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
    private HeadImageView frU;
    private ImageButton gts;
    protected TextView gtt;
    private TextView gtu;
    private TextView gtv;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.gtd != null && this.gtd.getImage() != null && (this.gtd.getImage() instanceof ChatClipImageItemView)) {
            this.gtd.getImage().setLeft(false);
        }
        this.gtt = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gts = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.frU = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.frU.setAutoChangeStyle(false);
        this.frU.setDrawerType(1);
        this.frU.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.frU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.gsy.a(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.gtu = (TextView) findViewById(R.id.has_read);
        this.gtv = (TextView) findViewById(R.id.has_sent);
        this.gta.setIsLeft(false);
        this.gtb.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.gtt.getVisibility() != 8) {
                this.gtt.setVisibility(8);
                this.gtd.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.gtt.getVisibility() != 8) {
                this.gtt.setVisibility(8);
                this.gtd.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.gtd.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.gtt.setText(chatMessage.getProgressValue() + "%");
            this.gtt.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.faW.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.gts.setVisibility(8);
            this.gtu.setVisibility(8);
            this.gtv.setVisibility(8);
            this.gsW.setVisibility(0);
            this.gsW.setText(null);
            uD(8);
            this.gtd.getImage().setTag(null);
            this.gsX.setVisibility(8);
            this.gsX.setTag(null);
            this.gta.setVisibility(8);
            this.gtb.setVisibility(8);
            this.gtc.setVisibility(8);
            return;
        }
        try {
            g(chatMessage);
            this.frU.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.frU.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.frU.startLoad(currentPortrait, 12, false);
                }
            }
            this.frU.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.gts.setVisibility(8);
            this.gtu.setVisibility(8);
            this.gtv.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.gts.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.gtf) {
                            if (chatMessage.isHasRead()) {
                                this.gtu.setVisibility(0);
                                this.gtv.setVisibility(8);
                                break;
                            } else {
                                this.gtu.setVisibility(8);
                                this.gtv.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.gts.getVisibility() == 0) {
                this.gts.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.gsy.a(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.gsW.setVisibility(8);
            uD(8);
            this.gsX.setVisibility(8);
            this.gsY.setVisibility(8);
            this.gtb.setVisibility(8);
            this.gta.setVisibility(8);
            this.gtc.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.gsX.setVisibility(0);
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
