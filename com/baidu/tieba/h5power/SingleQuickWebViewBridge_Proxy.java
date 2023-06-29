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
import com.baidu.tieba.d5a;
import com.baidu.tieba.e5a;
import com.baidu.tieba.f5a;
import com.baidu.tieba.h5a;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.wi;
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
public class SingleQuickWebViewBridge_Proxy extends d5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.d5a
    public f5a dispatch(h5a h5aVar, f5a f5aVar) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, h5aVar, f5aVar)) == null) {
            f5a f5aVar2 = f5aVar == null ? new f5a() : f5aVar;
            String b = h5aVar.b();
            JSONObject e = h5aVar.e();
            if (b.equals("account/startLoginModule")) {
                f5aVar2.s(true);
                f5a startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    f5aVar2.y(startLoginModule.f());
                    f5aVar2.u(startLoginModule.b());
                    f5aVar2.o(startLoginModule.a());
                    f5aVar2.x(startLoginModule.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("account/authState")) {
                f5aVar2.s(true);
                f5a checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    f5aVar2.y(checkAuthState.f());
                    f5aVar2.u(checkAuthState.b());
                    f5aVar2.o(checkAuthState.a());
                    f5aVar2.x(checkAuthState.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                f5aVar2.s(true);
                f5a startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    f5aVar2.y(startAllLoginModule.f());
                    f5aVar2.u(startAllLoginModule.b());
                    f5aVar2.o(startAllLoginModule.a());
                    f5aVar2.x(startAllLoginModule.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver("commonLogin", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                f5aVar2.s(true);
                f5a realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    f5aVar2.y(realNameAuth.f());
                    f5aVar2.u(realNameAuth.b());
                    f5aVar2.o(realNameAuth.a());
                    f5aVar2.x(realNameAuth.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver("realNameAuthResult", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                f5aVar2.s(true);
                f5a finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    f5aVar2.y(finishPage.f());
                    f5aVar2.u(finishPage.b());
                    f5aVar2.o(finishPage.a());
                    f5aVar2.x(finishPage.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                f5aVar2.s(true);
                f5a showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    f5aVar2.y(showLowerHairHint.f());
                    f5aVar2.u(showLowerHairHint.b());
                    f5aVar2.o(showLowerHairHint.a());
                    f5aVar2.x(showLowerHairHint.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                f5aVar2.s(true);
                f5a gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    f5aVar2.y(gamePush.f());
                    f5aVar2.u(gamePush.b());
                    f5aVar2.o(gamePush.a());
                    f5aVar2.x(gamePush.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                f5aVar2.s(true);
                f5a handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    f5aVar2.y(handleGamePushStatus.f());
                    f5aVar2.u(handleGamePushStatus.b());
                    f5aVar2.o(handleGamePushStatus.a());
                    f5aVar2.x(handleGamePushStatus.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                f5aVar2.s(true);
                f5a jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    f5aVar2.y(jumpForumRulesEditPage.f());
                    f5aVar2.u(jumpForumRulesEditPage.b());
                    f5aVar2.o(jumpForumRulesEditPage.a());
                    f5aVar2.x(jumpForumRulesEditPage.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                f5aVar2.s(true);
                f5a handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    f5aVar2.y(handleGoToBarDetail.f());
                    f5aVar2.u(handleGoToBarDetail.b());
                    f5aVar2.o(handleGoToBarDetail.a());
                    f5aVar2.x(handleGoToBarDetail.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                f5aVar2.s(true);
                f5a handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    f5aVar2.y(handleSaveImage.f());
                    f5aVar2.u(handleSaveImage.b());
                    f5aVar2.o(handleSaveImage.a());
                    f5aVar2.x(handleSaveImage.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver("saveImageSuccess", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                f5aVar2.s(true);
                f5a orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    f5aVar2.y(orderGameApk.f());
                    f5aVar2.u(orderGameApk.b());
                    f5aVar2.o(orderGameApk.a());
                    f5aVar2.x(orderGameApk.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver("orderGameApkResult", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                f5aVar2.s(true);
                f5a handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    f5aVar2.y(handleGetPhotoAlbum.f());
                    f5aVar2.u(handleGetPhotoAlbum.b());
                    f5aVar2.o(handleGetPhotoAlbum.a());
                    f5aVar2.x(handleGetPhotoAlbum.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver("GetPhotoAlbum", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                f5aVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                f5a preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    f5aVar2.y(preheatWeb.f());
                    f5aVar2.u(preheatWeb.b());
                    f5aVar2.o(preheatWeb.a());
                    f5aVar2.x(preheatWeb.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                f5aVar2.s(true);
                f5a openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    f5aVar2.y(openMXDYab.f());
                    f5aVar2.u(openMXDYab.b());
                    f5aVar2.o(openMXDYab.a());
                    f5aVar2.x(openMXDYab.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/portal")) {
                f5aVar2.s(true);
                f5a handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    f5aVar2.y(handlePortal.f());
                    f5aVar2.u(handlePortal.b());
                    f5aVar2.o(handlePortal.a());
                    f5aVar2.x(handlePortal.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                f5aVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                f5a selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    f5aVar2.y(selectPhotoAlbum.f());
                    f5aVar2.u(selectPhotoAlbum.b());
                    f5aVar2.o(selectPhotoAlbum.a());
                    f5aVar2.x(selectPhotoAlbum.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver("selectPhotoAlbum", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                f5aVar2.s(true);
                f5a operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                if (operateNotifyDataChanged != null) {
                    f5aVar2.y(operateNotifyDataChanged.f());
                    f5aVar2.u(operateNotifyDataChanged.b());
                    f5aVar2.o(operateNotifyDataChanged.a());
                    f5aVar2.x(operateNotifyDataChanged.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                f5aVar2.s(true);
                f5a viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    f5aVar2.y(viewPosition.f());
                    f5aVar2.u(viewPosition.b());
                    f5aVar2.o(viewPosition.a());
                    f5aVar2.x(viewPosition.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                f5aVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                f5a selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    f5aVar2.y(selectPrivateMsg.f());
                    f5aVar2.u(selectPrivateMsg.b());
                    f5aVar2.o(selectPrivateMsg.a());
                    f5aVar2.x(selectPrivateMsg.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                f5aVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                f5a reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    f5aVar2.y(reportUserTheme.f());
                    f5aVar2.u(reportUserTheme.b());
                    f5aVar2.o(reportUserTheme.a());
                    f5aVar2.x(reportUserTheme.e());
                    if (!f5aVar2.h()) {
                        f5aVar2.n(false);
                        addObserver("goToReportThreadPage", f5aVar2, false);
                    }
                }
                f5aVar2.z(0);
            } else if (b.equals("system/playSound")) {
                f5aVar2.s(true);
                f5a playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    f5aVar2.y(playSound.f());
                    f5aVar2.u(playSound.b());
                    f5aVar2.o(playSound.a());
                    f5aVar2.x(playSound.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                f5aVar2.s(true);
                f5a playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    f5aVar2.y(playVibrate.f());
                    f5aVar2.u(playVibrate.b());
                    f5aVar2.o(playVibrate.a());
                    f5aVar2.x(playVibrate.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                f5aVar2.s(true);
                f5a jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    f5aVar2.y(jumpLoginActivity.f());
                    f5aVar2.u(jumpLoginActivity.b());
                    f5aVar2.o(jumpLoginActivity.a());
                    f5aVar2.x(jumpLoginActivity.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                f5aVar2.s(true);
                f5a startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    f5aVar2.y(startLoadTimeInterval.f());
                    f5aVar2.u(startLoadTimeInterval.b());
                    f5aVar2.o(startLoadTimeInterval.a());
                    f5aVar2.x(startLoadTimeInterval.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("device/getZid")) {
                f5aVar2.s(true);
                f5a zid = this.mJsBridge.getZid();
                if (zid != null) {
                    f5aVar2.y(zid.f());
                    f5aVar2.u(zid.b());
                    f5aVar2.o(zid.a());
                    f5aVar2.x(zid.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                f5aVar2.s(true);
                f5a hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    f5aVar2.y(hdid.f());
                    f5aVar2.u(hdid.b());
                    f5aVar2.o(hdid.a());
                    f5aVar2.x(hdid.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                f5aVar2.s(true);
                f5a shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    f5aVar2.y(shareInfo.f());
                    f5aVar2.u(shareInfo.b());
                    f5aVar2.o(shareInfo.a());
                    f5aVar2.x(shareInfo.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("share/share")) {
                f5aVar2.s(true);
                f5a share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    f5aVar2.y(share.f());
                    f5aVar2.u(share.b());
                    f5aVar2.o(share.a());
                    f5aVar2.x(share.e());
                    if (!f5aVar2.h()) {
                        i7 = 0;
                        f5aVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, f5aVar2, false);
                        f5aVar2.z(i7);
                    }
                }
                i7 = 0;
                f5aVar2.z(i7);
            } else if (b.equals("clipper/getClipperInformation")) {
                f5aVar2.s(true);
                f5a clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    f5aVar2.y(clipperInformation.f());
                    f5aVar2.u(clipperInformation.b());
                    f5aVar2.o(clipperInformation.a());
                    f5aVar2.x(clipperInformation.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                f5aVar2.s(true);
                f5a clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    f5aVar2.y(clipperInformation2.f());
                    f5aVar2.u(clipperInformation2.b());
                    f5aVar2.o(clipperInformation2.a());
                    f5aVar2.x(clipperInformation2.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                f5aVar2.s(true);
                f5a goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    f5aVar2.y(goToEditPost.f());
                    f5aVar2.u(goToEditPost.b());
                    f5aVar2.o(goToEditPost.a());
                    f5aVar2.x(goToEditPost.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                f5aVar2.s(true);
                f5a updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    f5aVar2.y(updateSearchForumInfo.f());
                    f5aVar2.u(updateSearchForumInfo.b());
                    f5aVar2.o(updateSearchForumInfo.a());
                    f5aVar2.x(updateSearchForumInfo.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                f5aVar2.s(true);
                f5a personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    f5aVar2.y(personlizedSwitchChange.f());
                    f5aVar2.u(personlizedSwitchChange.b());
                    f5aVar2.o(personlizedSwitchChange.a());
                    f5aVar2.x(personlizedSwitchChange.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                f5aVar2.s(true);
                f5a updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    f5aVar2.y(updateTailStyle.f());
                    f5aVar2.u(updateTailStyle.b());
                    f5aVar2.o(updateTailStyle.a());
                    f5aVar2.x(updateTailStyle.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                f5aVar2.s(true);
                f5a goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    f5aVar2.y(goToVideoImmersivePage.f());
                    f5aVar2.u(goToVideoImmersivePage.b());
                    f5aVar2.o(goToVideoImmersivePage.a());
                    f5aVar2.x(goToVideoImmersivePage.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                f5aVar2.s(true);
                f5a jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    f5aVar2.y(jumpToVideo.f());
                    f5aVar2.u(jumpToVideo.b());
                    f5aVar2.o(jumpToVideo.a());
                    f5aVar2.x(jumpToVideo.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                f5aVar2.s(true);
                f5a closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    f5aVar2.y(closeNativeMask.f());
                    f5aVar2.u(closeNativeMask.b());
                    f5aVar2.o(closeNativeMask.a());
                    f5aVar2.x(closeNativeMask.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                f5aVar2.s(true);
                f5a oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    f5aVar2.y(oneKeyDeletion.f());
                    f5aVar2.u(oneKeyDeletion.b());
                    f5aVar2.o(oneKeyDeletion.a());
                    f5aVar2.x(oneKeyDeletion.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                f5aVar2.s(true);
                f5a checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    f5aVar2.y(checkAppInstall.f());
                    f5aVar2.u(checkAppInstall.b());
                    f5aVar2.o(checkAppInstall.a());
                    f5aVar2.x(checkAppInstall.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                f5aVar2.s(true);
                f5a disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    f5aVar2.y(disableBack.f());
                    f5aVar2.u(disableBack.b());
                    f5aVar2.o(disableBack.a());
                    f5aVar2.x(disableBack.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/startApp")) {
                f5aVar2.s(true);
                f5a startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    f5aVar2.y(startApp.f());
                    f5aVar2.u(startApp.b());
                    f5aVar2.o(startApp.a());
                    f5aVar2.x(startApp.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                f5aVar2.s(true);
                f5a hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    f5aVar2.y(hasNotificationPermission.f());
                    f5aVar2.u(hasNotificationPermission.b());
                    f5aVar2.o(hasNotificationPermission.a());
                    f5aVar2.x(hasNotificationPermission.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                f5aVar2.s(true);
                f5a goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    f5aVar2.y(goToNotificationSetting.f());
                    f5aVar2.u(goToNotificationSetting.b());
                    f5aVar2.o(goToNotificationSetting.a());
                    f5aVar2.x(goToNotificationSetting.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                f5aVar2.s(true);
                f5a startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    f5aVar2.y(startDownloadGameApk.f());
                    f5aVar2.u(startDownloadGameApk.b());
                    f5aVar2.o(startDownloadGameApk.a());
                    f5aVar2.x(startDownloadGameApk.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                f5aVar2.s(true);
                f5a checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    f5aVar2.y(checkInstallGameApk.f());
                    f5aVar2.u(checkInstallGameApk.b());
                    f5aVar2.o(checkInstallGameApk.a());
                    f5aVar2.x(checkInstallGameApk.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                f5aVar2.s(true);
                f5a startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    f5aVar2.y(startDownloadCss.f());
                    f5aVar2.u(startDownloadCss.b());
                    f5aVar2.o(startDownloadCss.a());
                    f5aVar2.x(startDownloadCss.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                f5aVar2.s(true);
                f5a disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    f5aVar2.y(disableGoBack.f());
                    f5aVar2.u(disableGoBack.b());
                    f5aVar2.o(disableGoBack.a());
                    f5aVar2.x(disableGoBack.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                f5aVar2.s(true);
                f5a supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    f5aVar2.y(supplementInfo.f());
                    f5aVar2.u(supplementInfo.b());
                    f5aVar2.o(supplementInfo.a());
                    f5aVar2.x(supplementInfo.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                f5aVar2.s(true);
                f5a deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    f5aVar2.y(deviceGyroscopeParams.f());
                    f5aVar2.u(deviceGyroscopeParams.b());
                    f5aVar2.o(deviceGyroscopeParams.a());
                    f5aVar2.x(deviceGyroscopeParams.e());
                    if (!f5aVar2.h()) {
                        i6 = 0;
                        f5aVar2.n(false);
                        addObserver("deviceMotion", f5aVar2, false);
                        f5aVar2.z(i6);
                    }
                }
                i6 = 0;
                f5aVar2.z(i6);
            } else if (b.equals("device/deviceRefreshRate")) {
                f5aVar2.s(true);
                f5a deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    f5aVar2.y(deviceRefreshRateParams.f());
                    f5aVar2.u(deviceRefreshRateParams.b());
                    f5aVar2.o(deviceRefreshRateParams.a());
                    f5aVar2.x(deviceRefreshRateParams.e());
                    if (!f5aVar2.h()) {
                        i5 = 0;
                        f5aVar2.n(false);
                        addObserver("deviceRefreshRate", f5aVar2, false);
                        f5aVar2.z(i5);
                    }
                }
                i5 = 0;
                f5aVar2.z(i5);
            } else if (b.equals("device/getDeviceInfo")) {
                f5aVar2.s(true);
                f5a deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    f5aVar2.y(deviceInfo.f());
                    f5aVar2.u(deviceInfo.b());
                    f5aVar2.o(deviceInfo.a());
                    f5aVar2.x(deviceInfo.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                f5aVar2.s(true);
                f5a sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    f5aVar2.y(sendCompleteTaskReqMsg.f());
                    f5aVar2.u(sendCompleteTaskReqMsg.b());
                    f5aVar2.o(sendCompleteTaskReqMsg.a());
                    f5aVar2.x(sendCompleteTaskReqMsg.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                f5aVar2.s(true);
                f5a showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    f5aVar2.y(showTipToast.f());
                    f5aVar2.u(showTipToast.b());
                    f5aVar2.o(showTipToast.a());
                    f5aVar2.x(showTipToast.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                f5aVar2.s(true);
                f5a getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    f5aVar2.y(getModalData.f());
                    f5aVar2.u(getModalData.b());
                    f5aVar2.o(getModalData.a());
                    f5aVar2.x(getModalData.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                f5aVar2.s(true);
                f5a openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    f5aVar2.y(openThirdPartApp.f());
                    f5aVar2.u(openThirdPartApp.b());
                    f5aVar2.o(openThirdPartApp.a());
                    f5aVar2.x(openThirdPartApp.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                f5aVar2.s(true);
                f5a jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    f5aVar2.y(jumpToHtmlPage.f());
                    f5aVar2.u(jumpToHtmlPage.b());
                    f5aVar2.o(jumpToHtmlPage.a());
                    f5aVar2.x(jumpToHtmlPage.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                f5aVar2.s(true);
                f5a offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    f5aVar2.y(offlineUserInfo.f());
                    f5aVar2.u(offlineUserInfo.b());
                    f5aVar2.o(offlineUserInfo.a());
                    f5aVar2.x(offlineUserInfo.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                f5aVar2.s(true);
                f5a deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    f5aVar2.y(deleteOfflineBundle.f());
                    f5aVar2.u(deleteOfflineBundle.b());
                    f5aVar2.o(deleteOfflineBundle.a());
                    f5aVar2.x(deleteOfflineBundle.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                f5aVar2.s(true);
                f5a updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    f5aVar2.y(updateOfflineBundle.f());
                    f5aVar2.u(updateOfflineBundle.b());
                    f5aVar2.o(updateOfflineBundle.a());
                    f5aVar2.x(updateOfflineBundle.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                f5aVar2.s(true);
                f5a switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    f5aVar2.y(switchOfflineInterface.f());
                    f5aVar2.u(switchOfflineInterface.b());
                    f5aVar2.o(switchOfflineInterface.a());
                    f5aVar2.x(switchOfflineInterface.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                f5aVar2.s(true);
                f5a switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    f5aVar2.y(switchOfflineBundleStatus.f());
                    f5aVar2.u(switchOfflineBundleStatus.b());
                    f5aVar2.o(switchOfflineBundleStatus.a());
                    f5aVar2.x(switchOfflineBundleStatus.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                f5aVar2.s(true);
                f5a finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    f5aVar2.y(finishTestAnswer.f());
                    f5aVar2.u(finishTestAnswer.b());
                    f5aVar2.o(finishTestAnswer.a());
                    f5aVar2.x(finishTestAnswer.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                f5aVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                f5a switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    f5aVar2.y(switchUrlHost.f());
                    f5aVar2.u(switchUrlHost.b());
                    f5aVar2.o(switchUrlHost.a());
                    f5aVar2.x(switchUrlHost.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                f5aVar2.s(true);
                f5a appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    f5aVar2.y(appStorage.f());
                    f5aVar2.u(appStorage.b());
                    f5aVar2.o(appStorage.a());
                    f5aVar2.x(appStorage.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                f5aVar2.s(true);
                f5a putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    f5aVar2.y(putAppStorage.f());
                    f5aVar2.u(putAppStorage.b());
                    f5aVar2.o(putAppStorage.a());
                    f5aVar2.x(putAppStorage.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                f5aVar2.s(true);
                f5a historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    f5aVar2.y(historyForumData.f());
                    f5aVar2.u(historyForumData.b());
                    f5aVar2.o(historyForumData.a());
                    f5aVar2.x(historyForumData.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                f5aVar2.s(true);
                f5a worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    f5aVar2.y(worldCupRaiseSuccess.f());
                    f5aVar2.u(worldCupRaiseSuccess.b());
                    f5aVar2.o(worldCupRaiseSuccess.a());
                    f5aVar2.x(worldCupRaiseSuccess.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                f5aVar2.s(true);
                f5a alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    f5aVar2.y(alipayUserId.f());
                    f5aVar2.u(alipayUserId.b());
                    f5aVar2.o(alipayUserId.a());
                    f5aVar2.x(alipayUserId.e());
                    if (!f5aVar2.h()) {
                        i4 = 0;
                        f5aVar2.n(false);
                        addObserver("aliAuthResult", f5aVar2, false);
                        f5aVar2.z(i4);
                    }
                }
                i4 = 0;
                f5aVar2.z(i4);
            } else if (b.equals("system/getFileDownloadStatus")) {
                f5aVar2.s(true);
                f5a fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    f5aVar2.y(fileDownloadStatus.f());
                    f5aVar2.u(fileDownloadStatus.b());
                    f5aVar2.o(fileDownloadStatus.a());
                    f5aVar2.x(fileDownloadStatus.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                f5aVar2.s(true);
                f5a fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    f5aVar2.y(fileDownloadProgress.f());
                    f5aVar2.u(fileDownloadProgress.b());
                    f5aVar2.o(fileDownloadProgress.a());
                    f5aVar2.x(fileDownloadProgress.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                f5aVar2.s(true);
                f5a fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    f5aVar2.y(fileDownloadPause.f());
                    f5aVar2.u(fileDownloadPause.b());
                    f5aVar2.o(fileDownloadPause.a());
                    f5aVar2.x(fileDownloadPause.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                f5aVar2.s(true);
                f5a fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    f5aVar2.y(fileDownloadDelete.f());
                    f5aVar2.u(fileDownloadDelete.b());
                    f5aVar2.o(fileDownloadDelete.a());
                    f5aVar2.x(fileDownloadDelete.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                f5aVar2.s(true);
                f5a installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    f5aVar2.y(installGameApk.f());
                    f5aVar2.u(installGameApk.b());
                    f5aVar2.o(installGameApk.a());
                    f5aVar2.x(installGameApk.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                f5aVar2.s(true);
                f5a launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    f5aVar2.y(launchApk.f());
                    f5aVar2.u(launchApk.b());
                    f5aVar2.o(launchApk.a());
                    f5aVar2.x(launchApk.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                f5aVar2.s(true);
                f5a wakeKeyboard = this.mJsBridge.wakeKeyboard();
                if (wakeKeyboard != null) {
                    f5aVar2.y(wakeKeyboard.f());
                    f5aVar2.u(wakeKeyboard.b());
                    f5aVar2.o(wakeKeyboard.a());
                    f5aVar2.x(wakeKeyboard.e());
                }
                f5aVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                f5aVar2.s(true);
                f5a replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    f5aVar2.y(replyPost.f());
                    f5aVar2.u(replyPost.b());
                    f5aVar2.o(replyPost.a());
                    f5aVar2.x(replyPost.e());
                    if (!f5aVar2.h()) {
                        i3 = 0;
                        f5aVar2.n(false);
                        addObserver("replyPostResult", f5aVar2, false);
                        f5aVar2.z(i3);
                    }
                }
                i3 = 0;
                f5aVar2.z(i3);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                f5aVar2.s(true);
                f5a nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    f5aVar2.y(nativeNetworkProxy.f());
                    f5aVar2.u(nativeNetworkProxy.b());
                    f5aVar2.o(nativeNetworkProxy.a());
                    f5aVar2.x(nativeNetworkProxy.e());
                    if (!f5aVar2.h()) {
                        i2 = 0;
                        f5aVar2.n(false);
                        addObserver("nativeNetworkProxyResult", f5aVar2, false);
                        f5aVar2.z(i2);
                    }
                }
                i2 = 0;
                f5aVar2.z(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                f5aVar2.s(true);
                f5a requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    f5aVar2.y(requestByNative.f());
                    f5aVar2.u(requestByNative.b());
                    f5aVar2.o(requestByNative.a());
                    f5aVar2.x(requestByNative.e());
                    if (!f5aVar2.h()) {
                        i = 0;
                        f5aVar2.n(false);
                        addObserver("RequestByNativeToH5", f5aVar2, false);
                        f5aVar2.z(i);
                    }
                }
                i = 0;
                f5aVar2.z(i);
            }
            return f5aVar2;
        }
        return (f5a) invokeLL.objValue;
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

    @Override // com.baidu.tieba.d5a
    public List<f5a> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            f5a f5aVar = null;
            if (wi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                f5aVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                f5aVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                f5aVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                f5aVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                f5aVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                f5aVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                f5aVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                f5aVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                f5aVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                f5aVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                f5aVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                f5aVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                f5aVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                f5aVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                f5aVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                f5aVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                f5aVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                f5aVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                f5aVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                f5aVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                f5aVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                f5aVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                f5aVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                f5aVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                f5aVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                f5aVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                f5aVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                f5aVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                f5aVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                f5aVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (f5aVar != null) {
                f5aVar.z(0);
            }
            List<e5a> list = this.mAsyncCallBackMethodList.get(str);
            if (f5aVar != null && list != null) {
                Iterator<e5a> it = list.iterator();
                if (!wi.isEmpty(f5aVar.e())) {
                    while (it.hasNext()) {
                        e5a next = it.next();
                        if (next.b().equals(f5aVar.e())) {
                            f5a f5aVar2 = new f5a();
                            f5aVar2.w(next.a());
                            f5aVar2.y(f5aVar.f());
                            f5aVar2.u(f5aVar.b());
                            f5aVar2.o(f5aVar.a());
                            f5aVar2.A(f5aVar.l());
                            arrayList.add(f5aVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        e5a next2 = it.next();
                        f5a f5aVar3 = new f5a();
                        f5aVar3.w(next2.a());
                        f5aVar3.y(f5aVar.f());
                        f5aVar3.u(f5aVar.b());
                        f5aVar3.o(f5aVar.a());
                        f5aVar3.A(f5aVar.l());
                        arrayList.add(f5aVar3);
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
