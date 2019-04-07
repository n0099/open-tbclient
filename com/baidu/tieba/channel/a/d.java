package com.baidu.tieba.channel.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.h;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b enq;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mIsHost = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
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
        aVar.ent.setText(hVar.getTitle());
        aVar.UB.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.enw.setText(this.mContext.getResources().getString(d.j.channel_home_play_count, ap.as(hVar.aRw())));
        aVar.enx.setText(com.baidu.tieba.channel.c.c.ce(hVar.getCreateTime()));
        aVar.eny.setText(ap.hu(hVar.getVideoDuration() * 1000));
        if (this.enq != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.enq != null) {
                        d.this.enq.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.enA.setVisibility(0);
            aVar.enz.setVisibility(8);
            aVar.enA.setClickable(true);
            aVar.enB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.enq != null) {
                        d.this.enq.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.enA.setVisibility(8);
            aVar.enz.setVisibility(0);
        }
        if (hVar.Zv()) {
            aVar.cJn.setVisibility(0);
            aVar.enC.setVisibility(0);
            return;
        }
        aVar.cJn.setVisibility(8);
        aVar.enC.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        al.j(aVar.cJn, d.C0277d.cp_cont_g);
        al.j(aVar.ent, d.C0277d.cp_cont_g);
        al.j(aVar.ent, d.C0277d.cp_cont_g);
        al.c(aVar.enC, d.f.channel_home_dot);
        al.j(aVar.enw, d.C0277d.cp_cont_g);
        al.j(aVar.eny, d.C0277d.cp_cont_g);
        al.j(aVar.enx, d.C0277d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.enq = bVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView UB;
        public TextView cJn;
        public View enA;
        public ImageView enB;
        public ImageView enC;
        public TextView ent;
        public ImageView enu;
        public TextView enw;
        public TextView enx;
        public TextView eny;
        public View enz;
        public View mRootView;

        public a(View view) {
            super(view);
            bA(view);
        }

        private void bA(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            al.l(a.this.mRootView, d.C0277d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(d.C0277d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.UB = (TbImageView) view.findViewById(d.g.channel_home_video_cover);
                this.ent = (TextView) view.findViewById(d.g.channel_home_video_title);
                this.enu = (ImageView) view.findViewById(d.g.channel_home_video_play);
                this.enw = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.enx = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.eny = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.enz = view.findViewById(d.g.channel_guest_big_video_gap);
                this.enA = view.findViewById(d.g.channel_host_big_video_more_layout);
                this.enB = (ImageView) view.findViewById(d.g.channel_host_big_video_more_btn);
                this.cJn = (TextView) view.findViewById(d.g.channel_home_big_set_top_textview);
                this.enC = (ImageView) view.findViewById(d.g.channel_home_big_set_top_dot);
                this.UB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.UB.setDefaultResource(d.f.pic_bg_video_frs);
                this.UB.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
