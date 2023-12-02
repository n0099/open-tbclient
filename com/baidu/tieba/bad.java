package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThumbnailInfo;
/* loaded from: classes5.dex */
public class bad extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThumbnailInfo thumbnailInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, thumbnailInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "url", thumbnailInfo.url);
            ktc.a(jSONObject, "width", thumbnailInfo.width);
            ktc.a(jSONObject, "height", thumbnailInfo.height);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
