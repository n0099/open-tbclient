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
    private HeadImageView idE;
    private ImageButton jpe;
    protected TextView jpf;
    private TextView jpg;
    private TextView jph;
    private ProgressBar mProgress;

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        initView();
        if (this.joP != null && this.joP.getImage() != null && (this.joP.getImage() instanceof ChatClipImageItemView)) {
            this.joP.getImage().setLeft(false);
        }
        this.jpf = (TextView) findViewById(R.id.img_msgitem_progressbar);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.jpe = (ImageButton) findViewById(R.id.btn_msgitem_resend);
        this.idE = (HeadImageView) findViewById(R.id.img_msgitem_photo);
        this.idE.setAutoChangeStyle(false);
        this.idE.setDrawerType(1);
        this.idE.setRadius(l.dip2px(this.mContext.getContext(), 4.0f));
        this.idE.setPlaceHolder(1);
        this.idE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MsgrightView.this.jom.onItemViewClick(view, 6, MsgrightView.this.mPosition, 0L);
            }
        });
        this.jpg = (TextView) findViewById(R.id.has_read);
        this.jph = (TextView) findViewById(R.id.has_sent);
        this.joM.setIsLeft(false);
        this.joN.setIsLeft(false);
    }

    @Override // com.baidu.tieba.im.chat.g
    public void a(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.jpf.getVisibility() != 8) {
                this.jpf.setVisibility(8);
                this.joP.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() >= 100 || !chatMessage.getIsUploading()) {
            if (this.jpf.getVisibility() != 8) {
                this.jpf.setVisibility(8);
                this.joP.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else {
            this.joP.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            this.jpf.setText(chatMessage.getProgressValue() + "%");
            this.jpf.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.chat.g
    public void b(View view, ChatMessage chatMessage) {
        super.b(view, chatMessage);
        if (chatMessage == null) {
            this.fKk.setVisibility(8);
            this.mProgress.setVisibility(8);
            this.jpe.setVisibility(8);
            this.jpg.setVisibility(8);
            this.jph.setVisibility(8);
            this.joI.setVisibility(0);
            this.joI.setText(null);
            Bm(8);
            this.joP.getImage().setTag(null);
            this.joJ.setVisibility(8);
            this.joJ.setTag(null);
            this.joM.setVisibility(8);
            this.joN.setVisibility(8);
            this.joO.setVisibility(8);
            return;
        }
        try {
            b(chatMessage);
            this.idE.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.idE.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.idE.startLoad(currentAvatar, 12, false);
                }
            }
            this.idE.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.mProgress.setVisibility(8);
            this.jpe.setVisibility(8);
            this.jpg.setVisibility(8);
            this.jph.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                switch (chatMessage.getLocalData().getStatus().shortValue()) {
                    case 1:
                        this.mProgress.setVisibility(0);
                        break;
                    case 2:
                        this.jpe.setVisibility(0);
                        break;
                    case 3:
                        this.mProgress.setVisibility(8);
                        if (this.joR) {
                            if (chatMessage.isHasRead()) {
                                this.jpg.setVisibility(0);
                                this.jph.setVisibility(8);
                                break;
                            } else {
                                this.jpg.setVisibility(8);
                                this.jph.setVisibility(0);
                                break;
                            }
                        }
                        break;
                }
            }
            if (this.jpe.getVisibility() == 0) {
                this.jpe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.MsgrightView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MsgrightView.this.jom.onItemViewClick(view2, 1, MsgrightView.this.mPosition, 0L);
                    }
                });
            }
            this.joI.setVisibility(8);
            Bm(8);
            this.joJ.setVisibility(8);
            this.joK.setVisibility(8);
            this.joN.setVisibility(8);
            this.joM.setVisibility(8);
            this.joO.setVisibility(8);
            switch (chatMessage.getMsgType()) {
                case 1:
                    a(chatMessage, TAG);
                    return;
                case 2:
                    a(view, chatMessage, TAG);
                    return;
                case 3:
                    b(chatMessage, TAG);
                    this.joJ.setVisibility(0);
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
