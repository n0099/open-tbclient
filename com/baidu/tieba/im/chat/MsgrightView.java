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
    private HeadImageView czK;
    private ImageButton dvo;
    protected TextView dvp;
    private TextView dvq;
    private TextView dvr;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.duZ != null && this.duZ.getImage() != null && (this.duZ.getImage() instanceof ChatClipImageItemView)) {
            this.duZ.getImage().setLeft(false);
        }
        this.dvp = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dvo = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.czK = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.czK.setAutoChangeStyle(false);
        this.czK.setDrawerType(1);
        this.czK.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.czK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.duu.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.dvq = (TextView) findViewById(d.g.has_read);
        this.dvr = (TextView) findViewById(d.g.has_sent);
        this.duW.setIsLeft(false);
        this.duX.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dvp.getVisibility() != 8) {
                this.dvp.setVisibility(8);
                this.duZ.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dvp.getVisibility() != 8) {
                this.dvp.setVisibility(8);
                this.duZ.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.duZ.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0080d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dvp.setText(chatMessage.getProgressValue() + "%");
            this.dvp.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cpA.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dvo.setVisibility(8);
            this.dvq.setVisibility(8);
            this.dvr.setVisibility(8);
            this.duS.setVisibility(0);
            this.duS.setText(null);
            mB(8);
            this.duZ.getImage().setTag(null);
            this.duT.setVisibility(8);
            this.duT.setTag(null);
            this.duW.setVisibility(8);
            this.duX.setVisibility(8);
            this.duY.setVisibility(8);
            return;
        }
        try {
            f(chatMessage);
            this.czK.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.czK.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.czK.startLoad(currentPortrait, 12, false);
                }
            }
            this.czK.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dvo.setVisibility(8);
            this.dvq.setVisibility(8);
            this.dvr.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dvo.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dvb) {
                            if (chatMessage.isHasRead()) {
                                this.dvq.setVisibility(0);
                                this.dvr.setVisibility(8);
                                break;
                            } else {
                                this.dvq.setVisibility(8);
                                this.dvr.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dvo.getVisibility() == 0) {
                this.dvo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.duu.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.duS.setVisibility(8);
            mB(8);
            this.duT.setVisibility(8);
            this.duU.setVisibility(8);
            this.duX.setVisibility(8);
            this.duW.setVisibility(8);
            this.duY.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.duT.setVisibility(0);
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
