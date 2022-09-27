package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.jm2;
import com.baidu.tieba.ro2;
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
public class gm2 extends jm2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final db4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947798653, "Lcom/baidu/tieba/gm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947798653, "Lcom/baidu/tieba/gm2;");
                return;
            }
        }
        f = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gm2(String str, db4 db4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, db4Var};
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
        this.e = db4Var;
    }

    @Override // com.baidu.tieba.jm2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        ef3 ef3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            qo2 d = qo2.d(bundle.getString("launch_id"));
            ro2.b e = d.e();
            e.b("SignChecker");
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    ef3Var = d72.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    ef3 ef3Var2 = new ef3();
                    ef3Var2.k(11L);
                    ef3Var2.i(2300L);
                    ef3Var2.f("inputStream IOException:" + e2.toString());
                    if3.a().f(ef3Var2);
                    d.g("SignChecker", ef3Var2.toString());
                    yh3.a(sourceChannel);
                    ef3Var = ef3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                boolean z = ef3Var == null;
                if (ef3Var != null) {
                    d.g("SignChecker", ef3Var.toString());
                    c().putLong("result_error_code", ef3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                yh3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
