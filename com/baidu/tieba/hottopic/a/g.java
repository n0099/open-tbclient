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
    public int aiX;
    public View dFJ;
    public TbCyberVideoView fHb;
    public ForeDrawableImageView jjF;
    public TopicVideoControllerView jjG;
    public TopicVideoProgressView jjH;
    public View jjI;
    public TextView jjJ;
    public ImageView jjK;
    public View jjL;
    public TextView jjM;
    public View jjN;
    public RelativeLayout jjO;

    public g(View view) {
        super(view);
        this.aiX = 3;
        if (view != null) {
            this.jjO = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.jjF = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.fHb = new TbCyberVideoView(view.getContext());
            this.fHb.setStageType(null);
            byp();
            this.jjG = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.jjH = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.jjI = view.findViewById(R.id.topic_replay_layout);
            this.jjJ = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.jjK = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.jjL = view.findViewById(R.id.topic_layout_loading);
            this.dFJ = view.findViewById(R.id.topic_video_cover_view);
            this.jjM = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.jjN = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void byp() {
        if (this.fHb != null && this.fHb.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jjO.addView(this.fHb.getView(), 0);
            this.fHb.getView().setLayoutParams(layoutParams);
        }
    }
}
