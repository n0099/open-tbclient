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
    private TbPageContext<MsglistActivity<?>> LH;
    private UserIconBox aKx;
    private HeadImageView aKy;
    private TextView baH;
    private ImageView baI;
    private ViewGroup baJ;
    private ImageView baK;
    private final TouchType baL;
    View.OnLongClickListener baM;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.r.msg_msgleft_view);
        this.baL = new TouchType();
        this.baM = new bx(this);
        this.LH = tbPageContext;
        initView();
        this.baK = (ImageView) findViewById(com.baidu.tieba.q.iv_live_group_host);
        this.baH = (TextView) findViewById(com.baidu.tieba.q.tex_msgitem_name);
        this.baI = (ImageView) findViewById(com.baidu.tieba.q.iv_sex);
        this.baJ = (ViewGroup) findViewById(com.baidu.tieba.q.box_msgitem_bubble);
        this.aKy = (HeadImageView) findViewById(com.baidu.tieba.q.img_msgitem_photo);
        this.aKy.setAutoChangeStyle(false);
        this.aKy.setDrawerType(1);
        this.aKy.setRadius(com.baidu.adp.lib.util.n.dip2px(this.LH.getContext(), 4.0f));
        this.aKx = (UserIconBox) findViewById(com.baidu.tieba.q.user_tshow_icon_box);
        this.aKy.setOnClickListener(new by(this));
        this.aKy.setLongClickable(true);
        this.aKy.setOnLongClickListener(this.baM);
        this.aKy.setOnTouchListener(new bz(this));
        this.baB.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        Pv();
        if (this.aKx != null && this.baE) {
            this.aKx.setVisibility(0);
            this.aKx.setAutoChangedStyle(false);
            this.aKx.a(tShowInfo, 2, this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_width), this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_height), this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.baH.setText((CharSequence) null);
            this.bax.setVisibility(0);
            this.bax.setText(null);
            fS(8);
            this.baD.getImage().setTag(null);
            this.bay.setVisibility(8);
            this.bay.setTag(null);
            this.baA.setVisibility(8);
            this.baA.setTag(null);
            this.baB.setVisibility(8);
            this.baC.setVisibility(8);
            this.baK.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.baH.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.baH.setText(chatMessage.getUserInfo().getUserName());
                this.aKy.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aKy.c(str, 10, false);
            } else {
                this.aKy.c(str, 12, false);
            }
            this.bax.setVisibility(8);
            fS(8);
            this.bay.setVisibility(8);
            this.baz.setVisibility(8);
            this.baA.setVisibility(8);
            this.baB.setVisibility(8);
            this.baC.setVisibility(8);
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
            this.baK.setVisibility(0);
        } else {
            this.baK.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.baE) {
                this.baI.setVisibility(8);
                return;
            }
            this.baI.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.baI.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.baI.setImageResource(com.baidu.tieba.p.icon_pop_qz_boy);
                this.baI.setVisibility(0);
            } else if (sex == 2) {
                this.baI.setImageResource(com.baidu.tieba.p.icon_pop_qz_girl);
                this.baI.setVisibility(0);
            } else {
                this.baI.setVisibility(8);
            }
        }
    }

    public void Pv() {
        if (this.baE) {
            this.baH.setVisibility(0);
            this.baI.setVisibility(0);
            this.aKx.setVisibility(0);
            return;
        }
        this.baI.setVisibility(8);
        this.baH.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.baJ.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.baJ.setLayoutParams(marginLayoutParams);
        this.aKx.setVisibility(8);
    }
}
