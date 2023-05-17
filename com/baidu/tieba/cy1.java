package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cy1 extends zx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jx1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m82 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ cy1 d;

        public a(cy1 cy1Var, m82 m82Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cy1Var, m82Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cy1Var;
            this.a = m82Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m82 m82Var = this.a;
                boolean z = true;
                if (!((m82Var == null || !m82Var.z2(this.b, true)) ? false : false)) {
                    g62.c("NavigationBarApi", "set title fail");
                    this.d.d(this.c, new g12(1001));
                }
                this.d.d(this.c, new g12(0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m82 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ cy1 f;

        public b(cy1 cy1Var, m82 m82Var, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cy1Var, m82Var, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cy1Var;
            this.a = m82Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m82 m82Var = this.a;
                if (m82Var != null && m82Var.H2(this.b, true)) {
                    if (!this.a.x2(SwanAppConfigData.t(this.d), true)) {
                        g62.c("NavigationBarApi", "set title background fail");
                        this.f.d(this.c, new g12(1001));
                        return;
                    }
                    JSONObject jSONObject = this.e;
                    if (jSONObject != null) {
                        this.a.v2(jSONObject.optInt("duration"), this.e.optString("timingFunc"));
                        g62.i("NavigationBarApi", "set action bar animator");
                    }
                    this.f.d(this.c, new g12(0));
                    return;
                }
                g62.c("NavigationBarApi", "set title color fail");
                this.f.d(this.c, new g12(1001));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m82 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ cy1 d;

        public c(cy1 cy1Var, m82 m82Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cy1Var, m82Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cy1Var;
            this.a = m82Var;
            this.b = str;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean V1;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m82 m82Var = this.a;
                if (m82Var == null) {
                    g62.c("NavigationBarApi", "swanAppFragment is null");
                    this.d.d(this.b, new g12(1001));
                    return;
                }
                if (this.c) {
                    V1 = m82Var.Q2();
                } else {
                    V1 = m82Var.V1();
                }
                if (!V1) {
                    if (this.c) {
                        str = "show";
                    } else {
                        str = "hide";
                    }
                    g62.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.d.d(this.b, new g12(1001));
                    return;
                }
                this.d.d(this.b, new g12(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cy1(@NonNull hx1 hx1Var) {
        super(hx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hx1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public g12 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#showNavigationBarLoading", false);
            g93 b0 = g93.b0();
            if (b0 != null && b0.n0()) {
                return new g12(1001, "ui operation does not supported when app is invisible.");
            }
            return x(str, true);
        }
        return (g12) invokeL.objValue;
    }

    public g12 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#setNavigationBarTitle", false);
            Pair<g12, JSONObject> s = s(str);
            g12 g12Var = (g12) s.first;
            if (!g12Var.isSuccess()) {
                return g12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return new g12(1001);
            }
            String optString = jSONObject.optString("title");
            p82 V = tu2.U().V();
            if (V == null) {
                g62.c("NavigationBarApi", "manager is null");
                return new g12(1001);
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                p("cb is empty", null, true);
                return new g12(1001, "cb is empty");
            }
            an3.e0(new a(this, V.m(), optString, optString2));
            return g12.f();
        }
        return (g12) invokeL.objValue;
    }

    public g12 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#setNavigationBarColor", false);
            p82 V = tu2.U().V();
            if (V == null) {
                g62.c("NavigationBarApi", "manager is null");
                return new g12(1001);
            }
            Pair<g12, JSONObject> s = s(str);
            g12 g12Var = (g12) s.first;
            if (!g12Var.isSuccess()) {
                return g12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("cb is empty", null, true);
                return new g12(1001, "cb is empty");
            }
            an3.e0(new b(this, V.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), jSONObject.optJSONObject("animation")));
            return g12.f();
        }
        return (g12) invokeL.objValue;
    }

    public final g12 x(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            p82 V = tu2.U().V();
            if (V == null) {
                g62.c("NavigationBarApi", "manager is null");
                return new g12(1001);
            }
            Pair<g12, JSONObject> s = s(str);
            g12 g12Var = (g12) s.first;
            if (!g12Var.isSuccess()) {
                return g12Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("cb is empty", null, true);
                return new g12(1001, "cb is empty");
            }
            an3.e0(new c(this, V.m(), optString, z));
            return g12.f();
        }
        return (g12) invokeLZ.objValue;
    }

    public g12 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#hideNavigationBarLoading", false);
            return x(str, false);
        }
        return (g12) invokeL.objValue;
    }
}
