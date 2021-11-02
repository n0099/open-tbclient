package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.r0.h1.k.a.c.b;
import b.a.r0.h1.k.a.c.f;
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
/* loaded from: classes9.dex */
public class TopicDetailHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49844e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f49845f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49846g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f49847h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f49848i;
    public View j;
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
        this.f49844e = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.topic_detail_head_view_layout, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.topic_detail_head_bg);
            this.f49845f = tbImageView;
            tbImageView.setDrawingCacheEnabled(true);
            this.f49846g = (TextView) findViewById(R.id.topic_detail_head_des);
            this.f49847h = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
            this.f49848i = (TbImageView) findViewById(R.id.topic_detail_head_img);
            this.j = findViewById(R.id.topic_detail_head_img_placeholder);
            this.mPkView = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
            this.k = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
            ViewGroup.LayoutParams layoutParams = this.f49848i.getLayoutParams();
            layoutParams.height = ((l.k(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
            this.f49848i.setLayoutParams(layoutParams);
            this.f49848i.setRadius(l.g(context, R.dimen.tbds10));
            this.f49848i.setConrers(15);
            this.f49848i.setPlaceHolder(3);
            onChangeSkinType();
        }
    }

    public TbImageView getmBgImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49845f : (TbImageView) invokeV.objValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f49844e) {
            return;
        }
        this.f49844e = skinType;
        this.f49845f.setSkinType(skinType);
        SkinManager.setViewTextColor(this.f49846g, R.color.CAM_X0101);
        this.f49848i.setSkinType(this.f49844e);
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
            if (bVar.f17594e == null && StringUtils.isNull(bVar.f17592c)) {
                ((LinearLayout.LayoutParams) this.f49846g.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
            }
            this.f49846g.setText(bVar.f17591b);
            if (StringUtils.isNull(bVar.f17592c)) {
                this.f49847h.setVisibility(8);
                this.f49845f.setDefaultBgResource(R.drawable.topic_detail_default_bg);
            } else {
                this.f49847h.setVisibility(0);
                this.f49848i.startLoad(bVar.f17592c, 10, false);
                this.f49845f.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
            }
            if (bVar.f17594e == null) {
                this.j.setVisibility(8);
                this.mPkView.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.mPkView.setVisibility(0);
                this.mPkView.setData(bVar.f17594e);
            }
            f fVar = bVar.f17595f;
            if (fVar != null && !ListUtils.isEmpty(fVar.f17613b)) {
                this.k.setVisibility(0);
                this.k.setData(bVar.f17595f);
            } else {
                this.k.setVisibility(8);
            }
            this.f49845f.startLoad(bVar.f17593d, 10, false);
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
        this.f49844e = 3;
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
        this.f49844e = 3;
        a(context);
    }
}
