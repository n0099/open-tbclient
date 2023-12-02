package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ClickBackCardItem;
/* loaded from: classes5.dex */
public class awc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ClickBackCardItem clickBackCardItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, clickBackCardItem)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "text", clickBackCardItem.text);
            ktc.a(jSONObject, BigdayActivityConfig.JUMP_URL, clickBackCardItem.jump_url);
            ktc.a(jSONObject, "business_id", clickBackCardItem.business_id);
            ktc.a(jSONObject, "business_type", clickBackCardItem.business_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
