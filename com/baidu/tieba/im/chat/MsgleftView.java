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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends as {
    private static final String TAG = MsgleftView.class.getName();
    private UserIconBox agT;
    private TextView bLD;
    private ViewGroup bLE;
    private ImageView bLF;
    private final TouchType bLG;
    View.OnLongClickListener bLH;
    private HeadImageView bcC;
    private TbPageContext<MsglistActivity<?>> mContext;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, n.h.msg_msgleft_view);
        this.bLG = new TouchType();
        this.bLH = new bh(this);
        this.mContext = tbPageContext;
        initView();
        this.bLF = (ImageView) findViewById(n.g.iv_live_group_host);
        this.bLD = (TextView) findViewById(n.g.tex_msgitem_name);
        this.bLE = (ViewGroup) findViewById(n.g.box_msgitem_bubble);
        this.bcC = (HeadImageView) findViewById(n.g.img_msgitem_photo);
        this.bcC.setAutoChangeStyle(false);
        this.bcC.setDrawerType(1);
        this.bcC.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.agT = (UserIconBox) findViewById(n.g.user_tshow_icon_box);
        this.bcC.setOnClickListener(new bi(this));
        this.bcC.setLongClickable(true);
        this.bcC.setOnLongClickListener(this.bLH);
        this.bcC.setOnTouchListener(new bj(this));
        this.bLw.setIsLeft(true);
        this.bLx.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        Wu();
        if (this.agT != null && this.bLA) {
            this.agT.setVisibility(0);
            this.agT.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.agT.a(tShowInfoNew, 2, resources.getDimensionPixelSize(n.e.small_icon_width), resources.getDimensionPixelSize(n.e.small_icon_height), resources.getDimensionPixelSize(n.e.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.bLD.setText((CharSequence) null);
            this.bLs.setVisibility(0);
            this.bLs.setText(null);
            ii(8);
            this.bLz.getImage().setTag(null);
            this.bLt.setVisibility(8);
            this.bLt.setTag(null);
            this.bLv.setVisibility(8);
            this.bLv.setTag(null);
            this.bLw.setVisibility(8);
            this.bLx.setVisibility(8);
            this.bLy.setVisibility(8);
            this.bLF.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.bLD.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.bLD.setText(chatMessage.getUserInfo().getUserName());
                this.bcC.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bcC.d(str, 10, false);
            } else {
                this.bcC.d(str, 12, false);
            }
            this.bLs.setVisibility(8);
            ii(8);
            this.bLt.setVisibility(8);
            this.bLu.setVisibility(8);
            this.bLv.setVisibility(8);
            this.bLx.setVisibility(8);
            this.bLw.setVisibility(8);
            this.bLy.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.tJ().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.bLF.setVisibility(0);
        } else {
            this.bLF.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.bLA) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = n.f.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = n.f.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.bLA) {
                i = 0;
            }
            this.bLD.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void Wu() {
        if (this.bLA) {
            this.bLD.setVisibility(0);
            this.agT.setVisibility(0);
            return;
        }
        this.bLD.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bLE.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.bLE.setLayoutParams(marginLayoutParams);
        this.agT.setVisibility(8);
    }
}
