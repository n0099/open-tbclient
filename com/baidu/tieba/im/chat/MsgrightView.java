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
    private HeadImageView hqm;
    private ImageButton itv;
    protected TextView itw;
    private TextView itx;
    private TextView ity;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.itg != null && this.itg.getImage() != null && (this.itg.getImage() instanceof ChatClipImageItemView)) {
            this.itg.getImage().setLeft(false);
        }
        this.itw = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.itv = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.hqm = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.hqm.setAutoChangeStyle(false);
        this.hqm.setDrawerType(1);
        this.hqm.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.hqm.setPlaceHolder(1);
        this.hqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.isD.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.itx = (TextView) findViewById(R.id.has_read);
        this.ity = (TextView) findViewById(R.id.has_sent);
        this.itd.setIsLeft(false);
        this.ite.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.itw.getVisibility() != 8) {
                this.itw.setVisibility(8);
                this.itg.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.itw.getVisibility() != 8) {
                this.itw.setVisibility(8);
                this.itg.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.itg.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.itw.setText(chatMessage.getProgressValue() + "%");
            this.itw.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.feW.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.itv.setVisibility(8);
            this.itx.setVisibility(8);
            this.ity.setVisibility(8);
            this.isZ.setVisibility(0);
            this.isZ.setText(null);
            xn(8);
            this.itg.getImage().setTag(null);
            this.ita.setVisibility(8);
            this.ita.setTag(null);
            this.itd.setVisibility(8);
            this.ite.setVisibility(8);
            this.itf.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.hqm.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.hqm.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.hqm.startLoad(currentAvatar, 12, false);
                }
            }
            this.hqm.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.itv.setVisibility(8);
            this.itx.setVisibility(8);
            this.ity.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.itv.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.iti) {
                            if (chatMessage.isHasRead()) {
                                this.itx.setVisibility(0);
                                this.ity.setVisibility(8);
                                break;
                            } else {
                                this.itx.setVisibility(8);
                                this.ity.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.itv.getVisibility() == 0) {
                this.itv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.isD.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.isZ.setVisibility(8);
            xn(8);
            this.ita.setVisibility(8);
            this.itb.setVisibility(8);
            this.ite.setVisibility(8);
            this.itd.setVisibility(8);
            this.itf.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.ita.setVisibility(0);
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
