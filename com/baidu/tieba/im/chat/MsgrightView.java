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
    private HeadImageView kjT;
    private ImageButton kkP;
    protected TextView kkQ;
    private TextView kkR;
    private TextView kkS;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.kkA != null && this.kkA.getImage() != null && (this.kkA.getImage() instanceof ChatClipImageItemView)) {
            this.kkA.getImage().setLeft(false);
        }
        this.kkQ = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.kkP = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.kjT = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.kjT.setAutoChangeStyle(false);
        this.kjT.setDrawerType(1);
        this.kjT.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.kjT.setPlaceHolder(1);
        this.kjT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.kjX.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.kkR = (TextView) findViewById(R.id.has_read);
        this.kkS = (TextView) findViewById(R.id.has_sent);
        this.kkx.setIsLeft(false);
        this.kky.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.kkQ.getVisibility() != 8) {
                this.kkQ.setVisibility(8);
                this.kkA.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.kkQ.getVisibility() != 8) {
                this.kkQ.setVisibility(8);
                this.kkA.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.kkA.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.kkQ.setText(chatMessage.getProgressValue() + "%");
            this.kkQ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.gul.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.kkP.setVisibility(8);
            this.kkR.setVisibility(8);
            this.kkS.setVisibility(8);
            this.kkt.setVisibility(0);
            this.kkt.setText(null);
            DL(8);
            this.kkA.getImage().setTag(null);
            this.kku.setVisibility(8);
            this.kku.setTag(null);
            this.kkx.setVisibility(8);
            this.kky.setVisibility(8);
            this.kkz.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.kjT.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.kjT.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.kjT.startLoad(currentAvatar, 12, false);
                }
            }
            this.kjT.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.kkP.setVisibility(8);
            this.kkR.setVisibility(8);
            this.kkS.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.kkP.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.kkC) {
                            if (chatMessage.isHasRead()) {
                                this.kkR.setVisibility(0);
                                this.kkS.setVisibility(8);
                                break;
                            } else {
                                this.kkR.setVisibility(8);
                                this.kkS.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.kkP.getVisibility() == 0) {
                this.kkP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.kjX.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.kkt.setVisibility(8);
            DL(8);
            this.kku.setVisibility(8);
            this.kkv.setVisibility(8);
            this.kky.setVisibility(8);
            this.kkx.setVisibility(8);
            this.kkz.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.kku.setVisibility(0);
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
