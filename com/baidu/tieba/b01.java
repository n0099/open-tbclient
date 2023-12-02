package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<a> a;
    public final List<zz0> b;
    public String c;
    public String d;
    public xz0 e;
    public yz0 f;
    public a01 g;
    public int h;
    public int i;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final nz0[] b;

        public a(String str, nz0[] nz0VarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, nz0VarArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = nz0VarArr;
        }
    }

    public b01() {
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
        this.a = new ArrayList(4);
        this.b = new ArrayList(2);
        this.h = -1;
        this.i = -1;
    }

    public static b01 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new b01();
        }
        return (b01) invokeV.objValue;
    }

    public String[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            xz0 xz0Var = this.e;
            if (xz0Var == null) {
                return null;
            }
            return xz0Var.e();
        }
        return (String[]) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return e(null).toString();
        }
        return (String) invokeV.objValue;
    }

    public b01 a(String str, nz0... nz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, nz0VarArr)) == null) {
            this.a.add(new a(str, nz0VarArr));
            return this;
        }
        return (b01) invokeLL.objValue;
    }

    public b01 c(String str, wz0 wz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, wz0Var)) == null) {
            this.d = str;
            this.c = wz0Var.b().g();
            return this;
        }
        return (b01) invokeLL.objValue;
    }

    public b01 d(String str, Class<? extends wz0> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, cls)) == null) {
            this.d = str;
            this.c = qz0.b(cls).g();
            return this;
        }
        return (b01) invokeLL.objValue;
    }

    public xz0 h(nz0 nz0Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, nz0Var, str)) == null) {
            return i(null, nz0Var, str);
        }
        return (xz0) invokeLL.objValue;
    }

    public final StringBuilder e(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sb)) == null) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append("SELECT ");
            int size = this.a.size();
            String str = "";
            for (int i = 0; i < size; i++) {
                int i2 = 0;
                while (i2 < this.a.get(i).b.length) {
                    sb.append(str);
                    String str2 = this.a.get(i).a;
                    if (!TextUtils.isEmpty(str2)) {
                        sb.append(str2);
                        sb.append(".");
                    }
                    sb.append(this.a.get(i).b[i2].b);
                    i2++;
                    str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
                }
            }
            sb.append(" ");
            sb.append("FROM ");
            sb.append(this.c);
            if (!TextUtils.isEmpty(this.d)) {
                sb.append(" AS ");
                sb.append(this.d);
            }
            for (zz0 zz0Var : this.b) {
                sb.append(zz0Var.c());
            }
            xz0 xz0Var = this.e;
            if (xz0Var != null) {
                sb.append(xz0Var.l());
            }
            yz0 yz0Var = this.f;
            if (yz0Var != null) {
                sb.append(yz0Var.a());
            }
            a01 a01Var = this.g;
            if (a01Var != null) {
                sb.append(a01Var.a());
            }
            if (this.h > -1) {
                sb.append(" LIMIT ");
                sb.append(this.h);
            }
            if (this.i > -1) {
                sb.append(" OFFSET ");
                sb.append(this.i);
            }
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }

    public xz0 i(String str, nz0 nz0Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, str, nz0Var, str2)) == null) {
            xz0 j = xz0.j(str, nz0Var, str2);
            this.e = j;
            return j;
        }
        return (xz0) invokeLLL.objValue;
    }
}
