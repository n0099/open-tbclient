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
    private ImageButton aPv;
    protected TextView aPw;
    private TextView aPx;
    private TextView aPy;
    private HeadImageView azk;
    private ProgressBar mProgress;

    public MsgrightView(Context context) {
        super(context, com.baidu.tieba.w.msg_msgright_view);
        nu();
        if (this.aPh != null && this.aPh.getImage() != null && (this.aPh.getImage() instanceof ChatClipImageItemView)) {
            this.aPh.getImage().setLeft(false);
        }
        this.aPw = (TextView) findViewById(com.baidu.tieba.v.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.aPv = (ImageButton) findViewById(com.baidu.tieba.v.btn_msgitem_resend);
        this.azk = (HeadImageView) findViewById(com.baidu.tieba.v.img_msgitem_photo);
        this.azk.setAutoChangeStyle(false);
        this.azk.setDrawerType(1);
        this.azk.setRadius(com.baidu.adp.lib.util.m.dip2px(this.mContext, 4.0f));
        this.azk.setOnClickListener(new ct(this));
        this.aPx = (TextView) findViewById(com.baidu.tieba.v.has_read);
        this.aPy = (TextView) findViewById(com.baidu.tieba.v.has_sent);
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.aPw.getVisibility() != 8) {
                this.aPw.setVisibility(8);
                this.aPh.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.aPw.getVisibility() != 8) {
                this.aPw.setVisibility(8);
                this.aPh.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.aPh.getImage().setColorFilter(TbadkApplication.m251getInst().getApp().getResources().getColor(com.baidu.tieba.s.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.aPw.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.aPw.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.cc
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.auh.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.aPv.setVisibility(8);
            this.aPx.setVisibility(8);
            this.aPy.setVisibility(8);
            this.aPb.setVisibility(0);
            this.aPb.setText(null);
            fq(8);
            this.aPh.getImage().setTag(null);
            this.aPc.setVisibility(8);
            this.aPc.setTag(null);
            this.aPf.setVisibility(8);
            this.aPg.setVisibility(8);
            return;
        }
        try {
            h(chatMessage);
            this.azk.setDefaultResource(com.baidu.tieba.u.photo);
            if (chatMessage.getUserInfo() != null) {
                this.azk.setUserId(chatMessage.getUserInfo().getUserId());
                String Jf = TbadkApplication.isLogin() ? com.baidu.tieba.im.c.Jf() : null;
                if (Jf != null && Jf.length() > 0) {
                    this.azk.c(Jf, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.aPv.setVisibility(8);
            this.aPx.setVisibility(8);
            this.aPy.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.aPv.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.aPj) {
                            if (chatMessage.isHasRead()) {
                                this.aPx.setVisibility(0);
                                this.aPy.setVisibility(8);
                                break;
                            } else {
                                this.aPx.setVisibility(8);
                                this.aPy.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.aPv.getVisibility() == 0) {
                this.aPv.setOnClickListener(new cu(this));
            }
            this.aPb.setVisibility(8);
            fq(8);
            this.aPc.setVisibility(8);
            this.aPd.setVisibility(8);
            this.aPf.setVisibility(8);
            this.aPg.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    b(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    c(chatMessage, TAG);
                    this.aPc.setVisibility(0);
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
