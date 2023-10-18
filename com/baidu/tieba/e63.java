package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final d63<e63> u;
    public static final c63<e63> v;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public int e;
    public boolean f;
    public String g;
    public boolean h;
    public boolean i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public String s;

    /* loaded from: classes5.dex */
    public static class a extends d63<e63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.d63
        /* renamed from: c */
        public void b(@NonNull e63 e63Var, @NonNull vo2 vo2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e63Var, vo2Var) == null) {
                vo2Var.writeInt(e63Var.a);
                vo2Var.f(e63Var.b);
                vo2Var.f(e63Var.c);
                vo2Var.f(e63Var.d);
                vo2Var.writeInt(e63Var.e);
                vo2Var.writeBoolean(e63Var.f);
                vo2Var.f(e63Var.g);
                vo2Var.writeBoolean(e63Var.h);
                vo2Var.writeBoolean(e63Var.i);
                vo2Var.f(e63Var.j);
                vo2Var.writeBoolean(e63Var.k);
                vo2Var.writeBoolean(e63Var.l);
                vo2Var.writeBoolean(e63Var.m);
                vo2Var.writeBoolean(e63Var.n);
                vo2Var.writeBoolean(e63Var.o);
                vo2Var.writeBoolean(e63Var.p);
                vo2Var.f(e63Var.q);
                vo2Var.f(e63Var.r);
                vo2Var.f(e63Var.s);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends c63<e63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c63
        /* renamed from: c */
        public e63 b(@NonNull uo2 uo2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uo2Var)) == null) {
                e63 e63Var = new e63();
                e63Var.a = uo2Var.readInt();
                e63Var.b = uo2Var.g();
                e63Var.c = uo2Var.g();
                e63Var.d = uo2Var.g();
                e63Var.e = uo2Var.readInt();
                e63Var.f = uo2Var.readBoolean();
                e63Var.g = uo2Var.g();
                e63Var.h = uo2Var.readBoolean();
                e63Var.i = uo2Var.readBoolean();
                e63Var.j = uo2Var.g();
                e63Var.k = uo2Var.readBoolean();
                e63Var.l = uo2Var.readBoolean();
                e63Var.m = uo2Var.readBoolean();
                e63Var.n = uo2Var.readBoolean();
                e63Var.o = uo2Var.readBoolean();
                e63Var.p = uo2Var.readBoolean();
                e63Var.q = uo2Var.g();
                e63Var.r = uo2Var.g();
                e63Var.s = uo2Var.g();
                return e63Var;
            }
            return (e63) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947686247, "Lcom/baidu/tieba/e63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947686247, "Lcom/baidu/tieba/e63;");
                return;
            }
        }
        t = am1.a;
        u = new a();
        v = new b();
    }

    public e63() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = false;
        this.p = false;
        this.a = -16777216;
        this.c = "#ffffff";
        this.j = "default";
        this.e = -1;
        this.f = false;
    }

    public static e63 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new e63();
        }
        return (e63) invokeV.objValue;
    }

    public static e63 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (e63) invokeL.objValue;
    }

    public static boolean f(e63 e63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, e63Var)) == null) {
            if (e63Var == null) {
                return false;
            }
            if (!e63Var.h && !TextUtils.equals(e63Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && !this.p) {
            this.p = true;
        }
    }

    public static e63 b(String str, @NonNull e63 e63Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, e63Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return e63Var;
            }
            try {
                return e(new JSONObject(str), e63Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return e63Var;
            }
        }
        return (e63) invokeLL.objValue;
    }

    public static e63 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (optJSONObject == null) {
                return d();
            }
            e63 e63Var = new e63();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            e63Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            e63Var.c = optString2;
            e63Var.b = optJSONObject.optString("navigationBarTitleText");
            e63Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            e63Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            e63Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            e63Var.g = optJSONObject.optString("onReachBottomDistance");
            e63Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            e63Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            e63Var.j = optJSONObject.optString("navigationStyle", "default");
            e63Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            e63Var.q = optJSONObject.optString("textSizeAdjust");
            e63Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return e63Var;
        }
        return (e63) invokeL.objValue;
    }

    public static e63 e(JSONObject jSONObject, @NonNull e63 e63Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, e63Var)) == null) {
            e63 e63Var2 = new e63();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = e63Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            e63Var2.a = t2;
            e63Var2.b = jSONObject.optString("navigationBarTitleText", e63Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = e63Var.c;
            }
            e63Var2.c = optString2;
            e63Var2.d = jSONObject.optString("backgroundTextStyle", e63Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = e63Var.e;
            }
            e63Var2.e = i;
            e63Var2.f = jSONObject.optBoolean("enablePullDownRefresh", e63Var.f);
            e63Var2.g = jSONObject.optString("onReachBottomDistance", e63Var.g);
            e63Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", e63Var.h);
            e63Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", e63Var.i);
            e63Var2.j = jSONObject.optString("navigationStyle", e63Var.j);
            e63Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", e63Var.k);
            e63Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            e63Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            e63Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            e63Var2.o = jSONObject.optBoolean("_hasVideo", false);
            e63Var2.r = jSONObject.optString("viewMode", e63Var.r);
            e63Var2.s = jSONObject.optString("htmlFontSize", e63Var.s);
            jSONObject.optJSONArray("fontFace");
            return e63Var2;
        }
        return (e63) invokeLL.objValue;
    }
}
