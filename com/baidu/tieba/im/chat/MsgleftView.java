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
public class MsgleftView extends as {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> Gf;
    private UserIconBox ahW;
    private HeadImageView bUx;
    private TextView daX;
    private ViewGroup daY;
    private ImageView daZ;
    private final TouchType dba;
    View.OnLongClickListener dbb;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.h.msg_msgleft_view);
        this.dba = new TouchType();
        this.dbb = new bi(this);
        this.Gf = tbPageContext;
        initView();
        this.daZ = (ImageView) findViewById(r.g.iv_live_group_host);
        this.daX = (TextView) findViewById(r.g.tex_msgitem_name);
        this.daY = (ViewGroup) findViewById(r.g.box_msgitem_bubble);
        this.bUx = (HeadImageView) findViewById(r.g.img_msgitem_photo);
        this.bUx.setAutoChangeStyle(false);
        this.bUx.setDrawerType(1);
        this.bUx.setRadius(com.baidu.adp.lib.util.k.dip2px(this.Gf.getContext(), 4.0f));
        this.ahW = (UserIconBox) findViewById(r.g.user_tshow_icon_box);
        this.bUx.setOnClickListener(new bj(this));
        this.bUx.setLongClickable(true);
        this.bUx.setOnLongClickListener(this.dbb);
        this.bUx.setOnTouchListener(new bk(this));
        this.daQ.setIsLeft(true);
        this.daR.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        asA();
        if (this.ahW != null && this.daU) {
            this.ahW.setVisibility(0);
            this.ahW.setAutoChangedStyle(false);
            Resources resources = this.Gf.getResources();
            this.ahW.a(tShowInfoNew, 2, resources.getDimensionPixelSize(r.e.ds32), resources.getDimensionPixelSize(r.e.ds32), resources.getDimensionPixelSize(r.e.ds8), true);
        }
        if (chatMessage == null) {
            this.daX.setText((CharSequence) null);
            this.daM.setVisibility(0);
            this.daM.setText(null);
            lq(8);
            this.daT.getImage().setTag(null);
            this.daN.setVisibility(8);
            this.daN.setTag(null);
            this.daP.setVisibility(8);
            this.daP.setTag(null);
            this.daQ.setVisibility(8);
            this.daR.setVisibility(8);
            this.daS.setVisibility(8);
            this.daZ.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.daX.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.daX.setText(chatMessage.getUserInfo().getUserName());
                this.bUx.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bUx.c(str, 10, false);
            } else {
                this.bUx.c(str, 12, false);
            }
            this.bUx.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.daM.setVisibility(8);
            lq(8);
            this.daN.setVisibility(8);
            this.daO.setVisibility(8);
            this.daP.setVisibility(8);
            this.daR.setVisibility(8);
            this.daQ.setVisibility(8);
            this.daS.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.um().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.daZ.setVisibility(0);
        } else {
            this.daZ.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.daU) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = r.f.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = r.f.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.daU) {
                i = 0;
            }
            this.daX.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void asA() {
        if (this.daU) {
            this.daX.setVisibility(0);
            this.ahW.setVisibility(0);
            return;
        }
        this.daX.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.daY.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.daY.setLayoutParams(marginLayoutParams);
        this.ahW.setVisibility(8);
    }
}
