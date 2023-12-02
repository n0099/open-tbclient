package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.ip2;
import com.baidu.tieba.qr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes6.dex */
public class fp2 extends ip2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final ce4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947771745, "Lcom/baidu/tieba/fp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947771745, "Lcom/baidu/tieba/fp2;");
                return;
            }
        }
        f = vm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fp2(String str, ce4 ce4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ce4Var};
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
        this.e = ce4Var;
    }

    @Override // com.baidu.tieba.ip2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        di3 di3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            pr2 d = pr2.d(bundle.getString("launch_id"));
            qr2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    di3Var = ca2.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    di3 di3Var2 = new di3();
                    di3Var2.k(11L);
                    di3Var2.i(2300L);
                    di3Var2.f("inputStream IOException:" + e2.toString());
                    hi3.a().f(di3Var2);
                    d.g("SignChecker", di3Var2.toString());
                    xk3.a(sourceChannel);
                    di3Var = di3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (di3Var != null) {
                    z = false;
                }
                if (di3Var != null) {
                    d.g("SignChecker", di3Var.toString());
                    c().putLong("result_error_code", di3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                xk3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
