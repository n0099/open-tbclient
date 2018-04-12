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
    private com.baidu.tieba.channel.view.b ctY;
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
        aVar.cuc.setText(hVar.getTitle());
        aVar.cub.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cue.setText(this.mContext.getResources().getString(d.k.channel_home_play_count, an.v(hVar.agp())));
        aVar.cuf.setText(com.baidu.tieba.channel.c.c.bj(hVar.getCreateTime()));
        aVar.cug.setText(an.cR(hVar.getVideoDuration() * 1000));
        if (this.ctY != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.ctY != null) {
                        d.this.ctY.a(1, view2, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.cui.setVisibility(0);
            aVar.cuh.setVisibility(8);
            aVar.cui.setClickable(true);
            aVar.cuj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.ctY != null) {
                        d.this.ctY.a(8, view2, hVar, i);
                    }
                }
            });
        } else {
            aVar.cui.setVisibility(8);
            aVar.cuh.setVisibility(0);
        }
        if (hVar.sp()) {
            aVar.cuk.setVisibility(0);
            aVar.cul.setVisibility(0);
            return;
        }
        aVar.cuk.setVisibility(8);
        aVar.cul.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        ak.h(aVar.cuk, d.C0126d.cp_cont_g);
        ak.h(aVar.cuc, d.C0126d.cp_cont_g);
        ak.h(aVar.cuc, d.C0126d.cp_cont_g);
        ak.c(aVar.cul, d.f.channel_home_dot);
        ak.h(aVar.cue, d.C0126d.cp_cont_g);
        ak.h(aVar.cug, d.C0126d.cp_cont_g);
        ak.h(aVar.cuf, d.C0126d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.ctY = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TbImageView cub;
        public TextView cuc;
        public ImageView cud;
        public TextView cue;
        public TextView cuf;
        public TextView cug;
        public View cuh;
        public View cui;
        public ImageView cuj;
        public TextView cuk;
        public ImageView cul;
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
                this.cub = (TbImageView) view2.findViewById(d.g.channel_home_video_cover);
                this.cuc = (TextView) view2.findViewById(d.g.channel_home_video_title);
                this.cud = (ImageView) view2.findViewById(d.g.channel_home_video_play);
                this.cue = (TextView) view2.findViewById(d.g.channel_home_big_video_count);
                this.cuf = (TextView) view2.findViewById(d.g.channel_home_big_video_time);
                this.cug = (TextView) view2.findViewById(d.g.channel_home_big_video_duration);
                this.cuh = view2.findViewById(d.g.channel_guest_big_video_gap);
                this.cui = view2.findViewById(d.g.channel_host_big_video_more_layout);
                this.cuj = (ImageView) view2.findViewById(d.g.channel_host_big_video_more_btn);
                this.cuk = (TextView) view2.findViewById(d.g.channel_home_big_set_top_textview);
                this.cul = (ImageView) view2.findViewById(d.g.channel_home_big_set_top_dot);
                this.cub.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cub.setDefaultResource(d.f.pic_bg_video_frs);
                this.cub.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
