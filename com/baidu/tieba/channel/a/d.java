package com.baidu.tieba.channel.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b cBC;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mIsHost = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.channel_home_big_video_item, viewGroup, false));
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (hVar != null && aVar != null) {
            a(aVar, hVar, i);
            a(aVar, hVar);
        }
        return view;
    }

    private void a(a aVar, final h hVar, final int i) {
        aVar.cBG.setText(hVar.getTitle());
        aVar.cBF.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cBI.setText(this.mContext.getResources().getString(d.k.channel_home_play_count, ap.z(hVar.ajr())));
        aVar.cBJ.setText(com.baidu.tieba.channel.c.c.bh(hVar.getCreateTime()));
        aVar.cBK.setText(ap.cU(hVar.getVideoDuration() * 1000));
        if (this.cBC != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.cBC != null) {
                        d.this.cBC.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.cBM.setVisibility(0);
            aVar.cBL.setVisibility(8);
            aVar.cBM.setClickable(true);
            aVar.cBN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.cBC != null) {
                        d.this.cBC.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.cBM.setVisibility(8);
            aVar.cBL.setVisibility(0);
        }
        if (hVar.vV()) {
            aVar.biI.setVisibility(0);
            aVar.cBO.setVisibility(0);
            return;
        }
        aVar.biI.setVisibility(8);
        aVar.cBO.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        am.h(aVar.biI, d.C0142d.cp_cont_g);
        am.h(aVar.cBG, d.C0142d.cp_cont_g);
        am.h(aVar.cBG, d.C0142d.cp_cont_g);
        am.c(aVar.cBO, d.f.channel_home_dot);
        am.h(aVar.cBI, d.C0142d.cp_cont_g);
        am.h(aVar.cBK, d.C0142d.cp_cont_g);
        am.h(aVar.cBJ, d.C0142d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cBC = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView biI;
        public TbImageView cBF;
        public TextView cBG;
        public ImageView cBH;
        public TextView cBI;
        public TextView cBJ;
        public TextView cBK;
        public View cBL;
        public View cBM;
        public ImageView cBN;
        public ImageView cBO;
        public View mRootView;

        public a(View view) {
            super(view);
            ak(view);
        }

        private void ak(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            am.j(a.this.mRootView, d.C0142d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(d.C0142d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.cBF = (TbImageView) view.findViewById(d.g.channel_home_video_cover);
                this.cBG = (TextView) view.findViewById(d.g.channel_home_video_title);
                this.cBH = (ImageView) view.findViewById(d.g.channel_home_video_play);
                this.cBI = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.cBJ = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.cBK = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.cBL = view.findViewById(d.g.channel_guest_big_video_gap);
                this.cBM = view.findViewById(d.g.channel_host_big_video_more_layout);
                this.cBN = (ImageView) view.findViewById(d.g.channel_host_big_video_more_btn);
                this.biI = (TextView) view.findViewById(d.g.channel_home_big_set_top_textview);
                this.cBO = (ImageView) view.findViewById(d.g.channel_home_big_set_top_dot);
                this.cBF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cBF.setDefaultResource(d.f.pic_bg_video_frs);
                this.cBF.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
