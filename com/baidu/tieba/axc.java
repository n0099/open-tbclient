package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.SignUser;
/* loaded from: classes5.dex */
public class axc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignUser signUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", signUser.user_id);
            qoc.a(jSONObject, "is_sign_in", signUser.is_sign_in);
            qoc.a(jSONObject, "user_sign_rank", signUser.user_sign_rank);
            qoc.a(jSONObject, "sign_time", signUser.sign_time);
            qoc.a(jSONObject, "cont_sign_num", signUser.cont_sign_num);
            qoc.a(jSONObject, "cout_total_sign_num", signUser.cout_total_sign_num);
            qoc.a(jSONObject, "is_org_disabled", signUser.is_org_disabled);
            qoc.a(jSONObject, "c_sign_num", signUser.c_sign_num);
            qoc.a(jSONObject, "hun_sign_num", signUser.hun_sign_num);
            qoc.a(jSONObject, "total_resign_num", signUser.total_resign_num);
            qoc.a(jSONObject, "miss_sign_num", signUser.miss_sign_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
