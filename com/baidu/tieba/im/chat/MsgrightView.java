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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class MsgrightView extends ar {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView bWb;
    private ImageButton cQd;
    protected TextView cQe;
    private TextView cQf;
    private TextView cQg;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgright_view);
        initView();
        if (this.cPP != null && this.cPP.getImage() != null && (this.cPP.getImage() instanceof ChatClipImageItemView)) {
            this.cPP.getImage().setLeft(false);
        }
        this.cQe = (TextView) findViewById(w.h.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.cQd = (ImageButton) findViewById(w.h.btn_msgitem_resend);
        this.bWb = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.bWb.setAutoChangeStyle(false);
        this.bWb.setDrawerType(1);
        this.bWb.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bWb.setOnClickListener(new bm(this));
        this.cQf = (TextView) findViewById(w.h.has_read);
        this.cQg = (TextView) findViewById(w.h.has_sent);
        this.cPM.setIsLeft(false);
        this.cPN.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cQe.getVisibility() != 8) {
                this.cQe.setVisibility(8);
                this.cPP.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cQe.getVisibility() != 8) {
                this.cQe.setVisibility(8);
                this.cPP.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cPP.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(w.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cQe.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cQe.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bQv.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.cQd.setVisibility(8);
            this.cQf.setVisibility(8);
            this.cQg.setVisibility(8);
            this.cPI.setVisibility(0);
            this.cPI.setText(null);
            lr(8);
            this.cPP.getImage().setTag(null);
            this.cPJ.setVisibility(8);
            this.cPJ.setTag(null);
            this.cPM.setVisibility(8);
            this.cPN.setVisibility(8);
            this.cPO.setVisibility(8);
            return;
        }
        try {
            d(chatMessage);
            this.bWb.setDefaultResource(w.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bWb.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bWb.c(currentPortrait, 12, false);
                }
            }
            this.bWb.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.cQd.setVisibility(8);
            this.cQf.setVisibility(8);
            this.cQg.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.cQd.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.cPR) {
                            if (chatMessage.isHasRead()) {
                                this.cQf.setVisibility(0);
                                this.cQg.setVisibility(8);
                                break;
                            } else {
                                this.cQf.setVisibility(8);
                                this.cQg.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cQd.getVisibility() == 0) {
                this.cQd.setOnClickListener(new bn(this));
            }
            this.cPI.setVisibility(8);
            lr(8);
            this.cPJ.setVisibility(8);
            this.cPK.setVisibility(8);
            this.cPN.setVisibility(8);
            this.cPM.setVisibility(8);
            this.cPO.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cPJ.setVisibility(0);
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
