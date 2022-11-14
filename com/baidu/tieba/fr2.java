package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.tbadk.core.util.TiebaStatic;
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
public class fr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public String j;
    public int k;
    public int l;
    public String m;
    public int n;
    public int o;
    public String p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public String u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947773667, "Lcom/baidu/tieba/fr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947773667, "Lcom/baidu/tieba/fr2;");
                return;
            }
        }
        v = pk1.a;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public fr2() {
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
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = false;
        this.j = "";
        this.k = 0;
        this.l = 0;
        this.m = "";
        this.q = false;
    }

    public static fr2 b(JSONObject jSONObject, fr2 fr2Var) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, fr2Var)) == null) {
            fr2 fr2Var2 = new fr2();
            if (jSONObject != null) {
                fr2Var2.a = jSONObject.optString("audioId", fr2Var.a);
                fr2Var2.b = jSONObject.optString("slaveId", fr2Var.b);
                fr2Var2.c = jSONObject.optString("src", fr2Var.c);
                if (f43.M() != null && nb3.E(fr2Var2.c)) {
                    z = true;
                } else {
                    z = false;
                }
                fr2Var2.q = z;
                fr2Var2.d = jSONObject.optString("title", fr2Var.d);
                fr2Var2.e = jSONObject.optString("epname", fr2Var.e);
                fr2Var2.f = jSONObject.optString("singer", fr2Var.f);
                fr2Var2.g = jSONObject.optString("coverImgUrl", fr2Var.g);
                fr2Var2.h = jSONObject.optString("lrcURL", fr2Var.h);
                fr2Var2.i = jSONObject.optBoolean("showFloatView", fr2Var.i);
                fr2Var2.j = jSONObject.optString("floatPosition", fr2Var.j);
                fr2Var2.k = jSONObject.optInt(FetchLog.START_TIME, fr2Var.k);
                fr2Var2.l = jSONObject.optInt(CriusAttrConstants.POSITION, fr2Var.l);
                fr2Var2.p = jSONObject.optString("cb", fr2Var.p);
                fr2Var2.m = jSONObject.optString("param", fr2Var.m);
                fr2Var2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String g0 = za2.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    fr2Var2.s = g0;
                }
                String b = mh3.b();
                if (!TextUtils.isEmpty(b) && mh3.c(fr2Var2.c)) {
                    fr2Var2.t = b;
                }
                String j = bd3.l().j(fr2Var2.c);
                if (!TextUtils.isEmpty(j)) {
                    fr2Var2.u = j;
                    if (v) {
                        Log.d("AudioPlayerParams", "addCookiesToHeader cookie: " + j);
                    }
                }
            }
            return fr2Var2;
        }
        return (fr2) invokeLL.objValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("src", str);
                jSONObject.putOpt("title", this.d);
                jSONObject.putOpt("epname", this.e);
                jSONObject.putOpt("singer", this.f);
                jSONObject.putOpt("coverImgUrl", this.g);
                jSONObject.putOpt("lrcURL", this.h);
                jSONObject.putOpt("isLocal", Boolean.valueOf(this.q));
                jSONObject.putOpt("appid", f43.g0());
                jSONObject.putOpt("user-agent", this.s);
                jSONObject.putOpt(TiebaStatic.Params.REFER, this.t);
                jSONObject.putOpt("Cookie", this.u);
            } catch (JSONException e) {
                if (v) {
                    e.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "AudioBGPlayerParams{ playerId=" + this.a + " slaveId=" + this.b + " url=" + this.c + " startTime=" + this.k + " pos=" + this.l + " canPlay=" + this.r + " }";
        }
        return (String) invokeV.objValue;
    }
}
