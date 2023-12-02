package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.g92;
import com.baidu.tieba.gp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public class ba2 extends o92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public f92 c;
    public String d;
    public String e;
    public be4<kf4> f;

    /* loaded from: classes5.dex */
    public class a extends yd4<kf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public a(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.be4
        /* renamed from: l */
        public String d(kf4 kf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, kf4Var)) == null) {
                return da2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: q */
        public void f(kf4 kf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kf4Var) == null) {
                super.f(kf4Var);
                if (ba2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(kf4Var);
            }
        }

        @Override // com.baidu.tieba.de4
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
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: o */
        public void e(kf4 kf4Var, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, kf4Var, ef4Var) == null) {
                super.e(kf4Var, ef4Var);
                if (ba2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + ef4Var.toString());
                }
                di3 di3Var = new di3();
                di3Var.k(12L);
                di3Var.i(ef4Var.a);
                di3Var.d("分包下载失败");
                di3Var.f(ef4Var.toString());
                this.a.S(3, di3Var);
                g92.c().a(kf4Var, PMSDownloadType.ALONE_SUB, di3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: p */
        public void i(kf4 kf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, kf4Var) == null) {
                super.i(kf4Var);
                if (ba2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + kf4Var.toString());
                }
                this.a.U(kf4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements g92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 a;

        public b(ba2 ba2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba2Var;
        }

        @Override // com.baidu.tieba.g92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.g92.c
        public void b(PMSDownloadType pMSDownloadType, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, di3Var) != null) {
                return;
            }
            this.a.S(0, di3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947638166, "Lcom/baidu/tieba/ba2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947638166, "Lcom/baidu/tieba/ba2;");
                return;
            }
        }
        g = vm1.a;
    }

    @Override // com.baidu.tieba.fe4
    public be4<kf4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (be4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            di3 di3Var = new di3();
            di3Var.k(12L);
            di3Var.i(2901L);
            di3Var.d("Server无包");
            S(2, di3Var);
        }
    }

    public final void T() {
        f92 f92Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (f92Var = this.c) != null) {
            f92Var.a();
        }
    }

    public ba2(String str, String str2, f92 f92Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, f92Var};
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
        this.c = f92Var;
        this.e = gp2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.fe4
    public void C(ef4 ef4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef4Var) == null) {
            super.C(ef4Var);
            di3 di3Var = new di3();
            di3Var.k(12L);
            di3Var.c(ef4Var);
            S(1, di3Var);
        }
    }

    public final void V(kf4 kf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, kf4Var) == null) {
            g92.c().d(kf4Var, new b(this));
        }
    }

    public final void S(int i, di3 di3Var) {
        f92 f92Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, di3Var) == null) && (f92Var = this.c) != null) {
            f92Var.b(i, di3Var);
        }
    }

    public final void U(kf4 kf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kf4Var) == null) {
            if (!xj3.a(new File(kf4Var.a), kf4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                di3 di3Var = new di3();
                di3Var.k(12L);
                di3Var.i(2300L);
                di3Var.d("分包签名校验");
                S(4, di3Var);
                g92.c().a(kf4Var, PMSDownloadType.ALONE_SUB, di3Var);
            } else if (da2.h(new File(kf4Var.a), new File(this.e, kf4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                kf4Var.o = this.d;
                he4.i().m(kf4Var);
                T();
                g92.c().b(kf4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                di3 di3Var2 = new di3();
                di3Var2.k(12L);
                di3Var2.i(2320L);
                di3Var2.d("分包解压失败");
                S(5, di3Var2);
                g92.c().a(kf4Var, PMSDownloadType.ALONE_SUB, di3Var2);
            }
        }
    }
}
