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
    private HeadImageView grj;
    private ImageButton hth;
    protected TextView hti;
    private TextView htj;
    private TextView htk;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.hsS != null && this.hsS.getImage() != null && (this.hsS.getImage() instanceof ChatClipImageItemView)) {
            this.hsS.getImage().setLeft(false);
        }
        this.hti = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.hth = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.grj = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.grj.setAutoChangeStyle(false);
        this.grj.setDrawerType(1);
        this.grj.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.grj.setPlaceHolder(1);
        this.grj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.hsp.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.htj = (TextView) findViewById(R.id.has_read);
        this.htk = (TextView) findViewById(R.id.has_sent);
        this.hsP.setIsLeft(false);
        this.hsQ.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.hti.getVisibility() != 8) {
                this.hti.setVisibility(8);
                this.hsS.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.hti.getVisibility() != 8) {
                this.hti.setVisibility(8);
                this.hsS.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.hsS.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.hti.setText(chatMessage.getProgressValue() + "%");
            this.hti.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.eoi.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.hth.setVisibility(8);
            this.htj.setVisibility(8);
            this.htk.setVisibility(8);
            this.hsL.setVisibility(0);
            this.hsL.setText(null);
            wb(8);
            this.hsS.getImage().setTag(null);
            this.hsM.setVisibility(8);
            this.hsM.setTag(null);
            this.hsP.setVisibility(8);
            this.hsQ.setVisibility(8);
            this.hsR.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.grj.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.grj.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.grj.startLoad(currentAvatar, 12, false);
                }
            }
            this.grj.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.hth.setVisibility(8);
            this.htj.setVisibility(8);
            this.htk.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.hth.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.hsU) {
                            if (chatMessage.isHasRead()) {
                                this.htj.setVisibility(0);
                                this.htk.setVisibility(8);
                                break;
                            } else {
                                this.htj.setVisibility(8);
                                this.htk.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.hth.getVisibility() == 0) {
                this.hth.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.hsp.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.hsL.setVisibility(8);
            wb(8);
            this.hsM.setVisibility(8);
            this.hsN.setVisibility(8);
            this.hsQ.setVisibility(8);
            this.hsP.setVisibility(8);
            this.hsR.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.hsM.setVisibility(0);
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
