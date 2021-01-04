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
/* loaded from: classes8.dex */
public class TopicMediaHolder extends TypeAdapter.ViewHolder {
    public int akW;
    public View euw;
    public TbCyberVideoView gBU;
    public ForeDrawableImageView ksB;
    public TopicVideoControllerView ksC;
    public TopicVideoProgressView ksD;
    public View ksE;
    public TextView ksF;
    public ImageView ksG;
    public View ksH;
    public TextView ksI;
    public View ksJ;
    public RelativeLayout ksK;

    public TopicMediaHolder(View view) {
        super(view);
        this.akW = 3;
        if (view != null) {
            this.ksK = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.ksB = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.gBU = new TbCyberVideoView(view.getContext());
            this.gBU.setStageType(null);
            bKF();
            this.ksC = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.ksD = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.ksE = view.findViewById(R.id.topic_replay_layout);
            this.ksF = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.ksG = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.ksH = view.findViewById(R.id.topic_layout_loading);
            this.euw = view.findViewById(R.id.topic_video_cover_view);
            this.ksI = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.ksJ = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bKF() {
        if (this.gBU != null && this.gBU.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.ksK.addView(this.gBU.getView(), 0);
            this.gBU.getView().setLayoutParams(layoutParams);
        }
    }
}
