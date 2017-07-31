package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView cld;
    private ImageButton dhZ;
    protected TextView dia;
    private TextView dib;
    private TextView dic;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.j.msg_msgright_view);
        initView();
        if (this.dhL != null && this.dhL.getImage() != null && (this.dhL.getImage() instanceof ChatClipImageItemView)) {
            this.dhL.getImage().setLeft(false);
        }
        this.dia = (TextView) findViewById(d.h.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        this.dhZ = (ImageButton) findViewById(d.h.btn_msgitem_resend);
        this.cld = (HeadImageView) findViewById(d.h.img_msgitem_photo);
        this.cld.setAutoChangeStyle(false);
        this.cld.setDrawerType(1);
        this.cld.setRadius(k.dip2px(this.mContext.getContext(), 4.0f));
        this.cld.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.dhg.a(view, 6, MsgrightView.this.awz, 0L);
            }
        });
        this.dib = (TextView) findViewById(d.h.has_read);
        this.dic = (TextView) findViewById(d.h.has_sent);
        this.dhI.setIsLeft(false);
        this.dhJ.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.dia.getVisibility() != 8) {
                this.dia.setVisibility(8);
                this.dhL.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.dia.getVisibility() != 8) {
                this.dia.setVisibility(8);
                this.dhL.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.dhL.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.e.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.dia.setText(chatMessage.getProgressValue() + "%");
            this.dia.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cdR.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.dhZ.setVisibility(8);
            this.dib.setVisibility(8);
            this.dic.setVisibility(8);
            this.dhE.setVisibility(0);
            this.dhE.setText(null);
            lL(8);
            this.dhL.getImage().setTag(null);
            this.dhF.setVisibility(8);
            this.dhF.setTag(null);
            this.dhI.setVisibility(8);
            this.dhJ.setVisibility(8);
            this.dhK.setVisibility(8);
            return;
        }
        try {
            e(chatMessage);
            this.cld.setDefaultResource(d.g.photo);
            if (chatMessage.getUserInfo() != null) {
                this.cld.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.cld.c(currentPortrait, 12, false);
                }
            }
            this.cld.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.dhZ.setVisibility(8);
            this.dib.setVisibility(8);
            this.dic.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.dhZ.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.dhN) {
                            if (chatMessage.isHasRead()) {
                                this.dib.setVisibility(0);
                                this.dic.setVisibility(8);
                                break;
                            } else {
                                this.dib.setVisibility(8);
                                this.dic.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.dhZ.getVisibility() == 0) {
                this.dhZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.dhg.a(view2, 1, MsgrightView.this.awz, 0L);
                    }
                });
            }
            this.dhE.setVisibility(8);
            lL(8);
            this.dhF.setVisibility(8);
            this.dhG.setVisibility(8);
            this.dhJ.setVisibility(8);
            this.dhI.setVisibility(8);
            this.dhK.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.dhF.setVisibility(0);
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
