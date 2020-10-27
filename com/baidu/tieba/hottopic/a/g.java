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
    public int ajq;
    public View eag;
    public TbCyberVideoView gdn;
    public ForeDrawableImageView jLc;
    public TopicVideoControllerView jLd;
    public TopicVideoProgressView jLe;
    public View jLf;
    public TextView jLg;
    public ImageView jLh;
    public View jLi;
    public TextView jLj;
    public View jLk;
    public RelativeLayout jLl;

    public g(View view) {
        super(view);
        this.ajq = 3;
        if (view != null) {
            this.jLl = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.jLc = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.gdn = new TbCyberVideoView(view.getContext());
            this.gdn.setStageType(null);
            bCS();
            this.jLd = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.jLe = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.jLf = view.findViewById(R.id.topic_replay_layout);
            this.jLg = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.jLh = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.jLi = view.findViewById(R.id.topic_layout_loading);
            this.eag = view.findViewById(R.id.topic_video_cover_view);
            this.jLj = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.jLk = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bCS() {
        if (this.gdn != null && this.gdn.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jLl.addView(this.gdn.getView(), 0);
            this.gdn.getView().setLayoutParams(layoutParams);
        }
    }
}
