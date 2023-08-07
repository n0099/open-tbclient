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
public class c44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c44 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<e44> a;

    public c44() {
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

    public static c44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (c44.class) {
                    if (b == null) {
                        b = new c44();
                    }
                }
            }
            return b;
        }
        return (c44) invokeV.objValue;
    }

    public void a(e44 e44Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, e44Var) == null) && e44Var != null && !this.a.contains(e44Var)) {
            this.a.add(e44Var);
        }
    }

    public void d(e44 e44Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e44Var) == null) && this.a.contains(e44Var)) {
            this.a.remove(e44Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (e44 e44Var : this.a) {
                if (i == 16) {
                    e44Var.c();
                } else if (i == 17) {
                    e44Var.b(str);
                }
                d(e44Var);
            }
        }
    }
}
