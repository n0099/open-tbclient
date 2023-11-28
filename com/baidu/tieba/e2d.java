package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes5.dex */
public class e2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarEnter starEnter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starEnter)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon", starEnter.icon);
            ltc.a(jSONObject, "title", starEnter.title);
            ltc.a(jSONObject, "weight", starEnter.weight);
            ltc.a(jSONObject, "type", starEnter.type);
            ltc.a(jSONObject, "url", starEnter.url);
            ltc.a(jSONObject, "time", starEnter.time);
            ltc.a(jSONObject, "obj_id", starEnter.obj_id);
            ltc.a(jSONObject, "text", starEnter.text);
            ltc.a(jSONObject, "rank_num", starEnter.rank_num);
            ltc.a(jSONObject, "bazhu_mark", starEnter.bazhu_mark);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
