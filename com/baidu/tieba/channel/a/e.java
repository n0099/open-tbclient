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
    private com.baidu.tieba.channel.view.b dcc;
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
        aVar.dcg.setText(hVar.getTitle());
        aVar.dcf.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.dci.setText(this.mContext.getResources().getString(d.j.channel_home_play_count, am.C(hVar.amo())));
        aVar.dcj.setText(com.baidu.tieba.channel.c.c.bl(hVar.getCreateTime()));
        aVar.dck.setText(am.fR(hVar.getVideoDuration() * 1000));
        if (this.mIsHost) {
            aVar.dcs.setVisibility(0);
            aVar.dcs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dcc != null) {
                        e.this.dcc.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.dcs.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.dcc != null) {
                    e.this.dcc.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        aj.r(aVar.dcg, d.C0141d.cp_cont_b);
        aj.r(aVar.dci, d.C0141d.cp_cont_c);
        aj.r(aVar.dck, d.C0141d.cp_cont_g);
        aj.r(aVar.dcj, d.C0141d.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dcc = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes3.dex */
    public static class a extends r.a {
        public TbImageView dcf;
        public TextView dcg;
        public TextView dci;
        public TextView dcj;
        public TextView dck;
        public ImageView dcs;
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
                this.dci = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.dcj = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.dck = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.dcs = (ImageView) view.findViewById(d.g.channel_host_common_video_more_btn);
                this.dcf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dcf.setDefaultResource(d.f.pic_bg_video_frs);
                this.dcf.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
