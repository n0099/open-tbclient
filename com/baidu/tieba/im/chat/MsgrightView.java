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
public class MsgrightView extends e {
    private static final String TAG = MsgrightView.class.getName();
    private HeadImageView krU;
    private ImageButton ksQ;
    protected TextView ksR;
    private TextView ksS;
    private TextView ksT;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.ksB != null && this.ksB.getImage() != null && (this.ksB.getImage() instanceof ChatClipImageItemView)) {
            this.ksB.getImage().setLeft(false);
        }
        this.ksR = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.ksQ = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.krU = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.krU.setAutoChangeStyle(false);
        this.krU.setDrawerType(1);
        this.krU.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.krU.setPlaceHolder(1);
        this.krU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.krY.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.ksS = (TextView) findViewById(R.id.has_read);
        this.ksT = (TextView) findViewById(R.id.has_sent);
        this.ksy.setIsLeft(false);
        this.ksz.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.e
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.ksR.getVisibility() != 8) {
                this.ksR.setVisibility(8);
                this.ksB.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.ksR.getVisibility() != 8) {
                this.ksR.setVisibility(8);
                this.ksB.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.ksB.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.ksR.setText(chatMessage.getProgressValue() + "%");
            this.ksR.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.e
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.gAE.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.ksQ.setVisibility(8);
            this.ksS.setVisibility(8);
            this.ksT.setVisibility(8);
            this.ksu.setVisibility(0);
            this.ksu.setText(null);
            Cq(8);
            this.ksB.getImage().setTag(null);
            this.ksv.setVisibility(8);
            this.ksv.setTag(null);
            this.ksy.setVisibility(8);
            this.ksz.setVisibility(8);
            this.ksA.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.krU.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.krU.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.krU.startLoad(currentAvatar, 12, false);
                }
            }
            this.krU.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.ksQ.setVisibility(8);
            this.ksS.setVisibility(8);
            this.ksT.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.ksQ.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.ksD) {
                            if (chatMessage.isHasRead()) {
                                this.ksS.setVisibility(0);
                                this.ksT.setVisibility(8);
                                break;
                            } else {
                                this.ksS.setVisibility(8);
                                this.ksT.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.ksQ.getVisibility() == 0) {
                this.ksQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.krY.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.ksu.setVisibility(8);
            Cq(8);
            this.ksv.setVisibility(8);
            this.ksw.setVisibility(8);
            this.ksz.setVisibility(8);
            this.ksy.setVisibility(8);
            this.ksA.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.ksv.setVisibility(0);
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
