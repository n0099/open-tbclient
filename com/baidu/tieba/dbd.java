package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.McnAdInfo;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class dbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, VideoFinishResult.KEY_VIDEO_MD5, videoInfo.video_md5);
            ltc.a(jSONObject, "video_url", videoInfo.video_url);
            ltc.a(jSONObject, AdWebVideoActivityConfig.KEY_VIDEO_DURATION, videoInfo.video_duration);
            ltc.a(jSONObject, "video_width", videoInfo.video_width);
            ltc.a(jSONObject, "video_height", videoInfo.video_height);
            ltc.a(jSONObject, "thumbnail_url", videoInfo.thumbnail_url);
            ltc.a(jSONObject, "thumbnail_width", videoInfo.thumbnail_width);
            ltc.a(jSONObject, "thumbnail_height", videoInfo.thumbnail_height);
            ltc.a(jSONObject, "video_length", videoInfo.video_length);
            ltc.a(jSONObject, "play_count", videoInfo.play_count);
            ltc.a(jSONObject, "media_subtitle", videoInfo.media_subtitle);
            if (videoInfo.video_desc != null) {
                JSONArray jSONArray = new JSONArray();
                for (VideoDesc videoDesc : videoInfo.video_desc) {
                    jSONArray.put(abd.b(videoDesc));
                }
                ltc.a(jSONObject, "video_desc", jSONArray);
            }
            ltc.a(jSONObject, "video_select_flag", videoInfo.video_select_flag);
            ltc.a(jSONObject, "video_type", videoInfo.video_type);
            ltc.a(jSONObject, TiebaStatic.Params.IS_VERTICAL, videoInfo.is_vertical);
            VideoDesc videoDesc2 = videoInfo.video_h265;
            if (videoDesc2 != null) {
                ltc.a(jSONObject, "video_h265", abd.b(videoDesc2));
            }
            ltc.a(jSONObject, "mcn_lead_page", videoInfo.mcn_lead_page);
            McnAdInfo mcnAdInfo = videoInfo.mcn_ad_card;
            if (mcnAdInfo != null) {
                ltc.a(jSONObject, "mcn_ad_card", b5d.b(mcnAdInfo));
            }
            ltc.a(jSONObject, "wth_mid_loc", videoInfo.wth_mid_loc);
            ltc.a(jSONObject, "hth_mid_loc", videoInfo.hth_mid_loc);
            ltc.a(jSONObject, "small_thumbnail_url", videoInfo.small_thumbnail_url);
            ltc.a(jSONObject, "first_frame_thumbnail", videoInfo.first_frame_thumbnail);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
