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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b cEe;
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
        return new a(LayoutInflater.from(this.mContext).inflate(f.h.channel_home_big_video_item, viewGroup, false));
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
        aVar.cEi.setText(hVar.getTitle());
        aVar.cEh.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cEk.setText(this.mContext.getResources().getString(f.j.channel_home_play_count, ap.A(hVar.ajS())));
        aVar.cEl.setText(com.baidu.tieba.channel.c.c.bl(hVar.getCreateTime()));
        aVar.cEm.setText(ap.cW(hVar.getVideoDuration() * 1000));
        if (this.cEe != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.cEe != null) {
                        d.this.cEe.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.cEo.setVisibility(0);
            aVar.cEn.setVisibility(8);
            aVar.cEo.setClickable(true);
            aVar.cEp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.cEe != null) {
                        d.this.cEe.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.cEo.setVisibility(8);
            aVar.cEn.setVisibility(0);
        }
        if (hVar.vJ()) {
            aVar.bjt.setVisibility(0);
            aVar.cEq.setVisibility(0);
            return;
        }
        aVar.bjt.setVisibility(8);
        aVar.cEq.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        am.h(aVar.bjt, f.d.cp_cont_g);
        am.h(aVar.cEi, f.d.cp_cont_g);
        am.h(aVar.cEi, f.d.cp_cont_g);
        am.c(aVar.cEq, f.C0146f.channel_home_dot);
        am.h(aVar.cEk, f.d.cp_cont_g);
        am.h(aVar.cEm, f.d.cp_cont_g);
        am.h(aVar.cEl, f.d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cEe = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView bjt;
        public TbImageView cEh;
        public TextView cEi;
        public ImageView cEj;
        public TextView cEk;
        public TextView cEl;
        public TextView cEm;
        public View cEn;
        public View cEo;
        public ImageView cEp;
        public ImageView cEq;
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
                            am.j(a.this.mRootView, f.d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(f.d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.cEh = (TbImageView) view.findViewById(f.g.channel_home_video_cover);
                this.cEi = (TextView) view.findViewById(f.g.channel_home_video_title);
                this.cEj = (ImageView) view.findViewById(f.g.channel_home_video_play);
                this.cEk = (TextView) view.findViewById(f.g.channel_home_big_video_count);
                this.cEl = (TextView) view.findViewById(f.g.channel_home_big_video_time);
                this.cEm = (TextView) view.findViewById(f.g.channel_home_big_video_duration);
                this.cEn = view.findViewById(f.g.channel_guest_big_video_gap);
                this.cEo = view.findViewById(f.g.channel_host_big_video_more_layout);
                this.cEp = (ImageView) view.findViewById(f.g.channel_host_big_video_more_btn);
                this.bjt = (TextView) view.findViewById(f.g.channel_home_big_set_top_textview);
                this.cEq = (ImageView) view.findViewById(f.g.channel_home_big_set_top_dot);
                this.cEh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cEh.setDefaultResource(f.C0146f.pic_bg_video_frs);
                this.cEh.setDefaultErrorResource(f.C0146f.pic_bg_video_frs);
            }
        }
    }
}
