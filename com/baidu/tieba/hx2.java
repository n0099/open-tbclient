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
public class hx2 extends n32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public gx2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947839015, "Lcom/baidu/tieba/hx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947839015, "Lcom/baidu/tieba/hx2;");
                return;
            }
        }
        boolean z = ho1.a;
    }

    @Override // com.baidu.tieba.n32, com.baidu.tieba.wx2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hx2() {
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
        this.B = new gx2();
        this.C = true;
    }

    public static hx2 h(JSONObject jSONObject, @NonNull hx2 hx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, hx2Var)) == null) {
            hx2 hx2Var2 = new hx2();
            if (jSONObject != null) {
                hx2Var2.e(jSONObject, hx2Var);
                hx2Var2.j = jSONObject.optString("videoId", hx2Var.j);
                hx2Var2.n = jSONObject.optBoolean("autoplay", hx2Var.n);
                hx2Var2.k = jSONObject.optBoolean("muted", hx2Var.k);
                hx2Var2.m = jSONObject.optString("initialTime", hx2Var.m);
                hx2Var2.l = jSONObject.optString(NativeConstants.POSTER, hx2Var.l);
                hx2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, hx2Var.p);
                hx2Var2.q = jSONObject.optBoolean("fullScreen", hx2Var.q);
                hx2Var2.o = jSONObject.optBoolean("loop", hx2Var.o);
                hx2Var2.r = jSONObject.optBoolean("controls", hx2Var.r);
                hx2Var2.s = i(jSONObject.optString("src", hx2Var.s));
                hx2Var2.A = !ff3.E(jSONObject.optString("src", hx2Var.s));
                hx2Var2.u = jSONObject.optBoolean("showPlayBtn", hx2Var.u);
                hx2Var2.v = jSONObject.optBoolean("showMuteBtn", hx2Var.v);
                hx2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", hx2Var.w);
                hx2Var2.x = jSONObject.optBoolean("showProgress", hx2Var.x);
                hx2Var2.z = jSONObject.optBoolean("showFullscreenBtn", hx2Var.z);
                hx2Var2.t = jSONObject.optString("sanId", hx2Var.t);
                hx2Var2.B = hx2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                hx2Var2.C = jSONObject.optBoolean("showNoWifiTip", hx2Var.C);
            }
            return hx2Var2;
        }
        return (hx2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (ff3.E(str) && x73.M() != null) {
                return ff3.H(str, x73.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n32
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
