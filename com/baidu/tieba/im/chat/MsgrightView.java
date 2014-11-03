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
    private static final String TAG = MsgrightView.class.getName();
    private ImageButton aPJ;
    protected TextView aPK;
    private TextView aPL;
    private TextView aPM;
    private HeadImageView azt;
    private ProgressBar mProgress;

    public MsgrightView(Context context) {
        super(context, com.baidu.tieba.w.msg_msgright_view);
        nu();
        if (this.aPv != null && this.aPv.getImage() != null && (this.aPv.getImage() instanceof ChatClipImageItemView)) {
            this.aPv.getImage().setLeft(false);
        }
        this.aPK = (TextView) findViewById(com.baidu.tieba.v.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.aPJ = (ImageButton) findViewById(com.baidu.tieba.v.btn_msgitem_resend);
        this.azt = (HeadImageView) findViewById(com.baidu.tieba.v.img_msgitem_photo);
        this.azt.setAutoChangeStyle(false);
        this.azt.setDrawerType(1);
        this.azt.setRadius(com.baidu.adp.lib.util.m.dip2px(this.mContext, 4.0f));
        this.azt.setOnClickListener(new ct(this));
        this.aPL = (TextView) findViewById(com.baidu.tieba.v.has_read);
        this.aPM = (TextView) findViewById(com.baidu.tieba.v.has_sent);
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.aPK.getVisibility() != 8) {
                this.aPK.setVisibility(8);
                this.aPv.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.aPK.getVisibility() != 8) {
                this.aPK.setVisibility(8);
                this.aPv.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.aPv.getImage().setColorFilter(TbadkApplication.m251getInst().getApp().getResources().getColor(com.baidu.tieba.s.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.aPK.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.aPK.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.auq.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.aPJ.setVisibility(8);
            this.aPL.setVisibility(8);
            this.aPM.setVisibility(8);
            this.aPp.setVisibility(0);
            this.aPp.setText(null);
            fq(8);
            this.aPv.getImage().setTag(null);
            this.aPq.setVisibility(8);
            this.aPq.setTag(null);
            this.aPt.setVisibility(8);
            this.aPu.setVisibility(8);
            return;
        }
        try {
            h(chatMessage);
            this.azt.setDefaultResource(com.baidu.tieba.u.photo);
            if (chatMessage.getUserInfo() != null) {
                this.azt.setUserId(chatMessage.getUserInfo().getUserId());
                String Jj = TbadkApplication.isLogin() ? com.baidu.tieba.im.c.Jj() : null;
                if (Jj != null && Jj.length() > 0) {
                    this.azt.c(Jj, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.aPJ.setVisibility(8);
            this.aPL.setVisibility(8);
            this.aPM.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.aPJ.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.aPx) {
                            if (chatMessage.isHasRead()) {
                                this.aPL.setVisibility(0);
                                this.aPM.setVisibility(8);
                                break;
                            } else {
                                this.aPL.setVisibility(8);
                                this.aPM.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.aPJ.getVisibility() == 0) {
                this.aPJ.setOnClickListener(new cu(this));
            }
            this.aPp.setVisibility(8);
            fq(8);
            this.aPq.setVisibility(8);
            this.aPr.setVisibility(8);
            this.aPt.setVisibility(8);
            this.aPu.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    b(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    c(chatMessage, TAG);
                    this.aPq.setVisibility(0);
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
                    c(view, chatMessage, TAG);
                    return;
            }
        } catch (Exception e) {
        }
    }
}
