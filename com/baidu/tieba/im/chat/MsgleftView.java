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
    private UserIconBox aSX;
    private HeadImageView aSY;
    private TextView bsb;
    private ViewGroup bsc;
    private ImageView bsd;
    private final TouchType bse;
    View.OnLongClickListener bsf;
    private TbPageContext<MsglistActivity<?>> mContext;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgleft_view);
        this.bse = new TouchType();
        this.bsf = new bh(this);
        this.mContext = tbPageContext;
        initView();
        this.bsd = (ImageView) findViewById(i.f.iv_live_group_host);
        this.bsb = (TextView) findViewById(i.f.tex_msgitem_name);
        this.bsc = (ViewGroup) findViewById(i.f.box_msgitem_bubble);
        this.aSY = (HeadImageView) findViewById(i.f.img_msgitem_photo);
        this.aSY.setAutoChangeStyle(false);
        this.aSY.setDrawerType(1);
        this.aSY.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aSX = (UserIconBox) findViewById(i.f.user_tshow_icon_box);
        this.aSY.setOnClickListener(new bi(this));
        this.aSY.setLongClickable(true);
        this.aSY.setOnLongClickListener(this.bsf);
        this.aSY.setOnTouchListener(new bj(this));
        this.brU.setIsLeft(true);
        this.brV.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        RQ();
        if (this.aSX != null && this.brY) {
            this.aSX.setVisibility(0);
            this.aSX.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.aSX.a(tShowInfo, 2, resources.getDimensionPixelSize(i.d.small_icon_width), resources.getDimensionPixelSize(i.d.small_icon_height), resources.getDimensionPixelSize(i.d.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.bsb.setText((CharSequence) null);
            this.brQ.setVisibility(0);
            this.brQ.setText(null);
            gJ(8);
            this.brX.getImage().setTag(null);
            this.brR.setVisibility(8);
            this.brR.setTag(null);
            this.brT.setVisibility(8);
            this.brT.setTag(null);
            this.brU.setVisibility(8);
            this.brV.setVisibility(8);
            this.brW.setVisibility(8);
            this.bsd.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.bsb.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.bsb.setText(chatMessage.getUserInfo().getUserName());
                this.aSY.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aSY.d(str, 10, false);
            } else {
                this.aSY.d(str, 12, false);
            }
            this.brQ.setVisibility(8);
            gJ(8);
            this.brR.setVisibility(8);
            this.brS.setVisibility(8);
            this.brT.setVisibility(8);
            this.brV.setVisibility(8);
            this.brU.setVisibility(8);
            this.brW.setVisibility(8);
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
            this.bsd.setVisibility(0);
        } else {
            this.bsd.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.brY) {
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
            if (!this.brY) {
                i = 0;
            }
            this.bsb.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void RQ() {
        if (this.brY) {
            this.bsb.setVisibility(0);
            this.aSX.setVisibility(0);
            return;
        }
        this.bsb.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bsc.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.bsc.setLayoutParams(marginLayoutParams);
        this.aSX.setVisibility(8);
    }
}
