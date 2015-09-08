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
    private UserIconBox aUb;
    private HeadImageView aUc;
    private TextView bpb;
    private ViewGroup bpc;
    private ImageView bpd;
    private final TouchType bpe;
    View.OnLongClickListener bpf;
    private TbPageContext<MsglistActivity<?>> mContext;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgleft_view);
        this.bpe = new TouchType();
        this.bpf = new bf(this);
        this.mContext = tbPageContext;
        initView();
        this.bpd = (ImageView) findViewById(i.f.iv_live_group_host);
        this.bpb = (TextView) findViewById(i.f.tex_msgitem_name);
        this.bpc = (ViewGroup) findViewById(i.f.box_msgitem_bubble);
        this.aUc = (HeadImageView) findViewById(i.f.img_msgitem_photo);
        this.aUc.setAutoChangeStyle(false);
        this.aUc.setDrawerType(1);
        this.aUc.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aUb = (UserIconBox) findViewById(i.f.user_tshow_icon_box);
        this.aUc.setOnClickListener(new bg(this));
        this.aUc.setLongClickable(true);
        this.aUc.setOnLongClickListener(this.bpf);
        this.aUc.setOnTouchListener(new bh(this));
        this.boV.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfo = chatMessage != null ? chatMessage.getUserInfo().getTShowInfo() : null;
        Rj();
        if (this.aUb != null && this.boY) {
            this.aUb.setVisibility(0);
            this.aUb.setAutoChangedStyle(false);
            Resources resources = this.mContext.getResources();
            this.aUb.a(tShowInfo, 2, resources.getDimensionPixelSize(i.d.small_icon_width), resources.getDimensionPixelSize(i.d.small_icon_height), resources.getDimensionPixelSize(i.d.small_icon_margin), true);
        }
        if (chatMessage == null) {
            this.bpb.setText((CharSequence) null);
            this.boR.setVisibility(0);
            this.boR.setText(null);
            gD(8);
            this.boX.getImage().setTag(null);
            this.boS.setVisibility(8);
            this.boS.setTag(null);
            this.boU.setVisibility(8);
            this.boU.setTag(null);
            this.boV.setVisibility(8);
            this.boW.setVisibility(8);
            this.bpd.setVisibility(8);
            return;
        }
        b(chatMessage);
        d(chatMessage);
        this.bpb.setText("");
        c(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.bpb.setText(chatMessage.getUserInfo().getUserName());
                this.aUc.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.aUc.d(str, 10, false);
            } else {
                this.aUc.d(str, 12, false);
            }
            this.boR.setVisibility(8);
            gD(8);
            this.boS.setVisibility(8);
            this.boT.setVisibility(8);
            this.boU.setVisibility(8);
            this.boV.setVisibility(8);
            this.boW.setVisibility(8);
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
        String string = com.baidu.tbadk.core.sharedPref.b.tx().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.bpd.setVisibility(0);
        } else {
            this.bpd.setVisibility(8);
        }
    }

    private void d(ChatMessage chatMessage) {
        int i;
        if (this.boY) {
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
            if (!this.boY) {
                i = 0;
            }
            this.bpb.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void Rj() {
        if (this.boY) {
            this.bpb.setVisibility(0);
            this.aUb.setVisibility(0);
            return;
        }
        this.bpb.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bpc.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.bpc.setLayoutParams(marginLayoutParams);
        this.aUb.setVisibility(8);
    }
}
