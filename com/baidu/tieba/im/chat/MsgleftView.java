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
public class MsgleftView extends bc {
    private static final String TAG = MsgleftView.class.getName();
    private TextView aAn;
    private UserIconBox aCl;
    private HeadImageView aCm;
    private ImageView aSr;
    private ViewGroup aSs;
    private ImageView aSt;
    private final TouchType aSu;
    View.OnLongClickListener aSv;
    private TbPageContext<MsglistActivity<?>> mContext;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_msgleft_view);
        this.aSu = new TouchType();
        this.aSv = new bp(this);
        this.mContext = tbPageContext;
        initView();
        this.aSt = (ImageView) findViewById(com.baidu.tieba.w.iv_live_group_host);
        this.aAn = (TextView) findViewById(com.baidu.tieba.w.tex_msgitem_name);
        this.aSr = (ImageView) findViewById(com.baidu.tieba.w.iv_sex);
        this.aSs = (ViewGroup) findViewById(com.baidu.tieba.w.box_msgitem_bubble);
        this.aCm = (HeadImageView) findViewById(com.baidu.tieba.w.img_msgitem_photo);
        this.aCm.setAutoChangeStyle(false);
        this.aCm.setDrawerType(1);
        this.aCm.setRadius(com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 4.0f));
        this.aCl = (UserIconBox) findViewById(com.baidu.tieba.w.user_tshow_icon_box);
        this.aCm.setOnClickListener(new bq(this));
        this.aCm.setLongClickable(true);
        this.aCm.setOnLongClickListener(this.aSv);
        this.aCm.setOnTouchListener(new br(this));
        this.aSl.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.bc
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        Kz();
        if (this.aCl != null && this.aSo) {
            this.aCl.setVisibility(0);
            this.aCl.setAutoChangedStyle(false);
            this.aCl.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.aAn.setText((CharSequence) null);
            this.aSh.setVisibility(0);
            this.aSh.setText(null);
            fy(8);
            this.aSn.getImage().setTag(null);
            this.aSi.setVisibility(8);
            this.aSi.setTag(null);
            this.aSk.setVisibility(8);
            this.aSk.setTag(null);
            this.aSl.setVisibility(8);
            this.aSm.setVisibility(8);
            this.aSt.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.aAn.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.aAn.setText(chatMessage.getUserInfo().getUserName());
                this.aCm.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aCm.d(str, 10, false);
            } else {
                this.aCm.d(str, 12, false);
            }
            this.aSh.setVisibility(8);
            fy(8);
            this.aSi.setVisibility(8);
            this.aSj.setVisibility(8);
            this.aSk.setVisibility(8);
            this.aSl.setVisibility(8);
            this.aSm.setVisibility(8);
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
            this.aSt.setVisibility(0);
        } else {
            this.aSt.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.aSo) {
                this.aSr.setVisibility(8);
                return;
            }
            this.aSr.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.aSr.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.aSr.setImageResource(com.baidu.tieba.v.icon_pop_qz_boy);
                this.aSr.setVisibility(0);
            } else if (sex == 2) {
                this.aSr.setImageResource(com.baidu.tieba.v.icon_pop_qz_girl);
                this.aSr.setVisibility(0);
            } else {
                this.aSr.setVisibility(8);
            }
        }
    }

    public void Kz() {
        if (this.aSo) {
            this.aAn.setVisibility(0);
            this.aSr.setVisibility(0);
            this.aCl.setVisibility(0);
            return;
        }
        this.aSr.setVisibility(8);
        this.aAn.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aSs.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.aSs.setLayoutParams(marginLayoutParams);
        this.aCl.setVisibility(8);
    }
}
