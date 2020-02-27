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
    private HeadImageView grh;
    private ImageButton htf;
    protected TextView htg;
    private TextView hth;
    private TextView hti;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.hsQ != null && this.hsQ.getImage() != null && (this.hsQ.getImage() instanceof ChatClipImageItemView)) {
            this.hsQ.getImage().setLeft(false);
        }
        this.htg = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.htf = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.grh = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.grh.setAutoChangeStyle(false);
        this.grh.setDrawerType(1);
        this.grh.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.grh.setPlaceHolder(1);
        this.grh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.hsn.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.hth = (TextView) findViewById(R.id.has_read);
        this.hti = (TextView) findViewById(R.id.has_sent);
        this.hsN.setIsLeft(false);
        this.hsO.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.htg.getVisibility() != 8) {
                this.htg.setVisibility(8);
                this.hsQ.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.htg.getVisibility() != 8) {
                this.htg.setVisibility(8);
                this.hsQ.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.hsQ.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.htg.setText(chatMessage.getProgressValue() + "%");
            this.htg.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.eoh.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.htf.setVisibility(8);
            this.hth.setVisibility(8);
            this.hti.setVisibility(8);
            this.hsJ.setVisibility(0);
            this.hsJ.setText(null);
            wb(8);
            this.hsQ.getImage().setTag(null);
            this.hsK.setVisibility(8);
            this.hsK.setTag(null);
            this.hsN.setVisibility(8);
            this.hsO.setVisibility(8);
            this.hsP.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.grh.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.grh.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.grh.startLoad(currentAvatar, 12, false);
                }
            }
            this.grh.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.htf.setVisibility(8);
            this.hth.setVisibility(8);
            this.hti.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.htf.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.hsS) {
                            if (chatMessage.isHasRead()) {
                                this.hth.setVisibility(0);
                                this.hti.setVisibility(8);
                                break;
                            } else {
                                this.hth.setVisibility(8);
                                this.hti.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.htf.getVisibility() == 0) {
                this.htf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.hsn.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.hsJ.setVisibility(8);
            wb(8);
            this.hsK.setVisibility(8);
            this.hsL.setVisibility(8);
            this.hsO.setVisibility(8);
            this.hsN.setVisibility(8);
            this.hsP.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.hsK.setVisibility(0);
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
