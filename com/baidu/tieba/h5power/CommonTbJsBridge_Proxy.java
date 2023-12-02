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
import com.baidu.tieba.dxa;
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.hxa;
import com.baidu.tieba.rd;
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
public class CommonTbJsBridge_Proxy extends dxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.dxa
    public fxa dispatch(hxa hxaVar, fxa fxaVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hxaVar, fxaVar)) == null) {
            fxa fxaVar2 = fxaVar == null ? new fxa() : fxaVar;
            String b = hxaVar.b();
            JSONObject e = hxaVar.e();
            if (b.equals("account/startLoginModule")) {
                fxaVar2.s(true);
                fxa startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    fxaVar2.y(startLoginModule.f());
                    fxaVar2.u(startLoginModule.b());
                    fxaVar2.o(startLoginModule.a());
                    fxaVar2.x(startLoginModule.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("account/authState")) {
                fxaVar2.s(true);
                fxa checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    fxaVar2.y(checkAuthState.f());
                    fxaVar2.u(checkAuthState.b());
                    fxaVar2.o(checkAuthState.a());
                    fxaVar2.x(checkAuthState.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                fxaVar2.s(true);
                fxa startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    fxaVar2.y(startAllLoginModule.f());
                    fxaVar2.u(startAllLoginModule.b());
                    fxaVar2.o(startAllLoginModule.a());
                    fxaVar2.x(startAllLoginModule.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver("commonLogin", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                fxaVar2.s(true);
                fxa realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    fxaVar2.y(realNameAuth.f());
                    fxaVar2.u(realNameAuth.b());
                    fxaVar2.o(realNameAuth.a());
                    fxaVar2.x(realNameAuth.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver("realNameAuthResult", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                fxaVar2.s(true);
                fxa finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    fxaVar2.y(finishPage.f());
                    fxaVar2.u(finishPage.b());
                    fxaVar2.o(finishPage.a());
                    fxaVar2.x(finishPage.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                fxaVar2.s(true);
                fxa showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    fxaVar2.y(showLowerHairHint.f());
                    fxaVar2.u(showLowerHairHint.b());
                    fxaVar2.o(showLowerHairHint.a());
                    fxaVar2.x(showLowerHairHint.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                fxaVar2.s(true);
                fxa gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    fxaVar2.y(gamePush.f());
                    fxaVar2.u(gamePush.b());
                    fxaVar2.o(gamePush.a());
                    fxaVar2.x(gamePush.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                fxaVar2.s(true);
                fxa handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    fxaVar2.y(handleGamePushStatus.f());
                    fxaVar2.u(handleGamePushStatus.b());
                    fxaVar2.o(handleGamePushStatus.a());
                    fxaVar2.x(handleGamePushStatus.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                fxaVar2.s(true);
                fxa jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    fxaVar2.y(jumpForumRulesEditPage.f());
                    fxaVar2.u(jumpForumRulesEditPage.b());
                    fxaVar2.o(jumpForumRulesEditPage.a());
                    fxaVar2.x(jumpForumRulesEditPage.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                fxaVar2.s(true);
                fxa handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    fxaVar2.y(handleGoToBarDetail.f());
                    fxaVar2.u(handleGoToBarDetail.b());
                    fxaVar2.o(handleGoToBarDetail.a());
                    fxaVar2.x(handleGoToBarDetail.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                fxaVar2.s(true);
                fxa handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    fxaVar2.y(handleSaveImage.f());
                    fxaVar2.u(handleSaveImage.b());
                    fxaVar2.o(handleSaveImage.a());
                    fxaVar2.x(handleSaveImage.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver("saveImageSuccess", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                fxaVar2.s(true);
                fxa orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    fxaVar2.y(orderGameApk.f());
                    fxaVar2.u(orderGameApk.b());
                    fxaVar2.o(orderGameApk.a());
                    fxaVar2.x(orderGameApk.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver("orderGameApkResult", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                fxaVar2.s(true);
                fxa handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    fxaVar2.y(handleGetPhotoAlbum.f());
                    fxaVar2.u(handleGetPhotoAlbum.b());
                    fxaVar2.o(handleGetPhotoAlbum.a());
                    fxaVar2.x(handleGetPhotoAlbum.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver("GetPhotoAlbum", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                fxaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                fxa preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    fxaVar2.y(preheatWeb.f());
                    fxaVar2.u(preheatWeb.b());
                    fxaVar2.o(preheatWeb.a());
                    fxaVar2.x(preheatWeb.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                fxaVar2.s(true);
                fxa openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    fxaVar2.y(openMXDYab.f());
                    fxaVar2.u(openMXDYab.b());
                    fxaVar2.o(openMXDYab.a());
                    fxaVar2.x(openMXDYab.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/portal")) {
                fxaVar2.s(true);
                fxa handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (handlePortal != null) {
                    fxaVar2.y(handlePortal.f());
                    fxaVar2.u(handlePortal.b());
                    fxaVar2.o(handlePortal.a());
                    fxaVar2.x(handlePortal.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                fxaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                fxa selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    fxaVar2.y(selectPhotoAlbum.f());
                    fxaVar2.u(selectPhotoAlbum.b());
                    fxaVar2.o(selectPhotoAlbum.a());
                    fxaVar2.x(selectPhotoAlbum.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver("selectPhotoAlbum", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                fxaVar2.s(true);
                fxa operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    fxaVar2.y(operateNotifyDataChanged.f());
                    fxaVar2.u(operateNotifyDataChanged.b());
                    fxaVar2.o(operateNotifyDataChanged.a());
                    fxaVar2.x(operateNotifyDataChanged.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                fxaVar2.s(true);
                fxa viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    fxaVar2.y(viewPosition.f());
                    fxaVar2.u(viewPosition.b());
                    fxaVar2.o(viewPosition.a());
                    fxaVar2.x(viewPosition.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                fxaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                fxa selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    fxaVar2.y(selectPrivateMsg.f());
                    fxaVar2.u(selectPrivateMsg.b());
                    fxaVar2.o(selectPrivateMsg.a());
                    fxaVar2.x(selectPrivateMsg.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                fxaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                fxa reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    fxaVar2.y(reportUserTheme.f());
                    fxaVar2.u(reportUserTheme.b());
                    fxaVar2.o(reportUserTheme.a());
                    fxaVar2.x(reportUserTheme.e());
                    if (!fxaVar2.h()) {
                        fxaVar2.n(false);
                        addObserver("goToReportThreadPage", fxaVar2, false);
                    }
                }
                fxaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                fxaVar2.s(true);
                fxa playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    fxaVar2.y(playSound.f());
                    fxaVar2.u(playSound.b());
                    fxaVar2.o(playSound.a());
                    fxaVar2.x(playSound.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                fxaVar2.s(true);
                fxa playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    fxaVar2.y(playVibrate.f());
                    fxaVar2.u(playVibrate.b());
                    fxaVar2.o(playVibrate.a());
                    fxaVar2.x(playVibrate.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                fxaVar2.s(true);
                fxa localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    fxaVar2.y(localYaLog.f());
                    fxaVar2.u(localYaLog.b());
                    fxaVar2.o(localYaLog.a());
                    fxaVar2.x(localYaLog.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                fxaVar2.s(true);
                fxa jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    fxaVar2.y(jumpLoginActivity.f());
                    fxaVar2.u(jumpLoginActivity.b());
                    fxaVar2.o(jumpLoginActivity.a());
                    fxaVar2.x(jumpLoginActivity.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                fxaVar2.s(true);
                fxa startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    fxaVar2.y(startLoadTimeInterval.f());
                    fxaVar2.u(startLoadTimeInterval.b());
                    fxaVar2.o(startLoadTimeInterval.a());
                    fxaVar2.x(startLoadTimeInterval.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                fxaVar2.s(true);
                fxa zid = this.mJsBridge.getZid();
                if (zid != null) {
                    fxaVar2.y(zid.f());
                    fxaVar2.u(zid.b());
                    fxaVar2.o(zid.a());
                    fxaVar2.x(zid.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                fxaVar2.s(true);
                fxa hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    fxaVar2.y(hdid.f());
                    fxaVar2.u(hdid.b());
                    fxaVar2.o(hdid.a());
                    fxaVar2.x(hdid.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                fxaVar2.s(true);
                fxa shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    fxaVar2.y(shareInfo.f());
                    fxaVar2.u(shareInfo.b());
                    fxaVar2.o(shareInfo.a());
                    fxaVar2.x(shareInfo.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("share/share")) {
                fxaVar2.s(true);
                fxa share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"), e.optJSONObject("floatShareCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    fxaVar2.y(share.f());
                    fxaVar2.u(share.b());
                    fxaVar2.o(share.a());
                    fxaVar2.x(share.e());
                    if (!fxaVar2.h()) {
                        i11 = 0;
                        fxaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, fxaVar2, false);
                        fxaVar2.z(i11);
                    }
                }
                i11 = 0;
                fxaVar2.z(i11);
            } else if (b.equals("clipper/getClipperInformation")) {
                fxaVar2.s(true);
                fxa clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    fxaVar2.y(clipperInformation.f());
                    fxaVar2.u(clipperInformation.b());
                    fxaVar2.o(clipperInformation.a());
                    fxaVar2.x(clipperInformation.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                fxaVar2.s(true);
                fxa clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    fxaVar2.y(clipperInformation2.f());
                    fxaVar2.u(clipperInformation2.b());
                    fxaVar2.o(clipperInformation2.a());
                    fxaVar2.x(clipperInformation2.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                fxaVar2.s(true);
                fxa goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    fxaVar2.y(goToEditPost.f());
                    fxaVar2.u(goToEditPost.b());
                    fxaVar2.o(goToEditPost.a());
                    fxaVar2.x(goToEditPost.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                fxaVar2.s(true);
                fxa updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    fxaVar2.y(updateSearchForumInfo.f());
                    fxaVar2.u(updateSearchForumInfo.b());
                    fxaVar2.o(updateSearchForumInfo.a());
                    fxaVar2.x(updateSearchForumInfo.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                fxaVar2.s(true);
                fxa personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    fxaVar2.y(personlizedSwitchChange.f());
                    fxaVar2.u(personlizedSwitchChange.b());
                    fxaVar2.o(personlizedSwitchChange.a());
                    fxaVar2.x(personlizedSwitchChange.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                fxaVar2.s(true);
                fxa updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    fxaVar2.y(updateTailStyle.f());
                    fxaVar2.u(updateTailStyle.b());
                    fxaVar2.o(updateTailStyle.a());
                    fxaVar2.x(updateTailStyle.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                fxaVar2.s(true);
                fxa goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    fxaVar2.y(goToVideoImmersivePage.f());
                    fxaVar2.u(goToVideoImmersivePage.b());
                    fxaVar2.o(goToVideoImmersivePage.a());
                    fxaVar2.x(goToVideoImmersivePage.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                fxaVar2.s(true);
                fxa jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    fxaVar2.y(jumpToVideo.f());
                    fxaVar2.u(jumpToVideo.b());
                    fxaVar2.o(jumpToVideo.a());
                    fxaVar2.x(jumpToVideo.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                fxaVar2.s(true);
                fxa closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    fxaVar2.y(closeNativeMask.f());
                    fxaVar2.u(closeNativeMask.b());
                    fxaVar2.o(closeNativeMask.a());
                    fxaVar2.x(closeNativeMask.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                fxaVar2.s(true);
                fxa oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    fxaVar2.y(oneKeyDeletion.f());
                    fxaVar2.u(oneKeyDeletion.b());
                    fxaVar2.o(oneKeyDeletion.a());
                    fxaVar2.x(oneKeyDeletion.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                fxaVar2.s(true);
                fxa checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    fxaVar2.y(checkAppInstall.f());
                    fxaVar2.u(checkAppInstall.b());
                    fxaVar2.o(checkAppInstall.a());
                    fxaVar2.x(checkAppInstall.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                fxaVar2.s(true);
                fxa disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    fxaVar2.y(disableBack.f());
                    fxaVar2.u(disableBack.b());
                    fxaVar2.o(disableBack.a());
                    fxaVar2.x(disableBack.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                fxaVar2.s(true);
                fxa startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    fxaVar2.y(startApp.f());
                    fxaVar2.u(startApp.b());
                    fxaVar2.o(startApp.a());
                    fxaVar2.x(startApp.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                fxaVar2.s(true);
                fxa hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    fxaVar2.y(hasNotificationPermission.f());
                    fxaVar2.u(hasNotificationPermission.b());
                    fxaVar2.o(hasNotificationPermission.a());
                    fxaVar2.x(hasNotificationPermission.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                fxaVar2.s(true);
                fxa goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    fxaVar2.y(goToNotificationSetting.f());
                    fxaVar2.u(goToNotificationSetting.b());
                    fxaVar2.o(goToNotificationSetting.a());
                    fxaVar2.x(goToNotificationSetting.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                fxaVar2.s(true);
                fxa startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    fxaVar2.y(startDownloadGameApk.f());
                    fxaVar2.u(startDownloadGameApk.b());
                    fxaVar2.o(startDownloadGameApk.a());
                    fxaVar2.x(startDownloadGameApk.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                fxaVar2.s(true);
                fxa checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    fxaVar2.y(checkInstallGameApk.f());
                    fxaVar2.u(checkInstallGameApk.b());
                    fxaVar2.o(checkInstallGameApk.a());
                    fxaVar2.x(checkInstallGameApk.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                fxaVar2.s(true);
                fxa startDownloadCss = this.mJsBridge.startDownloadCss(e.optString("downloadUrl"));
                if (startDownloadCss != null) {
                    fxaVar2.y(startDownloadCss.f());
                    fxaVar2.u(startDownloadCss.b());
                    fxaVar2.o(startDownloadCss.a());
                    fxaVar2.x(startDownloadCss.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                fxaVar2.s(true);
                fxa disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    fxaVar2.y(disableGoBack.f());
                    fxaVar2.u(disableGoBack.b());
                    fxaVar2.o(disableGoBack.a());
                    fxaVar2.x(disableGoBack.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                fxaVar2.s(true);
                fxa supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    fxaVar2.y(supplementInfo.f());
                    fxaVar2.u(supplementInfo.b());
                    fxaVar2.o(supplementInfo.a());
                    fxaVar2.x(supplementInfo.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                fxaVar2.s(true);
                fxa deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    fxaVar2.y(deviceGyroscopeParams.f());
                    fxaVar2.u(deviceGyroscopeParams.b());
                    fxaVar2.o(deviceGyroscopeParams.a());
                    fxaVar2.x(deviceGyroscopeParams.e());
                    if (!fxaVar2.h()) {
                        i10 = 0;
                        fxaVar2.n(false);
                        addObserver("deviceMotion", fxaVar2, false);
                        fxaVar2.z(i10);
                    }
                }
                i10 = 0;
                fxaVar2.z(i10);
            } else if (b.equals("device/deviceRefreshRate")) {
                fxaVar2.s(true);
                fxa deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    fxaVar2.y(deviceRefreshRateParams.f());
                    fxaVar2.u(deviceRefreshRateParams.b());
                    fxaVar2.o(deviceRefreshRateParams.a());
                    fxaVar2.x(deviceRefreshRateParams.e());
                    if (!fxaVar2.h()) {
                        i9 = 0;
                        fxaVar2.n(false);
                        addObserver("deviceRefreshRate", fxaVar2, false);
                        fxaVar2.z(i9);
                    }
                }
                i9 = 0;
                fxaVar2.z(i9);
            } else if (b.equals("device/getDeviceInfo")) {
                fxaVar2.s(true);
                fxa deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    fxaVar2.y(deviceInfo.f());
                    fxaVar2.u(deviceInfo.b());
                    fxaVar2.o(deviceInfo.a());
                    fxaVar2.x(deviceInfo.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                fxaVar2.s(true);
                fxa sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    fxaVar2.y(sendCompleteTaskReqMsg.f());
                    fxaVar2.u(sendCompleteTaskReqMsg.b());
                    fxaVar2.o(sendCompleteTaskReqMsg.a());
                    fxaVar2.x(sendCompleteTaskReqMsg.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                fxaVar2.s(true);
                fxa showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    fxaVar2.y(showTipToast.f());
                    fxaVar2.u(showTipToast.b());
                    fxaVar2.o(showTipToast.a());
                    fxaVar2.x(showTipToast.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                fxaVar2.s(true);
                fxa getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    fxaVar2.y(getModalData.f());
                    fxaVar2.u(getModalData.b());
                    fxaVar2.o(getModalData.a());
                    fxaVar2.x(getModalData.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                fxaVar2.s(true);
                fxa openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    fxaVar2.y(openThirdPartApp.f());
                    fxaVar2.u(openThirdPartApp.b());
                    fxaVar2.o(openThirdPartApp.a());
                    fxaVar2.x(openThirdPartApp.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                fxaVar2.s(true);
                fxa jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    fxaVar2.y(jumpToHtmlPage.f());
                    fxaVar2.u(jumpToHtmlPage.b());
                    fxaVar2.o(jumpToHtmlPage.a());
                    fxaVar2.x(jumpToHtmlPage.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                fxaVar2.s(true);
                fxa offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    fxaVar2.y(offlineUserInfo.f());
                    fxaVar2.u(offlineUserInfo.b());
                    fxaVar2.o(offlineUserInfo.a());
                    fxaVar2.x(offlineUserInfo.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                fxaVar2.s(true);
                fxa deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    fxaVar2.y(deleteOfflineBundle.f());
                    fxaVar2.u(deleteOfflineBundle.b());
                    fxaVar2.o(deleteOfflineBundle.a());
                    fxaVar2.x(deleteOfflineBundle.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                fxaVar2.s(true);
                fxa updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    fxaVar2.y(updateOfflineBundle.f());
                    fxaVar2.u(updateOfflineBundle.b());
                    fxaVar2.o(updateOfflineBundle.a());
                    fxaVar2.x(updateOfflineBundle.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                fxaVar2.s(true);
                fxa switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    fxaVar2.y(switchOfflineInterface.f());
                    fxaVar2.u(switchOfflineInterface.b());
                    fxaVar2.o(switchOfflineInterface.a());
                    fxaVar2.x(switchOfflineInterface.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                fxaVar2.s(true);
                fxa switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    fxaVar2.y(switchOfflineBundleStatus.f());
                    fxaVar2.u(switchOfflineBundleStatus.b());
                    fxaVar2.o(switchOfflineBundleStatus.a());
                    fxaVar2.x(switchOfflineBundleStatus.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                fxaVar2.s(true);
                fxa finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    fxaVar2.y(finishTestAnswer.f());
                    fxaVar2.u(finishTestAnswer.b());
                    fxaVar2.o(finishTestAnswer.a());
                    fxaVar2.x(finishTestAnswer.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                fxaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                fxa switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    fxaVar2.y(switchUrlHost.f());
                    fxaVar2.u(switchUrlHost.b());
                    fxaVar2.o(switchUrlHost.a());
                    fxaVar2.x(switchUrlHost.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                fxaVar2.s(true);
                fxa appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    fxaVar2.y(appStorage.f());
                    fxaVar2.u(appStorage.b());
                    fxaVar2.o(appStorage.a());
                    fxaVar2.x(appStorage.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                fxaVar2.s(true);
                fxa putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    fxaVar2.y(putAppStorage.f());
                    fxaVar2.u(putAppStorage.b());
                    fxaVar2.o(putAppStorage.a());
                    fxaVar2.x(putAppStorage.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                fxaVar2.s(true);
                fxa historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    fxaVar2.y(historyForumData.f());
                    fxaVar2.u(historyForumData.b());
                    fxaVar2.o(historyForumData.a());
                    fxaVar2.x(historyForumData.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                fxaVar2.s(true);
                fxa worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    fxaVar2.y(worldCupRaiseSuccess.f());
                    fxaVar2.u(worldCupRaiseSuccess.b());
                    fxaVar2.o(worldCupRaiseSuccess.a());
                    fxaVar2.x(worldCupRaiseSuccess.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                fxaVar2.s(true);
                fxa alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    fxaVar2.y(alipayUserId.f());
                    fxaVar2.u(alipayUserId.b());
                    fxaVar2.o(alipayUserId.a());
                    fxaVar2.x(alipayUserId.e());
                    if (!fxaVar2.h()) {
                        i8 = 0;
                        fxaVar2.n(false);
                        addObserver("aliAuthResult", fxaVar2, false);
                        fxaVar2.z(i8);
                    }
                }
                i8 = 0;
                fxaVar2.z(i8);
            } else if (b.equals("system/getFileDownloadStatus")) {
                fxaVar2.s(true);
                fxa fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"), e.optString("pkgName"));
                if (fileDownloadStatus != null) {
                    fxaVar2.y(fileDownloadStatus.f());
                    fxaVar2.u(fileDownloadStatus.b());
                    fxaVar2.o(fileDownloadStatus.a());
                    fxaVar2.x(fileDownloadStatus.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                fxaVar2.s(true);
                fxa fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"), e.optString("pkgName"));
                if (fileDownloadProgress != null) {
                    fxaVar2.y(fileDownloadProgress.f());
                    fxaVar2.u(fileDownloadProgress.b());
                    fxaVar2.o(fileDownloadProgress.a());
                    fxaVar2.x(fileDownloadProgress.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                fxaVar2.s(true);
                fxa fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"), e.optString("pkgName"));
                if (fileDownloadPause != null) {
                    fxaVar2.y(fileDownloadPause.f());
                    fxaVar2.u(fileDownloadPause.b());
                    fxaVar2.o(fileDownloadPause.a());
                    fxaVar2.x(fileDownloadPause.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                fxaVar2.s(true);
                fxa fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"), e.optString("pkgName"));
                if (fileDownloadDelete != null) {
                    fxaVar2.y(fileDownloadDelete.f());
                    fxaVar2.u(fileDownloadDelete.b());
                    fxaVar2.o(fileDownloadDelete.a());
                    fxaVar2.x(fileDownloadDelete.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                fxaVar2.s(true);
                fxa installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    fxaVar2.y(installGameApk.f());
                    fxaVar2.u(installGameApk.b());
                    fxaVar2.o(installGameApk.a());
                    fxaVar2.x(installGameApk.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                fxaVar2.s(true);
                fxa launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    fxaVar2.y(launchApk.f());
                    fxaVar2.u(launchApk.b());
                    fxaVar2.o(launchApk.a());
                    fxaVar2.x(launchApk.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                fxaVar2.s(true);
                fxa wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    fxaVar2.y(wakeKeyboard.f());
                    fxaVar2.u(wakeKeyboard.b());
                    fxaVar2.o(wakeKeyboard.a());
                    fxaVar2.x(wakeKeyboard.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                fxaVar2.s(true);
                fxa replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    fxaVar2.y(replyPost.f());
                    fxaVar2.u(replyPost.b());
                    fxaVar2.o(replyPost.a());
                    fxaVar2.x(replyPost.e());
                    if (!fxaVar2.h()) {
                        i7 = 0;
                        fxaVar2.n(false);
                        addObserver("replyPostResult", fxaVar2, false);
                        fxaVar2.z(i7);
                    }
                }
                i7 = 0;
                fxaVar2.z(i7);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                fxaVar2.s(true);
                fxa nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    fxaVar2.y(nativeNetworkProxy.f());
                    fxaVar2.u(nativeNetworkProxy.b());
                    fxaVar2.o(nativeNetworkProxy.a());
                    fxaVar2.x(nativeNetworkProxy.e());
                    if (!fxaVar2.h()) {
                        i6 = 0;
                        fxaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", fxaVar2, false);
                        fxaVar2.z(i6);
                    }
                }
                i6 = 0;
                fxaVar2.z(i6);
            } else if (b.equals("host/sendMsg")) {
                fxaVar2.s(true);
                fxa sendMessage = this.mJsBridge.sendMessage(e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (sendMessage != null) {
                    fxaVar2.y(sendMessage.f());
                    fxaVar2.u(sendMessage.b());
                    fxaVar2.o(sendMessage.a());
                    fxaVar2.x(sendMessage.e());
                    if (!fxaVar2.h()) {
                        i5 = 0;
                        fxaVar2.n(false);
                        addObserver("sendMsg", fxaVar2, false);
                        fxaVar2.z(i5);
                    }
                }
                i5 = 0;
                fxaVar2.z(i5);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                fxaVar2.s(true);
                fxa fetchHistoryMsgs = this.mJsBridge.fetchHistoryMsgs(e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (fetchHistoryMsgs != null) {
                    fxaVar2.y(fetchHistoryMsgs.f());
                    fxaVar2.u(fetchHistoryMsgs.b());
                    fxaVar2.o(fetchHistoryMsgs.a());
                    fxaVar2.x(fetchHistoryMsgs.e());
                    if (!fxaVar2.h()) {
                        i4 = 0;
                        fxaVar2.n(false);
                        addObserver("fetchHistoryMsgs", fxaVar2, false);
                        fxaVar2.z(i4);
                    }
                }
                i4 = 0;
                fxaVar2.z(i4);
            } else if (b.equals("host/receiveNewMsgs")) {
                fxaVar2.s(true);
                fxa receiveNewMsgs = this.mJsBridge.receiveNewMsgs();
                this.mNotificationNameList.add("receiveNewMsgs");
                if (receiveNewMsgs != null) {
                    fxaVar2.y(receiveNewMsgs.f());
                    fxaVar2.u(receiveNewMsgs.b());
                    fxaVar2.o(receiveNewMsgs.a());
                    fxaVar2.x(receiveNewMsgs.e());
                    if (!fxaVar2.h()) {
                        i3 = 0;
                        fxaVar2.n(false);
                        addObserver("receiveNewMsgs", fxaVar2, false);
                        fxaVar2.z(i3);
                    }
                }
                i3 = 0;
                fxaVar2.z(i3);
            } else if (b.equals("system/keyboardHeightChange")) {
                fxaVar2.s(true);
                fxa keyboardHeightChange = this.mJsBridge.keyboardHeightChange();
                this.mNotificationNameList.add("keyboardHeightChange");
                if (keyboardHeightChange != null) {
                    fxaVar2.y(keyboardHeightChange.f());
                    fxaVar2.u(keyboardHeightChange.b());
                    fxaVar2.o(keyboardHeightChange.a());
                    fxaVar2.x(keyboardHeightChange.e());
                    if (!fxaVar2.h()) {
                        i2 = 0;
                        fxaVar2.n(false);
                        addObserver("keyboardHeightChange", fxaVar2, false);
                        fxaVar2.z(i2);
                    }
                }
                i2 = 0;
                fxaVar2.z(i2);
            } else if (b.equals("host/preloadPic")) {
                fxaVar2.s(true);
                ArrayList<String> arrayList6 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList6, e.optJSONArray("url"));
                fxa perloadPicModule = this.mJsBridge.perloadPicModule(arrayList6);
                if (perloadPicModule != null) {
                    fxaVar2.y(perloadPicModule.f());
                    fxaVar2.u(perloadPicModule.b());
                    fxaVar2.o(perloadPicModule.a());
                    fxaVar2.x(perloadPicModule.e());
                }
                fxaVar2.z(0);
            } else if (b.equals("toast/showDialog")) {
                fxaVar2.s(true);
                fxa showDialog = this.mJsBridge.showDialog(e.optInt("type"), e.optString("content"), e.optString("dialogId"));
                this.mNotificationNameList.add("showDialog");
                if (showDialog != null) {
                    fxaVar2.y(showDialog.f());
                    fxaVar2.u(showDialog.b());
                    fxaVar2.o(showDialog.a());
                    fxaVar2.x(showDialog.e());
                    if (!fxaVar2.h()) {
                        i = 0;
                        fxaVar2.n(false);
                        addObserver("showDialog", fxaVar2, false);
                        fxaVar2.z(i);
                    }
                }
                i = 0;
                fxaVar2.z(i);
            }
            return fxaVar2;
        }
        return (fxa) invokeLL.objValue;
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
    }

    @Override // com.baidu.tieba.dxa
    public List<fxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            fxa fxaVar = null;
            if (rd.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                fxaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                fxaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                fxaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                fxaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                fxaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                fxaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                fxaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                fxaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                fxaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                fxaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                fxaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                fxaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                fxaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                fxaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                fxaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                fxaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                fxaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                fxaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                fxaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                fxaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                fxaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                fxaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                fxaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                fxaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                fxaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                fxaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                fxaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                fxaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                fxaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                fxaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("sendMsg")) {
                fxaVar = this.mJsBridge.onSendMsgResult(hashMap);
            } else if (str.equals("handleAudioMsgByTTS")) {
                fxaVar = this.mJsBridge.handleVoiceMsgResult(hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                fxaVar = this.mJsBridge.onFetchHistoryMsgsResult(hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                fxaVar = this.mJsBridge.onReceiveNewMsgsResult(hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                fxaVar = this.mJsBridge.onKeyboardHeightChange(hashMap);
            }
            if (fxaVar != null) {
                fxaVar.z(0);
            }
            List<exa> list = this.mAsyncCallBackMethodList.get(str);
            if (fxaVar != null && list != null) {
                Iterator<exa> it = list.iterator();
                if (!rd.isEmpty(fxaVar.e())) {
                    while (it.hasNext()) {
                        exa next = it.next();
                        if (next.b().equals(fxaVar.e())) {
                            fxa fxaVar2 = new fxa();
                            fxaVar2.w(next.a());
                            fxaVar2.y(fxaVar.f());
                            fxaVar2.u(fxaVar.b());
                            fxaVar2.o(fxaVar.a());
                            fxaVar2.A(fxaVar.l());
                            arrayList.add(fxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        exa next2 = it.next();
                        fxa fxaVar3 = new fxa();
                        fxaVar3.w(next2.a());
                        fxaVar3.y(fxaVar.f());
                        fxaVar3.u(fxaVar.b());
                        fxaVar3.o(fxaVar.a());
                        fxaVar3.A(fxaVar.l());
                        arrayList.add(fxaVar3);
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
