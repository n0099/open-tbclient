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
/* loaded from: classes4.dex */
public class gy3 extends i22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean A;
    public transient /* synthetic */ FieldHolder $fh;
    public View z;

    /* loaded from: classes4.dex */
    public class a extends z12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(gy3 gy3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.z12
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (gy3.A) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                hy3.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947810216, "Lcom/baidu/tieba/gy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947810216, "Lcom/baidu/tieba/gy3;");
                return;
            }
        }
        A = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gy3(Context context) {
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

    @Override // com.baidu.tieba.i22, com.baidu.tieba.qp1
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hy3.h(false);
            this.z = null;
            super.E();
        }
    }

    @Override // com.baidu.tieba.i22, com.baidu.tieba.qp1
    public void G(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.z = view2;
        }
    }

    @Override // com.baidu.tieba.i22, com.baidu.tieba.qp1
    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (r().getVisibility() == (z ? 0 : 8)) {
                return;
            }
            if (A) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                yo2.U().m("console", by3.u(true));
            }
            if (this.z != null) {
                this.z.setVisibility(z ? 4 : 0);
            }
            super.P(z);
        }
    }

    @Override // com.baidu.tieba.i22, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.tp1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "console" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i22, com.baidu.tieba.qp1
    public void g0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            hy3.g(str, str2);
        }
    }

    @Override // com.baidu.tieba.i22
    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            r().setVisibility(8);
            r().setBackgroundColor(0);
            hy3.c();
            i1();
            String i = cy3.m().i();
            if (A) {
                Log.d("SwanGameConsoleManager", HttpRetryStatistic.RETRY_URL + i);
            }
            loadUrl(i);
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b(new a(this));
        }
    }
}
