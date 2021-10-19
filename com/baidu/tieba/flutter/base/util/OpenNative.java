package com.baidu.tieba.flutter.base.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.j0.h;
import c.a.q0.m.a;
import c.a.r0.q1.o.k.b;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
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
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.SimpleVideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SmartAppBrowseHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.module.hottopic.VideoHotTopicParams;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.gson.Gson;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class OpenNative {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String kNativeBarBroadcastHistoryPage = "kNativeBarBroadcastHistoryPage";
    public static final String kNativePageKeyAddFriend = "kNativePageKeyAddFriend";
    public static final String kNativePageKeyAlaPersonalVC = "kNativePageKeyAlaPersonalVC";
    public static final String kNativePageKeyAlaVideoPlayer = "kNativePageKeyAlaVideoPlayer";
    public static final String kNativePageKeyAlbumFloat = "kNativePageKeyAlbumFloat";
    public static final String kNativePageKeyAvatarPendantPage = "kNativePageKeyAvatarPendantPage";
    public static final String kNativePageKeyBBASMHistory = "kNativePageKeyBBASMHistory";
    public static final String kNativePageKeyBarOrgMember = "kNativePageKeyBarOrgMember";
    public static final String kNativePageKeyBarownerSetting = "NativePageKeyBarownerSetting";
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
    public static final String kNativePageKeyPrivateSetting = "kNativePageKeyPrivateSetting";
    public static final String kNativePageKeyQRCodeScanner = "kNativePageKeyQRCodeScanner";
    public static final String kNativePageKeyRedPacketPersonalCenter = "kNativePageKeyRedPacketPersonalCenter";
    public static final String kNativePageKeySendThreadPage = "kNativePageKeySendThreadPage";
    public static final String kNativePageKeySentGiftList = "kNativePageKeySentGiftList";
    public static final String kNativePageKeySetting = "kNativePageKeySetting";
    public static final String kNativePageKeySquare = "kNativePageKeySquare";
    public static final String kNativePageKeySubscribeOrDownloadManager = "kNativePageKeySubscribeOrDownloadManager";
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
    public transient /* synthetic */ FieldHolder $fh;

    public OpenNative() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ArrayList<Integer> getGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        InterceptResult invokeLLL;
        int b2;
        int b3;
        int b4;
        int i2;
        int b5;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, themeElement, themeElement2, themeElement3)) == null) {
            if (themeElement == null) {
                b2 = b.b("#2BB8FF");
                b3 = b.b("#2BB8FF");
            } else {
                b2 = b.b(themeElement.common_color);
                b3 = b.b(themeElement.common_color);
            }
            if (themeElement2 == null) {
                i2 = b.b("#249BD6");
                b4 = b.b("#246CD6");
            } else {
                int b6 = b.b(themeElement2.common_color);
                b4 = b.b(themeElement2.common_color);
                i2 = b6;
            }
            if (themeElement3 == null) {
                i3 = b.b("#249BD6");
                b5 = b.b("#246CD6");
            } else {
                int b7 = b.b(themeElement3.common_color);
                b5 = b.b(themeElement3.common_color);
                i3 = b7;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(b2));
            arrayList.add(Integer.valueOf(b3));
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(b4));
            arrayList.add(Integer.valueOf(i3));
            arrayList.add(Integer.valueOf(b5));
            return arrayList;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public static List<String> getTagList(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split("-")) {
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void openNativeAddFriend(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(TbadkCoreApplication.getInst().getContext(), (String) map.get("uid"), (String) map.get("uName"), (String) map.get("portrait"), null, false, null)));
        }
    }

    public static void openNativeAlaPersonalVC(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(context, (String) map.get("kUid"), (String) map.get(TbEnum.SystemMessage.KEY_USER_NAME), (String) map.get("portrait"), c.a.e.e.m.b.e((String) map.get("sex"), 0), true)));
        }
    }

    public static void openNativeAlaVideoPlayer(Context context, Map<String, Object> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, map) == null) || map == null) {
            return;
        }
        if (map.containsKey("yyScheme")) {
            str = (String) map.get("yyScheme");
            str2 = (String) map.get("yySource");
        } else {
            str = null;
            str2 = null;
        }
        if (!k.isEmpty(str)) {
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity();
            if (tbPageContextSupport == null || tbPageContextSupport.getPageContext() == null) {
                return;
            }
            if (!k.isEmpty(str2)) {
                str = str + "&source=" + str2;
            }
            UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{str});
            return;
        }
        if (map.containsKey("sid") && map.containsKey("ssid") && map.containsKey("templateId")) {
            String str6 = (String) map.get("sid");
            str4 = (String) map.get("ssid");
            str5 = (String) map.get("templateId");
            str2 = (String) map.get("source");
            str3 = str6;
        } else {
            str3 = null;
            str4 = null;
            str5 = null;
        }
        if (!k.isEmpty(str3) && !k.isEmpty(str4)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = YYLiveUtil.SOURCE_PERSON_AUTHOR_HEAD;
            }
            YYLiveUtil.jumpToYYLiveRoom(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), str3, str4, str5, "", str2);
            return;
        }
        long g2 = c.a.e.e.m.b.g((String) map.get("liveId"), 0L);
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = g2;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
    }

    public static void openNativeAlbumFloatActivity(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, map) == null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(context, "", true, true);
            albumFloatActivityConfig.getIntent().putExtra("from", "main_tab");
            albumFloatActivityConfig.getIntent().putExtra("write_title", "");
            albumFloatActivityConfig.setRequestCode(12002);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(true);
            albumFloatActivityConfig.setCanSelectOnlyVideo(true);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("2");
            if (requestWriteExternalStoragePermission(TbadkCoreApplication.getInst().getCurrentActivity(), albumFloatActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public static void openNativeAvatarPendantPage(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(context)));
        }
    }

    public static void openNativeBBASMHistory(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SmartAppBrowseHistoryActivityConfig(context)));
        }
    }

    public static void openNativeBarBroadcastHistoryPage(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumBroadCastMajorHistoryActivityConfig(context, (String) map.get(TbTitleActivityConfig.FORUM_ID), (String) map.get("forumName"), (String) map.get("from"))));
        }
    }

    public static void openNativeBarOrgMember(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, map) == null) {
            String str = (String) map.get(TbTitleActivityConfig.FORUM_ID);
            String str2 = (String) map.get("forumName");
            if (k.isEmpty(str)) {
                BdLog.e("openPageByUrl param is empty.");
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(context, str, str2)));
            }
        }
    }

    public static void openNativeBigImagePage(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, map) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                l.M(context, "大图功能安装失败,请稍候重试");
                return;
            }
            ArrayList<String> arrayList = (ArrayList) map.get("urls");
            if (arrayList == null) {
                return;
            }
            String str = (arrayList == null || arrayList.size() <= 0) ? "" : arrayList.get(arrayList.size() - 1);
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(arrayList);
            bVar.B(((Integer) map.get("index")).intValue());
            bVar.z((String) map.get("forum_name"));
            bVar.y((String) map.get("forum_id"));
            bVar.O((String) map.get("thread_id"));
            bVar.C(true);
            bVar.J(str);
            bVar.F(true);
            bVar.H(true);
            ImageViewerConfig v = bVar.v(context);
            v.getIntent().putExtra(ImageViewerConfig.IS_SHOW_HOST, false);
            v.getIntent().putExtra("from", "index");
            if (map.containsKey("enter_type")) {
                TbPageExtraHelper.w((String) map.get("enter_type"));
                h.i(new PrePageKeyEvent(TbPageExtraHelper.m()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        }
    }

    public static void openNativeBlockedFans(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(context)));
        }
    }

    public static void openNativeBuyTBean(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, map) == null) {
            CurrencyJumpHelper.openNativeBuyTBean(context, map);
        }
    }

    public static void openNativeCreateForumPage(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, map) == null) {
            try {
                if (TbadkApplication.getInst().getCurrentActivity() != null) {
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
                }
            } catch (Exception e2) {
                BdLog.e("openPageByUrl fail:" + e2.toString());
            }
        }
    }

    public static void openNativeCustomVideo(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, map) == null) {
            String str = (String) map.get("videoUrl");
            SimpleVideoPlayActivityConfig.b bVar = new SimpleVideoPlayActivityConfig.b();
            bVar.d(str);
            bVar.e(str);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar.c(context)));
        }
    }

    public static void openNativeDynamicBaOrg(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, map) == null) {
            String str = (String) map.get(TbTitleActivityConfig.FORUM_ID);
            String str2 = (String) map.get("forumName");
            String str3 = (String) map.get("from");
            String str4 = (String) map.get(FrsActivityConfig.FRS_CALL_FROM);
            String str5 = (String) map.get("fakeThreadId");
            String str6 = (String) map.get("barImageFrame");
            String str7 = (String) map.get("barNameFrame");
            String str8 = (String) map.get("info_forum_image_url");
            String str9 = (String) map.get(FrsActivityConfig.FRS_CALL_FROM_BY_ITEM_POSITION);
            int intValue = map.containsKey("transition_type") ? ((Integer) map.get("transition_type")).intValue() : 0;
            String str10 = (String) map.get("item");
            if (k.isEmpty(str2)) {
                BdLog.e("openPageByUrl param is empty.");
                return;
            }
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(context).createNormalCfg(str2, str3);
            if (!k.isEmpty(str4)) {
                createNormalCfg.setCallFrom(c.a.e.e.m.b.e(str4, 0));
            }
            long g2 = c.a.e.e.m.b.g(str5, 0L);
            if (g2 > 0) {
                createNormalCfg.setFakeThreadId(g2);
            }
            if (!k.isEmpty(str9)) {
                createNormalCfg.setFrsCallFromByItemPosition(Integer.parseInt(str9));
            }
            Rect parseFrameInfo = parseFrameInfo(str6);
            Rect parseFrameInfo2 = parseFrameInfo(str7);
            createNormalCfg.getIntent().putExtra("info_forum_image_rect", parseFrameInfo);
            createNormalCfg.getIntent().putExtra("info_forum_name_rect", parseFrameInfo2);
            createNormalCfg.getIntent().putExtra("transition_type", intValue);
            createNormalCfg.getIntent().putExtra("info_forum_image_url", str8);
            createNormalCfg.getIntent().putExtra("info_forum_name_text", str2);
            if (str10 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str10);
                    createNormalCfg.getIntent().putExtra("info_forum_image_url", (String) jSONObject.get("avatar"));
                    String string = jSONObject.getString(FrsCommonTabFragment.THEME_COLOR);
                    if (!TextUtils.isEmpty(string)) {
                        ThemeColorInfo themeColorInfo = (ThemeColorInfo) new Gson().fromJson(string, (Class<Object>) ThemeColorInfo.class);
                        createNormalCfg.getIntent().putExtra("info_forum_head_background_color", getGradientColor(themeColorInfo.day, themeColorInfo.night, themeColorInfo.dark));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (map.containsKey(FrsActivityConfig.FRS_CALL_FROM)) {
                TbPageExtraHelper.w((String) map.get(FrsActivityConfig.FRS_CALL_FROM));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        }
    }

    public static void openNativeEditProfile(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, map) == null) {
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
            personChangeData.setSex(c.a.e.e.m.b.e((String) map.get("sex"), 0));
            personChangeData.setIntro((String) map.get("intro"));
            personChangeData.setForumAge((String) map.get("TBAge"));
            personChangeData.setAlaId(c.a.e.e.m.b.g((String) map.get("alaID"), 0L));
            personChangeData.setNickNameLeftDays(c.a.e.e.m.b.e((String) map.get("leftDays"), 0));
            personChangeData.setUserAge(c.a.e.e.m.b.e((String) map.get("age"), 0));
            personChangeData.setBirthdayTime(c.a.e.e.m.b.g((String) map.get("birthdayTime"), 0L));
            personChangeData.setBirthdayShowStatus(c.a.e.e.m.b.e((String) map.get("birthdayShowStatus"), 0));
            personChangeData.setTiebaId((String) map.get("tiebaId"));
            personChangeData.setIsBusinessAccount((String) map.get("isBusinessAccount"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(context, 101, personChangeData, Boolean.FALSE)));
        }
    }

    public static void openNativeEmojiCenter(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, context, map) == null) {
            String str = (String) map.get("url");
            if (k.isEmpty(str)) {
                BdLog.e("openPageByUrl param is empty.");
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(context, str)));
            }
        }
    }

    public static void openNativeEvaluationPage(Context context, Map<String, Object> map) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, null, context, map) == null) && ViewHelper.checkUpIsLogin(context)) {
            double parseDouble = Double.parseDouble(String.valueOf(map.get("iconSize")));
            String str = (String) map.get("iconUrl");
            int parseInt = Integer.parseInt(String.valueOf(map.get("id")));
            int parseInt2 = Integer.parseInt(String.valueOf(map.get("isSchool")));
            String str2 = (String) map.get("name");
            String str3 = (String) map.get(CommandMessage.TYPE_TAGS);
            int e2 = c.a.e.e.m.b.e(String.valueOf(map.get("commentStar")), 0);
            String valueOf = String.valueOf(map.get("pointNum"));
            double c2 = TextUtils.isEmpty(valueOf) ? 0.0d : c.a.e.e.m.b.c(valueOf, 0.0d);
            if (WriteActivityConfig.isAsyncWriting() || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
                return;
            }
            SerializableItemInfo serializableItemInfo = new SerializableItemInfo();
            serializableItemInfo.setId(Integer.valueOf(parseInt));
            serializableItemInfo.setIcon_url(str);
            serializableItemInfo.setName(str2);
            serializableItemInfo.setTags(getTagList(str3));
            serializableItemInfo.setIconSize(parseDouble);
            serializableItemInfo.setAverageScore(c2);
            WriteActivityConfig.newInstance(currentActivity).setType(9).setScoreItemInfo(serializableItemInfo).setItemIsSchool(parseInt2 == 1).setStarCount(e2).setIsEvaluate(true).setIsItemDetail(true).setCallFrom("2").setFrom("main_tab").send();
        }
    }

    public static void openNativeFans(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, context, map) == null) {
            String str = (String) map.get("userId");
            String str2 = (String) map.get("userSex");
            int intValue = ((Integer) map.get("type")).intValue();
            String str3 = (String) map.get("ShowNaviBar");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(TbadkCoreApplication.getInst().getContext(), intValue == 1, str, c.a.e.e.m.b.e(str2, 0))));
        }
    }

    public static void openNativeFavoriteBars(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(context, c.a.e.e.m.b.e((String) map.get("forumNum"), 0), (String) map.get("uid"), c.a.e.e.m.b.e((String) map.get("sex"), 0))));
        }
    }

    public static void openNativeFollowedUsers(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(context, "1".equals((String) map.get("type")), (String) map.get("uid"), c.a.e.e.m.b.e((String) map.get("sex"), 0)).updateFollowNum(c.a.e.e.m.b.e((String) map.get("concerNum"), 0), (String) map.get("portrait"))));
        }
    }

    public static void openNativeForumGroup(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, context, map) == null) {
            String str = (String) map.get("barID");
            if (k.isEmpty(str)) {
                BdLog.e("openPageByUrl param is empty.");
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGroupActivityConfig(context, str, "")));
            }
        }
    }

    public static void openNativeFrsManagerElectionVC(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, context, map) == null) {
            long e2 = c.a.e.e.m.b.e((String) map.get(TbTitleActivityConfig.FORUM_ID), 0);
            int e3 = c.a.e.e.m.b.e((String) map.get("electionEnterType"), 0);
            if (e2 != 0 && e3 != 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(context).createNormalConfig(e2, e3)));
            } else {
                BdLog.e("openPageByUrl param is empty.");
            }
        }
    }

    public static void openNativeGiftTabPage(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, context, map) == null) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), c.a.e.e.m.b.g((String) map.get("id"), 0L), (String) map.get("name"), (String) map.get("nameShow"), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
        }
    }

    public static void openNativeGroupList(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, context, map) == null) {
            String str = (String) map.get("uid");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(context, c.a.e.e.m.b.e((String) map.get("sex"), 0), 0, 1)));
        }
    }

    public static void openNativeHotTopicList(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65563, null, context, map) == null) || TbadkApplication.getInst().getCurrentActivity() == null || c.a.q0.t0.b.b(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext())) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(context).createNormalConfig("hottopic", "all")));
    }

    public static void openNativeHotTopicTrendDetail(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, context, map) == null) {
            long g2 = c.a.e.e.m.b.g((String) map.get("hotTopicID"), 0L);
            if (g2 > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(context, g2)));
            }
        }
    }

    public static void openNativeMemberStore(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, context, map) == null) {
            String str = (String) map.get("stParam");
            int e2 = c.a.e.e.m.b.e((String) map.get("enterType"), 0);
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(context, c.a.e.e.m.b.e((String) map.get("memberType"), 0), (String) map.get("stType"), e2);
            memberPayActivityConfig.setSceneId((String) map.get("sceneId"));
            memberPayActivityConfig.setClose("1".equals((String) map.get(IntentConfig.CLOSE)));
            memberPayActivityConfig.setReferPageClickZone((String) map.get("referPage"), (String) map.get("clickZone"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    public static void openNativeMyCollection(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65566, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(context)));
        }
    }

    public static void openNativeMyPostAndReply(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, context, map) == null) {
            String str = (String) map.get(TbEnum.SystemMessage.KEY_USER_NAME);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(context, (String) map.get("userID"), c.a.e.e.m.b.e((String) map.get("sex"), 0), (String) map.get("portrait"))));
        }
    }

    public static void openNativeOfficalBarChat(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(TbadkCoreApplication.getInst().getContext(), c.a.e.e.m.b.g((String) map.get(TbTitleActivityConfig.FORUM_ID), 0L), (String) map.get("forumName"), (String) map.get("imageUrl"), 0)));
        }
    }

    public static void openNativeOfficialForumHistory(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, null, context, map) == null) {
            int e2 = c.a.e.e.m.b.e((String) map.get(TbTitleActivityConfig.FORUM_ID), 0);
            if (e2 == 0) {
                BdLog.e("openPageByUrl param is empty.");
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(context, e2)));
            }
        }
    }

    public static void openNativePASSLoginVC(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, null, context, map) == null) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(TbadkCoreApplication.getInst().getContext(), true)));
        }
    }

    public static void openNativePageKeyBarownerSettingPage(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65571, null, context, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(context);
        privacyMarkActivityConfig.setMarkState(c.a.e.e.m.b.e((String) map.get(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE), 0), c.a.e.e.m.b.e((String) map.get(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE), 0));
        privacyMarkActivityConfig.start();
    }

    public static void openNativePageKeyForumSquare(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65572, null, context, map) == null) {
            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(context, (String) map.get("feildName"));
            forumSquareActivityConfig.showCreateBar("1".equals((String) map.get("showCreateBar")) ? 1 : 0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
        }
    }

    public static void openNativePageKeyHotUserRank(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65573, null, context, map) == null) {
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(context);
            hotUserRankActivityConfig.setCategory((String) map.get("moduleName"));
            hotUserRankActivityConfig.setIsGod("1".equals((String) map.get("isGod")));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
        }
    }

    public static void openNativePageKeySendThreadPage(Context context, Map<String, Object> map) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65574, null, context, map) == null) || !ViewHelper.checkUpIsLogin(context) || WriteActivityConfig.isAsyncWriting() || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        WriteActivityConfig.newInstance(currentActivity).setCallFrom("2").setType(9).setFrom("main_tab").send();
    }

    public static void openNativePersonChat(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(TbadkCoreApplication.getInst().getContext(), Long.parseLong((String) map.get("userId")), (String) map.get(TbEnum.SystemMessage.KEY_USER_NAME), (String) map.get("nameShow"), (String) map.get("portrait"), c.a.e.e.m.b.e((String) map.get("sex"), 0), c.a.e.e.m.b.e((String) map.get("isFriend"), 0), c.a.e.e.m.b.e((String) map.get("userType"), 0))));
        }
    }

    public static void openNativePersonMore(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65576, null, context, map) == null) {
            ArrayList arrayList = (ArrayList) map.get(SwanAppRelatedSwanListAdapter.PAGE_ABOUT_MORE_RELATED_SWAN);
            try {
                PersonMoreData personMoreData = new PersonMoreData();
                List<PersonMoreItemData> list = personMoreData.mUrlMaps;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    HashMap hashMap = (HashMap) arrayList.get(i2);
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = c.a.e.e.m.b.e((String) hashMap.get("id"), 0);
                    personMoreItemData.mName = (String) hashMap.get("name");
                    personMoreItemData.mUrl = (String) hashMap.get("url");
                    list.add(personMoreItemData);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(context, OrmObject.bundleWithObject(personMoreData))));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void openNativePersonal(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65577, null, context, map) == null) {
            String str = (String) map.get("uid");
            if (k.isEmpty(str)) {
                BdLog.e("openPageByUrl param is empty.");
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, str, "")));
            }
        }
    }

    public static void openNativePrivateSettingPage(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65578, null, context, map) == null) {
            if (TbadkCoreApplication.getInst().appResponseToCmd(2015007)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015007, new IntentConfig(context)));
            } else {
                BdLog.e("个人隐私插件未安装");
            }
        }
    }

    public static void openNativeQRCodeScanner(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65579, null, context, map) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.setOnPermissionsGrantedListener(new PermissionJudgePolicy.OnPermissionsGrantedListener(context) { // from class: com.baidu.tieba.flutter.base.util.OpenNative.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
                public void onPermissionsGranted() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(this.val$context)));
                    }
                }
            });
            permissionJudgePolicy.startRequestPermission(TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }

    public static void openNativeRedPacketPersonalCenter(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65580, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyRedPacketActivityConfig(context)));
        }
    }

    public static void openNativeSentGiftList(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65581, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(context, (String) map.get("uid"), (String) map.get(TbEnum.SystemMessage.KEY_USER_NAME), (String) map.get("nameShow"), c.a.e.e.m.b.e((String) map.get("sex"), 0), "iowner_gift")));
        }
    }

    public static void openNativeSetting(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65582, null, context, map) == null) {
            if (TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(context)));
            } else {
                BdLog.e("设置插件未安装");
            }
        }
    }

    public static void openNativeSquare(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65583, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(context)));
        }
    }

    public static void openNativeSubscribeOrDownloadManagerPage(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65584, null, context, map) == null) {
            String simpleName = ((Activity) context).getClass().getSimpleName();
            if ("FlutterPageActivity".equals(simpleName)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(context, 2)));
            } else if ("MainTabActivity".equals(simpleName)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(context, 1)));
            }
        }
    }

    public static void openNativeThemeCenter(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65585, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(context)));
        }
    }

    public static void openNativeTreasureTroveMorePage(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65586, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LowFlowsActivityConfig(context, (String) map.get("tab_code"), (String) map.get(LowFlowsActivityConfig.LF_USER), (String) map.get(LowFlowsActivityConfig.LF_USER_TASKID))));
        }
    }

    public static void openNativeUserHotHeadPage(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65587, null, context, map) == null) {
            ChangeSystemPhotoActivityConfig changeSystemPhotoActivityConfig = new ChangeSystemPhotoActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), 12014, true);
            changeSystemPhotoActivityConfig.getIntent().putExtra("from", "flutter");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, changeSystemPhotoActivityConfig));
        }
    }

    public static void openNativeUserProfileBackground(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65588, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(context)));
        }
    }

    public static void openNativeVideoMiddleFromPersonalPage(@NonNull Context context, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65589, null, context, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams = (VideoRecommentPlayActivityConfig.PersonalPageParams) DataExt.b(map, VideoRecommentPlayActivityConfig.PersonalPageParams.class);
        if (personalPageParams.getDataList() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < personalPageParams.getDataList().size(); i3++) {
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithFlutterMap(personalPageParams.getDataList().get(i3));
            arrayList.add(videoItemData);
            if (TextUtils.equals(personalPageParams.getThreadId(), videoItemData.getThreadId())) {
                i2 = i3;
            }
        }
        VideoPlayActivityConfig.bigDataList = arrayList;
        VideoRecommentPlayActivityConfig.bigPersonalPageParams = personalPageParams;
        new VideoRecommentPlayActivityConfig(context, i2, VideoRecommentPlayActivityConfig.FROM_PERSONAL_PAGE).start();
    }

    public static void openNativeVideoMiddleFromVideoHotTopic(@NonNull Context context, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65590, null, context, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        VideoHotTopicParams videoHotTopicParams = (VideoHotTopicParams) DataExt.b(map, VideoHotTopicParams.class);
        if (videoHotTopicParams.getDataList() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < videoHotTopicParams.getDataList().size(); i3++) {
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithFlutterMap(videoHotTopicParams.getDataList().get(i3));
            arrayList.add(videoItemData);
            if (TextUtils.equals(videoHotTopicParams.getThreadId(), videoItemData.getThreadId())) {
                i2 = i3;
            }
        }
        VideoPlayActivityConfig.bigDataList = arrayList;
        VideoRecommentPlayActivityConfig.bigVideoHotTopicParams = videoHotTopicParams;
        new VideoRecommentPlayActivityConfig(context, i2, VideoRecommentPlayActivityConfig.FROM_VIDEO_HOT_TOPIC).start();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v3, resolved type: com.baidu.tbadk.core.atomData.VideoPlayActivityConfig */
    /* JADX WARN: Multi-variable type inference failed */
    public static void openNativeVideoMiddlePage(Context context, Map<String, Object> map) {
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65591, null, context, map) == null) || map == null || map.isEmpty() || !(map.get(WriteActivityConfig.VIDEO_INFO) instanceof HashMap)) {
            return;
        }
        boolean equals = "1".equals(((HashMap) map.get(WriteActivityConfig.VIDEO_INFO)).get(TiebaStatic.Params.IS_VERTICAL));
        String str = (String) map.get("from");
        String str2 = (String) map.get("stType");
        if (equals) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithFlutterMap(map);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, arrayList, 0, null, "from_nani_video", str2, "", str, str);
            BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
            videoMiddlePageActivityConfig = videoPlayActivityConfig;
            if (baijiahaoData != null) {
                videoPlayActivityConfig.setNid(baijiahaoData.oriUgcNid);
                videoMiddlePageActivityConfig = videoPlayActivityConfig;
            }
        } else {
            String str3 = (String) map.get("tid");
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromFlutterDataMap(map);
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig2 = new VideoMiddlePageActivityConfig(context, str, str3, str2, "", videoSerializeVideoThreadInfo);
            videoMiddlePageActivityConfig = videoMiddlePageActivityConfig2;
            if (videoSerializeVideoThreadInfo.getBaijiahaoData() != null) {
                videoMiddlePageActivityConfig2.setNid(videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcNid);
                videoMiddlePageActivityConfig = videoMiddlePageActivityConfig2;
            }
        }
        if (map.containsKey("from")) {
            TbPageExtraHelper.w((String) map.get("from"));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
    }

    public static void openNativeViewHistory(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65592, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(context)));
        }
    }

    public static void openNativeVipCenterWKWebView(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65593, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(context)));
        }
    }

    public static void openNativeVitalityPB(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65594, null, context, map) == null) {
            String str = (String) map.get("tid");
            int e2 = c.a.e.e.m.b.e((String) map.get("threadType"), 0);
            if (k.isEmpty(str)) {
                BdLog.e("openPageByUrl param is empty.");
                return;
            }
            String valueOf = String.valueOf(map.get("st_type"));
            if (map.containsKey("flutter_from")) {
                valueOf = String.valueOf(map.get("flutter_from"));
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(context);
            pbActivityConfig.createNormalCfg(str, (String) null, e2, valueOf);
            if (map.containsKey(TbTitleActivityConfig.FORUM_ID)) {
                pbActivityConfig.setForumId(String.valueOf(map.get(TbTitleActivityConfig.FORUM_ID)));
            }
            if (map.containsKey("nid")) {
                pbActivityConfig.setBjhData(String.valueOf(map.get("nid")), String.valueOf(map.get("tid")), String.valueOf(map.get("type")), String.valueOf(map.get(TiebaStatic.Params.VID)));
            }
            if (map.containsKey("from_comment") && "1".equals(String.valueOf(map.get("from_comment")))) {
                pbActivityConfig.setJumpToCommentArea(true);
            }
            if (map.containsKey("unKnowPbType")) {
                pbActivityConfig.setUnKnowPbType((String) map.get("unKnowPbType"));
            }
            if (map.containsKey("enter_type")) {
                String str2 = (String) map.get("enter_type");
                TbPageExtraHelper.w(str2);
                if (TbPageExtraHelper.p(str2)) {
                    pbActivityConfig.setStartFrom(4);
                }
            }
            if (map.containsKey("is_remain")) {
                pbActivityConfig.setIsPrivacy(!"0".equals((String) map.get("is_remain")));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    public static void openNativeWKWebView(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65595, null, context, map) == null) {
            String str = (String) map.get("title");
            String str2 = (String) map.get("url");
            if (k.isEmpty(str2)) {
                BdLog.e("openNativeWKWebView param is empty.");
            } else {
                a.w(true, context, str, str2);
            }
        }
    }

    public static void openNativeWallet(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65596, null, context, map) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
        }
    }

    public static void openNativeWebView(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65597, null, context, map) == null) {
            String str = (String) map.get("url");
            if (k.isEmpty(str)) {
                BdLog.e("openPageByUrl param is empty.");
                return;
            }
            try {
                if (TbadkApplication.getInst().getCurrentActivity() != null) {
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{str});
                }
            } catch (Exception e2) {
                BdLog.e("openPageByUrl fail:" + e2.toString());
            }
        }
    }

    public static void openNativeWebViewWithTitle(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65598, null, context, map) == null) {
            String str = (String) map.get("title");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(TbadkCoreApplication.getInst().getContext(), str, (String) map.get("url"), true)));
        }
    }

    public static void openNativefourmBigImagePage(Context context, Map<String, Object> map) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65599, null, context, map) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                l.M(context, "大图功能安装失败,请稍候重试");
                return;
            }
            ArrayList<String> arrayList = (ArrayList) map.get("urls");
            ArrayList arrayList2 = (ArrayList) map.get("originPicUrls");
            if (arrayList == null) {
                return;
            }
            String str2 = (arrayList == null || arrayList.size() <= 0) ? "" : arrayList.get(arrayList.size() - 1);
            String str3 = (String) map.get("forum_id");
            String str4 = (String) map.get("forum_name");
            String str5 = (String) map.get("thread_id");
            String str6 = (String) map.get("post_id");
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            int i2 = 0;
            while (i2 < arrayList.size()) {
                if (TextUtils.isEmpty(arrayList.get(i2))) {
                    str = str2;
                } else {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = 13;
                    imageUrlData.imageUrl = arrayList.get(i2);
                    str = str2;
                    imageUrlData.threadId = c.a.e.e.m.b.g(str5, -1L);
                    imageUrlData.postId = c.a.e.e.m.b.g(str6, -1L);
                    imageUrlData.originalUrl = (String) ListUtils.getItem(arrayList2, i2);
                    concurrentHashMap.put(arrayList.get(i2), imageUrlData);
                }
                i2++;
                str2 = str;
            }
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(arrayList);
            bVar.B(((Integer) map.get("index")).intValue());
            bVar.z(str4);
            bVar.y(str3);
            bVar.O(str5);
            bVar.C(true);
            bVar.J(str2);
            bVar.F(true);
            bVar.w(concurrentHashMap);
            bVar.H(true);
            ImageViewerConfig v = bVar.v(context);
            v.getIntent().putExtra(ImageViewerConfig.IS_SHOW_HOST, true);
            if (map.get("from") != null && (map.get("from") instanceof String)) {
                v.getIntent().putExtra("from", (String) map.get("from"));
            } else {
                v.getIntent().putExtra("from", "index");
            }
            if (map.containsKey("enter_type")) {
                TbPageExtraHelper.w((String) map.get("enter_type"));
                h.i(new PrePageKeyEvent(TbPageExtraHelper.m()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        }
    }

    public static Rect parseFrameInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, str)) == null) {
            Rect rect = new Rect();
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                if (split.length >= 2) {
                    rect.left = (int) (c.a.e.e.m.b.c(split[0], 0.0d) * 2.6d);
                    rect.top = (int) (c.a.e.e.m.b.c(split[1], 0.0d) * 2.6d);
                }
            }
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static boolean requestWriteExternalStoragePermission(Activity activity, IntentConfig intentConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65601, null, activity, intentConfig)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.setOnPermissionsGrantedListener(new PermissionJudgePolicy.OnPermissionsGrantedListener(intentConfig) { // from class: com.baidu.tieba.flutter.base.util.OpenNative.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IntentConfig val$config;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {intentConfig};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$config = intentConfig;
                }

                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
                public void onPermissionsGranted() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.val$config));
                    }
                }
            });
            return permissionJudgePolicy.startRequestPermission(activity);
        }
        return invokeLL.booleanValue;
    }

    public static boolean toNativePage(Context context, String str, Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65602, null, context, str, map)) == null) {
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
                String str2 = (String) map.get("enter_type");
                if (TextUtils.equals(str2, "12")) {
                    openNativeVideoMiddleFromPersonalPage(context, map);
                    return true;
                } else if (TextUtils.equals(str2, "13")) {
                    openNativeVideoMiddleFromVideoHotTopic(context, map);
                    return true;
                } else {
                    openNativeVideoMiddlePage(context, map);
                    return true;
                }
            } else if (kNativePageKeyTreasureTroveMore.equals(str)) {
                openNativeTreasureTroveMorePage(context, map);
                return true;
            } else if (kNativePageKeyPrivateSetting.equals(str)) {
                openNativePrivateSettingPage(context, map);
                return true;
            } else if (kNativePageKeyAlbumFloat.equals(str)) {
                openNativeAlbumFloatActivity(context, map);
                return true;
            } else if (kNativePageKeySubscribeOrDownloadManager.equals(str)) {
                openNativeSubscribeOrDownloadManagerPage(context, map);
                return true;
            } else if (kNativePageKeyBarownerSetting.equals(str)) {
                openNativePageKeyBarownerSettingPage(context, map);
                return true;
            } else {
                if (BdBaseApplication.getInst().isDebugMode()) {
                    TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                    UtilHelper.showToast(inst, "打开页面找不到:" + str);
                }
                BdLog.e("flutter open page id not found :" + str + " " + map);
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }
}
