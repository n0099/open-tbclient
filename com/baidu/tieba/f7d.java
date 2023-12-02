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
public class f7d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull QuizInfo quizInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, quizInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "bonus_type", quizInfo.bonus_type);
            ktc.a(jSONObject, "title", quizInfo.title);
            ktc.a(jSONObject, "total_count_icon", quizInfo.total_count_icon);
            ktc.a(jSONObject, "total_count_text", quizInfo.total_count_text);
            ktc.a(jSONObject, "total_count", quizInfo.total_count);
            ktc.a(jSONObject, "total_user_count", quizInfo.total_user_count);
            ktc.a(jSONObject, "min_pour_count", quizInfo.min_pour_count);
            ktc.a(jSONObject, "quiz_id", quizInfo.quiz_id);
            ktc.a(jSONObject, "browse_user_option", quizInfo.browse_user_option);
            ktc.a(jSONObject, "product", quizInfo.product);
            if (quizInfo.options != null) {
                JSONArray jSONArray = new JSONArray();
                for (QuizOption quizOption : quizInfo.options) {
                    jSONArray.put(g7d.b(quizOption));
                }
                ktc.a(jSONObject, "options", jSONArray);
            }
            ktc.a(jSONObject, "type", quizInfo.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
