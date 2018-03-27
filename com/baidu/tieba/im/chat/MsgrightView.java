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
    private HeadImageView dGH;
    private ImageButton ewN;
    protected TextView ewO;
    private TextView ewP;
    private TextView ewQ;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.ewy != null && this.ewy.getImage() != null && (this.ewy.getImage() instanceof ChatClipImageItemView)) {
            this.ewy.getImage().setLeft(false);
        }
        this.ewO = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.ewN = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.dGH = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dGH.setAutoChangeStyle(false);
        this.dGH.setDrawerType(1);
        this.dGH.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dGH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.evT.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.ewP = (TextView) findViewById(d.g.has_read);
        this.ewQ = (TextView) findViewById(d.g.has_sent);
        this.ewv.setIsLeft(false);
        this.eww.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.ewO.getVisibility() != 8) {
                this.ewO.setVisibility(8);
                this.ewy.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.ewO.getVisibility() != 8) {
                this.ewO.setVisibility(8);
                this.ewy.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.ewy.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0141d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.ewO.setText(chatMessage.getProgressValue() + "%");
            this.ewO.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.duU.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.ewN.setVisibility(8);
            this.ewP.setVisibility(8);
            this.ewQ.setVisibility(8);
            this.ewr.setVisibility(0);
            this.ewr.setText(null);
            pJ(8);
            this.ewy.getImage().setTag(null);
            this.ews.setVisibility(8);
            this.ews.setTag(null);
            this.ewv.setVisibility(8);
            this.eww.setVisibility(8);
            this.ewx.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dGH.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dGH.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dGH.startLoad(currentPortrait, 12, false);
                }
            }
            this.dGH.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.ewN.setVisibility(8);
            this.ewP.setVisibility(8);
            this.ewQ.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.ewN.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.ewA) {
                            if (chatMessage.isHasRead()) {
                                this.ewP.setVisibility(0);
                                this.ewQ.setVisibility(8);
                                break;
                            } else {
                                this.ewP.setVisibility(8);
                                this.ewQ.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.ewN.getVisibility() == 0) {
                this.ewN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.evT.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.ewr.setVisibility(8);
            pJ(8);
            this.ews.setVisibility(8);
            this.ewt.setVisibility(8);
            this.eww.setVisibility(8);
            this.ewv.setVisibility(8);
            this.ewx.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.ews.setVisibility(0);
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
