package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarContriRecord;
/* loaded from: classes5.dex */
public class c2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarContriRecord starContriRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starContriRecord)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "user_id", starContriRecord.user_id);
            ktc.a(jSONObject, "user_name", starContriRecord.user_name);
            ktc.a(jSONObject, "record_notice", starContriRecord.record_notice);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
