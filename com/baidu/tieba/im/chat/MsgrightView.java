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
    private TextView dSA;
    private ImageButton dSx;
    protected TextView dSy;
    private TextView dSz;
    private HeadImageView daK;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgright_view);
        initView();
        if (this.dSi != null && this.dSi.getImage() != null && (this.dSi.getImage() instanceof ChatClipImageItemView)) {
            this.dSi.getImage().setLeft(false);
        }
        this.dSy = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dSx = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.daK = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.daK.setAutoChangeStyle(false);
        this.daK.setDrawerType(1);
        this.daK.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.daK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MsgrightView.this.dRD.a(view2, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.dSz = (TextView) findViewById(d.g.has_read);
        this.dSA = (TextView) findViewById(d.g.has_sent);
        this.dSf.setIsLeft(false);
        this.dSg.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view2, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dSy.getVisibility() != 8) {
                this.dSy.setVisibility(8);
                this.dSi.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dSy.getVisibility() != 8) {
                this.dSy.setVisibility(8);
                this.dSi.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dSi.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0126d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dSy.setText(chatMessage.getProgressValue() + "%");
            this.dSy.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view2, ChatMessage chatMessage) {
        super.b(view2, chatMessage);
        if (chatMessage == null) {
            this.cOM.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dSx.setVisibility(8);
            this.dSz.setVisibility(8);
            this.dSA.setVisibility(8);
            this.dSb.setVisibility(0);
            this.dSb.setText(null);
            ng(8);
            this.dSi.getImage().setTag(null);
            this.dSc.setVisibility(8);
            this.dSc.setTag(null);
            this.dSf.setVisibility(8);
            this.dSg.setVisibility(8);
            this.dSh.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.daK.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.daK.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.daK.startLoad(currentPortrait, 12, false);
                }
            }
            this.daK.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dSx.setVisibility(8);
            this.dSz.setVisibility(8);
            this.dSA.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dSx.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dSk) {
                            if (chatMessage.isHasRead()) {
                                this.dSz.setVisibility(0);
                                this.dSA.setVisibility(8);
                                break;
                            } else {
                                this.dSz.setVisibility(8);
                                this.dSA.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dSx.getVisibility() == 0) {
                this.dSx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        MsgrightView.this.dRD.a(view3, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.dSb.setVisibility(8);
            ng(8);
            this.dSc.setVisibility(8);
            this.dSd.setVisibility(8);
            this.dSg.setVisibility(8);
            this.dSf.setVisibility(8);
            this.dSh.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view2, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dSc.setVisibility(0);
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
                    c(view2, chatMessage, TAG);
                    return;
            }
        } catch (Exception e) {
        }
    }
}
