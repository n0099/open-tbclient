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
    private HeadImageView csz;
    private ImageButton dnL;
    protected TextView dnM;
    private TextView dnN;
    private TextView dnO;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgright_view);
        initView();
        if (this.dnw != null && this.dnw.getImage() != null && (this.dnw.getImage() instanceof ChatClipImageItemView)) {
            this.dnw.getImage().setLeft(false);
        }
        this.dnM = (TextView) findViewById(d.h.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.dnL = (ImageButton) findViewById(d.h.btn_msgitem_resend);
        this.csz = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.csz.setAutoChangeStyle(false);
        this.csz.setDrawerType(1);
        this.csz.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.csz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.dmR.a(view, 6, MsgrightView.this.auU, 0L);
            }
        });
        this.dnN = (TextView) findViewById(d.h.has_read);
        this.dnO = (TextView) findViewById(d.h.has_sent);
        this.dnt.setIsLeft(false);
        this.dnu.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dnM.getVisibility() != 8) {
                this.dnM.setVisibility(8);
                this.dnw.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dnM.getVisibility() != 8) {
                this.dnM.setVisibility(8);
                this.dnw.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dnw.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dnM.setText(chatMessage.getProgressValue() + "%");
            this.dnM.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cir.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dnL.setVisibility(8);
            this.dnN.setVisibility(8);
            this.dnO.setVisibility(8);
            this.dnp.setVisibility(0);
            this.dnp.setText(null);
            ml(8);
            this.dnw.getImage().setTag(null);
            this.dnq.setVisibility(8);
            this.dnq.setTag(null);
            this.dnt.setVisibility(8);
            this.dnu.setVisibility(8);
            this.dnv.setVisibility(8);
            return;
        }
        try {
            e(chatMessage);
            this.csz.setDefaultResource(d.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.csz.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.csz.c(currentPortrait, 12, false);
                }
            }
            this.csz.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dnL.setVisibility(8);
            this.dnN.setVisibility(8);
            this.dnO.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dnL.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dny) {
                            if (chatMessage.isHasRead()) {
                                this.dnN.setVisibility(0);
                                this.dnO.setVisibility(8);
                                break;
                            } else {
                                this.dnN.setVisibility(8);
                                this.dnO.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dnL.getVisibility() == 0) {
                this.dnL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.dmR.a(view2, 1, MsgrightView.this.auU, 0L);
                    }
                });
            }
            this.dnp.setVisibility(8);
            ml(8);
            this.dnq.setVisibility(8);
            this.dnr.setVisibility(8);
            this.dnu.setVisibility(8);
            this.dnt.setVisibility(8);
            this.dnv.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dnq.setVisibility(0);
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
