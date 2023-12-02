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
public class bwc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ComponentFactory componentFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, componentFactory)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "component", componentFactory.component);
            TitleComponent titleComponent = componentFactory.feed_title;
            if (titleComponent != null) {
                ktc.a(jSONObject, "feed_title", fad.b(titleComponent));
            }
            AbstractComponent abstractComponent = componentFactory.feed_abstract;
            if (abstractComponent != null) {
                ktc.a(jSONObject, "feed_abstract", mtc.b(abstractComponent));
            }
            FeedHeadComponent feedHeadComponent = componentFactory.feed_head;
            if (feedHeadComponent != null) {
                ktc.a(jSONObject, "feed_head", jxc.b(feedHeadComponent));
            }
            FeedHeadFigureComponent feedHeadFigureComponent = componentFactory.feed_head_figure;
            if (feedHeadFigureComponent != null) {
                ktc.a(jSONObject, "feed_head_figure", kxc.b(feedHeadFigureComponent));
            }
            FeedPicComponent feedPicComponent = componentFactory.feed_pic;
            if (feedPicComponent != null) {
                ktc.a(jSONObject, "feed_pic", zxc.b(feedPicComponent));
            }
            FeedSocialComponent feedSocialComponent = componentFactory.feed_social;
            if (feedSocialComponent != null) {
                ktc.a(jSONObject, "feed_social", cyc.b(feedSocialComponent));
            }
            FeedVideoComponent feedVideoComponent = componentFactory.feed_video;
            if (feedVideoComponent != null) {
                ktc.a(jSONObject, "feed_video", fyc.b(feedVideoComponent));
            }
            FeedEntrybarComponent feedEntrybarComponent = componentFactory.feed_entrybar;
            if (feedEntrybarComponent != null) {
                ktc.a(jSONObject, "feed_entrybar", fxc.b(feedEntrybarComponent));
            }
            Voice voice = componentFactory.feed_voice;
            if (voice != null) {
                ktc.a(jSONObject, "feed_voice", ibd.b(voice));
            }
            FeedLiveComponent feedLiveComponent = componentFactory.feed_live;
            if (feedLiveComponent != null) {
                ktc.a(jSONObject, "feed_live", uxc.b(feedLiveComponent));
            }
            ktc.a(jSONObject, "base_text", componentFactory.base_text);
            SidewayRecomComponent sidewayRecomComponent = componentFactory.sideway_recom;
            if (sidewayRecomComponent != null) {
                ktc.a(jSONObject, "sideway_recom", e8d.b(sidewayRecomComponent));
            }
            FeedItem feedItem = componentFactory.feed_item;
            if (feedItem != null) {
                ktc.a(jSONObject, "feed_item", qxc.b(feedItem));
            }
            FeedOriginComponent feedOriginComponent = componentFactory.feed_origin;
            if (feedOriginComponent != null) {
                ktc.a(jSONObject, "feed_origin", wxc.b(feedOriginComponent));
            }
            FeedLinkComponent feedLinkComponent = componentFactory.feed_link;
            if (feedLinkComponent != null) {
                ktc.a(jSONObject, "feed_link", txc.b(feedLinkComponent));
            }
            if (componentFactory.feed_recomtag != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadRecommendInfo threadRecommendInfo : componentFactory.feed_recomtag) {
                    jSONArray.put(z9d.b(threadRecommendInfo));
                }
                ktc.a(jSONObject, "feed_recomtag", jSONArray);
            }
            FeedVideoAdComponent feedVideoAdComponent = componentFactory.feed_videoad;
            if (feedVideoAdComponent != null) {
                ktc.a(jSONObject, "feed_videoad", eyc.b(feedVideoAdComponent));
            }
            FeedPostExpose feedPostExpose = componentFactory.feed_postexpose;
            if (feedPostExpose != null) {
                ktc.a(jSONObject, "feed_postexpose", ayc.b(feedPostExpose));
            }
            FeedRoomComponent feedRoomComponent = componentFactory.feed_room;
            if (feedRoomComponent != null) {
                ktc.a(jSONObject, "feed_room", byc.b(feedRoomComponent));
            }
            PollInfo pollInfo = componentFactory.feed_poll;
            if (pollInfo != null) {
                ktc.a(jSONObject, "feed_poll", m6d.b(pollInfo));
            }
            FeedToutiao feedToutiao = componentFactory.feed_toutiao;
            if (feedToutiao != null) {
                ktc.a(jSONObject, "feed_toutiao", dyc.b(feedToutiao));
            }
            FrsTopThreadComponent frsTopThreadComponent = componentFactory.frs_top_thread;
            if (frsTopThreadComponent != null) {
                ktc.a(jSONObject, "frs_top_thread", j3d.b(frsTopThreadComponent));
            }
            FeedAuthorSocial feedAuthorSocial = componentFactory.feed_author_social;
            if (feedAuthorSocial != null) {
                ktc.a(jSONObject, "feed_author_social", ywc.b(feedAuthorSocial));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
