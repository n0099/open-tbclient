package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkItem;
import tbclient.PkModule;
/* loaded from: classes6.dex */
public class i1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PkModule pkModule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pkModule)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "pk_id", pkModule.pk_id);
            qoc.a(jSONObject, "user_pk_id", pkModule.user_pk_id);
            PkItem pkItem = pkModule.agree;
            if (pkItem != null) {
                qoc.a(jSONObject, "agree", h1d.b(pkItem));
            }
            PkItem pkItem2 = pkModule.disagree;
            if (pkItem2 != null) {
                qoc.a(jSONObject, "disagree", h1d.b(pkItem2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
