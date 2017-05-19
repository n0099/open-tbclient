package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class MsgrightView extends ar {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView bQk;
    private ImageButton cKF;
    protected TextView cKG;
    private TextView cKH;
    private TextView cKI;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgright_view);
        initView();
        if (this.cKr != null && this.cKr.getImage() != null && (this.cKr.getImage() instanceof ChatClipImageItemView)) {
            this.cKr.getImage().setLeft(false);
        }
        this.cKG = (TextView) findViewById(w.h.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.cKF = (ImageButton) findViewById(w.h.btn_msgitem_resend);
        this.bQk = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.bQk.setAutoChangeStyle(false);
        this.bQk.setDrawerType(1);
        this.bQk.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bQk.setOnClickListener(new bm(this));
        this.cKH = (TextView) findViewById(w.h.has_read);
        this.cKI = (TextView) findViewById(w.h.has_sent);
        this.cKo.setIsLeft(false);
        this.cKp.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cKG.getVisibility() != 8) {
                this.cKG.setVisibility(8);
                this.cKr.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cKG.getVisibility() != 8) {
                this.cKG.setVisibility(8);
                this.cKr.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cKr.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(w.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cKG.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cKG.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bKI.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.cKF.setVisibility(8);
            this.cKH.setVisibility(8);
            this.cKI.setVisibility(8);
            this.cKk.setVisibility(0);
            this.cKk.setText(null);
            kX(8);
            this.cKr.getImage().setTag(null);
            this.cKl.setVisibility(8);
            this.cKl.setTag(null);
            this.cKo.setVisibility(8);
            this.cKp.setVisibility(8);
            this.cKq.setVisibility(8);
            return;
        }
        try {
            d(chatMessage);
            this.bQk.setDefaultResource(w.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bQk.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bQk.c(currentPortrait, 12, false);
                }
            }
            this.bQk.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.cKF.setVisibility(8);
            this.cKH.setVisibility(8);
            this.cKI.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.cKF.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.cKt) {
                            if (chatMessage.isHasRead()) {
                                this.cKH.setVisibility(0);
                                this.cKI.setVisibility(8);
                                break;
                            } else {
                                this.cKH.setVisibility(8);
                                this.cKI.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cKF.getVisibility() == 0) {
                this.cKF.setOnClickListener(new bn(this));
            }
            this.cKk.setVisibility(8);
            kX(8);
            this.cKl.setVisibility(8);
            this.cKm.setVisibility(8);
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
                    this.cKl.setVisibility(0);
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
