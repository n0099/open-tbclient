package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
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
public class b43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final a43 u;
    public static final z33 v;
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
    public final class a extends a43 {
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
        @Override // com.baidu.tieba.a43
        /* renamed from: b */
        public void a(b43 b43Var, sm2 sm2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b43Var, sm2Var) == null) {
                sm2Var.writeInt(b43Var.a);
                sm2Var.f(b43Var.b);
                sm2Var.f(b43Var.c);
                sm2Var.f(b43Var.d);
                sm2Var.writeInt(b43Var.e);
                sm2Var.writeBoolean(b43Var.f);
                sm2Var.f(b43Var.g);
                sm2Var.writeBoolean(b43Var.h);
                sm2Var.writeBoolean(b43Var.i);
                sm2Var.f(b43Var.j);
                sm2Var.writeBoolean(b43Var.k);
                sm2Var.writeBoolean(b43Var.l);
                sm2Var.writeBoolean(b43Var.m);
                sm2Var.writeBoolean(b43Var.n);
                sm2Var.writeBoolean(b43Var.o);
                sm2Var.writeBoolean(b43Var.p);
                sm2Var.f(b43Var.q);
                sm2Var.f(b43Var.r);
                sm2Var.f(b43Var.s);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class b extends z33 {
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
        @Override // com.baidu.tieba.z33
        /* renamed from: b */
        public b43 a(rm2 rm2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rm2Var)) == null) {
                b43 b43Var = new b43();
                b43Var.a = rm2Var.readInt();
                b43Var.b = rm2Var.g();
                b43Var.c = rm2Var.g();
                b43Var.d = rm2Var.g();
                b43Var.e = rm2Var.readInt();
                b43Var.f = rm2Var.readBoolean();
                b43Var.g = rm2Var.g();
                b43Var.h = rm2Var.readBoolean();
                b43Var.i = rm2Var.readBoolean();
                b43Var.j = rm2Var.g();
                b43Var.k = rm2Var.readBoolean();
                b43Var.l = rm2Var.readBoolean();
                b43Var.m = rm2Var.readBoolean();
                b43Var.n = rm2Var.readBoolean();
                b43Var.o = rm2Var.readBoolean();
                b43Var.p = rm2Var.readBoolean();
                b43Var.q = rm2Var.g();
                b43Var.r = rm2Var.g();
                b43Var.s = rm2Var.g();
                return b43Var;
            }
            return (b43) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947594952, "Lcom/baidu/tieba/b43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947594952, "Lcom/baidu/tieba/b43;");
                return;
            }
        }
        t = wj1.a;
        u = new a();
        v = new b();
    }

    public b43() {
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

    public static b43 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new b43();
        }
        return (b43) invokeV.objValue;
    }

    public static b43 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (b43) invokeL.objValue;
    }

    public static boolean f(b43 b43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, b43Var)) == null) {
            if (b43Var == null) {
                return false;
            }
            if (!b43Var.h && !TextUtils.equals(b43Var.j, "custom")) {
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

    public static b43 b(String str, b43 b43Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, b43Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return b43Var;
            }
            try {
                return e(new JSONObject(str), b43Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return b43Var;
            }
        }
        return (b43) invokeLL.objValue;
    }

    public static b43 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            b43 b43Var = new b43();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            b43Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            b43Var.c = optString2;
            b43Var.b = optJSONObject.optString("navigationBarTitleText");
            b43Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            b43Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            b43Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            b43Var.g = optJSONObject.optString("onReachBottomDistance");
            b43Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            b43Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            b43Var.j = optJSONObject.optString("navigationStyle", "default");
            b43Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            b43Var.q = optJSONObject.optString("textSizeAdjust");
            b43Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return b43Var;
        }
        return (b43) invokeL.objValue;
    }

    public static b43 e(JSONObject jSONObject, b43 b43Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, b43Var)) == null) {
            b43 b43Var2 = new b43();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = b43Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            b43Var2.a = t2;
            b43Var2.b = jSONObject.optString("navigationBarTitleText", b43Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = b43Var.c;
            }
            b43Var2.c = optString2;
            b43Var2.d = jSONObject.optString("backgroundTextStyle", b43Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = b43Var.e;
            }
            b43Var2.e = i;
            b43Var2.f = jSONObject.optBoolean("enablePullDownRefresh", b43Var.f);
            b43Var2.g = jSONObject.optString("onReachBottomDistance", b43Var.g);
            b43Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", b43Var.h);
            b43Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", b43Var.i);
            b43Var2.j = jSONObject.optString("navigationStyle", b43Var.j);
            b43Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", b43Var.k);
            b43Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            b43Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            b43Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            b43Var2.o = jSONObject.optBoolean("_hasVideo", false);
            b43Var2.r = jSONObject.optString("viewMode", b43Var.r);
            b43Var2.s = jSONObject.optString("htmlFontSize", b43Var.s);
            jSONObject.optJSONArray("fontFace");
            return b43Var2;
        }
        return (b43) invokeLL.objValue;
    }
}
