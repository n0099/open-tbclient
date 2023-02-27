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
/* loaded from: classes4.dex */
public class gy2 extends c52 {
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
    public String T;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947810185, "Lcom/baidu/tieba/gy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947810185, "Lcom/baidu/tieba/gy2;");
                return;
            }
        }
        X = wp1.a;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c52, com.baidu.tieba.lz2
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
            return TextUtils.equals("auto", this.T);
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
    public gy2() {
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
        this.T = "";
        this.U = true;
        this.V = "";
        this.W = "";
    }

    public static gy2 h(JSONObject jSONObject, @NonNull gy2 gy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, gy2Var)) == null) {
            gy2 gy2Var2 = new gy2();
            if (jSONObject != null) {
                gy2Var2.e(jSONObject, gy2Var);
                gy2Var2.j = jSONObject.optString("componentId", gy2Var.j);
                gy2Var2.o = jSONObject.optBoolean("autoplay", gy2Var.o);
                gy2Var2.k = jSONObject.optBoolean("muted", gy2Var.k);
                gy2Var2.q = jSONObject.optString("objectFit", gy2Var.q);
                gy2Var2.m = jSONObject.optInt("initialTime", gy2Var.m);
                gy2Var2.l = jSONObject.optString(NativeConstants.POSTER, gy2Var.l);
                gy2Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, gy2Var.r);
                gy2Var2.s = jSONObject.optBoolean("fullScreen", gy2Var.s);
                gy2Var2.t = p(jSONObject);
                gy2Var2.u = jSONObject.optString("danmuList", gy2Var.u);
                gy2Var2.v = jSONObject.optBoolean("enableDanmu", gy2Var.v);
                gy2Var2.w = jSONObject.optBoolean("danmuBtn", gy2Var.w);
                gy2Var2.p = jSONObject.optBoolean("loop", gy2Var.p);
                gy2Var2.x = jSONObject.optBoolean("controls", gy2Var.x);
                gy2Var2.y = q(jSONObject.optString("src", gy2Var.y));
                gy2Var2.I = !ug3.E(jSONObject.optString("src", gy2Var.y));
                gy2Var2.A = jSONObject.optBoolean("showPlayBtn", gy2Var.A);
                gy2Var2.B = jSONObject.optBoolean("showMuteBtn", gy2Var.B);
                gy2Var2.C = jSONObject.optBoolean("showCenterPlayBtn", gy2Var.C);
                gy2Var2.D = jSONObject.optBoolean("pageGesture", gy2Var.D);
                gy2Var2.E = jSONObject.optBoolean("showProgress", gy2Var.E);
                gy2Var2.F = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, gy2Var.F);
                gy2Var2.G = jSONObject.optBoolean("showFullscreenBtn", gy2Var.G);
                gy2Var2.H = jSONObject.optBoolean("enableProgressGesture", gy2Var.H);
                gy2Var2.z = jSONObject.optString("componentId", gy2Var.z);
                gy2Var2.J = jSONObject.optBoolean("showNoWifiTip", gy2Var.J);
                gy2Var2.K = jSONObject.optString("title", gy2Var.K);
                gy2Var2.L = jSONObject.optBoolean("enablePlayGesture", gy2Var.L);
                gy2Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", gy2Var.M);
                gy2Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", gy2Var.N);
                gy2Var2.P = jSONObject.optBoolean("showRateBtn", gy2Var.P);
                gy2Var2.Q = jSONObject.optBoolean("isFullscreen", gy2Var.Q);
                gy2Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", gy2Var.O);
                gy2Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", gy2Var.R);
                gy2Var2.S = jSONObject.optBoolean("silentPlay", gy2Var.S);
                gy2Var2.T = jSONObject.optString("preload", gy2Var.T);
                gy2Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", gy2Var.U);
                gy2Var2.V = jSONObject.optString("silentPlayTips", gy2Var.V);
                gy2Var2.W = jSONObject.optString("rate", gy2Var.W);
            }
            return gy2Var2;
        }
        return (gy2) invokeLL.objValue;
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
            if (ug3.E(str) && m93.M() != null) {
                return ug3.H(str, m93.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.c52
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
