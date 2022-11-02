package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n15 a;
    public int b;
    public long c;
    public long d;
    public int e;
    public int f;
    public int g;
    public int h;
    public String i;
    public boolean j;
    public String k;
    public String l;

    public g15() {
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
        this.e = 0;
        this.f = 0;
        this.g = 300;
        this.h = 1;
        this.a = new n15();
    }

    public n15 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (n15) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.e == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b != 1) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.c >= currentTimeMillis || currentTimeMillis >= this.d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        boolean z = true;
        jSONObject.optInt("als_control", 1);
        jSONObject.optInt("not_use_lego_patch", 0);
        jSONObject.optInt("ad_video_not_autoplay", 1);
        this.f = jSONObject.optInt("lp_video_not_autoplay", 0);
        this.a.a(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
        if (optJSONObject != null) {
            this.b = optJSONObject.optInt("log_feed_switch", 0);
            this.c = optJSONObject.optLong("start_time", -1L);
            this.d = optJSONObject.optLong("end_time", -1L);
            optJSONObject.optString("ext_info");
        }
        this.e = jSONObject.optInt("ad_collect_switch", 0);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_SPLASH);
        if (optJSONObject2 != null) {
            this.g = optJSONObject2.optInt("interval", 300);
        }
        this.h = jSONObject.optInt("video_page_style", 1);
        ky4.k().w("video_page_style", this.h);
        jSONObject.optInt("ad_download_lib", 0);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("action_control");
        if (optJSONObject3 != null) {
            this.i = optJSONObject3.optString("url");
            optJSONObject3.optString("name");
            optJSONObject3.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
            optJSONObject3.optString("text_color_pressed");
        }
        if (jSONObject.optInt("afd_jump_pb") != 1) {
            z = false;
        }
        this.j = z;
        this.k = jSONObject.optString("afd_eid");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("iadex_sniff_list_url");
        if (optJSONObject4 != null) {
            String optString = optJSONObject4.optString("os_type2_iadex_url");
            this.l = optString;
            xh5.h(optString);
            return;
        }
        xh5.h(null);
    }
}
