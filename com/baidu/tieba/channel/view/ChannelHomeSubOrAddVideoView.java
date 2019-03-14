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
    private e epG;
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
        if (this.epG == null) {
            this.isHost = z;
            this.epG = z ? new b(getContext(), this) : new a(getContext(), this);
            this.epG.a(z, bVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void aq(com.baidu.tieba.channel.data.d dVar) {
        if (this.epG != null) {
            this.epG.aq(dVar);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        if (this.epG != null) {
            this.epG.onChangeSkinType(i);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements e<com.baidu.tieba.channel.data.d> {
        private View epH = null;
        private ImageView epI = null;
        private TextView epJ = null;
        private boolean epK = false;
        private Context mContext;
        private ViewGroup mRootView;

        public a(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_guess_sub_view, this.mRootView, true);
            this.epH = this.mRootView.findViewById(d.g.channel_home_header_guest_layout);
            this.epI = (ImageView) this.mRootView.findViewById(d.g.channel_home_header_guest_add_iv);
            this.epJ = (TextView) this.mRootView.findViewById(d.g.channel_home_header_guest_tv);
            this.epH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.epK ? 16 : 3, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void aq(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.aRs() != null) {
                this.epK = dVar.aRs().isSubscribe();
                if (this.epK) {
                    this.epJ.setText(this.mContext.getResources().getString(d.j.channel_is_subscribed));
                } else {
                    this.epJ.setText(this.mContext.getResources().getString(d.j.channel_subscribe));
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
            if (this.epK) {
                this.epI.setVisibility(8);
                al.d(this.epJ, d.C0277d.cp_cont_d, 1);
                al.k(this.epH, d.f.btn_all_white_d);
                return;
            }
            this.epI.setVisibility(0);
            this.epJ.setTextColor(this.mContext.getResources().getColorStateList(d.C0277d.channel_home_header_res_text_color));
            al.k(this.epH, d.f.channel_sub_btn_bg);
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
        public void aq(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }
    }
}
