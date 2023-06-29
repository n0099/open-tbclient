package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.gf2;
import com.baidu.tieba.ye2;
import com.baidu.tieba.yu2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class hf2<T extends gf2> extends qj4<dl4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull dl4 dl4Var);

    public abstract void u(dl4 dl4Var, vn3 vn3Var);

    /* loaded from: classes6.dex */
    public class a implements ye2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl4 a;
        public final /* synthetic */ hf2 b;

        public a(hf2 hf2Var, dl4 dl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf2Var, dl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hf2Var;
            this.a = dl4Var;
        }

        @Override // com.baidu.tieba.ye2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.ye2.c
        public void b(PMSDownloadType pMSDownloadType, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, vn3Var) == null) {
                this.b.u(this.a, vn3Var);
            }
        }
    }

    public hf2(@NonNull T t) {
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
    @Override // com.baidu.tieba.tj4
    /* renamed from: l */
    public String d(dl4 dl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dl4Var)) == null) {
            return yu2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dl4Var) == null) {
            r(dl4Var);
            ye2.c().b(dl4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
    /* renamed from: v */
    public void c(dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dl4Var) == null) {
            super.c(dl4Var);
            if (dl4Var != null) {
                u73.b("plugin download start: bundleId = " + dl4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
    /* renamed from: w */
    public void f(dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dl4Var) == null) {
            super.f(dl4Var);
            if (dl4Var != null) {
                u73.b("plugin on downloading: bundleId = " + dl4Var.g);
            }
            x(dl4Var);
        }
    }

    public final void x(dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dl4Var) == null) {
            ye2.c().d(dl4Var, new a(this, dl4Var));
        }
    }

    @Override // com.baidu.tieba.vj4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(dl4 dl4Var, vn3 vn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dl4Var, vn3Var) == null) {
            u(dl4Var, vn3Var);
            ye2.c().a(dl4Var, o(), vn3Var);
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
    @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
    /* renamed from: s */
    public void e(dl4 dl4Var, wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, dl4Var, wk4Var) == null) {
            super.e(dl4Var, wk4Var);
            u73.b("plugin download error: " + wk4Var);
            vn3 vn3Var = new vn3();
            vn3Var.k(17L);
            vn3Var.i((long) wk4Var.a);
            vn3Var.d(wk4Var.b);
            vn3Var.f(wk4Var.toString());
            p(dl4Var, vn3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
    /* renamed from: t */
    public void i(dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dl4Var) == null) {
            super.i(dl4Var);
            if (dl4Var == null) {
                u73.b("download finish, plugin is null");
                vn3 vn3Var = new vn3();
                vn3Var.k(17L);
                vn3Var.i(2201L);
                vn3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, vn3Var);
            } else if (!pp3.a(new File(dl4Var.a), dl4Var.m)) {
                gs4.M(dl4Var.a);
                u73.b("download finish, check zip sign failure");
                vn3 vn3Var2 = new vn3();
                vn3Var2.k(17L);
                vn3Var2.i(2202L);
                vn3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(dl4Var, vn3Var2);
            } else {
                File t = yu2.t(dl4Var.g, String.valueOf(dl4Var.i));
                gs4.l(t);
                if (t != null && t.exists()) {
                    boolean U = gs4.U(dl4Var.a, t.getAbsolutePath());
                    gs4.M(dl4Var.a);
                    u73.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        vn3 vn3Var3 = new vn3();
                        vn3Var3.k(17L);
                        vn3Var3.i(2320L);
                        vn3Var3.d("plugin unzip fail.");
                        p(dl4Var, vn3Var3);
                        return;
                    }
                    dl4Var.c = dl4Var.b();
                    dl4Var.d = dl4Var.b();
                    zj4.i().m(dl4Var);
                    q(dl4Var);
                    return;
                }
                gs4.M(dl4Var.a);
                u73.b("download finish, create file failure, name = " + dl4Var.g + " ; version = " + dl4Var.i);
                vn3 vn3Var4 = new vn3();
                vn3Var4.k(17L);
                vn3Var4.i(2203L);
                vn3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(dl4Var, vn3Var4);
            }
        }
    }
}
