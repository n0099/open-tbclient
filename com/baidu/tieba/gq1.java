package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
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
public class gq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public boolean g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802466, "Lcom/baidu/tieba/gq1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802466, "Lcom/baidu/tieba/gq1;");
                return;
            }
        }
        boolean z = vj1.a;
    }

    public gq1(String str, String str2, String str3, int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = z;
    }

    public fs2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showMuteBtn", true);
                jSONObject.put("showCenterPlayBtn", true);
                fs2 fs2Var = new fs2();
                fs2Var.j = "SwanAdPlayer";
                fs2Var.b = "SwanAdPlayer";
                fs2Var.o = true;
                fs2Var.k = false;
                fs2Var.x = !this.g;
                fs2Var.I = false;
                fs2Var.l = this.a;
                fs2Var.y = this.b;
                fs2Var.c = this.c;
                rt2 rt2Var = new rt2(0, 0, this.d, this.e);
                fs2Var.h = rt2Var;
                rt2Var.i(true);
                fs2Var.m = this.f;
                if (this.g) {
                    fs2Var.q = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
                }
                return fs2.h(jSONObject, fs2Var);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (fs2) invokeV.objValue;
    }
}
