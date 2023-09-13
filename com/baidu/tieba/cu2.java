package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.fu2;
import com.baidu.tieba.nw2;
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
public class cu2 extends fu2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final zi4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687177, "Lcom/baidu/tieba/cu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687177, "Lcom/baidu/tieba/cu2;");
                return;
            }
        }
        f = rr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu2(String str, zi4 zi4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, zi4Var};
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
        this.e = zi4Var;
    }

    @Override // com.baidu.tieba.fu2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        an3 an3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            mw2 d = mw2.d(bundle.getString("launch_id"));
            nw2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    an3Var = ze2.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    an3 an3Var2 = new an3();
                    an3Var2.k(11L);
                    an3Var2.i(2300L);
                    an3Var2.f("inputStream IOException:" + e2.toString());
                    en3.a().f(an3Var2);
                    d.g("SignChecker", an3Var2.toString());
                    up3.a(sourceChannel);
                    an3Var = an3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (an3Var != null) {
                    z = false;
                }
                if (an3Var != null) {
                    d.g("SignChecker", an3Var.toString());
                    c().putLong("result_error_code", an3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                up3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
