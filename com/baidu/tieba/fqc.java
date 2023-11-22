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
/* loaded from: classes6.dex */
public class fqc extends qoc {
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
                    jSONArray.put(vpc.b(app));
                }
                qoc.a(jSONObject, "app", jSONArray);
            }
            if (bannerList.feed_forum != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedForumInfo feedForumInfo : bannerList.feed_forum) {
                    jSONArray2.put(ksc.b(feedForumInfo));
                }
                qoc.a(jSONObject, "feed_forum", jSONArray2);
            }
            RecomTopicInfo recomTopicInfo = bannerList.hot_topic;
            if (recomTopicInfo != null) {
                qoc.a(jSONObject, "hot_topic", j2d.b(recomTopicInfo));
            }
            qoc.a(jSONObject, "applist", bannerList.applist);
            App app2 = bannerList.pb_banner_ad;
            if (app2 != null) {
                qoc.a(jSONObject, "pb_banner_ad", vpc.b(app2));
            }
            if (bannerList.video_recommend_ad != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (App app3 : bannerList.video_recommend_ad) {
                    jSONArray3.put(vpc.b(app3));
                }
                qoc.a(jSONObject, "video_recommend_ad", jSONArray3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
