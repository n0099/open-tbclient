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
    private HeadImageView dOh;
    private ImageButton eMm;
    protected TextView eMn;
    private TextView eMo;
    private TextView eMp;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgright_view);
        initView();
        if (this.eLX != null && this.eLX.getImage() != null && (this.eLX.getImage() instanceof ChatClipImageItemView)) {
            this.eLX.getImage().setLeft(false);
        }
        this.eMn = (TextView) findViewById(e.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.eMm = (ImageButton) findViewById(e.g.btn_msgitem_resend);
        this.dOh = (HeadImageView) findViewById(e.g.img_msgitem_photo);
        this.dOh.setAutoChangeStyle(false);
        this.dOh.setDrawerType(1);
        this.dOh.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dOh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.eLs.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.eMo = (TextView) findViewById(e.g.has_read);
        this.eMp = (TextView) findViewById(e.g.has_sent);
        this.eLU.setIsLeft(false);
        this.eLV.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.eMn.getVisibility() != 8) {
                this.eMn.setVisibility(8);
                this.eLX.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.eMn.getVisibility() != 8) {
                this.eMn.setVisibility(8);
                this.eLX.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.eLX.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(e.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.eMn.setText(chatMessage.getProgressValue() + "%");
            this.eMn.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dxJ.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.eMm.setVisibility(8);
            this.eMo.setVisibility(8);
            this.eMp.setVisibility(8);
            this.eLQ.setVisibility(0);
            this.eLQ.setText(null);
            pQ(8);
            this.eLX.getImage().setTag(null);
            this.eLR.setVisibility(8);
            this.eLR.setTag(null);
            this.eLU.setVisibility(8);
            this.eLV.setVisibility(8);
            this.eLW.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dOh.setDefaultResource(e.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dOh.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dOh.startLoad(currentPortrait, 12, false);
                }
            }
            this.dOh.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.eMm.setVisibility(8);
            this.eMo.setVisibility(8);
            this.eMp.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.eMm.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.eLZ) {
                            if (chatMessage.isHasRead()) {
                                this.eMo.setVisibility(0);
                                this.eMp.setVisibility(8);
                                break;
                            } else {
                                this.eMo.setVisibility(8);
                                this.eMp.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.eMm.getVisibility() == 0) {
                this.eMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.eLs.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.eLQ.setVisibility(8);
            pQ(8);
            this.eLR.setVisibility(8);
            this.eLS.setVisibility(8);
            this.eLV.setVisibility(8);
            this.eLU.setVisibility(8);
            this.eLW.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.eLR.setVisibility(0);
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
