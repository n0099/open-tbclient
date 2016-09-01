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
    private TbPageContext<MsglistActivity<?>> Gd;
    private UserIconBox ahO;
    private HeadImageView bSr;
    private TextView cTS;
    private ViewGroup cTT;
    private ImageView cTU;
    private final TouchType cTV;
    View.OnLongClickListener cTW;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgleft_view);
        this.cTV = new TouchType();
        this.cTW = new bi(this);
        this.Gd = tbPageContext;
        initView();
        this.cTU = (ImageView) findViewById(t.g.iv_live_group_host);
        this.cTS = (TextView) findViewById(t.g.tex_msgitem_name);
        this.cTT = (ViewGroup) findViewById(t.g.box_msgitem_bubble);
        this.bSr = (HeadImageView) findViewById(t.g.img_msgitem_photo);
        this.bSr.setAutoChangeStyle(false);
        this.bSr.setDrawerType(1);
        this.bSr.setRadius(com.baidu.adp.lib.util.k.dip2px(this.Gd.getContext(), 4.0f));
        this.ahO = (UserIconBox) findViewById(t.g.user_tshow_icon_box);
        this.bSr.setOnClickListener(new bj(this));
        this.bSr.setLongClickable(true);
        this.bSr.setOnLongClickListener(this.cTW);
        this.bSr.setOnTouchListener(new bk(this));
        this.cTL.setIsLeft(true);
        this.cTM.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        aqe();
        if (this.ahO != null && this.cTP) {
            this.ahO.setVisibility(0);
            this.ahO.setAutoChangedStyle(false);
            Resources resources = this.Gd.getResources();
            this.ahO.a(tShowInfoNew, 2, resources.getDimensionPixelSize(t.e.ds32), resources.getDimensionPixelSize(t.e.ds32), resources.getDimensionPixelSize(t.e.ds8), true);
        }
        if (chatMessage == null) {
            this.cTS.setText((CharSequence) null);
            this.cTH.setVisibility(0);
            this.cTH.setText(null);
            la(8);
            this.cTO.getImage().setTag(null);
            this.cTI.setVisibility(8);
            this.cTI.setTag(null);
            this.cTK.setVisibility(8);
            this.cTK.setTag(null);
            this.cTL.setVisibility(8);
            this.cTM.setVisibility(8);
            this.cTN.setVisibility(8);
            this.cTU.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.cTS.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.cTS.setText(chatMessage.getUserInfo().getUserName());
                this.bSr.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bSr.c(str, 10, false);
            } else {
                this.bSr.c(str, 12, false);
            }
            this.bSr.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cTH.setVisibility(8);
            la(8);
            this.cTI.setVisibility(8);
            this.cTJ.setVisibility(8);
            this.cTK.setVisibility(8);
            this.cTM.setVisibility(8);
            this.cTL.setVisibility(8);
            this.cTN.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.tS().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cTU.setVisibility(0);
        } else {
            this.cTU.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.cTP) {
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
            if (!this.cTP) {
                i = 0;
            }
            this.cTS.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void aqe() {
        if (this.cTP) {
            this.cTS.setVisibility(0);
            this.ahO.setVisibility(0);
            return;
        }
        this.cTS.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cTT.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cTT.setLayoutParams(marginLayoutParams);
        this.ahO.setVisibility(8);
    }
}
