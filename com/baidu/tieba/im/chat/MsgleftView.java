package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends g {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox afZ;
    private TbPageContext<MsglistActivity<?>> duG;
    private HeadImageView hbs;
    private ViewGroup iev;
    private ImageView iew;
    private final TouchType iex;
    View.OnLongClickListener iey;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.iex = new TouchType();
        this.iey = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.iex.set(true);
                return true;
            }
        };
        this.duG = tbPageContext;
        initView();
        this.iew = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.iev = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.hbs = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hbs.setAutoChangeStyle(false);
        this.hbs.setDrawerType(1);
        this.hbs.setRadius(l.dip2px(this.duG.getContext(), 4.0f));
        this.hbs.setPlaceHolder(1);
        this.afZ = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.hbs.setLongClickable(true);
        this.hbs.setOnLongClickListener(this.iey);
        this.hbs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long iez = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.iez = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.iez > 200) {
                        if (MsgleftView.this.iex.get()) {
                            MsgleftView.this.idP.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.iex.set(false);
                        }
                    } else {
                        MsgleftView.this.idO.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.ieo.setIsLeft(true);
        this.iep.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cdf();
        if (this.afZ != null && this.ies) {
            this.afZ.setVisibility(0);
            this.afZ.setAutoChangedStyle(false);
            Resources resources = this.duG.getResources();
            this.afZ.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.iek.setVisibility(0);
            this.iek.setText(null);
            wH(8);
            this.ier.getImage().setTag(null);
            this.iel.setVisibility(8);
            this.iel.setTag(null);
            this.ien.setVisibility(8);
            this.ien.setTag(null);
            this.ieo.setVisibility(8);
            this.iep.setVisibility(8);
            this.ieq.setVisibility(8);
            this.iew.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.hbs.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.hbs.startLoad(str, 10, false);
            } else {
                this.hbs.startLoad(str, 12, false);
            }
            this.hbs.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.iek.setVisibility(8);
            wH(8);
            this.iel.setVisibility(8);
            this.iem.setVisibility(8);
            this.ien.setVisibility(8);
            this.iep.setVisibility(8);
            this.ieo.setVisibility(8);
            this.ieq.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    return;
                case 4:
                    a(chatMessage, false);
                    return;
                case 5:
                    b(view, chatMessage, TAG);
                    return;
                case 6:
                case 7:
                case 8:
                default:
                    return;
                case 9:
                    c(view, chatMessage, TAG);
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c(ChatMessage chatMessage) {
        String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.iew.setVisibility(0);
        } else {
            this.iew.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.ies) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = R.drawable.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = R.drawable.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.ies) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cdf() {
        if (this.ies) {
            this.mName.setVisibility(0);
            this.afZ.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iev.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.iev.setLayoutParams(marginLayoutParams);
        this.afZ.setVisibility(8);
    }
}
