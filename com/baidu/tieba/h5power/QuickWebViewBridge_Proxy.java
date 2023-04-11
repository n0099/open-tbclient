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
import com.baidu.tieba.im9;
import com.baidu.tieba.jm9;
import com.baidu.tieba.km9;
import com.baidu.tieba.mm9;
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
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
public class QuickWebViewBridge_Proxy extends im9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.im9
    public km9 dispatch(mm9 mm9Var, km9 km9Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mm9Var, km9Var)) == null) {
            km9 km9Var2 = km9Var == null ? new km9() : km9Var;
            String b = mm9Var.b();
            JSONObject e = mm9Var.e();
            if (b.equals("account/startLoginModule")) {
                km9Var2.r(true);
                km9 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    km9Var2.x(startLoginModule.f());
                    km9Var2.t(startLoginModule.b());
                    km9Var2.o(startLoginModule.a());
                    km9Var2.w(startLoginModule.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                km9Var2.r(true);
                km9 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    km9Var2.x(finishPage.f());
                    km9Var2.t(finishPage.b());
                    km9Var2.o(finishPage.a());
                    km9Var2.w(finishPage.e());
                }
                km9Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                km9Var2.r(true);
                km9 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    km9Var2.x(showLowerHairHint.f());
                    km9Var2.t(showLowerHairHint.b());
                    km9Var2.o(showLowerHairHint.a());
                    km9Var2.w(showLowerHairHint.e());
                }
                km9Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                km9Var2.r(true);
                km9 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    km9Var2.x(gamePush.f());
                    km9Var2.t(gamePush.b());
                    km9Var2.o(gamePush.a());
                    km9Var2.w(gamePush.e());
                }
                km9Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                km9Var2.r(true);
                km9 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    km9Var2.x(handleGamePushStatus.f());
                    km9Var2.t(handleGamePushStatus.b());
                    km9Var2.o(handleGamePushStatus.a());
                    km9Var2.w(handleGamePushStatus.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                km9Var2.r(true);
                km9 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    km9Var2.x(jumpForumRulesEditPage.f());
                    km9Var2.t(jumpForumRulesEditPage.b());
                    km9Var2.o(jumpForumRulesEditPage.a());
                    km9Var2.w(jumpForumRulesEditPage.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                km9Var2.r(true);
                km9 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    km9Var2.x(handleGoToBarDetail.f());
                    km9Var2.t(handleGoToBarDetail.b());
                    km9Var2.o(handleGoToBarDetail.a());
                    km9Var2.w(handleGoToBarDetail.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                km9Var2.r(true);
                km9 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    km9Var2.x(handleSaveImage.f());
                    km9Var2.t(handleSaveImage.b());
                    km9Var2.o(handleSaveImage.a());
                    km9Var2.w(handleSaveImage.e());
                    if (!km9Var2.h()) {
                        km9Var2.n(false);
                        addObserver("saveImageSuccess", km9Var2, false);
                    }
                }
                km9Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                km9Var2.r(true);
                km9 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    km9Var2.x(orderGameApk.f());
                    km9Var2.t(orderGameApk.b());
                    km9Var2.o(orderGameApk.a());
                    km9Var2.w(orderGameApk.e());
                    if (!km9Var2.h()) {
                        km9Var2.n(false);
                        addObserver("orderGameApkResult", km9Var2, false);
                    }
                }
                km9Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                km9Var2.r(true);
                km9 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    km9Var2.x(handleGetPhotoAlbum.f());
                    km9Var2.t(handleGetPhotoAlbum.b());
                    km9Var2.o(handleGetPhotoAlbum.a());
                    km9Var2.w(handleGetPhotoAlbum.e());
                    if (!km9Var2.h()) {
                        km9Var2.n(false);
                        addObserver("GetPhotoAlbum", km9Var2, false);
                    }
                }
                km9Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                km9Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                km9 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    km9Var2.x(preheatWeb.f());
                    km9Var2.t(preheatWeb.b());
                    km9Var2.o(preheatWeb.a());
                    km9Var2.w(preheatWeb.e());
                }
                km9Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                km9Var2.r(true);
                km9 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    km9Var2.x(openMXDYab.f());
                    km9Var2.t(openMXDYab.b());
                    km9Var2.o(openMXDYab.a());
                    km9Var2.w(openMXDYab.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/portal")) {
                km9Var2.r(true);
                km9 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    km9Var2.x(handlePortal.f());
                    km9Var2.t(handlePortal.b());
                    km9Var2.o(handlePortal.a());
                    km9Var2.w(handlePortal.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                km9Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                km9 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    km9Var2.x(selectPhotoAlbum.f());
                    km9Var2.t(selectPhotoAlbum.b());
                    km9Var2.o(selectPhotoAlbum.a());
                    km9Var2.w(selectPhotoAlbum.e());
                    if (!km9Var2.h()) {
                        km9Var2.n(false);
                        addObserver("selectPhotoAlbum", km9Var2, false);
                    }
                }
                km9Var2.y(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                km9Var2.r(true);
                km9 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (operateNotifyDataChanged != null) {
                    km9Var2.x(operateNotifyDataChanged.f());
                    km9Var2.t(operateNotifyDataChanged.b());
                    km9Var2.o(operateNotifyDataChanged.a());
                    km9Var2.w(operateNotifyDataChanged.e());
                    if (!km9Var2.h()) {
                        km9Var2.n(false);
                        addObserver("notifyNativeRefresh", km9Var2, false);
                    }
                }
                km9Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                km9Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                km9 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    km9Var2.x(selectPrivateMsg.f());
                    km9Var2.t(selectPrivateMsg.b());
                    km9Var2.o(selectPrivateMsg.a());
                    km9Var2.w(selectPrivateMsg.e());
                    if (!km9Var2.h()) {
                        i4 = 0;
                        km9Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", km9Var2, false);
                        km9Var2.y(i4);
                    }
                }
                i4 = 0;
                km9Var2.y(i4);
            } else if (b.equals("router/goToReportThreadPage")) {
                km9Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                km9 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    km9Var2.x(reportUserTheme.f());
                    km9Var2.t(reportUserTheme.b());
                    km9Var2.o(reportUserTheme.a());
                    km9Var2.w(reportUserTheme.e());
                    if (!km9Var2.h()) {
                        i3 = 0;
                        km9Var2.n(false);
                        addObserver("goToReportThreadPage", km9Var2, false);
                        km9Var2.y(i3);
                    }
                }
                i3 = 0;
                km9Var2.y(i3);
            } else if (b.equals("system/playSound")) {
                km9Var2.r(true);
                km9 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    km9Var2.x(playSound.f());
                    km9Var2.t(playSound.b());
                    km9Var2.o(playSound.a());
                    km9Var2.w(playSound.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                km9Var2.r(true);
                km9 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    km9Var2.x(playVibrate.f());
                    km9Var2.t(playVibrate.b());
                    km9Var2.o(playVibrate.a());
                    km9Var2.w(playVibrate.e());
                }
                km9Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                km9Var2.r(true);
                km9 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    km9Var2.x(jumpLoginActivity.f());
                    km9Var2.t(jumpLoginActivity.b());
                    km9Var2.o(jumpLoginActivity.a());
                    km9Var2.w(jumpLoginActivity.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                km9Var2.r(true);
                km9 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    km9Var2.x(startLoadTimeInterval.f());
                    km9Var2.t(startLoadTimeInterval.b());
                    km9Var2.o(startLoadTimeInterval.a());
                    km9Var2.w(startLoadTimeInterval.e());
                }
                km9Var2.y(0);
            } else if (b.equals("device/getZid")) {
                km9Var2.r(true);
                km9 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    km9Var2.x(zid.f());
                    km9Var2.t(zid.b());
                    km9Var2.o(zid.a());
                    km9Var2.w(zid.e());
                }
                km9Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                km9Var2.r(true);
                km9 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    km9Var2.x(hdid.f());
                    km9Var2.t(hdid.b());
                    km9Var2.o(hdid.a());
                    km9Var2.w(hdid.e());
                }
                km9Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                km9Var2.r(true);
                km9 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    km9Var2.x(shareInfo.f());
                    km9Var2.t(shareInfo.b());
                    km9Var2.o(shareInfo.a());
                    km9Var2.w(shareInfo.e());
                }
                km9Var2.y(0);
            } else if (b.equals("share/share")) {
                km9Var2.r(true);
                km9 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"));
                if (share != null) {
                    km9Var2.x(share.f());
                    km9Var2.t(share.b());
                    km9Var2.o(share.a());
                    km9Var2.w(share.e());
                }
                km9Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                km9Var2.r(true);
                km9 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    km9Var2.x(clipperInformation.f());
                    km9Var2.t(clipperInformation.b());
                    km9Var2.o(clipperInformation.a());
                    km9Var2.w(clipperInformation.e());
                }
                km9Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                km9Var2.r(true);
                km9 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    km9Var2.x(clipperInformation2.f());
                    km9Var2.t(clipperInformation2.b());
                    km9Var2.o(clipperInformation2.a());
                    km9Var2.w(clipperInformation2.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                km9Var2.r(true);
                km9 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    km9Var2.x(goToEditPost.f());
                    km9Var2.t(goToEditPost.b());
                    km9Var2.o(goToEditPost.a());
                    km9Var2.w(goToEditPost.e());
                }
                km9Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                km9Var2.r(true);
                km9 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    km9Var2.x(updateSearchForumInfo.f());
                    km9Var2.t(updateSearchForumInfo.b());
                    km9Var2.o(updateSearchForumInfo.a());
                    km9Var2.w(updateSearchForumInfo.e());
                }
                km9Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                km9Var2.r(true);
                km9 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    km9Var2.x(personlizedSwitchChange.f());
                    km9Var2.t(personlizedSwitchChange.b());
                    km9Var2.o(personlizedSwitchChange.a());
                    km9Var2.w(personlizedSwitchChange.e());
                }
                km9Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                km9Var2.r(true);
                km9 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    km9Var2.x(updateTailStyle.f());
                    km9Var2.t(updateTailStyle.b());
                    km9Var2.o(updateTailStyle.a());
                    km9Var2.w(updateTailStyle.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                km9Var2.r(true);
                km9 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    km9Var2.x(goToVideoImmersivePage.f());
                    km9Var2.t(goToVideoImmersivePage.b());
                    km9Var2.o(goToVideoImmersivePage.a());
                    km9Var2.w(goToVideoImmersivePage.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                km9Var2.r(true);
                km9 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    km9Var2.x(jumpToVideo.f());
                    km9Var2.t(jumpToVideo.b());
                    km9Var2.o(jumpToVideo.a());
                    km9Var2.w(jumpToVideo.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                km9Var2.r(true);
                km9 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    km9Var2.x(closeNativeMask.f());
                    km9Var2.t(closeNativeMask.b());
                    km9Var2.o(closeNativeMask.a());
                    km9Var2.w(closeNativeMask.e());
                }
                km9Var2.y(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                km9Var2.r(true);
                km9 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    km9Var2.x(oneKeyDeletion.f());
                    km9Var2.t(oneKeyDeletion.b());
                    km9Var2.o(oneKeyDeletion.a());
                    km9Var2.w(oneKeyDeletion.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                km9Var2.r(true);
                km9 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    km9Var2.x(checkAppInstall.f());
                    km9Var2.t(checkAppInstall.b());
                    km9Var2.o(checkAppInstall.a());
                    km9Var2.w(checkAppInstall.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                km9Var2.r(true);
                km9 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    km9Var2.x(disableBack.f());
                    km9Var2.t(disableBack.b());
                    km9Var2.o(disableBack.a());
                    km9Var2.w(disableBack.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/startApp")) {
                km9Var2.r(true);
                km9 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    km9Var2.x(startApp.f());
                    km9Var2.t(startApp.b());
                    km9Var2.o(startApp.a());
                    km9Var2.w(startApp.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                km9Var2.r(true);
                km9 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    km9Var2.x(hasNotificationPermission.f());
                    km9Var2.t(hasNotificationPermission.b());
                    km9Var2.o(hasNotificationPermission.a());
                    km9Var2.w(hasNotificationPermission.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                km9Var2.r(true);
                km9 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    km9Var2.x(goToNotificationSetting.f());
                    km9Var2.t(goToNotificationSetting.b());
                    km9Var2.o(goToNotificationSetting.a());
                    km9Var2.w(goToNotificationSetting.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                km9Var2.r(true);
                km9 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    km9Var2.x(startDownloadGameApk.f());
                    km9Var2.t(startDownloadGameApk.b());
                    km9Var2.o(startDownloadGameApk.a());
                    km9Var2.w(startDownloadGameApk.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                km9Var2.r(true);
                km9 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    km9Var2.x(checkInstallGameApk.f());
                    km9Var2.t(checkInstallGameApk.b());
                    km9Var2.o(checkInstallGameApk.a());
                    km9Var2.w(checkInstallGameApk.e());
                }
                km9Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                km9Var2.r(true);
                km9 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    km9Var2.x(startDownloadCss.f());
                    km9Var2.t(startDownloadCss.b());
                    km9Var2.o(startDownloadCss.a());
                    km9Var2.w(startDownloadCss.e());
                }
                km9Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                km9Var2.r(true);
                km9 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    km9Var2.x(disableGoBack.f());
                    km9Var2.t(disableGoBack.b());
                    km9Var2.o(disableGoBack.a());
                    km9Var2.w(disableGoBack.e());
                }
                km9Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                km9Var2.r(true);
                km9 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    km9Var2.x(supplementInfo.f());
                    km9Var2.t(supplementInfo.b());
                    km9Var2.o(supplementInfo.a());
                    km9Var2.w(supplementInfo.e());
                }
                km9Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                km9Var2.r(true);
                km9 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    km9Var2.x(deviceInfo.f());
                    km9Var2.t(deviceInfo.b());
                    km9Var2.o(deviceInfo.a());
                    km9Var2.w(deviceInfo.e());
                }
                km9Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                km9Var2.r(true);
                km9 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    km9Var2.x(sendCompleteTaskReqMsg.f());
                    km9Var2.t(sendCompleteTaskReqMsg.b());
                    km9Var2.o(sendCompleteTaskReqMsg.a());
                    km9Var2.w(sendCompleteTaskReqMsg.e());
                }
                km9Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                km9Var2.r(true);
                km9 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    km9Var2.x(showTipToast.f());
                    km9Var2.t(showTipToast.b());
                    km9Var2.o(showTipToast.a());
                    km9Var2.w(showTipToast.e());
                }
                km9Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                km9Var2.r(true);
                km9 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    km9Var2.x(getModalData.f());
                    km9Var2.t(getModalData.b());
                    km9Var2.o(getModalData.a());
                    km9Var2.w(getModalData.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                km9Var2.r(true);
                km9 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    km9Var2.x(openThirdPartApp.f());
                    km9Var2.t(openThirdPartApp.b());
                    km9Var2.o(openThirdPartApp.a());
                    km9Var2.w(openThirdPartApp.e());
                }
                km9Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                km9Var2.r(true);
                km9 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    km9Var2.x(jumpToHtmlPage.f());
                    km9Var2.t(jumpToHtmlPage.b());
                    km9Var2.o(jumpToHtmlPage.a());
                    km9Var2.w(jumpToHtmlPage.e());
                }
                km9Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                km9Var2.r(true);
                km9 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    km9Var2.x(offlineUserInfo.f());
                    km9Var2.t(offlineUserInfo.b());
                    km9Var2.o(offlineUserInfo.a());
                    km9Var2.w(offlineUserInfo.e());
                }
                km9Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                km9Var2.r(true);
                km9 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    km9Var2.x(deleteOfflineBundle.f());
                    km9Var2.t(deleteOfflineBundle.b());
                    km9Var2.o(deleteOfflineBundle.a());
                    km9Var2.w(deleteOfflineBundle.e());
                }
                km9Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                km9Var2.r(true);
                km9 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    km9Var2.x(updateOfflineBundle.f());
                    km9Var2.t(updateOfflineBundle.b());
                    km9Var2.o(updateOfflineBundle.a());
                    km9Var2.w(updateOfflineBundle.e());
                }
                km9Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                km9Var2.r(true);
                km9 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    km9Var2.x(switchOfflineInterface.f());
                    km9Var2.t(switchOfflineInterface.b());
                    km9Var2.o(switchOfflineInterface.a());
                    km9Var2.w(switchOfflineInterface.e());
                }
                km9Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                km9Var2.r(true);
                km9 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    km9Var2.x(switchOfflineBundleStatus.f());
                    km9Var2.t(switchOfflineBundleStatus.b());
                    km9Var2.o(switchOfflineBundleStatus.a());
                    km9Var2.w(switchOfflineBundleStatus.e());
                }
                km9Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                km9Var2.r(true);
                km9 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    km9Var2.x(finishTestAnswer.f());
                    km9Var2.t(finishTestAnswer.b());
                    km9Var2.o(finishTestAnswer.a());
                    km9Var2.w(finishTestAnswer.e());
                }
                km9Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                km9Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                km9 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    km9Var2.x(switchUrlHost.f());
                    km9Var2.t(switchUrlHost.b());
                    km9Var2.o(switchUrlHost.a());
                    km9Var2.w(switchUrlHost.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                km9Var2.r(true);
                km9 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    km9Var2.x(appStorage.f());
                    km9Var2.t(appStorage.b());
                    km9Var2.o(appStorage.a());
                    km9Var2.w(appStorage.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                km9Var2.r(true);
                km9 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    km9Var2.x(putAppStorage.f());
                    km9Var2.t(putAppStorage.b());
                    km9Var2.o(putAppStorage.a());
                    km9Var2.w(putAppStorage.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                km9Var2.r(true);
                km9 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    km9Var2.x(historyForumData.f());
                    km9Var2.t(historyForumData.b());
                    km9Var2.o(historyForumData.a());
                    km9Var2.w(historyForumData.e());
                }
                km9Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                km9Var2.r(true);
                km9 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    km9Var2.x(worldCupRaiseSuccess.f());
                    km9Var2.t(worldCupRaiseSuccess.b());
                    km9Var2.o(worldCupRaiseSuccess.a());
                    km9Var2.w(worldCupRaiseSuccess.e());
                }
                km9Var2.y(0);
            } else if (b.equals("account/getAlipayUserId")) {
                km9Var2.r(true);
                km9 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    km9Var2.x(alipayUserId.f());
                    km9Var2.t(alipayUserId.b());
                    km9Var2.o(alipayUserId.a());
                    km9Var2.w(alipayUserId.e());
                    if (!km9Var2.h()) {
                        i2 = 0;
                        km9Var2.n(false);
                        addObserver("aliAuthResult", km9Var2, false);
                        km9Var2.y(i2);
                    }
                }
                i2 = 0;
                km9Var2.y(i2);
            } else if (b.equals("system/getFileDownloadStatus")) {
                km9Var2.r(true);
                km9 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    km9Var2.x(fileDownloadStatus.f());
                    km9Var2.t(fileDownloadStatus.b());
                    km9Var2.o(fileDownloadStatus.a());
                    km9Var2.w(fileDownloadStatus.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                km9Var2.r(true);
                km9 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    km9Var2.x(fileDownloadProgress.f());
                    km9Var2.t(fileDownloadProgress.b());
                    km9Var2.o(fileDownloadProgress.a());
                    km9Var2.w(fileDownloadProgress.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/fileDownloadPause")) {
                km9Var2.r(true);
                km9 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    km9Var2.x(fileDownloadPause.f());
                    km9Var2.t(fileDownloadPause.b());
                    km9Var2.o(fileDownloadPause.a());
                    km9Var2.w(fileDownloadPause.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                km9Var2.r(true);
                km9 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    km9Var2.x(fileDownloadDelete.f());
                    km9Var2.t(fileDownloadDelete.b());
                    km9Var2.o(fileDownloadDelete.a());
                    km9Var2.w(fileDownloadDelete.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/installGameApk")) {
                km9Var2.r(true);
                km9 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    km9Var2.x(installGameApk.f());
                    km9Var2.t(installGameApk.b());
                    km9Var2.o(installGameApk.a());
                    km9Var2.w(installGameApk.e());
                }
                km9Var2.y(0);
            } else if (b.equals("system/launchApk")) {
                km9Var2.r(true);
                km9 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    km9Var2.x(launchApk.f());
                    km9Var2.t(launchApk.b());
                    km9Var2.o(launchApk.a());
                    km9Var2.w(launchApk.e());
                }
                km9Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                km9Var2.r(true);
                km9 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    km9Var2.x(requestByNative.f());
                    km9Var2.t(requestByNative.b());
                    km9Var2.o(requestByNative.a());
                    km9Var2.w(requestByNative.e());
                    if (!km9Var2.h()) {
                        i = 0;
                        km9Var2.n(false);
                        addObserver("RequestByNativeToH5", km9Var2, false);
                        km9Var2.y(i);
                    }
                }
                i = 0;
                km9Var2.y(i);
            }
            return km9Var2;
        }
        return (km9) invokeLL.objValue;
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

    @Override // com.baidu.tieba.im9
    public List<km9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            km9 km9Var = null;
            if (hi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                km9Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                km9Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                km9Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                km9Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                km9Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                km9Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                km9Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                km9Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                km9Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                km9Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                km9Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                km9Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                km9Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                km9Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                km9Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                km9Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                km9Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                km9Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                km9Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                km9Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("aliAuthResult")) {
                km9Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                km9Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                km9Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                km9Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (km9Var != null) {
                km9Var.y(0);
            }
            List<jm9> list = this.mAsyncCallBackMethodList.get(str);
            if (km9Var != null && list != null) {
                Iterator<jm9> it = list.iterator();
                if (!hi.isEmpty(km9Var.e())) {
                    while (it.hasNext()) {
                        jm9 next = it.next();
                        if (next.b().equals(km9Var.e())) {
                            km9 km9Var2 = new km9();
                            km9Var2.v(next.a());
                            km9Var2.x(km9Var.f());
                            km9Var2.t(km9Var.b());
                            km9Var2.o(km9Var.a());
                            km9Var2.z(km9Var.l());
                            arrayList.add(km9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jm9 next2 = it.next();
                        km9 km9Var3 = new km9();
                        km9Var3.v(next2.a());
                        km9Var3.x(km9Var.f());
                        km9Var3.t(km9Var.b());
                        km9Var3.o(km9Var.a());
                        km9Var3.z(km9Var.l());
                        arrayList.add(km9Var3);
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
