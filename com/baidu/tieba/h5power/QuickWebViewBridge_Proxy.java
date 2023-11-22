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
import com.baidu.tieba.msa;
import com.baidu.tieba.nsa;
import com.baidu.tieba.osa;
import com.baidu.tieba.qd;
import com.baidu.tieba.qsa;
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
public class QuickWebViewBridge_Proxy extends msa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.msa
    public osa dispatch(qsa qsaVar, osa osaVar) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qsaVar, osaVar)) == null) {
            osa osaVar2 = osaVar == null ? new osa() : osaVar;
            String b = qsaVar.b();
            JSONObject e = qsaVar.e();
            if (b.equals("account/startLoginModule")) {
                osaVar2.s(true);
                osa startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    osaVar2.y(startLoginModule.f());
                    osaVar2.u(startLoginModule.b());
                    osaVar2.o(startLoginModule.a());
                    osaVar2.x(startLoginModule.e());
                }
                osaVar2.z(0);
            } else if (b.equals("account/authState")) {
                osaVar2.s(true);
                osa checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    osaVar2.y(checkAuthState.f());
                    osaVar2.u(checkAuthState.b());
                    osaVar2.o(checkAuthState.a());
                    osaVar2.x(checkAuthState.e());
                }
                osaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                osaVar2.s(true);
                osa startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    osaVar2.y(startAllLoginModule.f());
                    osaVar2.u(startAllLoginModule.b());
                    osaVar2.o(startAllLoginModule.a());
                    osaVar2.x(startAllLoginModule.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver("commonLogin", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                osaVar2.s(true);
                osa realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    osaVar2.y(realNameAuth.f());
                    osaVar2.u(realNameAuth.b());
                    osaVar2.o(realNameAuth.a());
                    osaVar2.x(realNameAuth.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver("realNameAuthResult", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                osaVar2.s(true);
                osa finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    osaVar2.y(finishPage.f());
                    osaVar2.u(finishPage.b());
                    osaVar2.o(finishPage.a());
                    osaVar2.x(finishPage.e());
                }
                osaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                osaVar2.s(true);
                osa showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    osaVar2.y(showLowerHairHint.f());
                    osaVar2.u(showLowerHairHint.b());
                    osaVar2.o(showLowerHairHint.a());
                    osaVar2.x(showLowerHairHint.e());
                }
                osaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                osaVar2.s(true);
                osa gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    osaVar2.y(gamePush.f());
                    osaVar2.u(gamePush.b());
                    osaVar2.o(gamePush.a());
                    osaVar2.x(gamePush.e());
                }
                osaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                osaVar2.s(true);
                osa handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    osaVar2.y(handleGamePushStatus.f());
                    osaVar2.u(handleGamePushStatus.b());
                    osaVar2.o(handleGamePushStatus.a());
                    osaVar2.x(handleGamePushStatus.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                osaVar2.s(true);
                osa jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    osaVar2.y(jumpForumRulesEditPage.f());
                    osaVar2.u(jumpForumRulesEditPage.b());
                    osaVar2.o(jumpForumRulesEditPage.a());
                    osaVar2.x(jumpForumRulesEditPage.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                osaVar2.s(true);
                osa handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    osaVar2.y(handleGoToBarDetail.f());
                    osaVar2.u(handleGoToBarDetail.b());
                    osaVar2.o(handleGoToBarDetail.a());
                    osaVar2.x(handleGoToBarDetail.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                osaVar2.s(true);
                osa handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    osaVar2.y(handleSaveImage.f());
                    osaVar2.u(handleSaveImage.b());
                    osaVar2.o(handleSaveImage.a());
                    osaVar2.x(handleSaveImage.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver("saveImageSuccess", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                osaVar2.s(true);
                osa orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    osaVar2.y(orderGameApk.f());
                    osaVar2.u(orderGameApk.b());
                    osaVar2.o(orderGameApk.a());
                    osaVar2.x(orderGameApk.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver("orderGameApkResult", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                osaVar2.s(true);
                osa handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    osaVar2.y(handleGetPhotoAlbum.f());
                    osaVar2.u(handleGetPhotoAlbum.b());
                    osaVar2.o(handleGetPhotoAlbum.a());
                    osaVar2.x(handleGetPhotoAlbum.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver("GetPhotoAlbum", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                osaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                osa preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    osaVar2.y(preheatWeb.f());
                    osaVar2.u(preheatWeb.b());
                    osaVar2.o(preheatWeb.a());
                    osaVar2.x(preheatWeb.e());
                }
                osaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                osaVar2.s(true);
                osa openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    osaVar2.y(openMXDYab.f());
                    osaVar2.u(openMXDYab.b());
                    osaVar2.o(openMXDYab.a());
                    osaVar2.x(openMXDYab.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/portal")) {
                osaVar2.s(true);
                osa handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (handlePortal != null) {
                    osaVar2.y(handlePortal.f());
                    osaVar2.u(handlePortal.b());
                    osaVar2.o(handlePortal.a());
                    osaVar2.x(handlePortal.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                osaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                osa selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    osaVar2.y(selectPhotoAlbum.f());
                    osaVar2.u(selectPhotoAlbum.b());
                    osaVar2.o(selectPhotoAlbum.a());
                    osaVar2.x(selectPhotoAlbum.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver("selectPhotoAlbum", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                osaVar2.s(true);
                osa operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    osaVar2.y(operateNotifyDataChanged.f());
                    osaVar2.u(operateNotifyDataChanged.b());
                    osaVar2.o(operateNotifyDataChanged.a());
                    osaVar2.x(operateNotifyDataChanged.e());
                }
                osaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                osaVar2.s(true);
                osa viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    osaVar2.y(viewPosition.f());
                    osaVar2.u(viewPosition.b());
                    osaVar2.o(viewPosition.a());
                    osaVar2.x(viewPosition.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                osaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                osa selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    osaVar2.y(selectPrivateMsg.f());
                    osaVar2.u(selectPrivateMsg.b());
                    osaVar2.o(selectPrivateMsg.a());
                    osaVar2.x(selectPrivateMsg.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                osaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                osa reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    osaVar2.y(reportUserTheme.f());
                    osaVar2.u(reportUserTheme.b());
                    osaVar2.o(reportUserTheme.a());
                    osaVar2.x(reportUserTheme.e());
                    if (!osaVar2.h()) {
                        osaVar2.n(false);
                        addObserver("goToReportThreadPage", osaVar2, false);
                    }
                }
                osaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                osaVar2.s(true);
                osa playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    osaVar2.y(playSound.f());
                    osaVar2.u(playSound.b());
                    osaVar2.o(playSound.a());
                    osaVar2.x(playSound.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                osaVar2.s(true);
                osa playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    osaVar2.y(playVibrate.f());
                    osaVar2.u(playVibrate.b());
                    osaVar2.o(playVibrate.a());
                    osaVar2.x(playVibrate.e());
                }
                osaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                osaVar2.s(true);
                osa localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    osaVar2.y(localYaLog.f());
                    osaVar2.u(localYaLog.b());
                    osaVar2.o(localYaLog.a());
                    osaVar2.x(localYaLog.e());
                }
                osaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                osaVar2.s(true);
                osa jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    osaVar2.y(jumpLoginActivity.f());
                    osaVar2.u(jumpLoginActivity.b());
                    osaVar2.o(jumpLoginActivity.a());
                    osaVar2.x(jumpLoginActivity.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                osaVar2.s(true);
                osa startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    osaVar2.y(startLoadTimeInterval.f());
                    osaVar2.u(startLoadTimeInterval.b());
                    osaVar2.o(startLoadTimeInterval.a());
                    osaVar2.x(startLoadTimeInterval.e());
                }
                osaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                osaVar2.s(true);
                osa zid = this.mJsBridge.getZid();
                if (zid != null) {
                    osaVar2.y(zid.f());
                    osaVar2.u(zid.b());
                    osaVar2.o(zid.a());
                    osaVar2.x(zid.e());
                }
                osaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                osaVar2.s(true);
                osa hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    osaVar2.y(hdid.f());
                    osaVar2.u(hdid.b());
                    osaVar2.o(hdid.a());
                    osaVar2.x(hdid.e());
                }
                osaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                osaVar2.s(true);
                osa shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    osaVar2.y(shareInfo.f());
                    osaVar2.u(shareInfo.b());
                    osaVar2.o(shareInfo.a());
                    osaVar2.x(shareInfo.e());
                }
                osaVar2.z(0);
            } else if (b.equals("share/share")) {
                osaVar2.s(true);
                osa share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    osaVar2.y(share.f());
                    osaVar2.u(share.b());
                    osaVar2.o(share.a());
                    osaVar2.x(share.e());
                    if (!osaVar2.h()) {
                        i12 = 0;
                        osaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, osaVar2, false);
                        osaVar2.z(i12);
                    }
                }
                i12 = 0;
                osaVar2.z(i12);
            } else if (b.equals("clipper/getClipperInformation")) {
                osaVar2.s(true);
                osa clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    osaVar2.y(clipperInformation.f());
                    osaVar2.u(clipperInformation.b());
                    osaVar2.o(clipperInformation.a());
                    osaVar2.x(clipperInformation.e());
                }
                osaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                osaVar2.s(true);
                osa clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    osaVar2.y(clipperInformation2.f());
                    osaVar2.u(clipperInformation2.b());
                    osaVar2.o(clipperInformation2.a());
                    osaVar2.x(clipperInformation2.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                osaVar2.s(true);
                osa goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    osaVar2.y(goToEditPost.f());
                    osaVar2.u(goToEditPost.b());
                    osaVar2.o(goToEditPost.a());
                    osaVar2.x(goToEditPost.e());
                }
                osaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                osaVar2.s(true);
                osa updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    osaVar2.y(updateSearchForumInfo.f());
                    osaVar2.u(updateSearchForumInfo.b());
                    osaVar2.o(updateSearchForumInfo.a());
                    osaVar2.x(updateSearchForumInfo.e());
                }
                osaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                osaVar2.s(true);
                osa personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    osaVar2.y(personlizedSwitchChange.f());
                    osaVar2.u(personlizedSwitchChange.b());
                    osaVar2.o(personlizedSwitchChange.a());
                    osaVar2.x(personlizedSwitchChange.e());
                }
                osaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                osaVar2.s(true);
                osa updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    osaVar2.y(updateTailStyle.f());
                    osaVar2.u(updateTailStyle.b());
                    osaVar2.o(updateTailStyle.a());
                    osaVar2.x(updateTailStyle.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                osaVar2.s(true);
                osa goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    osaVar2.y(goToVideoImmersivePage.f());
                    osaVar2.u(goToVideoImmersivePage.b());
                    osaVar2.o(goToVideoImmersivePage.a());
                    osaVar2.x(goToVideoImmersivePage.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                osaVar2.s(true);
                osa jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    osaVar2.y(jumpToVideo.f());
                    osaVar2.u(jumpToVideo.b());
                    osaVar2.o(jumpToVideo.a());
                    osaVar2.x(jumpToVideo.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                osaVar2.s(true);
                osa closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    osaVar2.y(closeNativeMask.f());
                    osaVar2.u(closeNativeMask.b());
                    osaVar2.o(closeNativeMask.a());
                    osaVar2.x(closeNativeMask.e());
                }
                osaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                osaVar2.s(true);
                osa oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    osaVar2.y(oneKeyDeletion.f());
                    osaVar2.u(oneKeyDeletion.b());
                    osaVar2.o(oneKeyDeletion.a());
                    osaVar2.x(oneKeyDeletion.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                osaVar2.s(true);
                osa checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    osaVar2.y(checkAppInstall.f());
                    osaVar2.u(checkAppInstall.b());
                    osaVar2.o(checkAppInstall.a());
                    osaVar2.x(checkAppInstall.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                osaVar2.s(true);
                osa disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    osaVar2.y(disableBack.f());
                    osaVar2.u(disableBack.b());
                    osaVar2.o(disableBack.a());
                    osaVar2.x(disableBack.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                osaVar2.s(true);
                osa startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    osaVar2.y(startApp.f());
                    osaVar2.u(startApp.b());
                    osaVar2.o(startApp.a());
                    osaVar2.x(startApp.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                osaVar2.s(true);
                osa hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    osaVar2.y(hasNotificationPermission.f());
                    osaVar2.u(hasNotificationPermission.b());
                    osaVar2.o(hasNotificationPermission.a());
                    osaVar2.x(hasNotificationPermission.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                osaVar2.s(true);
                osa goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    osaVar2.y(goToNotificationSetting.f());
                    osaVar2.u(goToNotificationSetting.b());
                    osaVar2.o(goToNotificationSetting.a());
                    osaVar2.x(goToNotificationSetting.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                osaVar2.s(true);
                osa startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    osaVar2.y(startDownloadGameApk.f());
                    osaVar2.u(startDownloadGameApk.b());
                    osaVar2.o(startDownloadGameApk.a());
                    osaVar2.x(startDownloadGameApk.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                osaVar2.s(true);
                osa checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    osaVar2.y(checkInstallGameApk.f());
                    osaVar2.u(checkInstallGameApk.b());
                    osaVar2.o(checkInstallGameApk.a());
                    osaVar2.x(checkInstallGameApk.e());
                }
                osaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                osaVar2.s(true);
                osa startDownloadCss = this.mJsBridge.startDownloadCss(e.optString("downloadUrl"));
                if (startDownloadCss != null) {
                    osaVar2.y(startDownloadCss.f());
                    osaVar2.u(startDownloadCss.b());
                    osaVar2.o(startDownloadCss.a());
                    osaVar2.x(startDownloadCss.e());
                }
                osaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                osaVar2.s(true);
                osa disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    osaVar2.y(disableGoBack.f());
                    osaVar2.u(disableGoBack.b());
                    osaVar2.o(disableGoBack.a());
                    osaVar2.x(disableGoBack.e());
                }
                osaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                osaVar2.s(true);
                osa supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    osaVar2.y(supplementInfo.f());
                    osaVar2.u(supplementInfo.b());
                    osaVar2.o(supplementInfo.a());
                    osaVar2.x(supplementInfo.e());
                }
                osaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                osaVar2.s(true);
                osa deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    osaVar2.y(deviceGyroscopeParams.f());
                    osaVar2.u(deviceGyroscopeParams.b());
                    osaVar2.o(deviceGyroscopeParams.a());
                    osaVar2.x(deviceGyroscopeParams.e());
                    if (!osaVar2.h()) {
                        i11 = 0;
                        osaVar2.n(false);
                        addObserver("deviceMotion", osaVar2, false);
                        osaVar2.z(i11);
                    }
                }
                i11 = 0;
                osaVar2.z(i11);
            } else if (b.equals("device/deviceRefreshRate")) {
                osaVar2.s(true);
                osa deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    osaVar2.y(deviceRefreshRateParams.f());
                    osaVar2.u(deviceRefreshRateParams.b());
                    osaVar2.o(deviceRefreshRateParams.a());
                    osaVar2.x(deviceRefreshRateParams.e());
                    if (!osaVar2.h()) {
                        i10 = 0;
                        osaVar2.n(false);
                        addObserver("deviceRefreshRate", osaVar2, false);
                        osaVar2.z(i10);
                    }
                }
                i10 = 0;
                osaVar2.z(i10);
            } else if (b.equals("device/getDeviceInfo")) {
                osaVar2.s(true);
                osa deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    osaVar2.y(deviceInfo.f());
                    osaVar2.u(deviceInfo.b());
                    osaVar2.o(deviceInfo.a());
                    osaVar2.x(deviceInfo.e());
                }
                osaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                osaVar2.s(true);
                osa sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    osaVar2.y(sendCompleteTaskReqMsg.f());
                    osaVar2.u(sendCompleteTaskReqMsg.b());
                    osaVar2.o(sendCompleteTaskReqMsg.a());
                    osaVar2.x(sendCompleteTaskReqMsg.e());
                }
                osaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                osaVar2.s(true);
                osa showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    osaVar2.y(showTipToast.f());
                    osaVar2.u(showTipToast.b());
                    osaVar2.o(showTipToast.a());
                    osaVar2.x(showTipToast.e());
                }
                osaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                osaVar2.s(true);
                osa getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    osaVar2.y(getModalData.f());
                    osaVar2.u(getModalData.b());
                    osaVar2.o(getModalData.a());
                    osaVar2.x(getModalData.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                osaVar2.s(true);
                osa openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    osaVar2.y(openThirdPartApp.f());
                    osaVar2.u(openThirdPartApp.b());
                    osaVar2.o(openThirdPartApp.a());
                    osaVar2.x(openThirdPartApp.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                osaVar2.s(true);
                osa jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    osaVar2.y(jumpToHtmlPage.f());
                    osaVar2.u(jumpToHtmlPage.b());
                    osaVar2.o(jumpToHtmlPage.a());
                    osaVar2.x(jumpToHtmlPage.e());
                }
                osaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                osaVar2.s(true);
                osa offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    osaVar2.y(offlineUserInfo.f());
                    osaVar2.u(offlineUserInfo.b());
                    osaVar2.o(offlineUserInfo.a());
                    osaVar2.x(offlineUserInfo.e());
                }
                osaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                osaVar2.s(true);
                osa deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    osaVar2.y(deleteOfflineBundle.f());
                    osaVar2.u(deleteOfflineBundle.b());
                    osaVar2.o(deleteOfflineBundle.a());
                    osaVar2.x(deleteOfflineBundle.e());
                }
                osaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                osaVar2.s(true);
                osa updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    osaVar2.y(updateOfflineBundle.f());
                    osaVar2.u(updateOfflineBundle.b());
                    osaVar2.o(updateOfflineBundle.a());
                    osaVar2.x(updateOfflineBundle.e());
                }
                osaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                osaVar2.s(true);
                osa switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    osaVar2.y(switchOfflineInterface.f());
                    osaVar2.u(switchOfflineInterface.b());
                    osaVar2.o(switchOfflineInterface.a());
                    osaVar2.x(switchOfflineInterface.e());
                }
                osaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                osaVar2.s(true);
                osa switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    osaVar2.y(switchOfflineBundleStatus.f());
                    osaVar2.u(switchOfflineBundleStatus.b());
                    osaVar2.o(switchOfflineBundleStatus.a());
                    osaVar2.x(switchOfflineBundleStatus.e());
                }
                osaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                osaVar2.s(true);
                osa finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    osaVar2.y(finishTestAnswer.f());
                    osaVar2.u(finishTestAnswer.b());
                    osaVar2.o(finishTestAnswer.a());
                    osaVar2.x(finishTestAnswer.e());
                }
                osaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                osaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                osa switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    osaVar2.y(switchUrlHost.f());
                    osaVar2.u(switchUrlHost.b());
                    osaVar2.o(switchUrlHost.a());
                    osaVar2.x(switchUrlHost.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                osaVar2.s(true);
                osa appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    osaVar2.y(appStorage.f());
                    osaVar2.u(appStorage.b());
                    osaVar2.o(appStorage.a());
                    osaVar2.x(appStorage.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                osaVar2.s(true);
                osa putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    osaVar2.y(putAppStorage.f());
                    osaVar2.u(putAppStorage.b());
                    osaVar2.o(putAppStorage.a());
                    osaVar2.x(putAppStorage.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                osaVar2.s(true);
                osa historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    osaVar2.y(historyForumData.f());
                    osaVar2.u(historyForumData.b());
                    osaVar2.o(historyForumData.a());
                    osaVar2.x(historyForumData.e());
                }
                osaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                osaVar2.s(true);
                osa worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    osaVar2.y(worldCupRaiseSuccess.f());
                    osaVar2.u(worldCupRaiseSuccess.b());
                    osaVar2.o(worldCupRaiseSuccess.a());
                    osaVar2.x(worldCupRaiseSuccess.e());
                }
                osaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                osaVar2.s(true);
                osa alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    osaVar2.y(alipayUserId.f());
                    osaVar2.u(alipayUserId.b());
                    osaVar2.o(alipayUserId.a());
                    osaVar2.x(alipayUserId.e());
                    if (!osaVar2.h()) {
                        i9 = 0;
                        osaVar2.n(false);
                        addObserver("aliAuthResult", osaVar2, false);
                        osaVar2.z(i9);
                    }
                }
                i9 = 0;
                osaVar2.z(i9);
            } else if (b.equals("system/getFileDownloadStatus")) {
                osaVar2.s(true);
                osa fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    osaVar2.y(fileDownloadStatus.f());
                    osaVar2.u(fileDownloadStatus.b());
                    osaVar2.o(fileDownloadStatus.a());
                    osaVar2.x(fileDownloadStatus.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                osaVar2.s(true);
                osa fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    osaVar2.y(fileDownloadProgress.f());
                    osaVar2.u(fileDownloadProgress.b());
                    osaVar2.o(fileDownloadProgress.a());
                    osaVar2.x(fileDownloadProgress.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                osaVar2.s(true);
                osa fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    osaVar2.y(fileDownloadPause.f());
                    osaVar2.u(fileDownloadPause.b());
                    osaVar2.o(fileDownloadPause.a());
                    osaVar2.x(fileDownloadPause.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                osaVar2.s(true);
                osa fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    osaVar2.y(fileDownloadDelete.f());
                    osaVar2.u(fileDownloadDelete.b());
                    osaVar2.o(fileDownloadDelete.a());
                    osaVar2.x(fileDownloadDelete.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                osaVar2.s(true);
                osa installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    osaVar2.y(installGameApk.f());
                    osaVar2.u(installGameApk.b());
                    osaVar2.o(installGameApk.a());
                    osaVar2.x(installGameApk.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                osaVar2.s(true);
                osa launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    osaVar2.y(launchApk.f());
                    osaVar2.u(launchApk.b());
                    osaVar2.o(launchApk.a());
                    osaVar2.x(launchApk.e());
                }
                osaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                osaVar2.s(true);
                osa wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    osaVar2.y(wakeKeyboard.f());
                    osaVar2.u(wakeKeyboard.b());
                    osaVar2.o(wakeKeyboard.a());
                    osaVar2.x(wakeKeyboard.e());
                }
                osaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                osaVar2.s(true);
                osa replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    osaVar2.y(replyPost.f());
                    osaVar2.u(replyPost.b());
                    osaVar2.o(replyPost.a());
                    osaVar2.x(replyPost.e());
                    if (!osaVar2.h()) {
                        i8 = 0;
                        osaVar2.n(false);
                        addObserver("replyPostResult", osaVar2, false);
                        osaVar2.z(i8);
                    }
                }
                i8 = 0;
                osaVar2.z(i8);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                osaVar2.s(true);
                osa nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    osaVar2.y(nativeNetworkProxy.f());
                    osaVar2.u(nativeNetworkProxy.b());
                    osaVar2.o(nativeNetworkProxy.a());
                    osaVar2.x(nativeNetworkProxy.e());
                    if (!osaVar2.h()) {
                        i7 = 0;
                        osaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", osaVar2, false);
                        osaVar2.z(i7);
                    }
                }
                i7 = 0;
                osaVar2.z(i7);
            } else if (b.equals("host/sendMsg")) {
                osaVar2.s(true);
                osa sendMessage = this.mJsBridge.sendMessage(e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (sendMessage != null) {
                    osaVar2.y(sendMessage.f());
                    osaVar2.u(sendMessage.b());
                    osaVar2.o(sendMessage.a());
                    osaVar2.x(sendMessage.e());
                    if (!osaVar2.h()) {
                        i6 = 0;
                        osaVar2.n(false);
                        addObserver("sendMsg", osaVar2, false);
                        osaVar2.z(i6);
                    }
                }
                i6 = 0;
                osaVar2.z(i6);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                osaVar2.s(true);
                osa fetchHistoryMsgs = this.mJsBridge.fetchHistoryMsgs(e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (fetchHistoryMsgs != null) {
                    osaVar2.y(fetchHistoryMsgs.f());
                    osaVar2.u(fetchHistoryMsgs.b());
                    osaVar2.o(fetchHistoryMsgs.a());
                    osaVar2.x(fetchHistoryMsgs.e());
                    if (!osaVar2.h()) {
                        i5 = 0;
                        osaVar2.n(false);
                        addObserver("fetchHistoryMsgs", osaVar2, false);
                        osaVar2.z(i5);
                    }
                }
                i5 = 0;
                osaVar2.z(i5);
            } else if (b.equals("host/receiveNewMsgs")) {
                osaVar2.s(true);
                osa receiveNewMsgs = this.mJsBridge.receiveNewMsgs();
                this.mNotificationNameList.add("receiveNewMsgs");
                if (receiveNewMsgs != null) {
                    osaVar2.y(receiveNewMsgs.f());
                    osaVar2.u(receiveNewMsgs.b());
                    osaVar2.o(receiveNewMsgs.a());
                    osaVar2.x(receiveNewMsgs.e());
                    if (!osaVar2.h()) {
                        i4 = 0;
                        osaVar2.n(false);
                        addObserver("receiveNewMsgs", osaVar2, false);
                        osaVar2.z(i4);
                    }
                }
                i4 = 0;
                osaVar2.z(i4);
            } else if (b.equals("system/keyboardHeightChange")) {
                osaVar2.s(true);
                osa keyboardHeightChange = this.mJsBridge.keyboardHeightChange();
                this.mNotificationNameList.add("keyboardHeightChange");
                if (keyboardHeightChange != null) {
                    osaVar2.y(keyboardHeightChange.f());
                    osaVar2.u(keyboardHeightChange.b());
                    osaVar2.o(keyboardHeightChange.a());
                    osaVar2.x(keyboardHeightChange.e());
                    if (!osaVar2.h()) {
                        i3 = 0;
                        osaVar2.n(false);
                        addObserver("keyboardHeightChange", osaVar2, false);
                        osaVar2.z(i3);
                    }
                }
                i3 = 0;
                osaVar2.z(i3);
            } else if (b.equals("host/preloadPic")) {
                osaVar2.s(true);
                ArrayList<String> arrayList6 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList6, e.optJSONArray("url"));
                osa perloadPicModule = this.mJsBridge.perloadPicModule(arrayList6);
                if (perloadPicModule != null) {
                    osaVar2.y(perloadPicModule.f());
                    osaVar2.u(perloadPicModule.b());
                    osaVar2.o(perloadPicModule.a());
                    osaVar2.x(perloadPicModule.e());
                }
                osaVar2.z(0);
            } else if (b.equals("toast/showDialog")) {
                osaVar2.s(true);
                osa showDialog = this.mJsBridge.showDialog(e.optInt("type"), e.optString("content"), e.optString("dialogId"));
                this.mNotificationNameList.add("showDialog");
                if (showDialog != null) {
                    osaVar2.y(showDialog.f());
                    osaVar2.u(showDialog.b());
                    osaVar2.o(showDialog.a());
                    osaVar2.x(showDialog.e());
                    if (!osaVar2.h()) {
                        i2 = 0;
                        osaVar2.n(false);
                        addObserver("showDialog", osaVar2, false);
                        osaVar2.z(i2);
                    }
                }
                i2 = 0;
                osaVar2.z(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                osaVar2.s(true);
                osa requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    osaVar2.y(requestByNative.f());
                    osaVar2.u(requestByNative.b());
                    osaVar2.o(requestByNative.a());
                    osaVar2.x(requestByNative.e());
                    if (!osaVar2.h()) {
                        i = 0;
                        osaVar2.n(false);
                        addObserver("RequestByNativeToH5", osaVar2, false);
                        osaVar2.z(i);
                    }
                }
                i = 0;
                osaVar2.z(i);
            }
            return osaVar2;
        }
        return (osa) invokeLL.objValue;
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

    @Override // com.baidu.tieba.msa
    public List<osa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            osa osaVar = null;
            if (qd.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                osaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                osaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                osaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                osaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                osaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                osaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                osaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                osaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                osaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                osaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                osaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                osaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                osaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                osaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                osaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                osaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                osaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                osaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                osaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                osaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                osaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                osaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                osaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                osaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                osaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                osaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                osaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                osaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                osaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                osaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("sendMsg")) {
                osaVar = this.mJsBridge.onSendMsgResult(hashMap);
            } else if (str.equals("handleAudioMsgByTTS")) {
                osaVar = this.mJsBridge.handleVoiceMsgResult(hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                osaVar = this.mJsBridge.onFetchHistoryMsgsResult(hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                osaVar = this.mJsBridge.onReceiveNewMsgsResult(hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                osaVar = this.mJsBridge.onKeyboardHeightChange(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                osaVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (osaVar != null) {
                osaVar.z(0);
            }
            List<nsa> list = this.mAsyncCallBackMethodList.get(str);
            if (osaVar != null && list != null) {
                Iterator<nsa> it = list.iterator();
                if (!qd.isEmpty(osaVar.e())) {
                    while (it.hasNext()) {
                        nsa next = it.next();
                        if (next.b().equals(osaVar.e())) {
                            osa osaVar2 = new osa();
                            osaVar2.w(next.a());
                            osaVar2.y(osaVar.f());
                            osaVar2.u(osaVar.b());
                            osaVar2.o(osaVar.a());
                            osaVar2.A(osaVar.l());
                            arrayList.add(osaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        nsa next2 = it.next();
                        osa osaVar3 = new osa();
                        osaVar3.w(next2.a());
                        osaVar3.y(osaVar.f());
                        osaVar3.u(osaVar.b());
                        osaVar3.o(osaVar.a());
                        osaVar3.A(osaVar.l());
                        arrayList.add(osaVar3);
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
