package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AbstractComponent;
import tbclient.ComponentFactory;
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
public class erc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ComponentFactory componentFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, componentFactory)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "component", componentFactory.component);
            TitleComponent titleComponent = componentFactory.feed_title;
            if (titleComponent != null) {
                qoc.a(jSONObject, "feed_title", d5d.b(titleComponent));
            }
            AbstractComponent abstractComponent = componentFactory.feed_abstract;
            if (abstractComponent != null) {
                qoc.a(jSONObject, "feed_abstract", soc.b(abstractComponent));
            }
            FeedHeadComponent feedHeadComponent = componentFactory.feed_head;
            if (feedHeadComponent != null) {
                qoc.a(jSONObject, "feed_head", msc.b(feedHeadComponent));
            }
            FeedHeadFigureComponent feedHeadFigureComponent = componentFactory.feed_head_figure;
            if (feedHeadFigureComponent != null) {
                qoc.a(jSONObject, "feed_head_figure", nsc.b(feedHeadFigureComponent));
            }
            FeedPicComponent feedPicComponent = componentFactory.feed_pic;
            if (feedPicComponent != null) {
                qoc.a(jSONObject, "feed_pic", ctc.b(feedPicComponent));
            }
            FeedSocialComponent feedSocialComponent = componentFactory.feed_social;
            if (feedSocialComponent != null) {
                qoc.a(jSONObject, "feed_social", ftc.b(feedSocialComponent));
            }
            FeedVideoComponent feedVideoComponent = componentFactory.feed_video;
            if (feedVideoComponent != null) {
                qoc.a(jSONObject, "feed_video", itc.b(feedVideoComponent));
            }
            FeedEntrybarComponent feedEntrybarComponent = componentFactory.feed_entrybar;
            if (feedEntrybarComponent != null) {
                qoc.a(jSONObject, "feed_entrybar", isc.b(feedEntrybarComponent));
            }
            Voice voice = componentFactory.feed_voice;
            if (voice != null) {
                qoc.a(jSONObject, "feed_voice", f6d.b(voice));
            }
            FeedLiveComponent feedLiveComponent = componentFactory.feed_live;
            if (feedLiveComponent != null) {
                qoc.a(jSONObject, "feed_live", xsc.b(feedLiveComponent));
            }
            qoc.a(jSONObject, "base_text", componentFactory.base_text);
            SidewayRecomComponent sidewayRecomComponent = componentFactory.sideway_recom;
            if (sidewayRecomComponent != null) {
                qoc.a(jSONObject, "sideway_recom", c3d.b(sidewayRecomComponent));
            }
            FeedItem feedItem = componentFactory.feed_item;
            if (feedItem != null) {
                qoc.a(jSONObject, "feed_item", tsc.b(feedItem));
            }
            FeedOriginComponent feedOriginComponent = componentFactory.feed_origin;
            if (feedOriginComponent != null) {
                qoc.a(jSONObject, "feed_origin", zsc.b(feedOriginComponent));
            }
            FeedLinkComponent feedLinkComponent = componentFactory.feed_link;
            if (feedLinkComponent != null) {
                qoc.a(jSONObject, "feed_link", wsc.b(feedLinkComponent));
            }
            if (componentFactory.feed_recomtag != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadRecommendInfo threadRecommendInfo : componentFactory.feed_recomtag) {
                    jSONArray.put(x4d.b(threadRecommendInfo));
                }
                qoc.a(jSONObject, "feed_recomtag", jSONArray);
            }
            FeedVideoAdComponent feedVideoAdComponent = componentFactory.feed_videoad;
            if (feedVideoAdComponent != null) {
                qoc.a(jSONObject, "feed_videoad", htc.b(feedVideoAdComponent));
            }
            FeedPostExpose feedPostExpose = componentFactory.feed_postexpose;
            if (feedPostExpose != null) {
                qoc.a(jSONObject, "feed_postexpose", dtc.b(feedPostExpose));
            }
            FeedRoomComponent feedRoomComponent = componentFactory.feed_room;
            if (feedRoomComponent != null) {
                qoc.a(jSONObject, "feed_room", etc.b(feedRoomComponent));
            }
            PollInfo pollInfo = componentFactory.feed_poll;
            if (pollInfo != null) {
                qoc.a(jSONObject, "feed_poll", k1d.b(pollInfo));
            }
            FeedToutiao feedToutiao = componentFactory.feed_toutiao;
            if (feedToutiao != null) {
                qoc.a(jSONObject, "feed_toutiao", gtc.b(feedToutiao));
            }
            FrsTopThreadComponent frsTopThreadComponent = componentFactory.frs_top_thread;
            if (frsTopThreadComponent != null) {
                qoc.a(jSONObject, "frs_top_thread", hyc.b(frsTopThreadComponent));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
