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
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView hWu;
    private ImageButton jgs;
    protected TextView jgt;
    private TextView jgu;
    private TextView jgv;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.jgd != null && this.jgd.getImage() != null && (this.jgd.getImage() instanceof ChatClipImageItemView)) {
            this.jgd.getImage().setLeft(false);
        }
        this.jgt = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jgs = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.hWu = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hWu.setAutoChangeStyle(false);
        this.hWu.setDrawerType(1);
        this.hWu.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.hWu.setPlaceHolder(1);
        this.hWu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.jfA.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.jgu = (TextView) findViewById(R.id.has_read);
        this.jgv = (TextView) findViewById(R.id.has_sent);
        this.jga.setIsLeft(false);
        this.jgb.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.jgt.getVisibility() != 8) {
                this.jgt.setVisibility(8);
                this.jgd.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.jgt.getVisibility() != 8) {
                this.jgt.setVisibility(8);
                this.jgd.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.jgd.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.jgt.setText(chatMessage.getProgressValue() + "%");
            this.jgt.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.fGU.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.jgs.setVisibility(8);
            this.jgu.setVisibility(8);
            this.jgv.setVisibility(8);
            this.jfW.setVisibility(0);
            this.jfW.setText(null);
            AL(8);
            this.jgd.getImage().setTag(null);
            this.jfX.setVisibility(8);
            this.jfX.setTag(null);
            this.jga.setVisibility(8);
            this.jgb.setVisibility(8);
            this.jgc.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.hWu.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.hWu.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.hWu.startLoad(currentAvatar, 12, false);
                }
            }
            this.hWu.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.jgs.setVisibility(8);
            this.jgu.setVisibility(8);
            this.jgv.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.jgs.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.jgf) {
                            if (chatMessage.isHasRead()) {
                                this.jgu.setVisibility(0);
                                this.jgv.setVisibility(8);
                                break;
                            } else {
                                this.jgu.setVisibility(8);
                                this.jgv.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.jgs.getVisibility() == 0) {
                this.jgs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.jfA.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.jfW.setVisibility(8);
            AL(8);
            this.jfX.setVisibility(8);
            this.jfY.setVisibility(8);
            this.jgb.setVisibility(8);
            this.jga.setVisibility(8);
            this.jgc.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.jfX.setVisibility(0);
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
