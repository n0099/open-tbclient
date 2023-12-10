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
public class i0d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumInfo forumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", forumInfo.id);
            ltc.a(jSONObject, "name", forumInfo.name);
            ltc.a(jSONObject, "first_class", forumInfo.first_class);
            ltc.a(jSONObject, "second_class", forumInfo.second_class);
            ltc.a(jSONObject, "is_exists", forumInfo.is_exists);
            ltc.a(jSONObject, "is_like", forumInfo.is_like);
            ltc.a(jSONObject, IntentConfig.USER_LEVEL, forumInfo.user_level);
            ltc.a(jSONObject, "level_name", forumInfo.level_name);
            ltc.a(jSONObject, "member_num", forumInfo.member_num);
            ltc.a(jSONObject, "thread_num", forumInfo.thread_num);
            ltc.a(jSONObject, "post_num", forumInfo.post_num);
            ltc.a(jSONObject, "has_frs_star", forumInfo.has_frs_star);
            ltc.a(jSONObject, "cur_score", forumInfo.cur_score);
            ltc.a(jSONObject, "levelup_score", forumInfo.levelup_score);
            SignInfo signInfo = forumInfo.sign_in_info;
            if (signInfo != null) {
                ltc.a(jSONObject, "sign_in_info", a2d.b(signInfo));
            }
            Zhibo zhibo = forumInfo.zhibo;
            if (zhibo != null) {
                ltc.a(jSONObject, "zhibo", g3d.b(zhibo));
            }
            if (forumInfo.managers != null) {
                JSONArray jSONArray = new JSONArray();
                for (Manager manager : forumInfo.managers) {
                    jSONArray.put(y0d.b(manager));
                }
                ltc.a(jSONObject, "managers", jSONArray);
            }
            if (forumInfo.forum_sign_calendar != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Calendar calendar : forumInfo.forum_sign_calendar) {
                    jSONArray2.put(ozc.b(calendar));
                }
                ltc.a(jSONObject, "forum_sign_calendar", jSONArray2);
            }
            ltc.a(jSONObject, "is_search_people", forumInfo.is_search_people);
            ltc.a(jSONObject, "tids", forumInfo.tids);
            if (forumInfo.good_classify != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Classify classify : forumInfo.good_classify) {
                    jSONArray3.put(rzc.b(classify));
                }
                ltc.a(jSONObject, "good_classify", jSONArray3);
            }
            ltc.a(jSONObject, "is_readonly", forumInfo.is_readonly);
            ltc.a(jSONObject, "album_open_photo_frs", forumInfo.album_open_photo_frs);
            ltc.a(jSONObject, "avatar", forumInfo.avatar);
            ltc.a(jSONObject, "slogan", forumInfo.slogan);
            ltc.a(jSONObject, "has_postpre", forumInfo.has_postpre);
            ForumButton forumButton = forumInfo.forum_button;
            if (forumButton != null) {
                ltc.a(jSONObject, "forum_button", d0d.b(forumButton));
            }
            TopNotice topNotice = forumInfo.top_notice;
            if (topNotice != null) {
                ltc.a(jSONObject, "top_notice", s2d.b(topNotice));
            }
            ltc.a(jSONObject, "has_paper", forumInfo.has_paper);
            ltc.a(jSONObject, "is_stage_forum", forumInfo.is_stage_forum);
            ltc.a(jSONObject, "meizhi_tag", forumInfo.meizhi_tag);
            Banner banner = forumInfo.banner;
            if (banner != null) {
                ltc.a(jSONObject, "banner", gzc.b(banner));
            }
            BannerList bannerList = forumInfo.banner_list;
            if (bannerList != null) {
                ltc.a(jSONObject, "banner_list", cvc.b(bannerList));
            }
            if (forumInfo.badges != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (Badges badges : forumInfo.badges) {
                    jSONArray4.put(fzc.b(badges));
                }
                ltc.a(jSONObject, "badges", jSONArray4);
            }
            ltc.a(jSONObject, "level_id", forumInfo.level_id);
            ltc.a(jSONObject, "is_forbidden", forumInfo.is_forbidden);
            ltc.a(jSONObject, "favo_type", forumInfo.favo_type);
            TagInfo tagInfo = forumInfo.tag_info;
            if (tagInfo != null) {
                ltc.a(jSONObject, "tag_info", k2d.b(tagInfo));
            }
            PostPrefix postPrefix = forumInfo.post_prefix;
            if (postPrefix != null) {
                ltc.a(jSONObject, "post_prefix", l1d.b(postPrefix));
            }
            ltc.a(jSONObject, "superboy", forumInfo.superboy);
            ltc.a(jSONObject, "is_support_local", forumInfo.is_support_local);
            ltc.a(jSONObject, "is_local_effect", forumInfo.is_local_effect);
            if (forumInfo.recommend_forum != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (RecommendForum recommendForum : forumInfo.recommend_forum) {
                    jSONArray5.put(w1d.b(recommendForum));
                }
                ltc.a(jSONObject, "recommend_forum", jSONArray5);
            }
            AnchorPower anchorPower = forumInfo.anchor_power;
            if (anchorPower != null) {
                ltc.a(jSONObject, "anchor_power", ezc.b(anchorPower));
            }
            WorldCup worldCup = forumInfo.worldcupinfo;
            if (worldCup != null) {
                ltc.a(jSONObject, "worldcupinfo", x2d.b(worldCup));
            }
            ltc.a(jSONObject, "has_game", forumInfo.has_game);
            ltc.a(jSONObject, "game_url", forumInfo.game_url);
            RecomUserInfo recomUserInfo = forumInfo.recommend_user_info;
            if (recomUserInfo != null) {
                ltc.a(jSONObject, "recommend_user_info", u1d.b(recomUserInfo));
            }
            ltc.a(jSONObject, "can_use_accelerate", forumInfo.can_use_accelerate);
            ltc.a(jSONObject, "accelerate_cotent", forumInfo.accelerate_cotent);
            TopCode topCode = forumInfo.top_code;
            if (topCode != null) {
                ltc.a(jSONObject, "top_code", o2d.b(topCode));
            }
            TopNews topNews = forumInfo.news_info;
            if (topNews != null) {
                ltc.a(jSONObject, "news_info", r2d.b(topNews));
            }
            if (forumInfo.game_card != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (GameInfo gameInfo : forumInfo.game_card) {
                    jSONArray6.put(o3d.b(gameInfo));
                }
                ltc.a(jSONObject, "game_card", jSONArray6);
            }
            ltc.a(jSONObject, "game_name", forumInfo.game_name);
            MemberShowIcon memberShowIcon = forumInfo.forumvip_show_icon;
            if (memberShowIcon != null) {
                ltc.a(jSONObject, "forumvip_show_icon", b1d.b(memberShowIcon));
            }
            Adkiller adkiller = forumInfo.adkiller_data;
            if (adkiller != null) {
                ltc.a(jSONObject, "adkiller_data", azc.b(adkiller));
            }
            Yule yule = forumInfo.yule;
            if (yule != null) {
                ltc.a(jSONObject, "yule", f3d.b(yule));
            }
            RealTime realTime = forumInfo.realtime_data;
            if (realTime != null) {
                ltc.a(jSONObject, "realtime_data", r1d.b(realTime));
            }
            AcrossForumIcon acrossForumIcon = forumInfo.across_forum_show;
            if (acrossForumIcon != null) {
                ltc.a(jSONObject, "across_forum_show", wyc.b(acrossForumIcon));
            }
            PostTopic postTopic = forumInfo.post_topic;
            if (postTopic != null) {
                ltc.a(jSONObject, "post_topic", m1d.b(postTopic));
            }
            AcrossForumIcon acrossForumIcon2 = forumInfo.across_forum_hide;
            if (acrossForumIcon2 != null) {
                ltc.a(jSONObject, "across_forum_hide", wyc.b(acrossForumIcon2));
            }
            ltc.a(jSONObject, "is_live_game_forum", forumInfo.is_live_game_forum);
            ltc.a(jSONObject, "is_live_game", forumInfo.is_live_game);
            ltc.a(jSONObject, "is_new_game_forum", forumInfo.is_new_game_forum);
            ltc.a(jSONObject, "forum_game_label", forumInfo.forum_game_label);
            ltc.a(jSONObject, "warning_msg", forumInfo.warning_msg);
            ltc.a(jSONObject, AlaMasterLiveRoomActivityConfig.SPECIAL_FORIM_TYPE, forumInfo.special_forum_type);
            ltc.a(jSONObject, "topic_special_icon", forumInfo.topic_special_icon);
            ltc.a(jSONObject, "topic_special_icon_right", forumInfo.topic_special_icon_right);
            ltc.a(jSONObject, "is_brand_forum", forumInfo.is_brand_forum);
            ltc.a(jSONObject, "is_show_all_top_thread", forumInfo.is_show_all_top_thread);
            ThemeColorInfo themeColorInfo = forumInfo.theme_color;
            if (themeColorInfo != null) {
                ltc.a(jSONObject, "theme_color", t9d.b(themeColorInfo));
            }
            ltc.a(jSONObject, "is_top_img", forumInfo.is_top_img);
            ltc.a(jSONObject, "is_private_forum", forumInfo.is_private_forum);
            ltc.a(jSONObject, "is_show_bawutask", forumInfo.is_show_bawutask);
            ltc.a(jSONObject, "f_share_img", forumInfo.f_share_img);
            ltc.a(jSONObject, "forum_share_link", forumInfo.forum_share_link);
            ltc.a(jSONObject, "risk_tip_pop", forumInfo.risk_tip_pop);
            ltc.a(jSONObject, "risk_tip_notice", forumInfo.risk_tip_notice);
            ltc.a(jSONObject, "risk_tip_pop_title", forumInfo.risk_tip_pop_title);
            if (forumInfo.tip_list != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (TipInfo tipInfo : forumInfo.tip_list) {
                    jSONArray7.put(n2d.b(tipInfo));
                }
                ltc.a(jSONObject, "tip_list", jSONArray7);
            }
            ltc.a(jSONObject, "is_show_forumrule", forumInfo.is_show_forumrule);
            DeletedReasonInfo deletedReasonInfo = forumInfo.deleted_reason_info;
            if (deletedReasonInfo != null) {
                ltc.a(jSONObject, "deleted_reason_info", mwc.b(deletedReasonInfo));
            }
            ltc.a(jSONObject, "is_frs_mask", forumInfo.is_frs_mask);
            ltc.a(jSONObject, "msg_bubble_guide_frequency", forumInfo.msg_bubble_guide_frequency);
            ltc.a(jSONObject, "be_top_limit_time", forumInfo.be_top_limit_time);
            ltc.a(jSONObject, "msg_bubble_guide_frequency_unread", forumInfo.msg_bubble_guide_frequency_unread);
            ltc.a(jSONObject, "msg_bubble_guide_frequency_special", forumInfo.msg_bubble_guide_frequency_special);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
