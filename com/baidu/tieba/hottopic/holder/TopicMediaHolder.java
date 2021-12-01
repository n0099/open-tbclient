package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.r0.p1.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.hottopic.view.TopicVideoControllerView;
import com.baidu.tieba.hottopic.view.TopicVideoProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class TopicMediaHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mBtnPausePlay;
    public TextView mBtnReplay;
    public TopicVideoControllerView mControllerView;
    public View mCoverView;
    public View mLoadingLayout;
    public View mReplayLayout;
    public ForeDrawableImageView mThumbnailImage;
    public RelativeLayout mTopicLayoutVideoView;
    public View mVedioLine;
    public TextView mVedioTitle;
    public TopicVideoProgressView mVideoProgressView;
    public TbCyberVideoView mVideoView;
    public int skinType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicMediaHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.skinType = 3;
        if (view == null) {
            return;
        }
        this.mTopicLayoutVideoView = (RelativeLayout) view.findViewById(e.topic_layout_video_view);
        this.mThumbnailImage = (ForeDrawableImageView) view.findViewById(e.topic_list_video_item_thumbnail);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(view.getContext());
        this.mVideoView = tbCyberVideoView;
        tbCyberVideoView.setStageType(null);
        b();
        this.mControllerView = (TopicVideoControllerView) view.findViewById(e.topic_video_controller);
        this.mVideoProgressView = (TopicVideoProgressView) view.findViewById(e.topic_video_progress_view);
        this.mReplayLayout = view.findViewById(e.topic_replay_layout);
        this.mBtnReplay = (TextView) view.findViewById(e.textview_topic_replay);
        this.mBtnPausePlay = (ImageView) view.findViewById(e.topic_img_pause_play);
        this.mLoadingLayout = view.findViewById(e.topic_layout_loading);
        this.mCoverView = view.findViewById(e.topic_video_cover_view);
        this.mVedioTitle = (TextView) view.findViewById(e.topic_vedio_title);
        this.mVedioLine = view.findViewById(e.topic_vedio_line);
    }

    public final void b() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.mTopicLayoutVideoView.addView(this.mVideoView.getView(), 0);
            this.mVideoView.getView().setLayoutParams(layoutParams);
        }
    }
}
