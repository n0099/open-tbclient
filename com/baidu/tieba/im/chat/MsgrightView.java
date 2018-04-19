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
    private HeadImageView cZE;
    private ImageButton dRt;
    protected TextView dRu;
    private TextView dRv;
    private TextView dRw;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.i.msg_msgright_view);
        initView();
        if (this.dRe != null && this.dRe.getImage() != null && (this.dRe.getImage() instanceof ChatClipImageItemView)) {
            this.dRe.getImage().setLeft(false);
        }
        this.dRu = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.dRt = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.cZE = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.cZE.setAutoChangeStyle(false);
        this.cZE.setDrawerType(1);
        this.cZE.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.cZE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MsgrightView.this.dQz.a(view2, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.dRv = (TextView) findViewById(d.g.has_read);
        this.dRw = (TextView) findViewById(d.g.has_sent);
        this.dRb.setIsLeft(false);
        this.dRc.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view2, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dRu.getVisibility() != 8) {
                this.dRu.setVisibility(8);
                this.dRe.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dRu.getVisibility() != 8) {
                this.dRu.setVisibility(8);
                this.dRe.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dRe.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0126d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dRu.setText(chatMessage.getProgressValue() + "%");
            this.dRu.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view2, ChatMessage chatMessage) {
        super.b(view2, chatMessage);
        if (chatMessage == null) {
            this.cNI.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dRt.setVisibility(8);
            this.dRv.setVisibility(8);
            this.dRw.setVisibility(8);
            this.dQX.setVisibility(0);
            this.dQX.setText(null);
            nh(8);
            this.dRe.getImage().setTag(null);
            this.dQY.setVisibility(8);
            this.dQY.setTag(null);
            this.dRb.setVisibility(8);
            this.dRc.setVisibility(8);
            this.dRd.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.cZE.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.cZE.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.cZE.startLoad(currentPortrait, 12, false);
                }
            }
            this.cZE.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dRt.setVisibility(8);
            this.dRv.setVisibility(8);
            this.dRw.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dRt.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dRg) {
                            if (chatMessage.isHasRead()) {
                                this.dRv.setVisibility(0);
                                this.dRw.setVisibility(8);
                                break;
                            } else {
                                this.dRv.setVisibility(8);
                                this.dRw.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dRt.getVisibility() == 0) {
                this.dRt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        MsgrightView.this.dQz.a(view3, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.dQX.setVisibility(8);
            nh(8);
            this.dQY.setVisibility(8);
            this.dQZ.setVisibility(8);
            this.dRc.setVisibility(8);
            this.dRb.setVisibility(8);
            this.dRd.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view2, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dQY.setVisibility(0);
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
                    c(view2, chatMessage, TAG);
                    return;
            }
        } catch (Exception e) {
        }
    }
}
