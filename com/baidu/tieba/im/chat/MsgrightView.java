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
    private ImageButton bLO;
    protected TextView bLP;
    private TextView bLQ;
    private TextView bLR;
    private HeadImageView bcC;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, n.h.msg_msgright_view);
        initView();
        if (this.bLz != null && this.bLz.getImage() != null && (this.bLz.getImage() instanceof ChatClipImageItemView)) {
            this.bLz.getImage().setLeft(false);
        }
        this.bLP = (TextView) findViewById(n.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(n.g.progress);
        this.bLO = (ImageButton) findViewById(n.g.btn_msgitem_resend);
        this.bcC = (HeadImageView) findViewById(n.g.img_msgitem_photo);
        this.bcC.setAutoChangeStyle(false);
        this.bcC.setDrawerType(1);
        this.bcC.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bcC.setOnClickListener(new bm(this));
        this.bLQ = (TextView) findViewById(n.g.has_read);
        this.bLR = (TextView) findViewById(n.g.has_sent);
        this.bLw.setIsLeft(false);
        this.bLx.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.bLP.getVisibility() != 8) {
                this.bLP.setVisibility(8);
                this.bLz.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.bLP.getVisibility() != 8) {
                this.bLP.setVisibility(8);
                this.bLz.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.bLz.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(n.d.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.bLP.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.bLP.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.aZi.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.bLO.setVisibility(8);
            this.bLQ.setVisibility(8);
            this.bLR.setVisibility(8);
            this.bLs.setVisibility(0);
            this.bLs.setText(null);
            ii(8);
            this.bLz.getImage().setTag(null);
            this.bLt.setVisibility(8);
            this.bLt.setTag(null);
            this.bLw.setVisibility(8);
            this.bLx.setVisibility(8);
            this.bLy.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bcC.setDefaultResource(n.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bcC.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bcC.d(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.bLO.setVisibility(8);
            this.bLQ.setVisibility(8);
            this.bLR.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.bLO.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.bLB) {
                            if (chatMessage.isHasRead()) {
                                this.bLQ.setVisibility(0);
                                this.bLR.setVisibility(8);
                                break;
                            } else {
                                this.bLQ.setVisibility(8);
                                this.bLR.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.bLO.getVisibility() == 0) {
                this.bLO.setOnClickListener(new bn(this));
            }
            this.bLs.setVisibility(8);
            ii(8);
            this.bLt.setVisibility(8);
            this.bLu.setVisibility(8);
            this.bLx.setVisibility(8);
            this.bLw.setVisibility(8);
            this.bLy.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.bLt.setVisibility(0);
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
