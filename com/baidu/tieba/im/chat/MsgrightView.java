package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView dGO;
    private ImageButton ewJ;
    protected TextView ewK;
    private TextView ewL;
    private TextView ewM;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.ewu != null && this.ewu.getImage() != null && (this.ewu.getImage() instanceof ChatClipImageItemView)) {
            this.ewu.getImage().setLeft(false);
        }
        this.ewK = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.ewJ = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.dGO = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dGO.setAutoChangeStyle(false);
        this.dGO.setDrawerType(1);
        this.dGO.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dGO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.evP.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.ewL = (TextView) findViewById(d.g.has_read);
        this.ewM = (TextView) findViewById(d.g.has_sent);
        this.ewr.setIsLeft(false);
        this.ews.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.ewK.getVisibility() != 8) {
                this.ewK.setVisibility(8);
                this.ewu.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.ewK.getVisibility() != 8) {
                this.ewK.setVisibility(8);
                this.ewu.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.ewu.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0140d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.ewK.setText(chatMessage.getProgressValue() + "%");
            this.ewK.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dvd.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.ewJ.setVisibility(8);
            this.ewL.setVisibility(8);
            this.ewM.setVisibility(8);
            this.ewn.setVisibility(0);
            this.ewn.setText(null);
            pI(8);
            this.ewu.getImage().setTag(null);
            this.ewo.setVisibility(8);
            this.ewo.setTag(null);
            this.ewr.setVisibility(8);
            this.ews.setVisibility(8);
            this.ewt.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dGO.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dGO.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dGO.startLoad(currentPortrait, 12, false);
                }
            }
            this.dGO.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.ewJ.setVisibility(8);
            this.ewL.setVisibility(8);
            this.ewM.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.ewJ.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.eww) {
                            if (chatMessage.isHasRead()) {
                                this.ewL.setVisibility(0);
                                this.ewM.setVisibility(8);
                                break;
                            } else {
                                this.ewL.setVisibility(8);
                                this.ewM.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.ewJ.getVisibility() == 0) {
                this.ewJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.evP.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.ewn.setVisibility(8);
            pI(8);
            this.ewo.setVisibility(8);
            this.ewp.setVisibility(8);
            this.ews.setVisibility(8);
            this.ewr.setVisibility(8);
            this.ewt.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.ewo.setVisibility(0);
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
