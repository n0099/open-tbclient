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
import com.baidu.tieba.oda;
import com.baidu.tieba.pda;
import com.baidu.tieba.qda;
import com.baidu.tieba.sda;
import com.baidu.tieba.xi;
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
public class CommonTbJsBridge_Proxy extends oda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.oda
    public qda dispatch(sda sdaVar, qda qdaVar) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sdaVar, qdaVar)) == null) {
            qda qdaVar2 = qdaVar == null ? new qda() : qdaVar;
            String b = sdaVar.b();
            JSONObject e = sdaVar.e();
            if (b.equals("account/startLoginModule")) {
                qdaVar2.s(true);
                qda startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    qdaVar2.y(startLoginModule.f());
                    qdaVar2.u(startLoginModule.b());
                    qdaVar2.o(startLoginModule.a());
                    qdaVar2.x(startLoginModule.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("account/authState")) {
                qdaVar2.s(true);
                qda checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    qdaVar2.y(checkAuthState.f());
                    qdaVar2.u(checkAuthState.b());
                    qdaVar2.o(checkAuthState.a());
                    qdaVar2.x(checkAuthState.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                qdaVar2.s(true);
                qda startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    qdaVar2.y(startAllLoginModule.f());
                    qdaVar2.u(startAllLoginModule.b());
                    qdaVar2.o(startAllLoginModule.a());
                    qdaVar2.x(startAllLoginModule.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver("commonLogin", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                qdaVar2.s(true);
                qda realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    qdaVar2.y(realNameAuth.f());
                    qdaVar2.u(realNameAuth.b());
                    qdaVar2.o(realNameAuth.a());
                    qdaVar2.x(realNameAuth.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver("realNameAuthResult", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                qdaVar2.s(true);
                qda finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    qdaVar2.y(finishPage.f());
                    qdaVar2.u(finishPage.b());
                    qdaVar2.o(finishPage.a());
                    qdaVar2.x(finishPage.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                qdaVar2.s(true);
                qda showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    qdaVar2.y(showLowerHairHint.f());
                    qdaVar2.u(showLowerHairHint.b());
                    qdaVar2.o(showLowerHairHint.a());
                    qdaVar2.x(showLowerHairHint.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                qdaVar2.s(true);
                qda gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    qdaVar2.y(gamePush.f());
                    qdaVar2.u(gamePush.b());
                    qdaVar2.o(gamePush.a());
                    qdaVar2.x(gamePush.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                qdaVar2.s(true);
                qda handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    qdaVar2.y(handleGamePushStatus.f());
                    qdaVar2.u(handleGamePushStatus.b());
                    qdaVar2.o(handleGamePushStatus.a());
                    qdaVar2.x(handleGamePushStatus.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                qdaVar2.s(true);
                qda jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    qdaVar2.y(jumpForumRulesEditPage.f());
                    qdaVar2.u(jumpForumRulesEditPage.b());
                    qdaVar2.o(jumpForumRulesEditPage.a());
                    qdaVar2.x(jumpForumRulesEditPage.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                qdaVar2.s(true);
                qda handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    qdaVar2.y(handleGoToBarDetail.f());
                    qdaVar2.u(handleGoToBarDetail.b());
                    qdaVar2.o(handleGoToBarDetail.a());
                    qdaVar2.x(handleGoToBarDetail.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                qdaVar2.s(true);
                qda handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    qdaVar2.y(handleSaveImage.f());
                    qdaVar2.u(handleSaveImage.b());
                    qdaVar2.o(handleSaveImage.a());
                    qdaVar2.x(handleSaveImage.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver("saveImageSuccess", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                qdaVar2.s(true);
                qda orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    qdaVar2.y(orderGameApk.f());
                    qdaVar2.u(orderGameApk.b());
                    qdaVar2.o(orderGameApk.a());
                    qdaVar2.x(orderGameApk.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver("orderGameApkResult", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                qdaVar2.s(true);
                qda handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    qdaVar2.y(handleGetPhotoAlbum.f());
                    qdaVar2.u(handleGetPhotoAlbum.b());
                    qdaVar2.o(handleGetPhotoAlbum.a());
                    qdaVar2.x(handleGetPhotoAlbum.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver("GetPhotoAlbum", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                qdaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                qda preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    qdaVar2.y(preheatWeb.f());
                    qdaVar2.u(preheatWeb.b());
                    qdaVar2.o(preheatWeb.a());
                    qdaVar2.x(preheatWeb.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                qdaVar2.s(true);
                qda openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    qdaVar2.y(openMXDYab.f());
                    qdaVar2.u(openMXDYab.b());
                    qdaVar2.o(openMXDYab.a());
                    qdaVar2.x(openMXDYab.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/portal")) {
                qdaVar2.s(true);
                qda handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    qdaVar2.y(handlePortal.f());
                    qdaVar2.u(handlePortal.b());
                    qdaVar2.o(handlePortal.a());
                    qdaVar2.x(handlePortal.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                qdaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                qda selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    qdaVar2.y(selectPhotoAlbum.f());
                    qdaVar2.u(selectPhotoAlbum.b());
                    qdaVar2.o(selectPhotoAlbum.a());
                    qdaVar2.x(selectPhotoAlbum.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver("selectPhotoAlbum", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                qdaVar2.s(true);
                qda operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    qdaVar2.y(operateNotifyDataChanged.f());
                    qdaVar2.u(operateNotifyDataChanged.b());
                    qdaVar2.o(operateNotifyDataChanged.a());
                    qdaVar2.x(operateNotifyDataChanged.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                qdaVar2.s(true);
                qda viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    qdaVar2.y(viewPosition.f());
                    qdaVar2.u(viewPosition.b());
                    qdaVar2.o(viewPosition.a());
                    qdaVar2.x(viewPosition.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                qdaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                qda selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    qdaVar2.y(selectPrivateMsg.f());
                    qdaVar2.u(selectPrivateMsg.b());
                    qdaVar2.o(selectPrivateMsg.a());
                    qdaVar2.x(selectPrivateMsg.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                qdaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                qda reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    qdaVar2.y(reportUserTheme.f());
                    qdaVar2.u(reportUserTheme.b());
                    qdaVar2.o(reportUserTheme.a());
                    qdaVar2.x(reportUserTheme.e());
                    if (!qdaVar2.h()) {
                        qdaVar2.n(false);
                        addObserver("goToReportThreadPage", qdaVar2, false);
                    }
                }
                qdaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                qdaVar2.s(true);
                qda playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    qdaVar2.y(playSound.f());
                    qdaVar2.u(playSound.b());
                    qdaVar2.o(playSound.a());
                    qdaVar2.x(playSound.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                qdaVar2.s(true);
                qda playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    qdaVar2.y(playVibrate.f());
                    qdaVar2.u(playVibrate.b());
                    qdaVar2.o(playVibrate.a());
                    qdaVar2.x(playVibrate.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                qdaVar2.s(true);
                qda localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    qdaVar2.y(localYaLog.f());
                    qdaVar2.u(localYaLog.b());
                    qdaVar2.o(localYaLog.a());
                    qdaVar2.x(localYaLog.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                qdaVar2.s(true);
                qda jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    qdaVar2.y(jumpLoginActivity.f());
                    qdaVar2.u(jumpLoginActivity.b());
                    qdaVar2.o(jumpLoginActivity.a());
                    qdaVar2.x(jumpLoginActivity.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                qdaVar2.s(true);
                qda startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    qdaVar2.y(startLoadTimeInterval.f());
                    qdaVar2.u(startLoadTimeInterval.b());
                    qdaVar2.o(startLoadTimeInterval.a());
                    qdaVar2.x(startLoadTimeInterval.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                qdaVar2.s(true);
                qda zid = this.mJsBridge.getZid();
                if (zid != null) {
                    qdaVar2.y(zid.f());
                    qdaVar2.u(zid.b());
                    qdaVar2.o(zid.a());
                    qdaVar2.x(zid.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                qdaVar2.s(true);
                qda hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    qdaVar2.y(hdid.f());
                    qdaVar2.u(hdid.b());
                    qdaVar2.o(hdid.a());
                    qdaVar2.x(hdid.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                qdaVar2.s(true);
                qda shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    qdaVar2.y(shareInfo.f());
                    qdaVar2.u(shareInfo.b());
                    qdaVar2.o(shareInfo.a());
                    qdaVar2.x(shareInfo.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("share/share")) {
                qdaVar2.s(true);
                qda share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    qdaVar2.y(share.f());
                    qdaVar2.u(share.b());
                    qdaVar2.o(share.a());
                    qdaVar2.x(share.e());
                    if (!qdaVar2.h()) {
                        i6 = 0;
                        qdaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, qdaVar2, false);
                        qdaVar2.z(i6);
                    }
                }
                i6 = 0;
                qdaVar2.z(i6);
            } else if (b.equals("clipper/getClipperInformation")) {
                qdaVar2.s(true);
                qda clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    qdaVar2.y(clipperInformation.f());
                    qdaVar2.u(clipperInformation.b());
                    qdaVar2.o(clipperInformation.a());
                    qdaVar2.x(clipperInformation.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                qdaVar2.s(true);
                qda clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    qdaVar2.y(clipperInformation2.f());
                    qdaVar2.u(clipperInformation2.b());
                    qdaVar2.o(clipperInformation2.a());
                    qdaVar2.x(clipperInformation2.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                qdaVar2.s(true);
                qda goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    qdaVar2.y(goToEditPost.f());
                    qdaVar2.u(goToEditPost.b());
                    qdaVar2.o(goToEditPost.a());
                    qdaVar2.x(goToEditPost.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                qdaVar2.s(true);
                qda updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    qdaVar2.y(updateSearchForumInfo.f());
                    qdaVar2.u(updateSearchForumInfo.b());
                    qdaVar2.o(updateSearchForumInfo.a());
                    qdaVar2.x(updateSearchForumInfo.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                qdaVar2.s(true);
                qda personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    qdaVar2.y(personlizedSwitchChange.f());
                    qdaVar2.u(personlizedSwitchChange.b());
                    qdaVar2.o(personlizedSwitchChange.a());
                    qdaVar2.x(personlizedSwitchChange.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                qdaVar2.s(true);
                qda updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    qdaVar2.y(updateTailStyle.f());
                    qdaVar2.u(updateTailStyle.b());
                    qdaVar2.o(updateTailStyle.a());
                    qdaVar2.x(updateTailStyle.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                qdaVar2.s(true);
                qda goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    qdaVar2.y(goToVideoImmersivePage.f());
                    qdaVar2.u(goToVideoImmersivePage.b());
                    qdaVar2.o(goToVideoImmersivePage.a());
                    qdaVar2.x(goToVideoImmersivePage.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                qdaVar2.s(true);
                qda jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    qdaVar2.y(jumpToVideo.f());
                    qdaVar2.u(jumpToVideo.b());
                    qdaVar2.o(jumpToVideo.a());
                    qdaVar2.x(jumpToVideo.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                qdaVar2.s(true);
                qda closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    qdaVar2.y(closeNativeMask.f());
                    qdaVar2.u(closeNativeMask.b());
                    qdaVar2.o(closeNativeMask.a());
                    qdaVar2.x(closeNativeMask.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                qdaVar2.s(true);
                qda oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    qdaVar2.y(oneKeyDeletion.f());
                    qdaVar2.u(oneKeyDeletion.b());
                    qdaVar2.o(oneKeyDeletion.a());
                    qdaVar2.x(oneKeyDeletion.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                qdaVar2.s(true);
                qda checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    qdaVar2.y(checkAppInstall.f());
                    qdaVar2.u(checkAppInstall.b());
                    qdaVar2.o(checkAppInstall.a());
                    qdaVar2.x(checkAppInstall.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                qdaVar2.s(true);
                qda disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    qdaVar2.y(disableBack.f());
                    qdaVar2.u(disableBack.b());
                    qdaVar2.o(disableBack.a());
                    qdaVar2.x(disableBack.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                qdaVar2.s(true);
                qda startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    qdaVar2.y(startApp.f());
                    qdaVar2.u(startApp.b());
                    qdaVar2.o(startApp.a());
                    qdaVar2.x(startApp.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                qdaVar2.s(true);
                qda hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    qdaVar2.y(hasNotificationPermission.f());
                    qdaVar2.u(hasNotificationPermission.b());
                    qdaVar2.o(hasNotificationPermission.a());
                    qdaVar2.x(hasNotificationPermission.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                qdaVar2.s(true);
                qda goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    qdaVar2.y(goToNotificationSetting.f());
                    qdaVar2.u(goToNotificationSetting.b());
                    qdaVar2.o(goToNotificationSetting.a());
                    qdaVar2.x(goToNotificationSetting.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                qdaVar2.s(true);
                qda startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    qdaVar2.y(startDownloadGameApk.f());
                    qdaVar2.u(startDownloadGameApk.b());
                    qdaVar2.o(startDownloadGameApk.a());
                    qdaVar2.x(startDownloadGameApk.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                qdaVar2.s(true);
                qda checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    qdaVar2.y(checkInstallGameApk.f());
                    qdaVar2.u(checkInstallGameApk.b());
                    qdaVar2.o(checkInstallGameApk.a());
                    qdaVar2.x(checkInstallGameApk.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                qdaVar2.s(true);
                qda startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    qdaVar2.y(startDownloadCss.f());
                    qdaVar2.u(startDownloadCss.b());
                    qdaVar2.o(startDownloadCss.a());
                    qdaVar2.x(startDownloadCss.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                qdaVar2.s(true);
                qda disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    qdaVar2.y(disableGoBack.f());
                    qdaVar2.u(disableGoBack.b());
                    qdaVar2.o(disableGoBack.a());
                    qdaVar2.x(disableGoBack.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                qdaVar2.s(true);
                qda supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    qdaVar2.y(supplementInfo.f());
                    qdaVar2.u(supplementInfo.b());
                    qdaVar2.o(supplementInfo.a());
                    qdaVar2.x(supplementInfo.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                qdaVar2.s(true);
                qda deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    qdaVar2.y(deviceGyroscopeParams.f());
                    qdaVar2.u(deviceGyroscopeParams.b());
                    qdaVar2.o(deviceGyroscopeParams.a());
                    qdaVar2.x(deviceGyroscopeParams.e());
                    if (!qdaVar2.h()) {
                        i5 = 0;
                        qdaVar2.n(false);
                        addObserver("deviceMotion", qdaVar2, false);
                        qdaVar2.z(i5);
                    }
                }
                i5 = 0;
                qdaVar2.z(i5);
            } else if (b.equals("device/deviceRefreshRate")) {
                qdaVar2.s(true);
                qda deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    qdaVar2.y(deviceRefreshRateParams.f());
                    qdaVar2.u(deviceRefreshRateParams.b());
                    qdaVar2.o(deviceRefreshRateParams.a());
                    qdaVar2.x(deviceRefreshRateParams.e());
                    if (!qdaVar2.h()) {
                        i4 = 0;
                        qdaVar2.n(false);
                        addObserver("deviceRefreshRate", qdaVar2, false);
                        qdaVar2.z(i4);
                    }
                }
                i4 = 0;
                qdaVar2.z(i4);
            } else if (b.equals("device/getDeviceInfo")) {
                qdaVar2.s(true);
                qda deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    qdaVar2.y(deviceInfo.f());
                    qdaVar2.u(deviceInfo.b());
                    qdaVar2.o(deviceInfo.a());
                    qdaVar2.x(deviceInfo.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                qdaVar2.s(true);
                qda sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    qdaVar2.y(sendCompleteTaskReqMsg.f());
                    qdaVar2.u(sendCompleteTaskReqMsg.b());
                    qdaVar2.o(sendCompleteTaskReqMsg.a());
                    qdaVar2.x(sendCompleteTaskReqMsg.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                qdaVar2.s(true);
                qda showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    qdaVar2.y(showTipToast.f());
                    qdaVar2.u(showTipToast.b());
                    qdaVar2.o(showTipToast.a());
                    qdaVar2.x(showTipToast.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                qdaVar2.s(true);
                qda getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    qdaVar2.y(getModalData.f());
                    qdaVar2.u(getModalData.b());
                    qdaVar2.o(getModalData.a());
                    qdaVar2.x(getModalData.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                qdaVar2.s(true);
                qda openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    qdaVar2.y(openThirdPartApp.f());
                    qdaVar2.u(openThirdPartApp.b());
                    qdaVar2.o(openThirdPartApp.a());
                    qdaVar2.x(openThirdPartApp.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                qdaVar2.s(true);
                qda jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    qdaVar2.y(jumpToHtmlPage.f());
                    qdaVar2.u(jumpToHtmlPage.b());
                    qdaVar2.o(jumpToHtmlPage.a());
                    qdaVar2.x(jumpToHtmlPage.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                qdaVar2.s(true);
                qda offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    qdaVar2.y(offlineUserInfo.f());
                    qdaVar2.u(offlineUserInfo.b());
                    qdaVar2.o(offlineUserInfo.a());
                    qdaVar2.x(offlineUserInfo.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                qdaVar2.s(true);
                qda deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    qdaVar2.y(deleteOfflineBundle.f());
                    qdaVar2.u(deleteOfflineBundle.b());
                    qdaVar2.o(deleteOfflineBundle.a());
                    qdaVar2.x(deleteOfflineBundle.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                qdaVar2.s(true);
                qda updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    qdaVar2.y(updateOfflineBundle.f());
                    qdaVar2.u(updateOfflineBundle.b());
                    qdaVar2.o(updateOfflineBundle.a());
                    qdaVar2.x(updateOfflineBundle.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                qdaVar2.s(true);
                qda switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    qdaVar2.y(switchOfflineInterface.f());
                    qdaVar2.u(switchOfflineInterface.b());
                    qdaVar2.o(switchOfflineInterface.a());
                    qdaVar2.x(switchOfflineInterface.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                qdaVar2.s(true);
                qda switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    qdaVar2.y(switchOfflineBundleStatus.f());
                    qdaVar2.u(switchOfflineBundleStatus.b());
                    qdaVar2.o(switchOfflineBundleStatus.a());
                    qdaVar2.x(switchOfflineBundleStatus.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                qdaVar2.s(true);
                qda finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    qdaVar2.y(finishTestAnswer.f());
                    qdaVar2.u(finishTestAnswer.b());
                    qdaVar2.o(finishTestAnswer.a());
                    qdaVar2.x(finishTestAnswer.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                qdaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                qda switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    qdaVar2.y(switchUrlHost.f());
                    qdaVar2.u(switchUrlHost.b());
                    qdaVar2.o(switchUrlHost.a());
                    qdaVar2.x(switchUrlHost.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                qdaVar2.s(true);
                qda appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    qdaVar2.y(appStorage.f());
                    qdaVar2.u(appStorage.b());
                    qdaVar2.o(appStorage.a());
                    qdaVar2.x(appStorage.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                qdaVar2.s(true);
                qda putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    qdaVar2.y(putAppStorage.f());
                    qdaVar2.u(putAppStorage.b());
                    qdaVar2.o(putAppStorage.a());
                    qdaVar2.x(putAppStorage.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                qdaVar2.s(true);
                qda historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    qdaVar2.y(historyForumData.f());
                    qdaVar2.u(historyForumData.b());
                    qdaVar2.o(historyForumData.a());
                    qdaVar2.x(historyForumData.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                qdaVar2.s(true);
                qda worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    qdaVar2.y(worldCupRaiseSuccess.f());
                    qdaVar2.u(worldCupRaiseSuccess.b());
                    qdaVar2.o(worldCupRaiseSuccess.a());
                    qdaVar2.x(worldCupRaiseSuccess.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                qdaVar2.s(true);
                qda alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    qdaVar2.y(alipayUserId.f());
                    qdaVar2.u(alipayUserId.b());
                    qdaVar2.o(alipayUserId.a());
                    qdaVar2.x(alipayUserId.e());
                    if (!qdaVar2.h()) {
                        i3 = 0;
                        qdaVar2.n(false);
                        addObserver("aliAuthResult", qdaVar2, false);
                        qdaVar2.z(i3);
                    }
                }
                i3 = 0;
                qdaVar2.z(i3);
            } else if (b.equals("system/getFileDownloadStatus")) {
                qdaVar2.s(true);
                qda fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    qdaVar2.y(fileDownloadStatus.f());
                    qdaVar2.u(fileDownloadStatus.b());
                    qdaVar2.o(fileDownloadStatus.a());
                    qdaVar2.x(fileDownloadStatus.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                qdaVar2.s(true);
                qda fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    qdaVar2.y(fileDownloadProgress.f());
                    qdaVar2.u(fileDownloadProgress.b());
                    qdaVar2.o(fileDownloadProgress.a());
                    qdaVar2.x(fileDownloadProgress.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                qdaVar2.s(true);
                qda fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    qdaVar2.y(fileDownloadPause.f());
                    qdaVar2.u(fileDownloadPause.b());
                    qdaVar2.o(fileDownloadPause.a());
                    qdaVar2.x(fileDownloadPause.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                qdaVar2.s(true);
                qda fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    qdaVar2.y(fileDownloadDelete.f());
                    qdaVar2.u(fileDownloadDelete.b());
                    qdaVar2.o(fileDownloadDelete.a());
                    qdaVar2.x(fileDownloadDelete.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                qdaVar2.s(true);
                qda installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    qdaVar2.y(installGameApk.f());
                    qdaVar2.u(installGameApk.b());
                    qdaVar2.o(installGameApk.a());
                    qdaVar2.x(installGameApk.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                qdaVar2.s(true);
                qda launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    qdaVar2.y(launchApk.f());
                    qdaVar2.u(launchApk.b());
                    qdaVar2.o(launchApk.a());
                    qdaVar2.x(launchApk.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                qdaVar2.s(true);
                qda wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    qdaVar2.y(wakeKeyboard.f());
                    qdaVar2.u(wakeKeyboard.b());
                    qdaVar2.o(wakeKeyboard.a());
                    qdaVar2.x(wakeKeyboard.e());
                }
                qdaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                qdaVar2.s(true);
                qda replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    qdaVar2.y(replyPost.f());
                    qdaVar2.u(replyPost.b());
                    qdaVar2.o(replyPost.a());
                    qdaVar2.x(replyPost.e());
                    if (!qdaVar2.h()) {
                        i2 = 0;
                        qdaVar2.n(false);
                        addObserver("replyPostResult", qdaVar2, false);
                        qdaVar2.z(i2);
                    }
                }
                i2 = 0;
                qdaVar2.z(i2);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                qdaVar2.s(true);
                qda nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    qdaVar2.y(nativeNetworkProxy.f());
                    qdaVar2.u(nativeNetworkProxy.b());
                    qdaVar2.o(nativeNetworkProxy.a());
                    qdaVar2.x(nativeNetworkProxy.e());
                    if (!qdaVar2.h()) {
                        i = 0;
                        qdaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", qdaVar2, false);
                        qdaVar2.z(i);
                    }
                }
                i = 0;
                qdaVar2.z(i);
            }
            return qdaVar2;
        }
        return (qda) invokeLL.objValue;
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
    }

    @Override // com.baidu.tieba.oda
    public List<qda> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            qda qdaVar = null;
            if (xi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                qdaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                qdaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                qdaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                qdaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                qdaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                qdaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                qdaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                qdaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                qdaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                qdaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                qdaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                qdaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                qdaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                qdaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                qdaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                qdaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                qdaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                qdaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                qdaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                qdaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                qdaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                qdaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                qdaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                qdaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                qdaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                qdaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                qdaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                qdaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                qdaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                qdaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            }
            if (qdaVar != null) {
                qdaVar.z(0);
            }
            List<pda> list = this.mAsyncCallBackMethodList.get(str);
            if (qdaVar != null && list != null) {
                Iterator<pda> it = list.iterator();
                if (!xi.isEmpty(qdaVar.e())) {
                    while (it.hasNext()) {
                        pda next = it.next();
                        if (next.b().equals(qdaVar.e())) {
                            qda qdaVar2 = new qda();
                            qdaVar2.w(next.a());
                            qdaVar2.y(qdaVar.f());
                            qdaVar2.u(qdaVar.b());
                            qdaVar2.o(qdaVar.a());
                            qdaVar2.A(qdaVar.l());
                            arrayList.add(qdaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        pda next2 = it.next();
                        qda qdaVar3 = new qda();
                        qdaVar3.w(next2.a());
                        qdaVar3.y(qdaVar.f());
                        qdaVar3.u(qdaVar.b());
                        qdaVar3.o(qdaVar.a());
                        qdaVar3.A(qdaVar.l());
                        arrayList.add(qdaVar3);
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
