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
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b enF;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
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
        aVar.enI.setText(hVar.getTitle());
        aVar.UB.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.enK.setText(this.mContext.getResources().getString(d.j.channel_home_play_count, ap.as(hVar.aRy())));
        aVar.enL.setText(com.baidu.tieba.channel.c.c.ce(hVar.getCreateTime()));
        aVar.enM.setText(ap.hv(hVar.getVideoDuration() * 1000));
        if (this.mIsHost) {
            aVar.enT.setVisibility(0);
            aVar.enT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.enF != null) {
                        e.this.enF.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.enT.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.enF != null) {
                    e.this.enF.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        al.j(aVar.enI, d.C0277d.cp_cont_b);
        al.j(aVar.enK, d.C0277d.cp_cont_c);
        al.j(aVar.enM, d.C0277d.cp_cont_g);
        al.j(aVar.enL, d.C0277d.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.enF = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView UB;
        public TextView enI;
        public TextView enK;
        public TextView enL;
        public TextView enM;
        public ImageView enT;
        public View mRootView;

        public a(View view) {
            super(view);
            bA(view);
        }

        private void bA(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.e.a.1
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
                this.enI = (TextView) view.findViewById(d.g.channel_home_video_title);
                this.enK = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.enL = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.enM = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.enT = (ImageView) view.findViewById(d.g.channel_host_common_video_more_btn);
                this.UB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.UB.setDefaultResource(d.f.pic_bg_video_frs);
                this.UB.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
