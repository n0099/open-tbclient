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
    private HeadImageView hby;
    private ImageButton ieM;
    protected TextView ieN;
    private TextView ieO;
    private TextView ieP;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.iex != null && this.iex.getImage() != null && (this.iex.getImage() instanceof ChatClipImageItemView)) {
            this.iex.getImage().setLeft(false);
        }
        this.ieN = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.ieM = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.hby = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hby.setAutoChangeStyle(false);
        this.hby.setDrawerType(1);
        this.hby.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.hby.setPlaceHolder(1);
        this.hby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.idU.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.ieO = (TextView) findViewById(R.id.has_read);
        this.ieP = (TextView) findViewById(R.id.has_sent);
        this.ieu.setIsLeft(false);
        this.iev.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.ieN.getVisibility() != 8) {
                this.ieN.setVisibility(8);
                this.iex.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.ieN.getVisibility() != 8) {
                this.ieN.setVisibility(8);
                this.iex.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.iex.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.ieN.setText(chatMessage.getProgressValue() + "%");
            this.ieN.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.eSo.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.ieM.setVisibility(8);
            this.ieO.setVisibility(8);
            this.ieP.setVisibility(8);
            this.ieq.setVisibility(0);
            this.ieq.setText(null);
            wH(8);
            this.iex.getImage().setTag(null);
            this.ier.setVisibility(8);
            this.ier.setTag(null);
            this.ieu.setVisibility(8);
            this.iev.setVisibility(8);
            this.iew.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.hby.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.hby.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.hby.startLoad(currentAvatar, 12, false);
                }
            }
            this.hby.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.ieM.setVisibility(8);
            this.ieO.setVisibility(8);
            this.ieP.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.ieM.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.iez) {
                            if (chatMessage.isHasRead()) {
                                this.ieO.setVisibility(0);
                                this.ieP.setVisibility(8);
                                break;
                            } else {
                                this.ieO.setVisibility(8);
                                this.ieP.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.ieM.getVisibility() == 0) {
                this.ieM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.idU.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.ieq.setVisibility(8);
            wH(8);
            this.ier.setVisibility(8);
            this.ies.setVisibility(8);
            this.iev.setVisibility(8);
            this.ieu.setVisibility(8);
            this.iew.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.ier.setVisibility(0);
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
