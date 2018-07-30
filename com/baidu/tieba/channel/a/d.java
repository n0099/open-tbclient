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
    private com.baidu.tieba.channel.view.b cEh;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mIsHost = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
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
        aVar.cEl.setText(hVar.getTitle());
        aVar.cEk.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cEn.setText(this.mContext.getResources().getString(d.j.channel_home_play_count, ap.A(hVar.ajP())));
        aVar.cEo.setText(com.baidu.tieba.channel.c.c.bl(hVar.getCreateTime()));
        aVar.cEp.setText(ap.cW(hVar.getVideoDuration() * 1000));
        if (this.cEh != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.cEh != null) {
                        d.this.cEh.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.cEr.setVisibility(0);
            aVar.cEq.setVisibility(8);
            aVar.cEr.setClickable(true);
            aVar.cEs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.cEh != null) {
                        d.this.cEh.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.cEr.setVisibility(8);
            aVar.cEq.setVisibility(0);
        }
        if (hVar.vK()) {
            aVar.bjn.setVisibility(0);
            aVar.cEt.setVisibility(0);
            return;
        }
        aVar.bjn.setVisibility(8);
        aVar.cEt.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        am.h(aVar.bjn, d.C0140d.cp_cont_g);
        am.h(aVar.cEl, d.C0140d.cp_cont_g);
        am.h(aVar.cEl, d.C0140d.cp_cont_g);
        am.c(aVar.cEt, d.f.channel_home_dot);
        am.h(aVar.cEn, d.C0140d.cp_cont_g);
        am.h(aVar.cEp, d.C0140d.cp_cont_g);
        am.h(aVar.cEo, d.C0140d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cEh = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView bjn;
        public TbImageView cEk;
        public TextView cEl;
        public ImageView cEm;
        public TextView cEn;
        public TextView cEo;
        public TextView cEp;
        public View cEq;
        public View cEr;
        public ImageView cEs;
        public ImageView cEt;
        public View mRootView;

        public a(View view) {
            super(view);
            an(view);
        }

        private void an(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            am.j(a.this.mRootView, d.C0140d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(d.C0140d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.cEk = (TbImageView) view.findViewById(d.g.channel_home_video_cover);
                this.cEl = (TextView) view.findViewById(d.g.channel_home_video_title);
                this.cEm = (ImageView) view.findViewById(d.g.channel_home_video_play);
                this.cEn = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.cEo = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.cEp = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.cEq = view.findViewById(d.g.channel_guest_big_video_gap);
                this.cEr = view.findViewById(d.g.channel_host_big_video_more_layout);
                this.cEs = (ImageView) view.findViewById(d.g.channel_host_big_video_more_btn);
                this.bjn = (TextView) view.findViewById(d.g.channel_home_big_set_top_textview);
                this.cEt = (ImageView) view.findViewById(d.g.channel_home_big_set_top_dot);
                this.cEk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cEk.setDefaultResource(d.f.pic_bg_video_frs);
                this.cEk.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
