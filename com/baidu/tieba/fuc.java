package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AigcFeedbackInfo;
import tbclient.Toast;
/* loaded from: classes6.dex */
public class fuc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AigcFeedbackInfo aigcFeedbackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aigcFeedbackInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "aigc_chat_id", aigcFeedbackInfo.aigc_chat_id);
            ltc.a(jSONObject, "feedback_fold", aigcFeedbackInfo.feedback_fold);
            ltc.a(jSONObject, "feedback_fold_tip", aigcFeedbackInfo.feedback_fold_tip);
            ltc.a(jSONObject, "positive_text", aigcFeedbackInfo.positive_text);
            ltc.a(jSONObject, "negative_text", aigcFeedbackInfo.negative_text);
            ltc.a(jSONObject, "feedback_url", aigcFeedbackInfo.feedback_url);
            Toast toast = aigcFeedbackInfo.feedback_toast;
            if (toast != null) {
                ltc.a(jSONObject, "feedback_toast", iad.b(toast));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
