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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class MsgrightView extends as {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView bBS;
    private ImageButton cFJ;
    protected TextView cFK;
    private TextView cFL;
    private TextView cFM;
    private ProgressBar cbl;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, u.h.msg_msgright_view);
        initView();
        if (this.cFu != null && this.cFu.getImage() != null && (this.cFu.getImage() instanceof ChatClipImageItemView)) {
            this.cFu.getImage().setLeft(false);
        }
        this.cFK = (TextView) findViewById(u.g.img_msgitem_progressbar);
        this.cbl = (ProgressBar) findViewById(u.g.progress);
        this.cFJ = (ImageButton) findViewById(u.g.btn_msgitem_resend);
        this.bBS = (HeadImageView) findViewById(u.g.img_msgitem_photo);
        this.bBS.setAutoChangeStyle(false);
        this.bBS.setDrawerType(1);
        this.bBS.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bBS.setOnClickListener(new bn(this));
        this.cFL = (TextView) findViewById(u.g.has_read);
        this.cFM = (TextView) findViewById(u.g.has_sent);
        this.cFr.setIsLeft(false);
        this.cFs.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cFK.getVisibility() != 8) {
                this.cFK.setVisibility(8);
                this.cFu.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cFK.getVisibility() != 8) {
                this.cFK.setVisibility(8);
                this.cFu.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cFu.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(u.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cFK.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cFK.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bxR.setVisibility(8);
            this.cbl.setVisibility(8);
            this.cFJ.setVisibility(8);
            this.cFL.setVisibility(8);
            this.cFM.setVisibility(8);
            this.cFn.setVisibility(0);
            this.cFn.setText(null);
            kr(8);
            this.cFu.getImage().setTag(null);
            this.cFo.setVisibility(8);
            this.cFo.setTag(null);
            this.cFr.setVisibility(8);
            this.cFs.setVisibility(8);
            this.cFt.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bBS.setDefaultResource(u.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bBS.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bBS.c(currentPortrait, 12, false);
                }
            }
            this.bBS.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cbl.setVisibility(8);
            this.cFJ.setVisibility(8);
            this.cFL.setVisibility(8);
            this.cFM.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.cbl.setVisibility(0);
                        break;
                    case 2:
                        this.cFJ.setVisibility(0);
                        break;
                    case 3:
                        this.cbl.setVisibility(8);
                        if (this.cFw) {
                            if (chatMessage.isHasRead()) {
                                this.cFL.setVisibility(0);
                                this.cFM.setVisibility(8);
                                break;
                            } else {
                                this.cFL.setVisibility(8);
                                this.cFM.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cFJ.getVisibility() == 0) {
                this.cFJ.setOnClickListener(new bo(this));
            }
            this.cFn.setVisibility(8);
            kr(8);
            this.cFo.setVisibility(8);
            this.cFp.setVisibility(8);
            this.cFs.setVisibility(8);
            this.cFr.setVisibility(8);
            this.cFt.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cFo.setVisibility(0);
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
