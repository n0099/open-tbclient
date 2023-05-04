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
/* loaded from: classes3.dex */
public class aj1 extends xi1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, xi1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final aj1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-945829789, "Lcom/baidu/tieba/aj1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-945829789, "Lcom/baidu/tieba/aj1$b;");
                    return;
                }
            }
            a = new aj1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947616993, "Lcom/baidu/tieba/aj1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947616993, "Lcom/baidu/tieba/aj1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public aj1() {
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

    public static aj1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (aj1) invokeV.objValue;
    }

    public /* synthetic */ aj1(a aVar) {
        this();
    }

    public void g(xi1 xi1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xi1Var) == null) && xi1Var != null) {
            xi1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.xi1
    public boolean b(Context context, zi1 zi1Var, ti1 ti1Var) {
        InterceptResult invokeLLL;
        xi1 xi1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, zi1Var, ti1Var)) == null) {
            String b2 = zi1Var.b();
            if (a.get(b2) != null) {
                zi1Var.f(b2, a.get(b2));
            }
            String d = zi1Var.d(true);
            if (TextUtils.isEmpty(d) || (xi1Var = b.get(d)) == null) {
                return false;
            }
            return xi1Var.b(context, zi1Var, ti1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.xi1
    public boolean c(Context context, zi1 zi1Var, ti1 ti1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zi1Var, ti1Var)) == null) {
            zi1Var.i = cj1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, xi1 xi1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, xi1Var) == null) && !TextUtils.isEmpty(str) && xi1Var != null) {
            b.put(str, xi1Var);
        }
    }
}
