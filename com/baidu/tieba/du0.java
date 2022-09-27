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
/* loaded from: classes3.dex */
public class du0 implements au0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    @NonNull
    public br0 b;
    public ViewGroup c;

    public du0(@NonNull br0 br0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {br0Var};
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
        this.b = br0Var;
    }

    public void a(boolean z, @Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, activity) == null) {
            if (z) {
                int i = this.a;
                if (i != -1) {
                    h31.d(activity, i);
                    return;
                }
                return;
            }
            h31.f(activity);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public void b(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        dz0.b("NormalSwitchHelper", "SCREEN_ORIENTATION_PORTRAIT ");
        activity.setRequestedOrientation(1);
        activity.getWindow().clearFlags(1024);
        fz0.l(activity);
    }

    @Override // com.baidu.tieba.au0
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = this.b.n();
            this.b.Y0(true);
            Activity activity = this.b.getActivity();
            a(true, activity);
            ez0.b(activity, this.b.X0());
            ez0.c(activity, true);
            fz0.b(activity, this.b.v());
        }
    }

    @Override // com.baidu.tieba.au0
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.c == null) {
            return;
        }
        this.c = this.b.n();
        this.b.Y0(false);
        Activity activity = this.b.getActivity();
        a(false, activity);
        b(activity);
        fz0.k(this.b.v());
        fz0.j(this.b.n());
        fz0.c(this.b.v(), this.c);
    }
}
