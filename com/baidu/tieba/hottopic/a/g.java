package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.hottopic.view.TopicVideoProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes21.dex */
public class g extends af.a {
    public int aku;
    public View elr;
    public TbCyberVideoView gqV;
    public ForeDrawableImageView kfp;
    public TopicVideoControllerView kfq;
    public TopicVideoProgressView kfr;
    public View kfs;
    public TextView kft;
    public ImageView kfu;
    public View kfv;
    public TextView kfw;
    public View kfx;
    public RelativeLayout kfy;

    public g(View view) {
        super(view);
        this.aku = 3;
        if (view != null) {
            this.kfy = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.kfp = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.gqV = new TbCyberVideoView(view.getContext());
            this.gqV.setStageType(null);
            bIl();
            this.kfq = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.kfr = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.kfs = view.findViewById(R.id.topic_replay_layout);
            this.kft = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.kfu = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.kfv = view.findViewById(R.id.topic_layout_loading);
            this.elr = view.findViewById(R.id.topic_video_cover_view);
            this.kfw = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.kfx = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bIl() {
        if (this.gqV != null && this.gqV.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kfy.addView(this.gqV.getView(), 0);
            this.gqV.getView().setLayoutParams(layoutParams);
        }
    }
}
