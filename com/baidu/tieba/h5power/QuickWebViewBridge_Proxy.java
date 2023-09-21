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
import com.baidu.tieba.di;
import com.baidu.tieba.qka;
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
import com.baidu.tieba.rka;
import com.baidu.tieba.ska;
import com.baidu.tieba.uka;
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
/* loaded from: classes6.dex */
public class QuickWebViewBridge_Proxy extends qka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.qka
    public ska dispatch(uka ukaVar, ska skaVar) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ukaVar, skaVar)) == null) {
            ska skaVar2 = skaVar == null ? new ska() : skaVar;
            String b = ukaVar.b();
            JSONObject e = ukaVar.e();
            if (b.equals("account/startLoginModule")) {
                skaVar2.s(true);
                ska startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    skaVar2.y(startLoginModule.f());
                    skaVar2.u(startLoginModule.b());
                    skaVar2.o(startLoginModule.a());
                    skaVar2.x(startLoginModule.e());
                }
                skaVar2.z(0);
            } else if (b.equals("account/authState")) {
                skaVar2.s(true);
                ska checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    skaVar2.y(checkAuthState.f());
                    skaVar2.u(checkAuthState.b());
                    skaVar2.o(checkAuthState.a());
                    skaVar2.x(checkAuthState.e());
                }
                skaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                skaVar2.s(true);
                ska startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    skaVar2.y(startAllLoginModule.f());
                    skaVar2.u(startAllLoginModule.b());
                    skaVar2.o(startAllLoginModule.a());
                    skaVar2.x(startAllLoginModule.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver("commonLogin", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                skaVar2.s(true);
                ska realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    skaVar2.y(realNameAuth.f());
                    skaVar2.u(realNameAuth.b());
                    skaVar2.o(realNameAuth.a());
                    skaVar2.x(realNameAuth.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver("realNameAuthResult", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                skaVar2.s(true);
                ska finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    skaVar2.y(finishPage.f());
                    skaVar2.u(finishPage.b());
                    skaVar2.o(finishPage.a());
                    skaVar2.x(finishPage.e());
                }
                skaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                skaVar2.s(true);
                ska showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    skaVar2.y(showLowerHairHint.f());
                    skaVar2.u(showLowerHairHint.b());
                    skaVar2.o(showLowerHairHint.a());
                    skaVar2.x(showLowerHairHint.e());
                }
                skaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                skaVar2.s(true);
                ska gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    skaVar2.y(gamePush.f());
                    skaVar2.u(gamePush.b());
                    skaVar2.o(gamePush.a());
                    skaVar2.x(gamePush.e());
                }
                skaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                skaVar2.s(true);
                ska handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    skaVar2.y(handleGamePushStatus.f());
                    skaVar2.u(handleGamePushStatus.b());
                    skaVar2.o(handleGamePushStatus.a());
                    skaVar2.x(handleGamePushStatus.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                skaVar2.s(true);
                ska jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    skaVar2.y(jumpForumRulesEditPage.f());
                    skaVar2.u(jumpForumRulesEditPage.b());
                    skaVar2.o(jumpForumRulesEditPage.a());
                    skaVar2.x(jumpForumRulesEditPage.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                skaVar2.s(true);
                ska handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    skaVar2.y(handleGoToBarDetail.f());
                    skaVar2.u(handleGoToBarDetail.b());
                    skaVar2.o(handleGoToBarDetail.a());
                    skaVar2.x(handleGoToBarDetail.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                skaVar2.s(true);
                ska handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    skaVar2.y(handleSaveImage.f());
                    skaVar2.u(handleSaveImage.b());
                    skaVar2.o(handleSaveImage.a());
                    skaVar2.x(handleSaveImage.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver("saveImageSuccess", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                skaVar2.s(true);
                ska orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    skaVar2.y(orderGameApk.f());
                    skaVar2.u(orderGameApk.b());
                    skaVar2.o(orderGameApk.a());
                    skaVar2.x(orderGameApk.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver("orderGameApkResult", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                skaVar2.s(true);
                ska handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    skaVar2.y(handleGetPhotoAlbum.f());
                    skaVar2.u(handleGetPhotoAlbum.b());
                    skaVar2.o(handleGetPhotoAlbum.a());
                    skaVar2.x(handleGetPhotoAlbum.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver("GetPhotoAlbum", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                skaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                ska preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    skaVar2.y(preheatWeb.f());
                    skaVar2.u(preheatWeb.b());
                    skaVar2.o(preheatWeb.a());
                    skaVar2.x(preheatWeb.e());
                }
                skaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                skaVar2.s(true);
                ska openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    skaVar2.y(openMXDYab.f());
                    skaVar2.u(openMXDYab.b());
                    skaVar2.o(openMXDYab.a());
                    skaVar2.x(openMXDYab.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/portal")) {
                skaVar2.s(true);
                ska handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (handlePortal != null) {
                    skaVar2.y(handlePortal.f());
                    skaVar2.u(handlePortal.b());
                    skaVar2.o(handlePortal.a());
                    skaVar2.x(handlePortal.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                skaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                ska selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    skaVar2.y(selectPhotoAlbum.f());
                    skaVar2.u(selectPhotoAlbum.b());
                    skaVar2.o(selectPhotoAlbum.a());
                    skaVar2.x(selectPhotoAlbum.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver("selectPhotoAlbum", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                skaVar2.s(true);
                ska operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    skaVar2.y(operateNotifyDataChanged.f());
                    skaVar2.u(operateNotifyDataChanged.b());
                    skaVar2.o(operateNotifyDataChanged.a());
                    skaVar2.x(operateNotifyDataChanged.e());
                }
                skaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                skaVar2.s(true);
                ska viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    skaVar2.y(viewPosition.f());
                    skaVar2.u(viewPosition.b());
                    skaVar2.o(viewPosition.a());
                    skaVar2.x(viewPosition.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                skaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                ska selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    skaVar2.y(selectPrivateMsg.f());
                    skaVar2.u(selectPrivateMsg.b());
                    skaVar2.o(selectPrivateMsg.a());
                    skaVar2.x(selectPrivateMsg.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                skaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                ska reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    skaVar2.y(reportUserTheme.f());
                    skaVar2.u(reportUserTheme.b());
                    skaVar2.o(reportUserTheme.a());
                    skaVar2.x(reportUserTheme.e());
                    if (!skaVar2.h()) {
                        skaVar2.n(false);
                        addObserver("goToReportThreadPage", skaVar2, false);
                    }
                }
                skaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                skaVar2.s(true);
                ska playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    skaVar2.y(playSound.f());
                    skaVar2.u(playSound.b());
                    skaVar2.o(playSound.a());
                    skaVar2.x(playSound.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                skaVar2.s(true);
                ska playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    skaVar2.y(playVibrate.f());
                    skaVar2.u(playVibrate.b());
                    skaVar2.o(playVibrate.a());
                    skaVar2.x(playVibrate.e());
                }
                skaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                skaVar2.s(true);
                ska localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    skaVar2.y(localYaLog.f());
                    skaVar2.u(localYaLog.b());
                    skaVar2.o(localYaLog.a());
                    skaVar2.x(localYaLog.e());
                }
                skaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                skaVar2.s(true);
                ska jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    skaVar2.y(jumpLoginActivity.f());
                    skaVar2.u(jumpLoginActivity.b());
                    skaVar2.o(jumpLoginActivity.a());
                    skaVar2.x(jumpLoginActivity.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                skaVar2.s(true);
                ska startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    skaVar2.y(startLoadTimeInterval.f());
                    skaVar2.u(startLoadTimeInterval.b());
                    skaVar2.o(startLoadTimeInterval.a());
                    skaVar2.x(startLoadTimeInterval.e());
                }
                skaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                skaVar2.s(true);
                ska zid = this.mJsBridge.getZid();
                if (zid != null) {
                    skaVar2.y(zid.f());
                    skaVar2.u(zid.b());
                    skaVar2.o(zid.a());
                    skaVar2.x(zid.e());
                }
                skaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                skaVar2.s(true);
                ska hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    skaVar2.y(hdid.f());
                    skaVar2.u(hdid.b());
                    skaVar2.o(hdid.a());
                    skaVar2.x(hdid.e());
                }
                skaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                skaVar2.s(true);
                ska shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    skaVar2.y(shareInfo.f());
                    skaVar2.u(shareInfo.b());
                    skaVar2.o(shareInfo.a());
                    skaVar2.x(shareInfo.e());
                }
                skaVar2.z(0);
            } else if (b.equals("share/share")) {
                skaVar2.s(true);
                ska share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    skaVar2.y(share.f());
                    skaVar2.u(share.b());
                    skaVar2.o(share.a());
                    skaVar2.x(share.e());
                    if (!skaVar2.h()) {
                        i12 = 0;
                        skaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, skaVar2, false);
                        skaVar2.z(i12);
                    }
                }
                i12 = 0;
                skaVar2.z(i12);
            } else if (b.equals("clipper/getClipperInformation")) {
                skaVar2.s(true);
                ska clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    skaVar2.y(clipperInformation.f());
                    skaVar2.u(clipperInformation.b());
                    skaVar2.o(clipperInformation.a());
                    skaVar2.x(clipperInformation.e());
                }
                skaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                skaVar2.s(true);
                ska clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    skaVar2.y(clipperInformation2.f());
                    skaVar2.u(clipperInformation2.b());
                    skaVar2.o(clipperInformation2.a());
                    skaVar2.x(clipperInformation2.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                skaVar2.s(true);
                ska goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    skaVar2.y(goToEditPost.f());
                    skaVar2.u(goToEditPost.b());
                    skaVar2.o(goToEditPost.a());
                    skaVar2.x(goToEditPost.e());
                }
                skaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                skaVar2.s(true);
                ska updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    skaVar2.y(updateSearchForumInfo.f());
                    skaVar2.u(updateSearchForumInfo.b());
                    skaVar2.o(updateSearchForumInfo.a());
                    skaVar2.x(updateSearchForumInfo.e());
                }
                skaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                skaVar2.s(true);
                ska personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    skaVar2.y(personlizedSwitchChange.f());
                    skaVar2.u(personlizedSwitchChange.b());
                    skaVar2.o(personlizedSwitchChange.a());
                    skaVar2.x(personlizedSwitchChange.e());
                }
                skaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                skaVar2.s(true);
                ska updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    skaVar2.y(updateTailStyle.f());
                    skaVar2.u(updateTailStyle.b());
                    skaVar2.o(updateTailStyle.a());
                    skaVar2.x(updateTailStyle.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                skaVar2.s(true);
                ska goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    skaVar2.y(goToVideoImmersivePage.f());
                    skaVar2.u(goToVideoImmersivePage.b());
                    skaVar2.o(goToVideoImmersivePage.a());
                    skaVar2.x(goToVideoImmersivePage.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                skaVar2.s(true);
                ska jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    skaVar2.y(jumpToVideo.f());
                    skaVar2.u(jumpToVideo.b());
                    skaVar2.o(jumpToVideo.a());
                    skaVar2.x(jumpToVideo.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                skaVar2.s(true);
                ska closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    skaVar2.y(closeNativeMask.f());
                    skaVar2.u(closeNativeMask.b());
                    skaVar2.o(closeNativeMask.a());
                    skaVar2.x(closeNativeMask.e());
                }
                skaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                skaVar2.s(true);
                ska oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    skaVar2.y(oneKeyDeletion.f());
                    skaVar2.u(oneKeyDeletion.b());
                    skaVar2.o(oneKeyDeletion.a());
                    skaVar2.x(oneKeyDeletion.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                skaVar2.s(true);
                ska checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    skaVar2.y(checkAppInstall.f());
                    skaVar2.u(checkAppInstall.b());
                    skaVar2.o(checkAppInstall.a());
                    skaVar2.x(checkAppInstall.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                skaVar2.s(true);
                ska disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    skaVar2.y(disableBack.f());
                    skaVar2.u(disableBack.b());
                    skaVar2.o(disableBack.a());
                    skaVar2.x(disableBack.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                skaVar2.s(true);
                ska startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    skaVar2.y(startApp.f());
                    skaVar2.u(startApp.b());
                    skaVar2.o(startApp.a());
                    skaVar2.x(startApp.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                skaVar2.s(true);
                ska hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    skaVar2.y(hasNotificationPermission.f());
                    skaVar2.u(hasNotificationPermission.b());
                    skaVar2.o(hasNotificationPermission.a());
                    skaVar2.x(hasNotificationPermission.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                skaVar2.s(true);
                ska goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    skaVar2.y(goToNotificationSetting.f());
                    skaVar2.u(goToNotificationSetting.b());
                    skaVar2.o(goToNotificationSetting.a());
                    skaVar2.x(goToNotificationSetting.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                skaVar2.s(true);
                ska startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    skaVar2.y(startDownloadGameApk.f());
                    skaVar2.u(startDownloadGameApk.b());
                    skaVar2.o(startDownloadGameApk.a());
                    skaVar2.x(startDownloadGameApk.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                skaVar2.s(true);
                ska checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    skaVar2.y(checkInstallGameApk.f());
                    skaVar2.u(checkInstallGameApk.b());
                    skaVar2.o(checkInstallGameApk.a());
                    skaVar2.x(checkInstallGameApk.e());
                }
                skaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                skaVar2.s(true);
                ska startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    skaVar2.y(startDownloadCss.f());
                    skaVar2.u(startDownloadCss.b());
                    skaVar2.o(startDownloadCss.a());
                    skaVar2.x(startDownloadCss.e());
                }
                skaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                skaVar2.s(true);
                ska disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    skaVar2.y(disableGoBack.f());
                    skaVar2.u(disableGoBack.b());
                    skaVar2.o(disableGoBack.a());
                    skaVar2.x(disableGoBack.e());
                }
                skaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                skaVar2.s(true);
                ska supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    skaVar2.y(supplementInfo.f());
                    skaVar2.u(supplementInfo.b());
                    skaVar2.o(supplementInfo.a());
                    skaVar2.x(supplementInfo.e());
                }
                skaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                skaVar2.s(true);
                ska deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    skaVar2.y(deviceGyroscopeParams.f());
                    skaVar2.u(deviceGyroscopeParams.b());
                    skaVar2.o(deviceGyroscopeParams.a());
                    skaVar2.x(deviceGyroscopeParams.e());
                    if (!skaVar2.h()) {
                        i11 = 0;
                        skaVar2.n(false);
                        addObserver("deviceMotion", skaVar2, false);
                        skaVar2.z(i11);
                    }
                }
                i11 = 0;
                skaVar2.z(i11);
            } else if (b.equals("device/deviceRefreshRate")) {
                skaVar2.s(true);
                ska deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    skaVar2.y(deviceRefreshRateParams.f());
                    skaVar2.u(deviceRefreshRateParams.b());
                    skaVar2.o(deviceRefreshRateParams.a());
                    skaVar2.x(deviceRefreshRateParams.e());
                    if (!skaVar2.h()) {
                        i10 = 0;
                        skaVar2.n(false);
                        addObserver("deviceRefreshRate", skaVar2, false);
                        skaVar2.z(i10);
                    }
                }
                i10 = 0;
                skaVar2.z(i10);
            } else if (b.equals("device/getDeviceInfo")) {
                skaVar2.s(true);
                ska deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    skaVar2.y(deviceInfo.f());
                    skaVar2.u(deviceInfo.b());
                    skaVar2.o(deviceInfo.a());
                    skaVar2.x(deviceInfo.e());
                }
                skaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                skaVar2.s(true);
                ska sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    skaVar2.y(sendCompleteTaskReqMsg.f());
                    skaVar2.u(sendCompleteTaskReqMsg.b());
                    skaVar2.o(sendCompleteTaskReqMsg.a());
                    skaVar2.x(sendCompleteTaskReqMsg.e());
                }
                skaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                skaVar2.s(true);
                ska showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    skaVar2.y(showTipToast.f());
                    skaVar2.u(showTipToast.b());
                    skaVar2.o(showTipToast.a());
                    skaVar2.x(showTipToast.e());
                }
                skaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                skaVar2.s(true);
                ska getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    skaVar2.y(getModalData.f());
                    skaVar2.u(getModalData.b());
                    skaVar2.o(getModalData.a());
                    skaVar2.x(getModalData.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                skaVar2.s(true);
                ska openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    skaVar2.y(openThirdPartApp.f());
                    skaVar2.u(openThirdPartApp.b());
                    skaVar2.o(openThirdPartApp.a());
                    skaVar2.x(openThirdPartApp.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                skaVar2.s(true);
                ska jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    skaVar2.y(jumpToHtmlPage.f());
                    skaVar2.u(jumpToHtmlPage.b());
                    skaVar2.o(jumpToHtmlPage.a());
                    skaVar2.x(jumpToHtmlPage.e());
                }
                skaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                skaVar2.s(true);
                ska offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    skaVar2.y(offlineUserInfo.f());
                    skaVar2.u(offlineUserInfo.b());
                    skaVar2.o(offlineUserInfo.a());
                    skaVar2.x(offlineUserInfo.e());
                }
                skaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                skaVar2.s(true);
                ska deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    skaVar2.y(deleteOfflineBundle.f());
                    skaVar2.u(deleteOfflineBundle.b());
                    skaVar2.o(deleteOfflineBundle.a());
                    skaVar2.x(deleteOfflineBundle.e());
                }
                skaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                skaVar2.s(true);
                ska updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    skaVar2.y(updateOfflineBundle.f());
                    skaVar2.u(updateOfflineBundle.b());
                    skaVar2.o(updateOfflineBundle.a());
                    skaVar2.x(updateOfflineBundle.e());
                }
                skaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                skaVar2.s(true);
                ska switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    skaVar2.y(switchOfflineInterface.f());
                    skaVar2.u(switchOfflineInterface.b());
                    skaVar2.o(switchOfflineInterface.a());
                    skaVar2.x(switchOfflineInterface.e());
                }
                skaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                skaVar2.s(true);
                ska switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    skaVar2.y(switchOfflineBundleStatus.f());
                    skaVar2.u(switchOfflineBundleStatus.b());
                    skaVar2.o(switchOfflineBundleStatus.a());
                    skaVar2.x(switchOfflineBundleStatus.e());
                }
                skaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                skaVar2.s(true);
                ska finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    skaVar2.y(finishTestAnswer.f());
                    skaVar2.u(finishTestAnswer.b());
                    skaVar2.o(finishTestAnswer.a());
                    skaVar2.x(finishTestAnswer.e());
                }
                skaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                skaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                ska switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    skaVar2.y(switchUrlHost.f());
                    skaVar2.u(switchUrlHost.b());
                    skaVar2.o(switchUrlHost.a());
                    skaVar2.x(switchUrlHost.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                skaVar2.s(true);
                ska appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    skaVar2.y(appStorage.f());
                    skaVar2.u(appStorage.b());
                    skaVar2.o(appStorage.a());
                    skaVar2.x(appStorage.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                skaVar2.s(true);
                ska putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    skaVar2.y(putAppStorage.f());
                    skaVar2.u(putAppStorage.b());
                    skaVar2.o(putAppStorage.a());
                    skaVar2.x(putAppStorage.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                skaVar2.s(true);
                ska historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    skaVar2.y(historyForumData.f());
                    skaVar2.u(historyForumData.b());
                    skaVar2.o(historyForumData.a());
                    skaVar2.x(historyForumData.e());
                }
                skaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                skaVar2.s(true);
                ska worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    skaVar2.y(worldCupRaiseSuccess.f());
                    skaVar2.u(worldCupRaiseSuccess.b());
                    skaVar2.o(worldCupRaiseSuccess.a());
                    skaVar2.x(worldCupRaiseSuccess.e());
                }
                skaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                skaVar2.s(true);
                ska alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    skaVar2.y(alipayUserId.f());
                    skaVar2.u(alipayUserId.b());
                    skaVar2.o(alipayUserId.a());
                    skaVar2.x(alipayUserId.e());
                    if (!skaVar2.h()) {
                        i9 = 0;
                        skaVar2.n(false);
                        addObserver("aliAuthResult", skaVar2, false);
                        skaVar2.z(i9);
                    }
                }
                i9 = 0;
                skaVar2.z(i9);
            } else if (b.equals("system/getFileDownloadStatus")) {
                skaVar2.s(true);
                ska fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    skaVar2.y(fileDownloadStatus.f());
                    skaVar2.u(fileDownloadStatus.b());
                    skaVar2.o(fileDownloadStatus.a());
                    skaVar2.x(fileDownloadStatus.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                skaVar2.s(true);
                ska fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    skaVar2.y(fileDownloadProgress.f());
                    skaVar2.u(fileDownloadProgress.b());
                    skaVar2.o(fileDownloadProgress.a());
                    skaVar2.x(fileDownloadProgress.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                skaVar2.s(true);
                ska fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    skaVar2.y(fileDownloadPause.f());
                    skaVar2.u(fileDownloadPause.b());
                    skaVar2.o(fileDownloadPause.a());
                    skaVar2.x(fileDownloadPause.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                skaVar2.s(true);
                ska fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    skaVar2.y(fileDownloadDelete.f());
                    skaVar2.u(fileDownloadDelete.b());
                    skaVar2.o(fileDownloadDelete.a());
                    skaVar2.x(fileDownloadDelete.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                skaVar2.s(true);
                ska installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    skaVar2.y(installGameApk.f());
                    skaVar2.u(installGameApk.b());
                    skaVar2.o(installGameApk.a());
                    skaVar2.x(installGameApk.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                skaVar2.s(true);
                ska launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    skaVar2.y(launchApk.f());
                    skaVar2.u(launchApk.b());
                    skaVar2.o(launchApk.a());
                    skaVar2.x(launchApk.e());
                }
                skaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                skaVar2.s(true);
                ska wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    skaVar2.y(wakeKeyboard.f());
                    skaVar2.u(wakeKeyboard.b());
                    skaVar2.o(wakeKeyboard.a());
                    skaVar2.x(wakeKeyboard.e());
                }
                skaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                skaVar2.s(true);
                ska replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    skaVar2.y(replyPost.f());
                    skaVar2.u(replyPost.b());
                    skaVar2.o(replyPost.a());
                    skaVar2.x(replyPost.e());
                    if (!skaVar2.h()) {
                        i8 = 0;
                        skaVar2.n(false);
                        addObserver("replyPostResult", skaVar2, false);
                        skaVar2.z(i8);
                    }
                }
                i8 = 0;
                skaVar2.z(i8);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                skaVar2.s(true);
                ska nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    skaVar2.y(nativeNetworkProxy.f());
                    skaVar2.u(nativeNetworkProxy.b());
                    skaVar2.o(nativeNetworkProxy.a());
                    skaVar2.x(nativeNetworkProxy.e());
                    if (!skaVar2.h()) {
                        i7 = 0;
                        skaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", skaVar2, false);
                        skaVar2.z(i7);
                    }
                }
                i7 = 0;
                skaVar2.z(i7);
            } else if (b.equals("host/sendMsg")) {
                skaVar2.s(true);
                ska sendMessage = this.mJsBridge.sendMessage(e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (sendMessage != null) {
                    skaVar2.y(sendMessage.f());
                    skaVar2.u(sendMessage.b());
                    skaVar2.o(sendMessage.a());
                    skaVar2.x(sendMessage.e());
                    if (!skaVar2.h()) {
                        i6 = 0;
                        skaVar2.n(false);
                        addObserver("sendMsg", skaVar2, false);
                        skaVar2.z(i6);
                    }
                }
                i6 = 0;
                skaVar2.z(i6);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                skaVar2.s(true);
                ska fetchHistoryMsgs = this.mJsBridge.fetchHistoryMsgs(e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (fetchHistoryMsgs != null) {
                    skaVar2.y(fetchHistoryMsgs.f());
                    skaVar2.u(fetchHistoryMsgs.b());
                    skaVar2.o(fetchHistoryMsgs.a());
                    skaVar2.x(fetchHistoryMsgs.e());
                    if (!skaVar2.h()) {
                        i5 = 0;
                        skaVar2.n(false);
                        addObserver("fetchHistoryMsgs", skaVar2, false);
                        skaVar2.z(i5);
                    }
                }
                i5 = 0;
                skaVar2.z(i5);
            } else if (b.equals("host/receiveNewMsgs")) {
                skaVar2.s(true);
                ska receiveNewMsgs = this.mJsBridge.receiveNewMsgs();
                this.mNotificationNameList.add("receiveNewMsgs");
                if (receiveNewMsgs != null) {
                    skaVar2.y(receiveNewMsgs.f());
                    skaVar2.u(receiveNewMsgs.b());
                    skaVar2.o(receiveNewMsgs.a());
                    skaVar2.x(receiveNewMsgs.e());
                    if (!skaVar2.h()) {
                        i4 = 0;
                        skaVar2.n(false);
                        addObserver("receiveNewMsgs", skaVar2, false);
                        skaVar2.z(i4);
                    }
                }
                i4 = 0;
                skaVar2.z(i4);
            } else if (b.equals("system/keyboardHeightChange")) {
                skaVar2.s(true);
                ska keyboardHeightChange = this.mJsBridge.keyboardHeightChange();
                this.mNotificationNameList.add("keyboardHeightChange");
                if (keyboardHeightChange != null) {
                    skaVar2.y(keyboardHeightChange.f());
                    skaVar2.u(keyboardHeightChange.b());
                    skaVar2.o(keyboardHeightChange.a());
                    skaVar2.x(keyboardHeightChange.e());
                    if (!skaVar2.h()) {
                        i3 = 0;
                        skaVar2.n(false);
                        addObserver("keyboardHeightChange", skaVar2, false);
                        skaVar2.z(i3);
                    }
                }
                i3 = 0;
                skaVar2.z(i3);
            } else if (b.equals("host/preloadPic")) {
                skaVar2.s(true);
                ArrayList<String> arrayList6 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList6, e.optJSONArray("url"));
                ska perloadPicModule = this.mJsBridge.perloadPicModule(arrayList6);
                if (perloadPicModule != null) {
                    skaVar2.y(perloadPicModule.f());
                    skaVar2.u(perloadPicModule.b());
                    skaVar2.o(perloadPicModule.a());
                    skaVar2.x(perloadPicModule.e());
                }
                skaVar2.z(0);
            } else if (b.equals("toast/showDialog")) {
                skaVar2.s(true);
                ska showDialog = this.mJsBridge.showDialog(e.optInt("type"), e.optString("content"), e.optString("dialogId"));
                this.mNotificationNameList.add("showDialog");
                if (showDialog != null) {
                    skaVar2.y(showDialog.f());
                    skaVar2.u(showDialog.b());
                    skaVar2.o(showDialog.a());
                    skaVar2.x(showDialog.e());
                    if (!skaVar2.h()) {
                        i2 = 0;
                        skaVar2.n(false);
                        addObserver("showDialog", skaVar2, false);
                        skaVar2.z(i2);
                    }
                }
                i2 = 0;
                skaVar2.z(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                skaVar2.s(true);
                ska requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    skaVar2.y(requestByNative.f());
                    skaVar2.u(requestByNative.b());
                    skaVar2.o(requestByNative.a());
                    skaVar2.x(requestByNative.e());
                    if (!skaVar2.h()) {
                        i = 0;
                        skaVar2.n(false);
                        addObserver("RequestByNativeToH5", skaVar2, false);
                        skaVar2.z(i);
                    }
                }
                i = 0;
                skaVar2.z(i);
            }
            return skaVar2;
        }
        return (ska) invokeLL.objValue;
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

    @Override // com.baidu.tieba.qka
    public List<ska> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            ska skaVar = null;
            if (di.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                skaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                skaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                skaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                skaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                skaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                skaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                skaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                skaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                skaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                skaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                skaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                skaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                skaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                skaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                skaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                skaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                skaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                skaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                skaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                skaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                skaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                skaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                skaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                skaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                skaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                skaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                skaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                skaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                skaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                skaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("sendMsg")) {
                skaVar = this.mJsBridge.onSendMsgResult(hashMap);
            } else if (str.equals("handleAudioMsgByTTS")) {
                skaVar = this.mJsBridge.handleVoiceMsgResult(hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                skaVar = this.mJsBridge.onFetchHistoryMsgsResult(hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                skaVar = this.mJsBridge.onReceiveNewMsgsResult(hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                skaVar = this.mJsBridge.onKeyboardHeightChange(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                skaVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (skaVar != null) {
                skaVar.z(0);
            }
            List<rka> list = this.mAsyncCallBackMethodList.get(str);
            if (skaVar != null && list != null) {
                Iterator<rka> it = list.iterator();
                if (!di.isEmpty(skaVar.e())) {
                    while (it.hasNext()) {
                        rka next = it.next();
                        if (next.b().equals(skaVar.e())) {
                            ska skaVar2 = new ska();
                            skaVar2.w(next.a());
                            skaVar2.y(skaVar.f());
                            skaVar2.u(skaVar.b());
                            skaVar2.o(skaVar.a());
                            skaVar2.A(skaVar.l());
                            arrayList.add(skaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rka next2 = it.next();
                        ska skaVar3 = new ska();
                        skaVar3.w(next2.a());
                        skaVar3.y(skaVar.f());
                        skaVar3.u(skaVar.b());
                        skaVar3.o(skaVar.a());
                        skaVar3.A(skaVar.l());
                        arrayList.add(skaVar3);
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
