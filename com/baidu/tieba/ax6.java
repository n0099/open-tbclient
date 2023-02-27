package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ax6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z15 a;
    public b25 b;
    public String c;
    public String[] d;
    public String e;
    public b25.f f;
    public x9 g;

    public ax6(x9 x9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = x9Var;
    }

    public static ax6 c(x9 x9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, x9Var)) == null) {
            return new ax6(x9Var);
        }
        return (ax6) invokeL.objValue;
    }

    public ax6 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (ax6) invokeL.objValue;
    }

    public ax6 e(b25.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (ax6) invokeL.objValue;
    }

    public ax6 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (ax6) invokeL.objValue;
    }

    public ax6 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (ax6) invokeL.objValue;
    }

    public final List<x15> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                x15 x15Var = new x15(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    x15Var.q(R.color.CAM_X0304);
                    x15Var.p();
                }
                arrayList.add(x15Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        z15 z15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (z15Var = this.a) != null) {
            z15Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b25 b25Var = new b25(this.g.getPageActivity());
            this.b = b25Var;
            b25Var.s(this.c);
            this.b.p(this.f);
            this.b.k(a(this.d));
            this.b.m(ej.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f07076d));
            z15 z15Var = new z15(this.g, this.b);
            this.a = z15Var;
            z15Var.k();
        }
    }
}
