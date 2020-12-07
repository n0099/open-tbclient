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
    private HeadImageView kjR;
    private ImageButton kkN;
    protected TextView kkO;
    private TextView kkP;
    private TextView kkQ;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.kky != null && this.kky.getImage() != null && (this.kky.getImage() instanceof ChatClipImageItemView)) {
            this.kky.getImage().setLeft(false);
        }
        this.kkO = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.kkN = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.kjR = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.kjR.setAutoChangeStyle(false);
        this.kjR.setDrawerType(1);
        this.kjR.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.kjR.setPlaceHolder(1);
        this.kjR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.kjV.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.kkP = (TextView) findViewById(R.id.has_read);
        this.kkQ = (TextView) findViewById(R.id.has_sent);
        this.kkv.setIsLeft(false);
        this.kkw.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.kkO.getVisibility() != 8) {
                this.kkO.setVisibility(8);
                this.kky.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.kkO.getVisibility() != 8) {
                this.kkO.setVisibility(8);
                this.kky.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.kky.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.kkO.setText(chatMessage.getProgressValue() + "%");
            this.kkO.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.guj.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.kkN.setVisibility(8);
            this.kkP.setVisibility(8);
            this.kkQ.setVisibility(8);
            this.kkr.setVisibility(0);
            this.kkr.setText(null);
            DL(8);
            this.kky.getImage().setTag(null);
            this.kks.setVisibility(8);
            this.kks.setTag(null);
            this.kkv.setVisibility(8);
            this.kkw.setVisibility(8);
            this.kkx.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.kjR.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.kjR.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.kjR.startLoad(currentAvatar, 12, false);
                }
            }
            this.kjR.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.kkN.setVisibility(8);
            this.kkP.setVisibility(8);
            this.kkQ.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.kkN.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.kkA) {
                            if (chatMessage.isHasRead()) {
                                this.kkP.setVisibility(0);
                                this.kkQ.setVisibility(8);
                                break;
                            } else {
                                this.kkP.setVisibility(8);
                                this.kkQ.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.kkN.getVisibility() == 0) {
                this.kkN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.kjV.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.kkr.setVisibility(8);
            DL(8);
            this.kks.setVisibility(8);
            this.kkt.setVisibility(8);
            this.kkw.setVisibility(8);
            this.kkv.setVisibility(8);
            this.kkx.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.kks.setVisibility(0);
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
