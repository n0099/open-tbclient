package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MsgrightView extends an {
    private static final String n = MsgrightView.class.getName();
    protected TextView m;
    private ProgressBar o;
    private ImageButton p;
    private HeadImageView q;

    public MsgrightView(Context context) {
        super(context, R.layout.msg_msgright_view);
        e();
        this.m = (TextView) a(R.id.img_msgitem_progressbar);
        this.o = (ProgressBar) a(R.id.progress);
        this.p = (ImageButton) a(R.id.btn_msgitem_resend);
        this.q = (HeadImageView) a(R.id.img_msgitem_photo);
        this.q.setAutoChangeStyle(false);
        this.q.setIsRound(true);
        this.q.setOnClickListener(new cb(this));
    }

    @Override // com.baidu.tieba.im.chat.an
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.m.getVisibility() != 8) {
                this.m.setVisibility(8);
                this.k.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.m.getVisibility() != 8) {
                this.m.setVisibility(8);
                this.k.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.k.setColorFilter(TiebaApplication.h().getResources().getColor(R.color.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.m.setText(chatMessage.getProgressValue() + "%");
            this.m.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.an
    public void b(View view, ChatMessage chatMessage) {
        String str = null;
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.i.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
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
                this.q.setUserId(chatMessage.getUserInfo().getId());
                if (TiebaApplication.C()) {
                    str = com.baidu.tieba.im.i.b();
                }
            }
            com.baidu.adp.widget.ImageView.e c = this.e.c(str);
            if (c != null) {
                c.a(this.q);
            } else {
                this.e.b(str, new cc(this));
            }
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.o.setVisibility(0);
                        break;
                    case 2:
                        this.p.setVisibility(0);
                        break;
                    case 3:
                        this.o.setVisibility(8);
                        break;
                }
            }
            if (this.p.getVisibility() == 0) {
                this.p.setOnClickListener(new cd(this));
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
                    c(0);
                    return;
                case 3:
                    b(chatMessage, n);
                    this.l.setVisibility(0);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b("MsgrightView", "setData", "error = " + e.getMessage());
        }
    }
}
