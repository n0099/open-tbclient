package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class ft0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<bx0> a;

    public ft0() {
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

    public void b(@NonNull bx0 bx0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bx0Var) == null) || this.a.contains(bx0Var)) {
            return;
        }
        wz0.b(this.a, bx0Var);
    }

    public void c(@NonNull ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ut0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                bx0 bx0Var = (bx0) wz0.d(this.a, i);
                if (bx0Var != null) {
                    if (i == 0) {
                        bx0Var.d(ut0Var);
                    } else {
                        bx0Var.d(ut0.a(ut0Var));
                    }
                }
            }
        }
    }

    public void d(@NonNull bx0 bx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bx0Var) == null) {
            wz0.j(this.a, bx0Var);
        }
    }
}
