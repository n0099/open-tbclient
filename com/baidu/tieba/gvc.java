package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes6.dex */
public class gvc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BirthdayInfo birthdayInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, birthdayInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "birthday_time", birthdayInfo.birthday_time);
            ktc.a(jSONObject, "birthday_show_status", birthdayInfo.birthday_show_status);
            ktc.a(jSONObject, "constellation", birthdayInfo.constellation);
            ktc.a(jSONObject, "age", birthdayInfo.age);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
