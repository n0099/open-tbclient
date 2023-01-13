package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.f72;
import com.baidu.tieba.fn2;
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
public class a82 extends n72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public e72 c;
    public String d;
    public String e;
    public ac4<jd4> f;

    /* loaded from: classes3.dex */
    public class a extends xb4<jd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a82 a;

        public a(a82 a82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ac4
        /* renamed from: l */
        public String d(jd4 jd4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jd4Var)) == null) {
                return c82.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: q */
        public void f(jd4 jd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jd4Var) == null) {
                super.f(jd4Var);
                if (a82.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(jd4Var);
            }
        }

        @Override // com.baidu.tieba.cc4
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
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: o */
        public void e(jd4 jd4Var, dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, jd4Var, dd4Var) == null) {
                super.e(jd4Var, dd4Var);
                if (a82.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + dd4Var.toString());
                }
                cg3 cg3Var = new cg3();
                cg3Var.k(12L);
                cg3Var.i(dd4Var.a);
                cg3Var.d("分包下载失败");
                cg3Var.f(dd4Var.toString());
                this.a.S(3, cg3Var);
                f72.c().a(jd4Var, PMSDownloadType.ALONE_SUB, cg3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: p */
        public void i(jd4 jd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, jd4Var) == null) {
                super.i(jd4Var);
                if (a82.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + jd4Var.toString());
                }
                this.a.U(jd4Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a82 a;

        public b(a82 a82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a82Var;
        }

        @Override // com.baidu.tieba.f72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.f72.c
        public void b(PMSDownloadType pMSDownloadType, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cg3Var) != null) {
                return;
            }
            this.a.S(0, cg3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947568974, "Lcom/baidu/tieba/a82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947568974, "Lcom/baidu/tieba/a82;");
                return;
            }
        }
        g = tk1.a;
    }

    @Override // com.baidu.tieba.ec4
    public ac4<jd4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (ac4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            cg3 cg3Var = new cg3();
            cg3Var.k(12L);
            cg3Var.i(2901L);
            cg3Var.d("Server无包");
            S(2, cg3Var);
        }
    }

    public final void T() {
        e72 e72Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (e72Var = this.c) != null) {
            e72Var.a();
        }
    }

    public a82(String str, String str2, e72 e72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, e72Var};
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
        this.c = e72Var;
        this.e = fn2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.ec4
    public void C(dd4 dd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dd4Var) == null) {
            super.C(dd4Var);
            cg3 cg3Var = new cg3();
            cg3Var.k(12L);
            cg3Var.c(dd4Var);
            S(1, cg3Var);
        }
    }

    public final void V(jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jd4Var) == null) {
            f72.c().d(jd4Var, new b(this));
        }
    }

    public final void S(int i, cg3 cg3Var) {
        e72 e72Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, cg3Var) == null) && (e72Var = this.c) != null) {
            e72Var.b(i, cg3Var);
        }
    }

    public final void U(jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jd4Var) == null) {
            if (!wh3.a(new File(jd4Var.a), jd4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                cg3 cg3Var = new cg3();
                cg3Var.k(12L);
                cg3Var.i(2300L);
                cg3Var.d("分包签名校验");
                S(4, cg3Var);
                f72.c().a(jd4Var, PMSDownloadType.ALONE_SUB, cg3Var);
            } else if (c82.h(new File(jd4Var.a), new File(this.e, jd4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                jd4Var.o = this.d;
                gc4.i().m(jd4Var);
                T();
                f72.c().b(jd4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                cg3 cg3Var2 = new cg3();
                cg3Var2.k(12L);
                cg3Var2.i(2320L);
                cg3Var2.d("分包解压失败");
                S(5, cg3Var2);
                f72.c().a(jd4Var, PMSDownloadType.ALONE_SUB, cg3Var2);
            }
        }
    }
}
