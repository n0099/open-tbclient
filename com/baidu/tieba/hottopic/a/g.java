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
    public View efX;
    public TbCyberVideoView gjd;
    public ForeDrawableImageView jQZ;
    public TopicVideoControllerView jRa;
    public TopicVideoProgressView jRb;
    public View jRc;
    public TextView jRd;
    public ImageView jRe;
    public View jRf;
    public TextView jRg;
    public View jRh;
    public RelativeLayout jRi;

    public g(View view) {
        super(view);
        this.ajq = 3;
        if (view != null) {
            this.jRi = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.jQZ = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.gjd = new TbCyberVideoView(view.getContext());
            this.gjd.setStageType(null);
            bFr();
            this.jRa = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.jRb = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.jRc = view.findViewById(R.id.topic_replay_layout);
            this.jRd = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.jRe = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.jRf = view.findViewById(R.id.topic_layout_loading);
            this.efX = view.findViewById(R.id.topic_video_cover_view);
            this.jRg = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.jRh = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bFr() {
        if (this.gjd != null && this.gjd.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jRi.addView(this.gjd.getView(), 0);
            this.gjd.getView().setLayoutParams(layoutParams);
        }
    }
}
