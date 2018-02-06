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
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b dco;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.channel_home_common_video_item, viewGroup, false));
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
        if (this.mIsHost) {
            aVar.dcF.setVisibility(0);
            aVar.dcF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dco != null) {
                        e.this.dco.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.dcF.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.dco != null) {
                    e.this.dco.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        aj.r(aVar.dcs, d.C0140d.cp_cont_b);
        aj.r(aVar.dcv, d.C0140d.cp_cont_c);
        aj.r(aVar.dcx, d.C0140d.cp_cont_g);
        aj.r(aVar.dcw, d.C0140d.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dco = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes3.dex */
    public static class a extends r.a {
        public ImageView dcF;
        public TbImageView dcr;
        public TextView dcs;
        public TextView dcv;
        public TextView dcw;
        public TextView dcx;
        public View mRootView;

        public a(View view) {
            super(view);
            bD(view);
        }

        private void bD(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.e.a.1
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
                this.dcv = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.dcw = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.dcx = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.dcF = (ImageView) view.findViewById(d.g.channel_host_common_video_more_btn);
                this.dcr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dcr.setDefaultResource(d.f.pic_bg_video_frs);
                this.dcr.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
