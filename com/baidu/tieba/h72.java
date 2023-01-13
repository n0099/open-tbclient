package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public abstract class h72 extends n72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public rh4 d;
    public cg3 e;
    public final ac4<kd4> f;

    public abstract void Q(@NonNull cg3 cg3Var);

    public abstract void R();

    /* loaded from: classes4.dex */
    public class a extends o72<h72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h72 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h72 h72Var, h72 h72Var2) {
            super(h72Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h72Var, h72Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((n72) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h72Var;
        }

        @Override // com.baidu.tieba.o72
        public void u(kd4 kd4Var, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kd4Var, cg3Var) == null) {
                j12.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + kd4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + cg3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = cg3Var;
            }
        }

        @Override // com.baidu.tieba.o72
        public void r(@NonNull kd4 kd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kd4Var) == null) {
                if (h72.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + kd4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947776550, "Lcom/baidu/tieba/h72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947776550, "Lcom/baidu/tieba/h72;");
                return;
            }
        }
        g = tk1.a;
    }

    public h72() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new AtomicInteger(0);
        this.f = new a(this, this);
    }

    @Override // com.baidu.tieba.ec4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            j12.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            cg3 cg3Var = new cg3();
            cg3Var.k(17L);
            cg3Var.i(2901L);
            cg3Var.d("Server无包");
            Q(cg3Var);
        }
    }

    @Override // com.baidu.tieba.ec4
    public ac4<kd4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (ac4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec4
    public void C(dd4 dd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dd4Var) == null) {
            super.C(dd4Var);
            j12.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + dd4Var.toString());
            cg3 cg3Var = new cg3();
            cg3Var.k(17L);
            cg3Var.c(dd4Var);
            Q(cg3Var);
        }
    }

    @Override // com.baidu.tieba.ec4
    public void G(rh4 rh4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rh4Var) == null) {
            super.G(rh4Var);
            this.d = rh4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (rh4Var == null) {
                    n = 0;
                } else {
                    n = rh4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.ec4, com.baidu.tieba.bc4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            j12.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            rh4 rh4Var = this.d;
            if (rh4Var == null) {
                cg3 cg3Var = new cg3();
                cg3Var.k(17L);
                cg3Var.i(2900L);
                cg3Var.d("unknown error.");
                Q(cg3Var);
                return;
            }
            int n = rh4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                cg3 cg3Var2 = new cg3();
                cg3Var2.k(17L);
                cg3Var2.i(2900L);
                cg3Var2.d("unknown error.");
                this.e = cg3Var2;
            }
            cg3 cg3Var3 = this.e;
            cg3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
