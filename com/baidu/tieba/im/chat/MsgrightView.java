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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class MsgrightView extends as {
    private static final String TAG = MsgrightView.class.getName();
    private ProgressBar aQj;
    private ImageButton bZU;
    protected TextView bZV;
    private TextView bZW;
    private TextView bZX;
    private HeadImageView bjG;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgright_view);
        initView();
        if (this.bZF != null && this.bZF.getImage() != null && (this.bZF.getImage() instanceof ChatClipImageItemView)) {
            this.bZF.getImage().setLeft(false);
        }
        this.bZV = (TextView) findViewById(t.g.img_msgitem_progressbar);
        this.aQj = (ProgressBar) findViewById(t.g.progress);
        this.bZU = (ImageButton) findViewById(t.g.btn_msgitem_resend);
        this.bjG = (HeadImageView) findViewById(t.g.img_msgitem_photo);
        this.bjG.setAutoChangeStyle(false);
        this.bjG.setDrawerType(1);
        this.bjG.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bjG.setOnClickListener(new bm(this));
        this.bZW = (TextView) findViewById(t.g.has_read);
        this.bZX = (TextView) findViewById(t.g.has_sent);
        this.bZC.setIsLeft(false);
        this.bZD.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.bZV.getVisibility() != 8) {
                this.bZV.setVisibility(8);
                this.bZF.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.bZV.getVisibility() != 8) {
                this.bZV.setVisibility(8);
                this.bZF.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.bZF.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(t.d.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.bZV.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.bZV.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bgh.setVisibility(8);
            this.aQj.setVisibility(8);
            this.bZU.setVisibility(8);
            this.bZW.setVisibility(8);
            this.bZX.setVisibility(8);
            this.bZy.setVisibility(0);
            this.bZy.setText(null);
            jm(8);
            this.bZF.getImage().setTag(null);
            this.bZz.setVisibility(8);
            this.bZz.setTag(null);
            this.bZC.setVisibility(8);
            this.bZD.setVisibility(8);
            this.bZE.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bjG.setDefaultResource(t.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bjG.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bjG.c(currentPortrait, 12, false);
                }
            }
            this.bjG.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.aQj.setVisibility(8);
            this.bZU.setVisibility(8);
            this.bZW.setVisibility(8);
            this.bZX.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.aQj.setVisibility(0);
                        break;
                    case 2:
                        this.bZU.setVisibility(0);
                        break;
                    case 3:
                        this.aQj.setVisibility(8);
                        if (this.bZH) {
                            if (chatMessage.isHasRead()) {
                                this.bZW.setVisibility(0);
                                this.bZX.setVisibility(8);
                                break;
                            } else {
                                this.bZW.setVisibility(8);
                                this.bZX.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.bZU.getVisibility() == 0) {
                this.bZU.setOnClickListener(new bn(this));
            }
            this.bZy.setVisibility(8);
            jm(8);
            this.bZz.setVisibility(8);
            this.bZA.setVisibility(8);
            this.bZD.setVisibility(8);
            this.bZC.setVisibility(8);
            this.bZE.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.bZz.setVisibility(0);
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
