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
/* loaded from: classes5.dex */
public class eyc extends ktc {
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
                ktc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, bbd.b(videoField));
            }
            ktc.a(jSONObject, "schema", feedVideoAdComponent.schema);
            FeedMaskLayer feedMaskLayer = feedVideoAdComponent.mask_layer;
            if (feedMaskLayer != null) {
                ktc.a(jSONObject, "mask_layer", vxc.b(feedMaskLayer));
            }
            DownloadBar downloadBar = feedVideoAdComponent.download_bar;
            if (downloadBar != null) {
                ktc.a(jSONObject, "download_bar", owc.b(downloadBar));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
