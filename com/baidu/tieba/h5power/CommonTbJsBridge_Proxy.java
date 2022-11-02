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
import com.baidu.tieba.pp8;
import com.baidu.tieba.qp8;
import com.baidu.tieba.rp8;
import com.baidu.tieba.tp8;
import com.baidu.tieba.wi;
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
public class CommonTbJsBridge_Proxy extends pp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.pp8
    public rp8 dispatch(tp8 tp8Var, rp8 rp8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tp8Var, rp8Var)) == null) {
            rp8 rp8Var2 = rp8Var == null ? new rp8() : rp8Var;
            String b = tp8Var.b();
            JSONObject e = tp8Var.e();
            if (b.equals("account/startLoginModule")) {
                rp8Var2.r(true);
                rp8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    rp8Var2.x(startLoginModule.f());
                    rp8Var2.t(startLoginModule.b());
                    rp8Var2.o(startLoginModule.a());
                    rp8Var2.w(startLoginModule.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                rp8Var2.r(true);
                rp8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    rp8Var2.x(finishPage.f());
                    rp8Var2.t(finishPage.b());
                    rp8Var2.o(finishPage.a());
                    rp8Var2.w(finishPage.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                rp8Var2.r(true);
                rp8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    rp8Var2.x(showLowerHairHint.f());
                    rp8Var2.t(showLowerHairHint.b());
                    rp8Var2.o(showLowerHairHint.a());
                    rp8Var2.w(showLowerHairHint.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                rp8Var2.r(true);
                rp8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    rp8Var2.x(gamePush.f());
                    rp8Var2.t(gamePush.b());
                    rp8Var2.o(gamePush.a());
                    rp8Var2.w(gamePush.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                rp8Var2.r(true);
                rp8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    rp8Var2.x(handleGamePushStatus.f());
                    rp8Var2.t(handleGamePushStatus.b());
                    rp8Var2.o(handleGamePushStatus.a());
                    rp8Var2.w(handleGamePushStatus.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                rp8Var2.r(true);
                rp8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    rp8Var2.x(jumpForumRulesEditPage.f());
                    rp8Var2.t(jumpForumRulesEditPage.b());
                    rp8Var2.o(jumpForumRulesEditPage.a());
                    rp8Var2.w(jumpForumRulesEditPage.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                rp8Var2.r(true);
                rp8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    rp8Var2.x(handleGoToBarDetail.f());
                    rp8Var2.t(handleGoToBarDetail.b());
                    rp8Var2.o(handleGoToBarDetail.a());
                    rp8Var2.w(handleGoToBarDetail.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                rp8Var2.r(true);
                rp8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    rp8Var2.x(handleSaveImage.f());
                    rp8Var2.t(handleSaveImage.b());
                    rp8Var2.o(handleSaveImage.a());
                    rp8Var2.w(handleSaveImage.e());
                    if (!rp8Var2.h()) {
                        rp8Var2.n(false);
                        addObserver("saveImageSuccess", rp8Var2, false);
                    }
                }
                rp8Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                rp8Var2.r(true);
                rp8 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    rp8Var2.x(orderGameApk.f());
                    rp8Var2.t(orderGameApk.b());
                    rp8Var2.o(orderGameApk.a());
                    rp8Var2.w(orderGameApk.e());
                    if (!rp8Var2.h()) {
                        rp8Var2.n(false);
                        addObserver("orderGameApkResult", rp8Var2, false);
                    }
                }
                rp8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                rp8Var2.r(true);
                rp8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    rp8Var2.x(handleGetPhotoAlbum.f());
                    rp8Var2.t(handleGetPhotoAlbum.b());
                    rp8Var2.o(handleGetPhotoAlbum.a());
                    rp8Var2.w(handleGetPhotoAlbum.e());
                    if (!rp8Var2.h()) {
                        rp8Var2.n(false);
                        addObserver("GetPhotoAlbum", rp8Var2, false);
                    }
                }
                rp8Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                rp8Var2.r(true);
                rp8 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    rp8Var2.x(openMXDYab.f());
                    rp8Var2.t(openMXDYab.b());
                    rp8Var2.o(openMXDYab.a());
                    rp8Var2.w(openMXDYab.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("router/portal")) {
                rp8Var2.r(true);
                rp8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    rp8Var2.x(handlePortal.f());
                    rp8Var2.t(handlePortal.b());
                    rp8Var2.o(handlePortal.a());
                    rp8Var2.w(handlePortal.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                rp8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                rp8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    rp8Var2.x(selectPhotoAlbum.f());
                    rp8Var2.t(selectPhotoAlbum.b());
                    rp8Var2.o(selectPhotoAlbum.a());
                    rp8Var2.w(selectPhotoAlbum.e());
                    if (!rp8Var2.h()) {
                        rp8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, rp8Var2, false);
                    }
                }
                rp8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                rp8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                rp8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    rp8Var2.x(selectPrivateMsg.f());
                    rp8Var2.t(selectPrivateMsg.b());
                    rp8Var2.o(selectPrivateMsg.a());
                    rp8Var2.w(selectPrivateMsg.e());
                    if (!rp8Var2.h()) {
                        rp8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", rp8Var2, false);
                    }
                }
                rp8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                rp8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                rp8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    rp8Var2.x(reportUserTheme.f());
                    rp8Var2.t(reportUserTheme.b());
                    rp8Var2.o(reportUserTheme.a());
                    rp8Var2.w(reportUserTheme.e());
                    if (!rp8Var2.h()) {
                        rp8Var2.n(false);
                        addObserver("goToReportThreadPage", rp8Var2, false);
                    }
                }
                rp8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                rp8Var2.r(true);
                rp8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    rp8Var2.x(playSound.f());
                    rp8Var2.t(playSound.b());
                    rp8Var2.o(playSound.a());
                    rp8Var2.w(playSound.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                rp8Var2.r(true);
                rp8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    rp8Var2.x(playVibrate.f());
                    rp8Var2.t(playVibrate.b());
                    rp8Var2.o(playVibrate.a());
                    rp8Var2.w(playVibrate.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                rp8Var2.r(true);
                rp8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    rp8Var2.x(jumpLoginActivity.f());
                    rp8Var2.t(jumpLoginActivity.b());
                    rp8Var2.o(jumpLoginActivity.a());
                    rp8Var2.w(jumpLoginActivity.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                rp8Var2.r(true);
                rp8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    rp8Var2.x(startLoadTimeInterval.f());
                    rp8Var2.t(startLoadTimeInterval.b());
                    rp8Var2.o(startLoadTimeInterval.a());
                    rp8Var2.w(startLoadTimeInterval.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                rp8Var2.r(true);
                rp8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    rp8Var2.x(zid.f());
                    rp8Var2.t(zid.b());
                    rp8Var2.o(zid.a());
                    rp8Var2.w(zid.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                rp8Var2.r(true);
                rp8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    rp8Var2.x(hdid.f());
                    rp8Var2.t(hdid.b());
                    rp8Var2.o(hdid.a());
                    rp8Var2.w(hdid.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                rp8Var2.r(true);
                rp8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    rp8Var2.x(shareInfo.f());
                    rp8Var2.t(shareInfo.b());
                    rp8Var2.o(shareInfo.a());
                    rp8Var2.w(shareInfo.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("share/share")) {
                rp8Var2.r(true);
                rp8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"));
                if (share != null) {
                    rp8Var2.x(share.f());
                    rp8Var2.t(share.b());
                    rp8Var2.o(share.a());
                    rp8Var2.w(share.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                rp8Var2.r(true);
                rp8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    rp8Var2.x(clipperInformation.f());
                    rp8Var2.t(clipperInformation.b());
                    rp8Var2.o(clipperInformation.a());
                    rp8Var2.w(clipperInformation.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                rp8Var2.r(true);
                rp8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    rp8Var2.x(clipperInformation2.f());
                    rp8Var2.t(clipperInformation2.b());
                    rp8Var2.o(clipperInformation2.a());
                    rp8Var2.w(clipperInformation2.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                rp8Var2.r(true);
                rp8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    rp8Var2.x(goToEditPost.f());
                    rp8Var2.t(goToEditPost.b());
                    rp8Var2.o(goToEditPost.a());
                    rp8Var2.w(goToEditPost.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                rp8Var2.r(true);
                rp8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    rp8Var2.x(updateSearchForumInfo.f());
                    rp8Var2.t(updateSearchForumInfo.b());
                    rp8Var2.o(updateSearchForumInfo.a());
                    rp8Var2.w(updateSearchForumInfo.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                rp8Var2.r(true);
                rp8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    rp8Var2.x(personlizedSwitchChange.f());
                    rp8Var2.t(personlizedSwitchChange.b());
                    rp8Var2.o(personlizedSwitchChange.a());
                    rp8Var2.w(personlizedSwitchChange.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                rp8Var2.r(true);
                rp8 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    rp8Var2.x(updateTailStyle.f());
                    rp8Var2.t(updateTailStyle.b());
                    rp8Var2.o(updateTailStyle.a());
                    rp8Var2.w(updateTailStyle.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                rp8Var2.r(true);
                rp8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    rp8Var2.x(goToVideoImmersivePage.f());
                    rp8Var2.t(goToVideoImmersivePage.b());
                    rp8Var2.o(goToVideoImmersivePage.a());
                    rp8Var2.w(goToVideoImmersivePage.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                rp8Var2.r(true);
                rp8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    rp8Var2.x(jumpToVideo.f());
                    rp8Var2.t(jumpToVideo.b());
                    rp8Var2.o(jumpToVideo.a());
                    rp8Var2.w(jumpToVideo.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                rp8Var2.r(true);
                rp8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    rp8Var2.x(closeNativeMask.f());
                    rp8Var2.t(closeNativeMask.b());
                    rp8Var2.o(closeNativeMask.a());
                    rp8Var2.w(closeNativeMask.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                rp8Var2.r(true);
                rp8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    rp8Var2.x(checkAppInstall.f());
                    rp8Var2.t(checkAppInstall.b());
                    rp8Var2.o(checkAppInstall.a());
                    rp8Var2.w(checkAppInstall.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                rp8Var2.r(true);
                rp8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    rp8Var2.x(disableBack.f());
                    rp8Var2.t(disableBack.b());
                    rp8Var2.o(disableBack.a());
                    rp8Var2.w(disableBack.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                rp8Var2.r(true);
                rp8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    rp8Var2.x(startApp.f());
                    rp8Var2.t(startApp.b());
                    rp8Var2.o(startApp.a());
                    rp8Var2.w(startApp.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                rp8Var2.r(true);
                rp8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    rp8Var2.x(hasNotificationPermission.f());
                    rp8Var2.t(hasNotificationPermission.b());
                    rp8Var2.o(hasNotificationPermission.a());
                    rp8Var2.w(hasNotificationPermission.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                rp8Var2.r(true);
                rp8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    rp8Var2.x(goToNotificationSetting.f());
                    rp8Var2.t(goToNotificationSetting.b());
                    rp8Var2.o(goToNotificationSetting.a());
                    rp8Var2.w(goToNotificationSetting.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                rp8Var2.r(true);
                rp8 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushManager.APP_VERSION_CODE), e.optString("pkgName"));
                if (startDownloadGameApk != null) {
                    rp8Var2.x(startDownloadGameApk.f());
                    rp8Var2.t(startDownloadGameApk.b());
                    rp8Var2.o(startDownloadGameApk.a());
                    rp8Var2.w(startDownloadGameApk.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                rp8Var2.r(true);
                rp8 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    rp8Var2.x(checkInstallGameApk.f());
                    rp8Var2.t(checkInstallGameApk.b());
                    rp8Var2.o(checkInstallGameApk.a());
                    rp8Var2.w(checkInstallGameApk.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                rp8Var2.r(true);
                rp8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    rp8Var2.x(startDownloadCss.f());
                    rp8Var2.t(startDownloadCss.b());
                    rp8Var2.o(startDownloadCss.a());
                    rp8Var2.w(startDownloadCss.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                rp8Var2.r(true);
                rp8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    rp8Var2.x(disableGoBack.f());
                    rp8Var2.t(disableGoBack.b());
                    rp8Var2.o(disableGoBack.a());
                    rp8Var2.w(disableGoBack.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                rp8Var2.r(true);
                rp8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    rp8Var2.x(supplementInfo.f());
                    rp8Var2.t(supplementInfo.b());
                    rp8Var2.o(supplementInfo.a());
                    rp8Var2.w(supplementInfo.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                rp8Var2.r(true);
                rp8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    rp8Var2.x(deviceInfo.f());
                    rp8Var2.t(deviceInfo.b());
                    rp8Var2.o(deviceInfo.a());
                    rp8Var2.w(deviceInfo.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                rp8Var2.r(true);
                rp8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    rp8Var2.x(sendCompleteTaskReqMsg.f());
                    rp8Var2.t(sendCompleteTaskReqMsg.b());
                    rp8Var2.o(sendCompleteTaskReqMsg.a());
                    rp8Var2.w(sendCompleteTaskReqMsg.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                rp8Var2.r(true);
                rp8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    rp8Var2.x(showTipToast.f());
                    rp8Var2.t(showTipToast.b());
                    rp8Var2.o(showTipToast.a());
                    rp8Var2.w(showTipToast.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                rp8Var2.r(true);
                rp8 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    rp8Var2.x(getModalData.f());
                    rp8Var2.t(getModalData.b());
                    rp8Var2.o(getModalData.a());
                    rp8Var2.w(getModalData.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                rp8Var2.r(true);
                rp8 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    rp8Var2.x(openThirdPartApp.f());
                    rp8Var2.t(openThirdPartApp.b());
                    rp8Var2.o(openThirdPartApp.a());
                    rp8Var2.w(openThirdPartApp.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                rp8Var2.r(true);
                rp8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    rp8Var2.x(jumpToHtmlPage.f());
                    rp8Var2.t(jumpToHtmlPage.b());
                    rp8Var2.o(jumpToHtmlPage.a());
                    rp8Var2.w(jumpToHtmlPage.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                rp8Var2.r(true);
                rp8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    rp8Var2.x(offlineUserInfo.f());
                    rp8Var2.t(offlineUserInfo.b());
                    rp8Var2.o(offlineUserInfo.a());
                    rp8Var2.w(offlineUserInfo.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                rp8Var2.r(true);
                rp8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    rp8Var2.x(deleteOfflineBundle.f());
                    rp8Var2.t(deleteOfflineBundle.b());
                    rp8Var2.o(deleteOfflineBundle.a());
                    rp8Var2.w(deleteOfflineBundle.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                rp8Var2.r(true);
                rp8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    rp8Var2.x(updateOfflineBundle.f());
                    rp8Var2.t(updateOfflineBundle.b());
                    rp8Var2.o(updateOfflineBundle.a());
                    rp8Var2.w(updateOfflineBundle.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                rp8Var2.r(true);
                rp8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    rp8Var2.x(switchOfflineInterface.f());
                    rp8Var2.t(switchOfflineInterface.b());
                    rp8Var2.o(switchOfflineInterface.a());
                    rp8Var2.w(switchOfflineInterface.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                rp8Var2.r(true);
                rp8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    rp8Var2.x(switchOfflineBundleStatus.f());
                    rp8Var2.t(switchOfflineBundleStatus.b());
                    rp8Var2.o(switchOfflineBundleStatus.a());
                    rp8Var2.w(switchOfflineBundleStatus.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                rp8Var2.r(true);
                rp8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    rp8Var2.x(finishTestAnswer.f());
                    rp8Var2.t(finishTestAnswer.b());
                    rp8Var2.o(finishTestAnswer.a());
                    rp8Var2.w(finishTestAnswer.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                rp8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                rp8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    rp8Var2.x(switchUrlHost.f());
                    rp8Var2.t(switchUrlHost.b());
                    rp8Var2.o(switchUrlHost.a());
                    rp8Var2.w(switchUrlHost.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                rp8Var2.r(true);
                rp8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    rp8Var2.x(appStorage.f());
                    rp8Var2.t(appStorage.b());
                    rp8Var2.o(appStorage.a());
                    rp8Var2.w(appStorage.e());
                }
                rp8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                rp8Var2.r(true);
                rp8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    rp8Var2.x(putAppStorage.f());
                    rp8Var2.t(putAppStorage.b());
                    rp8Var2.o(putAppStorage.a());
                    rp8Var2.w(putAppStorage.e());
                }
                rp8Var2.y(0);
            }
            return rp8Var2;
        }
        return (rp8) invokeLL.objValue;
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

    @Override // com.baidu.tieba.pp8
    public List<rp8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            rp8 rp8Var = null;
            if (wi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                rp8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                rp8Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                rp8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                rp8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                rp8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                rp8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                rp8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                rp8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                rp8Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                rp8Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                rp8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                rp8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                rp8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                rp8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                rp8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                rp8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                rp8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                rp8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                rp8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            }
            if (rp8Var != null) {
                rp8Var.y(0);
            }
            List<qp8> list = this.mAsyncCallBackMethodList.get(str);
            if (rp8Var != null && list != null) {
                Iterator<qp8> it = list.iterator();
                if (!wi.isEmpty(rp8Var.e())) {
                    while (it.hasNext()) {
                        qp8 next = it.next();
                        if (next.b().equals(rp8Var.e())) {
                            rp8 rp8Var2 = new rp8();
                            rp8Var2.v(next.a());
                            rp8Var2.x(rp8Var.f());
                            rp8Var2.t(rp8Var.b());
                            rp8Var2.o(rp8Var.a());
                            rp8Var2.z(rp8Var.l());
                            arrayList.add(rp8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        qp8 next2 = it.next();
                        rp8 rp8Var3 = new rp8();
                        rp8Var3.v(next2.a());
                        rp8Var3.x(rp8Var.f());
                        rp8Var3.t(rp8Var.b());
                        rp8Var3.o(rp8Var.a());
                        rp8Var3.z(rp8Var.l());
                        arrayList.add(rp8Var3);
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
