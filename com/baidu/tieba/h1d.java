package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkItem;
/* loaded from: classes6.dex */
public class h1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PkItem pkItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pkItem)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "pk_num", pkItem.pk_num);
            qoc.a(jSONObject, "pk_desc", pkItem.pk_desc);
            qoc.a(jSONObject, "last_username", pkItem.last_username);
            qoc.a(jSONObject, "pk_icon", pkItem.pk_icon);
            qoc.a(jSONObject, "has_clicked", pkItem.has_clicked);
            qoc.a(jSONObject, "pk_index", pkItem.pk_index);
            qoc.a(jSONObject, "pk_icon_after", pkItem.pk_icon_after);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
