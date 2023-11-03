package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkItem;
import tbclient.PkModule;
/* loaded from: classes6.dex */
public class h1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PkModule pkModule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pkModule)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "pk_id", pkModule.pk_id);
            poc.a(jSONObject, "user_pk_id", pkModule.user_pk_id);
            PkItem pkItem = pkModule.agree;
            if (pkItem != null) {
                poc.a(jSONObject, "agree", g1d.b(pkItem));
            }
            PkItem pkItem2 = pkModule.disagree;
            if (pkItem2 != null) {
                poc.a(jSONObject, "disagree", g1d.b(pkItem2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
