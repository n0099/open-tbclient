package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedContentColor;
import tbclient.FeedContentText;
/* loaded from: classes5.dex */
public class exc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentText feedContentText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentText)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "text", feedContentText.text);
            FeedContentColor feedContentColor = feedContentText.color;
            if (feedContentColor != null) {
                ktc.a(jSONObject, "color", zwc.b(feedContentColor));
            }
            FeedContentColor feedContentColor2 = feedContentText.bg_color;
            if (feedContentColor2 != null) {
                ktc.a(jSONObject, "bg_color", zwc.b(feedContentColor2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
