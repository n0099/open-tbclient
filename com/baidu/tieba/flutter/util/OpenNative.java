package com.baidu.tieba.flutter.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ForumBroadCastMajorHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.MyRedPacketActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.SimpleVideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SmartAppBrowseHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.gson.Gson;
import com.heytap.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes11.dex */
public class OpenNative {
    public static final String kNativeBarBroadcastHistoryPage = "kNativeBarBroadcastHistoryPage";
    public static final String kNativePageKeyAddFriend = "kNativePageKeyAddFriend";
    public static final String kNativePageKeyAlaPersonalVC = "kNativePageKeyAlaPersonalVC";
    public static final String kNativePageKeyAlaVideoPlayer = "kNativePageKeyAlaVideoPlayer";
    public static final String kNativePageKeyAvatarPendantPage = "kNativePageKeyAvatarPendantPage";
    public static final String kNativePageKeyBBASMHistory = "kNativePageKeyBBASMHistory";
    public static final String kNativePageKeyBarOrgMember = "kNativePageKeyBarOrgMember";
    public static final String kNativePageKeyBigImagePage = "kNativePageKeyBigImagePage";
    public static final String kNativePageKeyBlockedFans = "kNativePageKeyBlockedFans";
    public static final String kNativePageKeyBuyTBean = "kNativePageKeyBuyTBean";
    public static final String kNativePageKeyCreateForum = "kNativePageKeyCreateForum";
    public static final String kNativePageKeyDynamicBaOrg = "kNativePageKeyDynamicBaOrg";
    public static final String kNativePageKeyDynamicPopOldFrs = "kNativePageKeyDynamicPopOldFrs";
    public static final String kNativePageKeyEditProfile = "kNativePageKeyEditProfile";
    public static final String kNativePageKeyEmojiCenter = "kNativePageKeyEmojiCenter";
    public static final String kNativePageKeyFans = "kNativePageKeyFans";
    public static final String kNativePageKeyFavoriteBars = "kNativePageKeyFavoriteBars";
    public static final String kNativePageKeyFollowedUsers = "kNativePageKeyFollowedUsers";
    public static final String kNativePageKeyForumGroup = "kNativePageKeyForumGroup";
    public static final String kNativePageKeyForumSquare = "kNativePageKeyForumSquare";
    public static final String kNativePageKeyFrsManagerElectionVC = "kNativePageKeyFrsManagerElectionVC";
    public static final String kNativePageKeyGiftTabPage = "kNativePageKeyGiftTabPage";
    public static final String kNativePageKeyGroupList = "kNativePageKeyGroupList";
    public static final String kNativePageKeyHotTopicList = "kNativePageKeyHotTopicList";
    public static final String kNativePageKeyHotTopicTrend = "kNativePageKeyHotTopicTrendDetail";
    public static final String kNativePageKeyHotUserRank = "kNativePageKeyHotUserRank";
    public static final String kNativePageKeyItemEvaluatePage = "kNativePageKeyItemEvaluatePage";
    public static final String kNativePageKeyMemberStore = "kNativePageKeyMemberStore";
    public static final String kNativePageKeyMyCollection = "kNativePageKeyMyCollection";
    public static final String kNativePageKeyMyPostAndReply = "kNativePageKeyMyPostAndReply";
    public static final String kNativePageKeyOfficalBarChat = "kNativePageKeyOfficalBarChat";
    public static final String kNativePageKeyOfficialForumHistory = "kNativePageKeyOfficialForumHistory";
    public static final String kNativePageKeyOpenVideo = "MFCustomCmdVideoViewController";
    public static final String kNativePageKeyPASSLoginVC = "kNativePageKeyPASSLoginVC";
    public static final String kNativePageKeyPersonChat = "kNativePageKeyPersonChat";
    public static final String kNativePageKeyPersonMore = "kNativePageKeyPersonMore";
    public static final String kNativePageKeyPersonal = "kNativePageKeyPersonal";
    public static final String kNativePageKeyQRCodeScanner = "kNativePageKeyQRCodeScanner";
    public static final String kNativePageKeyRedPacketPersonalCenter = "kNativePageKeyRedPacketPersonalCenter";
    public static final String kNativePageKeySendThreadPage = "kNativePageKeySendThreadPage";
    public static final String kNativePageKeySentGiftList = "kNativePageKeySentGiftList";
    public static final String kNativePageKeySetting = "kNativePageKeySetting";
    public static final String kNativePageKeySquare = "kNativePageKeySquare";
    public static final String kNativePageKeyThemeCenter = "kNativePageKeyThemeCenter";
    public static final String kNativePageKeyTreasureTroveMore = "kNativePageKeyTreasureTroveMore";
    public static final String kNativePageKeyUserHotHeadPage = "kNativePageKeyUserHotHeadPage";
    public static final String kNativePageKeyUserProfileBackground = "kNativePageKeyUserProfileBackground";
    public static final String kNativePageKeyVideoMiddlePage = "kNativePageKeyVideoMiddlePage";
    public static final String kNativePageKeyViewHistory = "kNativePageKeyViewHistory";
    public static final String kNativePageKeyVipCenterUIWebView = "kNativePageKeyVipCenterUIWebView";
    public static final String kNativePageKeyVipCenterWKWebView = "kNativePageKeyVipCenterWKWebView";
    public static final String kNativePageKeyVitalityPB = "kNativePageKeyVitalityPB";
    public static final String kNativePageKeyWKWebView = "kNativePageKeyWKWebView";
    public static final String kNativePageKeyWalletHome = "kNativePageKeyWalletHome";
    public static final String kNativePageKeyWebView = "kNativePageKeyWebView";
    public static final String kNativePageKeyWebViewWithTitle = "kNativePageKeyWebViewWithTitle";
    public static final String kNativePageKeyfourmBigImagePage = "kNativePageKeyfourmBigImagePage";

