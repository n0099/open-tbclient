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
public class MsgrightView extends e {
    private static final String TAG = MsgrightView.class.getName();
    private ImageButton kAX;
    protected TextView kAY;
    private TextView kAZ;
    private HeadImageView kAb;
    private TextView kBa;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.kAI != null && this.kAI.getImage() != null && (this.kAI.getImage() instanceof ChatClipImageItemView)) {
            this.kAI.getImage().setLeft(false);
        }
        this.kAY = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.kAX = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.kAb = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.kAb.setAutoChangeStyle(false);
        this.kAb.setDrawerType(1);
        this.kAb.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.kAb.setPlaceHolder(1);
        this.kAb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.kAf.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.kAZ = (TextView) findViewById(R.id.has_read);
        this.kBa = (TextView) findViewById(R.id.has_sent);
        this.kAF.setIsLeft(false);
        this.kAG.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.e
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.kAY.getVisibility() != 8) {
                this.kAY.setVisibility(8);
                this.kAI.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.kAY.getVisibility() != 8) {
                this.kAY.setVisibility(8);
                this.kAI.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.kAI.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.kAY.setText(chatMessage.getProgressValue() + "%");
            this.kAY.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.e
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.gDo.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.kAX.setVisibility(8);
            this.kAZ.setVisibility(8);
            this.kBa.setVisibility(8);
            this.kAB.setVisibility(0);
            this.kAB.setText(null);
            CI(8);
            this.kAI.getImage().setTag(null);
            this.kAC.setVisibility(8);
            this.kAC.setTag(null);
            this.kAF.setVisibility(8);
            this.kAG.setVisibility(8);
            this.kAH.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.kAb.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.kAb.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.kAb.startLoad(currentAvatar, 12, false);
                }
            }
            this.kAb.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.kAX.setVisibility(8);
            this.kAZ.setVisibility(8);
            this.kBa.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.kAX.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.kAK) {
                            if (chatMessage.isHasRead()) {
                                this.kAZ.setVisibility(0);
                                this.kBa.setVisibility(8);
                                break;
                            } else {
                                this.kAZ.setVisibility(8);
                                this.kBa.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.kAX.getVisibility() == 0) {
                this.kAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.kAf.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.kAB.setVisibility(8);
            CI(8);
            this.kAC.setVisibility(8);
            this.kAD.setVisibility(8);
            this.kAG.setVisibility(8);
            this.kAF.setVisibility(8);
            this.kAH.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.kAC.setVisibility(0);
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
