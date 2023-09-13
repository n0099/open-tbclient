package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x74;
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
public class e64 extends le2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public w54 c;
    @NonNull
    public f64 d;
    public yi4<ik4> e;

    /* loaded from: classes5.dex */
    public class a extends vi4<ik4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e64 a;

        public a(e64 e64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e64Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi4
        /* renamed from: l */
        public String d(ik4 ik4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ik4Var)) == null) {
                return x74.d.g().getPath();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: r */
        public void f(ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ik4Var) == null) {
                super.f(ik4Var);
                if (e64.f) {
                    Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
                }
            }
        }

        @Override // com.baidu.tieba.aj4
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
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: o */
        public void e(ik4 ik4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, ik4Var, bk4Var) == null) {
                super.e(ik4Var, bk4Var);
                if (e64.f) {
                    Log.e("ConsoleJsDownload", "onDownloadError: " + bk4Var.toString());
                }
                this.a.c.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: p */
        public void i(ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ik4Var) == null) {
                super.i(ik4Var);
                if (e64.f) {
                    Log.i("ConsoleJsDownload", "onDownloadFinish: " + ik4Var.toString());
                }
                if (!uo3.a(new File(ik4Var.a), ik4Var.m)) {
                    if (e64.f) {
                        Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                    }
                    this.a.c.a(false);
                    return;
                }
                File a = this.a.d.a();
                if (a.exists()) {
                    lr4.j(a);
                } else {
                    lr4.l(a);
                }
                boolean U = lr4.U(ik4Var.a, a.getAbsolutePath());
                if (U) {
                    this.a.d.b(ik4Var.j, ik4Var.i);
                }
                lr4.k(ik4Var.a);
                this.a.c.a(U);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void c(ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ik4Var) == null) {
                super.c(ik4Var);
                if (e64.f) {
                    Log.i("ConsoleJsDownload", "onDownloadStart: " + ik4Var.toString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947686278, "Lcom/baidu/tieba/e64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947686278, "Lcom/baidu/tieba/e64;");
                return;
            }
        }
        f = rr1.a;
    }

    @Override // com.baidu.tieba.cj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (f) {
                Log.i("ConsoleJsDownload", "onFetchSuccess");
            }
        }
    }

    @Override // com.baidu.tieba.cj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (f) {
                Log.i("ConsoleJsDownload", "onNoPackage");
            }
            this.c.a(false);
        }
    }

    @Override // com.baidu.tieba.cj4
    public yi4<ik4> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (yi4) invokeV.objValue;
    }

    public e64(@NonNull f64 f64Var, @NonNull w54 w54Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f64Var, w54Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.c = w54Var;
        this.d = f64Var;
    }

    @Override // com.baidu.tieba.cj4
    public void G(po4 po4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, po4Var) == null) {
            super.G(po4Var);
            if (f) {
                Log.i("ConsoleJsDownload", "onPrepareDownload");
            }
        }
    }

    @Override // com.baidu.tieba.cj4
    public void C(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bk4Var) == null) {
            super.C(bk4Var);
            if (f) {
                Log.e("ConsoleJsDownload", "onFetchError: " + bk4Var.toString());
            }
            this.c.a(false);
        }
    }
}
