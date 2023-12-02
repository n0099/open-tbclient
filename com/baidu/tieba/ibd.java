package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Voice;
/* loaded from: classes6.dex */
public class ibd extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Voice voice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, voice)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", voice.type);
            ktc.a(jSONObject, "during_time", voice.during_time);
            ktc.a(jSONObject, "voice_md5", voice.voice_md5);
            ktc.a(jSONObject, "voice_url", voice.voice_url);
            ktc.a(jSONObject, "uid", voice.uid);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
