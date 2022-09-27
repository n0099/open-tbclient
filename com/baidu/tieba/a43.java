package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class a43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final z33<a43> u;
    public static final y33<a43> v;
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

    /* loaded from: classes3.dex */
    public static class a extends z33<a43> {
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
        @Override // com.baidu.tieba.z33
        /* renamed from: b */
        public void a(@NonNull a43 a43Var, @NonNull rm2 rm2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a43Var, rm2Var) == null) {
                rm2Var.writeInt(a43Var.a);
                rm2Var.f(a43Var.b);
                rm2Var.f(a43Var.c);
                rm2Var.f(a43Var.d);
                rm2Var.writeInt(a43Var.e);
                rm2Var.writeBoolean(a43Var.f);
                rm2Var.f(a43Var.g);
                rm2Var.writeBoolean(a43Var.h);
                rm2Var.writeBoolean(a43Var.i);
                rm2Var.f(a43Var.j);
                rm2Var.writeBoolean(a43Var.k);
                rm2Var.writeBoolean(a43Var.l);
                rm2Var.writeBoolean(a43Var.m);
                rm2Var.writeBoolean(a43Var.n);
                rm2Var.writeBoolean(a43Var.o);
                rm2Var.writeBoolean(a43Var.p);
                rm2Var.f(a43Var.q);
                rm2Var.f(a43Var.r);
                rm2Var.f(a43Var.s);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends y33<a43> {
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
        @Override // com.baidu.tieba.y33
        /* renamed from: b */
        public a43 a(@NonNull qm2 qm2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qm2Var)) == null) {
                a43 a43Var = new a43();
                a43Var.a = qm2Var.readInt();
                a43Var.b = qm2Var.g();
                a43Var.c = qm2Var.g();
                a43Var.d = qm2Var.g();
                a43Var.e = qm2Var.readInt();
                a43Var.f = qm2Var.readBoolean();
                a43Var.g = qm2Var.g();
                a43Var.h = qm2Var.readBoolean();
                a43Var.i = qm2Var.readBoolean();
                a43Var.j = qm2Var.g();
                a43Var.k = qm2Var.readBoolean();
                a43Var.l = qm2Var.readBoolean();
                a43Var.m = qm2Var.readBoolean();
                a43Var.n = qm2Var.readBoolean();
                a43Var.o = qm2Var.readBoolean();
                a43Var.p = qm2Var.readBoolean();
                a43Var.q = qm2Var.g();
                a43Var.r = qm2Var.g();
                a43Var.s = qm2Var.g();
                return a43Var;
            }
            return (a43) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947565161, "Lcom/baidu/tieba/a43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947565161, "Lcom/baidu/tieba/a43;");
                return;
            }
        }
        t = vj1.a;
        u = new a();
        v = new b();
    }

    public a43() {
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

    public static a43 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (a43) invokeL.objValue;
    }

    public static a43 b(String str, @NonNull a43 a43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, a43Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return a43Var;
            }
            try {
                return e(new JSONObject(str), a43Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return a43Var;
            }
        }
        return (a43) invokeLL.objValue;
    }

    public static a43 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            a43 a43Var = new a43();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            a43Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            a43Var.c = optString2;
            a43Var.b = optJSONObject.optString("navigationBarTitleText");
            a43Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            a43Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            a43Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            a43Var.g = optJSONObject.optString("onReachBottomDistance");
            a43Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            a43Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            a43Var.j = optJSONObject.optString("navigationStyle", "default");
            a43Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            a43Var.q = optJSONObject.optString("textSizeAdjust");
            a43Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return a43Var;
        }
        return (a43) invokeL.objValue;
    }

    public static a43 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new a43();
        }
        return (a43) invokeV.objValue;
    }

    public static a43 e(JSONObject jSONObject, @NonNull a43 a43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, a43Var)) == null) {
            a43 a43Var2 = new a43();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            a43Var2.a = TextUtils.isEmpty(optString) ? a43Var.a : SwanAppConfigData.t(optString);
            a43Var2.b = jSONObject.optString("navigationBarTitleText", a43Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = a43Var.c;
            }
            a43Var2.c = optString2;
            a43Var2.d = jSONObject.optString("backgroundTextStyle", a43Var.d);
            a43Var2.e = jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR) ? SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) : a43Var.e;
            a43Var2.f = jSONObject.optBoolean("enablePullDownRefresh", a43Var.f);
            a43Var2.g = jSONObject.optString("onReachBottomDistance", a43Var.g);
            a43Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", a43Var.h);
            a43Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", a43Var.i);
            a43Var2.j = jSONObject.optString("navigationStyle", a43Var.j);
            a43Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", a43Var.k);
            a43Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            a43Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            a43Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            a43Var2.o = jSONObject.optBoolean("_hasVideo", false);
            a43Var2.r = jSONObject.optString("viewMode", a43Var.r);
            a43Var2.s = jSONObject.optString("htmlFontSize", a43Var.s);
            jSONObject.optJSONArray("fontFace");
            return a43Var2;
        }
        return (a43) invokeLL.objValue;
    }

    public static boolean f(a43 a43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, a43Var)) == null) {
            if (a43Var == null) {
                return false;
            }
            return a43Var.h || TextUtils.equals(a43Var.j, "custom");
        }
        return invokeL.booleanValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && !this.p) {
            this.p = true;
        }
    }
}
