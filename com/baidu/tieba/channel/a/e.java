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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b cBC;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.channel_home_common_video_item, viewGroup, false));
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
        aVar.cBG.setText(hVar.getTitle());
        aVar.cBF.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cBI.setText(this.mContext.getResources().getString(d.k.channel_home_play_count, ap.z(hVar.ajr())));
        aVar.cBJ.setText(com.baidu.tieba.channel.c.c.bh(hVar.getCreateTime()));
        aVar.cBK.setText(ap.cU(hVar.getVideoDuration() * 1000));
        if (this.mIsHost) {
            aVar.cBR.setVisibility(0);
            aVar.cBR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cBC != null) {
                        e.this.cBC.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.cBR.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cBC != null) {
                    e.this.cBC.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        am.h(aVar.cBG, d.C0142d.cp_cont_b);
        am.h(aVar.cBI, d.C0142d.cp_cont_c);
        am.h(aVar.cBK, d.C0142d.cp_cont_g);
        am.h(aVar.cBJ, d.C0142d.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cBC = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TbImageView cBF;
        public TextView cBG;
        public TextView cBI;
        public TextView cBJ;
        public TextView cBK;
        public ImageView cBR;
        public View mRootView;

        public a(View view) {
            super(view);
            ak(view);
        }

        private void ak(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.e.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            am.j(a.this.mRootView, d.C0142d.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(d.C0142d.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.cBF = (TbImageView) view.findViewById(d.g.channel_home_video_cover);
                this.cBG = (TextView) view.findViewById(d.g.channel_home_video_title);
                this.cBI = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.cBJ = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.cBK = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.cBR = (ImageView) view.findViewById(d.g.channel_host_common_video_more_btn);
                this.cBF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cBF.setDefaultResource(d.f.pic_bg_video_frs);
                this.cBF.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
