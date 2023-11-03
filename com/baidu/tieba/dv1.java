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
public class dv1 extends av1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m52 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ dv1 d;

        public a(dv1 dv1Var, m52 m52Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv1Var, m52Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dv1Var;
            this.a = m52Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m52 m52Var = this.a;
                boolean z = true;
                if (!((m52Var == null || !m52Var.D2(this.b, true)) ? false : false)) {
                    g32.c("NavigationBarApi", "set title fail");
                    this.d.d(this.c, new hy1(1001));
                }
                this.d.d(this.c, new hy1(0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m52 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ dv1 f;

        public b(dv1 dv1Var, m52 m52Var, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv1Var, m52Var, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = dv1Var;
            this.a = m52Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m52 m52Var = this.a;
                if (m52Var != null && m52Var.L2(this.b, true)) {
                    if (!this.a.B2(SwanAppConfigData.t(this.d), true)) {
                        g32.c("NavigationBarApi", "set title background fail");
                        this.f.d(this.c, new hy1(1001));
                        return;
                    }
                    JSONObject jSONObject = this.e;
                    if (jSONObject != null) {
                        this.a.z2(jSONObject.optInt("duration"), this.e.optString("timingFunc"));
                        g32.i("NavigationBarApi", "set action bar animator");
                    }
                    this.f.d(this.c, new hy1(0));
                    return;
                }
                g32.c("NavigationBarApi", "set title color fail");
                this.f.d(this.c, new hy1(1001));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m52 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ dv1 d;

        public c(dv1 dv1Var, m52 m52Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv1Var, m52Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dv1Var;
            this.a = m52Var;
            this.b = str;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean Y1;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m52 m52Var = this.a;
                if (m52Var == null) {
                    g32.c("NavigationBarApi", "swanAppFragment is null");
                    this.d.d(this.b, new hy1(1001));
                    return;
                }
                if (this.c) {
                    Y1 = m52Var.U2();
                } else {
                    Y1 = m52Var.Y1();
                }
                if (!Y1) {
                    if (this.c) {
                        str = "show";
                    } else {
                        str = "hide";
                    }
                    g32.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.d.d(this.b, new hy1(1001));
                    return;
                }
                this.d.d(this.b, new hy1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dv1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public hy1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#showNavigationBarLoading", false);
            g63 c0 = g63.c0();
            if (c0 != null && c0.o0()) {
                return new hy1(1001, "ui operation does not supported when app is invisible.");
            }
            return y(str, true);
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#setNavigationBarColor", false);
            p52 W = tr2.V().W();
            if (W == null) {
                g32.c("NavigationBarApi", "manager is null");
                return new hy1(1001);
            }
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                q("cb is empty", null, true);
                return new hy1(1001, "cb is empty");
            }
            ak3.e0(new b(this, W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), jSONObject.optJSONObject("animation")));
            return hy1.f();
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#setNavigationBarTitle", false);
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            if (jSONObject == null) {
                return new hy1(1001);
            }
            String optString = jSONObject.optString("title");
            p52 W = tr2.V().W();
            if (W == null) {
                g32.c("NavigationBarApi", "manager is null");
                return new hy1(1001);
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                q("cb is empty", null, true);
                return new hy1(1001, "cb is empty");
            }
            ak3.e0(new a(this, W.m(), optString, optString2));
            return hy1.f();
        }
        return (hy1) invokeL.objValue;
    }

    public final hy1 y(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            p52 W = tr2.V().W();
            if (W == null) {
                g32.c("NavigationBarApi", "manager is null");
                return new hy1(1001);
            }
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                q("cb is empty", null, true);
                return new hy1(1001, "cb is empty");
            }
            ak3.e0(new c(this, W.m(), optString, z));
            return hy1.f();
        }
        return (hy1) invokeLZ.objValue;
    }

    public hy1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            r("#hideNavigationBarLoading", false);
            return y(str, false);
        }
        return (hy1) invokeL.objValue;
    }
}
