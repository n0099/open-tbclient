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
import com.baidu.tieba.mq2;
import com.baidu.tieba.t43;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public t43 a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xx1 c;
        public final /* synthetic */ mq2 d;
        public final /* synthetic */ g54 e;

        public a(g54 g54Var, SwanAppActivity swanAppActivity, String str, xx1 xx1Var, mq2 mq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g54Var, swanAppActivity, str, xx1Var, mq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g54Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = xx1Var;
            this.d = mq2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.f(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx1 a;

        public b(g54 g54Var, xx1 xx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g54Var, xx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                b84.a(this.a, true, new i54(false));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx1 a;
        public final /* synthetic */ mq2 b;
        public final /* synthetic */ g54 c;

        public c(g54 g54Var, xx1 xx1Var, mq2 mq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g54Var, xx1Var, mq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g54Var;
            this.a = xx1Var;
            this.b = mq2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                b84.a(this.a, true, new i54(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947744899, "Lcom/baidu/tieba/g54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947744899, "Lcom/baidu/tieba/g54;");
                return;
            }
        }
        b = am1.a;
    }

    public g54() {
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

    public final void c(xx1 xx1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, xx1Var, str) == null) {
            yz3 yz3Var = new yz3();
            yz3Var.errMsg = str;
            b84.a(xx1Var, false, yz3Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            xx1 G = xx1.G(jsObject);
            if (G == null) {
                G = new xx1();
            }
            xx1 xx1Var = G;
            p53 q = o53.K().q();
            if (!q.I()) {
                c(xx1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity w = q.w();
            mq2.a X = q.X();
            if (w == null) {
                c(xx1Var, "reload failed, api internal error.");
                return;
            }
            String C = xx1Var.C("content");
            if (TextUtils.isEmpty(C)) {
                C = w.getString(R.string.obfuscated_res_0x7f0f01b1);
            }
            jj3.e0(new a(this, w, C, xx1Var, X));
        }
    }

    public final void e(@NonNull mq2 mq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mq2Var) == null) {
            String I = mq2Var.I();
            String i1 = nq2.i1(mq2Var.I(), mq2Var.U(), mq2Var.H());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, I);
            bundle.putString("scheme", i1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + mq2Var.I());
            }
            k23.Q().W(bundle, h54.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull xx1 xx1Var, @NonNull mq2 mq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, xx1Var, mq2Var) == null) {
            t43 t43Var = this.a;
            if (t43Var != null && t43Var.isShowing()) {
                c(xx1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            t43.a aVar = new t43.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f01b2);
            aVar.x(str);
            aVar.a();
            aVar.n(new xk3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f0141, new b(this, xx1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f01d1, new c(this, xx1Var, mq2Var));
            this.a = aVar.X();
        }
    }
}
