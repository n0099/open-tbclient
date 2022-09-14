package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.c62;
import com.baidu.tieba.u52;
import com.baidu.tieba.ul2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class d62<T extends c62> extends ma4<zb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    /* loaded from: classes3.dex */
    public class a implements u52.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zb4 a;
        public final /* synthetic */ d62 b;

        public a(d62 d62Var, zb4 zb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d62Var, zb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d62Var;
            this.a = zb4Var;
        }

        @Override // com.baidu.tieba.u52.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.u52.c
        public void b(PMSDownloadType pMSDownloadType, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, re3Var) == null) {
                this.b.u(this.a, re3Var);
            }
        }
    }

    public d62(@NonNull T t) {
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
    @Override // com.baidu.tieba.pa4
    /* renamed from: l */
    public String d(zb4 zb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zb4Var)) == null) ? ul2.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ra4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
    }

    public PMSDownloadType o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? PMSDownloadType.PLUGIN : (PMSDownloadType) invokeV.objValue;
    }

    public final void p(zb4 zb4Var, re3 re3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zb4Var, re3Var) == null) {
            u(zb4Var, re3Var);
            u52.c().a(zb4Var, o(), re3Var);
        }
    }

    public final void q(@NonNull zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zb4Var) == null) {
            r(zb4Var);
            u52.c().b(zb4Var, o());
        }
    }

    public abstract void r(@NonNull zb4 zb4Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
    /* renamed from: s */
    public void e(zb4 zb4Var, sb4 sb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, zb4Var, sb4Var) == null) {
            super.e(zb4Var, sb4Var);
            qy2.b("plugin download error: " + sb4Var);
            re3 re3Var = new re3();
            re3Var.k(17L);
            re3Var.i((long) sb4Var.a);
            re3Var.d(sb4Var.b);
            re3Var.f(sb4Var.toString());
            p(zb4Var, re3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
    /* renamed from: t */
    public void i(zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, zb4Var) == null) {
            super.i(zb4Var);
            if (zb4Var == null) {
                qy2.b("download finish, plugin is null");
                re3 re3Var = new re3();
                re3Var.k(17L);
                re3Var.i(2201L);
                re3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, re3Var);
            } else if (!lg3.a(new File(zb4Var.a), zb4Var.m)) {
                cj4.M(zb4Var.a);
                qy2.b("download finish, check zip sign failure");
                re3 re3Var2 = new re3();
                re3Var2.k(17L);
                re3Var2.i(2202L);
                re3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(zb4Var, re3Var2);
            } else {
                File t = ul2.t(zb4Var.g, String.valueOf(zb4Var.i));
                cj4.l(t);
                if (t != null && t.exists()) {
                    boolean U = cj4.U(zb4Var.a, t.getAbsolutePath());
                    cj4.M(zb4Var.a);
                    qy2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        re3 re3Var3 = new re3();
                        re3Var3.k(17L);
                        re3Var3.i(2320L);
                        re3Var3.d("plugin unzip fail.");
                        p(zb4Var, re3Var3);
                        return;
                    }
                    zb4Var.c = zb4Var.b();
                    zb4Var.d = zb4Var.b();
                    va4.i().m(zb4Var);
                    q(zb4Var);
                    return;
                }
                cj4.M(zb4Var.a);
                qy2.b("download finish, create file failure, name = " + zb4Var.g + " ; version = " + zb4Var.i);
                re3 re3Var4 = new re3();
                re3Var4.k(17L);
                re3Var4.i(2203L);
                re3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(zb4Var, re3Var4);
            }
        }
    }

    public abstract void u(zb4 zb4Var, re3 re3Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
    /* renamed from: v */
    public void c(zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zb4Var) == null) {
            super.c(zb4Var);
            if (zb4Var != null) {
                qy2.b("plugin download start: bundleId = " + zb4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
    /* renamed from: w */
    public void f(zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, zb4Var) == null) {
            super.f(zb4Var);
            if (zb4Var != null) {
                qy2.b("plugin on downloading: bundleId = " + zb4Var.g);
            }
            x(zb4Var);
        }
    }

    public final void x(zb4 zb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zb4Var) == null) {
            u52.c().d(zb4Var, new a(this, zb4Var));
        }
    }
}
