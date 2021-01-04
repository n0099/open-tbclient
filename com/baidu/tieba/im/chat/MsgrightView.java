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
    private HeadImageView kwz;
    private ImageButton kxv;
    protected TextView kxw;
    private TextView kxx;
    private TextView kxy;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.kxg != null && this.kxg.getImage() != null && (this.kxg.getImage() instanceof ChatClipImageItemView)) {
            this.kxg.getImage().setLeft(false);
        }
        this.kxw = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.kxv = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.kwz = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.kwz.setAutoChangeStyle(false);
        this.kwz.setDrawerType(1);
        this.kwz.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.kwz.setPlaceHolder(1);
        this.kwz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.kwD.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.kxx = (TextView) findViewById(R.id.has_read);
        this.kxy = (TextView) findViewById(R.id.has_sent);
        this.kxd.setIsLeft(false);
        this.kxe.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.e
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.kxw.getVisibility() != 8) {
                this.kxw.setVisibility(8);
                this.kxg.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.kxw.getVisibility() != 8) {
                this.kxw.setVisibility(8);
                this.kxg.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.kxg.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.kxw.setText(chatMessage.getProgressValue() + "%");
            this.kxw.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.e
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.gFk.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.kxv.setVisibility(8);
            this.kxx.setVisibility(8);
            this.kxy.setVisibility(8);
            this.kwZ.setVisibility(0);
            this.kwZ.setText(null);
            DX(8);
            this.kxg.getImage().setTag(null);
            this.kxa.setVisibility(8);
            this.kxa.setTag(null);
            this.kxd.setVisibility(8);
            this.kxe.setVisibility(8);
            this.kxf.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.kwz.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.kwz.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.kwz.startLoad(currentAvatar, 12, false);
                }
            }
            this.kwz.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.kxv.setVisibility(8);
            this.kxx.setVisibility(8);
            this.kxy.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.kxv.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.kxi) {
                            if (chatMessage.isHasRead()) {
                                this.kxx.setVisibility(0);
                                this.kxy.setVisibility(8);
                                break;
                            } else {
                                this.kxx.setVisibility(8);
                                this.kxy.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.kxv.getVisibility() == 0) {
                this.kxv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.kwD.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.kwZ.setVisibility(8);
            DX(8);
            this.kxa.setVisibility(8);
            this.kxb.setVisibility(8);
            this.kxe.setVisibility(8);
            this.kxd.setVisibility(8);
            this.kxf.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.kxa.setVisibility(0);
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
