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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b cDI;
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
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.channel_home_big_video_item, viewGroup, false));
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
        aVar.cDM.setText(hVar.getTitle());
        aVar.cDL.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cDO.setText(this.mContext.getResources().getString(d.k.channel_home_play_count, ao.y(hVar.ajX())));
        aVar.cDP.setText(com.baidu.tieba.channel.c.c.bn(hVar.getCreateTime()));
        aVar.cDQ.setText(ao.cT(hVar.getVideoDuration() * 1000));
        if (this.cDI != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.cDI != null) {
                        d.this.cDI.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.cDS.setVisibility(0);
            aVar.cDR.setVisibility(8);
            aVar.cDS.setClickable(true);
            aVar.cDT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.cDI != null) {
                        d.this.cDI.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.cDS.setVisibility(8);
            aVar.cDR.setVisibility(0);
        }
        if (hVar.vL()) {
            aVar.cDU.setVisibility(0);
            aVar.cDV.setVisibility(0);
            return;
        }
        aVar.cDU.setVisibility(8);
        aVar.cDV.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        al.h(aVar.cDU, d.C0141d.cp_cont_g);
        al.h(aVar.cDM, d.C0141d.cp_cont_g);
        al.h(aVar.cDM, d.C0141d.cp_cont_g);
        al.c(aVar.cDV, d.f.channel_home_dot);
        al.h(aVar.cDO, d.C0141d.cp_cont_g);
        al.h(aVar.cDQ, d.C0141d.cp_cont_g);
        al.h(aVar.cDP, d.C0141d.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cDI = bVar;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TbImageView cDL;
        public TextView cDM;
        public ImageView cDN;
        public TextView cDO;
        public TextView cDP;
        public TextView cDQ;
        public View cDR;
        public View cDS;
        public ImageView cDT;
        public TextView cDU;
        public ImageView cDV;
        public View mRootView;

        public a(View view) {
            super(view);
            ai(view);
        }

        private void ai(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            al.j(a.this.mRootView, d.C0141d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(d.C0141d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.cDL = (TbImageView) view.findViewById(d.g.channel_home_video_cover);
                this.cDM = (TextView) view.findViewById(d.g.channel_home_video_title);
                this.cDN = (ImageView) view.findViewById(d.g.channel_home_video_play);
                this.cDO = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.cDP = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.cDQ = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.cDR = view.findViewById(d.g.channel_guest_big_video_gap);
                this.cDS = view.findViewById(d.g.channel_host_big_video_more_layout);
                this.cDT = (ImageView) view.findViewById(d.g.channel_host_big_video_more_btn);
                this.cDU = (TextView) view.findViewById(d.g.channel_home_big_set_top_textview);
                this.cDV = (ImageView) view.findViewById(d.g.channel_home_big_set_top_dot);
                this.cDL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cDL.setDefaultResource(d.f.pic_bg_video_frs);
                this.cDL.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
