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
    private HeadImageView cJr;
    protected TextView dEA;
    private TextView dEB;
    private TextView dEC;
    private ImageButton dEz;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.dEk != null && this.dEk.getImage() != null && (this.dEk.getImage() instanceof ChatClipImageItemView)) {
            this.dEk.getImage().setLeft(false);
        }
        this.dEA = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dEz = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.cJr = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.cJr.setAutoChangeStyle(false);
        this.cJr.setDrawerType(1);
        this.cJr.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.cJr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.dDF.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.dEB = (TextView) findViewById(d.g.has_read);
        this.dEC = (TextView) findViewById(d.g.has_sent);
        this.dEh.setIsLeft(false);
        this.dEi.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dEA.getVisibility() != 8) {
                this.dEA.setVisibility(8);
                this.dEk.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dEA.getVisibility() != 8) {
                this.dEA.setVisibility(8);
                this.dEk.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dEk.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0096d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dEA.setText(chatMessage.getProgressValue() + "%");
            this.dEA.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cyM.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dEz.setVisibility(8);
            this.dEB.setVisibility(8);
            this.dEC.setVisibility(8);
            this.dEd.setVisibility(0);
            this.dEd.setText(null);
            mW(8);
            this.dEk.getImage().setTag(null);
            this.dEe.setVisibility(8);
            this.dEe.setTag(null);
            this.dEh.setVisibility(8);
            this.dEi.setVisibility(8);
            this.dEj.setVisibility(8);
            return;
        }
        try {
            f(chatMessage);
            this.cJr.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.cJr.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.cJr.startLoad(currentPortrait, 12, false);
                }
            }
            this.cJr.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dEz.setVisibility(8);
            this.dEB.setVisibility(8);
            this.dEC.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dEz.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dEm) {
                            if (chatMessage.isHasRead()) {
                                this.dEB.setVisibility(0);
                                this.dEC.setVisibility(8);
                                break;
                            } else {
                                this.dEB.setVisibility(8);
                                this.dEC.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dEz.getVisibility() == 0) {
                this.dEz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.dDF.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.dEd.setVisibility(8);
            mW(8);
            this.dEe.setVisibility(8);
            this.dEf.setVisibility(8);
            this.dEi.setVisibility(8);
            this.dEh.setVisibility(8);
            this.dEj.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dEe.setVisibility(0);
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
