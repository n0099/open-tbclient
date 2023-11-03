package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.NebulaHotThread;
import tbclient.FrsPage.NebulaHotThreads;
/* loaded from: classes5.dex */
public class dwc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NebulaHotThreads nebulaHotThreads) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nebulaHotThreads)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "url", nebulaHotThreads.url);
            if (nebulaHotThreads.threads != null) {
                JSONArray jSONArray = new JSONArray();
                for (NebulaHotThread nebulaHotThread : nebulaHotThreads.threads) {
                    jSONArray.put(cwc.b(nebulaHotThread));
                }
                poc.a(jSONObject, "threads", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
