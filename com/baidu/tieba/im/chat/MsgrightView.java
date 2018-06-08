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
    private HeadImageView dka;
    private ImageButton edK;
    protected TextView edL;
    private TextView edM;
    private TextView edN;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgright_view);
        initView();
        if (this.edv != null && this.edv.getImage() != null && (this.edv.getImage() instanceof ChatClipImageItemView)) {
            this.edv.getImage().setLeft(false);
        }
        this.edL = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.edK = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.dka = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dka.setAutoChangeStyle(false);
        this.dka.setDrawerType(1);
        this.dka.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dka.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.ecQ.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.edM = (TextView) findViewById(d.g.has_read);
        this.edN = (TextView) findViewById(d.g.has_sent);
        this.eds.setIsLeft(false);
        this.edt.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.edL.getVisibility() != 8) {
                this.edL.setVisibility(8);
                this.edv.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.edL.getVisibility() != 8) {
                this.edL.setVisibility(8);
                this.edv.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.edv.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0141d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.edL.setText(chatMessage.getProgressValue() + "%");
            this.edL.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cXR.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.edK.setVisibility(8);
            this.edM.setVisibility(8);
            this.edN.setVisibility(8);
            this.edo.setVisibility(0);
            this.edo.setText(null);
            ns(8);
            this.edv.getImage().setTag(null);
            this.edp.setVisibility(8);
            this.edp.setTag(null);
            this.eds.setVisibility(8);
            this.edt.setVisibility(8);
            this.edu.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dka.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dka.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dka.startLoad(currentPortrait, 12, false);
                }
            }
            this.dka.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.edK.setVisibility(8);
            this.edM.setVisibility(8);
            this.edN.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.edK.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.edx) {
                            if (chatMessage.isHasRead()) {
                                this.edM.setVisibility(0);
                                this.edN.setVisibility(8);
                                break;
                            } else {
                                this.edM.setVisibility(8);
                                this.edN.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.edK.getVisibility() == 0) {
                this.edK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.ecQ.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.edo.setVisibility(8);
            ns(8);
            this.edp.setVisibility(8);
            this.edq.setVisibility(8);
            this.edt.setVisibility(8);
            this.eds.setVisibility(8);
            this.edu.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.edp.setVisibility(0);
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
