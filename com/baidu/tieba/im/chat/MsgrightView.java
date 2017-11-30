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
    private HeadImageView cJh;
    private ImageButton dDv;
    protected TextView dDw;
    private TextView dDx;
    private TextView dDy;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.dDg != null && this.dDg.getImage() != null && (this.dDg.getImage() instanceof ChatClipImageItemView)) {
            this.dDg.getImage().setLeft(false);
        }
        this.dDw = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dDv = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.cJh = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.cJh.setAutoChangeStyle(false);
        this.cJh.setDrawerType(1);
        this.cJh.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.cJh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.dCB.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.dDx = (TextView) findViewById(d.g.has_read);
        this.dDy = (TextView) findViewById(d.g.has_sent);
        this.dDd.setIsLeft(false);
        this.dDe.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dDw.getVisibility() != 8) {
                this.dDw.setVisibility(8);
                this.dDg.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dDw.getVisibility() != 8) {
                this.dDw.setVisibility(8);
                this.dDg.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dDg.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0082d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dDw.setText(chatMessage.getProgressValue() + "%");
            this.dDw.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cyE.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dDv.setVisibility(8);
            this.dDx.setVisibility(8);
            this.dDy.setVisibility(8);
            this.dCZ.setVisibility(0);
            this.dCZ.setText(null);
            mP(8);
            this.dDg.getImage().setTag(null);
            this.dDa.setVisibility(8);
            this.dDa.setTag(null);
            this.dDd.setVisibility(8);
            this.dDe.setVisibility(8);
            this.dDf.setVisibility(8);
            return;
        }
        try {
            f(chatMessage);
            this.cJh.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.cJh.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.cJh.startLoad(currentPortrait, 12, false);
                }
            }
            this.cJh.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dDv.setVisibility(8);
            this.dDx.setVisibility(8);
            this.dDy.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dDv.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dDi) {
                            if (chatMessage.isHasRead()) {
                                this.dDx.setVisibility(0);
                                this.dDy.setVisibility(8);
                                break;
                            } else {
                                this.dDx.setVisibility(8);
                                this.dDy.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dDv.getVisibility() == 0) {
                this.dDv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.dCB.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.dCZ.setVisibility(8);
            mP(8);
            this.dDa.setVisibility(8);
            this.dDb.setVisibility(8);
            this.dDe.setVisibility(8);
            this.dDd.setVisibility(8);
            this.dDf.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dDa.setVisibility(0);
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
