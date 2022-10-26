package com.baidu.tieba;

import android.text.TextUtils;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gs2 extends cz1 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804419, "Lcom/baidu/tieba/gs2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804419, "Lcom/baidu/tieba/gs2;");
                return;
            }
        }
        X = wj1.a;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cz1, com.baidu.tieba.lt2
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
    public gs2() {
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

    public static gs2 h(JSONObject jSONObject, gs2 gs2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, gs2Var)) == null) {
            gs2 gs2Var2 = new gs2();
            if (jSONObject != null) {
                gs2Var2.e(jSONObject, gs2Var);
                gs2Var2.j = jSONObject.optString("componentId", gs2Var.j);
                gs2Var2.o = jSONObject.optBoolean("autoplay", gs2Var.o);
                gs2Var2.k = jSONObject.optBoolean("muted", gs2Var.k);
                gs2Var2.q = jSONObject.optString("objectFit", gs2Var.q);
                gs2Var2.m = jSONObject.optInt("initialTime", gs2Var.m);
                gs2Var2.l = jSONObject.optString(NativeConstants.POSTER, gs2Var.l);
                gs2Var2.r = jSONObject.optInt(CriusAttrConstants.POSITION, gs2Var.r);
                gs2Var2.s = jSONObject.optBoolean("fullScreen", gs2Var.s);
                gs2Var2.t = p(jSONObject);
                gs2Var2.u = jSONObject.optString("danmuList", gs2Var.u);
                gs2Var2.v = jSONObject.optBoolean("enableDanmu", gs2Var.v);
                gs2Var2.w = jSONObject.optBoolean("danmuBtn", gs2Var.w);
                gs2Var2.p = jSONObject.optBoolean("loop", gs2Var.p);
                gs2Var2.x = jSONObject.optBoolean("controls", gs2Var.x);
                gs2Var2.y = q(jSONObject.optString("src", gs2Var.y));
                gs2Var2.I = !ua3.E(jSONObject.optString("src", gs2Var.y));
                gs2Var2.A = jSONObject.optBoolean("showPlayBtn", gs2Var.A);
                gs2Var2.B = jSONObject.optBoolean("showMuteBtn", gs2Var.B);
                gs2Var2.C = jSONObject.optBoolean("showCenterPlayBtn", gs2Var.C);
                gs2Var2.D = jSONObject.optBoolean("pageGesture", gs2Var.D);
                gs2Var2.E = jSONObject.optBoolean("showProgress", gs2Var.E);
                gs2Var2.F = jSONObject.optInt("direction", gs2Var.F);
                gs2Var2.G = jSONObject.optBoolean("showFullscreenBtn", gs2Var.G);
                gs2Var2.H = jSONObject.optBoolean("enableProgressGesture", gs2Var.H);
                gs2Var2.z = jSONObject.optString("componentId", gs2Var.z);
                gs2Var2.J = jSONObject.optBoolean("showNoWifiTip", gs2Var.J);
                gs2Var2.K = jSONObject.optString("title", gs2Var.K);
                gs2Var2.L = jSONObject.optBoolean("enablePlayGesture", gs2Var.L);
                gs2Var2.M = jSONObject.optBoolean("vslideGestureInFullscreen", gs2Var.M);
                gs2Var2.N = jSONObject.optBoolean("customEnterExitFullScreen", gs2Var.N);
                gs2Var2.P = jSONObject.optBoolean("showRateBtn", gs2Var.P);
                gs2Var2.Q = jSONObject.optBoolean("isFullscreen", gs2Var.Q);
                gs2Var2.O = jSONObject.optBoolean("isAlwaysOnlyShowTopView", gs2Var.O);
                gs2Var2.R = jSONObject.optBoolean("showVslideBtnInFullscreen", gs2Var.R);
                gs2Var2.S = jSONObject.optBoolean("silentPlay", gs2Var.S);
                gs2Var2.T = jSONObject.optString("preload", gs2Var.T);
                gs2Var2.U = jSONObject.optBoolean("showSilentPlayMutedIcon", gs2Var.U);
                gs2Var2.V = jSONObject.optString("silentPlayTips", gs2Var.V);
                gs2Var2.W = jSONObject.optString("rate", gs2Var.W);
            }
            return gs2Var2;
        }
        return (gs2) invokeLL.objValue;
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
            if (ua3.E(str) && m33.M() != null) {
                return ua3.H(str, m33.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cz1
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", duration=" + this.n + ", mAutoPlay=" + this.o + ", mLoop=" + this.p + ", mObjectFit='" + this.q + "', mPos=" + this.r + ", mFullScreen=" + this.s + ", mDanmu='" + this.t + "', mDanmuList='" + this.u + "', mEnableDanmu=" + this.v + ", mShowDanmuBtn=" + this.w + ", mShowControlPanel=" + this.x + ", mSrc='" + this.y + "', mSanId='" + this.z + "', mShowPlayBtn=" + this.A + ", mShowMuteBtn=" + this.B + ", mShowCenterPlayBtn=" + this.C + ", mPageGesture=" + this.D + ", mShowProgress=" + this.E + ", mDirection=" + this.F + ", mShowFullscreenBtn=" + this.G + ", mEnableProgressGesture=" + this.H + ", mIsRemoteFile=" + this.I + '}';
        }
        return (String) invokeV.objValue;
    }
}
