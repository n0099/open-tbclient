package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class ai4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final zk4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public vh4 a;
    public AtomicBoolean b;
    public uh4 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947616125, "Lcom/baidu/tieba/ai4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947616125, "Lcom/baidu/tieba/ai4;");
                return;
            }
        }
        d = zk4.e();
    }

    public ai4(AtomicBoolean atomicBoolean, vh4 vh4Var, uh4 uh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atomicBoolean, vh4Var, uh4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = atomicBoolean;
        this.a = vh4Var;
        this.c = uh4Var;
    }

    public final <T> void a(zh4<T> zh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zh4Var) == null) {
            this.a.a(zh4Var);
            try {
                try {
                    zh4Var.run();
                } catch (Exception e) {
                    d.g("PMSTaskExecutor", "#runTask 包下载任务出错", e);
                }
            } finally {
                this.a.b(zh4Var);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.b.get()) {
                Runnable a = this.c.a(true);
                if (a instanceof zh4) {
                    try {
                        a((zh4) a);
                    } catch (Throwable th) {
                        d.g("PMSTaskExecutor", "#run 包下载任务出错", th);
                    }
                } else {
                    return;
                }
            }
        }
    }
}
