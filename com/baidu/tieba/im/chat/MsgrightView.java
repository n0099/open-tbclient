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
    private HeadImageView iKU;
    private TextView jWA;
    private ImageButton jWx;
    protected TextView jWy;
    private TextView jWz;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.jWi != null && this.jWi.getImage() != null && (this.jWi.getImage() instanceof ChatClipImageItemView)) {
            this.jWi.getImage().setLeft(false);
        }
        this.jWy = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jWx = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.iKU = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.iKU.setAutoChangeStyle(false);
        this.iKU.setDrawerType(1);
        this.iKU.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.iKU.setPlaceHolder(1);
        this.iKU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.jVF.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.jWz = (TextView) findViewById(R.id.has_read);
        this.jWA = (TextView) findViewById(R.id.has_sent);
        this.jWf.setIsLeft(false);
        this.jWg.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.jWy.getVisibility() != 8) {
                this.jWy.setVisibility(8);
                this.jWi.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.jWy.getVisibility() != 8) {
                this.jWy.setVisibility(8);
                this.jWi.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.jWi.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.jWy.setText(chatMessage.getProgressValue() + "%");
            this.jWy.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.gmt.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.jWx.setVisibility(8);
            this.jWz.setVisibility(8);
            this.jWA.setVisibility(8);
            this.jWb.setVisibility(0);
            this.jWb.setText(null);
            Cy(8);
            this.jWi.getImage().setTag(null);
            this.jWc.setVisibility(8);
            this.jWc.setTag(null);
            this.jWf.setVisibility(8);
            this.jWg.setVisibility(8);
            this.jWh.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.iKU.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.iKU.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.iKU.startLoad(currentAvatar, 12, false);
                }
            }
            this.iKU.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.jWx.setVisibility(8);
            this.jWz.setVisibility(8);
            this.jWA.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.jWx.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.jWk) {
                            if (chatMessage.isHasRead()) {
                                this.jWz.setVisibility(0);
                                this.jWA.setVisibility(8);
                                break;
                            } else {
                                this.jWz.setVisibility(8);
                                this.jWA.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.jWx.getVisibility() == 0) {
                this.jWx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.jVF.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.jWb.setVisibility(8);
            Cy(8);
            this.jWc.setVisibility(8);
            this.jWd.setVisibility(8);
            this.jWg.setVisibility(8);
            this.jWf.setVisibility(8);
            this.jWh.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.jWc.setVisibility(0);
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
