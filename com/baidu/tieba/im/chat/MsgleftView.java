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
public class MsgleftView extends az {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox aBn;
    private HeadImageView aBo;
    private ImageView aRj;
    private ViewGroup aRk;
    private ImageView aRl;
    private final TouchType aRm;
    View.OnLongClickListener aRn;
    private TextView azp;
    private TbPageContext<MsglistActivity<?>> mContext;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_msgleft_view);
        this.aRm = new TouchType();
        this.aRn = new bm(this);
        this.mContext = tbPageContext;
        initView();
        this.aRl = (ImageView) findViewById(com.baidu.tieba.w.iv_live_group_host);
        this.azp = (TextView) findViewById(com.baidu.tieba.w.tex_msgitem_name);
        this.aRj = (ImageView) findViewById(com.baidu.tieba.w.iv_sex);
        this.aRk = (ViewGroup) findViewById(com.baidu.tieba.w.box_msgitem_bubble);
        this.aBo = (HeadImageView) findViewById(com.baidu.tieba.w.img_msgitem_photo);
        this.aBo.setAutoChangeStyle(false);
        this.aBo.setDrawerType(1);
        this.aBo.setRadius(com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 4.0f));
        this.aBn = (UserIconBox) findViewById(com.baidu.tieba.w.user_tshow_icon_box);
        this.aBo.setOnClickListener(new bn(this));
        this.aBo.setLongClickable(true);
        this.aBo.setOnLongClickListener(this.aRn);
        this.aBo.setOnTouchListener(new bo(this));
        this.aRd.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.az
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        Kj();
        if (this.aBn != null && this.aRg) {
            this.aBn.setVisibility(0);
            this.aBn.setAutoChangedStyle(false);
            this.aBn.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.azp.setText((CharSequence) null);
            this.aQZ.setVisibility(0);
            this.aQZ.setText(null);
            ft(8);
            this.aRf.getImage().setTag(null);
            this.aRa.setVisibility(8);
            this.aRa.setTag(null);
            this.aRc.setVisibility(8);
            this.aRc.setTag(null);
            this.aRd.setVisibility(8);
            this.aRe.setVisibility(8);
            this.aRl.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.azp.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.azp.setText(chatMessage.getUserInfo().getUserName());
                this.aBo.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aBo.d(str, 10, false);
            } else {
                this.aBo.d(str, 12, false);
            }
            this.aQZ.setVisibility(8);
            ft(8);
            this.aRa.setVisibility(8);
            this.aRb.setVisibility(8);
            this.aRc.setVisibility(8);
            this.aRd.setVisibility(8);
            this.aRe.setVisibility(8);
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
        String string = TbadkCoreApplication.m255getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0).getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.aRl.setVisibility(0);
        } else {
            this.aRl.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.aRg) {
                this.aRj.setVisibility(8);
                return;
            }
            this.aRj.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.aRj.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.aRj.setImageResource(com.baidu.tieba.v.icon_pop_qz_boy);
                this.aRj.setVisibility(0);
            } else if (sex == 2) {
                this.aRj.setImageResource(com.baidu.tieba.v.icon_pop_qz_girl);
                this.aRj.setVisibility(0);
            } else {
                this.aRj.setVisibility(8);
            }
        }
    }

    public void Kj() {
        if (this.aRg) {
            this.azp.setVisibility(0);
            this.aRj.setVisibility(0);
            this.aBn.setVisibility(0);
            return;
        }
        this.aRj.setVisibility(8);
        this.azp.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aRk.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.aRk.setLayoutParams(marginLayoutParams);
        this.aBn.setVisibility(8);
    }
}
