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
    private HeadImageView fbS;
    private ImageButton gco;
    protected TextView gcp;
    private TextView gcq;
    private TextView gcr;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.gbZ != null && this.gbZ.getImage() != null && (this.gbZ.getImage() instanceof ChatClipImageItemView)) {
            this.gbZ.getImage().setLeft(false);
        }
        this.gcp = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.gco = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.fbS = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.fbS.setAutoChangeStyle(false);
        this.fbS.setDrawerType(1);
        this.fbS.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.fbS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.gbu.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.gcq = (TextView) findViewById(d.g.has_read);
        this.gcr = (TextView) findViewById(d.g.has_sent);
        this.gbW.setIsLeft(false);
        this.gbX.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.gcp.getVisibility() != 8) {
                this.gcp.setVisibility(8);
                this.gbZ.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.gcp.getVisibility() != 8) {
                this.gcp.setVisibility(8);
                this.gbZ.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.gbZ.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0277d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.gcp.setText(chatMessage.getProgressValue() + "%");
            this.gcp.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.eLa.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.gco.setVisibility(8);
            this.gcq.setVisibility(8);
            this.gcr.setVisibility(8);
            this.gbS.setVisibility(0);
            this.gbS.setText(null);
            tA(8);
            this.gbZ.getImage().setTag(null);
            this.gbT.setVisibility(8);
            this.gbT.setTag(null);
            this.gbW.setVisibility(8);
            this.gbX.setVisibility(8);
            this.gbY.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.fbS.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.fbS.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.fbS.startLoad(currentPortrait, 12, false);
                }
            }
            this.fbS.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.gco.setVisibility(8);
            this.gcq.setVisibility(8);
            this.gcr.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.gco.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.gcb) {
                            if (chatMessage.isHasRead()) {
                                this.gcq.setVisibility(0);
                                this.gcr.setVisibility(8);
                                break;
                            } else {
                                this.gcq.setVisibility(8);
                                this.gcr.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.gco.getVisibility() == 0) {
                this.gco.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.gbu.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.gbS.setVisibility(8);
            tA(8);
            this.gbT.setVisibility(8);
            this.gbU.setVisibility(8);
            this.gbX.setVisibility(8);
            this.gbW.setVisibility(8);
            this.gbY.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.gbT.setVisibility(0);
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
