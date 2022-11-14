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
/* loaded from: classes3.dex */
public abstract class d72 extends j72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public nh4 d;
    public yf3 e;
    public final wb4<gd4> f;

    public abstract void Q(@NonNull yf3 yf3Var);

    public abstract void R();

    /* loaded from: classes3.dex */
    public class a extends k72<d72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d72 d72Var, d72 d72Var2) {
            super(d72Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var, d72Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((j72) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d72Var;
        }

        @Override // com.baidu.tieba.k72
        public void u(gd4 gd4Var, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gd4Var, yf3Var) == null) {
                f12.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + gd4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + yf3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = yf3Var;
            }
        }

        @Override // com.baidu.tieba.k72
        public void r(@NonNull gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gd4Var) == null) {
                if (d72.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + gd4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947657386, "Lcom/baidu/tieba/d72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947657386, "Lcom/baidu/tieba/d72;");
                return;
            }
        }
        g = pk1.a;
    }

    public d72() {
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

    @Override // com.baidu.tieba.ac4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            f12.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            yf3 yf3Var = new yf3();
            yf3Var.k(17L);
            yf3Var.i(2901L);
            yf3Var.d("Server无包");
            Q(yf3Var);
        }
    }

    @Override // com.baidu.tieba.ac4
    public wb4<gd4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (wb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ac4
    public void C(zc4 zc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zc4Var) == null) {
            super.C(zc4Var);
            f12.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + zc4Var.toString());
            yf3 yf3Var = new yf3();
            yf3Var.k(17L);
            yf3Var.c(zc4Var);
            Q(yf3Var);
        }
    }

    @Override // com.baidu.tieba.ac4
    public void G(nh4 nh4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nh4Var) == null) {
            super.G(nh4Var);
            this.d = nh4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (nh4Var == null) {
                    n = 0;
                } else {
                    n = nh4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.ac4, com.baidu.tieba.xb4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            f12.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            nh4 nh4Var = this.d;
            if (nh4Var == null) {
                yf3 yf3Var = new yf3();
                yf3Var.k(17L);
                yf3Var.i(2900L);
                yf3Var.d("unknown error.");
                Q(yf3Var);
                return;
            }
            int n = nh4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                yf3 yf3Var2 = new yf3();
                yf3Var2.k(17L);
                yf3Var2.i(2900L);
                yf3Var2.d("unknown error.");
                this.e = yf3Var2;
            }
            yf3 yf3Var3 = this.e;
            yf3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
