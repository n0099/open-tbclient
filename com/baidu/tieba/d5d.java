package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
import tbclient.ToastContent;
/* loaded from: classes5.dex */
public class d5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ToastContent toastContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, toastContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "text", toastContent.text);
            poc.a(jSONObject, "has_color", toastContent.has_color);
            poc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, toastContent.text_color);
            poc.a(jSONObject, "text_color_dark", toastContent.text_color_dark);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
