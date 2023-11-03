package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.ep2;
import com.baidu.tieba.mr2;
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
public class bp2 extends ep2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final yd4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947652581, "Lcom/baidu/tieba/bp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947652581, "Lcom/baidu/tieba/bp2;");
                return;
            }
        }
        f = rm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp2(String str, yd4 yd4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, yd4Var};
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
        this.e = yd4Var;
    }

    @Override // com.baidu.tieba.ep2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        zh3 zh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            lr2 d = lr2.d(bundle.getString("launch_id"));
            mr2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    zh3Var = y92.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    zh3 zh3Var2 = new zh3();
                    zh3Var2.k(11L);
                    zh3Var2.i(2300L);
                    zh3Var2.f("inputStream IOException:" + e2.toString());
                    di3.a().f(zh3Var2);
                    d.g("SignChecker", zh3Var2.toString());
                    tk3.a(sourceChannel);
                    zh3Var = zh3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (zh3Var != null) {
                    z = false;
                }
                if (zh3Var != null) {
                    d.g("SignChecker", zh3Var.toString());
                    c().putLong("result_error_code", zh3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                tk3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
