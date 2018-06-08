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
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b cDI;
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
        aVar.cDM.setText(hVar.getTitle());
        aVar.cDL.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.cDO.setText(this.mContext.getResources().getString(d.k.channel_home_play_count, ao.y(hVar.ajX())));
        aVar.cDP.setText(com.baidu.tieba.channel.c.c.bn(hVar.getCreateTime()));
        aVar.cDQ.setText(ao.cT(hVar.getVideoDuration() * 1000));
        if (this.mIsHost) {
            aVar.cDY.setVisibility(0);
            aVar.cDY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.cDI != null) {
                        e.this.cDI.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.cDY.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cDI != null) {
                    e.this.cDI.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        al.h(aVar.cDM, d.C0141d.cp_cont_b);
        al.h(aVar.cDO, d.C0141d.cp_cont_c);
        al.h(aVar.cDQ, d.C0141d.cp_cont_g);
        al.h(aVar.cDP, d.C0141d.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.cDI = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TbImageView cDL;
        public TextView cDM;
        public TextView cDO;
        public TextView cDP;
        public TextView cDQ;
        public ImageView cDY;
        public View mRootView;

        public a(View view) {
            super(view);
            ai(view);
        }

        private void ai(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.e.a.1
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
                this.cDO = (TextView) view.findViewById(d.g.channel_home_big_video_count);
                this.cDP = (TextView) view.findViewById(d.g.channel_home_big_video_time);
                this.cDQ = (TextView) view.findViewById(d.g.channel_home_big_video_duration);
                this.cDY = (ImageView) view.findViewById(d.g.channel_host_common_video_more_btn);
                this.cDL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cDL.setDefaultResource(d.f.pic_bg_video_frs);
                this.cDL.setDefaultErrorResource(d.f.pic_bg_video_frs);
            }
        }
    }
}
