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
public abstract class ec2 extends kc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public om4 d;
    public zk3 e;
    public final xg4<hi4> f;

    public abstract void Q(@NonNull zk3 zk3Var);

    public abstract void R();

    /* loaded from: classes5.dex */
    public class a extends lc2<ec2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ec2 ec2Var, ec2 ec2Var2) {
            super(ec2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec2Var, ec2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((kc2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ec2Var;
        }

        @Override // com.baidu.tieba.lc2
        public void u(hi4 hi4Var, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hi4Var, zk3Var) == null) {
                g62.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + hi4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + zk3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = zk3Var;
            }
        }

        @Override // com.baidu.tieba.lc2
        public void r(@NonNull hi4 hi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hi4Var) == null) {
                if (ec2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + hi4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947729461, "Lcom/baidu/tieba/ec2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947729461, "Lcom/baidu/tieba/ec2;");
                return;
            }
        }
        g = qp1.a;
    }

    public ec2() {
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

    @Override // com.baidu.tieba.bh4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            g62.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            zk3 zk3Var = new zk3();
            zk3Var.k(17L);
            zk3Var.i(2901L);
            zk3Var.d("Server无包");
            Q(zk3Var);
        }
    }

    @Override // com.baidu.tieba.bh4
    public xg4<hi4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (xg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public void C(ai4 ai4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ai4Var) == null) {
            super.C(ai4Var);
            g62.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + ai4Var.toString());
            zk3 zk3Var = new zk3();
            zk3Var.k(17L);
            zk3Var.c(ai4Var);
            Q(zk3Var);
        }
    }

    @Override // com.baidu.tieba.bh4
    public void G(om4 om4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, om4Var) == null) {
            super.G(om4Var);
            this.d = om4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (om4Var == null) {
                    n = 0;
                } else {
                    n = om4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.bh4, com.baidu.tieba.yg4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            g62.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            om4 om4Var = this.d;
            if (om4Var == null) {
                zk3 zk3Var = new zk3();
                zk3Var.k(17L);
                zk3Var.i(2900L);
                zk3Var.d("unknown error.");
                Q(zk3Var);
                return;
            }
            int n = om4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                zk3 zk3Var2 = new zk3();
                zk3Var2.k(17L);
                zk3Var2.i(2900L);
                zk3Var2.d("unknown error.");
                this.e = zk3Var2;
            }
            zk3 zk3Var3 = this.e;
            zk3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
