package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.QuizOption;
/* loaded from: classes5.dex */
public class e2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull QuizOption quizOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, quizOption)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "quiz_option_id", quizOption.quiz_option_id);
            qoc.a(jSONObject, "quiz_option", quizOption.quiz_option);
            qoc.a(jSONObject, "icon", quizOption.icon);
            qoc.a(jSONObject, "total_user_count", quizOption.total_user_count);
            qoc.a(jSONObject, "button_img", quizOption.button_img);
            qoc.a(jSONObject, "button_text_sup", quizOption.button_text_sup);
            qoc.a(jSONObject, "button_text_no", quizOption.button_text_no);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
