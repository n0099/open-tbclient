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
    public TbCyberVideoView gAl;
    public RelativeLayout kwA;
    public ForeDrawableImageView kwr;
    public TopicVideoControllerView kws;
    public TopicVideoProgressView kwt;
    public View kwu;
    public TextView kwv;
    public ImageView kww;
    public View kwx;
    public TextView kwy;
    public View kwz;

    public TopicMediaHolder(View view) {
        super(view);
        this.ajU = 3;
        if (view != null) {
            this.kwA = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.kwr = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.gAl = new TbCyberVideoView(view.getContext());
            this.gAl.setStageType(null);
            bHi();
            this.kws = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.kwt = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.kwu = view.findViewById(R.id.topic_replay_layout);
            this.kwv = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.kww = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.kwx = view.findViewById(R.id.topic_layout_loading);
            this.erP = view.findViewById(R.id.topic_video_cover_view);
            this.kwy = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.kwz = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bHi() {
        if (this.gAl != null && this.gAl.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kwA.addView(this.gAl.getView(), 0);
            this.gAl.getView().setLayoutParams(layoutParams);
        }
    }
}
