package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AbstractComponent;
import tbclient.ComponentFactory;
import tbclient.FeedAuthorSocial;
import tbclient.FeedEntrybarComponent;
import tbclient.FeedHeadComponent;
import tbclient.FeedHeadFigureComponent;
import tbclient.FeedItem;
import tbclient.FeedLinkComponent;
import tbclient.FeedLiveComponent;
import tbclient.FeedOriginComponent;
import tbclient.FeedPicComponent;
import tbclient.FeedPostExpose;
import tbclient.FeedRoomComponent;
import tbclient.FeedSocialComponent;
import tbclient.FeedToutiao;
import tbclient.FeedVideoAdComponent;
import tbclient.FeedVideoComponent;
import tbclient.FrsTopThreadComponent;
import tbclient.PollInfo;
import tbclient.SidewayRecomComponent;
import tbclient.ThreadRecommendInfo;
import tbclient.TitleComponent;
import tbclient.Voice;
/* loaded from: classes5.dex */
public class cwc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ComponentFactory componentFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, componentFactory)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "component", componentFactory.component);
            TitleComponent titleComponent = componentFactory.feed_title;
            if (titleComponent != null) {
                ltc.a(jSONObject, "feed_title", gad.b(titleComponent));
            }
            AbstractComponent abstractComponent = componentFactory.feed_abstract;
            if (abstractComponent != null) {
                ltc.a(jSONObject, "feed_abstract", ntc.b(abstractComponent));
            }
            FeedHeadComponent feedHeadComponent = componentFactory.feed_head;
            if (feedHeadComponent != null) {
                ltc.a(jSONObject, "feed_head", kxc.b(feedHeadComponent));
            }
            FeedHeadFigureComponent feedHeadFigureComponent = componentFactory.feed_head_figure;
            if (feedHeadFigureComponent != null) {
                ltc.a(jSONObject, "feed_head_figure", lxc.b(feedHeadFigureComponent));
            }
            FeedPicComponent feedPicComponent = componentFactory.feed_pic;
            if (feedPicComponent != null) {
                ltc.a(jSONObject, "feed_pic", ayc.b(feedPicComponent));
            }
            FeedSocialComponent feedSocialComponent = componentFactory.feed_social;
            if (feedSocialComponent != null) {
                ltc.a(jSONObject, "feed_social", dyc.b(feedSocialComponent));
            }
            FeedVideoComponent feedVideoComponent = componentFactory.feed_video;
            if (feedVideoComponent != null) {
                ltc.a(jSONObject, "feed_video", gyc.b(feedVideoComponent));
            }
            FeedEntrybarComponent feedEntrybarComponent = componentFactory.feed_entrybar;
            if (feedEntrybarComponent != null) {
                ltc.a(jSONObject, "feed_entrybar", gxc.b(feedEntrybarComponent));
            }
            Voice voice = componentFactory.feed_voice;
            if (voice != null) {
                ltc.a(jSONObject, "feed_voice", jbd.b(voice));
            }
            FeedLiveComponent feedLiveComponent = componentFactory.feed_live;
            if (feedLiveComponent != null) {
                ltc.a(jSONObject, "feed_live", vxc.b(feedLiveComponent));
            }
            ltc.a(jSONObject, "base_text", componentFactory.base_text);
            SidewayRecomComponent sidewayRecomComponent = componentFactory.sideway_recom;
            if (sidewayRecomComponent != null) {
                ltc.a(jSONObject, "sideway_recom", f8d.b(sidewayRecomComponent));
            }
            FeedItem feedItem = componentFactory.feed_item;
            if (feedItem != null) {
                ltc.a(jSONObject, "feed_item", rxc.b(feedItem));
            }
            FeedOriginComponent feedOriginComponent = componentFactory.feed_origin;
            if (feedOriginComponent != null) {
                ltc.a(jSONObject, "feed_origin", xxc.b(feedOriginComponent));
            }
            FeedLinkComponent feedLinkComponent = componentFactory.feed_link;
            if (feedLinkComponent != null) {
                ltc.a(jSONObject, "feed_link", uxc.b(feedLinkComponent));
            }
            if (componentFactory.feed_recomtag != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadRecommendInfo threadRecommendInfo : componentFactory.feed_recomtag) {
                    jSONArray.put(aad.b(threadRecommendInfo));
                }
                ltc.a(jSONObject, "feed_recomtag", jSONArray);
            }
            FeedVideoAdComponent feedVideoAdComponent = componentFactory.feed_videoad;
            if (feedVideoAdComponent != null) {
                ltc.a(jSONObject, "feed_videoad", fyc.b(feedVideoAdComponent));
            }
            FeedPostExpose feedPostExpose = componentFactory.feed_postexpose;
            if (feedPostExpose != null) {
                ltc.a(jSONObject, "feed_postexpose", byc.b(feedPostExpose));
            }
            FeedRoomComponent feedRoomComponent = componentFactory.feed_room;
            if (feedRoomComponent != null) {
                ltc.a(jSONObject, "feed_room", cyc.b(feedRoomComponent));
            }
            PollInfo pollInfo = componentFactory.feed_poll;
            if (pollInfo != null) {
                ltc.a(jSONObject, "feed_poll", n6d.b(pollInfo));
            }
            FeedToutiao feedToutiao = componentFactory.feed_toutiao;
            if (feedToutiao != null) {
                ltc.a(jSONObject, "feed_toutiao", eyc.b(feedToutiao));
            }
            FrsTopThreadComponent frsTopThreadComponent = componentFactory.frs_top_thread;
            if (frsTopThreadComponent != null) {
                ltc.a(jSONObject, "frs_top_thread", k3d.b(frsTopThreadComponent));
            }
            FeedAuthorSocial feedAuthorSocial = componentFactory.feed_author_social;
            if (feedAuthorSocial != null) {
                ltc.a(jSONObject, "feed_author_social", zwc.b(feedAuthorSocial));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
