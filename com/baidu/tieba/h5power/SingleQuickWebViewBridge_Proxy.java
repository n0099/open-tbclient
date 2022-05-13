package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
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
import com.repackage.li;
import com.repackage.qk8;
import com.repackage.rk8;
import com.repackage.sk8;
import com.repackage.uk8;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SingleQuickWebViewBridge_Proxy extends qk8 {
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

    @Override // com.repackage.qk8
    public sk8 dispatch(uk8 uk8Var, sk8 sk8Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uk8Var, sk8Var)) == null) {
            sk8 sk8Var2 = sk8Var == null ? new sk8() : sk8Var;
            String b = uk8Var.b();
            JSONObject e = uk8Var.e();
            if (b.equals("account/startLoginModule")) {
                sk8Var2.r(true);
                sk8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    sk8Var2.x(startLoginModule.f());
                    sk8Var2.t(startLoginModule.b());
                    sk8Var2.o(startLoginModule.a());
                    sk8Var2.w(startLoginModule.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                sk8Var2.r(true);
                sk8 finishPage = this.mJsBridge.finishPage();
                if (finishPage != null) {
                    sk8Var2.x(finishPage.f());
                    sk8Var2.t(finishPage.b());
                    sk8Var2.o(finishPage.a());
                    sk8Var2.w(finishPage.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                sk8Var2.r(true);
                sk8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    sk8Var2.x(showLowerHairHint.f());
                    sk8Var2.t(showLowerHairHint.b());
                    sk8Var2.o(showLowerHairHint.a());
                    sk8Var2.w(showLowerHairHint.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                sk8Var2.r(true);
                sk8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    sk8Var2.x(gamePush.f());
                    sk8Var2.t(gamePush.b());
                    sk8Var2.o(gamePush.a());
                    sk8Var2.w(gamePush.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                sk8Var2.r(true);
                sk8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    sk8Var2.x(handleGamePushStatus.f());
                    sk8Var2.t(handleGamePushStatus.b());
                    sk8Var2.o(handleGamePushStatus.a());
                    sk8Var2.w(handleGamePushStatus.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                sk8Var2.r(true);
                sk8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID));
                if (handleGoToBarDetail != null) {
                    sk8Var2.x(handleGoToBarDetail.f());
                    sk8Var2.t(handleGoToBarDetail.b());
                    sk8Var2.o(handleGoToBarDetail.a());
                    sk8Var2.w(handleGoToBarDetail.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                sk8Var2.r(true);
                sk8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    sk8Var2.x(handleSaveImage.f());
                    sk8Var2.t(handleSaveImage.b());
                    sk8Var2.o(handleSaveImage.a());
                    sk8Var2.w(handleSaveImage.e());
                    if (!sk8Var2.h()) {
                        sk8Var2.n(false);
                        addObserver("saveImageSuccess", sk8Var2, false);
                    }
                }
                sk8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                sk8Var2.r(true);
                sk8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    sk8Var2.x(handleGetPhotoAlbum.f());
                    sk8Var2.t(handleGetPhotoAlbum.b());
                    sk8Var2.o(handleGetPhotoAlbum.a());
                    sk8Var2.w(handleGetPhotoAlbum.e());
                    if (!sk8Var2.h()) {
                        sk8Var2.n(false);
                        addObserver("GetPhotoAlbum", sk8Var2, false);
                    }
                }
                sk8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                sk8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                sk8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    sk8Var2.x(selectPhotoAlbum.f());
                    sk8Var2.t(selectPhotoAlbum.b());
                    sk8Var2.o(selectPhotoAlbum.a());
                    sk8Var2.w(selectPhotoAlbum.e());
                    if (!sk8Var2.h()) {
                        sk8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, sk8Var2, false);
                    }
                }
                sk8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                sk8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                sk8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    sk8Var2.x(selectPrivateMsg.f());
                    sk8Var2.t(selectPrivateMsg.b());
                    sk8Var2.o(selectPrivateMsg.a());
                    sk8Var2.w(selectPrivateMsg.e());
                    if (!sk8Var2.h()) {
                        sk8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", sk8Var2, false);
                    }
                }
                sk8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                sk8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                sk8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    sk8Var2.x(reportUserTheme.f());
                    sk8Var2.t(reportUserTheme.b());
                    sk8Var2.o(reportUserTheme.a());
                    sk8Var2.w(reportUserTheme.e());
                    if (!sk8Var2.h()) {
                        sk8Var2.n(false);
                        addObserver("goToReportThreadPage", sk8Var2, false);
                    }
                }
                sk8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                sk8Var2.r(true);
                sk8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    sk8Var2.x(playSound.f());
                    sk8Var2.t(playSound.b());
                    sk8Var2.o(playSound.a());
                    sk8Var2.w(playSound.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                sk8Var2.r(true);
                sk8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    sk8Var2.x(playVibrate.f());
                    sk8Var2.t(playVibrate.b());
                    sk8Var2.o(playVibrate.a());
                    sk8Var2.w(playVibrate.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                sk8Var2.r(true);
                sk8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    sk8Var2.x(jumpLoginActivity.f());
                    sk8Var2.t(jumpLoginActivity.b());
                    sk8Var2.o(jumpLoginActivity.a());
                    sk8Var2.w(jumpLoginActivity.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                sk8Var2.r(true);
                sk8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    sk8Var2.x(startLoadTimeInterval.f());
                    sk8Var2.t(startLoadTimeInterval.b());
                    sk8Var2.o(startLoadTimeInterval.a());
                    sk8Var2.w(startLoadTimeInterval.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                sk8Var2.r(true);
                sk8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    sk8Var2.x(zid.f());
                    sk8Var2.t(zid.b());
                    sk8Var2.o(zid.a());
                    sk8Var2.w(zid.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                sk8Var2.r(true);
                sk8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    sk8Var2.x(hdid.f());
                    sk8Var2.t(hdid.b());
                    sk8Var2.o(hdid.a());
                    sk8Var2.w(hdid.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                sk8Var2.r(true);
                sk8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    sk8Var2.x(shareInfo.f());
                    sk8Var2.t(shareInfo.b());
                    sk8Var2.o(shareInfo.a());
                    sk8Var2.w(shareInfo.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("share/share")) {
                sk8Var2.r(true);
                sk8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"));
                if (share != null) {
                    sk8Var2.x(share.f());
                    sk8Var2.t(share.b());
                    sk8Var2.o(share.a());
                    sk8Var2.w(share.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                sk8Var2.r(true);
                sk8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    sk8Var2.x(clipperInformation.f());
                    sk8Var2.t(clipperInformation.b());
                    sk8Var2.o(clipperInformation.a());
                    sk8Var2.w(clipperInformation.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                sk8Var2.r(true);
                sk8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    sk8Var2.x(clipperInformation2.f());
                    sk8Var2.t(clipperInformation2.b());
                    sk8Var2.o(clipperInformation2.a());
                    sk8Var2.w(clipperInformation2.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                sk8Var2.r(true);
                sk8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    sk8Var2.x(goToEditPost.f());
                    sk8Var2.t(goToEditPost.b());
                    sk8Var2.o(goToEditPost.a());
                    sk8Var2.w(goToEditPost.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                sk8Var2.r(true);
                sk8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    sk8Var2.x(updateSearchForumInfo.f());
                    sk8Var2.t(updateSearchForumInfo.b());
                    sk8Var2.o(updateSearchForumInfo.a());
                    sk8Var2.w(updateSearchForumInfo.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                sk8Var2.r(true);
                sk8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    sk8Var2.x(personlizedSwitchChange.f());
                    sk8Var2.t(personlizedSwitchChange.b());
                    sk8Var2.o(personlizedSwitchChange.a());
                    sk8Var2.w(personlizedSwitchChange.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                sk8Var2.r(true);
                sk8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    sk8Var2.x(goToVideoImmersivePage.f());
                    sk8Var2.t(goToVideoImmersivePage.b());
                    sk8Var2.o(goToVideoImmersivePage.a());
                    sk8Var2.w(goToVideoImmersivePage.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                sk8Var2.r(true);
                sk8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    sk8Var2.x(jumpToVideo.f());
                    sk8Var2.t(jumpToVideo.b());
                    sk8Var2.o(jumpToVideo.a());
                    sk8Var2.w(jumpToVideo.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                sk8Var2.r(true);
                sk8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    sk8Var2.x(closeNativeMask.f());
                    sk8Var2.t(closeNativeMask.b());
                    sk8Var2.o(closeNativeMask.a());
                    sk8Var2.w(closeNativeMask.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                sk8Var2.r(true);
                sk8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    sk8Var2.x(checkAppInstall.f());
                    sk8Var2.t(checkAppInstall.b());
                    sk8Var2.o(checkAppInstall.a());
                    sk8Var2.w(checkAppInstall.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                sk8Var2.r(true);
                sk8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    sk8Var2.x(disableBack.f());
                    sk8Var2.t(disableBack.b());
                    sk8Var2.o(disableBack.a());
                    sk8Var2.w(disableBack.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                sk8Var2.r(true);
                sk8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    sk8Var2.x(startApp.f());
                    sk8Var2.t(startApp.b());
                    sk8Var2.o(startApp.a());
                    sk8Var2.w(startApp.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                sk8Var2.r(true);
                sk8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    sk8Var2.x(hasNotificationPermission.f());
                    sk8Var2.t(hasNotificationPermission.b());
                    sk8Var2.o(hasNotificationPermission.a());
                    sk8Var2.w(hasNotificationPermission.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                sk8Var2.r(true);
                sk8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    sk8Var2.x(goToNotificationSetting.f());
                    sk8Var2.t(goToNotificationSetting.b());
                    sk8Var2.o(goToNotificationSetting.a());
                    sk8Var2.w(goToNotificationSetting.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                sk8Var2.r(true);
                sk8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    sk8Var2.x(startDownloadCss.f());
                    sk8Var2.t(startDownloadCss.b());
                    sk8Var2.o(startDownloadCss.a());
                    sk8Var2.w(startDownloadCss.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                sk8Var2.r(true);
                sk8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    sk8Var2.x(disableGoBack.f());
                    sk8Var2.t(disableGoBack.b());
                    sk8Var2.o(disableGoBack.a());
                    sk8Var2.w(disableGoBack.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                sk8Var2.r(true);
                sk8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    sk8Var2.x(supplementInfo.f());
                    sk8Var2.t(supplementInfo.b());
                    sk8Var2.o(supplementInfo.a());
                    sk8Var2.w(supplementInfo.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                sk8Var2.r(true);
                sk8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    sk8Var2.x(deviceInfo.f());
                    sk8Var2.t(deviceInfo.b());
                    sk8Var2.o(deviceInfo.a());
                    sk8Var2.w(deviceInfo.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                sk8Var2.r(true);
                sk8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    sk8Var2.x(sendCompleteTaskReqMsg.f());
                    sk8Var2.t(sendCompleteTaskReqMsg.b());
                    sk8Var2.o(sendCompleteTaskReqMsg.a());
                    sk8Var2.w(sendCompleteTaskReqMsg.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                sk8Var2.r(true);
                sk8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    sk8Var2.x(showTipToast.f());
                    sk8Var2.t(showTipToast.b());
                    sk8Var2.o(showTipToast.a());
                    sk8Var2.w(showTipToast.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                sk8Var2.r(true);
                sk8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    sk8Var2.x(getModalData.f());
                    sk8Var2.t(getModalData.b());
                    sk8Var2.o(getModalData.a());
                    sk8Var2.w(getModalData.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                sk8Var2.r(true);
                sk8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    sk8Var2.x(jumpToHtmlPage.f());
                    sk8Var2.t(jumpToHtmlPage.b());
                    sk8Var2.o(jumpToHtmlPage.a());
                    sk8Var2.w(jumpToHtmlPage.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                sk8Var2.r(true);
                sk8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    sk8Var2.x(offlineUserInfo.f());
                    sk8Var2.t(offlineUserInfo.b());
                    sk8Var2.o(offlineUserInfo.a());
                    sk8Var2.w(offlineUserInfo.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                sk8Var2.r(true);
                sk8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    sk8Var2.x(deleteOfflineBundle.f());
                    sk8Var2.t(deleteOfflineBundle.b());
                    sk8Var2.o(deleteOfflineBundle.a());
                    sk8Var2.w(deleteOfflineBundle.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                sk8Var2.r(true);
                sk8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    sk8Var2.x(updateOfflineBundle.f());
                    sk8Var2.t(updateOfflineBundle.b());
                    sk8Var2.o(updateOfflineBundle.a());
                    sk8Var2.w(updateOfflineBundle.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                sk8Var2.r(true);
                sk8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    sk8Var2.x(switchOfflineInterface.f());
                    sk8Var2.t(switchOfflineInterface.b());
                    sk8Var2.o(switchOfflineInterface.a());
                    sk8Var2.w(switchOfflineInterface.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                sk8Var2.r(true);
                sk8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    sk8Var2.x(switchOfflineBundleStatus.f());
                    sk8Var2.t(switchOfflineBundleStatus.b());
                    sk8Var2.o(switchOfflineBundleStatus.a());
                    sk8Var2.w(switchOfflineBundleStatus.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                sk8Var2.r(true);
                sk8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    sk8Var2.x(finishTestAnswer.f());
                    sk8Var2.t(finishTestAnswer.b());
                    sk8Var2.o(finishTestAnswer.a());
                    sk8Var2.w(finishTestAnswer.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                sk8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                sk8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    sk8Var2.x(switchUrlHost.f());
                    sk8Var2.t(switchUrlHost.b());
                    sk8Var2.o(switchUrlHost.a());
                    sk8Var2.w(switchUrlHost.e());
                }
                sk8Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                sk8Var2.r(true);
                sk8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    sk8Var2.x(requestByNative.f());
                    sk8Var2.t(requestByNative.b());
                    sk8Var2.o(requestByNative.a());
                    sk8Var2.w(requestByNative.e());
                    if (!sk8Var2.h()) {
                        i = 0;
                        sk8Var2.n(false);
                        addObserver("RequestByNativeToH5", sk8Var2, false);
                        sk8Var2.y(i);
                    }
                }
                i = 0;
                sk8Var2.y(i);
            }
            return sk8Var2;
        }
        return (sk8) invokeLL.objValue;
    }

    @Override // com.repackage.qk8
    public List<sk8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            sk8 sk8Var = null;
            if (li.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                sk8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                sk8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                sk8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                sk8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                sk8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                sk8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                sk8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                sk8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                sk8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                sk8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                sk8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                sk8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                sk8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                sk8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                sk8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                sk8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (sk8Var != null) {
                sk8Var.y(0);
            }
            List<rk8> list = this.mAsyncCallBackMethodList.get(str);
            if (sk8Var != null && list != null) {
                Iterator<rk8> it = list.iterator();
                if (!li.isEmpty(sk8Var.e())) {
                    while (it.hasNext()) {
                        rk8 next = it.next();
                        if (next.b().equals(sk8Var.e())) {
                            sk8 sk8Var2 = new sk8();
                            sk8Var2.v(next.a());
                            sk8Var2.x(sk8Var.f());
                            sk8Var2.t(sk8Var.b());
                            sk8Var2.o(sk8Var.a());
                            sk8Var2.z(sk8Var.l());
                            arrayList.add(sk8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rk8 next2 = it.next();
                        sk8 sk8Var3 = new sk8();
                        sk8Var3.v(next2.a());
                        sk8Var3.x(sk8Var.f());
                        sk8Var3.t(sk8Var.b());
                        sk8Var3.o(sk8Var.a());
                        sk8Var3.z(sk8Var.l());
                        arrayList.add(sk8Var3);
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
