package com.baidu.tieba;

import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Service
/* loaded from: classes4.dex */
public class f53 extends g53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947715077, "Lcom/baidu/tieba/f53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947715077, "Lcom/baidu/tieba/f53;");
                return;
            }
        }
        b = tk1.a;
    }

    public f53() {
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

    @Override // com.baidu.tieba.g53
    public void a() {
        List<g63> b2;
        List<g63> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new zo2(this));
            b(new w12(this));
            b(new b22(this));
            b(new p12(this));
            b(new c63(this));
            b(new n53(this));
            b(new o73(this));
            b(new df2(this));
            b(new mf2(this));
            b(new ef2(this));
            b(new if2(this));
            b(new jf2(this));
            b(new hf2(this));
            b(new nf2(this));
            b(new gf2(this));
            b(new lf2(this));
            b(new ak3(this));
            b(new kf2(this));
            b(new ff2(this));
            ol1 d = rn2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (g63 g63Var : a) {
                    b(g63Var);
                }
            }
            if (b) {
                b(new of2(this));
                b(new h53(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (g63 g63Var2 : b2) {
                        b(g63Var2);
                    }
                }
            }
        }
    }
}
