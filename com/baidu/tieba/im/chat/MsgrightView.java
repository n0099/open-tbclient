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
    private HeadImageView dKK;
    private ImageButton eIJ;
    protected TextView eIK;
    private TextView eIL;
    private TextView eIM;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgright_view);
        initView();
        if (this.eIu != null && this.eIu.getImage() != null && (this.eIu.getImage() instanceof ChatClipImageItemView)) {
            this.eIu.getImage().setLeft(false);
        }
        this.eIK = (TextView) findViewById(e.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.eIJ = (ImageButton) findViewById(e.g.btn_msgitem_resend);
        this.dKK = (HeadImageView) findViewById(e.g.img_msgitem_photo);
        this.dKK.setAutoChangeStyle(false);
        this.dKK.setDrawerType(1);
        this.dKK.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.eHP.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.eIL = (TextView) findViewById(e.g.has_read);
        this.eIM = (TextView) findViewById(e.g.has_sent);
        this.eIr.setIsLeft(false);
        this.eIs.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.eIK.getVisibility() != 8) {
                this.eIK.setVisibility(8);
                this.eIu.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.eIK.getVisibility() != 8) {
                this.eIK.setVisibility(8);
                this.eIu.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.eIu.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(e.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.eIK.setText(chatMessage.getProgressValue() + "%");
            this.eIK.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dun.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.eIJ.setVisibility(8);
            this.eIL.setVisibility(8);
            this.eIM.setVisibility(8);
            this.eIn.setVisibility(0);
            this.eIn.setText(null);
            pC(8);
            this.eIu.getImage().setTag(null);
            this.eIo.setVisibility(8);
            this.eIo.setTag(null);
            this.eIr.setVisibility(8);
            this.eIs.setVisibility(8);
            this.eIt.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dKK.setDefaultResource(e.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dKK.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dKK.startLoad(currentPortrait, 12, false);
                }
            }
            this.dKK.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.eIJ.setVisibility(8);
            this.eIL.setVisibility(8);
            this.eIM.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.eIJ.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.eIw) {
                            if (chatMessage.isHasRead()) {
                                this.eIL.setVisibility(0);
                                this.eIM.setVisibility(8);
                                break;
                            } else {
                                this.eIL.setVisibility(8);
                                this.eIM.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.eIJ.getVisibility() == 0) {
                this.eIJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.eHP.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.eIn.setVisibility(8);
            pC(8);
            this.eIo.setVisibility(8);
            this.eIp.setVisibility(8);
            this.eIs.setVisibility(8);
            this.eIr.setVisibility(8);
            this.eIt.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.eIo.setVisibility(0);
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
