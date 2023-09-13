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
/* loaded from: classes6.dex */
public class ik1 extends fk1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, fk1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ik1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-715873060, "Lcom/baidu/tieba/ik1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-715873060, "Lcom/baidu/tieba/ik1$b;");
                    return;
                }
            }
            a = new ik1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947856282, "Lcom/baidu/tieba/ik1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947856282, "Lcom/baidu/tieba/ik1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public ik1() {
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

    public static ik1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (ik1) invokeV.objValue;
    }

    public /* synthetic */ ik1(a aVar) {
        this();
    }

    public void g(fk1 fk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, fk1Var) == null) && fk1Var != null) {
            fk1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.fk1
    public boolean b(Context context, hk1 hk1Var, bk1 bk1Var) {
        InterceptResult invokeLLL;
        fk1 fk1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, hk1Var, bk1Var)) == null) {
            String b2 = hk1Var.b();
            if (a.get(b2) != null) {
                hk1Var.f(b2, a.get(b2));
            }
            String d = hk1Var.d(true);
            if (TextUtils.isEmpty(d) || (fk1Var = b.get(d)) == null) {
                return false;
            }
            return fk1Var.b(context, hk1Var, bk1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fk1
    public boolean c(Context context, hk1 hk1Var, bk1 bk1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hk1Var, bk1Var)) == null) {
            hk1Var.i = kk1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, fk1 fk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, fk1Var) == null) && !TextUtils.isEmpty(str) && fk1Var != null) {
            b.put(str, fk1Var);
        }
    }
}
