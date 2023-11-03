package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MemeInfo;
/* loaded from: classes5.dex */
public class a0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MemeInfo memeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, memeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "pck_id", memeInfo.pck_id);
            poc.a(jSONObject, EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, memeInfo.pic_id);
            poc.a(jSONObject, "pic_url", memeInfo.pic_url);
            poc.a(jSONObject, "thumbnail", memeInfo.thumbnail);
            poc.a(jSONObject, "width", memeInfo.width);
            poc.a(jSONObject, "height", memeInfo.height);
            poc.a(jSONObject, "detail_link", memeInfo.detail_link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
