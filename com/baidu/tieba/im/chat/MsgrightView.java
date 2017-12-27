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
    private HeadImageView dyP;
    private ImageButton eqG;
    protected TextView eqH;
    private TextView eqI;
    private TextView eqJ;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.eqr != null && this.eqr.getImage() != null && (this.eqr.getImage() instanceof ChatClipImageItemView)) {
            this.eqr.getImage().setLeft(false);
        }
        this.eqH = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.eqG = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.dyP = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dyP.setAutoChangeStyle(false);
        this.dyP.setDrawerType(1);
        this.dyP.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dyP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.epM.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.eqI = (TextView) findViewById(d.g.has_read);
        this.eqJ = (TextView) findViewById(d.g.has_sent);
        this.eqo.setIsLeft(false);
        this.eqp.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.eqH.getVisibility() != 8) {
                this.eqH.setVisibility(8);
                this.eqr.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.eqH.getVisibility() != 8) {
                this.eqH.setVisibility(8);
                this.eqr.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.eqr.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0108d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.eqH.setText(chatMessage.getProgressValue() + "%");
            this.eqH.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dno.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.eqG.setVisibility(8);
            this.eqI.setVisibility(8);
            this.eqJ.setVisibility(8);
            this.eqk.setVisibility(0);
            this.eqk.setText(null);
            pO(8);
            this.eqr.getImage().setTag(null);
            this.eql.setVisibility(8);
            this.eql.setTag(null);
            this.eqo.setVisibility(8);
            this.eqp.setVisibility(8);
            this.eqq.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dyP.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dyP.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dyP.startLoad(currentPortrait, 12, false);
                }
            }
            this.dyP.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.eqG.setVisibility(8);
            this.eqI.setVisibility(8);
            this.eqJ.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.eqG.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.eqt) {
                            if (chatMessage.isHasRead()) {
                                this.eqI.setVisibility(0);
                                this.eqJ.setVisibility(8);
                                break;
                            } else {
                                this.eqI.setVisibility(8);
                                this.eqJ.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.eqG.getVisibility() == 0) {
                this.eqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.epM.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.eqk.setVisibility(8);
            pO(8);
            this.eql.setVisibility(8);
            this.eqm.setVisibility(8);
            this.eqp.setVisibility(8);
            this.eqo.setVisibility(8);
            this.eqq.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.eql.setVisibility(0);
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
