package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedContentColor;
import tbclient.FeedContentText;
/* loaded from: classes6.dex */
public class hsc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedContentText feedContentText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedContentText)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "text", feedContentText.text);
            FeedContentColor feedContentColor = feedContentText.color;
            if (feedContentColor != null) {
                qoc.a(jSONObject, "color", csc.b(feedContentColor));
            }
            FeedContentColor feedContentColor2 = feedContentText.bg_color;
            if (feedContentColor2 != null) {
                qoc.a(jSONObject, "bg_color", csc.b(feedContentColor2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
