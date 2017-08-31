package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView crk;
    private ImageButton dqB;
    protected TextView dqC;
    private TextView dqD;
    private TextView dqE;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgright_view);
        initView();
        if (this.dqm != null && this.dqm.getImage() != null && (this.dqm.getImage() instanceof ChatClipImageItemView)) {
            this.dqm.getImage().setLeft(false);
        }
        this.dqC = (TextView) findViewById(d.h.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.dqB = (ImageButton) findViewById(d.h.btn_msgitem_resend);
        this.crk = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.crk.setAutoChangeStyle(false);
        this.crk.setDrawerType(1);
        this.crk.setRadius(k.dip2px(this.mContext.getContext(), 4.0f));
        this.crk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.dpH.a(view, 6, MsgrightView.this.avN, 0L);
            }
        });
        this.dqD = (TextView) findViewById(d.h.has_read);
        this.dqE = (TextView) findViewById(d.h.has_sent);
        this.dqj.setIsLeft(false);
        this.dqk.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dqC.getVisibility() != 8) {
                this.dqC.setVisibility(8);
                this.dqm.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dqC.getVisibility() != 8) {
                this.dqC.setVisibility(8);
                this.dqm.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dqm.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dqC.setText(chatMessage.getProgressValue() + "%");
            this.dqC.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cih.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dqB.setVisibility(8);
            this.dqD.setVisibility(8);
            this.dqE.setVisibility(8);
            this.dqf.setVisibility(0);
            this.dqf.setText(null);
            mn(8);
            this.dqm.getImage().setTag(null);
            this.dqg.setVisibility(8);
            this.dqg.setTag(null);
            this.dqj.setVisibility(8);
            this.dqk.setVisibility(8);
            this.dql.setVisibility(8);
            return;
        }
        try {
            e(chatMessage);
            this.crk.setDefaultResource(d.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.crk.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.crk.c(currentPortrait, 12, false);
                }
            }
            this.crk.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dqB.setVisibility(8);
            this.dqD.setVisibility(8);
            this.dqE.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dqB.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dqo) {
                            if (chatMessage.isHasRead()) {
                                this.dqD.setVisibility(0);
                                this.dqE.setVisibility(8);
                                break;
                            } else {
                                this.dqD.setVisibility(8);
                                this.dqE.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dqB.getVisibility() == 0) {
                this.dqB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.dpH.a(view2, 1, MsgrightView.this.avN, 0L);
                    }
                });
            }
            this.dqf.setVisibility(8);
            mn(8);
            this.dqg.setVisibility(8);
            this.dqh.setVisibility(8);
            this.dqk.setVisibility(8);
            this.dqj.setVisibility(8);
            this.dql.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dqg.setVisibility(0);
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
