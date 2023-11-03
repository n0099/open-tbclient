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
public class gtc extends poc {
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
                poc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, x5d.b(videoField));
            }
            poc.a(jSONObject, "schema", feedVideoAdComponent.schema);
            FeedMaskLayer feedMaskLayer = feedVideoAdComponent.mask_layer;
            if (feedMaskLayer != null) {
                poc.a(jSONObject, "mask_layer", xsc.b(feedMaskLayer));
            }
            DownloadBar downloadBar = feedVideoAdComponent.download_bar;
            if (downloadBar != null) {
                poc.a(jSONObject, "download_bar", qrc.b(downloadBar));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
