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
    private ProgressBar aNo;
    private ImageButton bPC;
    protected TextView bPD;
    private TextView bPE;
    private TextView bPF;
    private HeadImageView beU;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgright_view);
        initView();
        if (this.bPn != null && this.bPn.getImage() != null && (this.bPn.getImage() instanceof ChatClipImageItemView)) {
            this.bPn.getImage().setLeft(false);
        }
        this.bPD = (TextView) findViewById(t.g.img_msgitem_progressbar);
        this.aNo = (ProgressBar) findViewById(t.g.progress);
        this.bPC = (ImageButton) findViewById(t.g.btn_msgitem_resend);
        this.beU = (HeadImageView) findViewById(t.g.img_msgitem_photo);
        this.beU.setAutoChangeStyle(false);
        this.beU.setDrawerType(1);
        this.beU.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.beU.setOnClickListener(new bm(this));
        this.bPE = (TextView) findViewById(t.g.has_read);
        this.bPF = (TextView) findViewById(t.g.has_sent);
        this.bPk.setIsLeft(false);
        this.bPl.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.bPD.getVisibility() != 8) {
                this.bPD.setVisibility(8);
                this.bPn.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.bPD.getVisibility() != 8) {
                this.bPD.setVisibility(8);
                this.bPn.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.bPn.getImage().setColorFilter(TbadkCoreApplication.m411getInst().getApp().getResources().getColor(t.d.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.bPD.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.bPD.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bbx.setVisibility(8);
            this.aNo.setVisibility(8);
            this.bPC.setVisibility(8);
            this.bPE.setVisibility(8);
            this.bPF.setVisibility(8);
            this.bPg.setVisibility(0);
            this.bPg.setText(null);
            iF(8);
            this.bPn.getImage().setTag(null);
            this.bPh.setVisibility(8);
            this.bPh.setTag(null);
            this.bPk.setVisibility(8);
            this.bPl.setVisibility(8);
            this.bPm.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.beU.setDefaultResource(t.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.beU.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.beU.d(currentPortrait, 12, false);
                }
            }
            this.aNo.setVisibility(8);
            this.bPC.setVisibility(8);
            this.bPE.setVisibility(8);
            this.bPF.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.aNo.setVisibility(0);
                        break;
                    case 2:
                        this.bPC.setVisibility(0);
                        break;
                    case 3:
                        this.aNo.setVisibility(8);
                        if (this.bPp) {
                            if (chatMessage.isHasRead()) {
                                this.bPE.setVisibility(0);
                                this.bPF.setVisibility(8);
                                break;
                            } else {
                                this.bPE.setVisibility(8);
                                this.bPF.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.bPC.getVisibility() == 0) {
                this.bPC.setOnClickListener(new bn(this));
            }
            this.bPg.setVisibility(8);
            iF(8);
            this.bPh.setVisibility(8);
            this.bPi.setVisibility(8);
            this.bPl.setVisibility(8);
            this.bPk.setVisibility(8);
            this.bPm.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.bPh.setVisibility(0);
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
