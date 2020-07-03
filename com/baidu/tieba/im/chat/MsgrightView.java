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
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView hDg;
    private ImageButton iLo;
    protected TextView iLp;
    private TextView iLq;
    private TextView iLr;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.iKZ != null && this.iKZ.getImage() != null && (this.iKZ.getImage() instanceof ChatClipImageItemView)) {
            this.iKZ.getImage().setLeft(false);
        }
        this.iLp = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.iLo = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.hDg = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hDg.setAutoChangeStyle(false);
        this.hDg.setDrawerType(1);
        this.hDg.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.hDg.setPlaceHolder(1);
        this.hDg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.iKw.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.iLq = (TextView) findViewById(R.id.has_read);
        this.iLr = (TextView) findViewById(R.id.has_sent);
        this.iKW.setIsLeft(false);
        this.iKX.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.iLp.getVisibility() != 8) {
                this.iLp.setVisibility(8);
                this.iKZ.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.iLp.getVisibility() != 8) {
                this.iLp.setVisibility(8);
                this.iKZ.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.iKZ.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.iLp.setText(chatMessage.getProgressValue() + "%");
            this.iLp.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.fqs.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.iLo.setVisibility(8);
            this.iLq.setVisibility(8);
            this.iLr.setVisibility(8);
            this.iKS.setVisibility(0);
            this.iKS.setText(null);
            xZ(8);
            this.iKZ.getImage().setTag(null);
            this.iKT.setVisibility(8);
            this.iKT.setTag(null);
            this.iKW.setVisibility(8);
            this.iKX.setVisibility(8);
            this.iKY.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.hDg.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.hDg.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.hDg.startLoad(currentAvatar, 12, false);
                }
            }
            this.hDg.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.iLo.setVisibility(8);
            this.iLq.setVisibility(8);
            this.iLr.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.iLo.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.iLb) {
                            if (chatMessage.isHasRead()) {
                                this.iLq.setVisibility(0);
                                this.iLr.setVisibility(8);
                                break;
                            } else {
                                this.iLq.setVisibility(8);
                                this.iLr.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.iLo.getVisibility() == 0) {
                this.iLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.iKw.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.iKS.setVisibility(8);
            xZ(8);
            this.iKT.setVisibility(8);
            this.iKU.setVisibility(8);
            this.iKX.setVisibility(8);
            this.iKW.setVisibility(8);
            this.iKY.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.iKT.setVisibility(0);
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
