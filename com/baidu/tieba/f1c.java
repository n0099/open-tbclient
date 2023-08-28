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
public class f1c {
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
    public transient j3c j;
    public transient i3c k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public f1c() {
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

    public static f1c a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            f1c f1cVar = new f1c();
            try {
                JSONObject jSONObject = new JSONObject(str);
                f1cVar.a = jSONObject.optString("cacheDirectory");
                f1cVar.b = jSONObject.optInt("avcCodec");
                f1cVar.c = jSONObject.optInt("hevcCodec");
                f1cVar.d = jSONObject.optInt("audioCodec");
                f1cVar.e = jSONObject.optInt("videoSeekMode");
                f1cVar.f = jSONObject.optBoolean("clearRender");
                f1cVar.g = jSONObject.optBoolean("usingSurfaceView");
                f1cVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                f1cVar.i = jSONObject.optBoolean("forceNotCrop");
                f1cVar.l = jSONObject.optInt("samplerFilter");
                f1cVar.m = jSONObject.optBoolean("isSubProcess");
                f1cVar.n = jSONObject.optInt("pcdnCatonTime");
                f1cVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return f1cVar;
        }
        return (f1c) invokeL.objValue;
    }

    public static String b(f1c f1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, f1cVar)) == null) {
            if (f1cVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", f1cVar.a);
                jSONObject.put("avcCodec", f1cVar.b);
                jSONObject.put("hevcCodec", f1cVar.c);
                jSONObject.put("audioCodec", f1cVar.d);
                jSONObject.put("videoSeekMode", f1cVar.e);
                jSONObject.put("clearRender", f1cVar.f);
                jSONObject.put("usingSurfaceView", f1cVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", f1cVar.h);
                jSONObject.put("forceNotCrop", f1cVar.i);
                jSONObject.put("samplerFilter", f1cVar.l);
                jSONObject.put("isSubProcess", f1cVar.m);
                jSONObject.put("pcdnCatonTime", f1cVar.n);
                jSONObject.put("pcdnCatonCount", f1cVar.o);
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
