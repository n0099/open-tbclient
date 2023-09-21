package com.baidu.tieba;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a6c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public transient e8c j;
    public transient d8c k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public a6c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = 1;
        this.c = 1;
        this.d = 0;
        this.e = 1;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.k = null;
        this.l = 0;
        this.m = false;
        this.n = 1;
        this.o = 4000;
    }

    public static a6c a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            a6c a6cVar = new a6c();
            try {
                JSONObject jSONObject = new JSONObject(str);
                a6cVar.a = jSONObject.optString("cacheDirectory");
                a6cVar.b = jSONObject.optInt("avcCodec");
                a6cVar.c = jSONObject.optInt("hevcCodec");
                a6cVar.d = jSONObject.optInt("audioCodec");
                a6cVar.e = jSONObject.optInt("videoSeekMode");
                a6cVar.f = jSONObject.optBoolean("clearRender");
                a6cVar.g = jSONObject.optBoolean("usingSurfaceView");
                a6cVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                a6cVar.i = jSONObject.optBoolean("forceNotCrop");
                a6cVar.l = jSONObject.optInt("samplerFilter");
                a6cVar.m = jSONObject.optBoolean("isSubProcess");
                a6cVar.n = jSONObject.optInt("pcdnCatonTime");
                a6cVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return a6cVar;
        }
        return (a6c) invokeL.objValue;
    }

    public static String b(a6c a6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, a6cVar)) == null) {
            if (a6cVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", a6cVar.a);
                jSONObject.put("avcCodec", a6cVar.b);
                jSONObject.put("hevcCodec", a6cVar.c);
                jSONObject.put("audioCodec", a6cVar.d);
                jSONObject.put("videoSeekMode", a6cVar.e);
                jSONObject.put("clearRender", a6cVar.f);
                jSONObject.put("usingSurfaceView", a6cVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", a6cVar.h);
                jSONObject.put("forceNotCrop", a6cVar.i);
                jSONObject.put("samplerFilter", a6cVar.l);
                jSONObject.put("isSubProcess", a6cVar.m);
                jSONObject.put("pcdnCatonTime", a6cVar.n);
                jSONObject.put("pcdnCatonCount", a6cVar.o);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PlayerOptions [cacheDirectory=" + this.a + ", avcCodec=" + this.b + ", hevcCodec=" + this.c + ", audioCodec=" + this.d + ", videoSeekMode=" + this.e + ", clearRender=" + this.f + ", usingSurfaceView=" + this.g + ", hardDecodeOutputToBuffer=" + this.h + ", forceNotCrop=" + this.i + ", samplerFilter=" + this.l + ", isSubProcess=" + this.m + ", pcdnCatonTime=" + this.n + ", pcdnCatonCount=" + this.o + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
