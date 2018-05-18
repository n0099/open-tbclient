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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChannelHomeSubOrAddVideoView extends FrameLayout implements e<com.baidu.tieba.channel.data.d> {
    private e cxh;
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
        if (this.cxh == null) {
            this.isHost = z;
            this.cxh = z ? new b(getContext(), this) : new a(getContext(), this);
            this.cxh.a(z, bVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void O(com.baidu.tieba.channel.data.d dVar) {
        if (this.cxh != null) {
            this.cxh.O(dVar);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        if (this.cxh != null) {
            this.cxh.onChangeSkinType(i);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements e<com.baidu.tieba.channel.data.d> {
        private View cxi = null;
        private ImageView cxj = null;
        private TextView cxk = null;
        private boolean cxl = false;
        private Context mContext;
        private ViewGroup mRootView;

        public a(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(d.i.channel_home_header_guess_sub_view, this.mRootView, true);
            this.cxi = this.mRootView.findViewById(d.g.channel_home_header_guest_layout);
            this.cxj = (ImageView) this.mRootView.findViewById(d.g.channel_home_header_guest_add_iv);
            this.cxk = (TextView) this.mRootView.findViewById(d.g.channel_home_header_guest_tv);
            this.cxi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (bVar != null) {
                        bVar.a(a.this.cxl ? 16 : 3, view2, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void O(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.agj() != null) {
                this.cxl = dVar.agj().isSubscribe();
                if (this.cxl) {
                    this.cxk.setText(this.mContext.getResources().getString(d.k.channel_is_subscribed));
                } else {
                    this.cxk.setText(this.mContext.getResources().getString(d.k.channel_subscribe));
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
            if (this.cxl) {
                this.cxj.setVisibility(8);
                ak.c(this.cxk, d.C0126d.cp_cont_d, 1);
                ak.i(this.cxi, d.f.btn_all_white_d);
                return;
            }
            this.cxj.setVisibility(0);
            this.cxk.setTextColor(this.mContext.getResources().getColorStateList(d.C0126d.channel_home_header_res_text_color));
            ak.i(this.cxi, d.f.channel_sub_btn_bg);
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
                public void onClick(View view2) {
                    if (bVar != null) {
                        bVar.a(10, view2, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void O(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }
    }
}
