package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class dw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<zz0> a;

    public dw0() {
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

    public void b(@NonNull zz0 zz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, zz0Var) == null) && !this.a.contains(zz0Var)) {
            d31.b(this.a, zz0Var);
        }
    }

    public void d(@NonNull zz0 zz0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zz0Var) == null) {
            d31.j(this.a, zz0Var);
        }
    }

    public void c(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sw0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                zz0 zz0Var = (zz0) d31.d(this.a, i);
                if (zz0Var != null) {
                    if (i == 0) {
                        zz0Var.d(sw0Var);
                    } else {
                        zz0Var.d(sw0.a(sw0Var));
                    }
                }
            }
        }
    }
}
