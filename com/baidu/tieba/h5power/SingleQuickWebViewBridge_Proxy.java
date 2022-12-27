package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.bt8;
import com.baidu.tieba.ct8;
import com.baidu.tieba.dt8;
import com.baidu.tieba.ft8;
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
public class SingleQuickWebViewBridge_Proxy extends bt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.bt8
    public dt8 dispatch(ft8 ft8Var, dt8 dt8Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ft8Var, dt8Var)) == null) {
            dt8 dt8Var2 = dt8Var == null ? new dt8() : dt8Var;
            String b = ft8Var.b();
            JSONObject e = ft8Var.e();
            if (b.equals("account/startLoginModule")) {
                dt8Var2.r(true);
                dt8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    dt8Var2.x(startLoginModule.f());
                    dt8Var2.t(startLoginModule.b());
                    dt8Var2.o(startLoginModule.a());
                    dt8Var2.w(startLoginModule.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                dt8Var2.r(true);
                dt8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    dt8Var2.x(finishPage.f());
                    dt8Var2.t(finishPage.b());
                    dt8Var2.o(finishPage.a());
                    dt8Var2.w(finishPage.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                dt8Var2.r(true);
                dt8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    dt8Var2.x(showLowerHairHint.f());
                    dt8Var2.t(showLowerHairHint.b());
                    dt8Var2.o(showLowerHairHint.a());
                    dt8Var2.w(showLowerHairHint.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                dt8Var2.r(true);
                dt8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    dt8Var2.x(gamePush.f());
                    dt8Var2.t(gamePush.b());
                    dt8Var2.o(gamePush.a());
                    dt8Var2.w(gamePush.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                dt8Var2.r(true);
                dt8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    dt8Var2.x(handleGamePushStatus.f());
                    dt8Var2.t(handleGamePushStatus.b());
                    dt8Var2.o(handleGamePushStatus.a());
                    dt8Var2.w(handleGamePushStatus.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                dt8Var2.r(true);
                dt8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    dt8Var2.x(jumpForumRulesEditPage.f());
                    dt8Var2.t(jumpForumRulesEditPage.b());
                    dt8Var2.o(jumpForumRulesEditPage.a());
                    dt8Var2.w(jumpForumRulesEditPage.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                dt8Var2.r(true);
                dt8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    dt8Var2.x(handleGoToBarDetail.f());
                    dt8Var2.t(handleGoToBarDetail.b());
                    dt8Var2.o(handleGoToBarDetail.a());
                    dt8Var2.w(handleGoToBarDetail.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                dt8Var2.r(true);
                dt8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    dt8Var2.x(handleSaveImage.f());
                    dt8Var2.t(handleSaveImage.b());
                    dt8Var2.o(handleSaveImage.a());
                    dt8Var2.w(handleSaveImage.e());
                    if (!dt8Var2.h()) {
                        dt8Var2.n(false);
                        addObserver("saveImageSuccess", dt8Var2, false);
                    }
                }
                dt8Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                dt8Var2.r(true);
                dt8 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    dt8Var2.x(orderGameApk.f());
                    dt8Var2.t(orderGameApk.b());
                    dt8Var2.o(orderGameApk.a());
                    dt8Var2.w(orderGameApk.e());
                    if (!dt8Var2.h()) {
                        dt8Var2.n(false);
                        addObserver("orderGameApkResult", dt8Var2, false);
                    }
                }
                dt8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                dt8Var2.r(true);
                dt8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    dt8Var2.x(handleGetPhotoAlbum.f());
                    dt8Var2.t(handleGetPhotoAlbum.b());
                    dt8Var2.o(handleGetPhotoAlbum.a());
                    dt8Var2.w(handleGetPhotoAlbum.e());
                    if (!dt8Var2.h()) {
                        dt8Var2.n(false);
                        addObserver("GetPhotoAlbum", dt8Var2, false);
                    }
                }
                dt8Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                dt8Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                dt8 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    dt8Var2.x(preheatWeb.f());
                    dt8Var2.t(preheatWeb.b());
                    dt8Var2.o(preheatWeb.a());
                    dt8Var2.w(preheatWeb.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                dt8Var2.r(true);
                dt8 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    dt8Var2.x(openMXDYab.f());
                    dt8Var2.t(openMXDYab.b());
                    dt8Var2.o(openMXDYab.a());
                    dt8Var2.w(openMXDYab.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("router/portal")) {
                dt8Var2.r(true);
                dt8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    dt8Var2.x(handlePortal.f());
                    dt8Var2.t(handlePortal.b());
                    dt8Var2.o(handlePortal.a());
                    dt8Var2.w(handlePortal.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                dt8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                dt8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    dt8Var2.x(selectPhotoAlbum.f());
                    dt8Var2.t(selectPhotoAlbum.b());
                    dt8Var2.o(selectPhotoAlbum.a());
                    dt8Var2.w(selectPhotoAlbum.e());
                    if (!dt8Var2.h()) {
                        dt8Var2.n(false);
                        addObserver("selectPhotoAlbum", dt8Var2, false);
                    }
                }
                dt8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                dt8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                dt8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    dt8Var2.x(selectPrivateMsg.f());
                    dt8Var2.t(selectPrivateMsg.b());
                    dt8Var2.o(selectPrivateMsg.a());
                    dt8Var2.w(selectPrivateMsg.e());
                    if (!dt8Var2.h()) {
                        dt8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", dt8Var2, false);
                    }
                }
                dt8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                dt8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                dt8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    dt8Var2.x(reportUserTheme.f());
                    dt8Var2.t(reportUserTheme.b());
                    dt8Var2.o(reportUserTheme.a());
                    dt8Var2.w(reportUserTheme.e());
                    if (!dt8Var2.h()) {
                        dt8Var2.n(false);
                        addObserver("goToReportThreadPage", dt8Var2, false);
                    }
                }
                dt8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                dt8Var2.r(true);
                dt8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    dt8Var2.x(playSound.f());
                    dt8Var2.t(playSound.b());
                    dt8Var2.o(playSound.a());
                    dt8Var2.w(playSound.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                dt8Var2.r(true);
                dt8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    dt8Var2.x(playVibrate.f());
                    dt8Var2.t(playVibrate.b());
                    dt8Var2.o(playVibrate.a());
                    dt8Var2.w(playVibrate.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                dt8Var2.r(true);
                dt8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    dt8Var2.x(jumpLoginActivity.f());
                    dt8Var2.t(jumpLoginActivity.b());
                    dt8Var2.o(jumpLoginActivity.a());
                    dt8Var2.w(jumpLoginActivity.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                dt8Var2.r(true);
                dt8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    dt8Var2.x(startLoadTimeInterval.f());
                    dt8Var2.t(startLoadTimeInterval.b());
                    dt8Var2.o(startLoadTimeInterval.a());
                    dt8Var2.w(startLoadTimeInterval.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                dt8Var2.r(true);
                dt8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    dt8Var2.x(zid.f());
                    dt8Var2.t(zid.b());
                    dt8Var2.o(zid.a());
                    dt8Var2.w(zid.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                dt8Var2.r(true);
                dt8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    dt8Var2.x(hdid.f());
                    dt8Var2.t(hdid.b());
                    dt8Var2.o(hdid.a());
                    dt8Var2.w(hdid.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                dt8Var2.r(true);
                dt8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    dt8Var2.x(shareInfo.f());
                    dt8Var2.t(shareInfo.b());
                    dt8Var2.o(shareInfo.a());
                    dt8Var2.w(shareInfo.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("share/share")) {
                dt8Var2.r(true);
                dt8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"));
                if (share != null) {
                    dt8Var2.x(share.f());
                    dt8Var2.t(share.b());
                    dt8Var2.o(share.a());
                    dt8Var2.w(share.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                dt8Var2.r(true);
                dt8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    dt8Var2.x(clipperInformation.f());
                    dt8Var2.t(clipperInformation.b());
                    dt8Var2.o(clipperInformation.a());
                    dt8Var2.w(clipperInformation.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                dt8Var2.r(true);
                dt8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    dt8Var2.x(clipperInformation2.f());
                    dt8Var2.t(clipperInformation2.b());
                    dt8Var2.o(clipperInformation2.a());
                    dt8Var2.w(clipperInformation2.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                dt8Var2.r(true);
                dt8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    dt8Var2.x(goToEditPost.f());
                    dt8Var2.t(goToEditPost.b());
                    dt8Var2.o(goToEditPost.a());
                    dt8Var2.w(goToEditPost.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                dt8Var2.r(true);
                dt8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    dt8Var2.x(updateSearchForumInfo.f());
                    dt8Var2.t(updateSearchForumInfo.b());
                    dt8Var2.o(updateSearchForumInfo.a());
                    dt8Var2.w(updateSearchForumInfo.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                dt8Var2.r(true);
                dt8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    dt8Var2.x(personlizedSwitchChange.f());
                    dt8Var2.t(personlizedSwitchChange.b());
                    dt8Var2.o(personlizedSwitchChange.a());
                    dt8Var2.w(personlizedSwitchChange.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                dt8Var2.r(true);
                dt8 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    dt8Var2.x(updateTailStyle.f());
                    dt8Var2.t(updateTailStyle.b());
                    dt8Var2.o(updateTailStyle.a());
                    dt8Var2.w(updateTailStyle.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                dt8Var2.r(true);
                dt8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    dt8Var2.x(goToVideoImmersivePage.f());
                    dt8Var2.t(goToVideoImmersivePage.b());
                    dt8Var2.o(goToVideoImmersivePage.a());
                    dt8Var2.w(goToVideoImmersivePage.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                dt8Var2.r(true);
                dt8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    dt8Var2.x(jumpToVideo.f());
                    dt8Var2.t(jumpToVideo.b());
                    dt8Var2.o(jumpToVideo.a());
                    dt8Var2.w(jumpToVideo.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                dt8Var2.r(true);
                dt8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    dt8Var2.x(closeNativeMask.f());
                    dt8Var2.t(closeNativeMask.b());
                    dt8Var2.o(closeNativeMask.a());
                    dt8Var2.w(closeNativeMask.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                dt8Var2.r(true);
                dt8 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    dt8Var2.x(oneKeyDeletion.f());
                    dt8Var2.t(oneKeyDeletion.b());
                    dt8Var2.o(oneKeyDeletion.a());
                    dt8Var2.w(oneKeyDeletion.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                dt8Var2.r(true);
                dt8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    dt8Var2.x(checkAppInstall.f());
                    dt8Var2.t(checkAppInstall.b());
                    dt8Var2.o(checkAppInstall.a());
                    dt8Var2.w(checkAppInstall.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                dt8Var2.r(true);
                dt8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    dt8Var2.x(disableBack.f());
                    dt8Var2.t(disableBack.b());
                    dt8Var2.o(disableBack.a());
                    dt8Var2.w(disableBack.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                dt8Var2.r(true);
                dt8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    dt8Var2.x(startApp.f());
                    dt8Var2.t(startApp.b());
                    dt8Var2.o(startApp.a());
                    dt8Var2.w(startApp.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                dt8Var2.r(true);
                dt8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    dt8Var2.x(hasNotificationPermission.f());
                    dt8Var2.t(hasNotificationPermission.b());
                    dt8Var2.o(hasNotificationPermission.a());
                    dt8Var2.w(hasNotificationPermission.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                dt8Var2.r(true);
                dt8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    dt8Var2.x(goToNotificationSetting.f());
                    dt8Var2.t(goToNotificationSetting.b());
                    dt8Var2.o(goToNotificationSetting.a());
                    dt8Var2.w(goToNotificationSetting.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                dt8Var2.r(true);
                dt8 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushManager.APP_VERSION_CODE), e.optString("pkgName"));
                if (startDownloadGameApk != null) {
                    dt8Var2.x(startDownloadGameApk.f());
                    dt8Var2.t(startDownloadGameApk.b());
                    dt8Var2.o(startDownloadGameApk.a());
                    dt8Var2.w(startDownloadGameApk.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                dt8Var2.r(true);
                dt8 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    dt8Var2.x(checkInstallGameApk.f());
                    dt8Var2.t(checkInstallGameApk.b());
                    dt8Var2.o(checkInstallGameApk.a());
                    dt8Var2.w(checkInstallGameApk.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                dt8Var2.r(true);
                dt8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    dt8Var2.x(startDownloadCss.f());
                    dt8Var2.t(startDownloadCss.b());
                    dt8Var2.o(startDownloadCss.a());
                    dt8Var2.w(startDownloadCss.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                dt8Var2.r(true);
                dt8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    dt8Var2.x(disableGoBack.f());
                    dt8Var2.t(disableGoBack.b());
                    dt8Var2.o(disableGoBack.a());
                    dt8Var2.w(disableGoBack.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                dt8Var2.r(true);
                dt8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    dt8Var2.x(supplementInfo.f());
                    dt8Var2.t(supplementInfo.b());
                    dt8Var2.o(supplementInfo.a());
                    dt8Var2.w(supplementInfo.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                dt8Var2.r(true);
                dt8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    dt8Var2.x(deviceInfo.f());
                    dt8Var2.t(deviceInfo.b());
                    dt8Var2.o(deviceInfo.a());
                    dt8Var2.w(deviceInfo.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                dt8Var2.r(true);
                dt8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    dt8Var2.x(sendCompleteTaskReqMsg.f());
                    dt8Var2.t(sendCompleteTaskReqMsg.b());
                    dt8Var2.o(sendCompleteTaskReqMsg.a());
                    dt8Var2.w(sendCompleteTaskReqMsg.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                dt8Var2.r(true);
                dt8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    dt8Var2.x(showTipToast.f());
                    dt8Var2.t(showTipToast.b());
                    dt8Var2.o(showTipToast.a());
                    dt8Var2.w(showTipToast.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                dt8Var2.r(true);
                dt8 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    dt8Var2.x(getModalData.f());
                    dt8Var2.t(getModalData.b());
                    dt8Var2.o(getModalData.a());
                    dt8Var2.w(getModalData.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                dt8Var2.r(true);
                dt8 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    dt8Var2.x(openThirdPartApp.f());
                    dt8Var2.t(openThirdPartApp.b());
                    dt8Var2.o(openThirdPartApp.a());
                    dt8Var2.w(openThirdPartApp.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                dt8Var2.r(true);
                dt8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    dt8Var2.x(jumpToHtmlPage.f());
                    dt8Var2.t(jumpToHtmlPage.b());
                    dt8Var2.o(jumpToHtmlPage.a());
                    dt8Var2.w(jumpToHtmlPage.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                dt8Var2.r(true);
                dt8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    dt8Var2.x(offlineUserInfo.f());
                    dt8Var2.t(offlineUserInfo.b());
                    dt8Var2.o(offlineUserInfo.a());
                    dt8Var2.w(offlineUserInfo.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                dt8Var2.r(true);
                dt8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    dt8Var2.x(deleteOfflineBundle.f());
                    dt8Var2.t(deleteOfflineBundle.b());
                    dt8Var2.o(deleteOfflineBundle.a());
                    dt8Var2.w(deleteOfflineBundle.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                dt8Var2.r(true);
                dt8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    dt8Var2.x(updateOfflineBundle.f());
                    dt8Var2.t(updateOfflineBundle.b());
                    dt8Var2.o(updateOfflineBundle.a());
                    dt8Var2.w(updateOfflineBundle.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                dt8Var2.r(true);
                dt8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    dt8Var2.x(switchOfflineInterface.f());
                    dt8Var2.t(switchOfflineInterface.b());
                    dt8Var2.o(switchOfflineInterface.a());
                    dt8Var2.w(switchOfflineInterface.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                dt8Var2.r(true);
                dt8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    dt8Var2.x(switchOfflineBundleStatus.f());
                    dt8Var2.t(switchOfflineBundleStatus.b());
                    dt8Var2.o(switchOfflineBundleStatus.a());
                    dt8Var2.w(switchOfflineBundleStatus.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                dt8Var2.r(true);
                dt8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    dt8Var2.x(finishTestAnswer.f());
                    dt8Var2.t(finishTestAnswer.b());
                    dt8Var2.o(finishTestAnswer.a());
                    dt8Var2.w(finishTestAnswer.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                dt8Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                dt8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    dt8Var2.x(switchUrlHost.f());
                    dt8Var2.t(switchUrlHost.b());
                    dt8Var2.o(switchUrlHost.a());
                    dt8Var2.w(switchUrlHost.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                dt8Var2.r(true);
                dt8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    dt8Var2.x(appStorage.f());
                    dt8Var2.t(appStorage.b());
                    dt8Var2.o(appStorage.a());
                    dt8Var2.w(appStorage.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                dt8Var2.r(true);
                dt8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    dt8Var2.x(putAppStorage.f());
                    dt8Var2.t(putAppStorage.b());
                    dt8Var2.o(putAppStorage.a());
                    dt8Var2.w(putAppStorage.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                dt8Var2.r(true);
                dt8 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    dt8Var2.x(historyForumData.f());
                    dt8Var2.t(historyForumData.b());
                    dt8Var2.o(historyForumData.a());
                    dt8Var2.w(historyForumData.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                dt8Var2.r(true);
                dt8 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    dt8Var2.x(worldCupRaiseSuccess.f());
                    dt8Var2.t(worldCupRaiseSuccess.b());
                    dt8Var2.o(worldCupRaiseSuccess.a());
                    dt8Var2.w(worldCupRaiseSuccess.e());
                }
                dt8Var2.y(0);
            } else if (b.equals("account/getAlipayUserId")) {
                dt8Var2.r(true);
                dt8 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    dt8Var2.x(alipayUserId.f());
                    dt8Var2.t(alipayUserId.b());
                    dt8Var2.o(alipayUserId.a());
                    dt8Var2.w(alipayUserId.e());
                    if (!dt8Var2.h()) {
                        i2 = 0;
                        dt8Var2.n(false);
                        addObserver("aliAuthResult", dt8Var2, false);
                        dt8Var2.y(i2);
                    }
                }
                i2 = 0;
                dt8Var2.y(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                dt8Var2.r(true);
                dt8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    dt8Var2.x(requestByNative.f());
                    dt8Var2.t(requestByNative.b());
                    dt8Var2.o(requestByNative.a());
                    dt8Var2.w(requestByNative.e());
                    if (!dt8Var2.h()) {
                        i = 0;
                        dt8Var2.n(false);
                        addObserver("RequestByNativeToH5", dt8Var2, false);
                        dt8Var2.y(i);
                    }
                }
                i = 0;
                dt8Var2.y(i);
            }
            return dt8Var2;
        }
        return (dt8) invokeLL.objValue;
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

    @Override // com.baidu.tieba.bt8
    public List<dt8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            dt8 dt8Var = null;
            if (xi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                dt8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                dt8Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                dt8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                dt8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                dt8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                dt8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                dt8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                dt8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                dt8Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                dt8Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                dt8Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                dt8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                dt8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                dt8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                dt8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                dt8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                dt8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                dt8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                dt8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                dt8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("aliAuthResult")) {
                dt8Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                dt8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (dt8Var != null) {
                dt8Var.y(0);
            }
            List<ct8> list = this.mAsyncCallBackMethodList.get(str);
            if (dt8Var != null && list != null) {
                Iterator<ct8> it = list.iterator();
                if (!xi.isEmpty(dt8Var.e())) {
                    while (it.hasNext()) {
                        ct8 next = it.next();
                        if (next.b().equals(dt8Var.e())) {
                            dt8 dt8Var2 = new dt8();
                            dt8Var2.v(next.a());
                            dt8Var2.x(dt8Var.f());
                            dt8Var2.t(dt8Var.b());
                            dt8Var2.o(dt8Var.a());
                            dt8Var2.z(dt8Var.l());
                            arrayList.add(dt8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ct8 next2 = it.next();
                        dt8 dt8Var3 = new dt8();
                        dt8Var3.v(next2.a());
                        dt8Var3.x(dt8Var.f());
                        dt8Var3.t(dt8Var.b());
                        dt8Var3.o(dt8Var.a());
                        dt8Var3.z(dt8Var.l());
                        arrayList.add(dt8Var3);
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
