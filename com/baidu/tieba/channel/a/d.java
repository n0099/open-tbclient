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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.h;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b dcU;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mIsHost = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(e.h.channel_home_big_video_item, viewGroup, false));
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
        aVar.dcY.setText(hVar.getTitle());
        aVar.dcX.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.dda.setText(this.mContext.getResources().getString(e.j.channel_home_play_count, ao.Q(hVar.arj())));
        aVar.ddb.setText(com.baidu.tieba.channel.c.c.bE(hVar.getCreateTime()));
        aVar.ddc.setText(ao.dR(hVar.getVideoDuration() * 1000));
        if (this.dcU != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.dcU != null) {
                        d.this.dcU.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.dde.setVisibility(0);
            aVar.ddd.setVisibility(8);
            aVar.dde.setClickable(true);
            aVar.ddf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.dcU != null) {
                        d.this.dcU.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.dde.setVisibility(8);
            aVar.ddd.setVisibility(0);
        }
        if (hVar.Ah()) {
            aVar.bxr.setVisibility(0);
            aVar.ddg.setVisibility(0);
            return;
        }
        aVar.bxr.setVisibility(8);
        aVar.ddg.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        al.h(aVar.bxr, e.d.cp_cont_g);
        al.h(aVar.dcY, e.d.cp_cont_g);
        al.h(aVar.dcY, e.d.cp_cont_g);
        al.c(aVar.ddg, e.f.channel_home_dot);
        al.h(aVar.dda, e.d.cp_cont_g);
        al.h(aVar.ddc, e.d.cp_cont_g);
        al.h(aVar.ddb, e.d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dcU = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView bxr;
        public TbImageView dcX;
        public TextView dcY;
        public ImageView dcZ;
        public TextView dda;
        public TextView ddb;
        public TextView ddc;
        public View ddd;
        public View dde;
        public ImageView ddf;
        public ImageView ddg;
        public View mRootView;

        public a(View view) {
            super(view);
            aG(view);
        }

        private void aG(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            al.j(a.this.mRootView, e.d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(e.d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.dcX = (TbImageView) view.findViewById(e.g.channel_home_video_cover);
                this.dcY = (TextView) view.findViewById(e.g.channel_home_video_title);
                this.dcZ = (ImageView) view.findViewById(e.g.channel_home_video_play);
                this.dda = (TextView) view.findViewById(e.g.channel_home_big_video_count);
                this.ddb = (TextView) view.findViewById(e.g.channel_home_big_video_time);
                this.ddc = (TextView) view.findViewById(e.g.channel_home_big_video_duration);
                this.ddd = view.findViewById(e.g.channel_guest_big_video_gap);
                this.dde = view.findViewById(e.g.channel_host_big_video_more_layout);
                this.ddf = (ImageView) view.findViewById(e.g.channel_host_big_video_more_btn);
                this.bxr = (TextView) view.findViewById(e.g.channel_home_big_set_top_textview);
                this.ddg = (ImageView) view.findViewById(e.g.channel_home_big_set_top_dot);
                this.dcX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dcX.setDefaultResource(e.f.pic_bg_video_frs);
                this.dcX.setDefaultErrorResource(e.f.pic_bg_video_frs);
            }
        }
    }
}
