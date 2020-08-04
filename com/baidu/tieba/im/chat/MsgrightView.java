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
    private HeadImageView hJe;
    private ImageButton iRv;
    protected TextView iRw;
    private TextView iRx;
    private TextView iRy;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.iRg != null && this.iRg.getImage() != null && (this.iRg.getImage() instanceof ChatClipImageItemView)) {
            this.iRg.getImage().setLeft(false);
        }
        this.iRw = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.iRv = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.hJe = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hJe.setAutoChangeStyle(false);
        this.hJe.setDrawerType(1);
        this.hJe.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.hJe.setPlaceHolder(1);
        this.hJe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.iQD.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.iRx = (TextView) findViewById(R.id.has_read);
        this.iRy = (TextView) findViewById(R.id.has_sent);
        this.iRd.setIsLeft(false);
        this.iRe.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.iRw.getVisibility() != 8) {
                this.iRw.setVisibility(8);
                this.iRg.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.iRw.getVisibility() != 8) {
                this.iRw.setVisibility(8);
                this.iRg.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.iRg.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.iRw.setText(chatMessage.getProgressValue() + "%");
            this.iRw.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.fvC.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.iRv.setVisibility(8);
            this.iRx.setVisibility(8);
            this.iRy.setVisibility(8);
            this.iQZ.setVisibility(0);
            this.iQZ.setText(null);
            yr(8);
            this.iRg.getImage().setTag(null);
            this.iRa.setVisibility(8);
            this.iRa.setTag(null);
            this.iRd.setVisibility(8);
            this.iRe.setVisibility(8);
            this.iRf.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.hJe.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.hJe.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.hJe.startLoad(currentAvatar, 12, false);
                }
            }
            this.hJe.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.iRv.setVisibility(8);
            this.iRx.setVisibility(8);
            this.iRy.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.iRv.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.iRi) {
                            if (chatMessage.isHasRead()) {
                                this.iRx.setVisibility(0);
                                this.iRy.setVisibility(8);
                                break;
                            } else {
                                this.iRx.setVisibility(8);
                                this.iRy.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.iRv.getVisibility() == 0) {
                this.iRv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.iQD.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.iQZ.setVisibility(8);
            yr(8);
            this.iRa.setVisibility(8);
            this.iRb.setVisibility(8);
            this.iRe.setVisibility(8);
            this.iRd.setVisibility(8);
            this.iRf.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.iRa.setVisibility(0);
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
