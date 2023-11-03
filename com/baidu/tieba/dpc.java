package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AddBawuPopInfo;
/* loaded from: classes5.dex */
public class dpc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AddBawuPopInfo addBawuPopInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, addBawuPopInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "title", addBawuPopInfo.title);
            poc.a(jSONObject, "content", addBawuPopInfo.content);
            poc.a(jSONObject, BigdayActivityConfig.IMG_URL, addBawuPopInfo.img_url);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, addBawuPopInfo.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
