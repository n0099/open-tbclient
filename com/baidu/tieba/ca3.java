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
public class ca3 extends da3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947667988, "Lcom/baidu/tieba/ca3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947667988, "Lcom/baidu/tieba/ca3;");
                return;
            }
        }
        b = qp1.a;
    }

    public ca3() {
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

    @Override // com.baidu.tieba.da3
    public void a() {
        List<db3> b2;
        List<db3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new wt2(this));
            b(new t62(this));
            b(new y62(this));
            b(new m62(this));
            b(new za3(this));
            b(new ka3(this));
            b(new lc3(this));
            b(new ak2(this));
            b(new jk2(this));
            b(new bk2(this));
            b(new fk2(this));
            b(new gk2(this));
            b(new ek2(this));
            b(new kk2(this));
            b(new dk2(this));
            b(new ik2(this));
            b(new xo3(this));
            b(new hk2(this));
            b(new ck2(this));
            lq1 d = os2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (db3 db3Var : a) {
                    b(db3Var);
                }
            }
            if (b) {
                b(new lk2(this));
                b(new ea3(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (db3 db3Var2 : b2) {
                        b(db3Var2);
                    }
                }
            }
        }
    }
}
