package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class hw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<d01> a;

    public hw0() {
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

    public void b(@NonNull d01 d01Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, d01Var) == null) && !this.a.contains(d01Var)) {
            h31.b(this.a, d01Var);
        }
    }

    public void d(@NonNull d01 d01Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d01Var) == null) {
            h31.j(this.a, d01Var);
        }
    }

    public void c(@NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ww0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                d01 d01Var = (d01) h31.d(this.a, i);
                if (d01Var != null) {
                    if (i == 0) {
                        d01Var.d(ww0Var);
                    } else {
                        d01Var.d(ww0.a(ww0Var));
                    }
                }
            }
        }
    }
}
