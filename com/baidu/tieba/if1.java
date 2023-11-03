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
public class if1 extends ff1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, ff1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final if1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-720490665, "Lcom/baidu/tieba/if1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-720490665, "Lcom/baidu/tieba/if1$b;");
                    return;
                }
            }
            a = new if1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947851477, "Lcom/baidu/tieba/if1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947851477, "Lcom/baidu/tieba/if1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public if1() {
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

    public static if1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (if1) invokeV.objValue;
    }

    public /* synthetic */ if1(a aVar) {
        this();
    }

    public void g(ff1 ff1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ff1Var) == null) && ff1Var != null) {
            ff1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.ff1
    public boolean b(Context context, hf1 hf1Var, bf1 bf1Var) {
        InterceptResult invokeLLL;
        ff1 ff1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, hf1Var, bf1Var)) == null) {
            String b2 = hf1Var.b();
            if (a.get(b2) != null) {
                hf1Var.f(b2, a.get(b2));
            }
            String d = hf1Var.d(true);
            if (TextUtils.isEmpty(d) || (ff1Var = b.get(d)) == null) {
                return false;
            }
            return ff1Var.b(context, hf1Var, bf1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ff1
    public boolean c(Context context, hf1 hf1Var, bf1 bf1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hf1Var, bf1Var)) == null) {
            hf1Var.i = kf1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, ff1 ff1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ff1Var) == null) && !TextUtils.isEmpty(str) && ff1Var != null) {
            b.put(str, ff1Var);
        }
    }
}
