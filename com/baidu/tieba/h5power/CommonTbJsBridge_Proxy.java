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
import com.baidu.tieba.dj;
import com.baidu.tieba.v19;
import com.baidu.tieba.w19;
import com.baidu.tieba.x19;
import com.baidu.tieba.z19;
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
public class CommonTbJsBridge_Proxy extends v19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.v19
    public x19 dispatch(z19 z19Var, x19 x19Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, z19Var, x19Var)) == null) {
            x19 x19Var2 = x19Var == null ? new x19() : x19Var;
            String b = z19Var.b();
            JSONObject e = z19Var.e();
            if (b.equals("account/startLoginModule")) {
                x19Var2.r(true);
                x19 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    x19Var2.x(startLoginModule.f());
                    x19Var2.t(startLoginModule.b());
                    x19Var2.o(startLoginModule.a());
                    x19Var2.w(startLoginModule.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                x19Var2.r(true);
                x19 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    x19Var2.x(finishPage.f());
                    x19Var2.t(finishPage.b());
                    x19Var2.o(finishPage.a());
                    x19Var2.w(finishPage.e());
                }
                x19Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                x19Var2.r(true);
                x19 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    x19Var2.x(showLowerHairHint.f());
                    x19Var2.t(showLowerHairHint.b());
                    x19Var2.o(showLowerHairHint.a());
                    x19Var2.w(showLowerHairHint.e());
                }
                x19Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                x19Var2.r(true);
                x19 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    x19Var2.x(gamePush.f());
                    x19Var2.t(gamePush.b());
                    x19Var2.o(gamePush.a());
                    x19Var2.w(gamePush.e());
                }
                x19Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                x19Var2.r(true);
                x19 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    x19Var2.x(handleGamePushStatus.f());
                    x19Var2.t(handleGamePushStatus.b());
                    x19Var2.o(handleGamePushStatus.a());
                    x19Var2.w(handleGamePushStatus.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                x19Var2.r(true);
                x19 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    x19Var2.x(jumpForumRulesEditPage.f());
                    x19Var2.t(jumpForumRulesEditPage.b());
                    x19Var2.o(jumpForumRulesEditPage.a());
                    x19Var2.w(jumpForumRulesEditPage.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                x19Var2.r(true);
                x19 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    x19Var2.x(handleGoToBarDetail.f());
                    x19Var2.t(handleGoToBarDetail.b());
                    x19Var2.o(handleGoToBarDetail.a());
                    x19Var2.w(handleGoToBarDetail.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                x19Var2.r(true);
                x19 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    x19Var2.x(handleSaveImage.f());
                    x19Var2.t(handleSaveImage.b());
                    x19Var2.o(handleSaveImage.a());
                    x19Var2.w(handleSaveImage.e());
                    if (!x19Var2.h()) {
                        x19Var2.n(false);
                        addObserver("saveImageSuccess", x19Var2, false);
                    }
                }
                x19Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                x19Var2.r(true);
                x19 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    x19Var2.x(orderGameApk.f());
                    x19Var2.t(orderGameApk.b());
                    x19Var2.o(orderGameApk.a());
                    x19Var2.w(orderGameApk.e());
                    if (!x19Var2.h()) {
                        x19Var2.n(false);
                        addObserver("orderGameApkResult", x19Var2, false);
                    }
                }
                x19Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                x19Var2.r(true);
                x19 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    x19Var2.x(handleGetPhotoAlbum.f());
                    x19Var2.t(handleGetPhotoAlbum.b());
                    x19Var2.o(handleGetPhotoAlbum.a());
                    x19Var2.w(handleGetPhotoAlbum.e());
                    if (!x19Var2.h()) {
                        x19Var2.n(false);
                        addObserver("GetPhotoAlbum", x19Var2, false);
                    }
                }
                x19Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                x19Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                x19 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    x19Var2.x(preheatWeb.f());
                    x19Var2.t(preheatWeb.b());
                    x19Var2.o(preheatWeb.a());
                    x19Var2.w(preheatWeb.e());
                }
                x19Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                x19Var2.r(true);
                x19 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    x19Var2.x(openMXDYab.f());
                    x19Var2.t(openMXDYab.b());
                    x19Var2.o(openMXDYab.a());
                    x19Var2.w(openMXDYab.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/portal")) {
                x19Var2.r(true);
                x19 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    x19Var2.x(handlePortal.f());
                    x19Var2.t(handlePortal.b());
                    x19Var2.o(handlePortal.a());
                    x19Var2.w(handlePortal.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                x19Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                x19 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    x19Var2.x(selectPhotoAlbum.f());
                    x19Var2.t(selectPhotoAlbum.b());
                    x19Var2.o(selectPhotoAlbum.a());
                    x19Var2.w(selectPhotoAlbum.e());
                    if (!x19Var2.h()) {
                        x19Var2.n(false);
                        addObserver("selectPhotoAlbum", x19Var2, false);
                    }
                }
                x19Var2.y(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                x19Var2.r(true);
                x19 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (operateNotifyDataChanged != null) {
                    x19Var2.x(operateNotifyDataChanged.f());
                    x19Var2.t(operateNotifyDataChanged.b());
                    x19Var2.o(operateNotifyDataChanged.a());
                    x19Var2.w(operateNotifyDataChanged.e());
                    if (!x19Var2.h()) {
                        x19Var2.n(false);
                        addObserver("notifyNativeRefresh", x19Var2, false);
                    }
                }
                x19Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                x19Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                x19 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    x19Var2.x(selectPrivateMsg.f());
                    x19Var2.t(selectPrivateMsg.b());
                    x19Var2.o(selectPrivateMsg.a());
                    x19Var2.w(selectPrivateMsg.e());
                    if (!x19Var2.h()) {
                        i3 = 0;
                        x19Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", x19Var2, false);
                        x19Var2.y(i3);
                    }
                }
                i3 = 0;
                x19Var2.y(i3);
            } else if (b.equals("router/goToReportThreadPage")) {
                x19Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                x19 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    x19Var2.x(reportUserTheme.f());
                    x19Var2.t(reportUserTheme.b());
                    x19Var2.o(reportUserTheme.a());
                    x19Var2.w(reportUserTheme.e());
                    if (!x19Var2.h()) {
                        i2 = 0;
                        x19Var2.n(false);
                        addObserver("goToReportThreadPage", x19Var2, false);
                        x19Var2.y(i2);
                    }
                }
                i2 = 0;
                x19Var2.y(i2);
            } else if (b.equals("system/playSound")) {
                x19Var2.r(true);
                x19 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    x19Var2.x(playSound.f());
                    x19Var2.t(playSound.b());
                    x19Var2.o(playSound.a());
                    x19Var2.w(playSound.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                x19Var2.r(true);
                x19 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    x19Var2.x(playVibrate.f());
                    x19Var2.t(playVibrate.b());
                    x19Var2.o(playVibrate.a());
                    x19Var2.w(playVibrate.e());
                }
                x19Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                x19Var2.r(true);
                x19 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    x19Var2.x(jumpLoginActivity.f());
                    x19Var2.t(jumpLoginActivity.b());
                    x19Var2.o(jumpLoginActivity.a());
                    x19Var2.w(jumpLoginActivity.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                x19Var2.r(true);
                x19 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    x19Var2.x(startLoadTimeInterval.f());
                    x19Var2.t(startLoadTimeInterval.b());
                    x19Var2.o(startLoadTimeInterval.a());
                    x19Var2.w(startLoadTimeInterval.e());
                }
                x19Var2.y(0);
            } else if (b.equals("device/getZid")) {
                x19Var2.r(true);
                x19 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    x19Var2.x(zid.f());
                    x19Var2.t(zid.b());
                    x19Var2.o(zid.a());
                    x19Var2.w(zid.e());
                }
                x19Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                x19Var2.r(true);
                x19 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    x19Var2.x(hdid.f());
                    x19Var2.t(hdid.b());
                    x19Var2.o(hdid.a());
                    x19Var2.w(hdid.e());
                }
                x19Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                x19Var2.r(true);
                x19 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    x19Var2.x(shareInfo.f());
                    x19Var2.t(shareInfo.b());
                    x19Var2.o(shareInfo.a());
                    x19Var2.w(shareInfo.e());
                }
                x19Var2.y(0);
            } else if (b.equals("share/share")) {
                x19Var2.r(true);
                x19 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"));
                if (share != null) {
                    x19Var2.x(share.f());
                    x19Var2.t(share.b());
                    x19Var2.o(share.a());
                    x19Var2.w(share.e());
                }
                x19Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                x19Var2.r(true);
                x19 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    x19Var2.x(clipperInformation.f());
                    x19Var2.t(clipperInformation.b());
                    x19Var2.o(clipperInformation.a());
                    x19Var2.w(clipperInformation.e());
                }
                x19Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                x19Var2.r(true);
                x19 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    x19Var2.x(clipperInformation2.f());
                    x19Var2.t(clipperInformation2.b());
                    x19Var2.o(clipperInformation2.a());
                    x19Var2.w(clipperInformation2.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                x19Var2.r(true);
                x19 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    x19Var2.x(goToEditPost.f());
                    x19Var2.t(goToEditPost.b());
                    x19Var2.o(goToEditPost.a());
                    x19Var2.w(goToEditPost.e());
                }
                x19Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                x19Var2.r(true);
                x19 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    x19Var2.x(updateSearchForumInfo.f());
                    x19Var2.t(updateSearchForumInfo.b());
                    x19Var2.o(updateSearchForumInfo.a());
                    x19Var2.w(updateSearchForumInfo.e());
                }
                x19Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                x19Var2.r(true);
                x19 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    x19Var2.x(personlizedSwitchChange.f());
                    x19Var2.t(personlizedSwitchChange.b());
                    x19Var2.o(personlizedSwitchChange.a());
                    x19Var2.w(personlizedSwitchChange.e());
                }
                x19Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                x19Var2.r(true);
                x19 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    x19Var2.x(updateTailStyle.f());
                    x19Var2.t(updateTailStyle.b());
                    x19Var2.o(updateTailStyle.a());
                    x19Var2.w(updateTailStyle.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                x19Var2.r(true);
                x19 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    x19Var2.x(goToVideoImmersivePage.f());
                    x19Var2.t(goToVideoImmersivePage.b());
                    x19Var2.o(goToVideoImmersivePage.a());
                    x19Var2.w(goToVideoImmersivePage.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                x19Var2.r(true);
                x19 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    x19Var2.x(jumpToVideo.f());
                    x19Var2.t(jumpToVideo.b());
                    x19Var2.o(jumpToVideo.a());
                    x19Var2.w(jumpToVideo.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                x19Var2.r(true);
                x19 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    x19Var2.x(closeNativeMask.f());
                    x19Var2.t(closeNativeMask.b());
                    x19Var2.o(closeNativeMask.a());
                    x19Var2.w(closeNativeMask.e());
                }
                x19Var2.y(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                x19Var2.r(true);
                x19 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    x19Var2.x(oneKeyDeletion.f());
                    x19Var2.t(oneKeyDeletion.b());
                    x19Var2.o(oneKeyDeletion.a());
                    x19Var2.w(oneKeyDeletion.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                x19Var2.r(true);
                x19 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    x19Var2.x(checkAppInstall.f());
                    x19Var2.t(checkAppInstall.b());
                    x19Var2.o(checkAppInstall.a());
                    x19Var2.w(checkAppInstall.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                x19Var2.r(true);
                x19 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    x19Var2.x(disableBack.f());
                    x19Var2.t(disableBack.b());
                    x19Var2.o(disableBack.a());
                    x19Var2.w(disableBack.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/startApp")) {
                x19Var2.r(true);
                x19 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    x19Var2.x(startApp.f());
                    x19Var2.t(startApp.b());
                    x19Var2.o(startApp.a());
                    x19Var2.w(startApp.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                x19Var2.r(true);
                x19 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    x19Var2.x(hasNotificationPermission.f());
                    x19Var2.t(hasNotificationPermission.b());
                    x19Var2.o(hasNotificationPermission.a());
                    x19Var2.w(hasNotificationPermission.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                x19Var2.r(true);
                x19 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    x19Var2.x(goToNotificationSetting.f());
                    x19Var2.t(goToNotificationSetting.b());
                    x19Var2.o(goToNotificationSetting.a());
                    x19Var2.w(goToNotificationSetting.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                x19Var2.r(true);
                x19 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushManager.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString(a.v));
                if (startDownloadGameApk != null) {
                    x19Var2.x(startDownloadGameApk.f());
                    x19Var2.t(startDownloadGameApk.b());
                    x19Var2.o(startDownloadGameApk.a());
                    x19Var2.w(startDownloadGameApk.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                x19Var2.r(true);
                x19 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    x19Var2.x(checkInstallGameApk.f());
                    x19Var2.t(checkInstallGameApk.b());
                    x19Var2.o(checkInstallGameApk.a());
                    x19Var2.w(checkInstallGameApk.e());
                }
                x19Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                x19Var2.r(true);
                x19 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    x19Var2.x(startDownloadCss.f());
                    x19Var2.t(startDownloadCss.b());
                    x19Var2.o(startDownloadCss.a());
                    x19Var2.w(startDownloadCss.e());
                }
                x19Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                x19Var2.r(true);
                x19 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    x19Var2.x(disableGoBack.f());
                    x19Var2.t(disableGoBack.b());
                    x19Var2.o(disableGoBack.a());
                    x19Var2.w(disableGoBack.e());
                }
                x19Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                x19Var2.r(true);
                x19 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    x19Var2.x(supplementInfo.f());
                    x19Var2.t(supplementInfo.b());
                    x19Var2.o(supplementInfo.a());
                    x19Var2.w(supplementInfo.e());
                }
                x19Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                x19Var2.r(true);
                x19 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    x19Var2.x(deviceInfo.f());
                    x19Var2.t(deviceInfo.b());
                    x19Var2.o(deviceInfo.a());
                    x19Var2.w(deviceInfo.e());
                }
                x19Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                x19Var2.r(true);
                x19 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    x19Var2.x(sendCompleteTaskReqMsg.f());
                    x19Var2.t(sendCompleteTaskReqMsg.b());
                    x19Var2.o(sendCompleteTaskReqMsg.a());
                    x19Var2.w(sendCompleteTaskReqMsg.e());
                }
                x19Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                x19Var2.r(true);
                x19 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    x19Var2.x(showTipToast.f());
                    x19Var2.t(showTipToast.b());
                    x19Var2.o(showTipToast.a());
                    x19Var2.w(showTipToast.e());
                }
                x19Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                x19Var2.r(true);
                x19 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    x19Var2.x(getModalData.f());
                    x19Var2.t(getModalData.b());
                    x19Var2.o(getModalData.a());
                    x19Var2.w(getModalData.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                x19Var2.r(true);
                x19 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    x19Var2.x(openThirdPartApp.f());
                    x19Var2.t(openThirdPartApp.b());
                    x19Var2.o(openThirdPartApp.a());
                    x19Var2.w(openThirdPartApp.e());
                }
                x19Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                x19Var2.r(true);
                x19 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    x19Var2.x(jumpToHtmlPage.f());
                    x19Var2.t(jumpToHtmlPage.b());
                    x19Var2.o(jumpToHtmlPage.a());
                    x19Var2.w(jumpToHtmlPage.e());
                }
                x19Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                x19Var2.r(true);
                x19 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    x19Var2.x(offlineUserInfo.f());
                    x19Var2.t(offlineUserInfo.b());
                    x19Var2.o(offlineUserInfo.a());
                    x19Var2.w(offlineUserInfo.e());
                }
                x19Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                x19Var2.r(true);
                x19 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    x19Var2.x(deleteOfflineBundle.f());
                    x19Var2.t(deleteOfflineBundle.b());
                    x19Var2.o(deleteOfflineBundle.a());
                    x19Var2.w(deleteOfflineBundle.e());
                }
                x19Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                x19Var2.r(true);
                x19 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    x19Var2.x(updateOfflineBundle.f());
                    x19Var2.t(updateOfflineBundle.b());
                    x19Var2.o(updateOfflineBundle.a());
                    x19Var2.w(updateOfflineBundle.e());
                }
                x19Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                x19Var2.r(true);
                x19 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    x19Var2.x(switchOfflineInterface.f());
                    x19Var2.t(switchOfflineInterface.b());
                    x19Var2.o(switchOfflineInterface.a());
                    x19Var2.w(switchOfflineInterface.e());
                }
                x19Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                x19Var2.r(true);
                x19 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    x19Var2.x(switchOfflineBundleStatus.f());
                    x19Var2.t(switchOfflineBundleStatus.b());
                    x19Var2.o(switchOfflineBundleStatus.a());
                    x19Var2.w(switchOfflineBundleStatus.e());
                }
                x19Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                x19Var2.r(true);
                x19 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    x19Var2.x(finishTestAnswer.f());
                    x19Var2.t(finishTestAnswer.b());
                    x19Var2.o(finishTestAnswer.a());
                    x19Var2.w(finishTestAnswer.e());
                }
                x19Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                x19Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                x19 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    x19Var2.x(switchUrlHost.f());
                    x19Var2.t(switchUrlHost.b());
                    x19Var2.o(switchUrlHost.a());
                    x19Var2.w(switchUrlHost.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                x19Var2.r(true);
                x19 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    x19Var2.x(appStorage.f());
                    x19Var2.t(appStorage.b());
                    x19Var2.o(appStorage.a());
                    x19Var2.w(appStorage.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                x19Var2.r(true);
                x19 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    x19Var2.x(putAppStorage.f());
                    x19Var2.t(putAppStorage.b());
                    x19Var2.o(putAppStorage.a());
                    x19Var2.w(putAppStorage.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                x19Var2.r(true);
                x19 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    x19Var2.x(historyForumData.f());
                    x19Var2.t(historyForumData.b());
                    x19Var2.o(historyForumData.a());
                    x19Var2.w(historyForumData.e());
                }
                x19Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                x19Var2.r(true);
                x19 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    x19Var2.x(worldCupRaiseSuccess.f());
                    x19Var2.t(worldCupRaiseSuccess.b());
                    x19Var2.o(worldCupRaiseSuccess.a());
                    x19Var2.w(worldCupRaiseSuccess.e());
                }
                x19Var2.y(0);
            } else if (b.equals("account/getAlipayUserId")) {
                x19Var2.r(true);
                x19 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    x19Var2.x(alipayUserId.f());
                    x19Var2.t(alipayUserId.b());
                    x19Var2.o(alipayUserId.a());
                    x19Var2.w(alipayUserId.e());
                    if (!x19Var2.h()) {
                        i = 0;
                        x19Var2.n(false);
                        addObserver("aliAuthResult", x19Var2, false);
                        x19Var2.y(i);
                    }
                }
                i = 0;
                x19Var2.y(i);
            } else if (b.equals("system/getFileDownloadStatus")) {
                x19Var2.r(true);
                x19 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString(a.v));
                if (fileDownloadStatus != null) {
                    x19Var2.x(fileDownloadStatus.f());
                    x19Var2.t(fileDownloadStatus.b());
                    x19Var2.o(fileDownloadStatus.a());
                    x19Var2.w(fileDownloadStatus.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                x19Var2.r(true);
                x19 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString(a.v));
                if (fileDownloadProgress != null) {
                    x19Var2.x(fileDownloadProgress.f());
                    x19Var2.t(fileDownloadProgress.b());
                    x19Var2.o(fileDownloadProgress.a());
                    x19Var2.w(fileDownloadProgress.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/fileDownloadPause")) {
                x19Var2.r(true);
                x19 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString(a.v));
                if (fileDownloadPause != null) {
                    x19Var2.x(fileDownloadPause.f());
                    x19Var2.t(fileDownloadPause.b());
                    x19Var2.o(fileDownloadPause.a());
                    x19Var2.w(fileDownloadPause.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                x19Var2.r(true);
                x19 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString(a.v));
                if (fileDownloadDelete != null) {
                    x19Var2.x(fileDownloadDelete.f());
                    x19Var2.t(fileDownloadDelete.b());
                    x19Var2.o(fileDownloadDelete.a());
                    x19Var2.w(fileDownloadDelete.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/installGameApk")) {
                x19Var2.r(true);
                x19 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString(a.v));
                if (installGameApk != null) {
                    x19Var2.x(installGameApk.f());
                    x19Var2.t(installGameApk.b());
                    x19Var2.o(installGameApk.a());
                    x19Var2.w(installGameApk.e());
                }
                x19Var2.y(0);
            } else if (b.equals("system/launchApk")) {
                x19Var2.r(true);
                x19 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString(a.v));
                if (launchApk != null) {
                    x19Var2.x(launchApk.f());
                    x19Var2.t(launchApk.b());
                    x19Var2.o(launchApk.a());
                    x19Var2.w(launchApk.e());
                }
                x19Var2.y(0);
            }
            return x19Var2;
        }
        return (x19) invokeLL.objValue;
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

    @Override // com.baidu.tieba.v19
    public List<x19> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            x19 x19Var = null;
            if (dj.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                x19Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                x19Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                x19Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                x19Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                x19Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                x19Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                x19Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                x19Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                x19Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                x19Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                x19Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                x19Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                x19Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                x19Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                x19Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                x19Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                x19Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                x19Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                x19Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                x19Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("aliAuthResult")) {
                x19Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                x19Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                x19Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            }
            if (x19Var != null) {
                x19Var.y(0);
            }
            List<w19> list = this.mAsyncCallBackMethodList.get(str);
            if (x19Var != null && list != null) {
                Iterator<w19> it = list.iterator();
                if (!dj.isEmpty(x19Var.e())) {
                    while (it.hasNext()) {
                        w19 next = it.next();
                        if (next.b().equals(x19Var.e())) {
                            x19 x19Var2 = new x19();
                            x19Var2.v(next.a());
                            x19Var2.x(x19Var.f());
                            x19Var2.t(x19Var.b());
                            x19Var2.o(x19Var.a());
                            x19Var2.z(x19Var.l());
                            arrayList.add(x19Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        w19 next2 = it.next();
                        x19 x19Var3 = new x19();
                        x19Var3.v(next2.a());
                        x19Var3.x(x19Var.f());
                        x19Var3.t(x19Var.b());
                        x19Var3.o(x19Var.a());
                        x19Var3.z(x19Var.l());
                        arrayList.add(x19Var3);
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
