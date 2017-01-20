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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class MsgrightView extends ar {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView bIe;
    private ProgressBar bkd;
    private ImageButton cNA;
    protected TextView cNB;
    private TextView cNC;
    private TextView cND;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.j.msg_msgright_view);
        initView();
        if (this.cNm != null && this.cNm.getImage() != null && (this.cNm.getImage() instanceof ChatClipImageItemView)) {
            this.cNm.getImage().setLeft(false);
        }
        this.cNB = (TextView) findViewById(r.h.img_msgitem_progressbar);
        this.bkd = (ProgressBar) findViewById(r.h.progress);
        this.cNA = (ImageButton) findViewById(r.h.btn_msgitem_resend);
        this.bIe = (HeadImageView) findViewById(r.h.img_msgitem_photo);
        this.bIe.setAutoChangeStyle(false);
        this.bIe.setDrawerType(1);
        this.bIe.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bIe.setOnClickListener(new bm(this));
        this.cNC = (TextView) findViewById(r.h.has_read);
        this.cND = (TextView) findViewById(r.h.has_sent);
        this.cNj.setIsLeft(false);
        this.cNk.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cNB.getVisibility() != 8) {
                this.cNB.setVisibility(8);
                this.cNm.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cNB.getVisibility() != 8) {
                this.cNB.setVisibility(8);
                this.cNm.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cNm.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(r.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cNB.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cNB.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bCn.setVisibility(8);
            this.bkd.setVisibility(8);
            this.cNA.setVisibility(8);
            this.cNC.setVisibility(8);
            this.cND.setVisibility(8);
            this.cNf.setVisibility(0);
            this.cNf.setText(null);
            ln(8);
            this.cNm.getImage().setTag(null);
            this.cNg.setVisibility(8);
            this.cNg.setTag(null);
            this.cNj.setVisibility(8);
            this.cNk.setVisibility(8);
            this.cNl.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bIe.setDefaultResource(r.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bIe.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bIe.c(currentPortrait, 12, false);
                }
            }
            this.bIe.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.bkd.setVisibility(8);
            this.cNA.setVisibility(8);
            this.cNC.setVisibility(8);
            this.cND.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.bkd.setVisibility(0);
                        break;
                    case 2:
                        this.cNA.setVisibility(0);
                        break;
                    case 3:
                        this.bkd.setVisibility(8);
                        if (this.cNo) {
                            if (chatMessage.isHasRead()) {
                                this.cNC.setVisibility(0);
                                this.cND.setVisibility(8);
                                break;
                            } else {
                                this.cNC.setVisibility(8);
                                this.cND.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cNA.getVisibility() == 0) {
                this.cNA.setOnClickListener(new bn(this));
            }
            this.cNf.setVisibility(8);
            ln(8);
            this.cNg.setVisibility(8);
            this.cNh.setVisibility(8);
            this.cNk.setVisibility(8);
            this.cNj.setVisibility(8);
            this.cNl.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cNg.setVisibility(0);
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
