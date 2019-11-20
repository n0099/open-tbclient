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
    private e eTC;
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
        if (this.eTC == null) {
            this.isHost = z;
            this.eTC = z ? new b(getContext(), this) : new a(getContext(), this);
            this.eTC.a(z, bVar);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void al(com.baidu.tieba.channel.data.d dVar) {
        if (this.eTC != null) {
            this.eTC.al(dVar);
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        if (this.eTC != null) {
            this.eTC.onChangeSkinType(i);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements e<com.baidu.tieba.channel.data.d> {
        private View eTD = null;
        private ImageView eTE = null;
        private TextView eTF = null;
        private boolean eTG = false;
        private Context mContext;
        private ViewGroup mRootView;

        public a(Context context, ViewGroup viewGroup) {
            this.mContext = context;
            this.mRootView = viewGroup;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_guess_sub_view, this.mRootView, true);
            this.eTD = this.mRootView.findViewById(R.id.channel_home_header_guest_layout);
            this.eTE = (ImageView) this.mRootView.findViewById(R.id.channel_home_header_guest_add_iv);
            this.eTF = (TextView) this.mRootView.findViewById(R.id.channel_home_header_guest_tv);
            this.eTD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.ChannelHomeSubOrAddVideoView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.eTG ? 16 : 3, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void al(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.bbj() != null) {
                this.eTG = dVar.bbj().isSubscribe();
                if (this.eTG) {
                    this.eTF.setText(this.mContext.getResources().getString(R.string.channel_is_subscribed));
                } else {
                    this.eTF.setText(this.mContext.getResources().getString(R.string.channel_subscribe));
                }
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
            if (this.eTG) {
                this.eTE.setVisibility(8);
                am.setViewTextColor(this.eTF, R.color.cp_cont_d, 1);
                am.setBackgroundResource(this.eTD, R.drawable.btn_all_white_d);
                return;
            }
            this.eTE.setVisibility(0);
            this.eTF.setTextColor(this.mContext.getResources().getColorStateList(R.color.channel_home_header_res_text_color));
            am.setBackgroundResource(this.eTD, R.drawable.channel_sub_btn_bg);
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
        public void al(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }
    }
}
