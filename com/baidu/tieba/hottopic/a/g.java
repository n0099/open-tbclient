package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.hottopic.view.TopicVideoProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes15.dex */
public class g extends ad.a {
    public int aho;
    public View dtF;
    public TbCyberVideoView fsr;
    public ForeDrawableImageView iLT;
    public TopicVideoControllerView iLU;
    public TopicVideoProgressView iLV;
    public View iLW;
    public TextView iLX;
    public ImageView iLY;
    public View iLZ;
    public TextView iMa;
    public View iMb;
    public RelativeLayout iMc;

    public g(View view) {
        super(view);
        this.aho = 3;
        if (view != null) {
            this.iMc = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.iLT = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.fsr = new TbCyberVideoView(view.getContext());
            bos();
            this.iLU = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.iLV = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.iLW = view.findViewById(R.id.topic_replay_layout);
            this.iLX = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.iLY = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.iLZ = view.findViewById(R.id.topic_layout_loading);
            this.dtF = view.findViewById(R.id.topic_video_cover_view);
            this.iMa = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.iMb = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bos() {
        if (this.fsr != null && this.fsr.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.iMc.addView(this.fsr.getView(), 0);
            this.fsr.getView().setLayoutParams(layoutParams);
        }
    }
}
