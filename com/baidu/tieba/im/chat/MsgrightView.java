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
    private HeadImageView cZB;
    private ImageButton dRq;
    protected TextView dRr;
    private TextView dRs;
    private TextView dRt;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgright_view);
        initView();
        if (this.dRb != null && this.dRb.getImage() != null && (this.dRb.getImage() instanceof ChatClipImageItemView)) {
            this.dRb.getImage().setLeft(false);
        }
        this.dRr = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dRq = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.cZB = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.cZB.setAutoChangeStyle(false);
        this.cZB.setDrawerType(1);
        this.cZB.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.cZB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MsgrightView.this.dQw.a(view2, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.dRs = (TextView) findViewById(d.g.has_read);
        this.dRt = (TextView) findViewById(d.g.has_sent);
        this.dQY.setIsLeft(false);
        this.dQZ.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view2, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dRr.getVisibility() != 8) {
                this.dRr.setVisibility(8);
                this.dRb.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dRr.getVisibility() != 8) {
                this.dRr.setVisibility(8);
                this.dRb.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dRb.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0126d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dRr.setText(chatMessage.getProgressValue() + "%");
            this.dRr.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view2, ChatMessage chatMessage) {
        super.b(view2, chatMessage);
        if (chatMessage == null) {
            this.cNF.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dRq.setVisibility(8);
            this.dRs.setVisibility(8);
            this.dRt.setVisibility(8);
            this.dQU.setVisibility(0);
            this.dQU.setText(null);
            nh(8);
            this.dRb.getImage().setTag(null);
            this.dQV.setVisibility(8);
            this.dQV.setTag(null);
            this.dQY.setVisibility(8);
            this.dQZ.setVisibility(8);
            this.dRa.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.cZB.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.cZB.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.cZB.startLoad(currentPortrait, 12, false);
                }
            }
            this.cZB.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dRq.setVisibility(8);
            this.dRs.setVisibility(8);
            this.dRt.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dRq.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dRd) {
                            if (chatMessage.isHasRead()) {
                                this.dRs.setVisibility(0);
                                this.dRt.setVisibility(8);
                                break;
                            } else {
                                this.dRs.setVisibility(8);
                                this.dRt.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dRq.getVisibility() == 0) {
                this.dRq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        MsgrightView.this.dQw.a(view3, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.dQU.setVisibility(8);
            nh(8);
            this.dQV.setVisibility(8);
            this.dQW.setVisibility(8);
            this.dQZ.setVisibility(8);
            this.dQY.setVisibility(8);
            this.dRa.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view2, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dQV.setVisibility(0);
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
                    c(view2, chatMessage, TAG);
                    return;
            }
        } catch (Exception e) {
        }
    }
}
