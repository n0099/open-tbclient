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
    public int akf;
    public View epI;
    public TbCyberVideoView gxn;
    public ForeDrawableImageView knW;
    public TopicVideoControllerView knX;
    public TopicVideoProgressView knY;
    public View knZ;
    public TextView koa;
    public ImageView kob;
    public View koc;
    public TextView kod;
    public View koe;
    public RelativeLayout kof;

    public TopicMediaHolder(View view) {
        super(view);
        this.akf = 3;
        if (view != null) {
            this.kof = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
            this.knW = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
            this.gxn = new TbCyberVideoView(view.getContext());
            this.gxn.setStageType(null);
            bGO();
            this.knX = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
            this.knY = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
            this.knZ = view.findViewById(R.id.topic_replay_layout);
            this.koa = (TextView) view.findViewById(R.id.textview_topic_replay);
            this.kob = (ImageView) view.findViewById(R.id.topic_img_pause_play);
            this.koc = view.findViewById(R.id.topic_layout_loading);
            this.epI = view.findViewById(R.id.topic_video_cover_view);
            this.kod = (TextView) view.findViewById(R.id.topic_vedio_title);
            this.koe = view.findViewById(R.id.topic_vedio_line);
        }
    }

    private void bGO() {
        if (this.gxn != null && this.gxn.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.kof.addView(this.gxn.getView(), 0);
            this.gxn.getView().setLayoutParams(layoutParams);
        }
    }
}
