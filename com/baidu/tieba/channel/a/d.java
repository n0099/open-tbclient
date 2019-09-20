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
    private com.baidu.tieba.channel.view.b eJO;
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
        aVar.eJR.setText(hVar.getTitle());
        aVar.SD.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.eJT.setText(this.mContext.getResources().getString(R.string.channel_home_play_count, aq.aH(hVar.bbn())));
        aVar.eJU.setText(com.baidu.tieba.channel.c.c.cJ(hVar.getCreateTime()));
        aVar.eJV.setText(aq.ip(hVar.getVideoDuration() * 1000));
        if (this.eJO != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.eJO != null) {
                        d.this.eJO.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.eJX.setVisibility(0);
            aVar.eJW.setVisibility(8);
            aVar.eJX.setClickable(true);
            aVar.eJY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.eJO != null) {
                        d.this.eJO.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.eJX.setVisibility(8);
            aVar.eJW.setVisibility(0);
        }
        if (hVar.afj()) {
            aVar.cTV.setVisibility(0);
            aVar.eJZ.setVisibility(0);
            return;
        }
        aVar.cTV.setVisibility(8);
        aVar.eJZ.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        am.j(aVar.cTV, R.color.cp_cont_g);
        am.j(aVar.eJR, R.color.cp_cont_g);
        am.j(aVar.eJR, R.color.cp_cont_g);
        am.c(aVar.eJZ, (int) R.drawable.channel_home_dot);
        am.j(aVar.eJT, R.color.cp_cont_g);
        am.j(aVar.eJV, R.color.cp_cont_g);
        am.j(aVar.eJU, R.color.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eJO = bVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView SD;
        public TextView cTV;
        public TextView eJR;
        public ImageView eJS;
        public TextView eJT;
        public TextView eJU;
        public TextView eJV;
        public View eJW;
        public View eJX;
        public ImageView eJY;
        public ImageView eJZ;
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
                this.SD = (TbImageView) view.findViewById(R.id.channel_home_video_cover);
                this.eJR = (TextView) view.findViewById(R.id.channel_home_video_title);
                this.eJS = (ImageView) view.findViewById(R.id.channel_home_video_play);
                this.eJT = (TextView) view.findViewById(R.id.channel_home_big_video_count);
                this.eJU = (TextView) view.findViewById(R.id.channel_home_big_video_time);
                this.eJV = (TextView) view.findViewById(R.id.channel_home_big_video_duration);
                this.eJW = view.findViewById(R.id.channel_guest_big_video_gap);
                this.eJX = view.findViewById(R.id.channel_host_big_video_more_layout);
                this.eJY = (ImageView) view.findViewById(R.id.channel_host_big_video_more_btn);
                this.cTV = (TextView) view.findViewById(R.id.channel_home_big_set_top_textview);
                this.eJZ = (ImageView) view.findViewById(R.id.channel_home_big_set_top_dot);
                this.SD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.SD.setDefaultResource(R.drawable.pic_bg_video_frs);
                this.SD.setDefaultErrorResource(R.drawable.pic_bg_video_frs);
            }
        }
    }
}
