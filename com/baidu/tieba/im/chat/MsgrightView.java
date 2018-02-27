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
    private HeadImageView dGC;
    private TextView ewA;
    private ImageButton ewx;
    protected TextView ewy;
    private TextView ewz;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.ewi != null && this.ewi.getImage() != null && (this.ewi.getImage() instanceof ChatClipImageItemView)) {
            this.ewi.getImage().setLeft(false);
        }
        this.ewy = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.ewx = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.dGC = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.dGC.setAutoChangeStyle(false);
        this.dGC.setDrawerType(1);
        this.dGC.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.dGC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.evD.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.ewz = (TextView) findViewById(d.g.has_read);
        this.ewA = (TextView) findViewById(d.g.has_sent);
        this.ewf.setIsLeft(false);
        this.ewg.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.ewy.getVisibility() != 8) {
                this.ewy.setVisibility(8);
                this.ewi.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.ewy.getVisibility() != 8) {
                this.ewy.setVisibility(8);
                this.ewi.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.ewi.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0141d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.ewy.setText(chatMessage.getProgressValue() + "%");
            this.ewy.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.duR.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.ewx.setVisibility(8);
            this.ewz.setVisibility(8);
            this.ewA.setVisibility(8);
            this.ewb.setVisibility(0);
            this.ewb.setText(null);
            pI(8);
            this.ewi.getImage().setTag(null);
            this.ewc.setVisibility(8);
            this.ewc.setTag(null);
            this.ewf.setVisibility(8);
            this.ewg.setVisibility(8);
            this.ewh.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.dGC.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.dGC.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.dGC.startLoad(currentPortrait, 12, false);
                }
            }
            this.dGC.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.ewx.setVisibility(8);
            this.ewz.setVisibility(8);
            this.ewA.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.ewx.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.ewk) {
                            if (chatMessage.isHasRead()) {
                                this.ewz.setVisibility(0);
                                this.ewA.setVisibility(8);
                                break;
                            } else {
                                this.ewz.setVisibility(8);
                                this.ewA.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.ewx.getVisibility() == 0) {
                this.ewx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.evD.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.ewb.setVisibility(8);
            pI(8);
            this.ewc.setVisibility(8);
            this.ewd.setVisibility(8);
            this.ewg.setVisibility(8);
            this.ewf.setVisibility(8);
            this.ewh.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.ewc.setVisibility(0);
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
