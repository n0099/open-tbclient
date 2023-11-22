package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarContriRecord;
/* loaded from: classes5.dex */
public class cxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarContriRecord starContriRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starContriRecord)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", starContriRecord.user_id);
            qoc.a(jSONObject, "user_name", starContriRecord.user_name);
            qoc.a(jSONObject, "record_notice", starContriRecord.record_notice);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
