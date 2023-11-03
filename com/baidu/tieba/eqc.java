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
public class eqc extends poc {
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
                    jSONArray.put(upc.b(app));
                }
                poc.a(jSONObject, "app", jSONArray);
            }
            if (bannerList.feed_forum != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedForumInfo feedForumInfo : bannerList.feed_forum) {
                    jSONArray2.put(jsc.b(feedForumInfo));
                }
                poc.a(jSONObject, "feed_forum", jSONArray2);
            }
            RecomTopicInfo recomTopicInfo = bannerList.hot_topic;
            if (recomTopicInfo != null) {
                poc.a(jSONObject, "hot_topic", i2d.b(recomTopicInfo));
            }
            poc.a(jSONObject, "applist", bannerList.applist);
            App app2 = bannerList.pb_banner_ad;
            if (app2 != null) {
                poc.a(jSONObject, "pb_banner_ad", upc.b(app2));
            }
            if (bannerList.video_recommend_ad != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (App app3 : bannerList.video_recommend_ad) {
                    jSONArray3.put(upc.b(app3));
                }
                poc.a(jSONObject, "video_recommend_ad", jSONArray3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
