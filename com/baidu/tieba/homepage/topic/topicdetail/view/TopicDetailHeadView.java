package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.r0.n1.k.a.c.b;
import c.a.r0.n1.k.a.c.f;
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
/* loaded from: classes10.dex */
public class TopicDetailHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f45490e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f45491f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45492g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f45493h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f45494i;

    /* renamed from: j  reason: collision with root package name */
    public View f45495j;

    /* renamed from: k  reason: collision with root package name */
    public TopicTimelineView f45496k;
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
        this.f45490e = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.topic_detail_head_view_layout, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.topic_detail_head_bg);
            this.f45491f = tbImageView;
            tbImageView.setDrawingCacheEnabled(true);
            this.f45492g = (TextView) findViewById(R.id.topic_detail_head_des);
            this.f45493h = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
            this.f45494i = (TbImageView) findViewById(R.id.topic_detail_head_img);
            this.f45495j = findViewById(R.id.topic_detail_head_img_placeholder);
            this.mPkView = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
            this.f45496k = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
            ViewGroup.LayoutParams layoutParams = this.f45494i.getLayoutParams();
            layoutParams.height = ((l.k(getContext()) - l.f(getContext(), R.dimen.tbds88)) * 9) / 16;
            this.f45494i.setLayoutParams(layoutParams);
            this.f45494i.setRadius(l.f(context, R.dimen.tbds10));
            this.f45494i.setConrers(15);
            this.f45494i.setPlaceHolder(3);
            onChangeSkinType();
        }
    }

    public TbImageView getmBgImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45491f : (TbImageView) invokeV.objValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f45490e) {
            return;
        }
        this.f45490e = skinType;
        this.f45491f.setSkinType(skinType);
        SkinManager.setViewTextColor(this.f45492g, R.color.CAM_X0101);
        this.f45494i.setSkinType(this.f45490e);
        this.mPkView.onChangeSkinType();
        this.f45496k.onChangeSkinType();
    }

    public void setData(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (bVar.f20660e == null && StringUtils.isNull(bVar.f20658c)) {
                ((LinearLayout.LayoutParams) this.f45492g.getLayoutParams()).bottomMargin = l.f(getContext(), R.dimen.tbds130);
            }
            this.f45492g.setText(bVar.f20657b);
            if (StringUtils.isNull(bVar.f20658c)) {
                this.f45493h.setVisibility(8);
                this.f45491f.setDefaultBgResource(R.drawable.topic_detail_default_bg);
            } else {
                this.f45493h.setVisibility(0);
                this.f45494i.startLoad(bVar.f20658c, 10, false);
                this.f45491f.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
            }
            if (bVar.f20660e == null) {
                this.f45495j.setVisibility(8);
                this.mPkView.setVisibility(8);
            } else {
                this.f45495j.setVisibility(0);
                this.mPkView.setVisibility(0);
                this.mPkView.setData(bVar.f20660e);
            }
            f fVar = bVar.f20661f;
            if (fVar != null && !ListUtils.isEmpty(fVar.f20680b)) {
                this.f45496k.setVisibility(0);
                this.f45496k.setData(bVar.f20661f);
            } else {
                this.f45496k.setVisibility(8);
            }
            this.f45491f.startLoad(bVar.f20659d, 10, false);
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
        this.f45490e = 3;
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
        this.f45490e = 3;
        a(context);
    }
}
