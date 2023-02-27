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
public class ia3 extends ja3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947846734, "Lcom/baidu/tieba/ia3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947846734, "Lcom/baidu/tieba/ia3;");
                return;
            }
        }
        b = wp1.a;
    }

    public ia3() {
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

    @Override // com.baidu.tieba.ja3
    public void a() {
        List<jb3> b2;
        List<jb3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new cu2(this));
            b(new z62(this));
            b(new e72(this));
            b(new s62(this));
            b(new fb3(this));
            b(new qa3(this));
            b(new rc3(this));
            b(new gk2(this));
            b(new pk2(this));
            b(new hk2(this));
            b(new lk2(this));
            b(new mk2(this));
            b(new kk2(this));
            b(new qk2(this));
            b(new jk2(this));
            b(new ok2(this));
            b(new dp3(this));
            b(new nk2(this));
            b(new ik2(this));
            rq1 d = us2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (jb3 jb3Var : a) {
                    b(jb3Var);
                }
            }
            if (b) {
                b(new rk2(this));
                b(new ka3(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (jb3 jb3Var2 : b2) {
                        b(jb3Var2);
                    }
                }
            }
        }
    }
}
