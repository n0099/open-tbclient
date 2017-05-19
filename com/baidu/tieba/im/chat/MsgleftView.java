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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MsgleftView extends ar {
    private static final String TAG = MsgleftView.class.getName();
    private TbPageContext<MsglistActivity<?>> aat;
    private UserIconBox amq;
    private HeadImageView bQk;
    private ViewGroup cKv;
    private ImageView cKw;
    private final TouchType cKx;
    View.OnLongClickListener cKy;
    private TextView mName;

    public MsgleftView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgleft_view);
        this.cKx = new TouchType();
        this.cKy = new bh(this);
        this.aat = tbPageContext;
        initView();
        this.cKw = (ImageView) findViewById(w.h.iv_live_group_host);
        this.mName = (TextView) findViewById(w.h.tex_msgitem_name);
        this.cKv = (ViewGroup) findViewById(w.h.box_msgitem_bubble);
        this.bQk = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.bQk.setAutoChangeStyle(false);
        this.bQk.setDrawerType(1);
        this.bQk.setRadius(com.baidu.adp.lib.util.k.dip2px(this.aat.getContext(), 4.0f));
        this.amq = (UserIconBox) findViewById(w.h.user_tshow_icon_box);
        this.bQk.setOnClickListener(new bi(this));
        this.bQk.setLongClickable(true);
        this.bQk.setOnLongClickListener(this.cKy);
        this.bQk.setOnTouchListener(new bj(this));
        this.cKo.setIsLeft(true);
        this.cKp.setIsLeft(true);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        ArrayList<IconData> tShowInfoNew = chatMessage != null ? chatMessage.getUserInfo().getTShowInfoNew() : null;
        alr();
        if (this.amq != null && this.cKs) {
            this.amq.setVisibility(0);
            this.amq.setAutoChangedStyle(false);
            Resources resources = this.aat.getResources();
            this.amq.a(tShowInfoNew, 2, resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds32), resources.getDimensionPixelSize(w.f.ds8), true);
        }
        if (chatMessage == null) {
            this.mName.setText((CharSequence) null);
            this.cKk.setVisibility(0);
            this.cKk.setText(null);
            kX(8);
            this.cKr.getImage().setTag(null);
            this.cKl.setVisibility(8);
            this.cKl.setTag(null);
            this.cKn.setVisibility(8);
            this.cKn.setTag(null);
            this.cKo.setVisibility(8);
            this.cKp.setVisibility(8);
            this.cKq.setVisibility(8);
            this.cKw.setVisibility(8);
            return;
        }
        d(chatMessage);
        f(chatMessage);
        this.mName.setText("");
        e(chatMessage);
        try {
            if (chatMessage.getUserInfo() != null) {
                this.mName.setText(chatMessage.getUserInfo().getUserName());
                this.bQk.setUserId(chatMessage.getUserInfo().getUserId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            if (chatMessage.getUserInfo().getUserType() == 1 || chatMessage.getUserInfo().getUserType() == 3) {
                this.bQk.c(str, 10, false);
            } else {
                this.bQk.c(str, 12, false);
            }
            this.bQk.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cKk.setVisibility(8);
            kX(8);
            this.cKl.setVisibility(8);
            this.cKm.setVisibility(8);
            this.cKn.setVisibility(8);
            this.cKp.setVisibility(8);
            this.cKo.setVisibility(8);
            this.cKq.setVisibility(8);
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

    private void e(ChatMessage chatMessage) {
        String string = com.baidu.tbadk.core.sharedPref.b.tX().getString("live_room_chat_page_author_id", "");
        if (chatMessage.getUserInfo() != null && chatMessage.getUserInfo().getUserId().equals(string)) {
            this.cKw.setVisibility(0);
        } else {
            this.cKw.setVisibility(8);
        }
    }

    private void f(ChatMessage chatMessage) {
        int i;
        if (this.cKs) {
            if (chatMessage == null) {
                i = 0;
            } else if (chatMessage.getUserInfo() != null) {
                switch (chatMessage.getUserInfo().getSex()) {
                    case 1:
                        i = w.g.icon_pop_qz_boy;
                        break;
                    case 2:
                        i = w.g.icon_pop_qz_girl;
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = 0;
            }
            if (!this.cKs) {
                i = 0;
            }
            this.mName.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }
    }

    public void alr() {
        if (this.cKs) {
            this.mName.setVisibility(0);
            this.amq.setVisibility(0);
            return;
        }
        this.mName.setVisibility(8);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cKv.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.cKv.setLayoutParams(marginLayoutParams);
        this.amq.setVisibility(8);
    }
}
