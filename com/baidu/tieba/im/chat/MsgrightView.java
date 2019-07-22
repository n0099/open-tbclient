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
    private HeadImageView eef;
    private ImageButton gzG;
    protected TextView gzH;
    private TextView gzI;
    private TextView gzJ;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.gzr != null && this.gzr.getImage() != null && (this.gzr.getImage() instanceof ChatClipImageItemView)) {
            this.gzr.getImage().setLeft(false);
        }
        this.gzH = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gzG = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.eef = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.eef.setAutoChangeStyle(false);
        this.eef.setDrawerType(1);
        this.eef.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.eef.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.gyM.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.gzI = (TextView) findViewById(R.id.has_read);
        this.gzJ = (TextView) findViewById(R.id.has_sent);
        this.gzo.setIsLeft(false);
        this.gzp.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.gzH.getVisibility() != 8) {
                this.gzH.setVisibility(8);
                this.gzr.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.gzH.getVisibility() != 8) {
                this.gzH.setVisibility(8);
                this.gzr.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.gzr.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.gzH.setText(chatMessage.getProgressValue() + "%");
            this.gzH.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dpV.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.gzG.setVisibility(8);
            this.gzI.setVisibility(8);
            this.gzJ.setVisibility(8);
            this.gzk.setVisibility(0);
            this.gzk.setText(null);
            ve(8);
            this.gzr.getImage().setTag(null);
            this.gzl.setVisibility(8);
            this.gzl.setTag(null);
            this.gzo.setVisibility(8);
            this.gzp.setVisibility(8);
            this.gzq.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.eef.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.eef.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.eef.startLoad(currentPortrait, 12, false);
                }
            }
            this.eef.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.gzG.setVisibility(8);
            this.gzI.setVisibility(8);
            this.gzJ.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.gzG.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.gzt) {
                            if (chatMessage.isHasRead()) {
                                this.gzI.setVisibility(0);
                                this.gzJ.setVisibility(8);
                                break;
                            } else {
                                this.gzI.setVisibility(8);
                                this.gzJ.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.gzG.getVisibility() == 0) {
                this.gzG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.gyM.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.gzk.setVisibility(8);
            ve(8);
            this.gzl.setVisibility(8);
            this.gzm.setVisibility(8);
            this.gzp.setVisibility(8);
            this.gzo.setVisibility(8);
            this.gzq.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.gzl.setVisibility(0);
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
