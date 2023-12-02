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
/* loaded from: classes6.dex */
public abstract class i92 extends o92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public sj4 d;
    public di3 e;
    public final be4<lf4> f;

    public abstract void Q(@NonNull di3 di3Var);

    public abstract void R();

    /* loaded from: classes6.dex */
    public class a extends p92<i92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i92 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i92 i92Var, i92 i92Var2) {
            super(i92Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i92Var, i92Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((o92) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i92Var;
        }

        @Override // com.baidu.tieba.p92
        public void u(lf4 lf4Var, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lf4Var, di3Var) == null) {
                k32.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + lf4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + di3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = di3Var;
            }
        }

        @Override // com.baidu.tieba.p92
        public void r(@NonNull lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lf4Var) == null) {
                if (i92.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + lf4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947808263, "Lcom/baidu/tieba/i92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947808263, "Lcom/baidu/tieba/i92;");
                return;
            }
        }
        g = vm1.a;
    }

    public i92() {
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

    @Override // com.baidu.tieba.fe4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            k32.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            di3 di3Var = new di3();
            di3Var.k(17L);
            di3Var.i(2901L);
            di3Var.d("Server无包");
            Q(di3Var);
        }
    }

    @Override // com.baidu.tieba.fe4
    public be4<lf4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (be4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public void C(ef4 ef4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ef4Var) == null) {
            super.C(ef4Var);
            k32.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + ef4Var.toString());
            di3 di3Var = new di3();
            di3Var.k(17L);
            di3Var.c(ef4Var);
            Q(di3Var);
        }
    }

    @Override // com.baidu.tieba.fe4
    public void G(sj4 sj4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sj4Var) == null) {
            super.G(sj4Var);
            this.d = sj4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (sj4Var == null) {
                    n = 0;
                } else {
                    n = sj4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.fe4, com.baidu.tieba.ce4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            k32.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            sj4 sj4Var = this.d;
            if (sj4Var == null) {
                di3 di3Var = new di3();
                di3Var.k(17L);
                di3Var.i(2900L);
                di3Var.d("unknown error.");
                Q(di3Var);
                return;
            }
            int n = sj4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                di3 di3Var2 = new di3();
                di3Var2.k(17L);
                di3Var2.i(2900L);
                di3Var2.d("unknown error.");
                this.e = di3Var2;
            }
            di3 di3Var3 = this.e;
            di3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
