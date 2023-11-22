package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MemeInfo;
/* loaded from: classes5.dex */
public class b0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MemeInfo memeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, memeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "pck_id", memeInfo.pck_id);
            qoc.a(jSONObject, EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, memeInfo.pic_id);
            qoc.a(jSONObject, "pic_url", memeInfo.pic_url);
            qoc.a(jSONObject, "thumbnail", memeInfo.thumbnail);
            qoc.a(jSONObject, "width", memeInfo.width);
            qoc.a(jSONObject, "height", memeInfo.height);
            qoc.a(jSONObject, "detail_link", memeInfo.detail_link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
