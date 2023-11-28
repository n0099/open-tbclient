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
import com.baidu.tieba.exa;
import com.baidu.tieba.fxa;
import com.baidu.tieba.gxa;
import com.baidu.tieba.ixa;
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
public class CommonTbJsBridge_Proxy extends exa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.exa
    public gxa dispatch(ixa ixaVar, gxa gxaVar) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ixaVar, gxaVar)) == null) {
            gxa gxaVar2 = gxaVar == null ? new gxa() : gxaVar;
            String b = ixaVar.b();
            JSONObject e = ixaVar.e();
            if (b.equals("account/startLoginModule")) {
                gxaVar2.s(true);
                gxa startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    gxaVar2.y(startLoginModule.f());
                    gxaVar2.u(startLoginModule.b());
                    gxaVar2.o(startLoginModule.a());
                    gxaVar2.x(startLoginModule.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("account/authState")) {
                gxaVar2.s(true);
                gxa checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    gxaVar2.y(checkAuthState.f());
                    gxaVar2.u(checkAuthState.b());
                    gxaVar2.o(checkAuthState.a());
                    gxaVar2.x(checkAuthState.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                gxaVar2.s(true);
                gxa startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    gxaVar2.y(startAllLoginModule.f());
                    gxaVar2.u(startAllLoginModule.b());
                    gxaVar2.o(startAllLoginModule.a());
                    gxaVar2.x(startAllLoginModule.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver("commonLogin", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                gxaVar2.s(true);
                gxa realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    gxaVar2.y(realNameAuth.f());
                    gxaVar2.u(realNameAuth.b());
                    gxaVar2.o(realNameAuth.a());
                    gxaVar2.x(realNameAuth.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver("realNameAuthResult", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                gxaVar2.s(true);
                gxa finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    gxaVar2.y(finishPage.f());
                    gxaVar2.u(finishPage.b());
                    gxaVar2.o(finishPage.a());
                    gxaVar2.x(finishPage.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                gxaVar2.s(true);
                gxa showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    gxaVar2.y(showLowerHairHint.f());
                    gxaVar2.u(showLowerHairHint.b());
                    gxaVar2.o(showLowerHairHint.a());
                    gxaVar2.x(showLowerHairHint.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                gxaVar2.s(true);
                gxa gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    gxaVar2.y(gamePush.f());
                    gxaVar2.u(gamePush.b());
                    gxaVar2.o(gamePush.a());
                    gxaVar2.x(gamePush.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                gxaVar2.s(true);
                gxa handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    gxaVar2.y(handleGamePushStatus.f());
                    gxaVar2.u(handleGamePushStatus.b());
                    gxaVar2.o(handleGamePushStatus.a());
                    gxaVar2.x(handleGamePushStatus.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                gxaVar2.s(true);
                gxa jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    gxaVar2.y(jumpForumRulesEditPage.f());
                    gxaVar2.u(jumpForumRulesEditPage.b());
                    gxaVar2.o(jumpForumRulesEditPage.a());
                    gxaVar2.x(jumpForumRulesEditPage.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                gxaVar2.s(true);
                gxa handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    gxaVar2.y(handleGoToBarDetail.f());
                    gxaVar2.u(handleGoToBarDetail.b());
                    gxaVar2.o(handleGoToBarDetail.a());
                    gxaVar2.x(handleGoToBarDetail.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                gxaVar2.s(true);
                gxa handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    gxaVar2.y(handleSaveImage.f());
                    gxaVar2.u(handleSaveImage.b());
                    gxaVar2.o(handleSaveImage.a());
                    gxaVar2.x(handleSaveImage.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver("saveImageSuccess", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                gxaVar2.s(true);
                gxa orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    gxaVar2.y(orderGameApk.f());
                    gxaVar2.u(orderGameApk.b());
                    gxaVar2.o(orderGameApk.a());
                    gxaVar2.x(orderGameApk.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver("orderGameApkResult", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                gxaVar2.s(true);
                gxa handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    gxaVar2.y(handleGetPhotoAlbum.f());
                    gxaVar2.u(handleGetPhotoAlbum.b());
                    gxaVar2.o(handleGetPhotoAlbum.a());
                    gxaVar2.x(handleGetPhotoAlbum.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver("GetPhotoAlbum", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                gxaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                gxa preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    gxaVar2.y(preheatWeb.f());
                    gxaVar2.u(preheatWeb.b());
                    gxaVar2.o(preheatWeb.a());
                    gxaVar2.x(preheatWeb.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                gxaVar2.s(true);
                gxa openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    gxaVar2.y(openMXDYab.f());
                    gxaVar2.u(openMXDYab.b());
                    gxaVar2.o(openMXDYab.a());
                    gxaVar2.x(openMXDYab.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/portal")) {
                gxaVar2.s(true);
                gxa handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (handlePortal != null) {
                    gxaVar2.y(handlePortal.f());
                    gxaVar2.u(handlePortal.b());
                    gxaVar2.o(handlePortal.a());
                    gxaVar2.x(handlePortal.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                gxaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                gxa selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    gxaVar2.y(selectPhotoAlbum.f());
                    gxaVar2.u(selectPhotoAlbum.b());
                    gxaVar2.o(selectPhotoAlbum.a());
                    gxaVar2.x(selectPhotoAlbum.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver("selectPhotoAlbum", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                gxaVar2.s(true);
                gxa operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    gxaVar2.y(operateNotifyDataChanged.f());
                    gxaVar2.u(operateNotifyDataChanged.b());
                    gxaVar2.o(operateNotifyDataChanged.a());
                    gxaVar2.x(operateNotifyDataChanged.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                gxaVar2.s(true);
                gxa viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    gxaVar2.y(viewPosition.f());
                    gxaVar2.u(viewPosition.b());
                    gxaVar2.o(viewPosition.a());
                    gxaVar2.x(viewPosition.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                gxaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                gxa selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    gxaVar2.y(selectPrivateMsg.f());
                    gxaVar2.u(selectPrivateMsg.b());
                    gxaVar2.o(selectPrivateMsg.a());
                    gxaVar2.x(selectPrivateMsg.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                gxaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                gxa reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    gxaVar2.y(reportUserTheme.f());
                    gxaVar2.u(reportUserTheme.b());
                    gxaVar2.o(reportUserTheme.a());
                    gxaVar2.x(reportUserTheme.e());
                    if (!gxaVar2.h()) {
                        gxaVar2.n(false);
                        addObserver("goToReportThreadPage", gxaVar2, false);
                    }
                }
                gxaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                gxaVar2.s(true);
                gxa playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    gxaVar2.y(playSound.f());
                    gxaVar2.u(playSound.b());
                    gxaVar2.o(playSound.a());
                    gxaVar2.x(playSound.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                gxaVar2.s(true);
                gxa playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    gxaVar2.y(playVibrate.f());
                    gxaVar2.u(playVibrate.b());
                    gxaVar2.o(playVibrate.a());
                    gxaVar2.x(playVibrate.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                gxaVar2.s(true);
                gxa localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    gxaVar2.y(localYaLog.f());
                    gxaVar2.u(localYaLog.b());
                    gxaVar2.o(localYaLog.a());
                    gxaVar2.x(localYaLog.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                gxaVar2.s(true);
                gxa jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    gxaVar2.y(jumpLoginActivity.f());
                    gxaVar2.u(jumpLoginActivity.b());
                    gxaVar2.o(jumpLoginActivity.a());
                    gxaVar2.x(jumpLoginActivity.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                gxaVar2.s(true);
                gxa startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    gxaVar2.y(startLoadTimeInterval.f());
                    gxaVar2.u(startLoadTimeInterval.b());
                    gxaVar2.o(startLoadTimeInterval.a());
                    gxaVar2.x(startLoadTimeInterval.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                gxaVar2.s(true);
                gxa zid = this.mJsBridge.getZid();
                if (zid != null) {
                    gxaVar2.y(zid.f());
                    gxaVar2.u(zid.b());
                    gxaVar2.o(zid.a());
                    gxaVar2.x(zid.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                gxaVar2.s(true);
                gxa hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    gxaVar2.y(hdid.f());
                    gxaVar2.u(hdid.b());
                    gxaVar2.o(hdid.a());
                    gxaVar2.x(hdid.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                gxaVar2.s(true);
                gxa shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    gxaVar2.y(shareInfo.f());
                    gxaVar2.u(shareInfo.b());
                    gxaVar2.o(shareInfo.a());
                    gxaVar2.x(shareInfo.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("share/share")) {
                gxaVar2.s(true);
                gxa share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"), e.optJSONObject("floatShareCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    gxaVar2.y(share.f());
                    gxaVar2.u(share.b());
                    gxaVar2.o(share.a());
                    gxaVar2.x(share.e());
                    if (!gxaVar2.h()) {
                        i11 = 0;
                        gxaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, gxaVar2, false);
                        gxaVar2.z(i11);
                    }
                }
                i11 = 0;
                gxaVar2.z(i11);
            } else if (b.equals("clipper/getClipperInformation")) {
                gxaVar2.s(true);
                gxa clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    gxaVar2.y(clipperInformation.f());
                    gxaVar2.u(clipperInformation.b());
                    gxaVar2.o(clipperInformation.a());
                    gxaVar2.x(clipperInformation.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                gxaVar2.s(true);
                gxa clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    gxaVar2.y(clipperInformation2.f());
                    gxaVar2.u(clipperInformation2.b());
                    gxaVar2.o(clipperInformation2.a());
                    gxaVar2.x(clipperInformation2.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                gxaVar2.s(true);
                gxa goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    gxaVar2.y(goToEditPost.f());
                    gxaVar2.u(goToEditPost.b());
                    gxaVar2.o(goToEditPost.a());
                    gxaVar2.x(goToEditPost.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                gxaVar2.s(true);
                gxa updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    gxaVar2.y(updateSearchForumInfo.f());
                    gxaVar2.u(updateSearchForumInfo.b());
                    gxaVar2.o(updateSearchForumInfo.a());
                    gxaVar2.x(updateSearchForumInfo.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                gxaVar2.s(true);
                gxa personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    gxaVar2.y(personlizedSwitchChange.f());
                    gxaVar2.u(personlizedSwitchChange.b());
                    gxaVar2.o(personlizedSwitchChange.a());
                    gxaVar2.x(personlizedSwitchChange.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                gxaVar2.s(true);
                gxa updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    gxaVar2.y(updateTailStyle.f());
                    gxaVar2.u(updateTailStyle.b());
                    gxaVar2.o(updateTailStyle.a());
                    gxaVar2.x(updateTailStyle.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                gxaVar2.s(true);
                gxa goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    gxaVar2.y(goToVideoImmersivePage.f());
                    gxaVar2.u(goToVideoImmersivePage.b());
                    gxaVar2.o(goToVideoImmersivePage.a());
                    gxaVar2.x(goToVideoImmersivePage.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                gxaVar2.s(true);
                gxa jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    gxaVar2.y(jumpToVideo.f());
                    gxaVar2.u(jumpToVideo.b());
                    gxaVar2.o(jumpToVideo.a());
                    gxaVar2.x(jumpToVideo.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                gxaVar2.s(true);
                gxa closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    gxaVar2.y(closeNativeMask.f());
                    gxaVar2.u(closeNativeMask.b());
                    gxaVar2.o(closeNativeMask.a());
                    gxaVar2.x(closeNativeMask.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                gxaVar2.s(true);
                gxa oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    gxaVar2.y(oneKeyDeletion.f());
                    gxaVar2.u(oneKeyDeletion.b());
                    gxaVar2.o(oneKeyDeletion.a());
                    gxaVar2.x(oneKeyDeletion.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                gxaVar2.s(true);
                gxa checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    gxaVar2.y(checkAppInstall.f());
                    gxaVar2.u(checkAppInstall.b());
                    gxaVar2.o(checkAppInstall.a());
                    gxaVar2.x(checkAppInstall.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                gxaVar2.s(true);
                gxa disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    gxaVar2.y(disableBack.f());
                    gxaVar2.u(disableBack.b());
                    gxaVar2.o(disableBack.a());
                    gxaVar2.x(disableBack.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                gxaVar2.s(true);
                gxa startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    gxaVar2.y(startApp.f());
                    gxaVar2.u(startApp.b());
                    gxaVar2.o(startApp.a());
                    gxaVar2.x(startApp.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                gxaVar2.s(true);
                gxa hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    gxaVar2.y(hasNotificationPermission.f());
                    gxaVar2.u(hasNotificationPermission.b());
                    gxaVar2.o(hasNotificationPermission.a());
                    gxaVar2.x(hasNotificationPermission.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                gxaVar2.s(true);
                gxa goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    gxaVar2.y(goToNotificationSetting.f());
                    gxaVar2.u(goToNotificationSetting.b());
                    gxaVar2.o(goToNotificationSetting.a());
                    gxaVar2.x(goToNotificationSetting.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                gxaVar2.s(true);
                gxa startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    gxaVar2.y(startDownloadGameApk.f());
                    gxaVar2.u(startDownloadGameApk.b());
                    gxaVar2.o(startDownloadGameApk.a());
                    gxaVar2.x(startDownloadGameApk.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                gxaVar2.s(true);
                gxa checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    gxaVar2.y(checkInstallGameApk.f());
                    gxaVar2.u(checkInstallGameApk.b());
                    gxaVar2.o(checkInstallGameApk.a());
                    gxaVar2.x(checkInstallGameApk.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                gxaVar2.s(true);
                gxa startDownloadCss = this.mJsBridge.startDownloadCss(e.optString("downloadUrl"));
                if (startDownloadCss != null) {
                    gxaVar2.y(startDownloadCss.f());
                    gxaVar2.u(startDownloadCss.b());
                    gxaVar2.o(startDownloadCss.a());
                    gxaVar2.x(startDownloadCss.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                gxaVar2.s(true);
                gxa disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    gxaVar2.y(disableGoBack.f());
                    gxaVar2.u(disableGoBack.b());
                    gxaVar2.o(disableGoBack.a());
                    gxaVar2.x(disableGoBack.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                gxaVar2.s(true);
                gxa supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    gxaVar2.y(supplementInfo.f());
                    gxaVar2.u(supplementInfo.b());
                    gxaVar2.o(supplementInfo.a());
                    gxaVar2.x(supplementInfo.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                gxaVar2.s(true);
                gxa deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    gxaVar2.y(deviceGyroscopeParams.f());
                    gxaVar2.u(deviceGyroscopeParams.b());
                    gxaVar2.o(deviceGyroscopeParams.a());
                    gxaVar2.x(deviceGyroscopeParams.e());
                    if (!gxaVar2.h()) {
                        i10 = 0;
                        gxaVar2.n(false);
                        addObserver("deviceMotion", gxaVar2, false);
                        gxaVar2.z(i10);
                    }
                }
                i10 = 0;
                gxaVar2.z(i10);
            } else if (b.equals("device/deviceRefreshRate")) {
                gxaVar2.s(true);
                gxa deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    gxaVar2.y(deviceRefreshRateParams.f());
                    gxaVar2.u(deviceRefreshRateParams.b());
                    gxaVar2.o(deviceRefreshRateParams.a());
                    gxaVar2.x(deviceRefreshRateParams.e());
                    if (!gxaVar2.h()) {
                        i9 = 0;
                        gxaVar2.n(false);
                        addObserver("deviceRefreshRate", gxaVar2, false);
                        gxaVar2.z(i9);
                    }
                }
                i9 = 0;
                gxaVar2.z(i9);
            } else if (b.equals("device/getDeviceInfo")) {
                gxaVar2.s(true);
                gxa deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    gxaVar2.y(deviceInfo.f());
                    gxaVar2.u(deviceInfo.b());
                    gxaVar2.o(deviceInfo.a());
                    gxaVar2.x(deviceInfo.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                gxaVar2.s(true);
                gxa sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    gxaVar2.y(sendCompleteTaskReqMsg.f());
                    gxaVar2.u(sendCompleteTaskReqMsg.b());
                    gxaVar2.o(sendCompleteTaskReqMsg.a());
                    gxaVar2.x(sendCompleteTaskReqMsg.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                gxaVar2.s(true);
                gxa showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    gxaVar2.y(showTipToast.f());
                    gxaVar2.u(showTipToast.b());
                    gxaVar2.o(showTipToast.a());
                    gxaVar2.x(showTipToast.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                gxaVar2.s(true);
                gxa getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    gxaVar2.y(getModalData.f());
                    gxaVar2.u(getModalData.b());
                    gxaVar2.o(getModalData.a());
                    gxaVar2.x(getModalData.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                gxaVar2.s(true);
                gxa openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    gxaVar2.y(openThirdPartApp.f());
                    gxaVar2.u(openThirdPartApp.b());
                    gxaVar2.o(openThirdPartApp.a());
                    gxaVar2.x(openThirdPartApp.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                gxaVar2.s(true);
                gxa jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    gxaVar2.y(jumpToHtmlPage.f());
                    gxaVar2.u(jumpToHtmlPage.b());
                    gxaVar2.o(jumpToHtmlPage.a());
                    gxaVar2.x(jumpToHtmlPage.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                gxaVar2.s(true);
                gxa offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    gxaVar2.y(offlineUserInfo.f());
                    gxaVar2.u(offlineUserInfo.b());
                    gxaVar2.o(offlineUserInfo.a());
                    gxaVar2.x(offlineUserInfo.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                gxaVar2.s(true);
                gxa deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    gxaVar2.y(deleteOfflineBundle.f());
                    gxaVar2.u(deleteOfflineBundle.b());
                    gxaVar2.o(deleteOfflineBundle.a());
                    gxaVar2.x(deleteOfflineBundle.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                gxaVar2.s(true);
                gxa updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    gxaVar2.y(updateOfflineBundle.f());
                    gxaVar2.u(updateOfflineBundle.b());
                    gxaVar2.o(updateOfflineBundle.a());
                    gxaVar2.x(updateOfflineBundle.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                gxaVar2.s(true);
                gxa switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    gxaVar2.y(switchOfflineInterface.f());
                    gxaVar2.u(switchOfflineInterface.b());
                    gxaVar2.o(switchOfflineInterface.a());
                    gxaVar2.x(switchOfflineInterface.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                gxaVar2.s(true);
                gxa switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    gxaVar2.y(switchOfflineBundleStatus.f());
                    gxaVar2.u(switchOfflineBundleStatus.b());
                    gxaVar2.o(switchOfflineBundleStatus.a());
                    gxaVar2.x(switchOfflineBundleStatus.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                gxaVar2.s(true);
                gxa finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    gxaVar2.y(finishTestAnswer.f());
                    gxaVar2.u(finishTestAnswer.b());
                    gxaVar2.o(finishTestAnswer.a());
                    gxaVar2.x(finishTestAnswer.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                gxaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                gxa switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    gxaVar2.y(switchUrlHost.f());
                    gxaVar2.u(switchUrlHost.b());
                    gxaVar2.o(switchUrlHost.a());
                    gxaVar2.x(switchUrlHost.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                gxaVar2.s(true);
                gxa appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    gxaVar2.y(appStorage.f());
                    gxaVar2.u(appStorage.b());
                    gxaVar2.o(appStorage.a());
                    gxaVar2.x(appStorage.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                gxaVar2.s(true);
                gxa putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    gxaVar2.y(putAppStorage.f());
                    gxaVar2.u(putAppStorage.b());
                    gxaVar2.o(putAppStorage.a());
                    gxaVar2.x(putAppStorage.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                gxaVar2.s(true);
                gxa historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    gxaVar2.y(historyForumData.f());
                    gxaVar2.u(historyForumData.b());
                    gxaVar2.o(historyForumData.a());
                    gxaVar2.x(historyForumData.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                gxaVar2.s(true);
                gxa worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    gxaVar2.y(worldCupRaiseSuccess.f());
                    gxaVar2.u(worldCupRaiseSuccess.b());
                    gxaVar2.o(worldCupRaiseSuccess.a());
                    gxaVar2.x(worldCupRaiseSuccess.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                gxaVar2.s(true);
                gxa alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    gxaVar2.y(alipayUserId.f());
                    gxaVar2.u(alipayUserId.b());
                    gxaVar2.o(alipayUserId.a());
                    gxaVar2.x(alipayUserId.e());
                    if (!gxaVar2.h()) {
                        i8 = 0;
                        gxaVar2.n(false);
                        addObserver("aliAuthResult", gxaVar2, false);
                        gxaVar2.z(i8);
                    }
                }
                i8 = 0;
                gxaVar2.z(i8);
            } else if (b.equals("system/getFileDownloadStatus")) {
                gxaVar2.s(true);
                gxa fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"), e.optString("pkgName"));
                if (fileDownloadStatus != null) {
                    gxaVar2.y(fileDownloadStatus.f());
                    gxaVar2.u(fileDownloadStatus.b());
                    gxaVar2.o(fileDownloadStatus.a());
                    gxaVar2.x(fileDownloadStatus.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                gxaVar2.s(true);
                gxa fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"), e.optString("pkgName"));
                if (fileDownloadProgress != null) {
                    gxaVar2.y(fileDownloadProgress.f());
                    gxaVar2.u(fileDownloadProgress.b());
                    gxaVar2.o(fileDownloadProgress.a());
                    gxaVar2.x(fileDownloadProgress.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                gxaVar2.s(true);
                gxa fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"), e.optString("pkgName"));
                if (fileDownloadPause != null) {
                    gxaVar2.y(fileDownloadPause.f());
                    gxaVar2.u(fileDownloadPause.b());
                    gxaVar2.o(fileDownloadPause.a());
                    gxaVar2.x(fileDownloadPause.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                gxaVar2.s(true);
                gxa fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"), e.optString("pkgName"));
                if (fileDownloadDelete != null) {
                    gxaVar2.y(fileDownloadDelete.f());
                    gxaVar2.u(fileDownloadDelete.b());
                    gxaVar2.o(fileDownloadDelete.a());
                    gxaVar2.x(fileDownloadDelete.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                gxaVar2.s(true);
                gxa installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    gxaVar2.y(installGameApk.f());
                    gxaVar2.u(installGameApk.b());
                    gxaVar2.o(installGameApk.a());
                    gxaVar2.x(installGameApk.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                gxaVar2.s(true);
                gxa launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    gxaVar2.y(launchApk.f());
                    gxaVar2.u(launchApk.b());
                    gxaVar2.o(launchApk.a());
                    gxaVar2.x(launchApk.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                gxaVar2.s(true);
                gxa wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    gxaVar2.y(wakeKeyboard.f());
                    gxaVar2.u(wakeKeyboard.b());
                    gxaVar2.o(wakeKeyboard.a());
                    gxaVar2.x(wakeKeyboard.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                gxaVar2.s(true);
                gxa replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    gxaVar2.y(replyPost.f());
                    gxaVar2.u(replyPost.b());
                    gxaVar2.o(replyPost.a());
                    gxaVar2.x(replyPost.e());
                    if (!gxaVar2.h()) {
                        i7 = 0;
                        gxaVar2.n(false);
                        addObserver("replyPostResult", gxaVar2, false);
                        gxaVar2.z(i7);
                    }
                }
                i7 = 0;
                gxaVar2.z(i7);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                gxaVar2.s(true);
                gxa nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    gxaVar2.y(nativeNetworkProxy.f());
                    gxaVar2.u(nativeNetworkProxy.b());
                    gxaVar2.o(nativeNetworkProxy.a());
                    gxaVar2.x(nativeNetworkProxy.e());
                    if (!gxaVar2.h()) {
                        i6 = 0;
                        gxaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", gxaVar2, false);
                        gxaVar2.z(i6);
                    }
                }
                i6 = 0;
                gxaVar2.z(i6);
            } else if (b.equals("host/sendMsg")) {
                gxaVar2.s(true);
                gxa sendMessage = this.mJsBridge.sendMessage(e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (sendMessage != null) {
                    gxaVar2.y(sendMessage.f());
                    gxaVar2.u(sendMessage.b());
                    gxaVar2.o(sendMessage.a());
                    gxaVar2.x(sendMessage.e());
                    if (!gxaVar2.h()) {
                        i5 = 0;
                        gxaVar2.n(false);
                        addObserver("sendMsg", gxaVar2, false);
                        gxaVar2.z(i5);
                    }
                }
                i5 = 0;
                gxaVar2.z(i5);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                gxaVar2.s(true);
                gxa fetchHistoryMsgs = this.mJsBridge.fetchHistoryMsgs(e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (fetchHistoryMsgs != null) {
                    gxaVar2.y(fetchHistoryMsgs.f());
                    gxaVar2.u(fetchHistoryMsgs.b());
                    gxaVar2.o(fetchHistoryMsgs.a());
                    gxaVar2.x(fetchHistoryMsgs.e());
                    if (!gxaVar2.h()) {
                        i4 = 0;
                        gxaVar2.n(false);
                        addObserver("fetchHistoryMsgs", gxaVar2, false);
                        gxaVar2.z(i4);
                    }
                }
                i4 = 0;
                gxaVar2.z(i4);
            } else if (b.equals("host/receiveNewMsgs")) {
                gxaVar2.s(true);
                gxa receiveNewMsgs = this.mJsBridge.receiveNewMsgs();
                this.mNotificationNameList.add("receiveNewMsgs");
                if (receiveNewMsgs != null) {
                    gxaVar2.y(receiveNewMsgs.f());
                    gxaVar2.u(receiveNewMsgs.b());
                    gxaVar2.o(receiveNewMsgs.a());
                    gxaVar2.x(receiveNewMsgs.e());
                    if (!gxaVar2.h()) {
                        i3 = 0;
                        gxaVar2.n(false);
                        addObserver("receiveNewMsgs", gxaVar2, false);
                        gxaVar2.z(i3);
                    }
                }
                i3 = 0;
                gxaVar2.z(i3);
            } else if (b.equals("system/keyboardHeightChange")) {
                gxaVar2.s(true);
                gxa keyboardHeightChange = this.mJsBridge.keyboardHeightChange();
                this.mNotificationNameList.add("keyboardHeightChange");
                if (keyboardHeightChange != null) {
                    gxaVar2.y(keyboardHeightChange.f());
                    gxaVar2.u(keyboardHeightChange.b());
                    gxaVar2.o(keyboardHeightChange.a());
                    gxaVar2.x(keyboardHeightChange.e());
                    if (!gxaVar2.h()) {
                        i2 = 0;
                        gxaVar2.n(false);
                        addObserver("keyboardHeightChange", gxaVar2, false);
                        gxaVar2.z(i2);
                    }
                }
                i2 = 0;
                gxaVar2.z(i2);
            } else if (b.equals("host/preloadPic")) {
                gxaVar2.s(true);
                ArrayList<String> arrayList6 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList6, e.optJSONArray("url"));
                gxa perloadPicModule = this.mJsBridge.perloadPicModule(arrayList6);
                if (perloadPicModule != null) {
                    gxaVar2.y(perloadPicModule.f());
                    gxaVar2.u(perloadPicModule.b());
                    gxaVar2.o(perloadPicModule.a());
                    gxaVar2.x(perloadPicModule.e());
                }
                gxaVar2.z(0);
            } else if (b.equals("toast/showDialog")) {
                gxaVar2.s(true);
                gxa showDialog = this.mJsBridge.showDialog(e.optInt("type"), e.optString("content"), e.optString("dialogId"));
                this.mNotificationNameList.add("showDialog");
                if (showDialog != null) {
                    gxaVar2.y(showDialog.f());
                    gxaVar2.u(showDialog.b());
                    gxaVar2.o(showDialog.a());
                    gxaVar2.x(showDialog.e());
                    if (!gxaVar2.h()) {
                        i = 0;
                        gxaVar2.n(false);
                        addObserver("showDialog", gxaVar2, false);
                        gxaVar2.z(i);
                    }
                }
                i = 0;
                gxaVar2.z(i);
            }
            return gxaVar2;
        }
        return (gxa) invokeLL.objValue;
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

    @Override // com.baidu.tieba.exa
    public List<gxa> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            gxa gxaVar = null;
            if (rd.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                gxaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                gxaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                gxaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                gxaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                gxaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                gxaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                gxaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                gxaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                gxaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                gxaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                gxaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                gxaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                gxaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                gxaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                gxaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                gxaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                gxaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                gxaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                gxaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                gxaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                gxaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                gxaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                gxaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                gxaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                gxaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                gxaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                gxaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                gxaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                gxaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                gxaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("sendMsg")) {
                gxaVar = this.mJsBridge.onSendMsgResult(hashMap);
            } else if (str.equals("handleAudioMsgByTTS")) {
                gxaVar = this.mJsBridge.handleVoiceMsgResult(hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                gxaVar = this.mJsBridge.onFetchHistoryMsgsResult(hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                gxaVar = this.mJsBridge.onReceiveNewMsgsResult(hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                gxaVar = this.mJsBridge.onKeyboardHeightChange(hashMap);
            }
            if (gxaVar != null) {
                gxaVar.z(0);
            }
            List<fxa> list = this.mAsyncCallBackMethodList.get(str);
            if (gxaVar != null && list != null) {
                Iterator<fxa> it = list.iterator();
                if (!rd.isEmpty(gxaVar.e())) {
                    while (it.hasNext()) {
                        fxa next = it.next();
                        if (next.b().equals(gxaVar.e())) {
                            gxa gxaVar2 = new gxa();
                            gxaVar2.w(next.a());
                            gxaVar2.y(gxaVar.f());
                            gxaVar2.u(gxaVar.b());
                            gxaVar2.o(gxaVar.a());
                            gxaVar2.A(gxaVar.l());
                            arrayList.add(gxaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        fxa next2 = it.next();
                        gxa gxaVar3 = new gxa();
                        gxaVar3.w(next2.a());
                        gxaVar3.y(gxaVar.f());
                        gxaVar3.u(gxaVar.b());
                        gxaVar3.o(gxaVar.a());
                        gxaVar3.A(gxaVar.l());
                        arrayList.add(gxaVar3);
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
