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
/* loaded from: classes.dex */
public class MsgrightView extends g {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView grw;
    private ImageButton htt;
    protected TextView htu;
    private TextView htv;
    private TextView htw;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.hte != null && this.hte.getImage() != null && (this.hte.getImage() instanceof ChatClipImageItemView)) {
            this.hte.getImage().setLeft(false);
        }
        this.htu = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.htt = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.grw = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.grw.setAutoChangeStyle(false);
        this.grw.setDrawerType(1);
        this.grw.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.grw.setPlaceHolder(1);
        this.grw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.hsB.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.htv = (TextView) findViewById(R.id.has_read);
        this.htw = (TextView) findViewById(R.id.has_sent);
        this.htb.setIsLeft(false);
        this.htc.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.htu.getVisibility() != 8) {
                this.htu.setVisibility(8);
                this.hte.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.htu.getVisibility() != 8) {
                this.htu.setVisibility(8);
                this.hte.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.hte.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.htu.setText(chatMessage.getProgressValue() + "%");
            this.htu.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.eov.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.htt.setVisibility(8);
            this.htv.setVisibility(8);
            this.htw.setVisibility(8);
            this.hsX.setVisibility(0);
            this.hsX.setText(null);
            wb(8);
            this.hte.getImage().setTag(null);
            this.hsY.setVisibility(8);
            this.hsY.setTag(null);
            this.htb.setVisibility(8);
            this.htc.setVisibility(8);
            this.htd.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.grw.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.grw.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.grw.startLoad(currentAvatar, 12, false);
                }
            }
            this.grw.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.htt.setVisibility(8);
            this.htv.setVisibility(8);
            this.htw.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.htt.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.htg) {
                            if (chatMessage.isHasRead()) {
                                this.htv.setVisibility(0);
                                this.htw.setVisibility(8);
                                break;
                            } else {
                                this.htv.setVisibility(8);
                                this.htw.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.htt.getVisibility() == 0) {
                this.htt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.hsB.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.hsX.setVisibility(8);
            wb(8);
            this.hsY.setVisibility(8);
            this.hsZ.setVisibility(8);
            this.htc.setVisibility(8);
            this.htb.setVisibility(8);
            this.htd.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.hsY.setVisibility(0);
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
