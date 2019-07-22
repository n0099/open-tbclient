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
    private com.baidu.tieba.channel.view.b eHY;
    private boolean mIsHost;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
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
        aVar.eIb.setText(hVar.getTitle());
        aVar.SE.startLoad(hVar.getThumbnailUrl(), 10, false);
        aVar.eId.setText(this.mContext.getResources().getString(R.string.channel_home_play_count, aq.aH(hVar.baH())));
        aVar.eIe.setText(com.baidu.tieba.channel.c.c.cG(hVar.getCreateTime()));
        aVar.eIf.setText(aq.io(hVar.getVideoDuration() * 1000));
        if (this.mIsHost) {
            aVar.eIm.setVisibility(0);
            aVar.eIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.eHY != null) {
                        e.this.eHY.a(9, view, hVar, i);
                    }
                }
            });
        } else {
            aVar.eIm.setVisibility(8);
        }
        aVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.eHY != null) {
                    e.this.eHY.a(2, view, hVar, i);
                }
            }
        });
    }

    private void a(a aVar, h hVar) {
        am.j(aVar.eIb, R.color.cp_cont_b);
        am.j(aVar.eId, R.color.cp_cont_c);
        am.j(aVar.eIf, R.color.cp_cont_g);
        am.j(aVar.eIe, R.color.cp_cont_c);
    }

    public void a(com.baidu.tieba.channel.view.b bVar) {
        this.eHY = bVar;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public TbImageView SE;
        public TextView eIb;
        public TextView eId;
        public TextView eIe;
        public TextView eIf;
        public ImageView eIm;
        public View mRootView;

        public a(View view) {
            super(view);
            bJ(view);
        }

        private void bJ(View view) {
            if (view != null) {
                this.mRootView = view;
                this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.channel.a.e.a.1
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
                this.eIb = (TextView) view.findViewById(R.id.channel_home_video_title);
                this.eId = (TextView) view.findViewById(R.id.channel_home_big_video_count);
                this.eIe = (TextView) view.findViewById(R.id.channel_home_big_video_time);
                this.eIf = (TextView) view.findViewById(R.id.channel_home_big_video_duration);
                this.eIm = (ImageView) view.findViewById(R.id.channel_host_common_video_more_btn);
                this.SE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.SE.setDefaultResource(R.drawable.pic_bg_video_frs);
                this.SE.setDefaultErrorResource(R.drawable.pic_bg_video_frs);
            }
        }
    }
}
