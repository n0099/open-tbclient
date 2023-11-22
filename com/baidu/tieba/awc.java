package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.MemberShowIcon;
/* loaded from: classes5.dex */
public class awc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MemberShowIcon memberShowIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, memberShowIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon", memberShowIcon.icon);
            qoc.a(jSONObject, "name", memberShowIcon.name);
            qoc.a(jSONObject, "url", memberShowIcon.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
