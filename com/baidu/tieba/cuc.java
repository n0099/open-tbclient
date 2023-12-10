package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Agree;
/* loaded from: classes5.dex */
public class cuc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Agree agree) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, agree)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "agree_num", agree.agree_num);
            ltc.a(jSONObject, "has_agree", agree.has_agree);
            ltc.a(jSONObject, "agree_type", agree.agree_type);
            ltc.a(jSONObject, "disagree_num", agree.disagree_num);
            ltc.a(jSONObject, "diff_agree_num", agree.diff_agree_num);
            ltc.a(jSONObject, "lz_agree", agree.lz_agree);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
