package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkItem;
/* loaded from: classes6.dex */
public class g1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PkItem pkItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pkItem)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "pk_num", pkItem.pk_num);
            poc.a(jSONObject, "pk_desc", pkItem.pk_desc);
            poc.a(jSONObject, "last_username", pkItem.last_username);
            poc.a(jSONObject, "pk_icon", pkItem.pk_icon);
            poc.a(jSONObject, "has_clicked", pkItem.has_clicked);
            poc.a(jSONObject, "pk_index", pkItem.pk_index);
            poc.a(jSONObject, "pk_icon_after", pkItem.pk_icon_after);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
