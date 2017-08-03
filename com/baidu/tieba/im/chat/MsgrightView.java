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
    private HeadImageView cjV;
    private ImageButton dgH;
    protected TextView dgI;
    private TextView dgJ;
    private TextView dgK;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgright_view);
        initView();
        if (this.dgt != null && this.dgt.getImage() != null && (this.dgt.getImage() instanceof ChatClipImageItemView)) {
            this.dgt.getImage().setLeft(false);
        }
        this.dgI = (TextView) findViewById(d.h.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.dgH = (ImageButton) findViewById(d.h.btn_msgitem_resend);
        this.cjV = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.cjV.setAutoChangeStyle(false);
        this.cjV.setDrawerType(1);
        this.cjV.setRadius(k.dip2px(this.mContext.getContext(), 4.0f));
        this.cjV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.dfO.a(view, 6, MsgrightView.this.avi, 0L);
            }
        });
        this.dgJ = (TextView) findViewById(d.h.has_read);
        this.dgK = (TextView) findViewById(d.h.has_sent);
        this.dgq.setIsLeft(false);
        this.dgr.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dgI.getVisibility() != 8) {
                this.dgI.setVisibility(8);
                this.dgt.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dgI.getVisibility() != 8) {
                this.dgI.setVisibility(8);
                this.dgt.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dgt.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dgI.setText(chatMessage.getProgressValue() + "%");
            this.dgI.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.ccL.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dgH.setVisibility(8);
            this.dgJ.setVisibility(8);
            this.dgK.setVisibility(8);
            this.dgm.setVisibility(0);
            this.dgm.setText(null);
            lL(8);
            this.dgt.getImage().setTag(null);
            this.dgn.setVisibility(8);
            this.dgn.setTag(null);
            this.dgq.setVisibility(8);
            this.dgr.setVisibility(8);
            this.dgs.setVisibility(8);
            return;
        }
        try {
            e(chatMessage);
            this.cjV.setDefaultResource(d.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.cjV.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.cjV.c(currentPortrait, 12, false);
                }
            }
            this.cjV.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dgH.setVisibility(8);
            this.dgJ.setVisibility(8);
            this.dgK.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dgH.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dgv) {
                            if (chatMessage.isHasRead()) {
                                this.dgJ.setVisibility(0);
                                this.dgK.setVisibility(8);
                                break;
                            } else {
                                this.dgJ.setVisibility(8);
                                this.dgK.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dgH.getVisibility() == 0) {
                this.dgH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.dfO.a(view2, 1, MsgrightView.this.avi, 0L);
                    }
                });
            }
            this.dgm.setVisibility(8);
            lL(8);
            this.dgn.setVisibility(8);
            this.dgo.setVisibility(8);
            this.dgr.setVisibility(8);
            this.dgq.setVisibility(8);
            this.dgs.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dgn.setVisibility(0);
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
