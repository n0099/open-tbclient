package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedbackReason;
/* loaded from: classes6.dex */
public class hyc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedbackReason feedbackReason) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedbackReason)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "reason", feedbackReason.reason);
            ltc.a(jSONObject, "id", feedbackReason.id);
            ltc.a(jSONObject, "extra", feedbackReason.extra);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
