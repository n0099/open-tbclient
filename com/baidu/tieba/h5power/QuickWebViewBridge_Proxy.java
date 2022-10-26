package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ej;
import com.baidu.tieba.go8;
import com.baidu.tieba.ho8;
import com.baidu.tieba.io8;
import com.baidu.tieba.ko8;
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
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
public class QuickWebViewBridge_Proxy extends go8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.go8
    public io8 dispatch(ko8 ko8Var, io8 io8Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ko8Var, io8Var)) == null) {
            io8 io8Var2 = io8Var == null ? new io8() : io8Var;
            String b = ko8Var.b();
            JSONObject e = ko8Var.e();
            if (b.equals("account/startLoginModule")) {
                io8Var2.r(true);
                io8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    io8Var2.x(startLoginModule.f());
                    io8Var2.t(startLoginModule.b());
                    io8Var2.o(startLoginModule.a());
                    io8Var2.w(startLoginModule.e());
                }
                io8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                io8Var2.r(true);
                io8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    io8Var2.x(finishPage.f());
                    io8Var2.t(finishPage.b());
                    io8Var2.o(finishPage.a());
                    io8Var2.w(finishPage.e());
                }
                io8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                io8Var2.r(true);
                io8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    io8Var2.x(showLowerHairHint.f());
                    io8Var2.t(showLowerHairHint.b());
                    io8Var2.o(showLowerHairHint.a());
                    io8Var2.w(showLowerHairHint.e());
                }
                io8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                io8Var2.r(true);
                io8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    io8Var2.x(gamePush.f());
                    io8Var2.t(gamePush.b());
                    io8Var2.o(gamePush.a());
                    io8Var2.w(gamePush.e());
                }
                io8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                io8Var2.r(true);
                io8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    io8Var2.x(handleGamePushStatus.f());
                    io8Var2.t(handleGamePushStatus.b());
                    io8Var2.o(handleGamePushStatus.a());
                    io8Var2.w(handleGamePushStatus.e());
                }
                io8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                io8Var2.r(true);
                io8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    io8Var2.x(jumpForumRulesEditPage.f());
                    io8Var2.t(jumpForumRulesEditPage.b());
                    io8Var2.o(jumpForumRulesEditPage.a());
                    io8Var2.w(jumpForumRulesEditPage.e());
                }
                io8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                io8Var2.r(true);
                io8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    io8Var2.x(handleGoToBarDetail.f());
                    io8Var2.t(handleGoToBarDetail.b());
                    io8Var2.o(handleGoToBarDetail.a());
                    io8Var2.w(handleGoToBarDetail.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                io8Var2.r(true);
                io8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    io8Var2.x(handleSaveImage.f());
                    io8Var2.t(handleSaveImage.b());
                    io8Var2.o(handleSaveImage.a());
                    io8Var2.w(handleSaveImage.e());
                    if (!io8Var2.h()) {
                        io8Var2.n(false);
                        addObserver("saveImageSuccess", io8Var2, false);
                    }
                }
                io8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                io8Var2.r(true);
                io8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    io8Var2.x(handleGetPhotoAlbum.f());
                    io8Var2.t(handleGetPhotoAlbum.b());
                    io8Var2.o(handleGetPhotoAlbum.a());
                    io8Var2.w(handleGetPhotoAlbum.e());
                    if (!io8Var2.h()) {
                        io8Var2.n(false);
                        addObserver("GetPhotoAlbum", io8Var2, false);
                    }
                }
                io8Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                io8Var2.r(true);
                io8 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    io8Var2.x(openMXDYab.f());
                    io8Var2.t(openMXDYab.b());
                    io8Var2.o(openMXDYab.a());
                    io8Var2.w(openMXDYab.e());
                }
                io8Var2.y(0);
            } else if (b.equals("router/portal")) {
                io8Var2.r(true);
                io8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    io8Var2.x(handlePortal.f());
                    io8Var2.t(handlePortal.b());
                    io8Var2.o(handlePortal.a());
                    io8Var2.w(handlePortal.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                io8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList arrayList = new ArrayList();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                io8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    io8Var2.x(selectPhotoAlbum.f());
                    io8Var2.t(selectPhotoAlbum.b());
                    io8Var2.o(selectPhotoAlbum.a());
                    io8Var2.w(selectPhotoAlbum.e());
                    if (!io8Var2.h()) {
                        io8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, io8Var2, false);
                    }
                }
                io8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                io8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList arrayList2 = new ArrayList();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                io8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    io8Var2.x(selectPrivateMsg.f());
                    io8Var2.t(selectPrivateMsg.b());
                    io8Var2.o(selectPrivateMsg.a());
                    io8Var2.w(selectPrivateMsg.e());
                    if (!io8Var2.h()) {
                        io8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", io8Var2, false);
                    }
                }
                io8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                io8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList arrayList3 = new ArrayList();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                io8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    io8Var2.x(reportUserTheme.f());
                    io8Var2.t(reportUserTheme.b());
                    io8Var2.o(reportUserTheme.a());
                    io8Var2.w(reportUserTheme.e());
                    if (!io8Var2.h()) {
                        io8Var2.n(false);
                        addObserver("goToReportThreadPage", io8Var2, false);
                    }
                }
                io8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                io8Var2.r(true);
                io8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    io8Var2.x(playSound.f());
                    io8Var2.t(playSound.b());
                    io8Var2.o(playSound.a());
                    io8Var2.w(playSound.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                io8Var2.r(true);
                io8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    io8Var2.x(playVibrate.f());
                    io8Var2.t(playVibrate.b());
                    io8Var2.o(playVibrate.a());
                    io8Var2.w(playVibrate.e());
                }
                io8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                io8Var2.r(true);
                io8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    io8Var2.x(jumpLoginActivity.f());
                    io8Var2.t(jumpLoginActivity.b());
                    io8Var2.o(jumpLoginActivity.a());
                    io8Var2.w(jumpLoginActivity.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                io8Var2.r(true);
                io8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    io8Var2.x(startLoadTimeInterval.f());
                    io8Var2.t(startLoadTimeInterval.b());
                    io8Var2.o(startLoadTimeInterval.a());
                    io8Var2.w(startLoadTimeInterval.e());
                }
                io8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                io8Var2.r(true);
                io8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    io8Var2.x(zid.f());
                    io8Var2.t(zid.b());
                    io8Var2.o(zid.a());
                    io8Var2.w(zid.e());
                }
                io8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                io8Var2.r(true);
                io8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    io8Var2.x(hdid.f());
                    io8Var2.t(hdid.b());
                    io8Var2.o(hdid.a());
                    io8Var2.w(hdid.e());
                }
                io8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                io8Var2.r(true);
                io8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    io8Var2.x(shareInfo.f());
                    io8Var2.t(shareInfo.b());
                    io8Var2.o(shareInfo.a());
                    io8Var2.w(shareInfo.e());
                }
                io8Var2.y(0);
            } else if (b.equals("share/share")) {
                io8Var2.r(true);
                io8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"));
                if (share != null) {
                    io8Var2.x(share.f());
                    io8Var2.t(share.b());
                    io8Var2.o(share.a());
                    io8Var2.w(share.e());
                }
                io8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                io8Var2.r(true);
                io8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    io8Var2.x(clipperInformation.f());
                    io8Var2.t(clipperInformation.b());
                    io8Var2.o(clipperInformation.a());
                    io8Var2.w(clipperInformation.e());
                }
                io8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                io8Var2.r(true);
                io8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    io8Var2.x(clipperInformation2.f());
                    io8Var2.t(clipperInformation2.b());
                    io8Var2.o(clipperInformation2.a());
                    io8Var2.w(clipperInformation2.e());
                }
                io8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                io8Var2.r(true);
                io8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    io8Var2.x(goToEditPost.f());
                    io8Var2.t(goToEditPost.b());
                    io8Var2.o(goToEditPost.a());
                    io8Var2.w(goToEditPost.e());
                }
                io8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                io8Var2.r(true);
                io8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    io8Var2.x(updateSearchForumInfo.f());
                    io8Var2.t(updateSearchForumInfo.b());
                    io8Var2.o(updateSearchForumInfo.a());
                    io8Var2.w(updateSearchForumInfo.e());
                }
                io8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                io8Var2.r(true);
                io8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    io8Var2.x(personlizedSwitchChange.f());
                    io8Var2.t(personlizedSwitchChange.b());
                    io8Var2.o(personlizedSwitchChange.a());
                    io8Var2.w(personlizedSwitchChange.e());
                }
                io8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                io8Var2.r(true);
                io8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    io8Var2.x(goToVideoImmersivePage.f());
                    io8Var2.t(goToVideoImmersivePage.b());
                    io8Var2.o(goToVideoImmersivePage.a());
                    io8Var2.w(goToVideoImmersivePage.e());
                }
                io8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                io8Var2.r(true);
                io8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    io8Var2.x(jumpToVideo.f());
                    io8Var2.t(jumpToVideo.b());
                    io8Var2.o(jumpToVideo.a());
                    io8Var2.w(jumpToVideo.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                io8Var2.r(true);
                io8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    io8Var2.x(closeNativeMask.f());
                    io8Var2.t(closeNativeMask.b());
                    io8Var2.o(closeNativeMask.a());
                    io8Var2.w(closeNativeMask.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                io8Var2.r(true);
                io8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    io8Var2.x(checkAppInstall.f());
                    io8Var2.t(checkAppInstall.b());
                    io8Var2.o(checkAppInstall.a());
                    io8Var2.w(checkAppInstall.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                io8Var2.r(true);
                io8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    io8Var2.x(disableBack.f());
                    io8Var2.t(disableBack.b());
                    io8Var2.o(disableBack.a());
                    io8Var2.w(disableBack.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                io8Var2.r(true);
                io8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    io8Var2.x(startApp.f());
                    io8Var2.t(startApp.b());
                    io8Var2.o(startApp.a());
                    io8Var2.w(startApp.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                io8Var2.r(true);
                io8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    io8Var2.x(hasNotificationPermission.f());
                    io8Var2.t(hasNotificationPermission.b());
                    io8Var2.o(hasNotificationPermission.a());
                    io8Var2.w(hasNotificationPermission.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                io8Var2.r(true);
                io8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    io8Var2.x(goToNotificationSetting.f());
                    io8Var2.t(goToNotificationSetting.b());
                    io8Var2.o(goToNotificationSetting.a());
                    io8Var2.w(goToNotificationSetting.e());
                }
                io8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                io8Var2.r(true);
                io8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    io8Var2.x(startDownloadCss.f());
                    io8Var2.t(startDownloadCss.b());
                    io8Var2.o(startDownloadCss.a());
                    io8Var2.w(startDownloadCss.e());
                }
                io8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                io8Var2.r(true);
                io8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    io8Var2.x(disableGoBack.f());
                    io8Var2.t(disableGoBack.b());
                    io8Var2.o(disableGoBack.a());
                    io8Var2.w(disableGoBack.e());
                }
                io8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                io8Var2.r(true);
                io8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    io8Var2.x(supplementInfo.f());
                    io8Var2.t(supplementInfo.b());
                    io8Var2.o(supplementInfo.a());
                    io8Var2.w(supplementInfo.e());
                }
                io8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                io8Var2.r(true);
                io8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    io8Var2.x(deviceInfo.f());
                    io8Var2.t(deviceInfo.b());
                    io8Var2.o(deviceInfo.a());
                    io8Var2.w(deviceInfo.e());
                }
                io8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                io8Var2.r(true);
                io8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    io8Var2.x(sendCompleteTaskReqMsg.f());
                    io8Var2.t(sendCompleteTaskReqMsg.b());
                    io8Var2.o(sendCompleteTaskReqMsg.a());
                    io8Var2.w(sendCompleteTaskReqMsg.e());
                }
                io8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                io8Var2.r(true);
                io8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    io8Var2.x(showTipToast.f());
                    io8Var2.t(showTipToast.b());
                    io8Var2.o(showTipToast.a());
                    io8Var2.w(showTipToast.e());
                }
                io8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                io8Var2.r(true);
                io8 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    io8Var2.x(getModalData.f());
                    io8Var2.t(getModalData.b());
                    io8Var2.o(getModalData.a());
                    io8Var2.w(getModalData.e());
                }
                io8Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                io8Var2.r(true);
                io8 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    io8Var2.x(openThirdPartApp.f());
                    io8Var2.t(openThirdPartApp.b());
                    io8Var2.o(openThirdPartApp.a());
                    io8Var2.w(openThirdPartApp.e());
                }
                io8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                io8Var2.r(true);
                io8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    io8Var2.x(jumpToHtmlPage.f());
                    io8Var2.t(jumpToHtmlPage.b());
                    io8Var2.o(jumpToHtmlPage.a());
                    io8Var2.w(jumpToHtmlPage.e());
                }
                io8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                io8Var2.r(true);
                io8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    io8Var2.x(offlineUserInfo.f());
                    io8Var2.t(offlineUserInfo.b());
                    io8Var2.o(offlineUserInfo.a());
                    io8Var2.w(offlineUserInfo.e());
                }
                io8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                io8Var2.r(true);
                io8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    io8Var2.x(deleteOfflineBundle.f());
                    io8Var2.t(deleteOfflineBundle.b());
                    io8Var2.o(deleteOfflineBundle.a());
                    io8Var2.w(deleteOfflineBundle.e());
                }
                io8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                io8Var2.r(true);
                io8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    io8Var2.x(updateOfflineBundle.f());
                    io8Var2.t(updateOfflineBundle.b());
                    io8Var2.o(updateOfflineBundle.a());
                    io8Var2.w(updateOfflineBundle.e());
                }
                io8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                io8Var2.r(true);
                io8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    io8Var2.x(switchOfflineInterface.f());
                    io8Var2.t(switchOfflineInterface.b());
                    io8Var2.o(switchOfflineInterface.a());
                    io8Var2.w(switchOfflineInterface.e());
                }
                io8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                io8Var2.r(true);
                io8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    io8Var2.x(switchOfflineBundleStatus.f());
                    io8Var2.t(switchOfflineBundleStatus.b());
                    io8Var2.o(switchOfflineBundleStatus.a());
                    io8Var2.w(switchOfflineBundleStatus.e());
                }
                io8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                io8Var2.r(true);
                io8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    io8Var2.x(finishTestAnswer.f());
                    io8Var2.t(finishTestAnswer.b());
                    io8Var2.o(finishTestAnswer.a());
                    io8Var2.w(finishTestAnswer.e());
                }
                io8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                io8Var2.r(true);
                ArrayList arrayList4 = new ArrayList();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                io8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    io8Var2.x(switchUrlHost.f());
                    io8Var2.t(switchUrlHost.b());
                    io8Var2.o(switchUrlHost.a());
                    io8Var2.w(switchUrlHost.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                io8Var2.r(true);
                io8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    io8Var2.x(appStorage.f());
                    io8Var2.t(appStorage.b());
                    io8Var2.o(appStorage.a());
                    io8Var2.w(appStorage.e());
                }
                io8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                io8Var2.r(true);
                io8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    io8Var2.x(putAppStorage.f());
                    io8Var2.t(putAppStorage.b());
                    io8Var2.o(putAppStorage.a());
                    io8Var2.w(putAppStorage.e());
                }
                io8Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                io8Var2.r(true);
                io8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    io8Var2.x(requestByNative.f());
                    io8Var2.t(requestByNative.b());
                    io8Var2.o(requestByNative.a());
                    io8Var2.w(requestByNative.e());
                    if (!io8Var2.h()) {
                        i = 0;
                        io8Var2.n(false);
                        addObserver("RequestByNativeToH5", io8Var2, false);
                        io8Var2.y(i);
                    }
                }
                i = 0;
                io8Var2.y(i);
            }
            return io8Var2;
        }
        return (io8) invokeLL.objValue;
    }

    public QuickWebViewBridge_Proxy(QuickWebViewBridge quickWebViewBridge) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {quickWebViewBridge};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = quickWebViewBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet hashSet = new HashSet();
        this.mNotificationNameList = hashSet;
        hashSet.add("saveImageSuccess");
        this.mNotificationNameList.add("GetPhotoAlbum");
        this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add("getPageLeaveTime");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_SKIN_TYPE);
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
        this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
        this.mNotificationNameList.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add(CommonTbJsBridge.CLICK_GO_BACK_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.GO_BACK_FROM_NATIVE);
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.go8
    public List processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            io8 io8Var = null;
            if (ej.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                io8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                io8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                io8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                io8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                io8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                io8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                io8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                io8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                io8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                io8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                io8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                io8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                io8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                io8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                io8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                io8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                io8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (io8Var != null) {
                io8Var.y(0);
            }
            List list = (List) this.mAsyncCallBackMethodList.get(str);
            if (io8Var != null && list != null) {
                Iterator it = list.iterator();
                if (!ej.isEmpty(io8Var.e())) {
                    while (it.hasNext()) {
                        ho8 ho8Var = (ho8) it.next();
                        if (ho8Var.b().equals(io8Var.e())) {
                            io8 io8Var2 = new io8();
                            io8Var2.v(ho8Var.a());
                            io8Var2.x(io8Var.f());
                            io8Var2.t(io8Var.b());
                            io8Var2.o(io8Var.a());
                            io8Var2.z(io8Var.l());
                            arrayList.add(io8Var2);
                            if (!ho8Var.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ho8 ho8Var2 = (ho8) it.next();
                        io8 io8Var3 = new io8();
                        io8Var3.v(ho8Var2.a());
                        io8Var3.x(io8Var.f());
                        io8Var3.t(io8Var.b());
                        io8Var3.o(io8Var.a());
                        io8Var3.z(io8Var.l());
                        arrayList.add(io8Var3);
                        if (!ho8Var2.c()) {
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
