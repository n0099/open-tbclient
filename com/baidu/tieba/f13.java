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
/* loaded from: classes5.dex */
public class f13 extends l72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public e13 B;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947711233, "Lcom/baidu/tieba/f13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947711233, "Lcom/baidu/tieba/f13;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    @Override // com.baidu.tieba.l72, com.baidu.tieba.u13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TextUtils.isEmpty(this.j);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f13() {
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
        this.B = new e13();
        this.C = true;
    }

    public static f13 h(JSONObject jSONObject, @NonNull f13 f13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, f13Var)) == null) {
            f13 f13Var2 = new f13();
            if (jSONObject != null) {
                f13Var2.e(jSONObject, f13Var);
                f13Var2.j = jSONObject.optString("videoId", f13Var.j);
                f13Var2.n = jSONObject.optBoolean("autoplay", f13Var.n);
                f13Var2.k = jSONObject.optBoolean("muted", f13Var.k);
                f13Var2.m = jSONObject.optString("initialTime", f13Var.m);
                f13Var2.l = jSONObject.optString(NativeConstants.POSTER, f13Var.l);
                f13Var2.p = jSONObject.optInt(CriusAttrConstants.POSITION, f13Var.p);
                f13Var2.q = jSONObject.optBoolean("fullScreen", f13Var.q);
                f13Var2.o = jSONObject.optBoolean("loop", f13Var.o);
                f13Var2.r = jSONObject.optBoolean("controls", f13Var.r);
                f13Var2.s = i(jSONObject.optString("src", f13Var.s));
                f13Var2.A = !dj3.E(jSONObject.optString("src", f13Var.s));
                f13Var2.u = jSONObject.optBoolean("showPlayBtn", f13Var.u);
                f13Var2.v = jSONObject.optBoolean("showMuteBtn", f13Var.v);
                f13Var2.w = jSONObject.optBoolean("showCenterPlayBtn", f13Var.w);
                f13Var2.x = jSONObject.optBoolean("showProgress", f13Var.x);
                f13Var2.z = jSONObject.optBoolean("showFullscreenBtn", f13Var.z);
                f13Var2.t = jSONObject.optString("sanId", f13Var.t);
                f13Var2.B = f13Var2.B.a(jSONObject.optJSONObject("vrVideoMode"));
                f13Var2.C = jSONObject.optBoolean("showNoWifiTip", f13Var.C);
            }
            return f13Var2;
        }
        return (f13) invokeLL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (dj3.E(str) && vb3.M() != null) {
                return dj3.H(str, vb3.M());
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l72
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.j + "', mMute=" + this.k + ", mPoster='" + this.l + "', mInitialTime=" + this.m + ", mAutoPlay=" + this.n + ", mShowNoWifiTip=" + this.C + ", mLoop=" + this.o + ", mPos=" + this.p + ", mFullScreen=" + this.q + ", mShowControlPanel=" + this.r + ", mSrc='" + this.s + "', mSanId='" + this.t + "', mShowPlayBtn=" + this.u + ", mShowMuteBtn=" + this.v + ", mShowCenterPlayBtn=" + this.w + ", mShowProgress=" + this.x + ", mDirection=" + this.y + ", mShowFullscreenBtn=" + this.z + ", mIsRemoteFile=" + this.A + ", mVrVideoMode=" + this.B.toString() + '}';
        }
        return (String) invokeV.objValue;
    }
}
