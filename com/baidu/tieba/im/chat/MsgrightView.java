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
    private HeadImageView kAp;
    private ImageButton kBl;
    protected TextView kBm;
    private TextView kBn;
    private TextView kBo;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.kAW != null && this.kAW.getImage() != null && (this.kAW.getImage() instanceof ChatClipImageItemView)) {
            this.kAW.getImage().setLeft(false);
        }
        this.kBm = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.kBl = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.kAp = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.kAp.setAutoChangeStyle(false);
        this.kAp.setDrawerType(1);
        this.kAp.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.kAp.setPlaceHolder(1);
        this.kAp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.kAt.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.kBn = (TextView) findViewById(R.id.has_read);
        this.kBo = (TextView) findViewById(R.id.has_sent);
        this.kAT.setIsLeft(false);
        this.kAU.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.e
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.kBm.getVisibility() != 8) {
                this.kBm.setVisibility(8);
                this.kAW.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.kBm.getVisibility() != 8) {
                this.kBm.setVisibility(8);
                this.kAW.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.kAW.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.kBm.setText(chatMessage.getProgressValue() + "%");
            this.kBm.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.e
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.gDC.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.kBl.setVisibility(8);
            this.kBn.setVisibility(8);
            this.kBo.setVisibility(8);
            this.kAP.setVisibility(0);
            this.kAP.setText(null);
            CI(8);
            this.kAW.getImage().setTag(null);
            this.kAQ.setVisibility(8);
            this.kAQ.setTag(null);
            this.kAT.setVisibility(8);
            this.kAU.setVisibility(8);
            this.kAV.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.kAp.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.kAp.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.kAp.startLoad(currentAvatar, 12, false);
                }
            }
            this.kAp.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.kBl.setVisibility(8);
            this.kBn.setVisibility(8);
            this.kBo.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.kBl.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.kAY) {
                            if (chatMessage.isHasRead()) {
                                this.kBn.setVisibility(0);
                                this.kBo.setVisibility(8);
                                break;
                            } else {
                                this.kBn.setVisibility(8);
                                this.kBo.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.kBl.getVisibility() == 0) {
                this.kBl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.kAt.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.kAP.setVisibility(8);
            CI(8);
            this.kAQ.setVisibility(8);
            this.kAR.setVisibility(8);
            this.kAU.setVisibility(8);
            this.kAT.setVisibility(8);
            this.kAV.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.kAQ.setVisibility(0);
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
