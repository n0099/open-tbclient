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
    private com.baidu.tieba.channel.view.b dcc;
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
        aVar.dcg.setText(hVar.getTitle());
        aVar.dcf.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.dci.setText(this.mContext.getResources().getString(d.j.channel_home_play_count, am.C(hVar.amo())));
        aVar.dcj.setText(com.baidu.tieba.channel.c.c.bl(hVar.getCreateTime()));
        aVar.dck.setText(am.fR(hVar.getVideoDuration() * 1000));
        if (this.dcc != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.dcc != null) {
                        d.this.dcc.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.dcm.setVisibility(0);
            aVar.dcl.setVisibility(8);
            aVar.dcm.setClickable(true);
            aVar.dcn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.dcc != null) {
                        d.this.dcc.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.dcm.setVisibility(8);
            aVar.dcl.setVisibility(0);
        }
        if (hVar.zO()) {
            aVar.dco.setVisibility(0);
            aVar.dcp.setVisibility(0);
            return;
        }
        aVar.dco.setVisibility(8);
        aVar.dcp.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        aj.r(aVar.dco, d.C0141d.cp_cont_g);
        aj.r(aVar.dcg, d.C0141d.cp_cont_g);
        aj.r(aVar.dcg, d.C0141d.cp_cont_g);
        aj.c(aVar.dcp, d.f.channel_home_dot);
        aj.r(aVar.dci, d.C0141d.cp_cont_g);
        aj.r(aVar.dck, d.C0141d.cp_cont_g);
        aj.r(aVar.dcj, d.C0141d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dcc = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends r.a {
        public TbImageView dcf;
        public TextView dcg;
        public ImageView dch;
        public TextView dci;
        public TextView dcj;
        public TextView dck;
        public View dcl;
        public View dcm;
        public ImageView dcn;
        public TextView dco;
        public ImageView dcp;
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
                this.dcf = (TbImageView) view.findViewById(d.g.channel_home_video_cover);
                this.dcg = (TextView) view.findViewById(d.g.channel_home_video_title);
                this.dch = (ImageView) view.findViewById(d.g.channel_home_video_play);
                this.dci = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.dcj = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.dck = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.dcl = view.findViewById(d.g.channel_guest_big_video_gap);
                this.dcm = view.findViewById(d.g.channel_host_big_video_more_layout);
                this.dcn = (ImageView) view.findViewById(d.g.channel_host_big_video_more_btn);
                this.dco = (TextView) view.findViewById(d.g.channel_home_big_set_top_textview);
                this.dcp = (ImageView) view.findViewById(d.g.channel_home_big_set_top_dot);
                this.dcf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dcf.setDefaultResource(d.f.pic_bg_video_frs);
                this.dcf.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
