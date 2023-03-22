package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b0 {
    public static /* synthetic */ Interceptable $ic;
    public static g7<String, b0> e;
    public static int f;
    public static final b g;
    public static final n6 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final n6 a;
    public final n6 b;
    public final n6 c;
    public final int d;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this == obj : invokeL.booleanValue;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public n6 a;
        public n6 b;
        public n6 c;

        public b() {
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
            this.a = b0.h;
            this.b = b0.h;
            this.c = b0.h;
        }

        public b0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (b0) invokeV.objValue;
            }
            String f = b0.f(this.a, this.b, this.c);
            b0 b0Var = (b0) b0.e.d(f, null);
            if (b0Var == null) {
                b0 b0Var2 = new b0(this.a, this.b, this.c, null);
                b0.e.i(f, b0Var2);
                return b0Var2;
            }
            return b0Var;
        }

        @SafeVarargs
        public final b a(Class<? extends v>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, clsArr)) == null) {
                this.a = w.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        @SafeVarargs
        public final b c(Class<? extends v>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clsArr)) == null) {
                this.b = w.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.a = b0.h;
                this.b = b0.h;
                this.c = b0.h;
                return this;
            }
            return (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448298847, "Lcom/baidu/tieba/b0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448298847, "Lcom/baidu/tieba/b0;");
                return;
            }
        }
        e = new g7<>();
        f = 0;
        g = new b();
        h = new n6();
    }

    public b0(n6 n6Var, n6 n6Var2, n6 n6Var3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n6Var, n6Var2, n6Var3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = n6Var;
        this.b = n6Var2;
        this.c = n6Var3;
        int i3 = f;
        f = i3 + 1;
        this.d = i3;
    }

    public /* synthetic */ b0(n6 n6Var, n6 n6Var2, n6 n6Var3, a aVar) {
        this(n6Var, n6Var2, n6Var3);
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    @SafeVarargs
    public static final b d(Class<? extends v>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, clsArr)) == null) {
            b bVar = g;
            bVar.d();
            bVar.a(clsArr);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    @SafeVarargs
    public static final b i(Class<? extends v>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, clsArr)) == null) {
            b bVar = g;
            bVar.d();
            bVar.c(clsArr);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static String e(n6 n6Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, n6Var)) == null) {
            StringBuilder sb = new StringBuilder();
            int h2 = n6Var.h();
            for (int i = 0; i < h2; i++) {
                if (n6Var.e(i)) {
                    str = "1";
                } else {
                    str = "0";
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public boolean h(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yVar)) == null) {
            n6 e2 = yVar.e();
            if (!e2.d(this.a)) {
                return false;
            }
            if (!this.b.g() && !this.b.f(e2)) {
                return false;
            }
            if (!this.c.g() && this.c.f(e2)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String f(n6 n6Var, n6 n6Var2, n6 n6Var3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, n6Var, n6Var2, n6Var3)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!n6Var.g()) {
                sb.append("{all:");
                sb.append(e(n6Var));
                sb.append("}");
            }
            if (!n6Var2.g()) {
                sb.append("{one:");
                sb.append(e(n6Var2));
                sb.append("}");
            }
            if (!n6Var3.g()) {
                sb.append("{exclude:");
                sb.append(e(n6Var3));
                sb.append("}");
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }
}
