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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.data.h;
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b eIf;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mIsHost = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
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
        aVar.eIi.setText(hVar.getTitle());
        aVar.SE.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.eIk.setText(this.mContext.getResources().getString(R.string.channel_home_play_count, aq.aH(hVar.baJ())));
        aVar.eIl.setText(com.baidu.tieba.channel.c.c.cG(hVar.getCreateTime()));
        aVar.eIm.setText(aq.io(hVar.getVideoDuration() * 1000));
        if (this.eIf != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.eIf != null) {
                        d.this.eIf.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.eIo.setVisibility(0);
            aVar.eIn.setVisibility(8);
            aVar.eIo.setClickable(true);
            aVar.eIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.eIf != null) {
                        d.this.eIf.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.eIo.setVisibility(8);
            aVar.eIn.setVisibility(0);
        }
        if (hVar.aff()) {
            aVar.cTc.setVisibility(0);
            aVar.eIq.setVisibility(0);
            return;
        }
        aVar.cTc.setVisibility(8);
        aVar.eIq.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        am.j(aVar.cTc, R.color.cp_cont_g);
        am.j(aVar.eIi, R.color.cp_cont_g);
        am.j(aVar.eIi, R.color.cp_cont_g);
        am.c(aVar.eIq, (int) R.drawable.channel_home_dot);
        am.j(aVar.eIk, R.color.cp_cont_g);
        am.j(aVar.eIm, R.color.cp_cont_g);
        am.j(aVar.eIl, R.color.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eIf = bVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView SE;
        public TextView cTc;
        public TextView eIi;
        public ImageView eIj;
        public TextView eIk;
        public TextView eIl;
        public TextView eIm;
        public View eIn;
        public View eIo;
        public ImageView eIp;
        public ImageView eIq;
        public View mRootView;

        public a(View view) {
            super(view);
            bJ(view);
        }

        private void bJ(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            am.l(a.this.mRootView, R.color.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(R.color.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.SE = (TbImageView) view.findViewById(R.id.channel_home_video_cover);
                this.eIi = (TextView) view.findViewById(R.id.channel_home_video_title);
                this.eIj = (ImageView) view.findViewById(R.id.channel_home_video_play);
                this.eIk = (TextView) view.findViewById(R.id.channel_home_big_video_count);
                this.eIl = (TextView) view.findViewById(R.id.channel_home_big_video_time);
                this.eIm = (TextView) view.findViewById(R.id.channel_home_big_video_duration);
                this.eIn = view.findViewById(R.id.channel_guest_big_video_gap);
                this.eIo = view.findViewById(R.id.channel_host_big_video_more_layout);
                this.eIp = (ImageView) view.findViewById(R.id.channel_host_big_video_more_btn);
                this.cTc = (TextView) view.findViewById(R.id.channel_home_big_set_top_textview);
                this.eIq = (ImageView) view.findViewById(R.id.channel_home_big_set_top_dot);
                this.SE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.SE.setDefaultResource(R.drawable.pic_bg_video_frs);
                this.SE.setDefaultErrorResource(R.drawable.pic_bg_video_frs);
            }
        }
    }
}
