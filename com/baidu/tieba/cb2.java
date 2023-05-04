package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.bb2;
import com.baidu.tieba.ta2;
import com.baidu.tieba.tq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class cb2<T extends bb2> extends lf4<yg4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull yg4 yg4Var);

    public abstract void u(yg4 yg4Var, qj3 qj3Var);

    /* loaded from: classes3.dex */
    public class a implements ta2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg4 a;
        public final /* synthetic */ cb2 b;

        public a(cb2 cb2Var, yg4 yg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb2Var, yg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cb2Var;
            this.a = yg4Var;
        }

        @Override // com.baidu.tieba.ta2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.ta2.c
        public void b(PMSDownloadType pMSDownloadType, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, qj3Var) == null) {
                this.b.u(this.a, qj3Var);
            }
        }
    }

    public cb2(@NonNull T t) {
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
    @Override // com.baidu.tieba.of4
    /* renamed from: l */
    public String d(yg4 yg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, yg4Var)) == null) {
            return tq2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull yg4 yg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yg4Var) == null) {
            r(yg4Var);
            ta2.c().b(yg4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
    /* renamed from: v */
    public void c(yg4 yg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, yg4Var) == null) {
            super.c(yg4Var);
            if (yg4Var != null) {
                p33.b("plugin download start: bundleId = " + yg4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
    /* renamed from: w */
    public void f(yg4 yg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, yg4Var) == null) {
            super.f(yg4Var);
            if (yg4Var != null) {
                p33.b("plugin on downloading: bundleId = " + yg4Var.g);
            }
            x(yg4Var);
        }
    }

    public final void x(yg4 yg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, yg4Var) == null) {
            ta2.c().d(yg4Var, new a(this, yg4Var));
        }
    }

    @Override // com.baidu.tieba.qf4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(yg4 yg4Var, qj3 qj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yg4Var, qj3Var) == null) {
            u(yg4Var, qj3Var);
            ta2.c().a(yg4Var, o(), qj3Var);
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
    @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
    /* renamed from: s */
    public void e(yg4 yg4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, yg4Var, rg4Var) == null) {
            super.e(yg4Var, rg4Var);
            p33.b("plugin download error: " + rg4Var);
            qj3 qj3Var = new qj3();
            qj3Var.k(17L);
            qj3Var.i((long) rg4Var.a);
            qj3Var.d(rg4Var.b);
            qj3Var.f(rg4Var.toString());
            p(yg4Var, qj3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
    /* renamed from: t */
    public void i(yg4 yg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, yg4Var) == null) {
            super.i(yg4Var);
            if (yg4Var == null) {
                p33.b("download finish, plugin is null");
                qj3 qj3Var = new qj3();
                qj3Var.k(17L);
                qj3Var.i(2201L);
                qj3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, qj3Var);
            } else if (!kl3.a(new File(yg4Var.a), yg4Var.m)) {
                bo4.M(yg4Var.a);
                p33.b("download finish, check zip sign failure");
                qj3 qj3Var2 = new qj3();
                qj3Var2.k(17L);
                qj3Var2.i(2202L);
                qj3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(yg4Var, qj3Var2);
            } else {
                File t = tq2.t(yg4Var.g, String.valueOf(yg4Var.i));
                bo4.l(t);
                if (t != null && t.exists()) {
                    boolean U = bo4.U(yg4Var.a, t.getAbsolutePath());
                    bo4.M(yg4Var.a);
                    p33.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        qj3 qj3Var3 = new qj3();
                        qj3Var3.k(17L);
                        qj3Var3.i(2320L);
                        qj3Var3.d("plugin unzip fail.");
                        p(yg4Var, qj3Var3);
                        return;
                    }
                    yg4Var.c = yg4Var.b();
                    yg4Var.d = yg4Var.b();
                    uf4.i().m(yg4Var);
                    q(yg4Var);
                    return;
                }
                bo4.M(yg4Var.a);
                p33.b("download finish, create file failure, name = " + yg4Var.g + " ; version = " + yg4Var.i);
                qj3 qj3Var4 = new qj3();
                qj3Var4.k(17L);
                qj3Var4.i(2203L);
                qj3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(yg4Var, qj3Var4);
            }
        }
    }
}
