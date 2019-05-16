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
import com.baidu.tieba.R;
import com.baidu.tieba.channel.data.h;
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b eDb;
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
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_common_video_item, viewGroup, false));
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
        aVar.eDe.setText(hVar.getTitle());
        aVar.Sn.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.eDg.setText(this.mContext.getResources().getString(R.string.channel_home_play_count, ap.aG(hVar.aYF())));
        aVar.eDh.setText(com.baidu.tieba.channel.c.c.cB(hVar.getCreateTime()));
        aVar.eDi.setText(ap.ii(hVar.getVideoDuration() * 1000));
        if (this.mIsHost) {
            aVar.eDp.setVisibility(0);
            aVar.eDp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.eDb != null) {
                        e.this.eDb.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.eDp.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eDb != null) {
                    e.this.eDb.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        al.j(aVar.eDe, R.color.cp_cont_b);
        al.j(aVar.eDg, R.color.cp_cont_c);
        al.j(aVar.eDi, R.color.cp_cont_g);
        al.j(aVar.eDh, R.color.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eDb = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView Sn;
        public TextView eDe;
        public TextView eDg;
        public TextView eDh;
        public TextView eDi;
        public ImageView eDp;
        public View mRootView;

        public a(View view) {
            super(view);
            bH(view);
        }

        private void bH(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.e.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            al.l(a.this.mRootView, R.color.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(R.color.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.Sn = (TbImageView) view.findViewById(R.id.channel_home_video_cover);
                this.eDe = (TextView) view.findViewById(R.id.channel_home_video_title);
                this.eDg = (TextView) view.findViewById(R.id.channel_home_big_video_count);
                this.eDh = (TextView) view.findViewById(R.id.channel_home_big_video_time);
                this.eDi = (TextView) view.findViewById(R.id.channel_home_big_video_duration);
                this.eDp = (ImageView) view.findViewById(R.id.channel_host_common_video_more_btn);
                this.Sn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.Sn.setDefaultResource(R.drawable.pic_bg_video_frs);
                this.Sn.setDefaultErrorResource(R.drawable.pic_bg_video_frs);
            }
        }
    }
}
