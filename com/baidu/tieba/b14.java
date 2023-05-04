package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class b14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b14 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<d14> a;

    public b14() {
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

    public static b14 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (b14.class) {
                    if (b == null) {
                        b = new b14();
                    }
                }
            }
            return b;
        }
        return (b14) invokeV.objValue;
    }

    public void a(d14 d14Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, d14Var) == null) && d14Var != null && !this.a.contains(d14Var)) {
            this.a.add(d14Var);
        }
    }

    public void d(d14 d14Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d14Var) == null) && this.a.contains(d14Var)) {
            this.a.remove(d14Var);
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (d14 d14Var : this.a) {
                if (i == 16) {
                    d14Var.c();
                } else if (i == 17) {
                    d14Var.b(str);
                }
                d(d14Var);
            }
        }
    }
}
