package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.df2;
import com.baidu.tieba.ve2;
import com.baidu.tieba.vu2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class ef2<T extends df2> extends nj4<al4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull al4 al4Var);

    public abstract void u(al4 al4Var, sn3 sn3Var);

    /* loaded from: classes5.dex */
    public class a implements ve2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al4 a;
        public final /* synthetic */ ef2 b;

        public a(ef2 ef2Var, al4 al4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ef2Var, al4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ef2Var;
            this.a = al4Var;
        }

        @Override // com.baidu.tieba.ve2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.ve2.c
        public void b(PMSDownloadType pMSDownloadType, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sn3Var) == null) {
                this.b.u(this.a, sn3Var);
            }
        }
    }

    public ef2(@NonNull T t) {
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
    @Override // com.baidu.tieba.qj4
    /* renamed from: l */
    public String d(al4 al4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, al4Var)) == null) {
            return vu2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull al4 al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, al4Var) == null) {
            r(al4Var);
            ve2.c().b(al4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
    /* renamed from: v */
    public void c(al4 al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, al4Var) == null) {
            super.c(al4Var);
            if (al4Var != null) {
                r73.b("plugin download start: bundleId = " + al4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
    /* renamed from: w */
    public void f(al4 al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, al4Var) == null) {
            super.f(al4Var);
            if (al4Var != null) {
                r73.b("plugin on downloading: bundleId = " + al4Var.g);
            }
            x(al4Var);
        }
    }

    public final void x(al4 al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, al4Var) == null) {
            ve2.c().d(al4Var, new a(this, al4Var));
        }
    }

    @Override // com.baidu.tieba.sj4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(al4 al4Var, sn3 sn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, al4Var, sn3Var) == null) {
            u(al4Var, sn3Var);
            ve2.c().a(al4Var, o(), sn3Var);
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
    @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
    /* renamed from: s */
    public void e(al4 al4Var, tk4 tk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, al4Var, tk4Var) == null) {
            super.e(al4Var, tk4Var);
            r73.b("plugin download error: " + tk4Var);
            sn3 sn3Var = new sn3();
            sn3Var.k(17L);
            sn3Var.i((long) tk4Var.a);
            sn3Var.d(tk4Var.b);
            sn3Var.f(tk4Var.toString());
            p(al4Var, sn3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
    /* renamed from: t */
    public void i(al4 al4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, al4Var) == null) {
            super.i(al4Var);
            if (al4Var == null) {
                r73.b("download finish, plugin is null");
                sn3 sn3Var = new sn3();
                sn3Var.k(17L);
                sn3Var.i(2201L);
                sn3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, sn3Var);
            } else if (!mp3.a(new File(al4Var.a), al4Var.m)) {
                ds4.M(al4Var.a);
                r73.b("download finish, check zip sign failure");
                sn3 sn3Var2 = new sn3();
                sn3Var2.k(17L);
                sn3Var2.i(2202L);
                sn3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(al4Var, sn3Var2);
            } else {
                File t = vu2.t(al4Var.g, String.valueOf(al4Var.i));
                ds4.l(t);
                if (t != null && t.exists()) {
                    boolean U = ds4.U(al4Var.a, t.getAbsolutePath());
                    ds4.M(al4Var.a);
                    r73.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        sn3 sn3Var3 = new sn3();
                        sn3Var3.k(17L);
                        sn3Var3.i(2320L);
                        sn3Var3.d("plugin unzip fail.");
                        p(al4Var, sn3Var3);
                        return;
                    }
                    al4Var.c = al4Var.b();
                    al4Var.d = al4Var.b();
                    wj4.i().m(al4Var);
                    q(al4Var);
                    return;
                }
                ds4.M(al4Var.a);
                r73.b("download finish, create file failure, name = " + al4Var.g + " ; version = " + al4Var.i);
                sn3 sn3Var4 = new sn3();
                sn3Var4.k(17L);
                sn3Var4.i(2203L);
                sn3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(al4Var, sn3Var4);
            }
        }
    }
}
