package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.ui;
import com.baidu.tieba.uy9;
import com.baidu.tieba.vy9;
import com.baidu.tieba.wy9;
import com.baidu.tieba.yy9;
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
public class SingleQuickWebViewBridge_Proxy extends uy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.uy9
    public wy9 dispatch(yy9 yy9Var, wy9 wy9Var) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yy9Var, wy9Var)) == null) {
            wy9 wy9Var2 = wy9Var == null ? new wy9() : wy9Var;
            String b = yy9Var.b();
            JSONObject e = yy9Var.e();
            if (b.equals("account/startLoginModule")) {
                wy9Var2.s(true);
                wy9 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    wy9Var2.y(startLoginModule.f());
                    wy9Var2.u(startLoginModule.b());
                    wy9Var2.o(startLoginModule.a());
                    wy9Var2.x(startLoginModule.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("account/commonLogin")) {
                wy9Var2.s(true);
                wy9 startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    wy9Var2.y(startAllLoginModule.f());
                    wy9Var2.u(startAllLoginModule.b());
                    wy9Var2.o(startAllLoginModule.a());
                    wy9Var2.x(startAllLoginModule.e());
                    if (!wy9Var2.h()) {
                        wy9Var2.n(false);
                        addObserver("commonLogin", wy9Var2, false);
                    }
                }
                wy9Var2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                wy9Var2.s(true);
                wy9 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    wy9Var2.y(finishPage.f());
                    wy9Var2.u(finishPage.b());
                    wy9Var2.o(finishPage.a());
                    wy9Var2.x(finishPage.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                wy9Var2.s(true);
                wy9 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    wy9Var2.y(showLowerHairHint.f());
                    wy9Var2.u(showLowerHairHint.b());
                    wy9Var2.o(showLowerHairHint.a());
                    wy9Var2.x(showLowerHairHint.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                wy9Var2.s(true);
                wy9 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    wy9Var2.y(gamePush.f());
                    wy9Var2.u(gamePush.b());
                    wy9Var2.o(gamePush.a());
                    wy9Var2.x(gamePush.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                wy9Var2.s(true);
                wy9 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    wy9Var2.y(handleGamePushStatus.f());
                    wy9Var2.u(handleGamePushStatus.b());
                    wy9Var2.o(handleGamePushStatus.a());
                    wy9Var2.x(handleGamePushStatus.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                wy9Var2.s(true);
                wy9 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    wy9Var2.y(jumpForumRulesEditPage.f());
                    wy9Var2.u(jumpForumRulesEditPage.b());
                    wy9Var2.o(jumpForumRulesEditPage.a());
                    wy9Var2.x(jumpForumRulesEditPage.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                wy9Var2.s(true);
                wy9 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    wy9Var2.y(handleGoToBarDetail.f());
                    wy9Var2.u(handleGoToBarDetail.b());
                    wy9Var2.o(handleGoToBarDetail.a());
                    wy9Var2.x(handleGoToBarDetail.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/saveImage")) {
                wy9Var2.s(true);
                wy9 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    wy9Var2.y(handleSaveImage.f());
                    wy9Var2.u(handleSaveImage.b());
                    wy9Var2.o(handleSaveImage.a());
                    wy9Var2.x(handleSaveImage.e());
                    if (!wy9Var2.h()) {
                        wy9Var2.n(false);
                        addObserver("saveImageSuccess", wy9Var2, false);
                    }
                }
                wy9Var2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                wy9Var2.s(true);
                wy9 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    wy9Var2.y(orderGameApk.f());
                    wy9Var2.u(orderGameApk.b());
                    wy9Var2.o(orderGameApk.a());
                    wy9Var2.x(orderGameApk.e());
                    if (!wy9Var2.h()) {
                        wy9Var2.n(false);
                        addObserver("orderGameApkResult", wy9Var2, false);
                    }
                }
                wy9Var2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                wy9Var2.s(true);
                wy9 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    wy9Var2.y(handleGetPhotoAlbum.f());
                    wy9Var2.u(handleGetPhotoAlbum.b());
                    wy9Var2.o(handleGetPhotoAlbum.a());
                    wy9Var2.x(handleGetPhotoAlbum.e());
                    if (!wy9Var2.h()) {
                        wy9Var2.n(false);
                        addObserver("GetPhotoAlbum", wy9Var2, false);
                    }
                }
                wy9Var2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                wy9Var2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                wy9 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    wy9Var2.y(preheatWeb.f());
                    wy9Var2.u(preheatWeb.b());
                    wy9Var2.o(preheatWeb.a());
                    wy9Var2.x(preheatWeb.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                wy9Var2.s(true);
                wy9 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    wy9Var2.y(openMXDYab.f());
                    wy9Var2.u(openMXDYab.b());
                    wy9Var2.o(openMXDYab.a());
                    wy9Var2.x(openMXDYab.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/portal")) {
                wy9Var2.s(true);
                wy9 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    wy9Var2.y(handlePortal.f());
                    wy9Var2.u(handlePortal.b());
                    wy9Var2.o(handlePortal.a());
                    wy9Var2.x(handlePortal.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                wy9Var2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                wy9 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    wy9Var2.y(selectPhotoAlbum.f());
                    wy9Var2.u(selectPhotoAlbum.b());
                    wy9Var2.o(selectPhotoAlbum.a());
                    wy9Var2.x(selectPhotoAlbum.e());
                    if (!wy9Var2.h()) {
                        wy9Var2.n(false);
                        addObserver("selectPhotoAlbum", wy9Var2, false);
                    }
                }
                wy9Var2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                wy9Var2.s(true);
                wy9 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                if (operateNotifyDataChanged != null) {
                    wy9Var2.y(operateNotifyDataChanged.f());
                    wy9Var2.u(operateNotifyDataChanged.b());
                    wy9Var2.o(operateNotifyDataChanged.a());
                    wy9Var2.x(operateNotifyDataChanged.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                wy9Var2.s(true);
                wy9 viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    wy9Var2.y(viewPosition.f());
                    wy9Var2.u(viewPosition.b());
                    wy9Var2.o(viewPosition.a());
                    wy9Var2.x(viewPosition.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                wy9Var2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                wy9 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    wy9Var2.y(selectPrivateMsg.f());
                    wy9Var2.u(selectPrivateMsg.b());
                    wy9Var2.o(selectPrivateMsg.a());
                    wy9Var2.x(selectPrivateMsg.e());
                    if (!wy9Var2.h()) {
                        i9 = 0;
                        wy9Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", wy9Var2, false);
                        wy9Var2.z(i9);
                    }
                }
                i9 = 0;
                wy9Var2.z(i9);
            } else if (b.equals("router/goToReportThreadPage")) {
                wy9Var2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                wy9 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    wy9Var2.y(reportUserTheme.f());
                    wy9Var2.u(reportUserTheme.b());
                    wy9Var2.o(reportUserTheme.a());
                    wy9Var2.x(reportUserTheme.e());
                    if (!wy9Var2.h()) {
                        i8 = 0;
                        wy9Var2.n(false);
                        addObserver("goToReportThreadPage", wy9Var2, false);
                        wy9Var2.z(i8);
                    }
                }
                i8 = 0;
                wy9Var2.z(i8);
            } else if (b.equals("system/playSound")) {
                wy9Var2.s(true);
                wy9 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    wy9Var2.y(playSound.f());
                    wy9Var2.u(playSound.b());
                    wy9Var2.o(playSound.a());
                    wy9Var2.x(playSound.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/playVibrate")) {
                wy9Var2.s(true);
                wy9 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    wy9Var2.y(playVibrate.f());
                    wy9Var2.u(playVibrate.b());
                    wy9Var2.o(playVibrate.a());
                    wy9Var2.x(playVibrate.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                wy9Var2.s(true);
                wy9 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    wy9Var2.y(jumpLoginActivity.f());
                    wy9Var2.u(jumpLoginActivity.b());
                    wy9Var2.o(jumpLoginActivity.a());
                    wy9Var2.x(jumpLoginActivity.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                wy9Var2.s(true);
                wy9 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    wy9Var2.y(startLoadTimeInterval.f());
                    wy9Var2.u(startLoadTimeInterval.b());
                    wy9Var2.o(startLoadTimeInterval.a());
                    wy9Var2.x(startLoadTimeInterval.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("device/getZid")) {
                wy9Var2.s(true);
                wy9 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    wy9Var2.y(zid.f());
                    wy9Var2.u(zid.b());
                    wy9Var2.o(zid.a());
                    wy9Var2.x(zid.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("device/getHdid")) {
                wy9Var2.s(true);
                wy9 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    wy9Var2.y(hdid.f());
                    wy9Var2.u(hdid.b());
                    wy9Var2.o(hdid.a());
                    wy9Var2.x(hdid.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                wy9Var2.s(true);
                wy9 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    wy9Var2.y(shareInfo.f());
                    wy9Var2.u(shareInfo.b());
                    wy9Var2.o(shareInfo.a());
                    wy9Var2.x(shareInfo.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("share/share")) {
                wy9Var2.s(true);
                wy9 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    wy9Var2.y(share.f());
                    wy9Var2.u(share.b());
                    wy9Var2.o(share.a());
                    wy9Var2.x(share.e());
                    if (!wy9Var2.h()) {
                        i7 = 0;
                        wy9Var2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, wy9Var2, false);
                        wy9Var2.z(i7);
                    }
                }
                i7 = 0;
                wy9Var2.z(i7);
            } else if (b.equals("clipper/getClipperInformation")) {
                wy9Var2.s(true);
                wy9 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    wy9Var2.y(clipperInformation.f());
                    wy9Var2.u(clipperInformation.b());
                    wy9Var2.o(clipperInformation.a());
                    wy9Var2.x(clipperInformation.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                wy9Var2.s(true);
                wy9 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    wy9Var2.y(clipperInformation2.f());
                    wy9Var2.u(clipperInformation2.b());
                    wy9Var2.o(clipperInformation2.a());
                    wy9Var2.x(clipperInformation2.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                wy9Var2.s(true);
                wy9 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    wy9Var2.y(goToEditPost.f());
                    wy9Var2.u(goToEditPost.b());
                    wy9Var2.o(goToEditPost.a());
                    wy9Var2.x(goToEditPost.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                wy9Var2.s(true);
                wy9 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    wy9Var2.y(updateSearchForumInfo.f());
                    wy9Var2.u(updateSearchForumInfo.b());
                    wy9Var2.o(updateSearchForumInfo.a());
                    wy9Var2.x(updateSearchForumInfo.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                wy9Var2.s(true);
                wy9 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    wy9Var2.y(personlizedSwitchChange.f());
                    wy9Var2.u(personlizedSwitchChange.b());
                    wy9Var2.o(personlizedSwitchChange.a());
                    wy9Var2.x(personlizedSwitchChange.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                wy9Var2.s(true);
                wy9 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    wy9Var2.y(updateTailStyle.f());
                    wy9Var2.u(updateTailStyle.b());
                    wy9Var2.o(updateTailStyle.a());
                    wy9Var2.x(updateTailStyle.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                wy9Var2.s(true);
                wy9 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    wy9Var2.y(goToVideoImmersivePage.f());
                    wy9Var2.u(goToVideoImmersivePage.b());
                    wy9Var2.o(goToVideoImmersivePage.a());
                    wy9Var2.x(goToVideoImmersivePage.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                wy9Var2.s(true);
                wy9 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    wy9Var2.y(jumpToVideo.f());
                    wy9Var2.u(jumpToVideo.b());
                    wy9Var2.o(jumpToVideo.a());
                    wy9Var2.x(jumpToVideo.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                wy9Var2.s(true);
                wy9 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    wy9Var2.y(closeNativeMask.f());
                    wy9Var2.u(closeNativeMask.b());
                    wy9Var2.o(closeNativeMask.a());
                    wy9Var2.x(closeNativeMask.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                wy9Var2.s(true);
                wy9 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    wy9Var2.y(oneKeyDeletion.f());
                    wy9Var2.u(oneKeyDeletion.b());
                    wy9Var2.o(oneKeyDeletion.a());
                    wy9Var2.x(oneKeyDeletion.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                wy9Var2.s(true);
                wy9 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    wy9Var2.y(checkAppInstall.f());
                    wy9Var2.u(checkAppInstall.b());
                    wy9Var2.o(checkAppInstall.a());
                    wy9Var2.x(checkAppInstall.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                wy9Var2.s(true);
                wy9 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    wy9Var2.y(disableBack.f());
                    wy9Var2.u(disableBack.b());
                    wy9Var2.o(disableBack.a());
                    wy9Var2.x(disableBack.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/startApp")) {
                wy9Var2.s(true);
                wy9 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    wy9Var2.y(startApp.f());
                    wy9Var2.u(startApp.b());
                    wy9Var2.o(startApp.a());
                    wy9Var2.x(startApp.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                wy9Var2.s(true);
                wy9 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    wy9Var2.y(hasNotificationPermission.f());
                    wy9Var2.u(hasNotificationPermission.b());
                    wy9Var2.o(hasNotificationPermission.a());
                    wy9Var2.x(hasNotificationPermission.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                wy9Var2.s(true);
                wy9 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    wy9Var2.y(goToNotificationSetting.f());
                    wy9Var2.u(goToNotificationSetting.b());
                    wy9Var2.o(goToNotificationSetting.a());
                    wy9Var2.x(goToNotificationSetting.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                wy9Var2.s(true);
                wy9 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    wy9Var2.y(startDownloadGameApk.f());
                    wy9Var2.u(startDownloadGameApk.b());
                    wy9Var2.o(startDownloadGameApk.a());
                    wy9Var2.x(startDownloadGameApk.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                wy9Var2.s(true);
                wy9 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    wy9Var2.y(checkInstallGameApk.f());
                    wy9Var2.u(checkInstallGameApk.b());
                    wy9Var2.o(checkInstallGameApk.a());
                    wy9Var2.x(checkInstallGameApk.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                wy9Var2.s(true);
                wy9 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    wy9Var2.y(startDownloadCss.f());
                    wy9Var2.u(startDownloadCss.b());
                    wy9Var2.o(startDownloadCss.a());
                    wy9Var2.x(startDownloadCss.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                wy9Var2.s(true);
                wy9 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    wy9Var2.y(disableGoBack.f());
                    wy9Var2.u(disableGoBack.b());
                    wy9Var2.o(disableGoBack.a());
                    wy9Var2.x(disableGoBack.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                wy9Var2.s(true);
                wy9 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    wy9Var2.y(supplementInfo.f());
                    wy9Var2.u(supplementInfo.b());
                    wy9Var2.o(supplementInfo.a());
                    wy9Var2.x(supplementInfo.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                wy9Var2.s(true);
                wy9 deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    wy9Var2.y(deviceGyroscopeParams.f());
                    wy9Var2.u(deviceGyroscopeParams.b());
                    wy9Var2.o(deviceGyroscopeParams.a());
                    wy9Var2.x(deviceGyroscopeParams.e());
                    if (!wy9Var2.h()) {
                        i6 = 0;
                        wy9Var2.n(false);
                        addObserver("deviceMotion", wy9Var2, false);
                        wy9Var2.z(i6);
                    }
                }
                i6 = 0;
                wy9Var2.z(i6);
            } else if (b.equals("device/deviceRefreshRate")) {
                wy9Var2.s(true);
                wy9 deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    wy9Var2.y(deviceRefreshRateParams.f());
                    wy9Var2.u(deviceRefreshRateParams.b());
                    wy9Var2.o(deviceRefreshRateParams.a());
                    wy9Var2.x(deviceRefreshRateParams.e());
                    if (!wy9Var2.h()) {
                        i5 = 0;
                        wy9Var2.n(false);
                        addObserver("deviceRefreshRate", wy9Var2, false);
                        wy9Var2.z(i5);
                    }
                }
                i5 = 0;
                wy9Var2.z(i5);
            } else if (b.equals("device/getDeviceInfo")) {
                wy9Var2.s(true);
                wy9 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    wy9Var2.y(deviceInfo.f());
                    wy9Var2.u(deviceInfo.b());
                    wy9Var2.o(deviceInfo.a());
                    wy9Var2.x(deviceInfo.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("activity/completeTask")) {
                wy9Var2.s(true);
                wy9 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    wy9Var2.y(sendCompleteTaskReqMsg.f());
                    wy9Var2.u(sendCompleteTaskReqMsg.b());
                    wy9Var2.o(sendCompleteTaskReqMsg.a());
                    wy9Var2.x(sendCompleteTaskReqMsg.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                wy9Var2.s(true);
                wy9 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    wy9Var2.y(showTipToast.f());
                    wy9Var2.u(showTipToast.b());
                    wy9Var2.o(showTipToast.a());
                    wy9Var2.x(showTipToast.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("toast/getModalData")) {
                wy9Var2.s(true);
                wy9 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    wy9Var2.y(getModalData.f());
                    wy9Var2.u(getModalData.b());
                    wy9Var2.o(getModalData.a());
                    wy9Var2.x(getModalData.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                wy9Var2.s(true);
                wy9 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    wy9Var2.y(openThirdPartApp.f());
                    wy9Var2.u(openThirdPartApp.b());
                    wy9Var2.o(openThirdPartApp.a());
                    wy9Var2.x(openThirdPartApp.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                wy9Var2.s(true);
                wy9 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    wy9Var2.y(jumpToHtmlPage.f());
                    wy9Var2.u(jumpToHtmlPage.b());
                    wy9Var2.o(jumpToHtmlPage.a());
                    wy9Var2.x(jumpToHtmlPage.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                wy9Var2.s(true);
                wy9 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    wy9Var2.y(offlineUserInfo.f());
                    wy9Var2.u(offlineUserInfo.b());
                    wy9Var2.o(offlineUserInfo.a());
                    wy9Var2.x(offlineUserInfo.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                wy9Var2.s(true);
                wy9 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    wy9Var2.y(deleteOfflineBundle.f());
                    wy9Var2.u(deleteOfflineBundle.b());
                    wy9Var2.o(deleteOfflineBundle.a());
                    wy9Var2.x(deleteOfflineBundle.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                wy9Var2.s(true);
                wy9 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    wy9Var2.y(updateOfflineBundle.f());
                    wy9Var2.u(updateOfflineBundle.b());
                    wy9Var2.o(updateOfflineBundle.a());
                    wy9Var2.x(updateOfflineBundle.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                wy9Var2.s(true);
                wy9 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    wy9Var2.y(switchOfflineInterface.f());
                    wy9Var2.u(switchOfflineInterface.b());
                    wy9Var2.o(switchOfflineInterface.a());
                    wy9Var2.x(switchOfflineInterface.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                wy9Var2.s(true);
                wy9 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    wy9Var2.y(switchOfflineBundleStatus.f());
                    wy9Var2.u(switchOfflineBundleStatus.b());
                    wy9Var2.o(switchOfflineBundleStatus.a());
                    wy9Var2.x(switchOfflineBundleStatus.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                wy9Var2.s(true);
                wy9 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    wy9Var2.y(finishTestAnswer.f());
                    wy9Var2.u(finishTestAnswer.b());
                    wy9Var2.o(finishTestAnswer.a());
                    wy9Var2.x(finishTestAnswer.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                wy9Var2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                wy9 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    wy9Var2.y(switchUrlHost.f());
                    wy9Var2.u(switchUrlHost.b());
                    wy9Var2.o(switchUrlHost.a());
                    wy9Var2.x(switchUrlHost.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                wy9Var2.s(true);
                wy9 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    wy9Var2.y(appStorage.f());
                    wy9Var2.u(appStorage.b());
                    wy9Var2.o(appStorage.a());
                    wy9Var2.x(appStorage.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                wy9Var2.s(true);
                wy9 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    wy9Var2.y(putAppStorage.f());
                    wy9Var2.u(putAppStorage.b());
                    wy9Var2.o(putAppStorage.a());
                    wy9Var2.x(putAppStorage.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                wy9Var2.s(true);
                wy9 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    wy9Var2.y(historyForumData.f());
                    wy9Var2.u(historyForumData.b());
                    wy9Var2.o(historyForumData.a());
                    wy9Var2.x(historyForumData.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                wy9Var2.s(true);
                wy9 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    wy9Var2.y(worldCupRaiseSuccess.f());
                    wy9Var2.u(worldCupRaiseSuccess.b());
                    wy9Var2.o(worldCupRaiseSuccess.a());
                    wy9Var2.x(worldCupRaiseSuccess.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                wy9Var2.s(true);
                wy9 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    wy9Var2.y(alipayUserId.f());
                    wy9Var2.u(alipayUserId.b());
                    wy9Var2.o(alipayUserId.a());
                    wy9Var2.x(alipayUserId.e());
                    if (!wy9Var2.h()) {
                        i4 = 0;
                        wy9Var2.n(false);
                        addObserver("aliAuthResult", wy9Var2, false);
                        wy9Var2.z(i4);
                    }
                }
                i4 = 0;
                wy9Var2.z(i4);
            } else if (b.equals("system/getFileDownloadStatus")) {
                wy9Var2.s(true);
                wy9 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    wy9Var2.y(fileDownloadStatus.f());
                    wy9Var2.u(fileDownloadStatus.b());
                    wy9Var2.o(fileDownloadStatus.a());
                    wy9Var2.x(fileDownloadStatus.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                wy9Var2.s(true);
                wy9 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    wy9Var2.y(fileDownloadProgress.f());
                    wy9Var2.u(fileDownloadProgress.b());
                    wy9Var2.o(fileDownloadProgress.a());
                    wy9Var2.x(fileDownloadProgress.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                wy9Var2.s(true);
                wy9 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    wy9Var2.y(fileDownloadPause.f());
                    wy9Var2.u(fileDownloadPause.b());
                    wy9Var2.o(fileDownloadPause.a());
                    wy9Var2.x(fileDownloadPause.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                wy9Var2.s(true);
                wy9 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    wy9Var2.y(fileDownloadDelete.f());
                    wy9Var2.u(fileDownloadDelete.b());
                    wy9Var2.o(fileDownloadDelete.a());
                    wy9Var2.x(fileDownloadDelete.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/installGameApk")) {
                wy9Var2.s(true);
                wy9 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    wy9Var2.y(installGameApk.f());
                    wy9Var2.u(installGameApk.b());
                    wy9Var2.o(installGameApk.a());
                    wy9Var2.x(installGameApk.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/launchApk")) {
                wy9Var2.s(true);
                wy9 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    wy9Var2.y(launchApk.f());
                    wy9Var2.u(launchApk.b());
                    wy9Var2.o(launchApk.a());
                    wy9Var2.x(launchApk.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                wy9Var2.s(true);
                wy9 wakeKeyboard = this.mJsBridge.wakeKeyboard();
                if (wakeKeyboard != null) {
                    wy9Var2.y(wakeKeyboard.f());
                    wy9Var2.u(wakeKeyboard.b());
                    wy9Var2.o(wakeKeyboard.a());
                    wy9Var2.x(wakeKeyboard.e());
                }
                wy9Var2.z(0);
            } else if (b.equals("router/replyPost")) {
                wy9Var2.s(true);
                wy9 replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    wy9Var2.y(replyPost.f());
                    wy9Var2.u(replyPost.b());
                    wy9Var2.o(replyPost.a());
                    wy9Var2.x(replyPost.e());
                    if (!wy9Var2.h()) {
                        i3 = 0;
                        wy9Var2.n(false);
                        addObserver("replyPostResult", wy9Var2, false);
                        wy9Var2.z(i3);
                    }
                }
                i3 = 0;
                wy9Var2.z(i3);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                wy9Var2.s(true);
                wy9 nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    wy9Var2.y(nativeNetworkProxy.f());
                    wy9Var2.u(nativeNetworkProxy.b());
                    wy9Var2.o(nativeNetworkProxy.a());
                    wy9Var2.x(nativeNetworkProxy.e());
                    if (!wy9Var2.h()) {
                        i2 = 0;
                        wy9Var2.n(false);
                        addObserver("nativeNetworkProxyResult", wy9Var2, false);
                        wy9Var2.z(i2);
                    }
                }
                i2 = 0;
                wy9Var2.z(i2);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                wy9Var2.s(true);
                wy9 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    wy9Var2.y(requestByNative.f());
                    wy9Var2.u(requestByNative.b());
                    wy9Var2.o(requestByNative.a());
                    wy9Var2.x(requestByNative.e());
                    if (!wy9Var2.h()) {
                        i = 0;
                        wy9Var2.n(false);
                        addObserver("RequestByNativeToH5", wy9Var2, false);
                        wy9Var2.z(i);
                    }
                }
                i = 0;
                wy9Var2.z(i);
            }
            return wy9Var2;
        }
        return (wy9) invokeLL.objValue;
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

    @Override // com.baidu.tieba.uy9
    public List<wy9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            wy9 wy9Var = null;
            if (ui.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                wy9Var = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                wy9Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                wy9Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                wy9Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                wy9Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                wy9Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                wy9Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                wy9Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                wy9Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                wy9Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                wy9Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                wy9Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                wy9Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                wy9Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                wy9Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                wy9Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                wy9Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                wy9Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                wy9Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                wy9Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                wy9Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                wy9Var = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                wy9Var = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                wy9Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                wy9Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                wy9Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                wy9Var = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                wy9Var = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                wy9Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (wy9Var != null) {
                wy9Var.z(0);
            }
            List<vy9> list = this.mAsyncCallBackMethodList.get(str);
            if (wy9Var != null && list != null) {
                Iterator<vy9> it = list.iterator();
                if (!ui.isEmpty(wy9Var.e())) {
                    while (it.hasNext()) {
                        vy9 next = it.next();
                        if (next.b().equals(wy9Var.e())) {
                            wy9 wy9Var2 = new wy9();
                            wy9Var2.w(next.a());
                            wy9Var2.y(wy9Var.f());
                            wy9Var2.u(wy9Var.b());
                            wy9Var2.o(wy9Var.a());
                            wy9Var2.A(wy9Var.l());
                            arrayList.add(wy9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        vy9 next2 = it.next();
                        wy9 wy9Var3 = new wy9();
                        wy9Var3.w(next2.a());
                        wy9Var3.y(wy9Var.f());
                        wy9Var3.u(wy9Var.b());
                        wy9Var3.o(wy9Var.a());
                        wy9Var3.A(wy9Var.l());
                        arrayList.add(wy9Var3);
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
