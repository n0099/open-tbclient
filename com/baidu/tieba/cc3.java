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
public class cc3 extends dc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947669910, "Lcom/baidu/tieba/cc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947669910, "Lcom/baidu/tieba/cc3;");
                return;
            }
        }
        b = qr1.a;
    }

    public cc3() {
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

    @Override // com.baidu.tieba.dc3
    public void a() {
        List<dd3> b2;
        List<dd3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new wv2(this));
            b(new t82(this));
            b(new y82(this));
            b(new m82(this));
            b(new zc3(this));
            b(new kc3(this));
            b(new le3(this));
            b(new am2(this));
            b(new jm2(this));
            b(new bm2(this));
            b(new fm2(this));
            b(new gm2(this));
            b(new em2(this));
            b(new km2(this));
            b(new dm2(this));
            b(new im2(this));
            b(new xq3(this));
            b(new hm2(this));
            b(new cm2(this));
            ls1 d = ou2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (dd3 dd3Var : a) {
                    b(dd3Var);
                }
            }
            if (b) {
                b(new lm2(this));
                b(new ec3(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (dd3 dd3Var2 : b2) {
                        b(dd3Var2);
                    }
                }
            }
        }
    }
}
