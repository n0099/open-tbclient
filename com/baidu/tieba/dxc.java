package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes5.dex */
public class dxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarEnter starEnter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starEnter)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon", starEnter.icon);
            qoc.a(jSONObject, "title", starEnter.title);
            qoc.a(jSONObject, "weight", starEnter.weight);
            qoc.a(jSONObject, "type", starEnter.type);
            qoc.a(jSONObject, "url", starEnter.url);
            qoc.a(jSONObject, "time", starEnter.time);
            qoc.a(jSONObject, "obj_id", starEnter.obj_id);
            qoc.a(jSONObject, "text", starEnter.text);
            qoc.a(jSONObject, "rank_num", starEnter.rank_num);
            qoc.a(jSONObject, "bazhu_mark", starEnter.bazhu_mark);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
