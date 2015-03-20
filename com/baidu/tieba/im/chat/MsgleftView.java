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
    private TbPageContext<MsglistActivity<?>> LN;
    private UserIconBox aIh;
    private HeadImageView aIi;
    private TextView aXK;
    private ImageView aXL;
    private ViewGroup aXM;
    private ImageView aXN;
    private final TouchType aXO;
    View.OnLongClickListener aXP;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.w.msg_msgleft_view);
        this.aXO = new TouchType();
        this.aXP = new bx(this);
        this.LN = tbPageContext;
        initView();
        this.aXN = (ImageView) findViewById(com.baidu.tieba.v.iv_live_group_host);
        this.aXK = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_name);
        this.aXL = (ImageView) findViewById(com.baidu.tieba.v.iv_sex);
        this.aXM = (ViewGroup) findViewById(com.baidu.tieba.v.box_msgitem_bubble);
        this.aIi = (HeadImageView) findViewById(com.baidu.tieba.v.img_msgitem_photo);
        this.aIi.setAutoChangeStyle(false);
        this.aIi.setDrawerType(1);
        this.aIi.setRadius(com.baidu.adp.lib.util.n.dip2px(this.LN.getContext(), 4.0f));
        this.aIh = (UserIconBox) findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        this.aIi.setOnClickListener(new by(this));
        this.aIi.setLongClickable(true);
        this.aIi.setOnLongClickListener(this.aXP);
        this.aIi.setOnTouchListener(new bz(this));
        this.aXE.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        NT();
        if (this.aIh != null && this.aXH) {
            this.aIh.setVisibility(0);
            this.aIh.setAutoChangedStyle(false);
            this.aIh.a(tShowInfo, 2, this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.aXK.setText((CharSequence) null);
            this.aXA.setVisibility(0);
            this.aXA.setText(null);
            fz(8);
            this.aXG.getImage().setTag(null);
            this.aXB.setVisibility(8);
            this.aXB.setTag(null);
            this.aXD.setVisibility(8);
            this.aXD.setTag(null);
            this.aXE.setVisibility(8);
            this.aXF.setVisibility(8);
            this.aXN.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.aXK.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.aXK.setText(chatMessage.getUserInfo().getUserName());
                this.aIi.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aIi.c(str, 10, false);
            } else {
                this.aIi.c(str, 12, false);
            }
            this.aXA.setVisibility(8);
            fz(8);
            this.aXB.setVisibility(8);
            this.aXC.setVisibility(8);
            this.aXD.setVisibility(8);
            this.aXE.setVisibility(8);
            this.aXF.setVisibility(8);
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
            this.aXN.setVisibility(0);
        } else {
            this.aXN.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.aXH) {
                this.aXL.setVisibility(8);
                return;
            }
            this.aXL.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.aXL.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.aXL.setImageResource(com.baidu.tieba.u.icon_pop_qz_boy);
                this.aXL.setVisibility(0);
            } else if (sex == 2) {
                this.aXL.setImageResource(com.baidu.tieba.u.icon_pop_qz_girl);
                this.aXL.setVisibility(0);
            } else {
                this.aXL.setVisibility(8);
            }
        }
    }

    public void NT() {
        if (this.aXH) {
            this.aXK.setVisibility(0);
            this.aXL.setVisibility(0);
            this.aIh.setVisibility(0);
            return;
        }
        this.aXL.setVisibility(8);
        this.aXK.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aXM.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.aXM.setLayoutParams(marginLayoutParams);
        this.aIh.setVisibility(8);
    }
}
