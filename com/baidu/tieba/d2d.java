package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarContriRecord;
/* loaded from: classes5.dex */
public class d2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarContriRecord starContriRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starContriRecord)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_id", starContriRecord.user_id);
            ltc.a(jSONObject, "user_name", starContriRecord.user_name);
            ltc.a(jSONObject, "record_notice", starContriRecord.record_notice);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