    public static boolean toNativePage(Context context, String str, Map<String, Object> map) {
        if (kNativePageKeyBlockedFans.equals(str)) {
            openNativeBlockedFans(context, map);
            return true;
        } else if (kNativePageKeyHotTopicTrend.equals(str)) {
            openNativeHotTopicTrendDetail(context, map);
            return true;
        } else if (kNativePageKeyForumSquare.equals(str)) {
            openNativePageKeyForumSquare(context, map);
            return true;
        } else if (kNativePageKeyItemEvaluatePage.equals(str)) {
            openNativeEvaluationPage(context, map);
            return true;
        } else if (kNativePageKeySendThreadPage.equals(str)) {
            openNativePageKeySendThreadPage(context, map);
            return true;
        } else if (kNativePageKeyAlaVideoPlayer.equals(str)) {
            openNativeAlaVideoPlayer(context, map);
            return true;
        } else if (kNativePageKeyOpenVideo.equals(str)) {
            openNativeCustomVideo(context, map);
            return true;
        } else if (kNativePageKeyAlaVideoPlayer.equals(str)) {
            openNativeAlaVideoPlayer(context, map);
            return true;
        } else if (kNativePageKeyViewHistory.equals(str)) {
            openNativeViewHistory(context, map);
            return true;
        } else if (kNativePageKeyFollowedUsers.equals(str)) {
            openNativeFollowedUsers(context, map);
            return true;
        } else if (kNativePageKeyMyCollection.equals(str)) {
            openNativeMyCollection(context, map);
            return true;
        } else if (kNativePageKeySetting.equals(str)) {
            openNativeSetting(context, map);
            return true;
        } else if (kNativePageKeyGroupList.equals(str)) {
            openNativeGroupList(context, map);
            return true;
        } else if (kNativePageKeyMyPostAndReply.equals(str)) {
            openNativeMyPostAndReply(context, map);
            return true;
        } else if (kNativePageKeyHotTopicList.equals(str)) {
            openNativeHotTopicList(context, map);
            return true;
        } else if (kNativePageKeyThemeCenter.equals(str)) {
            openNativeThemeCenter(context, map);
            return true;
        } else if (kNativePageKeySentGiftList.equals(str)) {
            openNativeSentGiftList(context, map);
            return true;
        } else if (kNativePageKeyQRCodeScanner.equals(str)) {
            openNativeQRCodeScanner(context, map);
            return true;
        } else if (kNativePageKeyAlaPersonalVC.equals(str)) {
            openNativeAlaPersonalVC(context, map);
            return true;
        } else if (kNativePageKeyWKWebView.equals(str)) {
            openNativeWKWebView(context, map);
            return true;
        } else if (kNativePageKeyRedPacketPersonalCenter.equals(str)) {
            openNativeRedPacketPersonalCenter(context, map);
            return true;
        } else if (kNativePageKeyFavoriteBars.equals(str)) {
            openNativeFavoriteBars(context, map);
            return true;
        } else if (kNativePageKeyPersonMore.equals(str)) {
            openNativePersonMore(context, map);
            return true;
        } else if (kNativePageKeyVipCenterUIWebView.equals(str)) {
            openNativeVipCenterWKWebView(context, map);
            return true;
        } else if (kNativePageKeyVipCenterWKWebView.equals(str)) {
            openNativeVipCenterWKWebView(context, map);
            return true;
        } else if (kNativePageKeyBBASMHistory.equals(str)) {
            openNativeBBASMHistory(context, map);
            return true;
        } else if (kNativePageKeyPersonal.equals(str)) {
            openNativePersonal(context, map);
            return true;
        } else if (kNativePageKeyDynamicPopOldFrs.equals(str)) {
            openNativeDynamicBaOrg(context, map);
            return true;
        } else if (kNativePageKeyDynamicBaOrg.equals(str)) {
            openNativeDynamicBaOrg(context, map);
            return true;
        } else if (kNativePageKeyWebView.equals(str)) {
            openNativeWebView(context, map);
            return true;
        } else if (kNativePageKeyFrsManagerElectionVC.equals(str)) {
            openNativeFrsManagerElectionVC(context, map);
            return true;
        } else if (kNativePageKeyForumGroup.equals(str)) {
            openNativeForumGroup(context, map);
            return true;
        } else if (kNativePageKeyBarOrgMember.equals(str)) {
            openNativeBarOrgMember(context, map);
            return true;
        } else if (kNativePageKeyEmojiCenter.equals(str)) {
            openNativeEmojiCenter(context, map);
            return true;
        } else if (kNativePageKeyOfficialForumHistory.equals(str)) {
            openNativeOfficialForumHistory(context, map);
            return true;
        } else if (kNativePageKeyVitalityPB.equals(str)) {
            openNativeVitalityPB(context, map);
            return true;
        } else if (kNativePageKeySquare.equals(str)) {
            openNativeSquare(context, map);
            return true;
        } else if (kNativePageKeyMemberStore.equals(str)) {
            openNativeMemberStore(context, map);
            return true;
        } else if (kNativePageKeyPASSLoginVC.equals(str)) {
            openNativePASSLoginVC(context, map);
            return true;
        } else if (kNativePageKeyBuyTBean.equals(str)) {
            openNativeBuyTBean(context, map);
            return true;
        } else if (kNativePageKeyFans.equals(str)) {
            openNativeFans(context, map);
            return true;
        } else if (kNativePageKeyOfficalBarChat.equals(str)) {
            openNativeOfficalBarChat(context, map);
            return true;
        } else if (kNativePageKeyWalletHome.equals(str)) {
            openNativeWallet(context, map);
            return true;
        } else if (kNativeBarBroadcastHistoryPage.equals(str)) {
            openNativeBarBroadcastHistoryPage(context, map);
            return true;
        } else if (kNativePageKeyEditProfile.equals(str)) {
            openNativeEditProfile(context, map);
            return true;
        } else if (kNativePageKeyPersonChat.equals(str)) {
            openNativePersonChat(context, map);
            return true;
        } else if (kNativePageKeyWebViewWithTitle.equals(str)) {
            openNativeWebViewWithTitle(context, map);
            return true;
        } else if (kNativePageKeyAddFriend.equals(str)) {
            openNativeAddFriend(context, map);
            return true;
        } else if (kNativePageKeyBigImagePage.equals(str)) {
            openNativeBigImagePage(context, map);
            return true;
        } else if (kNativePageKeyfourmBigImagePage.equals(str)) {
            openNativefourmBigImagePage(context, map);
            return true;
        } else if (kNativePageKeyGiftTabPage.equals(str)) {
            openNativeGiftTabPage(context, map);
            return true;
        } else if (kNativePageKeyAvatarPendantPage.equals(str)) {
            openNativeAvatarPendantPage(context, map);
            return true;
        } else if (kNativePageKeyUserProfileBackground.equals(str)) {
            openNativeUserProfileBackground(context, map);
            return true;
        } else if (kNativePageKeyUserHotHeadPage.equals(str)) {
            openNativeUserHotHeadPage(context, map);
            return true;
        } else if (kNativePageKeyHotUserRank.equals(str)) {
            openNativePageKeyHotUserRank(context, map);
            return true;
        } else if (kNativePageKeyCreateForum.equals(str)) {
            openNativeCreateForumPage(context, map);
            return true;
        } else if (kNativePageKeyVideoMiddlePage.equals(str)) {
            openNativeVideoMiddlePage(context, map);
            return true;
        } else if (kNativePageKeyTreasureTroveMore.equals(str)) {
            openNativeTreasureTroveMorePage(context, map);
            return true;
        } else {
            if (BdBaseApplication.getInst().isDebugMode()) {
                UtilHelper.showToast(TbadkCoreApplication.getInst(), "打开页面找不到:" + str);
            }
            BdLog.e("flutter open page id not found :" + str + " " + map);
            return true;
        }
    }

