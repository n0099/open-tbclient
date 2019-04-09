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
/* loaded from: classes6.dex */
public class ChannelHomeSubOrAddVideoView extends FrameLayout implements e<com.baidu.tieba.channel.data.d> {
    private e ept;
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
        if (this.ept == null) {
            this.isHost = z;
            this.ept = z ? new b(getContext(), this) : new a(getContext(), this);
            this.ept.a(z, bVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void am(com.baidu.tieba.channel.data.d dVar) {
        if (this.ept != null) {
            this.ept.am(dVar);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        if (this.ept != null) {
            this.ept.onChangeSkinType(i);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements e<com.baidu.tieba.channel.data.d> {
        private View epu = null;
        private ImageView epv = null;
        private TextView epw = null;
        private boolean epx = false;
        private Context mContext;
        private ViewGroup mRootView;

        public a(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_guess_sub_view, this.mRootView, true);
            this.epu = this.mRootView.findViewById(d.g.channel_home_header_guest_layout);
            this.epv = (ImageView) this.mRootView.findViewById(d.g.channel_home_header_guest_add_iv);
            this.epw = (TextView) this.mRootView.findViewById(d.g.channel_home_header_guest_tv);
            this.epu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.epx ? 16 : 3, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void am(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.aRq() != null) {
                this.epx = dVar.aRq().isSubscribe();
                if (this.epx) {
                    this.epw.setText(this.mContext.getResources().getString(d.j.channel_is_subscribed));
                } else {
                    this.epw.setText(this.mContext.getResources().getString(d.j.channel_subscribe));
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
            if (this.epx) {
                this.epv.setVisibility(8);
                al.d(this.epw, d.C0277d.cp_cont_d, 1);
                al.k(this.epu, d.f.btn_all_white_d);
                return;
            }
            this.epv.setVisibility(0);
            this.epw.setTextColor(this.mContext.getResources().getColorStateList(d.C0277d.channel_home_header_res_text_color));
            al.k(this.epu, d.f.channel_sub_btn_bg);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements e<com.baidu.tieba.channel.data.d> {
        private Context mContext;
        private ViewGroup mRootView;

        public b(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_host_add_video_view, this.mRootView, true);
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
        public void am(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }
    }
}
