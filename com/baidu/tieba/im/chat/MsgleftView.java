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
    private TextView aAq;
    private UserIconBox aCo;
    private HeadImageView aCp;
    private ImageView aSs;
    private ViewGroup aSt;
    private ImageView aSu;
    private final TouchType aSv;
    View.OnLongClickListener aSw;
    private TbPageContext<MsglistActivity<?>> mContext;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_msgleft_view);
        this.aSv = new TouchType();
        this.aSw = new bp(this);
        this.mContext = tbPageContext;
        initView();
        this.aSu = (ImageView) findViewById(com.baidu.tieba.w.iv_live_group_host);
        this.aAq = (TextView) findViewById(com.baidu.tieba.w.tex_msgitem_name);
        this.aSs = (ImageView) findViewById(com.baidu.tieba.w.iv_sex);
        this.aSt = (ViewGroup) findViewById(com.baidu.tieba.w.box_msgitem_bubble);
        this.aCp = (HeadImageView) findViewById(com.baidu.tieba.w.img_msgitem_photo);
        this.aCp.setAutoChangeStyle(false);
        this.aCp.setDrawerType(1);
        this.aCp.setRadius(com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 4.0f));
        this.aCo = (UserIconBox) findViewById(com.baidu.tieba.w.user_tshow_icon_box);
        this.aCp.setOnClickListener(new bq(this));
        this.aCp.setLongClickable(true);
        this.aCp.setOnLongClickListener(this.aSw);
        this.aCp.setOnTouchListener(new br(this));
        this.aSm.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.bc
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        KE();
        if (this.aCo != null && this.aSp) {
            this.aCo.setVisibility(0);
            this.aCo.setAutoChangedStyle(false);
            this.aCo.a(tShowInfo, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.aAq.setText((CharSequence) null);
            this.aSi.setVisibility(0);
            this.aSi.setText(null);
            fy(8);
            this.aSo.getImage().setTag(null);
            this.aSj.setVisibility(8);
            this.aSj.setTag(null);
            this.aSl.setVisibility(8);
            this.aSl.setTag(null);
            this.aSm.setVisibility(8);
            this.aSn.setVisibility(8);
            this.aSu.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.aAq.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.aAq.setText(chatMessage.getUserInfo().getUserName());
                this.aCp.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aCp.d(str, 10, false);
            } else {
                this.aCp.d(str, 12, false);
            }
            this.aSi.setVisibility(8);
            fy(8);
            this.aSj.setVisibility(8);
            this.aSk.setVisibility(8);
            this.aSl.setVisibility(8);
            this.aSm.setVisibility(8);
            this.aSn.setVisibility(8);
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
            this.aSu.setVisibility(0);
        } else {
            this.aSu.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.aSp) {
                this.aSs.setVisibility(8);
                return;
            }
            this.aSs.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.aSs.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.aSs.setImageResource(com.baidu.tieba.v.icon_pop_qz_boy);
                this.aSs.setVisibility(0);
            } else if (sex == 2) {
                this.aSs.setImageResource(com.baidu.tieba.v.icon_pop_qz_girl);
                this.aSs.setVisibility(0);
            } else {
                this.aSs.setVisibility(8);
            }
        }
    }

    public void KE() {
        if (this.aSp) {
            this.aAq.setVisibility(0);
            this.aSs.setVisibility(0);
            this.aCo.setVisibility(0);
            return;
        }
        this.aSs.setVisibility(8);
        this.aAq.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aSt.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.aSt.setLayoutParams(marginLayoutParams);
        this.aCo.setVisibility(8);
    }
}
