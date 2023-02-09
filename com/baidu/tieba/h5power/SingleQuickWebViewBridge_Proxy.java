package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.alipay.sdk.sys.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.a39;
import com.baidu.tieba.b39;
import com.baidu.tieba.d39;
import com.baidu.tieba.dj;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.z29;
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
public class SingleQuickWebViewBridge_Proxy extends z29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.z29
    public b39 dispatch(d39 d39Var, b39 b39Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d39Var, b39Var)) == null) {
            b39 b39Var2 = b39Var == null ? new b39() : b39Var;
            String b = d39Var.b();
            JSONObject e = d39Var.e();
            if (b.equals("account/startLoginModule")) {
                b39Var2.r(true);
                b39 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    b39Var2.x(startLoginModule.f());
                    b39Var2.t(startLoginModule.b());
                    b39Var2.o(startLoginModule.a());
                    b39Var2.w(startLoginModule.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                b39Var2.r(true);
                b39 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    b39Var2.x(finishPage.f());
                    b39Var2.t(finishPage.b());
                    b39Var2.o(finishPage.a());
                    b39Var2.w(finishPage.e());
                }
                b39Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                b39Var2.r(true);
                b39 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    b39Var2.x(showLowerHairHint.f());
                    b39Var2.t(showLowerHairHint.b());
                    b39Var2.o(showLowerHairHint.a());
                    b39Var2.w(showLowerHairHint.e());
                }
                b39Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                b39Var2.r(true);
                b39 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    b39Var2.x(gamePush.f());
                    b39Var2.t(gamePush.b());
                    b39Var2.o(gamePush.a());
                    b39Var2.w(gamePush.e());
                }
                b39Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                b39Var2.r(true);
                b39 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    b39Var2.x(handleGamePushStatus.f());
                    b39Var2.t(handleGamePushStatus.b());
                    b39Var2.o(handleGamePushStatus.a());
                    b39Var2.w(handleGamePushStatus.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                b39Var2.r(true);
                b39 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    b39Var2.x(jumpForumRulesEditPage.f());
                    b39Var2.t(jumpForumRulesEditPage.b());
                    b39Var2.o(jumpForumRulesEditPage.a());
                    b39Var2.w(jumpForumRulesEditPage.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                b39Var2.r(true);
                b39 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    b39Var2.x(handleGoToBarDetail.f());
                    b39Var2.t(handleGoToBarDetail.b());
                    b39Var2.o(handleGoToBarDetail.a());
                    b39Var2.w(handleGoToBarDetail.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                b39Var2.r(true);
                b39 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    b39Var2.x(handleSaveImage.f());
                    b39Var2.t(handleSaveImage.b());
                    b39Var2.o(handleSaveImage.a());
                    b39Var2.w(handleSaveImage.e());
                    if (!b39Var2.h()) {
                        b39Var2.n(false);
                        addObserver("saveImageSuccess", b39Var2, false);
                    }
                }
                b39Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                b39Var2.r(true);
                b39 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    b39Var2.x(orderGameApk.f());
                    b39Var2.t(orderGameApk.b());
                    b39Var2.o(orderGameApk.a());
                    b39Var2.w(orderGameApk.e());
                    if (!b39Var2.h()) {
                        b39Var2.n(false);
                        addObserver("orderGameApkResult", b39Var2, false);
                    }
                }
                b39Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                b39Var2.r(true);
                b39 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    b39Var2.x(handleGetPhotoAlbum.f());
                    b39Var2.t(handleGetPhotoAlbum.b());
                    b39Var2.o(handleGetPhotoAlbum.a());
                    b39Var2.w(handleGetPhotoAlbum.e());
                    if (!b39Var2.h()) {
                        b39Var2.n(false);
                        addObserver("GetPhotoAlbum", b39Var2, false);
                    }
                }
                b39Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                b39Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                b39 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    b39Var2.x(preheatWeb.f());
                    b39Var2.t(preheatWeb.b());
                    b39Var2.o(preheatWeb.a());
                    b39Var2.w(preheatWeb.e());
                }
                b39Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                b39Var2.r(true);
                b39 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    b39Var2.x(openMXDYab.f());
                    b39Var2.t(openMXDYab.b());
                    b39Var2.o(openMXDYab.a());
                    b39Var2.w(openMXDYab.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/portal")) {
                b39Var2.r(true);
                b39 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    b39Var2.x(handlePortal.f());
                    b39Var2.t(handlePortal.b());
                    b39Var2.o(handlePortal.a());
                    b39Var2.w(handlePortal.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                b39Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                b39 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    b39Var2.x(selectPhotoAlbum.f());
                    b39Var2.t(selectPhotoAlbum.b());
                    b39Var2.o(selectPhotoAlbum.a());
                    b39Var2.w(selectPhotoAlbum.e());
                    if (!b39Var2.h()) {
                        b39Var2.n(false);
                        addObserver("selectPhotoAlbum", b39Var2, false);
                    }
                }
                b39Var2.y(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                b39Var2.r(true);
                b39 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (operateNotifyDataChanged != null) {
                    b39Var2.x(operateNotifyDataChanged.f());
                    b39Var2.t(operateNotifyDataChanged.b());
                    b39Var2.o(operateNotifyDataChanged.a());
                    b39Var2.w(operateNotifyDataChanged.e());
                    if (!b39Var2.h()) {
                        b39Var2.n(false);
                        addObserver("notifyNativeRefresh", b39Var2, false);
                    }
                }
                b39Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                b39Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                b39 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    b39Var2.x(selectPrivateMsg.f());
                    b39Var2.t(selectPrivateMsg.b());
                    b39Var2.o(selectPrivateMsg.a());
                    b39Var2.w(selectPrivateMsg.e());
                    if (!b39Var2.h()) {
                        i4 = 0;
                        b39Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", b39Var2, false);
                        b39Var2.y(i4);
                    }
                }
                i4 = 0;
                b39Var2.y(i4);
            } else if (b.equals("router/goToReportThreadPage")) {
                b39Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                b39 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    b39Var2.x(reportUserTheme.f());
                    b39Var2.t(reportUserTheme.b());
                    b39Var2.o(reportUserTheme.a());
                    b39Var2.w(reportUserTheme.e());
                    if (!b39Var2.h()) {
                        i3 = 0;
                        b39Var2.n(false);
                        addObserver("goToReportThreadPage", b39Var2, false);
                        b39Var2.y(i3);
                    }
                }
                i3 = 0;
                b39Var2.y(i3);
            } else if (b.equals("system/playSound")) {
                b39Var2.r(true);
                b39 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    b39Var2.x(playSound.f());
                    b39Var2.t(playSound.b());
                    b39Var2.o(playSound.a());
                    b39Var2.w(playSound.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                b39Var2.r(true);
                b39 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    b39Var2.x(playVibrate.f());
                    b39Var2.t(playVibrate.b());
                    b39Var2.o(playVibrate.a());
                    b39Var2.w(playVibrate.e());
                }
                b39Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                b39Var2.r(true);
                b39 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    b39Var2.x(jumpLoginActivity.f());
                    b39Var2.t(jumpLoginActivity.b());
                    b39Var2.o(jumpLoginActivity.a());
                    b39Var2.w(jumpLoginActivity.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                b39Var2.r(true);
                b39 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    b39Var2.x(startLoadTimeInterval.f());
                    b39Var2.t(startLoadTimeInterval.b());
                    b39Var2.o(startLoadTimeInterval.a());
                    b39Var2.w(startLoadTimeInterval.e());
                }
                b39Var2.y(0);
            } else if (b.equals("device/getZid")) {
                b39Var2.r(true);
                b39 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    b39Var2.x(zid.f());
                    b39Var2.t(zid.b());
                    b39Var2.o(zid.a());
                    b39Var2.w(zid.e());
                }
                b39Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                b39Var2.r(true);
                b39 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    b39Var2.x(hdid.f());
                    b39Var2.t(hdid.b());
                    b39Var2.o(hdid.a());
                    b39Var2.w(hdid.e());
                }
                b39Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                b39Var2.r(true);
                b39 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    b39Var2.x(shareInfo.f());
                    b39Var2.t(shareInfo.b());
                    b39Var2.o(shareInfo.a());
                    b39Var2.w(shareInfo.e());
                }
                b39Var2.y(0);
            } else if (b.equals("share/share")) {
                b39Var2.r(true);
                b39 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"));
                if (share != null) {
                    b39Var2.x(share.f());
                    b39Var2.t(share.b());
                    b39Var2.o(share.a());
                    b39Var2.w(share.e());
                }
                b39Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                b39Var2.r(true);
                b39 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    b39Var2.x(clipperInformation.f());
                    b39Var2.t(clipperInformation.b());
                    b39Var2.o(clipperInformation.a());
                    b39Var2.w(clipperInformation.e());
                }
                b39Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                b39Var2.r(true);
                b39 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    b39Var2.x(clipperInformation2.f());
                    b39Var2.t(clipperInformation2.b());
                    b39Var2.o(clipperInformation2.a());
                    b39Var2.w(clipperInformation2.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                b39Var2.r(true);
                b39 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    b39Var2.x(goToEditPost.f());
                    b39Var2.t(goToEditPost.b());
                    b39Var2.o(goToEditPost.a());
                    b39Var2.w(goToEditPost.e());
                }
                b39Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                b39Var2.r(true);
                b39 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    b39Var2.x(updateSearchForumInfo.f());
                    b39Var2.t(updateSearchForumInfo.b());
                    b39Var2.o(updateSearchForumInfo.a());
                    b39Var2.w(updateSearchForumInfo.e());
                }
                b39Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                b39Var2.r(true);
                b39 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    b39Var2.x(personlizedSwitchChange.f());
                    b39Var2.t(personlizedSwitchChange.b());
                    b39Var2.o(personlizedSwitchChange.a());
                    b39Var2.w(personlizedSwitchChange.e());
                }
                b39Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                b39Var2.r(true);
                b39 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    b39Var2.x(updateTailStyle.f());
                    b39Var2.t(updateTailStyle.b());
                    b39Var2.o(updateTailStyle.a());
                    b39Var2.w(updateTailStyle.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                b39Var2.r(true);
                b39 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    b39Var2.x(goToVideoImmersivePage.f());
                    b39Var2.t(goToVideoImmersivePage.b());
                    b39Var2.o(goToVideoImmersivePage.a());
                    b39Var2.w(goToVideoImmersivePage.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                b39Var2.r(true);
                b39 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    b39Var2.x(jumpToVideo.f());
                    b39Var2.t(jumpToVideo.b());
                    b39Var2.o(jumpToVideo.a());
                    b39Var2.w(jumpToVideo.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                b39Var2.r(true);
                b39 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    b39Var2.x(closeNativeMask.f());
                    b39Var2.t(closeNativeMask.b());
                    b39Var2.o(closeNativeMask.a());
                    b39Var2.w(closeNativeMask.e());
                }
                b39Var2.y(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                b39Var2.r(true);
                b39 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    b39Var2.x(oneKeyDeletion.f());
                    b39Var2.t(oneKeyDeletion.b());
                    b39Var2.o(oneKeyDeletion.a());
                    b39Var2.w(oneKeyDeletion.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                b39Var2.r(true);
                b39 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    b39Var2.x(checkAppInstall.f());
                    b39Var2.t(checkAppInstall.b());
                    b39Var2.o(checkAppInstall.a());
                    b39Var2.w(checkAppInstall.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                b39Var2.r(true);
                b39 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    b39Var2.x(disableBack.f());
                    b39Var2.t(disableBack.b());
                    b39Var2.o(disableBack.a());
                    b39Var2.w(disableBack.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/startApp")) {
                b39Var2.r(true);
                b39 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    b39Var2.x(startApp.f());
                    b39Var2.t(startApp.b());
                    b39Var2.o(startApp.a());
                    b39Var2.w(startApp.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                b39Var2.r(true);
                b39 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    b39Var2.x(hasNotificationPermission.f());
                    b39Var2.t(hasNotificationPermission.b());
                    b39Var2.o(hasNotificationPermission.a());
                    b39Var2.w(hasNotificationPermission.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                b39Var2.r(true);
                b39 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    b39Var2.x(goToNotificationSetting.f());
                    b39Var2.t(goToNotificationSetting.b());
                    b39Var2.o(goToNotificationSetting.a());
                    b39Var2.w(goToNotificationSetting.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                b39Var2.r(true);
                b39 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushManager.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString(a.v));
                if (startDownloadGameApk != null) {
                    b39Var2.x(startDownloadGameApk.f());
                    b39Var2.t(startDownloadGameApk.b());
                    b39Var2.o(startDownloadGameApk.a());
                    b39Var2.w(startDownloadGameApk.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                b39Var2.r(true);
                b39 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    b39Var2.x(checkInstallGameApk.f());
                    b39Var2.t(checkInstallGameApk.b());
                    b39Var2.o(checkInstallGameApk.a());
                    b39Var2.w(checkInstallGameApk.e());
                }
                b39Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                b39Var2.r(true);
                b39 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    b39Var2.x(startDownloadCss.f());
                    b39Var2.t(startDownloadCss.b());
                    b39Var2.o(startDownloadCss.a());
                    b39Var2.w(startDownloadCss.e());
                }
                b39Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                b39Var2.r(true);
                b39 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    b39Var2.x(disableGoBack.f());
                    b39Var2.t(disableGoBack.b());
                    b39Var2.o(disableGoBack.a());
                    b39Var2.w(disableGoBack.e());
                }
                b39Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                b39Var2.r(true);
                b39 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    b39Var2.x(supplementInfo.f());
                    b39Var2.t(supplementInfo.b());
                    b39Var2.o(supplementInfo.a());
                    b39Var2.w(supplementInfo.e());
                }
                b39Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                b39Var2.r(true);
                b39 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    b39Var2.x(deviceInfo.f());
                    b39Var2.t(deviceInfo.b());
                    b39Var2.o(deviceInfo.a());
                    b39Var2.w(deviceInfo.e());
                }
                b39Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                b39Var2.r(true);
                b39 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    b39Var2.x(sendCompleteTaskReqMsg.f());
                    b39Var2.t(sendCompleteTaskReqMsg.b());
                    b39Var2.o(sendCompleteTaskReqMsg.a());
                    b39Var2.w(sendCompleteTaskReqMsg.e());
                }
                b39Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                b39Var2.r(true);
                b39 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    b39Var2.x(showTipToast.f());
                    b39Var2.t(showTipToast.b());
                    b39Var2.o(showTipToast.a());
                    b39Var2.w(showTipToast.e());
                }
                b39Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                b39Var2.r(true);
                b39 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    b39Var2.x(getModalData.f());
                    b39Var2.t(getModalData.b());
                    b39Var2.o(getModalData.a());
                    b39Var2.w(getModalData.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                b39Var2.r(true);
                b39 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    b39Var2.x(openThirdPartApp.f());
                    b39Var2.t(openThirdPartApp.b());
                    b39Var2.o(openThirdPartApp.a());
                    b39Var2.w(openThirdPartApp.e());
                }
                b39Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                b39Var2.r(true);
                b39 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    b39Var2.x(jumpToHtmlPage.f());
                    b39Var2.t(jumpToHtmlPage.b());
                    b39Var2.o(jumpToHtmlPage.a());
                    b39Var2.w(jumpToHtmlPage.e());
                }
                b39Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                b39Var2.r(true);
                b39 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    b39Var2.x(offlineUserInfo.f());
                    b39Var2.t(offlineUserInfo.b());
                    b39Var2.o(offlineUserInfo.a());
                    b39Var2.w(offlineUserInfo.e());
                }
                b39Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                b39Var2.r(true);
                b39 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    b39Var2.x(deleteOfflineBundle.f());
                    b39Var2.t(deleteOfflineBundle.b());
                    b39Var2.o(deleteOfflineBundle.a());
                    b39Var2.w(deleteOfflineBundle.e());
                }
                b39Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                b39Var2.r(true);
                b39 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    b39Var2.x(updateOfflineBundle.f());
                    b39Var2.t(updateOfflineBundle.b());
                    b39Var2.o(updateOfflineBundle.a());
                    b39Var2.w(updateOfflineBundle.e());
                }
                b39Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                b39Var2.r(true);
                b39 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    b39Var2.x(switchOfflineInterface.f());
                    b39Var2.t(switchOfflineInterface.b());
                    b39Var2.o(switchOfflineInterface.a());
                    b39Var2.w(switchOfflineInterface.e());
                }
                b39Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                b39Var2.r(true);
                b39 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    b39Var2.x(switchOfflineBundleStatus.f());
                    b39Var2.t(switchOfflineBundleStatus.b());
                    b39Var2.o(switchOfflineBundleStatus.a());
                    b39Var2.w(switchOfflineBundleStatus.e());
                }
                b39Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                b39Var2.r(true);
                b39 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    b39Var2.x(finishTestAnswer.f());
                    b39Var2.t(finishTestAnswer.b());
                    b39Var2.o(finishTestAnswer.a());
                    b39Var2.w(finishTestAnswer.e());
                }
                b39Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                b39Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                b39 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    b39Var2.x(switchUrlHost.f());
                    b39Var2.t(switchUrlHost.b());
                    b39Var2.o(switchUrlHost.a());
                    b39Var2.w(switchUrlHost.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                b39Var2.r(true);
                b39 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    b39Var2.x(appStorage.f());
                    b39Var2.t(appStorage.b());
                    b39Var2.o(appStorage.a());
                    b39Var2.w(appStorage.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                b39Var2.r(true);
                b39 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    b39Var2.x(putAppStorage.f());
                    b39Var2.t(putAppStorage.b());
                    b39Var2.o(putAppStorage.a());
                    b39Var2.w(putAppStorage.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                b39Var2.r(true);
                b39 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    b39Var2.x(historyForumData.f());
                    b39Var2.t(historyForumData.b());
                    b39Var2.o(historyForumData.a());
                    b39Var2.w(historyForumData.e());
                }
                b39Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                b39Var2.r(true);
                b39 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    b39Var2.x(worldCupRaiseSuccess.f());
                    b39Var2.t(worldCupRaiseSuccess.b());
                    b39Var2.o(worldCupRaiseSuccess.a());
                    b39Var2.w(worldCupRaiseSuccess.e());
                }
                b39Var2.y(0);
            } else if (b.equals("account/getAlipayUserId")) {
                b39Var2.r(true);
                b39 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    b39Var2.x(alipayUserId.f());
                    b39Var2.t(alipayUserId.b());
                    b39Var2.o(alipayUserId.a());
                    b39Var2.w(alipayUserId.e());
                    if (!b39Var2.h()) {
                        i2 = 0;
                        b39Var2.n(false);
                        addObserver("aliAuthResult", b39Var2, false);
                        b39Var2.y(i2);
                    }
                }
                i2 = 0;
                b39Var2.y(i2);
            } else if (b.equals("system/getFileDownloadStatus")) {
                b39Var2.r(true);
                b39 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString(a.v));
                if (fileDownloadStatus != null) {
                    b39Var2.x(fileDownloadStatus.f());
                    b39Var2.t(fileDownloadStatus.b());
                    b39Var2.o(fileDownloadStatus.a());
                    b39Var2.w(fileDownloadStatus.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                b39Var2.r(true);
                b39 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString(a.v));
                if (fileDownloadProgress != null) {
                    b39Var2.x(fileDownloadProgress.f());
                    b39Var2.t(fileDownloadProgress.b());
                    b39Var2.o(fileDownloadProgress.a());
                    b39Var2.w(fileDownloadProgress.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/fileDownloadPause")) {
                b39Var2.r(true);
                b39 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString(a.v));
                if (fileDownloadPause != null) {
                    b39Var2.x(fileDownloadPause.f());
                    b39Var2.t(fileDownloadPause.b());
                    b39Var2.o(fileDownloadPause.a());
                    b39Var2.w(fileDownloadPause.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                b39Var2.r(true);
                b39 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString(a.v));
                if (fileDownloadDelete != null) {
                    b39Var2.x(fileDownloadDelete.f());
                    b39Var2.t(fileDownloadDelete.b());
                    b39Var2.o(fileDownloadDelete.a());
                    b39Var2.w(fileDownloadDelete.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/installGameApk")) {
                b39Var2.r(true);
                b39 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString(a.v));
                if (installGameApk != null) {
                    b39Var2.x(installGameApk.f());
                    b39Var2.t(installGameApk.b());
                    b39Var2.o(installGameApk.a());
                    b39Var2.w(installGameApk.e());
                }
                b39Var2.y(0);
            } else if (b.equals("system/launchApk")) {
                b39Var2.r(true);
                b39 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString(a.v));
                if (launchApk != null) {
                    b39Var2.x(launchApk.f());
                    b39Var2.t(launchApk.b());
                    b39Var2.o(launchApk.a());
                    b39Var2.w(launchApk.e());
                }
                b39Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                b39Var2.r(true);
                b39 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    b39Var2.x(requestByNative.f());
                    b39Var2.t(requestByNative.b());
                    b39Var2.o(requestByNative.a());
                    b39Var2.w(requestByNative.e());
                    if (!b39Var2.h()) {
                        i = 0;
                        b39Var2.n(false);
                        addObserver("RequestByNativeToH5", b39Var2, false);
                        b39Var2.y(i);
                    }
                }
                i = 0;
                b39Var2.y(i);
            }
            return b39Var2;
        }
        return (b39) invokeLL.objValue;
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

    @Override // com.baidu.tieba.z29
    public List<b39> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            b39 b39Var = null;
            if (dj.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                b39Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                b39Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                b39Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                b39Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                b39Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                b39Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                b39Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                b39Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                b39Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                b39Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                b39Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                b39Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                b39Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                b39Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                b39Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                b39Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                b39Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                b39Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                b39Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                b39Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("aliAuthResult")) {
                b39Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                b39Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                b39Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                b39Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (b39Var != null) {
                b39Var.y(0);
            }
            List<a39> list = this.mAsyncCallBackMethodList.get(str);
            if (b39Var != null && list != null) {
                Iterator<a39> it = list.iterator();
                if (!dj.isEmpty(b39Var.e())) {
                    while (it.hasNext()) {
                        a39 next = it.next();
                        if (next.b().equals(b39Var.e())) {
                            b39 b39Var2 = new b39();
                            b39Var2.v(next.a());
                            b39Var2.x(b39Var.f());
                            b39Var2.t(b39Var.b());
                            b39Var2.o(b39Var.a());
                            b39Var2.z(b39Var.l());
                            arrayList.add(b39Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        a39 next2 = it.next();
                        b39 b39Var3 = new b39();
                        b39Var3.v(next2.a());
                        b39Var3.x(b39Var.f());
                        b39Var3.t(b39Var.b());
                        b39Var3.o(b39Var.a());
                        b39Var3.z(b39Var.l());
                        arrayList.add(b39Var3);
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
