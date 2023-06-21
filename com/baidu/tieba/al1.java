package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class al1 extends xk1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, xk1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final al1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-943982747, "Lcom/baidu/tieba/al1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-943982747, "Lcom/baidu/tieba/al1$b;");
                    return;
                }
            }
            a = new al1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947618915, "Lcom/baidu/tieba/al1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947618915, "Lcom/baidu/tieba/al1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public al1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static al1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (al1) invokeV.objValue;
    }

    public /* synthetic */ al1(a aVar) {
        this();
    }

    public void g(xk1 xk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xk1Var) == null) && xk1Var != null) {
            xk1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.xk1
    public boolean b(Context context, zk1 zk1Var, tk1 tk1Var) {
        InterceptResult invokeLLL;
        xk1 xk1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, zk1Var, tk1Var)) == null) {
            String b2 = zk1Var.b();
            if (a.get(b2) != null) {
                zk1Var.f(b2, a.get(b2));
            }
            String d = zk1Var.d(true);
            if (TextUtils.isEmpty(d) || (xk1Var = b.get(d)) == null) {
                return false;
            }
            return xk1Var.b(context, zk1Var, tk1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xk1
    public boolean c(Context context, zk1 zk1Var, tk1 tk1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zk1Var, tk1Var)) == null) {
            zk1Var.i = cl1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, xk1 xk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, xk1Var) == null) && !TextUtils.isEmpty(str) && xk1Var != null) {
            b.put(str, xk1Var);
        }
    }
}
