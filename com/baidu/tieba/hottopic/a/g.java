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
/* loaded from: classes20.dex */
public class g extends af.a {
    public int ajv;
    public View eeq;
    public TbCyberVideoView giK;
    public ForeDrawableImageView jRJ;
    public TopicVideoControllerView jRK;
    public TopicVideoProgressView jRL;
    public View jRM;
    public TextView jRN;
    public ImageView jRO;
    public View jRP;
    public TextView jRQ;
    public View jRR;
    public RelativeLayout jRS;

    public g(View view) {
        super(view);
        this.ajv = 3;
        if (view != null) {
            this.jRS = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.jRJ = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.giK = new TbCyberVideoView(view.getContext());
            this.giK.setStageType(null);
            bEK();
            this.jRK = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.jRL = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.jRM = view.findViewById(R.id.topic_replay_layout);
            this.jRN = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.jRO = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.jRP = view.findViewById(R.id.topic_layout_loading);
            this.eeq = view.findViewById(R.id.topic_video_cover_view);
            this.jRQ = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.jRR = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bEK() {
        if (this.giK != null && this.giK.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jRS.addView(this.giK.getView(), 0);
            this.giK.getView().setLayoutParams(layoutParams);
        }
    }
}
