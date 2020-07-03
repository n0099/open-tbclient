package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.hottopic.view.TopicVideoProgressView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.n;
/* loaded from: classes8.dex */
public class g extends ad.a {
    public int ahx;
    public View dnJ;
    public QuickVideoView fnh;
    public n fnj;
    public ForeDrawableImageView iFP;
    public TopicVideoControllerView iFQ;
    public TopicVideoProgressView iFR;
    public View iFS;
    public TextView iFT;
    public ImageView iFU;
    public View iFV;
    public TextView iFW;
    public View iFX;

    public g(View view) {
        super(view);
        this.ahx = 3;
        if (view != null) {
            this.iFP = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.fnh = (QuickVideoView) view.findViewById(R.id.topic_videoview);
            this.fnj = new n(view.getContext());
            this.iFQ = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.iFR = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.iFS = view.findViewById(R.id.topic_replay_layout);
            this.iFT = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.iFU = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.iFV = view.findViewById(R.id.topic_layout_loading);
            this.dnJ = view.findViewById(R.id.topic_video_cover_view);
            this.iFW = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.iFX = view.findViewById(R.id.topic_vedio_line);
        }
    }
}
