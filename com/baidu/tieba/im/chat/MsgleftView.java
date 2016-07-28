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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends as {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> DQ;
    private UserIconBox aeT;
    private HeadImageView bHl;
    private TextView cIn;
    private ViewGroup cIo;
    private ImageView cIp;
    private final TouchType cIq;
    View.OnLongClickListener cIr;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, u.h.msg_msgleft_view);
        this.cIq = new TouchType();
        this.cIr = new bi(this);
        this.DQ = tbPageContext;
        initView();
        this.cIp = (ImageView) findViewById(u.g.iv_live_group_host);
        this.cIn = (TextView) findViewById(u.g.tex_msgitem_name);
        this.cIo = (ViewGroup) findViewById(u.g.box_msgitem_bubble);
        this.bHl = (HeadImageView) findViewById(u.g.img_msgitem_photo);
        this.bHl.setAutoChangeStyle(false);
        this.bHl.setDrawerType(1);
        this.bHl.setRadius(com.baidu.adp.lib.util.k.dip2px(this.DQ.getContext(), 4.0f));
        this.aeT = (UserIconBox) findViewById(u.g.user_tshow_icon_box);
        this.bHl.setOnClickListener(new bj(this));
        this.bHl.setLongClickable(true);
        this.bHl.setOnLongClickListener(this.cIr);
        this.bHl.setOnTouchListener(new bk(this));
        this.cIg.setIsLeft(true);
        this.cIh.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        alp();
        if (this.aeT != null && this.cIk) {
            this.aeT.setVisibility(0);
            this.aeT.setAutoChangedStyle(false);
            Resources resources = this.DQ.getResources();
            this.aeT.a(tShowInfoNew, 2, resources.getDimensionPixelSize(u.e.ds32), resources.getDimensionPixelSize(u.e.ds32), resources.getDimensionPixelSize(u.e.ds8), true);
        }
        if (chatMessage == null) {
            this.cIn.setText((CharSequence) null);
            this.cIc.setVisibility(0);
            this.cIc.setText(null);
            kx(8);
            this.cIj.getImage().setTag(null);
            this.cId.setVisibility(8);
            this.cId.setTag(null);
            this.cIf.setVisibility(8);
            this.cIf.setTag(null);
            this.cIg.setVisibility(8);
            this.cIh.setVisibility(8);
            this.cIi.setVisibility(8);
            this.cIp.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.cIn.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.cIn.setText(chatMessage.getUserInfo().getUserName());
                this.bHl.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bHl.c(str, 10, false);
            } else {
                this.bHl.c(str, 12, false);
            }
            this.bHl.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cIc.setVisibility(8);
            kx(8);
            this.cId.setVisibility(8);
            this.cIe.setVisibility(8);
            this.cIf.setVisibility(8);
            this.cIh.setVisibility(8);
            this.cIg.setVisibility(8);
            this.cIi.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.sN().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cIp.setVisibility(0);
        } else {
            this.cIp.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.cIk) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = u.f.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = u.f.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.cIk) {
                i = 0;
            }
            this.cIn.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void alp() {
        if (this.cIk) {
            this.cIn.setVisibility(0);
            this.aeT.setVisibility(0);
            return;
        }
        this.cIn.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cIo.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cIo.setLayoutParams(marginLayoutParams);
        this.aeT.setVisibility(8);
    }
}
