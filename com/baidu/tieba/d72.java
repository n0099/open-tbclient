package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.i62;
import com.baidu.tieba.im2;
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
public class d72 extends q62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public h62 c;
    public String d;
    public String e;
    public db4 f;

    /* loaded from: classes3.dex */
    public class a extends ab4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public a(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db4
        /* renamed from: l */
        public String d(mc4 mc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mc4Var)) == null) {
                return f72.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: q */
        public void f(mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mc4Var) == null) {
                super.f(mc4Var);
                if (d72.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(mc4Var);
            }
        }

        @Override // com.baidu.tieba.fb4
        public Bundle m(Bundle bundle, Set set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: o */
        public void e(mc4 mc4Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, mc4Var, gc4Var) == null) {
                super.e(mc4Var, gc4Var);
                if (d72.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + gc4Var.toString());
                }
                ff3 ff3Var = new ff3();
                ff3Var.k(12L);
                ff3Var.i(gc4Var.a);
                ff3Var.d("分包下载失败");
                ff3Var.f(gc4Var.toString());
                this.a.S(3, ff3Var);
                i62.c().a(mc4Var, PMSDownloadType.ALONE_SUB, ff3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: p */
        public void i(mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, mc4Var) == null) {
                super.i(mc4Var);
                if (d72.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + mc4Var.toString());
                }
                this.a.U(mc4Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public b(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        @Override // com.baidu.tieba.i62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.i62.c
        public void b(PMSDownloadType pMSDownloadType, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ff3Var) != null) {
                return;
            }
            this.a.S(0, ff3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947657386, "Lcom/baidu/tieba/d72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947657386, "Lcom/baidu/tieba/d72;");
                return;
            }
        }
        g = wj1.a;
    }

    @Override // com.baidu.tieba.hb4
    public db4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (db4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            ff3 ff3Var = new ff3();
            ff3Var.k(12L);
            ff3Var.i(2901L);
            ff3Var.d("Server无包");
            S(2, ff3Var);
        }
    }

    public final void T() {
        h62 h62Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (h62Var = this.c) != null) {
            h62Var.a();
        }
    }

    public d72(String str, String str2, h62 h62Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, h62Var};
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
        this.c = h62Var;
        this.e = im2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.hb4
    public void C(gc4 gc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gc4Var) == null) {
            super.C(gc4Var);
            ff3 ff3Var = new ff3();
            ff3Var.k(12L);
            ff3Var.c(gc4Var);
            S(1, ff3Var);
        }
    }

    public final void V(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mc4Var) == null) {
            i62.c().d(mc4Var, new b(this));
        }
    }

    public final void S(int i, ff3 ff3Var) {
        h62 h62Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, ff3Var) == null) && (h62Var = this.c) != null) {
            h62Var.b(i, ff3Var);
        }
    }

    public final void U(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mc4Var) == null) {
            if (!zg3.a(new File(mc4Var.a), mc4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                ff3 ff3Var = new ff3();
                ff3Var.k(12L);
                ff3Var.i(2300L);
                ff3Var.d("分包签名校验");
                S(4, ff3Var);
                i62.c().a(mc4Var, PMSDownloadType.ALONE_SUB, ff3Var);
            } else if (f72.h(new File(mc4Var.a), new File(this.e, mc4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                mc4Var.o = this.d;
                jb4.i().m(mc4Var);
                T();
                i62.c().b(mc4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                ff3 ff3Var2 = new ff3();
                ff3Var2.k(12L);
                ff3Var2.i(2320L);
                ff3Var2.d("分包解压失败");
                S(5, ff3Var2);
                i62.c().a(mc4Var, PMSDownloadType.ALONE_SUB, ff3Var2);
            }
        }
    }
}
