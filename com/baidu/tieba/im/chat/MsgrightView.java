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
    private HeadImageView cJv;
    private ImageButton dED;
    protected TextView dEE;
    private TextView dEF;
    private TextView dEG;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.dEo != null && this.dEo.getImage() != null && (this.dEo.getImage() instanceof ChatClipImageItemView)) {
            this.dEo.getImage().setLeft(false);
        }
        this.dEE = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dED = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.cJv = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.cJv.setAutoChangeStyle(false);
        this.cJv.setDrawerType(1);
        this.cJv.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.cJv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.dDJ.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.dEF = (TextView) findViewById(d.g.has_read);
        this.dEG = (TextView) findViewById(d.g.has_sent);
        this.dEl.setIsLeft(false);
        this.dEm.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dEE.getVisibility() != 8) {
                this.dEE.setVisibility(8);
                this.dEo.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dEE.getVisibility() != 8) {
                this.dEE.setVisibility(8);
                this.dEo.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dEo.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0095d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dEE.setText(chatMessage.getProgressValue() + "%");
            this.dEE.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cyQ.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dED.setVisibility(8);
            this.dEF.setVisibility(8);
            this.dEG.setVisibility(8);
            this.dEh.setVisibility(0);
            this.dEh.setText(null);
            mW(8);
            this.dEo.getImage().setTag(null);
            this.dEi.setVisibility(8);
            this.dEi.setTag(null);
            this.dEl.setVisibility(8);
            this.dEm.setVisibility(8);
            this.dEn.setVisibility(8);
            return;
        }
        try {
            f(chatMessage);
            this.cJv.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.cJv.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.cJv.startLoad(currentPortrait, 12, false);
                }
            }
            this.cJv.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dED.setVisibility(8);
            this.dEF.setVisibility(8);
            this.dEG.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dED.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dEq) {
                            if (chatMessage.isHasRead()) {
                                this.dEF.setVisibility(0);
                                this.dEG.setVisibility(8);
                                break;
                            } else {
                                this.dEF.setVisibility(8);
                                this.dEG.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dED.getVisibility() == 0) {
                this.dED.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.dDJ.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.dEh.setVisibility(8);
            mW(8);
            this.dEi.setVisibility(8);
            this.dEj.setVisibility(8);
            this.dEm.setVisibility(8);
            this.dEl.setVisibility(8);
            this.dEn.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dEi.setVisibility(0);
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
