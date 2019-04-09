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
    private com.baidu.tieba.channel.view.b enr;
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
        aVar.enu.setText(hVar.getTitle());
        aVar.UC.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.enx.setText(this.mContext.getResources().getString(d.j.channel_home_play_count, ap.as(hVar.aRw())));
        aVar.eny.setText(com.baidu.tieba.channel.c.c.ce(hVar.getCreateTime()));
        aVar.enz.setText(ap.hu(hVar.getVideoDuration() * 1000));
        if (this.enr != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.enr != null) {
                        d.this.enr.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.enB.setVisibility(0);
            aVar.enA.setVisibility(8);
            aVar.enB.setClickable(true);
            aVar.enC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.enr != null) {
                        d.this.enr.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.enB.setVisibility(8);
            aVar.enA.setVisibility(0);
        }
        if (hVar.Zv()) {
            aVar.cJo.setVisibility(0);
            aVar.enD.setVisibility(0);
            return;
        }
        aVar.cJo.setVisibility(8);
        aVar.enD.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        al.j(aVar.cJo, d.C0277d.cp_cont_g);
        al.j(aVar.enu, d.C0277d.cp_cont_g);
        al.j(aVar.enu, d.C0277d.cp_cont_g);
        al.c(aVar.enD, d.f.channel_home_dot);
        al.j(aVar.enx, d.C0277d.cp_cont_g);
        al.j(aVar.enz, d.C0277d.cp_cont_g);
        al.j(aVar.eny, d.C0277d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.enr = bVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView UC;
        public TextView cJo;
        public View enA;
        public View enB;
        public ImageView enC;
        public ImageView enD;
        public TextView enu;
        public ImageView enw;
        public TextView enx;
        public TextView eny;
        public TextView enz;
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
                this.UC = (TbImageView) view.findViewById(d.g.channel_home_video_cover);
                this.enu = (TextView) view.findViewById(d.g.channel_home_video_title);
                this.enw = (ImageView) view.findViewById(d.g.channel_home_video_play);
                this.enx = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.eny = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.enz = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.enA = view.findViewById(d.g.channel_guest_big_video_gap);
                this.enB = view.findViewById(d.g.channel_host_big_video_more_layout);
                this.enC = (ImageView) view.findViewById(d.g.channel_host_big_video_more_btn);
                this.cJo = (TextView) view.findViewById(d.g.channel_home_big_set_top_textview);
                this.enD = (ImageView) view.findViewById(d.g.channel_home_big_set_top_dot);
                this.UC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.UC.setDefaultResource(d.f.pic_bg_video_frs);
                this.UC.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
