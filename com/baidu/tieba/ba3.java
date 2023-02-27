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
/* loaded from: classes3.dex */
public class ba3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final aa3<ba3> u;
    public static final z93<ba3> v;
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
    public static class a extends aa3<ba3> {
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
        @Override // com.baidu.tieba.aa3
        /* renamed from: b */
        public void a(@NonNull ba3 ba3Var, @NonNull ss2 ss2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ba3Var, ss2Var) == null) {
                ss2Var.writeInt(ba3Var.a);
                ss2Var.f(ba3Var.b);
                ss2Var.f(ba3Var.c);
                ss2Var.f(ba3Var.d);
                ss2Var.writeInt(ba3Var.e);
                ss2Var.writeBoolean(ba3Var.f);
                ss2Var.f(ba3Var.g);
                ss2Var.writeBoolean(ba3Var.h);
                ss2Var.writeBoolean(ba3Var.i);
                ss2Var.f(ba3Var.j);
                ss2Var.writeBoolean(ba3Var.k);
                ss2Var.writeBoolean(ba3Var.l);
                ss2Var.writeBoolean(ba3Var.m);
                ss2Var.writeBoolean(ba3Var.n);
                ss2Var.writeBoolean(ba3Var.o);
                ss2Var.writeBoolean(ba3Var.p);
                ss2Var.f(ba3Var.q);
                ss2Var.f(ba3Var.r);
                ss2Var.f(ba3Var.s);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends z93<ba3> {
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
        @Override // com.baidu.tieba.z93
        /* renamed from: b */
        public ba3 a(@NonNull rs2 rs2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rs2Var)) == null) {
                ba3 ba3Var = new ba3();
                ba3Var.a = rs2Var.readInt();
                ba3Var.b = rs2Var.g();
                ba3Var.c = rs2Var.g();
                ba3Var.d = rs2Var.g();
                ba3Var.e = rs2Var.readInt();
                ba3Var.f = rs2Var.readBoolean();
                ba3Var.g = rs2Var.g();
                ba3Var.h = rs2Var.readBoolean();
                ba3Var.i = rs2Var.readBoolean();
                ba3Var.j = rs2Var.g();
                ba3Var.k = rs2Var.readBoolean();
                ba3Var.l = rs2Var.readBoolean();
                ba3Var.m = rs2Var.readBoolean();
                ba3Var.n = rs2Var.readBoolean();
                ba3Var.o = rs2Var.readBoolean();
                ba3Var.p = rs2Var.readBoolean();
                ba3Var.q = rs2Var.g();
                ba3Var.r = rs2Var.g();
                ba3Var.s = rs2Var.g();
                return ba3Var;
            }
            return (ba3) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947638197, "Lcom/baidu/tieba/ba3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947638197, "Lcom/baidu/tieba/ba3;");
                return;
            }
        }
        t = wp1.a;
        u = new a();
        v = new b();
    }

    public ba3() {
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

    public static ba3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new ba3();
        }
        return (ba3) invokeV.objValue;
    }

    public static ba3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (ba3) invokeL.objValue;
    }

    public static boolean f(ba3 ba3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, ba3Var)) == null) {
            if (ba3Var == null) {
                return false;
            }
            if (!ba3Var.h && !TextUtils.equals(ba3Var.j, ExceptionHandlerImpl.KEY_CUSTOM)) {
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

    public static ba3 b(String str, @NonNull ba3 ba3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, ba3Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ba3Var;
            }
            try {
                return e(new JSONObject(str), ba3Var);
            } catch (JSONException e) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e));
                }
                return ba3Var;
            }
        }
        return (ba3) invokeLL.objValue;
    }

    public static ba3 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            ba3 ba3Var = new ba3();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            ba3Var.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            ba3Var.c = optString2;
            ba3Var.b = optJSONObject.optString("navigationBarTitleText");
            ba3Var.d = optJSONObject.optString("backgroundTextStyle", "black");
            ba3Var.e = SwanAppConfigData.t(optJSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            ba3Var.f = optJSONObject.optBoolean("enablePullDownRefresh");
            ba3Var.g = optJSONObject.optString("onReachBottomDistance");
            ba3Var.h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            ba3Var.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            ba3Var.j = optJSONObject.optString("navigationStyle", "default");
            ba3Var.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            ba3Var.q = optJSONObject.optString("textSizeAdjust");
            ba3Var.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return ba3Var;
        }
        return (ba3) invokeL.objValue;
    }

    public static ba3 e(JSONObject jSONObject, @NonNull ba3 ba3Var) {
        InterceptResult invokeLL;
        int t2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, ba3Var)) == null) {
            ba3 ba3Var2 = new ba3();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                t2 = ba3Var.a;
            } else {
                t2 = SwanAppConfigData.t(optString);
            }
            ba3Var2.a = t2;
            ba3Var2.b = jSONObject.optString("navigationBarTitleText", ba3Var.b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = ba3Var.c;
            }
            ba3Var2.c = optString2;
            ba3Var2.d = jSONObject.optString("backgroundTextStyle", ba3Var.d);
            if (jSONObject.has(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                i = SwanAppConfigData.t(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
            } else {
                i = ba3Var.e;
            }
            ba3Var2.e = i;
            ba3Var2.f = jSONObject.optBoolean("enablePullDownRefresh", ba3Var.f);
            ba3Var2.g = jSONObject.optString("onReachBottomDistance", ba3Var.g);
            ba3Var2.h = jSONObject.optBoolean("enableOpacityNavigationBar", ba3Var.h);
            ba3Var2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", ba3Var.i);
            ba3Var2.j = jSONObject.optString("navigationStyle", ba3Var.j);
            ba3Var2.k = jSONObject.optBoolean("navigationHomeButtonHidden", ba3Var.k);
            ba3Var2.l = jSONObject.optBoolean("disableSwipeBack", false);
            ba3Var2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            ba3Var2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            ba3Var2.o = jSONObject.optBoolean("_hasVideo", false);
            ba3Var2.r = jSONObject.optString("viewMode", ba3Var.r);
            ba3Var2.s = jSONObject.optString("htmlFontSize", ba3Var.s);
            jSONObject.optJSONArray("fontFace");
            return ba3Var2;
        }
        return (ba3) invokeLL.objValue;
    }
}
