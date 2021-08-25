package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.f1.k.a.c.b;
import c.a.q0.f1.k.a.c.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class TopicDetailHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f52368e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f52369f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52370g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f52371h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f52372i;

    /* renamed from: j  reason: collision with root package name */
    public View f52373j;
    public TopicTimelineView k;
    public TopicPkView mPkView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailHeadView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52368e = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.topic_detail_head_view_layout, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.topic_detail_head_bg);
            this.f52369f = tbImageView;
            tbImageView.setDrawingCacheEnabled(true);
            this.f52370g = (TextView) findViewById(R.id.topic_detail_head_des);
            this.f52371h = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
            this.f52372i = (TbImageView) findViewById(R.id.topic_detail_head_img);
            this.f52373j = findViewById(R.id.topic_detail_head_img_placeholder);
            this.mPkView = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
            this.k = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
            ViewGroup.LayoutParams layoutParams = this.f52372i.getLayoutParams();
            layoutParams.height = ((l.k(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
            this.f52372i.setLayoutParams(layoutParams);
            this.f52372i.setRadius(l.g(context, R.dimen.tbds10));
            this.f52372i.setConrers(15);
            this.f52372i.setPlaceHolder(3);
            onChangeSkinType();
        }
    }

    public TbImageView getmBgImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52369f : (TbImageView) invokeV.objValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f52368e) {
            return;
        }
        this.f52368e = skinType;
        this.f52369f.setIsNight(skinType == 1);
        SkinManager.setViewTextColor(this.f52370g, R.color.CAM_X0101);
        this.f52372i.setIsNight(this.f52368e == 1);
        this.mPkView.onChangeSkinType();
        this.k.onChangeSkinType();
    }

    public void setData(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (bVar.f17951e == null && StringUtils.isNull(bVar.f17949c)) {
                ((LinearLayout.LayoutParams) this.f52370g.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
            }
            this.f52370g.setText(bVar.f17948b);
            if (StringUtils.isNull(bVar.f17949c)) {
                this.f52371h.setVisibility(8);
                this.f52369f.setDefaultBgResource(R.drawable.topic_detail_default_bg);
            } else {
                this.f52371h.setVisibility(0);
                this.f52372i.startLoad(bVar.f17949c, 10, false);
                this.f52369f.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
            }
            if (bVar.f17951e == null) {
                this.f52373j.setVisibility(8);
                this.mPkView.setVisibility(8);
            } else {
                this.f52373j.setVisibility(0);
                this.mPkView.setVisibility(0);
                this.mPkView.setData(bVar.f17951e);
            }
            f fVar = bVar.f17952f;
            if (fVar != null && !ListUtils.isEmpty(fVar.f17972b)) {
                this.k.setVisibility(0);
                this.k.setData(bVar.f17952f);
            } else {
                this.k.setVisibility(8);
            }
            this.f52369f.startLoad(bVar.f17950d, 10, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52368e = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailHeadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f52368e = 3;
        a(context);
    }
}
