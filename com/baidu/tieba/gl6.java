package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.uv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class gl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sv4 a;
    public uv4 b;
    public String c;
    public String[] d;
    public String e;
    public uv4.e f;
    public r9 g;

    public gl6(r9 r9Var) {
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

    public static gl6 c(r9 r9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, r9Var)) == null) {
            return new gl6(r9Var);
        }
        return (gl6) invokeL.objValue;
    }

    public gl6 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (gl6) invokeL.objValue;
    }

    public gl6 e(uv4.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            this.f = eVar;
            return this;
        }
        return (gl6) invokeL.objValue;
    }

    public gl6 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (gl6) invokeL.objValue;
    }

    public gl6 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (gl6) invokeL.objValue;
    }

    public final List<qv4> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                qv4 qv4Var = new qv4(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    qv4Var.q(R.color.CAM_X0304);
                    qv4Var.p();
                }
                arrayList.add(qv4Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        sv4 sv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (sv4Var = this.a) != null) {
            sv4Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            uv4 uv4Var = new uv4(this.g.getPageActivity());
            this.b = uv4Var;
            uv4Var.q(this.c);
            this.b.n(this.f);
            this.b.j(a(this.d));
            this.b.l(yi.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f07075d));
            sv4 sv4Var = new sv4(this.g, this.b);
            this.a = sv4Var;
            sv4Var.k();
        }
    }
}
