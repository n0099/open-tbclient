package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.SignUser;
/* loaded from: classes5.dex */
public class b2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignUser signUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_id", signUser.user_id);
            ltc.a(jSONObject, "is_sign_in", signUser.is_sign_in);
            ltc.a(jSONObject, "user_sign_rank", signUser.user_sign_rank);
            ltc.a(jSONObject, "sign_time", signUser.sign_time);
            ltc.a(jSONObject, "cont_sign_num", signUser.cont_sign_num);
            ltc.a(jSONObject, "cout_total_sign_num", signUser.cout_total_sign_num);
            ltc.a(jSONObject, "is_org_disabled", signUser.is_org_disabled);
            ltc.a(jSONObject, "c_sign_num", signUser.c_sign_num);
            ltc.a(jSONObject, "hun_sign_num", signUser.hun_sign_num);
            ltc.a(jSONObject, "total_resign_num", signUser.total_resign_num);
            ltc.a(jSONObject, "miss_sign_num", signUser.miss_sign_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
