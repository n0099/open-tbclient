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
import com.repackage.ki;
import com.repackage.rh8;
import com.repackage.sh8;
import com.repackage.th8;
import com.repackage.vh8;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommonTbJsBridge_Proxy extends rh8 {
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
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
        this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
        this.mNotificationNameList.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add(CommonTbJsBridge.CLICK_GO_BACK_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.GO_BACK_FROM_NATIVE);
    }

    @Override // com.repackage.rh8
    public th8 dispatch(vh8 vh8Var, th8 th8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vh8Var, th8Var)) == null) {
            th8 th8Var2 = th8Var == null ? new th8() : th8Var;
            String b = vh8Var.b();
            JSONObject e = vh8Var.e();
            if (b.equals("account/startLoginModule")) {
                th8Var2.r(true);
                th8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    th8Var2.x(startLoginModule.f());
                    th8Var2.t(startLoginModule.b());
                    th8Var2.o(startLoginModule.a());
                    th8Var2.w(startLoginModule.e());
                }
                th8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                th8Var2.r(true);
                th8 finishPage = this.mJsBridge.finishPage();
                if (finishPage != null) {
                    th8Var2.x(finishPage.f());
                    th8Var2.t(finishPage.b());
                    th8Var2.o(finishPage.a());
                    th8Var2.w(finishPage.e());
                }
                th8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                th8Var2.r(true);
                th8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    th8Var2.x(showLowerHairHint.f());
                    th8Var2.t(showLowerHairHint.b());
                    th8Var2.o(showLowerHairHint.a());
                    th8Var2.w(showLowerHairHint.e());
                }
                th8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                th8Var2.r(true);
                th8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    th8Var2.x(gamePush.f());
                    th8Var2.t(gamePush.b());
                    th8Var2.o(gamePush.a());
                    th8Var2.w(gamePush.e());
                }
                th8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                th8Var2.r(true);
                th8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    th8Var2.x(handleGamePushStatus.f());
                    th8Var2.t(handleGamePushStatus.b());
                    th8Var2.o(handleGamePushStatus.a());
                    th8Var2.w(handleGamePushStatus.e());
                }
                th8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                th8Var2.r(true);
                th8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    th8Var2.x(jumpForumRulesEditPage.f());
                    th8Var2.t(jumpForumRulesEditPage.b());
                    th8Var2.o(jumpForumRulesEditPage.a());
                    th8Var2.w(jumpForumRulesEditPage.e());
                }
                th8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                th8Var2.r(true);
                th8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    th8Var2.x(handleGoToBarDetail.f());
                    th8Var2.t(handleGoToBarDetail.b());
                    th8Var2.o(handleGoToBarDetail.a());
                    th8Var2.w(handleGoToBarDetail.e());
                }
                th8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                th8Var2.r(true);
                th8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    th8Var2.x(handleSaveImage.f());
                    th8Var2.t(handleSaveImage.b());
                    th8Var2.o(handleSaveImage.a());
                    th8Var2.w(handleSaveImage.e());
                    if (!th8Var2.h()) {
                        th8Var2.n(false);
                        addObserver("saveImageSuccess", th8Var2, false);
                    }
                }
                th8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                th8Var2.r(true);
                th8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    th8Var2.x(handleGetPhotoAlbum.f());
                    th8Var2.t(handleGetPhotoAlbum.b());
                    th8Var2.o(handleGetPhotoAlbum.a());
                    th8Var2.w(handleGetPhotoAlbum.e());
                    if (!th8Var2.h()) {
                        th8Var2.n(false);
                        addObserver("GetPhotoAlbum", th8Var2, false);
                    }
                }
                th8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                th8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                th8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    th8Var2.x(selectPhotoAlbum.f());
                    th8Var2.t(selectPhotoAlbum.b());
                    th8Var2.o(selectPhotoAlbum.a());
                    th8Var2.w(selectPhotoAlbum.e());
                    if (!th8Var2.h()) {
                        th8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, th8Var2, false);
                    }
                }
                th8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                th8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                th8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    th8Var2.x(selectPrivateMsg.f());
                    th8Var2.t(selectPrivateMsg.b());
                    th8Var2.o(selectPrivateMsg.a());
                    th8Var2.w(selectPrivateMsg.e());
                    if (!th8Var2.h()) {
                        th8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", th8Var2, false);
                    }
                }
                th8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                th8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                th8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    th8Var2.x(reportUserTheme.f());
                    th8Var2.t(reportUserTheme.b());
                    th8Var2.o(reportUserTheme.a());
                    th8Var2.w(reportUserTheme.e());
                    if (!th8Var2.h()) {
                        th8Var2.n(false);
                        addObserver("goToReportThreadPage", th8Var2, false);
                    }
                }
                th8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                th8Var2.r(true);
                th8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    th8Var2.x(playSound.f());
                    th8Var2.t(playSound.b());
                    th8Var2.o(playSound.a());
                    th8Var2.w(playSound.e());
                }
                th8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                th8Var2.r(true);
                th8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    th8Var2.x(playVibrate.f());
                    th8Var2.t(playVibrate.b());
                    th8Var2.o(playVibrate.a());
                    th8Var2.w(playVibrate.e());
                }
                th8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                th8Var2.r(true);
                th8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    th8Var2.x(jumpLoginActivity.f());
                    th8Var2.t(jumpLoginActivity.b());
                    th8Var2.o(jumpLoginActivity.a());
                    th8Var2.w(jumpLoginActivity.e());
                }
                th8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                th8Var2.r(true);
                th8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    th8Var2.x(startLoadTimeInterval.f());
                    th8Var2.t(startLoadTimeInterval.b());
                    th8Var2.o(startLoadTimeInterval.a());
                    th8Var2.w(startLoadTimeInterval.e());
                }
                th8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                th8Var2.r(true);
                th8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    th8Var2.x(zid.f());
                    th8Var2.t(zid.b());
                    th8Var2.o(zid.a());
                    th8Var2.w(zid.e());
                }
                th8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                th8Var2.r(true);
                th8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    th8Var2.x(hdid.f());
                    th8Var2.t(hdid.b());
                    th8Var2.o(hdid.a());
                    th8Var2.w(hdid.e());
                }
                th8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                th8Var2.r(true);
                th8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    th8Var2.x(shareInfo.f());
                    th8Var2.t(shareInfo.b());
                    th8Var2.o(shareInfo.a());
                    th8Var2.w(shareInfo.e());
                }
                th8Var2.y(0);
            } else if (b.equals("share/share")) {
                th8Var2.r(true);
                th8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"));
                if (share != null) {
                    th8Var2.x(share.f());
                    th8Var2.t(share.b());
                    th8Var2.o(share.a());
                    th8Var2.w(share.e());
                }
                th8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                th8Var2.r(true);
                th8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    th8Var2.x(clipperInformation.f());
                    th8Var2.t(clipperInformation.b());
                    th8Var2.o(clipperInformation.a());
                    th8Var2.w(clipperInformation.e());
                }
                th8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                th8Var2.r(true);
                th8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    th8Var2.x(clipperInformation2.f());
                    th8Var2.t(clipperInformation2.b());
                    th8Var2.o(clipperInformation2.a());
                    th8Var2.w(clipperInformation2.e());
                }
                th8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                th8Var2.r(true);
                th8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    th8Var2.x(goToEditPost.f());
                    th8Var2.t(goToEditPost.b());
                    th8Var2.o(goToEditPost.a());
                    th8Var2.w(goToEditPost.e());
                }
                th8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                th8Var2.r(true);
                th8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    th8Var2.x(updateSearchForumInfo.f());
                    th8Var2.t(updateSearchForumInfo.b());
                    th8Var2.o(updateSearchForumInfo.a());
                    th8Var2.w(updateSearchForumInfo.e());
                }
                th8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                th8Var2.r(true);
                th8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    th8Var2.x(personlizedSwitchChange.f());
                    th8Var2.t(personlizedSwitchChange.b());
                    th8Var2.o(personlizedSwitchChange.a());
                    th8Var2.w(personlizedSwitchChange.e());
                }
                th8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                th8Var2.r(true);
                th8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    th8Var2.x(goToVideoImmersivePage.f());
                    th8Var2.t(goToVideoImmersivePage.b());
                    th8Var2.o(goToVideoImmersivePage.a());
                    th8Var2.w(goToVideoImmersivePage.e());
                }
                th8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                th8Var2.r(true);
                th8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    th8Var2.x(jumpToVideo.f());
                    th8Var2.t(jumpToVideo.b());
                    th8Var2.o(jumpToVideo.a());
                    th8Var2.w(jumpToVideo.e());
                }
                th8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                th8Var2.r(true);
                th8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    th8Var2.x(closeNativeMask.f());
                    th8Var2.t(closeNativeMask.b());
                    th8Var2.o(closeNativeMask.a());
                    th8Var2.w(closeNativeMask.e());
                }
                th8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                th8Var2.r(true);
                th8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    th8Var2.x(checkAppInstall.f());
                    th8Var2.t(checkAppInstall.b());
                    th8Var2.o(checkAppInstall.a());
                    th8Var2.w(checkAppInstall.e());
                }
                th8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                th8Var2.r(true);
                th8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    th8Var2.x(disableBack.f());
                    th8Var2.t(disableBack.b());
                    th8Var2.o(disableBack.a());
                    th8Var2.w(disableBack.e());
                }
                th8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                th8Var2.r(true);
                th8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    th8Var2.x(startApp.f());
                    th8Var2.t(startApp.b());
                    th8Var2.o(startApp.a());
                    th8Var2.w(startApp.e());
                }
                th8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                th8Var2.r(true);
                th8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    th8Var2.x(hasNotificationPermission.f());
                    th8Var2.t(hasNotificationPermission.b());
                    th8Var2.o(hasNotificationPermission.a());
                    th8Var2.w(hasNotificationPermission.e());
                }
                th8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                th8Var2.r(true);
                th8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    th8Var2.x(goToNotificationSetting.f());
                    th8Var2.t(goToNotificationSetting.b());
                    th8Var2.o(goToNotificationSetting.a());
                    th8Var2.w(goToNotificationSetting.e());
                }
                th8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                th8Var2.r(true);
                th8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    th8Var2.x(startDownloadCss.f());
                    th8Var2.t(startDownloadCss.b());
                    th8Var2.o(startDownloadCss.a());
                    th8Var2.w(startDownloadCss.e());
                }
                th8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                th8Var2.r(true);
                th8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    th8Var2.x(disableGoBack.f());
                    th8Var2.t(disableGoBack.b());
                    th8Var2.o(disableGoBack.a());
                    th8Var2.w(disableGoBack.e());
                }
                th8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                th8Var2.r(true);
                th8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    th8Var2.x(supplementInfo.f());
                    th8Var2.t(supplementInfo.b());
                    th8Var2.o(supplementInfo.a());
                    th8Var2.w(supplementInfo.e());
                }
                th8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                th8Var2.r(true);
                th8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    th8Var2.x(deviceInfo.f());
                    th8Var2.t(deviceInfo.b());
                    th8Var2.o(deviceInfo.a());
                    th8Var2.w(deviceInfo.e());
                }
                th8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                th8Var2.r(true);
                th8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    th8Var2.x(sendCompleteTaskReqMsg.f());
                    th8Var2.t(sendCompleteTaskReqMsg.b());
                    th8Var2.o(sendCompleteTaskReqMsg.a());
                    th8Var2.w(sendCompleteTaskReqMsg.e());
                }
                th8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                th8Var2.r(true);
                th8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    th8Var2.x(showTipToast.f());
                    th8Var2.t(showTipToast.b());
                    th8Var2.o(showTipToast.a());
                    th8Var2.w(showTipToast.e());
                }
                th8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                th8Var2.r(true);
                th8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    th8Var2.x(getModalData.f());
                    th8Var2.t(getModalData.b());
                    th8Var2.o(getModalData.a());
                    th8Var2.w(getModalData.e());
                }
                th8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                th8Var2.r(true);
                th8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    th8Var2.x(jumpToHtmlPage.f());
                    th8Var2.t(jumpToHtmlPage.b());
                    th8Var2.o(jumpToHtmlPage.a());
                    th8Var2.w(jumpToHtmlPage.e());
                }
                th8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                th8Var2.r(true);
                th8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    th8Var2.x(offlineUserInfo.f());
                    th8Var2.t(offlineUserInfo.b());
                    th8Var2.o(offlineUserInfo.a());
                    th8Var2.w(offlineUserInfo.e());
                }
                th8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                th8Var2.r(true);
                th8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    th8Var2.x(deleteOfflineBundle.f());
                    th8Var2.t(deleteOfflineBundle.b());
                    th8Var2.o(deleteOfflineBundle.a());
                    th8Var2.w(deleteOfflineBundle.e());
                }
                th8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                th8Var2.r(true);
                th8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    th8Var2.x(updateOfflineBundle.f());
                    th8Var2.t(updateOfflineBundle.b());
                    th8Var2.o(updateOfflineBundle.a());
                    th8Var2.w(updateOfflineBundle.e());
                }
                th8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                th8Var2.r(true);
                th8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    th8Var2.x(switchOfflineInterface.f());
                    th8Var2.t(switchOfflineInterface.b());
                    th8Var2.o(switchOfflineInterface.a());
                    th8Var2.w(switchOfflineInterface.e());
                }
                th8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                th8Var2.r(true);
                th8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    th8Var2.x(switchOfflineBundleStatus.f());
                    th8Var2.t(switchOfflineBundleStatus.b());
                    th8Var2.o(switchOfflineBundleStatus.a());
                    th8Var2.w(switchOfflineBundleStatus.e());
                }
                th8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                th8Var2.r(true);
                th8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    th8Var2.x(finishTestAnswer.f());
                    th8Var2.t(finishTestAnswer.b());
                    th8Var2.o(finishTestAnswer.a());
                    th8Var2.w(finishTestAnswer.e());
                }
                th8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                th8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                th8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    th8Var2.x(switchUrlHost.f());
                    th8Var2.t(switchUrlHost.b());
                    th8Var2.o(switchUrlHost.a());
                    th8Var2.w(switchUrlHost.e());
                }
                th8Var2.y(0);
            }
            return th8Var2;
        }
        return (th8) invokeLL.objValue;
    }

    @Override // com.repackage.rh8
    public List<th8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            th8 th8Var = null;
            if (ki.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                th8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                th8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                th8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                th8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                th8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                th8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                th8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                th8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                th8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                th8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                th8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                th8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                th8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                th8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                th8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                th8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            }
            if (th8Var != null) {
                th8Var.y(0);
            }
            List<sh8> list = this.mAsyncCallBackMethodList.get(str);
            if (th8Var != null && list != null) {
                Iterator<sh8> it = list.iterator();
                if (!ki.isEmpty(th8Var.e())) {
                    while (it.hasNext()) {
                        sh8 next = it.next();
                        if (next.b().equals(th8Var.e())) {
                            th8 th8Var2 = new th8();
                            th8Var2.v(next.a());
                            th8Var2.x(th8Var.f());
                            th8Var2.t(th8Var.b());
                            th8Var2.o(th8Var.a());
                            th8Var2.z(th8Var.l());
                            arrayList.add(th8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        sh8 next2 = it.next();
                        th8 th8Var3 = new th8();
                        th8Var3.v(next2.a());
                        th8Var3.x(th8Var.f());
                        th8Var3.t(th8Var.b());
                        th8Var3.o(th8Var.a());
                        th8Var3.z(th8Var.l());
                        arrayList.add(th8Var3);
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
