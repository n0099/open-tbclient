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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends ar {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> Fp;
    private TextView aUd;
    private UserIconBox agL;
    private HeadImageView bIe;
    private ViewGroup cNq;
    private ImageView cNr;
    private final TouchType cNs;
    View.OnLongClickListener cNt;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.j.msg_msgleft_view);
        this.cNs = new TouchType();
        this.cNt = new bh(this);
        this.Fp = tbPageContext;
        initView();
        this.cNr = (ImageView) findViewById(r.h.iv_live_group_host);
        this.aUd = (TextView) findViewById(r.h.tex_msgitem_name);
        this.cNq = (ViewGroup) findViewById(r.h.box_msgitem_bubble);
        this.bIe = (HeadImageView) findViewById(r.h.img_msgitem_photo);
        this.bIe.setAutoChangeStyle(false);
        this.bIe.setDrawerType(1);
        this.bIe.setRadius(com.baidu.adp.lib.util.k.dip2px(this.Fp.getContext(), 4.0f));
        this.agL = (UserIconBox) findViewById(r.h.user_tshow_icon_box);
        this.bIe.setOnClickListener(new bi(this));
        this.bIe.setLongClickable(true);
        this.bIe.setOnLongClickListener(this.cNt);
        this.bIe.setOnTouchListener(new bj(this));
        this.cNj.setIsLeft(true);
        this.cNk.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aoj();
        if (this.agL != null && this.cNn) {
            this.agL.setVisibility(0);
            this.agL.setAutoChangedStyle(false);
            Resources resources = this.Fp.getResources();
            this.agL.a(tShowInfoNew, 2, resources.getDimensionPixelSize(r.f.ds32), resources.getDimensionPixelSize(r.f.ds32), resources.getDimensionPixelSize(r.f.ds8), true);
        }
        if (chatMessage == null) {
            this.aUd.setText((CharSequence) null);
            this.cNf.setVisibility(0);
            this.cNf.setText(null);
            ln(8);
            this.cNm.getImage().setTag(null);
            this.cNg.setVisibility(8);
            this.cNg.setTag(null);
            this.cNi.setVisibility(8);
            this.cNi.setTag(null);
            this.cNj.setVisibility(8);
            this.cNk.setVisibility(8);
            this.cNl.setVisibility(8);
            this.cNr.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.aUd.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.aUd.setText(chatMessage.getUserInfo().getUserName());
                this.bIe.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bIe.c(str, 10, false);
            } else {
                this.bIe.c(str, 12, false);
            }
            this.bIe.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cNf.setVisibility(8);
            ln(8);
            this.cNg.setVisibility(8);
            this.cNh.setVisibility(8);
            this.cNi.setVisibility(8);
            this.cNk.setVisibility(8);
            this.cNj.setVisibility(8);
            this.cNl.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.tQ().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cNr.setVisibility(0);
        } else {
            this.cNr.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.cNn) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = r.g.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = r.g.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.cNn) {
                i = 0;
            }
            this.aUd.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aoj() {
        if (this.cNn) {
            this.aUd.setVisibility(0);
            this.agL.setVisibility(0);
            return;
        }
        this.aUd.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cNq.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cNq.setLayoutParams(marginLayoutParams);
        this.agL.setVisibility(8);
    }
}
