package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.eu2;
import com.baidu.tieba.mw2;
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
public class bu2 extends eu2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final yi4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947657386, "Lcom/baidu/tieba/bu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947657386, "Lcom/baidu/tieba/bu2;");
                return;
            }
        }
        f = qr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu2(String str, yi4 yi4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, yi4Var};
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
        this.e = yi4Var;
    }

    @Override // com.baidu.tieba.eu2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        zm3 zm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            lw2 d = lw2.d(bundle.getString("launch_id"));
            mw2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    zm3Var = ye2.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    zm3 zm3Var2 = new zm3();
                    zm3Var2.k(11L);
                    zm3Var2.i(2300L);
                    zm3Var2.f("inputStream IOException:" + e2.toString());
                    dn3.a().f(zm3Var2);
                    d.g("SignChecker", zm3Var2.toString());
                    tp3.a(sourceChannel);
                    zm3Var = zm3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (zm3Var != null) {
                    z = false;
                }
                if (zm3Var != null) {
                    d.g("SignChecker", zm3Var.toString());
                    c().putLong("result_error_code", zm3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                tp3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
