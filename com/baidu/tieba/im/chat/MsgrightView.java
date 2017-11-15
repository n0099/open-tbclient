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
    private HeadImageView cAd;
    private ImageButton dvI;
    protected TextView dvJ;
    private TextView dvK;
    private TextView dvL;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.dvt != null && this.dvt.getImage() != null && (this.dvt.getImage() instanceof ChatClipImageItemView)) {
            this.dvt.getImage().setLeft(false);
        }
        this.dvJ = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dvI = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.cAd = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.cAd.setAutoChangeStyle(false);
        this.cAd.setDrawerType(1);
        this.cAd.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.cAd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.duO.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.dvK = (TextView) findViewById(d.g.has_read);
        this.dvL = (TextView) findViewById(d.g.has_sent);
        this.dvq.setIsLeft(false);
        this.dvr.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dvJ.getVisibility() != 8) {
                this.dvJ.setVisibility(8);
                this.dvt.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dvJ.getVisibility() != 8) {
                this.dvJ.setVisibility(8);
                this.dvt.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dvt.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0080d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dvJ.setText(chatMessage.getProgressValue() + "%");
            this.dvJ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cpT.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dvI.setVisibility(8);
            this.dvK.setVisibility(8);
            this.dvL.setVisibility(8);
            this.dvm.setVisibility(0);
            this.dvm.setText(null);
            mB(8);
            this.dvt.getImage().setTag(null);
            this.dvn.setVisibility(8);
            this.dvn.setTag(null);
            this.dvq.setVisibility(8);
            this.dvr.setVisibility(8);
            this.dvs.setVisibility(8);
            return;
        }
        try {
            f(chatMessage);
            this.cAd.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.cAd.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.cAd.startLoad(currentPortrait, 12, false);
                }
            }
            this.cAd.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dvI.setVisibility(8);
            this.dvK.setVisibility(8);
            this.dvL.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dvI.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dvv) {
                            if (chatMessage.isHasRead()) {
                                this.dvK.setVisibility(0);
                                this.dvL.setVisibility(8);
                                break;
                            } else {
                                this.dvK.setVisibility(8);
                                this.dvL.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dvI.getVisibility() == 0) {
                this.dvI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.duO.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.dvm.setVisibility(8);
            mB(8);
            this.dvn.setVisibility(8);
            this.dvo.setVisibility(8);
            this.dvr.setVisibility(8);
            this.dvq.setVisibility(8);
            this.dvs.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dvn.setVisibility(0);
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
