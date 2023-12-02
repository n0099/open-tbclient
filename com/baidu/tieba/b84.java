package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.a34;
import com.baidu.tieba.g92;
import com.baidu.tieba.y74;
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
public class b84 extends o92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public y74.a c;
    public String d;
    public String e;
    public String f;
    public be4<kf4> g;

    /* loaded from: classes5.dex */
    public class a extends yd4<kf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b84 a;

        public a(b84 b84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b84Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.be4
        /* renamed from: l */
        public String d(kf4 kf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, kf4Var)) == null) {
                return da2.c(this.a.f);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: r */
        public void f(kf4 kf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, kf4Var) == null) {
                super.f(kf4Var);
                if (b84.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(kf4Var);
            }
        }

        @Override // com.baidu.tieba.de4
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
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: o */
        public void e(kf4 kf4Var, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, kf4Var, ef4Var) == null) {
                super.e(kf4Var, ef4Var);
                if (b84.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + ef4Var.toString());
                }
                this.a.T(2103);
                di3 di3Var = new di3();
                di3Var.k(12L);
                di3Var.i(ef4Var.a);
                di3Var.d("分包下载失败");
                di3Var.f(ef4Var.toString());
                g92.c().a(kf4Var, PMSDownloadType.ALONE_SUB, di3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: p */
        public void i(kf4 kf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kf4Var) == null) {
                super.i(kf4Var);
                if (b84.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + kf4Var.toString());
                }
                this.a.W(kf4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: q */
        public void a(kf4 kf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, kf4Var) == null) {
                super.a(kf4Var);
                if (b84.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + kf4Var.k + ":" + kf4Var.b);
                }
                this.a.U(kf4Var.b, kf4Var.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements g92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b84 a;

        public b(b84 b84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b84Var;
        }

        @Override // com.baidu.tieba.g92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.V();
        }

        @Override // com.baidu.tieba.g92.c
        public void b(PMSDownloadType pMSDownloadType, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, di3Var) != null) {
                return;
            }
            this.a.T(2103);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947598827, "Lcom/baidu/tieba/b84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947598827, "Lcom/baidu/tieba/b84;");
                return;
            }
        }
        h = vm1.a;
    }

    @Override // com.baidu.tieba.fe4
    public be4<kf4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (be4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
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
        y74.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aVar = this.c) != null) {
            aVar.success();
        }
    }

    public b84(String str, String str2, String str3, y74.a aVar) {
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
        this.f = a34.d.h(str, str2).getPath();
    }

    public final void T(int i) {
        y74.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (aVar = this.c) != null) {
            aVar.b(i);
        }
    }

    public final void X(kf4 kf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, kf4Var) == null) {
            g92.c().d(kf4Var, new b(this));
        }
    }

    @Override // com.baidu.tieba.fe4
    public void C(ef4 ef4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef4Var) == null) {
            super.C(ef4Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + ef4Var.toString());
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

    public final void W(kf4 kf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, kf4Var) == null) {
            if (!xj3.a(new File(kf4Var.a), kf4Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4);
                di3 di3Var = new di3();
                di3Var.k(12L);
                di3Var.i(2300L);
                di3Var.d("分包签名校验");
                g92.c().a(kf4Var, PMSDownloadType.ALONE_SUB, di3Var);
            } else if (da2.h(new File(kf4Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                kf4Var.o = this.d;
                he4.i().m(kf4Var);
                g92.c().b(kf4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                di3 di3Var2 = new di3();
                di3Var2.k(12L);
                di3Var2.i(2320L);
                di3Var2.d("分包解压失败");
                g92.c().a(kf4Var, PMSDownloadType.ALONE_SUB, di3Var2);
            }
        }
    }
}
