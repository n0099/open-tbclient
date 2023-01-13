package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.alipay.sdk.sys.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.by8;
import com.baidu.tieba.xx8;
import com.baidu.tieba.yi;
import com.baidu.tieba.yx8;
import com.baidu.tieba.zx8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.PushManager;
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
public class CommonTbJsBridge_Proxy extends xx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.xx8
    public zx8 dispatch(by8 by8Var, zx8 zx8Var) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, by8Var, zx8Var)) == null) {
            zx8 zx8Var2 = zx8Var == null ? new zx8() : zx8Var;
            String b = by8Var.b();
            JSONObject e = by8Var.e();
            if (b.equals("account/startLoginModule")) {
                zx8Var2.r(true);
                zx8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    zx8Var2.x(startLoginModule.f());
                    zx8Var2.t(startLoginModule.b());
                    zx8Var2.o(startLoginModule.a());
                    zx8Var2.w(startLoginModule.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                zx8Var2.r(true);
                zx8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    zx8Var2.x(finishPage.f());
                    zx8Var2.t(finishPage.b());
                    zx8Var2.o(finishPage.a());
                    zx8Var2.w(finishPage.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                zx8Var2.r(true);
                zx8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    zx8Var2.x(showLowerHairHint.f());
                    zx8Var2.t(showLowerHairHint.b());
                    zx8Var2.o(showLowerHairHint.a());
                    zx8Var2.w(showLowerHairHint.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                zx8Var2.r(true);
                zx8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    zx8Var2.x(gamePush.f());
                    zx8Var2.t(gamePush.b());
                    zx8Var2.o(gamePush.a());
                    zx8Var2.w(gamePush.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                zx8Var2.r(true);
                zx8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    zx8Var2.x(handleGamePushStatus.f());
                    zx8Var2.t(handleGamePushStatus.b());
                    zx8Var2.o(handleGamePushStatus.a());
                    zx8Var2.w(handleGamePushStatus.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                zx8Var2.r(true);
                zx8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    zx8Var2.x(jumpForumRulesEditPage.f());
                    zx8Var2.t(jumpForumRulesEditPage.b());
                    zx8Var2.o(jumpForumRulesEditPage.a());
                    zx8Var2.w(jumpForumRulesEditPage.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                zx8Var2.r(true);
                zx8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    zx8Var2.x(handleGoToBarDetail.f());
                    zx8Var2.t(handleGoToBarDetail.b());
                    zx8Var2.o(handleGoToBarDetail.a());
                    zx8Var2.w(handleGoToBarDetail.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                zx8Var2.r(true);
                zx8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    zx8Var2.x(handleSaveImage.f());
                    zx8Var2.t(handleSaveImage.b());
                    zx8Var2.o(handleSaveImage.a());
                    zx8Var2.w(handleSaveImage.e());
                    if (!zx8Var2.h()) {
                        zx8Var2.n(false);
                        addObserver("saveImageSuccess", zx8Var2, false);
                    }
                }
                zx8Var2.y(0);
            } else if (b.equals("system/orderGameApk")) {
                zx8Var2.r(true);
                zx8 orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    zx8Var2.x(orderGameApk.f());
                    zx8Var2.t(orderGameApk.b());
                    zx8Var2.o(orderGameApk.a());
                    zx8Var2.w(orderGameApk.e());
                    if (!zx8Var2.h()) {
                        zx8Var2.n(false);
                        addObserver("orderGameApkResult", zx8Var2, false);
                    }
                }
                zx8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                zx8Var2.r(true);
                zx8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    zx8Var2.x(handleGetPhotoAlbum.f());
                    zx8Var2.t(handleGetPhotoAlbum.b());
                    zx8Var2.o(handleGetPhotoAlbum.a());
                    zx8Var2.w(handleGetPhotoAlbum.e());
                    if (!zx8Var2.h()) {
                        zx8Var2.n(false);
                        addObserver("GetPhotoAlbum", zx8Var2, false);
                    }
                }
                zx8Var2.y(0);
            } else if (b.equals("host/preheatWeb")) {
                zx8Var2.r(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                zx8 preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    zx8Var2.x(preheatWeb.f());
                    zx8Var2.t(preheatWeb.b());
                    zx8Var2.o(preheatWeb.a());
                    zx8Var2.w(preheatWeb.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                zx8Var2.r(true);
                zx8 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    zx8Var2.x(openMXDYab.f());
                    zx8Var2.t(openMXDYab.b());
                    zx8Var2.o(openMXDYab.a());
                    zx8Var2.w(openMXDYab.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/portal")) {
                zx8Var2.r(true);
                zx8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    zx8Var2.x(handlePortal.f());
                    zx8Var2.t(handlePortal.b());
                    zx8Var2.o(handlePortal.a());
                    zx8Var2.w(handlePortal.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                zx8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                zx8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    zx8Var2.x(selectPhotoAlbum.f());
                    zx8Var2.t(selectPhotoAlbum.b());
                    zx8Var2.o(selectPhotoAlbum.a());
                    zx8Var2.w(selectPhotoAlbum.e());
                    if (!zx8Var2.h()) {
                        zx8Var2.n(false);
                        addObserver("selectPhotoAlbum", zx8Var2, false);
                    }
                }
                zx8Var2.y(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                zx8Var2.r(true);
                zx8 operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"));
                this.mNotificationNameList.add("notifyNativeRefresh");
                if (operateNotifyDataChanged != null) {
                    zx8Var2.x(operateNotifyDataChanged.f());
                    zx8Var2.t(operateNotifyDataChanged.b());
                    zx8Var2.o(operateNotifyDataChanged.a());
                    zx8Var2.w(operateNotifyDataChanged.e());
                    if (!zx8Var2.h()) {
                        zx8Var2.n(false);
                        addObserver("notifyNativeRefresh", zx8Var2, false);
                    }
                }
                zx8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                zx8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                zx8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    zx8Var2.x(selectPrivateMsg.f());
                    zx8Var2.t(selectPrivateMsg.b());
                    zx8Var2.o(selectPrivateMsg.a());
                    zx8Var2.w(selectPrivateMsg.e());
                    if (!zx8Var2.h()) {
                        i3 = 0;
                        zx8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", zx8Var2, false);
                        zx8Var2.y(i3);
                    }
                }
                i3 = 0;
                zx8Var2.y(i3);
            } else if (b.equals("router/goToReportThreadPage")) {
                zx8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                zx8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    zx8Var2.x(reportUserTheme.f());
                    zx8Var2.t(reportUserTheme.b());
                    zx8Var2.o(reportUserTheme.a());
                    zx8Var2.w(reportUserTheme.e());
                    if (!zx8Var2.h()) {
                        i2 = 0;
                        zx8Var2.n(false);
                        addObserver("goToReportThreadPage", zx8Var2, false);
                        zx8Var2.y(i2);
                    }
                }
                i2 = 0;
                zx8Var2.y(i2);
            } else if (b.equals("system/playSound")) {
                zx8Var2.r(true);
                zx8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    zx8Var2.x(playSound.f());
                    zx8Var2.t(playSound.b());
                    zx8Var2.o(playSound.a());
                    zx8Var2.w(playSound.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                zx8Var2.r(true);
                zx8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    zx8Var2.x(playVibrate.f());
                    zx8Var2.t(playVibrate.b());
                    zx8Var2.o(playVibrate.a());
                    zx8Var2.w(playVibrate.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                zx8Var2.r(true);
                zx8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    zx8Var2.x(jumpLoginActivity.f());
                    zx8Var2.t(jumpLoginActivity.b());
                    zx8Var2.o(jumpLoginActivity.a());
                    zx8Var2.w(jumpLoginActivity.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                zx8Var2.r(true);
                zx8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    zx8Var2.x(startLoadTimeInterval.f());
                    zx8Var2.t(startLoadTimeInterval.b());
                    zx8Var2.o(startLoadTimeInterval.a());
                    zx8Var2.w(startLoadTimeInterval.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                zx8Var2.r(true);
                zx8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    zx8Var2.x(zid.f());
                    zx8Var2.t(zid.b());
                    zx8Var2.o(zid.a());
                    zx8Var2.w(zid.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                zx8Var2.r(true);
                zx8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    zx8Var2.x(hdid.f());
                    zx8Var2.t(hdid.b());
                    zx8Var2.o(hdid.a());
                    zx8Var2.w(hdid.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                zx8Var2.r(true);
                zx8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    zx8Var2.x(shareInfo.f());
                    zx8Var2.t(shareInfo.b());
                    zx8Var2.o(shareInfo.a());
                    zx8Var2.w(shareInfo.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("share/share")) {
                zx8Var2.r(true);
                zx8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"));
                if (share != null) {
                    zx8Var2.x(share.f());
                    zx8Var2.t(share.b());
                    zx8Var2.o(share.a());
                    zx8Var2.w(share.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                zx8Var2.r(true);
                zx8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    zx8Var2.x(clipperInformation.f());
                    zx8Var2.t(clipperInformation.b());
                    zx8Var2.o(clipperInformation.a());
                    zx8Var2.w(clipperInformation.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                zx8Var2.r(true);
                zx8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    zx8Var2.x(clipperInformation2.f());
                    zx8Var2.t(clipperInformation2.b());
                    zx8Var2.o(clipperInformation2.a());
                    zx8Var2.w(clipperInformation2.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                zx8Var2.r(true);
                zx8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    zx8Var2.x(goToEditPost.f());
                    zx8Var2.t(goToEditPost.b());
                    zx8Var2.o(goToEditPost.a());
                    zx8Var2.w(goToEditPost.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                zx8Var2.r(true);
                zx8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    zx8Var2.x(updateSearchForumInfo.f());
                    zx8Var2.t(updateSearchForumInfo.b());
                    zx8Var2.o(updateSearchForumInfo.a());
                    zx8Var2.w(updateSearchForumInfo.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                zx8Var2.r(true);
                zx8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    zx8Var2.x(personlizedSwitchChange.f());
                    zx8Var2.t(personlizedSwitchChange.b());
                    zx8Var2.o(personlizedSwitchChange.a());
                    zx8Var2.w(personlizedSwitchChange.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("activity/updateTailStyle")) {
                zx8Var2.r(true);
                zx8 updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    zx8Var2.x(updateTailStyle.f());
                    zx8Var2.t(updateTailStyle.b());
                    zx8Var2.o(updateTailStyle.a());
                    zx8Var2.w(updateTailStyle.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                zx8Var2.r(true);
                zx8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    zx8Var2.x(goToVideoImmersivePage.f());
                    zx8Var2.t(goToVideoImmersivePage.b());
                    zx8Var2.o(goToVideoImmersivePage.a());
                    zx8Var2.w(goToVideoImmersivePage.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                zx8Var2.r(true);
                zx8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    zx8Var2.x(jumpToVideo.f());
                    zx8Var2.t(jumpToVideo.b());
                    zx8Var2.o(jumpToVideo.a());
                    zx8Var2.w(jumpToVideo.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                zx8Var2.r(true);
                zx8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    zx8Var2.x(closeNativeMask.f());
                    zx8Var2.t(closeNativeMask.b());
                    zx8Var2.o(closeNativeMask.a());
                    zx8Var2.w(closeNativeMask.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                zx8Var2.r(true);
                zx8 oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    zx8Var2.x(oneKeyDeletion.f());
                    zx8Var2.t(oneKeyDeletion.b());
                    zx8Var2.o(oneKeyDeletion.a());
                    zx8Var2.w(oneKeyDeletion.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                zx8Var2.r(true);
                zx8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    zx8Var2.x(checkAppInstall.f());
                    zx8Var2.t(checkAppInstall.b());
                    zx8Var2.o(checkAppInstall.a());
                    zx8Var2.w(checkAppInstall.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                zx8Var2.r(true);
                zx8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    zx8Var2.x(disableBack.f());
                    zx8Var2.t(disableBack.b());
                    zx8Var2.o(disableBack.a());
                    zx8Var2.w(disableBack.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                zx8Var2.r(true);
                zx8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    zx8Var2.x(startApp.f());
                    zx8Var2.t(startApp.b());
                    zx8Var2.o(startApp.a());
                    zx8Var2.w(startApp.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                zx8Var2.r(true);
                zx8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    zx8Var2.x(hasNotificationPermission.f());
                    zx8Var2.t(hasNotificationPermission.b());
                    zx8Var2.o(hasNotificationPermission.a());
                    zx8Var2.w(hasNotificationPermission.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                zx8Var2.r(true);
                zx8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    zx8Var2.x(goToNotificationSetting.f());
                    zx8Var2.t(goToNotificationSetting.b());
                    zx8Var2.o(goToNotificationSetting.a());
                    zx8Var2.w(goToNotificationSetting.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/downloadGameApk")) {
                zx8Var2.r(true);
                zx8 startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushManager.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString(a.v));
                if (startDownloadGameApk != null) {
                    zx8Var2.x(startDownloadGameApk.f());
                    zx8Var2.t(startDownloadGameApk.b());
                    zx8Var2.o(startDownloadGameApk.a());
                    zx8Var2.w(startDownloadGameApk.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                zx8Var2.r(true);
                zx8 checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    zx8Var2.x(checkInstallGameApk.f());
                    zx8Var2.t(checkInstallGameApk.b());
                    zx8Var2.o(checkInstallGameApk.a());
                    zx8Var2.w(checkInstallGameApk.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                zx8Var2.r(true);
                zx8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    zx8Var2.x(startDownloadCss.f());
                    zx8Var2.t(startDownloadCss.b());
                    zx8Var2.o(startDownloadCss.a());
                    zx8Var2.w(startDownloadCss.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                zx8Var2.r(true);
                zx8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    zx8Var2.x(disableGoBack.f());
                    zx8Var2.t(disableGoBack.b());
                    zx8Var2.o(disableGoBack.a());
                    zx8Var2.w(disableGoBack.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                zx8Var2.r(true);
                zx8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    zx8Var2.x(supplementInfo.f());
                    zx8Var2.t(supplementInfo.b());
                    zx8Var2.o(supplementInfo.a());
                    zx8Var2.w(supplementInfo.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                zx8Var2.r(true);
                zx8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    zx8Var2.x(deviceInfo.f());
                    zx8Var2.t(deviceInfo.b());
                    zx8Var2.o(deviceInfo.a());
                    zx8Var2.w(deviceInfo.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                zx8Var2.r(true);
                zx8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    zx8Var2.x(sendCompleteTaskReqMsg.f());
                    zx8Var2.t(sendCompleteTaskReqMsg.b());
                    zx8Var2.o(sendCompleteTaskReqMsg.a());
                    zx8Var2.w(sendCompleteTaskReqMsg.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                zx8Var2.r(true);
                zx8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    zx8Var2.x(showTipToast.f());
                    zx8Var2.t(showTipToast.b());
                    zx8Var2.o(showTipToast.a());
                    zx8Var2.w(showTipToast.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                zx8Var2.r(true);
                zx8 getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    zx8Var2.x(getModalData.f());
                    zx8Var2.t(getModalData.b());
                    zx8Var2.o(getModalData.a());
                    zx8Var2.w(getModalData.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                zx8Var2.r(true);
                zx8 openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    zx8Var2.x(openThirdPartApp.f());
                    zx8Var2.t(openThirdPartApp.b());
                    zx8Var2.o(openThirdPartApp.a());
                    zx8Var2.w(openThirdPartApp.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                zx8Var2.r(true);
                zx8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    zx8Var2.x(jumpToHtmlPage.f());
                    zx8Var2.t(jumpToHtmlPage.b());
                    zx8Var2.o(jumpToHtmlPage.a());
                    zx8Var2.w(jumpToHtmlPage.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                zx8Var2.r(true);
                zx8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    zx8Var2.x(offlineUserInfo.f());
                    zx8Var2.t(offlineUserInfo.b());
                    zx8Var2.o(offlineUserInfo.a());
                    zx8Var2.w(offlineUserInfo.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                zx8Var2.r(true);
                zx8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    zx8Var2.x(deleteOfflineBundle.f());
                    zx8Var2.t(deleteOfflineBundle.b());
                    zx8Var2.o(deleteOfflineBundle.a());
                    zx8Var2.w(deleteOfflineBundle.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                zx8Var2.r(true);
                zx8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    zx8Var2.x(updateOfflineBundle.f());
                    zx8Var2.t(updateOfflineBundle.b());
                    zx8Var2.o(updateOfflineBundle.a());
                    zx8Var2.w(updateOfflineBundle.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                zx8Var2.r(true);
                zx8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    zx8Var2.x(switchOfflineInterface.f());
                    zx8Var2.t(switchOfflineInterface.b());
                    zx8Var2.o(switchOfflineInterface.a());
                    zx8Var2.w(switchOfflineInterface.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                zx8Var2.r(true);
                zx8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    zx8Var2.x(switchOfflineBundleStatus.f());
                    zx8Var2.t(switchOfflineBundleStatus.b());
                    zx8Var2.o(switchOfflineBundleStatus.a());
                    zx8Var2.w(switchOfflineBundleStatus.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                zx8Var2.r(true);
                zx8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    zx8Var2.x(finishTestAnswer.f());
                    zx8Var2.t(finishTestAnswer.b());
                    zx8Var2.o(finishTestAnswer.a());
                    zx8Var2.w(finishTestAnswer.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                zx8Var2.r(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                zx8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    zx8Var2.x(switchUrlHost.f());
                    zx8Var2.t(switchUrlHost.b());
                    zx8Var2.o(switchUrlHost.a());
                    zx8Var2.w(switchUrlHost.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                zx8Var2.r(true);
                zx8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    zx8Var2.x(appStorage.f());
                    zx8Var2.t(appStorage.b());
                    zx8Var2.o(appStorage.a());
                    zx8Var2.w(appStorage.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                zx8Var2.r(true);
                zx8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    zx8Var2.x(putAppStorage.f());
                    zx8Var2.t(putAppStorage.b());
                    zx8Var2.o(putAppStorage.a());
                    zx8Var2.w(putAppStorage.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/getHistoryForumData")) {
                zx8Var2.r(true);
                zx8 historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    zx8Var2.x(historyForumData.f());
                    zx8Var2.t(historyForumData.b());
                    zx8Var2.o(historyForumData.a());
                    zx8Var2.w(historyForumData.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                zx8Var2.r(true);
                zx8 worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    zx8Var2.x(worldCupRaiseSuccess.f());
                    zx8Var2.t(worldCupRaiseSuccess.b());
                    zx8Var2.o(worldCupRaiseSuccess.a());
                    zx8Var2.w(worldCupRaiseSuccess.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("account/getAlipayUserId")) {
                zx8Var2.r(true);
                zx8 alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    zx8Var2.x(alipayUserId.f());
                    zx8Var2.t(alipayUserId.b());
                    zx8Var2.o(alipayUserId.a());
                    zx8Var2.w(alipayUserId.e());
                    if (!zx8Var2.h()) {
                        i = 0;
                        zx8Var2.n(false);
                        addObserver("aliAuthResult", zx8Var2, false);
                        zx8Var2.y(i);
                    }
                }
                i = 0;
                zx8Var2.y(i);
            } else if (b.equals("system/getFileDownloadStatus")) {
                zx8Var2.r(true);
                zx8 fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString(a.v));
                if (fileDownloadStatus != null) {
                    zx8Var2.x(fileDownloadStatus.f());
                    zx8Var2.t(fileDownloadStatus.b());
                    zx8Var2.o(fileDownloadStatus.a());
                    zx8Var2.w(fileDownloadStatus.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                zx8Var2.r(true);
                zx8 fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optString(a.v));
                if (fileDownloadProgress != null) {
                    zx8Var2.x(fileDownloadProgress.f());
                    zx8Var2.t(fileDownloadProgress.b());
                    zx8Var2.o(fileDownloadProgress.a());
                    zx8Var2.w(fileDownloadProgress.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/fileDownloadPause")) {
                zx8Var2.r(true);
                zx8 fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString(a.v));
                if (fileDownloadPause != null) {
                    zx8Var2.x(fileDownloadPause.f());
                    zx8Var2.t(fileDownloadPause.b());
                    zx8Var2.o(fileDownloadPause.a());
                    zx8Var2.w(fileDownloadPause.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                zx8Var2.r(true);
                zx8 fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString(CommonTbJsBridge.FILE_DOWNLOAD_FILE_NAME), e.optString("fileVersion"), e.optInt("source"), e.optString(a.v));
                if (fileDownloadDelete != null) {
                    zx8Var2.x(fileDownloadDelete.f());
                    zx8Var2.t(fileDownloadDelete.b());
                    zx8Var2.o(fileDownloadDelete.a());
                    zx8Var2.w(fileDownloadDelete.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/installGameApk")) {
                zx8Var2.r(true);
                zx8 installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString(a.v));
                if (installGameApk != null) {
                    zx8Var2.x(installGameApk.f());
                    zx8Var2.t(installGameApk.b());
                    zx8Var2.o(installGameApk.a());
                    zx8Var2.w(installGameApk.e());
                }
                zx8Var2.y(0);
            } else if (b.equals("system/launchApk")) {
                zx8Var2.r(true);
                zx8 launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString(a.v));
                if (launchApk != null) {
                    zx8Var2.x(launchApk.f());
                    zx8Var2.t(launchApk.b());
                    zx8Var2.o(launchApk.a());
                    zx8Var2.w(launchApk.e());
                }
                zx8Var2.y(0);
            }
            return zx8Var2;
        }
        return (zx8) invokeLL.objValue;
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
        hashSet.add("saveImageSuccess");
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
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT);
        this.mNotificationNameList.add(CommonTbJsBridge.INSTALL_APK_RESULT);
    }

    @Override // com.baidu.tieba.xx8
    public List<zx8> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            zx8 zx8Var = null;
            if (yi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                zx8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                zx8Var = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                zx8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                zx8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                zx8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                zx8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                zx8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                zx8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                zx8Var = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                zx8Var = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                zx8Var = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                zx8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                zx8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                zx8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                zx8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                zx8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                zx8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                zx8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                zx8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                zx8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("aliAuthResult")) {
                zx8Var = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                zx8Var = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                zx8Var = this.mJsBridge.notifyApkInstallResult(hashMap);
            }
            if (zx8Var != null) {
                zx8Var.y(0);
            }
            List<yx8> list = this.mAsyncCallBackMethodList.get(str);
            if (zx8Var != null && list != null) {
                Iterator<yx8> it = list.iterator();
                if (!yi.isEmpty(zx8Var.e())) {
                    while (it.hasNext()) {
                        yx8 next = it.next();
                        if (next.b().equals(zx8Var.e())) {
                            zx8 zx8Var2 = new zx8();
                            zx8Var2.v(next.a());
                            zx8Var2.x(zx8Var.f());
                            zx8Var2.t(zx8Var.b());
                            zx8Var2.o(zx8Var.a());
                            zx8Var2.z(zx8Var.l());
                            arrayList.add(zx8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        yx8 next2 = it.next();
                        zx8 zx8Var3 = new zx8();
                        zx8Var3.v(next2.a());
                        zx8Var3.x(zx8Var.f());
                        zx8Var3.t(zx8Var.b());
                        zx8Var3.o(zx8Var.a());
                        zx8Var3.z(zx8Var.l());
                        arrayList.add(zx8Var3);
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
