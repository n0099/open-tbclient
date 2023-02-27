package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.dj;
import com.baidu.tieba.l69;
import com.baidu.tieba.m69;
import com.baidu.tieba.n69;
import com.baidu.tieba.p69;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
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
public class SingleQuickWebViewBridge_Proxy extends l69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.l69
    public n69 dispatch(p69 p69Var, n69 n69Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, p69Var, n69Var)) == null) {
            n69 n69Var2 = n69Var == null ? new n69() : n69Var;
            String b = p69Var.b();
            JSONObject e = p69Var.e();
            if (b.equals("account/startLoginModule")) {
                n69Var2.r(true);
                n69 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    n69Var2.x(startLoginModule.f());
                    n69Var2.t(startLoginModule.b());
                    n69Var2.o(startLoginModule.a());
                    n69Var2.w(startLoginModule.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                n69Var2.r(true);
                n69 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    n69Var2.x(finishPage.f());
                    n69Var2.t(finishPage.b());
                    n69Var2.o(finishPage.a());
                    n69Var2.w(finishPage.e());
                }
                n69Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                n69Var2.r(true);
                n69 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    n69Var2.x(showLowerHairHint.f());
                    n69Var2.t(showLowerHairHint.b());
                    n69Var2.o(showLowerHairHint.a());
                    n69Var2.w(showLowerHairHint.e());
                }
                n69Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                n69Var2.r(true);
                n69 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    n69Var2.x(gamePush.f());
                    n69Var2.t(gamePush.b());
                    n69Var2.o(gamePush.a());
                    n69Var2.w(gamePush.e());
                }
                n69Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                n69Var2.r(true);
                n69 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    n69Var2.x(handleGamePushStatus.f());
                    n69Var2.t(handleGamePushStatus.b());
                    n69Var2.o(handleGamePushStatus.a());
                    n69Var2.w(handleGamePushStatus.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                n69Var2.r(true);
                n69 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    n69Var2.x(jumpForumRulesEditPage.f());
                    n69Var2.t(jumpForumRulesEditPage.b());
                    n69Var2.o(jumpForumRulesEditPage.a());
                    n69Var2.w(jumpForumRulesEditPage.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                n69Var2.r(true);
                n69 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    n69Var2.x(handleGoToBarDetail.f());
                    n69Var2.t(handleGoToBarDetail.b());
                    n69Var2.o(handleGoToBarDetail.a());
                    n69Var2.w(handleGoToBarDetail.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                n69Var2.r(true);
                n69 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    n69Var2.x(handleSaveImage.f());
                    n69Var2.t(handleSaveImage.b());
                    n69Var2.o(handleSaveImage.a());
                    n69Var2.w(handleSaveImage.e());
                    if (!n69Var2.h()) {
                        n69Var2.n(false);
                        addObserver("saveImageSuccess", n69Var2, false);
                    }
                }
                n69Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                n69Var2.r(true);
                n69 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    n69Var2.x(orderGameApk.f());
                    n69Var2.t(orderGameApk.b());
                    n69Var2.o(orderGameApk.a());
                    n69Var2.w(orderGameApk.e());
                    if (!n69Var2.h()) {
                        n69Var2.n(false);
                        addObserver("orderGameApkResult", n69Var2, false);
                    }
                }
                n69Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                n69Var2.r(true);
                n69 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    n69Var2.x(handleGetPhotoAlbum.f());
                    n69Var2.t(handleGetPhotoAlbum.b());
                    n69Var2.o(handleGetPhotoAlbum.a());
                    n69Var2.w(handleGetPhotoAlbum.e());
                    if (!n69Var2.h()) {
                        n69Var2.n(false);
                        addObserver("GetPhotoAlbum", n69Var2, false);
                    }
                }
                n69Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                n69Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                n69 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    n69Var2.x(preheatWeb.f());
                    n69Var2.t(preheatWeb.b());
                    n69Var2.o(preheatWeb.a());
                    n69Var2.w(preheatWeb.e());
                }
                n69Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                n69Var2.r(true);
                n69 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    n69Var2.x(openMXDYab.f());
                    n69Var2.t(openMXDYab.b());
                    n69Var2.o(openMXDYab.a());
                    n69Var2.w(openMXDYab.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/portal")) {
                n69Var2.r(true);
                n69 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    n69Var2.x(handlePortal.f());
                    n69Var2.t(handlePortal.b());
                    n69Var2.o(handlePortal.a());
                    n69Var2.w(handlePortal.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                n69Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                n69 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    n69Var2.x(selectPhotoAlbum.f());
                    n69Var2.t(selectPhotoAlbum.b());
                    n69Var2.o(selectPhotoAlbum.a());
                    n69Var2.w(selectPhotoAlbum.e());
                    if (!n69Var2.h()) {
                        n69Var2.n(false);
                        addObserver("selectPhotoAlbum", n69Var2, false);
                    }
                }
                n69Var2.y(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                n69Var2.r(true);
                n69 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (operateNotifyDataChanged != null) {
                    n69Var2.x(operateNotifyDataChanged.f());
                    n69Var2.t(operateNotifyDataChanged.b());
                    n69Var2.o(operateNotifyDataChanged.a());
                    n69Var2.w(operateNotifyDataChanged.e());
                    if (!n69Var2.h()) {
                        n69Var2.n(false);
                        addObserver("notifyNativeRefresh", n69Var2, false);
                    }
                }
                n69Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                n69Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                n69 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    n69Var2.x(selectPrivateMsg.f());
                    n69Var2.t(selectPrivateMsg.b());
                    n69Var2.o(selectPrivateMsg.a());
                    n69Var2.w(selectPrivateMsg.e());
                    if (!n69Var2.h()) {
                        i4 = 0;
                        n69Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", n69Var2, false);
                        n69Var2.y(i4);
                    }
                }
                i4 = 0;
                n69Var2.y(i4);
            } else if (b.equals("router/goToReportThreadPage")) {
                n69Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                n69 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    n69Var2.x(reportUserTheme.f());
                    n69Var2.t(reportUserTheme.b());
                    n69Var2.o(reportUserTheme.a());
                    n69Var2.w(reportUserTheme.e());
                    if (!n69Var2.h()) {
                        i3 = 0;
                        n69Var2.n(false);
                        addObserver("goToReportThreadPage", n69Var2, false);
                        n69Var2.y(i3);
                    }
                }
                i3 = 0;
                n69Var2.y(i3);
            } else if (b.equals("system/playSound")) {
                n69Var2.r(true);
                n69 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    n69Var2.x(playSound.f());
                    n69Var2.t(playSound.b());
                    n69Var2.o(playSound.a());
                    n69Var2.w(playSound.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                n69Var2.r(true);
                n69 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    n69Var2.x(playVibrate.f());
                    n69Var2.t(playVibrate.b());
                    n69Var2.o(playVibrate.a());
                    n69Var2.w(playVibrate.e());
                }
                n69Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                n69Var2.r(true);
                n69 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    n69Var2.x(jumpLoginActivity.f());
                    n69Var2.t(jumpLoginActivity.b());
                    n69Var2.o(jumpLoginActivity.a());
                    n69Var2.w(jumpLoginActivity.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                n69Var2.r(true);
                n69 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    n69Var2.x(startLoadTimeInterval.f());
                    n69Var2.t(startLoadTimeInterval.b());
                    n69Var2.o(startLoadTimeInterval.a());
                    n69Var2.w(startLoadTimeInterval.e());
                }
                n69Var2.y(0);
            } else if (b.equals("device/getZid")) {
                n69Var2.r(true);
                n69 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    n69Var2.x(zid.f());
                    n69Var2.t(zid.b());
                    n69Var2.o(zid.a());
                    n69Var2.w(zid.e());
                }
                n69Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                n69Var2.r(true);
                n69 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    n69Var2.x(hdid.f());
                    n69Var2.t(hdid.b());
                    n69Var2.o(hdid.a());
                    n69Var2.w(hdid.e());
                }
                n69Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                n69Var2.r(true);
                n69 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    n69Var2.x(shareInfo.f());
                    n69Var2.t(shareInfo.b());
                    n69Var2.o(shareInfo.a());
                    n69Var2.w(shareInfo.e());
                }
                n69Var2.y(0);
            } else if (b.equals("share/share")) {
                n69Var2.r(true);
                n69 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"));
                if (share != null) {
                    n69Var2.x(share.f());
                    n69Var2.t(share.b());
                    n69Var2.o(share.a());
                    n69Var2.w(share.e());
                }
                n69Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                n69Var2.r(true);
                n69 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    n69Var2.x(clipperInformation.f());
                    n69Var2.t(clipperInformation.b());
                    n69Var2.o(clipperInformation.a());
                    n69Var2.w(clipperInformation.e());
                }
                n69Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                n69Var2.r(true);
                n69 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    n69Var2.x(clipperInformation2.f());
                    n69Var2.t(clipperInformation2.b());
                    n69Var2.o(clipperInformation2.a());
                    n69Var2.w(clipperInformation2.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                n69Var2.r(true);
                n69 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    n69Var2.x(goToEditPost.f());
                    n69Var2.t(goToEditPost.b());
                    n69Var2.o(goToEditPost.a());
                    n69Var2.w(goToEditPost.e());
                }
                n69Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                n69Var2.r(true);
                n69 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    n69Var2.x(updateSearchForumInfo.f());
                    n69Var2.t(updateSearchForumInfo.b());
                    n69Var2.o(updateSearchForumInfo.a());
                    n69Var2.w(updateSearchForumInfo.e());
                }
                n69Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                n69Var2.r(true);
                n69 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    n69Var2.x(personlizedSwitchChange.f());
                    n69Var2.t(personlizedSwitchChange.b());
                    n69Var2.o(personlizedSwitchChange.a());
                    n69Var2.w(personlizedSwitchChange.e());
                }
                n69Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                n69Var2.r(true);
                n69 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    n69Var2.x(updateTailStyle.f());
                    n69Var2.t(updateTailStyle.b());
                    n69Var2.o(updateTailStyle.a());
                    n69Var2.w(updateTailStyle.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                n69Var2.r(true);
                n69 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    n69Var2.x(goToVideoImmersivePage.f());
                    n69Var2.t(goToVideoImmersivePage.b());
                    n69Var2.o(goToVideoImmersivePage.a());
                    n69Var2.w(goToVideoImmersivePage.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                n69Var2.r(true);
                n69 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    n69Var2.x(jumpToVideo.f());
                    n69Var2.t(jumpToVideo.b());
                    n69Var2.o(jumpToVideo.a());
                    n69Var2.w(jumpToVideo.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                n69Var2.r(true);
                n69 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    n69Var2.x(closeNativeMask.f());
                    n69Var2.t(closeNativeMask.b());
                    n69Var2.o(closeNativeMask.a());
                    n69Var2.w(closeNativeMask.e());
                }
                n69Var2.y(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                n69Var2.r(true);
                n69 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    n69Var2.x(oneKeyDeletion.f());
                    n69Var2.t(oneKeyDeletion.b());
                    n69Var2.o(oneKeyDeletion.a());
                    n69Var2.w(oneKeyDeletion.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                n69Var2.r(true);
                n69 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    n69Var2.x(checkAppInstall.f());
                    n69Var2.t(checkAppInstall.b());
                    n69Var2.o(checkAppInstall.a());
                    n69Var2.w(checkAppInstall.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                n69Var2.r(true);
                n69 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    n69Var2.x(disableBack.f());
                    n69Var2.t(disableBack.b());
                    n69Var2.o(disableBack.a());
                    n69Var2.w(disableBack.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/startApp")) {
                n69Var2.r(true);
                n69 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    n69Var2.x(startApp.f());
                    n69Var2.t(startApp.b());
                    n69Var2.o(startApp.a());
                    n69Var2.w(startApp.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                n69Var2.r(true);
                n69 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    n69Var2.x(hasNotificationPermission.f());
                    n69Var2.t(hasNotificationPermission.b());
                    n69Var2.o(hasNotificationPermission.a());
                    n69Var2.w(hasNotificationPermission.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                n69Var2.r(true);
                n69 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    n69Var2.x(goToNotificationSetting.f());
                    n69Var2.t(goToNotificationSetting.b());
                    n69Var2.o(goToNotificationSetting.a());
                    n69Var2.w(goToNotificationSetting.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                n69Var2.r(true);
                n69 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    n69Var2.x(startDownloadGameApk.f());
                    n69Var2.t(startDownloadGameApk.b());
                    n69Var2.o(startDownloadGameApk.a());
                    n69Var2.w(startDownloadGameApk.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                n69Var2.r(true);
                n69 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    n69Var2.x(checkInstallGameApk.f());
                    n69Var2.t(checkInstallGameApk.b());
                    n69Var2.o(checkInstallGameApk.a());
                    n69Var2.w(checkInstallGameApk.e());
                }
                n69Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                n69Var2.r(true);
                n69 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    n69Var2.x(startDownloadCss.f());
                    n69Var2.t(startDownloadCss.b());
                    n69Var2.o(startDownloadCss.a());
                    n69Var2.w(startDownloadCss.e());
                }
                n69Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                n69Var2.r(true);
                n69 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    n69Var2.x(disableGoBack.f());
                    n69Var2.t(disableGoBack.b());
                    n69Var2.o(disableGoBack.a());
                    n69Var2.w(disableGoBack.e());
                }
                n69Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                n69Var2.r(true);
                n69 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    n69Var2.x(supplementInfo.f());
                    n69Var2.t(supplementInfo.b());
                    n69Var2.o(supplementInfo.a());
                    n69Var2.w(supplementInfo.e());
                }
                n69Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                n69Var2.r(true);
                n69 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    n69Var2.x(deviceInfo.f());
                    n69Var2.t(deviceInfo.b());
                    n69Var2.o(deviceInfo.a());
                    n69Var2.w(deviceInfo.e());
                }
                n69Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                n69Var2.r(true);
                n69 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    n69Var2.x(sendCompleteTaskReqMsg.f());
                    n69Var2.t(sendCompleteTaskReqMsg.b());
                    n69Var2.o(sendCompleteTaskReqMsg.a());
                    n69Var2.w(sendCompleteTaskReqMsg.e());
                }
                n69Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                n69Var2.r(true);
                n69 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    n69Var2.x(showTipToast.f());
                    n69Var2.t(showTipToast.b());
                    n69Var2.o(showTipToast.a());
                    n69Var2.w(showTipToast.e());
                }
                n69Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                n69Var2.r(true);
                n69 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    n69Var2.x(getModalData.f());
                    n69Var2.t(getModalData.b());
                    n69Var2.o(getModalData.a());
                    n69Var2.w(getModalData.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                n69Var2.r(true);
                n69 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    n69Var2.x(openThirdPartApp.f());
                    n69Var2.t(openThirdPartApp.b());
                    n69Var2.o(openThirdPartApp.a());
                    n69Var2.w(openThirdPartApp.e());
                }
                n69Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                n69Var2.r(true);
                n69 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    n69Var2.x(jumpToHtmlPage.f());
                    n69Var2.t(jumpToHtmlPage.b());
                    n69Var2.o(jumpToHtmlPage.a());
                    n69Var2.w(jumpToHtmlPage.e());
                }
                n69Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                n69Var2.r(true);
                n69 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    n69Var2.x(offlineUserInfo.f());
                    n69Var2.t(offlineUserInfo.b());
                    n69Var2.o(offlineUserInfo.a());
                    n69Var2.w(offlineUserInfo.e());
                }
                n69Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                n69Var2.r(true);
                n69 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    n69Var2.x(deleteOfflineBundle.f());
                    n69Var2.t(deleteOfflineBundle.b());
                    n69Var2.o(deleteOfflineBundle.a());
                    n69Var2.w(deleteOfflineBundle.e());
                }
                n69Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                n69Var2.r(true);
                n69 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    n69Var2.x(updateOfflineBundle.f());
                    n69Var2.t(updateOfflineBundle.b());
                    n69Var2.o(updateOfflineBundle.a());
                    n69Var2.w(updateOfflineBundle.e());
                }
                n69Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                n69Var2.r(true);
                n69 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    n69Var2.x(switchOfflineInterface.f());
                    n69Var2.t(switchOfflineInterface.b());
                    n69Var2.o(switchOfflineInterface.a());
                    n69Var2.w(switchOfflineInterface.e());
                }
                n69Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                n69Var2.r(true);
                n69 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    n69Var2.x(switchOfflineBundleStatus.f());
                    n69Var2.t(switchOfflineBundleStatus.b());
                    n69Var2.o(switchOfflineBundleStatus.a());
                    n69Var2.w(switchOfflineBundleStatus.e());
                }
                n69Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                n69Var2.r(true);
                n69 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    n69Var2.x(finishTestAnswer.f());
                    n69Var2.t(finishTestAnswer.b());
                    n69Var2.o(finishTestAnswer.a());
                    n69Var2.w(finishTestAnswer.e());
                }
                n69Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                n69Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                n69 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    n69Var2.x(switchUrlHost.f());
                    n69Var2.t(switchUrlHost.b());
                    n69Var2.o(switchUrlHost.a());
                    n69Var2.w(switchUrlHost.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                n69Var2.r(true);
                n69 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    n69Var2.x(appStorage.f());
                    n69Var2.t(appStorage.b());
                    n69Var2.o(appStorage.a());
                    n69Var2.w(appStorage.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                n69Var2.r(true);
                n69 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    n69Var2.x(putAppStorage.f());
                    n69Var2.t(putAppStorage.b());
                    n69Var2.o(putAppStorage.a());
                    n69Var2.w(putAppStorage.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                n69Var2.r(true);
                n69 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    n69Var2.x(historyForumData.f());
                    n69Var2.t(historyForumData.b());
                    n69Var2.o(historyForumData.a());
                    n69Var2.w(historyForumData.e());
                }
                n69Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                n69Var2.r(true);
                n69 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    n69Var2.x(worldCupRaiseSuccess.f());
                    n69Var2.t(worldCupRaiseSuccess.b());
                    n69Var2.o(worldCupRaiseSuccess.a());
                    n69Var2.w(worldCupRaiseSuccess.e());
                }
                n69Var2.y(0);
            } else if (b.equals("account/getAlipayUserId")) {
                n69Var2.r(true);
                n69 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    n69Var2.x(alipayUserId.f());
                    n69Var2.t(alipayUserId.b());
                    n69Var2.o(alipayUserId.a());
                    n69Var2.w(alipayUserId.e());
                    if (!n69Var2.h()) {
                        i2 = 0;
                        n69Var2.n(false);
                        addObserver("aliAuthResult", n69Var2, false);
                        n69Var2.y(i2);
                    }
                }
                i2 = 0;
                n69Var2.y(i2);
            } else if (b.equals("system/getFileDownloadStatus")) {
                n69Var2.r(true);
                n69 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    n69Var2.x(fileDownloadStatus.f());
                    n69Var2.t(fileDownloadStatus.b());
                    n69Var2.o(fileDownloadStatus.a());
                    n69Var2.w(fileDownloadStatus.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                n69Var2.r(true);
                n69 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    n69Var2.x(fileDownloadProgress.f());
                    n69Var2.t(fileDownloadProgress.b());
                    n69Var2.o(fileDownloadProgress.a());
                    n69Var2.w(fileDownloadProgress.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/fileDownloadPause")) {
                n69Var2.r(true);
                n69 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    n69Var2.x(fileDownloadPause.f());
                    n69Var2.t(fileDownloadPause.b());
                    n69Var2.o(fileDownloadPause.a());
                    n69Var2.w(fileDownloadPause.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                n69Var2.r(true);
                n69 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    n69Var2.x(fileDownloadDelete.f());
                    n69Var2.t(fileDownloadDelete.b());
                    n69Var2.o(fileDownloadDelete.a());
                    n69Var2.w(fileDownloadDelete.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/installGameApk")) {
                n69Var2.r(true);
                n69 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    n69Var2.x(installGameApk.f());
                    n69Var2.t(installGameApk.b());
                    n69Var2.o(installGameApk.a());
                    n69Var2.w(installGameApk.e());
                }
                n69Var2.y(0);
            } else if (b.equals("system/launchApk")) {
                n69Var2.r(true);
                n69 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    n69Var2.x(launchApk.f());
                    n69Var2.t(launchApk.b());
                    n69Var2.o(launchApk.a());
                    n69Var2.w(launchApk.e());
                }
                n69Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                n69Var2.r(true);
                n69 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    n69Var2.x(requestByNative.f());
                    n69Var2.t(requestByNative.b());
                    n69Var2.o(requestByNative.a());
                    n69Var2.w(requestByNative.e());
                    if (!n69Var2.h()) {
                        i = 0;
                        n69Var2.n(false);
                        addObserver("RequestByNativeToH5", n69Var2, false);
                        n69Var2.y(i);
                    }
                }
                i = 0;
                n69Var2.y(i);
            }
            return n69Var2;
        }
        return (n69) invokeLL.objValue;
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

    @Override // com.baidu.tieba.l69
    public List<n69> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            n69 n69Var = null;
            if (dj.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                n69Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                n69Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                n69Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                n69Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                n69Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                n69Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                n69Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                n69Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                n69Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                n69Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                n69Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                n69Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                n69Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                n69Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                n69Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                n69Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                n69Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                n69Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                n69Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                n69Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("aliAuthResult")) {
                n69Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                n69Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                n69Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                n69Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (n69Var != null) {
                n69Var.y(0);
            }
            List<m69> list = this.mAsyncCallBackMethodList.get(str);
            if (n69Var != null && list != null) {
                Iterator<m69> it = list.iterator();
                if (!dj.isEmpty(n69Var.e())) {
                    while (it.hasNext()) {
                        m69 next = it.next();
                        if (next.b().equals(n69Var.e())) {
                            n69 n69Var2 = new n69();
                            n69Var2.v(next.a());
                            n69Var2.x(n69Var.f());
                            n69Var2.t(n69Var.b());
                            n69Var2.o(n69Var.a());
                            n69Var2.z(n69Var.l());
                            arrayList.add(n69Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        m69 next2 = it.next();
                        n69 n69Var3 = new n69();
                        n69Var3.v(next2.a());
                        n69Var3.x(n69Var.f());
                        n69Var3.t(n69Var.b());
                        n69Var3.o(n69Var.a());
                        n69Var3.z(n69Var.l());
                        arrayList.add(n69Var3);
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
