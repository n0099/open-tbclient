package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a55 extends TBSpecificationButtonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean v;
    public boolean w;

    public a55() {
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
        this.b = R.color.CAM_X0302;
        this.v = true;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = R.color.CAM_X0101;
            this.d = R.color.CAM_X0904;
            this.v = false;
            this.r = true;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            return x(f);
        }
        return (Drawable) invokeF.objValue;
    }

    public void u(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.b = i;
            this.v = true;
            this.r = true;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void v(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b = i;
            this.d = R.color.CAM_X0903;
            this.v = false;
            this.r = true;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void w(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.b = i;
            this.d = R.color.CAM_X0211;
            this.v = false;
            this.r = true;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.r = z;
        }
    }

    public void r(@ColorInt int i, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            this.d = i;
            this.b = i2;
            this.w = true;
            this.r = false;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void s(@ColorRes int i, @ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.d = i;
            this.b = i2;
            this.v = false;
            this.r = true;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public final Drawable x(float f) {
        InterceptResult invokeF;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            if (this.w) {
                gradientDrawable.setColor(this.d);
            } else if (this.v) {
                if (this.r) {
                    i = SkinManager.getColor(this.s, this.b);
                } else {
                    i = this.b;
                }
                gradientDrawable.setColor(vca.a(i, 0.08f));
            } else {
                gradientDrawable.setColor(SkinManager.getColor(this.s, this.d));
            }
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }
}
