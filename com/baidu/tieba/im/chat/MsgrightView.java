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
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView doX;
    private ImageButton elq;
    protected TextView elr;
    private TextView els;
    private TextView elt;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, f.h.msg_msgright_view);
        initView();
        if (this.elb != null && this.elb.getImage() != null && (this.elb.getImage() instanceof ChatClipImageItemView)) {
            this.elb.getImage().setLeft(false);
        }
        this.elr = (TextView) findViewById(f.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(f.g.progress);
        this.elq = (ImageButton) findViewById(f.g.btn_msgitem_resend);
        this.doX = (HeadImageView) findViewById(f.g.img_msgitem_photo);
        this.doX.setAutoChangeStyle(false);
        this.doX.setDrawerType(1);
        this.doX.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.doX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.ekw.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.els = (TextView) findViewById(f.g.has_read);
        this.elt = (TextView) findViewById(f.g.has_sent);
        this.ekY.setIsLeft(false);
        this.ekZ.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.elr.getVisibility() != 8) {
                this.elr.setVisibility(8);
                this.elb.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.elr.getVisibility() != 8) {
                this.elr.setVisibility(8);
                this.elb.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.elb.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(f.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.elr.setText(chatMessage.getProgressValue() + "%");
            this.elr.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cYF.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.elq.setVisibility(8);
            this.els.setVisibility(8);
            this.elt.setVisibility(8);
            this.ekU.setVisibility(0);
            this.ekU.setText(null);
            nN(8);
            this.elb.getImage().setTag(null);
            this.ekV.setVisibility(8);
            this.ekV.setTag(null);
            this.ekY.setVisibility(8);
            this.ekZ.setVisibility(8);
            this.ela.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.doX.setDefaultResource(f.C0146f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.doX.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.doX.startLoad(currentPortrait, 12, false);
                }
            }
            this.doX.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.elq.setVisibility(8);
            this.els.setVisibility(8);
            this.elt.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.elq.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.eld) {
                            if (chatMessage.isHasRead()) {
                                this.els.setVisibility(0);
                                this.elt.setVisibility(8);
                                break;
                            } else {
                                this.els.setVisibility(8);
                                this.elt.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.elq.getVisibility() == 0) {
                this.elq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.ekw.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.ekU.setVisibility(8);
            nN(8);
            this.ekV.setVisibility(8);
            this.ekW.setVisibility(8);
            this.ekZ.setVisibility(8);
            this.ekY.setVisibility(8);
            this.ela.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.ekV.setVisibility(0);
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
