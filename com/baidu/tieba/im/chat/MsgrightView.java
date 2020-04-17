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
    private HeadImageView hbs;
    private ImageButton ieG;
    protected TextView ieH;
    private TextView ieI;
    private TextView ieJ;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.ier != null && this.ier.getImage() != null && (this.ier.getImage() instanceof ChatClipImageItemView)) {
            this.ier.getImage().setLeft(false);
        }
        this.ieH = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.ieG = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.hbs = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hbs.setAutoChangeStyle(false);
        this.hbs.setDrawerType(1);
        this.hbs.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.hbs.setPlaceHolder(1);
        this.hbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.idO.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.ieI = (TextView) findViewById(R.id.has_read);
        this.ieJ = (TextView) findViewById(R.id.has_sent);
        this.ieo.setIsLeft(false);
        this.iep.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.ieH.getVisibility() != 8) {
                this.ieH.setVisibility(8);
                this.ier.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.ieH.getVisibility() != 8) {
                this.ieH.setVisibility(8);
                this.ier.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.ier.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.ieH.setText(chatMessage.getProgressValue() + "%");
            this.ieH.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.eSj.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.ieG.setVisibility(8);
            this.ieI.setVisibility(8);
            this.ieJ.setVisibility(8);
            this.iek.setVisibility(0);
            this.iek.setText(null);
            wH(8);
            this.ier.getImage().setTag(null);
            this.iel.setVisibility(8);
            this.iel.setTag(null);
            this.ieo.setVisibility(8);
            this.iep.setVisibility(8);
            this.ieq.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.hbs.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.hbs.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.hbs.startLoad(currentAvatar, 12, false);
                }
            }
            this.hbs.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.ieG.setVisibility(8);
            this.ieI.setVisibility(8);
            this.ieJ.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.ieG.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.iet) {
                            if (chatMessage.isHasRead()) {
                                this.ieI.setVisibility(0);
                                this.ieJ.setVisibility(8);
                                break;
                            } else {
                                this.ieI.setVisibility(8);
                                this.ieJ.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.ieG.getVisibility() == 0) {
                this.ieG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.idO.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.iek.setVisibility(8);
            wH(8);
            this.iel.setVisibility(8);
            this.iem.setVisibility(8);
            this.iep.setVisibility(8);
            this.ieo.setVisibility(8);
            this.ieq.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.iel.setVisibility(0);
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
