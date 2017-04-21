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
    private HeadImageView bRt;
    private ImageButton cQD;
    protected TextView cQE;
    private TextView cQF;
    private TextView cQG;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgright_view);
        initView();
        if (this.cQp != null && this.cQp.getImage() != null && (this.cQp.getImage() instanceof ChatClipImageItemView)) {
            this.cQp.getImage().setLeft(false);
        }
        this.cQE = (TextView) findViewById(w.h.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.cQD = (ImageButton) findViewById(w.h.btn_msgitem_resend);
        this.bRt = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.bRt.setAutoChangeStyle(false);
        this.bRt.setDrawerType(1);
        this.bRt.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bRt.setOnClickListener(new bm(this));
        this.cQF = (TextView) findViewById(w.h.has_read);
        this.cQG = (TextView) findViewById(w.h.has_sent);
        this.cQm.setIsLeft(false);
        this.cQn.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cQE.getVisibility() != 8) {
                this.cQE.setVisibility(8);
                this.cQp.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cQE.getVisibility() != 8) {
                this.cQE.setVisibility(8);
                this.cQp.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cQp.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(w.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cQE.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cQE.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bLE.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.cQD.setVisibility(8);
            this.cQF.setVisibility(8);
            this.cQG.setVisibility(8);
            this.cQi.setVisibility(0);
            this.cQi.setText(null);
            lk(8);
            this.cQp.getImage().setTag(null);
            this.cQj.setVisibility(8);
            this.cQj.setTag(null);
            this.cQm.setVisibility(8);
            this.cQn.setVisibility(8);
            this.cQo.setVisibility(8);
            return;
        }
        try {
            d(chatMessage);
            this.bRt.setDefaultResource(w.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bRt.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bRt.c(currentPortrait, 12, false);
                }
            }
            this.bRt.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.cQD.setVisibility(8);
            this.cQF.setVisibility(8);
            this.cQG.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.cQD.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.cQr) {
                            if (chatMessage.isHasRead()) {
                                this.cQF.setVisibility(0);
                                this.cQG.setVisibility(8);
                                break;
                            } else {
                                this.cQF.setVisibility(8);
                                this.cQG.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cQD.getVisibility() == 0) {
                this.cQD.setOnClickListener(new bn(this));
            }
            this.cQi.setVisibility(8);
            lk(8);
            this.cQj.setVisibility(8);
            this.cQk.setVisibility(8);
            this.cQn.setVisibility(8);
            this.cQm.setVisibility(8);
            this.cQo.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cQj.setVisibility(0);
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
