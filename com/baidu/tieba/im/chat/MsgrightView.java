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
    private HeadImageView glX;
    private ImageButton hnD;
    protected TextView hnE;
    private TextView hnF;
    private TextView hnG;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.hno != null && this.hno.getImage() != null && (this.hno.getImage() instanceof ChatClipImageItemView)) {
            this.hno.getImage().setLeft(false);
        }
        this.hnE = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.hnD = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.glX = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.glX.setAutoChangeStyle(false);
        this.glX.setDrawerType(1);
        this.glX.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.glX.setPlaceHolder(1);
        this.glX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.hmL.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.hnF = (TextView) findViewById(R.id.has_read);
        this.hnG = (TextView) findViewById(R.id.has_sent);
        this.hnl.setIsLeft(false);
        this.hnm.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.hnE.getVisibility() != 8) {
                this.hnE.setVisibility(8);
                this.hno.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.hnE.getVisibility() != 8) {
                this.hnE.setVisibility(8);
                this.hno.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.hno.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.hnE.setText(chatMessage.getProgressValue() + "%");
            this.hnE.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.eji.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.hnD.setVisibility(8);
            this.hnF.setVisibility(8);
            this.hnG.setVisibility(8);
            this.hnh.setVisibility(0);
            this.hnh.setText(null);
            vQ(8);
            this.hno.getImage().setTag(null);
            this.hni.setVisibility(8);
            this.hni.setTag(null);
            this.hnl.setVisibility(8);
            this.hnm.setVisibility(8);
            this.hnn.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.glX.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.glX.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.glX.startLoad(currentAvatar, 12, false);
                }
            }
            this.glX.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.hnD.setVisibility(8);
            this.hnF.setVisibility(8);
            this.hnG.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.hnD.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.hnq) {
                            if (chatMessage.isHasRead()) {
                                this.hnF.setVisibility(0);
                                this.hnG.setVisibility(8);
                                break;
                            } else {
                                this.hnF.setVisibility(8);
                                this.hnG.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.hnD.getVisibility() == 0) {
                this.hnD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.hmL.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.hnh.setVisibility(8);
            vQ(8);
            this.hni.setVisibility(8);
            this.hnj.setVisibility(8);
            this.hnm.setVisibility(8);
            this.hnl.setVisibility(8);
            this.hnn.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.hni.setVisibility(0);
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
