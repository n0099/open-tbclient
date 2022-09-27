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
public class h43 extends i43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947773698, "Lcom/baidu/tieba/h43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947773698, "Lcom/baidu/tieba/h43;");
                return;
            }
        }
        b = vj1.a;
    }

    public h43() {
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

    @Override // com.baidu.tieba.i43
    public void a() {
        List<i53> b2;
        List<i53> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new bo2(this));
            b(new y02(this));
            b(new d12(this));
            b(new r02(this));
            b(new e53(this));
            b(new p43(this));
            b(new q63(this));
            b(new fe2(this));
            b(new oe2(this));
            b(new ge2(this));
            b(new ke2(this));
            b(new le2(this));
            b(new je2(this));
            b(new pe2(this));
            b(new ie2(this));
            b(new ne2(this));
            b(new cj3(this));
            b(new me2(this));
            b(new he2(this));
            qk1 d = tm2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (i53 i53Var : a) {
                    b(i53Var);
                }
            }
            if (b) {
                b(new qe2(this));
                b(new j43(this));
                if (d == null || (b2 = d.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (i53 i53Var2 : b2) {
                    b(i53Var2);
                }
            }
        }
    }
}
