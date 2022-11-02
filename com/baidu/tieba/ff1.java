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
public class ff1 extends cf1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, cf1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ff1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-806378118, "Lcom/baidu/tieba/ff1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-806378118, "Lcom/baidu/tieba/ff1$b;");
                    return;
                }
            }
            a = new ff1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947762104, "Lcom/baidu/tieba/ff1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947762104, "Lcom/baidu/tieba/ff1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public ff1() {
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

    public static ff1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (ff1) invokeV.objValue;
    }

    public /* synthetic */ ff1(a aVar) {
        this();
    }

    public void g(cf1 cf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, cf1Var) == null) && cf1Var != null) {
            cf1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.cf1
    public boolean b(Context context, ef1 ef1Var, ye1 ye1Var) {
        InterceptResult invokeLLL;
        cf1 cf1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, ef1Var, ye1Var)) == null) {
            String b2 = ef1Var.b();
            if (a.get(b2) != null) {
                ef1Var.f(b2, a.get(b2));
            }
            String d = ef1Var.d(true);
            if (TextUtils.isEmpty(d) || (cf1Var = b.get(d)) == null) {
                return false;
            }
            return cf1Var.b(context, ef1Var, ye1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.cf1
    public boolean c(Context context, ef1 ef1Var, ye1 ye1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ef1Var, ye1Var)) == null) {
            ef1Var.i = hf1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, cf1 cf1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cf1Var) == null) && !TextUtils.isEmpty(str) && cf1Var != null) {
            b.put(str, cf1Var);
        }
    }
}
