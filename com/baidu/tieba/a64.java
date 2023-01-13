package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.f72;
import com.baidu.tieba.x54;
import com.baidu.tieba.z04;
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
public class a64 extends n72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public x54.a c;
    public String d;
    public String e;
    public String f;
    public ac4<jd4> g;

    /* loaded from: classes3.dex */
    public class a extends xb4<jd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a64 a;

        public a(a64 a64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a64Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ac4
        /* renamed from: l */
        public String d(jd4 jd4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jd4Var)) == null) {
                return c82.c(this.a.f);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: r */
        public void f(jd4 jd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, jd4Var) == null) {
                super.f(jd4Var);
                if (a64.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(jd4Var);
            }
        }

        @Override // com.baidu.tieba.cc4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: o */
        public void e(jd4 jd4Var, dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, jd4Var, dd4Var) == null) {
                super.e(jd4Var, dd4Var);
                if (a64.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + dd4Var.toString());
                }
                this.a.T(2103);
                cg3 cg3Var = new cg3();
                cg3Var.k(12L);
                cg3Var.i(dd4Var.a);
                cg3Var.d("分包下载失败");
                cg3Var.f(dd4Var.toString());
                f72.c().a(jd4Var, PMSDownloadType.ALONE_SUB, cg3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: p */
        public void i(jd4 jd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jd4Var) == null) {
                super.i(jd4Var);
                if (a64.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + jd4Var.toString());
                }
                this.a.W(jd4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: q */
        public void a(jd4 jd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, jd4Var) == null) {
                super.a(jd4Var);
                if (a64.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + jd4Var.k + ":" + jd4Var.b);
                }
                this.a.U(jd4Var.b, jd4Var.k);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a64 a;

        public b(a64 a64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a64Var;
        }

        @Override // com.baidu.tieba.f72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.V();
        }

        @Override // com.baidu.tieba.f72.c
        public void b(PMSDownloadType pMSDownloadType, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cg3Var) != null) {
                return;
            }
            this.a.T(2103);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947567114, "Lcom/baidu/tieba/a64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947567114, "Lcom/baidu/tieba/a64;");
                return;
            }
        }
        h = tk1.a;
    }

    @Override // com.baidu.tieba.ec4
    public ac4<jd4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (ac4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (h) {
                Log.i("SwanGameSubPkgDownload", "onNoPackage");
            }
            T(2102);
        }
    }

    public final void V() {
        x54.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aVar = this.c) != null) {
            aVar.success();
        }
    }

    public a64(String str, String str2, String str3, x54.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.d = str;
        this.e = str3;
        this.c = aVar;
        this.f = z04.d.h(str, str2).getPath();
    }

    public final void T(int i) {
        x54.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (aVar = this.c) != null) {
            aVar.b(i);
        }
    }

    public final void X(jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jd4Var) == null) {
            f72.c().d(jd4Var, new b(this));
        }
    }

    @Override // com.baidu.tieba.ec4
    public void C(dd4 dd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dd4Var) == null) {
            super.C(dd4Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + dd4Var.toString());
            }
            T(2103);
        }
    }

    public final void U(long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) != null) || this.c == null) {
            return;
        }
        if (j2 > 0 && j <= j2) {
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.c.a(floor, j, j2);
                return;
            }
            return;
        }
        T(2114);
    }

    public final void W(jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jd4Var) == null) {
            if (!wh3.a(new File(jd4Var.a), jd4Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(2104);
                cg3 cg3Var = new cg3();
                cg3Var.k(12L);
                cg3Var.i(2300L);
                cg3Var.d("分包签名校验");
                f72.c().a(jd4Var, PMSDownloadType.ALONE_SUB, cg3Var);
            } else if (c82.h(new File(jd4Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                jd4Var.o = this.d;
                gc4.i().m(jd4Var);
                f72.c().b(jd4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                cg3 cg3Var2 = new cg3();
                cg3Var2.k(12L);
                cg3Var2.i(2320L);
                cg3Var2.d("分包解压失败");
                f72.c().a(jd4Var, PMSDownloadType.ALONE_SUB, cg3Var2);
            }
        }
    }
}
