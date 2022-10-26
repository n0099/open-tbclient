package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.km2;
import com.baidu.tieba.so2;
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
public class hm2 extends km2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final eb4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947828444, "Lcom/baidu/tieba/hm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947828444, "Lcom/baidu/tieba/hm2;");
                return;
            }
        }
        f = wj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hm2(String str, eb4 eb4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, eb4Var};
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
        this.e = eb4Var;
    }

    @Override // com.baidu.tieba.km2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ff3 ff3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            ro2 d = ro2.d(bundle.getString("launch_id"));
            so2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    ff3Var = e72.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    ff3 ff3Var2 = new ff3();
                    ff3Var2.k(11L);
                    ff3Var2.i(2300L);
                    ff3Var2.f("inputStream IOException:" + e2.toString());
                    jf3.a().f(ff3Var2);
                    d.g("SignChecker", ff3Var2.toString());
                    zh3.a(sourceChannel);
                    ff3Var = ff3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (ff3Var != null) {
                    z = false;
                }
                if (ff3Var != null) {
                    d.g("SignChecker", ff3Var.toString());
                    c().putLong("result_error_code", ff3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                zh3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
