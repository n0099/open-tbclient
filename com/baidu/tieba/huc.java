package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AlaChallengeInfo;
import tbclient.AlaCoverLabel;
import tbclient.AlaLiveInfo;
import tbclient.AlaShareInfo;
import tbclient.AlaStageDislikeInfo;
import tbclient.AlaUserInfo;
import tbclient.DislikeInfo;
import tbclient.UniversalLabel;
import tbclient.WidthHeight;
import tbclient.YyExt;
/* loaded from: classes6.dex */
public class huc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaLiveInfo alaLiveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaLiveInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "live_id", alaLiveInfo.live_id);
            ktc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, alaLiveInfo.cover);
            ktc.a(jSONObject, "session_id", alaLiveInfo.session_id);
            ktc.a(jSONObject, "rtmp_url", alaLiveInfo.rtmp_url);
            ktc.a(jSONObject, "hls_url", alaLiveInfo.hls_url);
            ktc.a(jSONObject, "group_id", alaLiveInfo.group_id);
            ktc.a(jSONObject, "media_url", alaLiveInfo.media_url);
            ktc.a(jSONObject, "media_pic", alaLiveInfo.media_pic);
            ktc.a(jSONObject, "media_id", alaLiveInfo.media_id);
            ktc.a(jSONObject, "media_subtitle", alaLiveInfo.media_subtitle);
            ktc.a(jSONObject, "description", alaLiveInfo.description);
            AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
            if (alaUserInfo != null) {
                ktc.a(jSONObject, SourceConstant.SOURCE_USER_INFO, luc.b(alaUserInfo));
            }
            ktc.a(jSONObject, "duration", alaLiveInfo.duration);
            ktc.a(jSONObject, "audience_count", alaLiveInfo.audience_count);
            ktc.a(jSONObject, "live_type", alaLiveInfo.live_type);
            ktc.a(jSONObject, "screen_direction", alaLiveInfo.screen_direction);
            ktc.a(jSONObject, "label_name", alaLiveInfo.label_name);
            ktc.a(jSONObject, IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaLiveInfo.live_status);
            AlaShareInfo alaShareInfo = alaLiveInfo.share_info;
            if (alaShareInfo != null) {
                ktc.a(jSONObject, "share_info", juc.b(alaShareInfo));
            }
            ktc.a(jSONObject, "distance", alaLiveInfo.distance);
            ktc.a(jSONObject, "third_app_id", alaLiveInfo.third_app_id);
            ktc.a(jSONObject, "thread_id", alaLiveInfo.thread_id);
            if (alaLiveInfo.stage_dislike_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (AlaStageDislikeInfo alaStageDislikeInfo : alaLiveInfo.stage_dislike_info) {
                    jSONArray.put(kuc.b(alaStageDislikeInfo));
                }
                ktc.a(jSONObject, "stage_dislike_info", jSONArray);
            }
            AlaCoverLabel alaCoverLabel = alaLiveInfo.label;
            if (alaCoverLabel != null) {
                ktc.a(jSONObject, "label", guc.b(alaCoverLabel));
            }
            AlaChallengeInfo alaChallengeInfo = alaLiveInfo.challenge_info;
            if (alaChallengeInfo != null) {
                ktc.a(jSONObject, "challenge_info", fuc.b(alaChallengeInfo));
            }
            ktc.a(jSONObject, "frs_toplive_type", alaLiveInfo.frs_toplive_type);
            ktc.a(jSONObject, "frs_toplive_pic", alaLiveInfo.frs_toplive_pic);
            ktc.a(jSONObject, "frs_toplive_force", alaLiveInfo.frs_toplive_force);
            ktc.a(jSONObject, "live_from", alaLiveInfo.live_from);
            ktc.a(jSONObject, "third_room_id", alaLiveInfo.third_room_id);
            ktc.a(jSONObject, "router_type", alaLiveInfo.router_type);
            ktc.a(jSONObject, "third_live_type", alaLiveInfo.third_live_type);
            ktc.a(jSONObject, "first_headline", alaLiveInfo.first_headline);
            ktc.a(jSONObject, "second_headline", alaLiveInfo.second_headline);
            ktc.a(jSONObject, "pb_display_type", alaLiveInfo.pb_display_type);
            ktc.a(jSONObject, "recom_reason", alaLiveInfo.recom_reason);
            ktc.a(jSONObject, "open_recom_reason", alaLiveInfo.open_recom_reason);
            ktc.a(jSONObject, "open_recom_location", alaLiveInfo.open_recom_location);
            ktc.a(jSONObject, "open_recom_fans", alaLiveInfo.open_recom_fans);
            ktc.a(jSONObject, "open_recom_duration", alaLiveInfo.open_recom_duration);
            if (alaLiveInfo.dislike_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (DislikeInfo dislikeInfo : alaLiveInfo.dislike_info) {
                    jSONArray2.put(nwc.b(dislikeInfo));
                }
                ktc.a(jSONObject, "dislike_info", jSONArray2);
            }
            ktc.a(jSONObject, "room_id", alaLiveInfo.room_id);
            ktc.a(jSONObject, "room_status", alaLiveInfo.room_status);
            ktc.a(jSONObject, DpStatConstants.KEY_ROOM_NAME, alaLiveInfo.room_name);
            ktc.a(jSONObject, "forum_user_live_msg", alaLiveInfo.forum_user_live_msg);
            ktc.a(jSONObject, "cover_wide", alaLiveInfo.cover_wide);
            YyExt yyExt = alaLiveInfo.yy_ext;
            if (yyExt != null) {
                ktc.a(jSONObject, "yy_ext", sbd.b(yyExt));
            }
            ktc.a(jSONObject, "show_page", alaLiveInfo.show_page);
            UniversalLabel universalLabel = alaLiveInfo.user_label;
            if (universalLabel != null) {
                ktc.a(jSONObject, "user_label", oad.b(universalLabel));
            }
            ktc.a(jSONObject, "flv", alaLiveInfo.flv);
            ktc.a(jSONObject, "page_from", alaLiveInfo.page_from);
            ktc.a(jSONObject, "scheme", alaLiveInfo.scheme);
            WidthHeight widthHeight = alaLiveInfo.player_size;
            if (widthHeight != null) {
                ktc.a(jSONObject, "player_size", mbd.b(widthHeight));
            }
            WidthHeight widthHeight2 = alaLiveInfo.container_size;
            if (widthHeight2 != null) {
                ktc.a(jSONObject, "container_size", mbd.b(widthHeight2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
