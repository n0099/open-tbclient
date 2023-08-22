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
public class ek1 extends bk1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, bk1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ek1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-830389664, "Lcom/baidu/tieba/ek1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-830389664, "Lcom/baidu/tieba/ek1$b;");
                    return;
                }
            }
            a = new ek1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947737118, "Lcom/baidu/tieba/ek1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947737118, "Lcom/baidu/tieba/ek1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public ek1() {
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

    public static ek1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (ek1) invokeV.objValue;
    }

    public /* synthetic */ ek1(a aVar) {
        this();
    }

    public void g(bk1 bk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bk1Var) == null) && bk1Var != null) {
            bk1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.bk1
    public boolean b(Context context, dk1 dk1Var, xj1 xj1Var) {
        InterceptResult invokeLLL;
        bk1 bk1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, dk1Var, xj1Var)) == null) {
            String b2 = dk1Var.b();
            if (a.get(b2) != null) {
                dk1Var.f(b2, a.get(b2));
            }
            String d = dk1Var.d(true);
            if (TextUtils.isEmpty(d) || (bk1Var = b.get(d)) == null) {
                return false;
            }
            return bk1Var.b(context, dk1Var, xj1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bk1
    public boolean c(Context context, dk1 dk1Var, xj1 xj1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, dk1Var, xj1Var)) == null) {
            dk1Var.i = gk1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, bk1 bk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bk1Var) == null) && !TextUtils.isEmpty(str) && bk1Var != null) {
            b.put(str, bk1Var);
        }
    }
}
