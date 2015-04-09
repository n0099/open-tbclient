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
    private HeadImageView aIq;
    private ImageButton aYm;
    protected TextView aYn;
    private TextView aYo;
    private TextView aYp;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.w.msg_msgright_view);
        initView();
        if (this.aXW != null && this.aXW.getImage() != null && (this.aXW.getImage() instanceof ChatClipImageItemView)) {
            this.aXW.getImage().setLeft(false);
        }
        this.aYn = (TextView) findViewById(com.baidu.tieba.v.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.aYm = (ImageButton) findViewById(com.baidu.tieba.v.btn_msgitem_resend);
        this.aIq = (HeadImageView) findViewById(com.baidu.tieba.v.img_msgitem_photo);
        this.aIq.setAutoChangeStyle(false);
        this.aIq.setDrawerType(1);
        this.aIq.setRadius(com.baidu.adp.lib.util.n.dip2px(this.mContext.getContext(), 4.0f));
        this.aIq.setOnClickListener(new cc(this));
        this.aYo = (TextView) findViewById(com.baidu.tieba.v.has_read);
        this.aYp = (TextView) findViewById(com.baidu.tieba.v.has_sent);
        this.aXU.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.aYn.getVisibility() != 8) {
                this.aYn.setVisibility(8);
                this.aXW.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.aYn.getVisibility() != 8) {
                this.aYn.setVisibility(8);
                this.aXW.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.aXW.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(com.baidu.tieba.s.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.aYn.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.aYn.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.aGS.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.aYm.setVisibility(8);
            this.aYo.setVisibility(8);
            this.aYp.setVisibility(8);
            this.aXQ.setVisibility(0);
            this.aXQ.setText(null);
            fB(8);
            this.aXW.getImage().setTag(null);
            this.aXR.setVisibility(8);
            this.aXR.setTag(null);
            this.aXU.setVisibility(8);
            this.aXV.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aIq.setDefaultResource(com.baidu.tieba.u.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aIq.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aIq.c(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.aYm.setVisibility(8);
            this.aYo.setVisibility(8);
            this.aYp.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.aYm.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.aXY) {
                            if (chatMessage.isHasRead()) {
                                this.aYo.setVisibility(0);
                                this.aYp.setVisibility(8);
                                break;
                            } else {
                                this.aYo.setVisibility(8);
                                this.aYp.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.aYm.getVisibility() == 0) {
                this.aYm.setOnClickListener(new cd(this));
            }
            this.aXQ.setVisibility(8);
            fB(8);
            this.aXR.setVisibility(8);
            this.aXS.setVisibility(8);
            this.aXU.setVisibility(8);
            this.aXV.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.aXR.setVisibility(0);
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
