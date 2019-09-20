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
    private HeadImageView efW;
    private ImageButton gCp;
    protected TextView gCq;
    private TextView gCr;
    private TextView gCs;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.gCa != null && this.gCa.getImage() != null && (this.gCa.getImage() instanceof ChatClipImageItemView)) {
            this.gCa.getImage().setLeft(false);
        }
        this.gCq = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gCp = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.efW = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.efW.setAutoChangeStyle(false);
        this.efW.setDrawerType(1);
        this.efW.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.efW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.gBv.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.gCr = (TextView) findViewById(R.id.has_read);
        this.gCs = (TextView) findViewById(R.id.has_sent);
        this.gBX.setIsLeft(false);
        this.gBY.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.gCq.getVisibility() != 8) {
                this.gCq.setVisibility(8);
                this.gCa.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.gCq.getVisibility() != 8) {
                this.gCq.setVisibility(8);
                this.gCa.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.gCa.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.gCq.setText(chatMessage.getProgressValue() + "%");
            this.gCq.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.drN.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.gCp.setVisibility(8);
            this.gCr.setVisibility(8);
            this.gCs.setVisibility(8);
            this.gBT.setVisibility(0);
            this.gBT.setText(null);
            vk(8);
            this.gCa.getImage().setTag(null);
            this.gBU.setVisibility(8);
            this.gBU.setTag(null);
            this.gBX.setVisibility(8);
            this.gBY.setVisibility(8);
            this.gBZ.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.efW.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.efW.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.efW.startLoad(currentPortrait, 12, false);
                }
            }
            this.efW.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.gCp.setVisibility(8);
            this.gCr.setVisibility(8);
            this.gCs.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.gCp.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.gCc) {
                            if (chatMessage.isHasRead()) {
                                this.gCr.setVisibility(0);
                                this.gCs.setVisibility(8);
                                break;
                            } else {
                                this.gCr.setVisibility(8);
                                this.gCs.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.gCp.getVisibility() == 0) {
                this.gCp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.gBv.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.gBT.setVisibility(8);
            vk(8);
            this.gBU.setVisibility(8);
            this.gBV.setVisibility(8);
            this.gBY.setVisibility(8);
            this.gBX.setVisibility(8);
            this.gBZ.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.gBU.setVisibility(0);
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
