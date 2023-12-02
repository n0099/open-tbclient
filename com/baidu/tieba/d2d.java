package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes5.dex */
public class d2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarEnter starEnter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starEnter)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "icon", starEnter.icon);
            ktc.a(jSONObject, "title", starEnter.title);
            ktc.a(jSONObject, "weight", starEnter.weight);
            ktc.a(jSONObject, "type", starEnter.type);
            ktc.a(jSONObject, "url", starEnter.url);
            ktc.a(jSONObject, "time", starEnter.time);
            ktc.a(jSONObject, "obj_id", starEnter.obj_id);
            ktc.a(jSONObject, "text", starEnter.text);
            ktc.a(jSONObject, "rank_num", starEnter.rank_num);
            ktc.a(jSONObject, "bazhu_mark", starEnter.bazhu_mark);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
