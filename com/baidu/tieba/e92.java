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
public abstract class e92 extends k92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public oj4 d;
    public zh3 e;
    public final xd4<hf4> f;

    public abstract void Q(@NonNull zh3 zh3Var);

    public abstract void R();

    /* loaded from: classes5.dex */
    public class a extends l92<e92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e92 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e92 e92Var, e92 e92Var2) {
            super(e92Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e92Var, e92Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((k92) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e92Var;
        }

        @Override // com.baidu.tieba.l92
        public void u(hf4 hf4Var, zh3 zh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hf4Var, zh3Var) == null) {
                g32.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + hf4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + zh3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = zh3Var;
            }
        }

        @Override // com.baidu.tieba.l92
        public void r(@NonNull hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hf4Var) == null) {
                if (e92.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + hf4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947689099, "Lcom/baidu/tieba/e92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947689099, "Lcom/baidu/tieba/e92;");
                return;
            }
        }
        g = rm1.a;
    }

    public e92() {
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

    @Override // com.baidu.tieba.be4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            g32.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            zh3 zh3Var = new zh3();
            zh3Var.k(17L);
            zh3Var.i(2901L);
            zh3Var.d("Server无包");
            Q(zh3Var);
        }
    }

    @Override // com.baidu.tieba.be4
    public xd4<hf4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (xd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.be4
    public void C(af4 af4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, af4Var) == null) {
            super.C(af4Var);
            g32.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + af4Var.toString());
            zh3 zh3Var = new zh3();
            zh3Var.k(17L);
            zh3Var.c(af4Var);
            Q(zh3Var);
        }
    }

    @Override // com.baidu.tieba.be4
    public void G(oj4 oj4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oj4Var) == null) {
            super.G(oj4Var);
            this.d = oj4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (oj4Var == null) {
                    n = 0;
                } else {
                    n = oj4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.be4, com.baidu.tieba.yd4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            g32.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            oj4 oj4Var = this.d;
            if (oj4Var == null) {
                zh3 zh3Var = new zh3();
                zh3Var.k(17L);
                zh3Var.i(2900L);
                zh3Var.d("unknown error.");
                Q(zh3Var);
                return;
            }
            int n = oj4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                zh3 zh3Var2 = new zh3();
                zh3Var2.k(17L);
                zh3Var2.i(2900L);
                zh3Var2.d("unknown error.");
                this.e = zh3Var2;
            }
            zh3 zh3Var3 = this.e;
            zh3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
