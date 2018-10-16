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
    private HeadImageView dCV;
    private ImageButton eAA;
    protected TextView eAB;
    private TextView eAC;
    private TextView eAD;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgright_view);
        initView();
        if (this.eAl != null && this.eAl.getImage() != null && (this.eAl.getImage() instanceof ChatClipImageItemView)) {
            this.eAl.getImage().setLeft(false);
        }
        this.eAB = (TextView) findViewById(e.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.eAA = (ImageButton) findViewById(e.g.btn_msgitem_resend);
        this.dCV = (HeadImageView) findViewById(e.g.img_msgitem_photo);
        this.dCV.setAutoChangeStyle(false);
        this.dCV.setDrawerType(1);
        this.dCV.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.ezG.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.eAC = (TextView) findViewById(e.g.has_read);
        this.eAD = (TextView) findViewById(e.g.has_sent);
        this.eAi.setIsLeft(false);
        this.eAj.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.eAB.getVisibility() != 8) {
                this.eAB.setVisibility(8);
                this.eAl.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.eAB.getVisibility() != 8) {
                this.eAB.setVisibility(8);
                this.eAl.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.eAl.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(e.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.eAB.setText(chatMessage.getProgressValue() + "%");
            this.eAB.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dmH.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.eAA.setVisibility(8);
            this.eAC.setVisibility(8);
            this.eAD.setVisibility(8);
            this.eAe.setVisibility(0);
            this.eAe.setText(null);
            oP(8);
            this.eAl.getImage().setTag(null);
            this.eAf.setVisibility(8);
            this.eAf.setTag(null);
            this.eAi.setVisibility(8);
            this.eAj.setVisibility(8);
            this.eAk.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dCV.setDefaultResource(e.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dCV.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dCV.startLoad(currentPortrait, 12, false);
                }
            }
            this.dCV.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.eAA.setVisibility(8);
            this.eAC.setVisibility(8);
            this.eAD.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.eAA.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.eAn) {
                            if (chatMessage.isHasRead()) {
                                this.eAC.setVisibility(0);
                                this.eAD.setVisibility(8);
                                break;
                            } else {
                                this.eAC.setVisibility(8);
                                this.eAD.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.eAA.getVisibility() == 0) {
                this.eAA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.ezG.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.eAe.setVisibility(8);
            oP(8);
            this.eAf.setVisibility(8);
            this.eAg.setVisibility(8);
            this.eAj.setVisibility(8);
            this.eAi.setVisibility(8);
            this.eAk.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.eAf.setVisibility(0);
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
