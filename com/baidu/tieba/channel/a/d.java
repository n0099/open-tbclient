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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b cvf;
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
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.channel_home_big_video_item, viewGroup, false));
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h hVar, a aVar) {
        if (hVar != null && aVar != null) {
            a(aVar, hVar, i);
            a(aVar, hVar);
        }
        return view2;
    }

    private void a(a aVar, final h hVar, final int i) {
        aVar.cvj.setText(hVar.getTitle());
        aVar.cvi.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cvl.setText(this.mContext.getResources().getString(d.k.channel_home_play_count, an.v(hVar.agp())));
        aVar.cvm.setText(com.baidu.tieba.channel.c.c.bj(hVar.getCreateTime()));
        aVar.cvn.setText(an.cR(hVar.getVideoDuration() * 1000));
        if (this.cvf != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.cvf != null) {
                        d.this.cvf.a(1, view2, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.cvp.setVisibility(0);
            aVar.cvo.setVisibility(8);
            aVar.cvp.setClickable(true);
            aVar.cvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.cvf != null) {
                        d.this.cvf.a(8, view2, hVar, i);
                    }
                }
            });
        } else {
            aVar.cvp.setVisibility(8);
            aVar.cvo.setVisibility(0);
        }
        if (hVar.so()) {
            aVar.cvr.setVisibility(0);
            aVar.cvs.setVisibility(0);
            return;
        }
        aVar.cvr.setVisibility(8);
        aVar.cvs.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        ak.h(aVar.cvr, d.C0126d.cp_cont_g);
        ak.h(aVar.cvj, d.C0126d.cp_cont_g);
        ak.h(aVar.cvj, d.C0126d.cp_cont_g);
        ak.c(aVar.cvs, d.f.channel_home_dot);
        ak.h(aVar.cvl, d.C0126d.cp_cont_g);
        ak.h(aVar.cvn, d.C0126d.cp_cont_g);
        ak.h(aVar.cvm, d.C0126d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cvf = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TbImageView cvi;
        public TextView cvj;
        public ImageView cvk;
        public TextView cvl;
        public TextView cvm;
        public TextView cvn;
        public View cvo;
        public View cvp;
        public ImageView cvq;
        public TextView cvr;
        public ImageView cvs;
        public View mRootView;

        public a(View view2) {
            super(view2);
            ai(view2);
        }

        private void ai(View view2) {
            if (view2 != null) {
                this.mRootView = view2;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view3, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            ak.j(a.this.mRootView, d.C0126d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(d.C0126d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.cvi = (TbImageView) view2.findViewById(d.g.channel_home_video_cover);
                this.cvj = (TextView) view2.findViewById(d.g.channel_home_video_title);
                this.cvk = (ImageView) view2.findViewById(d.g.channel_home_video_play);
                this.cvl = (TextView) view2.findViewById(d.g.channel_home_big_video_count);
                this.cvm = (TextView) view2.findViewById(d.g.channel_home_big_video_time);
                this.cvn = (TextView) view2.findViewById(d.g.channel_home_big_video_duration);
                this.cvo = view2.findViewById(d.g.channel_guest_big_video_gap);
                this.cvp = view2.findViewById(d.g.channel_host_big_video_more_layout);
                this.cvq = (ImageView) view2.findViewById(d.g.channel_host_big_video_more_btn);
                this.cvr = (TextView) view2.findViewById(d.g.channel_home_big_set_top_textview);
                this.cvs = (ImageView) view2.findViewById(d.g.channel_home_big_set_top_dot);
                this.cvi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cvi.setDefaultResource(d.f.pic_bg_video_frs);
                this.cvi.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
