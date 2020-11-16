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
    private HeadImageView iLH;
    private ImageButton jXh;
    protected TextView jXi;
    private TextView jXj;
    private TextView jXk;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.jWS != null && this.jWS.getImage() != null && (this.jWS.getImage() instanceof ChatClipImageItemView)) {
            this.jWS.getImage().setLeft(false);
        }
        this.jXi = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jXh = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.iLH = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.iLH.setAutoChangeStyle(false);
        this.iLH.setDrawerType(1);
        this.iLH.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.iLH.setPlaceHolder(1);
        this.iLH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.jWp.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.jXj = (TextView) findViewById(R.id.has_read);
        this.jXk = (TextView) findViewById(R.id.has_sent);
        this.jWP.setIsLeft(false);
        this.jWQ.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.jXi.getVisibility() != 8) {
                this.jXi.setVisibility(8);
                this.jWS.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.jXi.getVisibility() != 8) {
                this.jXi.setVisibility(8);
                this.jWS.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.jWS.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.jXi.setText(chatMessage.getProgressValue() + "%");
            this.jXi.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.gma.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.jXh.setVisibility(8);
            this.jXj.setVisibility(8);
            this.jXk.setVisibility(8);
            this.jWL.setVisibility(0);
            this.jWL.setText(null);
            CW(8);
            this.jWS.getImage().setTag(null);
            this.jWM.setVisibility(8);
            this.jWM.setTag(null);
            this.jWP.setVisibility(8);
            this.jWQ.setVisibility(8);
            this.jWR.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.iLH.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.iLH.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.iLH.startLoad(currentAvatar, 12, false);
                }
            }
            this.iLH.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.jXh.setVisibility(8);
            this.jXj.setVisibility(8);
            this.jXk.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.jXh.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.jWU) {
                            if (chatMessage.isHasRead()) {
                                this.jXj.setVisibility(0);
                                this.jXk.setVisibility(8);
                                break;
                            } else {
                                this.jXj.setVisibility(8);
                                this.jXk.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.jXh.getVisibility() == 0) {
                this.jXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.jWp.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.jWL.setVisibility(8);
            CW(8);
            this.jWM.setVisibility(8);
            this.jWN.setVisibility(8);
            this.jWQ.setVisibility(8);
            this.jWP.setVisibility(8);
            this.jWR.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.jWM.setVisibility(0);
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
