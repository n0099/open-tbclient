package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
import com.baidu.tieba.r0a;
import com.baidu.tieba.s0a;
import com.baidu.tieba.t0a;
import com.baidu.tieba.v0a;
import com.baidu.tieba.vi;
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
public class QuickWebViewBridge_Proxy extends r0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.r0a
    public t0a dispatch(v0a v0aVar, t0a t0aVar) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v0aVar, t0aVar)) == null) {
            t0a t0aVar2 = t0aVar == null ? new t0a() : t0aVar;
            String b = v0aVar.b();
            JSONObject e = v0aVar.e();
            if (b.equals("account/startLoginModule")) {
                t0aVar2.s(true);
                t0a startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    t0aVar2.y(startLoginModule.f());
                    t0aVar2.u(startLoginModule.b());
                    t0aVar2.o(startLoginModule.a());
                    t0aVar2.x(startLoginModule.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("account/authState")) {
                t0aVar2.s(true);
                t0a checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    t0aVar2.y(checkAuthState.f());
                    t0aVar2.u(checkAuthState.b());
                    t0aVar2.o(checkAuthState.a());
                    t0aVar2.x(checkAuthState.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                t0aVar2.s(true);
                t0a startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    t0aVar2.y(startAllLoginModule.f());
                    t0aVar2.u(startAllLoginModule.b());
                    t0aVar2.o(startAllLoginModule.a());
                    t0aVar2.x(startAllLoginModule.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver("commonLogin", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                t0aVar2.s(true);
                t0a realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    t0aVar2.y(realNameAuth.f());
                    t0aVar2.u(realNameAuth.b());
                    t0aVar2.o(realNameAuth.a());
                    t0aVar2.x(realNameAuth.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver("realNameAuthResult", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                t0aVar2.s(true);
                t0a finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    t0aVar2.y(finishPage.f());
                    t0aVar2.u(finishPage.b());
                    t0aVar2.o(finishPage.a());
                    t0aVar2.x(finishPage.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                t0aVar2.s(true);
                t0a showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    t0aVar2.y(showLowerHairHint.f());
                    t0aVar2.u(showLowerHairHint.b());
                    t0aVar2.o(showLowerHairHint.a());
                    t0aVar2.x(showLowerHairHint.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                t0aVar2.s(true);
                t0a gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    t0aVar2.y(gamePush.f());
                    t0aVar2.u(gamePush.b());
                    t0aVar2.o(gamePush.a());
                    t0aVar2.x(gamePush.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                t0aVar2.s(true);
                t0a handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    t0aVar2.y(handleGamePushStatus.f());
                    t0aVar2.u(handleGamePushStatus.b());
                    t0aVar2.o(handleGamePushStatus.a());
                    t0aVar2.x(handleGamePushStatus.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                t0aVar2.s(true);
                t0a jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    t0aVar2.y(jumpForumRulesEditPage.f());
                    t0aVar2.u(jumpForumRulesEditPage.b());
                    t0aVar2.o(jumpForumRulesEditPage.a());
                    t0aVar2.x(jumpForumRulesEditPage.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                t0aVar2.s(true);
                t0a handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    t0aVar2.y(handleGoToBarDetail.f());
                    t0aVar2.u(handleGoToBarDetail.b());
                    t0aVar2.o(handleGoToBarDetail.a());
                    t0aVar2.x(handleGoToBarDetail.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                t0aVar2.s(true);
                t0a handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    t0aVar2.y(handleSaveImage.f());
                    t0aVar2.u(handleSaveImage.b());
                    t0aVar2.o(handleSaveImage.a());
                    t0aVar2.x(handleSaveImage.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver("saveImageSuccess", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                t0aVar2.s(true);
                t0a orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    t0aVar2.y(orderGameApk.f());
                    t0aVar2.u(orderGameApk.b());
                    t0aVar2.o(orderGameApk.a());
                    t0aVar2.x(orderGameApk.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver("orderGameApkResult", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                t0aVar2.s(true);
                t0a handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    t0aVar2.y(handleGetPhotoAlbum.f());
                    t0aVar2.u(handleGetPhotoAlbum.b());
                    t0aVar2.o(handleGetPhotoAlbum.a());
                    t0aVar2.x(handleGetPhotoAlbum.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver("GetPhotoAlbum", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                t0aVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                t0a preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    t0aVar2.y(preheatWeb.f());
                    t0aVar2.u(preheatWeb.b());
                    t0aVar2.o(preheatWeb.a());
                    t0aVar2.x(preheatWeb.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                t0aVar2.s(true);
                t0a openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    t0aVar2.y(openMXDYab.f());
                    t0aVar2.u(openMXDYab.b());
                    t0aVar2.o(openMXDYab.a());
                    t0aVar2.x(openMXDYab.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/portal")) {
                t0aVar2.s(true);
                t0a handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    t0aVar2.y(handlePortal.f());
                    t0aVar2.u(handlePortal.b());
                    t0aVar2.o(handlePortal.a());
                    t0aVar2.x(handlePortal.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                t0aVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                t0a selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    t0aVar2.y(selectPhotoAlbum.f());
                    t0aVar2.u(selectPhotoAlbum.b());
                    t0aVar2.o(selectPhotoAlbum.a());
                    t0aVar2.x(selectPhotoAlbum.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver("selectPhotoAlbum", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                t0aVar2.s(true);
                t0a operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                if (operateNotifyDataChanged != null) {
                    t0aVar2.y(operateNotifyDataChanged.f());
                    t0aVar2.u(operateNotifyDataChanged.b());
                    t0aVar2.o(operateNotifyDataChanged.a());
                    t0aVar2.x(operateNotifyDataChanged.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                t0aVar2.s(true);
                t0a viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    t0aVar2.y(viewPosition.f());
                    t0aVar2.u(viewPosition.b());
                    t0aVar2.o(viewPosition.a());
                    t0aVar2.x(viewPosition.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                t0aVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                t0a selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    t0aVar2.y(selectPrivateMsg.f());
                    t0aVar2.u(selectPrivateMsg.b());
                    t0aVar2.o(selectPrivateMsg.a());
                    t0aVar2.x(selectPrivateMsg.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                t0aVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                t0a reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    t0aVar2.y(reportUserTheme.f());
                    t0aVar2.u(reportUserTheme.b());
                    t0aVar2.o(reportUserTheme.a());
                    t0aVar2.x(reportUserTheme.e());
                    if (!t0aVar2.h()) {
                        t0aVar2.n(false);
                        addObserver("goToReportThreadPage", t0aVar2, false);
                    }
                }
                t0aVar2.z(0);
            } else if (b.equals("system/playSound")) {
                t0aVar2.s(true);
                t0a playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    t0aVar2.y(playSound.f());
                    t0aVar2.u(playSound.b());
                    t0aVar2.o(playSound.a());
                    t0aVar2.x(playSound.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                t0aVar2.s(true);
                t0a playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    t0aVar2.y(playVibrate.f());
                    t0aVar2.u(playVibrate.b());
                    t0aVar2.o(playVibrate.a());
                    t0aVar2.x(playVibrate.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                t0aVar2.s(true);
                t0a jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    t0aVar2.y(jumpLoginActivity.f());
                    t0aVar2.u(jumpLoginActivity.b());
                    t0aVar2.o(jumpLoginActivity.a());
                    t0aVar2.x(jumpLoginActivity.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                t0aVar2.s(true);
                t0a startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    t0aVar2.y(startLoadTimeInterval.f());
                    t0aVar2.u(startLoadTimeInterval.b());
                    t0aVar2.o(startLoadTimeInterval.a());
                    t0aVar2.x(startLoadTimeInterval.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("device/getZid")) {
                t0aVar2.s(true);
                t0a zid = this.mJsBridge.getZid();
                if (zid != null) {
                    t0aVar2.y(zid.f());
                    t0aVar2.u(zid.b());
                    t0aVar2.o(zid.a());
                    t0aVar2.x(zid.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                t0aVar2.s(true);
                t0a hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    t0aVar2.y(hdid.f());
                    t0aVar2.u(hdid.b());
                    t0aVar2.o(hdid.a());
                    t0aVar2.x(hdid.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                t0aVar2.s(true);
                t0a shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    t0aVar2.y(shareInfo.f());
                    t0aVar2.u(shareInfo.b());
                    t0aVar2.o(shareInfo.a());
                    t0aVar2.x(shareInfo.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("share/share")) {
                t0aVar2.s(true);
                t0a share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    t0aVar2.y(share.f());
                    t0aVar2.u(share.b());
                    t0aVar2.o(share.a());
                    t0aVar2.x(share.e());
                    if (!t0aVar2.h()) {
                        i7 = 0;
                        t0aVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, t0aVar2, false);
                        t0aVar2.z(i7);
                    }
                }
                i7 = 0;
                t0aVar2.z(i7);
            } else if (b.equals("clipper/getClipperInformation")) {
                t0aVar2.s(true);
                t0a clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    t0aVar2.y(clipperInformation.f());
                    t0aVar2.u(clipperInformation.b());
                    t0aVar2.o(clipperInformation.a());
                    t0aVar2.x(clipperInformation.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                t0aVar2.s(true);
                t0a clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    t0aVar2.y(clipperInformation2.f());
                    t0aVar2.u(clipperInformation2.b());
                    t0aVar2.o(clipperInformation2.a());
                    t0aVar2.x(clipperInformation2.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                t0aVar2.s(true);
                t0a goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    t0aVar2.y(goToEditPost.f());
                    t0aVar2.u(goToEditPost.b());
                    t0aVar2.o(goToEditPost.a());
                    t0aVar2.x(goToEditPost.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                t0aVar2.s(true);
                t0a updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    t0aVar2.y(updateSearchForumInfo.f());
                    t0aVar2.u(updateSearchForumInfo.b());
                    t0aVar2.o(updateSearchForumInfo.a());
                    t0aVar2.x(updateSearchForumInfo.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                t0aVar2.s(true);
                t0a personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    t0aVar2.y(personlizedSwitchChange.f());
                    t0aVar2.u(personlizedSwitchChange.b());
                    t0aVar2.o(personlizedSwitchChange.a());
                    t0aVar2.x(personlizedSwitchChange.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                t0aVar2.s(true);
                t0a updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    t0aVar2.y(updateTailStyle.f());
                    t0aVar2.u(updateTailStyle.b());
                    t0aVar2.o(updateTailStyle.a());
                    t0aVar2.x(updateTailStyle.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                t0aVar2.s(true);
                t0a goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    t0aVar2.y(goToVideoImmersivePage.f());
                    t0aVar2.u(goToVideoImmersivePage.b());
                    t0aVar2.o(goToVideoImmersivePage.a());
                    t0aVar2.x(goToVideoImmersivePage.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                t0aVar2.s(true);
                t0a jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    t0aVar2.y(jumpToVideo.f());
                    t0aVar2.u(jumpToVideo.b());
                    t0aVar2.o(jumpToVideo.a());
                    t0aVar2.x(jumpToVideo.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                t0aVar2.s(true);
                t0a closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    t0aVar2.y(closeNativeMask.f());
                    t0aVar2.u(closeNativeMask.b());
                    t0aVar2.o(closeNativeMask.a());
                    t0aVar2.x(closeNativeMask.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                t0aVar2.s(true);
                t0a oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    t0aVar2.y(oneKeyDeletion.f());
                    t0aVar2.u(oneKeyDeletion.b());
                    t0aVar2.o(oneKeyDeletion.a());
                    t0aVar2.x(oneKeyDeletion.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                t0aVar2.s(true);
                t0a checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    t0aVar2.y(checkAppInstall.f());
                    t0aVar2.u(checkAppInstall.b());
                    t0aVar2.o(checkAppInstall.a());
                    t0aVar2.x(checkAppInstall.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                t0aVar2.s(true);
                t0a disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    t0aVar2.y(disableBack.f());
                    t0aVar2.u(disableBack.b());
                    t0aVar2.o(disableBack.a());
                    t0aVar2.x(disableBack.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/startApp")) {
                t0aVar2.s(true);
                t0a startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    t0aVar2.y(startApp.f());
                    t0aVar2.u(startApp.b());
                    t0aVar2.o(startApp.a());
                    t0aVar2.x(startApp.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                t0aVar2.s(true);
                t0a hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    t0aVar2.y(hasNotificationPermission.f());
                    t0aVar2.u(hasNotificationPermission.b());
                    t0aVar2.o(hasNotificationPermission.a());
                    t0aVar2.x(hasNotificationPermission.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                t0aVar2.s(true);
                t0a goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    t0aVar2.y(goToNotificationSetting.f());
                    t0aVar2.u(goToNotificationSetting.b());
                    t0aVar2.o(goToNotificationSetting.a());
                    t0aVar2.x(goToNotificationSetting.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                t0aVar2.s(true);
                t0a startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    t0aVar2.y(startDownloadGameApk.f());
                    t0aVar2.u(startDownloadGameApk.b());
                    t0aVar2.o(startDownloadGameApk.a());
                    t0aVar2.x(startDownloadGameApk.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                t0aVar2.s(true);
                t0a checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    t0aVar2.y(checkInstallGameApk.f());
                    t0aVar2.u(checkInstallGameApk.b());
                    t0aVar2.o(checkInstallGameApk.a());
                    t0aVar2.x(checkInstallGameApk.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                t0aVar2.s(true);
                t0a startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    t0aVar2.y(startDownloadCss.f());
                    t0aVar2.u(startDownloadCss.b());
                    t0aVar2.o(startDownloadCss.a());
                    t0aVar2.x(startDownloadCss.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                t0aVar2.s(true);
                t0a disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    t0aVar2.y(disableGoBack.f());
                    t0aVar2.u(disableGoBack.b());
                    t0aVar2.o(disableGoBack.a());
                    t0aVar2.x(disableGoBack.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                t0aVar2.s(true);
                t0a supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    t0aVar2.y(supplementInfo.f());
                    t0aVar2.u(supplementInfo.b());
                    t0aVar2.o(supplementInfo.a());
                    t0aVar2.x(supplementInfo.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                t0aVar2.s(true);
                t0a deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    t0aVar2.y(deviceGyroscopeParams.f());
                    t0aVar2.u(deviceGyroscopeParams.b());
                    t0aVar2.o(deviceGyroscopeParams.a());
                    t0aVar2.x(deviceGyroscopeParams.e());
                    if (!t0aVar2.h()) {
                        i6 = 0;
                        t0aVar2.n(false);
                        addObserver("deviceMotion", t0aVar2, false);
                        t0aVar2.z(i6);
                    }
                }
                i6 = 0;
                t0aVar2.z(i6);
            } else if (b.equals("device/deviceRefreshRate")) {
                t0aVar2.s(true);
                t0a deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    t0aVar2.y(deviceRefreshRateParams.f());
                    t0aVar2.u(deviceRefreshRateParams.b());
                    t0aVar2.o(deviceRefreshRateParams.a());
                    t0aVar2.x(deviceRefreshRateParams.e());
                    if (!t0aVar2.h()) {
                        i5 = 0;
                        t0aVar2.n(false);
                        addObserver("deviceRefreshRate", t0aVar2, false);
                        t0aVar2.z(i5);
                    }
                }
                i5 = 0;
                t0aVar2.z(i5);
            } else if (b.equals("device/getDeviceInfo")) {
                t0aVar2.s(true);
                t0a deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    t0aVar2.y(deviceInfo.f());
                    t0aVar2.u(deviceInfo.b());
                    t0aVar2.o(deviceInfo.a());
                    t0aVar2.x(deviceInfo.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                t0aVar2.s(true);
                t0a sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    t0aVar2.y(sendCompleteTaskReqMsg.f());
                    t0aVar2.u(sendCompleteTaskReqMsg.b());
                    t0aVar2.o(sendCompleteTaskReqMsg.a());
                    t0aVar2.x(sendCompleteTaskReqMsg.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                t0aVar2.s(true);
                t0a showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    t0aVar2.y(showTipToast.f());
                    t0aVar2.u(showTipToast.b());
                    t0aVar2.o(showTipToast.a());
                    t0aVar2.x(showTipToast.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                t0aVar2.s(true);
                t0a getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    t0aVar2.y(getModalData.f());
                    t0aVar2.u(getModalData.b());
                    t0aVar2.o(getModalData.a());
                    t0aVar2.x(getModalData.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                t0aVar2.s(true);
                t0a openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    t0aVar2.y(openThirdPartApp.f());
                    t0aVar2.u(openThirdPartApp.b());
                    t0aVar2.o(openThirdPartApp.a());
                    t0aVar2.x(openThirdPartApp.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                t0aVar2.s(true);
                t0a jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    t0aVar2.y(jumpToHtmlPage.f());
                    t0aVar2.u(jumpToHtmlPage.b());
                    t0aVar2.o(jumpToHtmlPage.a());
                    t0aVar2.x(jumpToHtmlPage.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                t0aVar2.s(true);
                t0a offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    t0aVar2.y(offlineUserInfo.f());
                    t0aVar2.u(offlineUserInfo.b());
                    t0aVar2.o(offlineUserInfo.a());
                    t0aVar2.x(offlineUserInfo.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                t0aVar2.s(true);
                t0a deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    t0aVar2.y(deleteOfflineBundle.f());
                    t0aVar2.u(deleteOfflineBundle.b());
                    t0aVar2.o(deleteOfflineBundle.a());
                    t0aVar2.x(deleteOfflineBundle.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                t0aVar2.s(true);
                t0a updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    t0aVar2.y(updateOfflineBundle.f());
                    t0aVar2.u(updateOfflineBundle.b());
                    t0aVar2.o(updateOfflineBundle.a());
                    t0aVar2.x(updateOfflineBundle.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                t0aVar2.s(true);
                t0a switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    t0aVar2.y(switchOfflineInterface.f());
                    t0aVar2.u(switchOfflineInterface.b());
                    t0aVar2.o(switchOfflineInterface.a());
                    t0aVar2.x(switchOfflineInterface.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                t0aVar2.s(true);
                t0a switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    t0aVar2.y(switchOfflineBundleStatus.f());
                    t0aVar2.u(switchOfflineBundleStatus.b());
                    t0aVar2.o(switchOfflineBundleStatus.a());
                    t0aVar2.x(switchOfflineBundleStatus.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                t0aVar2.s(true);
                t0a finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    t0aVar2.y(finishTestAnswer.f());
                    t0aVar2.u(finishTestAnswer.b());
                    t0aVar2.o(finishTestAnswer.a());
                    t0aVar2.x(finishTestAnswer.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                t0aVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                t0a switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    t0aVar2.y(switchUrlHost.f());
                    t0aVar2.u(switchUrlHost.b());
                    t0aVar2.o(switchUrlHost.a());
                    t0aVar2.x(switchUrlHost.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                t0aVar2.s(true);
                t0a appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    t0aVar2.y(appStorage.f());
                    t0aVar2.u(appStorage.b());
                    t0aVar2.o(appStorage.a());
                    t0aVar2.x(appStorage.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                t0aVar2.s(true);
                t0a putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    t0aVar2.y(putAppStorage.f());
                    t0aVar2.u(putAppStorage.b());
                    t0aVar2.o(putAppStorage.a());
                    t0aVar2.x(putAppStorage.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                t0aVar2.s(true);
                t0a historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    t0aVar2.y(historyForumData.f());
                    t0aVar2.u(historyForumData.b());
                    t0aVar2.o(historyForumData.a());
                    t0aVar2.x(historyForumData.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                t0aVar2.s(true);
                t0a worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    t0aVar2.y(worldCupRaiseSuccess.f());
                    t0aVar2.u(worldCupRaiseSuccess.b());
                    t0aVar2.o(worldCupRaiseSuccess.a());
                    t0aVar2.x(worldCupRaiseSuccess.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                t0aVar2.s(true);
                t0a alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    t0aVar2.y(alipayUserId.f());
                    t0aVar2.u(alipayUserId.b());
                    t0aVar2.o(alipayUserId.a());
                    t0aVar2.x(alipayUserId.e());
                    if (!t0aVar2.h()) {
                        i4 = 0;
                        t0aVar2.n(false);
                        addObserver("aliAuthResult", t0aVar2, false);
                        t0aVar2.z(i4);
                    }
                }
                i4 = 0;
                t0aVar2.z(i4);
            } else if (b.equals("system/getFileDownloadStatus")) {
                t0aVar2.s(true);
                t0a fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    t0aVar2.y(fileDownloadStatus.f());
                    t0aVar2.u(fileDownloadStatus.b());
                    t0aVar2.o(fileDownloadStatus.a());
                    t0aVar2.x(fileDownloadStatus.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                t0aVar2.s(true);
                t0a fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    t0aVar2.y(fileDownloadProgress.f());
                    t0aVar2.u(fileDownloadProgress.b());
                    t0aVar2.o(fileDownloadProgress.a());
                    t0aVar2.x(fileDownloadProgress.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                t0aVar2.s(true);
                t0a fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    t0aVar2.y(fileDownloadPause.f());
                    t0aVar2.u(fileDownloadPause.b());
                    t0aVar2.o(fileDownloadPause.a());
                    t0aVar2.x(fileDownloadPause.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                t0aVar2.s(true);
                t0a fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    t0aVar2.y(fileDownloadDelete.f());
                    t0aVar2.u(fileDownloadDelete.b());
                    t0aVar2.o(fileDownloadDelete.a());
                    t0aVar2.x(fileDownloadDelete.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                t0aVar2.s(true);
                t0a installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    t0aVar2.y(installGameApk.f());
                    t0aVar2.u(installGameApk.b());
                    t0aVar2.o(installGameApk.a());
                    t0aVar2.x(installGameApk.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                t0aVar2.s(true);
                t0a launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    t0aVar2.y(launchApk.f());
                    t0aVar2.u(launchApk.b());
                    t0aVar2.o(launchApk.a());
                    t0aVar2.x(launchApk.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                t0aVar2.s(true);
                t0a wakeKeyboard = this.mJsBridge.wakeKeyboard();
                if (wakeKeyboard != null) {
                    t0aVar2.y(wakeKeyboard.f());
                    t0aVar2.u(wakeKeyboard.b());
                    t0aVar2.o(wakeKeyboard.a());
                    t0aVar2.x(wakeKeyboard.e());
                }
                t0aVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                t0aVar2.s(true);
                t0a replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    t0aVar2.y(replyPost.f());
                    t0aVar2.u(replyPost.b());
                    t0aVar2.o(replyPost.a());
                    t0aVar2.x(replyPost.e());
                    if (!t0aVar2.h()) {
                        i3 = 0;
                        t0aVar2.n(false);
                        addObserver("replyPostResult", t0aVar2, false);
                        t0aVar2.z(i3);
                    }
                }
                i3 = 0;
                t0aVar2.z(i3);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                t0aVar2.s(true);
                t0a nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    t0aVar2.y(nativeNetworkProxy.f());
                    t0aVar2.u(nativeNetworkProxy.b());
                    t0aVar2.o(nativeNetworkProxy.a());
                    t0aVar2.x(nativeNetworkProxy.e());
                    if (!t0aVar2.h()) {
                        i2 = 0;
                        t0aVar2.n(false);
                        addObserver("nativeNetworkProxyResult", t0aVar2, false);
                        t0aVar2.z(i2);
                    }
                }
                i2 = 0;
                t0aVar2.z(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                t0aVar2.s(true);
                t0a requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    t0aVar2.y(requestByNative.f());
                    t0aVar2.u(requestByNative.b());
                    t0aVar2.o(requestByNative.a());
                    t0aVar2.x(requestByNative.e());
                    if (!t0aVar2.h()) {
                        i = 0;
                        t0aVar2.n(false);
                        addObserver("RequestByNativeToH5", t0aVar2, false);
                        t0aVar2.z(i);
                    }
                }
                i = 0;
                t0aVar2.z(i);
            }
            return t0aVar2;
        }
        return (t0a) invokeLL.objValue;
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
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.r0a
    public List<t0a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            t0a t0aVar = null;
            if (vi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                t0aVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                t0aVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                t0aVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                t0aVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                t0aVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                t0aVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                t0aVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                t0aVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                t0aVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                t0aVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                t0aVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                t0aVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                t0aVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                t0aVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                t0aVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                t0aVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                t0aVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                t0aVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                t0aVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                t0aVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                t0aVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                t0aVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                t0aVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                t0aVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                t0aVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                t0aVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                t0aVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                t0aVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                t0aVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                t0aVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (t0aVar != null) {
                t0aVar.z(0);
            }
            List<s0a> list = this.mAsyncCallBackMethodList.get(str);
            if (t0aVar != null && list != null) {
                Iterator<s0a> it = list.iterator();
                if (!vi.isEmpty(t0aVar.e())) {
                    while (it.hasNext()) {
                        s0a next = it.next();
                        if (next.b().equals(t0aVar.e())) {
                            t0a t0aVar2 = new t0a();
                            t0aVar2.w(next.a());
                            t0aVar2.y(t0aVar.f());
                            t0aVar2.u(t0aVar.b());
                            t0aVar2.o(t0aVar.a());
                            t0aVar2.A(t0aVar.l());
                            arrayList.add(t0aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        s0a next2 = it.next();
                        t0a t0aVar3 = new t0a();
                        t0aVar3.w(next2.a());
                        t0aVar3.y(t0aVar.f());
                        t0aVar3.u(t0aVar.b());
                        t0aVar3.o(t0aVar.a());
                        t0aVar3.A(t0aVar.l());
                        arrayList.add(t0aVar3);
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
