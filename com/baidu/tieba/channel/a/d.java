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
    private com.baidu.tieba.channel.view.b cTu;
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
        aVar.cTy.setText(hVar.getTitle());
        aVar.cTx.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cTA.setText(this.mContext.getResources().getString(e.j.channel_home_play_count, ao.I(hVar.aoH())));
        aVar.cTB.setText(com.baidu.tieba.channel.c.c.bs(hVar.getCreateTime()));
        aVar.cTC.setText(ao.dD(hVar.getVideoDuration() * 1000));
        if (this.cTu != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.cTu != null) {
                        d.this.cTu.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.cTE.setVisibility(0);
            aVar.cTD.setVisibility(8);
            aVar.cTE.setClickable(true);
            aVar.cTF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.cTu != null) {
                        d.this.cTu.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.cTE.setVisibility(8);
            aVar.cTD.setVisibility(0);
        }
        if (hVar.zd()) {
            aVar.btQ.setVisibility(0);
            aVar.cTG.setVisibility(0);
            return;
        }
        aVar.btQ.setVisibility(8);
        aVar.cTG.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        al.h(aVar.btQ, e.d.cp_cont_g);
        al.h(aVar.cTy, e.d.cp_cont_g);
        al.h(aVar.cTy, e.d.cp_cont_g);
        al.c(aVar.cTG, e.f.channel_home_dot);
        al.h(aVar.cTA, e.d.cp_cont_g);
        al.h(aVar.cTC, e.d.cp_cont_g);
        al.h(aVar.cTB, e.d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cTu = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView btQ;
        public TextView cTA;
        public TextView cTB;
        public TextView cTC;
        public View cTD;
        public View cTE;
        public ImageView cTF;
        public ImageView cTG;
        public TbImageView cTx;
        public TextView cTy;
        public ImageView cTz;
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
                this.cTx = (TbImageView) view.findViewById(e.g.channel_home_video_cover);
                this.cTy = (TextView) view.findViewById(e.g.channel_home_video_title);
                this.cTz = (ImageView) view.findViewById(e.g.channel_home_video_play);
                this.cTA = (TextView) view.findViewById(e.g.channel_home_big_video_count);
                this.cTB = (TextView) view.findViewById(e.g.channel_home_big_video_time);
                this.cTC = (TextView) view.findViewById(e.g.channel_home_big_video_duration);
                this.cTD = view.findViewById(e.g.channel_guest_big_video_gap);
                this.cTE = view.findViewById(e.g.channel_host_big_video_more_layout);
                this.cTF = (ImageView) view.findViewById(e.g.channel_host_big_video_more_btn);
                this.btQ = (TextView) view.findViewById(e.g.channel_home_big_set_top_textview);
                this.cTG = (ImageView) view.findViewById(e.g.channel_home_big_set_top_dot);
                this.cTx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cTx.setDefaultResource(e.f.pic_bg_video_frs);
                this.cTx.setDefaultErrorResource(e.f.pic_bg_video_frs);
            }
        }
    }
}
