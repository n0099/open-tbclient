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
public abstract class af2 extends gf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public kp4 d;
    public vn3 e;
    public final tj4<dl4> f;

    public abstract void Q(@NonNull vn3 vn3Var);

    public abstract void R();

    /* loaded from: classes5.dex */
    public class a extends hf2<af2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(af2 af2Var, af2 af2Var2) {
            super(af2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af2Var, af2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((gf2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = af2Var;
        }

        @Override // com.baidu.tieba.hf2
        public void u(dl4 dl4Var, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dl4Var, vn3Var) == null) {
                c92.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + dl4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + vn3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = vn3Var;
            }
        }

        @Override // com.baidu.tieba.hf2
        public void r(@NonNull dl4 dl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dl4Var) == null) {
                if (af2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + dl4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947613180, "Lcom/baidu/tieba/af2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947613180, "Lcom/baidu/tieba/af2;");
                return;
            }
        }
        g = ms1.a;
    }

    public af2() {
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

    @Override // com.baidu.tieba.xj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            c92.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            vn3 vn3Var = new vn3();
            vn3Var.k(17L);
            vn3Var.i(2901L);
            vn3Var.d("Server无包");
            Q(vn3Var);
        }
    }

    @Override // com.baidu.tieba.xj4
    public tj4<dl4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (tj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj4
    public void C(wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wk4Var) == null) {
            super.C(wk4Var);
            c92.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + wk4Var.toString());
            vn3 vn3Var = new vn3();
            vn3Var.k(17L);
            vn3Var.c(wk4Var);
            Q(vn3Var);
        }
    }

    @Override // com.baidu.tieba.xj4
    public void G(kp4 kp4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kp4Var) == null) {
            super.G(kp4Var);
            this.d = kp4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (kp4Var == null) {
                    n = 0;
                } else {
                    n = kp4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.xj4, com.baidu.tieba.uj4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            c92.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            kp4 kp4Var = this.d;
            if (kp4Var == null) {
                vn3 vn3Var = new vn3();
                vn3Var.k(17L);
                vn3Var.i(2900L);
                vn3Var.d("unknown error.");
                Q(vn3Var);
                return;
            }
            int n = kp4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                vn3 vn3Var2 = new vn3();
                vn3Var2.k(17L);
                vn3Var2.i(2900L);
                vn3Var2.d("unknown error.");
                this.e = vn3Var2;
            }
            vn3 vn3Var3 = this.e;
            vn3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
