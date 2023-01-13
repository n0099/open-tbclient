package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.hn2;
import com.baidu.tieba.pp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes4.dex */
public class en2 extends hn2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final bc4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947740032, "Lcom/baidu/tieba/en2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947740032, "Lcom/baidu/tieba/en2;");
                return;
            }
        }
        f = tk1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public en2(String str, bc4 bc4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bc4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = str;
        this.e = bc4Var;
    }

    @Override // com.baidu.tieba.hn2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        cg3 cg3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            op2 d = op2.d(bundle.getString("launch_id"));
            pp2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    cg3Var = b82.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    cg3 cg3Var2 = new cg3();
                    cg3Var2.k(11L);
                    cg3Var2.i(2300L);
                    cg3Var2.f("inputStream IOException:" + e2.toString());
                    gg3.a().f(cg3Var2);
                    d.g("SignChecker", cg3Var2.toString());
                    wi3.a(sourceChannel);
                    cg3Var = cg3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (cg3Var != null) {
                    z = false;
                }
                if (cg3Var != null) {
                    d.g("SignChecker", cg3Var.toString());
                    c().putLong("result_error_code", cg3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                wi3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
