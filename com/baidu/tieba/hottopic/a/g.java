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
    public TbCyberVideoView gqT;
    public ForeDrawableImageView kfn;
    public TopicVideoControllerView kfo;
    public TopicVideoProgressView kfp;
    public View kfq;
    public TextView kfr;
    public ImageView kfs;
    public View kft;
    public TextView kfu;
    public View kfv;
    public RelativeLayout kfw;

    public g(View view) {
        super(view);
        this.aku = 3;
        if (view != null) {
            this.kfw = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.kfn = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.gqT = new TbCyberVideoView(view.getContext());
            this.gqT.setStageType(null);
            bIl();
            this.kfo = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.kfp = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.kfq = view.findViewById(R.id.topic_replay_layout);
            this.kfr = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.kfs = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.kft = view.findViewById(R.id.topic_layout_loading);
            this.elr = view.findViewById(R.id.topic_video_cover_view);
            this.kfu = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.kfv = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bIl() {
        if (this.gqT != null && this.gqT.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kfw.addView(this.gqT.getView(), 0);
            this.gqT.getView().setLayoutParams(layoutParams);
        }
    }
}
