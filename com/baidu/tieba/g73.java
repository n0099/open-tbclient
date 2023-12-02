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
/* loaded from: classes6.dex */
public class g73 extends h73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746790, "Lcom/baidu/tieba/g73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746790, "Lcom/baidu/tieba/g73;");
                return;
            }
        }
        b = vm1.a;
    }

    public g73() {
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

    @Override // com.baidu.tieba.h73
    public void a() {
        List<h83> b2;
        List<h83> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new ar2(this));
            b(new x32(this));
            b(new c42(this));
            b(new q32(this));
            b(new d83(this));
            b(new o73(this));
            b(new p93(this));
            b(new eh2(this));
            b(new nh2(this));
            b(new fh2(this));
            b(new jh2(this));
            b(new kh2(this));
            b(new ih2(this));
            b(new oh2(this));
            b(new hh2(this));
            b(new mh2(this));
            b(new bm3(this));
            b(new lh2(this));
            b(new gh2(this));
            qn1 d = sp2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (h83 h83Var : a) {
                    b(h83Var);
                }
            }
            if (b) {
                b(new ph2(this));
                b(new i73(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (h83 h83Var2 : b2) {
                        b(h83Var2);
                    }
                }
            }
        }
    }
}
