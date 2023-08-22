package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fa5 extends TBSpecificationButtonConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean v;
    public int w;
    public int x;

    public fa5() {
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
        this.w = R.dimen.tbds1;
        this.x = R.string.A_X07;
        this.b = R.color.CAM_X0302;
        this.v = false;
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig
    public Drawable a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            return v(f);
        }
        return (Drawable) invokeF.objValue;
    }

    public void r(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b = i;
            this.v = false;
            this.r = true;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void s(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b = i;
            this.v = false;
            this.r = false;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void t(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b = i;
            this.c = R.color.CAM_X0902;
            this.v = true;
            this.r = true;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = R.color.CAM_X0101;
            this.v = false;
            this.r = true;
            TBSpecificationButtonConfig.a aVar = this.u;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public final Drawable v(float f) {
        InterceptResult invokeF;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            if (this.v) {
                gradientDrawable.setStroke(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), this.w), SkinManager.getColor(this.s, this.c));
            } else {
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), this.w);
                if (this.r) {
                    i = SkinManager.getColor(this.s, this.b);
                } else {
                    i = this.b;
                }
                gradientDrawable.setStroke(dimens, gea.a(i, c75.b(this.x)));
            }
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(f);
            return gradientDrawable;
        }
        return (Drawable) invokeF.objValue;
    }
}
