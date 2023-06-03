package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.cf2;
import com.baidu.tieba.ue2;
import com.baidu.tieba.uu2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class df2<T extends cf2> extends mj4<zk4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull zk4 zk4Var);

    public abstract void u(zk4 zk4Var, rn3 rn3Var);

    /* loaded from: classes5.dex */
    public class a implements ue2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk4 a;
        public final /* synthetic */ df2 b;

        public a(df2 df2Var, zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df2Var, zk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = df2Var;
            this.a = zk4Var;
        }

        @Override // com.baidu.tieba.ue2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.ue2.c
        public void b(PMSDownloadType pMSDownloadType, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rn3Var) == null) {
                this.b.u(this.a, rn3Var);
            }
        }
    }

    public df2(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = t;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pj4
    /* renamed from: l */
    public String d(zk4 zk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zk4Var)) == null) {
            return uu2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zk4Var) == null) {
            r(zk4Var);
            ue2.c().b(zk4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
    /* renamed from: v */
    public void c(zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zk4Var) == null) {
            super.c(zk4Var);
            if (zk4Var != null) {
                q73.b("plugin download start: bundleId = " + zk4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
    /* renamed from: w */
    public void f(zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, zk4Var) == null) {
            super.f(zk4Var);
            if (zk4Var != null) {
                q73.b("plugin on downloading: bundleId = " + zk4Var.g);
            }
            x(zk4Var);
        }
    }

    public final void x(zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zk4Var) == null) {
            ue2.c().d(zk4Var, new a(this, zk4Var));
        }
    }

    @Override // com.baidu.tieba.rj4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(zk4 zk4Var, rn3 rn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zk4Var, rn3Var) == null) {
            u(zk4Var, rn3Var);
            ue2.c().a(zk4Var, o(), rn3Var);
        }
    }

    public PMSDownloadType o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return PMSDownloadType.PLUGIN;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
    /* renamed from: s */
    public void e(zk4 zk4Var, sk4 sk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, zk4Var, sk4Var) == null) {
            super.e(zk4Var, sk4Var);
            q73.b("plugin download error: " + sk4Var);
            rn3 rn3Var = new rn3();
            rn3Var.k(17L);
            rn3Var.i((long) sk4Var.a);
            rn3Var.d(sk4Var.b);
            rn3Var.f(sk4Var.toString());
            p(zk4Var, rn3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
    /* renamed from: t */
    public void i(zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, zk4Var) == null) {
            super.i(zk4Var);
            if (zk4Var == null) {
                q73.b("download finish, plugin is null");
                rn3 rn3Var = new rn3();
                rn3Var.k(17L);
                rn3Var.i(2201L);
                rn3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, rn3Var);
            } else if (!lp3.a(new File(zk4Var.a), zk4Var.m)) {
                cs4.M(zk4Var.a);
                q73.b("download finish, check zip sign failure");
                rn3 rn3Var2 = new rn3();
                rn3Var2.k(17L);
                rn3Var2.i(2202L);
                rn3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(zk4Var, rn3Var2);
            } else {
                File t = uu2.t(zk4Var.g, String.valueOf(zk4Var.i));
                cs4.l(t);
                if (t != null && t.exists()) {
                    boolean U = cs4.U(zk4Var.a, t.getAbsolutePath());
                    cs4.M(zk4Var.a);
                    q73.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        rn3 rn3Var3 = new rn3();
                        rn3Var3.k(17L);
                        rn3Var3.i(2320L);
                        rn3Var3.d("plugin unzip fail.");
                        p(zk4Var, rn3Var3);
                        return;
                    }
                    zk4Var.c = zk4Var.b();
                    zk4Var.d = zk4Var.b();
                    vj4.i().m(zk4Var);
                    q(zk4Var);
                    return;
                }
                cs4.M(zk4Var.a);
                q73.b("download finish, create file failure, name = " + zk4Var.g + " ; version = " + zk4Var.i);
                rn3 rn3Var4 = new rn3();
                rn3Var4.k(17L);
                rn3Var4.i(2203L);
                rn3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(zk4Var, rn3Var4);
            }
        }
    }
}
