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
    private HeadImageView dDL;
    protected TextView esA;
    private TextView esB;
    private TextView esC;
    private ImageButton esz;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.esk != null && this.esk.getImage() != null && (this.esk.getImage() instanceof ChatClipImageItemView)) {
            this.esk.getImage().setLeft(false);
        }
        this.esA = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.esz = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.dDL = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dDL.setAutoChangeStyle(false);
        this.dDL.setDrawerType(1);
        this.dDL.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dDL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.erF.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.esB = (TextView) findViewById(d.g.has_read);
        this.esC = (TextView) findViewById(d.g.has_sent);
        this.esh.setIsLeft(false);
        this.esi.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.esA.getVisibility() != 8) {
                this.esA.setVisibility(8);
                this.esk.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.esA.getVisibility() != 8) {
                this.esA.setVisibility(8);
                this.esk.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.esk.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0108d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.esA.setText(chatMessage.getProgressValue() + "%");
            this.esA.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dsk.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.esz.setVisibility(8);
            this.esB.setVisibility(8);
            this.esC.setVisibility(8);
            this.esd.setVisibility(0);
            this.esd.setText(null);
            pH(8);
            this.esk.getImage().setTag(null);
            this.ese.setVisibility(8);
            this.ese.setTag(null);
            this.esh.setVisibility(8);
            this.esi.setVisibility(8);
            this.esj.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dDL.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dDL.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dDL.startLoad(currentPortrait, 12, false);
                }
            }
            this.dDL.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.esz.setVisibility(8);
            this.esB.setVisibility(8);
            this.esC.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.esz.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.esm) {
                            if (chatMessage.isHasRead()) {
                                this.esB.setVisibility(0);
                                this.esC.setVisibility(8);
                                break;
                            } else {
                                this.esB.setVisibility(8);
                                this.esC.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.esz.getVisibility() == 0) {
                this.esz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.erF.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.esd.setVisibility(8);
            pH(8);
            this.ese.setVisibility(8);
            this.esf.setVisibility(8);
            this.esi.setVisibility(8);
            this.esh.setVisibility(8);
            this.esj.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.ese.setVisibility(0);
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
