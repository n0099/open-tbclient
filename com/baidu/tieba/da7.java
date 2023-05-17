package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class da7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m25 a;
    public o25 b;
    public String c;
    public String[] d;
    public String e;
    public o25.f f;
    public g9 g;

    public da7(g9 g9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = g9Var;
    }

    public static da7 c(g9 g9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g9Var)) == null) {
            return new da7(g9Var);
        }
        return (da7) invokeL.objValue;
    }

    public da7 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (da7) invokeL.objValue;
    }

    public da7 e(o25.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (da7) invokeL.objValue;
    }

    public da7 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (da7) invokeL.objValue;
    }

    public da7 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (da7) invokeL.objValue;
    }

    public final List<k25> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                k25 k25Var = new k25(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    k25Var.q(R.color.CAM_X0304);
                    k25Var.p();
                }
                arrayList.add(k25Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        m25 m25Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (m25Var = this.a) != null) {
            m25Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            o25 o25Var = new o25(this.g.getPageActivity());
            this.b = o25Var;
            o25Var.t(this.c);
            this.b.q(this.f);
            this.b.l(a(this.d));
            this.b.n(ri.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f0708bf));
            m25 m25Var = new m25(this.g, this.b);
            this.a = m25Var;
            m25Var.l();
        }
    }
}
