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
    private HeadImageView iEX;
    private ImageButton jQA;
    protected TextView jQB;
    private TextView jQC;
    private TextView jQD;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.jQl != null && this.jQl.getImage() != null && (this.jQl.getImage() instanceof ChatClipImageItemView)) {
            this.jQl.getImage().setLeft(false);
        }
        this.jQB = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jQA = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.iEX = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.iEX.setAutoChangeStyle(false);
        this.iEX.setDrawerType(1);
        this.iEX.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.iEX.setPlaceHolder(1);
        this.iEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.jPI.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.jQC = (TextView) findViewById(R.id.has_read);
        this.jQD = (TextView) findViewById(R.id.has_sent);
        this.jQi.setIsLeft(false);
        this.jQj.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.jQB.getVisibility() != 8) {
                this.jQB.setVisibility(8);
                this.jQl.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.jQB.getVisibility() != 8) {
                this.jQB.setVisibility(8);
                this.jQl.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.jQl.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.jQB.setText(chatMessage.getProgressValue() + "%");
            this.jQB.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.ggF.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.jQA.setVisibility(8);
            this.jQC.setVisibility(8);
            this.jQD.setVisibility(8);
            this.jQe.setVisibility(0);
            this.jQe.setText(null);
            Cl(8);
            this.jQl.getImage().setTag(null);
            this.jQf.setVisibility(8);
            this.jQf.setTag(null);
            this.jQi.setVisibility(8);
            this.jQj.setVisibility(8);
            this.jQk.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.iEX.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.iEX.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.iEX.startLoad(currentAvatar, 12, false);
                }
            }
            this.iEX.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.jQA.setVisibility(8);
            this.jQC.setVisibility(8);
            this.jQD.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.jQA.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.jQn) {
                            if (chatMessage.isHasRead()) {
                                this.jQC.setVisibility(0);
                                this.jQD.setVisibility(8);
                                break;
                            } else {
                                this.jQC.setVisibility(8);
                                this.jQD.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.jQA.getVisibility() == 0) {
                this.jQA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.jPI.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.jQe.setVisibility(8);
            Cl(8);
            this.jQf.setVisibility(8);
            this.jQg.setVisibility(8);
            this.jQj.setVisibility(8);
            this.jQi.setVisibility(8);
            this.jQk.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.jQf.setVisibility(0);
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
