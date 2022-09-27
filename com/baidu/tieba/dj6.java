package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class dj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wu4 a;
    public yu4 b;
    public String c;
    public String[] d;
    public String e;
    public yu4.e f;
    public r9 g;

    public dj6(r9 r9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = r9Var;
    }

    public static dj6 c(r9 r9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, r9Var)) == null) ? new dj6(r9Var) : (dj6) invokeL.objValue;
    }

    public final List<uu4> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                uu4 uu4Var = new uu4(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    uu4Var.q(R.color.CAM_X0304);
                    uu4Var.p();
                }
                arrayList.add(uu4Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        wu4 wu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (wu4Var = this.a) == null) {
            return;
        }
        wu4Var.dismiss();
    }

    public dj6 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (dj6) invokeL.objValue;
    }

    public dj6 e(yu4.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            this.f = eVar;
            return this;
        }
        return (dj6) invokeL.objValue;
    }

    public dj6 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (dj6) invokeL.objValue;
    }

    public dj6 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (dj6) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            yu4 yu4Var = new yu4(this.g.getPageActivity());
            this.b = yu4Var;
            yu4Var.q(this.c);
            this.b.n(this.f);
            this.b.j(a(this.d));
            this.b.l(ej.f(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f07075d));
            wu4 wu4Var = new wu4(this.g, this.b);
            this.a = wu4Var;
            wu4Var.k();
        }
    }
}
