package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.io2;
import com.baidu.tieba.p23;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public p23 a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sv1 c;
        public final /* synthetic */ io2 d;
        public final /* synthetic */ c34 e;

        public a(c34 c34Var, SwanAppActivity swanAppActivity, String str, sv1 sv1Var, io2 io2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c34Var, swanAppActivity, str, sv1Var, io2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = c34Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = sv1Var;
            this.d = io2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.f(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv1 a;

        public b(c34 c34Var, sv1 sv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c34Var, sv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sv1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                x54.call(this.a, true, new e34(false));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv1 a;
        public final /* synthetic */ io2 b;
        public final /* synthetic */ c34 c;

        public c(c34 c34Var, sv1 sv1Var, io2 io2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c34Var, sv1Var, io2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c34Var;
            this.a = sv1Var;
            this.b = io2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                x54.call(this.a, true, new e34(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947623813, "Lcom/baidu/tieba/c34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947623813, "Lcom/baidu/tieba/c34;");
                return;
            }
        }
        b = vj1.a;
    }

    public c34() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void c(sv1 sv1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sv1Var, str) == null) {
            ux3 ux3Var = new ux3();
            ux3Var.errMsg = str;
            x54.call(sv1Var, false, ux3Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            sv1 F = sv1.F(jsObject);
            if (F == null) {
                F = new sv1();
            }
            sv1 sv1Var = F;
            l33 q = k33.K().q();
            if (!q.I()) {
                c(sv1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity w = q.w();
            io2.a W = q.W();
            if (w == null) {
                c(sv1Var, "reload failed, api internal error.");
                return;
            }
            String B = sv1Var.B("content");
            if (TextUtils.isEmpty(B)) {
                B = w.getString(R.string.obfuscated_res_0x7f0f0182);
            }
            fh3.e0(new a(this, w, B, sv1Var, W));
        }
    }

    public final void e(@NonNull io2 io2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, io2Var) == null) {
            String H = io2Var.H();
            String h1 = jo2.h1(io2Var.H(), io2Var.T(), io2Var.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + io2Var.H());
            }
            g03.Q().W(bundle, d34.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull sv1 sv1Var, @NonNull io2 io2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, sv1Var, io2Var) == null) {
            p23 p23Var = this.a;
            if (p23Var != null && p23Var.isShowing()) {
                c(sv1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            p23.a aVar = new p23.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f0183);
            aVar.x(str);
            aVar.a();
            aVar.n(new ti3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f0112, new b(this, sv1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f01a2, new c(this, sv1Var, io2Var));
            this.a = aVar.X();
        }
    }
}
