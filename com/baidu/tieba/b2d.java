package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.QuizCardTopConf;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public class b2d extends poc {
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
                poc.a(jSONObject, "img", p4d.b(themeColorInfo));
            }
            poc.a(jSONObject, "text", quizCardTopConf.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
