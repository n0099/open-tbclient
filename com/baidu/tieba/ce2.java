package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ce2 extends de2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean D;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.he2
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947671801, "Lcom/baidu/tieba/ce2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947671801, "Lcom/baidu/tieba/ce2;");
                return;
            }
        }
        D = nr1.a;
    }

    @Override // com.baidu.tieba.yi4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            if (this.n != null) {
                u0();
                H0("checkForUpdate", false);
                te2.c(this.o);
            }
        }
    }

    @Override // com.baidu.tieba.de2
    public PMSDownloadType k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return PMSDownloadType.ASYNC;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ce2(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.de2, com.baidu.tieba.yi4
    public void C(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xj4Var) == null) {
            super.C(xj4Var);
            if (D) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + xj4Var.toString());
            }
            H0("checkForUpdate", false);
            m0(xj4Var.a);
            if (te2.m(xj4Var)) {
                te2.c(this.o);
            }
        }
    }

    @Override // com.baidu.tieba.de2, com.baidu.tieba.yi4
    public void G(lo4 lo4Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lo4Var) == null) {
            super.G(lo4Var);
            if (lo4Var != null && lo4Var.f()) {
                z = true;
            } else {
                z = false;
            }
            H0("checkForUpdate", z);
        }
    }

    @Override // com.baidu.tieba.yi4
    public void H(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            super.H(str, i);
            ik4 a = ik4.a(str);
            if (a == null) {
                return;
            }
            boolean b = ko4.b(a.c());
            d82.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + b + ";statusCode:" + i);
            if (b) {
                t73 e = t73.e();
                v73 v73Var = new v73(129);
                v73Var.f(true);
                e.h(v73Var);
            }
        }
    }

    public final void H0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048580, this, str, z) != null) || TextUtils.isEmpty(this.o)) {
            return;
        }
        fe2.f(str, this.o, z);
    }

    @Override // com.baidu.tieba.de2
    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.v0();
            this.p.add(new UbcFlowEvent("na_start_update_db"));
            wm3 F0 = F0();
            this.p.add(new UbcFlowEvent("na_end_update_db"));
            if (F0 == null) {
                if (D) {
                    Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
                }
                H0("updateReady", true);
                A0("main_async_download", "0");
                te2.c(this.o);
            } else if (D) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
            }
        }
    }

    @Override // com.baidu.tieba.de2
    public void w0(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
            H0("updateFailed", false);
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (D) {
                    Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage());
                }
            } else if (D) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 未知错误：" + th.getMessage());
            }
        }
    }
}
