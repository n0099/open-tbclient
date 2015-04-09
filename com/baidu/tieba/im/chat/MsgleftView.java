package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends bk {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> LP;
    private UserIconBox aIp;
    private HeadImageView aIq;
    private TextView aYa;
    private ImageView aYb;
    private ViewGroup aYc;
    private ImageView aYd;
    private final TouchType aYe;
    View.OnLongClickListener aYf;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.w.msg_msgleft_view);
        this.aYe = new TouchType();
        this.aYf = new bx(this);
        this.LP = tbPageContext;
        initView();
        this.aYd = (ImageView) findViewById(com.baidu.tieba.v.iv_live_group_host);
        this.aYa = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_name);
        this.aYb = (ImageView) findViewById(com.baidu.tieba.v.iv_sex);
        this.aYc = (ViewGroup) findViewById(com.baidu.tieba.v.box_msgitem_bubble);
        this.aIq = (HeadImageView) findViewById(com.baidu.tieba.v.img_msgitem_photo);
        this.aIq.setAutoChangeStyle(false);
        this.aIq.setDrawerType(1);
        this.aIq.setRadius(com.baidu.adp.lib.util.n.dip2px(this.LP.getContext(), 4.0f));
        this.aIp = (UserIconBox) findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        this.aIq.setOnClickListener(new by(this));
        this.aIq.setLongClickable(true);
        this.aIq.setOnLongClickListener(this.aYf);
        this.aIq.setOnTouchListener(new bz(this));
        this.aXU.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        Og();
        if (this.aIp != null && this.aXX) {
            this.aIp.setVisibility(0);
            this.aIp.setAutoChangedStyle(false);
            this.aIp.a(tShowInfo, 2, this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.aYa.setText((CharSequence) null);
            this.aXQ.setVisibility(0);
            this.aXQ.setText(null);
            fB(8);
            this.aXW.getImage().setTag(null);
            this.aXR.setVisibility(8);
            this.aXR.setTag(null);
            this.aXT.setVisibility(8);
            this.aXT.setTag(null);
            this.aXU.setVisibility(8);
            this.aXV.setVisibility(8);
            this.aYd.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.aYa.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.aYa.setText(chatMessage.getUserInfo().getUserName());
                this.aIq.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aIq.c(str, 10, false);
            } else {
                this.aIq.c(str, 12, false);
            }
            this.aXQ.setVisibility(8);
            fB(8);
            this.aXR.setVisibility(8);
            this.aXS.setVisibility(8);
            this.aXT.setVisibility(8);
            this.aXU.setVisibility(8);
            this.aXV.setVisibility(8);
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
        String string = TbadkCoreApplication.m411getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0).getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.aYd.setVisibility(0);
        } else {
            this.aYd.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.aXX) {
                this.aYb.setVisibility(8);
                return;
            }
            this.aYb.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.aYb.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.aYb.setImageResource(com.baidu.tieba.u.icon_pop_qz_boy);
                this.aYb.setVisibility(0);
            } else if (sex == 2) {
                this.aYb.setImageResource(com.baidu.tieba.u.icon_pop_qz_girl);
                this.aYb.setVisibility(0);
            } else {
                this.aYb.setVisibility(8);
            }
        }
    }

    public void Og() {
        if (this.aXX) {
            this.aYa.setVisibility(0);
            this.aYb.setVisibility(0);
            this.aIp.setVisibility(0);
            return;
        }
        this.aYb.setVisibility(8);
        this.aYa.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aYc.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.aYc.setLayoutParams(marginLayoutParams);
        this.aIp.setVisibility(8);
    }
}
