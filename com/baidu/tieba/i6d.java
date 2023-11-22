package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.WapRn;
/* loaded from: classes6.dex */
public class i6d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WapRn wapRn) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wapRn)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "frsrn", wapRn.frsrn);
            qoc.a(jSONObject, "pbrn", wapRn.pbrn);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
