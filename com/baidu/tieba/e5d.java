package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MemeInfo;
/* loaded from: classes5.dex */
public class e5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MemeInfo memeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, memeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "pck_id", memeInfo.pck_id);
            ltc.a(jSONObject, EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, memeInfo.pic_id);
            ltc.a(jSONObject, "pic_url", memeInfo.pic_url);
            ltc.a(jSONObject, "thumbnail", memeInfo.thumbnail);
            ltc.a(jSONObject, "width", memeInfo.width);
            ltc.a(jSONObject, "height", memeInfo.height);
            ltc.a(jSONObject, "detail_link", memeInfo.detail_link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
