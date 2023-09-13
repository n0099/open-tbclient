package com.baidu.tieba;

import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class gk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g55 a;
    public i55 b;
    public String c;
    public String[] d;
    public String e;
    public i55.f f;
    public BdPageContext g;

    public gk7(BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = bdPageContext;
    }

    public static gk7 c(BdPageContext bdPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bdPageContext)) == null) {
            return new gk7(bdPageContext);
        }
        return (gk7) invokeL.objValue;
    }

    public gk7 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (gk7) invokeL.objValue;
    }

    public gk7 e(i55.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (gk7) invokeL.objValue;
    }

    public gk7 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (gk7) invokeL.objValue;
    }

    public gk7 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (gk7) invokeL.objValue;
    }

    public final List<e55> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                e55 e55Var = new e55(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    e55Var.r(R.color.CAM_X0304);
                    e55Var.q();
                }
                arrayList.add(e55Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        g55 g55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (g55Var = this.a) != null) {
            g55Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i55 i55Var = new i55(this.g.getPageActivity());
            this.b = i55Var;
            i55Var.t(this.c);
            this.b.q(this.f);
            this.b.l(a(this.d));
            this.b.n(BdUtilHelper.getDimens(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f0708ef));
            g55 g55Var = new g55(this.g, this.b);
            this.a = g55Var;
            g55Var.l();
        }
    }
}
