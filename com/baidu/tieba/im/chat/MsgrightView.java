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
    private HeadImageView isB;
    private ImageButton jEb;
    protected TextView jEc;
    private TextView jEd;
    private TextView jEe;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.jDM != null && this.jDM.getImage() != null && (this.jDM.getImage() instanceof ChatClipImageItemView)) {
            this.jDM.getImage().setLeft(false);
        }
        this.jEc = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jEb = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.isB = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.isB.setAutoChangeStyle(false);
        this.isB.setDrawerType(1);
        this.isB.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.isB.setPlaceHolder(1);
        this.isB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.jDj.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.jEd = (TextView) findViewById(R.id.has_read);
        this.jEe = (TextView) findViewById(R.id.has_sent);
        this.jDJ.setIsLeft(false);
        this.jDK.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.jEc.getVisibility() != 8) {
                this.jEc.setVisibility(8);
                this.jDM.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.jEc.getVisibility() != 8) {
                this.jEc.setVisibility(8);
                this.jDM.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.jDM.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.jEc.setText(chatMessage.getProgressValue() + "%");
            this.jEc.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.fWB.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.jEb.setVisibility(8);
            this.jEd.setVisibility(8);
            this.jEe.setVisibility(8);
            this.jDF.setVisibility(0);
            this.jDF.setText(null);
            BS(8);
            this.jDM.getImage().setTag(null);
            this.jDG.setVisibility(8);
            this.jDG.setTag(null);
            this.jDJ.setVisibility(8);
            this.jDK.setVisibility(8);
            this.jDL.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.isB.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.isB.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.isB.startLoad(currentAvatar, 12, false);
                }
            }
            this.isB.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.jEb.setVisibility(8);
            this.jEd.setVisibility(8);
            this.jEe.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.jEb.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.jDO) {
                            if (chatMessage.isHasRead()) {
                                this.jEd.setVisibility(0);
                                this.jEe.setVisibility(8);
                                break;
                            } else {
                                this.jEd.setVisibility(8);
                                this.jEe.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.jEb.getVisibility() == 0) {
                this.jEb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.jDj.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.jDF.setVisibility(8);
            BS(8);
            this.jDG.setVisibility(8);
            this.jDH.setVisibility(8);
            this.jDK.setVisibility(8);
            this.jDJ.setVisibility(8);
            this.jDL.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.jDG.setVisibility(0);
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
