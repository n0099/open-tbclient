package com.baidu.tieba;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i4c {
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
    public transient m6c j;
    public transient l6c k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public i4c() {
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

    public static i4c a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            i4c i4cVar = new i4c();
            try {
                JSONObject jSONObject = new JSONObject(str);
                i4cVar.a = jSONObject.optString("cacheDirectory");
                i4cVar.b = jSONObject.optInt("avcCodec");
                i4cVar.c = jSONObject.optInt("hevcCodec");
                i4cVar.d = jSONObject.optInt("audioCodec");
                i4cVar.e = jSONObject.optInt("videoSeekMode");
                i4cVar.f = jSONObject.optBoolean("clearRender");
                i4cVar.g = jSONObject.optBoolean("usingSurfaceView");
                i4cVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                i4cVar.i = jSONObject.optBoolean("forceNotCrop");
                i4cVar.l = jSONObject.optInt("samplerFilter");
                i4cVar.m = jSONObject.optBoolean("isSubProcess");
                i4cVar.n = jSONObject.optInt("pcdnCatonTime");
                i4cVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return i4cVar;
        }
        return (i4c) invokeL.objValue;
    }

    public static String b(i4c i4cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, i4cVar)) == null) {
            if (i4cVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", i4cVar.a);
                jSONObject.put("avcCodec", i4cVar.b);
                jSONObject.put("hevcCodec", i4cVar.c);
                jSONObject.put("audioCodec", i4cVar.d);
                jSONObject.put("videoSeekMode", i4cVar.e);
                jSONObject.put("clearRender", i4cVar.f);
                jSONObject.put("usingSurfaceView", i4cVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", i4cVar.h);
                jSONObject.put("forceNotCrop", i4cVar.i);
                jSONObject.put("samplerFilter", i4cVar.l);
                jSONObject.put("isSubProcess", i4cVar.m);
                jSONObject.put("pcdnCatonTime", i4cVar.n);
                jSONObject.put("pcdnCatonCount", i4cVar.o);
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
