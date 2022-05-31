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
import com.repackage.iz6;
import com.repackage.li;
import com.repackage.mz6;
/* loaded from: classes3.dex */
public class TopicDetailHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbImageView b;
    public TextView c;
    public LinearLayout d;
    public TbImageView e;
    public View f;
    public TopicPkView g;
    public TopicTimelineView h;

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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0826, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0920c7);
            this.b = tbImageView;
            tbImageView.setDrawingCacheEnabled(true);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0920c9);
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0920cb);
            this.e = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0920ca);
            this.f = findViewById(R.id.obfuscated_res_0x7f0920cc);
            this.g = (TopicPkView) findViewById(R.id.obfuscated_res_0x7f0920cd);
            this.h = (TopicTimelineView) findViewById(R.id.obfuscated_res_0x7f0920ce);
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            layoutParams.height = ((li.k(getContext()) - li.f(getContext(), R.dimen.tbds88)) * 9) / 16;
            this.e.setLayoutParams(layoutParams);
            this.e.setRadius(li.f(context, R.dimen.tbds10));
            this.e.setConrers(15);
            this.e.setPlaceHolder(3);
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
        this.b.setSkinType(skinType);
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
        this.e.setSkinType(this.a);
        this.g.r();
        this.h.b();
    }

    public TbImageView getmBgImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (TbImageView) invokeV.objValue;
    }

    public void setData(iz6 iz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iz6Var) == null) {
            if (iz6Var == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            if (iz6Var.e == null && StringUtils.isNull(iz6Var.c)) {
                ((LinearLayout.LayoutParams) this.c.getLayoutParams()).bottomMargin = li.f(getContext(), R.dimen.tbds130);
            }
            this.c.setText(iz6Var.b);
            if (StringUtils.isNull(iz6Var.c)) {
                this.d.setVisibility(8);
                this.b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081216);
            } else {
                this.d.setVisibility(0);
                this.e.K(iz6Var.c, 10, false);
                this.b.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081217);
            }
            if (iz6Var.e == null) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.g.setData(iz6Var.e);
            }
            mz6 mz6Var = iz6Var.f;
            if (mz6Var != null && !ListUtils.isEmpty(mz6Var.b)) {
                this.h.setVisibility(0);
                this.h.setData(iz6Var.f);
            } else {
                this.h.setVisibility(8);
            }
            this.b.K(iz6Var.d, 10, false);
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
