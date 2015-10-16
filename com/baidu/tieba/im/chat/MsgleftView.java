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
    private UserIconBox aTi;
    private HeadImageView aTj;
    private TextView bsm;
    private ViewGroup bsn;
    private ImageView bso;
    private final TouchType bsp;
    View.OnLongClickListener bsq;
    private TbPageContext<MsglistActivity<?>> mContext;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgleft_view);
        this.bsp = new TouchType();
        this.bsq = new bh(this);
        this.mContext = tbPageContext;
        initView();
        this.bso = (ImageView) findViewById(i.f.iv_live_group_host);
        this.bsm = (TextView) findViewById(i.f.tex_msgitem_name);
        this.bsn = (ViewGroup) findViewById(i.f.box_msgitem_bubble);
        this.aTj = (HeadImageView) findViewById(i.f.img_msgitem_photo);
        this.aTj.setAutoChangeStyle(false);
        this.aTj.setDrawerType(1);
        this.aTj.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aTi = (UserIconBox) findViewById(i.f.user_tshow_icon_box);
        this.aTj.setOnClickListener(new bi(this));
        this.aTj.setLongClickable(true);
        this.aTj.setOnLongClickListener(this.bsq);
        this.aTj.setOnTouchListener(new bj(this));
        this.bsf.setIsLeft(true);
        this.bsg.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        RQ();
        if (this.aTi != null && this.bsj) {
            this.aTi.setVisibility(0);
            this.aTi.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.aTi.a(tShowInfo, 2, resources.getDimensionPixelSize(i.d.small_icon_width), resources.getDimensionPixelSize(i.d.small_icon_height), resources.getDimensionPixelSize(i.d.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.bsm.setText((CharSequence) null);
            this.bsb.setVisibility(0);
            this.bsb.setText(null);
            gJ(8);
            this.bsi.getImage().setTag(null);
            this.bsc.setVisibility(8);
            this.bsc.setTag(null);
            this.bse.setVisibility(8);
            this.bse.setTag(null);
            this.bsf.setVisibility(8);
            this.bsg.setVisibility(8);
            this.bsh.setVisibility(8);
            this.bso.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.bsm.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.bsm.setText(chatMessage.getUserInfo().getUserName());
                this.aTj.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aTj.d(str, 10, false);
            } else {
                this.aTj.d(str, 12, false);
            }
            this.bsb.setVisibility(8);
            gJ(8);
            this.bsc.setVisibility(8);
            this.bsd.setVisibility(8);
            this.bse.setVisibility(8);
            this.bsg.setVisibility(8);
            this.bsf.setVisibility(8);
            this.bsh.setVisibility(8);
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
            this.bso.setVisibility(0);
        } else {
            this.bso.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.bsj) {
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
            if (!this.bsj) {
                i = 0;
            }
            this.bsm.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void RQ() {
        if (this.bsj) {
            this.bsm.setVisibility(0);
            this.aTi.setVisibility(0);
            return;
        }
        this.bsm.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bsn.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.bsn.setLayoutParams(marginLayoutParams);
        this.aTi.setVisibility(8);
    }
}
