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
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView dNy;
    private ImageButton eLA;
    protected TextView eLB;
    private TextView eLC;
    private TextView eLD;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, e.h.msg_msgright_view);
        initView();
        if (this.eLl != null && this.eLl.getImage() != null && (this.eLl.getImage() instanceof ChatClipImageItemView)) {
            this.eLl.getImage().setLeft(false);
        }
        this.eLB = (TextView) findViewById(e.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        this.eLA = (ImageButton) findViewById(e.g.btn_msgitem_resend);
        this.dNy = (HeadImageView) findViewById(e.g.img_msgitem_photo);
        this.dNy.setAutoChangeStyle(false);
        this.dNy.setDrawerType(1);
        this.dNy.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.eKG.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.eLC = (TextView) findViewById(e.g.has_read);
        this.eLD = (TextView) findViewById(e.g.has_sent);
        this.eLi.setIsLeft(false);
        this.eLj.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.eLB.getVisibility() != 8) {
                this.eLB.setVisibility(8);
                this.eLl.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.eLB.getVisibility() != 8) {
                this.eLB.setVisibility(8);
                this.eLl.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.eLl.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(e.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.eLB.setText(chatMessage.getProgressValue() + "%");
            this.eLB.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dxa.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.eLA.setVisibility(8);
            this.eLC.setVisibility(8);
            this.eLD.setVisibility(8);
            this.eLe.setVisibility(0);
            this.eLe.setText(null);
            pP(8);
            this.eLl.getImage().setTag(null);
            this.eLf.setVisibility(8);
            this.eLf.setTag(null);
            this.eLi.setVisibility(8);
            this.eLj.setVisibility(8);
            this.eLk.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dNy.setDefaultResource(e.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dNy.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dNy.startLoad(currentPortrait, 12, false);
                }
            }
            this.dNy.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.eLA.setVisibility(8);
            this.eLC.setVisibility(8);
            this.eLD.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.eLA.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.eLn) {
                            if (chatMessage.isHasRead()) {
                                this.eLC.setVisibility(0);
                                this.eLD.setVisibility(8);
                                break;
                            } else {
                                this.eLC.setVisibility(8);
                                this.eLD.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.eLA.getVisibility() == 0) {
                this.eLA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.eKG.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.eLe.setVisibility(8);
            pP(8);
            this.eLf.setVisibility(8);
            this.eLg.setVisibility(8);
            this.eLj.setVisibility(8);
            this.eLi.setVisibility(8);
            this.eLk.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.eLf.setVisibility(0);
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
