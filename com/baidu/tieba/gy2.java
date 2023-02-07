package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
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
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gy2 extends m42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public fy2 B;
    public boolean C;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public boolean z;

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
        boolean z = gp1.a;
    }

    @Override // com.baidu.tieba.m42, com.baidu.tieba.vy2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gy2() {
        super("vrvideo", "viewId");
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
        this.m = "0";
        this.n = false;
        this.o = false;
        this.p = 0;
        this.r = true;
        this.s = "";
        this.t = "";
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = -1;
        this.z = true;
        this.A = true;
        this.B = new fy2();
        this.C = true;
    }

    public static gy2 h(JSONObject jSONObject, @NonNull gy2 gy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, gy2Var)) == null) {
            gy2 gy2Var2 = new gy2();
            if (jSONObject != null) {
                gy2Var2.e(jSONObject, gy2Var);
                gy2Var2.j = jSONObject.optString("videoId", gy2Var.j);
                gy2Var2.n = jSONObject.optBoolean("autoplay", gy2Var.n);
                gy2Var2.k = jSONObject.optBoolean("muted", gy2Var.k);
                gy2Var2.m = jSONObject.optString("initialTime", gy2Var.m);
                gy2Var2.l = jSONObject.optString(NativeConstants.POSTER, gy2Var.l);
                gy2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, gy2Var.p);
                gy2Var2.q = jSONObject.optBoolean("fullScreen", gy2Var.q);
                gy2Var2.o = jSONObject.optBoolean("loop", gy2Var.o);
                gy2Var2.r = jSONObject.optBoolean("controls", gy2Var.r);
                gy2Var2.s = i(jSONObject.optString("src", gy2Var.s));
                gy2Var2.A = !eg3.E(jSONObject.optString("src", gy2Var.s));
                gy2Var2.u = jSONObject.optBoolean("showPlayBtn", gy2Var.u);
                gy2Var2.v = jSONObject.optBoolean("showMuteBtn", gy2Var.v);
                gy2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", gy2Var.w);
                gy2Var2.x = jSONObject.optBoolean("showProgress", gy2Var.x);
                gy2Var2.z = jSONObject.optBoolean("showFullscreenBtn", gy2Var.z);
                gy2Var2.t = jSONObject.optString("sanId", gy2Var.t);
                gy2Var2.B = gy2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                gy2Var2.C = jSONObject.optBoolean("showNoWifiTip", gy2Var.C);
            }
            return gy2Var2;
        }
        return (gy2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (eg3.E(str) && w83.M() != null) {
                return eg3.H(str, w83.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m42
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
