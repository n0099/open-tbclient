package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class i43 extends j43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947803489, "Lcom/baidu/tieba/i43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947803489, "Lcom/baidu/tieba/i43;");
                return;
            }
        }
        b = wj1.a;
    }

    public i43() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.j43
    public void a() {
        List<j53> b2;
        List<j53> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new co2(this));
            b(new z02(this));
            b(new e12(this));
            b(new s02(this));
            b(new f53(this));
            b(new q43(this));
            b(new r63(this));
            b(new ge2(this));
            b(new pe2(this));
            b(new he2(this));
            b(new le2(this));
            b(new me2(this));
            b(new ke2(this));
            b(new qe2(this));
            b(new je2(this));
            b(new oe2(this));
            b(new dj3(this));
            b(new ne2(this));
            b(new ie2(this));
            rk1 d = um2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (j53 j53Var : a) {
                    b(j53Var);
                }
            }
            if (b) {
                b(new re2(this));
                b(new k43(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (j53 j53Var2 : b2) {
                        b(j53Var2);
                    }
                }
            }
        }
    }
}
