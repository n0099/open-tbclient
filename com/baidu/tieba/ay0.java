package com.baidu.tieba;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ay0 implements sx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fv0 a;
    public ViewGroup b;

    public ay0(@NonNull fv0 fv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fv0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fv0Var;
    }

    public final void b(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && activity != null) {
            activity.getWindow().addFlags(128);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int M = this.a.M();
            int J = this.a.J();
            if (M <= 0 || J <= 0 || M > J) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sx0
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = this.a.n();
            this.a.Y0(true);
            Activity activity = this.a.getActivity();
            if (a()) {
                n21.a(activity, this.a.X0());
            }
            b(activity);
            x21.b(activity, this.a.v());
        }
    }

    @Override // com.baidu.tieba.sx0
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.b == null) {
            return;
        }
        this.b = this.a.n();
        this.a.Y0(false);
        n21.b(this.a.getActivity());
        x21.k(this.a.v());
        x21.j(this.a.n());
        x21.c(this.a.v(), this.b);
    }
}
