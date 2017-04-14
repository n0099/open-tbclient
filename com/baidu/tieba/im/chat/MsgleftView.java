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
    private TbPageContext<MsglistActivity<?>> aaX;
    private UserIconBox ams;
    private HeadImageView bPc;
    private ViewGroup cOc;
    private ImageView cOd;
    private final TouchType cOe;
    View.OnLongClickListener cOf;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgleft_view);
        this.cOe = new TouchType();
        this.cOf = new bh(this);
        this.aaX = tbPageContext;
        initView();
        this.cOd = (ImageView) findViewById(w.h.iv_live_group_host);
        this.mName = (TextView) findViewById(w.h.tex_msgitem_name);
        this.cOc = (ViewGroup) findViewById(w.h.box_msgitem_bubble);
        this.bPc = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.bPc.setAutoChangeStyle(false);
        this.bPc.setDrawerType(1);
        this.bPc.setRadius(com.baidu.adp.lib.util.k.dip2px(this.aaX.getContext(), 4.0f));
        this.ams = (UserIconBox) findViewById(w.h.user_tshow_icon_box);
        this.bPc.setOnClickListener(new bi(this));
        this.bPc.setLongClickable(true);
        this.bPc.setOnLongClickListener(this.cOf);
        this.bPc.setOnTouchListener(new bj(this));
        this.cNV.setIsLeft(true);
        this.cNW.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        anx();
        if (this.ams != null && this.cNZ) {
            this.ams.setVisibility(0);
            this.ams.setAutoChangedStyle(false);
            Resources resources = this.aaX.getResources();
            this.ams.a(tShowInfoNew, 2, resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.cNR.setVisibility(0);
            this.cNR.setText(null);
            le(8);
            this.cNY.getImage().setTag(null);
            this.cNS.setVisibility(8);
            this.cNS.setTag(null);
            this.cNU.setVisibility(8);
            this.cNU.setTag(null);
            this.cNV.setVisibility(8);
            this.cNW.setVisibility(8);
            this.cNX.setVisibility(8);
            this.cOd.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.mName.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.bPc.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bPc.c(str, 10, false);
            } else {
                this.bPc.c(str, 12, false);
            }
            this.bPc.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cNR.setVisibility(8);
            le(8);
            this.cNS.setVisibility(8);
            this.cNT.setVisibility(8);
            this.cNU.setVisibility(8);
            this.cNW.setVisibility(8);
            this.cNV.setVisibility(8);
            this.cNX.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.uL().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cOd.setVisibility(0);
        } else {
            this.cOd.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.cNZ) {
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
            if (!this.cNZ) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void anx() {
        if (this.cNZ) {
            this.mName.setVisibility(0);
            this.ams.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cOc.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cOc.setLayoutParams(marginLayoutParams);
        this.ams.setVisibility(8);
    }
}
