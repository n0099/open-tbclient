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
public abstract class fe2 extends le2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public po4 d;
    public an3 e;
    public final yi4<ik4> f;

    public abstract void Q(@NonNull an3 an3Var);

    public abstract void R();

    /* loaded from: classes5.dex */
    public class a extends me2<fe2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fe2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fe2 fe2Var, fe2 fe2Var2) {
            super(fe2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe2Var, fe2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((le2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fe2Var;
        }

        @Override // com.baidu.tieba.me2
        public void u(ik4 ik4Var, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ik4Var, an3Var) == null) {
                h82.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + ik4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + an3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = an3Var;
            }
        }

        @Override // com.baidu.tieba.me2
        public void r(@NonNull ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ik4Var) == null) {
                if (fe2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + ik4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947761174, "Lcom/baidu/tieba/fe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947761174, "Lcom/baidu/tieba/fe2;");
                return;
            }
        }
        g = rr1.a;
    }

    public fe2() {
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

    @Override // com.baidu.tieba.cj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            h82.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            an3 an3Var = new an3();
            an3Var.k(17L);
            an3Var.i(2901L);
            an3Var.d("Server无包");
            Q(an3Var);
        }
    }

    @Override // com.baidu.tieba.cj4
    public yi4<ik4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public void C(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bk4Var) == null) {
            super.C(bk4Var);
            h82.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + bk4Var.toString());
            an3 an3Var = new an3();
            an3Var.k(17L);
            an3Var.c(bk4Var);
            Q(an3Var);
        }
    }

    @Override // com.baidu.tieba.cj4
    public void G(po4 po4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, po4Var) == null) {
            super.G(po4Var);
            this.d = po4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (po4Var == null) {
                    n = 0;
                } else {
                    n = po4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.cj4, com.baidu.tieba.zi4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            h82.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            po4 po4Var = this.d;
            if (po4Var == null) {
                an3 an3Var = new an3();
                an3Var.k(17L);
                an3Var.i(2900L);
                an3Var.d("unknown error.");
                Q(an3Var);
                return;
            }
            int n = po4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                an3 an3Var2 = new an3();
                an3Var2.k(17L);
                an3Var2.i(2900L);
                an3Var2.d("unknown error.");
                this.e = an3Var2;
            }
            an3 an3Var3 = this.e;
            an3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
