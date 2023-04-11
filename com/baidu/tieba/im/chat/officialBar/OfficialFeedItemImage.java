package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b08;
import com.baidu.tieba.ii;
import com.baidu.tieba.qz7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbImageView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public View f;
    public View g;
    public View h;
    public boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = z;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setRadius(ii.g(this.a, R.dimen.tbds31));
            this.b.setConrers(3);
            ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
            layoutParams.height = ii.g(this.a, R.dimen.tbds579);
            this.g.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams2.leftMargin = ii.g(this.a, R.dimen.tbds27);
            this.h.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams3.leftMargin = ii.g(this.a, R.dimen.tbds30);
            layoutParams3.bottomMargin = ii.g(this.a, R.dimen.tbds27);
            this.e.setLayoutParams(layoutParams3);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06dd, (ViewGroup) this, true);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091699);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f0916a0);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09169f);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0916a5);
            this.f = findViewById(R.id.black_mask);
            this.b.setConrers(15);
            this.b.setRadius(ii.g(this.a, R.dimen.tbds21));
            this.g = findViewById(R.id.obfuscated_res_0x7f090ff3);
            this.h = findViewById(R.id.obfuscated_res_0x7f091708);
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.obfuscated_res_0x7f080982, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            DrawableSelector gradientLinear = TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606);
            if (this.i) {
                gradientLinear.into(this.f);
            } else {
                gradientLinear.blRadius(ii.g(getContext(), R.dimen.tbds21)).brRadius(ii.g(getContext(), R.dimen.tbds21)).into(this.f);
            }
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i > 0) {
                this.d.setText(this.a.getString(R.string.person_view_num, StringHelper.numberUniformFormatExtraWithRound(i)));
                this.d.setVisibility(0);
                this.c.setVisibility(0);
                return;
            }
            this.d.setVisibility(8);
            this.c.setVisibility(8);
        }
    }

    public void setData(b08.a aVar, int i, qz7 qz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, aVar, i, qz7Var) == null) {
            this.b.N(aVar.c, 10, false);
            this.e.setText(aVar.a);
            if (qz7Var != null) {
                i = qz7Var.i();
            }
            d(i);
        }
    }
}
