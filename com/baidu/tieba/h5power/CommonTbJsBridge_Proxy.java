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
import com.baidu.tieba.bq8;
import com.baidu.tieba.cq8;
import com.baidu.tieba.dq8;
import com.baidu.tieba.fq8;
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
public class CommonTbJsBridge_Proxy extends bq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.bq8
    public dq8 dispatch(fq8 fq8Var, dq8 dq8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fq8Var, dq8Var)) == null) {
            dq8 dq8Var2 = dq8Var == null ? new dq8() : dq8Var;
            String b = fq8Var.b();
            JSONObject e = fq8Var.e();
            if (b.equals("account/startLoginModule")) {
                dq8Var2.r(true);
                dq8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    dq8Var2.x(startLoginModule.f());
                    dq8Var2.t(startLoginModule.b());
                    dq8Var2.o(startLoginModule.a());
                    dq8Var2.w(startLoginModule.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                dq8Var2.r(true);
                dq8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    dq8Var2.x(finishPage.f());
                    dq8Var2.t(finishPage.b());
                    dq8Var2.o(finishPage.a());
                    dq8Var2.w(finishPage.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                dq8Var2.r(true);
                dq8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    dq8Var2.x(showLowerHairHint.f());
                    dq8Var2.t(showLowerHairHint.b());
                    dq8Var2.o(showLowerHairHint.a());
                    dq8Var2.w(showLowerHairHint.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                dq8Var2.r(true);
                dq8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    dq8Var2.x(gamePush.f());
                    dq8Var2.t(gamePush.b());
                    dq8Var2.o(gamePush.a());
                    dq8Var2.w(gamePush.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                dq8Var2.r(true);
                dq8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    dq8Var2.x(handleGamePushStatus.f());
                    dq8Var2.t(handleGamePushStatus.b());
                    dq8Var2.o(handleGamePushStatus.a());
                    dq8Var2.w(handleGamePushStatus.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                dq8Var2.r(true);
                dq8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    dq8Var2.x(jumpForumRulesEditPage.f());
                    dq8Var2.t(jumpForumRulesEditPage.b());
                    dq8Var2.o(jumpForumRulesEditPage.a());
                    dq8Var2.w(jumpForumRulesEditPage.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                dq8Var2.r(true);
                dq8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    dq8Var2.x(handleGoToBarDetail.f());
                    dq8Var2.t(handleGoToBarDetail.b());
                    dq8Var2.o(handleGoToBarDetail.a());
                    dq8Var2.w(handleGoToBarDetail.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                dq8Var2.r(true);
                dq8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    dq8Var2.x(handleSaveImage.f());
                    dq8Var2.t(handleSaveImage.b());
                    dq8Var2.o(handleSaveImage.a());
                    dq8Var2.w(handleSaveImage.e());
                    if (!dq8Var2.h()) {
                        dq8Var2.n(false);
                        addObserver("saveImageSuccess", dq8Var2, false);
                    }
                }
                dq8Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                dq8Var2.r(true);
                dq8 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    dq8Var2.x(orderGameApk.f());
                    dq8Var2.t(orderGameApk.b());
                    dq8Var2.o(orderGameApk.a());
                    dq8Var2.w(orderGameApk.e());
                    if (!dq8Var2.h()) {
                        dq8Var2.n(false);
                        addObserver("orderGameApkResult", dq8Var2, false);
                    }
                }
                dq8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                dq8Var2.r(true);
                dq8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    dq8Var2.x(handleGetPhotoAlbum.f());
                    dq8Var2.t(handleGetPhotoAlbum.b());
                    dq8Var2.o(handleGetPhotoAlbum.a());
                    dq8Var2.w(handleGetPhotoAlbum.e());
                    if (!dq8Var2.h()) {
                        dq8Var2.n(false);
                        addObserver("GetPhotoAlbum", dq8Var2, false);
                    }
                }
                dq8Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                dq8Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                dq8 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    dq8Var2.x(preheatWeb.f());
                    dq8Var2.t(preheatWeb.b());
                    dq8Var2.o(preheatWeb.a());
                    dq8Var2.w(preheatWeb.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                dq8Var2.r(true);
                dq8 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    dq8Var2.x(openMXDYab.f());
                    dq8Var2.t(openMXDYab.b());
                    dq8Var2.o(openMXDYab.a());
                    dq8Var2.w(openMXDYab.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("router/portal")) {
                dq8Var2.r(true);
                dq8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    dq8Var2.x(handlePortal.f());
                    dq8Var2.t(handlePortal.b());
                    dq8Var2.o(handlePortal.a());
                    dq8Var2.w(handlePortal.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                dq8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                dq8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    dq8Var2.x(selectPhotoAlbum.f());
                    dq8Var2.t(selectPhotoAlbum.b());
                    dq8Var2.o(selectPhotoAlbum.a());
                    dq8Var2.w(selectPhotoAlbum.e());
                    if (!dq8Var2.h()) {
                        dq8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, dq8Var2, false);
                    }
                }
                dq8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                dq8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                dq8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    dq8Var2.x(selectPrivateMsg.f());
                    dq8Var2.t(selectPrivateMsg.b());
                    dq8Var2.o(selectPrivateMsg.a());
                    dq8Var2.w(selectPrivateMsg.e());
                    if (!dq8Var2.h()) {
                        dq8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", dq8Var2, false);
                    }
                }
                dq8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                dq8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                dq8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    dq8Var2.x(reportUserTheme.f());
                    dq8Var2.t(reportUserTheme.b());
                    dq8Var2.o(reportUserTheme.a());
                    dq8Var2.w(reportUserTheme.e());
                    if (!dq8Var2.h()) {
                        dq8Var2.n(false);
                        addObserver("goToReportThreadPage", dq8Var2, false);
                    }
                }
                dq8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                dq8Var2.r(true);
                dq8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    dq8Var2.x(playSound.f());
                    dq8Var2.t(playSound.b());
                    dq8Var2.o(playSound.a());
                    dq8Var2.w(playSound.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                dq8Var2.r(true);
                dq8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    dq8Var2.x(playVibrate.f());
                    dq8Var2.t(playVibrate.b());
                    dq8Var2.o(playVibrate.a());
                    dq8Var2.w(playVibrate.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                dq8Var2.r(true);
                dq8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    dq8Var2.x(jumpLoginActivity.f());
                    dq8Var2.t(jumpLoginActivity.b());
                    dq8Var2.o(jumpLoginActivity.a());
                    dq8Var2.w(jumpLoginActivity.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                dq8Var2.r(true);
                dq8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    dq8Var2.x(startLoadTimeInterval.f());
                    dq8Var2.t(startLoadTimeInterval.b());
                    dq8Var2.o(startLoadTimeInterval.a());
                    dq8Var2.w(startLoadTimeInterval.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                dq8Var2.r(true);
                dq8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    dq8Var2.x(zid.f());
                    dq8Var2.t(zid.b());
                    dq8Var2.o(zid.a());
                    dq8Var2.w(zid.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                dq8Var2.r(true);
                dq8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    dq8Var2.x(hdid.f());
                    dq8Var2.t(hdid.b());
                    dq8Var2.o(hdid.a());
                    dq8Var2.w(hdid.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                dq8Var2.r(true);
                dq8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    dq8Var2.x(shareInfo.f());
                    dq8Var2.t(shareInfo.b());
                    dq8Var2.o(shareInfo.a());
                    dq8Var2.w(shareInfo.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("share/share")) {
                dq8Var2.r(true);
                dq8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"));
                if (share != null) {
                    dq8Var2.x(share.f());
                    dq8Var2.t(share.b());
                    dq8Var2.o(share.a());
                    dq8Var2.w(share.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                dq8Var2.r(true);
                dq8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    dq8Var2.x(clipperInformation.f());
                    dq8Var2.t(clipperInformation.b());
                    dq8Var2.o(clipperInformation.a());
                    dq8Var2.w(clipperInformation.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                dq8Var2.r(true);
                dq8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    dq8Var2.x(clipperInformation2.f());
                    dq8Var2.t(clipperInformation2.b());
                    dq8Var2.o(clipperInformation2.a());
                    dq8Var2.w(clipperInformation2.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                dq8Var2.r(true);
                dq8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    dq8Var2.x(goToEditPost.f());
                    dq8Var2.t(goToEditPost.b());
                    dq8Var2.o(goToEditPost.a());
                    dq8Var2.w(goToEditPost.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                dq8Var2.r(true);
                dq8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    dq8Var2.x(updateSearchForumInfo.f());
                    dq8Var2.t(updateSearchForumInfo.b());
                    dq8Var2.o(updateSearchForumInfo.a());
                    dq8Var2.w(updateSearchForumInfo.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                dq8Var2.r(true);
                dq8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    dq8Var2.x(personlizedSwitchChange.f());
                    dq8Var2.t(personlizedSwitchChange.b());
                    dq8Var2.o(personlizedSwitchChange.a());
                    dq8Var2.w(personlizedSwitchChange.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                dq8Var2.r(true);
                dq8 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    dq8Var2.x(updateTailStyle.f());
                    dq8Var2.t(updateTailStyle.b());
                    dq8Var2.o(updateTailStyle.a());
                    dq8Var2.w(updateTailStyle.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                dq8Var2.r(true);
                dq8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    dq8Var2.x(goToVideoImmersivePage.f());
                    dq8Var2.t(goToVideoImmersivePage.b());
                    dq8Var2.o(goToVideoImmersivePage.a());
                    dq8Var2.w(goToVideoImmersivePage.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                dq8Var2.r(true);
                dq8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    dq8Var2.x(jumpToVideo.f());
                    dq8Var2.t(jumpToVideo.b());
                    dq8Var2.o(jumpToVideo.a());
                    dq8Var2.w(jumpToVideo.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                dq8Var2.r(true);
                dq8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    dq8Var2.x(closeNativeMask.f());
                    dq8Var2.t(closeNativeMask.b());
                    dq8Var2.o(closeNativeMask.a());
                    dq8Var2.w(closeNativeMask.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                dq8Var2.r(true);
                dq8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    dq8Var2.x(checkAppInstall.f());
                    dq8Var2.t(checkAppInstall.b());
                    dq8Var2.o(checkAppInstall.a());
                    dq8Var2.w(checkAppInstall.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                dq8Var2.r(true);
                dq8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    dq8Var2.x(disableBack.f());
                    dq8Var2.t(disableBack.b());
                    dq8Var2.o(disableBack.a());
                    dq8Var2.w(disableBack.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                dq8Var2.r(true);
                dq8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    dq8Var2.x(startApp.f());
                    dq8Var2.t(startApp.b());
                    dq8Var2.o(startApp.a());
                    dq8Var2.w(startApp.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                dq8Var2.r(true);
                dq8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    dq8Var2.x(hasNotificationPermission.f());
                    dq8Var2.t(hasNotificationPermission.b());
                    dq8Var2.o(hasNotificationPermission.a());
                    dq8Var2.w(hasNotificationPermission.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                dq8Var2.r(true);
                dq8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    dq8Var2.x(goToNotificationSetting.f());
                    dq8Var2.t(goToNotificationSetting.b());
                    dq8Var2.o(goToNotificationSetting.a());
                    dq8Var2.w(goToNotificationSetting.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                dq8Var2.r(true);
                dq8 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushManager.APP_VERSION_CODE), e.optString("pkgName"));
                if (startDownloadGameApk != null) {
                    dq8Var2.x(startDownloadGameApk.f());
                    dq8Var2.t(startDownloadGameApk.b());
                    dq8Var2.o(startDownloadGameApk.a());
                    dq8Var2.w(startDownloadGameApk.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                dq8Var2.r(true);
                dq8 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    dq8Var2.x(checkInstallGameApk.f());
                    dq8Var2.t(checkInstallGameApk.b());
                    dq8Var2.o(checkInstallGameApk.a());
                    dq8Var2.w(checkInstallGameApk.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                dq8Var2.r(true);
                dq8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    dq8Var2.x(startDownloadCss.f());
                    dq8Var2.t(startDownloadCss.b());
                    dq8Var2.o(startDownloadCss.a());
                    dq8Var2.w(startDownloadCss.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                dq8Var2.r(true);
                dq8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    dq8Var2.x(disableGoBack.f());
                    dq8Var2.t(disableGoBack.b());
                    dq8Var2.o(disableGoBack.a());
                    dq8Var2.w(disableGoBack.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                dq8Var2.r(true);
                dq8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    dq8Var2.x(supplementInfo.f());
                    dq8Var2.t(supplementInfo.b());
                    dq8Var2.o(supplementInfo.a());
                    dq8Var2.w(supplementInfo.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                dq8Var2.r(true);
                dq8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    dq8Var2.x(deviceInfo.f());
                    dq8Var2.t(deviceInfo.b());
                    dq8Var2.o(deviceInfo.a());
                    dq8Var2.w(deviceInfo.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                dq8Var2.r(true);
                dq8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    dq8Var2.x(sendCompleteTaskReqMsg.f());
                    dq8Var2.t(sendCompleteTaskReqMsg.b());
                    dq8Var2.o(sendCompleteTaskReqMsg.a());
                    dq8Var2.w(sendCompleteTaskReqMsg.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                dq8Var2.r(true);
                dq8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    dq8Var2.x(showTipToast.f());
                    dq8Var2.t(showTipToast.b());
                    dq8Var2.o(showTipToast.a());
                    dq8Var2.w(showTipToast.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                dq8Var2.r(true);
                dq8 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    dq8Var2.x(getModalData.f());
                    dq8Var2.t(getModalData.b());
                    dq8Var2.o(getModalData.a());
                    dq8Var2.w(getModalData.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                dq8Var2.r(true);
                dq8 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    dq8Var2.x(openThirdPartApp.f());
                    dq8Var2.t(openThirdPartApp.b());
                    dq8Var2.o(openThirdPartApp.a());
                    dq8Var2.w(openThirdPartApp.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                dq8Var2.r(true);
                dq8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    dq8Var2.x(jumpToHtmlPage.f());
                    dq8Var2.t(jumpToHtmlPage.b());
                    dq8Var2.o(jumpToHtmlPage.a());
                    dq8Var2.w(jumpToHtmlPage.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                dq8Var2.r(true);
                dq8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    dq8Var2.x(offlineUserInfo.f());
                    dq8Var2.t(offlineUserInfo.b());
                    dq8Var2.o(offlineUserInfo.a());
                    dq8Var2.w(offlineUserInfo.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                dq8Var2.r(true);
                dq8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    dq8Var2.x(deleteOfflineBundle.f());
                    dq8Var2.t(deleteOfflineBundle.b());
                    dq8Var2.o(deleteOfflineBundle.a());
                    dq8Var2.w(deleteOfflineBundle.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                dq8Var2.r(true);
                dq8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    dq8Var2.x(updateOfflineBundle.f());
                    dq8Var2.t(updateOfflineBundle.b());
                    dq8Var2.o(updateOfflineBundle.a());
                    dq8Var2.w(updateOfflineBundle.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                dq8Var2.r(true);
                dq8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    dq8Var2.x(switchOfflineInterface.f());
                    dq8Var2.t(switchOfflineInterface.b());
                    dq8Var2.o(switchOfflineInterface.a());
                    dq8Var2.w(switchOfflineInterface.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                dq8Var2.r(true);
                dq8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    dq8Var2.x(switchOfflineBundleStatus.f());
                    dq8Var2.t(switchOfflineBundleStatus.b());
                    dq8Var2.o(switchOfflineBundleStatus.a());
                    dq8Var2.w(switchOfflineBundleStatus.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                dq8Var2.r(true);
                dq8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    dq8Var2.x(finishTestAnswer.f());
                    dq8Var2.t(finishTestAnswer.b());
                    dq8Var2.o(finishTestAnswer.a());
                    dq8Var2.w(finishTestAnswer.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                dq8Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                dq8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    dq8Var2.x(switchUrlHost.f());
                    dq8Var2.t(switchUrlHost.b());
                    dq8Var2.o(switchUrlHost.a());
                    dq8Var2.w(switchUrlHost.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                dq8Var2.r(true);
                dq8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    dq8Var2.x(appStorage.f());
                    dq8Var2.t(appStorage.b());
                    dq8Var2.o(appStorage.a());
                    dq8Var2.w(appStorage.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                dq8Var2.r(true);
                dq8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    dq8Var2.x(putAppStorage.f());
                    dq8Var2.t(putAppStorage.b());
                    dq8Var2.o(putAppStorage.a());
                    dq8Var2.w(putAppStorage.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                dq8Var2.r(true);
                dq8 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    dq8Var2.x(historyForumData.f());
                    dq8Var2.t(historyForumData.b());
                    dq8Var2.o(historyForumData.a());
                    dq8Var2.w(historyForumData.e());
                }
                dq8Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                dq8Var2.r(true);
                dq8 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    dq8Var2.x(worldCupRaiseSuccess.f());
                    dq8Var2.t(worldCupRaiseSuccess.b());
                    dq8Var2.o(worldCupRaiseSuccess.a());
                    dq8Var2.w(worldCupRaiseSuccess.e());
                }
                dq8Var2.y(0);
            }
            return dq8Var2;
        }
        return (dq8) invokeLL.objValue;
    }

    public CommonTbJsBridge_Proxy(CommonTbJsBridge commonTbJsBridge) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {commonTbJsBridge};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = commonTbJsBridge;
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
    }

    @Override // com.baidu.tieba.bq8
    public List<dq8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            dq8 dq8Var = null;
            if (xi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                dq8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                dq8Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                dq8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                dq8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                dq8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                dq8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                dq8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                dq8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                dq8Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                dq8Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                dq8Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                dq8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                dq8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                dq8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                dq8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                dq8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                dq8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                dq8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                dq8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                dq8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            }
            if (dq8Var != null) {
                dq8Var.y(0);
            }
            List<cq8> list = this.mAsyncCallBackMethodList.get(str);
            if (dq8Var != null && list != null) {
                Iterator<cq8> it = list.iterator();
                if (!xi.isEmpty(dq8Var.e())) {
                    while (it.hasNext()) {
                        cq8 next = it.next();
                        if (next.b().equals(dq8Var.e())) {
                            dq8 dq8Var2 = new dq8();
                            dq8Var2.v(next.a());
                            dq8Var2.x(dq8Var.f());
                            dq8Var2.t(dq8Var.b());
                            dq8Var2.o(dq8Var.a());
                            dq8Var2.z(dq8Var.l());
                            arrayList.add(dq8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        cq8 next2 = it.next();
                        dq8 dq8Var3 = new dq8();
                        dq8Var3.v(next2.a());
                        dq8Var3.x(dq8Var.f());
                        dq8Var3.t(dq8Var.b());
                        dq8Var3.o(dq8Var.a());
                        dq8Var3.z(dq8Var.l());
                        arrayList.add(dq8Var3);
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
