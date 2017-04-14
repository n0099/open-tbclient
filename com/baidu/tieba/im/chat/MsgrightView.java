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
    private HeadImageView bPc;
    private ImageButton cOm;
    protected TextView cOn;
    private TextView cOo;
    private TextView cOp;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgright_view);
        initView();
        if (this.cNY != null && this.cNY.getImage() != null && (this.cNY.getImage() instanceof ChatClipImageItemView)) {
            this.cNY.getImage().setLeft(false);
        }
        this.cOn = (TextView) findViewById(w.h.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.cOm = (ImageButton) findViewById(w.h.btn_msgitem_resend);
        this.bPc = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.bPc.setAutoChangeStyle(false);
        this.bPc.setDrawerType(1);
        this.bPc.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bPc.setOnClickListener(new bm(this));
        this.cOo = (TextView) findViewById(w.h.has_read);
        this.cOp = (TextView) findViewById(w.h.has_sent);
        this.cNV.setIsLeft(false);
        this.cNW.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cOn.getVisibility() != 8) {
                this.cOn.setVisibility(8);
                this.cNY.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cOn.getVisibility() != 8) {
                this.cOn.setVisibility(8);
                this.cNY.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cNY.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(w.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cOn.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cOn.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bJn.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.cOm.setVisibility(8);
            this.cOo.setVisibility(8);
            this.cOp.setVisibility(8);
            this.cNR.setVisibility(0);
            this.cNR.setText(null);
            le(8);
            this.cNY.getImage().setTag(null);
            this.cNS.setVisibility(8);
            this.cNS.setTag(null);
            this.cNV.setVisibility(8);
            this.cNW.setVisibility(8);
            this.cNX.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bPc.setDefaultResource(w.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bPc.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bPc.c(currentPortrait, 12, false);
                }
            }
            this.bPc.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.cOm.setVisibility(8);
            this.cOo.setVisibility(8);
            this.cOp.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.cOm.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.cOa) {
                            if (chatMessage.isHasRead()) {
                                this.cOo.setVisibility(0);
                                this.cOp.setVisibility(8);
                                break;
                            } else {
                                this.cOo.setVisibility(8);
                                this.cOp.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cOm.getVisibility() == 0) {
                this.cOm.setOnClickListener(new bn(this));
            }
            this.cNR.setVisibility(8);
            le(8);
            this.cNS.setVisibility(8);
            this.cNT.setVisibility(8);
            this.cNW.setVisibility(8);
            this.cNV.setVisibility(8);
            this.cNX.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cNS.setVisibility(0);
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
