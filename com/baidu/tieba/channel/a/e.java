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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.h;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b cEe;
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
        return new a(LayoutInflater.from(this.mContext).inflate(f.h.channel_home_common_video_item, viewGroup, false));
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
        aVar.cEi.setText(hVar.getTitle());
        aVar.cEh.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cEk.setText(this.mContext.getResources().getString(f.j.channel_home_play_count, ap.A(hVar.ajS())));
        aVar.cEl.setText(com.baidu.tieba.channel.c.c.bl(hVar.getCreateTime()));
        aVar.cEm.setText(ap.cW(hVar.getVideoDuration() * 1000));
        if (this.mIsHost) {
            aVar.cEt.setVisibility(0);
            aVar.cEt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cEe != null) {
                        e.this.cEe.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.cEt.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cEe != null) {
                    e.this.cEe.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        am.h(aVar.cEi, f.d.cp_cont_b);
        am.h(aVar.cEk, f.d.cp_cont_c);
        am.h(aVar.cEm, f.d.cp_cont_g);
        am.h(aVar.cEl, f.d.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cEe = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TbImageView cEh;
        public TextView cEi;
        public TextView cEk;
        public TextView cEl;
        public TextView cEm;
        public ImageView cEt;
        public View mRootView;

        public a(View view) {
            super(view);
            an(view);
        }

        private void an(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.e.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            am.j(a.this.mRootView, f.d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(f.d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.cEh = (TbImageView) view.findViewById(f.g.channel_home_video_cover);
                this.cEi = (TextView) view.findViewById(f.g.channel_home_video_title);
                this.cEk = (TextView) view.findViewById(f.g.channel_home_big_video_count);
                this.cEl = (TextView) view.findViewById(f.g.channel_home_big_video_time);
                this.cEm = (TextView) view.findViewById(f.g.channel_home_big_video_duration);
                this.cEt = (ImageView) view.findViewById(f.g.channel_host_common_video_more_btn);
                this.cEh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cEh.setDefaultResource(f.C0146f.pic_bg_video_frs);
                this.cEh.setDefaultErrorResource(f.C0146f.pic_bg_video_frs);
            }
        }
    }
}
