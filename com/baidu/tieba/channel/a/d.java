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
    private com.baidu.tieba.channel.view.b dcf;
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
        aVar.dcj.setText(hVar.getTitle());
        aVar.dci.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.dcl.setText(this.mContext.getResources().getString(d.j.channel_home_play_count, am.C(hVar.amp())));
        aVar.dcm.setText(com.baidu.tieba.channel.c.c.bl(hVar.getCreateTime()));
        aVar.dcn.setText(am.fR(hVar.getVideoDuration() * 1000));
        if (this.dcf != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.dcf != null) {
                        d.this.dcf.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.dcp.setVisibility(0);
            aVar.dco.setVisibility(8);
            aVar.dcp.setClickable(true);
            aVar.dcq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.dcf != null) {
                        d.this.dcf.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.dcp.setVisibility(8);
            aVar.dco.setVisibility(0);
        }
        if (hVar.zO()) {
            aVar.dcr.setVisibility(0);
            aVar.dcs.setVisibility(0);
            return;
        }
        aVar.dcr.setVisibility(8);
        aVar.dcs.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        aj.r(aVar.dcr, d.C0141d.cp_cont_g);
        aj.r(aVar.dcj, d.C0141d.cp_cont_g);
        aj.r(aVar.dcj, d.C0141d.cp_cont_g);
        aj.c(aVar.dcs, d.f.channel_home_dot);
        aj.r(aVar.dcl, d.C0141d.cp_cont_g);
        aj.r(aVar.dcn, d.C0141d.cp_cont_g);
        aj.r(aVar.dcm, d.C0141d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dcf = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends r.a {
        public TbImageView dci;
        public TextView dcj;
        public ImageView dck;
        public TextView dcl;
        public TextView dcm;
        public TextView dcn;
        public View dco;
        public View dcp;
        public ImageView dcq;
        public TextView dcr;
        public ImageView dcs;
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
                            aj.t(a.this.mRootView, d.C0141d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(d.C0141d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.dci = (TbImageView) view.findViewById(d.g.channel_home_video_cover);
                this.dcj = (TextView) view.findViewById(d.g.channel_home_video_title);
                this.dck = (ImageView) view.findViewById(d.g.channel_home_video_play);
                this.dcl = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.dcm = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.dcn = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.dco = view.findViewById(d.g.channel_guest_big_video_gap);
                this.dcp = view.findViewById(d.g.channel_host_big_video_more_layout);
                this.dcq = (ImageView) view.findViewById(d.g.channel_host_big_video_more_btn);
                this.dcr = (TextView) view.findViewById(d.g.channel_home_big_set_top_textview);
                this.dcs = (ImageView) view.findViewById(d.g.channel_home_big_set_top_dot);
                this.dci.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dci.setDefaultResource(d.f.pic_bg_video_frs);
                this.dci.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
