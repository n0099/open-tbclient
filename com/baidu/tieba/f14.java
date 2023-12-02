package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f14 extends h52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A;
    public transient /* synthetic */ FieldHolder $fh;
    public View z;

    @Override // com.baidu.tieba.h52, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ts1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "console" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a extends y42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(f14 f14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y42
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (f14.A) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                g14.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947711264, "Lcom/baidu/tieba/f14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947711264, "Lcom/baidu/tieba/f14;");
                return;
            }
        }
        A = vm1.a;
    }

    @Override // com.baidu.tieba.h52, com.baidu.tieba.qs1
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g14.h(false);
            this.z = null;
            super.C();
        }
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b(new a(this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f14(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.h52, com.baidu.tieba.qs1
    public void E(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.z = view2;
        }
    }

    @Override // com.baidu.tieba.h52, com.baidu.tieba.qs1
    public void N(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            int visibility = getWebView().getVisibility();
            int i2 = 0;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            if (visibility == i) {
                return;
            }
            if (A) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                xr2.V().n("console", a14.u(true));
            }
            if (this.z != null) {
                if (z) {
                    i2 = 4;
                }
                this.z.setVisibility(i2);
            }
            super.N(z);
        }
    }

    @Override // com.baidu.tieba.h52, com.baidu.tieba.qs1
    public void d0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            g14.g(str, str2);
        }
    }

    @Override // com.baidu.tieba.h52
    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            getWebView().setVisibility(8);
            getWebView().setBackgroundColor(0);
            g14.c();
            f1();
            String i = b14.m().i();
            if (A) {
                Log.d("SwanGameConsoleManager", HttpRetryStatistic.RETRY_URL + i);
            }
            loadUrl(i);
        }
    }
}
