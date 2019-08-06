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
    private HeadImageView eem;
    private TextView gAA;
    private TextView gAB;
    private ImageButton gAy;
    protected TextView gAz;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.gAj != null && this.gAj.getImage() != null && (this.gAj.getImage() instanceof ChatClipImageItemView)) {
            this.gAj.getImage().setLeft(false);
        }
        this.gAz = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gAy = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.eem = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.eem.setAutoChangeStyle(false);
        this.eem.setDrawerType(1);
        this.eem.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.eem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.gzE.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.gAA = (TextView) findViewById(R.id.has_read);
        this.gAB = (TextView) findViewById(R.id.has_sent);
        this.gAg.setIsLeft(false);
        this.gAh.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.gAz.getVisibility() != 8) {
                this.gAz.setVisibility(8);
                this.gAj.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.gAz.getVisibility() != 8) {
                this.gAz.setVisibility(8);
                this.gAj.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.gAj.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.gAz.setText(chatMessage.getProgressValue() + "%");
            this.gAz.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dqc.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.gAy.setVisibility(8);
            this.gAA.setVisibility(8);
            this.gAB.setVisibility(8);
            this.gAc.setVisibility(0);
            this.gAc.setText(null);
            vg(8);
            this.gAj.getImage().setTag(null);
            this.gAd.setVisibility(8);
            this.gAd.setTag(null);
            this.gAg.setVisibility(8);
            this.gAh.setVisibility(8);
            this.gAi.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.eem.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.eem.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.eem.startLoad(currentPortrait, 12, false);
                }
            }
            this.eem.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.gAy.setVisibility(8);
            this.gAA.setVisibility(8);
            this.gAB.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.gAy.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.gAl) {
                            if (chatMessage.isHasRead()) {
                                this.gAA.setVisibility(0);
                                this.gAB.setVisibility(8);
                                break;
                            } else {
                                this.gAA.setVisibility(8);
                                this.gAB.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.gAy.getVisibility() == 0) {
                this.gAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.gzE.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.gAc.setVisibility(8);
            vg(8);
            this.gAd.setVisibility(8);
            this.gAe.setVisibility(8);
            this.gAh.setVisibility(8);
            this.gAg.setVisibility(8);
            this.gAi.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.gAd.setVisibility(0);
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
