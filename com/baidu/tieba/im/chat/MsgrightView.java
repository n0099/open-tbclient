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
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView dmh;
    private ImageButton ehE;
    protected TextView ehF;
    private TextView ehG;
    private TextView ehH;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgright_view);
        initView();
        if (this.ehp != null && this.ehp.getImage() != null && (this.ehp.getImage() instanceof ChatClipImageItemView)) {
            this.ehp.getImage().setLeft(false);
        }
        this.ehF = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.ehE = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.dmh = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dmh.setAutoChangeStyle(false);
        this.dmh.setDrawerType(1);
        this.dmh.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dmh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.egK.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.ehG = (TextView) findViewById(d.g.has_read);
        this.ehH = (TextView) findViewById(d.g.has_sent);
        this.ehm.setIsLeft(false);
        this.ehn.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.ehF.getVisibility() != 8) {
                this.ehF.setVisibility(8);
                this.ehp.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.ehF.getVisibility() != 8) {
                this.ehF.setVisibility(8);
                this.ehp.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.ehp.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0142d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.ehF.setText(chatMessage.getProgressValue() + "%");
            this.ehF.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cVU.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.ehE.setVisibility(8);
            this.ehG.setVisibility(8);
            this.ehH.setVisibility(8);
            this.ehi.setVisibility(0);
            this.ehi.setText(null);
            nz(8);
            this.ehp.getImage().setTag(null);
            this.ehj.setVisibility(8);
            this.ehj.setTag(null);
            this.ehm.setVisibility(8);
            this.ehn.setVisibility(8);
            this.eho.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dmh.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dmh.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dmh.startLoad(currentPortrait, 12, false);
                }
            }
            this.dmh.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.ehE.setVisibility(8);
            this.ehG.setVisibility(8);
            this.ehH.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.ehE.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.ehr) {
                            if (chatMessage.isHasRead()) {
                                this.ehG.setVisibility(0);
                                this.ehH.setVisibility(8);
                                break;
                            } else {
                                this.ehG.setVisibility(8);
                                this.ehH.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.ehE.getVisibility() == 0) {
                this.ehE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.egK.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.ehi.setVisibility(8);
            nz(8);
            this.ehj.setVisibility(8);
            this.ehk.setVisibility(8);
            this.ehn.setVisibility(8);
            this.ehm.setVisibility(8);
            this.eho.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.ehj.setVisibility(0);
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
