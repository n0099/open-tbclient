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
/* loaded from: classes5.dex */
public class c73 extends d73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947627626, "Lcom/baidu/tieba/c73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947627626, "Lcom/baidu/tieba/c73;");
                return;
            }
        }
        b = rm1.a;
    }

    public c73() {
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

    @Override // com.baidu.tieba.d73
    public void a() {
        List<d83> b2;
        List<d83> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new wq2(this));
            b(new t32(this));
            b(new y32(this));
            b(new m32(this));
            b(new z73(this));
            b(new k73(this));
            b(new l93(this));
            b(new ah2(this));
            b(new jh2(this));
            b(new bh2(this));
            b(new fh2(this));
            b(new gh2(this));
            b(new eh2(this));
            b(new kh2(this));
            b(new dh2(this));
            b(new ih2(this));
            b(new xl3(this));
            b(new hh2(this));
            b(new ch2(this));
            mn1 d = op2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (d83 d83Var : a) {
                    b(d83Var);
                }
            }
            if (b) {
                b(new lh2(this));
                b(new e73(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (d83 d83Var2 : b2) {
                        b(d83Var2);
                    }
                }
            }
        }
    }
}
