package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.QuizInfo;
import tbclient.QuizOption;
/* loaded from: classes5.dex */
public class c2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull QuizInfo quizInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, quizInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "bonus_type", quizInfo.bonus_type);
            poc.a(jSONObject, "title", quizInfo.title);
            poc.a(jSONObject, "total_count_icon", quizInfo.total_count_icon);
            poc.a(jSONObject, "total_count_text", quizInfo.total_count_text);
            poc.a(jSONObject, "total_count", quizInfo.total_count);
            poc.a(jSONObject, "total_user_count", quizInfo.total_user_count);
            poc.a(jSONObject, "min_pour_count", quizInfo.min_pour_count);
            poc.a(jSONObject, "quiz_id", quizInfo.quiz_id);
            poc.a(jSONObject, "browse_user_option", quizInfo.browse_user_option);
            poc.a(jSONObject, "product", quizInfo.product);
            if (quizInfo.options != null) {
                JSONArray jSONArray = new JSONArray();
                for (QuizOption quizOption : quizInfo.options) {
                    jSONArray.put(d2d.b(quizOption));
                }
                poc.a(jSONObject, "options", jSONArray);
            }
            poc.a(jSONObject, "type", quizInfo.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
