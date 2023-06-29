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
public class dl1 extends al1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, al1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final dl1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-858095294, "Lcom/baidu/tieba/dl1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-858095294, "Lcom/baidu/tieba/dl1$b;");
                    return;
                }
            }
            a = new dl1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947708288, "Lcom/baidu/tieba/dl1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947708288, "Lcom/baidu/tieba/dl1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public dl1() {
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

    public static dl1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (dl1) invokeV.objValue;
    }

    public /* synthetic */ dl1(a aVar) {
        this();
    }

    public void g(al1 al1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, al1Var) == null) && al1Var != null) {
            al1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.al1
    public boolean b(Context context, cl1 cl1Var, wk1 wk1Var) {
        InterceptResult invokeLLL;
        al1 al1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, cl1Var, wk1Var)) == null) {
            String b2 = cl1Var.b();
            if (a.get(b2) != null) {
                cl1Var.f(b2, a.get(b2));
            }
            String d = cl1Var.d(true);
            if (TextUtils.isEmpty(d) || (al1Var = b.get(d)) == null) {
                return false;
            }
            return al1Var.b(context, cl1Var, wk1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.al1
    public boolean c(Context context, cl1 cl1Var, wk1 wk1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cl1Var, wk1Var)) == null) {
            cl1Var.i = fl1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, al1 al1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, al1Var) == null) && !TextUtils.isEmpty(str) && al1Var != null) {
            b.put(str, al1Var);
        }
    }
}
