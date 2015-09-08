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
    private HeadImageView aUc;
    private ImageButton bpm;
    protected TextView bpn;
    private TextView bpo;
    private TextView bpp;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgright_view);
        initView();
        if (this.boX != null && this.boX.getImage() != null && (this.boX.getImage() instanceof ChatClipImageItemView)) {
            this.boX.getImage().setLeft(false);
        }
        this.bpn = (TextView) findViewById(i.f.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.bpm = (ImageButton) findViewById(i.f.btn_msgitem_resend);
        this.aUc = (HeadImageView) findViewById(i.f.img_msgitem_photo);
        this.aUc.setAutoChangeStyle(false);
        this.aUc.setDrawerType(1);
        this.aUc.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aUc.setOnClickListener(new bk(this));
        this.bpo = (TextView) findViewById(i.f.has_read);
        this.bpp = (TextView) findViewById(i.f.has_sent);
        this.boV.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.bpn.getVisibility() != 8) {
                this.bpn.setVisibility(8);
                this.boX.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.bpn.getVisibility() != 8) {
                this.bpn.setVisibility(8);
                this.boX.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.boX.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(i.c.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.bpn.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.bpn.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.aQQ.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.bpm.setVisibility(8);
            this.bpo.setVisibility(8);
            this.bpp.setVisibility(8);
            this.boR.setVisibility(0);
            this.boR.setText(null);
            gD(8);
            this.boX.getImage().setTag(null);
            this.boS.setVisibility(8);
            this.boS.setTag(null);
            this.boV.setVisibility(8);
            this.boW.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aUc.setDefaultResource(i.e.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aUc.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aUc.d(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.bpm.setVisibility(8);
            this.bpo.setVisibility(8);
            this.bpp.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.bpm.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.boZ) {
                            if (chatMessage.isHasRead()) {
                                this.bpo.setVisibility(0);
                                this.bpp.setVisibility(8);
                                break;
                            } else {
                                this.bpo.setVisibility(8);
                                this.bpp.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.bpm.getVisibility() == 0) {
                this.bpm.setOnClickListener(new bl(this));
            }
            this.boR.setVisibility(8);
            gD(8);
            this.boS.setVisibility(8);
            this.boT.setVisibility(8);
            this.boV.setVisibility(8);
            this.boW.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.boS.setVisibility(0);
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
