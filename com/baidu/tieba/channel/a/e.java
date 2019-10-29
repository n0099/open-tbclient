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
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private com.baidu.tieba.channel.view.b eSt;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_common_video_item, viewGroup, false));
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
        if (this.mIsHost) {
            aVar.eSH.setVisibility(0);
            aVar.eSH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.eSt != null) {
                        e.this.eSt.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.eSH.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eSt != null) {
                    e.this.eSt.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        am.setViewTextColor(aVar.eSw, (int) R.color.cp_cont_b);
        am.setViewTextColor(aVar.eSy, (int) R.color.cp_cont_c);
        am.setViewTextColor(aVar.eSA, (int) R.color.cp_cont_g);
        am.setViewTextColor(aVar.eSz, (int) R.color.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eSt = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView BY;
        public TextView eSA;
        public ImageView eSH;
        public TextView eSw;
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
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.e.a.1
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
                this.eSy = (TextView) view.findViewById(R.id.channel_home_big_video_count);
                this.eSz = (TextView) view.findViewById(R.id.channel_home_big_video_time);
                this.eSA = (TextView) view.findViewById(R.id.channel_home_big_video_duration);
                this.eSH = (ImageView) view.findViewById(R.id.channel_host_common_video_more_btn);
                this.BY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.BY.setDefaultResource(R.drawable.pic_bg_video_frs);
                this.BY.setDefaultErrorResource(R.drawable.pic_bg_video_frs);
            }
        }
    }
}
