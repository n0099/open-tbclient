package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.l42;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements l42.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ xx1 c;
        public final /* synthetic */ i04 d;

        public a(i04 i04Var, boolean z, Context context, xx1 xx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i04Var, Boolean.valueOf(z), context, xx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = i04Var;
            this.a = z;
            this.b = context;
            this.c = xx1Var;
        }

        @Override // com.baidu.tieba.l42.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (!this.a) {
                        m22.c(this.b, false);
                        this.d.e(this.c, true, "setEnableDebug:ok");
                        return;
                    }
                    this.d.g(this.b, this.c);
                    return;
                }
                l42.c(this.b, str);
                i04 i04Var = this.d;
                i04Var.e(this.c, false, i04Var.f(str));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ik3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ xx1 b;
        public final /* synthetic */ i04 c;

        public b(i04 i04Var, Context context, xx1 xx1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i04Var, context, xx1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i04Var;
            this.a = context;
            this.b = xx1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (bool.booleanValue()) {
                    m22.c(this.a, true);
                    this.c.e(this.b, true, "setEnableDebug:ok");
                    return;
                }
                g04.m().p((Activity) this.a, null);
                this.c.e(this.b, false, "internet error");
            }
        }
    }

    public i04(zc2 zc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return String.format("setEnableDebug:fail %s", str);
        }
        return (String) invokeL.objValue;
    }

    public final void d(@NonNull p53 p53Var, @NonNull Context context, @NonNull xx1 xx1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{p53Var, context, xx1Var, Boolean.valueOf(z)}) == null) {
            l42.a(p53Var, context, new a(this, z, context, xx1Var));
        }
    }

    public final void e(xx1 xx1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{xx1Var, Boolean.valueOf(z), str}) == null) {
            yz3 yz3Var = new yz3();
            yz3Var.errMsg = str;
            b84.a(xx1Var, z, yz3Var);
        }
    }

    public final void g(Context context, xx1 xx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, xx1Var) == null) {
            g04.m().o(new b(this, context, xx1Var));
        }
    }

    public static void h(JSONObject jSONObject) {
        p53 M;
        SwanAppActivity w;
        xc2 h1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) != null) || (M = p53.M()) == null || !M.x0() || (w = M.w()) == null) {
            return;
        }
        oi2 Q = w.Q();
        if (!(Q instanceof q14) || (h1 = ((q14) Q).h1()) == null) {
            return;
        }
        h1.dispatchEvent(d04.a(jSONObject));
    }

    public void i(JsObject jsObject) {
        xx1 G;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jsObject) != null) || (G = xx1.G(jsObject)) == null) {
            return;
        }
        boolean m = G.m("enableDebug");
        p53 M = p53.M();
        if (M == null) {
            e(G, false, f("internal error"));
            return;
        }
        SwanAppActivity w = M.w();
        if (w == null) {
            e(G, false, f("internal error"));
        } else if (m == m22.a()) {
            e(G, true, "setEnableDebug:ok");
        } else {
            d(M, w, G, m);
        }
    }
}
