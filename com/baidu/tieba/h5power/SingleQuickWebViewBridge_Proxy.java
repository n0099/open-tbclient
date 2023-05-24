package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.is9;
import com.baidu.tieba.js9;
import com.baidu.tieba.ks9;
import com.baidu.tieba.ms9;
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
public class SingleQuickWebViewBridge_Proxy extends is9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    @Override // com.baidu.tieba.is9
    public ks9 dispatch(ms9 ms9Var, ks9 ks9Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ms9Var, ks9Var)) == null) {
            ks9 ks9Var2 = ks9Var == null ? new ks9() : ks9Var;
            String b = ms9Var.b();
            JSONObject e = ms9Var.e();
            if (b.equals("account/startLoginModule")) {
                ks9Var2.s(true);
                ks9 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    ks9Var2.y(startLoginModule.f());
                    ks9Var2.u(startLoginModule.b());
                    ks9Var2.o(startLoginModule.a());
                    ks9Var2.x(startLoginModule.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("account/commonLogin")) {
                ks9Var2.s(true);
                ks9 startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    ks9Var2.y(startAllLoginModule.f());
                    ks9Var2.u(startAllLoginModule.b());
                    ks9Var2.o(startAllLoginModule.a());
                    ks9Var2.x(startAllLoginModule.e());
                    if (!ks9Var2.h()) {
                        ks9Var2.n(false);
                        addObserver("commonLogin", ks9Var2, false);
                    }
                }
                ks9Var2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                ks9Var2.s(true);
                ks9 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    ks9Var2.y(finishPage.f());
                    ks9Var2.u(finishPage.b());
                    ks9Var2.o(finishPage.a());
                    ks9Var2.x(finishPage.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                ks9Var2.s(true);
                ks9 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    ks9Var2.y(showLowerHairHint.f());
                    ks9Var2.u(showLowerHairHint.b());
                    ks9Var2.o(showLowerHairHint.a());
                    ks9Var2.x(showLowerHairHint.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                ks9Var2.s(true);
                ks9 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    ks9Var2.y(gamePush.f());
                    ks9Var2.u(gamePush.b());
                    ks9Var2.o(gamePush.a());
                    ks9Var2.x(gamePush.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                ks9Var2.s(true);
                ks9 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    ks9Var2.y(handleGamePushStatus.f());
                    ks9Var2.u(handleGamePushStatus.b());
                    ks9Var2.o(handleGamePushStatus.a());
                    ks9Var2.x(handleGamePushStatus.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                ks9Var2.s(true);
                ks9 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    ks9Var2.y(jumpForumRulesEditPage.f());
                    ks9Var2.u(jumpForumRulesEditPage.b());
                    ks9Var2.o(jumpForumRulesEditPage.a());
                    ks9Var2.x(jumpForumRulesEditPage.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                ks9Var2.s(true);
                ks9 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    ks9Var2.y(handleGoToBarDetail.f());
                    ks9Var2.u(handleGoToBarDetail.b());
                    ks9Var2.o(handleGoToBarDetail.a());
                    ks9Var2.x(handleGoToBarDetail.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/saveImage")) {
                ks9Var2.s(true);
                ks9 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    ks9Var2.y(handleSaveImage.f());
                    ks9Var2.u(handleSaveImage.b());
                    ks9Var2.o(handleSaveImage.a());
                    ks9Var2.x(handleSaveImage.e());
                    if (!ks9Var2.h()) {
                        ks9Var2.n(false);
                        addObserver("saveImageSuccess", ks9Var2, false);
                    }
                }
                ks9Var2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                ks9Var2.s(true);
                ks9 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    ks9Var2.y(orderGameApk.f());
                    ks9Var2.u(orderGameApk.b());
                    ks9Var2.o(orderGameApk.a());
                    ks9Var2.x(orderGameApk.e());
                    if (!ks9Var2.h()) {
                        ks9Var2.n(false);
                        addObserver("orderGameApkResult", ks9Var2, false);
                    }
                }
                ks9Var2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                ks9Var2.s(true);
                ks9 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    ks9Var2.y(handleGetPhotoAlbum.f());
                    ks9Var2.u(handleGetPhotoAlbum.b());
                    ks9Var2.o(handleGetPhotoAlbum.a());
                    ks9Var2.x(handleGetPhotoAlbum.e());
                    if (!ks9Var2.h()) {
                        ks9Var2.n(false);
                        addObserver("GetPhotoAlbum", ks9Var2, false);
                    }
                }
                ks9Var2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                ks9Var2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                ks9 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    ks9Var2.y(preheatWeb.f());
                    ks9Var2.u(preheatWeb.b());
                    ks9Var2.o(preheatWeb.a());
                    ks9Var2.x(preheatWeb.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                ks9Var2.s(true);
                ks9 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    ks9Var2.y(openMXDYab.f());
                    ks9Var2.u(openMXDYab.b());
                    ks9Var2.o(openMXDYab.a());
                    ks9Var2.x(openMXDYab.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/portal")) {
                ks9Var2.s(true);
                ks9 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    ks9Var2.y(handlePortal.f());
                    ks9Var2.u(handlePortal.b());
                    ks9Var2.o(handlePortal.a());
                    ks9Var2.x(handlePortal.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                ks9Var2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                ks9 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    ks9Var2.y(selectPhotoAlbum.f());
                    ks9Var2.u(selectPhotoAlbum.b());
                    ks9Var2.o(selectPhotoAlbum.a());
                    ks9Var2.x(selectPhotoAlbum.e());
                    if (!ks9Var2.h()) {
                        ks9Var2.n(false);
                        addObserver("selectPhotoAlbum", ks9Var2, false);
                    }
                }
                ks9Var2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                ks9Var2.s(true);
                ks9 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (operateNotifyDataChanged != null) {
                    ks9Var2.y(operateNotifyDataChanged.f());
                    ks9Var2.u(operateNotifyDataChanged.b());
                    ks9Var2.o(operateNotifyDataChanged.a());
                    ks9Var2.x(operateNotifyDataChanged.e());
                    if (!ks9Var2.h()) {
                        ks9Var2.n(false);
                        addObserver("notifyNativeRefresh", ks9Var2, false);
                    }
                }
                ks9Var2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                ks9Var2.s(true);
                ks9 viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    ks9Var2.y(viewPosition.f());
                    ks9Var2.u(viewPosition.b());
                    ks9Var2.o(viewPosition.a());
                    ks9Var2.x(viewPosition.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                ks9Var2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                ks9 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    ks9Var2.y(selectPrivateMsg.f());
                    ks9Var2.u(selectPrivateMsg.b());
                    ks9Var2.o(selectPrivateMsg.a());
                    ks9Var2.x(selectPrivateMsg.e());
                    if (!ks9Var2.h()) {
                        i7 = 0;
                        ks9Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", ks9Var2, false);
                        ks9Var2.z(i7);
                    }
                }
                i7 = 0;
                ks9Var2.z(i7);
            } else if (b.equals("router/goToReportThreadPage")) {
                ks9Var2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                ks9 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    ks9Var2.y(reportUserTheme.f());
                    ks9Var2.u(reportUserTheme.b());
                    ks9Var2.o(reportUserTheme.a());
                    ks9Var2.x(reportUserTheme.e());
                    if (!ks9Var2.h()) {
                        i6 = 0;
                        ks9Var2.n(false);
                        addObserver("goToReportThreadPage", ks9Var2, false);
                        ks9Var2.z(i6);
                    }
                }
                i6 = 0;
                ks9Var2.z(i6);
            } else if (b.equals("system/playSound")) {
                ks9Var2.s(true);
                ks9 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    ks9Var2.y(playSound.f());
                    ks9Var2.u(playSound.b());
                    ks9Var2.o(playSound.a());
                    ks9Var2.x(playSound.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/playVibrate")) {
                ks9Var2.s(true);
                ks9 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    ks9Var2.y(playVibrate.f());
                    ks9Var2.u(playVibrate.b());
                    ks9Var2.o(playVibrate.a());
                    ks9Var2.x(playVibrate.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                ks9Var2.s(true);
                ks9 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    ks9Var2.y(jumpLoginActivity.f());
                    ks9Var2.u(jumpLoginActivity.b());
                    ks9Var2.o(jumpLoginActivity.a());
                    ks9Var2.x(jumpLoginActivity.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                ks9Var2.s(true);
                ks9 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    ks9Var2.y(startLoadTimeInterval.f());
                    ks9Var2.u(startLoadTimeInterval.b());
                    ks9Var2.o(startLoadTimeInterval.a());
                    ks9Var2.x(startLoadTimeInterval.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("device/getZid")) {
                ks9Var2.s(true);
                ks9 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    ks9Var2.y(zid.f());
                    ks9Var2.u(zid.b());
                    ks9Var2.o(zid.a());
                    ks9Var2.x(zid.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("device/getHdid")) {
                ks9Var2.s(true);
                ks9 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    ks9Var2.y(hdid.f());
                    ks9Var2.u(hdid.b());
                    ks9Var2.o(hdid.a());
                    ks9Var2.x(hdid.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                ks9Var2.s(true);
                ks9 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    ks9Var2.y(shareInfo.f());
                    ks9Var2.u(shareInfo.b());
                    ks9Var2.o(shareInfo.a());
                    ks9Var2.x(shareInfo.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("share/share")) {
                ks9Var2.s(true);
                ks9 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    ks9Var2.y(share.f());
                    ks9Var2.u(share.b());
                    ks9Var2.o(share.a());
                    ks9Var2.x(share.e());
                    if (!ks9Var2.h()) {
                        i5 = 0;
                        ks9Var2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, ks9Var2, false);
                        ks9Var2.z(i5);
                    }
                }
                i5 = 0;
                ks9Var2.z(i5);
            } else if (b.equals("clipper/getClipperInformation")) {
                ks9Var2.s(true);
                ks9 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    ks9Var2.y(clipperInformation.f());
                    ks9Var2.u(clipperInformation.b());
                    ks9Var2.o(clipperInformation.a());
                    ks9Var2.x(clipperInformation.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                ks9Var2.s(true);
                ks9 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    ks9Var2.y(clipperInformation2.f());
                    ks9Var2.u(clipperInformation2.b());
                    ks9Var2.o(clipperInformation2.a());
                    ks9Var2.x(clipperInformation2.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                ks9Var2.s(true);
                ks9 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    ks9Var2.y(goToEditPost.f());
                    ks9Var2.u(goToEditPost.b());
                    ks9Var2.o(goToEditPost.a());
                    ks9Var2.x(goToEditPost.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                ks9Var2.s(true);
                ks9 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    ks9Var2.y(updateSearchForumInfo.f());
                    ks9Var2.u(updateSearchForumInfo.b());
                    ks9Var2.o(updateSearchForumInfo.a());
                    ks9Var2.x(updateSearchForumInfo.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                ks9Var2.s(true);
                ks9 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    ks9Var2.y(personlizedSwitchChange.f());
                    ks9Var2.u(personlizedSwitchChange.b());
                    ks9Var2.o(personlizedSwitchChange.a());
                    ks9Var2.x(personlizedSwitchChange.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                ks9Var2.s(true);
                ks9 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    ks9Var2.y(updateTailStyle.f());
                    ks9Var2.u(updateTailStyle.b());
                    ks9Var2.o(updateTailStyle.a());
                    ks9Var2.x(updateTailStyle.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                ks9Var2.s(true);
                ks9 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    ks9Var2.y(goToVideoImmersivePage.f());
                    ks9Var2.u(goToVideoImmersivePage.b());
                    ks9Var2.o(goToVideoImmersivePage.a());
                    ks9Var2.x(goToVideoImmersivePage.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                ks9Var2.s(true);
                ks9 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    ks9Var2.y(jumpToVideo.f());
                    ks9Var2.u(jumpToVideo.b());
                    ks9Var2.o(jumpToVideo.a());
                    ks9Var2.x(jumpToVideo.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                ks9Var2.s(true);
                ks9 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    ks9Var2.y(closeNativeMask.f());
                    ks9Var2.u(closeNativeMask.b());
                    ks9Var2.o(closeNativeMask.a());
                    ks9Var2.x(closeNativeMask.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                ks9Var2.s(true);
                ks9 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    ks9Var2.y(oneKeyDeletion.f());
                    ks9Var2.u(oneKeyDeletion.b());
                    ks9Var2.o(oneKeyDeletion.a());
                    ks9Var2.x(oneKeyDeletion.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                ks9Var2.s(true);
                ks9 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    ks9Var2.y(checkAppInstall.f());
                    ks9Var2.u(checkAppInstall.b());
                    ks9Var2.o(checkAppInstall.a());
                    ks9Var2.x(checkAppInstall.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                ks9Var2.s(true);
                ks9 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    ks9Var2.y(disableBack.f());
                    ks9Var2.u(disableBack.b());
                    ks9Var2.o(disableBack.a());
                    ks9Var2.x(disableBack.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/startApp")) {
                ks9Var2.s(true);
                ks9 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    ks9Var2.y(startApp.f());
                    ks9Var2.u(startApp.b());
                    ks9Var2.o(startApp.a());
                    ks9Var2.x(startApp.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                ks9Var2.s(true);
                ks9 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    ks9Var2.y(hasNotificationPermission.f());
                    ks9Var2.u(hasNotificationPermission.b());
                    ks9Var2.o(hasNotificationPermission.a());
                    ks9Var2.x(hasNotificationPermission.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                ks9Var2.s(true);
                ks9 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    ks9Var2.y(goToNotificationSetting.f());
                    ks9Var2.u(goToNotificationSetting.b());
                    ks9Var2.o(goToNotificationSetting.a());
                    ks9Var2.x(goToNotificationSetting.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                ks9Var2.s(true);
                ks9 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    ks9Var2.y(startDownloadGameApk.f());
                    ks9Var2.u(startDownloadGameApk.b());
                    ks9Var2.o(startDownloadGameApk.a());
                    ks9Var2.x(startDownloadGameApk.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                ks9Var2.s(true);
                ks9 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    ks9Var2.y(checkInstallGameApk.f());
                    ks9Var2.u(checkInstallGameApk.b());
                    ks9Var2.o(checkInstallGameApk.a());
                    ks9Var2.x(checkInstallGameApk.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                ks9Var2.s(true);
                ks9 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    ks9Var2.y(startDownloadCss.f());
                    ks9Var2.u(startDownloadCss.b());
                    ks9Var2.o(startDownloadCss.a());
                    ks9Var2.x(startDownloadCss.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                ks9Var2.s(true);
                ks9 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    ks9Var2.y(disableGoBack.f());
                    ks9Var2.u(disableGoBack.b());
                    ks9Var2.o(disableGoBack.a());
                    ks9Var2.x(disableGoBack.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                ks9Var2.s(true);
                ks9 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    ks9Var2.y(supplementInfo.f());
                    ks9Var2.u(supplementInfo.b());
                    ks9Var2.o(supplementInfo.a());
                    ks9Var2.x(supplementInfo.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                ks9Var2.s(true);
                ks9 deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    ks9Var2.y(deviceGyroscopeParams.f());
                    ks9Var2.u(deviceGyroscopeParams.b());
                    ks9Var2.o(deviceGyroscopeParams.a());
                    ks9Var2.x(deviceGyroscopeParams.e());
                    if (!ks9Var2.h()) {
                        i4 = 0;
                        ks9Var2.n(false);
                        addObserver("deviceMotion", ks9Var2, false);
                        ks9Var2.z(i4);
                    }
                }
                i4 = 0;
                ks9Var2.z(i4);
            } else if (b.equals("device/deviceRefreshRate")) {
                ks9Var2.s(true);
                ks9 deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    ks9Var2.y(deviceRefreshRateParams.f());
                    ks9Var2.u(deviceRefreshRateParams.b());
                    ks9Var2.o(deviceRefreshRateParams.a());
                    ks9Var2.x(deviceRefreshRateParams.e());
                    if (!ks9Var2.h()) {
                        i3 = 0;
                        ks9Var2.n(false);
                        addObserver("deviceRefreshRate", ks9Var2, false);
                        ks9Var2.z(i3);
                    }
                }
                i3 = 0;
                ks9Var2.z(i3);
            } else if (b.equals("device/getDeviceInfo")) {
                ks9Var2.s(true);
                ks9 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    ks9Var2.y(deviceInfo.f());
                    ks9Var2.u(deviceInfo.b());
                    ks9Var2.o(deviceInfo.a());
                    ks9Var2.x(deviceInfo.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("activity/completeTask")) {
                ks9Var2.s(true);
                ks9 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    ks9Var2.y(sendCompleteTaskReqMsg.f());
                    ks9Var2.u(sendCompleteTaskReqMsg.b());
                    ks9Var2.o(sendCompleteTaskReqMsg.a());
                    ks9Var2.x(sendCompleteTaskReqMsg.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                ks9Var2.s(true);
                ks9 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    ks9Var2.y(showTipToast.f());
                    ks9Var2.u(showTipToast.b());
                    ks9Var2.o(showTipToast.a());
                    ks9Var2.x(showTipToast.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("toast/getModalData")) {
                ks9Var2.s(true);
                ks9 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    ks9Var2.y(getModalData.f());
                    ks9Var2.u(getModalData.b());
                    ks9Var2.o(getModalData.a());
                    ks9Var2.x(getModalData.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                ks9Var2.s(true);
                ks9 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    ks9Var2.y(openThirdPartApp.f());
                    ks9Var2.u(openThirdPartApp.b());
                    ks9Var2.o(openThirdPartApp.a());
                    ks9Var2.x(openThirdPartApp.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                ks9Var2.s(true);
                ks9 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    ks9Var2.y(jumpToHtmlPage.f());
                    ks9Var2.u(jumpToHtmlPage.b());
                    ks9Var2.o(jumpToHtmlPage.a());
                    ks9Var2.x(jumpToHtmlPage.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                ks9Var2.s(true);
                ks9 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    ks9Var2.y(offlineUserInfo.f());
                    ks9Var2.u(offlineUserInfo.b());
                    ks9Var2.o(offlineUserInfo.a());
                    ks9Var2.x(offlineUserInfo.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                ks9Var2.s(true);
                ks9 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    ks9Var2.y(deleteOfflineBundle.f());
                    ks9Var2.u(deleteOfflineBundle.b());
                    ks9Var2.o(deleteOfflineBundle.a());
                    ks9Var2.x(deleteOfflineBundle.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                ks9Var2.s(true);
                ks9 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    ks9Var2.y(updateOfflineBundle.f());
                    ks9Var2.u(updateOfflineBundle.b());
                    ks9Var2.o(updateOfflineBundle.a());
                    ks9Var2.x(updateOfflineBundle.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                ks9Var2.s(true);
                ks9 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    ks9Var2.y(switchOfflineInterface.f());
                    ks9Var2.u(switchOfflineInterface.b());
                    ks9Var2.o(switchOfflineInterface.a());
                    ks9Var2.x(switchOfflineInterface.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                ks9Var2.s(true);
                ks9 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    ks9Var2.y(switchOfflineBundleStatus.f());
                    ks9Var2.u(switchOfflineBundleStatus.b());
                    ks9Var2.o(switchOfflineBundleStatus.a());
                    ks9Var2.x(switchOfflineBundleStatus.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                ks9Var2.s(true);
                ks9 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    ks9Var2.y(finishTestAnswer.f());
                    ks9Var2.u(finishTestAnswer.b());
                    ks9Var2.o(finishTestAnswer.a());
                    ks9Var2.x(finishTestAnswer.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                ks9Var2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                ks9 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    ks9Var2.y(switchUrlHost.f());
                    ks9Var2.u(switchUrlHost.b());
                    ks9Var2.o(switchUrlHost.a());
                    ks9Var2.x(switchUrlHost.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                ks9Var2.s(true);
                ks9 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    ks9Var2.y(appStorage.f());
                    ks9Var2.u(appStorage.b());
                    ks9Var2.o(appStorage.a());
                    ks9Var2.x(appStorage.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                ks9Var2.s(true);
                ks9 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    ks9Var2.y(putAppStorage.f());
                    ks9Var2.u(putAppStorage.b());
                    ks9Var2.o(putAppStorage.a());
                    ks9Var2.x(putAppStorage.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                ks9Var2.s(true);
                ks9 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    ks9Var2.y(historyForumData.f());
                    ks9Var2.u(historyForumData.b());
                    ks9Var2.o(historyForumData.a());
                    ks9Var2.x(historyForumData.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                ks9Var2.s(true);
                ks9 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    ks9Var2.y(worldCupRaiseSuccess.f());
                    ks9Var2.u(worldCupRaiseSuccess.b());
                    ks9Var2.o(worldCupRaiseSuccess.a());
                    ks9Var2.x(worldCupRaiseSuccess.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                ks9Var2.s(true);
                ks9 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    ks9Var2.y(alipayUserId.f());
                    ks9Var2.u(alipayUserId.b());
                    ks9Var2.o(alipayUserId.a());
                    ks9Var2.x(alipayUserId.e());
                    if (!ks9Var2.h()) {
                        i2 = 0;
                        ks9Var2.n(false);
                        addObserver("aliAuthResult", ks9Var2, false);
                        ks9Var2.z(i2);
                    }
                }
                i2 = 0;
                ks9Var2.z(i2);
            } else if (b.equals("system/getFileDownloadStatus")) {
                ks9Var2.s(true);
                ks9 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    ks9Var2.y(fileDownloadStatus.f());
                    ks9Var2.u(fileDownloadStatus.b());
                    ks9Var2.o(fileDownloadStatus.a());
                    ks9Var2.x(fileDownloadStatus.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                ks9Var2.s(true);
                ks9 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    ks9Var2.y(fileDownloadProgress.f());
                    ks9Var2.u(fileDownloadProgress.b());
                    ks9Var2.o(fileDownloadProgress.a());
                    ks9Var2.x(fileDownloadProgress.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                ks9Var2.s(true);
                ks9 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    ks9Var2.y(fileDownloadPause.f());
                    ks9Var2.u(fileDownloadPause.b());
                    ks9Var2.o(fileDownloadPause.a());
                    ks9Var2.x(fileDownloadPause.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                ks9Var2.s(true);
                ks9 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    ks9Var2.y(fileDownloadDelete.f());
                    ks9Var2.u(fileDownloadDelete.b());
                    ks9Var2.o(fileDownloadDelete.a());
                    ks9Var2.x(fileDownloadDelete.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/installGameApk")) {
                ks9Var2.s(true);
                ks9 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    ks9Var2.y(installGameApk.f());
                    ks9Var2.u(installGameApk.b());
                    ks9Var2.o(installGameApk.a());
                    ks9Var2.x(installGameApk.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("system/launchApk")) {
                ks9Var2.s(true);
                ks9 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    ks9Var2.y(launchApk.f());
                    ks9Var2.u(launchApk.b());
                    ks9Var2.o(launchApk.a());
                    ks9Var2.x(launchApk.e());
                }
                ks9Var2.z(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                ks9Var2.s(true);
                ks9 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    ks9Var2.y(requestByNative.f());
                    ks9Var2.u(requestByNative.b());
                    ks9Var2.o(requestByNative.a());
                    ks9Var2.x(requestByNative.e());
                    if (!ks9Var2.h()) {
                        i = 0;
                        ks9Var2.n(false);
                        addObserver("RequestByNativeToH5", ks9Var2, false);
                        ks9Var2.z(i);
                    }
                }
                i = 0;
                ks9Var2.z(i);
            }
            return ks9Var2;
        }
        return (ks9) invokeLL.objValue;
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

    @Override // com.baidu.tieba.is9
    public List<ks9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            ks9 ks9Var = null;
            if (qi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                ks9Var = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                ks9Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                ks9Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                ks9Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                ks9Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                ks9Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                ks9Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                ks9Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                ks9Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                ks9Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                ks9Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                ks9Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                ks9Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                ks9Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                ks9Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                ks9Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                ks9Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                ks9Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                ks9Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                ks9Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                ks9Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                ks9Var = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                ks9Var = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                ks9Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                ks9Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                ks9Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                ks9Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (ks9Var != null) {
                ks9Var.z(0);
            }
            List<js9> list = this.mAsyncCallBackMethodList.get(str);
            if (ks9Var != null && list != null) {
                Iterator<js9> it = list.iterator();
                if (!qi.isEmpty(ks9Var.e())) {
                    while (it.hasNext()) {
                        js9 next = it.next();
                        if (next.b().equals(ks9Var.e())) {
                            ks9 ks9Var2 = new ks9();
                            ks9Var2.w(next.a());
                            ks9Var2.y(ks9Var.f());
                            ks9Var2.u(ks9Var.b());
                            ks9Var2.o(ks9Var.a());
                            ks9Var2.A(ks9Var.l());
                            arrayList.add(ks9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        js9 next2 = it.next();
                        ks9 ks9Var3 = new ks9();
                        ks9Var3.w(next2.a());
                        ks9Var3.y(ks9Var.f());
                        ks9Var3.u(ks9Var.b());
                        ks9Var3.o(ks9Var.a());
                        ks9Var3.A(ks9Var.l());
                        arrayList.add(ks9Var3);
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
