package com.baidu.tieba.channel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChannelHomeSubOrAddVideoView extends FrameLayout implements e<com.baidu.tieba.channel.data.d> {
    private e cFK;
    private boolean isHost;

    public ChannelHomeSubOrAddVideoView(Context context) {
        super(context);
    }

    public ChannelHomeSubOrAddVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChannelHomeSubOrAddVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.channel.view.e
    public void a(boolean z, com.baidu.tieba.channel.view.b bVar) {
        if (this.cFK == null) {
            this.isHost = z;
            this.cFK = z ? new b(getContext(), this) : new a(getContext(), this);
            this.cFK.a(z, bVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void R(com.baidu.tieba.channel.data.d dVar) {
        if (this.cFK != null) {
            this.cFK.R(dVar);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        if (this.cFK != null) {
            this.cFK.onChangeSkinType(i);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements e<com.baidu.tieba.channel.data.d> {
        private View cFL = null;
        private ImageView cFM = null;
        private TextView cFN = null;
        private boolean cFO = false;
        private Context mContext;
        private ViewGroup mRootView;

        public a(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(d.i.channel_home_header_guess_sub_view, this.mRootView, true);
            this.cFL = this.mRootView.findViewById(d.g.channel_home_header_guest_layout);
            this.cFM = (ImageView) this.mRootView.findViewById(d.g.channel_home_header_guest_add_iv);
            this.cFN = (TextView) this.mRootView.findViewById(d.g.channel_home_header_guest_tv);
            this.cFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.cFO ? 16 : 3, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void R(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.ajR() != null) {
                this.cFO = dVar.ajR().isSubscribe();
                if (this.cFO) {
                    this.cFN.setText(this.mContext.getResources().getString(d.k.channel_is_subscribed));
                } else {
                    this.cFN.setText(this.mContext.getResources().getString(d.k.channel_subscribe));
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
            if (this.cFO) {
                this.cFM.setVisibility(8);
                al.c(this.cFN, d.C0141d.cp_cont_d, 1);
                al.i(this.cFL, d.f.btn_all_white_d);
                return;
            }
            this.cFM.setVisibility(0);
            this.cFN.setTextColor(this.mContext.getResources().getColorStateList(d.C0141d.channel_home_header_res_text_color));
            al.i(this.cFL, d.f.channel_sub_btn_bg);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements e<com.baidu.tieba.channel.data.d> {
        private Context mContext;
        private ViewGroup mRootView;

        public b(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(d.i.channel_home_header_host_add_video_view, this.mRootView, true);
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(10, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void R(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }
    }
}
