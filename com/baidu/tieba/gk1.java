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
/* loaded from: classes4.dex */
public class gk1 extends dk1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, dk1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final gk1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-773131362, "Lcom/baidu/tieba/gk1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-773131362, "Lcom/baidu/tieba/gk1$b;");
                    return;
                }
            }
            a = new gk1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947796700, "Lcom/baidu/tieba/gk1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947796700, "Lcom/baidu/tieba/gk1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public gk1() {
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

    public static gk1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (gk1) invokeV.objValue;
    }

    public /* synthetic */ gk1(a aVar) {
        this();
    }

    public void g(dk1 dk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, dk1Var) == null) && dk1Var != null) {
            dk1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.dk1
    public boolean b(Context context, fk1 fk1Var, zj1 zj1Var) {
        InterceptResult invokeLLL;
        dk1 dk1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, fk1Var, zj1Var)) == null) {
            String b2 = fk1Var.b();
            if (a.get(b2) != null) {
                fk1Var.f(b2, a.get(b2));
            }
            String d = fk1Var.d(true);
            if (TextUtils.isEmpty(d) || (dk1Var = b.get(d)) == null) {
                return false;
            }
            return dk1Var.b(context, fk1Var, zj1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dk1
    public boolean c(Context context, fk1 fk1Var, zj1 zj1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fk1Var, zj1Var)) == null) {
            fk1Var.i = ik1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, dk1 dk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, dk1Var) == null) && !TextUtils.isEmpty(str) && dk1Var != null) {
            b.put(str, dk1Var);
        }
    }
}
