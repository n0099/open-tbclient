package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Music;
/* loaded from: classes5.dex */
public class bwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Music music) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, music)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "pic", music.pic);
            qoc.a(jSONObject, "num", music.num);
            qoc.a(jSONObject, "sid", music.sid);
            qoc.a(jSONObject, "isopen", music.isopen);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
