package com.baidu.tieba.im.chat;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends ar {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> aat;
    private UserIconBox ani;
    private ViewGroup cXP;
    private ImageView cXQ;
    private final TouchType cXR;
    View.OnLongClickListener cXS;
    private HeadImageView cej;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgleft_view);
        this.cXR = new TouchType();
        this.cXS = new bh(this);
        this.aat = tbPageContext;
        initView();
        this.cXQ = (ImageView) findViewById(w.h.iv_live_group_host);
        this.mName = (TextView) findViewById(w.h.tex_msgitem_name);
        this.cXP = (ViewGroup) findViewById(w.h.box_msgitem_bubble);
        this.cej = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.cej.setAutoChangeStyle(false);
        this.cej.setDrawerType(1);
        this.cej.setRadius(com.baidu.adp.lib.util.k.dip2px(this.aat.getContext(), 4.0f));
        this.ani = (UserIconBox) findViewById(w.h.user_tshow_icon_box);
        this.cej.setOnClickListener(new bi(this));
        this.cej.setLongClickable(true);
        this.cej.setOnLongClickListener(this.cXS);
        this.cej.setOnTouchListener(new bj(this));
        this.cXI.setIsLeft(true);
        this.cXJ.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aqc();
        if (this.ani != null && this.cXM) {
            this.ani.setVisibility(0);
            this.ani.setAutoChangedStyle(false);
            Resources resources = this.aat.getResources();
            this.ani.a(tShowInfoNew, 2, resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.cXE.setVisibility(0);
            this.cXE.setText(null);
            lC(8);
            this.cXL.getImage().setTag(null);
            this.cXF.setVisibility(8);
            this.cXF.setTag(null);
            this.cXH.setVisibility(8);
            this.cXH.setTag(null);
            this.cXI.setVisibility(8);
            this.cXJ.setVisibility(8);
            this.cXK.setVisibility(8);
            this.cXQ.setVisibility(8);
            return;
        }
        d(chatMessage);
        f(chatMessage);
        this.mName.setText("");
        e(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.cej.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.cej.c(str, 10, false);
            } else {
                this.cej.c(str, 12, false);
            }
            this.cej.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cXE.setVisibility(8);
            lC(8);
            this.cXF.setVisibility(8);
            this.cXG.setVisibility(8);
            this.cXH.setVisibility(8);
            this.cXJ.setVisibility(8);
            this.cXI.setVisibility(8);
            this.cXK.setVisibility(8);
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

    private void e(ChatMessage chatMessage) {
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cXQ.setVisibility(0);
        } else {
            this.cXQ.setVisibility(8);
        }
    }

    private void f(ChatMessage chatMessage) {
        int i;
        if (this.cXM) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = w.g.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = w.g.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.cXM) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aqc() {
        if (this.cXM) {
            this.mName.setVisibility(0);
            this.ani.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cXP.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cXP.setLayoutParams(marginLayoutParams);
        this.ani.setVisibility(8);
    }
}
