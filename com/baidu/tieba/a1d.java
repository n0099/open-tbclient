package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.MemberShowIcon;
/* loaded from: classes5.dex */
public class a1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MemberShowIcon memberShowIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, memberShowIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "icon", memberShowIcon.icon);
            ktc.a(jSONObject, "name", memberShowIcon.name);
            ktc.a(jSONObject, "url", memberShowIcon.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
