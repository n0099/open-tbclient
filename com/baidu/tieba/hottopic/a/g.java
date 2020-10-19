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
    public int ajp;
    public View dRK;
    public TbCyberVideoView fTk;
    public ForeDrawableImageView jyD;
    public TopicVideoControllerView jyE;
    public TopicVideoProgressView jyF;
    public View jyG;
    public TextView jyH;
    public ImageView jyI;
    public View jyJ;
    public TextView jyK;
    public View jyL;
    public RelativeLayout jyM;

    public g(View view) {
        super(view);
        this.ajp = 3;
        if (view != null) {
            this.jyM = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.jyD = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.fTk = new TbCyberVideoView(view.getContext());
            this.fTk.setStageType(null);
            bAZ();
            this.jyE = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.jyF = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.jyG = view.findViewById(R.id.topic_replay_layout);
            this.jyH = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.jyI = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.jyJ = view.findViewById(R.id.topic_layout_loading);
            this.dRK = view.findViewById(R.id.topic_video_cover_view);
            this.jyK = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.jyL = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bAZ() {
        if (this.fTk != null && this.fTk.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jyM.addView(this.fTk.getView(), 0);
            this.fTk.getView().setLayoutParams(layoutParams);
        }
    }
}
