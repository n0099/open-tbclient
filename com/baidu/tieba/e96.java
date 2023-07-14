package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public int h;
    public int i;
    public long j;
    public long k;

    public e96() {
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
        this.d = "";
        this.c = "";
        this.e = "";
        this.f = "";
        this.b = "";
        this.a = "";
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !TextUtils.isEmpty(this.d);
        }
        return invokeV.booleanValue;
    }

    public static e96 a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
            e96 e96Var = new e96();
            if (adInfo == null) {
                return e96Var;
            }
            e96Var.a = adInfo.adImgUrl;
            e96Var.b = adInfo.redirectUrl;
            e96Var.j = adInfo.startShowTime;
            e96Var.k = adInfo.endShowTime;
            e96Var.d = adInfo.videoLocalPath;
            e96Var.e = adInfo.videoJumpUrl;
            e96Var.f = adInfo.videoMd5;
            e96Var.g = adInfo.videoDuration;
            e96Var.h = adInfo.videoWidth;
            e96Var.i = adInfo.videoHight;
            e96Var.c = adInfo.adVideoUrl;
            return e96Var;
        }
        return (e96) invokeL.objValue;
    }

    public static e96 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            e96 e96Var = new e96();
            try {
                JSONObject jSONObject = new JSONObject(str);
                e96Var.a = jSONObject.optString("adImgUrl");
                e96Var.b = jSONObject.optString("redirectUrl");
                e96Var.d = jSONObject.optString("videoLocalPath");
                e96Var.j = jSONObject.optLong("startShowTime");
                e96Var.k = jSONObject.optLong("endShowTime");
                e96Var.e = jSONObject.optString("videoJumpUrl");
                e96Var.f = jSONObject.optString("videoMd5");
                e96Var.g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
                e96Var.h = jSONObject.optInt("videoWidth");
                e96Var.i = jSONObject.optInt("videoHeight");
                e96Var.c = jSONObject.optString("adVideoUrl");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return e96Var;
        }
        return (e96) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if ((System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adImgUrl", this.a);
                jSONObject.put("redirectUrl", this.b);
                jSONObject.put("videoLocalPath", this.d);
                jSONObject.put("startShowTime", this.j);
                jSONObject.put("endShowTime", this.k);
                jSONObject.put("videoMd5", this.f);
                jSONObject.put("videoJumpUrl", this.e);
                jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.g);
                jSONObject.put("videoWidth", this.h);
                jSONObject.put("videoHeight", this.i);
                jSONObject.put("adVideoUrl", this.c);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
