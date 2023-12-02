package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.g52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements g52.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ sy1 c;
        public final /* synthetic */ d14 d;

        public a(d14 d14Var, boolean z, Context context, sy1 sy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d14Var, Boolean.valueOf(z), context, sy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = d14Var;
            this.a = z;
            this.b = context;
            this.c = sy1Var;
        }

        @Override // com.baidu.tieba.g52.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (!this.a) {
                        h32.c(this.b, false);
                        this.d.e(this.c, true, "setEnableDebug:ok");
                        return;
                    }
                    this.d.g(this.b, this.c);
                    return;
                }
                g52.c(this.b, str);
                d14 d14Var = this.d;
                d14Var.e(this.c, false, d14Var.f(str));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dl3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ sy1 b;
        public final /* synthetic */ d14 c;

        public b(d14 d14Var, Context context, sy1 sy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d14Var, context, sy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d14Var;
            this.a = context;
            this.b = sy1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (bool.booleanValue()) {
                    h32.c(this.a, true);
                    this.c.e(this.b, true, "setEnableDebug:ok");
                    return;
                }
                b14.m().p((Activity) this.a, null);
                this.c.e(this.b, false, "internet error");
            }
        }
    }

    public d14(ud2 ud2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ud2Var};
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

    public final void d(@NonNull k63 k63Var, @NonNull Context context, @NonNull sy1 sy1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{k63Var, context, sy1Var, Boolean.valueOf(z)}) == null) {
            g52.a(k63Var, context, new a(this, z, context, sy1Var));
        }
    }

    public final void e(sy1 sy1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{sy1Var, Boolean.valueOf(z), str}) == null) {
            t04 t04Var = new t04();
            t04Var.errMsg = str;
            w84.a(sy1Var, z, t04Var);
        }
    }

    public final void g(Context context, sy1 sy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, sy1Var) == null) {
            b14.m().o(new b(this, context, sy1Var));
        }
    }

    public static void h(JSONObject jSONObject) {
        k63 M;
        SwanAppActivity w;
        sd2 h1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) != null) || (M = k63.M()) == null || !M.x0() || (w = M.w()) == null) {
            return;
        }
        jj2 R = w.R();
        if (!(R instanceof l24) || (h1 = ((l24) R).h1()) == null) {
            return;
        }
        h1.dispatchEvent(y04.a(jSONObject));
    }

    public void i(JsObject jsObject) {
        sy1 G;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jsObject) != null) || (G = sy1.G(jsObject)) == null) {
            return;
        }
        boolean m = G.m("enableDebug");
        k63 M = k63.M();
        if (M == null) {
            e(G, false, f("internal error"));
            return;
        }
        SwanAppActivity w = M.w();
        if (w == null) {
            e(G, false, f("internal error"));
        } else if (m == h32.a()) {
            e(G, true, "setEnableDebug:ok");
        } else {
            d(M, w, G, m);
        }
    }
}
