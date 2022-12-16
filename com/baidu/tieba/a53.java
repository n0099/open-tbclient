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
/* loaded from: classes3.dex */
public class a53 extends b53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947566122, "Lcom/baidu/tieba/a53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947566122, "Lcom/baidu/tieba/a53;");
                return;
            }
        }
        b = ok1.a;
    }

    public a53() {
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

    @Override // com.baidu.tieba.b53
    public void a() {
        List<b63> b2;
        List<b63> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new uo2(this));
            b(new r12(this));
            b(new w12(this));
            b(new k12(this));
            b(new x53(this));
            b(new i53(this));
            b(new j73(this));
            b(new ye2(this));
            b(new hf2(this));
            b(new ze2(this));
            b(new df2(this));
            b(new ef2(this));
            b(new cf2(this));
            b(new if2(this));
            b(new bf2(this));
            b(new gf2(this));
            b(new vj3(this));
            b(new ff2(this));
            b(new af2(this));
            jl1 d = mn2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (b63 b63Var : a) {
                    b(b63Var);
                }
            }
            if (b) {
                b(new jf2(this));
                b(new c53(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (b63 b63Var2 : b2) {
                        b(b63Var2);
                    }
                }
            }
        }
    }
}
