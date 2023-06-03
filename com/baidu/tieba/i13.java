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
/* loaded from: classes6.dex */
public class i13 extends o72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public h13 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947800606, "Lcom/baidu/tieba/i13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947800606, "Lcom/baidu/tieba/i13;");
                return;
            }
        }
        boolean z = is1.a;
    }

    @Override // com.baidu.tieba.o72, com.baidu.tieba.x13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i13() {
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
        this.B = new h13();
        this.C = true;
    }

    public static i13 h(JSONObject jSONObject, @NonNull i13 i13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, i13Var)) == null) {
            i13 i13Var2 = new i13();
            if (jSONObject != null) {
                i13Var2.e(jSONObject, i13Var);
                i13Var2.j = jSONObject.optString("videoId", i13Var.j);
                i13Var2.n = jSONObject.optBoolean("autoplay", i13Var.n);
                i13Var2.k = jSONObject.optBoolean("muted", i13Var.k);
                i13Var2.m = jSONObject.optString("initialTime", i13Var.m);
                i13Var2.l = jSONObject.optString(NativeConstants.POSTER, i13Var.l);
                i13Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, i13Var.p);
                i13Var2.q = jSONObject.optBoolean("fullScreen", i13Var.q);
                i13Var2.o = jSONObject.optBoolean("loop", i13Var.o);
                i13Var2.r = jSONObject.optBoolean("controls", i13Var.r);
                i13Var2.s = i(jSONObject.optString("src", i13Var.s));
                i13Var2.A = !gj3.E(jSONObject.optString("src", i13Var.s));
                i13Var2.u = jSONObject.optBoolean("showPlayBtn", i13Var.u);
                i13Var2.v = jSONObject.optBoolean("showMuteBtn", i13Var.v);
                i13Var2.w = jSONObject.optBoolean("showCenterPlayBtn", i13Var.w);
                i13Var2.x = jSONObject.optBoolean("showProgress", i13Var.x);
                i13Var2.z = jSONObject.optBoolean("showFullscreenBtn", i13Var.z);
                i13Var2.t = jSONObject.optString("sanId", i13Var.t);
                i13Var2.B = i13Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                i13Var2.C = jSONObject.optBoolean("showNoWifiTip", i13Var.C);
            }
            return i13Var2;
        }
        return (i13) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (gj3.E(str) && yb3.M() != null) {
                return gj3.H(str, yb3.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.o72
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
