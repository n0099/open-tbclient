package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.re2;
import com.baidu.tieba.ru2;
import com.baidu.tieba.ze2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class af2<T extends ze2> extends jj4<wk4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull wk4 wk4Var);

    public abstract void u(wk4 wk4Var, on3 on3Var);

    /* loaded from: classes5.dex */
    public class a implements re2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wk4 a;
        public final /* synthetic */ af2 b;

        public a(af2 af2Var, wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af2Var, wk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = af2Var;
            this.a = wk4Var;
        }

        @Override // com.baidu.tieba.re2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.re2.c
        public void b(PMSDownloadType pMSDownloadType, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, on3Var) == null) {
                this.b.u(this.a, on3Var);
            }
        }
    }

    public af2(@NonNull T t) {
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
    @Override // com.baidu.tieba.mj4
    /* renamed from: l */
    public String d(wk4 wk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wk4Var)) == null) {
            return ru2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wk4Var) == null) {
            r(wk4Var);
            re2.c().b(wk4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
    /* renamed from: v */
    public void c(wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, wk4Var) == null) {
            super.c(wk4Var);
            if (wk4Var != null) {
                n73.b("plugin download start: bundleId = " + wk4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
    /* renamed from: w */
    public void f(wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, wk4Var) == null) {
            super.f(wk4Var);
            if (wk4Var != null) {
                n73.b("plugin on downloading: bundleId = " + wk4Var.g);
            }
            x(wk4Var);
        }
    }

    public final void x(wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, wk4Var) == null) {
            re2.c().d(wk4Var, new a(this, wk4Var));
        }
    }

    @Override // com.baidu.tieba.oj4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(wk4 wk4Var, on3 on3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wk4Var, on3Var) == null) {
            u(wk4Var, on3Var);
            re2.c().a(wk4Var, o(), on3Var);
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
    @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
    /* renamed from: s */
    public void e(wk4 wk4Var, pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, wk4Var, pk4Var) == null) {
            super.e(wk4Var, pk4Var);
            n73.b("plugin download error: " + pk4Var);
            on3 on3Var = new on3();
            on3Var.k(17L);
            on3Var.i((long) pk4Var.a);
            on3Var.d(pk4Var.b);
            on3Var.f(pk4Var.toString());
            p(wk4Var, on3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
    /* renamed from: t */
    public void i(wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, wk4Var) == null) {
            super.i(wk4Var);
            if (wk4Var == null) {
                n73.b("download finish, plugin is null");
                on3 on3Var = new on3();
                on3Var.k(17L);
                on3Var.i(2201L);
                on3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, on3Var);
            } else if (!ip3.a(new File(wk4Var.a), wk4Var.m)) {
                zr4.M(wk4Var.a);
                n73.b("download finish, check zip sign failure");
                on3 on3Var2 = new on3();
                on3Var2.k(17L);
                on3Var2.i(2202L);
                on3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(wk4Var, on3Var2);
            } else {
                File t = ru2.t(wk4Var.g, String.valueOf(wk4Var.i));
                zr4.l(t);
                if (t != null && t.exists()) {
                    boolean U = zr4.U(wk4Var.a, t.getAbsolutePath());
                    zr4.M(wk4Var.a);
                    n73.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        on3 on3Var3 = new on3();
                        on3Var3.k(17L);
                        on3Var3.i(2320L);
                        on3Var3.d("plugin unzip fail.");
                        p(wk4Var, on3Var3);
                        return;
                    }
                    wk4Var.c = wk4Var.b();
                    wk4Var.d = wk4Var.b();
                    sj4.i().m(wk4Var);
                    q(wk4Var);
                    return;
                }
                zr4.M(wk4Var.a);
                n73.b("download finish, create file failure, name = " + wk4Var.g + " ; version = " + wk4Var.i);
                on3 on3Var4 = new on3();
                on3Var4.k(17L);
                on3Var4.i(2203L);
                on3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(wk4Var, on3Var4);
            }
        }
    }
}
