package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.he2;
import com.baidu.tieba.zd2;
import com.baidu.tieba.zt2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class ie2<T extends he2> extends ri4<ek4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull ek4 ek4Var);

    public abstract void u(ek4 ek4Var, wm3 wm3Var);

    /* loaded from: classes6.dex */
    public class a implements zd2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek4 a;
        public final /* synthetic */ ie2 b;

        public a(ie2 ie2Var, ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ie2Var, ek4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ie2Var;
            this.a = ek4Var;
        }

        @Override // com.baidu.tieba.zd2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.zd2.c
        public void b(PMSDownloadType pMSDownloadType, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, wm3Var) == null) {
                this.b.u(this.a, wm3Var);
            }
        }
    }

    public ie2(@NonNull T t) {
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
    @Override // com.baidu.tieba.ui4
    /* renamed from: l */
    public String d(ek4 ek4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ek4Var)) == null) {
            return zt2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull ek4 ek4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ek4Var) == null) {
            r(ek4Var);
            zd2.c().b(ek4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
    /* renamed from: v */
    public void c(ek4 ek4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ek4Var) == null) {
            super.c(ek4Var);
            if (ek4Var != null) {
                v63.b("plugin download start: bundleId = " + ek4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
    /* renamed from: w */
    public void f(ek4 ek4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ek4Var) == null) {
            super.f(ek4Var);
            if (ek4Var != null) {
                v63.b("plugin on downloading: bundleId = " + ek4Var.g);
            }
            x(ek4Var);
        }
    }

    public final void x(ek4 ek4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ek4Var) == null) {
            zd2.c().d(ek4Var, new a(this, ek4Var));
        }
    }

    @Override // com.baidu.tieba.wi4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(ek4 ek4Var, wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ek4Var, wm3Var) == null) {
            u(ek4Var, wm3Var);
            zd2.c().a(ek4Var, o(), wm3Var);
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
    @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
    /* renamed from: s */
    public void e(ek4 ek4Var, xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, ek4Var, xj4Var) == null) {
            super.e(ek4Var, xj4Var);
            v63.b("plugin download error: " + xj4Var);
            wm3 wm3Var = new wm3();
            wm3Var.k(17L);
            wm3Var.i((long) xj4Var.a);
            wm3Var.d(xj4Var.b);
            wm3Var.f(xj4Var.toString());
            p(ek4Var, wm3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
    /* renamed from: t */
    public void i(ek4 ek4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ek4Var) == null) {
            super.i(ek4Var);
            if (ek4Var == null) {
                v63.b("download finish, plugin is null");
                wm3 wm3Var = new wm3();
                wm3Var.k(17L);
                wm3Var.i(2201L);
                wm3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, wm3Var);
            } else if (!qo3.a(new File(ek4Var.a), ek4Var.m)) {
                hr4.M(ek4Var.a);
                v63.b("download finish, check zip sign failure");
                wm3 wm3Var2 = new wm3();
                wm3Var2.k(17L);
                wm3Var2.i(2202L);
                wm3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(ek4Var, wm3Var2);
            } else {
                File t = zt2.t(ek4Var.g, String.valueOf(ek4Var.i));
                hr4.l(t);
                if (t != null && t.exists()) {
                    boolean U = hr4.U(ek4Var.a, t.getAbsolutePath());
                    hr4.M(ek4Var.a);
                    v63.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        wm3 wm3Var3 = new wm3();
                        wm3Var3.k(17L);
                        wm3Var3.i(2320L);
                        wm3Var3.d("plugin unzip fail.");
                        p(ek4Var, wm3Var3);
                        return;
                    }
                    ek4Var.c = ek4Var.b();
                    ek4Var.d = ek4Var.b();
                    aj4.i().m(ek4Var);
                    q(ek4Var);
                    return;
                }
                hr4.M(ek4Var.a);
                v63.b("download finish, create file failure, name = " + ek4Var.g + " ; version = " + ek4Var.i);
                wm3 wm3Var4 = new wm3();
                wm3Var4.k(17L);
                wm3Var4.i(2203L);
                wm3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(ek4Var, wm3Var4);
            }
        }
    }
}
