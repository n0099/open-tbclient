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
    private HeadImageView fxA;
    private ImageButton gzw;
    protected TextView gzx;
    private TextView gzy;
    private TextView gzz;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.gzh != null && this.gzh.getImage() != null && (this.gzh.getImage() instanceof ChatClipImageItemView)) {
            this.gzh.getImage().setLeft(false);
        }
        this.gzx = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.gzw = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.fxA = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.fxA.setAutoChangeStyle(false);
        this.fxA.setDrawerType(1);
        this.fxA.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.fxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.gyD.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.gzy = (TextView) findViewById(R.id.has_read);
        this.gzz = (TextView) findViewById(R.id.has_sent);
        this.gze.setIsLeft(false);
        this.gzf.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.gzx.getVisibility() != 8) {
                this.gzx.setVisibility(8);
                this.gzh.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.gzx.getVisibility() != 8) {
                this.gzx.setVisibility(8);
                this.gzh.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.gzh.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.gzx.setText(chatMessage.getProgressValue() + "%");
            this.gzx.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.dyg.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.gzw.setVisibility(8);
            this.gzy.setVisibility(8);
            this.gzz.setVisibility(8);
            this.gza.setVisibility(0);
            this.gza.setText(null);
            tO(8);
            this.gzh.getImage().setTag(null);
            this.gzb.setVisibility(8);
            this.gzb.setTag(null);
            this.gze.setVisibility(8);
            this.gzf.setVisibility(8);
            this.gzg.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.fxA.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.fxA.setUserId(chatMessage.getUserInfo().getUserId());
                String currentPortrait = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentPortrait() : null;
                if (currentPortrait != null && currentPortrait.length() > 0) {
                    this.fxA.startLoad(currentPortrait, 12, false);
                }
            }
            this.fxA.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.gzw.setVisibility(8);
            this.gzy.setVisibility(8);
            this.gzz.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.gzw.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.gzj) {
                            if (chatMessage.isHasRead()) {
                                this.gzy.setVisibility(0);
                                this.gzz.setVisibility(8);
                                break;
                            } else {
                                this.gzy.setVisibility(8);
                                this.gzz.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.gzw.getVisibility() == 0) {
                this.gzw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.gyD.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.gza.setVisibility(8);
            tO(8);
            this.gzb.setVisibility(8);
            this.gzc.setVisibility(8);
            this.gzf.setVisibility(8);
            this.gze.setVisibility(8);
            this.gzg.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.gzb.setVisibility(0);
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
