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
    private HeadImageView aKz;
    private ImageButton baU;
    protected TextView baV;
    private TextView baW;
    private TextView baX;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.r.msg_msgright_view);
        initView();
        if (this.baE != null && this.baE.getImage() != null && (this.baE.getImage() instanceof ChatClipImageItemView)) {
            this.baE.getImage().setLeft(false);
        }
        this.baV = (TextView) findViewById(com.baidu.tieba.q.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.q.progress);
        this.baU = (ImageButton) findViewById(com.baidu.tieba.q.btn_msgitem_resend);
        this.aKz = (HeadImageView) findViewById(com.baidu.tieba.q.img_msgitem_photo);
        this.aKz.setAutoChangeStyle(false);
        this.aKz.setDrawerType(1);
        this.aKz.setRadius(com.baidu.adp.lib.util.n.dip2px(this.mContext.getContext(), 4.0f));
        this.aKz.setOnClickListener(new cc(this));
        this.baW = (TextView) findViewById(com.baidu.tieba.q.has_read);
        this.baX = (TextView) findViewById(com.baidu.tieba.q.has_sent);
        this.baC.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.baV.getVisibility() != 8) {
                this.baV.setVisibility(8);
                this.baE.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.baV.getVisibility() != 8) {
                this.baV.setVisibility(8);
                this.baE.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.baE.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(com.baidu.tieba.n.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.baV.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.baV.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.bk
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.aJb.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.baU.setVisibility(8);
            this.baW.setVisibility(8);
            this.baX.setVisibility(8);
            this.bay.setVisibility(0);
            this.bay.setText(null);
            fS(8);
            this.baE.getImage().setTag(null);
            this.baz.setVisibility(8);
            this.baz.setTag(null);
            this.baC.setVisibility(8);
            this.baD.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aKz.setDefaultResource(com.baidu.tieba.p.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aKz.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aKz.c(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.baU.setVisibility(8);
            this.baW.setVisibility(8);
            this.baX.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.baU.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.baG) {
                            if (chatMessage.isHasRead()) {
                                this.baW.setVisibility(0);
                                this.baX.setVisibility(8);
                                break;
                            } else {
                                this.baW.setVisibility(8);
                                this.baX.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.baU.getVisibility() == 0) {
                this.baU.setOnClickListener(new cd(this));
            }
            this.bay.setVisibility(8);
            fS(8);
            this.baz.setVisibility(8);
            this.baA.setVisibility(8);
            this.baC.setVisibility(8);
            this.baD.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.baz.setVisibility(0);
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
