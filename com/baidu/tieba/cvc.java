package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ForumButton;
/* loaded from: classes5.dex */
public class cvc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumButton forumButton) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumButton)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "is_blueV", forumButton.is_blueV);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
