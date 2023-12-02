package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MemeInfo;
/* loaded from: classes5.dex */
public class d5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MemeInfo memeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, memeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "pck_id", memeInfo.pck_id);
            ktc.a(jSONObject, EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, memeInfo.pic_id);
            ktc.a(jSONObject, "pic_url", memeInfo.pic_url);
            ktc.a(jSONObject, "thumbnail", memeInfo.thumbnail);
            ktc.a(jSONObject, "width", memeInfo.width);
            ktc.a(jSONObject, "height", memeInfo.height);
            ktc.a(jSONObject, "detail_link", memeInfo.detail_link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
