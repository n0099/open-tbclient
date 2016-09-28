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
public class MsgrightView extends as {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView bSk;
    private TextView cVA;
    private ImageButton cVx;
    protected TextView cVy;
    private TextView cVz;
    private ProgressBar coW;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.h.msg_msgright_view);
        initView();
        if (this.cVi != null && this.cVi.getImage() != null && (this.cVi.getImage() instanceof ChatClipImageItemView)) {
            this.cVi.getImage().setLeft(false);
        }
        this.cVy = (TextView) findViewById(r.g.img_msgitem_progressbar);
        this.coW = (ProgressBar) findViewById(r.g.progress);
        this.cVx = (ImageButton) findViewById(r.g.btn_msgitem_resend);
        this.bSk = (HeadImageView) findViewById(r.g.img_msgitem_photo);
        this.bSk.setAutoChangeStyle(false);
        this.bSk.setDrawerType(1);
        this.bSk.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bSk.setOnClickListener(new bn(this));
        this.cVz = (TextView) findViewById(r.g.has_read);
        this.cVA = (TextView) findViewById(r.g.has_sent);
        this.cVf.setIsLeft(false);
        this.cVg.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cVy.getVisibility() != 8) {
                this.cVy.setVisibility(8);
                this.cVi.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cVy.getVisibility() != 8) {
                this.cVy.setVisibility(8);
                this.cVi.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cVi.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(r.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cVy.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cVy.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bLI.setVisibility(8);
            this.coW.setVisibility(8);
            this.cVx.setVisibility(8);
            this.cVz.setVisibility(8);
            this.cVA.setVisibility(8);
            this.cVb.setVisibility(0);
            this.cVb.setText(null);
            li(8);
            this.cVi.getImage().setTag(null);
            this.cVc.setVisibility(8);
            this.cVc.setTag(null);
            this.cVf.setVisibility(8);
            this.cVg.setVisibility(8);
            this.cVh.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bSk.setDefaultResource(r.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bSk.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bSk.c(currentPortrait, 12, false);
                }
            }
            this.bSk.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.coW.setVisibility(8);
            this.cVx.setVisibility(8);
            this.cVz.setVisibility(8);
            this.cVA.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.coW.setVisibility(0);
                        break;
                    case 2:
                        this.cVx.setVisibility(0);
                        break;
                    case 3:
                        this.coW.setVisibility(8);
                        if (this.cVk) {
                            if (chatMessage.isHasRead()) {
                                this.cVz.setVisibility(0);
                                this.cVA.setVisibility(8);
                                break;
                            } else {
                                this.cVz.setVisibility(8);
                                this.cVA.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cVx.getVisibility() == 0) {
                this.cVx.setOnClickListener(new bo(this));
            }
            this.cVb.setVisibility(8);
            li(8);
            this.cVc.setVisibility(8);
            this.cVd.setVisibility(8);
            this.cVg.setVisibility(8);
            this.cVf.setVisibility(8);
            this.cVh.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cVc.setVisibility(0);
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
