package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class gt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList a;

    public gt0() {
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
        this.a = new ArrayList();
    }

    public void b(cx0 cx0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cx0Var) == null) && !this.a.contains(cx0Var)) {
            xz0.b(this.a, cx0Var);
        }
    }

    public void d(cx0 cx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cx0Var) == null) {
            xz0.j(this.a, cx0Var);
        }
    }

    public void c(vt0 vt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vt0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                cx0 cx0Var = (cx0) xz0.d(this.a, i);
                if (cx0Var != null) {
                    if (i == 0) {
                        cx0Var.d(vt0Var);
                    } else {
                        cx0Var.d(vt0.a(vt0Var));
                    }
                }
            }
        }
    }
}
