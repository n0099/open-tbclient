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
    private TbPageContext<MsglistActivity<?>> aaI;
    private UserIconBox ame;
    private HeadImageView bPn;
    private TextView bap;
    private ViewGroup cPF;
    private ImageView cPG;
    private final TouchType cPH;
    View.OnLongClickListener cPI;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgleft_view);
        this.cPH = new TouchType();
        this.cPI = new bh(this);
        this.aaI = tbPageContext;
        initView();
        this.cPG = (ImageView) findViewById(w.h.iv_live_group_host);
        this.bap = (TextView) findViewById(w.h.tex_msgitem_name);
        this.cPF = (ViewGroup) findViewById(w.h.box_msgitem_bubble);
        this.bPn = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.bPn.setAutoChangeStyle(false);
        this.bPn.setDrawerType(1);
        this.bPn.setRadius(com.baidu.adp.lib.util.k.dip2px(this.aaI.getContext(), 4.0f));
        this.ame = (UserIconBox) findViewById(w.h.user_tshow_icon_box);
        this.bPn.setOnClickListener(new bi(this));
        this.bPn.setLongClickable(true);
        this.bPn.setOnLongClickListener(this.cPI);
        this.bPn.setOnTouchListener(new bj(this));
        this.cPy.setIsLeft(true);
        this.cPz.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        anD();
        if (this.ame != null && this.cPC) {
            this.ame.setVisibility(0);
            this.ame.setAutoChangedStyle(false);
            Resources resources = this.aaI.getResources();
            this.ame.a(tShowInfoNew, 2, resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds8), true);
        }
        if (chatMessage == null) {
            this.bap.setText((CharSequence) null);
            this.cPu.setVisibility(0);
            this.cPu.setText(null);
            ld(8);
            this.cPB.getImage().setTag(null);
            this.cPv.setVisibility(8);
            this.cPv.setTag(null);
            this.cPx.setVisibility(8);
            this.cPx.setTag(null);
            this.cPy.setVisibility(8);
            this.cPz.setVisibility(8);
            this.cPA.setVisibility(8);
            this.cPG.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.bap.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.bap.setText(chatMessage.getUserInfo().getUserName());
                this.bPn.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bPn.c(str, 10, false);
            } else {
                this.bPn.c(str, 12, false);
            }
            this.bPn.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cPu.setVisibility(8);
            ld(8);
            this.cPv.setVisibility(8);
            this.cPw.setVisibility(8);
            this.cPx.setVisibility(8);
            this.cPz.setVisibility(8);
            this.cPy.setVisibility(8);
            this.cPA.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.uo().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cPG.setVisibility(0);
        } else {
            this.cPG.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.cPC) {
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
            if (!this.cPC) {
                i = 0;
            }
            this.bap.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void anD() {
        if (this.cPC) {
            this.bap.setVisibility(0);
            this.ame.setVisibility(0);
            return;
        }
        this.bap.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cPF.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cPF.setLayoutParams(marginLayoutParams);
        this.ame.setVisibility(8);
    }
}
