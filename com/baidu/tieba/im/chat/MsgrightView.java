package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MsgrightView extends al {
    private static final String m = MsgrightView.class.getName();
    private ProgressBar n;
    private ImageButton o;
    private HeadImageView p;

    public MsgrightView(Context context) {
        super(context, R.layout.msg_msgright_view);
        e();
        this.n = (ProgressBar) a(R.id.progress);
        this.o = (ImageButton) a(R.id.btn_msgitem_resend);
        this.p = (HeadImageView) a(R.id.img_msgitem_photo);
        this.p.setAutoChangeStyle(false);
        this.p.setOnClickListener(new bw(this));
    }

    @Override // com.baidu.tieba.im.chat.al
    public void a(View view, ChatMessage chatMessage) {
        String str = null;
        super.a(view, chatMessage);
        if (chatMessage == null) {
            this.i.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setText(null);
            c(8);
            this.k.setTag(null);
            this.l.setVisibility(8);
            this.l.setTag(null);
            return;
        }
        try {
            a(chatMessage);
            if (chatMessage.getUserInfo() != null) {
                this.p.setUserId(chatMessage.getUserInfo().getId());
                if (TiebaApplication.D()) {
                    str = com.baidu.tieba.im.i.b();
                }
            }
            com.baidu.adp.widget.ImageView.e c = this.e.c(str);
            if (c != null) {
                c.a(this.p);
            } else {
                this.e.b(str, new bx(this));
            }
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.n.setVisibility(0);
                        break;
                    case 2:
                        this.o.setVisibility(0);
                        break;
                    case 3:
                        this.n.setVisibility(8);
                        break;
                }
            }
            if (this.o.getVisibility() == 0) {
                this.o.setOnClickListener(new by(this));
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
                    c(0);
                    return;
                case 3:
                    b(chatMessage, m);
                    this.l.setVisibility(0);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.b("MsgrightView", "setData", "error = " + e.getMessage());
        }
    }
}
