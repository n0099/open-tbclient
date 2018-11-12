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
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView dEl;
    private ImageButton eBU;
    protected TextView eBV;
    private TextView eBW;
    private TextView eBX;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgright_view);
        initView();
        if (this.eBF != null && this.eBF.getImage() != null && (this.eBF.getImage() instanceof ChatClipImageItemView)) {
            this.eBF.getImage().setLeft(false);
        }
        this.eBV = (TextView) findViewById(e.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.eBU = (ImageButton) findViewById(e.g.btn_msgitem_resend);
        this.dEl = (HeadImageView) findViewById(e.g.img_msgitem_photo);
        this.dEl.setAutoChangeStyle(false);
        this.dEl.setDrawerType(1);
        this.dEl.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dEl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.eBa.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.eBW = (TextView) findViewById(e.g.has_read);
        this.eBX = (TextView) findViewById(e.g.has_sent);
        this.eBC.setIsLeft(false);
        this.eBD.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.eBV.getVisibility() != 8) {
                this.eBV.setVisibility(8);
                this.eBF.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.eBV.getVisibility() != 8) {
                this.eBV.setVisibility(8);
                this.eBF.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.eBF.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(e.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.eBV.setText(chatMessage.getProgressValue() + "%");
            this.eBV.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dnM.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.eBU.setVisibility(8);
            this.eBW.setVisibility(8);
            this.eBX.setVisibility(8);
            this.eBy.setVisibility(0);
            this.eBy.setText(null);
            ph(8);
            this.eBF.getImage().setTag(null);
            this.eBz.setVisibility(8);
            this.eBz.setTag(null);
            this.eBC.setVisibility(8);
            this.eBD.setVisibility(8);
            this.eBE.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dEl.setDefaultResource(e.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dEl.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dEl.startLoad(currentPortrait, 12, false);
                }
            }
            this.dEl.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.eBU.setVisibility(8);
            this.eBW.setVisibility(8);
            this.eBX.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.eBU.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.eBH) {
                            if (chatMessage.isHasRead()) {
                                this.eBW.setVisibility(0);
                                this.eBX.setVisibility(8);
                                break;
                            } else {
                                this.eBW.setVisibility(8);
                                this.eBX.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.eBU.getVisibility() == 0) {
                this.eBU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.eBa.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.eBy.setVisibility(8);
            ph(8);
            this.eBz.setVisibility(8);
            this.eBA.setVisibility(8);
            this.eBD.setVisibility(8);
            this.eBC.setVisibility(8);
            this.eBE.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.eBz.setVisibility(0);
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
