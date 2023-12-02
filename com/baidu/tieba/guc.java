package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AlaCoverLabel;
/* loaded from: classes6.dex */
public class guc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaCoverLabel alaCoverLabel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaCoverLabel)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "label_id", alaCoverLabel.label_id);
            ktc.a(jSONObject, "label_name", alaCoverLabel.label_name);
            ktc.a(jSONObject, "label_rgb", alaCoverLabel.label_rgb);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
