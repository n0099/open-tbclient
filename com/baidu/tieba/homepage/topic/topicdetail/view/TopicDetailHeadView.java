package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import d.a.c.e.p.l;
import d.a.p0.e1.k.a.c.b;
import d.a.p0.e1.k.a.c.f;
/* loaded from: classes4.dex */
public class TopicDetailHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16917e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16918f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16919g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16920h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f16921i;
    public View j;
    public TopicPkView k;
    public TopicTimelineView l;

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
        this.f16917e = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.topic_detail_head_view_layout, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.topic_detail_head_bg);
            this.f16918f = tbImageView;
            tbImageView.setDrawingCacheEnabled(true);
            this.f16919g = (TextView) findViewById(R.id.topic_detail_head_des);
            this.f16920h = (LinearLayout) findViewById(R.id.topic_detail_head_img_layout);
            this.f16921i = (TbImageView) findViewById(R.id.topic_detail_head_img);
            this.j = findViewById(R.id.topic_detail_head_img_placeholder);
            this.k = (TopicPkView) findViewById(R.id.topic_detail_head_pk);
            this.l = (TopicTimelineView) findViewById(R.id.topic_detail_head_timeline);
            ViewGroup.LayoutParams layoutParams = this.f16921i.getLayoutParams();
            layoutParams.height = ((l.k(getContext()) - l.g(getContext(), R.dimen.tbds88)) * 9) / 16;
            this.f16921i.setLayoutParams(layoutParams);
            this.f16921i.setRadius(l.g(context, R.dimen.tbds10));
            this.f16921i.setConrers(15);
            this.f16921i.setPlaceHolder(3);
            b();
        }
    }

    public void b() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f16917e) {
            return;
        }
        this.f16917e = skinType;
        this.f16918f.setIsNight(skinType == 1);
        SkinManager.setViewTextColor(this.f16919g, R.color.CAM_X0101);
        this.f16921i.setIsNight(this.f16917e == 1);
        this.k.q();
        this.l.b();
    }

    public TbImageView getmBgImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16918f : (TbImageView) invokeV.objValue;
    }

    public void setData(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (bVar.f55769e == null && StringUtils.isNull(bVar.f55767c)) {
                ((LinearLayout.LayoutParams) this.f16919g.getLayoutParams()).bottomMargin = l.g(getContext(), R.dimen.tbds130);
            }
            this.f16919g.setText(bVar.f55766b);
            if (StringUtils.isNull(bVar.f55767c)) {
                this.f16920h.setVisibility(8);
                this.f16918f.setDefaultBgResource(R.drawable.topic_detail_default_bg);
            } else {
                this.f16920h.setVisibility(0);
                this.f16921i.M(bVar.f55767c, 10, false);
                this.f16918f.setDefaultBgResource(R.drawable.topic_detail_img_default_bg);
            }
            if (bVar.f55769e == null) {
                this.j.setVisibility(8);
                this.k.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.k.setData(bVar.f55769e);
            }
            f fVar = bVar.f55770f;
            if (fVar != null && !ListUtils.isEmpty(fVar.f55788b)) {
                this.l.setVisibility(0);
                this.l.setData(bVar.f55770f);
            } else {
                this.l.setVisibility(8);
            }
            this.f16918f.M(bVar.f55768d, 10, false);
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
        this.f16917e = 3;
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
        this.f16917e = 3;
        a(context);
    }
}
