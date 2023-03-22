package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class cu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<yx0> a;

    public cu0() {
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

    public void b(@NonNull yx0 yx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, yx0Var) == null) && !this.a.contains(yx0Var)) {
            u01.b(this.a, yx0Var);
        }
    }

    public void d(@NonNull yx0 yx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yx0Var) == null) {
            u01.j(this.a, yx0Var);
        }
    }

    public void c(@NonNull ru0 ru0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ru0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                yx0 yx0Var = (yx0) u01.d(this.a, i);
                if (yx0Var != null) {
                    if (i == 0) {
                        yx0Var.d(ru0Var);
                    } else {
                        yx0Var.d(ru0.a(ru0Var));
                    }
                }
            }
        }
    }
}
