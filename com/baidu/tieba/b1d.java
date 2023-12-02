package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Music;
/* loaded from: classes5.dex */
public class b1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Music music) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, music)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "pic", music.pic);
            ktc.a(jSONObject, "num", music.num);
            ktc.a(jSONObject, "sid", music.sid);
            ktc.a(jSONObject, "isopen", music.isopen);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
