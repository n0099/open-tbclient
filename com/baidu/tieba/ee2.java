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
/* loaded from: classes5.dex */
public abstract class ee2 extends ke2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public oo4 d;
    public zm3 e;
    public final xi4<hk4> f;

    public abstract void Q(@NonNull zm3 zm3Var);

    public abstract void R();

    /* loaded from: classes5.dex */
    public class a extends le2<ee2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ee2 ee2Var, ee2 ee2Var2) {
            super(ee2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee2Var, ee2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ke2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ee2Var;
        }

        @Override // com.baidu.tieba.le2
        public void u(hk4 hk4Var, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hk4Var, zm3Var) == null) {
                g82.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + hk4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + zm3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = zm3Var;
            }
        }

        @Override // com.baidu.tieba.le2
        public void r(@NonNull hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hk4Var) == null) {
                if (ee2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + hk4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731383, "Lcom/baidu/tieba/ee2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731383, "Lcom/baidu/tieba/ee2;");
                return;
            }
        }
        g = qr1.a;
    }

    public ee2() {
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

    @Override // com.baidu.tieba.bj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            g82.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            zm3 zm3Var = new zm3();
            zm3Var.k(17L);
            zm3Var.i(2901L);
            zm3Var.d("Server无包");
            Q(zm3Var);
        }
    }

    @Override // com.baidu.tieba.bj4
    public xi4<hk4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (xi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public void C(ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ak4Var) == null) {
            super.C(ak4Var);
            g82.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + ak4Var.toString());
            zm3 zm3Var = new zm3();
            zm3Var.k(17L);
            zm3Var.c(ak4Var);
            Q(zm3Var);
        }
    }

    @Override // com.baidu.tieba.bj4
    public void G(oo4 oo4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oo4Var) == null) {
            super.G(oo4Var);
            this.d = oo4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (oo4Var == null) {
                    n = 0;
                } else {
                    n = oo4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.bj4, com.baidu.tieba.yi4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            g82.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            oo4 oo4Var = this.d;
            if (oo4Var == null) {
                zm3 zm3Var = new zm3();
                zm3Var.k(17L);
                zm3Var.i(2900L);
                zm3Var.d("unknown error.");
                Q(zm3Var);
                return;
            }
            int n = oo4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                zm3 zm3Var2 = new zm3();
                zm3Var2.k(17L);
                zm3Var2.i(2900L);
                zm3Var2.d("unknown error.");
                this.e = zm3Var2;
            }
            zm3 zm3Var3 = this.e;
            zm3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
