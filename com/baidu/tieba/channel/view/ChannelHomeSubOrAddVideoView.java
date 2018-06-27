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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChannelHomeSubOrAddVideoView extends FrameLayout implements e<com.baidu.tieba.channel.data.d> {
    private e cDD;
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
        if (this.cDD == null) {
            this.isHost = z;
            this.cDD = z ? new b(getContext(), this) : new a(getContext(), this);
            this.cDD.a(z, bVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void T(com.baidu.tieba.channel.data.d dVar) {
        if (this.cDD != null) {
            this.cDD.T(dVar);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        if (this.cDD != null) {
            this.cDD.onChangeSkinType(i);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements e<com.baidu.tieba.channel.data.d> {
        private View cDE = null;
        private ImageView cDF = null;
        private TextView cDG = null;
        private boolean cDH = false;
        private Context mContext;
        private ViewGroup mRootView;

        public a(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(d.i.channel_home_header_guess_sub_view, this.mRootView, true);
            this.cDE = this.mRootView.findViewById(d.g.channel_home_header_guest_layout);
            this.cDF = (ImageView) this.mRootView.findViewById(d.g.channel_home_header_guest_add_iv);
            this.cDG = (TextView) this.mRootView.findViewById(d.g.channel_home_header_guest_tv);
            this.cDE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.cDH ? 16 : 3, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void T(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.ajl() != null) {
                this.cDH = dVar.ajl().isSubscribe();
                if (this.cDH) {
                    this.cDG.setText(this.mContext.getResources().getString(d.k.channel_is_subscribed));
                } else {
                    this.cDG.setText(this.mContext.getResources().getString(d.k.channel_subscribe));
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
            if (this.cDH) {
                this.cDF.setVisibility(8);
                am.c(this.cDG, d.C0142d.cp_cont_d, 1);
                am.i(this.cDE, d.f.btn_all_white_d);
                return;
            }
            this.cDF.setVisibility(0);
            this.cDG.setTextColor(this.mContext.getResources().getColorStateList(d.C0142d.channel_home_header_res_text_color));
            am.i(this.cDE, d.f.channel_sub_btn_bg);
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
        public void T(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }
    }
}
