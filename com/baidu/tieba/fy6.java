package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class fy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i05 a;
    public k05 b;
    public String c;
    public String[] d;
    public String e;
    public k05.f f;
    public a9 g;

    public fy6(a9 a9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = a9Var;
    }

    public static fy6 c(a9 a9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, a9Var)) == null) {
            return new fy6(a9Var);
        }
        return (fy6) invokeL.objValue;
    }

    public fy6 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (fy6) invokeL.objValue;
    }

    public fy6 e(k05.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (fy6) invokeL.objValue;
    }

    public fy6 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (fy6) invokeL.objValue;
    }

    public fy6 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (fy6) invokeL.objValue;
    }

    public final List<g05> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                g05 g05Var = new g05(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    g05Var.q(R.color.CAM_X0304);
                    g05Var.p();
                }
                arrayList.add(g05Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        i05 i05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (i05Var = this.a) != null) {
            i05Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k05 k05Var = new k05(this.g.getPageActivity());
            this.b = k05Var;
            k05Var.s(this.c);
            this.b.p(this.f);
            this.b.k(a(this.d));
            this.b.m(hi.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f07076d));
            i05 i05Var = new i05(this.g, this.b);
            this.a = i05Var;
            i05Var.k();
        }
    }
}
