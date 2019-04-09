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
    private HeadImageView fbF;
    private ImageButton gcc;
    protected TextView gcd;
    private TextView gce;
    private TextView gcf;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.gbN != null && this.gbN.getImage() != null && (this.gbN.getImage() instanceof ChatClipImageItemView)) {
            this.gbN.getImage().setLeft(false);
        }
        this.gcd = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.gcc = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.fbF = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.fbF.setAutoChangeStyle(false);
        this.fbF.setDrawerType(1);
        this.fbF.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.fbF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.gbi.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.gce = (TextView) findViewById(d.g.has_read);
        this.gcf = (TextView) findViewById(d.g.has_sent);
        this.gbK.setIsLeft(false);
        this.gbL.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.gcd.getVisibility() != 8) {
                this.gcd.setVisibility(8);
                this.gbN.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.gcd.getVisibility() != 8) {
                this.gcd.setVisibility(8);
                this.gbN.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.gbN.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0277d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.gcd.setText(chatMessage.getProgressValue() + "%");
            this.gcd.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.eKN.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.gcc.setVisibility(8);
            this.gce.setVisibility(8);
            this.gcf.setVisibility(8);
            this.gbG.setVisibility(0);
            this.gbG.setText(null);
            tw(8);
            this.gbN.getImage().setTag(null);
            this.gbH.setVisibility(8);
            this.gbH.setTag(null);
            this.gbK.setVisibility(8);
            this.gbL.setVisibility(8);
            this.gbM.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.fbF.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.fbF.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.fbF.startLoad(currentPortrait, 12, false);
                }
            }
            this.fbF.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.gcc.setVisibility(8);
            this.gce.setVisibility(8);
            this.gcf.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.gcc.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.gbP) {
                            if (chatMessage.isHasRead()) {
                                this.gce.setVisibility(0);
                                this.gcf.setVisibility(8);
                                break;
                            } else {
                                this.gce.setVisibility(8);
                                this.gcf.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.gcc.getVisibility() == 0) {
                this.gcc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.gbi.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.gbG.setVisibility(8);
            tw(8);
            this.gbH.setVisibility(8);
            this.gbI.setVisibility(8);
            this.gbL.setVisibility(8);
            this.gbK.setVisibility(8);
            this.gbM.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.gbH.setVisibility(0);
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
