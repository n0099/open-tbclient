package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.SignUser;
/* loaded from: classes5.dex */
public class a2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignUser signUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "user_id", signUser.user_id);
            ktc.a(jSONObject, "is_sign_in", signUser.is_sign_in);
            ktc.a(jSONObject, "user_sign_rank", signUser.user_sign_rank);
            ktc.a(jSONObject, "sign_time", signUser.sign_time);
            ktc.a(jSONObject, "cont_sign_num", signUser.cont_sign_num);
            ktc.a(jSONObject, "cout_total_sign_num", signUser.cout_total_sign_num);
            ktc.a(jSONObject, "is_org_disabled", signUser.is_org_disabled);
            ktc.a(jSONObject, "c_sign_num", signUser.c_sign_num);
            ktc.a(jSONObject, "hun_sign_num", signUser.hun_sign_num);
            ktc.a(jSONObject, "total_resign_num", signUser.total_resign_num);
            ktc.a(jSONObject, "miss_sign_num", signUser.miss_sign_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
