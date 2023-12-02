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
public class d7d extends ktc {
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
                ktc.a(jSONObject, "freq", z6d.b(pubCardFreq));
            }
            ThemeColorInfo themeColorInfo = quizCard.card_background;
            if (themeColorInfo != null) {
                ktc.a(jSONObject, "card_background", s9d.b(themeColorInfo));
            }
            QuizCardTopConf quizCardTopConf = quizCard.top;
            if (quizCardTopConf != null) {
                ktc.a(jSONObject, "top", e7d.b(quizCardTopConf));
            }
            LinkConf linkConf = quizCard.bottom;
            if (linkConf != null) {
                ktc.a(jSONObject, "bottom", r4d.b(linkConf));
            }
            QuizInfo quizInfo = quizCard.quiz;
            if (quizInfo != null) {
                ktc.a(jSONObject, "quiz", f7d.b(quizInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
