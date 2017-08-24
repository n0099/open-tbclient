package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView clP;
    private ImageButton djW;
    protected TextView djX;
    private TextView djY;
    private TextView djZ;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgright_view);
        initView();
        if (this.djI != null && this.djI.getImage() != null && (this.djI.getImage() instanceof ChatClipImageItemView)) {
            this.djI.getImage().setLeft(false);
        }
        this.djX = (TextView) findViewById(d.h.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.djW = (ImageButton) findViewById(d.h.btn_msgitem_resend);
        this.clP = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.clP.setAutoChangeStyle(false);
        this.clP.setDrawerType(1);
        this.clP.setRadius(k.dip2px(this.mContext.getContext(), 4.0f));
        this.clP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.djd.a(view, 6, MsgrightView.this.awB, 0L);
            }
        });
        this.djY = (TextView) findViewById(d.h.has_read);
        this.djZ = (TextView) findViewById(d.h.has_sent);
        this.djF.setIsLeft(false);
        this.djG.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.djX.getVisibility() != 8) {
                this.djX.setVisibility(8);
                this.djI.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.djX.getVisibility() != 8) {
                this.djX.setVisibility(8);
                this.djI.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.djI.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.djX.setText(chatMessage.getProgressValue() + "%");
            this.djX.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.ceE.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.djW.setVisibility(8);
            this.djY.setVisibility(8);
            this.djZ.setVisibility(8);
            this.djB.setVisibility(0);
            this.djB.setText(null);
            lV(8);
            this.djI.getImage().setTag(null);
            this.djC.setVisibility(8);
            this.djC.setTag(null);
            this.djF.setVisibility(8);
            this.djG.setVisibility(8);
            this.djH.setVisibility(8);
            return;
        }
        try {
            e(chatMessage);
            this.clP.setDefaultResource(d.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.clP.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.clP.c(currentPortrait, 12, false);
                }
            }
            this.clP.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.djW.setVisibility(8);
            this.djY.setVisibility(8);
            this.djZ.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.djW.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.djK) {
                            if (chatMessage.isHasRead()) {
                                this.djY.setVisibility(0);
                                this.djZ.setVisibility(8);
                                break;
                            } else {
                                this.djY.setVisibility(8);
                                this.djZ.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.djW.getVisibility() == 0) {
                this.djW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.djd.a(view2, 1, MsgrightView.this.awB, 0L);
                    }
                });
            }
            this.djB.setVisibility(8);
            lV(8);
            this.djC.setVisibility(8);
            this.djD.setVisibility(8);
            this.djG.setVisibility(8);
            this.djF.setVisibility(8);
            this.djH.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.djC.setVisibility(0);
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
