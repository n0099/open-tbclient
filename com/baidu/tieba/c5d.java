package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes5.dex */
public class c5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Media media) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, media)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", media.type);
            ltc.a(jSONObject, "small_pic", media.small_pic);
            ltc.a(jSONObject, "big_pic", media.big_pic);
            ltc.a(jSONObject, "water_pic", media.water_pic);
            ltc.a(jSONObject, "vpic", media.vpic);
            ltc.a(jSONObject, "vsrc", media.vsrc);
            ltc.a(jSONObject, "vhsrc", media.vhsrc);
            ltc.a(jSONObject, "src_pic", media.src_pic);
            ltc.a(jSONObject, "text", media.text);
            ltc.a(jSONObject, "width", media.width);
            ltc.a(jSONObject, "height", media.height);
            ltc.a(jSONObject, "bsize", media.bsize);
            ltc.a(jSONObject, "during_time", media.during_time);
            ltc.a(jSONObject, "e_type", media.e_type);
            ltc.a(jSONObject, "origin_pic", media.origin_pic);
            ltc.a(jSONObject, "origin_size", media.origin_size);
            ltc.a(jSONObject, "post_id", media.post_id);
            ltc.a(jSONObject, "dynamic_pic", media.dynamic_pic);
            ltc.a(jSONObject, "is_long_pic", media.is_long_pic);
            ltc.a(jSONObject, "show_original_btn", media.show_original_btn);
            ltc.a(jSONObject, "is_blocked_pic", media.is_blocked_pic);
            ltc.a(jSONObject, "wth_mid_loc", media.wth_mid_loc);
            ltc.a(jSONObject, "hth_mid_loc", media.hth_mid_loc);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, media.jump_url);
            ltc.a(jSONObject, "guide_text", media.guide_text);
            ltc.a(jSONObject, "lottie_type", media.lottie_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
