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
    private ImageView aPl;
    private ViewGroup aPm;
    private ImageView aPn;
    private final TouchType aPo;
    View.OnLongClickListener aPp;
    private TextView avZ;
    private UserIconBox azj;
    private HeadImageView azk;
    private Context mContext;

    public MsgleftView(Context context) {
        super(context, com.baidu.tieba.w.msg_msgleft_view);
        this.aPo = new TouchType();
        this.aPp = new cp(this);
        this.mContext = context;
        nu();
        this.aPn = (ImageView) findViewById(com.baidu.tieba.v.iv_live_group_host);
        this.avZ = (TextView) findViewById(com.baidu.tieba.v.tex_msgitem_name);
        this.aPl = (ImageView) findViewById(com.baidu.tieba.v.iv_sex);
        this.aPm = (ViewGroup) findViewById(com.baidu.tieba.v.box_msgitem_bubble);
        this.azk = (HeadImageView) findViewById(com.baidu.tieba.v.img_msgitem_photo);
        this.azk.setAutoChangeStyle(false);
        this.azk.setDrawerType(1);
        this.azk.setRadius(com.baidu.adp.lib.util.m.dip2px(this.mContext, 4.0f));
        this.azj = (UserIconBox) findViewById(com.baidu.tieba.v.user_tshow_icon_box);
        this.azk.setOnClickListener(new cq(this));
        this.azk.setLongClickable(true);
        this.azk.setOnLongClickListener(this.aPp);
        this.azk.setOnTouchListener(new cr(this));
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        JV();
        if (this.azj != null && this.aPi) {
            this.azj.setVisibility(0);
            this.azj.setAutoChangedStyle(false);
            this.azj.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.avZ.setText((CharSequence) null);
            this.aPb.setVisibility(0);
            this.aPb.setText(null);
            fq(8);
            this.aPh.getImage().setTag(null);
            this.aPc.setVisibility(8);
            this.aPc.setTag(null);
            this.aPe.setVisibility(8);
            this.aPe.setTag(null);
            this.aPf.setVisibility(8);
            this.aPg.setVisibility(8);
            this.aPn.setVisibility(8);
            return;
        }
        h(chatMessage);
        j(chatMessage);
        this.avZ.setText("");
        i(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.avZ.setText(chatMessage.getUserInfo().getUserName());
                this.azk.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1) {
                this.azk.c(str, 10, false);
            } else {
                this.azk.c(str, 12, false);
            }
            this.aPb.setVisibility(8);
            fq(8);
            this.aPc.setVisibility(8);
            this.aPd.setVisibility(8);
            this.aPe.setVisibility(8);
            this.aPf.setVisibility(8);
            this.aPg.setVisibility(8);
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
            this.aPn.setVisibility(0);
        } else {
            this.aPn.setVisibility(8);
        }
    }

    private void j(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.aPi) {
                this.aPl.setVisibility(8);
                return;
            }
            this.aPl.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.aPl.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.aPl.setImageResource(com.baidu.tieba.u.icon_pop_qz_boy);
                this.aPl.setVisibility(0);
            } else if (sex == 2) {
                this.aPl.setImageResource(com.baidu.tieba.u.icon_pop_qz_girl);
                this.aPl.setVisibility(0);
            } else {
                this.aPl.setVisibility(8);
            }
        }
    }

    public void JV() {
        if (this.aPi) {
            this.avZ.setVisibility(0);
            this.aPl.setVisibility(0);
            this.azj.setVisibility(0);
            return;
        }
        this.aPl.setVisibility(8);
        this.avZ.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aPm.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.aPm.setLayoutParams(marginLayoutParams);
        this.azj.setVisibility(8);
    }
}
