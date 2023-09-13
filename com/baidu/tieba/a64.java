package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.da2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements da2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ o32 c;
        public final /* synthetic */ a64 d;

        public a(a64 a64Var, boolean z, Context context, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a64Var, Boolean.valueOf(z), context, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a64Var;
            this.a = z;
            this.b = context;
            this.c = o32Var;
        }

        @Override // com.baidu.tieba.da2.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (!this.a) {
                        e82.c(this.b, false);
                        this.d.e(this.c, true, "setEnableDebug:ok");
                        return;
                    }
                    this.d.g(this.b, this.c);
                    return;
                }
                da2.c(this.b, str);
                a64 a64Var = this.d;
                a64Var.e(this.c, false, a64Var.f(str));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements aq3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ o32 b;
        public final /* synthetic */ a64 c;

        public b(a64 a64Var, Context context, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a64Var, context, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a64Var;
            this.a = context;
            this.b = o32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (bool.booleanValue()) {
                    e82.c(this.a, true);
                    this.c.e(this.b, true, "setEnableDebug:ok");
                    return;
                }
                y54.m().p((Activity) this.a, null);
                this.c.e(this.b, false, "internet error");
            }
        }
    }

    public a64(ri2 ri2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ri2Var};
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

    public final void d(@NonNull hb3 hb3Var, @NonNull Context context, @NonNull o32 o32Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{hb3Var, context, o32Var, Boolean.valueOf(z)}) == null) {
            da2.a(hb3Var, context, new a(this, z, context, o32Var));
        }
    }

    public final void e(o32 o32Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{o32Var, Boolean.valueOf(z), str}) == null) {
            q54 q54Var = new q54();
            q54Var.errMsg = str;
            td4.call(o32Var, z, q54Var);
        }
    }

    public final void g(Context context, o32 o32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, o32Var) == null) {
            y54.m().o(new b(this, context, o32Var));
        }
    }

    public static void h(JSONObject jSONObject) {
        hb3 M;
        SwanAppActivity w;
        pi2 g1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) != null) || (M = hb3.M()) == null || !M.w0() || (w = M.w()) == null) {
            return;
        }
        go2 Q = w.Q();
        if (!(Q instanceof i74) || (g1 = ((i74) Q).g1()) == null) {
            return;
        }
        g1.dispatchEvent(v54.a(jSONObject));
    }

    public void i(JsObject jsObject) {
        o32 F;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jsObject) != null) || (F = o32.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        hb3 M = hb3.M();
        if (M == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity w = M.w();
        if (w == null) {
            e(F, false, f("internal error"));
        } else if (l == e82.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(M, w, F, l);
        }
    }
}
