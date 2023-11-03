package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes5.dex */
public class cxc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarEnter starEnter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starEnter)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "icon", starEnter.icon);
            poc.a(jSONObject, "title", starEnter.title);
            poc.a(jSONObject, "weight", starEnter.weight);
            poc.a(jSONObject, "type", starEnter.type);
            poc.a(jSONObject, "url", starEnter.url);
            poc.a(jSONObject, "time", starEnter.time);
            poc.a(jSONObject, "obj_id", starEnter.obj_id);
            poc.a(jSONObject, "text", starEnter.text);
            poc.a(jSONObject, "rank_num", starEnter.rank_num);
            poc.a(jSONObject, "bazhu_mark", starEnter.bazhu_mark);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
