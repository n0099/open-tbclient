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
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b dab;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(e.h.channel_home_common_video_item, viewGroup, false));
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
        if (this.mIsHost) {
            aVar.daq.setVisibility(0);
            aVar.daq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.dab != null) {
                        e.this.dab.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.daq.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.dab != null) {
                    e.this.dab.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        al.h(aVar.daf, e.d.cp_cont_b);
        al.h(aVar.dah, e.d.cp_cont_c);
        al.h(aVar.daj, e.d.cp_cont_g);
        al.h(aVar.dai, e.d.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.dab = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TbImageView dae;
        public TextView daf;
        public TextView dah;
        public TextView dai;
        public TextView daj;
        public ImageView daq;
        public View mRootView;

        public a(View view) {
            super(view);
            aD(view);
        }

        private void aD(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.e.a.1
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
                this.dah = (TextView) view.findViewById(e.g.channel_home_big_video_count);
                this.dai = (TextView) view.findViewById(e.g.channel_home_big_video_time);
                this.daj = (TextView) view.findViewById(e.g.channel_home_big_video_duration);
                this.daq = (ImageView) view.findViewById(e.g.channel_host_common_video_more_btn);
                this.dae.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dae.setDefaultResource(e.f.pic_bg_video_frs);
                this.dae.setDefaultErrorResource(e.f.pic_bg_video_frs);
            }
        }
    }
}
