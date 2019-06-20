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
    private HeadImageView frV;
    private ImageButton gtv;
    protected TextView gtw;
    private TextView gtx;
    private TextView gty;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.gtg != null && this.gtg.getImage() != null && (this.gtg.getImage() instanceof ChatClipImageItemView)) {
            this.gtg.getImage().setLeft(false);
        }
        this.gtw = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gtv = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.frV = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.frV.setAutoChangeStyle(false);
        this.frV.setDrawerType(1);
        this.frV.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.frV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.gsB.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.gtx = (TextView) findViewById(R.id.has_read);
        this.gty = (TextView) findViewById(R.id.has_sent);
        this.gtd.setIsLeft(false);
        this.gte.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.gtw.getVisibility() != 8) {
                this.gtw.setVisibility(8);
                this.gtg.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.gtw.getVisibility() != 8) {
                this.gtw.setVisibility(8);
                this.gtg.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.gtg.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.gtw.setText(chatMessage.getProgressValue() + "%");
            this.gtw.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.faX.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.gtv.setVisibility(8);
            this.gtx.setVisibility(8);
            this.gty.setVisibility(8);
            this.gsZ.setVisibility(0);
            this.gsZ.setText(null);
            uD(8);
            this.gtg.getImage().setTag(null);
            this.gta.setVisibility(8);
            this.gta.setTag(null);
            this.gtd.setVisibility(8);
            this.gte.setVisibility(8);
            this.gtf.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.frV.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.frV.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.frV.startLoad(currentPortrait, 12, false);
                }
            }
            this.frV.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.gtv.setVisibility(8);
            this.gtx.setVisibility(8);
            this.gty.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.gtv.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.gti) {
                            if (chatMessage.isHasRead()) {
                                this.gtx.setVisibility(0);
                                this.gty.setVisibility(8);
                                break;
                            } else {
                                this.gtx.setVisibility(8);
                                this.gty.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.gtv.getVisibility() == 0) {
                this.gtv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.gsB.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.gsZ.setVisibility(8);
            uD(8);
            this.gta.setVisibility(8);
            this.gtb.setVisibility(8);
            this.gte.setVisibility(8);
            this.gtd.setVisibility(8);
            this.gtf.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.gta.setVisibility(0);
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
