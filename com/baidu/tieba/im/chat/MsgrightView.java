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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class MsgrightView extends as {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView bHl;
    private TextView cIA;
    private TextView cIB;
    private ImageButton cIy;
    protected TextView cIz;
    private ProgressBar cdm;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, u.h.msg_msgright_view);
        initView();
        if (this.cIj != null && this.cIj.getImage() != null && (this.cIj.getImage() instanceof ChatClipImageItemView)) {
            this.cIj.getImage().setLeft(false);
        }
        this.cIz = (TextView) findViewById(u.g.img_msgitem_progressbar);
        this.cdm = (ProgressBar) findViewById(u.g.progress);
        this.cIy = (ImageButton) findViewById(u.g.btn_msgitem_resend);
        this.bHl = (HeadImageView) findViewById(u.g.img_msgitem_photo);
        this.bHl.setAutoChangeStyle(false);
        this.bHl.setDrawerType(1);
        this.bHl.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bHl.setOnClickListener(new bn(this));
        this.cIA = (TextView) findViewById(u.g.has_read);
        this.cIB = (TextView) findViewById(u.g.has_sent);
        this.cIg.setIsLeft(false);
        this.cIh.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.as
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cIz.getVisibility() != 8) {
                this.cIz.setVisibility(8);
                this.cIj.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cIz.getVisibility() != 8) {
                this.cIz.setVisibility(8);
                this.cIj.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cIj.getImage().setColorFilter(TbadkCoreApplication.m10getInst().getApp().getResources().getColor(u.d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cIz.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cIz.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.as
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bAf.setVisibility(8);
            this.cdm.setVisibility(8);
            this.cIy.setVisibility(8);
            this.cIA.setVisibility(8);
            this.cIB.setVisibility(8);
            this.cIc.setVisibility(0);
            this.cIc.setText(null);
            kx(8);
            this.cIj.getImage().setTag(null);
            this.cId.setVisibility(8);
            this.cId.setTag(null);
            this.cIg.setVisibility(8);
            this.cIh.setVisibility(8);
            this.cIi.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bHl.setDefaultResource(u.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bHl.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bHl.c(currentPortrait, 12, false);
                }
            }
            this.bHl.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.cdm.setVisibility(8);
            this.cIy.setVisibility(8);
            this.cIA.setVisibility(8);
            this.cIB.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.cdm.setVisibility(0);
                        break;
                    case 2:
                        this.cIy.setVisibility(0);
                        break;
                    case 3:
                        this.cdm.setVisibility(8);
                        if (this.cIl) {
                            if (chatMessage.isHasRead()) {
                                this.cIA.setVisibility(0);
                                this.cIB.setVisibility(8);
                                break;
                            } else {
                                this.cIA.setVisibility(8);
                                this.cIB.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cIy.getVisibility() == 0) {
                this.cIy.setOnClickListener(new bo(this));
            }
            this.cIc.setVisibility(8);
            kx(8);
            this.cId.setVisibility(8);
            this.cIe.setVisibility(8);
            this.cIh.setVisibility(8);
            this.cIg.setVisibility(8);
            this.cIi.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cId.setVisibility(0);
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
