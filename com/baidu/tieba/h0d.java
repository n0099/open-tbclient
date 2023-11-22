package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NativeApp;
/* loaded from: classes6.dex */
public class h0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NativeApp nativeApp) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nativeApp)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "jump_and", nativeApp.jump_and);
            qoc.a(jSONObject, "jump_ios", nativeApp.jump_ios);
            qoc.a(jSONObject, "download_and", nativeApp.download_and);
            qoc.a(jSONObject, "download_ios", nativeApp.download_ios);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
