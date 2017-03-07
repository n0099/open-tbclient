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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class MsgrightView extends ar {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView bPn;
    private ProgressBar bqO;
    private ImageButton cPP;
    protected TextView cPQ;
    private TextView cPR;
    private TextView cPS;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, w.j.msg_msgright_view);
        initView();
        if (this.cPB != null && this.cPB.getImage() != null && (this.cPB.getImage() instanceof ChatClipImageItemView)) {
            this.cPB.getImage().setLeft(false);
        }
        this.cPQ = (TextView) findViewById(w.h.img_msgitem_progressbar);
        this.bqO = (ProgressBar) findViewById(w.h.progress);
        this.cPP = (ImageButton) findViewById(w.h.btn_msgitem_resend);
        this.bPn = (HeadImageView) findViewById(w.h.img_msgitem_photo);
        this.bPn.setAutoChangeStyle(false);
        this.bPn.setDrawerType(1);
        this.bPn.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext.getContext(), 4.0f));
        this.bPn.setOnClickListener(new bm(this));
        this.cPR = (TextView) findViewById(w.h.has_read);
        this.cPS = (TextView) findViewById(w.h.has_sent);
        this.cPy.setIsLeft(false);
        this.cPz.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.cPQ.getVisibility() != 8) {
                this.cPQ.setVisibility(8);
                this.cPB.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.cPQ.getVisibility() != 8) {
                this.cPQ.setVisibility(8);
                this.cPB.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.cPB.getImage().setColorFilter(TbadkCoreApplication.m9getInst().getApp().getResources().getColor(w.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.cPQ.setText(String.valueOf(chatMessage.getProgressValue()) + "%");
            this.cPQ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.ar
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.bJu.setVisibility(8);
            this.bqO.setVisibility(8);
            this.cPP.setVisibility(8);
            this.cPR.setVisibility(8);
            this.cPS.setVisibility(8);
            this.cPu.setVisibility(0);
            this.cPu.setText(null);
            ld(8);
            this.cPB.getImage().setTag(null);
            this.cPv.setVisibility(8);
            this.cPv.setTag(null);
            this.cPy.setVisibility(8);
            this.cPz.setVisibility(8);
            this.cPA.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.bPn.setDefaultResource(w.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.bPn.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.bPn.c(currentPortrait, 12, false);
                }
            }
            this.bPn.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.bqO.setVisibility(8);
            this.cPP.setVisibility(8);
            this.cPR.setVisibility(8);
            this.cPS.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.bqO.setVisibility(0);
                        break;
                    case 2:
                        this.cPP.setVisibility(0);
                        break;
                    case 3:
                        this.bqO.setVisibility(8);
                        if (this.cPD) {
                            if (chatMessage.isHasRead()) {
                                this.cPR.setVisibility(0);
                                this.cPS.setVisibility(8);
                                break;
                            } else {
                                this.cPR.setVisibility(8);
                                this.cPS.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.cPP.getVisibility() == 0) {
                this.cPP.setOnClickListener(new bn(this));
            }
            this.cPu.setVisibility(8);
            ld(8);
            this.cPv.setVisibility(8);
            this.cPw.setVisibility(8);
            this.cPz.setVisibility(8);
            this.cPy.setVisibility(8);
            this.cPA.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.cPv.setVisibility(0);
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
