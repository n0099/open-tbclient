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
import com.baidu.tieba.az9;
import com.baidu.tieba.bz9;
import com.baidu.tieba.dz9;
import com.baidu.tieba.ui;
import com.baidu.tieba.zy9;
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
public class CommonTbJsBridge_Proxy extends zy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.zy9
    public bz9 dispatch(dz9 dz9Var, bz9 bz9Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dz9Var, bz9Var)) == null) {
            bz9 bz9Var2 = bz9Var == null ? new bz9() : bz9Var;
            String b = dz9Var.b();
            JSONObject e = dz9Var.e();
            if (b.equals("account/startLoginModule")) {
                bz9Var2.s(true);
                bz9 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    bz9Var2.y(startLoginModule.f());
                    bz9Var2.u(startLoginModule.b());
                    bz9Var2.o(startLoginModule.a());
                    bz9Var2.x(startLoginModule.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("account/authState")) {
                bz9Var2.s(true);
                bz9 checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    bz9Var2.y(checkAuthState.f());
                    bz9Var2.u(checkAuthState.b());
                    bz9Var2.o(checkAuthState.a());
                    bz9Var2.x(checkAuthState.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("account/commonLogin")) {
                bz9Var2.s(true);
                bz9 startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    bz9Var2.y(startAllLoginModule.f());
                    bz9Var2.u(startAllLoginModule.b());
                    bz9Var2.o(startAllLoginModule.a());
                    bz9Var2.x(startAllLoginModule.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver("commonLogin", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                bz9Var2.s(true);
                bz9 realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    bz9Var2.y(realNameAuth.f());
                    bz9Var2.u(realNameAuth.b());
                    bz9Var2.o(realNameAuth.a());
                    bz9Var2.x(realNameAuth.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver("realNameAuthResult", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                bz9Var2.s(true);
                bz9 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    bz9Var2.y(finishPage.f());
                    bz9Var2.u(finishPage.b());
                    bz9Var2.o(finishPage.a());
                    bz9Var2.x(finishPage.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                bz9Var2.s(true);
                bz9 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    bz9Var2.y(showLowerHairHint.f());
                    bz9Var2.u(showLowerHairHint.b());
                    bz9Var2.o(showLowerHairHint.a());
                    bz9Var2.x(showLowerHairHint.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                bz9Var2.s(true);
                bz9 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    bz9Var2.y(gamePush.f());
                    bz9Var2.u(gamePush.b());
                    bz9Var2.o(gamePush.a());
                    bz9Var2.x(gamePush.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                bz9Var2.s(true);
                bz9 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    bz9Var2.y(handleGamePushStatus.f());
                    bz9Var2.u(handleGamePushStatus.b());
                    bz9Var2.o(handleGamePushStatus.a());
                    bz9Var2.x(handleGamePushStatus.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                bz9Var2.s(true);
                bz9 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    bz9Var2.y(jumpForumRulesEditPage.f());
                    bz9Var2.u(jumpForumRulesEditPage.b());
                    bz9Var2.o(jumpForumRulesEditPage.a());
                    bz9Var2.x(jumpForumRulesEditPage.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                bz9Var2.s(true);
                bz9 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    bz9Var2.y(handleGoToBarDetail.f());
                    bz9Var2.u(handleGoToBarDetail.b());
                    bz9Var2.o(handleGoToBarDetail.a());
                    bz9Var2.x(handleGoToBarDetail.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/saveImage")) {
                bz9Var2.s(true);
                bz9 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    bz9Var2.y(handleSaveImage.f());
                    bz9Var2.u(handleSaveImage.b());
                    bz9Var2.o(handleSaveImage.a());
                    bz9Var2.x(handleSaveImage.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver("saveImageSuccess", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                bz9Var2.s(true);
                bz9 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    bz9Var2.y(orderGameApk.f());
                    bz9Var2.u(orderGameApk.b());
                    bz9Var2.o(orderGameApk.a());
                    bz9Var2.x(orderGameApk.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver("orderGameApkResult", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                bz9Var2.s(true);
                bz9 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    bz9Var2.y(handleGetPhotoAlbum.f());
                    bz9Var2.u(handleGetPhotoAlbum.b());
                    bz9Var2.o(handleGetPhotoAlbum.a());
                    bz9Var2.x(handleGetPhotoAlbum.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver("GetPhotoAlbum", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                bz9Var2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                bz9 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    bz9Var2.y(preheatWeb.f());
                    bz9Var2.u(preheatWeb.b());
                    bz9Var2.o(preheatWeb.a());
                    bz9Var2.x(preheatWeb.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                bz9Var2.s(true);
                bz9 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    bz9Var2.y(openMXDYab.f());
                    bz9Var2.u(openMXDYab.b());
                    bz9Var2.o(openMXDYab.a());
                    bz9Var2.x(openMXDYab.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/portal")) {
                bz9Var2.s(true);
                bz9 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    bz9Var2.y(handlePortal.f());
                    bz9Var2.u(handlePortal.b());
                    bz9Var2.o(handlePortal.a());
                    bz9Var2.x(handlePortal.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                bz9Var2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                bz9 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    bz9Var2.y(selectPhotoAlbum.f());
                    bz9Var2.u(selectPhotoAlbum.b());
                    bz9Var2.o(selectPhotoAlbum.a());
                    bz9Var2.x(selectPhotoAlbum.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver("selectPhotoAlbum", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                bz9Var2.s(true);
                bz9 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                if (operateNotifyDataChanged != null) {
                    bz9Var2.y(operateNotifyDataChanged.f());
                    bz9Var2.u(operateNotifyDataChanged.b());
                    bz9Var2.o(operateNotifyDataChanged.a());
                    bz9Var2.x(operateNotifyDataChanged.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                bz9Var2.s(true);
                bz9 viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    bz9Var2.y(viewPosition.f());
                    bz9Var2.u(viewPosition.b());
                    bz9Var2.o(viewPosition.a());
                    bz9Var2.x(viewPosition.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                bz9Var2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                bz9 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    bz9Var2.y(selectPrivateMsg.f());
                    bz9Var2.u(selectPrivateMsg.b());
                    bz9Var2.o(selectPrivateMsg.a());
                    bz9Var2.x(selectPrivateMsg.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                bz9Var2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                bz9 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    bz9Var2.y(reportUserTheme.f());
                    bz9Var2.u(reportUserTheme.b());
                    bz9Var2.o(reportUserTheme.a());
                    bz9Var2.x(reportUserTheme.e());
                    if (!bz9Var2.h()) {
                        bz9Var2.n(false);
                        addObserver("goToReportThreadPage", bz9Var2, false);
                    }
                }
                bz9Var2.z(0);
            } else if (b.equals("system/playSound")) {
                bz9Var2.s(true);
                bz9 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    bz9Var2.y(playSound.f());
                    bz9Var2.u(playSound.b());
                    bz9Var2.o(playSound.a());
                    bz9Var2.x(playSound.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/playVibrate")) {
                bz9Var2.s(true);
                bz9 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    bz9Var2.y(playVibrate.f());
                    bz9Var2.u(playVibrate.b());
                    bz9Var2.o(playVibrate.a());
                    bz9Var2.x(playVibrate.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                bz9Var2.s(true);
                bz9 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    bz9Var2.y(jumpLoginActivity.f());
                    bz9Var2.u(jumpLoginActivity.b());
                    bz9Var2.o(jumpLoginActivity.a());
                    bz9Var2.x(jumpLoginActivity.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                bz9Var2.s(true);
                bz9 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    bz9Var2.y(startLoadTimeInterval.f());
                    bz9Var2.u(startLoadTimeInterval.b());
                    bz9Var2.o(startLoadTimeInterval.a());
                    bz9Var2.x(startLoadTimeInterval.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("device/getZid")) {
                bz9Var2.s(true);
                bz9 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    bz9Var2.y(zid.f());
                    bz9Var2.u(zid.b());
                    bz9Var2.o(zid.a());
                    bz9Var2.x(zid.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("device/getHdid")) {
                bz9Var2.s(true);
                bz9 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    bz9Var2.y(hdid.f());
                    bz9Var2.u(hdid.b());
                    bz9Var2.o(hdid.a());
                    bz9Var2.x(hdid.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                bz9Var2.s(true);
                bz9 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    bz9Var2.y(shareInfo.f());
                    bz9Var2.u(shareInfo.b());
                    bz9Var2.o(shareInfo.a());
                    bz9Var2.x(shareInfo.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("share/share")) {
                bz9Var2.s(true);
                bz9 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    bz9Var2.y(share.f());
                    bz9Var2.u(share.b());
                    bz9Var2.o(share.a());
                    bz9Var2.x(share.e());
                    if (!bz9Var2.h()) {
                        i6 = 0;
                        bz9Var2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, bz9Var2, false);
                        bz9Var2.z(i6);
                    }
                }
                i6 = 0;
                bz9Var2.z(i6);
            } else if (b.equals("clipper/getClipperInformation")) {
                bz9Var2.s(true);
                bz9 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    bz9Var2.y(clipperInformation.f());
                    bz9Var2.u(clipperInformation.b());
                    bz9Var2.o(clipperInformation.a());
                    bz9Var2.x(clipperInformation.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                bz9Var2.s(true);
                bz9 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    bz9Var2.y(clipperInformation2.f());
                    bz9Var2.u(clipperInformation2.b());
                    bz9Var2.o(clipperInformation2.a());
                    bz9Var2.x(clipperInformation2.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                bz9Var2.s(true);
                bz9 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    bz9Var2.y(goToEditPost.f());
                    bz9Var2.u(goToEditPost.b());
                    bz9Var2.o(goToEditPost.a());
                    bz9Var2.x(goToEditPost.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                bz9Var2.s(true);
                bz9 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    bz9Var2.y(updateSearchForumInfo.f());
                    bz9Var2.u(updateSearchForumInfo.b());
                    bz9Var2.o(updateSearchForumInfo.a());
                    bz9Var2.x(updateSearchForumInfo.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                bz9Var2.s(true);
                bz9 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    bz9Var2.y(personlizedSwitchChange.f());
                    bz9Var2.u(personlizedSwitchChange.b());
                    bz9Var2.o(personlizedSwitchChange.a());
                    bz9Var2.x(personlizedSwitchChange.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                bz9Var2.s(true);
                bz9 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    bz9Var2.y(updateTailStyle.f());
                    bz9Var2.u(updateTailStyle.b());
                    bz9Var2.o(updateTailStyle.a());
                    bz9Var2.x(updateTailStyle.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                bz9Var2.s(true);
                bz9 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    bz9Var2.y(goToVideoImmersivePage.f());
                    bz9Var2.u(goToVideoImmersivePage.b());
                    bz9Var2.o(goToVideoImmersivePage.a());
                    bz9Var2.x(goToVideoImmersivePage.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                bz9Var2.s(true);
                bz9 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    bz9Var2.y(jumpToVideo.f());
                    bz9Var2.u(jumpToVideo.b());
                    bz9Var2.o(jumpToVideo.a());
                    bz9Var2.x(jumpToVideo.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                bz9Var2.s(true);
                bz9 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    bz9Var2.y(closeNativeMask.f());
                    bz9Var2.u(closeNativeMask.b());
                    bz9Var2.o(closeNativeMask.a());
                    bz9Var2.x(closeNativeMask.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                bz9Var2.s(true);
                bz9 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    bz9Var2.y(oneKeyDeletion.f());
                    bz9Var2.u(oneKeyDeletion.b());
                    bz9Var2.o(oneKeyDeletion.a());
                    bz9Var2.x(oneKeyDeletion.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                bz9Var2.s(true);
                bz9 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    bz9Var2.y(checkAppInstall.f());
                    bz9Var2.u(checkAppInstall.b());
                    bz9Var2.o(checkAppInstall.a());
                    bz9Var2.x(checkAppInstall.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                bz9Var2.s(true);
                bz9 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    bz9Var2.y(disableBack.f());
                    bz9Var2.u(disableBack.b());
                    bz9Var2.o(disableBack.a());
                    bz9Var2.x(disableBack.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/startApp")) {
                bz9Var2.s(true);
                bz9 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    bz9Var2.y(startApp.f());
                    bz9Var2.u(startApp.b());
                    bz9Var2.o(startApp.a());
                    bz9Var2.x(startApp.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                bz9Var2.s(true);
                bz9 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    bz9Var2.y(hasNotificationPermission.f());
                    bz9Var2.u(hasNotificationPermission.b());
                    bz9Var2.o(hasNotificationPermission.a());
                    bz9Var2.x(hasNotificationPermission.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                bz9Var2.s(true);
                bz9 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    bz9Var2.y(goToNotificationSetting.f());
                    bz9Var2.u(goToNotificationSetting.b());
                    bz9Var2.o(goToNotificationSetting.a());
                    bz9Var2.x(goToNotificationSetting.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                bz9Var2.s(true);
                bz9 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    bz9Var2.y(startDownloadGameApk.f());
                    bz9Var2.u(startDownloadGameApk.b());
                    bz9Var2.o(startDownloadGameApk.a());
                    bz9Var2.x(startDownloadGameApk.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                bz9Var2.s(true);
                bz9 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    bz9Var2.y(checkInstallGameApk.f());
                    bz9Var2.u(checkInstallGameApk.b());
                    bz9Var2.o(checkInstallGameApk.a());
                    bz9Var2.x(checkInstallGameApk.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                bz9Var2.s(true);
                bz9 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    bz9Var2.y(startDownloadCss.f());
                    bz9Var2.u(startDownloadCss.b());
                    bz9Var2.o(startDownloadCss.a());
                    bz9Var2.x(startDownloadCss.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                bz9Var2.s(true);
                bz9 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    bz9Var2.y(disableGoBack.f());
                    bz9Var2.u(disableGoBack.b());
                    bz9Var2.o(disableGoBack.a());
                    bz9Var2.x(disableGoBack.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                bz9Var2.s(true);
                bz9 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    bz9Var2.y(supplementInfo.f());
                    bz9Var2.u(supplementInfo.b());
                    bz9Var2.o(supplementInfo.a());
                    bz9Var2.x(supplementInfo.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                bz9Var2.s(true);
                bz9 deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    bz9Var2.y(deviceGyroscopeParams.f());
                    bz9Var2.u(deviceGyroscopeParams.b());
                    bz9Var2.o(deviceGyroscopeParams.a());
                    bz9Var2.x(deviceGyroscopeParams.e());
                    if (!bz9Var2.h()) {
                        i5 = 0;
                        bz9Var2.n(false);
                        addObserver("deviceMotion", bz9Var2, false);
                        bz9Var2.z(i5);
                    }
                }
                i5 = 0;
                bz9Var2.z(i5);
            } else if (b.equals("device/deviceRefreshRate")) {
                bz9Var2.s(true);
                bz9 deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    bz9Var2.y(deviceRefreshRateParams.f());
                    bz9Var2.u(deviceRefreshRateParams.b());
                    bz9Var2.o(deviceRefreshRateParams.a());
                    bz9Var2.x(deviceRefreshRateParams.e());
                    if (!bz9Var2.h()) {
                        i4 = 0;
                        bz9Var2.n(false);
                        addObserver("deviceRefreshRate", bz9Var2, false);
                        bz9Var2.z(i4);
                    }
                }
                i4 = 0;
                bz9Var2.z(i4);
            } else if (b.equals("device/getDeviceInfo")) {
                bz9Var2.s(true);
                bz9 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    bz9Var2.y(deviceInfo.f());
                    bz9Var2.u(deviceInfo.b());
                    bz9Var2.o(deviceInfo.a());
                    bz9Var2.x(deviceInfo.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("activity/completeTask")) {
                bz9Var2.s(true);
                bz9 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    bz9Var2.y(sendCompleteTaskReqMsg.f());
                    bz9Var2.u(sendCompleteTaskReqMsg.b());
                    bz9Var2.o(sendCompleteTaskReqMsg.a());
                    bz9Var2.x(sendCompleteTaskReqMsg.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                bz9Var2.s(true);
                bz9 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    bz9Var2.y(showTipToast.f());
                    bz9Var2.u(showTipToast.b());
                    bz9Var2.o(showTipToast.a());
                    bz9Var2.x(showTipToast.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("toast/getModalData")) {
                bz9Var2.s(true);
                bz9 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    bz9Var2.y(getModalData.f());
                    bz9Var2.u(getModalData.b());
                    bz9Var2.o(getModalData.a());
                    bz9Var2.x(getModalData.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                bz9Var2.s(true);
                bz9 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    bz9Var2.y(openThirdPartApp.f());
                    bz9Var2.u(openThirdPartApp.b());
                    bz9Var2.o(openThirdPartApp.a());
                    bz9Var2.x(openThirdPartApp.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                bz9Var2.s(true);
                bz9 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    bz9Var2.y(jumpToHtmlPage.f());
                    bz9Var2.u(jumpToHtmlPage.b());
                    bz9Var2.o(jumpToHtmlPage.a());
                    bz9Var2.x(jumpToHtmlPage.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                bz9Var2.s(true);
                bz9 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    bz9Var2.y(offlineUserInfo.f());
                    bz9Var2.u(offlineUserInfo.b());
                    bz9Var2.o(offlineUserInfo.a());
                    bz9Var2.x(offlineUserInfo.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                bz9Var2.s(true);
                bz9 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    bz9Var2.y(deleteOfflineBundle.f());
                    bz9Var2.u(deleteOfflineBundle.b());
                    bz9Var2.o(deleteOfflineBundle.a());
                    bz9Var2.x(deleteOfflineBundle.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                bz9Var2.s(true);
                bz9 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    bz9Var2.y(updateOfflineBundle.f());
                    bz9Var2.u(updateOfflineBundle.b());
                    bz9Var2.o(updateOfflineBundle.a());
                    bz9Var2.x(updateOfflineBundle.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                bz9Var2.s(true);
                bz9 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    bz9Var2.y(switchOfflineInterface.f());
                    bz9Var2.u(switchOfflineInterface.b());
                    bz9Var2.o(switchOfflineInterface.a());
                    bz9Var2.x(switchOfflineInterface.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                bz9Var2.s(true);
                bz9 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    bz9Var2.y(switchOfflineBundleStatus.f());
                    bz9Var2.u(switchOfflineBundleStatus.b());
                    bz9Var2.o(switchOfflineBundleStatus.a());
                    bz9Var2.x(switchOfflineBundleStatus.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                bz9Var2.s(true);
                bz9 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    bz9Var2.y(finishTestAnswer.f());
                    bz9Var2.u(finishTestAnswer.b());
                    bz9Var2.o(finishTestAnswer.a());
                    bz9Var2.x(finishTestAnswer.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                bz9Var2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                bz9 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    bz9Var2.y(switchUrlHost.f());
                    bz9Var2.u(switchUrlHost.b());
                    bz9Var2.o(switchUrlHost.a());
                    bz9Var2.x(switchUrlHost.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                bz9Var2.s(true);
                bz9 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    bz9Var2.y(appStorage.f());
                    bz9Var2.u(appStorage.b());
                    bz9Var2.o(appStorage.a());
                    bz9Var2.x(appStorage.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                bz9Var2.s(true);
                bz9 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    bz9Var2.y(putAppStorage.f());
                    bz9Var2.u(putAppStorage.b());
                    bz9Var2.o(putAppStorage.a());
                    bz9Var2.x(putAppStorage.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                bz9Var2.s(true);
                bz9 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    bz9Var2.y(historyForumData.f());
                    bz9Var2.u(historyForumData.b());
                    bz9Var2.o(historyForumData.a());
                    bz9Var2.x(historyForumData.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                bz9Var2.s(true);
                bz9 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    bz9Var2.y(worldCupRaiseSuccess.f());
                    bz9Var2.u(worldCupRaiseSuccess.b());
                    bz9Var2.o(worldCupRaiseSuccess.a());
                    bz9Var2.x(worldCupRaiseSuccess.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                bz9Var2.s(true);
                bz9 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    bz9Var2.y(alipayUserId.f());
                    bz9Var2.u(alipayUserId.b());
                    bz9Var2.o(alipayUserId.a());
                    bz9Var2.x(alipayUserId.e());
                    if (!bz9Var2.h()) {
                        i3 = 0;
                        bz9Var2.n(false);
                        addObserver("aliAuthResult", bz9Var2, false);
                        bz9Var2.z(i3);
                    }
                }
                i3 = 0;
                bz9Var2.z(i3);
            } else if (b.equals("system/getFileDownloadStatus")) {
                bz9Var2.s(true);
                bz9 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    bz9Var2.y(fileDownloadStatus.f());
                    bz9Var2.u(fileDownloadStatus.b());
                    bz9Var2.o(fileDownloadStatus.a());
                    bz9Var2.x(fileDownloadStatus.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                bz9Var2.s(true);
                bz9 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    bz9Var2.y(fileDownloadProgress.f());
                    bz9Var2.u(fileDownloadProgress.b());
                    bz9Var2.o(fileDownloadProgress.a());
                    bz9Var2.x(fileDownloadProgress.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                bz9Var2.s(true);
                bz9 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    bz9Var2.y(fileDownloadPause.f());
                    bz9Var2.u(fileDownloadPause.b());
                    bz9Var2.o(fileDownloadPause.a());
                    bz9Var2.x(fileDownloadPause.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                bz9Var2.s(true);
                bz9 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    bz9Var2.y(fileDownloadDelete.f());
                    bz9Var2.u(fileDownloadDelete.b());
                    bz9Var2.o(fileDownloadDelete.a());
                    bz9Var2.x(fileDownloadDelete.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/installGameApk")) {
                bz9Var2.s(true);
                bz9 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    bz9Var2.y(installGameApk.f());
                    bz9Var2.u(installGameApk.b());
                    bz9Var2.o(installGameApk.a());
                    bz9Var2.x(installGameApk.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/launchApk")) {
                bz9Var2.s(true);
                bz9 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    bz9Var2.y(launchApk.f());
                    bz9Var2.u(launchApk.b());
                    bz9Var2.o(launchApk.a());
                    bz9Var2.x(launchApk.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                bz9Var2.s(true);
                bz9 wakeKeyboard = this.mJsBridge.wakeKeyboard();
                if (wakeKeyboard != null) {
                    bz9Var2.y(wakeKeyboard.f());
                    bz9Var2.u(wakeKeyboard.b());
                    bz9Var2.o(wakeKeyboard.a());
                    bz9Var2.x(wakeKeyboard.e());
                }
                bz9Var2.z(0);
            } else if (b.equals("router/replyPost")) {
                bz9Var2.s(true);
                bz9 replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    bz9Var2.y(replyPost.f());
                    bz9Var2.u(replyPost.b());
                    bz9Var2.o(replyPost.a());
                    bz9Var2.x(replyPost.e());
                    if (!bz9Var2.h()) {
                        i2 = 0;
                        bz9Var2.n(false);
                        addObserver("replyPostResult", bz9Var2, false);
                        bz9Var2.z(i2);
                    }
                }
                i2 = 0;
                bz9Var2.z(i2);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                bz9Var2.s(true);
                bz9 nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    bz9Var2.y(nativeNetworkProxy.f());
                    bz9Var2.u(nativeNetworkProxy.b());
                    bz9Var2.o(nativeNetworkProxy.a());
                    bz9Var2.x(nativeNetworkProxy.e());
                    if (!bz9Var2.h()) {
                        i = 0;
                        bz9Var2.n(false);
                        addObserver("nativeNetworkProxyResult", bz9Var2, false);
                        bz9Var2.z(i);
                    }
                }
                i = 0;
                bz9Var2.z(i);
            }
            return bz9Var2;
        }
        return (bz9) invokeLL.objValue;
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

    @Override // com.baidu.tieba.zy9
    public List<bz9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            bz9 bz9Var = null;
            if (ui.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                bz9Var = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                bz9Var = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                bz9Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                bz9Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                bz9Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                bz9Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                bz9Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                bz9Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                bz9Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                bz9Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                bz9Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                bz9Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                bz9Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                bz9Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                bz9Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                bz9Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                bz9Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                bz9Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                bz9Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                bz9Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                bz9Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                bz9Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                bz9Var = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                bz9Var = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                bz9Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                bz9Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                bz9Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                bz9Var = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                bz9Var = this.mJsBridge.nativeNetworkProxy(hashMap);
            }
            if (bz9Var != null) {
                bz9Var.z(0);
            }
            List<az9> list = this.mAsyncCallBackMethodList.get(str);
            if (bz9Var != null && list != null) {
                Iterator<az9> it = list.iterator();
                if (!ui.isEmpty(bz9Var.e())) {
                    while (it.hasNext()) {
                        az9 next = it.next();
                        if (next.b().equals(bz9Var.e())) {
                            bz9 bz9Var2 = new bz9();
                            bz9Var2.w(next.a());
                            bz9Var2.y(bz9Var.f());
                            bz9Var2.u(bz9Var.b());
                            bz9Var2.o(bz9Var.a());
                            bz9Var2.A(bz9Var.l());
                            arrayList.add(bz9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        az9 next2 = it.next();
                        bz9 bz9Var3 = new bz9();
                        bz9Var3.w(next2.a());
                        bz9Var3.y(bz9Var.f());
                        bz9Var3.u(bz9Var.b());
                        bz9Var3.o(bz9Var.a());
                        bz9Var3.A(bz9Var.l());
                        arrayList.add(bz9Var3);
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
