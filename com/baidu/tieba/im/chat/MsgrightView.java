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
    private HeadImageView aTr;
    private ImageButton btb;
    protected TextView btc;
    private TextView btd;
    private TextView bte;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgright_view);
        initView();
        if (this.bsM != null && this.bsM.getImage() != null && (this.bsM.getImage() instanceof ChatClipImageItemView)) {
            this.bsM.getImage().setLeft(false);
        }
        this.btc = (TextView) findViewById(i.f.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.btb = (ImageButton) findViewById(i.f.btn_msgitem_resend);
        this.aTr = (HeadImageView) findViewById(i.f.img_msgitem_photo);
        this.aTr.setAutoChangeStyle(false);
        this.aTr.setDrawerType(1);
        this.aTr.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aTr.setOnClickListener(new bm(this));
        this.btd = (TextView) findViewById(i.f.has_read);
        this.bte = (TextView) findViewById(i.f.has_sent);
        this.bsJ.setIsLeft(false);
        this.bsK.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.btc.getVisibility() != 8) {
                this.btc.setVisibility(8);
                this.bsM.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.btc.getVisibility() != 8) {
                this.btc.setVisibility(8);
                this.bsM.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.bsM.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(i.c.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.btc.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.btc.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.aQf.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.btb.setVisibility(8);
            this.btd.setVisibility(8);
            this.bte.setVisibility(8);
            this.bsF.setVisibility(0);
            this.bsF.setText(null);
            gW(8);
            this.bsM.getImage().setTag(null);
            this.bsG.setVisibility(8);
            this.bsG.setTag(null);
            this.bsJ.setVisibility(8);
            this.bsK.setVisibility(8);
            this.bsL.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aTr.setDefaultResource(i.e.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aTr.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aTr.d(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.btb.setVisibility(8);
            this.btd.setVisibility(8);
            this.bte.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.btb.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.bsO) {
                            if (chatMessage.isHasRead()) {
                                this.btd.setVisibility(0);
                                this.bte.setVisibility(8);
                                break;
                            } else {
                                this.btd.setVisibility(8);
                                this.bte.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.btb.getVisibility() == 0) {
                this.btb.setOnClickListener(new bn(this));
            }
            this.bsF.setVisibility(8);
            gW(8);
            this.bsG.setVisibility(8);
            this.bsH.setVisibility(8);
            this.bsK.setVisibility(8);
            this.bsJ.setVisibility(8);
            this.bsL.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.bsG.setVisibility(0);
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
