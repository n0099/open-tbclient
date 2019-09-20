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
    private e eLN;
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
        if (this.eLN == null) {
            this.isHost = z;
            this.eLN = z ? new b(getContext(), this) : new a(getContext(), this);
            this.eLN.a(z, bVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void ao(com.baidu.tieba.channel.data.d dVar) {
        if (this.eLN != null) {
            this.eLN.ao(dVar);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        if (this.eLN != null) {
            this.eLN.onChangeSkinType(i);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements e<com.baidu.tieba.channel.data.d> {
        private View eLO = null;
        private ImageView eLP = null;
        private TextView eLQ = null;
        private boolean eLR = false;
        private Context mContext;
        private ViewGroup mRootView;

        public a(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_guess_sub_view, this.mRootView, true);
            this.eLO = this.mRootView.findViewById(R.id.channel_home_header_guest_layout);
            this.eLP = (ImageView) this.mRootView.findViewById(R.id.channel_home_header_guest_add_iv);
            this.eLQ = (TextView) this.mRootView.findViewById(R.id.channel_home_header_guest_tv);
            this.eLO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.eLR ? 16 : 3, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void ao(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.bbh() != null) {
                this.eLR = dVar.bbh().isSubscribe();
                if (this.eLR) {
                    this.eLQ.setText(this.mContext.getResources().getString(R.string.channel_is_subscribed));
                } else {
                    this.eLQ.setText(this.mContext.getResources().getString(R.string.channel_subscribe));
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
            if (this.eLR) {
                this.eLP.setVisibility(8);
                am.f(this.eLQ, R.color.cp_cont_d, 1);
                am.k(this.eLO, R.drawable.btn_all_white_d);
                return;
            }
            this.eLP.setVisibility(0);
            this.eLQ.setTextColor(this.mContext.getResources().getColorStateList(R.color.channel_home_header_res_text_color));
            am.k(this.eLO, R.drawable.channel_sub_btn_bg);
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
