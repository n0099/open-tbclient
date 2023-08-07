package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ce2;
import com.baidu.tieba.ud2;
import com.baidu.tieba.ut2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class de2<T extends ce2> extends mi4<zj4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull zj4 zj4Var);

    public abstract void u(zj4 zj4Var, rm3 rm3Var);

    /* loaded from: classes5.dex */
    public class a implements ud2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zj4 a;
        public final /* synthetic */ de2 b;

        public a(de2 de2Var, zj4 zj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {de2Var, zj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = de2Var;
            this.a = zj4Var;
        }

        @Override // com.baidu.tieba.ud2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.ud2.c
        public void b(PMSDownloadType pMSDownloadType, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rm3Var) == null) {
                this.b.u(this.a, rm3Var);
            }
        }
    }

    public de2(@NonNull T t) {
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
    @Override // com.baidu.tieba.pi4
    /* renamed from: l */
    public String d(zj4 zj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zj4Var)) == null) {
            return ut2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull zj4 zj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zj4Var) == null) {
            r(zj4Var);
            ud2.c().b(zj4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
    /* renamed from: v */
    public void c(zj4 zj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zj4Var) == null) {
            super.c(zj4Var);
            if (zj4Var != null) {
                q63.b("plugin download start: bundleId = " + zj4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
    /* renamed from: w */
    public void f(zj4 zj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, zj4Var) == null) {
            super.f(zj4Var);
            if (zj4Var != null) {
                q63.b("plugin on downloading: bundleId = " + zj4Var.g);
            }
            x(zj4Var);
        }
    }

    public final void x(zj4 zj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zj4Var) == null) {
            ud2.c().d(zj4Var, new a(this, zj4Var));
        }
    }

    @Override // com.baidu.tieba.ri4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(zj4 zj4Var, rm3 rm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zj4Var, rm3Var) == null) {
            u(zj4Var, rm3Var);
            ud2.c().a(zj4Var, o(), rm3Var);
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
    @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
    /* renamed from: s */
    public void e(zj4 zj4Var, sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, zj4Var, sj4Var) == null) {
            super.e(zj4Var, sj4Var);
            q63.b("plugin download error: " + sj4Var);
            rm3 rm3Var = new rm3();
            rm3Var.k(17L);
            rm3Var.i((long) sj4Var.a);
            rm3Var.d(sj4Var.b);
            rm3Var.f(sj4Var.toString());
            p(zj4Var, rm3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
    /* renamed from: t */
    public void i(zj4 zj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, zj4Var) == null) {
            super.i(zj4Var);
            if (zj4Var == null) {
                q63.b("download finish, plugin is null");
                rm3 rm3Var = new rm3();
                rm3Var.k(17L);
                rm3Var.i(2201L);
                rm3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, rm3Var);
            } else if (!lo3.a(new File(zj4Var.a), zj4Var.m)) {
                cr4.M(zj4Var.a);
                q63.b("download finish, check zip sign failure");
                rm3 rm3Var2 = new rm3();
                rm3Var2.k(17L);
                rm3Var2.i(2202L);
                rm3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(zj4Var, rm3Var2);
            } else {
                File t = ut2.t(zj4Var.g, String.valueOf(zj4Var.i));
                cr4.l(t);
                if (t != null && t.exists()) {
                    boolean U = cr4.U(zj4Var.a, t.getAbsolutePath());
                    cr4.M(zj4Var.a);
                    q63.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        rm3 rm3Var3 = new rm3();
                        rm3Var3.k(17L);
                        rm3Var3.i(2320L);
                        rm3Var3.d("plugin unzip fail.");
                        p(zj4Var, rm3Var3);
                        return;
                    }
                    zj4Var.c = zj4Var.b();
                    zj4Var.d = zj4Var.b();
                    vi4.i().m(zj4Var);
                    q(zj4Var);
                    return;
                }
                cr4.M(zj4Var.a);
                q63.b("download finish, create file failure, name = " + zj4Var.g + " ; version = " + zj4Var.i);
                rm3 rm3Var4 = new rm3();
                rm3Var4.k(17L);
                rm3Var4.i(2203L);
                rm3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(zj4Var, rm3Var4);
            }
        }
    }
}
