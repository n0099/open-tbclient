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
    private com.baidu.tieba.channel.view.b eSt;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mIsHost = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_big_video_item, viewGroup, false));
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (hVar != null && aVar != null) {
            a(aVar, hVar, i);
            a(aVar, hVar);
        }
        return view;
    }

    private void a(a aVar, final h hVar, final int i) {
        aVar.eSw.setText(hVar.getTitle());
        aVar.BY.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.eSy.setText(this.mContext.getResources().getString(R.string.channel_home_play_count, aq.numberUniformFormat(hVar.bbr())));
        aVar.eSz.setText(com.baidu.tieba.channel.c.c.cx(hVar.getCreateTime()));
        aVar.eSA.setText(aq.formatSecondsTime(hVar.getVideoDuration() * 1000));
        if (this.eSt != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.eSt != null) {
                        d.this.eSt.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.eSC.setVisibility(0);
            aVar.eSB.setVisibility(8);
            aVar.eSC.setClickable(true);
            aVar.eSD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.eSt != null) {
                        d.this.eSt.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.eSC.setVisibility(8);
            aVar.eSB.setVisibility(0);
        }
        if (hVar.ajn()) {
            aVar.ddp.setVisibility(0);
            aVar.eSE.setVisibility(0);
            return;
        }
        aVar.ddp.setVisibility(8);
        aVar.eSE.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        am.setViewTextColor(aVar.ddp, (int) R.color.cp_cont_g);
        am.setViewTextColor(aVar.eSw, (int) R.color.cp_cont_g);
        am.setViewTextColor(aVar.eSw, (int) R.color.cp_cont_g);
        am.setImageResource(aVar.eSE, R.drawable.channel_home_dot);
        am.setViewTextColor(aVar.eSy, (int) R.color.cp_cont_g);
        am.setViewTextColor(aVar.eSA, (int) R.color.cp_cont_g);
        am.setViewTextColor(aVar.eSz, (int) R.color.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eSt = bVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView BY;
        public TextView ddp;
        public TextView eSA;
        public View eSB;
        public View eSC;
        public ImageView eSD;
        public ImageView eSE;
        public TextView eSw;
        public ImageView eSx;
        public TextView eSy;
        public TextView eSz;
        public View mRootView;

        public a(View view) {
            super(view);
            bG(view);
        }

        private void bG(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.d.a.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            am.setBackgroundColor(a.this.mRootView, R.color.cp_bg_line_c);
                            return false;
                        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            a.this.mRootView.setBackgroundResource(R.color.transparent);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
                this.BY = (TbImageView) view.findViewById(R.id.channel_home_video_cover);
                this.eSw = (TextView) view.findViewById(R.id.channel_home_video_title);
                this.eSx = (ImageView) view.findViewById(R.id.channel_home_video_play);
                this.eSy = (TextView) view.findViewById(R.id.channel_home_big_video_count);
                this.eSz = (TextView) view.findViewById(R.id.channel_home_big_video_time);
                this.eSA = (TextView) view.findViewById(R.id.channel_home_big_video_duration);
                this.eSB = view.findViewById(R.id.channel_guest_big_video_gap);
                this.eSC = view.findViewById(R.id.channel_host_big_video_more_layout);
                this.eSD = (ImageView) view.findViewById(R.id.channel_host_big_video_more_btn);
                this.ddp = (TextView) view.findViewById(R.id.channel_home_big_set_top_textview);
                this.eSE = (ImageView) view.findViewById(R.id.channel_home_big_set_top_dot);
                this.BY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.BY.setDefaultResource(R.drawable.pic_bg_video_frs);
                this.BY.setDefaultErrorResource(R.drawable.pic_bg_video_frs);
            }
        }
    }
}