    private static void openNativePageKeyForumSquare(Context context, Map<String, Object> map) {
        ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(context, (String) map.get("feildName"));
        forumSquareActivityConfig.showCreateBar("1".equals((String) map.get("showCreateBar")) ? 1 : 0);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumSquareActivityConfig));
    }

    private static void openNativeVideoMiddlePage(Context context, Map<String, Object> map) {
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig;
        if (map != null && !map.isEmpty() && (map.get(WriteActivityConfig.VIDEO_INFO) instanceof HashMap)) {
            boolean equals = "1".equals(((HashMap) map.get(WriteActivityConfig.VIDEO_INFO)).get("is_vertical"));
            String str = (String) map.get("from");
            String str2 = (String) map.get("stType");
            if (equals) {
                ArrayList arrayList = new ArrayList();
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.buildWithFlutterMap(map);
                arrayList.add(videoItemData);
                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, str2, "", str, str);
                if (videoItemData.baijiahaoData != null) {
                    videoPlayActivityConfig.setNid(videoItemData.baijiahaoData.oriUgcNid);
                }
                videoMiddlePageActivityConfig = videoPlayActivityConfig;
            } else {
                VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                videoSerializeVideoThreadInfo.copyFromFlutterDataMap(map);
                videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(context, str, (String) map.get("tid"), str2, "", videoSerializeVideoThreadInfo);
                if (videoSerializeVideoThreadInfo.getBaijiahaoData() != null) {
                    videoMiddlePageActivityConfig.setNid(videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcNid);
                }
            }
            if (map.containsKey("from")) {
                d.Dv((String) map.get("from"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoMiddlePageActivityConfig));
        }
    }

    private static void openNativeTreasureTroveMorePage(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LowFlowsActivityConfig(context, (String) map.get(LowFlowsActivityConfig.TAB_CODE), (String) map.get(LowFlowsActivityConfig.LF_USER), (String) map.get(LowFlowsActivityConfig.LF_USER_TASKID))));
    }

    private static void openNativePageKeyHotUserRank(Context context, Map<String, Object> map) {
        HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(context);
        hotUserRankActivityConfig.setCategory((String) map.get("moduleName"));
        hotUserRankActivityConfig.setIsGod("1".equals((String) map.get("isGod")));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
    }

    private static void openNativeAlaVideoPlayer(Context context, Map<String, Object> map) {
        long j = b.toLong((String) map.get("liveId"), 0L);
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = j;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
    }

    private static void openNativeCustomVideo(Context context, Map<String, Object> map) {
        String str = (String) map.get("videoUrl");
        SimpleVideoPlayActivityConfig.a aVar = new SimpleVideoPlayActivityConfig.a();
        aVar.zX(str).zW(str);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, aVar.eP(context)));
    }

    private static void openNativeHotTopicTrendDetail(Context context, Map<String, Object> map) {
        long j = b.toLong((String) map.get("hotTopicID"), 0L);
        if (j > 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(context, j)));
        }
    }

    private static void openNativeEditProfile(Context context, Map<String, Object> map) {
        PersonChangeData personChangeData = new PersonChangeData();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            personChangeData.setPortrait(currentAccountInfo.getPortrait());
            personChangeData.setName(currentAccountInfo.getDisplayName());
            personChangeData.setSex(currentAccountInfo.getSex());
            personChangeData.setNameShow(currentAccountInfo.getAccountNameShow());
            personChangeData.setMem(currentAccountInfo.getMemberType());
        }
        personChangeData.setName((String) map.get(TbEnum.SystemMessage.KEY_USER_NAME));
        personChangeData.setSex(b.toInt((String) map.get("sex"), 0));
        personChangeData.setIntro((String) map.get("intro"));
        personChangeData.setForumAge((String) map.get("TBAge"));
        personChangeData.setAlaId(b.toLong((String) map.get("alaID"), 0L));
        personChangeData.setNickNameLeftDays(b.toInt((String) map.get("leftDays"), 0));
        personChangeData.setUserAge(b.toInt((String) map.get("age"), 0));
        personChangeData.setBirthdayTime(b.toLong((String) map.get("birthdayTime"), 0L));
        personChangeData.setBirthdayShowStatus(b.toInt((String) map.get("birthdayShowStatus"), 0));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(context, 101, personChangeData, false)));
    }

    private static void openNativeUserProfileBackground(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(context)));
    }

    private static void openNativeAvatarPendantPage(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(context)));
    }

    private static void openNativeWallet(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
    }

    private static void openNativeSquare(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(context)));
    }

    private static void openNativePersonal(Context context, Map<String, Object> map) {
        String str = (String) map.get("uid");
        if (au.isEmpty(str)) {
            BdLog.e("openPageByUrl param is empty.");
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, str, "")));
        }
    }

    private static void openNativeViewHistory(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(context)));
    }

    private static void openNativeFollowedUsers(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(context, "1".equals((String) map.get("type")), (String) map.get("uid"), b.toInt((String) map.get("sex"), 0)).updateFollowNum(b.toInt((String) map.get("concerNum"), 0), (String) map.get("portrait"))));
    }

    private static void openNativeMyCollection(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(context)));
    }

    private static void openNativeSetting(Context context, Map<String, Object> map) {
        if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(context)));
        } else {
            BdLog.e("设置插件未安装");
        }
    }

    private static void openNativeGroupList(Context context, Map<String, Object> map) {
        String str = (String) map.get("uid");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(context, b.toInt((String) map.get("sex"), 0), 0, 1)));
    }

    private static void openNativeMemberStore(Context context, Map<String, Object> map) {
        String str = (String) map.get("stParam");
        int i = b.toInt((String) map.get("enterType"), 0);
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(context, b.toInt((String) map.get("memberType"), 0), (String) map.get("stType"), i);
        memberPayActivityConfig.setSceneId((String) map.get("sceneId"));
        memberPayActivityConfig.setClose("1".equals((String) map.get("close")));
        memberPayActivityConfig.setReferPageClickZone((String) map.get("referPage"), (String) map.get("clickZone"));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }

    private static void openNativeMyPostAndReply(Context context, Map<String, Object> map) {
        String str = (String) map.get(TbEnum.SystemMessage.KEY_USER_NAME);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(context, (String) map.get("userID"), b.toInt((String) map.get("sex"), 0), (String) map.get("portrait"))));
    }

    private static void openNativeBlockedFans(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(context)));
    }

    private static void openNativeBarOrgMember(Context context, Map<String, Object> map) {
        String str = (String) map.get(TbTitleActivityConfig.FORUM_ID);
        String str2 = (String) map.get(TbTitleActivityConfig.FORUM_NAME);
        if (au.isEmpty(str)) {
            BdLog.e("openPageByUrl param is empty.");
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumMemberActivityConfig(context, str, str2)));
        }
    }

    private static void openNativeEmojiCenter(Context context, Map<String, Object> map) {
        String str = (String) map.get("url");
        if (au.isEmpty(str)) {
            BdLog.e("openPageByUrl param is empty.");
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(context, str)));
        }
    }

    private static void openNativeHotTopicList(Context context, Map<String, Object> map) {
        if (TbadkApplication.getInst().getCurrentActivity() != null && !com.baidu.tbadk.plugins.b.k(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(context).createNormalConfig("hottopic", "all")));
        }
    }

    private static void openNativeThemeCenter(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(context)));
    }

    private static void openNativeSentGiftList(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(context, (String) map.get("uid"), (String) map.get(TbEnum.SystemMessage.KEY_USER_NAME), (String) map.get("nameShow"), b.toInt((String) map.get("sex"), 0), "iowner_gift")));
    }

    private static void openNativeQRCodeScanner(final Context context, Map<String, Object> map) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.flutter.util.OpenNative.1
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
            public void onPermissionsGranted() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(context)));
            }
        });
        permissionJudgePolicy.startRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity());
    }

    private static void openNativeOfficialForumHistory(Context context, Map<String, Object> map) {
        int i = b.toInt((String) map.get(TbTitleActivityConfig.FORUM_ID), 0);
        if (i == 0) {
            BdLog.e("openPageByUrl param is empty.");
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new OfficialBarHistoryActivityConfig(context, i)));
        }
    }

    private static void openNativePASSLoginVC(Context context, Map<String, Object> map) {
        TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TbadkCoreApplication.getInst().getContext(), true)));
    }

    private static void openNativeVitalityPB(Context context, Map<String, Object> map) {
        String str = (String) map.get("tid");
        int i = b.toInt((String) map.get("threadType"), 0);
        if (au.isEmpty(str)) {
            BdLog.e("openPageByUrl param is empty.");
            return;
        }
        String valueOf = String.valueOf(map.get("st_type"));
        if (map.containsKey("flutter_from")) {
            valueOf = String.valueOf(map.get("flutter_from"));
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(context);
        pbActivityConfig.createNormalCfg(str, (String) null, i, valueOf);
        if (map.containsKey(TbTitleActivityConfig.FORUM_ID)) {
            pbActivityConfig.setForumId(String.valueOf(map.get(TbTitleActivityConfig.FORUM_ID)));
        }
        if (map.containsKey(IntentConfig.NID)) {
            pbActivityConfig.setBjhData(String.valueOf(map.get(IntentConfig.NID)), String.valueOf(map.get("tid")), String.valueOf(map.get("type")), String.valueOf(map.get("vid")));
        }
        if (map.containsKey("from_comment") && "1".equals(String.valueOf(map.get("from_comment")))) {
            pbActivityConfig.setJumpToCommentArea(true);
        }
        if (map.containsKey(PbActivityConfig.KEY_UNKNOW_PB_TYPE)) {
            pbActivityConfig.setUnKnowPbType((String) map.get(PbActivityConfig.KEY_UNKNOW_PB_TYPE));
        }
        if (map.containsKey("enter_type")) {
            d.Dv((String) map.get("enter_type"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }

    private static void openNativeDynamicBaOrg(Context context, Map<String, Object> map) {
        String str = (String) map.get(TbTitleActivityConfig.FORUM_ID);
        String str2 = (String) map.get(TbTitleActivityConfig.FORUM_NAME);
        String str3 = (String) map.get("from");
        String str4 = (String) map.get(FrsActivityConfig.FRS_CALL_FROM);
        String str5 = (String) map.get("fakeThreadId");
        String str6 = (String) map.get("barImageFrame");
        String str7 = (String) map.get("barNameFrame");
        String str8 = (String) map.get("info_forum_image_url");
        int intValue = map.containsKey("transition_type") ? ((Integer) map.get("transition_type")).intValue() : 0;
        String str9 = (String) map.get("item");
        if (au.isEmpty(str2)) {
            BdLog.e("openPageByUrl param is empty.");
            return;
        }
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(context).createNormalCfg(str2, str3);
        if (!au.isEmpty(str4)) {
            createNormalCfg.setCallFrom(b.toInt(str4, 0));
        }
        long j = b.toLong(str5, 0L);
        if (j > 0) {
            createNormalCfg.setFakeThreadId(j);
        }
        Rect parseFrameInfo = parseFrameInfo(str6);
        Rect parseFrameInfo2 = parseFrameInfo(str7);
        createNormalCfg.getIntent().putExtra("info_forum_image_rect", parseFrameInfo);
        createNormalCfg.getIntent().putExtra("info_forum_name_rect", parseFrameInfo2);
        createNormalCfg.getIntent().putExtra("transition_type", intValue);
        createNormalCfg.getIntent().putExtra("info_forum_image_url", str8);
        createNormalCfg.getIntent().putExtra("info_forum_name_text", str2);
        if (str9 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str9);
                createNormalCfg.getIntent().putExtra("info_forum_image_url", (String) jSONObject.get(TableDefine.PaSubscribeColumns.COLUMN_AVATAR));
                String string = jSONObject.getString("theme_color");
                if (!TextUtils.isEmpty(string)) {
                    ThemeColorInfo themeColorInfo = (ThemeColorInfo) new Gson().fromJson(string, (Class<Object>) ThemeColorInfo.class);
                    createNormalCfg.getIntent().putExtra("info_forum_head_background_color", getGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (map.containsKey(FrsActivityConfig.FRS_CALL_FROM)) {
            d.Dv((String) map.get(FrsActivityConfig.FRS_CALL_FROM));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalCfg));
    }

    private static void openNativeBarBroadcastHistoryPage(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumBroadCastMajorHistoryActivityConfig(context, (String) map.get(TbTitleActivityConfig.FORUM_ID), (String) map.get(TbTitleActivityConfig.FORUM_NAME), (String) map.get("from"))));
    }

    private static void openNativeAlaPersonalVC(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(context, (String) map.get("kUid"), (String) map.get(TbEnum.SystemMessage.KEY_USER_NAME), (String) map.get("portrait"), b.toInt((String) map.get("sex"), 0), true)));
    }

    private static void openNativeWebView(Context context, Map<String, Object> map) {
        String str = (String) map.get("url");
        if (au.isEmpty(str)) {
            BdLog.e("openPageByUrl param is empty.");
            return;
        }
        try {
            if (TbadkApplication.getInst().getCurrentActivity() != null) {
                bf.bsY().b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{str});
            }
        } catch (Exception e) {
            BdLog.e("openPageByUrl fail:" + e.toString());
        }
    }

    private static void openNativeWKWebView(Context context, Map<String, Object> map) {
        String str = (String) map.get("title");
        String str2 = (String) map.get("url");
        if (au.isEmpty(str2)) {
            BdLog.e("openNativeWKWebView param is empty.");
        } else {
            a.startWebActivity(true, context, str, str2);
        }
    }

    private static void openNativeRedPacketPersonalCenter(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyRedPacketActivityConfig(context)));
    }

    private static void openNativeFavoriteBars(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(context, b.toInt((String) map.get("forumNum"), 0), (String) map.get("uid"), b.toInt((String) map.get("sex"), 0))));
    }

    private static void openNativePersonMore(Context context, Map<String, Object> map) {
        ArrayList arrayList = (ArrayList) map.get("more");
        try {
            PersonMoreData personMoreData = new PersonMoreData();
            List<PersonMoreItemData> list = personMoreData.mUrlMaps;
            for (int i = 0; i < arrayList.size(); i++) {
                HashMap hashMap = (HashMap) arrayList.get(i);
                PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                personMoreItemData.mId = b.toInt((String) hashMap.get("id"), 0);
                personMoreItemData.mName = (String) hashMap.get("name");
                personMoreItemData.mUrl = (String) hashMap.get("url");
                list.add(personMoreItemData);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(context, OrmObject.bundleWithObject(personMoreData))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void openNativeForumGroup(Context context, Map<String, Object> map) {
        String str = (String) map.get("barID");
        if (au.isEmpty(str)) {
            BdLog.e("openPageByUrl param is empty.");
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsGroupActivityConfig(context, str, "")));
        }
    }

    private static void openNativeVipCenterWKWebView(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(context)));
    }

    private static void openNativeFrsManagerElectionVC(Context context, Map<String, Object> map) {
        long j = b.toInt((String) map.get(TbTitleActivityConfig.FORUM_ID), 0);
        int i = b.toInt((String) map.get("electionEnterType"), 0);
        if (j == 0 || i == 0) {
            BdLog.e("openPageByUrl param is empty.");
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(context).createNormalConfig(j, i)));
        }
    }

    private static void openNativeBBASMHistory(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SmartAppBrowseHistoryActivityConfig(context)));
    }

    private static void openNativeBuyTBean(Context context, Map<String, Object> map) {
        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(TbadkCoreApplication.getInst().getContext(), 0L);
        buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
    }

    private static void openNativeFans(Context context, Map<String, Object> map) {
        String str = (String) map.get(TbEnum.SystemMessage.KEY_USER_ID);
        String str2 = (String) map.get("userSex");
        int intValue = ((Integer) map.get("type")).intValue();
        String str3 = (String) map.get("ShowNaviBar");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(TbadkCoreApplication.getInst().getContext(), intValue == 1, str, b.toInt(str2, 0))));
    }

    private static void openNativeOfficalBarChat(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(TbadkCoreApplication.getInst().getContext(), b.toLong((String) map.get(TbTitleActivityConfig.FORUM_ID), 0L), (String) map.get(TbTitleActivityConfig.FORUM_NAME), (String) map.get("imageUrl"), 0)));
    }

    private static void openNativePersonChat(Context context, Map<String, Object> map) {
        String str = (String) map.get(TbEnum.SystemMessage.KEY_USER_ID);
        String str2 = (String) map.get("sex");
        String str3 = (String) map.get("isFriend");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(TbadkCoreApplication.getInst().getContext(), Long.parseLong(str), (String) map.get(TbEnum.SystemMessage.KEY_USER_NAME), (String) map.get("nameShow"), (String) map.get("portrait"), b.toInt(str2, 0), b.toInt(str3, 0), b.toInt((String) map.get("userType"), 0))));
    }

    private static void openNativeWebViewWithTitle(Context context, Map<String, Object> map) {
        String str = (String) map.get("title");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(TbadkCoreApplication.getInst().getContext(), str, (String) map.get("url"), true)));
    }

    private static void openNativeAddFriend(Context context, Map<String, Object> map) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(TbadkCoreApplication.getInst().getContext(), (String) map.get("uid"), (String) map.get("uName"), (String) map.get("portrait"), null, false, null)));
    }

    private static void openNativeBigImagePage(Context context, Map<String, Object> map) {
        String str;
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(context, "大图功能安装失败,请稍候重试");
            return;
        }
        ArrayList<String> arrayList = (ArrayList) map.get("urls");
        if (arrayList != null) {
            if (arrayList == null || arrayList.size() <= 0) {
                str = "";
            } else {
                str = arrayList.get(arrayList.size() - 1);
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).mR(((Integer) map.get("index")).intValue()).zQ((String) map.get("forum_name")).zR((String) map.get("forum_id")).zS((String) map.get("thread_id")).jg(true).zT(str).jh(true).ji(true);
            ImageViewerConfig eO = aVar.eO(context);
            eO.getIntent().putExtra(ImageViewerConfig.IS_SHOW_HOST, false);
            eO.getIntent().putExtra("from", "index");
            if (map.containsKey("enter_type")) {
                d.Dv((String) map.get("enter_type"));
                g.publishEvent(new PrePageKeyEvent(d.bDP()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO));
        }
    }

    private static void openNativefourmBigImagePage(Context context, Map<String, Object> map) {
        String str;
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(context, "大图功能安装失败,请稍候重试");
            return;
        }
        ArrayList<String> arrayList = (ArrayList) map.get("urls");
        if (arrayList != null) {
            if (arrayList == null || arrayList.size() <= 0) {
                str = "";
            } else {
                str = arrayList.get(arrayList.size() - 1);
            }
            String str2 = (String) map.get("forum_id");
            String str3 = (String) map.get("forum_name");
            String str4 = (String) map.get("thread_id");
            String str5 = (String) map.get("post_id");
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (!TextUtils.isEmpty(arrayList.get(i2))) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = 13;
                    imageUrlData.imageUrl = arrayList.get(i2);
                    imageUrlData.threadId = b.toLong(str4, -1L);
                    imageUrlData.postId = b.toLong(str5, -1L);
                    concurrentHashMap.put(arrayList.get(i2), imageUrlData);
                }
                i = i2 + 1;
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.s(arrayList).mR(((Integer) map.get("index")).intValue()).zQ(str3).zR(str2).zS(str4).jg(true).zT(str).jh(true).d(concurrentHashMap).ji(true);
            ImageViewerConfig eO = aVar.eO(context);
            eO.getIntent().putExtra(ImageViewerConfig.IS_SHOW_HOST, true);
            if (map.get("from") != null && (map.get("from") instanceof String)) {
                eO.getIntent().putExtra("from", (String) map.get("from"));
            } else {
                eO.getIntent().putExtra("from", "index");
            }
            if (map.containsKey("enter_type")) {
                d.Dv((String) map.get("enter_type"));
                g.publishEvent(new PrePageKeyEvent(d.bDP()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eO));
        }
    }

    private static void openNativeGiftTabPage(Context context, Map<String, Object> map) {
        GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), b.toLong((String) map.get("id"), 0L), (String) map.get("name"), (String) map.get("nameShow"), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
        giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
    }

    private static void openNativeUserHotHeadPage(Context context, Map<String, Object> map) {
        ChangeSystemPhotoActivityConfig changeSystemPhotoActivityConfig = new ChangeSystemPhotoActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST, true);
        changeSystemPhotoActivityConfig.getIntent().putExtra("from", "flutter");
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, changeSystemPhotoActivityConfig));
    }

    private static void openNativeEvaluationPage(Context context, Map<String, Object> map) {
        Activity currentActivity;
        if (bh.checkUpIsLogin(context)) {
            double parseDouble = Double.parseDouble(String.valueOf(map.get("iconSize")));
            String str = (String) map.get("iconUrl");
            int parseInt = Integer.parseInt(String.valueOf(map.get("id")));
            int parseInt2 = Integer.parseInt(String.valueOf(map.get("isSchool")));
            String str2 = (String) map.get("name");
            String str3 = (String) map.get(CommandMessage.TYPE_TAGS);
            int i = b.toInt(String.valueOf(map.get("commentStar")), 0);
            String valueOf = String.valueOf(map.get("pointNum"));
            double d = TextUtils.isEmpty(valueOf) ? 0.0d : b.toDouble(valueOf, 0.0d);
            if (!WriteActivityConfig.isAsyncWriting() && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
                SerializableItemInfo serializableItemInfo = new SerializableItemInfo();
                serializableItemInfo.setId(Integer.valueOf(parseInt));
                serializableItemInfo.setIcon_url(str);
                serializableItemInfo.setName(str2);
                serializableItemInfo.setTags(getTagList(str3));
                serializableItemInfo.setIconSize(parseDouble);
                serializableItemInfo.setAverageScore(d);
                WriteActivityConfig.newInstance(currentActivity).setType(9).setScoreItemInfo(serializableItemInfo).setItemIsSchool(parseInt2 == 1).setStarCount(i).setIsEvaluate(true).setIsItemDetail(true).setCallFrom("2").setFrom("main_tab").send();
            }
        }
    }

    private static void openNativePageKeySendThreadPage(Context context, Map<String, Object> map) {
        Activity currentActivity;
        if (bh.checkUpIsLogin(context) && !WriteActivityConfig.isAsyncWriting() && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
            WriteActivityConfig.newInstance(currentActivity).setCallFrom("2").setType(9).setFrom("main_tab").send();
        }
    }

    private static List<String> getTagList(String str) {
        String[] split;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    private static void openNativeCreateForumPage(Context context, Map<String, Object> map) {
        try {
            if (TbadkApplication.getInst().getCurrentActivity() != null) {
                bf.bsY().b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
            }
        } catch (Exception e) {
            BdLog.e("openPageByUrl fail:" + e.toString());
        }
    }

    private static Rect parseFrameInfo(String str) {
        Rect rect = new Rect();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length >= 2) {
                rect.left = (int) (b.toDouble(split[0], 0.0d) * 2.6d);
                rect.top = (int) (b.toDouble(split[1], 0.0d) * 2.6d);
            }
        }
        return rect;
    }

    public static ArrayList<Integer> getGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int rT;
        int i;
        int rT2;
        int i2;
        int rT3;
        int rT4;
        if (themeElement == null) {
            int rT5 = com.baidu.tieba.lego.card.c.b.rT("#2BB8FF");
            rT = com.baidu.tieba.lego.card.c.b.rT("#2BB8FF");
            i = rT5;
        } else {
            int rT6 = com.baidu.tieba.lego.card.c.b.rT(themeElement.common_color);
            rT = com.baidu.tieba.lego.card.c.b.rT(themeElement.common_color);
            i = rT6;
        }
        if (themeElement2 == null) {
            int rT7 = com.baidu.tieba.lego.card.c.b.rT("#249BD6");
            rT2 = com.baidu.tieba.lego.card.c.b.rT("#246CD6");
            i2 = rT7;
        } else {
            int rT8 = com.baidu.tieba.lego.card.c.b.rT(themeElement2.common_color);
            rT2 = com.baidu.tieba.lego.card.c.b.rT(themeElement2.common_color);
            i2 = rT8;
        }
        if (themeElement3 == null) {
            rT3 = com.baidu.tieba.lego.card.c.b.rT("#249BD6");
            rT4 = com.baidu.tieba.lego.card.c.b.rT("#246CD6");
        } else {
            rT3 = com.baidu.tieba.lego.card.c.b.rT(themeElement3.common_color);
            rT4 = com.baidu.tieba.lego.card.c.b.rT(themeElement3.common_color);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(i));
        arrayList.add(Integer.valueOf(rT));
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(rT2));
        arrayList.add(Integer.valueOf(rT3));
        arrayList.add(Integer.valueOf(rT4));
        return arrayList;
    }
}
