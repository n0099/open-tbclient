package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends as {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView aSY;
    private ImageButton bsm;
    protected TextView bsn;
    private TextView bso;
    private TextView bsp;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgright_view);
        initView();
        if (this.brX != null && this.brX.getImage() != null && (this.brX.getImage() instanceof ChatClipImageItemView)) {
            this.brX.getImage().setLeft(false);
        }
        this.bsn = (TextView) findViewById(i.f.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.bsm = (ImageButton) findViewById(i.f.btn_msgitem_resend);
        this.aSY = (HeadImageView) findViewById(i.f.img_msgitem_photo);
        this.aSY.setAutoChangeStyle(false);
        this.aSY.setDrawerType(1);
        this.aSY.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aSY.setOnClickListener(new bm(this));
        this.bso = (TextView) findViewById(i.f.has_read);
        this.bsp = (TextView) findViewById(i.f.has_sent);
        this.brU.setIsLeft(false);
        this.brV.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.bsn.getVisibility() != 8) {
                this.bsn.setVisibility(8);
                this.brX.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.bsn.getVisibility() != 8) {
                this.bsn.setVisibility(8);
                this.brX.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.brX.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(i.c.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.bsn.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.bsn.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.aPM.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.bsm.setVisibility(8);
            this.bso.setVisibility(8);
            this.bsp.setVisibility(8);
            this.brQ.setVisibility(0);
            this.brQ.setText(null);
            gJ(8);
            this.brX.getImage().setTag(null);
            this.brR.setVisibility(8);
            this.brR.setTag(null);
            this.brU.setVisibility(8);
            this.brV.setVisibility(8);
            this.brW.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aSY.setDefaultResource(i.e.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aSY.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aSY.d(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.bsm.setVisibility(8);
            this.bso.setVisibility(8);
            this.bsp.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.bsm.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.brZ) {
                            if (chatMessage.isHasRead()) {
                                this.bso.setVisibility(0);
                                this.bsp.setVisibility(8);
                                break;
                            } else {
                                this.bso.setVisibility(8);
                                this.bsp.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.bsm.getVisibility() == 0) {
                this.bsm.setOnClickListener(new bn(this));
            }
            this.brQ.setVisibility(8);
            gJ(8);
            this.brR.setVisibility(8);
            this.brS.setVisibility(8);
            this.brV.setVisibility(8);
            this.brU.setVisibility(8);
            this.brW.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.brR.setVisibility(0);
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
