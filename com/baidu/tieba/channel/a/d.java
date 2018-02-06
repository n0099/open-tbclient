package com.baidu.tieba.channel.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b dco;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mIsHost = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.channel_home_big_video_item, viewGroup, false));
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
        aVar.dcs.setText(hVar.getTitle());
        aVar.dcr.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.dcv.setText(this.mContext.getResources().getString(d.j.channel_home_play_count, am.C(hVar.amp())));
        aVar.dcw.setText(com.baidu.tieba.channel.c.c.bl(hVar.getCreateTime()));
        aVar.dcx.setText(am.fR(hVar.getVideoDuration() * 1000));
        if (this.dco != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.dco != null) {
                        d.this.dco.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.dcz.setVisibility(0);
            aVar.dcy.setVisibility(8);
            aVar.dcz.setClickable(true);
            aVar.dcA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.dco != null) {
                        d.this.dco.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.dcz.setVisibility(8);
            aVar.dcy.setVisibility(0);
        }
        if (hVar.zO()) {
            aVar.dcB.setVisibility(0);
            aVar.dcC.setVisibility(0);
            return;
        }
        aVar.dcB.setVisibility(8);
        aVar.dcC.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        aj.r(aVar.dcB, d.C0140d.cp_cont_g);
        aj.r(aVar.dcs, d.C0140d.cp_cont_g);
        aj.r(aVar.dcs, d.C0140d.cp_cont_g);
        aj.c(aVar.dcC, d.f.channel_home_dot);
        aj.r(aVar.dcv, d.C0140d.cp_cont_g);
        aj.r(aVar.dcx, d.C0140d.cp_cont_g);
        aj.r(aVar.dcw, d.C0140d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dco = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends r.a {
        public ImageView dcA;
        public TextView dcB;
        public ImageView dcC;
        public TbImageView dcr;
        public TextView dcs;
        public ImageView dct;
        public TextView dcv;
        public TextView dcw;
        public TextView dcx;
        public View dcy;
        public View dcz;
        public View mRootView;

        public a(View view) {
            super(view);
            bD(view);
        }

        private void bD(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            aj.t(a.this.mRootView, d.C0140d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(d.C0140d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.dcr = (TbImageView) view.findViewById(d.g.channel_home_video_cover);
                this.dcs = (TextView) view.findViewById(d.g.channel_home_video_title);
                this.dct = (ImageView) view.findViewById(d.g.channel_home_video_play);
                this.dcv = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.dcw = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.dcx = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.dcy = view.findViewById(d.g.channel_guest_big_video_gap);
                this.dcz = view.findViewById(d.g.channel_host_big_video_more_layout);
                this.dcA = (ImageView) view.findViewById(d.g.channel_host_big_video_more_btn);
                this.dcB = (TextView) view.findViewById(d.g.channel_home_big_set_top_textview);
                this.dcC = (ImageView) view.findViewById(d.g.channel_home_big_set_top_dot);
                this.dcr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dcr.setDefaultResource(d.f.pic_bg_video_frs);
                this.dcr.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
