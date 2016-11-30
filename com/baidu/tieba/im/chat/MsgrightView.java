package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class MsgrightView extends as {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView bUx;
    private ProgressBar cub;
    private ImageButton dbi;
    protected TextView dbj;
    private TextView dbk;
    private TextView dbl;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, r.h.msg_msgright_view);
        initView();
        if (this.daT != null && this.daT.getImage() != null && (this.daT.getImage() instanceof ChatClipImageItemView)) {
            this.daT.getImage().setLeft(false);
        }
        this.dbj = (TextView) findViewById(r.g.img_msgitem_progressbar);
        this.cub = (ProgressBar) findViewById(r.g.progress);
        this.dbi = (ImageButton) findViewById(r.g.btn_msgitem_resend);
        this.bUx = (HeadImageView) findViewById(r.g.img_msgitem_photo);
        this.bUx.setAutoChangeStyle(false);
        this.bUx.setDrawerType(1);
        this.bUx.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bUx.setOnClickListener(new bn(this));
        this.dbk = (TextView) findViewById(r.g.has_read);
        this.dbl = (TextView) findViewById(r.g.has_sent);
        this.daQ.setIsLeft(false);
        this.daR.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dbj.getVisibility() != 8) {
                this.dbj.setVisibility(8);
                this.daT.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dbj.getVisibility() != 8) {
                this.dbj.setVisibility(8);
                this.daT.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.daT.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(r.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dbj.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.dbj.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bOB.setVisibility(8);
            this.cub.setVisibility(8);
            this.dbi.setVisibility(8);
            this.dbk.setVisibility(8);
            this.dbl.setVisibility(8);
            this.daM.setVisibility(0);
            this.daM.setText(null);
            lq(8);
            this.daT.getImage().setTag(null);
            this.daN.setVisibility(8);
            this.daN.setTag(null);
            this.daQ.setVisibility(8);
            this.daR.setVisibility(8);
            this.daS.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bUx.setDefaultResource(r.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bUx.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bUx.c(currentPortrait, 12, false);
                }
            }
            this.bUx.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cub.setVisibility(8);
            this.dbi.setVisibility(8);
            this.dbk.setVisibility(8);
            this.dbl.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.cub.setVisibility(0);
                        break;
                    case 2:
                        this.dbi.setVisibility(0);
                        break;
                    case 3:
                        this.cub.setVisibility(8);
                        if (this.daV) {
                            if (chatMessage.isHasRead()) {
                                this.dbk.setVisibility(0);
                                this.dbl.setVisibility(8);
                                break;
                            } else {
                                this.dbk.setVisibility(8);
                                this.dbl.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dbi.getVisibility() == 0) {
                this.dbi.setOnClickListener(new bo(this));
            }
            this.daM.setVisibility(8);
            lq(8);
            this.daN.setVisibility(8);
            this.daO.setVisibility(8);
            this.daR.setVisibility(8);
            this.daQ.setVisibility(8);
            this.daS.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.daN.setVisibility(0);
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
