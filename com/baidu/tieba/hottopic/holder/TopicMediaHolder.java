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
    public int f16893a;

    /* renamed from: b  reason: collision with root package name */
    public ForeDrawableImageView f16894b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f16895c;

    /* renamed from: d  reason: collision with root package name */
    public TopicVideoControllerView f16896d;

    /* renamed from: e  reason: collision with root package name */
    public TopicVideoProgressView f16897e;

    /* renamed from: f  reason: collision with root package name */
    public View f16898f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16899g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f16900h;

    /* renamed from: i  reason: collision with root package name */
    public View f16901i;
    public View j;
    public TextView k;
    public View l;
    public RelativeLayout m;

    public TopicMediaHolder(View view) {
        super(view);
        this.f16893a = 3;
        if (view == null) {
            return;
        }
        this.m = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
        this.f16894b = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(view.getContext());
        this.f16895c = tbCyberVideoView;
        tbCyberVideoView.setStageType(null);
        b();
        this.f16896d = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
        this.f16897e = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
        this.f16898f = view.findViewById(R.id.topic_replay_layout);
        this.f16899g = (TextView) view.findViewById(R.id.textview_topic_replay);
        this.f16900h = (ImageView) view.findViewById(R.id.topic_img_pause_play);
        this.f16901i = view.findViewById(R.id.topic_layout_loading);
        this.j = view.findViewById(R.id.topic_video_cover_view);
        this.k = (TextView) view.findViewById(R.id.topic_vedio_title);
        this.l = view.findViewById(R.id.topic_vedio_line);
    }

    public final void b() {
        TbCyberVideoView tbCyberVideoView = this.f16895c;
        if (tbCyberVideoView == null || tbCyberVideoView.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.m.addView(this.f16895c.getView(), 0);
        this.f16895c.getView().setLayoutParams(layoutParams);
    }
}
