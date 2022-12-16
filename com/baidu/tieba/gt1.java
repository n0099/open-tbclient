package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.tieba.j93;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gt1 extends xs1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppWebPopWindow f;
    public t32 g;
    public k32 h;

    @Override // com.baidu.tieba.hs1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "WebPopWindowApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ e43 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ gt1 e;

        /* loaded from: classes4.dex */
        public class a extends t32 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.t32, com.baidu.tieba.u32
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.b();
                    e12.i("WebPopWindowApi", "swanId=" + this.a.b.b + ", nowId=" + e43.g0());
                    if (TextUtils.equals(this.a.b.b, e43.g0())) {
                        return;
                    }
                    this.a.e.H();
                }
            }

            @Override // com.baidu.tieba.t32, com.baidu.tieba.u32
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    e12.i("WebPopWindowApi", "call onFragmentDestroyed");
                    this.a.e.H();
                    if (this.a.e.h != null && this.a.e.g != null) {
                        this.a.e.h.R2(this.a.e.g);
                    }
                }
            }
        }

        public b(gt1 gt1Var, String str, e43 e43Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt1Var, str, e43Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gt1Var;
            this.a = str;
            this.b = e43Var;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (activity = rp2.U().getActivity()) == null) {
                return;
            }
            if (this.e.f != null && this.e.f.x()) {
                this.e.d(this.a, new ew1(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            n32 V = rp2.U().V();
            if (V == null) {
                return;
            }
            this.e.h = V.m();
            if (this.e.h == null) {
                return;
            }
            if (this.e.g != null) {
                this.e.h.R2(this.e.g);
            }
            this.e.g = new a(this);
            this.e.h.n2(this.e.g);
            gt1 gt1Var = this.e;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.c);
            swanAppWebPopWindow.r0(R.string.obfuscated_res_0x7f0f12c3);
            gt1Var.f = swanAppWebPopWindow;
            if (TextUtils.equals(this.d, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.e.f;
                swanAppWebPopWindow2.n0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.o0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.e.f;
            swanAppWebPopWindow3.m0();
            swanAppWebPopWindow3.t0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e) {
                if (gt1.i) {
                    e.printStackTrace();
                }
            }
            this.e.d(this.a, new ew1(0, "show halfScreenWebview success", jSONObject));
        }
    }

    /* loaded from: classes4.dex */
    public class a implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ e43 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ gt1 d;

        public a(gt1 gt1Var, String str, e43 e43Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt1Var, str, e43Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gt1Var;
            this.a = str;
            this.b = e43Var;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (!c93.h(h93Var)) {
                    this.d.d(this.a, new ew1(10005, "system deny"));
                } else {
                    this.d.I(this.b, this.c, this.a);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947805349, "Lcom/baidu/tieba/gt1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947805349, "Lcom/baidu/tieba/gt1;");
                return;
            }
        }
        i = ok1.a;
    }

    public final void H() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.h.U() && (swanAppWebPopWindow = this.f) != null) {
            swanAppWebPopWindow.r();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt1(@NonNull fs1 fs1Var) {
        super(fs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((fs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void G(e43 e43Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, e43Var, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                e43Var.e0().g(getContext(), "scope_web_window_pay_protected", new a(this, str2, e43Var, str));
            } else {
                d(str2, new ew1(202, "type is invalid"));
            }
        }
    }

    public final void I(e43 e43Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, e43Var, str, str2) == null) {
            String J = J(e43Var, str);
            if (J == null) {
                d(str2, new ew1(202, "type is invalid"));
            } else {
                yh3.e0(new b(this, str2, e43Var, J, str));
            }
        }
    }

    public final String J(e43 e43Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, e43Var, str)) == null) {
            if (TextUtils.equals(str, "protect") && e43Var != null) {
                return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + e43Var.O();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public ew1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#showHalfScreenWebview", false);
            if (i) {
                Log.d("WebPopWindowApi", "#showHalfScreenWebview params=" + str);
            }
            e43 b0 = e43.b0();
            if (b0 == null) {
                return new ew1(202, "swan app is null");
            }
            Pair<ew1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((ew1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new ew1(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new ew1(202, "cb is invalid");
                }
                G(b0, optString, optString2);
                return ew1.f();
            }
            return new ew1(202);
        }
        return (ew1) invokeL.objValue;
    }
}
