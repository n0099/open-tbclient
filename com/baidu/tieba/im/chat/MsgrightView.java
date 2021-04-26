package com.baidu.tieba.im.chat;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatClipImageItemView;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.c.e.p.l;
import d.a.j0.e1.f.e;
/* loaded from: classes4.dex */
public class MsgrightView extends e {
    public static final String z = "com.baidu.tieba.im.chat.MsgrightView";
    public ProgressBar t;
    public ImageButton u;
    public TextView v;
    public HeadImageView w;
    public TextView x;
    public TextView y;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MsgrightView msgrightView = MsgrightView.this;
            msgrightView.f53441b.onItemViewClick(view, 6, msgrightView.f53445f, 0L);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MsgrightView msgrightView = MsgrightView.this;
            msgrightView.f53441b.onItemViewClick(view, 1, msgrightView.f53445f, 0L);
        }
    }

    public MsgrightView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_msgright_view);
        g();
        ChatImageWithTailView chatImageWithTailView = this.p;
        if (chatImageWithTailView != null && chatImageWithTailView.getImage() != null && (this.p.getImage() instanceof ChatClipImageItemView)) {
            this.p.getImage().setLeft(false);
        }
        this.v = (TextView) d(R.id.img_msgitem_progressbar);
        this.t = (ProgressBar) d(R.id.progress);
        this.u = (ImageButton) d(R.id.btn_msgitem_resend);
        HeadImageView headImageView = (HeadImageView) d(R.id.img_msgitem_photo);
        this.w = headImageView;
        headImageView.setAutoChangeStyle(false);
        this.w.setDrawerType(1);
        this.w.setRadius(l.e(this.mContext.getContext(), 4.0f));
        this.w.setPlaceHolder(1);
        this.w.setOnClickListener(new a());
        this.x = (TextView) d(R.id.has_read);
        this.y = (TextView) d(R.id.has_sent);
        this.m.setIsLeft(false);
        this.n.setIsLeft(false);
    }

    @Override // d.a.j0.e1.f.e
    public void k(View view, ChatMessage chatMessage) {
        super.k(view, chatMessage);
        if (chatMessage == null) {
            this.f53447h.setVisibility(8);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            this.f53448i.setVisibility(0);
            this.f53448i.setText(null);
            l(8);
            this.p.getImage().setTag(null);
            this.j.setVisibility(8);
            this.j.setTag(null);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            return;
        }
        try {
            w(chatMessage);
            this.w.setDefaultResource(R.drawable.photo);
            if (chatMessage.getUserInfo() != null) {
                this.w.setUserId(chatMessage.getUserInfo().getUserId());
                String currentAvatar = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAvatar() : null;
                if (currentAvatar != null && currentAvatar.length() > 0) {
                    this.w.V(currentAvatar, 12, false);
                }
            }
            this.w.setContentDescription(chatMessage.getUserInfo().getName_show());
            this.t.setVisibility(8);
            this.u.setVisibility(8);
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null) {
                short shortValue = chatMessage.getLocalData().getStatus().shortValue();
                if (shortValue == 1) {
                    this.t.setVisibility(0);
                } else if (shortValue == 2) {
                    this.u.setVisibility(0);
                } else if (shortValue == 3) {
                    this.t.setVisibility(8);
                    if (this.r) {
                        if (chatMessage.isHasRead()) {
                            this.x.setVisibility(0);
                            this.y.setVisibility(8);
                        } else {
                            this.x.setVisibility(8);
                            this.y.setVisibility(0);
                        }
                    }
                }
            }
            if (this.u.getVisibility() == 0) {
                this.u.setOnClickListener(new b());
            }
            this.f53448i.setVisibility(8);
            l(8);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.o.setVisibility(8);
            int msgType = chatMessage.getMsgType();
            if (msgType == 1) {
                z(chatMessage, z);
            } else if (msgType == 2) {
                y(view, chatMessage, z);
            } else if (msgType == 3) {
                A(chatMessage, z);
                this.j.setVisibility(0);
            } else if (msgType == 4) {
                u(chatMessage, true);
            } else if (msgType != 9) {
            } else {
                v(view, chatMessage, z);
            }
        } catch (Exception unused) {
        }
    }

    @Override // d.a.j0.e1.f.e
    public void s(View view, ChatMessage chatMessage) {
        if (chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus() != null && (chatMessage.getLocalData().getStatus().shortValue() == 3 || chatMessage.getLocalData().getStatus().shortValue() == 2)) {
            if (this.v.getVisibility() != 8) {
                this.v.setVisibility(8);
                this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
            }
        } else if (chatMessage.getProgressValue() < 100 && chatMessage.getIsUploading()) {
            this.p.getImage().setColorFilter(TbadkCoreApplication.getInst().getApp().getResources().getColor(R.color.common_color_10227), PorterDuff.Mode.SRC_ATOP);
            TextView textView = this.v;
            textView.setText(chatMessage.getProgressValue() + "%");
            this.v.setVisibility(0);
        } else if (this.v.getVisibility() != 8) {
            this.v.setVisibility(8);
            this.p.getImage().setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
