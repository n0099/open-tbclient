package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PicDecoration;
import tbclient.PicInfo;
/* loaded from: classes6.dex */
public class g1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PicInfo picInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, picInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "small_pic_url", picInfo.small_pic_url);
            qoc.a(jSONObject, "big_pic_url", picInfo.big_pic_url);
            qoc.a(jSONObject, "origin_pic_url", picInfo.origin_pic_url);
            qoc.a(jSONObject, "width", picInfo.width);
            qoc.a(jSONObject, "height", picInfo.height);
            qoc.a(jSONObject, "is_long_pic", picInfo.is_long_pic);
            qoc.a(jSONObject, "crop_point_width_ratio", picInfo.crop_point_width_ratio);
            qoc.a(jSONObject, "crop_point_height_ratio", picInfo.crop_point_height_ratio);
            if (picInfo.decoration != null) {
                JSONArray jSONArray = new JSONArray();
                for (PicDecoration picDecoration : picInfo.decoration) {
                    jSONArray.put(f1d.b(picDecoration));
                }
                qoc.a(jSONObject, "decoration", jSONArray);
            }
            qoc.a(jSONObject, "scheme", picInfo.scheme);
            qoc.a(jSONObject, "pic_type", picInfo.pic_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
