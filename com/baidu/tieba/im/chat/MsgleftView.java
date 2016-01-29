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
    private TbPageContext<MsglistActivity<?>> MR;
    private UserIconBox ahI;
    private TextView bPr;
    private ViewGroup bPs;
    private ImageView bPt;
    private final TouchType bPu;
    View.OnLongClickListener bPv;
    private HeadImageView beU;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgleft_view);
        this.bPu = new TouchType();
        this.bPv = new bh(this);
        this.MR = tbPageContext;
        initView();
        this.bPt = (ImageView) findViewById(t.g.iv_live_group_host);
        this.bPr = (TextView) findViewById(t.g.tex_msgitem_name);
        this.bPs = (ViewGroup) findViewById(t.g.box_msgitem_bubble);
        this.beU = (HeadImageView) findViewById(t.g.img_msgitem_photo);
        this.beU.setAutoChangeStyle(false);
        this.beU.setDrawerType(1);
        this.beU.setRadius(com.baidu.adp.lib.util.k.dip2px(this.MR.getContext(), 4.0f));
        this.ahI = (UserIconBox) findViewById(t.g.user_tshow_icon_box);
        this.beU.setOnClickListener(new bi(this));
        this.beU.setLongClickable(true);
        this.beU.setOnLongClickListener(this.bPv);
        this.beU.setOnTouchListener(new bj(this));
        this.bPk.setIsLeft(true);
        this.bPl.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        YY();
        if (this.ahI != null && this.bPo) {
            this.ahI.setVisibility(0);
            this.ahI.setAutoChangedStyle(false);
            Resources resources = this.MR.getResources();
            this.ahI.a(tShowInfoNew, 2, resources.getDimensionPixelSize(t.e.small_icon_width), resources.getDimensionPixelSize(t.e.small_icon_height), resources.getDimensionPixelSize(t.e.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.bPr.setText((CharSequence) null);
            this.bPg.setVisibility(0);
            this.bPg.setText(null);
            iF(8);
            this.bPn.getImage().setTag(null);
            this.bPh.setVisibility(8);
            this.bPh.setTag(null);
            this.bPj.setVisibility(8);
            this.bPj.setTag(null);
            this.bPk.setVisibility(8);
            this.bPl.setVisibility(8);
            this.bPm.setVisibility(8);
            this.bPt.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.bPr.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.bPr.setText(chatMessage.getUserInfo().getUserName());
                this.beU.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.beU.d(str, 10, false);
            } else {
                this.beU.d(str, 12, false);
            }
            this.bPg.setVisibility(8);
            iF(8);
            this.bPh.setVisibility(8);
            this.bPi.setVisibility(8);
            this.bPj.setVisibility(8);
            this.bPl.setVisibility(8);
            this.bPk.setVisibility(8);
            this.bPm.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.uO().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.bPt.setVisibility(0);
        } else {
            this.bPt.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.bPo) {
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
            if (!this.bPo) {
                i = 0;
            }
            this.bPr.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void YY() {
        if (this.bPo) {
            this.bPr.setVisibility(0);
            this.ahI.setVisibility(0);
            return;
        }
        this.bPr.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bPs.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.bPs.setLayoutParams(marginLayoutParams);
        this.ahI.setVisibility(8);
    }
}
