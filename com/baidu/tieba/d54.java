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
public class d54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d54 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<f54> a;

    public d54() {
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

    public static d54 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (d54.class) {
                    if (b == null) {
                        b = new d54();
                    }
                }
            }
            return b;
        }
        return (d54) invokeV.objValue;
    }

    public void a(f54 f54Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, f54Var) == null) && f54Var != null && !this.a.contains(f54Var)) {
            this.a.add(f54Var);
        }
    }

    public void d(f54 f54Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f54Var) == null) && this.a.contains(f54Var)) {
            this.a.remove(f54Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (f54 f54Var : this.a) {
                if (i == 16) {
                    f54Var.c();
                } else if (i == 17) {
                    f54Var.b(str);
                }
                d(f54Var);
            }
        }
    }
}
