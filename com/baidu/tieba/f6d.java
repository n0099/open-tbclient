package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Voice;
/* loaded from: classes5.dex */
public class f6d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Voice voice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, voice)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", voice.type);
            qoc.a(jSONObject, "during_time", voice.during_time);
            qoc.a(jSONObject, "voice_md5", voice.voice_md5);
            qoc.a(jSONObject, "voice_url", voice.voice_url);
            qoc.a(jSONObject, "uid", voice.uid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
