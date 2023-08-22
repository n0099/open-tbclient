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
/* loaded from: classes6.dex */
public class gl4 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final fo4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public bl4 a;
    public AtomicBoolean b;
    public al4 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947797754, "Lcom/baidu/tieba/gl4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947797754, "Lcom/baidu/tieba/gl4;");
                return;
            }
        }
        d = fo4.e();
    }

    public gl4(AtomicBoolean atomicBoolean, bl4 bl4Var, al4 al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atomicBoolean, bl4Var, al4Var};
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
        this.a = bl4Var;
        this.c = al4Var;
    }

    public final <T> void a(fl4<T> fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fl4Var) == null) {
            this.a.a(fl4Var);
            try {
                try {
                    fl4Var.run();
                } catch (Exception e) {
                    d.g("PMSTaskExecutor", "#runTask 包下载任务出错", e);
                }
            } finally {
                this.a.b(fl4Var);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.b.get()) {
                Runnable a = this.c.a(true);
                if (a instanceof fl4) {
                    try {
                        a((fl4) a);
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
