package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Voice;
/* loaded from: classes5.dex */
public class e6d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Voice voice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, voice)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", voice.type);
            poc.a(jSONObject, "during_time", voice.during_time);
            poc.a(jSONObject, "voice_md5", voice.voice_md5);
            poc.a(jSONObject, "voice_url", voice.voice_url);
            poc.a(jSONObject, "uid", voice.uid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
