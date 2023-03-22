package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.gi;
import com.baidu.tieba.rc9;
import com.baidu.tieba.sc9;
import com.baidu.tieba.tc9;
import com.baidu.tieba.vc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.PushService;
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
public class CommonTbJsBridge_Proxy extends rc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.rc9
    public tc9 dispatch(vc9 vc9Var, tc9 tc9Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vc9Var, tc9Var)) == null) {
            tc9 tc9Var2 = tc9Var == null ? new tc9() : tc9Var;
            String b = vc9Var.b();
            JSONObject e = vc9Var.e();
            if (b.equals("account/startLoginModule")) {
                tc9Var2.r(true);
                tc9 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    tc9Var2.x(startLoginModule.f());
                    tc9Var2.t(startLoginModule.b());
                    tc9Var2.o(startLoginModule.a());
                    tc9Var2.w(startLoginModule.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                tc9Var2.r(true);
                tc9 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    tc9Var2.x(finishPage.f());
                    tc9Var2.t(finishPage.b());
                    tc9Var2.o(finishPage.a());
                    tc9Var2.w(finishPage.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                tc9Var2.r(true);
                tc9 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    tc9Var2.x(showLowerHairHint.f());
                    tc9Var2.t(showLowerHairHint.b());
                    tc9Var2.o(showLowerHairHint.a());
                    tc9Var2.w(showLowerHairHint.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                tc9Var2.r(true);
                tc9 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    tc9Var2.x(gamePush.f());
                    tc9Var2.t(gamePush.b());
                    tc9Var2.o(gamePush.a());
                    tc9Var2.w(gamePush.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                tc9Var2.r(true);
                tc9 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    tc9Var2.x(handleGamePushStatus.f());
                    tc9Var2.t(handleGamePushStatus.b());
                    tc9Var2.o(handleGamePushStatus.a());
                    tc9Var2.w(handleGamePushStatus.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                tc9Var2.r(true);
                tc9 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    tc9Var2.x(jumpForumRulesEditPage.f());
                    tc9Var2.t(jumpForumRulesEditPage.b());
                    tc9Var2.o(jumpForumRulesEditPage.a());
                    tc9Var2.w(jumpForumRulesEditPage.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                tc9Var2.r(true);
                tc9 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    tc9Var2.x(handleGoToBarDetail.f());
                    tc9Var2.t(handleGoToBarDetail.b());
                    tc9Var2.o(handleGoToBarDetail.a());
                    tc9Var2.w(handleGoToBarDetail.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                tc9Var2.r(true);
                tc9 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    tc9Var2.x(handleSaveImage.f());
                    tc9Var2.t(handleSaveImage.b());
                    tc9Var2.o(handleSaveImage.a());
                    tc9Var2.w(handleSaveImage.e());
                    if (!tc9Var2.h()) {
                        tc9Var2.n(false);
                        addObserver("saveImageSuccess", tc9Var2, false);
                    }
                }
                tc9Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                tc9Var2.r(true);
                tc9 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    tc9Var2.x(orderGameApk.f());
                    tc9Var2.t(orderGameApk.b());
                    tc9Var2.o(orderGameApk.a());
                    tc9Var2.w(orderGameApk.e());
                    if (!tc9Var2.h()) {
                        tc9Var2.n(false);
                        addObserver("orderGameApkResult", tc9Var2, false);
                    }
                }
                tc9Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                tc9Var2.r(true);
                tc9 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    tc9Var2.x(handleGetPhotoAlbum.f());
                    tc9Var2.t(handleGetPhotoAlbum.b());
                    tc9Var2.o(handleGetPhotoAlbum.a());
                    tc9Var2.w(handleGetPhotoAlbum.e());
                    if (!tc9Var2.h()) {
                        tc9Var2.n(false);
                        addObserver("GetPhotoAlbum", tc9Var2, false);
                    }
                }
                tc9Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                tc9Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                tc9 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    tc9Var2.x(preheatWeb.f());
                    tc9Var2.t(preheatWeb.b());
                    tc9Var2.o(preheatWeb.a());
                    tc9Var2.w(preheatWeb.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                tc9Var2.r(true);
                tc9 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    tc9Var2.x(openMXDYab.f());
                    tc9Var2.t(openMXDYab.b());
                    tc9Var2.o(openMXDYab.a());
                    tc9Var2.w(openMXDYab.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/portal")) {
                tc9Var2.r(true);
                tc9 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    tc9Var2.x(handlePortal.f());
                    tc9Var2.t(handlePortal.b());
                    tc9Var2.o(handlePortal.a());
                    tc9Var2.w(handlePortal.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                tc9Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                tc9 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    tc9Var2.x(selectPhotoAlbum.f());
                    tc9Var2.t(selectPhotoAlbum.b());
                    tc9Var2.o(selectPhotoAlbum.a());
                    tc9Var2.w(selectPhotoAlbum.e());
                    if (!tc9Var2.h()) {
                        tc9Var2.n(false);
                        addObserver("selectPhotoAlbum", tc9Var2, false);
                    }
                }
                tc9Var2.y(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                tc9Var2.r(true);
                tc9 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (operateNotifyDataChanged != null) {
                    tc9Var2.x(operateNotifyDataChanged.f());
                    tc9Var2.t(operateNotifyDataChanged.b());
                    tc9Var2.o(operateNotifyDataChanged.a());
                    tc9Var2.w(operateNotifyDataChanged.e());
                    if (!tc9Var2.h()) {
                        tc9Var2.n(false);
                        addObserver("notifyNativeRefresh", tc9Var2, false);
                    }
                }
                tc9Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                tc9Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                tc9 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    tc9Var2.x(selectPrivateMsg.f());
                    tc9Var2.t(selectPrivateMsg.b());
                    tc9Var2.o(selectPrivateMsg.a());
                    tc9Var2.w(selectPrivateMsg.e());
                    if (!tc9Var2.h()) {
                        i3 = 0;
                        tc9Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", tc9Var2, false);
                        tc9Var2.y(i3);
                    }
                }
                i3 = 0;
                tc9Var2.y(i3);
            } else if (b.equals("router/goToReportThreadPage")) {
                tc9Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                tc9 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    tc9Var2.x(reportUserTheme.f());
                    tc9Var2.t(reportUserTheme.b());
                    tc9Var2.o(reportUserTheme.a());
                    tc9Var2.w(reportUserTheme.e());
                    if (!tc9Var2.h()) {
                        i2 = 0;
                        tc9Var2.n(false);
                        addObserver("goToReportThreadPage", tc9Var2, false);
                        tc9Var2.y(i2);
                    }
                }
                i2 = 0;
                tc9Var2.y(i2);
            } else if (b.equals("system/playSound")) {
                tc9Var2.r(true);
                tc9 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    tc9Var2.x(playSound.f());
                    tc9Var2.t(playSound.b());
                    tc9Var2.o(playSound.a());
                    tc9Var2.w(playSound.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                tc9Var2.r(true);
                tc9 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    tc9Var2.x(playVibrate.f());
                    tc9Var2.t(playVibrate.b());
                    tc9Var2.o(playVibrate.a());
                    tc9Var2.w(playVibrate.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                tc9Var2.r(true);
                tc9 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    tc9Var2.x(jumpLoginActivity.f());
                    tc9Var2.t(jumpLoginActivity.b());
                    tc9Var2.o(jumpLoginActivity.a());
                    tc9Var2.w(jumpLoginActivity.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                tc9Var2.r(true);
                tc9 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    tc9Var2.x(startLoadTimeInterval.f());
                    tc9Var2.t(startLoadTimeInterval.b());
                    tc9Var2.o(startLoadTimeInterval.a());
                    tc9Var2.w(startLoadTimeInterval.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("device/getZid")) {
                tc9Var2.r(true);
                tc9 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    tc9Var2.x(zid.f());
                    tc9Var2.t(zid.b());
                    tc9Var2.o(zid.a());
                    tc9Var2.w(zid.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                tc9Var2.r(true);
                tc9 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    tc9Var2.x(hdid.f());
                    tc9Var2.t(hdid.b());
                    tc9Var2.o(hdid.a());
                    tc9Var2.w(hdid.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                tc9Var2.r(true);
                tc9 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    tc9Var2.x(shareInfo.f());
                    tc9Var2.t(shareInfo.b());
                    tc9Var2.o(shareInfo.a());
                    tc9Var2.w(shareInfo.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("share/share")) {
                tc9Var2.r(true);
                tc9 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"));
                if (share != null) {
                    tc9Var2.x(share.f());
                    tc9Var2.t(share.b());
                    tc9Var2.o(share.a());
                    tc9Var2.w(share.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                tc9Var2.r(true);
                tc9 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    tc9Var2.x(clipperInformation.f());
                    tc9Var2.t(clipperInformation.b());
                    tc9Var2.o(clipperInformation.a());
                    tc9Var2.w(clipperInformation.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                tc9Var2.r(true);
                tc9 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    tc9Var2.x(clipperInformation2.f());
                    tc9Var2.t(clipperInformation2.b());
                    tc9Var2.o(clipperInformation2.a());
                    tc9Var2.w(clipperInformation2.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                tc9Var2.r(true);
                tc9 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    tc9Var2.x(goToEditPost.f());
                    tc9Var2.t(goToEditPost.b());
                    tc9Var2.o(goToEditPost.a());
                    tc9Var2.w(goToEditPost.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                tc9Var2.r(true);
                tc9 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    tc9Var2.x(updateSearchForumInfo.f());
                    tc9Var2.t(updateSearchForumInfo.b());
                    tc9Var2.o(updateSearchForumInfo.a());
                    tc9Var2.w(updateSearchForumInfo.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                tc9Var2.r(true);
                tc9 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    tc9Var2.x(personlizedSwitchChange.f());
                    tc9Var2.t(personlizedSwitchChange.b());
                    tc9Var2.o(personlizedSwitchChange.a());
                    tc9Var2.w(personlizedSwitchChange.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                tc9Var2.r(true);
                tc9 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    tc9Var2.x(updateTailStyle.f());
                    tc9Var2.t(updateTailStyle.b());
                    tc9Var2.o(updateTailStyle.a());
                    tc9Var2.w(updateTailStyle.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                tc9Var2.r(true);
                tc9 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    tc9Var2.x(goToVideoImmersivePage.f());
                    tc9Var2.t(goToVideoImmersivePage.b());
                    tc9Var2.o(goToVideoImmersivePage.a());
                    tc9Var2.w(goToVideoImmersivePage.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                tc9Var2.r(true);
                tc9 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    tc9Var2.x(jumpToVideo.f());
                    tc9Var2.t(jumpToVideo.b());
                    tc9Var2.o(jumpToVideo.a());
                    tc9Var2.w(jumpToVideo.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                tc9Var2.r(true);
                tc9 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    tc9Var2.x(closeNativeMask.f());
                    tc9Var2.t(closeNativeMask.b());
                    tc9Var2.o(closeNativeMask.a());
                    tc9Var2.w(closeNativeMask.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                tc9Var2.r(true);
                tc9 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    tc9Var2.x(oneKeyDeletion.f());
                    tc9Var2.t(oneKeyDeletion.b());
                    tc9Var2.o(oneKeyDeletion.a());
                    tc9Var2.w(oneKeyDeletion.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                tc9Var2.r(true);
                tc9 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    tc9Var2.x(checkAppInstall.f());
                    tc9Var2.t(checkAppInstall.b());
                    tc9Var2.o(checkAppInstall.a());
                    tc9Var2.w(checkAppInstall.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                tc9Var2.r(true);
                tc9 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    tc9Var2.x(disableBack.f());
                    tc9Var2.t(disableBack.b());
                    tc9Var2.o(disableBack.a());
                    tc9Var2.w(disableBack.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/startApp")) {
                tc9Var2.r(true);
                tc9 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    tc9Var2.x(startApp.f());
                    tc9Var2.t(startApp.b());
                    tc9Var2.o(startApp.a());
                    tc9Var2.w(startApp.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                tc9Var2.r(true);
                tc9 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    tc9Var2.x(hasNotificationPermission.f());
                    tc9Var2.t(hasNotificationPermission.b());
                    tc9Var2.o(hasNotificationPermission.a());
                    tc9Var2.w(hasNotificationPermission.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                tc9Var2.r(true);
                tc9 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    tc9Var2.x(goToNotificationSetting.f());
                    tc9Var2.t(goToNotificationSetting.b());
                    tc9Var2.o(goToNotificationSetting.a());
                    tc9Var2.w(goToNotificationSetting.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                tc9Var2.r(true);
                tc9 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    tc9Var2.x(startDownloadGameApk.f());
                    tc9Var2.t(startDownloadGameApk.b());
                    tc9Var2.o(startDownloadGameApk.a());
                    tc9Var2.w(startDownloadGameApk.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                tc9Var2.r(true);
                tc9 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    tc9Var2.x(checkInstallGameApk.f());
                    tc9Var2.t(checkInstallGameApk.b());
                    tc9Var2.o(checkInstallGameApk.a());
                    tc9Var2.w(checkInstallGameApk.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                tc9Var2.r(true);
                tc9 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    tc9Var2.x(startDownloadCss.f());
                    tc9Var2.t(startDownloadCss.b());
                    tc9Var2.o(startDownloadCss.a());
                    tc9Var2.w(startDownloadCss.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                tc9Var2.r(true);
                tc9 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    tc9Var2.x(disableGoBack.f());
                    tc9Var2.t(disableGoBack.b());
                    tc9Var2.o(disableGoBack.a());
                    tc9Var2.w(disableGoBack.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                tc9Var2.r(true);
                tc9 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    tc9Var2.x(supplementInfo.f());
                    tc9Var2.t(supplementInfo.b());
                    tc9Var2.o(supplementInfo.a());
                    tc9Var2.w(supplementInfo.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                tc9Var2.r(true);
                tc9 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    tc9Var2.x(deviceInfo.f());
                    tc9Var2.t(deviceInfo.b());
                    tc9Var2.o(deviceInfo.a());
                    tc9Var2.w(deviceInfo.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                tc9Var2.r(true);
                tc9 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    tc9Var2.x(sendCompleteTaskReqMsg.f());
                    tc9Var2.t(sendCompleteTaskReqMsg.b());
                    tc9Var2.o(sendCompleteTaskReqMsg.a());
                    tc9Var2.w(sendCompleteTaskReqMsg.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                tc9Var2.r(true);
                tc9 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    tc9Var2.x(showTipToast.f());
                    tc9Var2.t(showTipToast.b());
                    tc9Var2.o(showTipToast.a());
                    tc9Var2.w(showTipToast.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                tc9Var2.r(true);
                tc9 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    tc9Var2.x(getModalData.f());
                    tc9Var2.t(getModalData.b());
                    tc9Var2.o(getModalData.a());
                    tc9Var2.w(getModalData.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                tc9Var2.r(true);
                tc9 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    tc9Var2.x(openThirdPartApp.f());
                    tc9Var2.t(openThirdPartApp.b());
                    tc9Var2.o(openThirdPartApp.a());
                    tc9Var2.w(openThirdPartApp.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                tc9Var2.r(true);
                tc9 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    tc9Var2.x(jumpToHtmlPage.f());
                    tc9Var2.t(jumpToHtmlPage.b());
                    tc9Var2.o(jumpToHtmlPage.a());
                    tc9Var2.w(jumpToHtmlPage.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                tc9Var2.r(true);
                tc9 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    tc9Var2.x(offlineUserInfo.f());
                    tc9Var2.t(offlineUserInfo.b());
                    tc9Var2.o(offlineUserInfo.a());
                    tc9Var2.w(offlineUserInfo.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                tc9Var2.r(true);
                tc9 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    tc9Var2.x(deleteOfflineBundle.f());
                    tc9Var2.t(deleteOfflineBundle.b());
                    tc9Var2.o(deleteOfflineBundle.a());
                    tc9Var2.w(deleteOfflineBundle.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                tc9Var2.r(true);
                tc9 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    tc9Var2.x(updateOfflineBundle.f());
                    tc9Var2.t(updateOfflineBundle.b());
                    tc9Var2.o(updateOfflineBundle.a());
                    tc9Var2.w(updateOfflineBundle.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                tc9Var2.r(true);
                tc9 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    tc9Var2.x(switchOfflineInterface.f());
                    tc9Var2.t(switchOfflineInterface.b());
                    tc9Var2.o(switchOfflineInterface.a());
                    tc9Var2.w(switchOfflineInterface.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                tc9Var2.r(true);
                tc9 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    tc9Var2.x(switchOfflineBundleStatus.f());
                    tc9Var2.t(switchOfflineBundleStatus.b());
                    tc9Var2.o(switchOfflineBundleStatus.a());
                    tc9Var2.w(switchOfflineBundleStatus.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                tc9Var2.r(true);
                tc9 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    tc9Var2.x(finishTestAnswer.f());
                    tc9Var2.t(finishTestAnswer.b());
                    tc9Var2.o(finishTestAnswer.a());
                    tc9Var2.w(finishTestAnswer.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                tc9Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                tc9 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    tc9Var2.x(switchUrlHost.f());
                    tc9Var2.t(switchUrlHost.b());
                    tc9Var2.o(switchUrlHost.a());
                    tc9Var2.w(switchUrlHost.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                tc9Var2.r(true);
                tc9 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    tc9Var2.x(appStorage.f());
                    tc9Var2.t(appStorage.b());
                    tc9Var2.o(appStorage.a());
                    tc9Var2.w(appStorage.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                tc9Var2.r(true);
                tc9 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    tc9Var2.x(putAppStorage.f());
                    tc9Var2.t(putAppStorage.b());
                    tc9Var2.o(putAppStorage.a());
                    tc9Var2.w(putAppStorage.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                tc9Var2.r(true);
                tc9 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    tc9Var2.x(historyForumData.f());
                    tc9Var2.t(historyForumData.b());
                    tc9Var2.o(historyForumData.a());
                    tc9Var2.w(historyForumData.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                tc9Var2.r(true);
                tc9 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    tc9Var2.x(worldCupRaiseSuccess.f());
                    tc9Var2.t(worldCupRaiseSuccess.b());
                    tc9Var2.o(worldCupRaiseSuccess.a());
                    tc9Var2.w(worldCupRaiseSuccess.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("account/getAlipayUserId")) {
                tc9Var2.r(true);
                tc9 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    tc9Var2.x(alipayUserId.f());
                    tc9Var2.t(alipayUserId.b());
                    tc9Var2.o(alipayUserId.a());
                    tc9Var2.w(alipayUserId.e());
                    if (!tc9Var2.h()) {
                        i = 0;
                        tc9Var2.n(false);
                        addObserver("aliAuthResult", tc9Var2, false);
                        tc9Var2.y(i);
                    }
                }
                i = 0;
                tc9Var2.y(i);
            } else if (b.equals("system/getFileDownloadStatus")) {
                tc9Var2.r(true);
                tc9 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    tc9Var2.x(fileDownloadStatus.f());
                    tc9Var2.t(fileDownloadStatus.b());
                    tc9Var2.o(fileDownloadStatus.a());
                    tc9Var2.w(fileDownloadStatus.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                tc9Var2.r(true);
                tc9 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    tc9Var2.x(fileDownloadProgress.f());
                    tc9Var2.t(fileDownloadProgress.b());
                    tc9Var2.o(fileDownloadProgress.a());
                    tc9Var2.w(fileDownloadProgress.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/fileDownloadPause")) {
                tc9Var2.r(true);
                tc9 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    tc9Var2.x(fileDownloadPause.f());
                    tc9Var2.t(fileDownloadPause.b());
                    tc9Var2.o(fileDownloadPause.a());
                    tc9Var2.w(fileDownloadPause.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                tc9Var2.r(true);
                tc9 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    tc9Var2.x(fileDownloadDelete.f());
                    tc9Var2.t(fileDownloadDelete.b());
                    tc9Var2.o(fileDownloadDelete.a());
                    tc9Var2.w(fileDownloadDelete.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/installGameApk")) {
                tc9Var2.r(true);
                tc9 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    tc9Var2.x(installGameApk.f());
                    tc9Var2.t(installGameApk.b());
                    tc9Var2.o(installGameApk.a());
                    tc9Var2.w(installGameApk.e());
                }
                tc9Var2.y(0);
            } else if (b.equals("system/launchApk")) {
                tc9Var2.r(true);
                tc9 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    tc9Var2.x(launchApk.f());
                    tc9Var2.t(launchApk.b());
                    tc9Var2.o(launchApk.a());
                    tc9Var2.w(launchApk.e());
                }
                tc9Var2.y(0);
            }
            return tc9Var2;
        }
        return (tc9) invokeLL.objValue;
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
        this.mNotificationNameList.add(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT);
        this.mNotificationNameList.add(CommonTbJsBridge.INSTALL_APK_RESULT);
    }

    @Override // com.baidu.tieba.rc9
    public List<tc9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            tc9 tc9Var = null;
            if (gi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                tc9Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                tc9Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                tc9Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                tc9Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                tc9Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                tc9Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                tc9Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                tc9Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                tc9Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                tc9Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                tc9Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                tc9Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                tc9Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                tc9Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                tc9Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                tc9Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                tc9Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                tc9Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                tc9Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                tc9Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("aliAuthResult")) {
                tc9Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                tc9Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                tc9Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            }
            if (tc9Var != null) {
                tc9Var.y(0);
            }
            List<sc9> list = this.mAsyncCallBackMethodList.get(str);
            if (tc9Var != null && list != null) {
                Iterator<sc9> it = list.iterator();
                if (!gi.isEmpty(tc9Var.e())) {
                    while (it.hasNext()) {
                        sc9 next = it.next();
                        if (next.b().equals(tc9Var.e())) {
                            tc9 tc9Var2 = new tc9();
                            tc9Var2.v(next.a());
                            tc9Var2.x(tc9Var.f());
                            tc9Var2.t(tc9Var.b());
                            tc9Var2.o(tc9Var.a());
                            tc9Var2.z(tc9Var.l());
                            arrayList.add(tc9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        sc9 next2 = it.next();
                        tc9 tc9Var3 = new tc9();
                        tc9Var3.v(next2.a());
                        tc9Var3.x(tc9Var.f());
                        tc9Var3.t(tc9Var.b());
                        tc9Var3.o(tc9Var.a());
                        tc9Var3.z(tc9Var.l());
                        arrayList.add(tc9Var3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
