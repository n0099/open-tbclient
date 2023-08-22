package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.tieba.ig3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f02 extends wz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppWebPopWindow f;
    public sa2 g;
    public ja2 h;

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "WebPopWindowApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ db3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ f02 e;

        /* loaded from: classes5.dex */
        public class a extends sa2 {
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

            @Override // com.baidu.tieba.sa2, com.baidu.tieba.ta2
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.b();
                    d82.i("WebPopWindowApi", "swanId=" + this.a.b.b + ", nowId=" + db3.g0());
                    if (TextUtils.equals(this.a.b.b, db3.g0())) {
                        return;
                    }
                    this.a.e.H();
                }
            }

            @Override // com.baidu.tieba.sa2, com.baidu.tieba.ta2
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d82.i("WebPopWindowApi", "call onFragmentDestroyed");
                    this.a.e.H();
                    if (this.a.e.h != null && this.a.e.g != null) {
                        this.a.e.h.T2(this.a.e.g);
                    }
                }
            }
        }

        public b(f02 f02Var, String str, db3 db3Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f02Var, str, db3Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = f02Var;
            this.a = str;
            this.b = db3Var;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (activity = qw2.T().getActivity()) == null) {
                return;
            }
            if (this.e.f != null && this.e.f.y()) {
                this.e.d(this.a, new d32(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            ma2 U = qw2.T().U();
            if (U == null) {
                return;
            }
            this.e.h = U.m();
            if (this.e.h == null) {
                return;
            }
            if (this.e.g != null) {
                this.e.h.T2(this.e.g);
            }
            this.e.g = new a(this);
            this.e.h.p2(this.e.g);
            f02 f02Var = this.e;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.c);
            swanAppWebPopWindow.s0(R.string.obfuscated_res_0x7f0f14a4);
            f02Var.f = swanAppWebPopWindow;
            if (TextUtils.equals(this.d, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.e.f;
                swanAppWebPopWindow2.o0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.p0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.e.f;
            swanAppWebPopWindow3.n0();
            swanAppWebPopWindow3.u0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e) {
                if (f02.i) {
                    e.printStackTrace();
                }
            }
            this.e.d(this.a, new d32(0, "show halfScreenWebview success", jSONObject));
        }
    }

    /* loaded from: classes5.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ db3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ f02 d;

        public a(f02 f02Var, String str, db3 db3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f02Var, str, db3Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = f02Var;
            this.a = str;
            this.b = db3Var;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!bg3.h(gg3Var)) {
                    this.d.d(this.a, new d32(10005, "system deny"));
                } else {
                    this.d.I(this.b, this.c, this.a);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947710241, "Lcom/baidu/tieba/f02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947710241, "Lcom/baidu/tieba/f02;");
                return;
            }
        }
        i = nr1.a;
    }

    public final void H() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.h.Z() && (swanAppWebPopWindow = this.f) != null) {
            swanAppWebPopWindow.q();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f02(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void G(db3 db3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, db3Var, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                db3Var.e0().g(getContext(), "scope_web_window_pay_protected", new a(this, str2, db3Var, str));
            } else {
                d(str2, new d32(202, "type is invalid"));
            }
        }
    }

    public final void I(db3 db3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, db3Var, str, str2) == null) {
            String J = J(db3Var, str);
            if (J == null) {
                d(str2, new d32(202, "type is invalid"));
            } else {
                xo3.e0(new b(this, str2, db3Var, J, str));
            }
        }
    }

    public final String J(db3 db3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, db3Var, str)) == null) {
            if (TextUtils.equals(str, "protect") && db3Var != null) {
                return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + db3Var.O();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public d32 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#showHalfScreenWebview", false);
            if (i) {
                Log.d("WebPopWindowApi", "#showHalfScreenWebview params=" + str);
            }
            db3 b0 = db3.b0();
            if (b0 == null) {
                return new d32(202, "swan app is null");
            }
            Pair<d32, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((d32) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new d32(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new d32(202, "cb is invalid");
                }
                G(b0, optString, optString2);
                return d32.f();
            }
            return new d32(202);
        }
        return (d32) invokeL.objValue;
    }
}
