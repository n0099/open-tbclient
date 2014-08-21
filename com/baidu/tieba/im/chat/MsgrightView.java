package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends cc {
    private static final String q = MsgrightView.class.getName();
    protected TextView p;
    private ProgressBar r;
    private ImageButton s;
    private HeadImageView t;

    public MsgrightView(Context context) {
        super(context, com.baidu.tieba.v.msg_msgright_view);
        b();
        if (this.n != null && this.n.getImage() != null && (this.n.getImage() instanceof ChatClipImageItemView)) {
            this.n.getImage().setLeft(false);
        }
        this.p = (TextView) a(com.baidu.tieba.u.img_msgitem_progressbar);
        this.r = (ProgressBar) a(com.baidu.tieba.u.progress);
        this.s = (ImageButton) a(com.baidu.tieba.u.btn_msgitem_resend);
        this.t = (HeadImageView) a(com.baidu.tieba.u.img_msgitem_photo);
        this.t.setAutoChangeStyle(false);
        this.t.setDrawerType(1);
        this.t.setRadius(com.baidu.adp.lib.util.j.a(this.mContext, 4.0f));
        this.t.setOnClickListener(new cs(this));
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.p.getVisibility() != 8) {
                this.p.setVisibility(8);
                this.n.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.p.getVisibility() != 8) {
                this.p.setVisibility(8);
                this.n.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.n.getImage().setColorFilter(TbadkApplication.m252getInst().getApp().getResources().getColor(com.baidu.tieba.r.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.p.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.p.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.g.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.h.setVisibility(0);
            this.h.setText(null);
            c(8);
            this.n.getImage().setTag(null);
            this.i.setVisibility(8);
            this.i.setTag(null);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.t.setDefaultResource(com.baidu.tieba.t.photo);
            if (chatMessage.getUserInfo() != null) {
                this.t.setUserId(chatMessage.getUserInfo().getUserId());
                String b = TbadkApplication.isLogin() ? com.baidu.tieba.im.c.b() : null;
                if (b != null && b.length() > 0) {
                    this.t.a(b, 12, false);
                }
            }
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.r.setVisibility(0);
                        break;
                    case 2:
                        this.s.setVisibility(0);
                        break;
                    case 3:
                        this.r.setVisibility(8);
                        break;
                }
            }
            if (this.s.getVisibility() == 0) {
                this.s.setOnClickListener(new ct(this));
            }
            this.h.setVisibility(8);
            c(8);
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, q);
                    return;
                case 2:
                    a(view, chatMessage, q);
                    return;
                case 3:
                    b(chatMessage, q);
                    this.i.setVisibility(0);
                    return;
                case 4:
                    a(chatMessage, true);
                    return;
                case 5:
                case 6:
                case 7:
                case 8:
                default:
                    return;
                case 9:
                    c(view, chatMessage, q);
                    return;
            }
        } catch (Exception e) {
        }
    }
}
