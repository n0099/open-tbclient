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
/* loaded from: classes4.dex */
public class en0 implements nn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fn0 b;
    public int c;
    public long d;
    public AtomicBoolean e;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final en0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-827648892, "Lcom/baidu/tieba/en0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-827648892, "Lcom/baidu/tieba/en0$b;");
                    return;
                }
            }
            a = new en0(null);
        }
    }

    public en0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.d = 0L;
        this.e = new AtomicBoolean(false);
    }

    public static en0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (en0) invokeV.objValue;
    }

    public void b() {
        fn0 fn0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.c + 1;
            this.c = i;
            if (i <= 2 && (fn0Var = this.b) != null) {
                fn0Var.e();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.set(false);
        }
    }

    public /* synthetic */ en0(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.nn0
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || this.e.get()) {
            return;
        }
        fn0 fn0Var = this.b;
        if (fn0Var != null) {
            fn0Var.d();
            this.b = null;
            this.c = -1;
        }
        if (z) {
            if (this.d == 0 || System.currentTimeMillis() - this.d <= 300000) {
                return;
            }
            if (this.e.compareAndSet(false, true)) {
                this.b = new fn0(60, this.c + 1, true);
            }
        } else {
            if (this.e.compareAndSet(false, true)) {
                this.b = new fn0(60, this.c + 1, false);
            }
            bn0.d().f();
        }
        b();
        this.d = System.currentTimeMillis();
    }
}
