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
/* loaded from: classes.dex */
public class MsgrightView extends bk {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView aIi;
    private ImageButton aXW;
    protected TextView aXX;
    private TextView aXY;
    private TextView aXZ;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.w.msg_msgright_view);
        initView();
        if (this.aXG != null && this.aXG.getImage() != null && (this.aXG.getImage() instanceof ChatClipImageItemView)) {
            this.aXG.getImage().setLeft(false);
        }
        this.aXX = (TextView) findViewById(com.baidu.tieba.v.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.aXW = (ImageButton) findViewById(com.baidu.tieba.v.btn_msgitem_resend);
        this.aIi = (HeadImageView) findViewById(com.baidu.tieba.v.img_msgitem_photo);
        this.aIi.setAutoChangeStyle(false);
        this.aIi.setDrawerType(1);
        this.aIi.setRadius(com.baidu.adp.lib.util.n.dip2px(this.mContext.getContext(), 4.0f));
        this.aIi.setOnClickListener(new cc(this));
        this.aXY = (TextView) findViewById(com.baidu.tieba.v.has_read);
        this.aXZ = (TextView) findViewById(com.baidu.tieba.v.has_sent);
        this.aXE.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.aXX.getVisibility() != 8) {
                this.aXX.setVisibility(8);
                this.aXG.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.aXX.getVisibility() != 8) {
                this.aXX.setVisibility(8);
                this.aXG.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.aXG.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(com.baidu.tieba.s.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.aXX.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.aXX.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.aGK.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.aXW.setVisibility(8);
            this.aXY.setVisibility(8);
            this.aXZ.setVisibility(8);
            this.aXA.setVisibility(0);
            this.aXA.setText(null);
            fz(8);
            this.aXG.getImage().setTag(null);
            this.aXB.setVisibility(8);
            this.aXB.setTag(null);
            this.aXE.setVisibility(8);
            this.aXF.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aIi.setDefaultResource(com.baidu.tieba.u.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aIi.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aIi.c(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.aXW.setVisibility(8);
            this.aXY.setVisibility(8);
            this.aXZ.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.aXW.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.aXI) {
                            if (chatMessage.isHasRead()) {
                                this.aXY.setVisibility(0);
                                this.aXZ.setVisibility(8);
                                break;
                            } else {
                                this.aXY.setVisibility(8);
                                this.aXZ.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.aXW.getVisibility() == 0) {
                this.aXW.setOnClickListener(new cd(this));
            }
            this.aXA.setVisibility(8);
            fz(8);
            this.aXB.setVisibility(8);
            this.aXC.setVisibility(8);
            this.aXE.setVisibility(8);
            this.aXF.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.aXB.setVisibility(0);
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
