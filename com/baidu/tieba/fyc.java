package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DownloadBar;
import tbclient.FeedMaskLayer;
import tbclient.FeedVideoAdComponent;
import tbclient.VideoField;
/* loaded from: classes6.dex */
public class fyc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedVideoAdComponent feedVideoAdComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedVideoAdComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            VideoField videoField = feedVideoAdComponent.video_info;
            if (videoField != null) {
                ltc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, cbd.b(videoField));
            }
            ltc.a(jSONObject, "schema", feedVideoAdComponent.schema);
            FeedMaskLayer feedMaskLayer = feedVideoAdComponent.mask_layer;
            if (feedMaskLayer != null) {
                ltc.a(jSONObject, "mask_layer", wxc.b(feedMaskLayer));
            }
            DownloadBar downloadBar = feedVideoAdComponent.download_bar;
            if (downloadBar != null) {
                ltc.a(jSONObject, "download_bar", pwc.b(downloadBar));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
