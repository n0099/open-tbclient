package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkModule;
import tbclient.TopicModule;
/* loaded from: classes6.dex */
public class h5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopicModule topicModule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topicModule)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "topic_id", topicModule.topic_id);
            poc.a(jSONObject, "topic_name", topicModule.topic_name);
            poc.a(jSONObject, "topic_desc", topicModule.topic_desc);
            poc.a(jSONObject, "discuss_num", topicModule.discuss_num);
            poc.a(jSONObject, "topic_image", topicModule.topic_image);
            PkModule pkModule = topicModule.pk_module;
            if (pkModule != null) {
                poc.a(jSONObject, "pk_module", h1d.b(pkModule));
            }
            poc.a(jSONObject, "topic_avatar", topicModule.topic_avatar);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
