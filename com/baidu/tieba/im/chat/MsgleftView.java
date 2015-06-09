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
    private UserIconBox aKy;
    private HeadImageView aKz;
    private TextView baI;
    private ImageView baJ;
    private ViewGroup baK;
    private ImageView baL;
    private final TouchType baM;
    View.OnLongClickListener baN;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.r.msg_msgleft_view);
        this.baM = new TouchType();
        this.baN = new bx(this);
        this.LH = tbPageContext;
        initView();
        this.baL = (ImageView) findViewById(com.baidu.tieba.q.iv_live_group_host);
        this.baI = (TextView) findViewById(com.baidu.tieba.q.tex_msgitem_name);
        this.baJ = (ImageView) findViewById(com.baidu.tieba.q.iv_sex);
        this.baK = (ViewGroup) findViewById(com.baidu.tieba.q.box_msgitem_bubble);
        this.aKz = (HeadImageView) findViewById(com.baidu.tieba.q.img_msgitem_photo);
        this.aKz.setAutoChangeStyle(false);
        this.aKz.setDrawerType(1);
        this.aKz.setRadius(com.baidu.adp.lib.util.n.dip2px(this.LH.getContext(), 4.0f));
        this.aKy = (UserIconBox) findViewById(com.baidu.tieba.q.user_tshow_icon_box);
        this.aKz.setOnClickListener(new by(this));
        this.aKz.setLongClickable(true);
        this.aKz.setOnLongClickListener(this.baN);
        this.aKz.setOnTouchListener(new bz(this));
        this.baC.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        Pw();
        if (this.aKy != null && this.baF) {
            this.aKy.setVisibility(0);
            this.aKy.setAutoChangedStyle(false);
            this.aKy.a(tShowInfo, 2, this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_width), this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_height), this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.baI.setText((CharSequence) null);
            this.bay.setVisibility(0);
            this.bay.setText(null);
            fS(8);
            this.baE.getImage().setTag(null);
            this.baz.setVisibility(8);
            this.baz.setTag(null);
            this.baB.setVisibility(8);
            this.baB.setTag(null);
            this.baC.setVisibility(8);
            this.baD.setVisibility(8);
            this.baL.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.baI.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.baI.setText(chatMessage.getUserInfo().getUserName());
                this.aKz.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aKz.c(str, 10, false);
            } else {
                this.aKz.c(str, 12, false);
            }
            this.bay.setVisibility(8);
            fS(8);
            this.baz.setVisibility(8);
            this.baA.setVisibility(8);
            this.baB.setVisibility(8);
            this.baC.setVisibility(8);
            this.baD.setVisibility(8);
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
            this.baL.setVisibility(0);
        } else {
            this.baL.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        if (chatMessage != null) {
            if (!this.baF) {
                this.baJ.setVisibility(8);
                return;
            }
            this.baJ.setVisibility(0);
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.baJ.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.baJ.setImageResource(com.baidu.tieba.p.icon_pop_qz_boy);
                this.baJ.setVisibility(0);
            } else if (sex == 2) {
                this.baJ.setImageResource(com.baidu.tieba.p.icon_pop_qz_girl);
                this.baJ.setVisibility(0);
            } else {
                this.baJ.setVisibility(8);
            }
        }
    }

    public void Pw() {
        if (this.baF) {
            this.baI.setVisibility(0);
            this.baJ.setVisibility(0);
            this.aKy.setVisibility(0);
            return;
        }
        this.baJ.setVisibility(8);
        this.baI.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.baK.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.baK.setLayoutParams(marginLayoutParams);
        this.aKy.setVisibility(8);
    }
}
