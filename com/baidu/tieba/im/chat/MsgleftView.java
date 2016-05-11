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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends as {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> Do;
    private UserIconBox adH;
    private HeadImageView bfG;
    private TextView cao;
    private ViewGroup cap;
    private ImageView caq;
    private final TouchType car;
    View.OnLongClickListener cas;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgleft_view);
        this.car = new TouchType();
        this.cas = new bh(this);
        this.Do = tbPageContext;
        initView();
        this.caq = (ImageView) findViewById(t.g.iv_live_group_host);
        this.cao = (TextView) findViewById(t.g.tex_msgitem_name);
        this.cap = (ViewGroup) findViewById(t.g.box_msgitem_bubble);
        this.bfG = (HeadImageView) findViewById(t.g.img_msgitem_photo);
        this.bfG.setAutoChangeStyle(false);
        this.bfG.setDrawerType(1);
        this.bfG.setRadius(com.baidu.adp.lib.util.k.dip2px(this.Do.getContext(), 4.0f));
        this.adH = (UserIconBox) findViewById(t.g.user_tshow_icon_box);
        this.bfG.setOnClickListener(new bi(this));
        this.bfG.setLongClickable(true);
        this.bfG.setOnLongClickListener(this.cas);
        this.bfG.setOnTouchListener(new bj(this));
        this.cah.setIsLeft(true);
        this.cai.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        acr();
        if (this.adH != null && this.cal) {
            this.adH.setVisibility(0);
            this.adH.setAutoChangedStyle(false);
            Resources resources = this.Do.getResources();
            this.adH.a(tShowInfoNew, 2, resources.getDimensionPixelSize(t.e.small_icon_width), resources.getDimensionPixelSize(t.e.small_icon_height), resources.getDimensionPixelSize(t.e.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.cao.setText((CharSequence) null);
            this.cad.setVisibility(0);
            this.cad.setText(null);
            iQ(8);
            this.cak.getImage().setTag(null);
            this.cae.setVisibility(8);
            this.cae.setTag(null);
            this.cag.setVisibility(8);
            this.cag.setTag(null);
            this.cah.setVisibility(8);
            this.cai.setVisibility(8);
            this.caj.setVisibility(8);
            this.caq.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.cao.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.cao.setText(chatMessage.getUserInfo().getUserName());
                this.bfG.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bfG.c(str, 10, false);
            } else {
                this.bfG.c(str, 12, false);
            }
            this.bfG.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cad.setVisibility(8);
            iQ(8);
            this.cae.setVisibility(8);
            this.caf.setVisibility(8);
            this.cag.setVisibility(8);
            this.cai.setVisibility(8);
            this.cah.setVisibility(8);
            this.caj.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.sQ().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.caq.setVisibility(0);
        } else {
            this.caq.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.cal) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = t.f.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = t.f.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.cal) {
                i = 0;
            }
            this.cao.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void acr() {
        if (this.cal) {
            this.cao.setVisibility(0);
            this.adH.setVisibility(0);
            return;
        }
        this.cao.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cap.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cap.setLayoutParams(marginLayoutParams);
        this.adH.setVisibility(8);
    }
}
