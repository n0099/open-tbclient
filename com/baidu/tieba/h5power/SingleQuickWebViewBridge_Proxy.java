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
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.lsa;
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.psa;
import com.baidu.tieba.qd;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
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
public class SingleQuickWebViewBridge_Proxy extends lsa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.lsa
    public nsa dispatch(psa psaVar, nsa nsaVar) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, psaVar, nsaVar)) == null) {
            nsa nsaVar2 = nsaVar == null ? new nsa() : nsaVar;
            String b = psaVar.b();
            JSONObject e = psaVar.e();
            if (b.equals("account/startLoginModule")) {
                nsaVar2.s(true);
                nsa startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    nsaVar2.y(startLoginModule.f());
                    nsaVar2.u(startLoginModule.b());
                    nsaVar2.o(startLoginModule.a());
                    nsaVar2.x(startLoginModule.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("account/authState")) {
                nsaVar2.s(true);
                nsa checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    nsaVar2.y(checkAuthState.f());
                    nsaVar2.u(checkAuthState.b());
                    nsaVar2.o(checkAuthState.a());
                    nsaVar2.x(checkAuthState.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                nsaVar2.s(true);
                nsa startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    nsaVar2.y(startAllLoginModule.f());
                    nsaVar2.u(startAllLoginModule.b());
                    nsaVar2.o(startAllLoginModule.a());
                    nsaVar2.x(startAllLoginModule.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver("commonLogin", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                nsaVar2.s(true);
                nsa realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    nsaVar2.y(realNameAuth.f());
                    nsaVar2.u(realNameAuth.b());
                    nsaVar2.o(realNameAuth.a());
                    nsaVar2.x(realNameAuth.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver("realNameAuthResult", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                nsaVar2.s(true);
                nsa finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    nsaVar2.y(finishPage.f());
                    nsaVar2.u(finishPage.b());
                    nsaVar2.o(finishPage.a());
                    nsaVar2.x(finishPage.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                nsaVar2.s(true);
                nsa showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    nsaVar2.y(showLowerHairHint.f());
                    nsaVar2.u(showLowerHairHint.b());
                    nsaVar2.o(showLowerHairHint.a());
                    nsaVar2.x(showLowerHairHint.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                nsaVar2.s(true);
                nsa gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    nsaVar2.y(gamePush.f());
                    nsaVar2.u(gamePush.b());
                    nsaVar2.o(gamePush.a());
                    nsaVar2.x(gamePush.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                nsaVar2.s(true);
                nsa handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    nsaVar2.y(handleGamePushStatus.f());
                    nsaVar2.u(handleGamePushStatus.b());
                    nsaVar2.o(handleGamePushStatus.a());
                    nsaVar2.x(handleGamePushStatus.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                nsaVar2.s(true);
                nsa jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    nsaVar2.y(jumpForumRulesEditPage.f());
                    nsaVar2.u(jumpForumRulesEditPage.b());
                    nsaVar2.o(jumpForumRulesEditPage.a());
                    nsaVar2.x(jumpForumRulesEditPage.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                nsaVar2.s(true);
                nsa handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    nsaVar2.y(handleGoToBarDetail.f());
                    nsaVar2.u(handleGoToBarDetail.b());
                    nsaVar2.o(handleGoToBarDetail.a());
                    nsaVar2.x(handleGoToBarDetail.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                nsaVar2.s(true);
                nsa handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    nsaVar2.y(handleSaveImage.f());
                    nsaVar2.u(handleSaveImage.b());
                    nsaVar2.o(handleSaveImage.a());
                    nsaVar2.x(handleSaveImage.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver("saveImageSuccess", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                nsaVar2.s(true);
                nsa orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    nsaVar2.y(orderGameApk.f());
                    nsaVar2.u(orderGameApk.b());
                    nsaVar2.o(orderGameApk.a());
                    nsaVar2.x(orderGameApk.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver("orderGameApkResult", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                nsaVar2.s(true);
                nsa handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    nsaVar2.y(handleGetPhotoAlbum.f());
                    nsaVar2.u(handleGetPhotoAlbum.b());
                    nsaVar2.o(handleGetPhotoAlbum.a());
                    nsaVar2.x(handleGetPhotoAlbum.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver("GetPhotoAlbum", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                nsaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                nsa preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    nsaVar2.y(preheatWeb.f());
                    nsaVar2.u(preheatWeb.b());
                    nsaVar2.o(preheatWeb.a());
                    nsaVar2.x(preheatWeb.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                nsaVar2.s(true);
                nsa openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    nsaVar2.y(openMXDYab.f());
                    nsaVar2.u(openMXDYab.b());
                    nsaVar2.o(openMXDYab.a());
                    nsaVar2.x(openMXDYab.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/portal")) {
                nsaVar2.s(true);
                nsa handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (handlePortal != null) {
                    nsaVar2.y(handlePortal.f());
                    nsaVar2.u(handlePortal.b());
                    nsaVar2.o(handlePortal.a());
                    nsaVar2.x(handlePortal.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                nsaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                nsa selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    nsaVar2.y(selectPhotoAlbum.f());
                    nsaVar2.u(selectPhotoAlbum.b());
                    nsaVar2.o(selectPhotoAlbum.a());
                    nsaVar2.x(selectPhotoAlbum.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver("selectPhotoAlbum", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                nsaVar2.s(true);
                nsa operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    nsaVar2.y(operateNotifyDataChanged.f());
                    nsaVar2.u(operateNotifyDataChanged.b());
                    nsaVar2.o(operateNotifyDataChanged.a());
                    nsaVar2.x(operateNotifyDataChanged.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                nsaVar2.s(true);
                nsa viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    nsaVar2.y(viewPosition.f());
                    nsaVar2.u(viewPosition.b());
                    nsaVar2.o(viewPosition.a());
                    nsaVar2.x(viewPosition.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                nsaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                nsa selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    nsaVar2.y(selectPrivateMsg.f());
                    nsaVar2.u(selectPrivateMsg.b());
                    nsaVar2.o(selectPrivateMsg.a());
                    nsaVar2.x(selectPrivateMsg.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                nsaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                nsa reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    nsaVar2.y(reportUserTheme.f());
                    nsaVar2.u(reportUserTheme.b());
                    nsaVar2.o(reportUserTheme.a());
                    nsaVar2.x(reportUserTheme.e());
                    if (!nsaVar2.h()) {
                        nsaVar2.n(false);
                        addObserver("goToReportThreadPage", nsaVar2, false);
                    }
                }
                nsaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                nsaVar2.s(true);
                nsa playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    nsaVar2.y(playSound.f());
                    nsaVar2.u(playSound.b());
                    nsaVar2.o(playSound.a());
                    nsaVar2.x(playSound.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                nsaVar2.s(true);
                nsa playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    nsaVar2.y(playVibrate.f());
                    nsaVar2.u(playVibrate.b());
                    nsaVar2.o(playVibrate.a());
                    nsaVar2.x(playVibrate.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                nsaVar2.s(true);
                nsa localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    nsaVar2.y(localYaLog.f());
                    nsaVar2.u(localYaLog.b());
                    nsaVar2.o(localYaLog.a());
                    nsaVar2.x(localYaLog.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                nsaVar2.s(true);
                nsa jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    nsaVar2.y(jumpLoginActivity.f());
                    nsaVar2.u(jumpLoginActivity.b());
                    nsaVar2.o(jumpLoginActivity.a());
                    nsaVar2.x(jumpLoginActivity.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                nsaVar2.s(true);
                nsa startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    nsaVar2.y(startLoadTimeInterval.f());
                    nsaVar2.u(startLoadTimeInterval.b());
                    nsaVar2.o(startLoadTimeInterval.a());
                    nsaVar2.x(startLoadTimeInterval.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                nsaVar2.s(true);
                nsa zid = this.mJsBridge.getZid();
                if (zid != null) {
                    nsaVar2.y(zid.f());
                    nsaVar2.u(zid.b());
                    nsaVar2.o(zid.a());
                    nsaVar2.x(zid.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                nsaVar2.s(true);
                nsa hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    nsaVar2.y(hdid.f());
                    nsaVar2.u(hdid.b());
                    nsaVar2.o(hdid.a());
                    nsaVar2.x(hdid.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                nsaVar2.s(true);
                nsa shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    nsaVar2.y(shareInfo.f());
                    nsaVar2.u(shareInfo.b());
                    nsaVar2.o(shareInfo.a());
                    nsaVar2.x(shareInfo.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("share/share")) {
                nsaVar2.s(true);
                nsa share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    nsaVar2.y(share.f());
                    nsaVar2.u(share.b());
                    nsaVar2.o(share.a());
                    nsaVar2.x(share.e());
                    if (!nsaVar2.h()) {
                        i12 = 0;
                        nsaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, nsaVar2, false);
                        nsaVar2.z(i12);
                    }
                }
                i12 = 0;
                nsaVar2.z(i12);
            } else if (b.equals("clipper/getClipperInformation")) {
                nsaVar2.s(true);
                nsa clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    nsaVar2.y(clipperInformation.f());
                    nsaVar2.u(clipperInformation.b());
                    nsaVar2.o(clipperInformation.a());
                    nsaVar2.x(clipperInformation.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                nsaVar2.s(true);
                nsa clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    nsaVar2.y(clipperInformation2.f());
                    nsaVar2.u(clipperInformation2.b());
                    nsaVar2.o(clipperInformation2.a());
                    nsaVar2.x(clipperInformation2.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                nsaVar2.s(true);
                nsa goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    nsaVar2.y(goToEditPost.f());
                    nsaVar2.u(goToEditPost.b());
                    nsaVar2.o(goToEditPost.a());
                    nsaVar2.x(goToEditPost.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                nsaVar2.s(true);
                nsa updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    nsaVar2.y(updateSearchForumInfo.f());
                    nsaVar2.u(updateSearchForumInfo.b());
                    nsaVar2.o(updateSearchForumInfo.a());
                    nsaVar2.x(updateSearchForumInfo.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                nsaVar2.s(true);
                nsa personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    nsaVar2.y(personlizedSwitchChange.f());
                    nsaVar2.u(personlizedSwitchChange.b());
                    nsaVar2.o(personlizedSwitchChange.a());
                    nsaVar2.x(personlizedSwitchChange.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                nsaVar2.s(true);
                nsa updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    nsaVar2.y(updateTailStyle.f());
                    nsaVar2.u(updateTailStyle.b());
                    nsaVar2.o(updateTailStyle.a());
                    nsaVar2.x(updateTailStyle.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                nsaVar2.s(true);
                nsa goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    nsaVar2.y(goToVideoImmersivePage.f());
                    nsaVar2.u(goToVideoImmersivePage.b());
                    nsaVar2.o(goToVideoImmersivePage.a());
                    nsaVar2.x(goToVideoImmersivePage.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                nsaVar2.s(true);
                nsa jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    nsaVar2.y(jumpToVideo.f());
                    nsaVar2.u(jumpToVideo.b());
                    nsaVar2.o(jumpToVideo.a());
                    nsaVar2.x(jumpToVideo.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                nsaVar2.s(true);
                nsa closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    nsaVar2.y(closeNativeMask.f());
                    nsaVar2.u(closeNativeMask.b());
                    nsaVar2.o(closeNativeMask.a());
                    nsaVar2.x(closeNativeMask.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                nsaVar2.s(true);
                nsa oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    nsaVar2.y(oneKeyDeletion.f());
                    nsaVar2.u(oneKeyDeletion.b());
                    nsaVar2.o(oneKeyDeletion.a());
                    nsaVar2.x(oneKeyDeletion.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                nsaVar2.s(true);
                nsa checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    nsaVar2.y(checkAppInstall.f());
                    nsaVar2.u(checkAppInstall.b());
                    nsaVar2.o(checkAppInstall.a());
                    nsaVar2.x(checkAppInstall.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                nsaVar2.s(true);
                nsa disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    nsaVar2.y(disableBack.f());
                    nsaVar2.u(disableBack.b());
                    nsaVar2.o(disableBack.a());
                    nsaVar2.x(disableBack.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                nsaVar2.s(true);
                nsa startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    nsaVar2.y(startApp.f());
                    nsaVar2.u(startApp.b());
                    nsaVar2.o(startApp.a());
                    nsaVar2.x(startApp.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                nsaVar2.s(true);
                nsa hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    nsaVar2.y(hasNotificationPermission.f());
                    nsaVar2.u(hasNotificationPermission.b());
                    nsaVar2.o(hasNotificationPermission.a());
                    nsaVar2.x(hasNotificationPermission.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                nsaVar2.s(true);
                nsa goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    nsaVar2.y(goToNotificationSetting.f());
                    nsaVar2.u(goToNotificationSetting.b());
                    nsaVar2.o(goToNotificationSetting.a());
                    nsaVar2.x(goToNotificationSetting.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                nsaVar2.s(true);
                nsa startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    nsaVar2.y(startDownloadGameApk.f());
                    nsaVar2.u(startDownloadGameApk.b());
                    nsaVar2.o(startDownloadGameApk.a());
                    nsaVar2.x(startDownloadGameApk.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                nsaVar2.s(true);
                nsa checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    nsaVar2.y(checkInstallGameApk.f());
                    nsaVar2.u(checkInstallGameApk.b());
                    nsaVar2.o(checkInstallGameApk.a());
                    nsaVar2.x(checkInstallGameApk.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                nsaVar2.s(true);
                nsa startDownloadCss = this.mJsBridge.startDownloadCss(e.optString("downloadUrl"));
                if (startDownloadCss != null) {
                    nsaVar2.y(startDownloadCss.f());
                    nsaVar2.u(startDownloadCss.b());
                    nsaVar2.o(startDownloadCss.a());
                    nsaVar2.x(startDownloadCss.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                nsaVar2.s(true);
                nsa disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    nsaVar2.y(disableGoBack.f());
                    nsaVar2.u(disableGoBack.b());
                    nsaVar2.o(disableGoBack.a());
                    nsaVar2.x(disableGoBack.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                nsaVar2.s(true);
                nsa supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    nsaVar2.y(supplementInfo.f());
                    nsaVar2.u(supplementInfo.b());
                    nsaVar2.o(supplementInfo.a());
                    nsaVar2.x(supplementInfo.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                nsaVar2.s(true);
                nsa deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    nsaVar2.y(deviceGyroscopeParams.f());
                    nsaVar2.u(deviceGyroscopeParams.b());
                    nsaVar2.o(deviceGyroscopeParams.a());
                    nsaVar2.x(deviceGyroscopeParams.e());
                    if (!nsaVar2.h()) {
                        i11 = 0;
                        nsaVar2.n(false);
                        addObserver("deviceMotion", nsaVar2, false);
                        nsaVar2.z(i11);
                    }
                }
                i11 = 0;
                nsaVar2.z(i11);
            } else if (b.equals("device/deviceRefreshRate")) {
                nsaVar2.s(true);
                nsa deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    nsaVar2.y(deviceRefreshRateParams.f());
                    nsaVar2.u(deviceRefreshRateParams.b());
                    nsaVar2.o(deviceRefreshRateParams.a());
                    nsaVar2.x(deviceRefreshRateParams.e());
                    if (!nsaVar2.h()) {
                        i10 = 0;
                        nsaVar2.n(false);
                        addObserver("deviceRefreshRate", nsaVar2, false);
                        nsaVar2.z(i10);
                    }
                }
                i10 = 0;
                nsaVar2.z(i10);
            } else if (b.equals("device/getDeviceInfo")) {
                nsaVar2.s(true);
                nsa deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    nsaVar2.y(deviceInfo.f());
                    nsaVar2.u(deviceInfo.b());
                    nsaVar2.o(deviceInfo.a());
                    nsaVar2.x(deviceInfo.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                nsaVar2.s(true);
                nsa sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    nsaVar2.y(sendCompleteTaskReqMsg.f());
                    nsaVar2.u(sendCompleteTaskReqMsg.b());
                    nsaVar2.o(sendCompleteTaskReqMsg.a());
                    nsaVar2.x(sendCompleteTaskReqMsg.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                nsaVar2.s(true);
                nsa showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    nsaVar2.y(showTipToast.f());
                    nsaVar2.u(showTipToast.b());
                    nsaVar2.o(showTipToast.a());
                    nsaVar2.x(showTipToast.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                nsaVar2.s(true);
                nsa getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    nsaVar2.y(getModalData.f());
                    nsaVar2.u(getModalData.b());
                    nsaVar2.o(getModalData.a());
                    nsaVar2.x(getModalData.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                nsaVar2.s(true);
                nsa openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    nsaVar2.y(openThirdPartApp.f());
                    nsaVar2.u(openThirdPartApp.b());
                    nsaVar2.o(openThirdPartApp.a());
                    nsaVar2.x(openThirdPartApp.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                nsaVar2.s(true);
                nsa jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    nsaVar2.y(jumpToHtmlPage.f());
                    nsaVar2.u(jumpToHtmlPage.b());
                    nsaVar2.o(jumpToHtmlPage.a());
                    nsaVar2.x(jumpToHtmlPage.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                nsaVar2.s(true);
                nsa offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    nsaVar2.y(offlineUserInfo.f());
                    nsaVar2.u(offlineUserInfo.b());
                    nsaVar2.o(offlineUserInfo.a());
                    nsaVar2.x(offlineUserInfo.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                nsaVar2.s(true);
                nsa deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    nsaVar2.y(deleteOfflineBundle.f());
                    nsaVar2.u(deleteOfflineBundle.b());
                    nsaVar2.o(deleteOfflineBundle.a());
                    nsaVar2.x(deleteOfflineBundle.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                nsaVar2.s(true);
                nsa updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    nsaVar2.y(updateOfflineBundle.f());
                    nsaVar2.u(updateOfflineBundle.b());
                    nsaVar2.o(updateOfflineBundle.a());
                    nsaVar2.x(updateOfflineBundle.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                nsaVar2.s(true);
                nsa switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    nsaVar2.y(switchOfflineInterface.f());
                    nsaVar2.u(switchOfflineInterface.b());
                    nsaVar2.o(switchOfflineInterface.a());
                    nsaVar2.x(switchOfflineInterface.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                nsaVar2.s(true);
                nsa switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    nsaVar2.y(switchOfflineBundleStatus.f());
                    nsaVar2.u(switchOfflineBundleStatus.b());
                    nsaVar2.o(switchOfflineBundleStatus.a());
                    nsaVar2.x(switchOfflineBundleStatus.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                nsaVar2.s(true);
                nsa finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    nsaVar2.y(finishTestAnswer.f());
                    nsaVar2.u(finishTestAnswer.b());
                    nsaVar2.o(finishTestAnswer.a());
                    nsaVar2.x(finishTestAnswer.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                nsaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                nsa switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    nsaVar2.y(switchUrlHost.f());
                    nsaVar2.u(switchUrlHost.b());
                    nsaVar2.o(switchUrlHost.a());
                    nsaVar2.x(switchUrlHost.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                nsaVar2.s(true);
                nsa appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    nsaVar2.y(appStorage.f());
                    nsaVar2.u(appStorage.b());
                    nsaVar2.o(appStorage.a());
                    nsaVar2.x(appStorage.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                nsaVar2.s(true);
                nsa putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    nsaVar2.y(putAppStorage.f());
                    nsaVar2.u(putAppStorage.b());
                    nsaVar2.o(putAppStorage.a());
                    nsaVar2.x(putAppStorage.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                nsaVar2.s(true);
                nsa historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    nsaVar2.y(historyForumData.f());
                    nsaVar2.u(historyForumData.b());
                    nsaVar2.o(historyForumData.a());
                    nsaVar2.x(historyForumData.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                nsaVar2.s(true);
                nsa worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    nsaVar2.y(worldCupRaiseSuccess.f());
                    nsaVar2.u(worldCupRaiseSuccess.b());
                    nsaVar2.o(worldCupRaiseSuccess.a());
                    nsaVar2.x(worldCupRaiseSuccess.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                nsaVar2.s(true);
                nsa alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    nsaVar2.y(alipayUserId.f());
                    nsaVar2.u(alipayUserId.b());
                    nsaVar2.o(alipayUserId.a());
                    nsaVar2.x(alipayUserId.e());
                    if (!nsaVar2.h()) {
                        i9 = 0;
                        nsaVar2.n(false);
                        addObserver("aliAuthResult", nsaVar2, false);
                        nsaVar2.z(i9);
                    }
                }
                i9 = 0;
                nsaVar2.z(i9);
            } else if (b.equals("system/getFileDownloadStatus")) {
                nsaVar2.s(true);
                nsa fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    nsaVar2.y(fileDownloadStatus.f());
                    nsaVar2.u(fileDownloadStatus.b());
                    nsaVar2.o(fileDownloadStatus.a());
                    nsaVar2.x(fileDownloadStatus.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                nsaVar2.s(true);
                nsa fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    nsaVar2.y(fileDownloadProgress.f());
                    nsaVar2.u(fileDownloadProgress.b());
                    nsaVar2.o(fileDownloadProgress.a());
                    nsaVar2.x(fileDownloadProgress.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                nsaVar2.s(true);
                nsa fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    nsaVar2.y(fileDownloadPause.f());
                    nsaVar2.u(fileDownloadPause.b());
                    nsaVar2.o(fileDownloadPause.a());
                    nsaVar2.x(fileDownloadPause.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                nsaVar2.s(true);
                nsa fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    nsaVar2.y(fileDownloadDelete.f());
                    nsaVar2.u(fileDownloadDelete.b());
                    nsaVar2.o(fileDownloadDelete.a());
                    nsaVar2.x(fileDownloadDelete.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                nsaVar2.s(true);
                nsa installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    nsaVar2.y(installGameApk.f());
                    nsaVar2.u(installGameApk.b());
                    nsaVar2.o(installGameApk.a());
                    nsaVar2.x(installGameApk.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                nsaVar2.s(true);
                nsa launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    nsaVar2.y(launchApk.f());
                    nsaVar2.u(launchApk.b());
                    nsaVar2.o(launchApk.a());
                    nsaVar2.x(launchApk.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                nsaVar2.s(true);
                nsa wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    nsaVar2.y(wakeKeyboard.f());
                    nsaVar2.u(wakeKeyboard.b());
                    nsaVar2.o(wakeKeyboard.a());
                    nsaVar2.x(wakeKeyboard.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                nsaVar2.s(true);
                nsa replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    nsaVar2.y(replyPost.f());
                    nsaVar2.u(replyPost.b());
                    nsaVar2.o(replyPost.a());
                    nsaVar2.x(replyPost.e());
                    if (!nsaVar2.h()) {
                        i8 = 0;
                        nsaVar2.n(false);
                        addObserver("replyPostResult", nsaVar2, false);
                        nsaVar2.z(i8);
                    }
                }
                i8 = 0;
                nsaVar2.z(i8);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                nsaVar2.s(true);
                nsa nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    nsaVar2.y(nativeNetworkProxy.f());
                    nsaVar2.u(nativeNetworkProxy.b());
                    nsaVar2.o(nativeNetworkProxy.a());
                    nsaVar2.x(nativeNetworkProxy.e());
                    if (!nsaVar2.h()) {
                        i7 = 0;
                        nsaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", nsaVar2, false);
                        nsaVar2.z(i7);
                    }
                }
                i7 = 0;
                nsaVar2.z(i7);
            } else if (b.equals("host/sendMsg")) {
                nsaVar2.s(true);
                nsa sendMessage = this.mJsBridge.sendMessage(e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (sendMessage != null) {
                    nsaVar2.y(sendMessage.f());
                    nsaVar2.u(sendMessage.b());
                    nsaVar2.o(sendMessage.a());
                    nsaVar2.x(sendMessage.e());
                    if (!nsaVar2.h()) {
                        i6 = 0;
                        nsaVar2.n(false);
                        addObserver("sendMsg", nsaVar2, false);
                        nsaVar2.z(i6);
                    }
                }
                i6 = 0;
                nsaVar2.z(i6);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                nsaVar2.s(true);
                nsa fetchHistoryMsgs = this.mJsBridge.fetchHistoryMsgs(e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (fetchHistoryMsgs != null) {
                    nsaVar2.y(fetchHistoryMsgs.f());
                    nsaVar2.u(fetchHistoryMsgs.b());
                    nsaVar2.o(fetchHistoryMsgs.a());
                    nsaVar2.x(fetchHistoryMsgs.e());
                    if (!nsaVar2.h()) {
                        i5 = 0;
                        nsaVar2.n(false);
                        addObserver("fetchHistoryMsgs", nsaVar2, false);
                        nsaVar2.z(i5);
                    }
                }
                i5 = 0;
                nsaVar2.z(i5);
            } else if (b.equals("host/receiveNewMsgs")) {
                nsaVar2.s(true);
                nsa receiveNewMsgs = this.mJsBridge.receiveNewMsgs();
                this.mNotificationNameList.add("receiveNewMsgs");
                if (receiveNewMsgs != null) {
                    nsaVar2.y(receiveNewMsgs.f());
                    nsaVar2.u(receiveNewMsgs.b());
                    nsaVar2.o(receiveNewMsgs.a());
                    nsaVar2.x(receiveNewMsgs.e());
                    if (!nsaVar2.h()) {
                        i4 = 0;
                        nsaVar2.n(false);
                        addObserver("receiveNewMsgs", nsaVar2, false);
                        nsaVar2.z(i4);
                    }
                }
                i4 = 0;
                nsaVar2.z(i4);
            } else if (b.equals("system/keyboardHeightChange")) {
                nsaVar2.s(true);
                nsa keyboardHeightChange = this.mJsBridge.keyboardHeightChange();
                this.mNotificationNameList.add("keyboardHeightChange");
                if (keyboardHeightChange != null) {
                    nsaVar2.y(keyboardHeightChange.f());
                    nsaVar2.u(keyboardHeightChange.b());
                    nsaVar2.o(keyboardHeightChange.a());
                    nsaVar2.x(keyboardHeightChange.e());
                    if (!nsaVar2.h()) {
                        i3 = 0;
                        nsaVar2.n(false);
                        addObserver("keyboardHeightChange", nsaVar2, false);
                        nsaVar2.z(i3);
                    }
                }
                i3 = 0;
                nsaVar2.z(i3);
            } else if (b.equals("host/preloadPic")) {
                nsaVar2.s(true);
                ArrayList<String> arrayList6 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList6, e.optJSONArray("url"));
                nsa perloadPicModule = this.mJsBridge.perloadPicModule(arrayList6);
                if (perloadPicModule != null) {
                    nsaVar2.y(perloadPicModule.f());
                    nsaVar2.u(perloadPicModule.b());
                    nsaVar2.o(perloadPicModule.a());
                    nsaVar2.x(perloadPicModule.e());
                }
                nsaVar2.z(0);
            } else if (b.equals("toast/showDialog")) {
                nsaVar2.s(true);
                nsa showDialog = this.mJsBridge.showDialog(e.optInt("type"), e.optString("content"), e.optString("dialogId"));
                this.mNotificationNameList.add("showDialog");
                if (showDialog != null) {
                    nsaVar2.y(showDialog.f());
                    nsaVar2.u(showDialog.b());
                    nsaVar2.o(showDialog.a());
                    nsaVar2.x(showDialog.e());
                    if (!nsaVar2.h()) {
                        i2 = 0;
                        nsaVar2.n(false);
                        addObserver("showDialog", nsaVar2, false);
                        nsaVar2.z(i2);
                    }
                }
                i2 = 0;
                nsaVar2.z(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                nsaVar2.s(true);
                nsa requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    nsaVar2.y(requestByNative.f());
                    nsaVar2.u(requestByNative.b());
                    nsaVar2.o(requestByNative.a());
                    nsaVar2.x(requestByNative.e());
                    if (!nsaVar2.h()) {
                        i = 0;
                        nsaVar2.n(false);
                        addObserver("RequestByNativeToH5", nsaVar2, false);
                        nsaVar2.z(i);
                    }
                }
                i = 0;
                nsaVar2.z(i);
            }
            return nsaVar2;
        }
        return (nsa) invokeLL.objValue;
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

    @Override // com.baidu.tieba.lsa
    public List<nsa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            nsa nsaVar = null;
            if (qd.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                nsaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                nsaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                nsaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                nsaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                nsaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                nsaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                nsaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                nsaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                nsaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                nsaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                nsaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                nsaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                nsaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                nsaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                nsaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                nsaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                nsaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                nsaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                nsaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                nsaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                nsaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                nsaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                nsaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                nsaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                nsaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                nsaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                nsaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                nsaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                nsaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                nsaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("sendMsg")) {
                nsaVar = this.mJsBridge.onSendMsgResult(hashMap);
            } else if (str.equals("handleAudioMsgByTTS")) {
                nsaVar = this.mJsBridge.handleVoiceMsgResult(hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                nsaVar = this.mJsBridge.onFetchHistoryMsgsResult(hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                nsaVar = this.mJsBridge.onReceiveNewMsgsResult(hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                nsaVar = this.mJsBridge.onKeyboardHeightChange(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                nsaVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (nsaVar != null) {
                nsaVar.z(0);
            }
            List<msa> list = this.mAsyncCallBackMethodList.get(str);
            if (nsaVar != null && list != null) {
                Iterator<msa> it = list.iterator();
                if (!qd.isEmpty(nsaVar.e())) {
                    while (it.hasNext()) {
                        msa next = it.next();
                        if (next.b().equals(nsaVar.e())) {
                            nsa nsaVar2 = new nsa();
                            nsaVar2.w(next.a());
                            nsaVar2.y(nsaVar.f());
                            nsaVar2.u(nsaVar.b());
                            nsaVar2.o(nsaVar.a());
                            nsaVar2.A(nsaVar.l());
                            arrayList.add(nsaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        msa next2 = it.next();
                        nsa nsaVar3 = new nsa();
                        nsaVar3.w(next2.a());
                        nsaVar3.y(nsaVar.f());
                        nsaVar3.u(nsaVar.b());
                        nsaVar3.o(nsaVar.a());
                        nsaVar3.A(nsaVar.l());
                        arrayList.add(nsaVar3);
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
