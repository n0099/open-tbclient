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
    private HeadImageView kCr;
    private ImageButton kDn;
    protected TextView kDo;
    private TextView kDp;
    private TextView kDq;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.kCY != null && this.kCY.getImage() != null && (this.kCY.getImage() instanceof ChatClipImageItemView)) {
            this.kCY.getImage().setLeft(false);
        }
        this.kDo = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.kDn = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.kCr = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.kCr.setAutoChangeStyle(false);
        this.kCr.setDrawerType(1);
        this.kCr.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.kCr.setPlaceHolder(1);
        this.kCr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.kCv.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.kDp = (TextView) findViewById(R.id.has_read);
        this.kDq = (TextView) findViewById(R.id.has_sent);
        this.kCV.setIsLeft(false);
        this.kCW.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.e
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.kDo.getVisibility() != 8) {
                this.kDo.setVisibility(8);
                this.kCY.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.kDo.getVisibility() != 8) {
                this.kDo.setVisibility(8);
                this.kCY.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.kCY.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.kDo.setText(chatMessage.getProgressValue() + "%");
            this.kDo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.e
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.gFl.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.kDn.setVisibility(8);
            this.kDp.setVisibility(8);
            this.kDq.setVisibility(8);
            this.kCR.setVisibility(0);
            this.kCR.setText(null);
            CL(8);
            this.kCY.getImage().setTag(null);
            this.kCS.setVisibility(8);
            this.kCS.setTag(null);
            this.kCV.setVisibility(8);
            this.kCW.setVisibility(8);
            this.kCX.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.kCr.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.kCr.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.kCr.startLoad(currentAvatar, 12, false);
                }
            }
            this.kCr.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.kDn.setVisibility(8);
            this.kDp.setVisibility(8);
            this.kDq.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.kDn.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.kDa) {
                            if (chatMessage.isHasRead()) {
                                this.kDp.setVisibility(0);
                                this.kDq.setVisibility(8);
                                break;
                            } else {
                                this.kDp.setVisibility(8);
                                this.kDq.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.kDn.getVisibility() == 0) {
                this.kDn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.kCv.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.kCR.setVisibility(8);
            CL(8);
            this.kCS.setVisibility(8);
            this.kCT.setVisibility(8);
            this.kCW.setVisibility(8);
            this.kCV.setVisibility(8);
            this.kCX.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.kCS.setVisibility(0);
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
