package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ad;
import com.baidu.tieba.gfa;
import com.baidu.tieba.hfa;
import com.baidu.tieba.ifa;
import com.baidu.tieba.kfa;
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public class QuickWebViewBridge_Proxy extends gfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.gfa
    public ifa dispatch(kfa kfaVar, ifa ifaVar) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kfaVar, ifaVar)) == null) {
            ifa ifaVar2 = ifaVar == null ? new ifa() : ifaVar;
            String b = kfaVar.b();
            JSONObject e = kfaVar.e();
            if (b.equals("account/startLoginModule")) {
                ifaVar2.s(true);
                ifa startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    ifaVar2.y(startLoginModule.f());
                    ifaVar2.u(startLoginModule.b());
                    ifaVar2.o(startLoginModule.a());
                    ifaVar2.x(startLoginModule.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("account/authState")) {
                ifaVar2.s(true);
                ifa checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    ifaVar2.y(checkAuthState.f());
                    ifaVar2.u(checkAuthState.b());
                    ifaVar2.o(checkAuthState.a());
                    ifaVar2.x(checkAuthState.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                ifaVar2.s(true);
                ifa startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    ifaVar2.y(startAllLoginModule.f());
                    ifaVar2.u(startAllLoginModule.b());
                    ifaVar2.o(startAllLoginModule.a());
                    ifaVar2.x(startAllLoginModule.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver("commonLogin", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                ifaVar2.s(true);
                ifa realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    ifaVar2.y(realNameAuth.f());
                    ifaVar2.u(realNameAuth.b());
                    ifaVar2.o(realNameAuth.a());
                    ifaVar2.x(realNameAuth.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver("realNameAuthResult", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                ifaVar2.s(true);
                ifa finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    ifaVar2.y(finishPage.f());
                    ifaVar2.u(finishPage.b());
                    ifaVar2.o(finishPage.a());
                    ifaVar2.x(finishPage.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                ifaVar2.s(true);
                ifa showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    ifaVar2.y(showLowerHairHint.f());
                    ifaVar2.u(showLowerHairHint.b());
                    ifaVar2.o(showLowerHairHint.a());
                    ifaVar2.x(showLowerHairHint.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                ifaVar2.s(true);
                ifa gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    ifaVar2.y(gamePush.f());
                    ifaVar2.u(gamePush.b());
                    ifaVar2.o(gamePush.a());
                    ifaVar2.x(gamePush.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                ifaVar2.s(true);
                ifa handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    ifaVar2.y(handleGamePushStatus.f());
                    ifaVar2.u(handleGamePushStatus.b());
                    ifaVar2.o(handleGamePushStatus.a());
                    ifaVar2.x(handleGamePushStatus.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                ifaVar2.s(true);
                ifa jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    ifaVar2.y(jumpForumRulesEditPage.f());
                    ifaVar2.u(jumpForumRulesEditPage.b());
                    ifaVar2.o(jumpForumRulesEditPage.a());
                    ifaVar2.x(jumpForumRulesEditPage.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                ifaVar2.s(true);
                ifa handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    ifaVar2.y(handleGoToBarDetail.f());
                    ifaVar2.u(handleGoToBarDetail.b());
                    ifaVar2.o(handleGoToBarDetail.a());
                    ifaVar2.x(handleGoToBarDetail.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                ifaVar2.s(true);
                ifa handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    ifaVar2.y(handleSaveImage.f());
                    ifaVar2.u(handleSaveImage.b());
                    ifaVar2.o(handleSaveImage.a());
                    ifaVar2.x(handleSaveImage.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver("saveImageSuccess", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                ifaVar2.s(true);
                ifa orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    ifaVar2.y(orderGameApk.f());
                    ifaVar2.u(orderGameApk.b());
                    ifaVar2.o(orderGameApk.a());
                    ifaVar2.x(orderGameApk.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver("orderGameApkResult", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                ifaVar2.s(true);
                ifa handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    ifaVar2.y(handleGetPhotoAlbum.f());
                    ifaVar2.u(handleGetPhotoAlbum.b());
                    ifaVar2.o(handleGetPhotoAlbum.a());
                    ifaVar2.x(handleGetPhotoAlbum.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver("GetPhotoAlbum", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                ifaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                ifa preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    ifaVar2.y(preheatWeb.f());
                    ifaVar2.u(preheatWeb.b());
                    ifaVar2.o(preheatWeb.a());
                    ifaVar2.x(preheatWeb.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                ifaVar2.s(true);
                ifa openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    ifaVar2.y(openMXDYab.f());
                    ifaVar2.u(openMXDYab.b());
                    ifaVar2.o(openMXDYab.a());
                    ifaVar2.x(openMXDYab.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/portal")) {
                ifaVar2.s(true);
                ifa handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (handlePortal != null) {
                    ifaVar2.y(handlePortal.f());
                    ifaVar2.u(handlePortal.b());
                    ifaVar2.o(handlePortal.a());
                    ifaVar2.x(handlePortal.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                ifaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                ifa selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    ifaVar2.y(selectPhotoAlbum.f());
                    ifaVar2.u(selectPhotoAlbum.b());
                    ifaVar2.o(selectPhotoAlbum.a());
                    ifaVar2.x(selectPhotoAlbum.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver("selectPhotoAlbum", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                ifaVar2.s(true);
                ifa operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    ifaVar2.y(operateNotifyDataChanged.f());
                    ifaVar2.u(operateNotifyDataChanged.b());
                    ifaVar2.o(operateNotifyDataChanged.a());
                    ifaVar2.x(operateNotifyDataChanged.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                ifaVar2.s(true);
                ifa viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    ifaVar2.y(viewPosition.f());
                    ifaVar2.u(viewPosition.b());
                    ifaVar2.o(viewPosition.a());
                    ifaVar2.x(viewPosition.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                ifaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                ifa selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    ifaVar2.y(selectPrivateMsg.f());
                    ifaVar2.u(selectPrivateMsg.b());
                    ifaVar2.o(selectPrivateMsg.a());
                    ifaVar2.x(selectPrivateMsg.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                ifaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                ifa reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    ifaVar2.y(reportUserTheme.f());
                    ifaVar2.u(reportUserTheme.b());
                    ifaVar2.o(reportUserTheme.a());
                    ifaVar2.x(reportUserTheme.e());
                    if (!ifaVar2.h()) {
                        ifaVar2.n(false);
                        addObserver("goToReportThreadPage", ifaVar2, false);
                    }
                }
                ifaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                ifaVar2.s(true);
                ifa playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    ifaVar2.y(playSound.f());
                    ifaVar2.u(playSound.b());
                    ifaVar2.o(playSound.a());
                    ifaVar2.x(playSound.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                ifaVar2.s(true);
                ifa playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    ifaVar2.y(playVibrate.f());
                    ifaVar2.u(playVibrate.b());
                    ifaVar2.o(playVibrate.a());
                    ifaVar2.x(playVibrate.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                ifaVar2.s(true);
                ifa localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    ifaVar2.y(localYaLog.f());
                    ifaVar2.u(localYaLog.b());
                    ifaVar2.o(localYaLog.a());
                    ifaVar2.x(localYaLog.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                ifaVar2.s(true);
                ifa jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    ifaVar2.y(jumpLoginActivity.f());
                    ifaVar2.u(jumpLoginActivity.b());
                    ifaVar2.o(jumpLoginActivity.a());
                    ifaVar2.x(jumpLoginActivity.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                ifaVar2.s(true);
                ifa startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    ifaVar2.y(startLoadTimeInterval.f());
                    ifaVar2.u(startLoadTimeInterval.b());
                    ifaVar2.o(startLoadTimeInterval.a());
                    ifaVar2.x(startLoadTimeInterval.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                ifaVar2.s(true);
                ifa zid = this.mJsBridge.getZid();
                if (zid != null) {
                    ifaVar2.y(zid.f());
                    ifaVar2.u(zid.b());
                    ifaVar2.o(zid.a());
                    ifaVar2.x(zid.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                ifaVar2.s(true);
                ifa hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    ifaVar2.y(hdid.f());
                    ifaVar2.u(hdid.b());
                    ifaVar2.o(hdid.a());
                    ifaVar2.x(hdid.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                ifaVar2.s(true);
                ifa shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    ifaVar2.y(shareInfo.f());
                    ifaVar2.u(shareInfo.b());
                    ifaVar2.o(shareInfo.a());
                    ifaVar2.x(shareInfo.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("share/share")) {
                ifaVar2.s(true);
                ifa share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    ifaVar2.y(share.f());
                    ifaVar2.u(share.b());
                    ifaVar2.o(share.a());
                    ifaVar2.x(share.e());
                    if (!ifaVar2.h()) {
                        i12 = 0;
                        ifaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, ifaVar2, false);
                        ifaVar2.z(i12);
                    }
                }
                i12 = 0;
                ifaVar2.z(i12);
            } else if (b.equals("clipper/getClipperInformation")) {
                ifaVar2.s(true);
                ifa clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    ifaVar2.y(clipperInformation.f());
                    ifaVar2.u(clipperInformation.b());
                    ifaVar2.o(clipperInformation.a());
                    ifaVar2.x(clipperInformation.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                ifaVar2.s(true);
                ifa clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    ifaVar2.y(clipperInformation2.f());
                    ifaVar2.u(clipperInformation2.b());
                    ifaVar2.o(clipperInformation2.a());
                    ifaVar2.x(clipperInformation2.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                ifaVar2.s(true);
                ifa goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    ifaVar2.y(goToEditPost.f());
                    ifaVar2.u(goToEditPost.b());
                    ifaVar2.o(goToEditPost.a());
                    ifaVar2.x(goToEditPost.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                ifaVar2.s(true);
                ifa updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    ifaVar2.y(updateSearchForumInfo.f());
                    ifaVar2.u(updateSearchForumInfo.b());
                    ifaVar2.o(updateSearchForumInfo.a());
                    ifaVar2.x(updateSearchForumInfo.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                ifaVar2.s(true);
                ifa personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    ifaVar2.y(personlizedSwitchChange.f());
                    ifaVar2.u(personlizedSwitchChange.b());
                    ifaVar2.o(personlizedSwitchChange.a());
                    ifaVar2.x(personlizedSwitchChange.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                ifaVar2.s(true);
                ifa updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    ifaVar2.y(updateTailStyle.f());
                    ifaVar2.u(updateTailStyle.b());
                    ifaVar2.o(updateTailStyle.a());
                    ifaVar2.x(updateTailStyle.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                ifaVar2.s(true);
                ifa goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    ifaVar2.y(goToVideoImmersivePage.f());
                    ifaVar2.u(goToVideoImmersivePage.b());
                    ifaVar2.o(goToVideoImmersivePage.a());
                    ifaVar2.x(goToVideoImmersivePage.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                ifaVar2.s(true);
                ifa jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    ifaVar2.y(jumpToVideo.f());
                    ifaVar2.u(jumpToVideo.b());
                    ifaVar2.o(jumpToVideo.a());
                    ifaVar2.x(jumpToVideo.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                ifaVar2.s(true);
                ifa closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    ifaVar2.y(closeNativeMask.f());
                    ifaVar2.u(closeNativeMask.b());
                    ifaVar2.o(closeNativeMask.a());
                    ifaVar2.x(closeNativeMask.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                ifaVar2.s(true);
                ifa oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    ifaVar2.y(oneKeyDeletion.f());
                    ifaVar2.u(oneKeyDeletion.b());
                    ifaVar2.o(oneKeyDeletion.a());
                    ifaVar2.x(oneKeyDeletion.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                ifaVar2.s(true);
                ifa checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    ifaVar2.y(checkAppInstall.f());
                    ifaVar2.u(checkAppInstall.b());
                    ifaVar2.o(checkAppInstall.a());
                    ifaVar2.x(checkAppInstall.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                ifaVar2.s(true);
                ifa disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    ifaVar2.y(disableBack.f());
                    ifaVar2.u(disableBack.b());
                    ifaVar2.o(disableBack.a());
                    ifaVar2.x(disableBack.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                ifaVar2.s(true);
                ifa startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    ifaVar2.y(startApp.f());
                    ifaVar2.u(startApp.b());
                    ifaVar2.o(startApp.a());
                    ifaVar2.x(startApp.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                ifaVar2.s(true);
                ifa hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    ifaVar2.y(hasNotificationPermission.f());
                    ifaVar2.u(hasNotificationPermission.b());
                    ifaVar2.o(hasNotificationPermission.a());
                    ifaVar2.x(hasNotificationPermission.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                ifaVar2.s(true);
                ifa goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    ifaVar2.y(goToNotificationSetting.f());
                    ifaVar2.u(goToNotificationSetting.b());
                    ifaVar2.o(goToNotificationSetting.a());
                    ifaVar2.x(goToNotificationSetting.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                ifaVar2.s(true);
                ifa startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    ifaVar2.y(startDownloadGameApk.f());
                    ifaVar2.u(startDownloadGameApk.b());
                    ifaVar2.o(startDownloadGameApk.a());
                    ifaVar2.x(startDownloadGameApk.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                ifaVar2.s(true);
                ifa checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    ifaVar2.y(checkInstallGameApk.f());
                    ifaVar2.u(checkInstallGameApk.b());
                    ifaVar2.o(checkInstallGameApk.a());
                    ifaVar2.x(checkInstallGameApk.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                ifaVar2.s(true);
                ifa startDownloadCss = this.mJsBridge.startDownloadCss(e.optString("downloadUrl"));
                if (startDownloadCss != null) {
                    ifaVar2.y(startDownloadCss.f());
                    ifaVar2.u(startDownloadCss.b());
                    ifaVar2.o(startDownloadCss.a());
                    ifaVar2.x(startDownloadCss.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                ifaVar2.s(true);
                ifa disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    ifaVar2.y(disableGoBack.f());
                    ifaVar2.u(disableGoBack.b());
                    ifaVar2.o(disableGoBack.a());
                    ifaVar2.x(disableGoBack.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                ifaVar2.s(true);
                ifa supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    ifaVar2.y(supplementInfo.f());
                    ifaVar2.u(supplementInfo.b());
                    ifaVar2.o(supplementInfo.a());
                    ifaVar2.x(supplementInfo.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                ifaVar2.s(true);
                ifa deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    ifaVar2.y(deviceGyroscopeParams.f());
                    ifaVar2.u(deviceGyroscopeParams.b());
                    ifaVar2.o(deviceGyroscopeParams.a());
                    ifaVar2.x(deviceGyroscopeParams.e());
                    if (!ifaVar2.h()) {
                        i11 = 0;
                        ifaVar2.n(false);
                        addObserver("deviceMotion", ifaVar2, false);
                        ifaVar2.z(i11);
                    }
                }
                i11 = 0;
                ifaVar2.z(i11);
            } else if (b.equals("device/deviceRefreshRate")) {
                ifaVar2.s(true);
                ifa deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    ifaVar2.y(deviceRefreshRateParams.f());
                    ifaVar2.u(deviceRefreshRateParams.b());
                    ifaVar2.o(deviceRefreshRateParams.a());
                    ifaVar2.x(deviceRefreshRateParams.e());
                    if (!ifaVar2.h()) {
                        i10 = 0;
                        ifaVar2.n(false);
                        addObserver("deviceRefreshRate", ifaVar2, false);
                        ifaVar2.z(i10);
                    }
                }
                i10 = 0;
                ifaVar2.z(i10);
            } else if (b.equals("device/getDeviceInfo")) {
                ifaVar2.s(true);
                ifa deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    ifaVar2.y(deviceInfo.f());
                    ifaVar2.u(deviceInfo.b());
                    ifaVar2.o(deviceInfo.a());
                    ifaVar2.x(deviceInfo.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                ifaVar2.s(true);
                ifa sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    ifaVar2.y(sendCompleteTaskReqMsg.f());
                    ifaVar2.u(sendCompleteTaskReqMsg.b());
                    ifaVar2.o(sendCompleteTaskReqMsg.a());
                    ifaVar2.x(sendCompleteTaskReqMsg.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                ifaVar2.s(true);
                ifa showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    ifaVar2.y(showTipToast.f());
                    ifaVar2.u(showTipToast.b());
                    ifaVar2.o(showTipToast.a());
                    ifaVar2.x(showTipToast.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                ifaVar2.s(true);
                ifa getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    ifaVar2.y(getModalData.f());
                    ifaVar2.u(getModalData.b());
                    ifaVar2.o(getModalData.a());
                    ifaVar2.x(getModalData.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                ifaVar2.s(true);
                ifa openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    ifaVar2.y(openThirdPartApp.f());
                    ifaVar2.u(openThirdPartApp.b());
                    ifaVar2.o(openThirdPartApp.a());
                    ifaVar2.x(openThirdPartApp.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                ifaVar2.s(true);
                ifa jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    ifaVar2.y(jumpToHtmlPage.f());
                    ifaVar2.u(jumpToHtmlPage.b());
                    ifaVar2.o(jumpToHtmlPage.a());
                    ifaVar2.x(jumpToHtmlPage.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                ifaVar2.s(true);
                ifa offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    ifaVar2.y(offlineUserInfo.f());
                    ifaVar2.u(offlineUserInfo.b());
                    ifaVar2.o(offlineUserInfo.a());
                    ifaVar2.x(offlineUserInfo.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                ifaVar2.s(true);
                ifa deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    ifaVar2.y(deleteOfflineBundle.f());
                    ifaVar2.u(deleteOfflineBundle.b());
                    ifaVar2.o(deleteOfflineBundle.a());
                    ifaVar2.x(deleteOfflineBundle.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                ifaVar2.s(true);
                ifa updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    ifaVar2.y(updateOfflineBundle.f());
                    ifaVar2.u(updateOfflineBundle.b());
                    ifaVar2.o(updateOfflineBundle.a());
                    ifaVar2.x(updateOfflineBundle.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                ifaVar2.s(true);
                ifa switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    ifaVar2.y(switchOfflineInterface.f());
                    ifaVar2.u(switchOfflineInterface.b());
                    ifaVar2.o(switchOfflineInterface.a());
                    ifaVar2.x(switchOfflineInterface.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                ifaVar2.s(true);
                ifa switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    ifaVar2.y(switchOfflineBundleStatus.f());
                    ifaVar2.u(switchOfflineBundleStatus.b());
                    ifaVar2.o(switchOfflineBundleStatus.a());
                    ifaVar2.x(switchOfflineBundleStatus.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                ifaVar2.s(true);
                ifa finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    ifaVar2.y(finishTestAnswer.f());
                    ifaVar2.u(finishTestAnswer.b());
                    ifaVar2.o(finishTestAnswer.a());
                    ifaVar2.x(finishTestAnswer.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                ifaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                ifa switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    ifaVar2.y(switchUrlHost.f());
                    ifaVar2.u(switchUrlHost.b());
                    ifaVar2.o(switchUrlHost.a());
                    ifaVar2.x(switchUrlHost.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                ifaVar2.s(true);
                ifa appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    ifaVar2.y(appStorage.f());
                    ifaVar2.u(appStorage.b());
                    ifaVar2.o(appStorage.a());
                    ifaVar2.x(appStorage.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                ifaVar2.s(true);
                ifa putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    ifaVar2.y(putAppStorage.f());
                    ifaVar2.u(putAppStorage.b());
                    ifaVar2.o(putAppStorage.a());
                    ifaVar2.x(putAppStorage.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                ifaVar2.s(true);
                ifa historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    ifaVar2.y(historyForumData.f());
                    ifaVar2.u(historyForumData.b());
                    ifaVar2.o(historyForumData.a());
                    ifaVar2.x(historyForumData.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                ifaVar2.s(true);
                ifa worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    ifaVar2.y(worldCupRaiseSuccess.f());
                    ifaVar2.u(worldCupRaiseSuccess.b());
                    ifaVar2.o(worldCupRaiseSuccess.a());
                    ifaVar2.x(worldCupRaiseSuccess.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                ifaVar2.s(true);
                ifa alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    ifaVar2.y(alipayUserId.f());
                    ifaVar2.u(alipayUserId.b());
                    ifaVar2.o(alipayUserId.a());
                    ifaVar2.x(alipayUserId.e());
                    if (!ifaVar2.h()) {
                        i9 = 0;
                        ifaVar2.n(false);
                        addObserver("aliAuthResult", ifaVar2, false);
                        ifaVar2.z(i9);
                    }
                }
                i9 = 0;
                ifaVar2.z(i9);
            } else if (b.equals("system/getFileDownloadStatus")) {
                ifaVar2.s(true);
                ifa fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    ifaVar2.y(fileDownloadStatus.f());
                    ifaVar2.u(fileDownloadStatus.b());
                    ifaVar2.o(fileDownloadStatus.a());
                    ifaVar2.x(fileDownloadStatus.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                ifaVar2.s(true);
                ifa fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    ifaVar2.y(fileDownloadProgress.f());
                    ifaVar2.u(fileDownloadProgress.b());
                    ifaVar2.o(fileDownloadProgress.a());
                    ifaVar2.x(fileDownloadProgress.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                ifaVar2.s(true);
                ifa fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    ifaVar2.y(fileDownloadPause.f());
                    ifaVar2.u(fileDownloadPause.b());
                    ifaVar2.o(fileDownloadPause.a());
                    ifaVar2.x(fileDownloadPause.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                ifaVar2.s(true);
                ifa fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    ifaVar2.y(fileDownloadDelete.f());
                    ifaVar2.u(fileDownloadDelete.b());
                    ifaVar2.o(fileDownloadDelete.a());
                    ifaVar2.x(fileDownloadDelete.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                ifaVar2.s(true);
                ifa installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    ifaVar2.y(installGameApk.f());
                    ifaVar2.u(installGameApk.b());
                    ifaVar2.o(installGameApk.a());
                    ifaVar2.x(installGameApk.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                ifaVar2.s(true);
                ifa launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    ifaVar2.y(launchApk.f());
                    ifaVar2.u(launchApk.b());
                    ifaVar2.o(launchApk.a());
                    ifaVar2.x(launchApk.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                ifaVar2.s(true);
                ifa wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    ifaVar2.y(wakeKeyboard.f());
                    ifaVar2.u(wakeKeyboard.b());
                    ifaVar2.o(wakeKeyboard.a());
                    ifaVar2.x(wakeKeyboard.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                ifaVar2.s(true);
                ifa replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    ifaVar2.y(replyPost.f());
                    ifaVar2.u(replyPost.b());
                    ifaVar2.o(replyPost.a());
                    ifaVar2.x(replyPost.e());
                    if (!ifaVar2.h()) {
                        i8 = 0;
                        ifaVar2.n(false);
                        addObserver("replyPostResult", ifaVar2, false);
                        ifaVar2.z(i8);
                    }
                }
                i8 = 0;
                ifaVar2.z(i8);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                ifaVar2.s(true);
                ifa nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    ifaVar2.y(nativeNetworkProxy.f());
                    ifaVar2.u(nativeNetworkProxy.b());
                    ifaVar2.o(nativeNetworkProxy.a());
                    ifaVar2.x(nativeNetworkProxy.e());
                    if (!ifaVar2.h()) {
                        i7 = 0;
                        ifaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", ifaVar2, false);
                        ifaVar2.z(i7);
                    }
                }
                i7 = 0;
                ifaVar2.z(i7);
            } else if (b.equals("host/sendMsg")) {
                ifaVar2.s(true);
                ifa sendMessage = this.mJsBridge.sendMessage(e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (sendMessage != null) {
                    ifaVar2.y(sendMessage.f());
                    ifaVar2.u(sendMessage.b());
                    ifaVar2.o(sendMessage.a());
                    ifaVar2.x(sendMessage.e());
                    if (!ifaVar2.h()) {
                        i6 = 0;
                        ifaVar2.n(false);
                        addObserver("sendMsg", ifaVar2, false);
                        ifaVar2.z(i6);
                    }
                }
                i6 = 0;
                ifaVar2.z(i6);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                ifaVar2.s(true);
                ifa fetchHistoryMsgs = this.mJsBridge.fetchHistoryMsgs(e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (fetchHistoryMsgs != null) {
                    ifaVar2.y(fetchHistoryMsgs.f());
                    ifaVar2.u(fetchHistoryMsgs.b());
                    ifaVar2.o(fetchHistoryMsgs.a());
                    ifaVar2.x(fetchHistoryMsgs.e());
                    if (!ifaVar2.h()) {
                        i5 = 0;
                        ifaVar2.n(false);
                        addObserver("fetchHistoryMsgs", ifaVar2, false);
                        ifaVar2.z(i5);
                    }
                }
                i5 = 0;
                ifaVar2.z(i5);
            } else if (b.equals("host/receiveNewMsgs")) {
                ifaVar2.s(true);
                ifa receiveNewMsgs = this.mJsBridge.receiveNewMsgs();
                this.mNotificationNameList.add("receiveNewMsgs");
                if (receiveNewMsgs != null) {
                    ifaVar2.y(receiveNewMsgs.f());
                    ifaVar2.u(receiveNewMsgs.b());
                    ifaVar2.o(receiveNewMsgs.a());
                    ifaVar2.x(receiveNewMsgs.e());
                    if (!ifaVar2.h()) {
                        i4 = 0;
                        ifaVar2.n(false);
                        addObserver("receiveNewMsgs", ifaVar2, false);
                        ifaVar2.z(i4);
                    }
                }
                i4 = 0;
                ifaVar2.z(i4);
            } else if (b.equals("system/keyboardHeightChange")) {
                ifaVar2.s(true);
                ifa keyboardHeightChange = this.mJsBridge.keyboardHeightChange();
                this.mNotificationNameList.add("keyboardHeightChange");
                if (keyboardHeightChange != null) {
                    ifaVar2.y(keyboardHeightChange.f());
                    ifaVar2.u(keyboardHeightChange.b());
                    ifaVar2.o(keyboardHeightChange.a());
                    ifaVar2.x(keyboardHeightChange.e());
                    if (!ifaVar2.h()) {
                        i3 = 0;
                        ifaVar2.n(false);
                        addObserver("keyboardHeightChange", ifaVar2, false);
                        ifaVar2.z(i3);
                    }
                }
                i3 = 0;
                ifaVar2.z(i3);
            } else if (b.equals("host/preloadPic")) {
                ifaVar2.s(true);
                ArrayList<String> arrayList6 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList6, e.optJSONArray("url"));
                ifa perloadPicModule = this.mJsBridge.perloadPicModule(arrayList6);
                if (perloadPicModule != null) {
                    ifaVar2.y(perloadPicModule.f());
                    ifaVar2.u(perloadPicModule.b());
                    ifaVar2.o(perloadPicModule.a());
                    ifaVar2.x(perloadPicModule.e());
                }
                ifaVar2.z(0);
            } else if (b.equals("toast/showDialog")) {
                ifaVar2.s(true);
                ifa showDialog = this.mJsBridge.showDialog(e.optInt("type"), e.optString("content"), e.optString("dialogId"));
                this.mNotificationNameList.add("showDialog");
                if (showDialog != null) {
                    ifaVar2.y(showDialog.f());
                    ifaVar2.u(showDialog.b());
                    ifaVar2.o(showDialog.a());
                    ifaVar2.x(showDialog.e());
                    if (!ifaVar2.h()) {
                        i2 = 0;
                        ifaVar2.n(false);
                        addObserver("showDialog", ifaVar2, false);
                        ifaVar2.z(i2);
                    }
                }
                i2 = 0;
                ifaVar2.z(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                ifaVar2.s(true);
                ifa requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    ifaVar2.y(requestByNative.f());
                    ifaVar2.u(requestByNative.b());
                    ifaVar2.o(requestByNative.a());
                    ifaVar2.x(requestByNative.e());
                    if (!ifaVar2.h()) {
                        i = 0;
                        ifaVar2.n(false);
                        addObserver("RequestByNativeToH5", ifaVar2, false);
                        ifaVar2.z(i);
                    }
                }
                i = 0;
                ifaVar2.z(i);
            }
            return ifaVar2;
        }
        return (ifa) invokeLL.objValue;
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
        hashSet.add("commonLogin");
        this.mNotificationNameList.add("realNameAuthResult");
        this.mNotificationNameList.add("saveImageSuccess");
        this.mNotificationNameList.add("orderGameApkResult");
        this.mNotificationNameList.add("GetPhotoAlbum");
        this.mNotificationNameList.add("tbPayResult");
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
        this.mNotificationNameList.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT);
        this.mNotificationNameList.add(CommonTbJsBridge.INSTALL_APK_RESULT);
        this.mNotificationNameList.add("replyPostResult");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
        this.mNotificationNameList.add("sendMsg");
        this.mNotificationNameList.add("handleAudioMsgByTTS");
        this.mNotificationNameList.add("fetchHistoryMsgs");
        this.mNotificationNameList.add("receiveNewMsgs");
        this.mNotificationNameList.add("keyboardHeightChange");
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.gfa
    public List<ifa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            ifa ifaVar = null;
            if (ad.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                ifaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                ifaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                ifaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                ifaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                ifaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                ifaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                ifaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                ifaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                ifaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                ifaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                ifaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                ifaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                ifaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                ifaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                ifaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                ifaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                ifaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                ifaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                ifaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                ifaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                ifaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                ifaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                ifaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                ifaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                ifaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                ifaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                ifaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                ifaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                ifaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                ifaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("sendMsg")) {
                ifaVar = this.mJsBridge.onSendMsgResult(hashMap);
            } else if (str.equals("handleAudioMsgByTTS")) {
                ifaVar = this.mJsBridge.handleVoiceMsgResult(hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                ifaVar = this.mJsBridge.onFetchHistoryMsgsResult(hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                ifaVar = this.mJsBridge.onReceiveNewMsgsResult(hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                ifaVar = this.mJsBridge.onKeyboardHeightChange(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                ifaVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (ifaVar != null) {
                ifaVar.z(0);
            }
            List<hfa> list = this.mAsyncCallBackMethodList.get(str);
            if (ifaVar != null && list != null) {
                Iterator<hfa> it = list.iterator();
                if (!ad.isEmpty(ifaVar.e())) {
                    while (it.hasNext()) {
                        hfa next = it.next();
                        if (next.b().equals(ifaVar.e())) {
                            ifa ifaVar2 = new ifa();
                            ifaVar2.w(next.a());
                            ifaVar2.y(ifaVar.f());
                            ifaVar2.u(ifaVar.b());
                            ifaVar2.o(ifaVar.a());
                            ifaVar2.A(ifaVar.l());
                            arrayList.add(ifaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        hfa next2 = it.next();
                        ifa ifaVar3 = new ifa();
                        ifaVar3.w(next2.a());
                        ifaVar3.y(ifaVar.f());
                        ifaVar3.u(ifaVar.b());
                        ifaVar3.o(ifaVar.a());
                        ifaVar3.A(ifaVar.l());
                        arrayList.add(ifaVar3);
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
