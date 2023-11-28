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
public abstract class f92 extends l92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public pj4 d;
    public ai3 e;
    public final yd4<if4> f;

    public abstract void Q(@NonNull ai3 ai3Var);

    public abstract void R();

    /* loaded from: classes5.dex */
    public class a extends m92<f92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f92 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f92 f92Var, f92 f92Var2) {
            super(f92Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f92Var, f92Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l92) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f92Var;
        }

        @Override // com.baidu.tieba.m92
        public void u(if4 if4Var, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, if4Var, ai3Var) == null) {
                h32.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + if4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ai3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = ai3Var;
            }
        }

        @Override // com.baidu.tieba.m92
        public void r(@NonNull if4 if4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, if4Var) == null) {
                if (f92.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + if4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947718890, "Lcom/baidu/tieba/f92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947718890, "Lcom/baidu/tieba/f92;");
                return;
            }
        }
        g = sm1.a;
    }

    public f92() {
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

    @Override // com.baidu.tieba.ce4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            h32.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            ai3 ai3Var = new ai3();
            ai3Var.k(17L);
            ai3Var.i(2901L);
            ai3Var.d("Server无包");
            Q(ai3Var);
        }
    }

    @Override // com.baidu.tieba.ce4
    public yd4<if4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (yd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public void C(bf4 bf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bf4Var) == null) {
            super.C(bf4Var);
            h32.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + bf4Var.toString());
            ai3 ai3Var = new ai3();
            ai3Var.k(17L);
            ai3Var.c(bf4Var);
            Q(ai3Var);
        }
    }

    @Override // com.baidu.tieba.ce4
    public void G(pj4 pj4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pj4Var) == null) {
            super.G(pj4Var);
            this.d = pj4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (pj4Var == null) {
                    n = 0;
                } else {
                    n = pj4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.ce4, com.baidu.tieba.zd4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            h32.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            pj4 pj4Var = this.d;
            if (pj4Var == null) {
                ai3 ai3Var = new ai3();
                ai3Var.k(17L);
                ai3Var.i(2900L);
                ai3Var.d("unknown error.");
                Q(ai3Var);
                return;
            }
            int n = pj4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                ai3 ai3Var2 = new ai3();
                ai3Var2.k(17L);
                ai3Var2.i(2900L);
                ai3Var2.d("unknown error.");
                this.e = ai3Var2;
            }
            ai3 ai3Var3 = this.e;
            ai3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
