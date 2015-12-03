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
    private UserIconBox aYE;
    private HeadImageView aYF;
    private TextView bHW;
    private ViewGroup bHX;
    private ImageView bHY;
    private final TouchType bHZ;
    View.OnLongClickListener bIa;
    private TbPageContext<MsglistActivity<?>> mContext;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, n.g.msg_msgleft_view);
        this.bHZ = new TouchType();
        this.bIa = new bh(this);
        this.mContext = tbPageContext;
        initView();
        this.bHY = (ImageView) findViewById(n.f.iv_live_group_host);
        this.bHW = (TextView) findViewById(n.f.tex_msgitem_name);
        this.bHX = (ViewGroup) findViewById(n.f.box_msgitem_bubble);
        this.aYF = (HeadImageView) findViewById(n.f.img_msgitem_photo);
        this.aYF.setAutoChangeStyle(false);
        this.aYF.setDrawerType(1);
        this.aYF.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aYE = (UserIconBox) findViewById(n.f.user_tshow_icon_box);
        this.aYF.setOnClickListener(new bi(this));
        this.aYF.setLongClickable(true);
        this.aYF.setOnLongClickListener(this.bIa);
        this.aYF.setOnTouchListener(new bj(this));
        this.bHP.setIsLeft(true);
        this.bHQ.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        Vo();
        if (this.aYE != null && this.bHT) {
            this.aYE.setVisibility(0);
            this.aYE.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.aYE.a(tShowInfoNew, 2, resources.getDimensionPixelSize(n.d.small_icon_width), resources.getDimensionPixelSize(n.d.small_icon_height), resources.getDimensionPixelSize(n.d.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.bHW.setText((CharSequence) null);
            this.bHL.setVisibility(0);
            this.bHL.setText(null);
            hI(8);
            this.bHS.getImage().setTag(null);
            this.bHM.setVisibility(8);
            this.bHM.setTag(null);
            this.bHO.setVisibility(8);
            this.bHO.setTag(null);
            this.bHP.setVisibility(8);
            this.bHQ.setVisibility(8);
            this.bHR.setVisibility(8);
            this.bHY.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.bHW.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.bHW.setText(chatMessage.getUserInfo().getUserName());
                this.aYF.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aYF.d(str, 10, false);
            } else {
                this.aYF.d(str, 12, false);
            }
            this.bHL.setVisibility(8);
            hI(8);
            this.bHM.setVisibility(8);
            this.bHN.setVisibility(8);
            this.bHO.setVisibility(8);
            this.bHQ.setVisibility(8);
            this.bHP.setVisibility(8);
            this.bHR.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.tZ().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.bHY.setVisibility(0);
        } else {
            this.bHY.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.bHT) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = n.e.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = n.e.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.bHT) {
                i = 0;
            }
            this.bHW.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void Vo() {
        if (this.bHT) {
            this.bHW.setVisibility(0);
            this.aYE.setVisibility(0);
            return;
        }
        this.bHW.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bHX.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.bHX.setLayoutParams(marginLayoutParams);
        this.aYE.setVisibility(8);
    }
}
