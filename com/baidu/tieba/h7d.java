package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.QuizOption;
/* loaded from: classes6.dex */
public class h7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull QuizOption quizOption) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, quizOption)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "quiz_option_id", quizOption.quiz_option_id);
            ltc.a(jSONObject, "quiz_option", quizOption.quiz_option);
            ltc.a(jSONObject, "icon", quizOption.icon);
            ltc.a(jSONObject, "total_user_count", quizOption.total_user_count);
            ltc.a(jSONObject, "button_img", quizOption.button_img);
            ltc.a(jSONObject, "button_text_sup", quizOption.button_text_sup);
            ltc.a(jSONObject, "button_text_no", quizOption.button_text_no);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
