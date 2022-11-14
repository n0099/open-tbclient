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
public class b53 extends c53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947595913, "Lcom/baidu/tieba/b53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947595913, "Lcom/baidu/tieba/b53;");
                return;
            }
        }
        b = pk1.a;
    }

    public b53() {
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

    @Override // com.baidu.tieba.c53
    public void a() {
        List<c63> b2;
        List<c63> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new vo2(this));
            b(new s12(this));
            b(new x12(this));
            b(new l12(this));
            b(new y53(this));
            b(new j53(this));
            b(new k73(this));
            b(new ze2(this));
            b(new if2(this));
            b(new af2(this));
            b(new ef2(this));
            b(new ff2(this));
            b(new df2(this));
            b(new jf2(this));
            b(new cf2(this));
            b(new hf2(this));
            b(new wj3(this));
            b(new gf2(this));
            b(new bf2(this));
            kl1 d = nn2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (c63 c63Var : a) {
                    b(c63Var);
                }
            }
            if (b) {
                b(new kf2(this));
                b(new d53(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (c63 c63Var2 : b2) {
                        b(c63Var2);
                    }
                }
            }
        }
    }
}
