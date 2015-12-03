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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class MsgrightView extends as {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView aYF;
    private ImageButton bIh;
    protected TextView bIi;
    private TextView bIj;
    private TextView bIk;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, n.g.msg_msgright_view);
        initView();
        if (this.bHS != null && this.bHS.getImage() != null && (this.bHS.getImage() instanceof ChatClipImageItemView)) {
            this.bHS.getImage().setLeft(false);
        }
        this.bIi = (TextView) findViewById(n.f.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(n.f.progress);
        this.bIh = (ImageButton) findViewById(n.f.btn_msgitem_resend);
        this.aYF = (HeadImageView) findViewById(n.f.img_msgitem_photo);
        this.aYF.setAutoChangeStyle(false);
        this.aYF.setDrawerType(1);
        this.aYF.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aYF.setOnClickListener(new bm(this));
        this.bIj = (TextView) findViewById(n.f.has_read);
        this.bIk = (TextView) findViewById(n.f.has_sent);
        this.bHP.setIsLeft(false);
        this.bHQ.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.bIi.getVisibility() != 8) {
                this.bIi.setVisibility(8);
                this.bHS.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.bIi.getVisibility() != 8) {
                this.bIi.setVisibility(8);
                this.bHS.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.bHS.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(n.c.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.bIi.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.bIi.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.aVi.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.bIh.setVisibility(8);
            this.bIj.setVisibility(8);
            this.bIk.setVisibility(8);
            this.bHL.setVisibility(0);
            this.bHL.setText(null);
            hI(8);
            this.bHS.getImage().setTag(null);
            this.bHM.setVisibility(8);
            this.bHM.setTag(null);
            this.bHP.setVisibility(8);
            this.bHQ.setVisibility(8);
            this.bHR.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aYF.setDefaultResource(n.e.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aYF.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aYF.d(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.bIh.setVisibility(8);
            this.bIj.setVisibility(8);
            this.bIk.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.bIh.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.bHU) {
                            if (chatMessage.isHasRead()) {
                                this.bIj.setVisibility(0);
                                this.bIk.setVisibility(8);
                                break;
                            } else {
                                this.bIj.setVisibility(8);
                                this.bIk.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.bIh.getVisibility() == 0) {
                this.bIh.setOnClickListener(new bn(this));
            }
            this.bHL.setVisibility(8);
            hI(8);
            this.bHM.setVisibility(8);
            this.bHN.setVisibility(8);
            this.bHQ.setVisibility(8);
            this.bHP.setVisibility(8);
            this.bHR.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.bHM.setVisibility(0);
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
