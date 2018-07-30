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
    private HeadImageView doZ;
    private ImageButton elu;
    protected TextView elv;
    private TextView elw;
    private TextView elx;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, d.h.msg_msgright_view);
        initView();
        if (this.elf != null && this.elf.getImage() != null && (this.elf.getImage() instanceof ChatClipImageItemView)) {
            this.elf.getImage().setLeft(false);
        }
        this.elv = (TextView) findViewById(d.g.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.elu = (ImageButton) findViewById(d.g.btn_msgitem_resend);
        this.doZ = (HeadImageView) findViewById(d.g.img_msgitem_photo);
        this.doZ.setAutoChangeStyle(false);
        this.doZ.setDrawerType(1);
        this.doZ.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.doZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.ekA.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.elw = (TextView) findViewById(d.g.has_read);
        this.elx = (TextView) findViewById(d.g.has_sent);
        this.elc.setIsLeft(false);
        this.eld.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.elv.getVisibility() != 8) {
                this.elv.setVisibility(8);
                this.elf.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.elv.getVisibility() != 8) {
                this.elv.setVisibility(8);
                this.elf.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.elf.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(d.C0140d.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.elv.setText(chatMessage.getProgressValue() + "%");
            this.elv.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.cYJ.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.elu.setVisibility(8);
            this.elw.setVisibility(8);
            this.elx.setVisibility(8);
            this.ekY.setVisibility(0);
            this.ekY.setText(null);
            nN(8);
            this.elf.getImage().setTag(null);
            this.ekZ.setVisibility(8);
            this.ekZ.setTag(null);
            this.elc.setVisibility(8);
            this.eld.setVisibility(8);
            this.ele.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.doZ.setDefaultResource(d.f.photo);
            if (chatMessage.getUserInfo() != null) {
                this.doZ.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.doZ.startLoad(currentPortrait, 12, false);
                }
            }
            this.doZ.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.elu.setVisibility(8);
            this.elw.setVisibility(8);
            this.elx.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.elu.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.elh) {
                            if (chatMessage.isHasRead()) {
                                this.elw.setVisibility(0);
                                this.elx.setVisibility(8);
                                break;
                            } else {
                                this.elw.setVisibility(8);
                                this.elx.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.elu.getVisibility() == 0) {
                this.elu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.ekA.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.ekY.setVisibility(8);
            nN(8);
            this.ekZ.setVisibility(8);
            this.ela.setVisibility(8);
            this.eld.setVisibility(8);
            this.elc.setVisibility(8);
            this.ele.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.ekZ.setVisibility(0);
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
