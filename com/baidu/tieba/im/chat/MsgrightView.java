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
/* loaded from: classes.dex */
public class MsgrightView extends az {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView aBo;
    private ImageButton aRp;
    protected TextView aRq;
    private TextView aRr;
    private TextView aRs;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_msgright_view);
        initView();
        if (this.aRf != null && this.aRf.getImage() != null && (this.aRf.getImage() instanceof ChatClipImageItemView)) {
            this.aRf.getImage().setLeft(false);
        }
        this.aRq = (TextView) findViewById(com.baidu.tieba.w.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.aRp = (ImageButton) findViewById(com.baidu.tieba.w.btn_msgitem_resend);
        this.aBo = (HeadImageView) findViewById(com.baidu.tieba.w.img_msgitem_photo);
        this.aBo.setAutoChangeStyle(false);
        this.aBo.setDrawerType(1);
        this.aBo.setRadius(com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 4.0f));
        this.aBo.setOnClickListener(new bq(this));
        this.aRr = (TextView) findViewById(com.baidu.tieba.w.has_read);
        this.aRs = (TextView) findViewById(com.baidu.tieba.w.has_sent);
        this.aRd.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.az
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.aRq.getVisibility() != 8) {
                this.aRq.setVisibility(8);
                this.aRf.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.aRq.getVisibility() != 8) {
                this.aRq.setVisibility(8);
                this.aRf.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.aRf.getImage().setColorFilter(TbadkCoreApplication.m255getInst().getApp().getResources().getColor(com.baidu.tieba.t.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.aRq.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.aRq.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.az
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.axA.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.aRp.setVisibility(8);
            this.aRr.setVisibility(8);
            this.aRs.setVisibility(8);
            this.aQZ.setVisibility(0);
            this.aQZ.setText(null);
            ft(8);
            this.aRf.getImage().setTag(null);
            this.aRa.setVisibility(8);
            this.aRa.setTag(null);
            this.aRd.setVisibility(8);
            this.aRe.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aBo.setDefaultResource(com.baidu.tieba.v.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aBo.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aBo.d(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.aRp.setVisibility(8);
            this.aRr.setVisibility(8);
            this.aRs.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.aRp.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.aRh) {
                            if (chatMessage.isHasRead()) {
                                this.aRr.setVisibility(0);
                                this.aRs.setVisibility(8);
                                break;
                            } else {
                                this.aRr.setVisibility(8);
                                this.aRs.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.aRp.getVisibility() == 0) {
                this.aRp.setOnClickListener(new br(this));
            }
            this.aQZ.setVisibility(8);
            ft(8);
            this.aRa.setVisibility(8);
            this.aRb.setVisibility(8);
            this.aRd.setVisibility(8);
            this.aRe.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.aRa.setVisibility(0);
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
