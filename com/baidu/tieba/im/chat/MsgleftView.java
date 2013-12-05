package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MsgleftView extends an {
    private static final String n = MsgleftView.class.getName();
    View.OnLongClickListener m;
    private HeadImageView o;
    private TextView p;
    private ImageView q;
    private final TouchType r;

    public MsgleftView(Context context) {
        super(context, R.layout.msg_msgleft_view);
        this.r = new TouchType();
        this.m = new au(this);
        e();
        this.p = (TextView) a(R.id.tex_msgitem_name);
        this.q = (ImageView) a(R.id.iv_sex);
        this.o = (HeadImageView) a(R.id.img_msgitem_photo);
        this.o.setAutoChangeStyle(false);
        this.o.setIsRound(true);
        this.o.setOnClickListener(new as(this));
        this.o.setLongClickable(true);
        this.o.setOnLongClickListener(this.m);
        this.o.setOnTouchListener(new at(this));
    }

    @Override // com.baidu.tieba.im.chat.an
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.p.setText((CharSequence) null);
            this.j.setVisibility(0);
            this.j.setText(null);
            c(8);
            this.k.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            return;
        }
        a(chatMessage);
        b(chatMessage);
        this.p.setText(chatMessage.getUserInfo().getName());
        try {
            if (chatMessage.getUserInfo() != null) {
                this.o.setUserId(chatMessage.getUserInfo().getId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            com.baidu.adp.widget.ImageView.e c = this.e.c(str);
            if (c != null) {
                c.a(this.o);
            } else {
                this.e.b(str, new av(this));
            }
            this.j.setVisibility(8);
            c(8);
            this.l.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, n);
                    return;
                case 2:
                    a(view, chatMessage, n);
                    return;
                case 3:
                    b(chatMessage, n);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b("MsgleftView", "setData", "error = " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void b(ChatMessage chatMessage) {
        if (chatMessage != null) {
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.q.setVisibility(8);
                return;
            }
            int sex = userInfo.getSex();
            if (sex == 1) {
                this.q.setImageResource(R.drawable.icon_pop_qz_boy);
                this.q.setVisibility(0);
            } else if (sex == 2) {
                this.q.setImageResource(R.drawable.icon_pop_qz_girl);
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
        }
    }
}
