package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThumbnailInfo;
import tbclient.VideoField;
/* loaded from: classes5.dex */
public class cbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoField videoField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoField)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "url", videoField.url);
            ltc.a(jSONObject, "duration", videoField.duration);
            ltc.a(jSONObject, "width", videoField.width);
            ltc.a(jSONObject, "height", videoField.height);
            ltc.a(jSONObject, "play_count", videoField.play_count);
            ThumbnailInfo thumbnailInfo = videoField.thumbnail;
            if (thumbnailInfo != null) {
                ltc.a(jSONObject, "thumbnail", cad.b(thumbnailInfo));
            }
            ltc.a(jSONObject, TiebaStatic.Params.IS_VERTICAL, videoField.is_vertical);
            ltc.a(jSONObject, "md5", videoField.md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
