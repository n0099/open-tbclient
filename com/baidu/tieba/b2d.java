package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LinkConf;
import tbclient.PubCardFreq;
import tbclient.QuizCard;
import tbclient.QuizCardTopConf;
import tbclient.QuizInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
public class b2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull QuizCard quizCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, quizCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            PubCardFreq pubCardFreq = quizCard.freq;
            if (pubCardFreq != null) {
                qoc.a(jSONObject, "freq", x1d.b(pubCardFreq));
            }
            ThemeColorInfo themeColorInfo = quizCard.card_background;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, "card_background", q4d.b(themeColorInfo));
            }
            QuizCardTopConf quizCardTopConf = quizCard.top;
            if (quizCardTopConf != null) {
                qoc.a(jSONObject, "top", c2d.b(quizCardTopConf));
            }
            LinkConf linkConf = quizCard.bottom;
            if (linkConf != null) {
                qoc.a(jSONObject, "bottom", pzc.b(linkConf));
            }
            QuizInfo quizInfo = quizCard.quiz;
            if (quizInfo != null) {
                qoc.a(jSONObject, "quiz", d2d.b(quizInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
