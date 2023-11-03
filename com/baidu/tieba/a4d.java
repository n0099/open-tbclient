package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TabMenu;
/* loaded from: classes5.dex */
public class a4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TabMenu tabMenu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tabMenu)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "class_id", tabMenu.class_id);
            poc.a(jSONObject, ForumSquareActivityConfig.FORUM_CLASS_NAME, tabMenu.class_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
