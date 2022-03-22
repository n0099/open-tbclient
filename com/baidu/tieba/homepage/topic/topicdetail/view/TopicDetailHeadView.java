package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.q1.l.b.c.b;
import c.a.p0.q1.l.b.c.f;
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
/* loaded from: classes5.dex */
public class TopicDetailHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f33533b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33534c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f33535d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f33536e;

    /* renamed from: f  reason: collision with root package name */
    public View f33537f;

    /* renamed from: g  reason: collision with root package name */
    public TopicPkView f33538g;

    /* renamed from: h  reason: collision with root package name */
    public TopicTimelineView f33539h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailHeadView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0843, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0920e0);
            this.f33533b = tbImageView;
            tbImageView.setDrawingCacheEnabled(true);
            this.f33534c = (TextView) findViewById(R.id.obfuscated_res_0x7f0920e2);
            this.f33535d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0920e4);
            this.f33536e = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0920e3);
            this.f33537f = findViewById(R.id.obfuscated_res_0x7f0920e5);
            this.f33538g = (TopicPkView) findViewById(R.id.obfuscated_res_0x7f0920e6);
            this.f33539h = (TopicTimelineView) findViewById(R.id.obfuscated_res_0x7f0920e7);
            ViewGroup.LayoutParams layoutParams = this.f33536e.getLayoutParams();
            layoutParams.height = ((n.k(getContext()) - n.f(getContext(), R.dimen.tbds88)) * 9) / 16;
            this.f33536e.setLayoutParams(layoutParams);
            this.f33536e.setRadius(n.f(context, R.dimen.tbds10));
            this.f33536e.setConrers(15);
            this.f33536e.setPlaceHolder(3);
            b();
        }
    }

    public void b() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        this.f33533b.setSkinType(skinType);
        SkinManager.setViewTextColor(this.f33534c, (int) R.color.CAM_X0101);
        this.f33536e.setSkinType(this.a);
        this.f33538g.q();
        this.f33539h.b();
    }

    public TbImageView getmBgImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33533b : (TbImageView) invokeV.objValue;
    }

    public void setData(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (bVar.f17556e == null && StringUtils.isNull(bVar.f17554c)) {
                ((LinearLayout.LayoutParams) this.f33534c.getLayoutParams()).bottomMargin = n.f(getContext(), R.dimen.tbds130);
            }
            this.f33534c.setText(bVar.f17553b);
            if (StringUtils.isNull(bVar.f17554c)) {
                this.f33535d.setVisibility(8);
                this.f33533b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f0811e3);
            } else {
                this.f33535d.setVisibility(0);
                this.f33536e.J(bVar.f17554c, 10, false);
                this.f33533b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f0811e4);
            }
            if (bVar.f17556e == null) {
                this.f33537f.setVisibility(8);
                this.f33538g.setVisibility(8);
            } else {
                this.f33537f.setVisibility(0);
                this.f33538g.setVisibility(0);
                this.f33538g.setData(bVar.f17556e);
            }
            f fVar = bVar.f17557f;
            if (fVar != null && !ListUtils.isEmpty(fVar.f17574b)) {
                this.f33539h.setVisibility(0);
                this.f33539h.setData(bVar.f17557f);
            } else {
                this.f33539h.setVisibility(8);
            }
            this.f33533b.J(bVar.f17555d, 10, false);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetailHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        a(context);
    }
}
