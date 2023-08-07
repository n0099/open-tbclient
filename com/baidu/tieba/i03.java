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
public class i03 extends o62 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public h03 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947799645, "Lcom/baidu/tieba/i03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947799645, "Lcom/baidu/tieba/i03;");
                return;
            }
        }
        boolean z = ir1.a;
    }

    @Override // com.baidu.tieba.o62, com.baidu.tieba.x03
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i03() {
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
        this.B = new h03();
        this.C = true;
    }

    public static i03 h(JSONObject jSONObject, @NonNull i03 i03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, i03Var)) == null) {
            i03 i03Var2 = new i03();
            if (jSONObject != null) {
                i03Var2.e(jSONObject, i03Var);
                i03Var2.j = jSONObject.optString("videoId", i03Var.j);
                i03Var2.n = jSONObject.optBoolean("autoplay", i03Var.n);
                i03Var2.k = jSONObject.optBoolean("muted", i03Var.k);
                i03Var2.m = jSONObject.optString("initialTime", i03Var.m);
                i03Var2.l = jSONObject.optString(NativeConstants.POSTER, i03Var.l);
                i03Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, i03Var.p);
                i03Var2.q = jSONObject.optBoolean("fullScreen", i03Var.q);
                i03Var2.o = jSONObject.optBoolean("loop", i03Var.o);
                i03Var2.r = jSONObject.optBoolean("controls", i03Var.r);
                i03Var2.s = i(jSONObject.optString("src", i03Var.s));
                i03Var2.A = !gi3.E(jSONObject.optString("src", i03Var.s));
                i03Var2.u = jSONObject.optBoolean("showPlayBtn", i03Var.u);
                i03Var2.v = jSONObject.optBoolean("showMuteBtn", i03Var.v);
                i03Var2.w = jSONObject.optBoolean("showCenterPlayBtn", i03Var.w);
                i03Var2.x = jSONObject.optBoolean("showProgress", i03Var.x);
                i03Var2.z = jSONObject.optBoolean("showFullscreenBtn", i03Var.z);
                i03Var2.t = jSONObject.optString("sanId", i03Var.t);
                i03Var2.B = i03Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                i03Var2.C = jSONObject.optBoolean("showNoWifiTip", i03Var.C);
            }
            return i03Var2;
        }
        return (i03) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (gi3.E(str) && ya3.M() != null) {
                return gi3.H(str, ya3.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.o62
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
