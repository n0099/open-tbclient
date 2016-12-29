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
    private HeadImageView bAJ;
    private ProgressBar ban;
    private ImageButton cGs;
    protected TextView cGt;
    private TextView cGu;
    private TextView cGv;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.h.msg_msgright_view);
        initView();
        if (this.cGd != null && this.cGd.getImage() != null && (this.cGd.getImage() instanceof ChatClipImageItemView)) {
            this.cGd.getImage().setLeft(false);
        }
        this.cGt = (TextView) findViewById(r.g.img_msgitem_progressbar);
        this.ban = (ProgressBar) findViewById(r.g.progress);
        this.cGs = (ImageButton) findViewById(r.g.btn_msgitem_resend);
        this.bAJ = (HeadImageView) findViewById(r.g.img_msgitem_photo);
        this.bAJ.setAutoChangeStyle(false);
        this.bAJ.setDrawerType(1);
        this.bAJ.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bAJ.setOnClickListener(new bn(this));
        this.cGu = (TextView) findViewById(r.g.has_read);
        this.cGv = (TextView) findViewById(r.g.has_sent);
        this.cGa.setIsLeft(false);
        this.cGb.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cGt.getVisibility() != 8) {
                this.cGt.setVisibility(8);
                this.cGd.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cGt.getVisibility() != 8) {
                this.cGt.setVisibility(8);
                this.cGd.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cGd.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(r.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cGt.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cGt.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.buG.setVisibility(8);
            this.ban.setVisibility(8);
            this.cGs.setVisibility(8);
            this.cGu.setVisibility(8);
            this.cGv.setVisibility(8);
            this.cFW.setVisibility(0);
            this.cFW.setText(null);
            kA(8);
            this.cGd.getImage().setTag(null);
            this.cFX.setVisibility(8);
            this.cFX.setTag(null);
            this.cGa.setVisibility(8);
            this.cGb.setVisibility(8);
            this.cGc.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bAJ.setDefaultResource(r.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bAJ.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bAJ.c(currentPortrait, 12, false);
                }
            }
            this.bAJ.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.ban.setVisibility(8);
            this.cGs.setVisibility(8);
            this.cGu.setVisibility(8);
            this.cGv.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.ban.setVisibility(0);
                        break;
                    case 2:
                        this.cGs.setVisibility(0);
                        break;
                    case 3:
                        this.ban.setVisibility(8);
                        if (this.cGf) {
                            if (chatMessage.isHasRead()) {
                                this.cGu.setVisibility(0);
                                this.cGv.setVisibility(8);
                                break;
                            } else {
                                this.cGu.setVisibility(8);
                                this.cGv.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cGs.getVisibility() == 0) {
                this.cGs.setOnClickListener(new bo(this));
            }
            this.cFW.setVisibility(8);
            kA(8);
            this.cFX.setVisibility(8);
            this.cFY.setVisibility(8);
            this.cGb.setVisibility(8);
            this.cGa.setVisibility(8);
            this.cGc.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cFX.setVisibility(0);
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
