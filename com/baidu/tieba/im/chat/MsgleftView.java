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
    private UserIconBox ahu;
    private TbPageContext<MsglistActivity<?>> dVN;
    private HeadImageView hJe;
    private ViewGroup iRi;
    private ImageView iRj;
    private final TouchType iRk;
    View.OnLongClickListener iRl;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgleft_view);
        this.iRk = new TouchType();
        this.iRl = new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MsgleftView.this.iRk.set(true);
                return true;
            }
        };
        this.dVN = tbPageContext;
        initView();
        this.iRj = (ImageView) findViewById(R.id.iv_live_group_host);
        this.mName = (TextView) findViewById(R.id.tex_msgitem_name);
        this.iRi = (ViewGroup) findViewById(R.id.box_msgitem_bubble);
        this.hJe = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hJe.setAutoChangeStyle(false);
        this.hJe.setDrawerType(1);
        this.hJe.setRadius(l.dip2px(this.dVN.getContext(), 4.0f));
        this.hJe.setPlaceHolder(1);
        this.ahu = (UserIconBox) findViewById(R.id.user_tshow_icon_box);
        this.hJe.setLongClickable(true);
        this.hJe.setOnLongClickListener(this.iRl);
        this.hJe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.MsgleftView.1
            long iRm = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.iRm = System.currentTimeMillis();
                } else if (motionEvent.getAction() == 1) {
                    if (System.currentTimeMillis() - this.iRm > 200) {
                        if (MsgleftView.this.iRk.get()) {
                            MsgleftView.this.iQC.onItemViewLongClick(view, 2, MsgleftView.this.mPosition, 0L);
                            MsgleftView.this.iRk.set(false);
                        }
                    } else {
                        MsgleftView.this.iQB.onItemViewClick(view, 2, MsgleftView.this.mPosition, 0L);
                    }
                }
                return false;
            }
        });
        this.iRb.setIsLeft(true);
        this.iRc.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        crb();
        if (this.ahu != null && this.iRf) {
            this.ahu.setVisibility(0);
            this.ahu.setAutoChangedStyle(false);
            Resources resources = this.dVN.getResources();
            this.ahu.a(tShowInfoNew, 2, resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds32), resources.getDimensionPixelSize(R.dimen.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.iQX.setVisibility(0);
            this.iQX.setText(null);
            yr(8);
            this.iRe.getImage().setTag(null);
            this.iQY.setVisibility(8);
            this.iQY.setTag(null);
            this.iRa.setVisibility(8);
            this.iRa.setTag(null);
            this.iRb.setVisibility(8);
            this.iRc.setVisibility(8);
            this.iRd.setVisibility(8);
            this.iRj.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getName_show());
                this.hJe.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getAvater();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.hJe.startLoad(str, 10, false);
            } else {
                this.hJe.startLoad(str, 12, false);
            }
            this.hJe.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.iQX.setVisibility(8);
            yr(8);
            this.iQY.setVisibility(8);
            this.iQZ.setVisibility(8);
            this.iRa.setVisibility(8);
            this.iRc.setVisibility(8);
            this.iRb.setVisibility(8);
            this.iRd.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.LIVE_ROOM_CHAT_PAGE_AUTHOR_ID, "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.iRj.setVisibility(0);
        } else {
            this.iRj.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.iRf) {
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
            if (!this.iRf) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void crb() {
        if (this.iRf) {
            this.mName.setVisibility(0);
            this.ahu.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iRi.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.iRi.setLayoutParams(marginLayoutParams);
        this.ahu.setVisibility(8);
    }
}
