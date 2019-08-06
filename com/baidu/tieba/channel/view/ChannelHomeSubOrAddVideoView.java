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
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ChannelHomeSubOrAddVideoView extends FrameLayout implements e<com.baidu.tieba.channel.data.d> {
    private e eKe;
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
        if (this.eKe == null) {
            this.isHost = z;
            this.eKe = z ? new b(getContext(), this) : new a(getContext(), this);
            this.eKe.a(z, bVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void ao(com.baidu.tieba.channel.data.d dVar) {
        if (this.eKe != null) {
            this.eKe.ao(dVar);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        if (this.eKe != null) {
            this.eKe.onChangeSkinType(i);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements e<com.baidu.tieba.channel.data.d> {
        private View eKf = null;
        private ImageView eKg = null;
        private TextView eKh = null;
        private boolean eKi = false;
        private Context mContext;
        private ViewGroup mRootView;

        public a(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_guess_sub_view, this.mRootView, true);
            this.eKf = this.mRootView.findViewById(R.id.channel_home_header_guest_layout);
            this.eKg = (ImageView) this.mRootView.findViewById(R.id.channel_home_header_guest_add_iv);
            this.eKh = (TextView) this.mRootView.findViewById(R.id.channel_home_header_guest_tv);
            this.eKf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.eKi ? 16 : 3, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void ao(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.baD() != null) {
                this.eKi = dVar.baD().isSubscribe();
                if (this.eKi) {
                    this.eKh.setText(this.mContext.getResources().getString(R.string.channel_is_subscribed));
                } else {
                    this.eKh.setText(this.mContext.getResources().getString(R.string.channel_subscribe));
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
            if (this.eKi) {
                this.eKg.setVisibility(8);
                am.f(this.eKh, R.color.cp_cont_d, 1);
                am.k(this.eKf, R.drawable.btn_all_white_d);
                return;
            }
            this.eKg.setVisibility(0);
            this.eKh.setTextColor(this.mContext.getResources().getColorStateList(R.color.channel_home_header_res_text_color));
            am.k(this.eKf, R.drawable.channel_sub_btn_bg);
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
            LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_host_add_video_view, this.mRootView, true);
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
        public void ao(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }
    }
}
