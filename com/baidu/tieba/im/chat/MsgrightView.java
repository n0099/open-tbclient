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
    private HeadImageView gsg;
    private ImageButton huT;
    protected TextView huU;
    private TextView huV;
    private TextView huW;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.huE != null && this.huE.getImage() != null && (this.huE.getImage() instanceof ChatClipImageItemView)) {
            this.huE.getImage().setLeft(false);
        }
        this.huU = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.huT = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.gsg = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.gsg.setAutoChangeStyle(false);
        this.gsg.setDrawerType(1);
        this.gsg.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.gsg.setPlaceHolder(1);
        this.gsg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.hub.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.huV = (TextView) findViewById(R.id.has_read);
        this.huW = (TextView) findViewById(R.id.has_sent);
        this.huB.setIsLeft(false);
        this.huC.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.huU.getVisibility() != 8) {
                this.huU.setVisibility(8);
                this.huE.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.huU.getVisibility() != 8) {
                this.huU.setVisibility(8);
                this.huE.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.huE.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.huU.setText(chatMessage.getProgressValue() + "%");
            this.huU.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.eoM.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.huT.setVisibility(8);
            this.huV.setVisibility(8);
            this.huW.setVisibility(8);
            this.hux.setVisibility(0);
            this.hux.setText(null);
            wj(8);
            this.huE.getImage().setTag(null);
            this.huy.setVisibility(8);
            this.huy.setTag(null);
            this.huB.setVisibility(8);
            this.huC.setVisibility(8);
            this.huD.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.gsg.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.gsg.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.gsg.startLoad(currentAvatar, 12, false);
                }
            }
            this.gsg.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.huT.setVisibility(8);
            this.huV.setVisibility(8);
            this.huW.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.huT.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.huG) {
                            if (chatMessage.isHasRead()) {
                                this.huV.setVisibility(0);
                                this.huW.setVisibility(8);
                                break;
                            } else {
                                this.huV.setVisibility(8);
                                this.huW.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.huT.getVisibility() == 0) {
                this.huT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.hub.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.hux.setVisibility(8);
            wj(8);
            this.huy.setVisibility(8);
            this.huz.setVisibility(8);
            this.huC.setVisibility(8);
            this.huB.setVisibility(8);
            this.huD.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.huy.setVisibility(0);
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
