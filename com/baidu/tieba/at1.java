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
/* loaded from: classes3.dex */
public class at1 extends xs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hs1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k32 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ at1 d;

        public a(at1 at1Var, k32 k32Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at1Var, k32Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = at1Var;
            this.a = k32Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k32 k32Var = this.a;
                boolean z = true;
                if (!((k32Var == null || !k32Var.w2(this.b, true)) ? false : false)) {
                    e12.c("NavigationBarApi", "set title fail");
                    this.d.d(this.c, new ew1(1001));
                }
                this.d.d(this.c, new ew1(0));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k32 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ at1 f;

        public b(at1 at1Var, k32 k32Var, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at1Var, k32Var, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = at1Var;
            this.a = k32Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k32 k32Var = this.a;
                if (k32Var != null && k32Var.E2(this.b, true)) {
                    if (!this.a.u2(SwanAppConfigData.t(this.d), true)) {
                        e12.c("NavigationBarApi", "set title background fail");
                        this.f.d(this.c, new ew1(1001));
                        return;
                    }
                    JSONObject jSONObject = this.e;
                    if (jSONObject != null) {
                        this.a.s2(jSONObject.optInt("duration"), this.e.optString("timingFunc"));
                        e12.i("NavigationBarApi", "set action bar animator");
                    }
                    this.f.d(this.c, new ew1(0));
                    return;
                }
                e12.c("NavigationBarApi", "set title color fail");
                this.f.d(this.c, new ew1(1001));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k32 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ at1 d;

        public c(at1 at1Var, k32 k32Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at1Var, k32Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = at1Var;
            this.a = k32Var;
            this.b = str;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean S1;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k32 k32Var = this.a;
                if (k32Var == null) {
                    e12.c("NavigationBarApi", "swanAppFragment is null");
                    this.d.d(this.b, new ew1(1001));
                    return;
                }
                if (this.c) {
                    S1 = k32Var.N2();
                } else {
                    S1 = k32Var.S1();
                }
                if (!S1) {
                    if (this.c) {
                        str = "show";
                    } else {
                        str = "hide";
                    }
                    e12.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.d.d(this.b, new ew1(1001));
                    return;
                }
                this.d.d(this.b, new ew1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at1(@NonNull fs1 fs1Var) {
        super(fs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ew1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#showNavigationBarLoading", false);
            e43 b0 = e43.b0();
            if (b0 != null && b0.n0()) {
                return new ew1(1001, "ui operation does not supported when app is invisible.");
            }
            return x(str, true);
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#setNavigationBarTitle", false);
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (!ew1Var.isSuccess()) {
                return ew1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return new ew1(1001);
            }
            String optString = jSONObject.optString("title");
            n32 V = rp2.U().V();
            if (V == null) {
                e12.c("NavigationBarApi", "manager is null");
                return new ew1(1001);
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                p("cb is empty", null, true);
                return new ew1(1001, "cb is empty");
            }
            yh3.e0(new a(this, V.m(), optString, optString2));
            return ew1.f();
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#setNavigationBarColor", false);
            n32 V = rp2.U().V();
            if (V == null) {
                e12.c("NavigationBarApi", "manager is null");
                return new ew1(1001);
            }
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (!ew1Var.isSuccess()) {
                return ew1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("cb is empty", null, true);
                return new ew1(1001, "cb is empty");
            }
            yh3.e0(new b(this, V.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), jSONObject.optJSONObject("animation")));
            return ew1.f();
        }
        return (ew1) invokeL.objValue;
    }

    public final ew1 x(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            n32 V = rp2.U().V();
            if (V == null) {
                e12.c("NavigationBarApi", "manager is null");
                return new ew1(1001);
            }
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (!ew1Var.isSuccess()) {
                return ew1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("cb is empty", null, true);
                return new ew1(1001, "cb is empty");
            }
            yh3.e0(new c(this, V.m(), optString, z));
            return ew1.f();
        }
        return (ew1) invokeLZ.objValue;
    }

    public ew1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#hideNavigationBarLoading", false);
            return x(str, false);
        }
        return (ew1) invokeL.objValue;
    }
}
