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
public class d2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull QuizInfo quizInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, quizInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "bonus_type", quizInfo.bonus_type);
            qoc.a(jSONObject, "title", quizInfo.title);
            qoc.a(jSONObject, "total_count_icon", quizInfo.total_count_icon);
            qoc.a(jSONObject, "total_count_text", quizInfo.total_count_text);
            qoc.a(jSONObject, "total_count", quizInfo.total_count);
            qoc.a(jSONObject, "total_user_count", quizInfo.total_user_count);
            qoc.a(jSONObject, "min_pour_count", quizInfo.min_pour_count);
            qoc.a(jSONObject, "quiz_id", quizInfo.quiz_id);
            qoc.a(jSONObject, "browse_user_option", quizInfo.browse_user_option);
            qoc.a(jSONObject, "product", quizInfo.product);
            if (quizInfo.options != null) {
                JSONArray jSONArray = new JSONArray();
                for (QuizOption quizOption : quizInfo.options) {
                    jSONArray.put(e2d.b(quizOption));
                }
                qoc.a(jSONObject, "options", jSONArray);
            }
            qoc.a(jSONObject, "type", quizInfo.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
