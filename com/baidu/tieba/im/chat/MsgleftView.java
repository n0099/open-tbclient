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
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends as {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox aTq;
    private HeadImageView aTr;
    private TextView bsQ;
    private ViewGroup bsR;
    private ImageView bsS;
    private final TouchType bsT;
    View.OnLongClickListener bsU;
    private TbPageContext<MsglistActivity<?>> mContext;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgleft_view);
        this.bsT = new TouchType();
        this.bsU = new bh(this);
        this.mContext = tbPageContext;
        initView();
        this.bsS = (ImageView) findViewById(i.f.iv_live_group_host);
        this.bsQ = (TextView) findViewById(i.f.tex_msgitem_name);
        this.bsR = (ViewGroup) findViewById(i.f.box_msgitem_bubble);
        this.aTr = (HeadImageView) findViewById(i.f.img_msgitem_photo);
        this.aTr.setAutoChangeStyle(false);
        this.aTr.setDrawerType(1);
        this.aTr.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aTq = (UserIconBox) findViewById(i.f.user_tshow_icon_box);
        this.aTr.setOnClickListener(new bi(this));
        this.aTr.setLongClickable(true);
        this.aTr.setOnLongClickListener(this.bsU);
        this.aTr.setOnTouchListener(new bj(this));
        this.bsJ.setIsLeft(true);
        this.bsK.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        Si();
        if (this.aTq != null && this.bsN) {
            this.aTq.setVisibility(0);
            this.aTq.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.aTq.a(tShowInfo, 2, resources.getDimensionPixelSize(i.d.small_icon_width), resources.getDimensionPixelSize(i.d.small_icon_height), resources.getDimensionPixelSize(i.d.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.bsQ.setText((CharSequence) null);
            this.bsF.setVisibility(0);
            this.bsF.setText(null);
            gW(8);
            this.bsM.getImage().setTag(null);
            this.bsG.setVisibility(8);
            this.bsG.setTag(null);
            this.bsI.setVisibility(8);
            this.bsI.setTag(null);
            this.bsJ.setVisibility(8);
            this.bsK.setVisibility(8);
            this.bsL.setVisibility(8);
            this.bsS.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.bsQ.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.bsQ.setText(chatMessage.getUserInfo().getUserName());
                this.aTr.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aTr.d(str, 10, false);
            } else {
                this.aTr.d(str, 12, false);
            }
            this.bsF.setVisibility(8);
            gW(8);
            this.bsG.setVisibility(8);
            this.bsH.setVisibility(8);
            this.bsI.setVisibility(8);
            this.bsK.setVisibility(8);
            this.bsJ.setVisibility(8);
            this.bsL.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.tu().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.bsS.setVisibility(0);
        } else {
            this.bsS.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.bsN) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = i.e.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = i.e.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.bsN) {
                i = 0;
            }
            this.bsQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void Si() {
        if (this.bsN) {
            this.bsQ.setVisibility(0);
            this.aTq.setVisibility(0);
            return;
        }
        this.bsQ.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bsR.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.bsR.setLayoutParams(marginLayoutParams);
        this.aTq.setVisibility(8);
    }
}
