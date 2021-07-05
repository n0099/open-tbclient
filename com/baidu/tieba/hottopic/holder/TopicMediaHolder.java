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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TopicMediaHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f17101a;

    /* renamed from: b  reason: collision with root package name */
    public ForeDrawableImageView f17102b;

    /* renamed from: c  reason: collision with root package name */
    public TbCyberVideoView f17103c;

    /* renamed from: d  reason: collision with root package name */
    public TopicVideoControllerView f17104d;

    /* renamed from: e  reason: collision with root package name */
    public TopicVideoProgressView f17105e;

    /* renamed from: f  reason: collision with root package name */
    public View f17106f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17107g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f17108h;

    /* renamed from: i  reason: collision with root package name */
    public View f17109i;
    public View j;
    public TextView k;
    public View l;
    public RelativeLayout m;

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
        this.f17101a = 3;
        if (view == null) {
            return;
        }
        this.m = (RelativeLayout) view.findViewById(R.id.topic_layout_video_view);
        this.f17102b = (ForeDrawableImageView) view.findViewById(R.id.topic_list_video_item_thumbnail);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(view.getContext());
        this.f17103c = tbCyberVideoView;
        tbCyberVideoView.setStageType(null);
        b();
        this.f17104d = (TopicVideoControllerView) view.findViewById(R.id.topic_video_controller);
        this.f17105e = (TopicVideoProgressView) view.findViewById(R.id.topic_video_progress_view);
        this.f17106f = view.findViewById(R.id.topic_replay_layout);
        this.f17107g = (TextView) view.findViewById(R.id.textview_topic_replay);
        this.f17108h = (ImageView) view.findViewById(R.id.topic_img_pause_play);
        this.f17109i = view.findViewById(R.id.topic_layout_loading);
        this.j = view.findViewById(R.id.topic_video_cover_view);
        this.k = (TextView) view.findViewById(R.id.topic_vedio_title);
        this.l = view.findViewById(R.id.topic_vedio_line);
    }

    public final void b() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tbCyberVideoView = this.f17103c) != null && tbCyberVideoView.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.m.addView(this.f17103c.getView(), 0);
            this.f17103c.getView().setLayoutParams(layoutParams);
        }
    }
}
