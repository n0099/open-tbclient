package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FeedForumInfo;
import tbclient.RecomTopicInfo;
/* loaded from: classes5.dex */
public class cvc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BannerList bannerList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bannerList)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (bannerList.app != null) {
                JSONArray jSONArray = new JSONArray();
                for (App app : bannerList.app) {
                    jSONArray.put(suc.b(app));
                }
                ltc.a(jSONObject, "app", jSONArray);
            }
            if (bannerList.feed_forum != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedForumInfo feedForumInfo : bannerList.feed_forum) {
                    jSONArray2.put(ixc.b(feedForumInfo));
                }
                ltc.a(jSONObject, "feed_forum", jSONArray2);
            }
            RecomTopicInfo recomTopicInfo = bannerList.hot_topic;
            if (recomTopicInfo != null) {
                ltc.a(jSONObject, "hot_topic", m7d.b(recomTopicInfo));
            }
            ltc.a(jSONObject, "applist", bannerList.applist);
            App app2 = bannerList.pb_banner_ad;
            if (app2 != null) {
                ltc.a(jSONObject, "pb_banner_ad", suc.b(app2));
            }
            if (bannerList.video_recommend_ad != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (App app3 : bannerList.video_recommend_ad) {
                    jSONArray3.put(suc.b(app3));
                }
                ltc.a(jSONObject, "video_recommend_ad", jSONArray3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
