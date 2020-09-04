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
    public int aiD;
    public View dDI;
    public TbCyberVideoView fDP;
    public ForeDrawableImageView jaZ;
    public TopicVideoControllerView jba;
    public TopicVideoProgressView jbb;
    public View jbc;
    public TextView jbd;
    public ImageView jbe;
    public View jbf;
    public TextView jbg;
    public View jbh;
    public RelativeLayout jbi;

    public g(View view) {
        super(view);
        this.aiD = 3;
        if (view != null) {
            this.jbi = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.jaZ = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.fDP = new TbCyberVideoView(view.getContext());
            this.fDP.setStageType(null);
            bxg();
            this.jba = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.jbb = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.jbc = view.findViewById(R.id.topic_replay_layout);
            this.jbd = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.jbe = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.jbf = view.findViewById(R.id.topic_layout_loading);
            this.dDI = view.findViewById(R.id.topic_video_cover_view);
            this.jbg = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.jbh = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bxg() {
        if (this.fDP != null && this.fDP.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.jbi.addView(this.fDP.getView(), 0);
            this.fDP.getView().setLayoutParams(layoutParams);
        }
    }
}
