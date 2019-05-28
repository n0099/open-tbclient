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
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b eDc;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mIsHost = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_big_video_item, viewGroup, false));
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
        aVar.eDf.setText(hVar.getTitle());
        aVar.Sn.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.eDh.setText(this.mContext.getResources().getString(R.string.channel_home_play_count, ap.aG(hVar.aYI())));
        aVar.eDi.setText(com.baidu.tieba.channel.c.c.cB(hVar.getCreateTime()));
        aVar.eDj.setText(ap.ii(hVar.getVideoDuration() * 1000));
        if (this.eDc != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.eDc != null) {
                        d.this.eDc.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.eDl.setVisibility(0);
            aVar.eDk.setVisibility(8);
            aVar.eDl.setClickable(true);
            aVar.eDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.eDc != null) {
                        d.this.eDc.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.eDl.setVisibility(8);
            aVar.eDk.setVisibility(0);
        }
        if (hVar.aec()) {
            aVar.cRy.setVisibility(0);
            aVar.eDn.setVisibility(0);
            return;
        }
        aVar.cRy.setVisibility(8);
        aVar.eDn.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        al.j(aVar.cRy, R.color.cp_cont_g);
        al.j(aVar.eDf, R.color.cp_cont_g);
        al.j(aVar.eDf, R.color.cp_cont_g);
        al.c(aVar.eDn, (int) R.drawable.channel_home_dot);
        al.j(aVar.eDh, R.color.cp_cont_g);
        al.j(aVar.eDj, R.color.cp_cont_g);
        al.j(aVar.eDi, R.color.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eDc = bVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView Sn;
        public TextView cRy;
        public TextView eDf;
        public ImageView eDg;
        public TextView eDh;
        public TextView eDi;
        public TextView eDj;
        public View eDk;
        public View eDl;
        public ImageView eDm;
        public ImageView eDn;
        public View mRootView;

        public a(View view) {
            super(view);
            bH(view);
        }

        private void bH(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
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
                this.eDf = (TextView) view.findViewById(R.id.channel_home_video_title);
                this.eDg = (ImageView) view.findViewById(R.id.channel_home_video_play);
                this.eDh = (TextView) view.findViewById(R.id.channel_home_big_video_count);
                this.eDi = (TextView) view.findViewById(R.id.channel_home_big_video_time);
                this.eDj = (TextView) view.findViewById(R.id.channel_home_big_video_duration);
                this.eDk = view.findViewById(R.id.channel_guest_big_video_gap);
                this.eDl = view.findViewById(R.id.channel_host_big_video_more_layout);
                this.eDm = (ImageView) view.findViewById(R.id.channel_host_big_video_more_btn);
                this.cRy = (TextView) view.findViewById(R.id.channel_home_big_set_top_textview);
                this.eDn = (ImageView) view.findViewById(R.id.channel_home_big_set_top_dot);
                this.Sn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.Sn.setDefaultResource(R.drawable.pic_bg_video_frs);
                this.Sn.setDefaultErrorResource(R.drawable.pic_bg_video_frs);
            }
        }
    }
}
