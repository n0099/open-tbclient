package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.l82;
import com.baidu.tieba.lo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class g92 extends t82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public k82 c;
    public String d;
    public String e;
    public gd4<pe4> f;

    /* loaded from: classes6.dex */
    public class a extends dd4<pe4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g92 a;

        public a(g92 g92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gd4
        /* renamed from: l */
        public String d(pe4 pe4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pe4Var)) == null) {
                return i92.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: q */
        public void f(pe4 pe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pe4Var) == null) {
                super.f(pe4Var);
                if (g92.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(pe4Var);
            }
        }

        @Override // com.baidu.tieba.id4
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
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: o */
        public void e(pe4 pe4Var, je4 je4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, pe4Var, je4Var) == null) {
                super.e(pe4Var, je4Var);
                if (g92.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + je4Var.toString());
                }
                ih3 ih3Var = new ih3();
                ih3Var.k(12L);
                ih3Var.i(je4Var.a);
                ih3Var.d("分包下载失败");
                ih3Var.f(je4Var.toString());
                this.a.S(3, ih3Var);
                l82.c().a(pe4Var, PMSDownloadType.ALONE_SUB, ih3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: p */
        public void i(pe4 pe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, pe4Var) == null) {
                super.i(pe4Var);
                if (g92.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + pe4Var.toString());
                }
                this.a.U(pe4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements l82.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g92 a;

        public b(g92 g92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g92Var;
        }

        @Override // com.baidu.tieba.l82.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.l82.c
        public void b(PMSDownloadType pMSDownloadType, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ih3Var) != null) {
                return;
            }
            this.a.S(0, ih3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748681, "Lcom/baidu/tieba/g92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748681, "Lcom/baidu/tieba/g92;");
                return;
            }
        }
        g = am1.a;
    }

    @Override // com.baidu.tieba.kd4
    public gd4<pe4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (gd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            ih3 ih3Var = new ih3();
            ih3Var.k(12L);
            ih3Var.i(2901L);
            ih3Var.d("Server无包");
            S(2, ih3Var);
        }
    }

    public final void T() {
        k82 k82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (k82Var = this.c) != null) {
            k82Var.a();
        }
    }

    public g92(String str, String str2, k82 k82Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, k82Var};
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
        this.c = k82Var;
        this.e = lo2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.kd4
    public void C(je4 je4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, je4Var) == null) {
            super.C(je4Var);
            ih3 ih3Var = new ih3();
            ih3Var.k(12L);
            ih3Var.c(je4Var);
            S(1, ih3Var);
        }
    }

    public final void V(pe4 pe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pe4Var) == null) {
            l82.c().d(pe4Var, new b(this));
        }
    }

    public final void S(int i, ih3 ih3Var) {
        k82 k82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, ih3Var) == null) && (k82Var = this.c) != null) {
            k82Var.b(i, ih3Var);
        }
    }

    public final void U(pe4 pe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pe4Var) == null) {
            if (!cj3.a(new File(pe4Var.a), pe4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                ih3 ih3Var = new ih3();
                ih3Var.k(12L);
                ih3Var.i(2300L);
                ih3Var.d("分包签名校验");
                S(4, ih3Var);
                l82.c().a(pe4Var, PMSDownloadType.ALONE_SUB, ih3Var);
            } else if (i92.h(new File(pe4Var.a), new File(this.e, pe4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                pe4Var.o = this.d;
                md4.i().m(pe4Var);
                T();
                l82.c().b(pe4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                ih3 ih3Var2 = new ih3();
                ih3Var2.k(12L);
                ih3Var2.i(2320L);
                ih3Var2.d("分包解压失败");
                S(5, ih3Var2);
                l82.c().a(pe4Var, PMSDownloadType.ALONE_SUB, ih3Var2);
            }
        }
    }
}
