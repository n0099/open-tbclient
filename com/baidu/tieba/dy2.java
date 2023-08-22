package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dy2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947720812, "Lcom/baidu/tieba/dy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947720812, "Lcom/baidu/tieba/dy2;");
                return;
            }
        }
        v = nr1.a;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public dy2() {
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

    public static dy2 b(JSONObject jSONObject, dy2 dy2Var) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, dy2Var)) == null) {
            dy2 dy2Var2 = new dy2();
            if (jSONObject != null) {
                dy2Var2.a = jSONObject.optString("audioId", dy2Var.a);
                dy2Var2.b = jSONObject.optString("slaveId", dy2Var.b);
                dy2Var2.c = jSONObject.optString("src", dy2Var.c);
                if (db3.M() != null && li3.E(dy2Var2.c)) {
                    z = true;
                } else {
                    z = false;
                }
                dy2Var2.q = z;
                dy2Var2.d = jSONObject.optString("title", dy2Var.d);
                dy2Var2.e = jSONObject.optString("epname", dy2Var.e);
                dy2Var2.f = jSONObject.optString("singer", dy2Var.f);
                dy2Var2.g = jSONObject.optString("coverImgUrl", dy2Var.g);
                dy2Var2.h = jSONObject.optString("lrcURL", dy2Var.h);
                dy2Var2.i = jSONObject.optBoolean("showFloatView", dy2Var.i);
                dy2Var2.j = jSONObject.optString("floatPosition", dy2Var.j);
                dy2Var2.k = jSONObject.optInt("startTime", dy2Var.k);
                dy2Var2.l = jSONObject.optInt(CriusAttrConstants.POSITION, dy2Var.l);
                dy2Var2.p = jSONObject.optString("cb", dy2Var.p);
                dy2Var2.m = jSONObject.optString("param", dy2Var.m);
                dy2Var2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String g0 = xh2.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    dy2Var2.s = g0;
                }
                String b = ko3.b();
                if (!TextUtils.isEmpty(b) && ko3.c(dy2Var2.c)) {
                    dy2Var2.t = b;
                }
                String j = zj3.l().j(dy2Var2.c);
                if (!TextUtils.isEmpty(j)) {
                    dy2Var2.u = j;
                    if (v) {
                        Log.d("AudioPlayerParams", "addCookiesToHeader cookie: " + j);
                    }
                }
            }
            return dy2Var2;
        }
        return (dy2) invokeLL.objValue;
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
                jSONObject.putOpt("appid", db3.g0());
                jSONObject.putOpt("user-agent", this.s);
                jSONObject.putOpt("refer", this.t);
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
