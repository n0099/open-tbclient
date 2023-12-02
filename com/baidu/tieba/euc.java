package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AigcFeedbackInfo;
import tbclient.Toast;
/* loaded from: classes5.dex */
public class euc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AigcFeedbackInfo aigcFeedbackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aigcFeedbackInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "aigc_chat_id", aigcFeedbackInfo.aigc_chat_id);
            ktc.a(jSONObject, "feedback_fold", aigcFeedbackInfo.feedback_fold);
            ktc.a(jSONObject, "feedback_fold_tip", aigcFeedbackInfo.feedback_fold_tip);
            ktc.a(jSONObject, "positive_text", aigcFeedbackInfo.positive_text);
            ktc.a(jSONObject, "negative_text", aigcFeedbackInfo.negative_text);
            ktc.a(jSONObject, "feedback_url", aigcFeedbackInfo.feedback_url);
            Toast toast = aigcFeedbackInfo.feedback_toast;
            if (toast != null) {
                ktc.a(jSONObject, "feedback_toast", had.b(toast));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
