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
public abstract class be2 extends he2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public lo4 d;
    public wm3 e;
    public final ui4<ek4> f;

    public abstract void Q(@NonNull wm3 wm3Var);

    public abstract void R();

    /* loaded from: classes5.dex */
    public class a extends ie2<be2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ be2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(be2 be2Var, be2 be2Var2) {
            super(be2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be2Var, be2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((he2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = be2Var;
        }

        @Override // com.baidu.tieba.ie2
        public void u(ek4 ek4Var, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ek4Var, wm3Var) == null) {
                d82.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + ek4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + wm3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = wm3Var;
            }
        }

        @Override // com.baidu.tieba.ie2
        public void r(@NonNull ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ek4Var) == null) {
                if (be2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + ek4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947642010, "Lcom/baidu/tieba/be2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947642010, "Lcom/baidu/tieba/be2;");
                return;
            }
        }
        g = nr1.a;
    }

    public be2() {
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

    @Override // com.baidu.tieba.yi4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            d82.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            wm3 wm3Var = new wm3();
            wm3Var.k(17L);
            wm3Var.i(2901L);
            wm3Var.d("Server无包");
            Q(wm3Var);
        }
    }

    @Override // com.baidu.tieba.yi4
    public ui4<ek4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (ui4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public void C(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xj4Var) == null) {
            super.C(xj4Var);
            d82.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + xj4Var.toString());
            wm3 wm3Var = new wm3();
            wm3Var.k(17L);
            wm3Var.c(xj4Var);
            Q(wm3Var);
        }
    }

    @Override // com.baidu.tieba.yi4
    public void G(lo4 lo4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lo4Var) == null) {
            super.G(lo4Var);
            this.d = lo4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (lo4Var == null) {
                    n = 0;
                } else {
                    n = lo4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.yi4, com.baidu.tieba.vi4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            d82.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            lo4 lo4Var = this.d;
            if (lo4Var == null) {
                wm3 wm3Var = new wm3();
                wm3Var.k(17L);
                wm3Var.i(2900L);
                wm3Var.d("unknown error.");
                Q(wm3Var);
                return;
            }
            int n = lo4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                wm3 wm3Var2 = new wm3();
                wm3Var2.k(17L);
                wm3Var2.i(2900L);
                wm3Var2.d("unknown error.");
                this.e = wm3Var2;
            }
            wm3 wm3Var3 = this.e;
            wm3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
