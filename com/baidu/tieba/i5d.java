package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkModule;
import tbclient.TopicModule;
/* loaded from: classes6.dex */
public class i5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopicModule topicModule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topicModule)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "topic_id", topicModule.topic_id);
            qoc.a(jSONObject, "topic_name", topicModule.topic_name);
            qoc.a(jSONObject, "topic_desc", topicModule.topic_desc);
            qoc.a(jSONObject, "discuss_num", topicModule.discuss_num);
            qoc.a(jSONObject, "topic_image", topicModule.topic_image);
            PkModule pkModule = topicModule.pk_module;
            if (pkModule != null) {
                qoc.a(jSONObject, "pk_module", i1d.b(pkModule));
            }
            qoc.a(jSONObject, "topic_avatar", topicModule.topic_avatar);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
