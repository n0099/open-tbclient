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
    private HeadImageView aTj;
    private TextView bsA;
    private ImageButton bsx;
    protected TextView bsy;
    private TextView bsz;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgright_view);
        initView();
        if (this.bsi != null && this.bsi.getImage() != null && (this.bsi.getImage() instanceof ChatClipImageItemView)) {
            this.bsi.getImage().setLeft(false);
        }
        this.bsy = (TextView) findViewById(i.f.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.bsx = (ImageButton) findViewById(i.f.btn_msgitem_resend);
        this.aTj = (HeadImageView) findViewById(i.f.img_msgitem_photo);
        this.aTj.setAutoChangeStyle(false);
        this.aTj.setDrawerType(1);
        this.aTj.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aTj.setOnClickListener(new bm(this));
        this.bsz = (TextView) findViewById(i.f.has_read);
        this.bsA = (TextView) findViewById(i.f.has_sent);
        this.bsf.setIsLeft(false);
        this.bsg.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.bsy.getVisibility() != 8) {
                this.bsy.setVisibility(8);
                this.bsi.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.bsy.getVisibility() != 8) {
                this.bsy.setVisibility(8);
                this.bsi.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.bsi.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(i.c.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.bsy.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.bsy.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.aPX.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.bsx.setVisibility(8);
            this.bsz.setVisibility(8);
            this.bsA.setVisibility(8);
            this.bsb.setVisibility(0);
            this.bsb.setText(null);
            gJ(8);
            this.bsi.getImage().setTag(null);
            this.bsc.setVisibility(8);
            this.bsc.setTag(null);
            this.bsf.setVisibility(8);
            this.bsg.setVisibility(8);
            this.bsh.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aTj.setDefaultResource(i.e.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aTj.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aTj.d(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.bsx.setVisibility(8);
            this.bsz.setVisibility(8);
            this.bsA.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.bsx.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.bsk) {
                            if (chatMessage.isHasRead()) {
                                this.bsz.setVisibility(0);
                                this.bsA.setVisibility(8);
                                break;
                            } else {
                                this.bsz.setVisibility(8);
                                this.bsA.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.bsx.getVisibility() == 0) {
                this.bsx.setOnClickListener(new bn(this));
            }
            this.bsb.setVisibility(8);
            gJ(8);
            this.bsc.setVisibility(8);
            this.bsd.setVisibility(8);
            this.bsg.setVisibility(8);
            this.bsf.setVisibility(8);
            this.bsh.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.bsc.setVisibility(0);
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
