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
public class htc extends qoc {
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
                qoc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, y5d.b(videoField));
            }
            qoc.a(jSONObject, "schema", feedVideoAdComponent.schema);
            FeedMaskLayer feedMaskLayer = feedVideoAdComponent.mask_layer;
            if (feedMaskLayer != null) {
                qoc.a(jSONObject, "mask_layer", ysc.b(feedMaskLayer));
            }
            DownloadBar downloadBar = feedVideoAdComponent.download_bar;
            if (downloadBar != null) {
                qoc.a(jSONObject, "download_bar", rrc.b(downloadBar));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
