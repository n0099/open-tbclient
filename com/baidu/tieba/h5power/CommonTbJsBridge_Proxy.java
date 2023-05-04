package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.fq9;
import com.baidu.tieba.gq9;
import com.baidu.tieba.hi;
import com.baidu.tieba.hq9;
import com.baidu.tieba.jq9;
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
/* loaded from: classes4.dex */
public class CommonTbJsBridge_Proxy extends fq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.fq9
    public hq9 dispatch(jq9 jq9Var, hq9 hq9Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jq9Var, hq9Var)) == null) {
            hq9 hq9Var2 = hq9Var == null ? new hq9() : hq9Var;
            String b = jq9Var.b();
            JSONObject e = jq9Var.e();
            if (b.equals("account/startLoginModule")) {
                hq9Var2.s(true);
                hq9 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    hq9Var2.y(startLoginModule.f());
                    hq9Var2.u(startLoginModule.b());
                    hq9Var2.o(startLoginModule.a());
                    hq9Var2.x(startLoginModule.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("account/commonLogin")) {
                hq9Var2.s(true);
                hq9 startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    hq9Var2.y(startAllLoginModule.f());
                    hq9Var2.u(startAllLoginModule.b());
                    hq9Var2.o(startAllLoginModule.a());
                    hq9Var2.x(startAllLoginModule.e());
                    if (!hq9Var2.h()) {
                        hq9Var2.n(false);
                        addObserver("commonLogin", hq9Var2, false);
                    }
                }
                hq9Var2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                hq9Var2.s(true);
                hq9 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    hq9Var2.y(finishPage.f());
                    hq9Var2.u(finishPage.b());
                    hq9Var2.o(finishPage.a());
                    hq9Var2.x(finishPage.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                hq9Var2.s(true);
                hq9 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    hq9Var2.y(showLowerHairHint.f());
                    hq9Var2.u(showLowerHairHint.b());
                    hq9Var2.o(showLowerHairHint.a());
                    hq9Var2.x(showLowerHairHint.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                hq9Var2.s(true);
                hq9 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    hq9Var2.y(gamePush.f());
                    hq9Var2.u(gamePush.b());
                    hq9Var2.o(gamePush.a());
                    hq9Var2.x(gamePush.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                hq9Var2.s(true);
                hq9 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    hq9Var2.y(handleGamePushStatus.f());
                    hq9Var2.u(handleGamePushStatus.b());
                    hq9Var2.o(handleGamePushStatus.a());
                    hq9Var2.x(handleGamePushStatus.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                hq9Var2.s(true);
                hq9 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    hq9Var2.y(jumpForumRulesEditPage.f());
                    hq9Var2.u(jumpForumRulesEditPage.b());
                    hq9Var2.o(jumpForumRulesEditPage.a());
                    hq9Var2.x(jumpForumRulesEditPage.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                hq9Var2.s(true);
                hq9 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    hq9Var2.y(handleGoToBarDetail.f());
                    hq9Var2.u(handleGoToBarDetail.b());
                    hq9Var2.o(handleGoToBarDetail.a());
                    hq9Var2.x(handleGoToBarDetail.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/saveImage")) {
                hq9Var2.s(true);
                hq9 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    hq9Var2.y(handleSaveImage.f());
                    hq9Var2.u(handleSaveImage.b());
                    hq9Var2.o(handleSaveImage.a());
                    hq9Var2.x(handleSaveImage.e());
                    if (!hq9Var2.h()) {
                        hq9Var2.n(false);
                        addObserver("saveImageSuccess", hq9Var2, false);
                    }
                }
                hq9Var2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                hq9Var2.s(true);
                hq9 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    hq9Var2.y(orderGameApk.f());
                    hq9Var2.u(orderGameApk.b());
                    hq9Var2.o(orderGameApk.a());
                    hq9Var2.x(orderGameApk.e());
                    if (!hq9Var2.h()) {
                        hq9Var2.n(false);
                        addObserver("orderGameApkResult", hq9Var2, false);
                    }
                }
                hq9Var2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                hq9Var2.s(true);
                hq9 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    hq9Var2.y(handleGetPhotoAlbum.f());
                    hq9Var2.u(handleGetPhotoAlbum.b());
                    hq9Var2.o(handleGetPhotoAlbum.a());
                    hq9Var2.x(handleGetPhotoAlbum.e());
                    if (!hq9Var2.h()) {
                        hq9Var2.n(false);
                        addObserver("GetPhotoAlbum", hq9Var2, false);
                    }
                }
                hq9Var2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                hq9Var2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                hq9 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    hq9Var2.y(preheatWeb.f());
                    hq9Var2.u(preheatWeb.b());
                    hq9Var2.o(preheatWeb.a());
                    hq9Var2.x(preheatWeb.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                hq9Var2.s(true);
                hq9 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    hq9Var2.y(openMXDYab.f());
                    hq9Var2.u(openMXDYab.b());
                    hq9Var2.o(openMXDYab.a());
                    hq9Var2.x(openMXDYab.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("router/portal")) {
                hq9Var2.s(true);
                hq9 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    hq9Var2.y(handlePortal.f());
                    hq9Var2.u(handlePortal.b());
                    hq9Var2.o(handlePortal.a());
                    hq9Var2.x(handlePortal.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                hq9Var2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                hq9 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    hq9Var2.y(selectPhotoAlbum.f());
                    hq9Var2.u(selectPhotoAlbum.b());
                    hq9Var2.o(selectPhotoAlbum.a());
                    hq9Var2.x(selectPhotoAlbum.e());
                    if (!hq9Var2.h()) {
                        hq9Var2.n(false);
                        addObserver("selectPhotoAlbum", hq9Var2, false);
                    }
                }
                hq9Var2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                hq9Var2.s(true);
                hq9 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (operateNotifyDataChanged != null) {
                    hq9Var2.y(operateNotifyDataChanged.f());
                    hq9Var2.u(operateNotifyDataChanged.b());
                    hq9Var2.o(operateNotifyDataChanged.a());
                    hq9Var2.x(operateNotifyDataChanged.e());
                    if (!hq9Var2.h()) {
                        hq9Var2.n(false);
                        addObserver("notifyNativeRefresh", hq9Var2, false);
                    }
                }
                hq9Var2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                hq9Var2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                hq9 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    hq9Var2.y(selectPrivateMsg.f());
                    hq9Var2.u(selectPrivateMsg.b());
                    hq9Var2.o(selectPrivateMsg.a());
                    hq9Var2.x(selectPrivateMsg.e());
                    if (!hq9Var2.h()) {
                        i6 = 0;
                        hq9Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", hq9Var2, false);
                        hq9Var2.z(i6);
                    }
                }
                i6 = 0;
                hq9Var2.z(i6);
            } else if (b.equals("router/goToReportThreadPage")) {
                hq9Var2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                hq9 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    hq9Var2.y(reportUserTheme.f());
                    hq9Var2.u(reportUserTheme.b());
                    hq9Var2.o(reportUserTheme.a());
                    hq9Var2.x(reportUserTheme.e());
                    if (!hq9Var2.h()) {
                        i5 = 0;
                        hq9Var2.n(false);
                        addObserver("goToReportThreadPage", hq9Var2, false);
                        hq9Var2.z(i5);
                    }
                }
                i5 = 0;
                hq9Var2.z(i5);
            } else if (b.equals("system/playSound")) {
                hq9Var2.s(true);
                hq9 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    hq9Var2.y(playSound.f());
                    hq9Var2.u(playSound.b());
                    hq9Var2.o(playSound.a());
                    hq9Var2.x(playSound.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/playVibrate")) {
                hq9Var2.s(true);
                hq9 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    hq9Var2.y(playVibrate.f());
                    hq9Var2.u(playVibrate.b());
                    hq9Var2.o(playVibrate.a());
                    hq9Var2.x(playVibrate.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                hq9Var2.s(true);
                hq9 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    hq9Var2.y(jumpLoginActivity.f());
                    hq9Var2.u(jumpLoginActivity.b());
                    hq9Var2.o(jumpLoginActivity.a());
                    hq9Var2.x(jumpLoginActivity.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                hq9Var2.s(true);
                hq9 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    hq9Var2.y(startLoadTimeInterval.f());
                    hq9Var2.u(startLoadTimeInterval.b());
                    hq9Var2.o(startLoadTimeInterval.a());
                    hq9Var2.x(startLoadTimeInterval.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("device/getZid")) {
                hq9Var2.s(true);
                hq9 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    hq9Var2.y(zid.f());
                    hq9Var2.u(zid.b());
                    hq9Var2.o(zid.a());
                    hq9Var2.x(zid.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("device/getHdid")) {
                hq9Var2.s(true);
                hq9 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    hq9Var2.y(hdid.f());
                    hq9Var2.u(hdid.b());
                    hq9Var2.o(hdid.a());
                    hq9Var2.x(hdid.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                hq9Var2.s(true);
                hq9 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    hq9Var2.y(shareInfo.f());
                    hq9Var2.u(shareInfo.b());
                    hq9Var2.o(shareInfo.a());
                    hq9Var2.x(shareInfo.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("share/share")) {
                hq9Var2.s(true);
                hq9 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    hq9Var2.y(share.f());
                    hq9Var2.u(share.b());
                    hq9Var2.o(share.a());
                    hq9Var2.x(share.e());
                    if (!hq9Var2.h()) {
                        i4 = 0;
                        hq9Var2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, hq9Var2, false);
                        hq9Var2.z(i4);
                    }
                }
                i4 = 0;
                hq9Var2.z(i4);
            } else if (b.equals("clipper/getClipperInformation")) {
                hq9Var2.s(true);
                hq9 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    hq9Var2.y(clipperInformation.f());
                    hq9Var2.u(clipperInformation.b());
                    hq9Var2.o(clipperInformation.a());
                    hq9Var2.x(clipperInformation.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                hq9Var2.s(true);
                hq9 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    hq9Var2.y(clipperInformation2.f());
                    hq9Var2.u(clipperInformation2.b());
                    hq9Var2.o(clipperInformation2.a());
                    hq9Var2.x(clipperInformation2.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                hq9Var2.s(true);
                hq9 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    hq9Var2.y(goToEditPost.f());
                    hq9Var2.u(goToEditPost.b());
                    hq9Var2.o(goToEditPost.a());
                    hq9Var2.x(goToEditPost.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                hq9Var2.s(true);
                hq9 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    hq9Var2.y(updateSearchForumInfo.f());
                    hq9Var2.u(updateSearchForumInfo.b());
                    hq9Var2.o(updateSearchForumInfo.a());
                    hq9Var2.x(updateSearchForumInfo.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                hq9Var2.s(true);
                hq9 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    hq9Var2.y(personlizedSwitchChange.f());
                    hq9Var2.u(personlizedSwitchChange.b());
                    hq9Var2.o(personlizedSwitchChange.a());
                    hq9Var2.x(personlizedSwitchChange.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                hq9Var2.s(true);
                hq9 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    hq9Var2.y(updateTailStyle.f());
                    hq9Var2.u(updateTailStyle.b());
                    hq9Var2.o(updateTailStyle.a());
                    hq9Var2.x(updateTailStyle.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                hq9Var2.s(true);
                hq9 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    hq9Var2.y(goToVideoImmersivePage.f());
                    hq9Var2.u(goToVideoImmersivePage.b());
                    hq9Var2.o(goToVideoImmersivePage.a());
                    hq9Var2.x(goToVideoImmersivePage.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                hq9Var2.s(true);
                hq9 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    hq9Var2.y(jumpToVideo.f());
                    hq9Var2.u(jumpToVideo.b());
                    hq9Var2.o(jumpToVideo.a());
                    hq9Var2.x(jumpToVideo.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                hq9Var2.s(true);
                hq9 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    hq9Var2.y(closeNativeMask.f());
                    hq9Var2.u(closeNativeMask.b());
                    hq9Var2.o(closeNativeMask.a());
                    hq9Var2.x(closeNativeMask.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                hq9Var2.s(true);
                hq9 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    hq9Var2.y(oneKeyDeletion.f());
                    hq9Var2.u(oneKeyDeletion.b());
                    hq9Var2.o(oneKeyDeletion.a());
                    hq9Var2.x(oneKeyDeletion.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                hq9Var2.s(true);
                hq9 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    hq9Var2.y(checkAppInstall.f());
                    hq9Var2.u(checkAppInstall.b());
                    hq9Var2.o(checkAppInstall.a());
                    hq9Var2.x(checkAppInstall.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                hq9Var2.s(true);
                hq9 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    hq9Var2.y(disableBack.f());
                    hq9Var2.u(disableBack.b());
                    hq9Var2.o(disableBack.a());
                    hq9Var2.x(disableBack.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/startApp")) {
                hq9Var2.s(true);
                hq9 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    hq9Var2.y(startApp.f());
                    hq9Var2.u(startApp.b());
                    hq9Var2.o(startApp.a());
                    hq9Var2.x(startApp.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                hq9Var2.s(true);
                hq9 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    hq9Var2.y(hasNotificationPermission.f());
                    hq9Var2.u(hasNotificationPermission.b());
                    hq9Var2.o(hasNotificationPermission.a());
                    hq9Var2.x(hasNotificationPermission.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                hq9Var2.s(true);
                hq9 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    hq9Var2.y(goToNotificationSetting.f());
                    hq9Var2.u(goToNotificationSetting.b());
                    hq9Var2.o(goToNotificationSetting.a());
                    hq9Var2.x(goToNotificationSetting.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                hq9Var2.s(true);
                hq9 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    hq9Var2.y(startDownloadGameApk.f());
                    hq9Var2.u(startDownloadGameApk.b());
                    hq9Var2.o(startDownloadGameApk.a());
                    hq9Var2.x(startDownloadGameApk.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                hq9Var2.s(true);
                hq9 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    hq9Var2.y(checkInstallGameApk.f());
                    hq9Var2.u(checkInstallGameApk.b());
                    hq9Var2.o(checkInstallGameApk.a());
                    hq9Var2.x(checkInstallGameApk.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                hq9Var2.s(true);
                hq9 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    hq9Var2.y(startDownloadCss.f());
                    hq9Var2.u(startDownloadCss.b());
                    hq9Var2.o(startDownloadCss.a());
                    hq9Var2.x(startDownloadCss.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                hq9Var2.s(true);
                hq9 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    hq9Var2.y(disableGoBack.f());
                    hq9Var2.u(disableGoBack.b());
                    hq9Var2.o(disableGoBack.a());
                    hq9Var2.x(disableGoBack.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                hq9Var2.s(true);
                hq9 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    hq9Var2.y(supplementInfo.f());
                    hq9Var2.u(supplementInfo.b());
                    hq9Var2.o(supplementInfo.a());
                    hq9Var2.x(supplementInfo.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                hq9Var2.s(true);
                hq9 deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    hq9Var2.y(deviceGyroscopeParams.f());
                    hq9Var2.u(deviceGyroscopeParams.b());
                    hq9Var2.o(deviceGyroscopeParams.a());
                    hq9Var2.x(deviceGyroscopeParams.e());
                    if (!hq9Var2.h()) {
                        i3 = 0;
                        hq9Var2.n(false);
                        addObserver("deviceMotion", hq9Var2, false);
                        hq9Var2.z(i3);
                    }
                }
                i3 = 0;
                hq9Var2.z(i3);
            } else if (b.equals("device/deviceRefreshRate")) {
                hq9Var2.s(true);
                hq9 deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    hq9Var2.y(deviceRefreshRateParams.f());
                    hq9Var2.u(deviceRefreshRateParams.b());
                    hq9Var2.o(deviceRefreshRateParams.a());
                    hq9Var2.x(deviceRefreshRateParams.e());
                    if (!hq9Var2.h()) {
                        i2 = 0;
                        hq9Var2.n(false);
                        addObserver("deviceRefreshRate", hq9Var2, false);
                        hq9Var2.z(i2);
                    }
                }
                i2 = 0;
                hq9Var2.z(i2);
            } else if (b.equals("device/getDeviceInfo")) {
                hq9Var2.s(true);
                hq9 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    hq9Var2.y(deviceInfo.f());
                    hq9Var2.u(deviceInfo.b());
                    hq9Var2.o(deviceInfo.a());
                    hq9Var2.x(deviceInfo.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("activity/completeTask")) {
                hq9Var2.s(true);
                hq9 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    hq9Var2.y(sendCompleteTaskReqMsg.f());
                    hq9Var2.u(sendCompleteTaskReqMsg.b());
                    hq9Var2.o(sendCompleteTaskReqMsg.a());
                    hq9Var2.x(sendCompleteTaskReqMsg.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                hq9Var2.s(true);
                hq9 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    hq9Var2.y(showTipToast.f());
                    hq9Var2.u(showTipToast.b());
                    hq9Var2.o(showTipToast.a());
                    hq9Var2.x(showTipToast.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("toast/getModalData")) {
                hq9Var2.s(true);
                hq9 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    hq9Var2.y(getModalData.f());
                    hq9Var2.u(getModalData.b());
                    hq9Var2.o(getModalData.a());
                    hq9Var2.x(getModalData.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                hq9Var2.s(true);
                hq9 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    hq9Var2.y(openThirdPartApp.f());
                    hq9Var2.u(openThirdPartApp.b());
                    hq9Var2.o(openThirdPartApp.a());
                    hq9Var2.x(openThirdPartApp.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                hq9Var2.s(true);
                hq9 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    hq9Var2.y(jumpToHtmlPage.f());
                    hq9Var2.u(jumpToHtmlPage.b());
                    hq9Var2.o(jumpToHtmlPage.a());
                    hq9Var2.x(jumpToHtmlPage.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                hq9Var2.s(true);
                hq9 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    hq9Var2.y(offlineUserInfo.f());
                    hq9Var2.u(offlineUserInfo.b());
                    hq9Var2.o(offlineUserInfo.a());
                    hq9Var2.x(offlineUserInfo.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                hq9Var2.s(true);
                hq9 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    hq9Var2.y(deleteOfflineBundle.f());
                    hq9Var2.u(deleteOfflineBundle.b());
                    hq9Var2.o(deleteOfflineBundle.a());
                    hq9Var2.x(deleteOfflineBundle.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                hq9Var2.s(true);
                hq9 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    hq9Var2.y(updateOfflineBundle.f());
                    hq9Var2.u(updateOfflineBundle.b());
                    hq9Var2.o(updateOfflineBundle.a());
                    hq9Var2.x(updateOfflineBundle.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                hq9Var2.s(true);
                hq9 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    hq9Var2.y(switchOfflineInterface.f());
                    hq9Var2.u(switchOfflineInterface.b());
                    hq9Var2.o(switchOfflineInterface.a());
                    hq9Var2.x(switchOfflineInterface.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                hq9Var2.s(true);
                hq9 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    hq9Var2.y(switchOfflineBundleStatus.f());
                    hq9Var2.u(switchOfflineBundleStatus.b());
                    hq9Var2.o(switchOfflineBundleStatus.a());
                    hq9Var2.x(switchOfflineBundleStatus.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                hq9Var2.s(true);
                hq9 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    hq9Var2.y(finishTestAnswer.f());
                    hq9Var2.u(finishTestAnswer.b());
                    hq9Var2.o(finishTestAnswer.a());
                    hq9Var2.x(finishTestAnswer.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                hq9Var2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                hq9 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    hq9Var2.y(switchUrlHost.f());
                    hq9Var2.u(switchUrlHost.b());
                    hq9Var2.o(switchUrlHost.a());
                    hq9Var2.x(switchUrlHost.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                hq9Var2.s(true);
                hq9 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    hq9Var2.y(appStorage.f());
                    hq9Var2.u(appStorage.b());
                    hq9Var2.o(appStorage.a());
                    hq9Var2.x(appStorage.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                hq9Var2.s(true);
                hq9 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    hq9Var2.y(putAppStorage.f());
                    hq9Var2.u(putAppStorage.b());
                    hq9Var2.o(putAppStorage.a());
                    hq9Var2.x(putAppStorage.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                hq9Var2.s(true);
                hq9 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    hq9Var2.y(historyForumData.f());
                    hq9Var2.u(historyForumData.b());
                    hq9Var2.o(historyForumData.a());
                    hq9Var2.x(historyForumData.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                hq9Var2.s(true);
                hq9 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    hq9Var2.y(worldCupRaiseSuccess.f());
                    hq9Var2.u(worldCupRaiseSuccess.b());
                    hq9Var2.o(worldCupRaiseSuccess.a());
                    hq9Var2.x(worldCupRaiseSuccess.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                hq9Var2.s(true);
                hq9 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    hq9Var2.y(alipayUserId.f());
                    hq9Var2.u(alipayUserId.b());
                    hq9Var2.o(alipayUserId.a());
                    hq9Var2.x(alipayUserId.e());
                    if (!hq9Var2.h()) {
                        i = 0;
                        hq9Var2.n(false);
                        addObserver("aliAuthResult", hq9Var2, false);
                        hq9Var2.z(i);
                    }
                }
                i = 0;
                hq9Var2.z(i);
            } else if (b.equals("system/getFileDownloadStatus")) {
                hq9Var2.s(true);
                hq9 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    hq9Var2.y(fileDownloadStatus.f());
                    hq9Var2.u(fileDownloadStatus.b());
                    hq9Var2.o(fileDownloadStatus.a());
                    hq9Var2.x(fileDownloadStatus.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                hq9Var2.s(true);
                hq9 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    hq9Var2.y(fileDownloadProgress.f());
                    hq9Var2.u(fileDownloadProgress.b());
                    hq9Var2.o(fileDownloadProgress.a());
                    hq9Var2.x(fileDownloadProgress.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                hq9Var2.s(true);
                hq9 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    hq9Var2.y(fileDownloadPause.f());
                    hq9Var2.u(fileDownloadPause.b());
                    hq9Var2.o(fileDownloadPause.a());
                    hq9Var2.x(fileDownloadPause.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                hq9Var2.s(true);
                hq9 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    hq9Var2.y(fileDownloadDelete.f());
                    hq9Var2.u(fileDownloadDelete.b());
                    hq9Var2.o(fileDownloadDelete.a());
                    hq9Var2.x(fileDownloadDelete.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/installGameApk")) {
                hq9Var2.s(true);
                hq9 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    hq9Var2.y(installGameApk.f());
                    hq9Var2.u(installGameApk.b());
                    hq9Var2.o(installGameApk.a());
                    hq9Var2.x(installGameApk.e());
                }
                hq9Var2.z(0);
            } else if (b.equals("system/launchApk")) {
                hq9Var2.s(true);
                hq9 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    hq9Var2.y(launchApk.f());
                    hq9Var2.u(launchApk.b());
                    hq9Var2.o(launchApk.a());
                    hq9Var2.x(launchApk.e());
                }
                hq9Var2.z(0);
            }
            return hq9Var2;
        }
        return (hq9) invokeLL.objValue;
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
    }

    @Override // com.baidu.tieba.fq9
    public List<hq9> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            hq9 hq9Var = null;
            if (hi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                hq9Var = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                hq9Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                hq9Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                hq9Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                hq9Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                hq9Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                hq9Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                hq9Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                hq9Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                hq9Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                hq9Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                hq9Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                hq9Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                hq9Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                hq9Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                hq9Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                hq9Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                hq9Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                hq9Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                hq9Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                hq9Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                hq9Var = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                hq9Var = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                hq9Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                hq9Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                hq9Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            }
            if (hq9Var != null) {
                hq9Var.z(0);
            }
            List<gq9> list = this.mAsyncCallBackMethodList.get(str);
            if (hq9Var != null && list != null) {
                Iterator<gq9> it = list.iterator();
                if (!hi.isEmpty(hq9Var.e())) {
                    while (it.hasNext()) {
                        gq9 next = it.next();
                        if (next.b().equals(hq9Var.e())) {
                            hq9 hq9Var2 = new hq9();
                            hq9Var2.w(next.a());
                            hq9Var2.y(hq9Var.f());
                            hq9Var2.u(hq9Var.b());
                            hq9Var2.o(hq9Var.a());
                            hq9Var2.A(hq9Var.l());
                            arrayList.add(hq9Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        gq9 next2 = it.next();
                        hq9 hq9Var3 = new hq9();
                        hq9Var3.w(next2.a());
                        hq9Var3.y(hq9Var.f());
                        hq9Var3.u(hq9Var.b());
                        hq9Var3.o(hq9Var.a());
                        hq9Var3.A(hq9Var.l());
                        arrayList.add(hq9Var3);
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
