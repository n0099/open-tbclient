package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.h22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ey3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements h22.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ sv1 c;
        public final /* synthetic */ ey3 d;

        public a(ey3 ey3Var, boolean z, Context context, sv1 sv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey3Var, Boolean.valueOf(z), context, sv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ey3Var;
            this.a = z;
            this.b = context;
            this.c = sv1Var;
        }

        @Override // com.baidu.tieba.h22.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.a) {
                        this.d.g(this.b, this.c);
                        return;
                    }
                    i02.c(this.b, false);
                    this.d.e(this.c, true, "setEnableDebug:ok");
                    return;
                }
                h22.c(this.b, str);
                ey3 ey3Var = this.d;
                ey3Var.e(this.c, false, ey3Var.f(str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ei3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ sv1 b;
        public final /* synthetic */ ey3 c;

        public b(ey3 ey3Var, Context context, sv1 sv1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey3Var, context, sv1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ey3Var;
            this.a = context;
            this.b = sv1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (bool.booleanValue()) {
                    i02.c(this.a, true);
                    this.c.e(this.b, true, "setEnableDebug:ok");
                    return;
                }
                cy3.m().p((Activity) this.a, null);
                this.c.e(this.b, false, "internet error");
            }
        }
    }

    public ey3(va2 va2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {va2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void h(JSONObject jSONObject) {
        l33 M;
        SwanAppActivity w;
        ta2 g1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (M = l33.M()) == null || !M.w0() || (w = M.w()) == null) {
            return;
        }
        kg2 Q = w.Q();
        if ((Q instanceof mz3) && (g1 = ((mz3) Q).g1()) != null) {
            g1.dispatchEvent(zx3.a(jSONObject));
        }
    }

    public final void d(@NonNull l33 l33Var, @NonNull Context context, @NonNull sv1 sv1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{l33Var, context, sv1Var, Boolean.valueOf(z)}) == null) {
            h22.a(l33Var, context, new a(this, z, context, sv1Var));
        }
    }

    public final void e(sv1 sv1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{sv1Var, Boolean.valueOf(z), str}) == null) {
            ux3 ux3Var = new ux3();
            ux3Var.errMsg = str;
            x54.call(sv1Var, z, ux3Var);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, sv1 sv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, sv1Var) == null) {
            cy3.m().o(new b(this, context, sv1Var));
        }
    }

    public void i(JsObject jsObject) {
        sv1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (F = sv1.F(jsObject)) == null) {
            return;
        }
        boolean l = F.l("enableDebug");
        l33 M = l33.M();
        if (M == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity w = M.w();
        if (w == null) {
            e(F, false, f("internal error"));
        } else if (l == i02.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(M, w, F, l);
        }
    }
}
