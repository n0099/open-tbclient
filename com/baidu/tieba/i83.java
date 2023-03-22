package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes4.dex */
public class i83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final h83<i83> u;
    public static final g83<i83> v;
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

    /* loaded from: classes4.dex */
    public static class a extends h83<i83> {
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
        @Override // com.baidu.tieba.h83
        /* renamed from: b */
        public void a(@NonNull i83 i83Var, @NonNull zq2 zq2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i83Var, zq2Var) == null) {
                zq2Var.writeInt(i83Var.a);
                zq2Var.f(i83Var.b);
                zq2Var.f(i83Var.c);
                zq2Var.f(i83Var.d);
                zq2Var.writeInt(i83Var.e);
                zq2Var.writeBoolean(i83Var.f);
                zq2Var.f(i83Var.g);
                zq2Var.writeBoolean(i83Var.h);
                zq2Var.writeBoolean(i83Var.i);
                zq2Var.f(i83Var.j);
                zq2Var.writeBoolean(i83Var.k);
                zq2Var.writeBoolean(i83Var.l);
                zq2Var.writeBoolean(i83Var.m);
                zq2Var.writeBoolean(i83Var.n);
                zq2Var.writeBoolean(i83Var.o);
                zq2Var.writeBoolean(i83Var.p);
                zq2Var.f(i83Var.q);
                zq2Var.f(i83Var.r);
                zq2Var.f(i83Var.s);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends g83<i83> {
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
        @Override // com.baidu.tieba.g83
        /* renamed from: b */
        public i83 a(@NonNull yq2 yq2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yq2Var)) == null) {
                i83 i83Var = new i83();
                i83Var.a = yq2Var.readInt();
                i83Var.b = yq2Var.g();
                i83Var.c = yq2Var.g();
                i83Var.d = yq2Var.g();
                i83Var.e = yq2Var.readInt();
                i83Var.f = yq2Var.readBoolean();
                i83Var.g = yq2Var.g();
                i83Var.h = yq2Var.readBoolean();
                i83Var.i = yq2Var.readBoolean();
                i83Var.j = yq2Var.g();
                i83Var.k = yq2Var.readBoolean();
                i83Var.l = yq2Var.readBoolean();
                i83Var.m = yq2Var.readBoolean();
                i83Var.n = yq2Var.readBoolean();
                i83Var.o = yq2Var.readBoolean();
                i83Var.p = yq2Var.readBoolean();
                i83Var.q = yq2Var.g();
                i83Var.r = yq2Var.g();
                i83Var.s = yq2Var.g();
                return i83Var;
            }
            return (i83) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947807333, "Lcom/baidu/tieba/i83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947807333, "Lcom/baidu/tieba/i83;");
                return;
            }
        }
        t = do1.a;
        u = new a();
        v = new b();
    }

    public i83() {
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

    public static i83 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new i83();
        }
        return (i83) invokeV.objValue;
    }

    public static i83 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (i83) invokeL.objValue;
    }

    public static boolean f(i83 i83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, i83Var)) == null) {
            if (i83Var == null) {
                return false;
            }
            if (!i83Var.h && !TextUtils.equals(i83Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static i83 b(String str, @NonNull i83 i83Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, i83Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i83Var;
            }
            try {
                return e(new JSONObject(str), i83Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return i83Var;
            }
        }
        return (i83) invokeLL.objValue;
    }

    public static i83 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            i83 i83Var = new i83();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            i83Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            i83Var.c = optString2;
            i83Var.b = optJSONObject.optString("navigationBarTitleText");
            i83Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            i83Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            i83Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            i83Var.g = optJSONObject.optString("onReachBottomDistance");
            i83Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            i83Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            i83Var.j = optJSONObject.optString("navigationStyle", "default");
            i83Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            i83Var.q = optJSONObject.optString("textSizeAdjust");
            i83Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return i83Var;
        }
        return (i83) invokeL.objValue;
    }

    public static i83 e(JSONObject jSONObject, @NonNull i83 i83Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, i83Var)) == null) {
            i83 i83Var2 = new i83();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = i83Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            i83Var2.a = t2;
            i83Var2.b = jSONObject.optString("navigationBarTitleText", i83Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = i83Var.c;
            }
            i83Var2.c = optString2;
            i83Var2.d = jSONObject.optString("backgroundTextStyle", i83Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = i83Var.e;
            }
            i83Var2.e = i;
            i83Var2.f = jSONObject.optBoolean("enablePullDownRefresh", i83Var.f);
            i83Var2.g = jSONObject.optString("onReachBottomDistance", i83Var.g);
            i83Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", i83Var.h);
            i83Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", i83Var.i);
            i83Var2.j = jSONObject.optString("navigationStyle", i83Var.j);
            i83Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", i83Var.k);
            i83Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            i83Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            i83Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            i83Var2.o = jSONObject.optBoolean("_hasVideo", false);
            i83Var2.r = jSONObject.optString("viewMode", i83Var.r);
            i83Var2.s = jSONObject.optString("htmlFontSize", i83Var.s);
            jSONObject.optJSONArray("fontFace");
            return i83Var2;
        }
        return (i83) invokeLL.objValue;
    }
}
