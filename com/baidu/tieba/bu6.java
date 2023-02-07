package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class bu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s05 a;
    public u05 b;
    public String c;
    public String[] d;
    public String e;
    public u05.f f;
    public x9 g;

    public bu6(x9 x9Var) {
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

    public static bu6 c(x9 x9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, x9Var)) == null) {
            return new bu6(x9Var);
        }
        return (bu6) invokeL.objValue;
    }

    public bu6 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (bu6) invokeL.objValue;
    }

    public bu6 e(u05.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (bu6) invokeL.objValue;
    }

    public bu6 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (bu6) invokeL.objValue;
    }

    public bu6 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (bu6) invokeL.objValue;
    }

    public final List<q05> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                q05 q05Var = new q05(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    q05Var.q(R.color.CAM_X0304);
                    q05Var.p();
                }
                arrayList.add(q05Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        s05 s05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (s05Var = this.a) != null) {
            s05Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            u05 u05Var = new u05(this.g.getPageActivity());
            this.b = u05Var;
            u05Var.s(this.c);
            this.b.p(this.f);
            this.b.k(a(this.d));
            this.b.m(ej.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f07076d));
            s05 s05Var = new s05(this.g, this.b);
            this.a = s05Var;
            s05Var.k();
        }
    }
}
