package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ic2;
import com.baidu.tieba.is2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes4.dex */
public class dd2 extends qc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public hc2 c;
    public String d;
    public String e;
    public dh4<mi4> f;

    /* loaded from: classes4.dex */
    public class a extends ah4<mi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;

        public a(dd2 dd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dh4
        /* renamed from: l */
        public String d(mi4 mi4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mi4Var)) == null) {
                return fd2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: q */
        public void f(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mi4Var) == null) {
                super.f(mi4Var);
                if (dd2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(mi4Var);
            }
        }

        @Override // com.baidu.tieba.fh4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: o */
        public void e(mi4 mi4Var, gi4 gi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, mi4Var, gi4Var) == null) {
                super.e(mi4Var, gi4Var);
                if (dd2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + gi4Var.toString());
                }
                fl3 fl3Var = new fl3();
                fl3Var.k(12L);
                fl3Var.i(gi4Var.a);
                fl3Var.d("分包下载失败");
                fl3Var.f(gi4Var.toString());
                this.a.S(3, fl3Var);
                ic2.c().a(mi4Var, PMSDownloadType.ALONE_SUB, fl3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: p */
        public void i(mi4 mi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, mi4Var) == null) {
                super.i(mi4Var);
                if (dd2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + mi4Var.toString());
                }
                this.a.U(mi4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ic2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dd2 a;

        public b(dd2 dd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dd2Var;
        }

        @Override // com.baidu.tieba.ic2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.ic2.c
        public void b(PMSDownloadType pMSDownloadType, fl3 fl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, fl3Var) != null) {
                return;
            }
            this.a.S(0, fl3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947700631, "Lcom/baidu/tieba/dd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947700631, "Lcom/baidu/tieba/dd2;");
                return;
            }
        }
        g = wp1.a;
    }

    @Override // com.baidu.tieba.hh4
    public dh4<mi4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (dh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            fl3 fl3Var = new fl3();
            fl3Var.k(12L);
            fl3Var.i(2901L);
            fl3Var.d("Server无包");
            S(2, fl3Var);
        }
    }

    public final void T() {
        hc2 hc2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (hc2Var = this.c) != null) {
            hc2Var.a();
        }
    }

    public dd2(String str, String str2, hc2 hc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, hc2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.d = str;
        this.c = hc2Var;
        this.e = is2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.hh4
    public void C(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gi4Var) == null) {
            super.C(gi4Var);
            fl3 fl3Var = new fl3();
            fl3Var.k(12L);
            fl3Var.c(gi4Var);
            S(1, fl3Var);
        }
    }

    public final void V(mi4 mi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mi4Var) == null) {
            ic2.c().d(mi4Var, new b(this));
        }
    }

    public final void S(int i, fl3 fl3Var) {
        hc2 hc2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, fl3Var) == null) && (hc2Var = this.c) != null) {
            hc2Var.b(i, fl3Var);
        }
    }

    public final void U(mi4 mi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mi4Var) == null) {
            if (!zm3.a(new File(mi4Var.a), mi4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                fl3 fl3Var = new fl3();
                fl3Var.k(12L);
                fl3Var.i(2300L);
                fl3Var.d("分包签名校验");
                S(4, fl3Var);
                ic2.c().a(mi4Var, PMSDownloadType.ALONE_SUB, fl3Var);
            } else if (fd2.h(new File(mi4Var.a), new File(this.e, mi4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                mi4Var.o = this.d;
                jh4.i().m(mi4Var);
                T();
                ic2.c().b(mi4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                fl3 fl3Var2 = new fl3();
                fl3Var2.k(12L);
                fl3Var2.i(2320L);
                fl3Var2.d("分包解压失败");
                S(5, fl3Var2);
                ic2.c().a(mi4Var, PMSDownloadType.ALONE_SUB, fl3Var2);
            }
        }
    }
}
