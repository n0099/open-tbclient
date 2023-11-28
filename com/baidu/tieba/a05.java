package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PeiwanInfo;
import tbclient.ThreadRecommendTag;
import tbclient.Voice;
@JvmName(name = "PeiWanCardBuilder")
/* loaded from: classes5.dex */
public final class a05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final PeiwanInfo a(JSONObject jsonObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jsonObject)) == null) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            PeiwanInfo.Builder builder = new PeiwanInfo.Builder();
            builder.cover = jsonObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            builder.scheme = jsonObject.optString("scheme");
            builder.extension_info = jsonObject.optString("extension_info");
            builder.room_status = Integer.valueOf(jsonObject.optInt("room_status"));
            builder.room_status_text = jsonObject.optString("room_status_text");
            JSONObject optJSONObject = jsonObject.optJSONObject("voice");
            Voice.Builder builder2 = new Voice.Builder();
            builder2.voice_md5 = optJSONObject.optString("voice_md5");
            builder2.voice_url = optJSONObject.optString("voice_url");
            builder2.type = Integer.valueOf(optJSONObject.optInt("type"));
            builder2.during_time = Integer.valueOf(optJSONObject.optInt("during_time"));
            builder.voice = builder2.build(true);
            JSONArray optJSONArray = jsonObject.optJSONArray(PushConstants.SUB_TAGS_STATUS_LIST);
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    ThreadRecommendTag.Builder builder3 = new ThreadRecommendTag.Builder();
                    builder3.text = optJSONObject2.optString("text");
                    builder3.text_color = z5b.j(optJSONObject2.optJSONObject(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR));
                    builder3.background_color = z5b.j(optJSONObject2.optJSONObject("background_color"));
                    builder3.boundary_color = z5b.j(optJSONObject2.optJSONObject("boundary_color"));
                    ThreadRecommendTag build = builder3.build(true);
                    Intrinsics.checkNotNullExpressionValue(build, "tagBuilder.build(true)");
                    arrayList.add(build);
                }
                builder.tag_list = arrayList;
            }
            return builder.build(true);
        }
        return (PeiwanInfo) invokeL.objValue;
    }
}
