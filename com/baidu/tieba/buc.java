package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Agree;
/* loaded from: classes5.dex */
public class buc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Agree agree) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, agree)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "agree_num", agree.agree_num);
            ktc.a(jSONObject, "has_agree", agree.has_agree);
            ktc.a(jSONObject, "agree_type", agree.agree_type);
            ktc.a(jSONObject, "disagree_num", agree.disagree_num);
            ktc.a(jSONObject, "diff_agree_num", agree.diff_agree_num);
            ktc.a(jSONObject, "lz_agree", agree.lz_agree);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
