package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.am8;
import com.baidu.tieba.cm8;
import com.baidu.tieba.qi;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.yl8;
import com.baidu.tieba.zl8;
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
/* loaded from: classes4.dex */
public class SingleQuickWebViewBridge_Proxy extends yl8 {
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
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
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

    @Override // com.baidu.tieba.yl8
    public am8 dispatch(cm8 cm8Var, am8 am8Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cm8Var, am8Var)) == null) {
            am8 am8Var2 = am8Var == null ? new am8() : am8Var;
            String b = cm8Var.b();
            JSONObject e = cm8Var.e();
            if (b.equals("account/startLoginModule")) {
                am8Var2.r(true);
                am8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    am8Var2.x(startLoginModule.f());
                    am8Var2.t(startLoginModule.b());
                    am8Var2.o(startLoginModule.a());
                    am8Var2.w(startLoginModule.e());
                }
                am8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                am8Var2.r(true);
                am8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    am8Var2.x(finishPage.f());
                    am8Var2.t(finishPage.b());
                    am8Var2.o(finishPage.a());
                    am8Var2.w(finishPage.e());
                }
                am8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                am8Var2.r(true);
                am8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    am8Var2.x(showLowerHairHint.f());
                    am8Var2.t(showLowerHairHint.b());
                    am8Var2.o(showLowerHairHint.a());
                    am8Var2.w(showLowerHairHint.e());
                }
                am8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                am8Var2.r(true);
                am8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    am8Var2.x(gamePush.f());
                    am8Var2.t(gamePush.b());
                    am8Var2.o(gamePush.a());
                    am8Var2.w(gamePush.e());
                }
                am8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                am8Var2.r(true);
                am8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    am8Var2.x(handleGamePushStatus.f());
                    am8Var2.t(handleGamePushStatus.b());
                    am8Var2.o(handleGamePushStatus.a());
                    am8Var2.w(handleGamePushStatus.e());
                }
                am8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                am8Var2.r(true);
                am8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    am8Var2.x(jumpForumRulesEditPage.f());
                    am8Var2.t(jumpForumRulesEditPage.b());
                    am8Var2.o(jumpForumRulesEditPage.a());
                    am8Var2.w(jumpForumRulesEditPage.e());
                }
                am8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                am8Var2.r(true);
                am8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    am8Var2.x(handleGoToBarDetail.f());
                    am8Var2.t(handleGoToBarDetail.b());
                    am8Var2.o(handleGoToBarDetail.a());
                    am8Var2.w(handleGoToBarDetail.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                am8Var2.r(true);
                am8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    am8Var2.x(handleSaveImage.f());
                    am8Var2.t(handleSaveImage.b());
                    am8Var2.o(handleSaveImage.a());
                    am8Var2.w(handleSaveImage.e());
                    if (!am8Var2.h()) {
                        am8Var2.n(false);
                        addObserver("saveImageSuccess", am8Var2, false);
                    }
                }
                am8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                am8Var2.r(true);
                am8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    am8Var2.x(handleGetPhotoAlbum.f());
                    am8Var2.t(handleGetPhotoAlbum.b());
                    am8Var2.o(handleGetPhotoAlbum.a());
                    am8Var2.w(handleGetPhotoAlbum.e());
                    if (!am8Var2.h()) {
                        am8Var2.n(false);
                        addObserver("GetPhotoAlbum", am8Var2, false);
                    }
                }
                am8Var2.y(0);
            } else if (b.equals("router/portal")) {
                am8Var2.r(true);
                am8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    am8Var2.x(handlePortal.f());
                    am8Var2.t(handlePortal.b());
                    am8Var2.o(handlePortal.a());
                    am8Var2.w(handlePortal.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                am8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                am8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    am8Var2.x(selectPhotoAlbum.f());
                    am8Var2.t(selectPhotoAlbum.b());
                    am8Var2.o(selectPhotoAlbum.a());
                    am8Var2.w(selectPhotoAlbum.e());
                    if (!am8Var2.h()) {
                        am8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, am8Var2, false);
                    }
                }
                am8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                am8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                am8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    am8Var2.x(selectPrivateMsg.f());
                    am8Var2.t(selectPrivateMsg.b());
                    am8Var2.o(selectPrivateMsg.a());
                    am8Var2.w(selectPrivateMsg.e());
                    if (!am8Var2.h()) {
                        am8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", am8Var2, false);
                    }
                }
                am8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                am8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                am8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    am8Var2.x(reportUserTheme.f());
                    am8Var2.t(reportUserTheme.b());
                    am8Var2.o(reportUserTheme.a());
                    am8Var2.w(reportUserTheme.e());
                    if (!am8Var2.h()) {
                        am8Var2.n(false);
                        addObserver("goToReportThreadPage", am8Var2, false);
                    }
                }
                am8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                am8Var2.r(true);
                am8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    am8Var2.x(playSound.f());
                    am8Var2.t(playSound.b());
                    am8Var2.o(playSound.a());
                    am8Var2.w(playSound.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                am8Var2.r(true);
                am8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    am8Var2.x(playVibrate.f());
                    am8Var2.t(playVibrate.b());
                    am8Var2.o(playVibrate.a());
                    am8Var2.w(playVibrate.e());
                }
                am8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                am8Var2.r(true);
                am8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    am8Var2.x(jumpLoginActivity.f());
                    am8Var2.t(jumpLoginActivity.b());
                    am8Var2.o(jumpLoginActivity.a());
                    am8Var2.w(jumpLoginActivity.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                am8Var2.r(true);
                am8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    am8Var2.x(startLoadTimeInterval.f());
                    am8Var2.t(startLoadTimeInterval.b());
                    am8Var2.o(startLoadTimeInterval.a());
                    am8Var2.w(startLoadTimeInterval.e());
                }
                am8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                am8Var2.r(true);
                am8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    am8Var2.x(zid.f());
                    am8Var2.t(zid.b());
                    am8Var2.o(zid.a());
                    am8Var2.w(zid.e());
                }
                am8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                am8Var2.r(true);
                am8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    am8Var2.x(hdid.f());
                    am8Var2.t(hdid.b());
                    am8Var2.o(hdid.a());
                    am8Var2.w(hdid.e());
                }
                am8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                am8Var2.r(true);
                am8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    am8Var2.x(shareInfo.f());
                    am8Var2.t(shareInfo.b());
                    am8Var2.o(shareInfo.a());
                    am8Var2.w(shareInfo.e());
                }
                am8Var2.y(0);
            } else if (b.equals("share/share")) {
                am8Var2.r(true);
                am8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"));
                if (share != null) {
                    am8Var2.x(share.f());
                    am8Var2.t(share.b());
                    am8Var2.o(share.a());
                    am8Var2.w(share.e());
                }
                am8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                am8Var2.r(true);
                am8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    am8Var2.x(clipperInformation.f());
                    am8Var2.t(clipperInformation.b());
                    am8Var2.o(clipperInformation.a());
                    am8Var2.w(clipperInformation.e());
                }
                am8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                am8Var2.r(true);
                am8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    am8Var2.x(clipperInformation2.f());
                    am8Var2.t(clipperInformation2.b());
                    am8Var2.o(clipperInformation2.a());
                    am8Var2.w(clipperInformation2.e());
                }
                am8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                am8Var2.r(true);
                am8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    am8Var2.x(goToEditPost.f());
                    am8Var2.t(goToEditPost.b());
                    am8Var2.o(goToEditPost.a());
                    am8Var2.w(goToEditPost.e());
                }
                am8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                am8Var2.r(true);
                am8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    am8Var2.x(updateSearchForumInfo.f());
                    am8Var2.t(updateSearchForumInfo.b());
                    am8Var2.o(updateSearchForumInfo.a());
                    am8Var2.w(updateSearchForumInfo.e());
                }
                am8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                am8Var2.r(true);
                am8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    am8Var2.x(personlizedSwitchChange.f());
                    am8Var2.t(personlizedSwitchChange.b());
                    am8Var2.o(personlizedSwitchChange.a());
                    am8Var2.w(personlizedSwitchChange.e());
                }
                am8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                am8Var2.r(true);
                am8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    am8Var2.x(goToVideoImmersivePage.f());
                    am8Var2.t(goToVideoImmersivePage.b());
                    am8Var2.o(goToVideoImmersivePage.a());
                    am8Var2.w(goToVideoImmersivePage.e());
                }
                am8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                am8Var2.r(true);
                am8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    am8Var2.x(jumpToVideo.f());
                    am8Var2.t(jumpToVideo.b());
                    am8Var2.o(jumpToVideo.a());
                    am8Var2.w(jumpToVideo.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                am8Var2.r(true);
                am8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    am8Var2.x(closeNativeMask.f());
                    am8Var2.t(closeNativeMask.b());
                    am8Var2.o(closeNativeMask.a());
                    am8Var2.w(closeNativeMask.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                am8Var2.r(true);
                am8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    am8Var2.x(checkAppInstall.f());
                    am8Var2.t(checkAppInstall.b());
                    am8Var2.o(checkAppInstall.a());
                    am8Var2.w(checkAppInstall.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                am8Var2.r(true);
                am8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    am8Var2.x(disableBack.f());
                    am8Var2.t(disableBack.b());
                    am8Var2.o(disableBack.a());
                    am8Var2.w(disableBack.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                am8Var2.r(true);
                am8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    am8Var2.x(startApp.f());
                    am8Var2.t(startApp.b());
                    am8Var2.o(startApp.a());
                    am8Var2.w(startApp.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                am8Var2.r(true);
                am8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    am8Var2.x(hasNotificationPermission.f());
                    am8Var2.t(hasNotificationPermission.b());
                    am8Var2.o(hasNotificationPermission.a());
                    am8Var2.w(hasNotificationPermission.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                am8Var2.r(true);
                am8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    am8Var2.x(goToNotificationSetting.f());
                    am8Var2.t(goToNotificationSetting.b());
                    am8Var2.o(goToNotificationSetting.a());
                    am8Var2.w(goToNotificationSetting.e());
                }
                am8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                am8Var2.r(true);
                am8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    am8Var2.x(startDownloadCss.f());
                    am8Var2.t(startDownloadCss.b());
                    am8Var2.o(startDownloadCss.a());
                    am8Var2.w(startDownloadCss.e());
                }
                am8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                am8Var2.r(true);
                am8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    am8Var2.x(disableGoBack.f());
                    am8Var2.t(disableGoBack.b());
                    am8Var2.o(disableGoBack.a());
                    am8Var2.w(disableGoBack.e());
                }
                am8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                am8Var2.r(true);
                am8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    am8Var2.x(supplementInfo.f());
                    am8Var2.t(supplementInfo.b());
                    am8Var2.o(supplementInfo.a());
                    am8Var2.w(supplementInfo.e());
                }
                am8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                am8Var2.r(true);
                am8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    am8Var2.x(deviceInfo.f());
                    am8Var2.t(deviceInfo.b());
                    am8Var2.o(deviceInfo.a());
                    am8Var2.w(deviceInfo.e());
                }
                am8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                am8Var2.r(true);
                am8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    am8Var2.x(sendCompleteTaskReqMsg.f());
                    am8Var2.t(sendCompleteTaskReqMsg.b());
                    am8Var2.o(sendCompleteTaskReqMsg.a());
                    am8Var2.w(sendCompleteTaskReqMsg.e());
                }
                am8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                am8Var2.r(true);
                am8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    am8Var2.x(showTipToast.f());
                    am8Var2.t(showTipToast.b());
                    am8Var2.o(showTipToast.a());
                    am8Var2.w(showTipToast.e());
                }
                am8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                am8Var2.r(true);
                am8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    am8Var2.x(getModalData.f());
                    am8Var2.t(getModalData.b());
                    am8Var2.o(getModalData.a());
                    am8Var2.w(getModalData.e());
                }
                am8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                am8Var2.r(true);
                am8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    am8Var2.x(jumpToHtmlPage.f());
                    am8Var2.t(jumpToHtmlPage.b());
                    am8Var2.o(jumpToHtmlPage.a());
                    am8Var2.w(jumpToHtmlPage.e());
                }
                am8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                am8Var2.r(true);
                am8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    am8Var2.x(offlineUserInfo.f());
                    am8Var2.t(offlineUserInfo.b());
                    am8Var2.o(offlineUserInfo.a());
                    am8Var2.w(offlineUserInfo.e());
                }
                am8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                am8Var2.r(true);
                am8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    am8Var2.x(deleteOfflineBundle.f());
                    am8Var2.t(deleteOfflineBundle.b());
                    am8Var2.o(deleteOfflineBundle.a());
                    am8Var2.w(deleteOfflineBundle.e());
                }
                am8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                am8Var2.r(true);
                am8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    am8Var2.x(updateOfflineBundle.f());
                    am8Var2.t(updateOfflineBundle.b());
                    am8Var2.o(updateOfflineBundle.a());
                    am8Var2.w(updateOfflineBundle.e());
                }
                am8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                am8Var2.r(true);
                am8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    am8Var2.x(switchOfflineInterface.f());
                    am8Var2.t(switchOfflineInterface.b());
                    am8Var2.o(switchOfflineInterface.a());
                    am8Var2.w(switchOfflineInterface.e());
                }
                am8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                am8Var2.r(true);
                am8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    am8Var2.x(switchOfflineBundleStatus.f());
                    am8Var2.t(switchOfflineBundleStatus.b());
                    am8Var2.o(switchOfflineBundleStatus.a());
                    am8Var2.w(switchOfflineBundleStatus.e());
                }
                am8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                am8Var2.r(true);
                am8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    am8Var2.x(finishTestAnswer.f());
                    am8Var2.t(finishTestAnswer.b());
                    am8Var2.o(finishTestAnswer.a());
                    am8Var2.w(finishTestAnswer.e());
                }
                am8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                am8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                am8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    am8Var2.x(switchUrlHost.f());
                    am8Var2.t(switchUrlHost.b());
                    am8Var2.o(switchUrlHost.a());
                    am8Var2.w(switchUrlHost.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                am8Var2.r(true);
                am8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    am8Var2.x(appStorage.f());
                    am8Var2.t(appStorage.b());
                    am8Var2.o(appStorage.a());
                    am8Var2.w(appStorage.e());
                }
                am8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                am8Var2.r(true);
                am8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    am8Var2.x(putAppStorage.f());
                    am8Var2.t(putAppStorage.b());
                    am8Var2.o(putAppStorage.a());
                    am8Var2.w(putAppStorage.e());
                }
                am8Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                am8Var2.r(true);
                am8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    am8Var2.x(requestByNative.f());
                    am8Var2.t(requestByNative.b());
                    am8Var2.o(requestByNative.a());
                    am8Var2.w(requestByNative.e());
                    if (!am8Var2.h()) {
                        i = 0;
                        am8Var2.n(false);
                        addObserver("RequestByNativeToH5", am8Var2, false);
                        am8Var2.y(i);
                    }
                }
                i = 0;
                am8Var2.y(i);
            }
            return am8Var2;
        }
        return (am8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.yl8
    public List<am8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            am8 am8Var = null;
            if (qi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                am8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                am8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                am8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                am8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                am8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                am8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                am8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                am8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                am8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                am8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                am8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                am8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                am8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                am8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                am8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                am8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                am8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (am8Var != null) {
                am8Var.y(0);
            }
            List<zl8> list = this.mAsyncCallBackMethodList.get(str);
            if (am8Var != null && list != null) {
                Iterator<zl8> it = list.iterator();
                if (!qi.isEmpty(am8Var.e())) {
                    while (it.hasNext()) {
                        zl8 next = it.next();
                        if (next.b().equals(am8Var.e())) {
                            am8 am8Var2 = new am8();
                            am8Var2.v(next.a());
                            am8Var2.x(am8Var.f());
                            am8Var2.t(am8Var.b());
                            am8Var2.o(am8Var.a());
                            am8Var2.z(am8Var.l());
                            arrayList.add(am8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        zl8 next2 = it.next();
                        am8 am8Var3 = new am8();
                        am8Var3.v(next2.a());
                        am8Var3.x(am8Var.f());
                        am8Var3.t(am8Var.b());
                        am8Var3.o(am8Var.a());
                        am8Var3.z(am8Var.l());
                        arrayList.add(am8Var3);
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
