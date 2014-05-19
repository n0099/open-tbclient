package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.view.HeadImageShaderView;
/* loaded from: classes.dex */
public class MsgrightView extends cd {
    private static final String p = MsgrightView.class.getName();
    protected TextView o;
    private ProgressBar q;
    private ImageButton r;
    private HeadImageShaderView s;

    public MsgrightView(Context context) {
        super(context, com.baidu.tieba.s.msg_msgright_view);
        b();
        this.o = (TextView) a(com.baidu.tieba.r.img_msgitem_progressbar);
        this.q = (ProgressBar) a(com.baidu.tieba.r.progress);
        this.r = (ImageButton) a(com.baidu.tieba.r.btn_msgitem_resend);
        this.s = (HeadImageShaderView) a(com.baidu.tieba.r.img_msgitem_photo);
        this.s.setAutoChangeStyle(false);
        this.s.setOnClickListener(new co(this));
    }

    @Override // com.baidu.tieba.im.chat.cd
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.o.getVisibility() != 8) {
                this.o.setVisibility(8);
                this.j.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.o.getVisibility() != 8) {
                this.o.setVisibility(8);
                this.j.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.j.setColorFilter(TbadkApplication.m252getInst().getApp().getResources().getColor(com.baidu.tieba.o.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.o.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.o.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.cd
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.h.setVisibility(8);
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            this.i.setVisibility(0);
            this.i.setText(null);
            c(8);
            this.j.setTag(null);
            this.k.setVisibility(8);
            this.k.setTag(null);
            return;
        }
        try {
            b(chatMessage);
            this.s.getHeadImageView().setDefaultResource(com.baidu.tieba.q.photo);
            if (chatMessage.getUserInfo() != null) {
                this.s.setUserId(chatMessage.getUserInfo().getUserId());
                String b = TbadkApplication.isLogin() ? com.baidu.tieba.im.e.b() : null;
                if (b != null && b.length() > 0) {
                    this.s.getHeadImageView().a(b, 12, false);
                }
            }
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.q.setVisibility(0);
                        break;
                    case 2:
                        this.r.setVisibility(0);
                        break;
                    case 3:
                        this.q.setVisibility(8);
                        break;
                }
            }
            if (this.r.getVisibility() == 0) {
                this.r.setOnClickListener(new cp(this));
            }
            this.i.setVisibility(8);
            c(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, p);
                    return;
                case 2:
                    a(view, chatMessage, p);
                    c(0);
                    return;
                case 3:
                    b(chatMessage, p);
                    this.k.setVisibility(0);
                    return;
                case 4:
                    a(chatMessage, true);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            BdLog.e("MsgrightView", "setData", "error = " + e.getMessage());
        }
    }
}
