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
    private HeadImageView hWA;
    private TextView jgA;
    private TextView jgB;
    private ImageButton jgy;
    protected TextView jgz;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.jgj != null && this.jgj.getImage() != null && (this.jgj.getImage() instanceof ChatClipImageItemView)) {
            this.jgj.getImage().setLeft(false);
        }
        this.jgz = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jgy = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.hWA = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hWA.setAutoChangeStyle(false);
        this.hWA.setDrawerType(1);
        this.hWA.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.hWA.setPlaceHolder(1);
        this.hWA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.jfG.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.jgA = (TextView) findViewById(R.id.has_read);
        this.jgB = (TextView) findViewById(R.id.has_sent);
        this.jgg.setIsLeft(false);
        this.jgh.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.jgz.getVisibility() != 8) {
                this.jgz.setVisibility(8);
                this.jgj.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.jgz.getVisibility() != 8) {
                this.jgz.setVisibility(8);
                this.jgj.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.jgj.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.jgz.setText(chatMessage.getProgressValue() + "%");
            this.jgz.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.fGY.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.jgy.setVisibility(8);
            this.jgA.setVisibility(8);
            this.jgB.setVisibility(8);
            this.jgc.setVisibility(0);
            this.jgc.setText(null);
            AL(8);
            this.jgj.getImage().setTag(null);
            this.jgd.setVisibility(8);
            this.jgd.setTag(null);
            this.jgg.setVisibility(8);
            this.jgh.setVisibility(8);
            this.jgi.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.hWA.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.hWA.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.hWA.startLoad(currentAvatar, 12, false);
                }
            }
            this.hWA.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.jgy.setVisibility(8);
            this.jgA.setVisibility(8);
            this.jgB.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.jgy.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.jgl) {
                            if (chatMessage.isHasRead()) {
                                this.jgA.setVisibility(0);
                                this.jgB.setVisibility(8);
                                break;
                            } else {
                                this.jgA.setVisibility(8);
                                this.jgB.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.jgy.getVisibility() == 0) {
                this.jgy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.jfG.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.jgc.setVisibility(8);
            AL(8);
            this.jgd.setVisibility(8);
            this.jge.setVisibility(8);
            this.jgh.setVisibility(8);
            this.jgg.setVisibility(8);
            this.jgi.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.jgd.setVisibility(0);
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
