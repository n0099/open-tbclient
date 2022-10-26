package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.a54;
import com.baidu.tieba.c04;
import com.baidu.tieba.i62;
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
public class d54 extends q62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public a54.a c;
    public String d;
    public String e;
    public String f;
    public db4 g;

    /* loaded from: classes3.dex */
    public class a extends ab4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d54 a;

        public a(d54 d54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d54Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db4
        /* renamed from: l */
        public String d(mc4 mc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mc4Var)) == null) {
                return f72.c(this.a.f);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: r */
        public void f(mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, mc4Var) == null) {
                super.f(mc4Var);
                if (d54.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(mc4Var);
            }
        }

        @Override // com.baidu.tieba.fb4
        public Bundle m(Bundle bundle, Set set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: o */
        public void e(mc4 mc4Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, mc4Var, gc4Var) == null) {
                super.e(mc4Var, gc4Var);
                if (d54.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + gc4Var.toString());
                }
                this.a.T(2103);
                ff3 ff3Var = new ff3();
                ff3Var.k(12L);
                ff3Var.i(gc4Var.a);
                ff3Var.d("分包下载失败");
                ff3Var.f(gc4Var.toString());
                i62.c().a(mc4Var, PMSDownloadType.ALONE_SUB, ff3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: p */
        public void i(mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mc4Var) == null) {
                super.i(mc4Var);
                if (d54.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + mc4Var.toString());
                }
                this.a.W(mc4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: q */
        public void a(mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, mc4Var) == null) {
                super.a(mc4Var);
                if (d54.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + mc4Var.k + ":" + mc4Var.b);
                }
                this.a.U(mc4Var.b, mc4Var.k);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d54 a;

        public b(d54 d54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d54Var;
        }

        @Override // com.baidu.tieba.i62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.V();
        }

        @Override // com.baidu.tieba.i62.c
        public void b(PMSDownloadType pMSDownloadType, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ff3Var) != null) {
                return;
            }
            this.a.T(2103);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947655526, "Lcom/baidu/tieba/d54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947655526, "Lcom/baidu/tieba/d54;");
                return;
            }
        }
        h = wj1.a;
    }

    @Override // com.baidu.tieba.hb4
    public db4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (db4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
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
        a54.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aVar = this.c) != null) {
            aVar.success();
        }
    }

    public d54(String str, String str2, String str3, a54.a aVar) {
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
        this.f = c04.d.h(str, str2).getPath();
    }

    public final void T(int i) {
        a54.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (aVar = this.c) != null) {
            aVar.b(i);
        }
    }

    public final void X(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mc4Var) == null) {
            i62.c().d(mc4Var, new b(this));
        }
    }

    @Override // com.baidu.tieba.hb4
    public void C(gc4 gc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gc4Var) == null) {
            super.C(gc4Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + gc4Var.toString());
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

    public final void W(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mc4Var) == null) {
            if (!zg3.a(new File(mc4Var.a), mc4Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(2104);
                ff3 ff3Var = new ff3();
                ff3Var.k(12L);
                ff3Var.i(2300L);
                ff3Var.d("分包签名校验");
                i62.c().a(mc4Var, PMSDownloadType.ALONE_SUB, ff3Var);
            } else if (f72.h(new File(mc4Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                mc4Var.o = this.d;
                jb4.i().m(mc4Var);
                i62.c().b(mc4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                ff3 ff3Var2 = new ff3();
                ff3Var2.k(12L);
                ff3Var2.i(2320L);
                ff3Var2.d("分包解压失败");
                i62.c().a(mc4Var, PMSDownloadType.ALONE_SUB, ff3Var2);
            }
        }
    }
}
