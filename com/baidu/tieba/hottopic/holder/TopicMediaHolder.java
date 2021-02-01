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
    public int ajU;
    public View erP;
    public TbCyberVideoView gzX;
    public ForeDrawableImageView kwd;
    public TopicVideoControllerView kwe;
    public TopicVideoProgressView kwf;
    public View kwg;
    public TextView kwh;
    public ImageView kwi;
    public View kwj;
    public TextView kwk;
    public View kwl;
    public RelativeLayout kwm;

    public TopicMediaHolder(View view) {
        super(view);
        this.ajU = 3;
        if (view != null) {
            this.kwm = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.kwd = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.gzX = new TbCyberVideoView(view.getContext());
            this.gzX.setStageType(null);
            bHi();
            this.kwe = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.kwf = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.kwg = view.findViewById(R.id.topic_replay_layout);
            this.kwh = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.kwi = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.kwj = view.findViewById(R.id.topic_layout_loading);
            this.erP = view.findViewById(R.id.topic_video_cover_view);
            this.kwk = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.kwl = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bHi() {
        if (this.gzX != null && this.gzX.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kwm.addView(this.gzX.getView(), 0);
            this.gzX.getView().setLayoutParams(layoutParams);
        }
    }
}
