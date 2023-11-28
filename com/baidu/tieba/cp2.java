package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.fp2;
import com.baidu.tieba.nr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes5.dex */
public class cp2 extends fp2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final zd4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947682372, "Lcom/baidu/tieba/cp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947682372, "Lcom/baidu/tieba/cp2;");
                return;
            }
        }
        f = sm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp2(String str, zd4 zd4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, zd4Var};
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
        this.e = zd4Var;
    }

    @Override // com.baidu.tieba.fp2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ai3 ai3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            mr2 d = mr2.d(bundle.getString("launch_id"));
            nr2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    ai3Var = z92.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    ai3 ai3Var2 = new ai3();
                    ai3Var2.k(11L);
                    ai3Var2.i(2300L);
                    ai3Var2.f("inputStream IOException:" + e2.toString());
                    ei3.a().f(ai3Var2);
                    d.g("SignChecker", ai3Var2.toString());
                    uk3.a(sourceChannel);
                    ai3Var = ai3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (ai3Var != null) {
                    z = false;
                }
                if (ai3Var != null) {
                    d.g("SignChecker", ai3Var.toString());
                    c().putLong("result_error_code", ai3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                uk3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
