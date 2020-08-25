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
/* loaded from: classes15.dex */
public class g extends af.a {
    public int aiB;
    public View dDE;
    public TbCyberVideoView fDL;
    public ForeDrawableImageView jaT;
    public TopicVideoControllerView jaU;
    public TopicVideoProgressView jaV;
    public View jaW;
    public TextView jaX;
    public ImageView jaY;
    public View jaZ;
    public TextView jba;
    public View jbb;
    public RelativeLayout jbc;

    public g(View view) {
        super(view);
        this.aiB = 3;
        if (view != null) {
            this.jbc = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.jaT = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.fDL = new TbCyberVideoView(view.getContext());
            this.fDL.setStageType(null);
            bxf();
            this.jaU = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.jaV = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.jaW = view.findViewById(R.id.topic_replay_layout);
            this.jaX = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.jaY = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.jaZ = view.findViewById(R.id.topic_layout_loading);
            this.dDE = view.findViewById(R.id.topic_video_cover_view);
            this.jba = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.jbb = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bxf() {
        if (this.fDL != null && this.fDL.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jbc.addView(this.fDL.getView(), 0);
            this.fDL.getView().setLayoutParams(layoutParams);
        }
    }
}
