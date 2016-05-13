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
    private ProgressBar bDI;
    private HeadImageView bfG;
    protected TextView caA;
    private TextView caB;
    private TextView caC;
    private ImageButton caz;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgright_view);
        initView();
        if (this.cak != null && this.cak.getImage() != null && (this.cak.getImage() instanceof ChatClipImageItemView)) {
            this.cak.getImage().setLeft(false);
        }
        this.caA = (TextView) findViewById(t.g.img_msgitem_progressbar);
        this.bDI = (ProgressBar) findViewById(t.g.progress);
        this.caz = (ImageButton) findViewById(t.g.btn_msgitem_resend);
        this.bfG = (HeadImageView) findViewById(t.g.img_msgitem_photo);
        this.bfG.setAutoChangeStyle(false);
        this.bfG.setDrawerType(1);
        this.bfG.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bfG.setOnClickListener(new bm(this));
        this.caB = (TextView) findViewById(t.g.has_read);
        this.caC = (TextView) findViewById(t.g.has_sent);
        this.cah.setIsLeft(false);
        this.cai.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.caA.getVisibility() != 8) {
                this.caA.setVisibility(8);
                this.cak.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.caA.getVisibility() != 8) {
                this.caA.setVisibility(8);
                this.cak.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cak.getImage().setColorFilter(TbadkCoreApplication.m11getInst().getApp().getResources().getColor(t.d.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.caA.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.caA.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bbW.setVisibility(8);
            this.bDI.setVisibility(8);
            this.caz.setVisibility(8);
            this.caB.setVisibility(8);
            this.caC.setVisibility(8);
            this.cad.setVisibility(0);
            this.cad.setText(null);
            iP(8);
            this.cak.getImage().setTag(null);
            this.cae.setVisibility(8);
            this.cae.setTag(null);
            this.cah.setVisibility(8);
            this.cai.setVisibility(8);
            this.caj.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bfG.setDefaultResource(t.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bfG.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bfG.c(currentPortrait, 12, false);
                }
            }
            this.bfG.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.bDI.setVisibility(8);
            this.caz.setVisibility(8);
            this.caB.setVisibility(8);
            this.caC.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.bDI.setVisibility(0);
                        break;
                    case 2:
                        this.caz.setVisibility(0);
                        break;
                    case 3:
                        this.bDI.setVisibility(8);
                        if (this.cam) {
                            if (chatMessage.isHasRead()) {
                                this.caB.setVisibility(0);
                                this.caC.setVisibility(8);
                                break;
                            } else {
                                this.caB.setVisibility(8);
                                this.caC.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.caz.getVisibility() == 0) {
                this.caz.setOnClickListener(new bn(this));
            }
            this.cad.setVisibility(8);
            iP(8);
            this.cae.setVisibility(8);
            this.caf.setVisibility(8);
            this.cai.setVisibility(8);
            this.cah.setVisibility(8);
            this.caj.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cae.setVisibility(0);
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
