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
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b ctV;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.channel_home_common_video_item, viewGroup, false));
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
        aVar.ctZ.setText(hVar.getTitle());
        aVar.ctY.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cub.setText(this.mContext.getResources().getString(d.k.channel_home_play_count, an.v(hVar.agp())));
        aVar.cuc.setText(com.baidu.tieba.channel.c.c.bj(hVar.getCreateTime()));
        aVar.cud.setText(an.cQ(hVar.getVideoDuration() * 1000));
        if (this.mIsHost) {
            aVar.cul.setVisibility(0);
            aVar.cul.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.ctV != null) {
                        e.this.ctV.a(9, view2, hVar, i);
                    }
                }
            });
        } else {
            aVar.cul.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.ctV != null) {
                    e.this.ctV.a(2, view2, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        ak.h(aVar.ctZ, d.C0126d.cp_cont_b);
        ak.h(aVar.cub, d.C0126d.cp_cont_c);
        ak.h(aVar.cud, d.C0126d.cp_cont_g);
        ak.h(aVar.cuc, d.C0126d.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.ctV = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TbImageView ctY;
        public TextView ctZ;
        public TextView cub;
        public TextView cuc;
        public TextView cud;
        public ImageView cul;
        public View mRootView;

        public a(View view2) {
            super(view2);
            ai(view2);
        }

        private void ai(View view2) {
            if (view2 != null) {
                this.mRootView = view2;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.e.a.1
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
                this.ctY = (TbImageView) view2.findViewById(d.g.channel_home_video_cover);
                this.ctZ = (TextView) view2.findViewById(d.g.channel_home_video_title);
                this.cub = (TextView) view2.findViewById(d.g.channel_home_big_video_count);
                this.cuc = (TextView) view2.findViewById(d.g.channel_home_big_video_time);
                this.cud = (TextView) view2.findViewById(d.g.channel_home_big_video_duration);
                this.cul = (ImageView) view2.findViewById(d.g.channel_host_common_video_more_btn);
                this.ctY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.ctY.setDefaultResource(d.f.pic_bg_video_frs);
                this.ctY.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
