package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends cc {
    private static final String TAG = MsgleftView.class.getName();
    private ViewGroup aPA;
    private ImageView aPB;
    private final TouchType aPC;
    View.OnLongClickListener aPD;
    private ImageView aPz;
    private TextView awi;
    private UserIconBox azs;
    private HeadImageView azt;
    private Context mContext;

    public MsgleftView(Context context) {
        super(context, com.baidu.tieba.w.msg_msgleft_view);
        this.aPC = new TouchType();
        this.aPD = new cp(this);
        this.mContext = context;
        nu();
        this.aPB = (ImageView) findViewById(com.baidu.tieba.v.iv_live_group_host);
        this.awi = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_name);
        this.aPz = (ImageView) findViewById(com.baidu.tieba.v.iv_sex);
        this.aPA = (ViewGroup) findViewById(com.baidu.tieba.v.box_msgitem_bubble);
        this.azt = (HeadImageView) findViewById(com.baidu.tieba.v.img_msgitem_photo);
        this.azt.setAutoChangeStyle(false);
        this.azt.setDrawerType(1);
        this.azt.setRadius(com.baidu.adp.lib.util.m.dip2px(this.mContext, 4.0f));
        this.azs = (UserIconBox) findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        this.azt.setOnClickListener(new cq(this));
        this.azt.setLongClickable(true);
        this.azt.setOnLongClickListener(this.aPD);
        this.azt.setOnTouchListener(new cr(this));
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        JZ();
        if (this.azs != null && this.aPw) {
            this.azs.setVisibility(0);
            this.azs.setAutoChangedStyle(false);
            this.azs.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.awi.setText((CharSequence) null);
            this.aPp.setVisibility(0);
            this.aPp.setText(null);
            fq(8);
            this.aPv.getImage().setTag(null);
            this.aPq.setVisibility(8);
            this.aPq.setTag(null);
            this.aPs.setVisibility(8);
            this.aPs.setTag(null);
            this.aPt.setVisibility(8);
            this.aPu.setVisibility(8);
            this.aPB.setVisibility(8);
            return;
        }
        h(chatMessage);
        j(chatMessage);
        this.awi.setText("");
        i(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.awi.setText(chatMessage.getUserInfo().getUserName());
                this.azt.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1) {
                this.azt.c(str, 10, false);
            } else {
                this.azt.c(str, 12, false);
            }
            this.aPp.setVisibility(8);
            fq(8);
            this.aPq.setVisibility(8);
            this.aPr.setVisibility(8);
            this.aPs.setVisibility(8);
            this.aPt.setVisibility(8);
            this.aPu.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    b(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    c(chatMessage, TAG);
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

    private void i(ChatMessage chatMessage) {
        String string = TbadkApplication.m251getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0).getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.aPB.setVisibility(0);
        } else {
            this.aPB.setVisibility(8);
        }
    }

    private void j(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.aPw) {
                this.aPz.setVisibility(8);
                return;
            }
            this.aPz.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.aPz.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.aPz.setImageResource(com.baidu.tieba.u.icon_pop_qz_boy);
                this.aPz.setVisibility(0);
            } else if (sex == 2) {
                this.aPz.setImageResource(com.baidu.tieba.u.icon_pop_qz_girl);
                this.aPz.setVisibility(0);
            } else {
                this.aPz.setVisibility(8);
            }
        }
    }

    public void JZ() {
        if (this.aPw) {
            this.awi.setVisibility(0);
            this.aPz.setVisibility(0);
            this.azs.setVisibility(0);
            return;
        }
        this.aPz.setVisibility(8);
        this.awi.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aPA.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.aPA.setLayoutParams(marginLayoutParams);
        this.azs.setVisibility(8);
    }
}
