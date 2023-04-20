package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ra2;
import com.baidu.tieba.rq2;
import com.baidu.tieba.za2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class ab2<T extends za2> extends jf4<wg4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull wg4 wg4Var);

    public abstract void u(wg4 wg4Var, oj3 oj3Var);

    /* loaded from: classes3.dex */
    public class a implements ra2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg4 a;
        public final /* synthetic */ ab2 b;

        public a(ab2 ab2Var, wg4 wg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab2Var, wg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ab2Var;
            this.a = wg4Var;
        }

        @Override // com.baidu.tieba.ra2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.ra2.c
        public void b(PMSDownloadType pMSDownloadType, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, oj3Var) == null) {
                this.b.u(this.a, oj3Var);
            }
        }
    }

    public ab2(@NonNull T t) {
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
    @Override // com.baidu.tieba.mf4
    /* renamed from: l */
    public String d(wg4 wg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wg4Var)) == null) {
            return rq2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull wg4 wg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wg4Var) == null) {
            r(wg4Var);
            ra2.c().b(wg4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
    /* renamed from: v */
    public void c(wg4 wg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, wg4Var) == null) {
            super.c(wg4Var);
            if (wg4Var != null) {
                n33.b("plugin download start: bundleId = " + wg4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
    /* renamed from: w */
    public void f(wg4 wg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, wg4Var) == null) {
            super.f(wg4Var);
            if (wg4Var != null) {
                n33.b("plugin on downloading: bundleId = " + wg4Var.g);
            }
            x(wg4Var);
        }
    }

    public final void x(wg4 wg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, wg4Var) == null) {
            ra2.c().d(wg4Var, new a(this, wg4Var));
        }
    }

    @Override // com.baidu.tieba.of4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(wg4 wg4Var, oj3 oj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wg4Var, oj3Var) == null) {
            u(wg4Var, oj3Var);
            ra2.c().a(wg4Var, o(), oj3Var);
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
    @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
    /* renamed from: s */
    public void e(wg4 wg4Var, pg4 pg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, wg4Var, pg4Var) == null) {
            super.e(wg4Var, pg4Var);
            n33.b("plugin download error: " + pg4Var);
            oj3 oj3Var = new oj3();
            oj3Var.k(17L);
            oj3Var.i((long) pg4Var.a);
            oj3Var.d(pg4Var.b);
            oj3Var.f(pg4Var.toString());
            p(wg4Var, oj3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
    /* renamed from: t */
    public void i(wg4 wg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, wg4Var) == null) {
            super.i(wg4Var);
            if (wg4Var == null) {
                n33.b("download finish, plugin is null");
                oj3 oj3Var = new oj3();
                oj3Var.k(17L);
                oj3Var.i(2201L);
                oj3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, oj3Var);
            } else if (!il3.a(new File(wg4Var.a), wg4Var.m)) {
                zn4.M(wg4Var.a);
                n33.b("download finish, check zip sign failure");
                oj3 oj3Var2 = new oj3();
                oj3Var2.k(17L);
                oj3Var2.i(2202L);
                oj3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(wg4Var, oj3Var2);
            } else {
                File t = rq2.t(wg4Var.g, String.valueOf(wg4Var.i));
                zn4.l(t);
                if (t != null && t.exists()) {
                    boolean U = zn4.U(wg4Var.a, t.getAbsolutePath());
                    zn4.M(wg4Var.a);
                    n33.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        oj3 oj3Var3 = new oj3();
                        oj3Var3.k(17L);
                        oj3Var3.i(2320L);
                        oj3Var3.d("plugin unzip fail.");
                        p(wg4Var, oj3Var3);
                        return;
                    }
                    wg4Var.c = wg4Var.b();
                    wg4Var.d = wg4Var.b();
                    sf4.i().m(wg4Var);
                    q(wg4Var);
                    return;
                }
                zn4.M(wg4Var.a);
                n33.b("download finish, create file failure, name = " + wg4Var.g + " ; version = " + wg4Var.i);
                oj3 oj3Var4 = new oj3();
                oj3Var4.k(17L);
                oj3Var4.i(2203L);
                oj3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(wg4Var, oj3Var4);
            }
        }
    }
}
