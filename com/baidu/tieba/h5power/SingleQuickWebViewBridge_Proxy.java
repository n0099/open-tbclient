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
import com.baidu.tieba.ica;
import com.baidu.tieba.jca;
import com.baidu.tieba.kca;
import com.baidu.tieba.mca;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
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
public class SingleQuickWebViewBridge_Proxy extends ica {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.ica
    public kca dispatch(mca mcaVar, kca kcaVar) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mcaVar, kcaVar)) == null) {
            kca kcaVar2 = kcaVar == null ? new kca() : kcaVar;
            String b = mcaVar.b();
            JSONObject e = mcaVar.e();
            if (b.equals("account/startLoginModule")) {
                kcaVar2.s(true);
                kca startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    kcaVar2.y(startLoginModule.f());
                    kcaVar2.u(startLoginModule.b());
                    kcaVar2.o(startLoginModule.a());
                    kcaVar2.x(startLoginModule.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("account/authState")) {
                kcaVar2.s(true);
                kca checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    kcaVar2.y(checkAuthState.f());
                    kcaVar2.u(checkAuthState.b());
                    kcaVar2.o(checkAuthState.a());
                    kcaVar2.x(checkAuthState.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                kcaVar2.s(true);
                kca startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    kcaVar2.y(startAllLoginModule.f());
                    kcaVar2.u(startAllLoginModule.b());
                    kcaVar2.o(startAllLoginModule.a());
                    kcaVar2.x(startAllLoginModule.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver("commonLogin", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                kcaVar2.s(true);
                kca realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    kcaVar2.y(realNameAuth.f());
                    kcaVar2.u(realNameAuth.b());
                    kcaVar2.o(realNameAuth.a());
                    kcaVar2.x(realNameAuth.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver("realNameAuthResult", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                kcaVar2.s(true);
                kca finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    kcaVar2.y(finishPage.f());
                    kcaVar2.u(finishPage.b());
                    kcaVar2.o(finishPage.a());
                    kcaVar2.x(finishPage.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                kcaVar2.s(true);
                kca showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    kcaVar2.y(showLowerHairHint.f());
                    kcaVar2.u(showLowerHairHint.b());
                    kcaVar2.o(showLowerHairHint.a());
                    kcaVar2.x(showLowerHairHint.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                kcaVar2.s(true);
                kca gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    kcaVar2.y(gamePush.f());
                    kcaVar2.u(gamePush.b());
                    kcaVar2.o(gamePush.a());
                    kcaVar2.x(gamePush.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                kcaVar2.s(true);
                kca handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    kcaVar2.y(handleGamePushStatus.f());
                    kcaVar2.u(handleGamePushStatus.b());
                    kcaVar2.o(handleGamePushStatus.a());
                    kcaVar2.x(handleGamePushStatus.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                kcaVar2.s(true);
                kca jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    kcaVar2.y(jumpForumRulesEditPage.f());
                    kcaVar2.u(jumpForumRulesEditPage.b());
                    kcaVar2.o(jumpForumRulesEditPage.a());
                    kcaVar2.x(jumpForumRulesEditPage.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                kcaVar2.s(true);
                kca handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    kcaVar2.y(handleGoToBarDetail.f());
                    kcaVar2.u(handleGoToBarDetail.b());
                    kcaVar2.o(handleGoToBarDetail.a());
                    kcaVar2.x(handleGoToBarDetail.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                kcaVar2.s(true);
                kca handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    kcaVar2.y(handleSaveImage.f());
                    kcaVar2.u(handleSaveImage.b());
                    kcaVar2.o(handleSaveImage.a());
                    kcaVar2.x(handleSaveImage.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver("saveImageSuccess", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                kcaVar2.s(true);
                kca orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    kcaVar2.y(orderGameApk.f());
                    kcaVar2.u(orderGameApk.b());
                    kcaVar2.o(orderGameApk.a());
                    kcaVar2.x(orderGameApk.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver("orderGameApkResult", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                kcaVar2.s(true);
                kca handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    kcaVar2.y(handleGetPhotoAlbum.f());
                    kcaVar2.u(handleGetPhotoAlbum.b());
                    kcaVar2.o(handleGetPhotoAlbum.a());
                    kcaVar2.x(handleGetPhotoAlbum.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver("GetPhotoAlbum", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                kcaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                kca preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    kcaVar2.y(preheatWeb.f());
                    kcaVar2.u(preheatWeb.b());
                    kcaVar2.o(preheatWeb.a());
                    kcaVar2.x(preheatWeb.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                kcaVar2.s(true);
                kca openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    kcaVar2.y(openMXDYab.f());
                    kcaVar2.u(openMXDYab.b());
                    kcaVar2.o(openMXDYab.a());
                    kcaVar2.x(openMXDYab.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/portal")) {
                kcaVar2.s(true);
                kca handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (handlePortal != null) {
                    kcaVar2.y(handlePortal.f());
                    kcaVar2.u(handlePortal.b());
                    kcaVar2.o(handlePortal.a());
                    kcaVar2.x(handlePortal.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                kcaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                kca selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    kcaVar2.y(selectPhotoAlbum.f());
                    kcaVar2.u(selectPhotoAlbum.b());
                    kcaVar2.o(selectPhotoAlbum.a());
                    kcaVar2.x(selectPhotoAlbum.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver("selectPhotoAlbum", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                kcaVar2.s(true);
                kca operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    kcaVar2.y(operateNotifyDataChanged.f());
                    kcaVar2.u(operateNotifyDataChanged.b());
                    kcaVar2.o(operateNotifyDataChanged.a());
                    kcaVar2.x(operateNotifyDataChanged.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                kcaVar2.s(true);
                kca viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    kcaVar2.y(viewPosition.f());
                    kcaVar2.u(viewPosition.b());
                    kcaVar2.o(viewPosition.a());
                    kcaVar2.x(viewPosition.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                kcaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                kca selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    kcaVar2.y(selectPrivateMsg.f());
                    kcaVar2.u(selectPrivateMsg.b());
                    kcaVar2.o(selectPrivateMsg.a());
                    kcaVar2.x(selectPrivateMsg.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                kcaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                kca reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    kcaVar2.y(reportUserTheme.f());
                    kcaVar2.u(reportUserTheme.b());
                    kcaVar2.o(reportUserTheme.a());
                    kcaVar2.x(reportUserTheme.e());
                    if (!kcaVar2.h()) {
                        kcaVar2.n(false);
                        addObserver("goToReportThreadPage", kcaVar2, false);
                    }
                }
                kcaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                kcaVar2.s(true);
                kca playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    kcaVar2.y(playSound.f());
                    kcaVar2.u(playSound.b());
                    kcaVar2.o(playSound.a());
                    kcaVar2.x(playSound.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                kcaVar2.s(true);
                kca playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    kcaVar2.y(playVibrate.f());
                    kcaVar2.u(playVibrate.b());
                    kcaVar2.o(playVibrate.a());
                    kcaVar2.x(playVibrate.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                kcaVar2.s(true);
                kca localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    kcaVar2.y(localYaLog.f());
                    kcaVar2.u(localYaLog.b());
                    kcaVar2.o(localYaLog.a());
                    kcaVar2.x(localYaLog.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                kcaVar2.s(true);
                kca jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    kcaVar2.y(jumpLoginActivity.f());
                    kcaVar2.u(jumpLoginActivity.b());
                    kcaVar2.o(jumpLoginActivity.a());
                    kcaVar2.x(jumpLoginActivity.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                kcaVar2.s(true);
                kca startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    kcaVar2.y(startLoadTimeInterval.f());
                    kcaVar2.u(startLoadTimeInterval.b());
                    kcaVar2.o(startLoadTimeInterval.a());
                    kcaVar2.x(startLoadTimeInterval.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                kcaVar2.s(true);
                kca zid = this.mJsBridge.getZid();
                if (zid != null) {
                    kcaVar2.y(zid.f());
                    kcaVar2.u(zid.b());
                    kcaVar2.o(zid.a());
                    kcaVar2.x(zid.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                kcaVar2.s(true);
                kca hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    kcaVar2.y(hdid.f());
                    kcaVar2.u(hdid.b());
                    kcaVar2.o(hdid.a());
                    kcaVar2.x(hdid.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                kcaVar2.s(true);
                kca shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    kcaVar2.y(shareInfo.f());
                    kcaVar2.u(shareInfo.b());
                    kcaVar2.o(shareInfo.a());
                    kcaVar2.x(shareInfo.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("share/share")) {
                kcaVar2.s(true);
                kca share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    kcaVar2.y(share.f());
                    kcaVar2.u(share.b());
                    kcaVar2.o(share.a());
                    kcaVar2.x(share.e());
                    if (!kcaVar2.h()) {
                        i7 = 0;
                        kcaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, kcaVar2, false);
                        kcaVar2.z(i7);
                    }
                }
                i7 = 0;
                kcaVar2.z(i7);
            } else if (b.equals("clipper/getClipperInformation")) {
                kcaVar2.s(true);
                kca clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    kcaVar2.y(clipperInformation.f());
                    kcaVar2.u(clipperInformation.b());
                    kcaVar2.o(clipperInformation.a());
                    kcaVar2.x(clipperInformation.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                kcaVar2.s(true);
                kca clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    kcaVar2.y(clipperInformation2.f());
                    kcaVar2.u(clipperInformation2.b());
                    kcaVar2.o(clipperInformation2.a());
                    kcaVar2.x(clipperInformation2.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                kcaVar2.s(true);
                kca goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    kcaVar2.y(goToEditPost.f());
                    kcaVar2.u(goToEditPost.b());
                    kcaVar2.o(goToEditPost.a());
                    kcaVar2.x(goToEditPost.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                kcaVar2.s(true);
                kca updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    kcaVar2.y(updateSearchForumInfo.f());
                    kcaVar2.u(updateSearchForumInfo.b());
                    kcaVar2.o(updateSearchForumInfo.a());
                    kcaVar2.x(updateSearchForumInfo.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                kcaVar2.s(true);
                kca personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    kcaVar2.y(personlizedSwitchChange.f());
                    kcaVar2.u(personlizedSwitchChange.b());
                    kcaVar2.o(personlizedSwitchChange.a());
                    kcaVar2.x(personlizedSwitchChange.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                kcaVar2.s(true);
                kca updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    kcaVar2.y(updateTailStyle.f());
                    kcaVar2.u(updateTailStyle.b());
                    kcaVar2.o(updateTailStyle.a());
                    kcaVar2.x(updateTailStyle.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                kcaVar2.s(true);
                kca goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    kcaVar2.y(goToVideoImmersivePage.f());
                    kcaVar2.u(goToVideoImmersivePage.b());
                    kcaVar2.o(goToVideoImmersivePage.a());
                    kcaVar2.x(goToVideoImmersivePage.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                kcaVar2.s(true);
                kca jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    kcaVar2.y(jumpToVideo.f());
                    kcaVar2.u(jumpToVideo.b());
                    kcaVar2.o(jumpToVideo.a());
                    kcaVar2.x(jumpToVideo.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                kcaVar2.s(true);
                kca closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    kcaVar2.y(closeNativeMask.f());
                    kcaVar2.u(closeNativeMask.b());
                    kcaVar2.o(closeNativeMask.a());
                    kcaVar2.x(closeNativeMask.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                kcaVar2.s(true);
                kca oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    kcaVar2.y(oneKeyDeletion.f());
                    kcaVar2.u(oneKeyDeletion.b());
                    kcaVar2.o(oneKeyDeletion.a());
                    kcaVar2.x(oneKeyDeletion.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                kcaVar2.s(true);
                kca checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    kcaVar2.y(checkAppInstall.f());
                    kcaVar2.u(checkAppInstall.b());
                    kcaVar2.o(checkAppInstall.a());
                    kcaVar2.x(checkAppInstall.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                kcaVar2.s(true);
                kca disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    kcaVar2.y(disableBack.f());
                    kcaVar2.u(disableBack.b());
                    kcaVar2.o(disableBack.a());
                    kcaVar2.x(disableBack.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                kcaVar2.s(true);
                kca startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    kcaVar2.y(startApp.f());
                    kcaVar2.u(startApp.b());
                    kcaVar2.o(startApp.a());
                    kcaVar2.x(startApp.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                kcaVar2.s(true);
                kca hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    kcaVar2.y(hasNotificationPermission.f());
                    kcaVar2.u(hasNotificationPermission.b());
                    kcaVar2.o(hasNotificationPermission.a());
                    kcaVar2.x(hasNotificationPermission.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                kcaVar2.s(true);
                kca goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    kcaVar2.y(goToNotificationSetting.f());
                    kcaVar2.u(goToNotificationSetting.b());
                    kcaVar2.o(goToNotificationSetting.a());
                    kcaVar2.x(goToNotificationSetting.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                kcaVar2.s(true);
                kca startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    kcaVar2.y(startDownloadGameApk.f());
                    kcaVar2.u(startDownloadGameApk.b());
                    kcaVar2.o(startDownloadGameApk.a());
                    kcaVar2.x(startDownloadGameApk.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                kcaVar2.s(true);
                kca checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    kcaVar2.y(checkInstallGameApk.f());
                    kcaVar2.u(checkInstallGameApk.b());
                    kcaVar2.o(checkInstallGameApk.a());
                    kcaVar2.x(checkInstallGameApk.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                kcaVar2.s(true);
                kca startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    kcaVar2.y(startDownloadCss.f());
                    kcaVar2.u(startDownloadCss.b());
                    kcaVar2.o(startDownloadCss.a());
                    kcaVar2.x(startDownloadCss.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                kcaVar2.s(true);
                kca disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    kcaVar2.y(disableGoBack.f());
                    kcaVar2.u(disableGoBack.b());
                    kcaVar2.o(disableGoBack.a());
                    kcaVar2.x(disableGoBack.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                kcaVar2.s(true);
                kca supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    kcaVar2.y(supplementInfo.f());
                    kcaVar2.u(supplementInfo.b());
                    kcaVar2.o(supplementInfo.a());
                    kcaVar2.x(supplementInfo.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                kcaVar2.s(true);
                kca deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    kcaVar2.y(deviceGyroscopeParams.f());
                    kcaVar2.u(deviceGyroscopeParams.b());
                    kcaVar2.o(deviceGyroscopeParams.a());
                    kcaVar2.x(deviceGyroscopeParams.e());
                    if (!kcaVar2.h()) {
                        i6 = 0;
                        kcaVar2.n(false);
                        addObserver("deviceMotion", kcaVar2, false);
                        kcaVar2.z(i6);
                    }
                }
                i6 = 0;
                kcaVar2.z(i6);
            } else if (b.equals("device/deviceRefreshRate")) {
                kcaVar2.s(true);
                kca deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    kcaVar2.y(deviceRefreshRateParams.f());
                    kcaVar2.u(deviceRefreshRateParams.b());
                    kcaVar2.o(deviceRefreshRateParams.a());
                    kcaVar2.x(deviceRefreshRateParams.e());
                    if (!kcaVar2.h()) {
                        i5 = 0;
                        kcaVar2.n(false);
                        addObserver("deviceRefreshRate", kcaVar2, false);
                        kcaVar2.z(i5);
                    }
                }
                i5 = 0;
                kcaVar2.z(i5);
            } else if (b.equals("device/getDeviceInfo")) {
                kcaVar2.s(true);
                kca deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    kcaVar2.y(deviceInfo.f());
                    kcaVar2.u(deviceInfo.b());
                    kcaVar2.o(deviceInfo.a());
                    kcaVar2.x(deviceInfo.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                kcaVar2.s(true);
                kca sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    kcaVar2.y(sendCompleteTaskReqMsg.f());
                    kcaVar2.u(sendCompleteTaskReqMsg.b());
                    kcaVar2.o(sendCompleteTaskReqMsg.a());
                    kcaVar2.x(sendCompleteTaskReqMsg.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                kcaVar2.s(true);
                kca showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    kcaVar2.y(showTipToast.f());
                    kcaVar2.u(showTipToast.b());
                    kcaVar2.o(showTipToast.a());
                    kcaVar2.x(showTipToast.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                kcaVar2.s(true);
                kca getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    kcaVar2.y(getModalData.f());
                    kcaVar2.u(getModalData.b());
                    kcaVar2.o(getModalData.a());
                    kcaVar2.x(getModalData.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                kcaVar2.s(true);
                kca openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    kcaVar2.y(openThirdPartApp.f());
                    kcaVar2.u(openThirdPartApp.b());
                    kcaVar2.o(openThirdPartApp.a());
                    kcaVar2.x(openThirdPartApp.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                kcaVar2.s(true);
                kca jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    kcaVar2.y(jumpToHtmlPage.f());
                    kcaVar2.u(jumpToHtmlPage.b());
                    kcaVar2.o(jumpToHtmlPage.a());
                    kcaVar2.x(jumpToHtmlPage.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                kcaVar2.s(true);
                kca offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    kcaVar2.y(offlineUserInfo.f());
                    kcaVar2.u(offlineUserInfo.b());
                    kcaVar2.o(offlineUserInfo.a());
                    kcaVar2.x(offlineUserInfo.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                kcaVar2.s(true);
                kca deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    kcaVar2.y(deleteOfflineBundle.f());
                    kcaVar2.u(deleteOfflineBundle.b());
                    kcaVar2.o(deleteOfflineBundle.a());
                    kcaVar2.x(deleteOfflineBundle.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                kcaVar2.s(true);
                kca updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    kcaVar2.y(updateOfflineBundle.f());
                    kcaVar2.u(updateOfflineBundle.b());
                    kcaVar2.o(updateOfflineBundle.a());
                    kcaVar2.x(updateOfflineBundle.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                kcaVar2.s(true);
                kca switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    kcaVar2.y(switchOfflineInterface.f());
                    kcaVar2.u(switchOfflineInterface.b());
                    kcaVar2.o(switchOfflineInterface.a());
                    kcaVar2.x(switchOfflineInterface.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                kcaVar2.s(true);
                kca switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    kcaVar2.y(switchOfflineBundleStatus.f());
                    kcaVar2.u(switchOfflineBundleStatus.b());
                    kcaVar2.o(switchOfflineBundleStatus.a());
                    kcaVar2.x(switchOfflineBundleStatus.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                kcaVar2.s(true);
                kca finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    kcaVar2.y(finishTestAnswer.f());
                    kcaVar2.u(finishTestAnswer.b());
                    kcaVar2.o(finishTestAnswer.a());
                    kcaVar2.x(finishTestAnswer.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                kcaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                kca switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    kcaVar2.y(switchUrlHost.f());
                    kcaVar2.u(switchUrlHost.b());
                    kcaVar2.o(switchUrlHost.a());
                    kcaVar2.x(switchUrlHost.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                kcaVar2.s(true);
                kca appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    kcaVar2.y(appStorage.f());
                    kcaVar2.u(appStorage.b());
                    kcaVar2.o(appStorage.a());
                    kcaVar2.x(appStorage.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                kcaVar2.s(true);
                kca putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    kcaVar2.y(putAppStorage.f());
                    kcaVar2.u(putAppStorage.b());
                    kcaVar2.o(putAppStorage.a());
                    kcaVar2.x(putAppStorage.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                kcaVar2.s(true);
                kca historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    kcaVar2.y(historyForumData.f());
                    kcaVar2.u(historyForumData.b());
                    kcaVar2.o(historyForumData.a());
                    kcaVar2.x(historyForumData.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                kcaVar2.s(true);
                kca worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    kcaVar2.y(worldCupRaiseSuccess.f());
                    kcaVar2.u(worldCupRaiseSuccess.b());
                    kcaVar2.o(worldCupRaiseSuccess.a());
                    kcaVar2.x(worldCupRaiseSuccess.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                kcaVar2.s(true);
                kca alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    kcaVar2.y(alipayUserId.f());
                    kcaVar2.u(alipayUserId.b());
                    kcaVar2.o(alipayUserId.a());
                    kcaVar2.x(alipayUserId.e());
                    if (!kcaVar2.h()) {
                        i4 = 0;
                        kcaVar2.n(false);
                        addObserver("aliAuthResult", kcaVar2, false);
                        kcaVar2.z(i4);
                    }
                }
                i4 = 0;
                kcaVar2.z(i4);
            } else if (b.equals("system/getFileDownloadStatus")) {
                kcaVar2.s(true);
                kca fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    kcaVar2.y(fileDownloadStatus.f());
                    kcaVar2.u(fileDownloadStatus.b());
                    kcaVar2.o(fileDownloadStatus.a());
                    kcaVar2.x(fileDownloadStatus.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                kcaVar2.s(true);
                kca fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    kcaVar2.y(fileDownloadProgress.f());
                    kcaVar2.u(fileDownloadProgress.b());
                    kcaVar2.o(fileDownloadProgress.a());
                    kcaVar2.x(fileDownloadProgress.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                kcaVar2.s(true);
                kca fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    kcaVar2.y(fileDownloadPause.f());
                    kcaVar2.u(fileDownloadPause.b());
                    kcaVar2.o(fileDownloadPause.a());
                    kcaVar2.x(fileDownloadPause.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                kcaVar2.s(true);
                kca fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    kcaVar2.y(fileDownloadDelete.f());
                    kcaVar2.u(fileDownloadDelete.b());
                    kcaVar2.o(fileDownloadDelete.a());
                    kcaVar2.x(fileDownloadDelete.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                kcaVar2.s(true);
                kca installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    kcaVar2.y(installGameApk.f());
                    kcaVar2.u(installGameApk.b());
                    kcaVar2.o(installGameApk.a());
                    kcaVar2.x(installGameApk.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                kcaVar2.s(true);
                kca launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    kcaVar2.y(launchApk.f());
                    kcaVar2.u(launchApk.b());
                    kcaVar2.o(launchApk.a());
                    kcaVar2.x(launchApk.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                kcaVar2.s(true);
                kca wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    kcaVar2.y(wakeKeyboard.f());
                    kcaVar2.u(wakeKeyboard.b());
                    kcaVar2.o(wakeKeyboard.a());
                    kcaVar2.x(wakeKeyboard.e());
                }
                kcaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                kcaVar2.s(true);
                kca replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    kcaVar2.y(replyPost.f());
                    kcaVar2.u(replyPost.b());
                    kcaVar2.o(replyPost.a());
                    kcaVar2.x(replyPost.e());
                    if (!kcaVar2.h()) {
                        i3 = 0;
                        kcaVar2.n(false);
                        addObserver("replyPostResult", kcaVar2, false);
                        kcaVar2.z(i3);
                    }
                }
                i3 = 0;
                kcaVar2.z(i3);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                kcaVar2.s(true);
                kca nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    kcaVar2.y(nativeNetworkProxy.f());
                    kcaVar2.u(nativeNetworkProxy.b());
                    kcaVar2.o(nativeNetworkProxy.a());
                    kcaVar2.x(nativeNetworkProxy.e());
                    if (!kcaVar2.h()) {
                        i2 = 0;
                        kcaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", kcaVar2, false);
                        kcaVar2.z(i2);
                    }
                }
                i2 = 0;
                kcaVar2.z(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                kcaVar2.s(true);
                kca requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    kcaVar2.y(requestByNative.f());
                    kcaVar2.u(requestByNative.b());
                    kcaVar2.o(requestByNative.a());
                    kcaVar2.x(requestByNative.e());
                    if (!kcaVar2.h()) {
                        i = 0;
                        kcaVar2.n(false);
                        addObserver("RequestByNativeToH5", kcaVar2, false);
                        kcaVar2.z(i);
                    }
                }
                i = 0;
                kcaVar2.z(i);
            }
            return kcaVar2;
        }
        return (kca) invokeLL.objValue;
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
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.ica
    public List<kca> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            kca kcaVar = null;
            if (bi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                kcaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                kcaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                kcaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                kcaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                kcaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                kcaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                kcaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                kcaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                kcaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                kcaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                kcaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                kcaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                kcaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                kcaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                kcaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                kcaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                kcaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                kcaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                kcaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                kcaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                kcaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                kcaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                kcaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                kcaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                kcaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                kcaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                kcaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                kcaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                kcaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                kcaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                kcaVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (kcaVar != null) {
                kcaVar.z(0);
            }
            List<jca> list = this.mAsyncCallBackMethodList.get(str);
            if (kcaVar != null && list != null) {
                Iterator<jca> it = list.iterator();
                if (!bi.isEmpty(kcaVar.e())) {
                    while (it.hasNext()) {
                        jca next = it.next();
                        if (next.b().equals(kcaVar.e())) {
                            kca kcaVar2 = new kca();
                            kcaVar2.w(next.a());
                            kcaVar2.y(kcaVar.f());
                            kcaVar2.u(kcaVar.b());
                            kcaVar2.o(kcaVar.a());
                            kcaVar2.A(kcaVar.l());
                            arrayList.add(kcaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        jca next2 = it.next();
                        kca kcaVar3 = new kca();
                        kcaVar3.w(next2.a());
                        kcaVar3.y(kcaVar.f());
                        kcaVar3.u(kcaVar.b());
                        kcaVar3.o(kcaVar.a());
                        kcaVar3.A(kcaVar.l());
                        arrayList.add(kcaVar3);
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
