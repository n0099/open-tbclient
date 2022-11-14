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
import com.baidu.tieba.aq8;
import com.baidu.tieba.bq8;
import com.baidu.tieba.cq8;
import com.baidu.tieba.eq8;
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
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
public class QuickWebViewBridge_Proxy extends aq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.aq8
    public cq8 dispatch(eq8 eq8Var, cq8 cq8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eq8Var, cq8Var)) == null) {
            cq8 cq8Var2 = cq8Var == null ? new cq8() : cq8Var;
            String b = eq8Var.b();
            JSONObject e = eq8Var.e();
            if (b.equals("account/startLoginModule")) {
                cq8Var2.r(true);
                cq8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    cq8Var2.x(startLoginModule.f());
                    cq8Var2.t(startLoginModule.b());
                    cq8Var2.o(startLoginModule.a());
                    cq8Var2.w(startLoginModule.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                cq8Var2.r(true);
                cq8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    cq8Var2.x(finishPage.f());
                    cq8Var2.t(finishPage.b());
                    cq8Var2.o(finishPage.a());
                    cq8Var2.w(finishPage.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                cq8Var2.r(true);
                cq8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    cq8Var2.x(showLowerHairHint.f());
                    cq8Var2.t(showLowerHairHint.b());
                    cq8Var2.o(showLowerHairHint.a());
                    cq8Var2.w(showLowerHairHint.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                cq8Var2.r(true);
                cq8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    cq8Var2.x(gamePush.f());
                    cq8Var2.t(gamePush.b());
                    cq8Var2.o(gamePush.a());
                    cq8Var2.w(gamePush.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                cq8Var2.r(true);
                cq8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    cq8Var2.x(handleGamePushStatus.f());
                    cq8Var2.t(handleGamePushStatus.b());
                    cq8Var2.o(handleGamePushStatus.a());
                    cq8Var2.w(handleGamePushStatus.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                cq8Var2.r(true);
                cq8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    cq8Var2.x(jumpForumRulesEditPage.f());
                    cq8Var2.t(jumpForumRulesEditPage.b());
                    cq8Var2.o(jumpForumRulesEditPage.a());
                    cq8Var2.w(jumpForumRulesEditPage.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                cq8Var2.r(true);
                cq8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    cq8Var2.x(handleGoToBarDetail.f());
                    cq8Var2.t(handleGoToBarDetail.b());
                    cq8Var2.o(handleGoToBarDetail.a());
                    cq8Var2.w(handleGoToBarDetail.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                cq8Var2.r(true);
                cq8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    cq8Var2.x(handleSaveImage.f());
                    cq8Var2.t(handleSaveImage.b());
                    cq8Var2.o(handleSaveImage.a());
                    cq8Var2.w(handleSaveImage.e());
                    if (!cq8Var2.h()) {
                        cq8Var2.n(false);
                        addObserver("saveImageSuccess", cq8Var2, false);
                    }
                }
                cq8Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                cq8Var2.r(true);
                cq8 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    cq8Var2.x(orderGameApk.f());
                    cq8Var2.t(orderGameApk.b());
                    cq8Var2.o(orderGameApk.a());
                    cq8Var2.w(orderGameApk.e());
                    if (!cq8Var2.h()) {
                        cq8Var2.n(false);
                        addObserver("orderGameApkResult", cq8Var2, false);
                    }
                }
                cq8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                cq8Var2.r(true);
                cq8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    cq8Var2.x(handleGetPhotoAlbum.f());
                    cq8Var2.t(handleGetPhotoAlbum.b());
                    cq8Var2.o(handleGetPhotoAlbum.a());
                    cq8Var2.w(handleGetPhotoAlbum.e());
                    if (!cq8Var2.h()) {
                        cq8Var2.n(false);
                        addObserver("GetPhotoAlbum", cq8Var2, false);
                    }
                }
                cq8Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                cq8Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                cq8 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    cq8Var2.x(preheatWeb.f());
                    cq8Var2.t(preheatWeb.b());
                    cq8Var2.o(preheatWeb.a());
                    cq8Var2.w(preheatWeb.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                cq8Var2.r(true);
                cq8 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    cq8Var2.x(openMXDYab.f());
                    cq8Var2.t(openMXDYab.b());
                    cq8Var2.o(openMXDYab.a());
                    cq8Var2.w(openMXDYab.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("router/portal")) {
                cq8Var2.r(true);
                cq8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    cq8Var2.x(handlePortal.f());
                    cq8Var2.t(handlePortal.b());
                    cq8Var2.o(handlePortal.a());
                    cq8Var2.w(handlePortal.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                cq8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                cq8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    cq8Var2.x(selectPhotoAlbum.f());
                    cq8Var2.t(selectPhotoAlbum.b());
                    cq8Var2.o(selectPhotoAlbum.a());
                    cq8Var2.w(selectPhotoAlbum.e());
                    if (!cq8Var2.h()) {
                        cq8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, cq8Var2, false);
                    }
                }
                cq8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                cq8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                cq8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    cq8Var2.x(selectPrivateMsg.f());
                    cq8Var2.t(selectPrivateMsg.b());
                    cq8Var2.o(selectPrivateMsg.a());
                    cq8Var2.w(selectPrivateMsg.e());
                    if (!cq8Var2.h()) {
                        cq8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", cq8Var2, false);
                    }
                }
                cq8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                cq8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                cq8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    cq8Var2.x(reportUserTheme.f());
                    cq8Var2.t(reportUserTheme.b());
                    cq8Var2.o(reportUserTheme.a());
                    cq8Var2.w(reportUserTheme.e());
                    if (!cq8Var2.h()) {
                        cq8Var2.n(false);
                        addObserver("goToReportThreadPage", cq8Var2, false);
                    }
                }
                cq8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                cq8Var2.r(true);
                cq8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    cq8Var2.x(playSound.f());
                    cq8Var2.t(playSound.b());
                    cq8Var2.o(playSound.a());
                    cq8Var2.w(playSound.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                cq8Var2.r(true);
                cq8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    cq8Var2.x(playVibrate.f());
                    cq8Var2.t(playVibrate.b());
                    cq8Var2.o(playVibrate.a());
                    cq8Var2.w(playVibrate.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                cq8Var2.r(true);
                cq8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    cq8Var2.x(jumpLoginActivity.f());
                    cq8Var2.t(jumpLoginActivity.b());
                    cq8Var2.o(jumpLoginActivity.a());
                    cq8Var2.w(jumpLoginActivity.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                cq8Var2.r(true);
                cq8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    cq8Var2.x(startLoadTimeInterval.f());
                    cq8Var2.t(startLoadTimeInterval.b());
                    cq8Var2.o(startLoadTimeInterval.a());
                    cq8Var2.w(startLoadTimeInterval.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                cq8Var2.r(true);
                cq8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    cq8Var2.x(zid.f());
                    cq8Var2.t(zid.b());
                    cq8Var2.o(zid.a());
                    cq8Var2.w(zid.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                cq8Var2.r(true);
                cq8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    cq8Var2.x(hdid.f());
                    cq8Var2.t(hdid.b());
                    cq8Var2.o(hdid.a());
                    cq8Var2.w(hdid.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                cq8Var2.r(true);
                cq8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    cq8Var2.x(shareInfo.f());
                    cq8Var2.t(shareInfo.b());
                    cq8Var2.o(shareInfo.a());
                    cq8Var2.w(shareInfo.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("share/share")) {
                cq8Var2.r(true);
                cq8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"));
                if (share != null) {
                    cq8Var2.x(share.f());
                    cq8Var2.t(share.b());
                    cq8Var2.o(share.a());
                    cq8Var2.w(share.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                cq8Var2.r(true);
                cq8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    cq8Var2.x(clipperInformation.f());
                    cq8Var2.t(clipperInformation.b());
                    cq8Var2.o(clipperInformation.a());
                    cq8Var2.w(clipperInformation.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                cq8Var2.r(true);
                cq8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    cq8Var2.x(clipperInformation2.f());
                    cq8Var2.t(clipperInformation2.b());
                    cq8Var2.o(clipperInformation2.a());
                    cq8Var2.w(clipperInformation2.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                cq8Var2.r(true);
                cq8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    cq8Var2.x(goToEditPost.f());
                    cq8Var2.t(goToEditPost.b());
                    cq8Var2.o(goToEditPost.a());
                    cq8Var2.w(goToEditPost.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                cq8Var2.r(true);
                cq8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    cq8Var2.x(updateSearchForumInfo.f());
                    cq8Var2.t(updateSearchForumInfo.b());
                    cq8Var2.o(updateSearchForumInfo.a());
                    cq8Var2.w(updateSearchForumInfo.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                cq8Var2.r(true);
                cq8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    cq8Var2.x(personlizedSwitchChange.f());
                    cq8Var2.t(personlizedSwitchChange.b());
                    cq8Var2.o(personlizedSwitchChange.a());
                    cq8Var2.w(personlizedSwitchChange.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                cq8Var2.r(true);
                cq8 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    cq8Var2.x(updateTailStyle.f());
                    cq8Var2.t(updateTailStyle.b());
                    cq8Var2.o(updateTailStyle.a());
                    cq8Var2.w(updateTailStyle.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                cq8Var2.r(true);
                cq8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    cq8Var2.x(goToVideoImmersivePage.f());
                    cq8Var2.t(goToVideoImmersivePage.b());
                    cq8Var2.o(goToVideoImmersivePage.a());
                    cq8Var2.w(goToVideoImmersivePage.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                cq8Var2.r(true);
                cq8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    cq8Var2.x(jumpToVideo.f());
                    cq8Var2.t(jumpToVideo.b());
                    cq8Var2.o(jumpToVideo.a());
                    cq8Var2.w(jumpToVideo.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                cq8Var2.r(true);
                cq8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    cq8Var2.x(closeNativeMask.f());
                    cq8Var2.t(closeNativeMask.b());
                    cq8Var2.o(closeNativeMask.a());
                    cq8Var2.w(closeNativeMask.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                cq8Var2.r(true);
                cq8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    cq8Var2.x(checkAppInstall.f());
                    cq8Var2.t(checkAppInstall.b());
                    cq8Var2.o(checkAppInstall.a());
                    cq8Var2.w(checkAppInstall.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                cq8Var2.r(true);
                cq8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    cq8Var2.x(disableBack.f());
                    cq8Var2.t(disableBack.b());
                    cq8Var2.o(disableBack.a());
                    cq8Var2.w(disableBack.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                cq8Var2.r(true);
                cq8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    cq8Var2.x(startApp.f());
                    cq8Var2.t(startApp.b());
                    cq8Var2.o(startApp.a());
                    cq8Var2.w(startApp.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                cq8Var2.r(true);
                cq8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    cq8Var2.x(hasNotificationPermission.f());
                    cq8Var2.t(hasNotificationPermission.b());
                    cq8Var2.o(hasNotificationPermission.a());
                    cq8Var2.w(hasNotificationPermission.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                cq8Var2.r(true);
                cq8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    cq8Var2.x(goToNotificationSetting.f());
                    cq8Var2.t(goToNotificationSetting.b());
                    cq8Var2.o(goToNotificationSetting.a());
                    cq8Var2.w(goToNotificationSetting.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                cq8Var2.r(true);
                cq8 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushManager.APP_VERSION_CODE), e.optString("pkgName"));
                if (startDownloadGameApk != null) {
                    cq8Var2.x(startDownloadGameApk.f());
                    cq8Var2.t(startDownloadGameApk.b());
                    cq8Var2.o(startDownloadGameApk.a());
                    cq8Var2.w(startDownloadGameApk.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                cq8Var2.r(true);
                cq8 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    cq8Var2.x(checkInstallGameApk.f());
                    cq8Var2.t(checkInstallGameApk.b());
                    cq8Var2.o(checkInstallGameApk.a());
                    cq8Var2.w(checkInstallGameApk.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                cq8Var2.r(true);
                cq8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    cq8Var2.x(startDownloadCss.f());
                    cq8Var2.t(startDownloadCss.b());
                    cq8Var2.o(startDownloadCss.a());
                    cq8Var2.w(startDownloadCss.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                cq8Var2.r(true);
                cq8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    cq8Var2.x(disableGoBack.f());
                    cq8Var2.t(disableGoBack.b());
                    cq8Var2.o(disableGoBack.a());
                    cq8Var2.w(disableGoBack.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                cq8Var2.r(true);
                cq8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    cq8Var2.x(supplementInfo.f());
                    cq8Var2.t(supplementInfo.b());
                    cq8Var2.o(supplementInfo.a());
                    cq8Var2.w(supplementInfo.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                cq8Var2.r(true);
                cq8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    cq8Var2.x(deviceInfo.f());
                    cq8Var2.t(deviceInfo.b());
                    cq8Var2.o(deviceInfo.a());
                    cq8Var2.w(deviceInfo.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                cq8Var2.r(true);
                cq8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    cq8Var2.x(sendCompleteTaskReqMsg.f());
                    cq8Var2.t(sendCompleteTaskReqMsg.b());
                    cq8Var2.o(sendCompleteTaskReqMsg.a());
                    cq8Var2.w(sendCompleteTaskReqMsg.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                cq8Var2.r(true);
                cq8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    cq8Var2.x(showTipToast.f());
                    cq8Var2.t(showTipToast.b());
                    cq8Var2.o(showTipToast.a());
                    cq8Var2.w(showTipToast.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                cq8Var2.r(true);
                cq8 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    cq8Var2.x(getModalData.f());
                    cq8Var2.t(getModalData.b());
                    cq8Var2.o(getModalData.a());
                    cq8Var2.w(getModalData.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                cq8Var2.r(true);
                cq8 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    cq8Var2.x(openThirdPartApp.f());
                    cq8Var2.t(openThirdPartApp.b());
                    cq8Var2.o(openThirdPartApp.a());
                    cq8Var2.w(openThirdPartApp.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                cq8Var2.r(true);
                cq8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    cq8Var2.x(jumpToHtmlPage.f());
                    cq8Var2.t(jumpToHtmlPage.b());
                    cq8Var2.o(jumpToHtmlPage.a());
                    cq8Var2.w(jumpToHtmlPage.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                cq8Var2.r(true);
                cq8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    cq8Var2.x(offlineUserInfo.f());
                    cq8Var2.t(offlineUserInfo.b());
                    cq8Var2.o(offlineUserInfo.a());
                    cq8Var2.w(offlineUserInfo.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                cq8Var2.r(true);
                cq8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    cq8Var2.x(deleteOfflineBundle.f());
                    cq8Var2.t(deleteOfflineBundle.b());
                    cq8Var2.o(deleteOfflineBundle.a());
                    cq8Var2.w(deleteOfflineBundle.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                cq8Var2.r(true);
                cq8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    cq8Var2.x(updateOfflineBundle.f());
                    cq8Var2.t(updateOfflineBundle.b());
                    cq8Var2.o(updateOfflineBundle.a());
                    cq8Var2.w(updateOfflineBundle.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                cq8Var2.r(true);
                cq8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    cq8Var2.x(switchOfflineInterface.f());
                    cq8Var2.t(switchOfflineInterface.b());
                    cq8Var2.o(switchOfflineInterface.a());
                    cq8Var2.w(switchOfflineInterface.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                cq8Var2.r(true);
                cq8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    cq8Var2.x(switchOfflineBundleStatus.f());
                    cq8Var2.t(switchOfflineBundleStatus.b());
                    cq8Var2.o(switchOfflineBundleStatus.a());
                    cq8Var2.w(switchOfflineBundleStatus.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                cq8Var2.r(true);
                cq8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    cq8Var2.x(finishTestAnswer.f());
                    cq8Var2.t(finishTestAnswer.b());
                    cq8Var2.o(finishTestAnswer.a());
                    cq8Var2.w(finishTestAnswer.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                cq8Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                cq8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    cq8Var2.x(switchUrlHost.f());
                    cq8Var2.t(switchUrlHost.b());
                    cq8Var2.o(switchUrlHost.a());
                    cq8Var2.w(switchUrlHost.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                cq8Var2.r(true);
                cq8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    cq8Var2.x(appStorage.f());
                    cq8Var2.t(appStorage.b());
                    cq8Var2.o(appStorage.a());
                    cq8Var2.w(appStorage.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                cq8Var2.r(true);
                cq8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    cq8Var2.x(putAppStorage.f());
                    cq8Var2.t(putAppStorage.b());
                    cq8Var2.o(putAppStorage.a());
                    cq8Var2.w(putAppStorage.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                cq8Var2.r(true);
                cq8 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    cq8Var2.x(historyForumData.f());
                    cq8Var2.t(historyForumData.b());
                    cq8Var2.o(historyForumData.a());
                    cq8Var2.w(historyForumData.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                cq8Var2.r(true);
                cq8 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    cq8Var2.x(worldCupRaiseSuccess.f());
                    cq8Var2.t(worldCupRaiseSuccess.b());
                    cq8Var2.o(worldCupRaiseSuccess.a());
                    cq8Var2.w(worldCupRaiseSuccess.e());
                }
                cq8Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                cq8Var2.r(true);
                cq8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    cq8Var2.x(requestByNative.f());
                    cq8Var2.t(requestByNative.b());
                    cq8Var2.o(requestByNative.a());
                    cq8Var2.w(requestByNative.e());
                    if (!cq8Var2.h()) {
                        cq8Var2.n(false);
                        addObserver("RequestByNativeToH5", cq8Var2, false);
                    }
                }
                cq8Var2.y(0);
            }
            return cq8Var2;
        }
        return (cq8) invokeLL.objValue;
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
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("saveImageSuccess");
        this.mNotificationNameList.add("orderGameApkResult");
        this.mNotificationNameList.add("GetPhotoAlbum");
        this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
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
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.aq8
    public List<cq8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            cq8 cq8Var = null;
            if (xi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                cq8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                cq8Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                cq8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                cq8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                cq8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                cq8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                cq8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                cq8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                cq8Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                cq8Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                cq8Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                cq8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                cq8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                cq8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                cq8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                cq8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                cq8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                cq8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                cq8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                cq8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                cq8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (cq8Var != null) {
                cq8Var.y(0);
            }
            List<bq8> list = this.mAsyncCallBackMethodList.get(str);
            if (cq8Var != null && list != null) {
                Iterator<bq8> it = list.iterator();
                if (!xi.isEmpty(cq8Var.e())) {
                    while (it.hasNext()) {
                        bq8 next = it.next();
                        if (next.b().equals(cq8Var.e())) {
                            cq8 cq8Var2 = new cq8();
                            cq8Var2.v(next.a());
                            cq8Var2.x(cq8Var.f());
                            cq8Var2.t(cq8Var.b());
                            cq8Var2.o(cq8Var.a());
                            cq8Var2.z(cq8Var.l());
                            arrayList.add(cq8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        bq8 next2 = it.next();
                        cq8 cq8Var3 = new cq8();
                        cq8Var3.v(next2.a());
                        cq8Var3.x(cq8Var.f());
                        cq8Var3.t(cq8Var.b());
                        cq8Var3.o(cq8Var.a());
                        cq8Var3.z(cq8Var.l());
                        arrayList.add(cq8Var3);
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
