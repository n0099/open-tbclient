package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.hs9;
import com.baidu.tieba.is9;
import com.baidu.tieba.js9;
import com.baidu.tieba.ls9;
import com.baidu.tieba.qi;
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
/* loaded from: classes5.dex */
public class SingleQuickWebViewBridge_Proxy extends hs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.hs9
    public js9 dispatch(ls9 ls9Var, js9 js9Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ls9Var, js9Var)) == null) {
            js9 js9Var2 = js9Var == null ? new js9() : js9Var;
            String b = ls9Var.b();
            JSONObject e = ls9Var.e();
            if (b.equals("account/startLoginModule")) {
                js9Var2.s(true);
                js9 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    js9Var2.y(startLoginModule.f());
                    js9Var2.u(startLoginModule.b());
                    js9Var2.o(startLoginModule.a());
                    js9Var2.x(startLoginModule.e());
                }
                js9Var2.z(0);
            } else if (b.equals("account/commonLogin")) {
                js9Var2.s(true);
                js9 startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    js9Var2.y(startAllLoginModule.f());
                    js9Var2.u(startAllLoginModule.b());
                    js9Var2.o(startAllLoginModule.a());
                    js9Var2.x(startAllLoginModule.e());
                    if (!js9Var2.h()) {
                        js9Var2.n(false);
                        addObserver("commonLogin", js9Var2, false);
                    }
                }
                js9Var2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                js9Var2.s(true);
                js9 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    js9Var2.y(finishPage.f());
                    js9Var2.u(finishPage.b());
                    js9Var2.o(finishPage.a());
                    js9Var2.x(finishPage.e());
                }
                js9Var2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                js9Var2.s(true);
                js9 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    js9Var2.y(showLowerHairHint.f());
                    js9Var2.u(showLowerHairHint.b());
                    js9Var2.o(showLowerHairHint.a());
                    js9Var2.x(showLowerHairHint.e());
                }
                js9Var2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                js9Var2.s(true);
                js9 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    js9Var2.y(gamePush.f());
                    js9Var2.u(gamePush.b());
                    js9Var2.o(gamePush.a());
                    js9Var2.x(gamePush.e());
                }
                js9Var2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                js9Var2.s(true);
                js9 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    js9Var2.y(handleGamePushStatus.f());
                    js9Var2.u(handleGamePushStatus.b());
                    js9Var2.o(handleGamePushStatus.a());
                    js9Var2.x(handleGamePushStatus.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                js9Var2.s(true);
                js9 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    js9Var2.y(jumpForumRulesEditPage.f());
                    js9Var2.u(jumpForumRulesEditPage.b());
                    js9Var2.o(jumpForumRulesEditPage.a());
                    js9Var2.x(jumpForumRulesEditPage.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                js9Var2.s(true);
                js9 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    js9Var2.y(handleGoToBarDetail.f());
                    js9Var2.u(handleGoToBarDetail.b());
                    js9Var2.o(handleGoToBarDetail.a());
                    js9Var2.x(handleGoToBarDetail.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/saveImage")) {
                js9Var2.s(true);
                js9 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    js9Var2.y(handleSaveImage.f());
                    js9Var2.u(handleSaveImage.b());
                    js9Var2.o(handleSaveImage.a());
                    js9Var2.x(handleSaveImage.e());
                    if (!js9Var2.h()) {
                        js9Var2.n(false);
                        addObserver("saveImageSuccess", js9Var2, false);
                    }
                }
                js9Var2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                js9Var2.s(true);
                js9 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    js9Var2.y(orderGameApk.f());
                    js9Var2.u(orderGameApk.b());
                    js9Var2.o(orderGameApk.a());
                    js9Var2.x(orderGameApk.e());
                    if (!js9Var2.h()) {
                        js9Var2.n(false);
                        addObserver("orderGameApkResult", js9Var2, false);
                    }
                }
                js9Var2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                js9Var2.s(true);
                js9 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    js9Var2.y(handleGetPhotoAlbum.f());
                    js9Var2.u(handleGetPhotoAlbum.b());
                    js9Var2.o(handleGetPhotoAlbum.a());
                    js9Var2.x(handleGetPhotoAlbum.e());
                    if (!js9Var2.h()) {
                        js9Var2.n(false);
                        addObserver("GetPhotoAlbum", js9Var2, false);
                    }
                }
                js9Var2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                js9Var2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                js9 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    js9Var2.y(preheatWeb.f());
                    js9Var2.u(preheatWeb.b());
                    js9Var2.o(preheatWeb.a());
                    js9Var2.x(preheatWeb.e());
                }
                js9Var2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                js9Var2.s(true);
                js9 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    js9Var2.y(openMXDYab.f());
                    js9Var2.u(openMXDYab.b());
                    js9Var2.o(openMXDYab.a());
                    js9Var2.x(openMXDYab.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/portal")) {
                js9Var2.s(true);
                js9 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    js9Var2.y(handlePortal.f());
                    js9Var2.u(handlePortal.b());
                    js9Var2.o(handlePortal.a());
                    js9Var2.x(handlePortal.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                js9Var2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                js9 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    js9Var2.y(selectPhotoAlbum.f());
                    js9Var2.u(selectPhotoAlbum.b());
                    js9Var2.o(selectPhotoAlbum.a());
                    js9Var2.x(selectPhotoAlbum.e());
                    if (!js9Var2.h()) {
                        js9Var2.n(false);
                        addObserver("selectPhotoAlbum", js9Var2, false);
                    }
                }
                js9Var2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                js9Var2.s(true);
                js9 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (operateNotifyDataChanged != null) {
                    js9Var2.y(operateNotifyDataChanged.f());
                    js9Var2.u(operateNotifyDataChanged.b());
                    js9Var2.o(operateNotifyDataChanged.a());
                    js9Var2.x(operateNotifyDataChanged.e());
                    if (!js9Var2.h()) {
                        js9Var2.n(false);
                        addObserver("notifyNativeRefresh", js9Var2, false);
                    }
                }
                js9Var2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                js9Var2.s(true);
                js9 viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    js9Var2.y(viewPosition.f());
                    js9Var2.u(viewPosition.b());
                    js9Var2.o(viewPosition.a());
                    js9Var2.x(viewPosition.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                js9Var2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                js9 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    js9Var2.y(selectPrivateMsg.f());
                    js9Var2.u(selectPrivateMsg.b());
                    js9Var2.o(selectPrivateMsg.a());
                    js9Var2.x(selectPrivateMsg.e());
                    if (!js9Var2.h()) {
                        i7 = 0;
                        js9Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", js9Var2, false);
                        js9Var2.z(i7);
                    }
                }
                i7 = 0;
                js9Var2.z(i7);
            } else if (b.equals("router/goToReportThreadPage")) {
                js9Var2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                js9 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    js9Var2.y(reportUserTheme.f());
                    js9Var2.u(reportUserTheme.b());
                    js9Var2.o(reportUserTheme.a());
                    js9Var2.x(reportUserTheme.e());
                    if (!js9Var2.h()) {
                        i6 = 0;
                        js9Var2.n(false);
                        addObserver("goToReportThreadPage", js9Var2, false);
                        js9Var2.z(i6);
                    }
                }
                i6 = 0;
                js9Var2.z(i6);
            } else if (b.equals("system/playSound")) {
                js9Var2.s(true);
                js9 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    js9Var2.y(playSound.f());
                    js9Var2.u(playSound.b());
                    js9Var2.o(playSound.a());
                    js9Var2.x(playSound.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/playVibrate")) {
                js9Var2.s(true);
                js9 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    js9Var2.y(playVibrate.f());
                    js9Var2.u(playVibrate.b());
                    js9Var2.o(playVibrate.a());
                    js9Var2.x(playVibrate.e());
                }
                js9Var2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                js9Var2.s(true);
                js9 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    js9Var2.y(jumpLoginActivity.f());
                    js9Var2.u(jumpLoginActivity.b());
                    js9Var2.o(jumpLoginActivity.a());
                    js9Var2.x(jumpLoginActivity.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                js9Var2.s(true);
                js9 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    js9Var2.y(startLoadTimeInterval.f());
                    js9Var2.u(startLoadTimeInterval.b());
                    js9Var2.o(startLoadTimeInterval.a());
                    js9Var2.x(startLoadTimeInterval.e());
                }
                js9Var2.z(0);
            } else if (b.equals("device/getZid")) {
                js9Var2.s(true);
                js9 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    js9Var2.y(zid.f());
                    js9Var2.u(zid.b());
                    js9Var2.o(zid.a());
                    js9Var2.x(zid.e());
                }
                js9Var2.z(0);
            } else if (b.equals("device/getHdid")) {
                js9Var2.s(true);
                js9 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    js9Var2.y(hdid.f());
                    js9Var2.u(hdid.b());
                    js9Var2.o(hdid.a());
                    js9Var2.x(hdid.e());
                }
                js9Var2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                js9Var2.s(true);
                js9 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    js9Var2.y(shareInfo.f());
                    js9Var2.u(shareInfo.b());
                    js9Var2.o(shareInfo.a());
                    js9Var2.x(shareInfo.e());
                }
                js9Var2.z(0);
            } else if (b.equals("share/share")) {
                js9Var2.s(true);
                js9 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    js9Var2.y(share.f());
                    js9Var2.u(share.b());
                    js9Var2.o(share.a());
                    js9Var2.x(share.e());
                    if (!js9Var2.h()) {
                        i5 = 0;
                        js9Var2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, js9Var2, false);
                        js9Var2.z(i5);
                    }
                }
                i5 = 0;
                js9Var2.z(i5);
            } else if (b.equals("clipper/getClipperInformation")) {
                js9Var2.s(true);
                js9 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    js9Var2.y(clipperInformation.f());
                    js9Var2.u(clipperInformation.b());
                    js9Var2.o(clipperInformation.a());
                    js9Var2.x(clipperInformation.e());
                }
                js9Var2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                js9Var2.s(true);
                js9 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    js9Var2.y(clipperInformation2.f());
                    js9Var2.u(clipperInformation2.b());
                    js9Var2.o(clipperInformation2.a());
                    js9Var2.x(clipperInformation2.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                js9Var2.s(true);
                js9 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    js9Var2.y(goToEditPost.f());
                    js9Var2.u(goToEditPost.b());
                    js9Var2.o(goToEditPost.a());
                    js9Var2.x(goToEditPost.e());
                }
                js9Var2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                js9Var2.s(true);
                js9 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    js9Var2.y(updateSearchForumInfo.f());
                    js9Var2.u(updateSearchForumInfo.b());
                    js9Var2.o(updateSearchForumInfo.a());
                    js9Var2.x(updateSearchForumInfo.e());
                }
                js9Var2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                js9Var2.s(true);
                js9 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    js9Var2.y(personlizedSwitchChange.f());
                    js9Var2.u(personlizedSwitchChange.b());
                    js9Var2.o(personlizedSwitchChange.a());
                    js9Var2.x(personlizedSwitchChange.e());
                }
                js9Var2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                js9Var2.s(true);
                js9 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    js9Var2.y(updateTailStyle.f());
                    js9Var2.u(updateTailStyle.b());
                    js9Var2.o(updateTailStyle.a());
                    js9Var2.x(updateTailStyle.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                js9Var2.s(true);
                js9 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    js9Var2.y(goToVideoImmersivePage.f());
                    js9Var2.u(goToVideoImmersivePage.b());
                    js9Var2.o(goToVideoImmersivePage.a());
                    js9Var2.x(goToVideoImmersivePage.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                js9Var2.s(true);
                js9 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    js9Var2.y(jumpToVideo.f());
                    js9Var2.u(jumpToVideo.b());
                    js9Var2.o(jumpToVideo.a());
                    js9Var2.x(jumpToVideo.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                js9Var2.s(true);
                js9 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    js9Var2.y(closeNativeMask.f());
                    js9Var2.u(closeNativeMask.b());
                    js9Var2.o(closeNativeMask.a());
                    js9Var2.x(closeNativeMask.e());
                }
                js9Var2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                js9Var2.s(true);
                js9 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    js9Var2.y(oneKeyDeletion.f());
                    js9Var2.u(oneKeyDeletion.b());
                    js9Var2.o(oneKeyDeletion.a());
                    js9Var2.x(oneKeyDeletion.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                js9Var2.s(true);
                js9 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    js9Var2.y(checkAppInstall.f());
                    js9Var2.u(checkAppInstall.b());
                    js9Var2.o(checkAppInstall.a());
                    js9Var2.x(checkAppInstall.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                js9Var2.s(true);
                js9 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    js9Var2.y(disableBack.f());
                    js9Var2.u(disableBack.b());
                    js9Var2.o(disableBack.a());
                    js9Var2.x(disableBack.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/startApp")) {
                js9Var2.s(true);
                js9 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    js9Var2.y(startApp.f());
                    js9Var2.u(startApp.b());
                    js9Var2.o(startApp.a());
                    js9Var2.x(startApp.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                js9Var2.s(true);
                js9 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    js9Var2.y(hasNotificationPermission.f());
                    js9Var2.u(hasNotificationPermission.b());
                    js9Var2.o(hasNotificationPermission.a());
                    js9Var2.x(hasNotificationPermission.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                js9Var2.s(true);
                js9 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    js9Var2.y(goToNotificationSetting.f());
                    js9Var2.u(goToNotificationSetting.b());
                    js9Var2.o(goToNotificationSetting.a());
                    js9Var2.x(goToNotificationSetting.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                js9Var2.s(true);
                js9 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    js9Var2.y(startDownloadGameApk.f());
                    js9Var2.u(startDownloadGameApk.b());
                    js9Var2.o(startDownloadGameApk.a());
                    js9Var2.x(startDownloadGameApk.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                js9Var2.s(true);
                js9 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    js9Var2.y(checkInstallGameApk.f());
                    js9Var2.u(checkInstallGameApk.b());
                    js9Var2.o(checkInstallGameApk.a());
                    js9Var2.x(checkInstallGameApk.e());
                }
                js9Var2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                js9Var2.s(true);
                js9 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    js9Var2.y(startDownloadCss.f());
                    js9Var2.u(startDownloadCss.b());
                    js9Var2.o(startDownloadCss.a());
                    js9Var2.x(startDownloadCss.e());
                }
                js9Var2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                js9Var2.s(true);
                js9 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    js9Var2.y(disableGoBack.f());
                    js9Var2.u(disableGoBack.b());
                    js9Var2.o(disableGoBack.a());
                    js9Var2.x(disableGoBack.e());
                }
                js9Var2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                js9Var2.s(true);
                js9 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    js9Var2.y(supplementInfo.f());
                    js9Var2.u(supplementInfo.b());
                    js9Var2.o(supplementInfo.a());
                    js9Var2.x(supplementInfo.e());
                }
                js9Var2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                js9Var2.s(true);
                js9 deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    js9Var2.y(deviceGyroscopeParams.f());
                    js9Var2.u(deviceGyroscopeParams.b());
                    js9Var2.o(deviceGyroscopeParams.a());
                    js9Var2.x(deviceGyroscopeParams.e());
                    if (!js9Var2.h()) {
                        i4 = 0;
                        js9Var2.n(false);
                        addObserver("deviceMotion", js9Var2, false);
                        js9Var2.z(i4);
                    }
                }
                i4 = 0;
                js9Var2.z(i4);
            } else if (b.equals("device/deviceRefreshRate")) {
                js9Var2.s(true);
                js9 deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    js9Var2.y(deviceRefreshRateParams.f());
                    js9Var2.u(deviceRefreshRateParams.b());
                    js9Var2.o(deviceRefreshRateParams.a());
                    js9Var2.x(deviceRefreshRateParams.e());
                    if (!js9Var2.h()) {
                        i3 = 0;
                        js9Var2.n(false);
                        addObserver("deviceRefreshRate", js9Var2, false);
                        js9Var2.z(i3);
                    }
                }
                i3 = 0;
                js9Var2.z(i3);
            } else if (b.equals("device/getDeviceInfo")) {
                js9Var2.s(true);
                js9 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    js9Var2.y(deviceInfo.f());
                    js9Var2.u(deviceInfo.b());
                    js9Var2.o(deviceInfo.a());
                    js9Var2.x(deviceInfo.e());
                }
                js9Var2.z(0);
            } else if (b.equals("activity/completeTask")) {
                js9Var2.s(true);
                js9 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    js9Var2.y(sendCompleteTaskReqMsg.f());
                    js9Var2.u(sendCompleteTaskReqMsg.b());
                    js9Var2.o(sendCompleteTaskReqMsg.a());
                    js9Var2.x(sendCompleteTaskReqMsg.e());
                }
                js9Var2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                js9Var2.s(true);
                js9 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    js9Var2.y(showTipToast.f());
                    js9Var2.u(showTipToast.b());
                    js9Var2.o(showTipToast.a());
                    js9Var2.x(showTipToast.e());
                }
                js9Var2.z(0);
            } else if (b.equals("toast/getModalData")) {
                js9Var2.s(true);
                js9 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    js9Var2.y(getModalData.f());
                    js9Var2.u(getModalData.b());
                    js9Var2.o(getModalData.a());
                    js9Var2.x(getModalData.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                js9Var2.s(true);
                js9 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    js9Var2.y(openThirdPartApp.f());
                    js9Var2.u(openThirdPartApp.b());
                    js9Var2.o(openThirdPartApp.a());
                    js9Var2.x(openThirdPartApp.e());
                }
                js9Var2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                js9Var2.s(true);
                js9 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    js9Var2.y(jumpToHtmlPage.f());
                    js9Var2.u(jumpToHtmlPage.b());
                    js9Var2.o(jumpToHtmlPage.a());
                    js9Var2.x(jumpToHtmlPage.e());
                }
                js9Var2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                js9Var2.s(true);
                js9 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    js9Var2.y(offlineUserInfo.f());
                    js9Var2.u(offlineUserInfo.b());
                    js9Var2.o(offlineUserInfo.a());
                    js9Var2.x(offlineUserInfo.e());
                }
                js9Var2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                js9Var2.s(true);
                js9 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    js9Var2.y(deleteOfflineBundle.f());
                    js9Var2.u(deleteOfflineBundle.b());
                    js9Var2.o(deleteOfflineBundle.a());
                    js9Var2.x(deleteOfflineBundle.e());
                }
                js9Var2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                js9Var2.s(true);
                js9 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    js9Var2.y(updateOfflineBundle.f());
                    js9Var2.u(updateOfflineBundle.b());
                    js9Var2.o(updateOfflineBundle.a());
                    js9Var2.x(updateOfflineBundle.e());
                }
                js9Var2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                js9Var2.s(true);
                js9 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    js9Var2.y(switchOfflineInterface.f());
                    js9Var2.u(switchOfflineInterface.b());
                    js9Var2.o(switchOfflineInterface.a());
                    js9Var2.x(switchOfflineInterface.e());
                }
                js9Var2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                js9Var2.s(true);
                js9 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    js9Var2.y(switchOfflineBundleStatus.f());
                    js9Var2.u(switchOfflineBundleStatus.b());
                    js9Var2.o(switchOfflineBundleStatus.a());
                    js9Var2.x(switchOfflineBundleStatus.e());
                }
                js9Var2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                js9Var2.s(true);
                js9 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    js9Var2.y(finishTestAnswer.f());
                    js9Var2.u(finishTestAnswer.b());
                    js9Var2.o(finishTestAnswer.a());
                    js9Var2.x(finishTestAnswer.e());
                }
                js9Var2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                js9Var2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                js9 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    js9Var2.y(switchUrlHost.f());
                    js9Var2.u(switchUrlHost.b());
                    js9Var2.o(switchUrlHost.a());
                    js9Var2.x(switchUrlHost.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                js9Var2.s(true);
                js9 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    js9Var2.y(appStorage.f());
                    js9Var2.u(appStorage.b());
                    js9Var2.o(appStorage.a());
                    js9Var2.x(appStorage.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                js9Var2.s(true);
                js9 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    js9Var2.y(putAppStorage.f());
                    js9Var2.u(putAppStorage.b());
                    js9Var2.o(putAppStorage.a());
                    js9Var2.x(putAppStorage.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                js9Var2.s(true);
                js9 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    js9Var2.y(historyForumData.f());
                    js9Var2.u(historyForumData.b());
                    js9Var2.o(historyForumData.a());
                    js9Var2.x(historyForumData.e());
                }
                js9Var2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                js9Var2.s(true);
                js9 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    js9Var2.y(worldCupRaiseSuccess.f());
                    js9Var2.u(worldCupRaiseSuccess.b());
                    js9Var2.o(worldCupRaiseSuccess.a());
                    js9Var2.x(worldCupRaiseSuccess.e());
                }
                js9Var2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                js9Var2.s(true);
                js9 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    js9Var2.y(alipayUserId.f());
                    js9Var2.u(alipayUserId.b());
                    js9Var2.o(alipayUserId.a());
                    js9Var2.x(alipayUserId.e());
                    if (!js9Var2.h()) {
                        i2 = 0;
                        js9Var2.n(false);
                        addObserver("aliAuthResult", js9Var2, false);
                        js9Var2.z(i2);
                    }
                }
                i2 = 0;
                js9Var2.z(i2);
            } else if (b.equals("system/getFileDownloadStatus")) {
                js9Var2.s(true);
                js9 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    js9Var2.y(fileDownloadStatus.f());
                    js9Var2.u(fileDownloadStatus.b());
                    js9Var2.o(fileDownloadStatus.a());
                    js9Var2.x(fileDownloadStatus.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                js9Var2.s(true);
                js9 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    js9Var2.y(fileDownloadProgress.f());
                    js9Var2.u(fileDownloadProgress.b());
                    js9Var2.o(fileDownloadProgress.a());
                    js9Var2.x(fileDownloadProgress.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                js9Var2.s(true);
                js9 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    js9Var2.y(fileDownloadPause.f());
                    js9Var2.u(fileDownloadPause.b());
                    js9Var2.o(fileDownloadPause.a());
                    js9Var2.x(fileDownloadPause.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                js9Var2.s(true);
                js9 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    js9Var2.y(fileDownloadDelete.f());
                    js9Var2.u(fileDownloadDelete.b());
                    js9Var2.o(fileDownloadDelete.a());
                    js9Var2.x(fileDownloadDelete.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/installGameApk")) {
                js9Var2.s(true);
                js9 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    js9Var2.y(installGameApk.f());
                    js9Var2.u(installGameApk.b());
                    js9Var2.o(installGameApk.a());
                    js9Var2.x(installGameApk.e());
                }
                js9Var2.z(0);
            } else if (b.equals("system/launchApk")) {
                js9Var2.s(true);
                js9 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    js9Var2.y(launchApk.f());
                    js9Var2.u(launchApk.b());
                    js9Var2.o(launchApk.a());
                    js9Var2.x(launchApk.e());
                }
                js9Var2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                js9Var2.s(true);
                js9 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    js9Var2.y(requestByNative.f());
                    js9Var2.u(requestByNative.b());
                    js9Var2.o(requestByNative.a());
                    js9Var2.x(requestByNative.e());
                    if (!js9Var2.h()) {
                        i = 0;
                        js9Var2.n(false);
                        addObserver("RequestByNativeToH5", js9Var2, false);
                        js9Var2.z(i);
                    }
                }
                i = 0;
                js9Var2.z(i);
            }
            return js9Var2;
        }
        return (js9) invokeLL.objValue;
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
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // com.baidu.tieba.hs9
    public List<js9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            js9 js9Var = null;
            if (qi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                js9Var = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                js9Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                js9Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                js9Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                js9Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                js9Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                js9Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                js9Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                js9Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                js9Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                js9Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                js9Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                js9Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                js9Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                js9Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                js9Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                js9Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                js9Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                js9Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                js9Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                js9Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                js9Var = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                js9Var = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                js9Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                js9Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                js9Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                js9Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (js9Var != null) {
                js9Var.z(0);
            }
            List<is9> list = this.mAsyncCallBackMethodList.get(str);
            if (js9Var != null && list != null) {
                Iterator<is9> it = list.iterator();
                if (!qi.isEmpty(js9Var.e())) {
                    while (it.hasNext()) {
                        is9 next = it.next();
                        if (next.b().equals(js9Var.e())) {
                            js9 js9Var2 = new js9();
                            js9Var2.w(next.a());
                            js9Var2.y(js9Var.f());
                            js9Var2.u(js9Var.b());
                            js9Var2.o(js9Var.a());
                            js9Var2.A(js9Var.l());
                            arrayList.add(js9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        is9 next2 = it.next();
                        js9 js9Var3 = new js9();
                        js9Var3.w(next2.a());
                        js9Var3.y(js9Var.f());
                        js9Var3.u(js9Var.b());
                        js9Var3.o(js9Var.a());
                        js9Var3.A(js9Var.l());
                        arrayList.add(js9Var3);
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
