package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedVideoComponent;
import tbclient.VideoField;
/* loaded from: classes6.dex */
public class fyc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedVideoComponent feedVideoComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedVideoComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            VideoField videoField = feedVideoComponent.video_info;
            if (videoField != null) {
                ktc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, bbd.b(videoField));
            }
            ktc.a(jSONObject, "schema", feedVideoComponent.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
