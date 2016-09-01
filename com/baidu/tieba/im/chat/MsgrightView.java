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
    private HeadImageView bSr;
    private ImageButton cUd;
    protected TextView cUe;
    private TextView cUf;
    private TextView cUg;
    private ProgressBar coz;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, t.h.msg_msgright_view);
        initView();
        if (this.cTO != null && this.cTO.getImage() != null && (this.cTO.getImage() instanceof ChatClipImageItemView)) {
            this.cTO.getImage().setLeft(false);
        }
        this.cUe = (TextView) findViewById(t.g.img_msgitem_progressbar);
        this.coz = (ProgressBar) findViewById(t.g.progress);
        this.cUd = (ImageButton) findViewById(t.g.btn_msgitem_resend);
        this.bSr = (HeadImageView) findViewById(t.g.img_msgitem_photo);
        this.bSr.setAutoChangeStyle(false);
        this.bSr.setDrawerType(1);
        this.bSr.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bSr.setOnClickListener(new bn(this));
        this.cUf = (TextView) findViewById(t.g.has_read);
        this.cUg = (TextView) findViewById(t.g.has_sent);
        this.cTL.setIsLeft(false);
        this.cTM.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cUe.getVisibility() != 8) {
                this.cUe.setVisibility(8);
                this.cTO.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cUe.getVisibility() != 8) {
                this.cUe.setVisibility(8);
                this.cTO.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cTO.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(t.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cUe.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cUe.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bLH.setVisibility(8);
            this.coz.setVisibility(8);
            this.cUd.setVisibility(8);
            this.cUf.setVisibility(8);
            this.cUg.setVisibility(8);
            this.cTH.setVisibility(0);
            this.cTH.setText(null);
            la(8);
            this.cTO.getImage().setTag(null);
            this.cTI.setVisibility(8);
            this.cTI.setTag(null);
            this.cTL.setVisibility(8);
            this.cTM.setVisibility(8);
            this.cTN.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bSr.setDefaultResource(t.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bSr.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bSr.c(currentPortrait, 12, false);
                }
            }
            this.bSr.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.coz.setVisibility(8);
            this.cUd.setVisibility(8);
            this.cUf.setVisibility(8);
            this.cUg.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.coz.setVisibility(0);
                        break;
                    case 2:
                        this.cUd.setVisibility(0);
                        break;
                    case 3:
                        this.coz.setVisibility(8);
                        if (this.cTQ) {
                            if (chatMessage.isHasRead()) {
                                this.cUf.setVisibility(0);
                                this.cUg.setVisibility(8);
                                break;
                            } else {
                                this.cUf.setVisibility(8);
                                this.cUg.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cUd.getVisibility() == 0) {
                this.cUd.setOnClickListener(new bo(this));
            }
            this.cTH.setVisibility(8);
            la(8);
            this.cTI.setVisibility(8);
            this.cTJ.setVisibility(8);
            this.cTM.setVisibility(8);
            this.cTL.setVisibility(8);
            this.cTN.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cTI.setVisibility(0);
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
