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
    public ForeDrawableImageView iLV;
    public TopicVideoControllerView iLW;
    public TopicVideoProgressView iLX;
    public View iLY;
    public TextView iLZ;
    public ImageView iMa;
    public View iMb;
    public TextView iMc;
    public View iMd;
    public RelativeLayout iMe;

    public g(View view) {
        super(view);
        this.aho = 3;
        if (view != null) {
            this.iMe = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.iLV = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.fsr = new TbCyberVideoView(view.getContext());
            bos();
            this.iLW = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.iLX = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.iLY = view.findViewById(R.id.topic_replay_layout);
            this.iLZ = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.iMa = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.iMb = view.findViewById(R.id.topic_layout_loading);
            this.dtF = view.findViewById(R.id.topic_video_cover_view);
            this.iMc = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.iMd = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bos() {
        if (this.fsr != null && this.fsr.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.iMe.addView(this.fsr.getView(), 0);
            this.fsr.getView().setLayoutParams(layoutParams);
        }
    }
}
