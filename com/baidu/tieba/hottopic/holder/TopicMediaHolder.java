package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.hottopic.view.TopicVideoProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes4.dex */
public class TopicMediaHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17592a;

    /* renamed from: b  reason: collision with root package name */
    public ForeDrawableImageView f17593b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f17594c;

    /* renamed from: d  reason: collision with root package name */
    public TopicVideoControllerView f17595d;

    /* renamed from: e  reason: collision with root package name */
    public TopicVideoProgressView f17596e;

    /* renamed from: f  reason: collision with root package name */
    public View f17597f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17598g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f17599h;

    /* renamed from: i  reason: collision with root package name */
    public View f17600i;
    public View j;
    public TextView k;
    public View l;
    public RelativeLayout m;

    public TopicMediaHolder(View view) {
        super(view);
        this.f17592a = 3;
        if (view == null) {
            return;
        }
        this.m = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
        this.f17593b = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(view.getContext());
        this.f17594c = tbCyberVideoView;
        tbCyberVideoView.setStageType(null);
        b();
        this.f17595d = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
        this.f17596e = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
        this.f17597f = view.findViewById(R.id.topic_replay_layout);
        this.f17598g = (TextView) view.findViewById(R.id.textview_topic_replay);
        this.f17599h = (ImageView) view.findViewById(R.id.topic_img_pause_play);
        this.f17600i = view.findViewById(R.id.topic_layout_loading);
        this.j = view.findViewById(R.id.topic_video_cover_view);
        this.k = (TextView) view.findViewById(R.id.topic_vedio_title);
        this.l = view.findViewById(R.id.topic_vedio_line);
    }

    public final void b() {
        TbCyberVideoView tbCyberVideoView = this.f17594c;
        if (tbCyberVideoView == null || tbCyberVideoView.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.m.addView(this.f17594c.getView(), 0);
        this.f17594c.getView().setLayoutParams(layoutParams);
    }
}
