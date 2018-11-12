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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChannelHomeSubOrAddVideoView extends FrameLayout implements e<com.baidu.tieba.channel.data.d> {
    private e cVw;
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
        if (this.cVw == null) {
            this.isHost = z;
            this.cVw = z ? new b(getContext(), this) : new a(getContext(), this);
            this.cVw.a(z, bVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void Z(com.baidu.tieba.channel.data.d dVar) {
        if (this.cVw != null) {
            this.cVw.Z(dVar);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        if (this.cVw != null) {
            this.cVw.onChangeSkinType(i);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements e<com.baidu.tieba.channel.data.d> {
        private Context mContext;
        private ViewGroup mRootView;
        private View cVx = null;
        private ImageView cVy = null;
        private TextView cVz = null;
        private boolean cVA = false;

        public a(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(e.h.channel_home_header_guess_sub_view, this.mRootView, true);
            this.cVx = this.mRootView.findViewById(e.g.channel_home_header_guest_layout);
            this.cVy = (ImageView) this.mRootView.findViewById(e.g.channel_home_header_guest_add_iv);
            this.cVz = (TextView) this.mRootView.findViewById(e.g.channel_home_header_guest_tv);
            this.cVx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.cVA ? 16 : 3, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void Z(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.aoB() != null) {
                this.cVA = dVar.aoB().isSubscribe();
                if (this.cVA) {
                    this.cVz.setText(this.mContext.getResources().getString(e.j.channel_is_subscribed));
                } else {
                    this.cVz.setText(this.mContext.getResources().getString(e.j.channel_subscribe));
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
            if (this.cVA) {
                this.cVy.setVisibility(8);
                al.c(this.cVz, e.d.cp_cont_d, 1);
                al.i(this.cVx, e.f.btn_all_white_d);
                return;
            }
            this.cVy.setVisibility(0);
            this.cVz.setTextColor(this.mContext.getResources().getColorStateList(e.d.channel_home_header_res_text_color));
            al.i(this.cVx, e.f.channel_sub_btn_bg);
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
            LayoutInflater.from(this.mContext).inflate(e.h.channel_home_header_host_add_video_view, this.mRootView, true);
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
        public void Z(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }
    }
}
