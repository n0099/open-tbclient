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
    private com.baidu.tieba.channel.view.b cSo;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
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
        aVar.cSs.setText(hVar.getTitle());
        aVar.cSr.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cSu.setText(this.mContext.getResources().getString(e.j.channel_home_play_count, ao.G(hVar.apg())));
        aVar.cSv.setText(com.baidu.tieba.channel.c.c.bw(hVar.getCreateTime()));
        aVar.cSw.setText(ao.dp(hVar.getVideoDuration() * 1000));
        if (this.mIsHost) {
            aVar.cSD.setVisibility(0);
            aVar.cSD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cSo != null) {
                        e.this.cSo.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.cSD.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cSo != null) {
                    e.this.cSo.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        al.h(aVar.cSs, e.d.cp_cont_b);
        al.h(aVar.cSu, e.d.cp_cont_c);
        al.h(aVar.cSw, e.d.cp_cont_g);
        al.h(aVar.cSv, e.d.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cSo = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public ImageView cSD;
        public TbImageView cSr;
        public TextView cSs;
        public TextView cSu;
        public TextView cSv;
        public TextView cSw;
        public View mRootView;

        public a(View view) {
            super(view);
            aB(view);
        }

        private void aB(View view) {
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
                this.cSr = (TbImageView) view.findViewById(e.g.channel_home_video_cover);
                this.cSs = (TextView) view.findViewById(e.g.channel_home_video_title);
                this.cSu = (TextView) view.findViewById(e.g.channel_home_big_video_count);
                this.cSv = (TextView) view.findViewById(e.g.channel_home_big_video_time);
                this.cSw = (TextView) view.findViewById(e.g.channel_home_big_video_duration);
                this.cSD = (ImageView) view.findViewById(e.g.channel_host_common_video_more_btn);
                this.cSr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cSr.setDefaultResource(e.f.pic_bg_video_frs);
                this.cSr.setDefaultErrorResource(e.f.pic_bg_video_frs);
            }
        }
    }
}
