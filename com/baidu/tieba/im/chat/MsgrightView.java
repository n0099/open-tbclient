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
    private HeadImageView duU;
    private ImageButton esK;
    protected TextView esL;
    private TextView esM;
    private TextView esN;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgright_view);
        initView();
        if (this.esv != null && this.esv.getImage() != null && (this.esv.getImage() instanceof ChatClipImageItemView)) {
            this.esv.getImage().setLeft(false);
        }
        this.esL = (TextView) findViewById(e.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.esK = (ImageButton) findViewById(e.g.btn_msgitem_resend);
        this.duU = (HeadImageView) findViewById(e.g.img_msgitem_photo);
        this.duU.setAutoChangeStyle(false);
        this.duU.setDrawerType(1);
        this.duU.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.duU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.erQ.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.esM = (TextView) findViewById(e.g.has_read);
        this.esN = (TextView) findViewById(e.g.has_sent);
        this.ess.setIsLeft(false);
        this.est.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.esL.getVisibility() != 8) {
                this.esL.setVisibility(8);
                this.esv.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.esL.getVisibility() != 8) {
                this.esL.setVisibility(8);
                this.esv.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.esv.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(e.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.esL.setText(chatMessage.getProgressValue() + "%");
            this.esL.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.deC.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.esK.setVisibility(8);
            this.esM.setVisibility(8);
            this.esN.setVisibility(8);
            this.eso.setVisibility(0);
            this.eso.setText(null);
            or(8);
            this.esv.getImage().setTag(null);
            this.esp.setVisibility(8);
            this.esp.setTag(null);
            this.ess.setVisibility(8);
            this.est.setVisibility(8);
            this.esu.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.duU.setDefaultResource(e.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.duU.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.duU.startLoad(currentPortrait, 12, false);
                }
            }
            this.duU.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.esK.setVisibility(8);
            this.esM.setVisibility(8);
            this.esN.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.esK.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.esx) {
                            if (chatMessage.isHasRead()) {
                                this.esM.setVisibility(0);
                                this.esN.setVisibility(8);
                                break;
                            } else {
                                this.esM.setVisibility(8);
                                this.esN.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.esK.getVisibility() == 0) {
                this.esK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.erQ.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.eso.setVisibility(8);
            or(8);
            this.esp.setVisibility(8);
            this.esq.setVisibility(8);
            this.est.setVisibility(8);
            this.ess.setVisibility(8);
            this.esu.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.esp.setVisibility(0);
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
