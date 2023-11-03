package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedContentResource;
import tbclient.TitleComponent;
/* loaded from: classes5.dex */
public class c5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TitleComponent titleComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, titleComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (titleComponent.data != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedContentResource feedContentResource : titleComponent.data) {
                    jSONArray.put(fsc.b(feedContentResource));
                }
                poc.a(jSONObject, "data", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
