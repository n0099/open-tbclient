package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.QuizCardTopConf;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public class e7d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull QuizCardTopConf quizCardTopConf) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, quizCardTopConf)) == null) {
            JSONObject jSONObject = new JSONObject();
            ThemeColorInfo themeColorInfo = quizCardTopConf.img;
            if (themeColorInfo != null) {
                ktc.a(jSONObject, "img", s9d.b(themeColorInfo));
            }
            ktc.a(jSONObject, "text", quizCardTopConf.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
