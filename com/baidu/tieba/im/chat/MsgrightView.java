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
    private HeadImageView csc;
    private ImageButton drw;
    protected TextView drx;
    private TextView dry;
    private TextView drz;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgright_view);
        initView();
        if (this.drh != null && this.drh.getImage() != null && (this.drh.getImage() instanceof ChatClipImageItemView)) {
            this.drh.getImage().setLeft(false);
        }
        this.drx = (TextView) findViewById(d.h.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.drw = (ImageButton) findViewById(d.h.btn_msgitem_resend);
        this.csc = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.csc.setAutoChangeStyle(false);
        this.csc.setDrawerType(1);
        this.csc.setRadius(k.dip2px(this.mContext.getContext(), 4.0f));
        this.csc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.dqC.a(view, 6, MsgrightView.this.avK, 0L);
            }
        });
        this.dry = (TextView) findViewById(d.h.has_read);
        this.drz = (TextView) findViewById(d.h.has_sent);
        this.dre.setIsLeft(false);
        this.drf.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.drx.getVisibility() != 8) {
                this.drx.setVisibility(8);
                this.drh.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.drx.getVisibility() != 8) {
                this.drx.setVisibility(8);
                this.drh.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.drh.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.drx.setText(chatMessage.getProgressValue() + "%");
            this.drx.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.ciZ.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.drw.setVisibility(8);
            this.dry.setVisibility(8);
            this.drz.setVisibility(8);
            this.dra.setVisibility(0);
            this.dra.setText(null);
            mp(8);
            this.drh.getImage().setTag(null);
            this.drb.setVisibility(8);
            this.drb.setTag(null);
            this.dre.setVisibility(8);
            this.drf.setVisibility(8);
            this.drg.setVisibility(8);
            return;
        }
        try {
            e(chatMessage);
            this.csc.setDefaultResource(d.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.csc.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.csc.c(currentPortrait, 12, false);
                }
            }
            this.csc.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.drw.setVisibility(8);
            this.dry.setVisibility(8);
            this.drz.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.drw.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.drj) {
                            if (chatMessage.isHasRead()) {
                                this.dry.setVisibility(0);
                                this.drz.setVisibility(8);
                                break;
                            } else {
                                this.dry.setVisibility(8);
                                this.drz.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.drw.getVisibility() == 0) {
                this.drw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.dqC.a(view2, 1, MsgrightView.this.avK, 0L);
                    }
                });
            }
            this.dra.setVisibility(8);
            mp(8);
            this.drb.setVisibility(8);
            this.drc.setVisibility(8);
            this.drf.setVisibility(8);
            this.dre.setVisibility(8);
            this.drg.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.drb.setVisibility(0);
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
