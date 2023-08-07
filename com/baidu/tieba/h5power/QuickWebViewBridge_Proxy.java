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
import com.baidu.tieba.bi;
import com.baidu.tieba.hca;
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.lca;
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
/* loaded from: classes6.dex */
public class QuickWebViewBridge_Proxy extends hca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.hca
    public jca dispatch(lca lcaVar, jca jcaVar) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lcaVar, jcaVar)) == null) {
            jca jcaVar2 = jcaVar == null ? new jca() : jcaVar;
            String b = lcaVar.b();
            JSONObject e = lcaVar.e();
            if (b.equals("account/startLoginModule")) {
                jcaVar2.s(true);
                jca startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    jcaVar2.y(startLoginModule.f());
                    jcaVar2.u(startLoginModule.b());
                    jcaVar2.o(startLoginModule.a());
                    jcaVar2.x(startLoginModule.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("account/authState")) {
                jcaVar2.s(true);
                jca checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    jcaVar2.y(checkAuthState.f());
                    jcaVar2.u(checkAuthState.b());
                    jcaVar2.o(checkAuthState.a());
                    jcaVar2.x(checkAuthState.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                jcaVar2.s(true);
                jca startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    jcaVar2.y(startAllLoginModule.f());
                    jcaVar2.u(startAllLoginModule.b());
                    jcaVar2.o(startAllLoginModule.a());
                    jcaVar2.x(startAllLoginModule.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver("commonLogin", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                jcaVar2.s(true);
                jca realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    jcaVar2.y(realNameAuth.f());
                    jcaVar2.u(realNameAuth.b());
                    jcaVar2.o(realNameAuth.a());
                    jcaVar2.x(realNameAuth.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver("realNameAuthResult", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                jcaVar2.s(true);
                jca finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    jcaVar2.y(finishPage.f());
                    jcaVar2.u(finishPage.b());
                    jcaVar2.o(finishPage.a());
                    jcaVar2.x(finishPage.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                jcaVar2.s(true);
                jca showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    jcaVar2.y(showLowerHairHint.f());
                    jcaVar2.u(showLowerHairHint.b());
                    jcaVar2.o(showLowerHairHint.a());
                    jcaVar2.x(showLowerHairHint.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                jcaVar2.s(true);
                jca gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    jcaVar2.y(gamePush.f());
                    jcaVar2.u(gamePush.b());
                    jcaVar2.o(gamePush.a());
                    jcaVar2.x(gamePush.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                jcaVar2.s(true);
                jca handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    jcaVar2.y(handleGamePushStatus.f());
                    jcaVar2.u(handleGamePushStatus.b());
                    jcaVar2.o(handleGamePushStatus.a());
                    jcaVar2.x(handleGamePushStatus.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                jcaVar2.s(true);
                jca jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    jcaVar2.y(jumpForumRulesEditPage.f());
                    jcaVar2.u(jumpForumRulesEditPage.b());
                    jcaVar2.o(jumpForumRulesEditPage.a());
                    jcaVar2.x(jumpForumRulesEditPage.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                jcaVar2.s(true);
                jca handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    jcaVar2.y(handleGoToBarDetail.f());
                    jcaVar2.u(handleGoToBarDetail.b());
                    jcaVar2.o(handleGoToBarDetail.a());
                    jcaVar2.x(handleGoToBarDetail.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                jcaVar2.s(true);
                jca handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    jcaVar2.y(handleSaveImage.f());
                    jcaVar2.u(handleSaveImage.b());
                    jcaVar2.o(handleSaveImage.a());
                    jcaVar2.x(handleSaveImage.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver("saveImageSuccess", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                jcaVar2.s(true);
                jca orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    jcaVar2.y(orderGameApk.f());
                    jcaVar2.u(orderGameApk.b());
                    jcaVar2.o(orderGameApk.a());
                    jcaVar2.x(orderGameApk.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver("orderGameApkResult", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                jcaVar2.s(true);
                jca handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    jcaVar2.y(handleGetPhotoAlbum.f());
                    jcaVar2.u(handleGetPhotoAlbum.b());
                    jcaVar2.o(handleGetPhotoAlbum.a());
                    jcaVar2.x(handleGetPhotoAlbum.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver("GetPhotoAlbum", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                jcaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                jca preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    jcaVar2.y(preheatWeb.f());
                    jcaVar2.u(preheatWeb.b());
                    jcaVar2.o(preheatWeb.a());
                    jcaVar2.x(preheatWeb.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                jcaVar2.s(true);
                jca openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    jcaVar2.y(openMXDYab.f());
                    jcaVar2.u(openMXDYab.b());
                    jcaVar2.o(openMXDYab.a());
                    jcaVar2.x(openMXDYab.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/portal")) {
                jcaVar2.s(true);
                jca handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (handlePortal != null) {
                    jcaVar2.y(handlePortal.f());
                    jcaVar2.u(handlePortal.b());
                    jcaVar2.o(handlePortal.a());
                    jcaVar2.x(handlePortal.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                jcaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                jca selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    jcaVar2.y(selectPhotoAlbum.f());
                    jcaVar2.u(selectPhotoAlbum.b());
                    jcaVar2.o(selectPhotoAlbum.a());
                    jcaVar2.x(selectPhotoAlbum.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver("selectPhotoAlbum", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                jcaVar2.s(true);
                jca operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    jcaVar2.y(operateNotifyDataChanged.f());
                    jcaVar2.u(operateNotifyDataChanged.b());
                    jcaVar2.o(operateNotifyDataChanged.a());
                    jcaVar2.x(operateNotifyDataChanged.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                jcaVar2.s(true);
                jca viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    jcaVar2.y(viewPosition.f());
                    jcaVar2.u(viewPosition.b());
                    jcaVar2.o(viewPosition.a());
                    jcaVar2.x(viewPosition.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                jcaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                jca selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    jcaVar2.y(selectPrivateMsg.f());
                    jcaVar2.u(selectPrivateMsg.b());
                    jcaVar2.o(selectPrivateMsg.a());
                    jcaVar2.x(selectPrivateMsg.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                jcaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                jca reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    jcaVar2.y(reportUserTheme.f());
                    jcaVar2.u(reportUserTheme.b());
                    jcaVar2.o(reportUserTheme.a());
                    jcaVar2.x(reportUserTheme.e());
                    if (!jcaVar2.h()) {
                        jcaVar2.n(false);
                        addObserver("goToReportThreadPage", jcaVar2, false);
                    }
                }
                jcaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                jcaVar2.s(true);
                jca playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    jcaVar2.y(playSound.f());
                    jcaVar2.u(playSound.b());
                    jcaVar2.o(playSound.a());
                    jcaVar2.x(playSound.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                jcaVar2.s(true);
                jca playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    jcaVar2.y(playVibrate.f());
                    jcaVar2.u(playVibrate.b());
                    jcaVar2.o(playVibrate.a());
                    jcaVar2.x(playVibrate.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                jcaVar2.s(true);
                jca localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    jcaVar2.y(localYaLog.f());
                    jcaVar2.u(localYaLog.b());
                    jcaVar2.o(localYaLog.a());
                    jcaVar2.x(localYaLog.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                jcaVar2.s(true);
                jca jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    jcaVar2.y(jumpLoginActivity.f());
                    jcaVar2.u(jumpLoginActivity.b());
                    jcaVar2.o(jumpLoginActivity.a());
                    jcaVar2.x(jumpLoginActivity.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                jcaVar2.s(true);
                jca startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    jcaVar2.y(startLoadTimeInterval.f());
                    jcaVar2.u(startLoadTimeInterval.b());
                    jcaVar2.o(startLoadTimeInterval.a());
                    jcaVar2.x(startLoadTimeInterval.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                jcaVar2.s(true);
                jca zid = this.mJsBridge.getZid();
                if (zid != null) {
                    jcaVar2.y(zid.f());
                    jcaVar2.u(zid.b());
                    jcaVar2.o(zid.a());
                    jcaVar2.x(zid.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                jcaVar2.s(true);
                jca hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    jcaVar2.y(hdid.f());
                    jcaVar2.u(hdid.b());
                    jcaVar2.o(hdid.a());
                    jcaVar2.x(hdid.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                jcaVar2.s(true);
                jca shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    jcaVar2.y(shareInfo.f());
                    jcaVar2.u(shareInfo.b());
                    jcaVar2.o(shareInfo.a());
                    jcaVar2.x(shareInfo.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("share/share")) {
                jcaVar2.s(true);
                jca share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    jcaVar2.y(share.f());
                    jcaVar2.u(share.b());
                    jcaVar2.o(share.a());
                    jcaVar2.x(share.e());
                    if (!jcaVar2.h()) {
                        i7 = 0;
                        jcaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, jcaVar2, false);
                        jcaVar2.z(i7);
                    }
                }
                i7 = 0;
                jcaVar2.z(i7);
            } else if (b.equals("clipper/getClipperInformation")) {
                jcaVar2.s(true);
                jca clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    jcaVar2.y(clipperInformation.f());
                    jcaVar2.u(clipperInformation.b());
                    jcaVar2.o(clipperInformation.a());
                    jcaVar2.x(clipperInformation.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                jcaVar2.s(true);
                jca clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    jcaVar2.y(clipperInformation2.f());
                    jcaVar2.u(clipperInformation2.b());
                    jcaVar2.o(clipperInformation2.a());
                    jcaVar2.x(clipperInformation2.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                jcaVar2.s(true);
                jca goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    jcaVar2.y(goToEditPost.f());
                    jcaVar2.u(goToEditPost.b());
                    jcaVar2.o(goToEditPost.a());
                    jcaVar2.x(goToEditPost.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                jcaVar2.s(true);
                jca updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    jcaVar2.y(updateSearchForumInfo.f());
                    jcaVar2.u(updateSearchForumInfo.b());
                    jcaVar2.o(updateSearchForumInfo.a());
                    jcaVar2.x(updateSearchForumInfo.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                jcaVar2.s(true);
                jca personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    jcaVar2.y(personlizedSwitchChange.f());
                    jcaVar2.u(personlizedSwitchChange.b());
                    jcaVar2.o(personlizedSwitchChange.a());
                    jcaVar2.x(personlizedSwitchChange.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                jcaVar2.s(true);
                jca updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    jcaVar2.y(updateTailStyle.f());
                    jcaVar2.u(updateTailStyle.b());
                    jcaVar2.o(updateTailStyle.a());
                    jcaVar2.x(updateTailStyle.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                jcaVar2.s(true);
                jca goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    jcaVar2.y(goToVideoImmersivePage.f());
                    jcaVar2.u(goToVideoImmersivePage.b());
                    jcaVar2.o(goToVideoImmersivePage.a());
                    jcaVar2.x(goToVideoImmersivePage.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                jcaVar2.s(true);
                jca jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    jcaVar2.y(jumpToVideo.f());
                    jcaVar2.u(jumpToVideo.b());
                    jcaVar2.o(jumpToVideo.a());
                    jcaVar2.x(jumpToVideo.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                jcaVar2.s(true);
                jca closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    jcaVar2.y(closeNativeMask.f());
                    jcaVar2.u(closeNativeMask.b());
                    jcaVar2.o(closeNativeMask.a());
                    jcaVar2.x(closeNativeMask.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                jcaVar2.s(true);
                jca oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    jcaVar2.y(oneKeyDeletion.f());
                    jcaVar2.u(oneKeyDeletion.b());
                    jcaVar2.o(oneKeyDeletion.a());
                    jcaVar2.x(oneKeyDeletion.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                jcaVar2.s(true);
                jca checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    jcaVar2.y(checkAppInstall.f());
                    jcaVar2.u(checkAppInstall.b());
                    jcaVar2.o(checkAppInstall.a());
                    jcaVar2.x(checkAppInstall.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                jcaVar2.s(true);
                jca disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    jcaVar2.y(disableBack.f());
                    jcaVar2.u(disableBack.b());
                    jcaVar2.o(disableBack.a());
                    jcaVar2.x(disableBack.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                jcaVar2.s(true);
                jca startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    jcaVar2.y(startApp.f());
                    jcaVar2.u(startApp.b());
                    jcaVar2.o(startApp.a());
                    jcaVar2.x(startApp.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                jcaVar2.s(true);
                jca hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    jcaVar2.y(hasNotificationPermission.f());
                    jcaVar2.u(hasNotificationPermission.b());
                    jcaVar2.o(hasNotificationPermission.a());
                    jcaVar2.x(hasNotificationPermission.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                jcaVar2.s(true);
                jca goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    jcaVar2.y(goToNotificationSetting.f());
                    jcaVar2.u(goToNotificationSetting.b());
                    jcaVar2.o(goToNotificationSetting.a());
                    jcaVar2.x(goToNotificationSetting.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                jcaVar2.s(true);
                jca startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    jcaVar2.y(startDownloadGameApk.f());
                    jcaVar2.u(startDownloadGameApk.b());
                    jcaVar2.o(startDownloadGameApk.a());
                    jcaVar2.x(startDownloadGameApk.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                jcaVar2.s(true);
                jca checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    jcaVar2.y(checkInstallGameApk.f());
                    jcaVar2.u(checkInstallGameApk.b());
                    jcaVar2.o(checkInstallGameApk.a());
                    jcaVar2.x(checkInstallGameApk.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                jcaVar2.s(true);
                jca startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    jcaVar2.y(startDownloadCss.f());
                    jcaVar2.u(startDownloadCss.b());
                    jcaVar2.o(startDownloadCss.a());
                    jcaVar2.x(startDownloadCss.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                jcaVar2.s(true);
                jca disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    jcaVar2.y(disableGoBack.f());
                    jcaVar2.u(disableGoBack.b());
                    jcaVar2.o(disableGoBack.a());
                    jcaVar2.x(disableGoBack.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                jcaVar2.s(true);
                jca supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    jcaVar2.y(supplementInfo.f());
                    jcaVar2.u(supplementInfo.b());
                    jcaVar2.o(supplementInfo.a());
                    jcaVar2.x(supplementInfo.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                jcaVar2.s(true);
                jca deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    jcaVar2.y(deviceGyroscopeParams.f());
                    jcaVar2.u(deviceGyroscopeParams.b());
                    jcaVar2.o(deviceGyroscopeParams.a());
                    jcaVar2.x(deviceGyroscopeParams.e());
                    if (!jcaVar2.h()) {
                        i6 = 0;
                        jcaVar2.n(false);
                        addObserver("deviceMotion", jcaVar2, false);
                        jcaVar2.z(i6);
                    }
                }
                i6 = 0;
                jcaVar2.z(i6);
            } else if (b.equals("device/deviceRefreshRate")) {
                jcaVar2.s(true);
                jca deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    jcaVar2.y(deviceRefreshRateParams.f());
                    jcaVar2.u(deviceRefreshRateParams.b());
                    jcaVar2.o(deviceRefreshRateParams.a());
                    jcaVar2.x(deviceRefreshRateParams.e());
                    if (!jcaVar2.h()) {
                        i5 = 0;
                        jcaVar2.n(false);
                        addObserver("deviceRefreshRate", jcaVar2, false);
                        jcaVar2.z(i5);
                    }
                }
                i5 = 0;
                jcaVar2.z(i5);
            } else if (b.equals("device/getDeviceInfo")) {
                jcaVar2.s(true);
                jca deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    jcaVar2.y(deviceInfo.f());
                    jcaVar2.u(deviceInfo.b());
                    jcaVar2.o(deviceInfo.a());
                    jcaVar2.x(deviceInfo.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                jcaVar2.s(true);
                jca sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    jcaVar2.y(sendCompleteTaskReqMsg.f());
                    jcaVar2.u(sendCompleteTaskReqMsg.b());
                    jcaVar2.o(sendCompleteTaskReqMsg.a());
                    jcaVar2.x(sendCompleteTaskReqMsg.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                jcaVar2.s(true);
                jca showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    jcaVar2.y(showTipToast.f());
                    jcaVar2.u(showTipToast.b());
                    jcaVar2.o(showTipToast.a());
                    jcaVar2.x(showTipToast.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                jcaVar2.s(true);
                jca getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    jcaVar2.y(getModalData.f());
                    jcaVar2.u(getModalData.b());
                    jcaVar2.o(getModalData.a());
                    jcaVar2.x(getModalData.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                jcaVar2.s(true);
                jca openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    jcaVar2.y(openThirdPartApp.f());
                    jcaVar2.u(openThirdPartApp.b());
                    jcaVar2.o(openThirdPartApp.a());
                    jcaVar2.x(openThirdPartApp.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                jcaVar2.s(true);
                jca jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    jcaVar2.y(jumpToHtmlPage.f());
                    jcaVar2.u(jumpToHtmlPage.b());
                    jcaVar2.o(jumpToHtmlPage.a());
                    jcaVar2.x(jumpToHtmlPage.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                jcaVar2.s(true);
                jca offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    jcaVar2.y(offlineUserInfo.f());
                    jcaVar2.u(offlineUserInfo.b());
                    jcaVar2.o(offlineUserInfo.a());
                    jcaVar2.x(offlineUserInfo.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                jcaVar2.s(true);
                jca deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    jcaVar2.y(deleteOfflineBundle.f());
                    jcaVar2.u(deleteOfflineBundle.b());
                    jcaVar2.o(deleteOfflineBundle.a());
                    jcaVar2.x(deleteOfflineBundle.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                jcaVar2.s(true);
                jca updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    jcaVar2.y(updateOfflineBundle.f());
                    jcaVar2.u(updateOfflineBundle.b());
                    jcaVar2.o(updateOfflineBundle.a());
                    jcaVar2.x(updateOfflineBundle.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                jcaVar2.s(true);
                jca switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    jcaVar2.y(switchOfflineInterface.f());
                    jcaVar2.u(switchOfflineInterface.b());
                    jcaVar2.o(switchOfflineInterface.a());
                    jcaVar2.x(switchOfflineInterface.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                jcaVar2.s(true);
                jca switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    jcaVar2.y(switchOfflineBundleStatus.f());
                    jcaVar2.u(switchOfflineBundleStatus.b());
                    jcaVar2.o(switchOfflineBundleStatus.a());
                    jcaVar2.x(switchOfflineBundleStatus.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                jcaVar2.s(true);
                jca finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    jcaVar2.y(finishTestAnswer.f());
                    jcaVar2.u(finishTestAnswer.b());
                    jcaVar2.o(finishTestAnswer.a());
                    jcaVar2.x(finishTestAnswer.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                jcaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                jca switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    jcaVar2.y(switchUrlHost.f());
                    jcaVar2.u(switchUrlHost.b());
                    jcaVar2.o(switchUrlHost.a());
                    jcaVar2.x(switchUrlHost.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                jcaVar2.s(true);
                jca appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    jcaVar2.y(appStorage.f());
                    jcaVar2.u(appStorage.b());
                    jcaVar2.o(appStorage.a());
                    jcaVar2.x(appStorage.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                jcaVar2.s(true);
                jca putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    jcaVar2.y(putAppStorage.f());
                    jcaVar2.u(putAppStorage.b());
                    jcaVar2.o(putAppStorage.a());
                    jcaVar2.x(putAppStorage.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                jcaVar2.s(true);
                jca historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    jcaVar2.y(historyForumData.f());
                    jcaVar2.u(historyForumData.b());
                    jcaVar2.o(historyForumData.a());
                    jcaVar2.x(historyForumData.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                jcaVar2.s(true);
                jca worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    jcaVar2.y(worldCupRaiseSuccess.f());
                    jcaVar2.u(worldCupRaiseSuccess.b());
                    jcaVar2.o(worldCupRaiseSuccess.a());
                    jcaVar2.x(worldCupRaiseSuccess.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                jcaVar2.s(true);
                jca alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    jcaVar2.y(alipayUserId.f());
                    jcaVar2.u(alipayUserId.b());
                    jcaVar2.o(alipayUserId.a());
                    jcaVar2.x(alipayUserId.e());
                    if (!jcaVar2.h()) {
                        i4 = 0;
                        jcaVar2.n(false);
                        addObserver("aliAuthResult", jcaVar2, false);
                        jcaVar2.z(i4);
                    }
                }
                i4 = 0;
                jcaVar2.z(i4);
            } else if (b.equals("system/getFileDownloadStatus")) {
                jcaVar2.s(true);
                jca fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    jcaVar2.y(fileDownloadStatus.f());
                    jcaVar2.u(fileDownloadStatus.b());
                    jcaVar2.o(fileDownloadStatus.a());
                    jcaVar2.x(fileDownloadStatus.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                jcaVar2.s(true);
                jca fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    jcaVar2.y(fileDownloadProgress.f());
                    jcaVar2.u(fileDownloadProgress.b());
                    jcaVar2.o(fileDownloadProgress.a());
                    jcaVar2.x(fileDownloadProgress.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                jcaVar2.s(true);
                jca fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    jcaVar2.y(fileDownloadPause.f());
                    jcaVar2.u(fileDownloadPause.b());
                    jcaVar2.o(fileDownloadPause.a());
                    jcaVar2.x(fileDownloadPause.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                jcaVar2.s(true);
                jca fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    jcaVar2.y(fileDownloadDelete.f());
                    jcaVar2.u(fileDownloadDelete.b());
                    jcaVar2.o(fileDownloadDelete.a());
                    jcaVar2.x(fileDownloadDelete.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                jcaVar2.s(true);
                jca installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    jcaVar2.y(installGameApk.f());
                    jcaVar2.u(installGameApk.b());
                    jcaVar2.o(installGameApk.a());
                    jcaVar2.x(installGameApk.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                jcaVar2.s(true);
                jca launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    jcaVar2.y(launchApk.f());
                    jcaVar2.u(launchApk.b());
                    jcaVar2.o(launchApk.a());
                    jcaVar2.x(launchApk.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                jcaVar2.s(true);
                jca wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    jcaVar2.y(wakeKeyboard.f());
                    jcaVar2.u(wakeKeyboard.b());
                    jcaVar2.o(wakeKeyboard.a());
                    jcaVar2.x(wakeKeyboard.e());
                }
                jcaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                jcaVar2.s(true);
                jca replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    jcaVar2.y(replyPost.f());
                    jcaVar2.u(replyPost.b());
                    jcaVar2.o(replyPost.a());
                    jcaVar2.x(replyPost.e());
                    if (!jcaVar2.h()) {
                        i3 = 0;
                        jcaVar2.n(false);
                        addObserver("replyPostResult", jcaVar2, false);
                        jcaVar2.z(i3);
                    }
                }
                i3 = 0;
                jcaVar2.z(i3);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                jcaVar2.s(true);
                jca nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    jcaVar2.y(nativeNetworkProxy.f());
                    jcaVar2.u(nativeNetworkProxy.b());
                    jcaVar2.o(nativeNetworkProxy.a());
                    jcaVar2.x(nativeNetworkProxy.e());
                    if (!jcaVar2.h()) {
                        i2 = 0;
                        jcaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", jcaVar2, false);
                        jcaVar2.z(i2);
                    }
                }
                i2 = 0;
                jcaVar2.z(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                jcaVar2.s(true);
                jca requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    jcaVar2.y(requestByNative.f());
                    jcaVar2.u(requestByNative.b());
                    jcaVar2.o(requestByNative.a());
                    jcaVar2.x(requestByNative.e());
                    if (!jcaVar2.h()) {
                        i = 0;
                        jcaVar2.n(false);
                        addObserver("RequestByNativeToH5", jcaVar2, false);
                        jcaVar2.z(i);
                    }
                }
                i = 0;
                jcaVar2.z(i);
            }
            return jcaVar2;
        }
        return (jca) invokeLL.objValue;
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
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.hca
    public List<jca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            jca jcaVar = null;
            if (bi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                jcaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                jcaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                jcaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                jcaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                jcaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                jcaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                jcaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                jcaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                jcaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                jcaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                jcaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                jcaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                jcaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                jcaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                jcaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                jcaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                jcaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                jcaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                jcaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                jcaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                jcaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                jcaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                jcaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                jcaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                jcaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                jcaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                jcaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                jcaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                jcaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                jcaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                jcaVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (jcaVar != null) {
                jcaVar.z(0);
            }
            List<ica> list = this.mAsyncCallBackMethodList.get(str);
            if (jcaVar != null && list != null) {
                Iterator<ica> it = list.iterator();
                if (!bi.isEmpty(jcaVar.e())) {
                    while (it.hasNext()) {
                        ica next = it.next();
                        if (next.b().equals(jcaVar.e())) {
                            jca jcaVar2 = new jca();
                            jcaVar2.w(next.a());
                            jcaVar2.y(jcaVar.f());
                            jcaVar2.u(jcaVar.b());
                            jcaVar2.o(jcaVar.a());
                            jcaVar2.A(jcaVar.l());
                            arrayList.add(jcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ica next2 = it.next();
                        jca jcaVar3 = new jca();
                        jcaVar3.w(next2.a());
                        jcaVar3.y(jcaVar.f());
                        jcaVar3.u(jcaVar.b());
                        jcaVar3.o(jcaVar.a());
                        jcaVar3.A(jcaVar.l());
                        arrayList.add(jcaVar3);
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
