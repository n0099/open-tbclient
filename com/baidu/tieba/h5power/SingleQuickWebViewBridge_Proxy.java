package com.baidu.tieba.h5power;

import c.a.d.f.p.m;
import c.a.r0.y3.o0.d.a;
import c.a.r0.y3.o0.d.b;
import c.a.r0.y3.o0.d.c;
import c.a.r0.y3.o0.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SingleQuickWebViewBridge_Proxy extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleQuickWebViewBridge mJsBridge;

    public SingleQuickWebViewBridge_Proxy(SingleQuickWebViewBridge singleQuickWebViewBridge) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleQuickWebViewBridge};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = singleQuickWebViewBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("saveImageSuccess");
        this.mNotificationNameList.add("GetPhotoAlbum");
        this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add("getPageLeaveTime");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_SKIN_TYPE);
        this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
        this.mNotificationNameList.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add(CommonTbJsBridge.CLICK_GO_BACK_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.GO_BACK_FROM_NATIVE);
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // c.a.r0.y3.o0.d.a
    public c dispatch(e eVar, c cVar) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, cVar)) == null) {
            c cVar2 = cVar == null ? new c() : cVar;
            String b2 = eVar.b();
            JSONObject e2 = eVar.e();
            if (b2.equals("account/startLoginModule")) {
                cVar2.r(true);
                c startLoginModule = this.mJsBridge.startLoginModule(e2.optString("cssUrl"));
                if (startLoginModule != null) {
                    cVar2.x(startLoginModule.f());
                    cVar2.t(startLoginModule.b());
                    cVar2.o(startLoginModule.a());
                    cVar2.w(startLoginModule.e());
                }
                cVar2.y(0);
            } else if (b2.equals("router/finishThisPage")) {
                cVar2.r(true);
                c finishPage = this.mJsBridge.finishPage();
                if (finishPage != null) {
                    cVar2.x(finishPage.f());
                    cVar2.t(finishPage.b());
                    cVar2.o(finishPage.a());
                    cVar2.w(finishPage.e());
                }
                cVar2.y(0);
            } else if (b2.equals("toast/toastPopupView")) {
                cVar2.r(true);
                c showLowerHairHint = this.mJsBridge.showLowerHairHint(e2.optInt("showType"), e2.optInt("aheadType"), e2.optString("message"), e2.optString("btnText"), e2.optInt("toastDuration"), e2.optString("schema"), e2.optString("token"), e2.optDouble("opacity"), e2.optString("imgUrl"), e2.optString("url"), e2.optInt("missionId"), e2.optString("btnColor"), e2.optString("messageColor"), e2.optString("btnTextColor"), e2.optInt("status"), e2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    cVar2.x(showLowerHairHint.f());
                    cVar2.t(showLowerHairHint.b());
                    cVar2.o(showLowerHairHint.a());
                    cVar2.w(showLowerHairHint.e());
                }
                cVar2.y(0);
            } else if (b2.equals("subscription/gamePush")) {
                cVar2.r(true);
                c gamePush = this.mJsBridge.gamePush(e2.optString("gameId"), e2.optString("gameName"), e2.optString("gameTime"), e2.optString("gameType"));
                if (gamePush != null) {
                    cVar2.x(gamePush.f());
                    cVar2.t(gamePush.b());
                    cVar2.o(gamePush.a());
                    cVar2.w(gamePush.e());
                }
                cVar2.y(0);
            } else if (b2.equals("subscription/gamePushStatus")) {
                cVar2.r(true);
                c handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    cVar2.x(handleGamePushStatus.f());
                    cVar2.t(handleGamePushStatus.b());
                    cVar2.o(handleGamePushStatus.a());
                    cVar2.w(handleGamePushStatus.e());
                }
                cVar2.y(0);
            } else if (b2.equals("router/goToBarDetail")) {
                cVar2.r(true);
                c handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e2.optString(TbTitleActivityConfig.FORUM_ID));
                if (handleGoToBarDetail != null) {
                    cVar2.x(handleGoToBarDetail.f());
                    cVar2.t(handleGoToBarDetail.b());
                    cVar2.o(handleGoToBarDetail.a());
                    cVar2.w(handleGoToBarDetail.e());
                }
                cVar2.y(0);
            } else if (b2.equals("system/saveImage")) {
                cVar2.r(true);
                c handleSaveImage = this.mJsBridge.handleSaveImage(e2.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    cVar2.x(handleSaveImage.f());
                    cVar2.t(handleSaveImage.b());
                    cVar2.o(handleSaveImage.a());
                    cVar2.w(handleSaveImage.e());
                    if (!cVar2.h()) {
                        cVar2.n(false);
                        addObserver("saveImageSuccess", cVar2, false);
                    }
                }
                cVar2.y(0);
            } else if (b2.equals("system/goToPhotoAlbum")) {
                cVar2.r(true);
                c handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    cVar2.x(handleGetPhotoAlbum.f());
                    cVar2.t(handleGetPhotoAlbum.b());
                    cVar2.o(handleGetPhotoAlbum.a());
                    cVar2.w(handleGetPhotoAlbum.e());
                    if (!cVar2.h()) {
                        cVar2.n(false);
                        addObserver("GetPhotoAlbum", cVar2, false);
                    }
                }
                cVar2.y(0);
            } else if (b2.equals("system/selectPhotoAlbum")) {
                cVar2.r(true);
                int optInt = e2.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e2.optJSONArray("imageArray"));
                c selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    cVar2.x(selectPhotoAlbum.f());
                    cVar2.t(selectPhotoAlbum.b());
                    cVar2.o(selectPhotoAlbum.a());
                    cVar2.w(selectPhotoAlbum.e());
                    if (!cVar2.h()) {
                        cVar2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, cVar2, false);
                    }
                }
                cVar2.y(0);
            } else if (b2.equals("router/goToSelectPrivateMsgPage")) {
                cVar2.r(true);
                String optString = e2.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e2.optJSONArray("msgArray"));
                c selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    cVar2.x(selectPrivateMsg.f());
                    cVar2.t(selectPrivateMsg.b());
                    cVar2.o(selectPrivateMsg.a());
                    cVar2.w(selectPrivateMsg.e());
                    if (!cVar2.h()) {
                        cVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", cVar2, false);
                    }
                }
                cVar2.y(0);
            } else if (b2.equals("router/goToReportThreadPage")) {
                cVar2.r(true);
                String optString2 = e2.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e2.optJSONArray("threadArray"));
                c reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    cVar2.x(reportUserTheme.f());
                    cVar2.t(reportUserTheme.b());
                    cVar2.o(reportUserTheme.a());
                    cVar2.w(reportUserTheme.e());
                    if (!cVar2.h()) {
                        cVar2.n(false);
                        addObserver("goToReportThreadPage", cVar2, false);
                    }
                }
                cVar2.y(0);
            } else if (b2.equals("system/playSound")) {
                cVar2.r(true);
                c playSound = this.mJsBridge.playSound(e2.optString("soundUrl"));
                if (playSound != null) {
                    cVar2.x(playSound.f());
                    cVar2.t(playSound.b());
                    cVar2.o(playSound.a());
                    cVar2.w(playSound.e());
                }
                cVar2.y(0);
            } else if (b2.equals("system/playVibrate")) {
                cVar2.r(true);
                c playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    cVar2.x(playVibrate.f());
                    cVar2.t(playVibrate.b());
                    cVar2.o(playVibrate.a());
                    cVar2.w(playVibrate.e());
                }
                cVar2.y(0);
            } else if (b2.equals("account/loadThirdPartyLogin")) {
                cVar2.r(true);
                c jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e2.optInt("socialType"), e2.optString("activityId"));
                if (jumpLoginActivity != null) {
                    cVar2.x(jumpLoginActivity.f());
                    cVar2.t(jumpLoginActivity.b());
                    cVar2.o(jumpLoginActivity.a());
                    cVar2.w(jumpLoginActivity.e());
                }
                cVar2.y(0);
            } else if (b2.equals("system/startLoadTimeInterval")) {
                cVar2.r(true);
                c startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    cVar2.x(startLoadTimeInterval.f());
                    cVar2.t(startLoadTimeInterval.b());
                    cVar2.o(startLoadTimeInterval.a());
                    cVar2.w(startLoadTimeInterval.e());
                }
                cVar2.y(0);
            } else if (b2.equals("device/getZid")) {
                cVar2.r(true);
                c zid = this.mJsBridge.getZid();
                if (zid != null) {
                    cVar2.x(zid.f());
                    cVar2.t(zid.b());
                    cVar2.o(zid.a());
                    cVar2.w(zid.e());
                }
                cVar2.y(0);
            } else if (b2.equals("device/getHdid")) {
                cVar2.r(true);
                c hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    cVar2.x(hdid.f());
                    cVar2.t(hdid.b());
                    cVar2.o(hdid.a());
                    cVar2.w(hdid.e());
                }
                cVar2.y(0);
            } else if (b2.equals("share/registerShareDataNew")) {
                cVar2.r(true);
                c shareInfo = this.mJsBridge.setShareInfo(e2.optString("title"), e2.optString("desc"), e2.optString("img"), e2.optString("url"), e2.optString("topic"), e2.optString("wbtitle"), e2.optString("wbcontent"), e2.optString("isShowMoreForum"), e2.optInt("shareimg"), e2.optString("extdata"));
                if (shareInfo != null) {
                    cVar2.x(shareInfo.f());
                    cVar2.t(shareInfo.b());
                    cVar2.o(shareInfo.a());
                    cVar2.w(shareInfo.e());
                }
                cVar2.y(0);
            } else if (b2.equals("share/share")) {
                cVar2.r(true);
                c share = this.mJsBridge.share(e2.optInt("channel"), e2.optInt("shareImg"), e2.optString("img"), e2.optString("isShowMoreForum"), e2.optString("url"), e2.optString("title"), e2.optString("desc"), e2.optString("topic"), e2.optString("wbtitle"), e2.optString("wbcontent"), e2.optInt("weixinDisable"), e2.optString("extData"));
                if (share != null) {
                    cVar2.x(share.f());
                    cVar2.t(share.b());
                    cVar2.o(share.a());
                    cVar2.w(share.e());
                }
                cVar2.y(0);
            } else if (b2.equals("clipper/getClipperInformation")) {
                cVar2.r(true);
                c clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    cVar2.x(clipperInformation.f());
                    cVar2.t(clipperInformation.b());
                    cVar2.o(clipperInformation.a());
                    cVar2.w(clipperInformation.e());
                }
                cVar2.y(0);
            } else if (b2.equals("clipper/setClipperInformation")) {
                cVar2.r(true);
                c clipperInformation2 = this.mJsBridge.setClipperInformation(e2.optString("txt"));
                if (clipperInformation2 != null) {
                    cVar2.x(clipperInformation2.f());
                    cVar2.t(clipperInformation2.b());
                    cVar2.o(clipperInformation2.a());
                    cVar2.w(clipperInformation2.e());
                }
                cVar2.y(0);
            } else if (b2.equals("router/goToEditPost")) {
                cVar2.r(true);
                c goToEditPost = this.mJsBridge.goToEditPost(e2.optString("pos"), e2.optString("tid"), e2.optString("floorId"), e2.optString("postId"), e2.optString("content"), e2.optString("fid"), e2.optString("fname"));
                if (goToEditPost != null) {
                    cVar2.x(goToEditPost.f());
                    cVar2.t(goToEditPost.b());
                    cVar2.o(goToEditPost.a());
                    cVar2.w(goToEditPost.e());
                }
                cVar2.y(0);
            } else if (b2.equals("activity/updateSearchForumInfo")) {
                cVar2.r(true);
                c updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e2.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    cVar2.x(updateSearchForumInfo.f());
                    cVar2.t(updateSearchForumInfo.b());
                    cVar2.o(updateSearchForumInfo.a());
                    cVar2.w(updateSearchForumInfo.e());
                }
                cVar2.y(0);
            } else if (b2.equals("activity/personlizedSwitchChange")) {
                cVar2.r(true);
                c personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e2.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    cVar2.x(personlizedSwitchChange.f());
                    cVar2.t(personlizedSwitchChange.b());
                    cVar2.o(personlizedSwitchChange.a());
                    cVar2.w(personlizedSwitchChange.e());
                }
                cVar2.y(0);
            } else if (b2.equals("router/videoImmersivePage")) {
                cVar2.r(true);
                c goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e2.optString("threadId"), e2.optString("postId"), e2.optString("title"), e2.optString(TbEnum.SystemMessage.KEY_USER_NAME), e2.optString("nickName"), e2.optString("portrait"), e2.optString("thumbnailUrl"), e2.optString("videoUrl"), e2.optString("videoWidth"), e2.optString("videoHeight"), e2.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e2.optString("postNum"), e2.optString("agreeNum"), e2.optString("shareNum"), e2.optString(TbTitleActivityConfig.FORUM_ID), e2.optString("forumName"), e2.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    cVar2.x(goToVideoImmersivePage.f());
                    cVar2.t(goToVideoImmersivePage.b());
                    cVar2.o(goToVideoImmersivePage.a());
                    cVar2.w(goToVideoImmersivePage.e());
                }
                cVar2.y(0);
            } else if (b2.equals("router/jumpToVideo")) {
                cVar2.r(true);
                c jumpToVideo = this.mJsBridge.jumpToVideo(e2.optString("videoTopic"), e2.optString("videoTopicID"), e2.optString("isVideo"));
                if (jumpToVideo != null) {
                    cVar2.x(jumpToVideo.f());
                    cVar2.t(jumpToVideo.b());
                    cVar2.o(jumpToVideo.a());
                    cVar2.w(jumpToVideo.e());
                }
                cVar2.y(0);
            } else if (b2.equals("system/closeNativeMask")) {
                cVar2.r(true);
                c closeNativeMask = this.mJsBridge.closeNativeMask(e2.optInt("result"));
                if (closeNativeMask != null) {
                    cVar2.x(closeNativeMask.f());
                    cVar2.t(closeNativeMask.b());
                    cVar2.o(closeNativeMask.a());
                    cVar2.w(closeNativeMask.e());
                }
                cVar2.y(0);
            } else if (b2.equals("system/checkAppInstall")) {
                cVar2.r(true);
                c checkAppInstall = this.mJsBridge.checkAppInstall(e2.optString("pkgName"));
                if (checkAppInstall != null) {
                    cVar2.x(checkAppInstall.f());
                    cVar2.t(checkAppInstall.b());
                    cVar2.o(checkAppInstall.a());
                    cVar2.w(checkAppInstall.e());
                }
                cVar2.y(0);
            } else if (b2.equals("system/disableSlideBack")) {
                cVar2.r(true);
                c disableBack = this.mJsBridge.disableBack(e2.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    cVar2.x(disableBack.f());
                    cVar2.t(disableBack.b());
                    cVar2.o(disableBack.a());
                    cVar2.w(disableBack.e());
                }
                cVar2.y(0);
            } else if (b2.equals("system/startApp")) {
                cVar2.r(true);
                c startApp = this.mJsBridge.startApp(e2.optString("pkgName"), e2.optString("schema"));
                if (startApp != null) {
                    cVar2.x(startApp.f());
                    cVar2.t(startApp.b());
                    cVar2.o(startApp.a());
                    cVar2.w(startApp.e());
                }
                cVar2.y(0);
            } else if (b2.equals("system/hasNotificationPermission")) {
                cVar2.r(true);
                c hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    cVar2.x(hasNotificationPermission.f());
                    cVar2.t(hasNotificationPermission.b());
                    cVar2.o(hasNotificationPermission.a());
                    cVar2.w(hasNotificationPermission.e());
                }
                cVar2.y(0);
            } else if (b2.equals("system/goToNotificationSetting")) {
                cVar2.r(true);
                c goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    cVar2.x(goToNotificationSetting.f());
                    cVar2.t(goToNotificationSetting.b());
                    cVar2.o(goToNotificationSetting.a());
                    cVar2.w(goToNotificationSetting.e());
                }
                cVar2.y(0);
            } else if (b2.equals("account/startDownloadCss")) {
                cVar2.r(true);
                c startDownloadCss = this.mJsBridge.startDownloadCss(e2.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    cVar2.x(startDownloadCss.f());
                    cVar2.t(startDownloadCss.b());
                    cVar2.o(startDownloadCss.a());
                    cVar2.w(startDownloadCss.e());
                }
                cVar2.y(0);
            } else if (b2.equals("navigationBar/isDisableGoBack")) {
                cVar2.r(true);
                c disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    cVar2.x(disableGoBack.f());
                    cVar2.t(disableGoBack.b());
                    cVar2.o(disableGoBack.a());
                    cVar2.w(disableGoBack.e());
                }
                cVar2.y(0);
            } else if (b2.equals("device/getSupplementInfo")) {
                cVar2.r(true);
                c supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    cVar2.x(supplementInfo.f());
                    cVar2.t(supplementInfo.b());
                    cVar2.o(supplementInfo.a());
                    cVar2.w(supplementInfo.e());
                }
                cVar2.y(0);
            } else if (b2.equals("device/getDeviceInfo")) {
                cVar2.r(true);
                c deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    cVar2.x(deviceInfo.f());
                    cVar2.t(deviceInfo.b());
                    cVar2.o(deviceInfo.a());
                    cVar2.w(deviceInfo.e());
                }
                cVar2.y(0);
            } else if (b2.equals("activity/completeTask")) {
                cVar2.r(true);
                c sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e2.optString("activityId"), e2.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    cVar2.x(sendCompleteTaskReqMsg.f());
                    cVar2.t(sendCompleteTaskReqMsg.b());
                    cVar2.o(sendCompleteTaskReqMsg.a());
                    cVar2.w(sendCompleteTaskReqMsg.e());
                }
                cVar2.y(0);
            } else if (b2.equals("toast/showTipToast")) {
                cVar2.r(true);
                c showTipToast = this.mJsBridge.showTipToast(e2.optString("content"), e2.optString("linkUrl"), e2.optString("key"), e2.optInt("maxTimes"), e2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    cVar2.x(showTipToast.f());
                    cVar2.t(showTipToast.b());
                    cVar2.o(showTipToast.a());
                    cVar2.w(showTipToast.e());
                }
                cVar2.y(0);
            } else if (b2.equals("toast/getModalData")) {
                cVar2.r(true);
                c getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    cVar2.x(getModalData.f());
                    cVar2.t(getModalData.b());
                    cVar2.o(getModalData.a());
                    cVar2.w(getModalData.e());
                }
                cVar2.y(0);
            } else if (b2.equals("router/jumpToHTMLPage")) {
                cVar2.r(true);
                c jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e2.optString("url"), e2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    cVar2.x(jumpToHtmlPage.f());
                    cVar2.t(jumpToHtmlPage.b());
                    cVar2.o(jumpToHtmlPage.a());
                    cVar2.w(jumpToHtmlPage.e());
                }
                cVar2.y(0);
            } else if (b2.equals("hybridDebug/getOfflineUserInfo")) {
                cVar2.r(true);
                c offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    cVar2.x(offlineUserInfo.f());
                    cVar2.t(offlineUserInfo.b());
                    cVar2.o(offlineUserInfo.a());
                    cVar2.w(offlineUserInfo.e());
                }
                cVar2.y(0);
            } else if (b2.equals("hybridDebug/deleteOfflineBundle")) {
                cVar2.r(true);
                c deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    cVar2.x(deleteOfflineBundle.f());
                    cVar2.t(deleteOfflineBundle.b());
                    cVar2.o(deleteOfflineBundle.a());
                    cVar2.w(deleteOfflineBundle.e());
                }
                cVar2.y(0);
            } else if (b2.equals("hybridDebug/updateOfflineBundle")) {
                cVar2.r(true);
                c updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    cVar2.x(updateOfflineBundle.f());
                    cVar2.t(updateOfflineBundle.b());
                    cVar2.o(updateOfflineBundle.a());
                    cVar2.w(updateOfflineBundle.e());
                }
                cVar2.y(0);
            } else if (b2.equals("hybridDebug/switchOfflineInterface")) {
                cVar2.r(true);
                c switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e2.optString("host"));
                if (switchOfflineInterface != null) {
                    cVar2.x(switchOfflineInterface.f());
                    cVar2.t(switchOfflineInterface.b());
                    cVar2.o(switchOfflineInterface.a());
                    cVar2.w(switchOfflineInterface.e());
                }
                cVar2.y(0);
            } else if (b2.equals("hybridDebug/switchOfflineBundleStatus")) {
                cVar2.r(true);
                c switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e2.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    cVar2.x(switchOfflineBundleStatus.f());
                    cVar2.t(switchOfflineBundleStatus.b());
                    cVar2.o(switchOfflineBundleStatus.a());
                    cVar2.w(switchOfflineBundleStatus.e());
                }
                cVar2.y(0);
            } else if (b2.equals("activity/finishTestAnswer")) {
                cVar2.r(true);
                c finishTestAnswer = this.mJsBridge.finishTestAnswer(e2.optLong("testId"));
                if (finishTestAnswer != null) {
                    cVar2.x(finishTestAnswer.f());
                    cVar2.t(finishTestAnswer.b());
                    cVar2.o(finishTestAnswer.a());
                    cVar2.w(finishTestAnswer.e());
                }
                cVar2.y(0);
            } else if (b2.equals("hybridDebug/switchUrlHost")) {
                cVar2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e2.optJSONArray("hostArr"));
                c switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    cVar2.x(switchUrlHost.f());
                    cVar2.t(switchUrlHost.b());
                    cVar2.o(switchUrlHost.a());
                    cVar2.w(switchUrlHost.e());
                }
                cVar2.y(0);
            } else if (b2.equals("hybrid/requestByNativeNew")) {
                cVar2.r(true);
                c requestByNative = this.mJsBridge.requestByNative(e2.optString("url"), e2.optString("type"), e2.optString("module"), e2.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    cVar2.x(requestByNative.f());
                    cVar2.t(requestByNative.b());
                    cVar2.o(requestByNative.a());
                    cVar2.w(requestByNative.e());
                    if (!cVar2.h()) {
                        i2 = 0;
                        cVar2.n(false);
                        addObserver("RequestByNativeToH5", cVar2, false);
                        cVar2.y(i2);
                    }
                }
                i2 = 0;
                cVar2.y(i2);
            }
            return cVar2;
        }
        return (c) invokeLL.objValue;
    }

    @Override // c.a.r0.y3.o0.d.a
    public List<c> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            c cVar = null;
            if (m.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                cVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                cVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                cVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                cVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                cVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                cVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                cVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                cVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                cVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                cVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                cVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                cVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                cVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                cVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                cVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                cVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (cVar != null) {
                cVar.y(0);
            }
            List<b> list = this.mAsyncCallBackMethodList.get(str);
            if (cVar != null && list != null) {
                Iterator<b> it = list.iterator();
                if (!m.isEmpty(cVar.e())) {
                    while (it.hasNext()) {
                        b next = it.next();
                        if (next.b().equals(cVar.e())) {
                            c cVar2 = new c();
                            cVar2.v(next.a());
                            cVar2.x(cVar.f());
                            cVar2.t(cVar.b());
                            cVar2.o(cVar.a());
                            cVar2.z(cVar.l());
                            arrayList.add(cVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        b next2 = it.next();
                        c cVar3 = new c();
                        cVar3.v(next2.a());
                        cVar3.x(cVar.f());
                        cVar3.t(cVar.b());
                        cVar3.o(cVar.a());
                        cVar3.z(cVar.l());
                        arrayList.add(cVar3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
