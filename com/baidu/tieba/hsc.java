package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedEntrybarComponent;
/* loaded from: classes6.dex */
public class hsc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedEntrybarComponent feedEntrybarComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedEntrybarComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "text", feedEntrybarComponent.text);
            poc.a(jSONObject, "schema", feedEntrybarComponent.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
