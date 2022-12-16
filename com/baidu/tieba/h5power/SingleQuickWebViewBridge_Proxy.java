package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.at8;
import com.baidu.tieba.bt8;
import com.baidu.tieba.ct8;
import com.baidu.tieba.et8;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.PushManager;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SingleQuickWebViewBridge_Proxy extends at8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.at8
    public ct8 dispatch(et8 et8Var, ct8 ct8Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, et8Var, ct8Var)) == null) {
            ct8 ct8Var2 = ct8Var == null ? new ct8() : ct8Var;
            String b = et8Var.b();
            JSONObject e = et8Var.e();
            if (b.equals("account/startLoginModule")) {
                ct8Var2.r(true);
                ct8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    ct8Var2.x(startLoginModule.f());
                    ct8Var2.t(startLoginModule.b());
                    ct8Var2.o(startLoginModule.a());
                    ct8Var2.w(startLoginModule.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                ct8Var2.r(true);
                ct8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    ct8Var2.x(finishPage.f());
                    ct8Var2.t(finishPage.b());
                    ct8Var2.o(finishPage.a());
                    ct8Var2.w(finishPage.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                ct8Var2.r(true);
                ct8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    ct8Var2.x(showLowerHairHint.f());
                    ct8Var2.t(showLowerHairHint.b());
                    ct8Var2.o(showLowerHairHint.a());
                    ct8Var2.w(showLowerHairHint.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                ct8Var2.r(true);
                ct8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    ct8Var2.x(gamePush.f());
                    ct8Var2.t(gamePush.b());
                    ct8Var2.o(gamePush.a());
                    ct8Var2.w(gamePush.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                ct8Var2.r(true);
                ct8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    ct8Var2.x(handleGamePushStatus.f());
                    ct8Var2.t(handleGamePushStatus.b());
                    ct8Var2.o(handleGamePushStatus.a());
                    ct8Var2.w(handleGamePushStatus.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                ct8Var2.r(true);
                ct8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    ct8Var2.x(jumpForumRulesEditPage.f());
                    ct8Var2.t(jumpForumRulesEditPage.b());
                    ct8Var2.o(jumpForumRulesEditPage.a());
                    ct8Var2.w(jumpForumRulesEditPage.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                ct8Var2.r(true);
                ct8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    ct8Var2.x(handleGoToBarDetail.f());
                    ct8Var2.t(handleGoToBarDetail.b());
                    ct8Var2.o(handleGoToBarDetail.a());
                    ct8Var2.w(handleGoToBarDetail.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                ct8Var2.r(true);
                ct8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    ct8Var2.x(handleSaveImage.f());
                    ct8Var2.t(handleSaveImage.b());
                    ct8Var2.o(handleSaveImage.a());
                    ct8Var2.w(handleSaveImage.e());
                    if (!ct8Var2.h()) {
                        ct8Var2.n(false);
                        addObserver("saveImageSuccess", ct8Var2, false);
                    }
                }
                ct8Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                ct8Var2.r(true);
                ct8 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    ct8Var2.x(orderGameApk.f());
                    ct8Var2.t(orderGameApk.b());
                    ct8Var2.o(orderGameApk.a());
                    ct8Var2.w(orderGameApk.e());
                    if (!ct8Var2.h()) {
                        ct8Var2.n(false);
                        addObserver("orderGameApkResult", ct8Var2, false);
                    }
                }
                ct8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                ct8Var2.r(true);
                ct8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    ct8Var2.x(handleGetPhotoAlbum.f());
                    ct8Var2.t(handleGetPhotoAlbum.b());
                    ct8Var2.o(handleGetPhotoAlbum.a());
                    ct8Var2.w(handleGetPhotoAlbum.e());
                    if (!ct8Var2.h()) {
                        ct8Var2.n(false);
                        addObserver("GetPhotoAlbum", ct8Var2, false);
                    }
                }
                ct8Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                ct8Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                ct8 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    ct8Var2.x(preheatWeb.f());
                    ct8Var2.t(preheatWeb.b());
                    ct8Var2.o(preheatWeb.a());
                    ct8Var2.w(preheatWeb.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                ct8Var2.r(true);
                ct8 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    ct8Var2.x(openMXDYab.f());
                    ct8Var2.t(openMXDYab.b());
                    ct8Var2.o(openMXDYab.a());
                    ct8Var2.w(openMXDYab.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("router/portal")) {
                ct8Var2.r(true);
                ct8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    ct8Var2.x(handlePortal.f());
                    ct8Var2.t(handlePortal.b());
                    ct8Var2.o(handlePortal.a());
                    ct8Var2.w(handlePortal.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                ct8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                ct8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    ct8Var2.x(selectPhotoAlbum.f());
                    ct8Var2.t(selectPhotoAlbum.b());
                    ct8Var2.o(selectPhotoAlbum.a());
                    ct8Var2.w(selectPhotoAlbum.e());
                    if (!ct8Var2.h()) {
                        ct8Var2.n(false);
                        addObserver("selectPhotoAlbum", ct8Var2, false);
                    }
                }
                ct8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                ct8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                ct8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    ct8Var2.x(selectPrivateMsg.f());
                    ct8Var2.t(selectPrivateMsg.b());
                    ct8Var2.o(selectPrivateMsg.a());
                    ct8Var2.w(selectPrivateMsg.e());
                    if (!ct8Var2.h()) {
                        ct8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", ct8Var2, false);
                    }
                }
                ct8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                ct8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                ct8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    ct8Var2.x(reportUserTheme.f());
                    ct8Var2.t(reportUserTheme.b());
                    ct8Var2.o(reportUserTheme.a());
                    ct8Var2.w(reportUserTheme.e());
                    if (!ct8Var2.h()) {
                        ct8Var2.n(false);
                        addObserver("goToReportThreadPage", ct8Var2, false);
                    }
                }
                ct8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                ct8Var2.r(true);
                ct8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    ct8Var2.x(playSound.f());
                    ct8Var2.t(playSound.b());
                    ct8Var2.o(playSound.a());
                    ct8Var2.w(playSound.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                ct8Var2.r(true);
                ct8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    ct8Var2.x(playVibrate.f());
                    ct8Var2.t(playVibrate.b());
                    ct8Var2.o(playVibrate.a());
                    ct8Var2.w(playVibrate.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                ct8Var2.r(true);
                ct8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    ct8Var2.x(jumpLoginActivity.f());
                    ct8Var2.t(jumpLoginActivity.b());
                    ct8Var2.o(jumpLoginActivity.a());
                    ct8Var2.w(jumpLoginActivity.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                ct8Var2.r(true);
                ct8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    ct8Var2.x(startLoadTimeInterval.f());
                    ct8Var2.t(startLoadTimeInterval.b());
                    ct8Var2.o(startLoadTimeInterval.a());
                    ct8Var2.w(startLoadTimeInterval.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                ct8Var2.r(true);
                ct8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    ct8Var2.x(zid.f());
                    ct8Var2.t(zid.b());
                    ct8Var2.o(zid.a());
                    ct8Var2.w(zid.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                ct8Var2.r(true);
                ct8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    ct8Var2.x(hdid.f());
                    ct8Var2.t(hdid.b());
                    ct8Var2.o(hdid.a());
                    ct8Var2.w(hdid.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                ct8Var2.r(true);
                ct8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    ct8Var2.x(shareInfo.f());
                    ct8Var2.t(shareInfo.b());
                    ct8Var2.o(shareInfo.a());
                    ct8Var2.w(shareInfo.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("share/share")) {
                ct8Var2.r(true);
                ct8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"));
                if (share != null) {
                    ct8Var2.x(share.f());
                    ct8Var2.t(share.b());
                    ct8Var2.o(share.a());
                    ct8Var2.w(share.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                ct8Var2.r(true);
                ct8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    ct8Var2.x(clipperInformation.f());
                    ct8Var2.t(clipperInformation.b());
                    ct8Var2.o(clipperInformation.a());
                    ct8Var2.w(clipperInformation.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                ct8Var2.r(true);
                ct8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    ct8Var2.x(clipperInformation2.f());
                    ct8Var2.t(clipperInformation2.b());
                    ct8Var2.o(clipperInformation2.a());
                    ct8Var2.w(clipperInformation2.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                ct8Var2.r(true);
                ct8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    ct8Var2.x(goToEditPost.f());
                    ct8Var2.t(goToEditPost.b());
                    ct8Var2.o(goToEditPost.a());
                    ct8Var2.w(goToEditPost.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                ct8Var2.r(true);
                ct8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    ct8Var2.x(updateSearchForumInfo.f());
                    ct8Var2.t(updateSearchForumInfo.b());
                    ct8Var2.o(updateSearchForumInfo.a());
                    ct8Var2.w(updateSearchForumInfo.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                ct8Var2.r(true);
                ct8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    ct8Var2.x(personlizedSwitchChange.f());
                    ct8Var2.t(personlizedSwitchChange.b());
                    ct8Var2.o(personlizedSwitchChange.a());
                    ct8Var2.w(personlizedSwitchChange.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                ct8Var2.r(true);
                ct8 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    ct8Var2.x(updateTailStyle.f());
                    ct8Var2.t(updateTailStyle.b());
                    ct8Var2.o(updateTailStyle.a());
                    ct8Var2.w(updateTailStyle.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                ct8Var2.r(true);
                ct8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    ct8Var2.x(goToVideoImmersivePage.f());
                    ct8Var2.t(goToVideoImmersivePage.b());
                    ct8Var2.o(goToVideoImmersivePage.a());
                    ct8Var2.w(goToVideoImmersivePage.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                ct8Var2.r(true);
                ct8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    ct8Var2.x(jumpToVideo.f());
                    ct8Var2.t(jumpToVideo.b());
                    ct8Var2.o(jumpToVideo.a());
                    ct8Var2.w(jumpToVideo.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                ct8Var2.r(true);
                ct8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    ct8Var2.x(closeNativeMask.f());
                    ct8Var2.t(closeNativeMask.b());
                    ct8Var2.o(closeNativeMask.a());
                    ct8Var2.w(closeNativeMask.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                ct8Var2.r(true);
                ct8 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    ct8Var2.x(oneKeyDeletion.f());
                    ct8Var2.t(oneKeyDeletion.b());
                    ct8Var2.o(oneKeyDeletion.a());
                    ct8Var2.w(oneKeyDeletion.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                ct8Var2.r(true);
                ct8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    ct8Var2.x(checkAppInstall.f());
                    ct8Var2.t(checkAppInstall.b());
                    ct8Var2.o(checkAppInstall.a());
                    ct8Var2.w(checkAppInstall.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                ct8Var2.r(true);
                ct8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    ct8Var2.x(disableBack.f());
                    ct8Var2.t(disableBack.b());
                    ct8Var2.o(disableBack.a());
                    ct8Var2.w(disableBack.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                ct8Var2.r(true);
                ct8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    ct8Var2.x(startApp.f());
                    ct8Var2.t(startApp.b());
                    ct8Var2.o(startApp.a());
                    ct8Var2.w(startApp.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                ct8Var2.r(true);
                ct8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    ct8Var2.x(hasNotificationPermission.f());
                    ct8Var2.t(hasNotificationPermission.b());
                    ct8Var2.o(hasNotificationPermission.a());
                    ct8Var2.w(hasNotificationPermission.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                ct8Var2.r(true);
                ct8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    ct8Var2.x(goToNotificationSetting.f());
                    ct8Var2.t(goToNotificationSetting.b());
                    ct8Var2.o(goToNotificationSetting.a());
                    ct8Var2.w(goToNotificationSetting.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                ct8Var2.r(true);
                ct8 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushManager.APP_VERSION_CODE), e.optString("pkgName"));
                if (startDownloadGameApk != null) {
                    ct8Var2.x(startDownloadGameApk.f());
                    ct8Var2.t(startDownloadGameApk.b());
                    ct8Var2.o(startDownloadGameApk.a());
                    ct8Var2.w(startDownloadGameApk.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                ct8Var2.r(true);
                ct8 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    ct8Var2.x(checkInstallGameApk.f());
                    ct8Var2.t(checkInstallGameApk.b());
                    ct8Var2.o(checkInstallGameApk.a());
                    ct8Var2.w(checkInstallGameApk.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                ct8Var2.r(true);
                ct8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    ct8Var2.x(startDownloadCss.f());
                    ct8Var2.t(startDownloadCss.b());
                    ct8Var2.o(startDownloadCss.a());
                    ct8Var2.w(startDownloadCss.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                ct8Var2.r(true);
                ct8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    ct8Var2.x(disableGoBack.f());
                    ct8Var2.t(disableGoBack.b());
                    ct8Var2.o(disableGoBack.a());
                    ct8Var2.w(disableGoBack.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                ct8Var2.r(true);
                ct8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    ct8Var2.x(supplementInfo.f());
                    ct8Var2.t(supplementInfo.b());
                    ct8Var2.o(supplementInfo.a());
                    ct8Var2.w(supplementInfo.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                ct8Var2.r(true);
                ct8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    ct8Var2.x(deviceInfo.f());
                    ct8Var2.t(deviceInfo.b());
                    ct8Var2.o(deviceInfo.a());
                    ct8Var2.w(deviceInfo.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                ct8Var2.r(true);
                ct8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    ct8Var2.x(sendCompleteTaskReqMsg.f());
                    ct8Var2.t(sendCompleteTaskReqMsg.b());
                    ct8Var2.o(sendCompleteTaskReqMsg.a());
                    ct8Var2.w(sendCompleteTaskReqMsg.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                ct8Var2.r(true);
                ct8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    ct8Var2.x(showTipToast.f());
                    ct8Var2.t(showTipToast.b());
                    ct8Var2.o(showTipToast.a());
                    ct8Var2.w(showTipToast.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                ct8Var2.r(true);
                ct8 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    ct8Var2.x(getModalData.f());
                    ct8Var2.t(getModalData.b());
                    ct8Var2.o(getModalData.a());
                    ct8Var2.w(getModalData.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                ct8Var2.r(true);
                ct8 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    ct8Var2.x(openThirdPartApp.f());
                    ct8Var2.t(openThirdPartApp.b());
                    ct8Var2.o(openThirdPartApp.a());
                    ct8Var2.w(openThirdPartApp.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                ct8Var2.r(true);
                ct8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    ct8Var2.x(jumpToHtmlPage.f());
                    ct8Var2.t(jumpToHtmlPage.b());
                    ct8Var2.o(jumpToHtmlPage.a());
                    ct8Var2.w(jumpToHtmlPage.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                ct8Var2.r(true);
                ct8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    ct8Var2.x(offlineUserInfo.f());
                    ct8Var2.t(offlineUserInfo.b());
                    ct8Var2.o(offlineUserInfo.a());
                    ct8Var2.w(offlineUserInfo.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                ct8Var2.r(true);
                ct8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    ct8Var2.x(deleteOfflineBundle.f());
                    ct8Var2.t(deleteOfflineBundle.b());
                    ct8Var2.o(deleteOfflineBundle.a());
                    ct8Var2.w(deleteOfflineBundle.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                ct8Var2.r(true);
                ct8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    ct8Var2.x(updateOfflineBundle.f());
                    ct8Var2.t(updateOfflineBundle.b());
                    ct8Var2.o(updateOfflineBundle.a());
                    ct8Var2.w(updateOfflineBundle.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                ct8Var2.r(true);
                ct8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    ct8Var2.x(switchOfflineInterface.f());
                    ct8Var2.t(switchOfflineInterface.b());
                    ct8Var2.o(switchOfflineInterface.a());
                    ct8Var2.w(switchOfflineInterface.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                ct8Var2.r(true);
                ct8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    ct8Var2.x(switchOfflineBundleStatus.f());
                    ct8Var2.t(switchOfflineBundleStatus.b());
                    ct8Var2.o(switchOfflineBundleStatus.a());
                    ct8Var2.w(switchOfflineBundleStatus.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                ct8Var2.r(true);
                ct8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    ct8Var2.x(finishTestAnswer.f());
                    ct8Var2.t(finishTestAnswer.b());
                    ct8Var2.o(finishTestAnswer.a());
                    ct8Var2.w(finishTestAnswer.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                ct8Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                ct8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    ct8Var2.x(switchUrlHost.f());
                    ct8Var2.t(switchUrlHost.b());
                    ct8Var2.o(switchUrlHost.a());
                    ct8Var2.w(switchUrlHost.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                ct8Var2.r(true);
                ct8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    ct8Var2.x(appStorage.f());
                    ct8Var2.t(appStorage.b());
                    ct8Var2.o(appStorage.a());
                    ct8Var2.w(appStorage.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                ct8Var2.r(true);
                ct8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    ct8Var2.x(putAppStorage.f());
                    ct8Var2.t(putAppStorage.b());
                    ct8Var2.o(putAppStorage.a());
                    ct8Var2.w(putAppStorage.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                ct8Var2.r(true);
                ct8 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    ct8Var2.x(historyForumData.f());
                    ct8Var2.t(historyForumData.b());
                    ct8Var2.o(historyForumData.a());
                    ct8Var2.w(historyForumData.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                ct8Var2.r(true);
                ct8 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    ct8Var2.x(worldCupRaiseSuccess.f());
                    ct8Var2.t(worldCupRaiseSuccess.b());
                    ct8Var2.o(worldCupRaiseSuccess.a());
                    ct8Var2.w(worldCupRaiseSuccess.e());
                }
                ct8Var2.y(0);
            } else if (b.equals("account/getAlipayUserId")) {
                ct8Var2.r(true);
                ct8 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    ct8Var2.x(alipayUserId.f());
                    ct8Var2.t(alipayUserId.b());
                    ct8Var2.o(alipayUserId.a());
                    ct8Var2.w(alipayUserId.e());
                    if (!ct8Var2.h()) {
                        i2 = 0;
                        ct8Var2.n(false);
                        addObserver("aliAuthResult", ct8Var2, false);
                        ct8Var2.y(i2);
                    }
                }
                i2 = 0;
                ct8Var2.y(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                ct8Var2.r(true);
                ct8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    ct8Var2.x(requestByNative.f());
                    ct8Var2.t(requestByNative.b());
                    ct8Var2.o(requestByNative.a());
                    ct8Var2.w(requestByNative.e());
                    if (!ct8Var2.h()) {
                        i = 0;
                        ct8Var2.n(false);
                        addObserver("RequestByNativeToH5", ct8Var2, false);
                        ct8Var2.y(i);
                    }
                }
                i = 0;
                ct8Var2.y(i);
            }
            return ct8Var2;
        }
        return (ct8) invokeLL.objValue;
    }

    public SingleQuickWebViewBridge_Proxy(SingleQuickWebViewBridge singleQuickWebViewBridge) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleQuickWebViewBridge};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = singleQuickWebViewBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("saveImageSuccess");
        this.mNotificationNameList.add("orderGameApkResult");
        this.mNotificationNameList.add("GetPhotoAlbum");
        this.mNotificationNameList.add("selectPhotoAlbum");
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add("getPageLeaveTime");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_SKIN_TYPE);
        this.mNotificationNameList.add(CommonTbJsBridge.OPEN_VIP_SUCCESS);
        this.mNotificationNameList.add(CommonTbJsBridge.REFRESH_TAIL);
        this.mNotificationNameList.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
        this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
        this.mNotificationNameList.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add(CommonTbJsBridge.CLICK_GO_BACK_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.GO_BACK_FROM_NATIVE);
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.at8
    public List<ct8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            ct8 ct8Var = null;
            if (xi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                ct8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                ct8Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                ct8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                ct8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                ct8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                ct8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                ct8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                ct8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                ct8Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                ct8Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                ct8Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                ct8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                ct8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                ct8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                ct8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                ct8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                ct8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                ct8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                ct8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                ct8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("aliAuthResult")) {
                ct8Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                ct8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (ct8Var != null) {
                ct8Var.y(0);
            }
            List<bt8> list = this.mAsyncCallBackMethodList.get(str);
            if (ct8Var != null && list != null) {
                Iterator<bt8> it = list.iterator();
                if (!xi.isEmpty(ct8Var.e())) {
                    while (it.hasNext()) {
                        bt8 next = it.next();
                        if (next.b().equals(ct8Var.e())) {
                            ct8 ct8Var2 = new ct8();
                            ct8Var2.v(next.a());
                            ct8Var2.x(ct8Var.f());
                            ct8Var2.t(ct8Var.b());
                            ct8Var2.o(ct8Var.a());
                            ct8Var2.z(ct8Var.l());
                            arrayList.add(ct8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        bt8 next2 = it.next();
                        ct8 ct8Var3 = new ct8();
                        ct8Var3.v(next2.a());
                        ct8Var3.x(ct8Var.f());
                        ct8Var3.t(ct8Var.b());
                        ct8Var3.o(ct8Var.a());
                        ct8Var3.z(ct8Var.l());
                        arrayList.add(ct8Var3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
