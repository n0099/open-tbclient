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
    private HeadImageView gpg;
    private ImageButton hrg;
    protected TextView hrh;
    private TextView hri;
    private TextView hrj;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.hqR != null && this.hqR.getImage() != null && (this.hqR.getImage() instanceof ChatClipImageItemView)) {
            this.hqR.getImage().setLeft(false);
        }
        this.hrh = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.hrg = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.gpg = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.gpg.setAutoChangeStyle(false);
        this.gpg.setDrawerType(1);
        this.gpg.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.gpg.setPlaceHolder(1);
        this.gpg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.hqo.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.hri = (TextView) findViewById(R.id.has_read);
        this.hrj = (TextView) findViewById(R.id.has_sent);
        this.hqO.setIsLeft(false);
        this.hqP.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.hrh.getVisibility() != 8) {
                this.hrh.setVisibility(8);
                this.hqR.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.hrh.getVisibility() != 8) {
                this.hrh.setVisibility(8);
                this.hqR.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.hqR.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.hrh.setText(chatMessage.getProgressValue() + "%");
            this.hrh.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.ejW.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.hrg.setVisibility(8);
            this.hri.setVisibility(8);
            this.hrj.setVisibility(8);
            this.hqK.setVisibility(0);
            this.hqK.setText(null);
            vV(8);
            this.hqR.getImage().setTag(null);
            this.hqL.setVisibility(8);
            this.hqL.setTag(null);
            this.hqO.setVisibility(8);
            this.hqP.setVisibility(8);
            this.hqQ.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.gpg.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.gpg.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.gpg.startLoad(currentAvatar, 12, false);
                }
            }
            this.gpg.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.hrg.setVisibility(8);
            this.hri.setVisibility(8);
            this.hrj.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.hrg.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.hqT) {
                            if (chatMessage.isHasRead()) {
                                this.hri.setVisibility(0);
                                this.hrj.setVisibility(8);
                                break;
                            } else {
                                this.hri.setVisibility(8);
                                this.hrj.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.hrg.getVisibility() == 0) {
                this.hrg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.hqo.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.hqK.setVisibility(8);
            vV(8);
            this.hqL.setVisibility(8);
            this.hqM.setVisibility(8);
            this.hqP.setVisibility(8);
            this.hqO.setVisibility(8);
            this.hqQ.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.hqL.setVisibility(0);
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
