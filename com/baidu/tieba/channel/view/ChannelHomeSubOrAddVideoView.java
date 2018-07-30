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
    private e cGj;
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
        if (this.cGj == null) {
            this.isHost = z;
            this.cGj = z ? new b(getContext(), this) : new a(getContext(), this);
            this.cGj.a(z, bVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void T(com.baidu.tieba.channel.data.d dVar) {
        if (this.cGj != null) {
            this.cGj.T(dVar);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        if (this.cGj != null) {
            this.cGj.onChangeSkinType(i);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements e<com.baidu.tieba.channel.data.d> {
        private View cGk = null;
        private ImageView cGl = null;
        private TextView cGm = null;
        private boolean cGn = false;
        private Context mContext;
        private ViewGroup mRootView;

        public a(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_guess_sub_view, this.mRootView, true);
            this.cGk = this.mRootView.findViewById(d.g.channel_home_header_guest_layout);
            this.cGl = (ImageView) this.mRootView.findViewById(d.g.channel_home_header_guest_add_iv);
            this.cGm = (TextView) this.mRootView.findViewById(d.g.channel_home_header_guest_tv);
            this.cGk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.cGn ? 16 : 3, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void T(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.ajJ() != null) {
                this.cGn = dVar.ajJ().isSubscribe();
                if (this.cGn) {
                    this.cGm.setText(this.mContext.getResources().getString(d.j.channel_is_subscribed));
                } else {
                    this.cGm.setText(this.mContext.getResources().getString(d.j.channel_subscribe));
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
            if (this.cGn) {
                this.cGl.setVisibility(8);
                am.c(this.cGm, d.C0140d.cp_cont_d, 1);
                am.i(this.cGk, d.f.btn_all_white_d);
                return;
            }
            this.cGl.setVisibility(0);
            this.cGm.setTextColor(this.mContext.getResources().getColorStateList(d.C0140d.channel_home_header_res_text_color));
            am.i(this.cGk, d.f.channel_sub_btn_bg);
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
        public void T(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }
    }
}
