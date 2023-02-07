package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ac2;
import com.baidu.tieba.sb2;
import com.baidu.tieba.sr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class bc2<T extends ac2> extends kg4<xh4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull xh4 xh4Var);

    public abstract void u(xh4 xh4Var, pk3 pk3Var);

    /* loaded from: classes3.dex */
    public class a implements sb2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xh4 a;
        public final /* synthetic */ bc2 b;

        public a(bc2 bc2Var, xh4 xh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bc2Var, xh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bc2Var;
            this.a = xh4Var;
        }

        @Override // com.baidu.tieba.sb2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.sb2.c
        public void b(PMSDownloadType pMSDownloadType, pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, pk3Var) == null) {
                this.b.u(this.a, pk3Var);
            }
        }
    }

    public bc2(@NonNull T t) {
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
    @Override // com.baidu.tieba.ng4
    /* renamed from: l */
    public String d(xh4 xh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xh4Var)) == null) {
            return sr2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull xh4 xh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, xh4Var) == null) {
            r(xh4Var);
            sb2.c().b(xh4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
    /* renamed from: v */
    public void c(xh4 xh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, xh4Var) == null) {
            super.c(xh4Var);
            if (xh4Var != null) {
                o43.b("plugin download start: bundleId = " + xh4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
    /* renamed from: w */
    public void f(xh4 xh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, xh4Var) == null) {
            super.f(xh4Var);
            if (xh4Var != null) {
                o43.b("plugin on downloading: bundleId = " + xh4Var.g);
            }
            x(xh4Var);
        }
    }

    public final void x(xh4 xh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, xh4Var) == null) {
            sb2.c().d(xh4Var, new a(this, xh4Var));
        }
    }

    @Override // com.baidu.tieba.pg4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(xh4 xh4Var, pk3 pk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xh4Var, pk3Var) == null) {
            u(xh4Var, pk3Var);
            sb2.c().a(xh4Var, o(), pk3Var);
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
    @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
    /* renamed from: s */
    public void e(xh4 xh4Var, qh4 qh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, xh4Var, qh4Var) == null) {
            super.e(xh4Var, qh4Var);
            o43.b("plugin download error: " + qh4Var);
            pk3 pk3Var = new pk3();
            pk3Var.k(17L);
            pk3Var.i((long) qh4Var.a);
            pk3Var.d(qh4Var.b);
            pk3Var.f(qh4Var.toString());
            p(xh4Var, pk3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
    /* renamed from: t */
    public void i(xh4 xh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, xh4Var) == null) {
            super.i(xh4Var);
            if (xh4Var == null) {
                o43.b("download finish, plugin is null");
                pk3 pk3Var = new pk3();
                pk3Var.k(17L);
                pk3Var.i(2201L);
                pk3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, pk3Var);
            } else if (!jm3.a(new File(xh4Var.a), xh4Var.m)) {
                ap4.M(xh4Var.a);
                o43.b("download finish, check zip sign failure");
                pk3 pk3Var2 = new pk3();
                pk3Var2.k(17L);
                pk3Var2.i(2202L);
                pk3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(xh4Var, pk3Var2);
            } else {
                File t = sr2.t(xh4Var.g, String.valueOf(xh4Var.i));
                ap4.l(t);
                if (t != null && t.exists()) {
                    boolean U = ap4.U(xh4Var.a, t.getAbsolutePath());
                    ap4.M(xh4Var.a);
                    o43.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        pk3 pk3Var3 = new pk3();
                        pk3Var3.k(17L);
                        pk3Var3.i(2320L);
                        pk3Var3.d("plugin unzip fail.");
                        p(xh4Var, pk3Var3);
                        return;
                    }
                    xh4Var.c = xh4Var.b();
                    xh4Var.d = xh4Var.b();
                    tg4.i().m(xh4Var);
                    q(xh4Var);
                    return;
                }
                ap4.M(xh4Var.a);
                o43.b("download finish, create file failure, name = " + xh4Var.g + " ; version = " + xh4Var.i);
                pk3 pk3Var4 = new pk3();
                pk3Var4.k(17L);
                pk3Var4.i(2203L);
                pk3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(xh4Var, pk3Var4);
            }
        }
    }
}
