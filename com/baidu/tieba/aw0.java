package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class aw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<wz0> a;

    public aw0() {
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
        this.a = new ArrayList<>();
    }

    public void b(@NonNull wz0 wz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, wz0Var) == null) && !this.a.contains(wz0Var)) {
            a31.b(this.a, wz0Var);
        }
    }

    public void d(@NonNull wz0 wz0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wz0Var) == null) {
            a31.j(this.a, wz0Var);
        }
    }

    public void c(@NonNull pw0 pw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pw0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                wz0 wz0Var = (wz0) a31.d(this.a, i);
                if (wz0Var != null) {
                    if (i == 0) {
                        wz0Var.d(pw0Var);
                    } else {
                        wz0Var.d(pw0.a(pw0Var));
                    }
                }
            }
        }
    }
}
