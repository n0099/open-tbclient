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
public class dgb {
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
    public transient hib j;
    public transient gib k;
    public int l;
    public boolean m;
    public int n;
    public int o;

    public dgb() {
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

    public static dgb a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            dgb dgbVar = new dgb();
            try {
                JSONObject jSONObject = new JSONObject(str);
                dgbVar.a = jSONObject.optString("cacheDirectory");
                dgbVar.b = jSONObject.optInt("avcCodec");
                dgbVar.c = jSONObject.optInt("hevcCodec");
                dgbVar.d = jSONObject.optInt("audioCodec");
                dgbVar.e = jSONObject.optInt("videoSeekMode");
                dgbVar.f = jSONObject.optBoolean("clearRender");
                dgbVar.g = jSONObject.optBoolean("usingSurfaceView");
                dgbVar.h = jSONObject.optBoolean("hardDecodeOutputToBuffer");
                dgbVar.i = jSONObject.optBoolean("forceNotCrop");
                dgbVar.l = jSONObject.optInt("samplerFilter");
                dgbVar.m = jSONObject.optBoolean("isSubProcess");
                dgbVar.n = jSONObject.optInt("pcdnCatonTime");
                dgbVar.o = jSONObject.optInt("pcdnCatonCount");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return dgbVar;
        }
        return (dgb) invokeL.objValue;
    }

    public static String b(dgb dgbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dgbVar)) == null) {
            if (dgbVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cacheDirectory", dgbVar.a);
                jSONObject.put("avcCodec", dgbVar.b);
                jSONObject.put("hevcCodec", dgbVar.c);
                jSONObject.put("audioCodec", dgbVar.d);
                jSONObject.put("videoSeekMode", dgbVar.e);
                jSONObject.put("clearRender", dgbVar.f);
                jSONObject.put("usingSurfaceView", dgbVar.g);
                jSONObject.put("hardDecodeOutputToBuffer", dgbVar.h);
                jSONObject.put("forceNotCrop", dgbVar.i);
                jSONObject.put("samplerFilter", dgbVar.l);
                jSONObject.put("isSubProcess", dgbVar.m);
                jSONObject.put("pcdnCatonTime", dgbVar.n);
                jSONObject.put("pcdnCatonCount", dgbVar.o);
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
