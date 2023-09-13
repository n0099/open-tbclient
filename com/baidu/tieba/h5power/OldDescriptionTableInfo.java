package com.baidu.tieba.h5power;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.LinkedHashSet;
/* loaded from: classes6.dex */
public class OldDescriptionTableInfo {
    public static /* synthetic */ Interceptable $ic;
    public static String mDescriptionTable;
    public static HashSet<String> mModuleSet;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-227673319, "Lcom/baidu/tieba/h5power/OldDescriptionTableInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-227673319, "Lcom/baidu/tieba/h5power/OldDescriptionTableInfo;");
                return;
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        mModuleSet = linkedHashSet;
        linkedHashSet.add("host");
        mModuleSet.add(Config.DEVICE_PART);
        mModuleSet.add("account");
        mModuleSet.add(DI.ROUTER_NAME);
        mModuleSet.add("toast");
        mModuleSet.add(IMConstants.SERVICE_TYPE_SUBSCRIPTION);
        mModuleSet.add("system");
        mModuleSet.add("payment");
        mModuleSet.add("yabment");
        mModuleSet.add(LocalFilesFilterKt.FILTER_NAME_LOG);
        mModuleSet.add("share");
        mModuleSet.add("clipper");
        mModuleSet.add("activity");
        mModuleSet.add("navigationBar");
        mModuleSet.add("hybridDebug");
        mModuleSet.add("hybrid");
        mDescriptionTable = "[{\"name\":\"account.DownloadSkinCSS\",\"scheme\":\"tiebaapp\",\"path\":\"account/startDownloadCss\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"downloadUrl\",\"value\":\"string\"}]},{\"name\":\"account.aliAuthResult\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"aliAuthResult\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.34\"},{\"name\":\"account.authState\",\"scheme\":\"tiebaapp\",\"path\":\"account/authState\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"scene\",\"value\":\"string\"}],\"version\":\"12.42.5\"},{\"name\":\"account.bindMobileNumber\",\"scheme\":\"tiebaapp\",\"path\":\"account/bindMobileNumber\",\"invoke\":\"prompt.scheme\"},{\"name\":\"account.commonLogin\",\"scheme\":\"tiebaapp\",\"path\":\"account/commonLogin\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"type\",\"value\":\"string=\"},{\"name\":\"addObserverNotify\",\"value\":\"string=\"},{\"name\":\"activityId\",\"value\":\"string=\"},{\"name\":\"cssUrl\",\"value\":\"string=\"}],\"version\":\"12.39.0\"},{\"name\":\"account.getAlipayUserId\",\"scheme\":\"tiebaapp\",\"path\":\"account/getAlipayUserId\",\"invoke\":\"prompt.scheme\",\"version\":\"12.34\"},{\"name\":\"account.login\",\"scheme\":\"tiebaapp\",\"path\":\"account/startLoginModule\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"cssUrl\",\"value\":\"string=\"}]},{\"name\":\"account.loginResult\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"loginResultToH5\"},\"invoke\":\"prompt.scheme\"},{\"name\":\"account.openThirdPartyLoginPage\",\"scheme\":\"tiebaapp\",\"path\":\"account/loadThirdPartyLogin\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"socialType\",\"value\":\"number\"},{\"name\":\"activityId\",\"value\":\"string=\"}]},{\"name\":\"account.realNameAuth\",\"scheme\":\"tiebaapp\",\"path\":\"account/realNameAuth\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"scene\",\"value\":\"string\"},{\"name\":\"needCbKey\",\"value\":\"boolean=\"},{\"name\":\"customRealNameUrl\",\"value\":\"string=\"},{\"name\":\"realNameLevel\",\"value\":\"number=\"}],\"version\":\"12.42.5\"},{\"name\":\"account.thirdPartyLoginResult\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"thirdPartyLoginResultToH5\"},\"invoke\":\"prompt.scheme\"},{\"name\":\"activity.completeTask\",\"scheme\":\"tiebaapp\",\"path\":\"activity/completeTask\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"activityId\",\"value\":\"string\"},{\"name\":\"missionId\",\"value\":\"string\"}]},{\"name\":\"activity.goBackFromNative\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"goBackFromNative\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.6\"},{\"name\":\"activity.goBackToH5\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"clickGoBackToH5\"},\"invoke\":\"prompt.scheme\"},{\"name\":\"activity.oneKeyDeletion\",\"scheme\":\"tiebaapp\",\"path\":\"activity/oneKeyDeletion\",\"invoke\":\"prompt.scheme\",\"version\":\"12.34\"},{\"name\":\"activity.personlizedSwitchChange\",\"scheme\":\"tiebaapp\",\"path\":\"activity/personlizedSwitchChange\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"personlizedSwitchStatus\",\"value\":\"string\"}],\"version\":\"12.17\"},{\"name\":\"activity.postFakeTheWall\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"postFakeTheWall\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.25\"},{\"name\":\"activity.submitTestAnswer\",\"scheme\":\"tiebaapp\",\"path\":\"activity/finishTestAnswer\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"testId\",\"value\":\"number\"}]},{\"name\":\"activity.updateSearchForumInfo\",\"scheme\":\"tiebaapp\",\"path\":\"activity/updateSearchForumInfo\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"forumParams\",\"value\":\"string\"}],\"version\":\"12.21\"},{\"name\":\"activity.updateTailStyle\",\"scheme\":\"tiebaapp\",\"path\":\"activity/updateTailStyle\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"type\",\"value\":\"number\"},{\"name\":\"tailId\",\"value\":\"string\"}],\"version\":\"12.31\"},{\"name\":\"activity.worldCupRaiseSuccess\",\"scheme\":\"tiebaapp\",\"path\":\"activity/worldCupRaiseSuccess\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"portrait\",\"value\":\"string\"},{\"name\":\"flagUrl\",\"value\":\"string\"}],\"version\":\"12.32\"},{\"name\":\"activity.writePostSuccess\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"writePostSuccess\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.32.0\"},{\"name\":\"clipper.getClipperInformation\",\"scheme\":\"tiebaapp\",\"path\":\"clipper/getClipperInformation\",\"invoke\":\"prompt.scheme\"},{\"name\":\"clipper.setClipperInformation\",\"scheme\":\"tiebaapp\",\"path\":\"clipper/setClipperInformation\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"txt\",\"value\":\"string\"}]},{\"name\":\"device.deviceMotion\",\"scheme\":\"tiebaapp\",\"path\":\"device/deviceMotion\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"interval\",\"value\":\"string=\"},{\"name\":\"type\",\"value\":\"string\"}],\"version\":\"12.39.0\"},{\"name\":\"device.deviceRefreshRate\",\"scheme\":\"tiebaapp\",\"path\":\"device/deviceRefreshRate\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"type\",\"value\":\"string\"}],\"version\":\"12.39.0\"},{\"name\":\"device.getDeviceInfo\",\"scheme\":\"tiebaapp\",\"path\":\"device/getDeviceInfo\",\"invoke\":\"prompt.scheme\"},{\"name\":\"device.getHdid\",\"scheme\":\"tiebaapp\",\"path\":\"device/getHdid\",\"invoke\":\"prompt.scheme\",\"version\":\"12.9\"},{\"name\":\"device.getSupplementInfo\",\"scheme\":\"tiebaapp\",\"path\":\"device/getSupplementInfo\",\"invoke\":\"prompt.scheme\"},{\"name\":\"device.getZid\",\"scheme\":\"tiebaapp\",\"path\":\"device/getZid\",\"invoke\":\"prompt.scheme\"},{\"name\":\"device.setBlockInfo\",\"scheme\":\"tiebaapp\",\"path\":\"device/setBlockPopInfo\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"canPost\",\"value\":\"number\"},{\"name\":\"blockInfo\",\"value\":\"string\"},{\"name\":\"aheadInfo\",\"value\":\"string\"},{\"name\":\"aheadUrl\",\"value\":\"string\"},{\"name\":\"okInfo\",\"value\":\"string\"},{\"name\":\"aheadType\",\"value\":\"number\"}]},{\"name\":\"host.callNativeSMS\",\"scheme\":\"tiebaapp\",\"path\":\"host/callNativeSMS\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"phoneNumber\",\"value\":\"string\"},{\"name\":\"content\",\"value\":\"string\"}]},{\"name\":\"host.fetchHistoryMsgs\",\"scheme\":\"tiebaapp\",\"path\":\"host/fetchHistoryMsgs\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"count\",\"value\":\"number\"},{\"name\":\"beginMsgId\",\"value\":\"number\"},{\"name\":\"endMsgId\",\"value\":\"number\"},{\"name\":\"chatType\",\"value\":\"string\"},{\"name\":\"chatId\",\"value\":\"string\"}],\"version\":\"12.46.0\"},{\"name\":\"host.novelPayResultToClient\",\"scheme\":\"tiebaapp\",\"path\":\"host/novelPayResultToClient\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"isPaySuccess\",\"value\":\"boolean\"}],\"version\":\"12.25\"},{\"name\":\"host.preheatWeb\",\"scheme\":\"tiebaapp\",\"path\":\"host/preheatWeb\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"urlList\",\"value\":{\"arrayOf\":\"string\"},\"isRequired\":true}],\"version\":\"12.32\"},{\"name\":\"host.preloadPic\",\"scheme\":\"tiebaapp\",\"path\":\"host/preloadPic\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"url\",\"value\":{\"arrayOf\":\"string\"},\"isRequired\":true}],\"version\":\"12.46\"},{\"name\":\"host.receiveNewMsgs\",\"scheme\":\"tiebaapp\",\"path\":\"host/receiveNewMsgs\",\"invoke\":\"prompt.scheme\",\"version\":\"12.46.0\"},{\"name\":\"host.recordNovelInfo\",\"scheme\":\"tiebaapp\",\"path\":\"host/recordNovelInfo\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"bookProgress\",\"value\":\"string\"},{\"name\":\"gid\",\"value\":\"string\"},{\"name\":\"lastReadChapterId\",\"value\":\"string\"},{\"name\":\"lastReadChapterIndex\",\"value\":\"string=\"},{\"name\":\"lastReadChapterName\",\"value\":\"string=\"}],\"version\":\"12.16.5\"},{\"name\":\"host.sendMsg\",\"scheme\":\"tiebaapp\",\"path\":\"host/sendMsg\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"msg\",\"value\":\"string\"},{\"name\":\"chatType\",\"value\":\"string\"},{\"name\":\"chatId\",\"value\":\"string\"}],\"version\":\"12.46.0\"},{\"name\":\"hybrid.deleteAllSearchHistory\",\"scheme\":\"tiebaapp\",\"path\":\"hybrid/deleteAllSearchHistory\",\"invoke\":\"prompt.scheme\"},{\"name\":\"hybrid.deleteSearchHistory\",\"scheme\":\"tiebaapp\",\"path\":\"hybrid/deleteSearchHistory\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"query\",\"value\":\"string\"}]},{\"name\":\"hybrid.getSearchAdCookie\",\"scheme\":\"tiebaapp\",\"path\":\"hybrid/getSearchAdCookie\",\"invoke\":\"prompt.scheme\"},{\"name\":\"hybrid.getSearchHistory\",\"scheme\":\"tiebaapp\",\"path\":\"hybrid/getSearchHistory\",\"invoke\":\"prompt.scheme\"},{\"name\":\"hybrid.nativeNetworkProxy\",\"scheme\":\"tiebaapp\",\"path\":\"hybrid/nativeNetworkProxy\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"path\",\"value\":\"string\"},{\"name\":\"host\",\"value\":\"string\"},{\"name\":\"type\",\"value\":\"string\"},{\"name\":\"data\",\"value\":\"Object\"},{\"name\":\"needBduss\",\"value\":\"number=\"},{\"name\":\"needTbs\",\"value\":\"number=\"}],\"version\":\"12.42.0\"},{\"name\":\"hybrid.openSearchPage\",\"scheme\":\"tiebaapp\",\"path\":\"hybrid/openSearchPage\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"query\",\"value\":\"string\"},{\"name\":\"subType\",\"value\":\"number\"}]},{\"name\":\"hybrid.requestByNative\",\"scheme\":\"tiebaapp\",\"path\":\"hybrid/requestByNativeNew\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"url\",\"value\":\"string\"},{\"name\":\"type\",\"value\":\"string\"},{\"name\":\"module\",\"value\":\"string=\"},{\"name\":\"data\",\"value\":\"Object=\"}],\"version\":\"12.10.0\"},{\"name\":\"hybrid.requestByNative\",\"scheme\":\"tiebaapp\",\"path\":\"hybrid/requestByNativeNew\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"url\",\"value\":\"string\"},{\"name\":\"type\",\"value\":\"string\"},{\"name\":\"module\",\"value\":\"string=\"},{\"name\":\"data\",\"value\":\"Object=\"}],\"version\":\"12.10.0\"},{\"name\":\"hybrid.setSearchHistory\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"setSearchHistory\"},\"invoke\":\"prompt.scheme\"},{\"name\":\"hybridDebug.deleteOfflineBundle\",\"scheme\":\"tiebaapp\",\"path\":\"hybridDebug/deleteOfflineBundle\",\"invoke\":\"prompt.scheme\"},{\"name\":\"hybridDebug.getOfflineUserInfo\",\"scheme\":\"tiebaapp\",\"path\":\"hybridDebug/getOfflineUserInfo\",\"invoke\":\"prompt.scheme\"},{\"name\":\"hybridDebug.switchOfflineBundleStatus\",\"scheme\":\"tiebaapp\",\"path\":\"hybridDebug/switchOfflineBundleStatus\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"isOn\",\"value\":\"number=\"}]},{\"name\":\"hybridDebug.switchOfflineInterface\",\"scheme\":\"tiebaapp\",\"path\":\"hybridDebug/switchOfflineInterface\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"host\",\"value\":\"string=\"}]},{\"name\":\"hybridDebug.switchUrlHost\",\"scheme\":\"tiebaapp\",\"path\":\"hybridDebug/switchUrlHost\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"hostArr\",\"value\":{\"arrayOf\":\"Object\"},\"isRequired\":true}]},{\"name\":\"hybridDebug.updateOfflineBundle\",\"scheme\":\"tiebaapp\",\"path\":\"hybridDebug/updateOfflineBundle\",\"invoke\":\"prompt.scheme\"},{\"name\":\"log.LocalYaLog\",\"scheme\":\"tiebaapp\",\"path\":\"log/LocalYaLog\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"tag\",\"value\":\"string\"},{\"name\":\"logInfo\",\"value\":\"string\"}],\"version\":\"12.44\"},{\"name\":\"log.getPageLeaveTime\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"getPageLeaveTime\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.6.5\"},{\"name\":\"navigationBar.disableGoBack\",\"scheme\":\"tiebaapp\",\"path\":\"navigationBar/isDisableGoBack\",\"invoke\":\"prompt.scheme\"},{\"name\":\"payment.openMXDYab\",\"scheme\":\"tiebaapp\",\"path\":\"payment/openMXDYab\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"parameters\",\"value\":\"string\"}],\"version\":\"12.28.4\"},{\"name\":\"payment.openVipSuccess\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"openVipSuccess\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.31\"},{\"name\":\"router.JumpToVideo\",\"scheme\":\"com.baidu.tieba\",\"path\":\"router/jumpToVideo\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"videoTopic\",\"value\":\"string=\"},{\"name\":\"videoTopicID\",\"value\":\"string=\"},{\"name\":\"isVideo\",\"value\":\"string=\"}],\"version\":\"12.12\"},{\"name\":\"router.closeCurrentPage\",\"scheme\":\"tiebaapp\",\"path\":\"router/finishThisPage\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"nextPage\",\"value\":\"string=\"},{\"name\":\"source\",\"value\":\"string=\"}]},{\"name\":\"router.goToBarDetail\",\"scheme\":\"tiebaapp\",\"path\":\"router/goToBarDetail\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"forumId\",\"value\":\"string\"},{\"name\":\"selectHostTab\",\"value\":\"number=\"}],\"version\":\"12.1\"},{\"name\":\"router.goToEditPost\",\"scheme\":\"tiebaapp\",\"path\":\"router/goToEditPost\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"pos\",\"value\":\"string\"},{\"name\":\"tid\",\"value\":\"string\"},{\"name\":\"floorId\",\"value\":\"string\"},{\"name\":\"postId\",\"value\":\"string\"},{\"name\":\"content\",\"value\":\"string\"},{\"name\":\"fid\",\"value\":\"string\"},{\"name\":\"fname\",\"value\":\"string\"}],\"version\":\"12.2\"},{\"name\":\"router.goToForumRulesEditPage\",\"scheme\":\"tiebaapp\",\"path\":\"router/forumRulesEditPage\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"forum_id\",\"value\":\"string\"},{\"name\":\"forum_name\",\"value\":\"string\"}],\"version\":\"12.25\"},{\"name\":\"router.goToGoodsShop\",\"scheme\":\"tiebaclient\",\"path\":\"tbcsm\",\"invoke\":\"location\",\"args\":[{\"name\":\"uk\",\"value\":\"string\"},{\"name\":\"goods_url\",\"value\":\"string=\"}]},{\"name\":\"router.goToReportThreadPage\",\"scheme\":\"tiebaapp\",\"path\":\"router/goToReportThreadPage\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"portrait\",\"value\":\"string\"},{\"name\":\"threadArray\",\"value\":{\"arrayOf\":\"string\"},\"isRequired\":true}],\"version\":\"12.20\"},{\"name\":\"router.goToSelectPrivateMsgPage\",\"scheme\":\"tiebaapp\",\"path\":\"router/goToSelectPrivateMsgPage\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"portrait\",\"value\":\"string\"},{\"name\":\"msgArray\",\"value\":{\"arrayOf\":\"Object\"},\"isRequired\":true}],\"version\":\"12.20\"},{\"name\":\"router.jumpToNewPage\",\"scheme\":\"tiebaapp\",\"path\":\"router/jumpToHTMLPage\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"url\",\"value\":\"string\"},{\"name\":\"finishThisPage\",\"value\":\"number=\"}]},{\"name\":\"router.openThirdPartyApp\",\"scheme\":\"tiebaapp\",\"path\":\"router/openThirdPartyApp\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"type\",\"value\":\"number\"},{\"name\":\"data\",\"value\":\"string=\"}],\"version\":\"12.30.0\"},{\"name\":\"router.portal\",\"scheme\":\"tiebaapp\",\"path\":\"router/portal\",\"invoke\":\"prompt.scheme\",\"invokeHigher\":\"method.scheme\",\"args\":[{\"name\":\"page\",\"value\":\"string\"},{\"name\":\"refre\",\"value\":\"string=\"},{\"name\":\"pageParams\",\"value\":\"Object=\"}],\"version\":\"12.27\"},{\"name\":\"router.refreshTail\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"refreshTail\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.31\"},{\"name\":\"router.rehide\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"rehide\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.14\"},{\"name\":\"router.replyPost\",\"scheme\":\"tiebaapp\",\"path\":\"router/replyPost\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"tid\",\"value\":\"string\"}],\"version\":\"12.42\"},{\"name\":\"router.reshow\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"reshow\"},\"invoke\":\"prompt.scheme\"},{\"name\":\"router.videoImmersivePage\",\"scheme\":\"tiebaapp\",\"path\":\"router/videoImmersivePage\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"threadId\",\"value\":\"string\"},{\"name\":\"postId\",\"value\":\"string\"},{\"name\":\"title\",\"value\":\"string\"},{\"name\":\"userName\",\"value\":\"string\"},{\"name\":\"nickName\",\"value\":\"string\"},{\"name\":\"portrait\",\"value\":\"string\"},{\"name\":\"thumbnailUrl\",\"value\":\"string\"},{\"name\":\"videoUrl\",\"value\":\"string\"},{\"name\":\"videoWidth\",\"value\":\"string\"},{\"name\":\"videoHeight\",\"value\":\"string\"},{\"name\":\"videoDuration\",\"value\":\"string\"},{\"name\":\"postNum\",\"value\":\"string\"},{\"name\":\"agreeNum\",\"value\":\"string\"},{\"name\":\"isAgreed\",\"value\":\"string=\"},{\"name\":\"shareNum\",\"value\":\"string\"},{\"name\":\"forumId\",\"value\":\"string\"},{\"name\":\"forumName\",\"value\":\"string\"},{\"name\":\"showComment\",\"value\":\"string\"}],\"version\":\"12.13\"},{\"name\":\"share.registerShareData\",\"scheme\":\"tiebaapp\",\"path\":\"share/registerShareDataNew\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"title\",\"value\":\"string=\"},{\"name\":\"desc\",\"value\":\"string=\"},{\"name\":\"img\",\"value\":\"string=\"},{\"name\":\"url\",\"value\":\"string=\"},{\"name\":\"topic\",\"value\":\"string=\"},{\"name\":\"wbtitle\",\"value\":\"string=\"},{\"name\":\"wbcontent\",\"value\":\"string=\"},{\"name\":\"isShowMoreForum\",\"value\":\"string=\"},{\"name\":\"shareimg\",\"value\":\"number=\"},{\"name\":\"extdata\",\"value\":\"string=\"}]},{\"name\":\"share.share\",\"scheme\":\"tiebaapp\",\"path\":\"share/share\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"channel\",\"value\":\"number=\"},{\"name\":\"shareImg\",\"value\":\"number=\"},{\"name\":\"img\",\"value\":\"string=\"},{\"name\":\"isShowMoreForum\",\"value\":\"string=\"},{\"name\":\"url\",\"value\":\"string=\"},{\"name\":\"title\",\"value\":\"string=\"},{\"name\":\"desc\",\"value\":\"string=\"},{\"name\":\"topic\",\"value\":\"string=\"},{\"name\":\"wbtitle\",\"value\":\"string=\"},{\"name\":\"wbcontent\",\"value\":\"string=\"},{\"name\":\"weixinDisable\",\"value\":\"number=\"},{\"name\":\"extData\",\"value\":\"string=\"},{\"name\":\"source\",\"value\":\"number=\"},{\"name\":\"topicId\",\"value\":\"string=\"},{\"name\":\"disableSafari\",\"value\":\"string=\"},{\"name\":\"roomId\",\"value\":\"number=\"},{\"name\":\"filterRooms\",\"value\":\"number=\"},{\"name\":\"roomMemberCount\",\"value\":\"number=\"},{\"name\":\"fid\",\"value\":\"number=\"},{\"name\":\"forumName\",\"value\":\"string=\"},{\"name\":\"onlyThirdShare\",\"value\":\"string=\"},{\"name\":\"addObserverNotify\",\"value\":\"string=\"},{\"name\":\"panelTitle\",\"value\":\"string=\"},{\"name\":\"shareIMCard\",\"value\":\"Object=\"}]},{\"name\":\"share.shareResult\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"ShareSuccessNotification\"},\"invoke\":\"prompt.scheme\"},{\"name\":\"subscription.checkGamePushStatus\",\"scheme\":\"tiebaapp\",\"path\":\"subscription/gamePushStatus\",\"invoke\":\"prompt.scheme\"},{\"name\":\"subscription.getViewPosition\",\"scheme\":\"tiebaapp\",\"path\":\"subscription/getViewPosition\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"viewId\",\"value\":\"string\"},{\"name\":\"data\",\"value\":\"string=\"}],\"version\":\"12.41\"},{\"name\":\"subscription.notifyNativeRefresh\",\"scheme\":\"tiebaapp\",\"path\":\"subscription/notifyNativeRefresh\",\"invoke\":\"prompt.scheme\",\"invokeHigher\":\"method.scheme\",\"args\":[{\"name\":\"key\",\"value\":\"string\"},{\"name\":\"data\",\"value\":\"Object=\"},{\"name\":\"isNotifyH5\",\"value\":\"boolean=\"}],\"version\":\"12.35\"},{\"name\":\"subscription.subscribeGame\",\"scheme\":\"tiebaapp\",\"path\":\"subscription/gamePush\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"gameId\",\"value\":\"string\"},{\"name\":\"gameName\",\"value\":\"string\"},{\"name\":\"gameTime\",\"value\":\"string\"},{\"name\":\"gameType\",\"value\":\"string\"}]},{\"name\":\"system.canOpenApp\",\"scheme\":\"tiebaapp\",\"path\":\"system/checkAppInstall\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"pkgName\",\"value\":\"string\"}]},{\"name\":\"system.changeSkinType\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"changeSkinType\"},\"invoke\":\"prompt.scheme\"},{\"name\":\"system.checkInstallGameApk\",\"scheme\":\"tiebaapp\",\"path\":\"system/checkInstallGameApk\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"pkgName\",\"value\":\"string\"}],\"version\":\"12.31\"},{\"name\":\"system.checkNotificationPermission\",\"scheme\":\"tiebaapp\",\"path\":\"system/hasNotificationPermission\",\"invoke\":\"prompt.scheme\"},{\"name\":\"system.closeNativeMask\",\"scheme\":\"tiebaapp\",\"path\":\"system/closeNativeMask\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"result\",\"value\":\"number=\"}]},{\"name\":\"system.disableSlideBack\",\"scheme\":\"tiebaapp\",\"path\":\"system/disableSlideBack\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"disable\",\"value\":\"number=\"}],\"version\":\"12.2\"},{\"name\":\"system.downloadGameApk\",\"scheme\":\"tiebaapp\",\"path\":\"system/downloadGameApk\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"gameUrl\",\"value\":\"string\"},{\"name\":\"gameId\",\"value\":\"string\"},{\"name\":\"apkName\",\"value\":\"string\"},{\"name\":\"apkIcon\",\"value\":\"string\"},{\"name\":\"forumName\",\"value\":\"string\"},{\"name\":\"apkVersion\",\"value\":\"string\"},{\"name\":\"developerName\",\"value\":\"string\"},{\"name\":\"privacyUrl\",\"value\":\"string\"},{\"name\":\"authorityUrl\",\"value\":\"string\"},{\"name\":\"packageSize\",\"value\":\"string\"},{\"name\":\"versionCode\",\"value\":\"number\"},{\"name\":\"pkgName\",\"value\":\"string\"},{\"name\":\"source\",\"value\":\"number=\"},{\"name\":\"extInfo\",\"value\":\"Object=\"}],\"version\":\"12.31\"},{\"name\":\"system.fileDownloadDelete\",\"scheme\":\"tiebaapp\",\"path\":\"system/fileDownloadDelete\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"fileUrl\",\"value\":\"string\"},{\"name\":\"fileName\",\"value\":\"string\"},{\"name\":\"fileVersion\",\"value\":\"string\"},{\"name\":\"source\",\"value\":\"number=\"},{\"name\":\"extInfo\",\"value\":\"Object=\"}],\"version\":\"12.35\"},{\"name\":\"system.fileDownloadPause\",\"scheme\":\"tiebaapp\",\"path\":\"system/fileDownloadPause\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"fileUrl\",\"value\":\"string\"},{\"name\":\"fileName\",\"value\":\"string\"},{\"name\":\"fileVersion\",\"value\":\"string\"},{\"name\":\"source\",\"value\":\"number=\"},{\"name\":\"extInfo\",\"value\":\"Object=\"}],\"version\":\"12.35\"},{\"name\":\"system.fileDownloadStatusResult\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"fileDownloadStatusResult\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.35\"},{\"name\":\"system.getAppStorage\",\"scheme\":\"tiebaapp\",\"path\":\"system/getAppStorage\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"key\",\"value\":\"string\"}],\"version\":\"12.26\"},{\"name\":\"system.getFileDownloadProgress\",\"scheme\":\"tiebaapp\",\"path\":\"system/getFileDownloadProgress\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"fileName\",\"value\":\"string\"},{\"name\":\"fileVersion\",\"value\":\"string\"},{\"name\":\"extInfo\",\"value\":\"Object=\"}],\"version\":\"12.35\"},{\"name\":\"system.getFileDownloadStatus\",\"scheme\":\"tiebaapp\",\"path\":\"system/getFileDownloadStatus\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"fileName\",\"value\":\"string\"},{\"name\":\"fileVersion\",\"value\":\"string\"},{\"name\":\"extInfo\",\"value\":\"Object=\"}],\"version\":\"12.35\"},{\"name\":\"system.getHistoryForumData\",\"scheme\":\"tiebaapp\",\"path\":\"system/getHistoryForumData\",\"invoke\":\"prompt.scheme\",\"version\":\"12.32\"},{\"name\":\"system.getPhotoAlbum\",\"scheme\":\"tiebaapp\",\"path\":\"system/goToPhotoAlbum\",\"invoke\":\"prompt.scheme\",\"version\":\"12.13\"},{\"name\":\"system.goToNotificationSetting\",\"scheme\":\"tiebaapp\",\"path\":\"system/goToNotificationSetting\",\"invoke\":\"prompt.scheme\"},{\"name\":\"system.installApkResult\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"installApkResult\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.35\"},{\"name\":\"system.installGameApk\",\"scheme\":\"tiebaapp\",\"path\":\"system/installGameApk\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"apkName\",\"value\":\"string\"},{\"name\":\"pkgName\",\"value\":\"string\"},{\"name\":\"apkUrl\",\"value\":\"string=\"},{\"name\":\"apkVersion\",\"value\":\"string\"},{\"name\":\"source\",\"value\":\"number=\"},{\"name\":\"extInfo\",\"value\":\"Object=\"}],\"version\":\"12.35\"},{\"name\":\"system.keyboardHeightChange\",\"scheme\":\"tiebaapp\",\"path\":\"system/keyboardHeightChange\",\"invoke\":\"prompt.scheme\",\"version\":\"12.46\"},{\"name\":\"system.launchApk\",\"scheme\":\"tiebaapp\",\"path\":\"system/launchApk\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"pkgName\",\"value\":\"string\"},{\"name\":\"apkName\",\"value\":\"string\"},{\"name\":\"apkUrl\",\"value\":\"string=\"},{\"name\":\"source\",\"value\":\"number=\"},{\"name\":\"extInfo\",\"value\":\"Object=\"}],\"version\":\"12.35\"},{\"name\":\"system.openApp\",\"scheme\":\"tiebaapp\",\"path\":\"system/startApp\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"pkgName\",\"value\":\"string=\"},{\"name\":\"schema\",\"value\":\"string=\"}]},{\"name\":\"system.orderGameApk\",\"scheme\":\"tiebaapp\",\"path\":\"system/orderGameApk\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"id\",\"value\":\"string\"},{\"name\":\"name\",\"value\":\"string\"}],\"version\":\"12.31\"},{\"name\":\"system.orderGameApkResult\",\"path\":\"notification/addObserver\",\"query\":{\"notificationName\":\"orderGameApkResult\"},\"invoke\":\"prompt.scheme\",\"version\":\"12.31\"},{\"name\":\"system.playSound\",\"scheme\":\"tiebaapp\",\"path\":\"system/playSound\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"soundUrl\",\"value\":\"string\"}]},{\"name\":\"system.playVibrate\",\"scheme\":\"tiebaapp\",\"path\":\"system/playVibrate\",\"invoke\":\"prompt.scheme\"},{\"name\":\"system.putAppStorage\",\"scheme\":\"tiebaapp\",\"path\":\"system/putAppStorage\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"key\",\"value\":\"string\"},{\"name\":\"data\",\"value\":\"string=\"}],\"version\":\"12.26\"},{\"name\":\"system.saveImage\",\"scheme\":\"tiebaapp\",\"path\":\"system/saveImage\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"imgUrl\",\"value\":\"string\"}],\"version\":\"12.1\"},{\"name\":\"system.selectPhotoAlbum\",\"scheme\":\"tiebaapp\",\"path\":\"system/selectPhotoAlbum\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"maxPhotoNum\",\"value\":\"number\"},{\"name\":\"imageArray\",\"value\":{\"arrayOf\":\"Object\"},\"isRequired\":true}],\"version\":\"12.20\"},{\"name\":\"system.startLoadTimeInterval\",\"scheme\":\"tiebaapp\",\"path\":\"system/startLoadTimeInterval\",\"invoke\":\"prompt.scheme\",\"version\":\"12.3\"},{\"name\":\"system.wakeKeyboard\",\"scheme\":\"tiebaapp\",\"path\":\"system/wakeKeyboard\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"postType\",\"value\":\"string=\"},{\"name\":\"showInputContainer\",\"value\":\"boolean=\"},{\"name\":\"showReplyContainer\",\"value\":\"boolean=\"},{\"name\":\"showStarContainer\",\"value\":\"boolean=\"},{\"name\":\"showEmotion\",\"value\":\"boolean=\"},{\"name\":\"showDIYEmotion\",\"value\":\"boolean=\"},{\"name\":\"showAt\",\"value\":\"boolean=\"},{\"name\":\"topViewData\",\"value\":\"Object=\"},{\"name\":\"show\",\"value\":\"boolean=\"}],\"version\":\"12.42\"},{\"name\":\"toast.controlPopupView\",\"scheme\":\"tiebaapp\",\"path\":\"toast/toastPopupView\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"showType\",\"value\":\"number\"},{\"name\":\"aheadType\",\"value\":\"number\"},{\"name\":\"message\",\"value\":\"string\"},{\"name\":\"btnText\",\"value\":\"string=\"},{\"name\":\"toastDuration\",\"value\":\"number=\"},{\"name\":\"schema\",\"value\":\"string=\"},{\"name\":\"token\",\"value\":\"string=\"},{\"name\":\"opacity\",\"value\":\"number\"},{\"name\":\"imgUrl\",\"value\":\"string=\"},{\"name\":\"url\",\"value\":\"string=\"},{\"name\":\"missionId\",\"value\":\"number=\"},{\"name\":\"btnColor\",\"value\":\"string=\"},{\"name\":\"messageColor\",\"value\":\"string=\"},{\"name\":\"btnTextColor\",\"value\":\"string=\"},{\"name\":\"status\",\"value\":\"number=\"},{\"name\":\"finishThisPage\",\"value\":\"number=\"}]},{\"name\":\"toast.getToastData\",\"scheme\":\"tiebaapp\",\"path\":\"toast/getModalData\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"url\",\"value\":\"string=\"}]},{\"name\":\"toast.showDialog\",\"scheme\":\"tiebaapp\",\"path\":\"toast/showDialog\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"type\",\"value\":\"number\"},{\"name\":\"content\",\"value\":\"string\"},{\"name\":\"dialogId\",\"value\":\"string=\"}],\"version\":\"12.46\"},{\"name\":\"toast.showTipToast\",\"scheme\":\"tiebaapp\",\"path\":\"toast/showTipToast\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"content\",\"value\":\"string\"},{\"name\":\"linkUrl\",\"value\":\"string\"},{\"name\":\"key\",\"value\":\"string=\"},{\"name\":\"maxTimes\",\"value\":\"number=\"},{\"name\":\"finishThisPage\",\"value\":\"number=\"}]},{\"name\":\"yabment.tbYab\",\"scheme\":\"tiebaapp\",\"path\":\"yabment/tbYab\",\"invoke\":\"prompt.scheme\",\"args\":[{\"name\":\"pId\",\"value\":\"string\"},{\"name\":\"money\",\"value\":\"number\"},{\"name\":\"month\",\"value\":\"number\"},{\"name\":\"isAutoYab\",\"value\":\"number\"},{\"name\":\"yabChannel\",\"value\":\"string\"},{\"name\":\"vipType\",\"value\":\"string\"},{\"name\":\"propsId\",\"value\":\"number\"},{\"name\":\"sceneId\",\"value\":\"number=\"},{\"name\":\"referPage\",\"value\":\"string=\"},{\"name\":\"clickZone\",\"value\":\"string=\"},{\"name\":\"fromScene\",\"value\":\"string=\"},{\"name\":\"isRetry\",\"value\":\"number=\"},{\"name\":\"posKey\",\"value\":\"string=\"},{\"name\":\"isTouristMode\",\"value\":\"boolean=\"},{\"name\":\"isRestoreMode\",\"value\":\"boolean=\"},{\"name\":\"ext\",\"value\":\"string=\"},{\"name\":\"yabmentType\",\"value\":\"string=\"},{\"name\":\"goodId\",\"value\":\"string=\"},{\"name\":\"from\",\"value\":\"string=\"}],\"version\":\"12.44.0\"}]";
    }

    public OldDescriptionTableInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getDescriptionTable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return mDescriptionTable;
        }
        return (String) invokeV.objValue;
    }

    public static HashSet<String> getModuleSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return mModuleSet;
        }
        return (HashSet) invokeV.objValue;
    }

    public static void setDescriptionTable(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            mDescriptionTable = str;
        }
    }

    public static void setModuleSet(HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, hashSet) == null) {
            mModuleSet = hashSet;
        }
    }
}
