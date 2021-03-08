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
/* loaded from: classes7.dex */
public class TopicMediaHolder extends TypeAdapter.ViewHolder {
    public int aln;
    public View etr;
    public TbCyberVideoView gBU;
    public TextView kyA;
    public View kyB;
    public RelativeLayout kyC;
    public ForeDrawableImageView kyt;
    public TopicVideoControllerView kyu;
    public TopicVideoProgressView kyv;
    public View kyw;
    public TextView kyx;
    public ImageView kyy;
    public View kyz;

    public TopicMediaHolder(View view) {
        super(view);
        this.aln = 3;
        if (view != null) {
            this.kyC = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.kyt = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.gBU = new TbCyberVideoView(view.getContext());
            this.gBU.setStageType(null);
            bHm();
            this.kyu = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.kyv = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.kyw = view.findViewById(R.id.topic_replay_layout);
            this.kyx = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.kyy = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.kyz = view.findViewById(R.id.topic_layout_loading);
            this.etr = view.findViewById(R.id.topic_video_cover_view);
            this.kyA = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.kyB = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bHm() {
        if (this.gBU != null && this.gBU.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kyC.addView(this.gBU.getView(), 0);
            this.gBU.getView().setLayoutParams(layoutParams);
        }
    }
}
