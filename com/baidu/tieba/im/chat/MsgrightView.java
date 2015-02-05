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
public class MsgrightView extends bc {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView aCm;
    private TextView aSA;
    private ImageButton aSx;
    protected TextView aSy;
    private TextView aSz;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.x.msg_msgright_view);
        initView();
        if (this.aSn != null && this.aSn.getImage() != null && (this.aSn.getImage() instanceof ChatClipImageItemView)) {
            this.aSn.getImage().setLeft(false);
        }
        this.aSy = (TextView) findViewById(com.baidu.tieba.w.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.aSx = (ImageButton) findViewById(com.baidu.tieba.w.btn_msgitem_resend);
        this.aCm = (HeadImageView) findViewById(com.baidu.tieba.w.img_msgitem_photo);
        this.aCm.setAutoChangeStyle(false);
        this.aCm.setDrawerType(1);
        this.aCm.setRadius(com.baidu.adp.lib.util.l.dip2px(this.mContext.getContext(), 4.0f));
        this.aCm.setOnClickListener(new bt(this));
        this.aSz = (TextView) findViewById(com.baidu.tieba.w.has_read);
        this.aSA = (TextView) findViewById(com.baidu.tieba.w.has_sent);
        this.aSl.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.bc
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.aSy.getVisibility() != 8) {
                this.aSy.setVisibility(8);
                this.aSn.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.aSy.getVisibility() != 8) {
                this.aSy.setVisibility(8);
                this.aSn.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.aSn.getImage().setColorFilter(TbadkCoreApplication.m255getInst().getApp().getResources().getColor(com.baidu.tieba.t.image_uploading_cover), PorterDuff.Mode.SRC_ATOP);
            this.aSy.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.aSy.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.bc
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.ayx.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.aSx.setVisibility(8);
            this.aSz.setVisibility(8);
            this.aSA.setVisibility(8);
            this.aSh.setVisibility(0);
            this.aSh.setText(null);
            fy(8);
            this.aSn.getImage().setTag(null);
            this.aSi.setVisibility(8);
            this.aSi.setTag(null);
            this.aSl.setVisibility(8);
            this.aSm.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.aCm.setDefaultResource(com.baidu.tieba.v.photo);
            if (chatMessage.getUserInfo() != null) {
                this.aCm.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.aCm.d(currentPortrait, 12, false);
                }
            }
            this.mProgress.setVisibility(8);
            this.aSx.setVisibility(8);
            this.aSz.setVisibility(8);
            this.aSA.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.aSx.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.aSp) {
                            if (chatMessage.isHasRead()) {
                                this.aSz.setVisibility(0);
                                this.aSA.setVisibility(8);
                                break;
                            } else {
                                this.aSz.setVisibility(8);
                                this.aSA.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.aSx.getVisibility() == 0) {
                this.aSx.setOnClickListener(new bu(this));
            }
            this.aSh.setVisibility(8);
            fy(8);
            this.aSi.setVisibility(8);
            this.aSj.setVisibility(8);
            this.aSl.setVisibility(8);
            this.aSm.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.aSi.setVisibility(0);
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
