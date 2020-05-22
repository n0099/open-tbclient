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
    private UserIconBox agz;
    private TbPageContext<MsglistActivity<?>> dIF;
    private HeadImageView hqm;
    private ViewGroup itk;
    private ImageView itl;
    private final TouchType itm;
    View.OnLongClickListener itn;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.itm = new TouchType();
        this.itn = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.itm.set(true);
                return true;
            }
        };
        this.dIF = tbPageContext;
        initView();
        this.itl = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.itk = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.hqm = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hqm.setAutoChangeStyle(false);
        this.hqm.setDrawerType(1);
        this.hqm.setRadius(l.dip2px(this.dIF.getContext(), 4.0f));
        this.hqm.setPlaceHolder(1);
        this.agz = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.hqm.setLongClickable(true);
        this.hqm.setOnLongClickListener(this.itn);
        this.hqm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long ito = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.ito = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.ito > 200) {
                        if (MsgleftView.this.itm.get()) {
                            MsgleftView.this.isE.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.itm.set(false);
                        }
                    } else {
                        MsgleftView.this.isD.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.itd.setIsLeft(true);
        this.ite.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        cjC();
        if (this.agz != null && this.ith) {
            this.agz.setVisibility(0);
            this.agz.setAutoChangedStyle(false);
            Resources resources = this.dIF.getResources();
            this.agz.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.isZ.setVisibility(0);
            this.isZ.setText(null);
            xn(8);
            this.itg.getImage().setTag(null);
            this.ita.setVisibility(8);
            this.ita.setTag(null);
            this.itc.setVisibility(8);
            this.itc.setTag(null);
            this.itd.setVisibility(8);
            this.ite.setVisibility(8);
            this.itf.setVisibility(8);
            this.itl.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.hqm.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.hqm.startLoad(str, 10, false);
            } else {
                this.hqm.startLoad(str, 12, false);
            }
            this.hqm.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.isZ.setVisibility(8);
            xn(8);
            this.ita.setVisibility(8);
            this.itb.setVisibility(8);
            this.itc.setVisibility(8);
            this.ite.setVisibility(8);
            this.itd.setVisibility(8);
            this.itf.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.itl.setVisibility(0);
        } else {
            this.itl.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.ith) {
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
            if (!this.ith) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void cjC() {
        if (this.ith) {
            this.mName.setVisibility(0);
            this.agz.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.itk.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.itk.setLayoutParams(marginLayoutParams);
        this.agz.setVisibility(8);
    }
}
