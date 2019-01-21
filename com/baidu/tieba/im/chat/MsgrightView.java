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
    private HeadImageView dOi;
    private ImageButton eMn;
    protected TextView eMo;
    private TextView eMp;
    private TextView eMq;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgright_view);
        initView();
        if (this.eLY != null && this.eLY.getImage() != null && (this.eLY.getImage() instanceof ChatClipImageItemView)) {
            this.eLY.getImage().setLeft(false);
        }
        this.eMo = (TextView) findViewById(e.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.eMn = (ImageButton) findViewById(e.g.btn_msgitem_resend);
        this.dOi = (HeadImageView) findViewById(e.g.img_msgitem_photo);
        this.dOi.setAutoChangeStyle(false);
        this.dOi.setDrawerType(1);
        this.dOi.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dOi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.eLt.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.eMp = (TextView) findViewById(e.g.has_read);
        this.eMq = (TextView) findViewById(e.g.has_sent);
        this.eLV.setIsLeft(false);
        this.eLW.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.eMo.getVisibility() != 8) {
                this.eMo.setVisibility(8);
                this.eLY.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.eMo.getVisibility() != 8) {
                this.eMo.setVisibility(8);
                this.eLY.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.eLY.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(e.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.eMo.setText(chatMessage.getProgressValue() + "%");
            this.eMo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dxK.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.eMn.setVisibility(8);
            this.eMp.setVisibility(8);
            this.eMq.setVisibility(8);
            this.eLR.setVisibility(0);
            this.eLR.setText(null);
            pQ(8);
            this.eLY.getImage().setTag(null);
            this.eLS.setVisibility(8);
            this.eLS.setTag(null);
            this.eLV.setVisibility(8);
            this.eLW.setVisibility(8);
            this.eLX.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dOi.setDefaultResource(e.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dOi.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dOi.startLoad(currentPortrait, 12, false);
                }
            }
            this.dOi.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.eMn.setVisibility(8);
            this.eMp.setVisibility(8);
            this.eMq.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.eMn.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.eMa) {
                            if (chatMessage.isHasRead()) {
                                this.eMp.setVisibility(0);
                                this.eMq.setVisibility(8);
                                break;
                            } else {
                                this.eMp.setVisibility(8);
                                this.eMq.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.eMn.getVisibility() == 0) {
                this.eMn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.eLt.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.eLR.setVisibility(8);
            pQ(8);
            this.eLS.setVisibility(8);
            this.eLT.setVisibility(8);
            this.eLW.setVisibility(8);
            this.eLV.setVisibility(8);
            this.eLX.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.eLS.setVisibility(0);
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
