package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g65 extends TBSpecificationButtonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean v;

    public g65() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.b = R.color.CAM_X0101;
        this.d = R.color.CAM_X0302;
        this.v = false;
        this.o = this.p;
        this.n = this.m;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            return t(f);
        }
        return (Drawable) invokeF.objValue;
    }

    public void r(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b = i;
            this.d = R.color.CAM_X0904;
            this.v = false;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void s(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b = R.color.CAM_X0101;
            this.d = i;
            this.v = false;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public final Drawable t(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) {
            if (this.v) {
                return u(f);
            }
            return v(f);
        }
        return (Drawable) invokeF.objValue;
    }

    public final Drawable v(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(SkinManager.getColor(this.s, this.d));
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    @Deprecated
    public void j(int i, int i2, TBSpecificationButtonConfig.IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, iconType) == null) {
            w(i, iconType);
        }
    }

    public final Drawable u(float f) {
        InterceptResult invokeF;
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
            int color = SkinManager.getColor(this.s, this.d);
            int[] iArr = {uua.c(color), color};
            if (Build.VERSION.SDK_INT >= 16) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setOrientation(this.t);
                gradientDrawable.setColors(iArr);
            } else {
                gradientDrawable = new GradientDrawable(this.t, iArr);
            }
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }

    public void w(@DrawableRes int i, TBSpecificationButtonConfig.IconType iconType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, iconType) == null) {
            this.e[0] = i;
            this.f = iconType;
        }
    }
}
