package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes5.dex */
public class b5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Media media) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, media)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", media.type);
            ktc.a(jSONObject, "small_pic", media.small_pic);
            ktc.a(jSONObject, "big_pic", media.big_pic);
            ktc.a(jSONObject, "water_pic", media.water_pic);
            ktc.a(jSONObject, "vpic", media.vpic);
            ktc.a(jSONObject, "vsrc", media.vsrc);
            ktc.a(jSONObject, "vhsrc", media.vhsrc);
            ktc.a(jSONObject, "src_pic", media.src_pic);
            ktc.a(jSONObject, "text", media.text);
            ktc.a(jSONObject, "width", media.width);
            ktc.a(jSONObject, "height", media.height);
            ktc.a(jSONObject, "bsize", media.bsize);
            ktc.a(jSONObject, "during_time", media.during_time);
            ktc.a(jSONObject, "e_type", media.e_type);
            ktc.a(jSONObject, "origin_pic", media.origin_pic);
            ktc.a(jSONObject, "origin_size", media.origin_size);
            ktc.a(jSONObject, "post_id", media.post_id);
            ktc.a(jSONObject, "dynamic_pic", media.dynamic_pic);
            ktc.a(jSONObject, "is_long_pic", media.is_long_pic);
            ktc.a(jSONObject, "show_original_btn", media.show_original_btn);
            ktc.a(jSONObject, "is_blocked_pic", media.is_blocked_pic);
            ktc.a(jSONObject, "wth_mid_loc", media.wth_mid_loc);
            ktc.a(jSONObject, "hth_mid_loc", media.hth_mid_loc);
            ktc.a(jSONObject, BigdayActivityConfig.JUMP_URL, media.jump_url);
            ktc.a(jSONObject, "guide_text", media.guide_text);
            ktc.a(jSONObject, "lottie_type", media.lottie_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
