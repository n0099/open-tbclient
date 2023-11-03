package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.QuizOption;
/* loaded from: classes5.dex */
public class d2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull QuizOption quizOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, quizOption)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "quiz_option_id", quizOption.quiz_option_id);
            poc.a(jSONObject, "quiz_option", quizOption.quiz_option);
            poc.a(jSONObject, "icon", quizOption.icon);
            poc.a(jSONObject, "total_user_count", quizOption.total_user_count);
            poc.a(jSONObject, "button_img", quizOption.button_img);
            poc.a(jSONObject, "button_text_sup", quizOption.button_text_sup);
            poc.a(jSONObject, "button_text_no", quizOption.button_text_no);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
