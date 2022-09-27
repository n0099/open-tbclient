package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.h62;
import com.baidu.tieba.hm2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class c72 extends p62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public g62 c;
    public String d;
    public String e;
    public cb4<lc4> f;

    /* loaded from: classes3.dex */
    public class a extends za4<lc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c72 a;

        public a(c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cb4
        /* renamed from: l */
        public String d(lc4 lc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lc4Var)) == null) ? e72.a(this.a.e) : (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.eb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: o */
        public void e(lc4 lc4Var, fc4 fc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, lc4Var, fc4Var) == null) {
                super.e(lc4Var, fc4Var);
                if (c72.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + fc4Var.toString());
                }
                ef3 ef3Var = new ef3();
                ef3Var.k(12L);
                ef3Var.i(fc4Var.a);
                ef3Var.d("分包下载失败");
                ef3Var.f(fc4Var.toString());
                this.a.S(3, ef3Var);
                h62.c().a(lc4Var, PMSDownloadType.ALONE_SUB, ef3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: p */
        public void i(lc4 lc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, lc4Var) == null) {
                super.i(lc4Var);
                if (c72.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + lc4Var.toString());
                }
                this.a.U(lc4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: q */
        public void f(lc4 lc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lc4Var) == null) {
                super.f(lc4Var);
                if (c72.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(lc4Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c72 a;

        public b(c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c72Var;
        }

        @Override // com.baidu.tieba.h62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.T();
            }
        }

        @Override // com.baidu.tieba.h62.c
        public void b(PMSDownloadType pMSDownloadType, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ef3Var) == null) {
                this.a.S(0, ef3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947627595, "Lcom/baidu/tieba/c72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947627595, "Lcom/baidu/tieba/c72;");
                return;
            }
        }
        g = vj1.a;
    }

    public c72(String str, String str2, g62 g62Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, g62Var};
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
        this.c = g62Var;
        this.e = hm2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.gb4
    public cb4<lc4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (cb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gb4
    public void C(fc4 fc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fc4Var) == null) {
            super.C(fc4Var);
            ef3 ef3Var = new ef3();
            ef3Var.k(12L);
            ef3Var.c(fc4Var);
            S(1, ef3Var);
        }
    }

    @Override // com.baidu.tieba.gb4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            ef3 ef3Var = new ef3();
            ef3Var.k(12L);
            ef3Var.i(2901L);
            ef3Var.d("Server无包");
            S(2, ef3Var);
        }
    }

    public final void S(int i, ef3 ef3Var) {
        g62 g62Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, ef3Var) == null) || (g62Var = this.c) == null) {
            return;
        }
        g62Var.b(i, ef3Var);
    }

    public final void T() {
        g62 g62Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (g62Var = this.c) == null) {
            return;
        }
        g62Var.a();
    }

    public final void U(lc4 lc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lc4Var) == null) {
            if (!yg3.a(new File(lc4Var.a), lc4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                ef3 ef3Var = new ef3();
                ef3Var.k(12L);
                ef3Var.i(2300L);
                ef3Var.d("分包签名校验");
                S(4, ef3Var);
                h62.c().a(lc4Var, PMSDownloadType.ALONE_SUB, ef3Var);
            } else if (e72.h(new File(lc4Var.a), new File(this.e, lc4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                lc4Var.o = this.d;
                ib4.i().m(lc4Var);
                T();
                h62.c().b(lc4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                ef3 ef3Var2 = new ef3();
                ef3Var2.k(12L);
                ef3Var2.i(2320L);
                ef3Var2.d("分包解压失败");
                S(5, ef3Var2);
                h62.c().a(lc4Var, PMSDownloadType.ALONE_SUB, ef3Var2);
            }
        }
    }

    public final void V(lc4 lc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lc4Var) == null) {
            h62.c().d(lc4Var, new b(this));
        }
    }
}
