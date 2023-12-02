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
import com.baidu.tieba.hr2;
import com.baidu.tieba.o53;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b64 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public o53 a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sy1 c;
        public final /* synthetic */ hr2 d;
        public final /* synthetic */ b64 e;

        public a(b64 b64Var, SwanAppActivity swanAppActivity, String str, sy1 sy1Var, hr2 hr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b64Var, swanAppActivity, str, sy1Var, hr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b64Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = sy1Var;
            this.d = hr2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.f(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy1 a;

        public b(b64 b64Var, sy1 sy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b64Var, sy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                w84.a(this.a, true, new d64(false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy1 a;
        public final /* synthetic */ hr2 b;
        public final /* synthetic */ b64 c;

        public c(b64 b64Var, sy1 sy1Var, hr2 hr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b64Var, sy1Var, hr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = b64Var;
            this.a = sy1Var;
            this.b = hr2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                w84.a(this.a, true, new d64(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947596905, "Lcom/baidu/tieba/b64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947596905, "Lcom/baidu/tieba/b64;");
                return;
            }
        }
        b = vm1.a;
    }

    public b64() {
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

    public final void c(sy1 sy1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sy1Var, str) == null) {
            t04 t04Var = new t04();
            t04Var.errMsg = str;
            w84.a(sy1Var, false, t04Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            sy1 G = sy1.G(jsObject);
            if (G == null) {
                G = new sy1();
            }
            sy1 sy1Var = G;
            k63 q = j63.K().q();
            if (!q.I()) {
                c(sy1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity w = q.w();
            hr2.a X = q.X();
            if (w == null) {
                c(sy1Var, "reload failed, api internal error.");
                return;
            }
            String C = sy1Var.C("content");
            if (TextUtils.isEmpty(C)) {
                C = w.getString(R.string.obfuscated_res_0x7f0f01b9);
            }
            ek3.e0(new a(this, w, C, sy1Var, X));
        }
    }

    public final void e(@NonNull hr2 hr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hr2Var) == null) {
            String I = hr2Var.I();
            String i1 = ir2.i1(hr2Var.I(), hr2Var.U(), hr2Var.H());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, I);
            bundle.putString("scheme", i1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + hr2Var.I());
            }
            f33.Q().W(bundle, c64.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull sy1 sy1Var, @NonNull hr2 hr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, sy1Var, hr2Var) == null) {
            o53 o53Var = this.a;
            if (o53Var != null && o53Var.isShowing()) {
                c(sy1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            o53.a aVar = new o53.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f01ba);
            aVar.x(str);
            aVar.a();
            aVar.n(new sl3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f0149, new b(this, sy1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f01d9, new c(this, sy1Var, hr2Var));
            this.a = aVar.X();
        }
    }
}
