package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class g54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g54 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<i54> a;

    public g54() {
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
        this.a = new CopyOnWriteArrayList();
    }

    public static g54 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (g54.class) {
                    if (b == null) {
                        b = new g54();
                    }
                }
            }
            return b;
        }
        return (g54) invokeV.objValue;
    }

    public void a(i54 i54Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, i54Var) == null) && i54Var != null && !this.a.contains(i54Var)) {
            this.a.add(i54Var);
        }
    }

    public void d(i54 i54Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i54Var) == null) && this.a.contains(i54Var)) {
            this.a.remove(i54Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (i54 i54Var : this.a) {
                if (i == 16) {
                    i54Var.c();
                } else if (i == 17) {
                    i54Var.b(str);
                }
                d(i54Var);
            }
        }
    }
}
