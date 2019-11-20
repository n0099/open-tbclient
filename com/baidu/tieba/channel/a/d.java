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
    private com.baidu.tieba.channel.view.b eRC;
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
        aVar.eRF.setText(hVar.getTitle());
        aVar.By.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.eRH.setText(this.mContext.getResources().getString(R.string.channel_home_play_count, aq.numberUniformFormat(hVar.bbp())));
        aVar.eRI.setText(com.baidu.tieba.channel.c.c.cw(hVar.getCreateTime()));
        aVar.eRJ.setText(aq.formatSecondsTime(hVar.getVideoDuration() * 1000));
        if (this.eRC != null) {
            aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.eRC != null) {
                        d.this.eRC.a(1, view, hVar, i);
                    }
                }
            });
        }
        if (this.mIsHost) {
            aVar.eRL.setVisibility(0);
            aVar.eRK.setVisibility(8);
            aVar.eRL.setClickable(true);
            aVar.eRM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.eRC != null) {
                        d.this.eRC.a(8, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.eRL.setVisibility(8);
            aVar.eRK.setVisibility(0);
        }
        if (hVar.ajl()) {
            aVar.dcy.setVisibility(0);
            aVar.eRN.setVisibility(0);
            return;
        }
        aVar.dcy.setVisibility(8);
        aVar.eRN.setVisibility(8);
    }

    private void a(a aVar, h hVar) {
        am.setViewTextColor(aVar.dcy, (int) R.color.cp_cont_g);
        am.setViewTextColor(aVar.eRF, (int) R.color.cp_cont_g);
        am.setViewTextColor(aVar.eRF, (int) R.color.cp_cont_g);
        am.setImageResource(aVar.eRN, R.drawable.channel_home_dot);
        am.setViewTextColor(aVar.eRH, (int) R.color.cp_cont_g);
        am.setViewTextColor(aVar.eRJ, (int) R.color.cp_cont_g);
        am.setViewTextColor(aVar.eRI, (int) R.color.cp_cont_g);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eRC = bVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView By;
        public TextView dcy;
        public TextView eRF;
        public ImageView eRG;
        public TextView eRH;
        public TextView eRI;
        public TextView eRJ;
        public View eRK;
        public View eRL;
        public ImageView eRM;
        public ImageView eRN;
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
                this.By = (TbImageView) view.findViewById(R.id.channel_home_video_cover);
                this.eRF = (TextView) view.findViewById(R.id.channel_home_video_title);
                this.eRG = (ImageView) view.findViewById(R.id.channel_home_video_play);
                this.eRH = (TextView) view.findViewById(R.id.channel_home_big_video_count);
                this.eRI = (TextView) view.findViewById(R.id.channel_home_big_video_time);
                this.eRJ = (TextView) view.findViewById(R.id.channel_home_big_video_duration);
                this.eRK = view.findViewById(R.id.channel_guest_big_video_gap);
                this.eRL = view.findViewById(R.id.channel_host_big_video_more_layout);
                this.eRM = (ImageView) view.findViewById(R.id.channel_host_big_video_more_btn);
                this.dcy = (TextView) view.findViewById(R.id.channel_home_big_set_top_textview);
                this.eRN = (ImageView) view.findViewById(R.id.channel_home_big_set_top_dot);
                this.By.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.By.setDefaultResource(R.drawable.pic_bg_video_frs);
                this.By.setDefaultErrorResource(R.drawable.pic_bg_video_frs);
            }
        }
    }
}
