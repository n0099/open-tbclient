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
    private TbPageContext<MsglistActivity<?>> MX;
    private UserIconBox ahN;
    private TextView bZJ;
    private ViewGroup bZK;
    private ImageView bZL;
    private final TouchType bZM;
    View.OnLongClickListener bZN;
    private HeadImageView bjG;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgleft_view);
        this.bZM = new TouchType();
        this.bZN = new bh(this);
        this.MX = tbPageContext;
        initView();
        this.bZL = (ImageView) findViewById(t.g.iv_live_group_host);
        this.bZJ = (TextView) findViewById(t.g.tex_msgitem_name);
        this.bZK = (ViewGroup) findViewById(t.g.box_msgitem_bubble);
        this.bjG = (HeadImageView) findViewById(t.g.img_msgitem_photo);
        this.bjG.setAutoChangeStyle(false);
        this.bjG.setDrawerType(1);
        this.bjG.setRadius(com.baidu.adp.lib.util.k.dip2px(this.MX.getContext(), 4.0f));
        this.ahN = (UserIconBox) findViewById(t.g.user_tshow_icon_box);
        this.bjG.setOnClickListener(new bi(this));
        this.bjG.setLongClickable(true);
        this.bjG.setOnLongClickListener(this.bZN);
        this.bjG.setOnTouchListener(new bj(this));
        this.bZC.setIsLeft(true);
        this.bZD.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        acr();
        if (this.ahN != null && this.bZG) {
            this.ahN.setVisibility(0);
            this.ahN.setAutoChangedStyle(false);
            Resources resources = this.MX.getResources();
            this.ahN.a(tShowInfoNew, 2, resources.getDimensionPixelSize(t.e.small_icon_width), resources.getDimensionPixelSize(t.e.small_icon_height), resources.getDimensionPixelSize(t.e.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.bZJ.setText((CharSequence) null);
            this.bZy.setVisibility(0);
            this.bZy.setText(null);
            jm(8);
            this.bZF.getImage().setTag(null);
            this.bZz.setVisibility(8);
            this.bZz.setTag(null);
            this.bZB.setVisibility(8);
            this.bZB.setTag(null);
            this.bZC.setVisibility(8);
            this.bZD.setVisibility(8);
            this.bZE.setVisibility(8);
            this.bZL.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.bZJ.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.bZJ.setText(chatMessage.getUserInfo().getUserName());
                this.bjG.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bjG.c(str, 10, false);
            } else {
                this.bjG.c(str, 12, false);
            }
            this.bjG.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.bZy.setVisibility(8);
            jm(8);
            this.bZz.setVisibility(8);
            this.bZA.setVisibility(8);
            this.bZB.setVisibility(8);
            this.bZD.setVisibility(8);
            this.bZC.setVisibility(8);
            this.bZE.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.vk().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.bZL.setVisibility(0);
        } else {
            this.bZL.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.bZG) {
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
            if (!this.bZG) {
                i = 0;
            }
            this.bZJ.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void acr() {
        if (this.bZG) {
            this.bZJ.setVisibility(0);
            this.ahN.setVisibility(0);
            return;
        }
        this.bZJ.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bZK.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.bZK.setLayoutParams(marginLayoutParams);
        this.ahN.setVisibility(8);
    }
}
