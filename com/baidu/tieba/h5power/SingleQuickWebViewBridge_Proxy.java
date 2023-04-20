package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.hi;
import com.baidu.tieba.qm9;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.rm9;
import com.baidu.tieba.sm9;
import com.baidu.tieba.um9;
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
public class SingleQuickWebViewBridge_Proxy extends qm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.qm9
    public sm9 dispatch(um9 um9Var, sm9 sm9Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, um9Var, sm9Var)) == null) {
            sm9 sm9Var2 = sm9Var == null ? new sm9() : sm9Var;
            String b = um9Var.b();
            JSONObject e = um9Var.e();
            if (b.equals("account/startLoginModule")) {
                sm9Var2.r(true);
                sm9 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    sm9Var2.x(startLoginModule.f());
                    sm9Var2.t(startLoginModule.b());
                    sm9Var2.o(startLoginModule.a());
                    sm9Var2.w(startLoginModule.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                sm9Var2.r(true);
                sm9 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    sm9Var2.x(finishPage.f());
                    sm9Var2.t(finishPage.b());
                    sm9Var2.o(finishPage.a());
                    sm9Var2.w(finishPage.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                sm9Var2.r(true);
                sm9 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    sm9Var2.x(showLowerHairHint.f());
                    sm9Var2.t(showLowerHairHint.b());
                    sm9Var2.o(showLowerHairHint.a());
                    sm9Var2.w(showLowerHairHint.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                sm9Var2.r(true);
                sm9 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    sm9Var2.x(gamePush.f());
                    sm9Var2.t(gamePush.b());
                    sm9Var2.o(gamePush.a());
                    sm9Var2.w(gamePush.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                sm9Var2.r(true);
                sm9 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    sm9Var2.x(handleGamePushStatus.f());
                    sm9Var2.t(handleGamePushStatus.b());
                    sm9Var2.o(handleGamePushStatus.a());
                    sm9Var2.w(handleGamePushStatus.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                sm9Var2.r(true);
                sm9 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    sm9Var2.x(jumpForumRulesEditPage.f());
                    sm9Var2.t(jumpForumRulesEditPage.b());
                    sm9Var2.o(jumpForumRulesEditPage.a());
                    sm9Var2.w(jumpForumRulesEditPage.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                sm9Var2.r(true);
                sm9 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    sm9Var2.x(handleGoToBarDetail.f());
                    sm9Var2.t(handleGoToBarDetail.b());
                    sm9Var2.o(handleGoToBarDetail.a());
                    sm9Var2.w(handleGoToBarDetail.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                sm9Var2.r(true);
                sm9 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    sm9Var2.x(handleSaveImage.f());
                    sm9Var2.t(handleSaveImage.b());
                    sm9Var2.o(handleSaveImage.a());
                    sm9Var2.w(handleSaveImage.e());
                    if (!sm9Var2.h()) {
                        sm9Var2.n(false);
                        addObserver("saveImageSuccess", sm9Var2, false);
                    }
                }
                sm9Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                sm9Var2.r(true);
                sm9 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    sm9Var2.x(orderGameApk.f());
                    sm9Var2.t(orderGameApk.b());
                    sm9Var2.o(orderGameApk.a());
                    sm9Var2.w(orderGameApk.e());
                    if (!sm9Var2.h()) {
                        sm9Var2.n(false);
                        addObserver("orderGameApkResult", sm9Var2, false);
                    }
                }
                sm9Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                sm9Var2.r(true);
                sm9 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    sm9Var2.x(handleGetPhotoAlbum.f());
                    sm9Var2.t(handleGetPhotoAlbum.b());
                    sm9Var2.o(handleGetPhotoAlbum.a());
                    sm9Var2.w(handleGetPhotoAlbum.e());
                    if (!sm9Var2.h()) {
                        sm9Var2.n(false);
                        addObserver("GetPhotoAlbum", sm9Var2, false);
                    }
                }
                sm9Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                sm9Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                sm9 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    sm9Var2.x(preheatWeb.f());
                    sm9Var2.t(preheatWeb.b());
                    sm9Var2.o(preheatWeb.a());
                    sm9Var2.w(preheatWeb.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                sm9Var2.r(true);
                sm9 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    sm9Var2.x(openMXDYab.f());
                    sm9Var2.t(openMXDYab.b());
                    sm9Var2.o(openMXDYab.a());
                    sm9Var2.w(openMXDYab.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/portal")) {
                sm9Var2.r(true);
                sm9 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    sm9Var2.x(handlePortal.f());
                    sm9Var2.t(handlePortal.b());
                    sm9Var2.o(handlePortal.a());
                    sm9Var2.w(handlePortal.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                sm9Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                sm9 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    sm9Var2.x(selectPhotoAlbum.f());
                    sm9Var2.t(selectPhotoAlbum.b());
                    sm9Var2.o(selectPhotoAlbum.a());
                    sm9Var2.w(selectPhotoAlbum.e());
                    if (!sm9Var2.h()) {
                        sm9Var2.n(false);
                        addObserver("selectPhotoAlbum", sm9Var2, false);
                    }
                }
                sm9Var2.y(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                sm9Var2.r(true);
                sm9 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (operateNotifyDataChanged != null) {
                    sm9Var2.x(operateNotifyDataChanged.f());
                    sm9Var2.t(operateNotifyDataChanged.b());
                    sm9Var2.o(operateNotifyDataChanged.a());
                    sm9Var2.w(operateNotifyDataChanged.e());
                    if (!sm9Var2.h()) {
                        sm9Var2.n(false);
                        addObserver("notifyNativeRefresh", sm9Var2, false);
                    }
                }
                sm9Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                sm9Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                sm9 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    sm9Var2.x(selectPrivateMsg.f());
                    sm9Var2.t(selectPrivateMsg.b());
                    sm9Var2.o(selectPrivateMsg.a());
                    sm9Var2.w(selectPrivateMsg.e());
                    if (!sm9Var2.h()) {
                        i4 = 0;
                        sm9Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", sm9Var2, false);
                        sm9Var2.y(i4);
                    }
                }
                i4 = 0;
                sm9Var2.y(i4);
            } else if (b.equals("router/goToReportThreadPage")) {
                sm9Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                sm9 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    sm9Var2.x(reportUserTheme.f());
                    sm9Var2.t(reportUserTheme.b());
                    sm9Var2.o(reportUserTheme.a());
                    sm9Var2.w(reportUserTheme.e());
                    if (!sm9Var2.h()) {
                        i3 = 0;
                        sm9Var2.n(false);
                        addObserver("goToReportThreadPage", sm9Var2, false);
                        sm9Var2.y(i3);
                    }
                }
                i3 = 0;
                sm9Var2.y(i3);
            } else if (b.equals("system/playSound")) {
                sm9Var2.r(true);
                sm9 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    sm9Var2.x(playSound.f());
                    sm9Var2.t(playSound.b());
                    sm9Var2.o(playSound.a());
                    sm9Var2.w(playSound.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                sm9Var2.r(true);
                sm9 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    sm9Var2.x(playVibrate.f());
                    sm9Var2.t(playVibrate.b());
                    sm9Var2.o(playVibrate.a());
                    sm9Var2.w(playVibrate.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                sm9Var2.r(true);
                sm9 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    sm9Var2.x(jumpLoginActivity.f());
                    sm9Var2.t(jumpLoginActivity.b());
                    sm9Var2.o(jumpLoginActivity.a());
                    sm9Var2.w(jumpLoginActivity.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                sm9Var2.r(true);
                sm9 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    sm9Var2.x(startLoadTimeInterval.f());
                    sm9Var2.t(startLoadTimeInterval.b());
                    sm9Var2.o(startLoadTimeInterval.a());
                    sm9Var2.w(startLoadTimeInterval.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("device/getZid")) {
                sm9Var2.r(true);
                sm9 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    sm9Var2.x(zid.f());
                    sm9Var2.t(zid.b());
                    sm9Var2.o(zid.a());
                    sm9Var2.w(zid.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                sm9Var2.r(true);
                sm9 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    sm9Var2.x(hdid.f());
                    sm9Var2.t(hdid.b());
                    sm9Var2.o(hdid.a());
                    sm9Var2.w(hdid.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                sm9Var2.r(true);
                sm9 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    sm9Var2.x(shareInfo.f());
                    sm9Var2.t(shareInfo.b());
                    sm9Var2.o(shareInfo.a());
                    sm9Var2.w(shareInfo.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("share/share")) {
                sm9Var2.r(true);
                sm9 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"));
                if (share != null) {
                    sm9Var2.x(share.f());
                    sm9Var2.t(share.b());
                    sm9Var2.o(share.a());
                    sm9Var2.w(share.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                sm9Var2.r(true);
                sm9 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    sm9Var2.x(clipperInformation.f());
                    sm9Var2.t(clipperInformation.b());
                    sm9Var2.o(clipperInformation.a());
                    sm9Var2.w(clipperInformation.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                sm9Var2.r(true);
                sm9 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    sm9Var2.x(clipperInformation2.f());
                    sm9Var2.t(clipperInformation2.b());
                    sm9Var2.o(clipperInformation2.a());
                    sm9Var2.w(clipperInformation2.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                sm9Var2.r(true);
                sm9 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    sm9Var2.x(goToEditPost.f());
                    sm9Var2.t(goToEditPost.b());
                    sm9Var2.o(goToEditPost.a());
                    sm9Var2.w(goToEditPost.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                sm9Var2.r(true);
                sm9 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    sm9Var2.x(updateSearchForumInfo.f());
                    sm9Var2.t(updateSearchForumInfo.b());
                    sm9Var2.o(updateSearchForumInfo.a());
                    sm9Var2.w(updateSearchForumInfo.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                sm9Var2.r(true);
                sm9 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    sm9Var2.x(personlizedSwitchChange.f());
                    sm9Var2.t(personlizedSwitchChange.b());
                    sm9Var2.o(personlizedSwitchChange.a());
                    sm9Var2.w(personlizedSwitchChange.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                sm9Var2.r(true);
                sm9 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    sm9Var2.x(updateTailStyle.f());
                    sm9Var2.t(updateTailStyle.b());
                    sm9Var2.o(updateTailStyle.a());
                    sm9Var2.w(updateTailStyle.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                sm9Var2.r(true);
                sm9 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    sm9Var2.x(goToVideoImmersivePage.f());
                    sm9Var2.t(goToVideoImmersivePage.b());
                    sm9Var2.o(goToVideoImmersivePage.a());
                    sm9Var2.w(goToVideoImmersivePage.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                sm9Var2.r(true);
                sm9 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    sm9Var2.x(jumpToVideo.f());
                    sm9Var2.t(jumpToVideo.b());
                    sm9Var2.o(jumpToVideo.a());
                    sm9Var2.w(jumpToVideo.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                sm9Var2.r(true);
                sm9 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    sm9Var2.x(closeNativeMask.f());
                    sm9Var2.t(closeNativeMask.b());
                    sm9Var2.o(closeNativeMask.a());
                    sm9Var2.w(closeNativeMask.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                sm9Var2.r(true);
                sm9 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    sm9Var2.x(oneKeyDeletion.f());
                    sm9Var2.t(oneKeyDeletion.b());
                    sm9Var2.o(oneKeyDeletion.a());
                    sm9Var2.w(oneKeyDeletion.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                sm9Var2.r(true);
                sm9 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    sm9Var2.x(checkAppInstall.f());
                    sm9Var2.t(checkAppInstall.b());
                    sm9Var2.o(checkAppInstall.a());
                    sm9Var2.w(checkAppInstall.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                sm9Var2.r(true);
                sm9 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    sm9Var2.x(disableBack.f());
                    sm9Var2.t(disableBack.b());
                    sm9Var2.o(disableBack.a());
                    sm9Var2.w(disableBack.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/startApp")) {
                sm9Var2.r(true);
                sm9 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    sm9Var2.x(startApp.f());
                    sm9Var2.t(startApp.b());
                    sm9Var2.o(startApp.a());
                    sm9Var2.w(startApp.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                sm9Var2.r(true);
                sm9 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    sm9Var2.x(hasNotificationPermission.f());
                    sm9Var2.t(hasNotificationPermission.b());
                    sm9Var2.o(hasNotificationPermission.a());
                    sm9Var2.w(hasNotificationPermission.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                sm9Var2.r(true);
                sm9 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    sm9Var2.x(goToNotificationSetting.f());
                    sm9Var2.t(goToNotificationSetting.b());
                    sm9Var2.o(goToNotificationSetting.a());
                    sm9Var2.w(goToNotificationSetting.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                sm9Var2.r(true);
                sm9 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    sm9Var2.x(startDownloadGameApk.f());
                    sm9Var2.t(startDownloadGameApk.b());
                    sm9Var2.o(startDownloadGameApk.a());
                    sm9Var2.w(startDownloadGameApk.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                sm9Var2.r(true);
                sm9 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    sm9Var2.x(checkInstallGameApk.f());
                    sm9Var2.t(checkInstallGameApk.b());
                    sm9Var2.o(checkInstallGameApk.a());
                    sm9Var2.w(checkInstallGameApk.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                sm9Var2.r(true);
                sm9 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    sm9Var2.x(startDownloadCss.f());
                    sm9Var2.t(startDownloadCss.b());
                    sm9Var2.o(startDownloadCss.a());
                    sm9Var2.w(startDownloadCss.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                sm9Var2.r(true);
                sm9 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    sm9Var2.x(disableGoBack.f());
                    sm9Var2.t(disableGoBack.b());
                    sm9Var2.o(disableGoBack.a());
                    sm9Var2.w(disableGoBack.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                sm9Var2.r(true);
                sm9 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    sm9Var2.x(supplementInfo.f());
                    sm9Var2.t(supplementInfo.b());
                    sm9Var2.o(supplementInfo.a());
                    sm9Var2.w(supplementInfo.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                sm9Var2.r(true);
                sm9 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    sm9Var2.x(deviceInfo.f());
                    sm9Var2.t(deviceInfo.b());
                    sm9Var2.o(deviceInfo.a());
                    sm9Var2.w(deviceInfo.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                sm9Var2.r(true);
                sm9 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    sm9Var2.x(sendCompleteTaskReqMsg.f());
                    sm9Var2.t(sendCompleteTaskReqMsg.b());
                    sm9Var2.o(sendCompleteTaskReqMsg.a());
                    sm9Var2.w(sendCompleteTaskReqMsg.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                sm9Var2.r(true);
                sm9 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    sm9Var2.x(showTipToast.f());
                    sm9Var2.t(showTipToast.b());
                    sm9Var2.o(showTipToast.a());
                    sm9Var2.w(showTipToast.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                sm9Var2.r(true);
                sm9 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    sm9Var2.x(getModalData.f());
                    sm9Var2.t(getModalData.b());
                    sm9Var2.o(getModalData.a());
                    sm9Var2.w(getModalData.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                sm9Var2.r(true);
                sm9 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    sm9Var2.x(openThirdPartApp.f());
                    sm9Var2.t(openThirdPartApp.b());
                    sm9Var2.o(openThirdPartApp.a());
                    sm9Var2.w(openThirdPartApp.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                sm9Var2.r(true);
                sm9 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    sm9Var2.x(jumpToHtmlPage.f());
                    sm9Var2.t(jumpToHtmlPage.b());
                    sm9Var2.o(jumpToHtmlPage.a());
                    sm9Var2.w(jumpToHtmlPage.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                sm9Var2.r(true);
                sm9 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    sm9Var2.x(offlineUserInfo.f());
                    sm9Var2.t(offlineUserInfo.b());
                    sm9Var2.o(offlineUserInfo.a());
                    sm9Var2.w(offlineUserInfo.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                sm9Var2.r(true);
                sm9 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    sm9Var2.x(deleteOfflineBundle.f());
                    sm9Var2.t(deleteOfflineBundle.b());
                    sm9Var2.o(deleteOfflineBundle.a());
                    sm9Var2.w(deleteOfflineBundle.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                sm9Var2.r(true);
                sm9 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    sm9Var2.x(updateOfflineBundle.f());
                    sm9Var2.t(updateOfflineBundle.b());
                    sm9Var2.o(updateOfflineBundle.a());
                    sm9Var2.w(updateOfflineBundle.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                sm9Var2.r(true);
                sm9 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    sm9Var2.x(switchOfflineInterface.f());
                    sm9Var2.t(switchOfflineInterface.b());
                    sm9Var2.o(switchOfflineInterface.a());
                    sm9Var2.w(switchOfflineInterface.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                sm9Var2.r(true);
                sm9 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    sm9Var2.x(switchOfflineBundleStatus.f());
                    sm9Var2.t(switchOfflineBundleStatus.b());
                    sm9Var2.o(switchOfflineBundleStatus.a());
                    sm9Var2.w(switchOfflineBundleStatus.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                sm9Var2.r(true);
                sm9 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    sm9Var2.x(finishTestAnswer.f());
                    sm9Var2.t(finishTestAnswer.b());
                    sm9Var2.o(finishTestAnswer.a());
                    sm9Var2.w(finishTestAnswer.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                sm9Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                sm9 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    sm9Var2.x(switchUrlHost.f());
                    sm9Var2.t(switchUrlHost.b());
                    sm9Var2.o(switchUrlHost.a());
                    sm9Var2.w(switchUrlHost.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                sm9Var2.r(true);
                sm9 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    sm9Var2.x(appStorage.f());
                    sm9Var2.t(appStorage.b());
                    sm9Var2.o(appStorage.a());
                    sm9Var2.w(appStorage.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                sm9Var2.r(true);
                sm9 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    sm9Var2.x(putAppStorage.f());
                    sm9Var2.t(putAppStorage.b());
                    sm9Var2.o(putAppStorage.a());
                    sm9Var2.w(putAppStorage.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                sm9Var2.r(true);
                sm9 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    sm9Var2.x(historyForumData.f());
                    sm9Var2.t(historyForumData.b());
                    sm9Var2.o(historyForumData.a());
                    sm9Var2.w(historyForumData.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                sm9Var2.r(true);
                sm9 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    sm9Var2.x(worldCupRaiseSuccess.f());
                    sm9Var2.t(worldCupRaiseSuccess.b());
                    sm9Var2.o(worldCupRaiseSuccess.a());
                    sm9Var2.w(worldCupRaiseSuccess.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("account/getAlipayUserId")) {
                sm9Var2.r(true);
                sm9 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    sm9Var2.x(alipayUserId.f());
                    sm9Var2.t(alipayUserId.b());
                    sm9Var2.o(alipayUserId.a());
                    sm9Var2.w(alipayUserId.e());
                    if (!sm9Var2.h()) {
                        i2 = 0;
                        sm9Var2.n(false);
                        addObserver("aliAuthResult", sm9Var2, false);
                        sm9Var2.y(i2);
                    }
                }
                i2 = 0;
                sm9Var2.y(i2);
            } else if (b.equals("system/getFileDownloadStatus")) {
                sm9Var2.r(true);
                sm9 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    sm9Var2.x(fileDownloadStatus.f());
                    sm9Var2.t(fileDownloadStatus.b());
                    sm9Var2.o(fileDownloadStatus.a());
                    sm9Var2.w(fileDownloadStatus.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                sm9Var2.r(true);
                sm9 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    sm9Var2.x(fileDownloadProgress.f());
                    sm9Var2.t(fileDownloadProgress.b());
                    sm9Var2.o(fileDownloadProgress.a());
                    sm9Var2.w(fileDownloadProgress.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/fileDownloadPause")) {
                sm9Var2.r(true);
                sm9 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    sm9Var2.x(fileDownloadPause.f());
                    sm9Var2.t(fileDownloadPause.b());
                    sm9Var2.o(fileDownloadPause.a());
                    sm9Var2.w(fileDownloadPause.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                sm9Var2.r(true);
                sm9 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    sm9Var2.x(fileDownloadDelete.f());
                    sm9Var2.t(fileDownloadDelete.b());
                    sm9Var2.o(fileDownloadDelete.a());
                    sm9Var2.w(fileDownloadDelete.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/installGameApk")) {
                sm9Var2.r(true);
                sm9 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    sm9Var2.x(installGameApk.f());
                    sm9Var2.t(installGameApk.b());
                    sm9Var2.o(installGameApk.a());
                    sm9Var2.w(installGameApk.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("system/launchApk")) {
                sm9Var2.r(true);
                sm9 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    sm9Var2.x(launchApk.f());
                    sm9Var2.t(launchApk.b());
                    sm9Var2.o(launchApk.a());
                    sm9Var2.w(launchApk.e());
                }
                sm9Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                sm9Var2.r(true);
                sm9 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    sm9Var2.x(requestByNative.f());
                    sm9Var2.t(requestByNative.b());
                    sm9Var2.o(requestByNative.a());
                    sm9Var2.w(requestByNative.e());
                    if (!sm9Var2.h()) {
                        i = 0;
                        sm9Var2.n(false);
                        addObserver("RequestByNativeToH5", sm9Var2, false);
                        sm9Var2.y(i);
                    }
                }
                i = 0;
                sm9Var2.y(i);
            }
            return sm9Var2;
        }
        return (sm9) invokeLL.objValue;
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
        this.mNotificationNameList.add(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT);
        this.mNotificationNameList.add(CommonTbJsBridge.INSTALL_APK_RESULT);
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.qm9
    public List<sm9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            sm9 sm9Var = null;
            if (hi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                sm9Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                sm9Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                sm9Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                sm9Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                sm9Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                sm9Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                sm9Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                sm9Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                sm9Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                sm9Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                sm9Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                sm9Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                sm9Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                sm9Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                sm9Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                sm9Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                sm9Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                sm9Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                sm9Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                sm9Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("aliAuthResult")) {
                sm9Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                sm9Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                sm9Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                sm9Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (sm9Var != null) {
                sm9Var.y(0);
            }
            List<rm9> list = this.mAsyncCallBackMethodList.get(str);
            if (sm9Var != null && list != null) {
                Iterator<rm9> it = list.iterator();
                if (!hi.isEmpty(sm9Var.e())) {
                    while (it.hasNext()) {
                        rm9 next = it.next();
                        if (next.b().equals(sm9Var.e())) {
                            sm9 sm9Var2 = new sm9();
                            sm9Var2.v(next.a());
                            sm9Var2.x(sm9Var.f());
                            sm9Var2.t(sm9Var.b());
                            sm9Var2.o(sm9Var.a());
                            sm9Var2.z(sm9Var.l());
                            arrayList.add(sm9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rm9 next2 = it.next();
                        sm9 sm9Var3 = new sm9();
                        sm9Var3.v(next2.a());
                        sm9Var3.x(sm9Var.f());
                        sm9Var3.t(sm9Var.b());
                        sm9Var3.o(sm9Var.a());
                        sm9Var3.z(sm9Var.l());
                        arrayList.add(sm9Var3);
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
