package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.BannerList;
import tbclient.DeletedReasonInfo;
import tbclient.FrsPage.AcrossForumIcon;
import tbclient.FrsPage.Adkiller;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.Badges;
import tbclient.FrsPage.Banner;
import tbclient.FrsPage.Calendar;
import tbclient.FrsPage.Classify;
import tbclient.FrsPage.ForumButton;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.Manager;
import tbclient.FrsPage.MemberShowIcon;
import tbclient.FrsPage.PostPrefix;
import tbclient.FrsPage.PostTopic;
import tbclient.FrsPage.RealTime;
import tbclient.FrsPage.RecomUserInfo;
import tbclient.FrsPage.RecommendForum;
import tbclient.FrsPage.SignInfo;
import tbclient.FrsPage.TagInfo;
import tbclient.FrsPage.TipInfo;
import tbclient.FrsPage.TopCode;
import tbclient.FrsPage.TopNews;
import tbclient.FrsPage.TopNotice;
import tbclient.FrsPage.WorldCup;
import tbclient.FrsPage.Yule;
import tbclient.FrsPage.Zhibo;
import tbclient.GameInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class h0d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumInfo forumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", forumInfo.id);
            ktc.a(jSONObject, "name", forumInfo.name);
            ktc.a(jSONObject, "first_class", forumInfo.first_class);
            ktc.a(jSONObject, "second_class", forumInfo.second_class);
            ktc.a(jSONObject, "is_exists", forumInfo.is_exists);
            ktc.a(jSONObject, "is_like", forumInfo.is_like);
            ktc.a(jSONObject, IntentConfig.USER_LEVEL, forumInfo.user_level);
            ktc.a(jSONObject, "level_name", forumInfo.level_name);
            ktc.a(jSONObject, "member_num", forumInfo.member_num);
            ktc.a(jSONObject, "thread_num", forumInfo.thread_num);
            ktc.a(jSONObject, "post_num", forumInfo.post_num);
            ktc.a(jSONObject, "has_frs_star", forumInfo.has_frs_star);
            ktc.a(jSONObject, "cur_score", forumInfo.cur_score);
            ktc.a(jSONObject, "levelup_score", forumInfo.levelup_score);
            SignInfo signInfo = forumInfo.sign_in_info;
            if (signInfo != null) {
                ktc.a(jSONObject, "sign_in_info", z1d.b(signInfo));
            }
            Zhibo zhibo = forumInfo.zhibo;
            if (zhibo != null) {
                ktc.a(jSONObject, "zhibo", f3d.b(zhibo));
            }
            if (forumInfo.managers != null) {
                JSONArray jSONArray = new JSONArray();
                for (Manager manager : forumInfo.managers) {
                    jSONArray.put(x0d.b(manager));
                }
                ktc.a(jSONObject, "managers", jSONArray);
            }
            if (forumInfo.forum_sign_calendar != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Calendar calendar : forumInfo.forum_sign_calendar) {
                    jSONArray2.put(nzc.b(calendar));
                }
                ktc.a(jSONObject, "forum_sign_calendar", jSONArray2);
            }
            ktc.a(jSONObject, "is_search_people", forumInfo.is_search_people);
            ktc.a(jSONObject, "tids", forumInfo.tids);
            if (forumInfo.good_classify != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Classify classify : forumInfo.good_classify) {
                    jSONArray3.put(qzc.b(classify));
                }
                ktc.a(jSONObject, "good_classify", jSONArray3);
            }
            ktc.a(jSONObject, "is_readonly", forumInfo.is_readonly);
            ktc.a(jSONObject, "album_open_photo_frs", forumInfo.album_open_photo_frs);
            ktc.a(jSONObject, "avatar", forumInfo.avatar);
            ktc.a(jSONObject, "slogan", forumInfo.slogan);
            ktc.a(jSONObject, "has_postpre", forumInfo.has_postpre);
            ForumButton forumButton = forumInfo.forum_button;
            if (forumButton != null) {
                ktc.a(jSONObject, "forum_button", c0d.b(forumButton));
            }
            TopNotice topNotice = forumInfo.top_notice;
            if (topNotice != null) {
                ktc.a(jSONObject, "top_notice", r2d.b(topNotice));
            }
            ktc.a(jSONObject, "has_paper", forumInfo.has_paper);
            ktc.a(jSONObject, "is_stage_forum", forumInfo.is_stage_forum);
            ktc.a(jSONObject, "meizhi_tag", forumInfo.meizhi_tag);
            Banner banner = forumInfo.banner;
            if (banner != null) {
                ktc.a(jSONObject, "banner", fzc.b(banner));
            }
            BannerList bannerList = forumInfo.banner_list;
            if (bannerList != null) {
                ktc.a(jSONObject, "banner_list", bvc.b(bannerList));
            }
            if (forumInfo.badges != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (Badges badges : forumInfo.badges) {
                    jSONArray4.put(ezc.b(badges));
                }
                ktc.a(jSONObject, "badges", jSONArray4);
            }
            ktc.a(jSONObject, "level_id", forumInfo.level_id);
            ktc.a(jSONObject, "is_forbidden", forumInfo.is_forbidden);
            ktc.a(jSONObject, "favo_type", forumInfo.favo_type);
            TagInfo tagInfo = forumInfo.tag_info;
            if (tagInfo != null) {
                ktc.a(jSONObject, "tag_info", j2d.b(tagInfo));
            }
            PostPrefix postPrefix = forumInfo.post_prefix;
            if (postPrefix != null) {
                ktc.a(jSONObject, "post_prefix", k1d.b(postPrefix));
            }
            ktc.a(jSONObject, "superboy", forumInfo.superboy);
            ktc.a(jSONObject, "is_support_local", forumInfo.is_support_local);
            ktc.a(jSONObject, "is_local_effect", forumInfo.is_local_effect);
            if (forumInfo.recommend_forum != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (RecommendForum recommendForum : forumInfo.recommend_forum) {
                    jSONArray5.put(v1d.b(recommendForum));
                }
                ktc.a(jSONObject, "recommend_forum", jSONArray5);
            }
            AnchorPower anchorPower = forumInfo.anchor_power;
            if (anchorPower != null) {
                ktc.a(jSONObject, "anchor_power", dzc.b(anchorPower));
            }
            WorldCup worldCup = forumInfo.worldcupinfo;
            if (worldCup != null) {
                ktc.a(jSONObject, "worldcupinfo", w2d.b(worldCup));
            }
            ktc.a(jSONObject, "has_game", forumInfo.has_game);
            ktc.a(jSONObject, "game_url", forumInfo.game_url);
            RecomUserInfo recomUserInfo = forumInfo.recommend_user_info;
            if (recomUserInfo != null) {
                ktc.a(jSONObject, "recommend_user_info", t1d.b(recomUserInfo));
            }
            ktc.a(jSONObject, "can_use_accelerate", forumInfo.can_use_accelerate);
            ktc.a(jSONObject, "accelerate_cotent", forumInfo.accelerate_cotent);
            TopCode topCode = forumInfo.top_code;
            if (topCode != null) {
                ktc.a(jSONObject, "top_code", n2d.b(topCode));
            }
            TopNews topNews = forumInfo.news_info;
            if (topNews != null) {
                ktc.a(jSONObject, "news_info", q2d.b(topNews));
            }
            if (forumInfo.game_card != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (GameInfo gameInfo : forumInfo.game_card) {
                    jSONArray6.put(n3d.b(gameInfo));
                }
                ktc.a(jSONObject, "game_card", jSONArray6);
            }
            ktc.a(jSONObject, "game_name", forumInfo.game_name);
            MemberShowIcon memberShowIcon = forumInfo.forumvip_show_icon;
            if (memberShowIcon != null) {
                ktc.a(jSONObject, "forumvip_show_icon", a1d.b(memberShowIcon));
            }
            Adkiller adkiller = forumInfo.adkiller_data;
            if (adkiller != null) {
                ktc.a(jSONObject, "adkiller_data", zyc.b(adkiller));
            }
            Yule yule = forumInfo.yule;
            if (yule != null) {
                ktc.a(jSONObject, "yule", e3d.b(yule));
            }
            RealTime realTime = forumInfo.realtime_data;
            if (realTime != null) {
                ktc.a(jSONObject, "realtime_data", q1d.b(realTime));
            }
            AcrossForumIcon acrossForumIcon = forumInfo.across_forum_show;
            if (acrossForumIcon != null) {
                ktc.a(jSONObject, "across_forum_show", vyc.b(acrossForumIcon));
            }
            PostTopic postTopic = forumInfo.post_topic;
            if (postTopic != null) {
                ktc.a(jSONObject, "post_topic", l1d.b(postTopic));
            }
            AcrossForumIcon acrossForumIcon2 = forumInfo.across_forum_hide;
            if (acrossForumIcon2 != null) {
                ktc.a(jSONObject, "across_forum_hide", vyc.b(acrossForumIcon2));
            }
            ktc.a(jSONObject, "is_live_game_forum", forumInfo.is_live_game_forum);
            ktc.a(jSONObject, "is_live_game", forumInfo.is_live_game);
            ktc.a(jSONObject, "is_new_game_forum", forumInfo.is_new_game_forum);
            ktc.a(jSONObject, "forum_game_label", forumInfo.forum_game_label);
            ktc.a(jSONObject, "warning_msg", forumInfo.warning_msg);
            ktc.a(jSONObject, AlaMasterLiveRoomActivityConfig.SPECIAL_FORIM_TYPE, forumInfo.special_forum_type);
            ktc.a(jSONObject, "topic_special_icon", forumInfo.topic_special_icon);
            ktc.a(jSONObject, "topic_special_icon_right", forumInfo.topic_special_icon_right);
            ktc.a(jSONObject, "is_brand_forum", forumInfo.is_brand_forum);
            ktc.a(jSONObject, "is_show_all_top_thread", forumInfo.is_show_all_top_thread);
            ThemeColorInfo themeColorInfo = forumInfo.theme_color;
            if (themeColorInfo != null) {
                ktc.a(jSONObject, "theme_color", s9d.b(themeColorInfo));
            }
            ktc.a(jSONObject, "is_top_img", forumInfo.is_top_img);
            ktc.a(jSONObject, "is_private_forum", forumInfo.is_private_forum);
            ktc.a(jSONObject, "is_show_bawutask", forumInfo.is_show_bawutask);
            ktc.a(jSONObject, "f_share_img", forumInfo.f_share_img);
            ktc.a(jSONObject, "forum_share_link", forumInfo.forum_share_link);
            ktc.a(jSONObject, "risk_tip_pop", forumInfo.risk_tip_pop);
            ktc.a(jSONObject, "risk_tip_notice", forumInfo.risk_tip_notice);
            ktc.a(jSONObject, "risk_tip_pop_title", forumInfo.risk_tip_pop_title);
            if (forumInfo.tip_list != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (TipInfo tipInfo : forumInfo.tip_list) {
                    jSONArray7.put(m2d.b(tipInfo));
                }
                ktc.a(jSONObject, "tip_list", jSONArray7);
            }
            ktc.a(jSONObject, "is_show_forumrule", forumInfo.is_show_forumrule);
            DeletedReasonInfo deletedReasonInfo = forumInfo.deleted_reason_info;
            if (deletedReasonInfo != null) {
                ktc.a(jSONObject, "deleted_reason_info", lwc.b(deletedReasonInfo));
            }
            ktc.a(jSONObject, "is_frs_mask", forumInfo.is_frs_mask);
            ktc.a(jSONObject, "msg_bubble_guide_frequency", forumInfo.msg_bubble_guide_frequency);
            ktc.a(jSONObject, "be_top_limit_time", forumInfo.be_top_limit_time);
            ktc.a(jSONObject, "msg_bubble_guide_frequency_unread", forumInfo.msg_bubble_guide_frequency_unread);
            ktc.a(jSONObject, "msg_bubble_guide_frequency_special", forumInfo.msg_bubble_guide_frequency_special);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
