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
    private HeadImageView fyr;
    private ImageButton gAn;
    protected TextView gAo;
    private TextView gAp;
    private TextView gAq;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.gzY != null && this.gzY.getImage() != null && (this.gzY.getImage() instanceof ChatClipImageItemView)) {
            this.gzY.getImage().setLeft(false);
        }
        this.gAo = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gAn = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.fyr = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.fyr.setAutoChangeStyle(false);
        this.fyr.setDrawerType(1);
        this.fyr.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.fyr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.gzu.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.gAp = (TextView) findViewById(R.id.has_read);
        this.gAq = (TextView) findViewById(R.id.has_sent);
        this.gzV.setIsLeft(false);
        this.gzW.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.gAo.getVisibility() != 8) {
                this.gAo.setVisibility(8);
                this.gzY.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.gAo.getVisibility() != 8) {
                this.gAo.setVisibility(8);
                this.gzY.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.gzY.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.gAo.setText(chatMessage.getProgressValue() + "%");
            this.gAo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dyX.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.gAn.setVisibility(8);
            this.gAp.setVisibility(8);
            this.gAq.setVisibility(8);
            this.gzR.setVisibility(0);
            this.gzR.setText(null);
            tP(8);
            this.gzY.getImage().setTag(null);
            this.gzS.setVisibility(8);
            this.gzS.setTag(null);
            this.gzV.setVisibility(8);
            this.gzW.setVisibility(8);
            this.gzX.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.fyr.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.fyr.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.fyr.startLoad(currentPortrait, 12, false);
                }
            }
            this.fyr.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.gAn.setVisibility(8);
            this.gAp.setVisibility(8);
            this.gAq.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.gAn.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.gAa) {
                            if (chatMessage.isHasRead()) {
                                this.gAp.setVisibility(0);
                                this.gAq.setVisibility(8);
                                break;
                            } else {
                                this.gAp.setVisibility(8);
                                this.gAq.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.gAn.getVisibility() == 0) {
                this.gAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.gzu.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.gzR.setVisibility(8);
            tP(8);
            this.gzS.setVisibility(8);
            this.gzT.setVisibility(8);
            this.gzW.setVisibility(8);
            this.gzV.setVisibility(8);
            this.gzX.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.gzS.setVisibility(0);
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
