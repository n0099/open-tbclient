package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bx0 implements yw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    @NonNull
    public zt0 b;
    public ViewGroup c;

    public bx0(@NonNull zt0 zt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zt0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = zt0Var;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public void b(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && activity != null) {
            b21.b("NormalSwitchHelper", "SCREEN_ORIENTATION_PORTRAIT ");
            activity.setRequestedOrientation(1);
            activity.getWindow().clearFlags(1024);
            d21.l(activity);
        }
    }

    public void a(boolean z, @Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, activity) == null) {
            if (z) {
                int i = this.a;
                if (i != -1) {
                    b71.d(activity, i);
                    return;
                }
                return;
            }
            b71.f(activity);
        }
    }

    @Override // com.baidu.tieba.yw0
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = this.b.n();
            this.b.Y0(true);
            Activity activity = this.b.getActivity();
            a(true, activity);
            c21.b(activity, this.b.X0());
            c21.c(activity, true);
            d21.b(activity, this.b.v());
        }
    }

    @Override // com.baidu.tieba.yw0
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.c == null) {
            return;
        }
        this.c = this.b.n();
        this.b.Y0(false);
        Activity activity = this.b.getActivity();
        a(false, activity);
        b(activity);
        d21.k(this.b.v());
        d21.j(this.b.n());
        d21.c(this.b.v(), this.c);
    }
}
