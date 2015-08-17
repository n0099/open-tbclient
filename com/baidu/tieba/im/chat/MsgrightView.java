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
    private HeadImageView aTO;
    private ImageButton boO;
    protected TextView boP;
    private TextView boQ;
    private TextView boR;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, i.g.msg_msgright_view);
        initView();
        if (this.boz != null && this.boz.getImage() != null && (this.boz.getImage() instanceof ChatClipImageItemView)) {
            this.boz.getImage().setLeft(false);
        }
        this.boP = (TextView) findViewById(i.f.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.boO = (ImageButton) findViewById(i.f.btn_msgitem_resend);
        this.aTO = (HeadImageView) findViewById(i.f.img_msgitem_photo);
        this.aTO.setAutoChangeStyle(false);
        this.aTO.setDrawerType(1);
        this.aTO.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.aTO.setOnClickListener(new bk(this));
        this.boQ = (TextView) findViewById(i.f.has_read);
        this.boR = (TextView) findViewById(i.f.has_sent);
        this.box.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.boP.getVisibility() != 8) {
                this.boP.setVisibility(8);
                this.boz.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.boP.getVisibility() != 8) {
                this.boP.setVisibility(8);
                this.boz.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.boz.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(i.c.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.boP.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.boP.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.aQC.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.boO.setVisibility(8);
            this.boQ.setVisibility(8);
            this.boR.setVisibility(8);
            this.bot.setVisibility(0);
            this.bot.setText(null);
            gt(8);
            this.boz.getImage().setTag(null);
            this.bou.setVisibility(8);
            this.bou.setTag(null);
            this.box.setVisibility(8);
            this.boy.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aTO.setDefaultResource(i.e.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aTO.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aTO.d(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.boO.setVisibility(8);
            this.boQ.setVisibility(8);
            this.boR.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.boO.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.boB) {
                            if (chatMessage.isHasRead()) {
                                this.boQ.setVisibility(0);
                                this.boR.setVisibility(8);
                                break;
                            } else {
                                this.boQ.setVisibility(8);
                                this.boR.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.boO.getVisibility() == 0) {
                this.boO.setOnClickListener(new bl(this));
            }
            this.bot.setVisibility(8);
            gt(8);
            this.bou.setVisibility(8);
            this.bov.setVisibility(8);
            this.box.setVisibility(8);
            this.boy.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.bou.setVisibility(0);
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
