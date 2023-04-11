package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class fc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final View b;
    public String c;
    public xb1 d;
    public wb1 e;

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public fc1(int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.a = i;
        this.b = view2;
    }

    public static boolean c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        gp0 gp0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adBaseModel)) == null) {
            if (d(adBaseModel) && adBaseModel.h.a == AdOperator.TYPE.DOWNLOAD && (gp0Var = adBaseModel.l) != null && gp0Var.e) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adBaseModel)) == null) {
            if (adBaseModel != null && adBaseModel.h != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final <T> T a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return (T) this.b.findViewById(i);
        }
        return (T) invokeI.objValue;
    }

    public void f(xb1 xb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xb1Var) == null) {
            this.d = xb1Var;
        }
    }

    public final <T> void g(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
            this.b.setTag(t);
        }
    }

    public void h(wb1 wb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, wb1Var) == null) {
            this.e = wb1Var;
        }
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b.setVisibility(i);
        }
    }

    public final <T> T b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (T) this.b.getTag();
        }
        return (T) invokeV.objValue;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b.getContext();
        }
        return (Context) invokeV.objValue;
    }

    public final Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public void j() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (view2 = this.b) != null && view2.getLayoutParams() != null) {
            this.b.getLayoutParams().height = -2;
            View view3 = this.b;
            view3.setLayoutParams(view3.getLayoutParams());
        }
    }

    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, adBaseModel, nadExpressNaBaseView) == null) {
            g(adBaseModel);
        }
    }
}
