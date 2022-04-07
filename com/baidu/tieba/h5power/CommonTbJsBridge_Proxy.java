package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.ml8;
import com.repackage.ni;
import com.repackage.nl8;
import com.repackage.ol8;
import com.repackage.ql8;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommonTbJsBridge_Proxy extends ml8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

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
    }

    @Override // com.repackage.ml8
    public ol8 dispatch(ql8 ql8Var, ol8 ol8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ql8Var, ol8Var)) == null) {
            ol8 ol8Var2 = ol8Var == null ? new ol8() : ol8Var;
            String b = ql8Var.b();
            JSONObject e = ql8Var.e();
            if (b.equals("account/startLoginModule")) {
                ol8Var2.r(true);
                ol8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    ol8Var2.x(startLoginModule.f());
                    ol8Var2.t(startLoginModule.b());
                    ol8Var2.o(startLoginModule.a());
                    ol8Var2.w(startLoginModule.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                ol8Var2.r(true);
                ol8 finishPage = this.mJsBridge.finishPage();
                if (finishPage != null) {
                    ol8Var2.x(finishPage.f());
                    ol8Var2.t(finishPage.b());
                    ol8Var2.o(finishPage.a());
                    ol8Var2.w(finishPage.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                ol8Var2.r(true);
                ol8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    ol8Var2.x(showLowerHairHint.f());
                    ol8Var2.t(showLowerHairHint.b());
                    ol8Var2.o(showLowerHairHint.a());
                    ol8Var2.w(showLowerHairHint.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                ol8Var2.r(true);
                ol8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    ol8Var2.x(gamePush.f());
                    ol8Var2.t(gamePush.b());
                    ol8Var2.o(gamePush.a());
                    ol8Var2.w(gamePush.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                ol8Var2.r(true);
                ol8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    ol8Var2.x(handleGamePushStatus.f());
                    ol8Var2.t(handleGamePushStatus.b());
                    ol8Var2.o(handleGamePushStatus.a());
                    ol8Var2.w(handleGamePushStatus.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                ol8Var2.r(true);
                ol8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID));
                if (handleGoToBarDetail != null) {
                    ol8Var2.x(handleGoToBarDetail.f());
                    ol8Var2.t(handleGoToBarDetail.b());
                    ol8Var2.o(handleGoToBarDetail.a());
                    ol8Var2.w(handleGoToBarDetail.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                ol8Var2.r(true);
                ol8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    ol8Var2.x(handleSaveImage.f());
                    ol8Var2.t(handleSaveImage.b());
                    ol8Var2.o(handleSaveImage.a());
                    ol8Var2.w(handleSaveImage.e());
                    if (!ol8Var2.h()) {
                        ol8Var2.n(false);
                        addObserver("saveImageSuccess", ol8Var2, false);
                    }
                }
                ol8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                ol8Var2.r(true);
                ol8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    ol8Var2.x(handleGetPhotoAlbum.f());
                    ol8Var2.t(handleGetPhotoAlbum.b());
                    ol8Var2.o(handleGetPhotoAlbum.a());
                    ol8Var2.w(handleGetPhotoAlbum.e());
                    if (!ol8Var2.h()) {
                        ol8Var2.n(false);
                        addObserver("GetPhotoAlbum", ol8Var2, false);
                    }
                }
                ol8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                ol8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                ol8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    ol8Var2.x(selectPhotoAlbum.f());
                    ol8Var2.t(selectPhotoAlbum.b());
                    ol8Var2.o(selectPhotoAlbum.a());
                    ol8Var2.w(selectPhotoAlbum.e());
                    if (!ol8Var2.h()) {
                        ol8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, ol8Var2, false);
                    }
                }
                ol8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                ol8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                ol8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    ol8Var2.x(selectPrivateMsg.f());
                    ol8Var2.t(selectPrivateMsg.b());
                    ol8Var2.o(selectPrivateMsg.a());
                    ol8Var2.w(selectPrivateMsg.e());
                    if (!ol8Var2.h()) {
                        ol8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", ol8Var2, false);
                    }
                }
                ol8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                ol8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                ol8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    ol8Var2.x(reportUserTheme.f());
                    ol8Var2.t(reportUserTheme.b());
                    ol8Var2.o(reportUserTheme.a());
                    ol8Var2.w(reportUserTheme.e());
                    if (!ol8Var2.h()) {
                        ol8Var2.n(false);
                        addObserver("goToReportThreadPage", ol8Var2, false);
                    }
                }
                ol8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                ol8Var2.r(true);
                ol8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    ol8Var2.x(playSound.f());
                    ol8Var2.t(playSound.b());
                    ol8Var2.o(playSound.a());
                    ol8Var2.w(playSound.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                ol8Var2.r(true);
                ol8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    ol8Var2.x(playVibrate.f());
                    ol8Var2.t(playVibrate.b());
                    ol8Var2.o(playVibrate.a());
                    ol8Var2.w(playVibrate.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                ol8Var2.r(true);
                ol8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    ol8Var2.x(jumpLoginActivity.f());
                    ol8Var2.t(jumpLoginActivity.b());
                    ol8Var2.o(jumpLoginActivity.a());
                    ol8Var2.w(jumpLoginActivity.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                ol8Var2.r(true);
                ol8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    ol8Var2.x(startLoadTimeInterval.f());
                    ol8Var2.t(startLoadTimeInterval.b());
                    ol8Var2.o(startLoadTimeInterval.a());
                    ol8Var2.w(startLoadTimeInterval.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                ol8Var2.r(true);
                ol8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    ol8Var2.x(zid.f());
                    ol8Var2.t(zid.b());
                    ol8Var2.o(zid.a());
                    ol8Var2.w(zid.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                ol8Var2.r(true);
                ol8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    ol8Var2.x(hdid.f());
                    ol8Var2.t(hdid.b());
                    ol8Var2.o(hdid.a());
                    ol8Var2.w(hdid.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                ol8Var2.r(true);
                ol8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    ol8Var2.x(shareInfo.f());
                    ol8Var2.t(shareInfo.b());
                    ol8Var2.o(shareInfo.a());
                    ol8Var2.w(shareInfo.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("share/share")) {
                ol8Var2.r(true);
                ol8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"));
                if (share != null) {
                    ol8Var2.x(share.f());
                    ol8Var2.t(share.b());
                    ol8Var2.o(share.a());
                    ol8Var2.w(share.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                ol8Var2.r(true);
                ol8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    ol8Var2.x(clipperInformation.f());
                    ol8Var2.t(clipperInformation.b());
                    ol8Var2.o(clipperInformation.a());
                    ol8Var2.w(clipperInformation.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                ol8Var2.r(true);
                ol8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    ol8Var2.x(clipperInformation2.f());
                    ol8Var2.t(clipperInformation2.b());
                    ol8Var2.o(clipperInformation2.a());
                    ol8Var2.w(clipperInformation2.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                ol8Var2.r(true);
                ol8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    ol8Var2.x(goToEditPost.f());
                    ol8Var2.t(goToEditPost.b());
                    ol8Var2.o(goToEditPost.a());
                    ol8Var2.w(goToEditPost.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                ol8Var2.r(true);
                ol8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    ol8Var2.x(updateSearchForumInfo.f());
                    ol8Var2.t(updateSearchForumInfo.b());
                    ol8Var2.o(updateSearchForumInfo.a());
                    ol8Var2.w(updateSearchForumInfo.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                ol8Var2.r(true);
                ol8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    ol8Var2.x(personlizedSwitchChange.f());
                    ol8Var2.t(personlizedSwitchChange.b());
                    ol8Var2.o(personlizedSwitchChange.a());
                    ol8Var2.w(personlizedSwitchChange.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                ol8Var2.r(true);
                ol8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    ol8Var2.x(goToVideoImmersivePage.f());
                    ol8Var2.t(goToVideoImmersivePage.b());
                    ol8Var2.o(goToVideoImmersivePage.a());
                    ol8Var2.w(goToVideoImmersivePage.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                ol8Var2.r(true);
                ol8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    ol8Var2.x(jumpToVideo.f());
                    ol8Var2.t(jumpToVideo.b());
                    ol8Var2.o(jumpToVideo.a());
                    ol8Var2.w(jumpToVideo.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                ol8Var2.r(true);
                ol8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    ol8Var2.x(closeNativeMask.f());
                    ol8Var2.t(closeNativeMask.b());
                    ol8Var2.o(closeNativeMask.a());
                    ol8Var2.w(closeNativeMask.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                ol8Var2.r(true);
                ol8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    ol8Var2.x(checkAppInstall.f());
                    ol8Var2.t(checkAppInstall.b());
                    ol8Var2.o(checkAppInstall.a());
                    ol8Var2.w(checkAppInstall.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                ol8Var2.r(true);
                ol8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    ol8Var2.x(disableBack.f());
                    ol8Var2.t(disableBack.b());
                    ol8Var2.o(disableBack.a());
                    ol8Var2.w(disableBack.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                ol8Var2.r(true);
                ol8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    ol8Var2.x(startApp.f());
                    ol8Var2.t(startApp.b());
                    ol8Var2.o(startApp.a());
                    ol8Var2.w(startApp.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                ol8Var2.r(true);
                ol8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    ol8Var2.x(hasNotificationPermission.f());
                    ol8Var2.t(hasNotificationPermission.b());
                    ol8Var2.o(hasNotificationPermission.a());
                    ol8Var2.w(hasNotificationPermission.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                ol8Var2.r(true);
                ol8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    ol8Var2.x(goToNotificationSetting.f());
                    ol8Var2.t(goToNotificationSetting.b());
                    ol8Var2.o(goToNotificationSetting.a());
                    ol8Var2.w(goToNotificationSetting.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                ol8Var2.r(true);
                ol8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    ol8Var2.x(startDownloadCss.f());
                    ol8Var2.t(startDownloadCss.b());
                    ol8Var2.o(startDownloadCss.a());
                    ol8Var2.w(startDownloadCss.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                ol8Var2.r(true);
                ol8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    ol8Var2.x(disableGoBack.f());
                    ol8Var2.t(disableGoBack.b());
                    ol8Var2.o(disableGoBack.a());
                    ol8Var2.w(disableGoBack.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                ol8Var2.r(true);
                ol8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    ol8Var2.x(supplementInfo.f());
                    ol8Var2.t(supplementInfo.b());
                    ol8Var2.o(supplementInfo.a());
                    ol8Var2.w(supplementInfo.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                ol8Var2.r(true);
                ol8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    ol8Var2.x(deviceInfo.f());
                    ol8Var2.t(deviceInfo.b());
                    ol8Var2.o(deviceInfo.a());
                    ol8Var2.w(deviceInfo.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                ol8Var2.r(true);
                ol8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    ol8Var2.x(sendCompleteTaskReqMsg.f());
                    ol8Var2.t(sendCompleteTaskReqMsg.b());
                    ol8Var2.o(sendCompleteTaskReqMsg.a());
                    ol8Var2.w(sendCompleteTaskReqMsg.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                ol8Var2.r(true);
                ol8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    ol8Var2.x(showTipToast.f());
                    ol8Var2.t(showTipToast.b());
                    ol8Var2.o(showTipToast.a());
                    ol8Var2.w(showTipToast.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                ol8Var2.r(true);
                ol8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    ol8Var2.x(getModalData.f());
                    ol8Var2.t(getModalData.b());
                    ol8Var2.o(getModalData.a());
                    ol8Var2.w(getModalData.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                ol8Var2.r(true);
                ol8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    ol8Var2.x(jumpToHtmlPage.f());
                    ol8Var2.t(jumpToHtmlPage.b());
                    ol8Var2.o(jumpToHtmlPage.a());
                    ol8Var2.w(jumpToHtmlPage.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                ol8Var2.r(true);
                ol8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    ol8Var2.x(offlineUserInfo.f());
                    ol8Var2.t(offlineUserInfo.b());
                    ol8Var2.o(offlineUserInfo.a());
                    ol8Var2.w(offlineUserInfo.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                ol8Var2.r(true);
                ol8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    ol8Var2.x(deleteOfflineBundle.f());
                    ol8Var2.t(deleteOfflineBundle.b());
                    ol8Var2.o(deleteOfflineBundle.a());
                    ol8Var2.w(deleteOfflineBundle.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                ol8Var2.r(true);
                ol8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    ol8Var2.x(updateOfflineBundle.f());
                    ol8Var2.t(updateOfflineBundle.b());
                    ol8Var2.o(updateOfflineBundle.a());
                    ol8Var2.w(updateOfflineBundle.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                ol8Var2.r(true);
                ol8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    ol8Var2.x(switchOfflineInterface.f());
                    ol8Var2.t(switchOfflineInterface.b());
                    ol8Var2.o(switchOfflineInterface.a());
                    ol8Var2.w(switchOfflineInterface.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                ol8Var2.r(true);
                ol8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    ol8Var2.x(switchOfflineBundleStatus.f());
                    ol8Var2.t(switchOfflineBundleStatus.b());
                    ol8Var2.o(switchOfflineBundleStatus.a());
                    ol8Var2.w(switchOfflineBundleStatus.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                ol8Var2.r(true);
                ol8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    ol8Var2.x(finishTestAnswer.f());
                    ol8Var2.t(finishTestAnswer.b());
                    ol8Var2.o(finishTestAnswer.a());
                    ol8Var2.w(finishTestAnswer.e());
                }
                ol8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                ol8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                ol8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    ol8Var2.x(switchUrlHost.f());
                    ol8Var2.t(switchUrlHost.b());
                    ol8Var2.o(switchUrlHost.a());
                    ol8Var2.w(switchUrlHost.e());
                }
                ol8Var2.y(0);
            }
            return ol8Var2;
        }
        return (ol8) invokeLL.objValue;
    }

    @Override // com.repackage.ml8
    public List<ol8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            ol8 ol8Var = null;
            if (ni.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                ol8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                ol8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                ol8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                ol8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                ol8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                ol8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                ol8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                ol8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                ol8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                ol8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                ol8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                ol8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                ol8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                ol8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                ol8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            }
            if (ol8Var != null) {
                ol8Var.y(0);
            }
            List<nl8> list = this.mAsyncCallBackMethodList.get(str);
            if (ol8Var != null && list != null) {
                Iterator<nl8> it = list.iterator();
                if (!ni.isEmpty(ol8Var.e())) {
                    while (it.hasNext()) {
                        nl8 next = it.next();
                        if (next.b().equals(ol8Var.e())) {
                            ol8 ol8Var2 = new ol8();
                            ol8Var2.v(next.a());
                            ol8Var2.x(ol8Var.f());
                            ol8Var2.t(ol8Var.b());
                            ol8Var2.o(ol8Var.a());
                            ol8Var2.z(ol8Var.l());
                            arrayList.add(ol8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        nl8 next2 = it.next();
                        ol8 ol8Var3 = new ol8();
                        ol8Var3.v(next2.a());
                        ol8Var3.x(ol8Var.f());
                        ol8Var3.t(ol8Var.b());
                        ol8Var3.o(ol8Var.a());
                        ol8Var3.z(ol8Var.l());
                        arrayList.add(ol8Var3);
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
