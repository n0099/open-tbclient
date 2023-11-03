package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b1 {
    public static /* synthetic */ Interceptable $ic;
    public static q3<String, b1> e;
    public static int f;
    public static final b g;
    public static final i3 h;
    public transient /* synthetic */ FieldHolder $fh;
    public final i3 a;
    public final i3 b;
    public final i3 c;
    public final int d;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this == obj : invokeL.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public i3 a;
        public i3 b;
        public i3 c;

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
            this.a = b1.h;
            this.b = b1.h;
            this.c = b1.h;
        }

        public b1 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (b1) invokeV.objValue;
            }
            String f = b1.f(this.a, this.b, this.c);
            b1 b1Var = (b1) b1.e.c(f, null);
            if (b1Var == null) {
                b1 b1Var2 = new b1(this.a, this.b, this.c, null);
                b1.e.h(f, b1Var2);
                return b1Var2;
            }
            return b1Var;
        }

        @SafeVarargs
        public final b a(Class<? extends v0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, clsArr)) == null) {
                this.a = w0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        @SafeVarargs
        public final b c(Class<? extends v0>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clsArr)) == null) {
                this.b = w0.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.a = b1.h;
                this.b = b1.h;
                this.c = b1.h;
                return this;
            }
            return (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448298878, "Lcom/baidu/tieba/b1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448298878, "Lcom/baidu/tieba/b1;");
                return;
            }
        }
        e = new q3<>();
        f = 0;
        g = new b();
        h = new i3();
    }

    public b1(i3 i3Var, i3 i3Var2, i3 i3Var3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i3Var, i3Var2, i3Var3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i3Var;
        this.b = i3Var2;
        this.c = i3Var3;
        int i3 = f;
        f = i3 + 1;
        this.d = i3;
    }

    public /* synthetic */ b1(i3 i3Var, i3 i3Var2, i3 i3Var3, a aVar) {
        this(i3Var, i3Var2, i3Var3);
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
    public static final b d(Class<? extends v0>... clsArr) {
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
    public static final b i(Class<? extends v0>... clsArr) {
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

    public static String e(i3 i3Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, i3Var)) == null) {
            StringBuilder sb = new StringBuilder();
            int h2 = i3Var.h();
            for (int i = 0; i < h2; i++) {
                if (i3Var.e(i)) {
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

    public boolean h(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y0Var)) == null) {
            i3 e2 = y0Var.e();
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

    public static String f(i3 i3Var, i3 i3Var2, i3 i3Var3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, i3Var, i3Var2, i3Var3)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!i3Var.g()) {
                sb.append("{all:");
                sb.append(e(i3Var));
                sb.append("}");
            }
            if (!i3Var2.g()) {
                sb.append("{one:");
                sb.append(e(i3Var2));
                sb.append("}");
            }
            if (!i3Var3.g()) {
                sb.append("{exclude:");
                sb.append(e(i3Var3));
                sb.append("}");
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }
}
