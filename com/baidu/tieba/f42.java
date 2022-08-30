package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.e42;
import com.baidu.tieba.w32;
import com.baidu.tieba.wj2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class f42<T extends e42> extends m84<z94> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    /* loaded from: classes4.dex */
    public class a implements w32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z94 a;
        public final /* synthetic */ f42 b;

        public a(f42 f42Var, z94 z94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f42Var, z94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f42Var;
            this.a = z94Var;
        }

        @Override // com.baidu.tieba.w32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.w32.c
        public void b(PMSDownloadType pMSDownloadType, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, tc3Var) == null) {
                this.b.u(this.a, tc3Var);
            }
        }
    }

    public f42(@NonNull T t) {
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
    @Override // com.baidu.tieba.p84
    /* renamed from: l */
    public String d(z94 z94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, z94Var)) == null) ? wj2.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r84
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

    public final void p(z94 z94Var, tc3 tc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z94Var, tc3Var) == null) {
            u(z94Var, tc3Var);
            w32.c().a(z94Var, o(), tc3Var);
        }
    }

    public final void q(@NonNull z94 z94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, z94Var) == null) {
            r(z94Var);
            w32.c().b(z94Var, o());
        }
    }

    public abstract void r(@NonNull z94 z94Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
    /* renamed from: s */
    public void e(z94 z94Var, s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, z94Var, s94Var) == null) {
            super.e(z94Var, s94Var);
            sw2.b("plugin download error: " + s94Var);
            tc3 tc3Var = new tc3();
            tc3Var.k(17L);
            tc3Var.i((long) s94Var.a);
            tc3Var.d(s94Var.b);
            tc3Var.f(s94Var.toString());
            p(z94Var, tc3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
    /* renamed from: t */
    public void i(z94 z94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, z94Var) == null) {
            super.i(z94Var);
            if (z94Var == null) {
                sw2.b("download finish, plugin is null");
                tc3 tc3Var = new tc3();
                tc3Var.k(17L);
                tc3Var.i(2201L);
                tc3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, tc3Var);
            } else if (!ne3.a(new File(z94Var.a), z94Var.m)) {
                ch4.M(z94Var.a);
                sw2.b("download finish, check zip sign failure");
                tc3 tc3Var2 = new tc3();
                tc3Var2.k(17L);
                tc3Var2.i(2202L);
                tc3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(z94Var, tc3Var2);
            } else {
                File t = wj2.t(z94Var.g, String.valueOf(z94Var.i));
                ch4.l(t);
                if (t != null && t.exists()) {
                    boolean U = ch4.U(z94Var.a, t.getAbsolutePath());
                    ch4.M(z94Var.a);
                    sw2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        tc3 tc3Var3 = new tc3();
                        tc3Var3.k(17L);
                        tc3Var3.i(2320L);
                        tc3Var3.d("plugin unzip fail.");
                        p(z94Var, tc3Var3);
                        return;
                    }
                    z94Var.c = z94Var.b();
                    z94Var.d = z94Var.b();
                    v84.i().m(z94Var);
                    q(z94Var);
                    return;
                }
                ch4.M(z94Var.a);
                sw2.b("download finish, create file failure, name = " + z94Var.g + " ; version = " + z94Var.i);
                tc3 tc3Var4 = new tc3();
                tc3Var4.k(17L);
                tc3Var4.i(2203L);
                tc3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(z94Var, tc3Var4);
            }
        }
    }

    public abstract void u(z94 z94Var, tc3 tc3Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
    /* renamed from: v */
    public void c(z94 z94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, z94Var) == null) {
            super.c(z94Var);
            if (z94Var != null) {
                sw2.b("plugin download start: bundleId = " + z94Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
    /* renamed from: w */
    public void f(z94 z94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, z94Var) == null) {
            super.f(z94Var);
            if (z94Var != null) {
                sw2.b("plugin on downloading: bundleId = " + z94Var.g);
            }
            x(z94Var);
        }
    }

    public final void x(z94 z94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, z94Var) == null) {
            w32.c().d(z94Var, new a(this, z94Var));
        }
    }
}
