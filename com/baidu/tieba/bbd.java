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
public class bbd extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoField videoField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoField)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "url", videoField.url);
            ktc.a(jSONObject, "duration", videoField.duration);
            ktc.a(jSONObject, "width", videoField.width);
            ktc.a(jSONObject, "height", videoField.height);
            ktc.a(jSONObject, "play_count", videoField.play_count);
            ThumbnailInfo thumbnailInfo = videoField.thumbnail;
            if (thumbnailInfo != null) {
                ktc.a(jSONObject, "thumbnail", bad.b(thumbnailInfo));
            }
            ktc.a(jSONObject, TiebaStatic.Params.IS_VERTICAL, videoField.is_vertical);
            ktc.a(jSONObject, "md5", videoField.md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
