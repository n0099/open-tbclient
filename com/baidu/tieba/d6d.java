package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PbPresent;
import tbclient.PbPresentList;
/* loaded from: classes5.dex */
public class d6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbPresent pbPresent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbPresent)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "total", pbPresent.total);
            if (pbPresent.list != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbPresentList pbPresentList : pbPresent.list) {
                    jSONArray.put(e6d.b(pbPresentList));
                }
                ktc.a(jSONObject, "list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
