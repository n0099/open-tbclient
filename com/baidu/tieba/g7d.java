package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.QuizInfo;
import tbclient.QuizOption;
/* loaded from: classes6.dex */
public class g7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull QuizInfo quizInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, quizInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "bonus_type", quizInfo.bonus_type);
            ltc.a(jSONObject, "title", quizInfo.title);
            ltc.a(jSONObject, "total_count_icon", quizInfo.total_count_icon);
            ltc.a(jSONObject, "total_count_text", quizInfo.total_count_text);
            ltc.a(jSONObject, "total_count", quizInfo.total_count);
            ltc.a(jSONObject, "total_user_count", quizInfo.total_user_count);
            ltc.a(jSONObject, "min_pour_count", quizInfo.min_pour_count);
            ltc.a(jSONObject, "quiz_id", quizInfo.quiz_id);
            ltc.a(jSONObject, "browse_user_option", quizInfo.browse_user_option);
            ltc.a(jSONObject, "product", quizInfo.product);
            if (quizInfo.options != null) {
                JSONArray jSONArray = new JSONArray();
                for (QuizOption quizOption : quizInfo.options) {
                    jSONArray.put(h7d.b(quizOption));
                }
                ltc.a(jSONObject, "options", jSONArray);
            }
            ltc.a(jSONObject, "type", quizInfo.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
