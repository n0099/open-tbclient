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
public class MsgleftView extends al {
    private static final String m = MsgleftView.class.getName();
    private HeadImageView n;
    private TextView o;
    private ImageView p;

    public MsgleftView(Context context) {
        super(context, R.layout.msg_msgleft_view);
        e();
        this.o = (TextView) a(R.id.tex_msgitem_name);
        this.p = (ImageView) a(R.id.iv_sex);
        this.n = (HeadImageView) a(R.id.img_msgitem_photo);
        this.n.setAutoChangeStyle(false);
        this.n.setOnClickListener(new aq(this));
        this.n.setLongClickable(true);
        this.n.setOnLongClickListener(new ar(this));
    }

    @Override // com.baidu.tieba.im.chat.al
    public void a(View view, ChatMessage chatMessage) {
        String str = null;
        super.a(view, chatMessage);
        if (chatMessage == null) {
            this.o.setText((CharSequence) null);
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
        this.o.setText(chatMessage.getUserInfo().getName());
        try {
            if (chatMessage.getUserInfo() != null) {
                this.n.setUserId(chatMessage.getUserInfo().getId());
                str = chatMessage.getUserInfo().getPortrait();
            }
            com.baidu.adp.widget.ImageView.e c = this.e.c(str);
            if (c != null) {
                c.a(this.n);
            } else {
                this.e.b(str, new as(this));
            }
            this.j.setVisibility(8);
            c(8);
            this.l.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, m);
                    return;
                case 2:
                    a(view, chatMessage, m);
                    return;
                case 3:
                    b(chatMessage, m);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.b("MsgleftView", "setData", "error = " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void b(ChatMessage chatMessage) {
        if (chatMessage != null) {
            UserData userInfo = chatMessage.getUserInfo();
            if (userInfo == null) {
                this.p.setVisibility(8);
                return;
            }
            if (userInfo.getSex() == 1) {
                this.p.setImageResource(R.drawable.cent_icon_boy_n);
            } else {
                this.p.setImageResource(R.drawable.cent_icon_girl_n);
            }
            this.p.setVisibility(0);
        }
    }
}
