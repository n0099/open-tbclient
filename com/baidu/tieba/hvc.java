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
public class hvc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumInfo forumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", forumInfo.id);
            poc.a(jSONObject, "name", forumInfo.name);
            poc.a(jSONObject, "first_class", forumInfo.first_class);
            poc.a(jSONObject, "second_class", forumInfo.second_class);
            poc.a(jSONObject, "is_exists", forumInfo.is_exists);
            poc.a(jSONObject, "is_like", forumInfo.is_like);
            poc.a(jSONObject, IntentConfig.USER_LEVEL, forumInfo.user_level);
            poc.a(jSONObject, "level_name", forumInfo.level_name);
            poc.a(jSONObject, "member_num", forumInfo.member_num);
            poc.a(jSONObject, "thread_num", forumInfo.thread_num);
            poc.a(jSONObject, "post_num", forumInfo.post_num);
            poc.a(jSONObject, "has_frs_star", forumInfo.has_frs_star);
            poc.a(jSONObject, "cur_score", forumInfo.cur_score);
            poc.a(jSONObject, "levelup_score", forumInfo.levelup_score);
            SignInfo signInfo = forumInfo.sign_in_info;
            if (signInfo != null) {
                poc.a(jSONObject, "sign_in_info", ywc.b(signInfo));
            }
            Zhibo zhibo = forumInfo.zhibo;
            if (zhibo != null) {
                poc.a(jSONObject, "zhibo", cyc.b(zhibo));
            }
            if (forumInfo.managers != null) {
                JSONArray jSONArray = new JSONArray();
                for (Manager manager : forumInfo.managers) {
                    jSONArray.put(wvc.b(manager));
                }
                poc.a(jSONObject, "managers", jSONArray);
            }
            if (forumInfo.forum_sign_calendar != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Calendar calendar : forumInfo.forum_sign_calendar) {
                    jSONArray2.put(nuc.b(calendar));
                }
                poc.a(jSONObject, "forum_sign_calendar", jSONArray2);
            }
            poc.a(jSONObject, "is_search_people", forumInfo.is_search_people);
            poc.a(jSONObject, "tids", forumInfo.tids);
            if (forumInfo.good_classify != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Classify classify : forumInfo.good_classify) {
                    jSONArray3.put(quc.b(classify));
                }
                poc.a(jSONObject, "good_classify", jSONArray3);
            }
            poc.a(jSONObject, "is_readonly", forumInfo.is_readonly);
            poc.a(jSONObject, "album_open_photo_frs", forumInfo.album_open_photo_frs);
            poc.a(jSONObject, "avatar", forumInfo.avatar);
            poc.a(jSONObject, "slogan", forumInfo.slogan);
            poc.a(jSONObject, "has_postpre", forumInfo.has_postpre);
            ForumButton forumButton = forumInfo.forum_button;
            if (forumButton != null) {
                poc.a(jSONObject, "forum_button", cvc.b(forumButton));
            }
            TopNotice topNotice = forumInfo.top_notice;
            if (topNotice != null) {
                poc.a(jSONObject, "top_notice", oxc.b(topNotice));
            }
            poc.a(jSONObject, "has_paper", forumInfo.has_paper);
            poc.a(jSONObject, "is_stage_forum", forumInfo.is_stage_forum);
            poc.a(jSONObject, "meizhi_tag", forumInfo.meizhi_tag);
            Banner banner = forumInfo.banner;
            if (banner != null) {
                poc.a(jSONObject, "banner", guc.b(banner));
            }
            BannerList bannerList = forumInfo.banner_list;
            if (bannerList != null) {
                poc.a(jSONObject, "banner_list", eqc.b(bannerList));
            }
            if (forumInfo.badges != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (Badges badges : forumInfo.badges) {
                    jSONArray4.put(fuc.b(badges));
                }
                poc.a(jSONObject, "badges", jSONArray4);
            }
            poc.a(jSONObject, "level_id", forumInfo.level_id);
            poc.a(jSONObject, "is_forbidden", forumInfo.is_forbidden);
            poc.a(jSONObject, "favo_type", forumInfo.favo_type);
            TagInfo tagInfo = forumInfo.tag_info;
            if (tagInfo != null) {
                poc.a(jSONObject, "tag_info", ixc.b(tagInfo));
            }
            PostPrefix postPrefix = forumInfo.post_prefix;
            if (postPrefix != null) {
                poc.a(jSONObject, "post_prefix", jwc.b(postPrefix));
            }
            poc.a(jSONObject, "superboy", forumInfo.superboy);
            poc.a(jSONObject, "is_support_local", forumInfo.is_support_local);
            poc.a(jSONObject, "is_local_effect", forumInfo.is_local_effect);
            if (forumInfo.recommend_forum != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (RecommendForum recommendForum : forumInfo.recommend_forum) {
                    jSONArray5.put(uwc.b(recommendForum));
                }
                poc.a(jSONObject, "recommend_forum", jSONArray5);
            }
            AnchorPower anchorPower = forumInfo.anchor_power;
            if (anchorPower != null) {
                poc.a(jSONObject, "anchor_power", euc.b(anchorPower));
            }
            WorldCup worldCup = forumInfo.worldcupinfo;
            if (worldCup != null) {
                poc.a(jSONObject, "worldcupinfo", txc.b(worldCup));
            }
            poc.a(jSONObject, "has_game", forumInfo.has_game);
            poc.a(jSONObject, "game_url", forumInfo.game_url);
            RecomUserInfo recomUserInfo = forumInfo.recommend_user_info;
            if (recomUserInfo != null) {
                poc.a(jSONObject, "recommend_user_info", swc.b(recomUserInfo));
            }
            poc.a(jSONObject, "can_use_accelerate", forumInfo.can_use_accelerate);
            poc.a(jSONObject, "accelerate_cotent", forumInfo.accelerate_cotent);
            TopCode topCode = forumInfo.top_code;
            if (topCode != null) {
                poc.a(jSONObject, "top_code", mxc.b(topCode));
            }
            TopNews topNews = forumInfo.news_info;
            if (topNews != null) {
                poc.a(jSONObject, "news_info", nxc.b(topNews));
            }
            if (forumInfo.game_card != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (GameInfo gameInfo : forumInfo.game_card) {
                    jSONArray6.put(kyc.b(gameInfo));
                }
                poc.a(jSONObject, "game_card", jSONArray6);
            }
            poc.a(jSONObject, "game_name", forumInfo.game_name);
            MemberShowIcon memberShowIcon = forumInfo.forumvip_show_icon;
            if (memberShowIcon != null) {
                poc.a(jSONObject, "forumvip_show_icon", zvc.b(memberShowIcon));
            }
            Adkiller adkiller = forumInfo.adkiller_data;
            if (adkiller != null) {
                poc.a(jSONObject, "adkiller_data", buc.b(adkiller));
            }
            Yule yule = forumInfo.yule;
            if (yule != null) {
                poc.a(jSONObject, "yule", byc.b(yule));
            }
            RealTime realTime = forumInfo.realtime_data;
            if (realTime != null) {
                poc.a(jSONObject, "realtime_data", pwc.b(realTime));
            }
            AcrossForumIcon acrossForumIcon = forumInfo.across_forum_show;
            if (acrossForumIcon != null) {
                poc.a(jSONObject, "across_forum_show", xtc.b(acrossForumIcon));
            }
            PostTopic postTopic = forumInfo.post_topic;
            if (postTopic != null) {
                poc.a(jSONObject, "post_topic", kwc.b(postTopic));
            }
            AcrossForumIcon acrossForumIcon2 = forumInfo.across_forum_hide;
            if (acrossForumIcon2 != null) {
                poc.a(jSONObject, "across_forum_hide", xtc.b(acrossForumIcon2));
            }
            poc.a(jSONObject, "is_live_game_forum", forumInfo.is_live_game_forum);
            poc.a(jSONObject, "is_live_game", forumInfo.is_live_game);
            poc.a(jSONObject, "is_new_game_forum", forumInfo.is_new_game_forum);
            poc.a(jSONObject, "forum_game_label", forumInfo.forum_game_label);
            poc.a(jSONObject, "warning_msg", forumInfo.warning_msg);
            poc.a(jSONObject, AlaMasterLiveRoomActivityConfig.SPECIAL_FORIM_TYPE, forumInfo.special_forum_type);
            poc.a(jSONObject, "topic_special_icon", forumInfo.topic_special_icon);
            poc.a(jSONObject, "topic_special_icon_right", forumInfo.topic_special_icon_right);
            poc.a(jSONObject, "is_brand_forum", forumInfo.is_brand_forum);
            poc.a(jSONObject, "is_show_all_top_thread", forumInfo.is_show_all_top_thread);
            ThemeColorInfo themeColorInfo = forumInfo.theme_color;
            if (themeColorInfo != null) {
                poc.a(jSONObject, "theme_color", p4d.b(themeColorInfo));
            }
            poc.a(jSONObject, "is_top_img", forumInfo.is_top_img);
            poc.a(jSONObject, "is_private_forum", forumInfo.is_private_forum);
            poc.a(jSONObject, "is_show_bawutask", forumInfo.is_show_bawutask);
            poc.a(jSONObject, "f_share_img", forumInfo.f_share_img);
            poc.a(jSONObject, "forum_share_link", forumInfo.forum_share_link);
            poc.a(jSONObject, "risk_tip_pop", forumInfo.risk_tip_pop);
            poc.a(jSONObject, "risk_tip_notice", forumInfo.risk_tip_notice);
            poc.a(jSONObject, "risk_tip_pop_title", forumInfo.risk_tip_pop_title);
            if (forumInfo.tip_list != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (TipInfo tipInfo : forumInfo.tip_list) {
                    jSONArray7.put(lxc.b(tipInfo));
                }
                poc.a(jSONObject, "tip_list", jSONArray7);
            }
            poc.a(jSONObject, "is_show_forumrule", forumInfo.is_show_forumrule);
            DeletedReasonInfo deletedReasonInfo = forumInfo.deleted_reason_info;
            if (deletedReasonInfo != null) {
                poc.a(jSONObject, "deleted_reason_info", nrc.b(deletedReasonInfo));
            }
            poc.a(jSONObject, "is_frs_mask", forumInfo.is_frs_mask);
            poc.a(jSONObject, "msg_bubble_guide_frequency", forumInfo.msg_bubble_guide_frequency);
            poc.a(jSONObject, "be_top_limit_time", forumInfo.be_top_limit_time);
            poc.a(jSONObject, "msg_bubble_guide_frequency_unread", forumInfo.msg_bubble_guide_frequency_unread);
            poc.a(jSONObject, "msg_bubble_guide_frequency_special", forumInfo.msg_bubble_guide_frequency_special);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
