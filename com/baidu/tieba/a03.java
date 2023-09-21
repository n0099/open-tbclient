package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a03 extends w62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean X;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public String K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public String f1087T;
    public boolean U;
    public String V;
    public String W;
    public String j;
    public boolean k;
    public String l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public String q;
    public int r;
    public boolean s;
    public String t;
    public String u;
    public boolean v;
    public boolean w;
    public boolean x;
    public String y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947561317, "Lcom/baidu/tieba/a03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947561317, "Lcom/baidu/tieba/a03;");
                return;
            }
        }
        X = qr1.a;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.w62, com.baidu.tieba.f13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return TextUtils.equals("auto", this.f1087T);
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.C;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.B;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.A;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return !this.f;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a03() {
        super("video", "componentId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = "";
        this.k = false;
        this.l = "";
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.q = "";
        this.r = 0;
        this.t = "";
        this.u = "";
        this.v = false;
        this.w = false;
        this.x = true;
        this.y = "";
        this.z = "";
        this.D = false;
        this.E = true;
        this.F = -1;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = true;
        this.K = "";
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = false;
        this.P = true;
        this.Q = false;
        this.R = true;
        this.S = false;
        this.f1087T = "";
        this.U = true;
        this.V = "";
        this.W = "";
    }

    public static a03 h(JSONObject jSONObject, @NonNull a03 a03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, a03Var)) == null) {
            a03 a03Var2 = new a03();
            if (jSONObject != null) {
                a03Var2.e(jSONObject, a03Var);
                a03Var2.j = jSONObject.optString("componentId", a03Var.j);
                a03Var2.o = jSONObject.optBoolean("autoplay", a03Var.o);
                a03Var2.k = jSONObject.optBoolean("muted", a03Var.k);
                a03Var2.q = jSONObject.optString("objectFit", a03Var.q);
                a03Var2.m = jSONObject.optInt("initialTime", a03Var.m);
                a03Var2.l = jSONObject.optString(NativeConstants.POSTER, a03Var.l);
                a03Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, a03Var.r);
                a03Var2.s = jSONObject.optBoolean("fullScreen", a03Var.s);
                a03Var2.t = p(jSONObject);
                a03Var2.u = jSONObject.optString("danmuList", a03Var.u);
                a03Var2.v = jSONObject.optBoolean("enableDanmu", a03Var.v);
                a03Var2.w = jSONObject.optBoolean("danmuBtn", a03Var.w);
                a03Var2.p = jSONObject.optBoolean("loop", a03Var.p);
                a03Var2.x = jSONObject.optBoolean("controls", a03Var.x);
                a03Var2.y = q(jSONObject.optString("src", a03Var.y));
                a03Var2.I = !oi3.E(jSONObject.optString("src", a03Var.y));
                a03Var2.A = jSONObject.optBoolean("showPlayBtn", a03Var.A);
                a03Var2.B = jSONObject.optBoolean("showMuteBtn", a03Var.B);
                a03Var2.C = jSONObject.optBoolean("showCenterPlayBtn", a03Var.C);
                a03Var2.D = jSONObject.optBoolean("pageGesture", a03Var.D);
                a03Var2.E = jSONObject.optBoolean("showProgress", a03Var.E);
                a03Var2.F = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, a03Var.F);
                a03Var2.G = jSONObject.optBoolean("showFullscreenBtn", a03Var.G);
                a03Var2.H = jSONObject.optBoolean("enableProgressGesture", a03Var.H);
                a03Var2.z = jSONObject.optString("componentId", a03Var.z);
                a03Var2.J = jSONObject.optBoolean("showNoWifiTip", a03Var.J);
                a03Var2.K = jSONObject.optString("title", a03Var.K);
                a03Var2.L = jSONObject.optBoolean("enablePlayGesture", a03Var.L);
                a03Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", a03Var.M);
                a03Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", a03Var.N);
                a03Var2.P = jSONObject.optBoolean("showRateBtn", a03Var.P);
                a03Var2.Q = jSONObject.optBoolean("isFullscreen", a03Var.Q);
                a03Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", a03Var.O);
                a03Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", a03Var.R);
                a03Var2.S = jSONObject.optBoolean("silentPlay", a03Var.S);
                a03Var2.f1087T = jSONObject.optString("preload", a03Var.f1087T);
                a03Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", a03Var.U);
                a03Var2.V = jSONObject.optString("silentPlayTips", a03Var.V);
                a03Var2.W = jSONObject.optString("rate", a03Var.W);
            }
            return a03Var2;
        }
        return (a03) invokeLL.objValue;
    }

    public static String p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("text", jSONObject.optString("text"));
                jSONObject2.putOpt("color", jSONObject.optString("color"));
                jSONObject2.putOpt("componentId", jSONObject.optString("componentId"));
            } catch (JSONException e) {
                if (X) {
                    e.printStackTrace();
                }
            }
            return jSONObject2.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (oi3.E(str) && gb3.M() != null) {
                return oi3.H(str, gb3.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w62
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
