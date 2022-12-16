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
public abstract class c72 extends i72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public mh4 d;
    public xf3 e;
    public final vb4<fd4> f;

    public abstract void Q(@NonNull xf3 xf3Var);

    public abstract void R();

    /* loaded from: classes3.dex */
    public class a extends j72<c72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c72 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c72 c72Var, c72 c72Var2) {
            super(c72Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c72Var, c72Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((i72) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c72Var;
        }

        @Override // com.baidu.tieba.j72
        public void u(fd4 fd4Var, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fd4Var, xf3Var) == null) {
                e12.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + fd4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + xf3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = xf3Var;
            }
        }

        @Override // com.baidu.tieba.j72
        public void r(@NonNull fd4 fd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fd4Var) == null) {
                if (c72.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + fd4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947627595, "Lcom/baidu/tieba/c72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947627595, "Lcom/baidu/tieba/c72;");
                return;
            }
        }
        g = ok1.a;
    }

    public c72() {
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

    @Override // com.baidu.tieba.zb4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            e12.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            xf3 xf3Var = new xf3();
            xf3Var.k(17L);
            xf3Var.i(2901L);
            xf3Var.d("Server无包");
            Q(xf3Var);
        }
    }

    @Override // com.baidu.tieba.zb4
    public vb4<fd4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (vb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public void C(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yc4Var) == null) {
            super.C(yc4Var);
            e12.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + yc4Var.toString());
            xf3 xf3Var = new xf3();
            xf3Var.k(17L);
            xf3Var.c(yc4Var);
            Q(xf3Var);
        }
    }

    @Override // com.baidu.tieba.zb4
    public void G(mh4 mh4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mh4Var) == null) {
            super.G(mh4Var);
            this.d = mh4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (mh4Var == null) {
                    n = 0;
                } else {
                    n = mh4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.zb4, com.baidu.tieba.wb4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            e12.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            mh4 mh4Var = this.d;
            if (mh4Var == null) {
                xf3 xf3Var = new xf3();
                xf3Var.k(17L);
                xf3Var.i(2900L);
                xf3Var.d("unknown error.");
                Q(xf3Var);
                return;
            }
            int n = mh4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                xf3 xf3Var2 = new xf3();
                xf3Var2.k(17L);
                xf3Var2.i(2900L);
                xf3Var2.d("unknown error.");
                this.e = xf3Var2;
            }
            xf3 xf3Var3 = this.e;
            xf3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
