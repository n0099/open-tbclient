package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AlaChallengeInfo;
/* loaded from: classes6.dex */
public class guc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaChallengeInfo alaChallengeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaChallengeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "challenge_id", alaChallengeInfo.challenge_id);
            ltc.a(jSONObject, "winning_num", alaChallengeInfo.winning_num);
            ltc.a(jSONObject, "rival_session", alaChallengeInfo.rival_session);
            ltc.a(jSONObject, "rival_rtmp_url", alaChallengeInfo.rival_rtmp_url);
            ltc.a(jSONObject, "rival_hls_url", alaChallengeInfo.rival_hls_url);
            ltc.a(jSONObject, "ext", alaChallengeInfo.ext);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
