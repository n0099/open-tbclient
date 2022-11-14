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
public class gf1 extends df1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public static HashMap<String, df1> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final gf1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-777748967, "Lcom/baidu/tieba/gf1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-777748967, "Lcom/baidu/tieba/gf1$b;");
                    return;
                }
            }
            a = new gf1(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947791895, "Lcom/baidu/tieba/gf1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947791895, "Lcom/baidu/tieba/gf1;");
                return;
            }
        }
        a = new HashMap<>();
        b = new HashMap<>();
    }

    public gf1() {
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

    public static gf1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (gf1) invokeV.objValue;
    }

    public /* synthetic */ gf1(a aVar) {
        this();
    }

    public void g(df1 df1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, df1Var) == null) && df1Var != null) {
            df1Var.a(a);
        }
    }

    @Override // com.baidu.tieba.df1
    public boolean b(Context context, ff1 ff1Var, ze1 ze1Var) {
        InterceptResult invokeLLL;
        df1 df1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, ff1Var, ze1Var)) == null) {
            String b2 = ff1Var.b();
            if (a.get(b2) != null) {
                ff1Var.f(b2, a.get(b2));
            }
            String d = ff1Var.d(true);
            if (TextUtils.isEmpty(d) || (df1Var = b.get(d)) == null) {
                return false;
            }
            return df1Var.b(context, ff1Var, ze1Var);
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.df1
    public boolean c(Context context, ff1 ff1Var, ze1 ze1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ff1Var, ze1Var)) == null) {
            ff1Var.i = if1.h(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void f(String str, df1 df1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, df1Var) == null) && !TextUtils.isEmpty(str) && df1Var != null) {
            b.put(str, df1Var);
        }
    }
}
