package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.AlaLiveInsert;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class czc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaLiveInsert alaLiveInsert) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaLiveInsert)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (alaLiveInsert.ala_live_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : alaLiveInsert.ala_live_list) {
                    jSONArray.put(x9d.b(threadInfo));
                }
                ktc.a(jSONObject, "ala_live_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
