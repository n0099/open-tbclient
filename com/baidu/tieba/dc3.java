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
public class dc3 extends ec3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947699701, "Lcom/baidu/tieba/dc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947699701, "Lcom/baidu/tieba/dc3;");
                return;
            }
        }
        b = rr1.a;
    }

    public dc3() {
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

    @Override // com.baidu.tieba.ec3
    public void a() {
        List<ed3> b2;
        List<ed3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new xv2(this));
            b(new u82(this));
            b(new z82(this));
            b(new n82(this));
            b(new ad3(this));
            b(new lc3(this));
            b(new me3(this));
            b(new bm2(this));
            b(new km2(this));
            b(new cm2(this));
            b(new gm2(this));
            b(new hm2(this));
            b(new fm2(this));
            b(new lm2(this));
            b(new em2(this));
            b(new jm2(this));
            b(new yq3(this));
            b(new im2(this));
            b(new dm2(this));
            ms1 d = pu2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (ed3 ed3Var : a) {
                    b(ed3Var);
                }
            }
            if (b) {
                b(new mm2(this));
                b(new fc3(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (ed3 ed3Var2 : b2) {
                        b(ed3Var2);
                    }
                }
            }
        }
    }
}
