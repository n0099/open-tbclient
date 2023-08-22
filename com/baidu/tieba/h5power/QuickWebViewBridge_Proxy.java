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
import com.baidu.tieba.qga;
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
import com.baidu.tieba.rga;
import com.baidu.tieba.sga;
import com.baidu.tieba.uga;
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
public class QuickWebViewBridge_Proxy extends qga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.qga
    public sga dispatch(uga ugaVar, sga sgaVar) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ugaVar, sgaVar)) == null) {
            sga sgaVar2 = sgaVar == null ? new sga() : sgaVar;
            String b = ugaVar.b();
            JSONObject e = ugaVar.e();
            if (b.equals("account/startLoginModule")) {
                sgaVar2.s(true);
                sga startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    sgaVar2.y(startLoginModule.f());
                    sgaVar2.u(startLoginModule.b());
                    sgaVar2.o(startLoginModule.a());
                    sgaVar2.x(startLoginModule.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("account/authState")) {
                sgaVar2.s(true);
                sga checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    sgaVar2.y(checkAuthState.f());
                    sgaVar2.u(checkAuthState.b());
                    sgaVar2.o(checkAuthState.a());
                    sgaVar2.x(checkAuthState.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                sgaVar2.s(true);
                sga startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    sgaVar2.y(startAllLoginModule.f());
                    sgaVar2.u(startAllLoginModule.b());
                    sgaVar2.o(startAllLoginModule.a());
                    sgaVar2.x(startAllLoginModule.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver("commonLogin", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                sgaVar2.s(true);
                sga realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    sgaVar2.y(realNameAuth.f());
                    sgaVar2.u(realNameAuth.b());
                    sgaVar2.o(realNameAuth.a());
                    sgaVar2.x(realNameAuth.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver("realNameAuthResult", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                sgaVar2.s(true);
                sga finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    sgaVar2.y(finishPage.f());
                    sgaVar2.u(finishPage.b());
                    sgaVar2.o(finishPage.a());
                    sgaVar2.x(finishPage.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                sgaVar2.s(true);
                sga showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    sgaVar2.y(showLowerHairHint.f());
                    sgaVar2.u(showLowerHairHint.b());
                    sgaVar2.o(showLowerHairHint.a());
                    sgaVar2.x(showLowerHairHint.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                sgaVar2.s(true);
                sga gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    sgaVar2.y(gamePush.f());
                    sgaVar2.u(gamePush.b());
                    sgaVar2.o(gamePush.a());
                    sgaVar2.x(gamePush.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                sgaVar2.s(true);
                sga handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    sgaVar2.y(handleGamePushStatus.f());
                    sgaVar2.u(handleGamePushStatus.b());
                    sgaVar2.o(handleGamePushStatus.a());
                    sgaVar2.x(handleGamePushStatus.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                sgaVar2.s(true);
                sga jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    sgaVar2.y(jumpForumRulesEditPage.f());
                    sgaVar2.u(jumpForumRulesEditPage.b());
                    sgaVar2.o(jumpForumRulesEditPage.a());
                    sgaVar2.x(jumpForumRulesEditPage.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                sgaVar2.s(true);
                sga handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    sgaVar2.y(handleGoToBarDetail.f());
                    sgaVar2.u(handleGoToBarDetail.b());
                    sgaVar2.o(handleGoToBarDetail.a());
                    sgaVar2.x(handleGoToBarDetail.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                sgaVar2.s(true);
                sga handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    sgaVar2.y(handleSaveImage.f());
                    sgaVar2.u(handleSaveImage.b());
                    sgaVar2.o(handleSaveImage.a());
                    sgaVar2.x(handleSaveImage.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver("saveImageSuccess", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                sgaVar2.s(true);
                sga orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    sgaVar2.y(orderGameApk.f());
                    sgaVar2.u(orderGameApk.b());
                    sgaVar2.o(orderGameApk.a());
                    sgaVar2.x(orderGameApk.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver("orderGameApkResult", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                sgaVar2.s(true);
                sga handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    sgaVar2.y(handleGetPhotoAlbum.f());
                    sgaVar2.u(handleGetPhotoAlbum.b());
                    sgaVar2.o(handleGetPhotoAlbum.a());
                    sgaVar2.x(handleGetPhotoAlbum.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver("GetPhotoAlbum", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                sgaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                sga preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    sgaVar2.y(preheatWeb.f());
                    sgaVar2.u(preheatWeb.b());
                    sgaVar2.o(preheatWeb.a());
                    sgaVar2.x(preheatWeb.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                sgaVar2.s(true);
                sga openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    sgaVar2.y(openMXDYab.f());
                    sgaVar2.u(openMXDYab.b());
                    sgaVar2.o(openMXDYab.a());
                    sgaVar2.x(openMXDYab.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/portal")) {
                sgaVar2.s(true);
                sga handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (handlePortal != null) {
                    sgaVar2.y(handlePortal.f());
                    sgaVar2.u(handlePortal.b());
                    sgaVar2.o(handlePortal.a());
                    sgaVar2.x(handlePortal.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                sgaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                sga selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    sgaVar2.y(selectPhotoAlbum.f());
                    sgaVar2.u(selectPhotoAlbum.b());
                    sgaVar2.o(selectPhotoAlbum.a());
                    sgaVar2.x(selectPhotoAlbum.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver("selectPhotoAlbum", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                sgaVar2.s(true);
                sga operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    sgaVar2.y(operateNotifyDataChanged.f());
                    sgaVar2.u(operateNotifyDataChanged.b());
                    sgaVar2.o(operateNotifyDataChanged.a());
                    sgaVar2.x(operateNotifyDataChanged.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                sgaVar2.s(true);
                sga viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    sgaVar2.y(viewPosition.f());
                    sgaVar2.u(viewPosition.b());
                    sgaVar2.o(viewPosition.a());
                    sgaVar2.x(viewPosition.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                sgaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                sga selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    sgaVar2.y(selectPrivateMsg.f());
                    sgaVar2.u(selectPrivateMsg.b());
                    sgaVar2.o(selectPrivateMsg.a());
                    sgaVar2.x(selectPrivateMsg.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                sgaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                sga reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    sgaVar2.y(reportUserTheme.f());
                    sgaVar2.u(reportUserTheme.b());
                    sgaVar2.o(reportUserTheme.a());
                    sgaVar2.x(reportUserTheme.e());
                    if (!sgaVar2.h()) {
                        sgaVar2.n(false);
                        addObserver("goToReportThreadPage", sgaVar2, false);
                    }
                }
                sgaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                sgaVar2.s(true);
                sga playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    sgaVar2.y(playSound.f());
                    sgaVar2.u(playSound.b());
                    sgaVar2.o(playSound.a());
                    sgaVar2.x(playSound.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                sgaVar2.s(true);
                sga playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    sgaVar2.y(playVibrate.f());
                    sgaVar2.u(playVibrate.b());
                    sgaVar2.o(playVibrate.a());
                    sgaVar2.x(playVibrate.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                sgaVar2.s(true);
                sga localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    sgaVar2.y(localYaLog.f());
                    sgaVar2.u(localYaLog.b());
                    sgaVar2.o(localYaLog.a());
                    sgaVar2.x(localYaLog.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                sgaVar2.s(true);
                sga jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    sgaVar2.y(jumpLoginActivity.f());
                    sgaVar2.u(jumpLoginActivity.b());
                    sgaVar2.o(jumpLoginActivity.a());
                    sgaVar2.x(jumpLoginActivity.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                sgaVar2.s(true);
                sga startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    sgaVar2.y(startLoadTimeInterval.f());
                    sgaVar2.u(startLoadTimeInterval.b());
                    sgaVar2.o(startLoadTimeInterval.a());
                    sgaVar2.x(startLoadTimeInterval.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                sgaVar2.s(true);
                sga zid = this.mJsBridge.getZid();
                if (zid != null) {
                    sgaVar2.y(zid.f());
                    sgaVar2.u(zid.b());
                    sgaVar2.o(zid.a());
                    sgaVar2.x(zid.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                sgaVar2.s(true);
                sga hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    sgaVar2.y(hdid.f());
                    sgaVar2.u(hdid.b());
                    sgaVar2.o(hdid.a());
                    sgaVar2.x(hdid.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                sgaVar2.s(true);
                sga shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    sgaVar2.y(shareInfo.f());
                    sgaVar2.u(shareInfo.b());
                    sgaVar2.o(shareInfo.a());
                    sgaVar2.x(shareInfo.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("share/share")) {
                sgaVar2.s(true);
                sga share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    sgaVar2.y(share.f());
                    sgaVar2.u(share.b());
                    sgaVar2.o(share.a());
                    sgaVar2.x(share.e());
                    if (!sgaVar2.h()) {
                        i12 = 0;
                        sgaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, sgaVar2, false);
                        sgaVar2.z(i12);
                    }
                }
                i12 = 0;
                sgaVar2.z(i12);
            } else if (b.equals("clipper/getClipperInformation")) {
                sgaVar2.s(true);
                sga clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    sgaVar2.y(clipperInformation.f());
                    sgaVar2.u(clipperInformation.b());
                    sgaVar2.o(clipperInformation.a());
                    sgaVar2.x(clipperInformation.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                sgaVar2.s(true);
                sga clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    sgaVar2.y(clipperInformation2.f());
                    sgaVar2.u(clipperInformation2.b());
                    sgaVar2.o(clipperInformation2.a());
                    sgaVar2.x(clipperInformation2.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                sgaVar2.s(true);
                sga goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    sgaVar2.y(goToEditPost.f());
                    sgaVar2.u(goToEditPost.b());
                    sgaVar2.o(goToEditPost.a());
                    sgaVar2.x(goToEditPost.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                sgaVar2.s(true);
                sga updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    sgaVar2.y(updateSearchForumInfo.f());
                    sgaVar2.u(updateSearchForumInfo.b());
                    sgaVar2.o(updateSearchForumInfo.a());
                    sgaVar2.x(updateSearchForumInfo.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                sgaVar2.s(true);
                sga personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    sgaVar2.y(personlizedSwitchChange.f());
                    sgaVar2.u(personlizedSwitchChange.b());
                    sgaVar2.o(personlizedSwitchChange.a());
                    sgaVar2.x(personlizedSwitchChange.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                sgaVar2.s(true);
                sga updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    sgaVar2.y(updateTailStyle.f());
                    sgaVar2.u(updateTailStyle.b());
                    sgaVar2.o(updateTailStyle.a());
                    sgaVar2.x(updateTailStyle.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                sgaVar2.s(true);
                sga goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    sgaVar2.y(goToVideoImmersivePage.f());
                    sgaVar2.u(goToVideoImmersivePage.b());
                    sgaVar2.o(goToVideoImmersivePage.a());
                    sgaVar2.x(goToVideoImmersivePage.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                sgaVar2.s(true);
                sga jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    sgaVar2.y(jumpToVideo.f());
                    sgaVar2.u(jumpToVideo.b());
                    sgaVar2.o(jumpToVideo.a());
                    sgaVar2.x(jumpToVideo.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                sgaVar2.s(true);
                sga closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    sgaVar2.y(closeNativeMask.f());
                    sgaVar2.u(closeNativeMask.b());
                    sgaVar2.o(closeNativeMask.a());
                    sgaVar2.x(closeNativeMask.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                sgaVar2.s(true);
                sga oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    sgaVar2.y(oneKeyDeletion.f());
                    sgaVar2.u(oneKeyDeletion.b());
                    sgaVar2.o(oneKeyDeletion.a());
                    sgaVar2.x(oneKeyDeletion.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                sgaVar2.s(true);
                sga checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    sgaVar2.y(checkAppInstall.f());
                    sgaVar2.u(checkAppInstall.b());
                    sgaVar2.o(checkAppInstall.a());
                    sgaVar2.x(checkAppInstall.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                sgaVar2.s(true);
                sga disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    sgaVar2.y(disableBack.f());
                    sgaVar2.u(disableBack.b());
                    sgaVar2.o(disableBack.a());
                    sgaVar2.x(disableBack.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                sgaVar2.s(true);
                sga startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    sgaVar2.y(startApp.f());
                    sgaVar2.u(startApp.b());
                    sgaVar2.o(startApp.a());
                    sgaVar2.x(startApp.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                sgaVar2.s(true);
                sga hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    sgaVar2.y(hasNotificationPermission.f());
                    sgaVar2.u(hasNotificationPermission.b());
                    sgaVar2.o(hasNotificationPermission.a());
                    sgaVar2.x(hasNotificationPermission.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                sgaVar2.s(true);
                sga goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    sgaVar2.y(goToNotificationSetting.f());
                    sgaVar2.u(goToNotificationSetting.b());
                    sgaVar2.o(goToNotificationSetting.a());
                    sgaVar2.x(goToNotificationSetting.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                sgaVar2.s(true);
                sga startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    sgaVar2.y(startDownloadGameApk.f());
                    sgaVar2.u(startDownloadGameApk.b());
                    sgaVar2.o(startDownloadGameApk.a());
                    sgaVar2.x(startDownloadGameApk.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                sgaVar2.s(true);
                sga checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    sgaVar2.y(checkInstallGameApk.f());
                    sgaVar2.u(checkInstallGameApk.b());
                    sgaVar2.o(checkInstallGameApk.a());
                    sgaVar2.x(checkInstallGameApk.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                sgaVar2.s(true);
                sga startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    sgaVar2.y(startDownloadCss.f());
                    sgaVar2.u(startDownloadCss.b());
                    sgaVar2.o(startDownloadCss.a());
                    sgaVar2.x(startDownloadCss.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                sgaVar2.s(true);
                sga disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    sgaVar2.y(disableGoBack.f());
                    sgaVar2.u(disableGoBack.b());
                    sgaVar2.o(disableGoBack.a());
                    sgaVar2.x(disableGoBack.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                sgaVar2.s(true);
                sga supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    sgaVar2.y(supplementInfo.f());
                    sgaVar2.u(supplementInfo.b());
                    sgaVar2.o(supplementInfo.a());
                    sgaVar2.x(supplementInfo.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                sgaVar2.s(true);
                sga deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    sgaVar2.y(deviceGyroscopeParams.f());
                    sgaVar2.u(deviceGyroscopeParams.b());
                    sgaVar2.o(deviceGyroscopeParams.a());
                    sgaVar2.x(deviceGyroscopeParams.e());
                    if (!sgaVar2.h()) {
                        i11 = 0;
                        sgaVar2.n(false);
                        addObserver("deviceMotion", sgaVar2, false);
                        sgaVar2.z(i11);
                    }
                }
                i11 = 0;
                sgaVar2.z(i11);
            } else if (b.equals("device/deviceRefreshRate")) {
                sgaVar2.s(true);
                sga deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    sgaVar2.y(deviceRefreshRateParams.f());
                    sgaVar2.u(deviceRefreshRateParams.b());
                    sgaVar2.o(deviceRefreshRateParams.a());
                    sgaVar2.x(deviceRefreshRateParams.e());
                    if (!sgaVar2.h()) {
                        i10 = 0;
                        sgaVar2.n(false);
                        addObserver("deviceRefreshRate", sgaVar2, false);
                        sgaVar2.z(i10);
                    }
                }
                i10 = 0;
                sgaVar2.z(i10);
            } else if (b.equals("device/getDeviceInfo")) {
                sgaVar2.s(true);
                sga deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    sgaVar2.y(deviceInfo.f());
                    sgaVar2.u(deviceInfo.b());
                    sgaVar2.o(deviceInfo.a());
                    sgaVar2.x(deviceInfo.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                sgaVar2.s(true);
                sga sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    sgaVar2.y(sendCompleteTaskReqMsg.f());
                    sgaVar2.u(sendCompleteTaskReqMsg.b());
                    sgaVar2.o(sendCompleteTaskReqMsg.a());
                    sgaVar2.x(sendCompleteTaskReqMsg.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                sgaVar2.s(true);
                sga showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    sgaVar2.y(showTipToast.f());
                    sgaVar2.u(showTipToast.b());
                    sgaVar2.o(showTipToast.a());
                    sgaVar2.x(showTipToast.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                sgaVar2.s(true);
                sga getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    sgaVar2.y(getModalData.f());
                    sgaVar2.u(getModalData.b());
                    sgaVar2.o(getModalData.a());
                    sgaVar2.x(getModalData.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                sgaVar2.s(true);
                sga openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    sgaVar2.y(openThirdPartApp.f());
                    sgaVar2.u(openThirdPartApp.b());
                    sgaVar2.o(openThirdPartApp.a());
                    sgaVar2.x(openThirdPartApp.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                sgaVar2.s(true);
                sga jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    sgaVar2.y(jumpToHtmlPage.f());
                    sgaVar2.u(jumpToHtmlPage.b());
                    sgaVar2.o(jumpToHtmlPage.a());
                    sgaVar2.x(jumpToHtmlPage.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                sgaVar2.s(true);
                sga offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    sgaVar2.y(offlineUserInfo.f());
                    sgaVar2.u(offlineUserInfo.b());
                    sgaVar2.o(offlineUserInfo.a());
                    sgaVar2.x(offlineUserInfo.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                sgaVar2.s(true);
                sga deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    sgaVar2.y(deleteOfflineBundle.f());
                    sgaVar2.u(deleteOfflineBundle.b());
                    sgaVar2.o(deleteOfflineBundle.a());
                    sgaVar2.x(deleteOfflineBundle.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                sgaVar2.s(true);
                sga updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    sgaVar2.y(updateOfflineBundle.f());
                    sgaVar2.u(updateOfflineBundle.b());
                    sgaVar2.o(updateOfflineBundle.a());
                    sgaVar2.x(updateOfflineBundle.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                sgaVar2.s(true);
                sga switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    sgaVar2.y(switchOfflineInterface.f());
                    sgaVar2.u(switchOfflineInterface.b());
                    sgaVar2.o(switchOfflineInterface.a());
                    sgaVar2.x(switchOfflineInterface.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                sgaVar2.s(true);
                sga switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    sgaVar2.y(switchOfflineBundleStatus.f());
                    sgaVar2.u(switchOfflineBundleStatus.b());
                    sgaVar2.o(switchOfflineBundleStatus.a());
                    sgaVar2.x(switchOfflineBundleStatus.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                sgaVar2.s(true);
                sga finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    sgaVar2.y(finishTestAnswer.f());
                    sgaVar2.u(finishTestAnswer.b());
                    sgaVar2.o(finishTestAnswer.a());
                    sgaVar2.x(finishTestAnswer.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                sgaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                sga switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    sgaVar2.y(switchUrlHost.f());
                    sgaVar2.u(switchUrlHost.b());
                    sgaVar2.o(switchUrlHost.a());
                    sgaVar2.x(switchUrlHost.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                sgaVar2.s(true);
                sga appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    sgaVar2.y(appStorage.f());
                    sgaVar2.u(appStorage.b());
                    sgaVar2.o(appStorage.a());
                    sgaVar2.x(appStorage.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                sgaVar2.s(true);
                sga putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    sgaVar2.y(putAppStorage.f());
                    sgaVar2.u(putAppStorage.b());
                    sgaVar2.o(putAppStorage.a());
                    sgaVar2.x(putAppStorage.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                sgaVar2.s(true);
                sga historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    sgaVar2.y(historyForumData.f());
                    sgaVar2.u(historyForumData.b());
                    sgaVar2.o(historyForumData.a());
                    sgaVar2.x(historyForumData.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                sgaVar2.s(true);
                sga worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    sgaVar2.y(worldCupRaiseSuccess.f());
                    sgaVar2.u(worldCupRaiseSuccess.b());
                    sgaVar2.o(worldCupRaiseSuccess.a());
                    sgaVar2.x(worldCupRaiseSuccess.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                sgaVar2.s(true);
                sga alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    sgaVar2.y(alipayUserId.f());
                    sgaVar2.u(alipayUserId.b());
                    sgaVar2.o(alipayUserId.a());
                    sgaVar2.x(alipayUserId.e());
                    if (!sgaVar2.h()) {
                        i9 = 0;
                        sgaVar2.n(false);
                        addObserver("aliAuthResult", sgaVar2, false);
                        sgaVar2.z(i9);
                    }
                }
                i9 = 0;
                sgaVar2.z(i9);
            } else if (b.equals("system/getFileDownloadStatus")) {
                sgaVar2.s(true);
                sga fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    sgaVar2.y(fileDownloadStatus.f());
                    sgaVar2.u(fileDownloadStatus.b());
                    sgaVar2.o(fileDownloadStatus.a());
                    sgaVar2.x(fileDownloadStatus.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                sgaVar2.s(true);
                sga fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    sgaVar2.y(fileDownloadProgress.f());
                    sgaVar2.u(fileDownloadProgress.b());
                    sgaVar2.o(fileDownloadProgress.a());
                    sgaVar2.x(fileDownloadProgress.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                sgaVar2.s(true);
                sga fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    sgaVar2.y(fileDownloadPause.f());
                    sgaVar2.u(fileDownloadPause.b());
                    sgaVar2.o(fileDownloadPause.a());
                    sgaVar2.x(fileDownloadPause.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                sgaVar2.s(true);
                sga fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    sgaVar2.y(fileDownloadDelete.f());
                    sgaVar2.u(fileDownloadDelete.b());
                    sgaVar2.o(fileDownloadDelete.a());
                    sgaVar2.x(fileDownloadDelete.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                sgaVar2.s(true);
                sga installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    sgaVar2.y(installGameApk.f());
                    sgaVar2.u(installGameApk.b());
                    sgaVar2.o(installGameApk.a());
                    sgaVar2.x(installGameApk.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                sgaVar2.s(true);
                sga launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    sgaVar2.y(launchApk.f());
                    sgaVar2.u(launchApk.b());
                    sgaVar2.o(launchApk.a());
                    sgaVar2.x(launchApk.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                sgaVar2.s(true);
                sga wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    sgaVar2.y(wakeKeyboard.f());
                    sgaVar2.u(wakeKeyboard.b());
                    sgaVar2.o(wakeKeyboard.a());
                    sgaVar2.x(wakeKeyboard.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                sgaVar2.s(true);
                sga replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    sgaVar2.y(replyPost.f());
                    sgaVar2.u(replyPost.b());
                    sgaVar2.o(replyPost.a());
                    sgaVar2.x(replyPost.e());
                    if (!sgaVar2.h()) {
                        i8 = 0;
                        sgaVar2.n(false);
                        addObserver("replyPostResult", sgaVar2, false);
                        sgaVar2.z(i8);
                    }
                }
                i8 = 0;
                sgaVar2.z(i8);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                sgaVar2.s(true);
                sga nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    sgaVar2.y(nativeNetworkProxy.f());
                    sgaVar2.u(nativeNetworkProxy.b());
                    sgaVar2.o(nativeNetworkProxy.a());
                    sgaVar2.x(nativeNetworkProxy.e());
                    if (!sgaVar2.h()) {
                        i7 = 0;
                        sgaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", sgaVar2, false);
                        sgaVar2.z(i7);
                    }
                }
                i7 = 0;
                sgaVar2.z(i7);
            } else if (b.equals("host/sendMsg")) {
                sgaVar2.s(true);
                sga sendMessage = this.mJsBridge.sendMessage(e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (sendMessage != null) {
                    sgaVar2.y(sendMessage.f());
                    sgaVar2.u(sendMessage.b());
                    sgaVar2.o(sendMessage.a());
                    sgaVar2.x(sendMessage.e());
                    if (!sgaVar2.h()) {
                        i6 = 0;
                        sgaVar2.n(false);
                        addObserver("sendMsg", sgaVar2, false);
                        sgaVar2.z(i6);
                    }
                }
                i6 = 0;
                sgaVar2.z(i6);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                sgaVar2.s(true);
                sga fetchHistoryMsgs = this.mJsBridge.fetchHistoryMsgs(e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (fetchHistoryMsgs != null) {
                    sgaVar2.y(fetchHistoryMsgs.f());
                    sgaVar2.u(fetchHistoryMsgs.b());
                    sgaVar2.o(fetchHistoryMsgs.a());
                    sgaVar2.x(fetchHistoryMsgs.e());
                    if (!sgaVar2.h()) {
                        i5 = 0;
                        sgaVar2.n(false);
                        addObserver("fetchHistoryMsgs", sgaVar2, false);
                        sgaVar2.z(i5);
                    }
                }
                i5 = 0;
                sgaVar2.z(i5);
            } else if (b.equals("host/receiveNewMsgs")) {
                sgaVar2.s(true);
                sga receiveNewMsgs = this.mJsBridge.receiveNewMsgs();
                this.mNotificationNameList.add("receiveNewMsgs");
                if (receiveNewMsgs != null) {
                    sgaVar2.y(receiveNewMsgs.f());
                    sgaVar2.u(receiveNewMsgs.b());
                    sgaVar2.o(receiveNewMsgs.a());
                    sgaVar2.x(receiveNewMsgs.e());
                    if (!sgaVar2.h()) {
                        i4 = 0;
                        sgaVar2.n(false);
                        addObserver("receiveNewMsgs", sgaVar2, false);
                        sgaVar2.z(i4);
                    }
                }
                i4 = 0;
                sgaVar2.z(i4);
            } else if (b.equals("system/keyboardHeightChange")) {
                sgaVar2.s(true);
                sga keyboardHeightChange = this.mJsBridge.keyboardHeightChange();
                this.mNotificationNameList.add("keyboardHeightChange");
                if (keyboardHeightChange != null) {
                    sgaVar2.y(keyboardHeightChange.f());
                    sgaVar2.u(keyboardHeightChange.b());
                    sgaVar2.o(keyboardHeightChange.a());
                    sgaVar2.x(keyboardHeightChange.e());
                    if (!sgaVar2.h()) {
                        i3 = 0;
                        sgaVar2.n(false);
                        addObserver("keyboardHeightChange", sgaVar2, false);
                        sgaVar2.z(i3);
                    }
                }
                i3 = 0;
                sgaVar2.z(i3);
            } else if (b.equals("host/preloadPic")) {
                sgaVar2.s(true);
                ArrayList<String> arrayList6 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList6, e.optJSONArray("url"));
                sga perloadPicModule = this.mJsBridge.perloadPicModule(arrayList6);
                if (perloadPicModule != null) {
                    sgaVar2.y(perloadPicModule.f());
                    sgaVar2.u(perloadPicModule.b());
                    sgaVar2.o(perloadPicModule.a());
                    sgaVar2.x(perloadPicModule.e());
                }
                sgaVar2.z(0);
            } else if (b.equals("toast/showDialog")) {
                sgaVar2.s(true);
                sga showDialog = this.mJsBridge.showDialog(e.optInt("type"), e.optString("content"), e.optString("dialogId"));
                this.mNotificationNameList.add("showDialog");
                if (showDialog != null) {
                    sgaVar2.y(showDialog.f());
                    sgaVar2.u(showDialog.b());
                    sgaVar2.o(showDialog.a());
                    sgaVar2.x(showDialog.e());
                    if (!sgaVar2.h()) {
                        i2 = 0;
                        sgaVar2.n(false);
                        addObserver("showDialog", sgaVar2, false);
                        sgaVar2.z(i2);
                    }
                }
                i2 = 0;
                sgaVar2.z(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                sgaVar2.s(true);
                sga requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    sgaVar2.y(requestByNative.f());
                    sgaVar2.u(requestByNative.b());
                    sgaVar2.o(requestByNative.a());
                    sgaVar2.x(requestByNative.e());
                    if (!sgaVar2.h()) {
                        i = 0;
                        sgaVar2.n(false);
                        addObserver("RequestByNativeToH5", sgaVar2, false);
                        sgaVar2.z(i);
                    }
                }
                i = 0;
                sgaVar2.z(i);
            }
            return sgaVar2;
        }
        return (sga) invokeLL.objValue;
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
        this.mNotificationNameList.add("fetchHistoryMsgs");
        this.mNotificationNameList.add("receiveNewMsgs");
        this.mNotificationNameList.add("keyboardHeightChange");
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.qga
    public List<sga> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            sga sgaVar = null;
            if (di.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                sgaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                sgaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                sgaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                sgaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                sgaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                sgaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                sgaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                sgaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                sgaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                sgaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                sgaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                sgaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                sgaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                sgaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                sgaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                sgaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                sgaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                sgaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                sgaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                sgaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                sgaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                sgaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                sgaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                sgaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                sgaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                sgaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                sgaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                sgaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                sgaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                sgaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("sendMsg")) {
                sgaVar = this.mJsBridge.onSendMsgResult(hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                sgaVar = this.mJsBridge.onFetchHistoryMsgsResult(hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                sgaVar = this.mJsBridge.onReceiveNewMsgsResult(hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                sgaVar = this.mJsBridge.onKeyboardHeightChange(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                sgaVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (sgaVar != null) {
                sgaVar.z(0);
            }
            List<rga> list = this.mAsyncCallBackMethodList.get(str);
            if (sgaVar != null && list != null) {
                Iterator<rga> it = list.iterator();
                if (!di.isEmpty(sgaVar.e())) {
                    while (it.hasNext()) {
                        rga next = it.next();
                        if (next.b().equals(sgaVar.e())) {
                            sga sgaVar2 = new sga();
                            sgaVar2.w(next.a());
                            sgaVar2.y(sgaVar.f());
                            sgaVar2.u(sgaVar.b());
                            sgaVar2.o(sgaVar.a());
                            sgaVar2.A(sgaVar.l());
                            arrayList.add(sgaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rga next2 = it.next();
                        sga sgaVar3 = new sga();
                        sgaVar3.w(next2.a());
                        sgaVar3.y(sgaVar.f());
                        sgaVar3.u(sgaVar.b());
                        sgaVar3.o(sgaVar.a());
                        sgaVar3.A(sgaVar.l());
                        arrayList.add(sgaVar3);
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
