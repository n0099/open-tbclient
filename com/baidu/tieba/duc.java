package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AichatBotCommentCard;
/* loaded from: classes5.dex */
public class duc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AichatBotCommentCard aichatBotCommentCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aichatBotCommentCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "uk", aichatBotCommentCard.uk);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
