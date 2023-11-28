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
public class e7d extends ltc {
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
                ltc.a(jSONObject, "freq", a7d.b(pubCardFreq));
            }
            ThemeColorInfo themeColorInfo = quizCard.card_background;
            if (themeColorInfo != null) {
                ltc.a(jSONObject, "card_background", t9d.b(themeColorInfo));
            }
            QuizCardTopConf quizCardTopConf = quizCard.top;
            if (quizCardTopConf != null) {
                ltc.a(jSONObject, "top", f7d.b(quizCardTopConf));
            }
            LinkConf linkConf = quizCard.bottom;
            if (linkConf != null) {
                ltc.a(jSONObject, "bottom", s4d.b(linkConf));
            }
            QuizInfo quizInfo = quizCard.quiz;
            if (quizInfo != null) {
                ltc.a(jSONObject, "quiz", g7d.b(quizInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
