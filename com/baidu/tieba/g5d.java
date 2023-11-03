package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Topic;
/* loaded from: classes6.dex */
public class g5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Topic topic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topic)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "is_lpost", topic.is_lpost);
            poc.a(jSONObject, TiebaStatic.Params.TOPIC_TYPE, topic.topic_type);
            poc.a(jSONObject, "link", topic.link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
