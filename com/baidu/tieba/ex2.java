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
public class ex2 extends k32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public dx2 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947749642, "Lcom/baidu/tieba/ex2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947749642, "Lcom/baidu/tieba/ex2;");
                return;
            }
        }
        boolean z = eo1.a;
    }

    @Override // com.baidu.tieba.k32, com.baidu.tieba.tx2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex2() {
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
        this.B = new dx2();
        this.C = true;
    }

    public static ex2 h(JSONObject jSONObject, @NonNull ex2 ex2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, ex2Var)) == null) {
            ex2 ex2Var2 = new ex2();
            if (jSONObject != null) {
                ex2Var2.e(jSONObject, ex2Var);
                ex2Var2.j = jSONObject.optString("videoId", ex2Var.j);
                ex2Var2.n = jSONObject.optBoolean("autoplay", ex2Var.n);
                ex2Var2.k = jSONObject.optBoolean("muted", ex2Var.k);
                ex2Var2.m = jSONObject.optString("initialTime", ex2Var.m);
                ex2Var2.l = jSONObject.optString(NativeConstants.POSTER, ex2Var.l);
                ex2Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, ex2Var.p);
                ex2Var2.q = jSONObject.optBoolean("fullScreen", ex2Var.q);
                ex2Var2.o = jSONObject.optBoolean("loop", ex2Var.o);
                ex2Var2.r = jSONObject.optBoolean("controls", ex2Var.r);
                ex2Var2.s = i(jSONObject.optString("src", ex2Var.s));
                ex2Var2.A = !cf3.E(jSONObject.optString("src", ex2Var.s));
                ex2Var2.u = jSONObject.optBoolean("showPlayBtn", ex2Var.u);
                ex2Var2.v = jSONObject.optBoolean("showMuteBtn", ex2Var.v);
                ex2Var2.w = jSONObject.optBoolean("showCenterPlayBtn", ex2Var.w);
                ex2Var2.x = jSONObject.optBoolean("showProgress", ex2Var.x);
                ex2Var2.z = jSONObject.optBoolean("showFullscreenBtn", ex2Var.z);
                ex2Var2.t = jSONObject.optString("sanId", ex2Var.t);
                ex2Var2.B = ex2Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                ex2Var2.C = jSONObject.optBoolean("showNoWifiTip", ex2Var.C);
            }
            return ex2Var2;
        }
        return (ex2) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (cf3.E(str) && u73.M() != null) {
                return cf3.H(str, u73.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k32
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
