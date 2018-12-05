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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.h;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b dab;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mIsHost = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(e.h.channel_home_big_video_item, viewGroup, false));
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
        aVar.daf.setText(hVar.getTitle());
        aVar.dae.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.dah.setText(this.mContext.getResources().getString(e.j.channel_home_play_count, ao.P(hVar.aqu())));
        aVar.dai.setText(com.baidu.tieba.channel.c.c.bz(hVar.getCreateTime()));
        aVar.daj.setText(ao.dR(hVar.getVideoDuration() * 1000));
        if (this.dab != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.dab != null) {
                        d.this.dab.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.dal.setVisibility(0);
            aVar.dak.setVisibility(8);
            aVar.dal.setClickable(true);
            aVar.dam.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.dab != null) {
                        d.this.dab.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.dal.setVisibility(8);
            aVar.dak.setVisibility(0);
        }
        if (hVar.Ah()) {
            aVar.bxo.setVisibility(0);
            aVar.dan.setVisibility(0);
            return;
        }
        aVar.bxo.setVisibility(8);
        aVar.dan.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        al.h(aVar.bxo, e.d.cp_cont_g);
        al.h(aVar.daf, e.d.cp_cont_g);
        al.h(aVar.daf, e.d.cp_cont_g);
        al.c(aVar.dan, e.f.channel_home_dot);
        al.h(aVar.dah, e.d.cp_cont_g);
        al.h(aVar.daj, e.d.cp_cont_g);
        al.h(aVar.dai, e.d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dab = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView bxo;
        public TbImageView dae;
        public TextView daf;
        public ImageView dag;
        public TextView dah;
        public TextView dai;
        public TextView daj;
        public View dak;
        public View dal;
        public ImageView dam;
        public ImageView dan;
        public View mRootView;

        public a(View view) {
            super(view);
            aD(view);
        }

        private void aD(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            al.j(a.this.mRootView, e.d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(e.d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.dae = (TbImageView) view.findViewById(e.g.channel_home_video_cover);
                this.daf = (TextView) view.findViewById(e.g.channel_home_video_title);
                this.dag = (ImageView) view.findViewById(e.g.channel_home_video_play);
                this.dah = (TextView) view.findViewById(e.g.channel_home_big_video_count);
                this.dai = (TextView) view.findViewById(e.g.channel_home_big_video_time);
                this.daj = (TextView) view.findViewById(e.g.channel_home_big_video_duration);
                this.dak = view.findViewById(e.g.channel_guest_big_video_gap);
                this.dal = view.findViewById(e.g.channel_host_big_video_more_layout);
                this.dam = (ImageView) view.findViewById(e.g.channel_host_big_video_more_btn);
                this.bxo = (TextView) view.findViewById(e.g.channel_home_big_set_top_textview);
                this.dan = (ImageView) view.findViewById(e.g.channel_home_big_set_top_dot);
                this.dae.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dae.setDefaultResource(e.f.pic_bg_video_frs);
                this.dae.setDefaultErrorResource(e.f.pic_bg_video_frs);
            }
        }
    }
}
