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
import com.baidu.tieba.dj;
import com.baidu.tieba.kn8;
import com.baidu.tieba.ln8;
import com.baidu.tieba.mn8;
import com.baidu.tieba.on8;
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
public class CommonTbJsBridge_Proxy extends kn8 {
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

    @Override // com.baidu.tieba.kn8
    public mn8 dispatch(on8 on8Var, mn8 mn8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, on8Var, mn8Var)) == null) {
            mn8 mn8Var2 = mn8Var == null ? new mn8() : mn8Var;
            String b = on8Var.b();
            JSONObject e = on8Var.e();
            if (b.equals("account/startLoginModule")) {
                mn8Var2.r(true);
                mn8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    mn8Var2.x(startLoginModule.f());
                    mn8Var2.t(startLoginModule.b());
                    mn8Var2.o(startLoginModule.a());
                    mn8Var2.w(startLoginModule.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                mn8Var2.r(true);
                mn8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    mn8Var2.x(finishPage.f());
                    mn8Var2.t(finishPage.b());
                    mn8Var2.o(finishPage.a());
                    mn8Var2.w(finishPage.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                mn8Var2.r(true);
                mn8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    mn8Var2.x(showLowerHairHint.f());
                    mn8Var2.t(showLowerHairHint.b());
                    mn8Var2.o(showLowerHairHint.a());
                    mn8Var2.w(showLowerHairHint.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                mn8Var2.r(true);
                mn8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    mn8Var2.x(gamePush.f());
                    mn8Var2.t(gamePush.b());
                    mn8Var2.o(gamePush.a());
                    mn8Var2.w(gamePush.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                mn8Var2.r(true);
                mn8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    mn8Var2.x(handleGamePushStatus.f());
                    mn8Var2.t(handleGamePushStatus.b());
                    mn8Var2.o(handleGamePushStatus.a());
                    mn8Var2.w(handleGamePushStatus.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                mn8Var2.r(true);
                mn8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    mn8Var2.x(jumpForumRulesEditPage.f());
                    mn8Var2.t(jumpForumRulesEditPage.b());
                    mn8Var2.o(jumpForumRulesEditPage.a());
                    mn8Var2.w(jumpForumRulesEditPage.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                mn8Var2.r(true);
                mn8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    mn8Var2.x(handleGoToBarDetail.f());
                    mn8Var2.t(handleGoToBarDetail.b());
                    mn8Var2.o(handleGoToBarDetail.a());
                    mn8Var2.w(handleGoToBarDetail.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                mn8Var2.r(true);
                mn8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    mn8Var2.x(handleSaveImage.f());
                    mn8Var2.t(handleSaveImage.b());
                    mn8Var2.o(handleSaveImage.a());
                    mn8Var2.w(handleSaveImage.e());
                    if (!mn8Var2.h()) {
                        mn8Var2.n(false);
                        addObserver("saveImageSuccess", mn8Var2, false);
                    }
                }
                mn8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                mn8Var2.r(true);
                mn8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    mn8Var2.x(handleGetPhotoAlbum.f());
                    mn8Var2.t(handleGetPhotoAlbum.b());
                    mn8Var2.o(handleGetPhotoAlbum.a());
                    mn8Var2.w(handleGetPhotoAlbum.e());
                    if (!mn8Var2.h()) {
                        mn8Var2.n(false);
                        addObserver("GetPhotoAlbum", mn8Var2, false);
                    }
                }
                mn8Var2.y(0);
            } else if (b.equals("router/portal")) {
                mn8Var2.r(true);
                mn8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    mn8Var2.x(handlePortal.f());
                    mn8Var2.t(handlePortal.b());
                    mn8Var2.o(handlePortal.a());
                    mn8Var2.w(handlePortal.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                mn8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                mn8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    mn8Var2.x(selectPhotoAlbum.f());
                    mn8Var2.t(selectPhotoAlbum.b());
                    mn8Var2.o(selectPhotoAlbum.a());
                    mn8Var2.w(selectPhotoAlbum.e());
                    if (!mn8Var2.h()) {
                        mn8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, mn8Var2, false);
                    }
                }
                mn8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                mn8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                mn8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    mn8Var2.x(selectPrivateMsg.f());
                    mn8Var2.t(selectPrivateMsg.b());
                    mn8Var2.o(selectPrivateMsg.a());
                    mn8Var2.w(selectPrivateMsg.e());
                    if (!mn8Var2.h()) {
                        mn8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", mn8Var2, false);
                    }
                }
                mn8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                mn8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                mn8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    mn8Var2.x(reportUserTheme.f());
                    mn8Var2.t(reportUserTheme.b());
                    mn8Var2.o(reportUserTheme.a());
                    mn8Var2.w(reportUserTheme.e());
                    if (!mn8Var2.h()) {
                        mn8Var2.n(false);
                        addObserver("goToReportThreadPage", mn8Var2, false);
                    }
                }
                mn8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                mn8Var2.r(true);
                mn8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    mn8Var2.x(playSound.f());
                    mn8Var2.t(playSound.b());
                    mn8Var2.o(playSound.a());
                    mn8Var2.w(playSound.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                mn8Var2.r(true);
                mn8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    mn8Var2.x(playVibrate.f());
                    mn8Var2.t(playVibrate.b());
                    mn8Var2.o(playVibrate.a());
                    mn8Var2.w(playVibrate.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                mn8Var2.r(true);
                mn8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    mn8Var2.x(jumpLoginActivity.f());
                    mn8Var2.t(jumpLoginActivity.b());
                    mn8Var2.o(jumpLoginActivity.a());
                    mn8Var2.w(jumpLoginActivity.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                mn8Var2.r(true);
                mn8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    mn8Var2.x(startLoadTimeInterval.f());
                    mn8Var2.t(startLoadTimeInterval.b());
                    mn8Var2.o(startLoadTimeInterval.a());
                    mn8Var2.w(startLoadTimeInterval.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                mn8Var2.r(true);
                mn8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    mn8Var2.x(zid.f());
                    mn8Var2.t(zid.b());
                    mn8Var2.o(zid.a());
                    mn8Var2.w(zid.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                mn8Var2.r(true);
                mn8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    mn8Var2.x(hdid.f());
                    mn8Var2.t(hdid.b());
                    mn8Var2.o(hdid.a());
                    mn8Var2.w(hdid.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                mn8Var2.r(true);
                mn8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    mn8Var2.x(shareInfo.f());
                    mn8Var2.t(shareInfo.b());
                    mn8Var2.o(shareInfo.a());
                    mn8Var2.w(shareInfo.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("share/share")) {
                mn8Var2.r(true);
                mn8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"));
                if (share != null) {
                    mn8Var2.x(share.f());
                    mn8Var2.t(share.b());
                    mn8Var2.o(share.a());
                    mn8Var2.w(share.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                mn8Var2.r(true);
                mn8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    mn8Var2.x(clipperInformation.f());
                    mn8Var2.t(clipperInformation.b());
                    mn8Var2.o(clipperInformation.a());
                    mn8Var2.w(clipperInformation.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                mn8Var2.r(true);
                mn8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    mn8Var2.x(clipperInformation2.f());
                    mn8Var2.t(clipperInformation2.b());
                    mn8Var2.o(clipperInformation2.a());
                    mn8Var2.w(clipperInformation2.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                mn8Var2.r(true);
                mn8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    mn8Var2.x(goToEditPost.f());
                    mn8Var2.t(goToEditPost.b());
                    mn8Var2.o(goToEditPost.a());
                    mn8Var2.w(goToEditPost.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                mn8Var2.r(true);
                mn8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    mn8Var2.x(updateSearchForumInfo.f());
                    mn8Var2.t(updateSearchForumInfo.b());
                    mn8Var2.o(updateSearchForumInfo.a());
                    mn8Var2.w(updateSearchForumInfo.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                mn8Var2.r(true);
                mn8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    mn8Var2.x(personlizedSwitchChange.f());
                    mn8Var2.t(personlizedSwitchChange.b());
                    mn8Var2.o(personlizedSwitchChange.a());
                    mn8Var2.w(personlizedSwitchChange.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                mn8Var2.r(true);
                mn8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    mn8Var2.x(goToVideoImmersivePage.f());
                    mn8Var2.t(goToVideoImmersivePage.b());
                    mn8Var2.o(goToVideoImmersivePage.a());
                    mn8Var2.w(goToVideoImmersivePage.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                mn8Var2.r(true);
                mn8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    mn8Var2.x(jumpToVideo.f());
                    mn8Var2.t(jumpToVideo.b());
                    mn8Var2.o(jumpToVideo.a());
                    mn8Var2.w(jumpToVideo.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                mn8Var2.r(true);
                mn8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    mn8Var2.x(closeNativeMask.f());
                    mn8Var2.t(closeNativeMask.b());
                    mn8Var2.o(closeNativeMask.a());
                    mn8Var2.w(closeNativeMask.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                mn8Var2.r(true);
                mn8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    mn8Var2.x(checkAppInstall.f());
                    mn8Var2.t(checkAppInstall.b());
                    mn8Var2.o(checkAppInstall.a());
                    mn8Var2.w(checkAppInstall.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                mn8Var2.r(true);
                mn8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    mn8Var2.x(disableBack.f());
                    mn8Var2.t(disableBack.b());
                    mn8Var2.o(disableBack.a());
                    mn8Var2.w(disableBack.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                mn8Var2.r(true);
                mn8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    mn8Var2.x(startApp.f());
                    mn8Var2.t(startApp.b());
                    mn8Var2.o(startApp.a());
                    mn8Var2.w(startApp.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                mn8Var2.r(true);
                mn8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    mn8Var2.x(hasNotificationPermission.f());
                    mn8Var2.t(hasNotificationPermission.b());
                    mn8Var2.o(hasNotificationPermission.a());
                    mn8Var2.w(hasNotificationPermission.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                mn8Var2.r(true);
                mn8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    mn8Var2.x(goToNotificationSetting.f());
                    mn8Var2.t(goToNotificationSetting.b());
                    mn8Var2.o(goToNotificationSetting.a());
                    mn8Var2.w(goToNotificationSetting.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                mn8Var2.r(true);
                mn8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    mn8Var2.x(startDownloadCss.f());
                    mn8Var2.t(startDownloadCss.b());
                    mn8Var2.o(startDownloadCss.a());
                    mn8Var2.w(startDownloadCss.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                mn8Var2.r(true);
                mn8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    mn8Var2.x(disableGoBack.f());
                    mn8Var2.t(disableGoBack.b());
                    mn8Var2.o(disableGoBack.a());
                    mn8Var2.w(disableGoBack.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                mn8Var2.r(true);
                mn8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    mn8Var2.x(supplementInfo.f());
                    mn8Var2.t(supplementInfo.b());
                    mn8Var2.o(supplementInfo.a());
                    mn8Var2.w(supplementInfo.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                mn8Var2.r(true);
                mn8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    mn8Var2.x(deviceInfo.f());
                    mn8Var2.t(deviceInfo.b());
                    mn8Var2.o(deviceInfo.a());
                    mn8Var2.w(deviceInfo.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                mn8Var2.r(true);
                mn8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    mn8Var2.x(sendCompleteTaskReqMsg.f());
                    mn8Var2.t(sendCompleteTaskReqMsg.b());
                    mn8Var2.o(sendCompleteTaskReqMsg.a());
                    mn8Var2.w(sendCompleteTaskReqMsg.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                mn8Var2.r(true);
                mn8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    mn8Var2.x(showTipToast.f());
                    mn8Var2.t(showTipToast.b());
                    mn8Var2.o(showTipToast.a());
                    mn8Var2.w(showTipToast.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                mn8Var2.r(true);
                mn8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    mn8Var2.x(getModalData.f());
                    mn8Var2.t(getModalData.b());
                    mn8Var2.o(getModalData.a());
                    mn8Var2.w(getModalData.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                mn8Var2.r(true);
                mn8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    mn8Var2.x(jumpToHtmlPage.f());
                    mn8Var2.t(jumpToHtmlPage.b());
                    mn8Var2.o(jumpToHtmlPage.a());
                    mn8Var2.w(jumpToHtmlPage.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                mn8Var2.r(true);
                mn8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    mn8Var2.x(offlineUserInfo.f());
                    mn8Var2.t(offlineUserInfo.b());
                    mn8Var2.o(offlineUserInfo.a());
                    mn8Var2.w(offlineUserInfo.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                mn8Var2.r(true);
                mn8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    mn8Var2.x(deleteOfflineBundle.f());
                    mn8Var2.t(deleteOfflineBundle.b());
                    mn8Var2.o(deleteOfflineBundle.a());
                    mn8Var2.w(deleteOfflineBundle.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                mn8Var2.r(true);
                mn8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    mn8Var2.x(updateOfflineBundle.f());
                    mn8Var2.t(updateOfflineBundle.b());
                    mn8Var2.o(updateOfflineBundle.a());
                    mn8Var2.w(updateOfflineBundle.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                mn8Var2.r(true);
                mn8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    mn8Var2.x(switchOfflineInterface.f());
                    mn8Var2.t(switchOfflineInterface.b());
                    mn8Var2.o(switchOfflineInterface.a());
                    mn8Var2.w(switchOfflineInterface.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                mn8Var2.r(true);
                mn8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    mn8Var2.x(switchOfflineBundleStatus.f());
                    mn8Var2.t(switchOfflineBundleStatus.b());
                    mn8Var2.o(switchOfflineBundleStatus.a());
                    mn8Var2.w(switchOfflineBundleStatus.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                mn8Var2.r(true);
                mn8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    mn8Var2.x(finishTestAnswer.f());
                    mn8Var2.t(finishTestAnswer.b());
                    mn8Var2.o(finishTestAnswer.a());
                    mn8Var2.w(finishTestAnswer.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                mn8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                mn8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    mn8Var2.x(switchUrlHost.f());
                    mn8Var2.t(switchUrlHost.b());
                    mn8Var2.o(switchUrlHost.a());
                    mn8Var2.w(switchUrlHost.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                mn8Var2.r(true);
                mn8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    mn8Var2.x(appStorage.f());
                    mn8Var2.t(appStorage.b());
                    mn8Var2.o(appStorage.a());
                    mn8Var2.w(appStorage.e());
                }
                mn8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                mn8Var2.r(true);
                mn8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    mn8Var2.x(putAppStorage.f());
                    mn8Var2.t(putAppStorage.b());
                    mn8Var2.o(putAppStorage.a());
                    mn8Var2.w(putAppStorage.e());
                }
                mn8Var2.y(0);
            }
            return mn8Var2;
        }
        return (mn8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kn8
    public List<mn8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            mn8 mn8Var = null;
            if (dj.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                mn8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                mn8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                mn8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                mn8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                mn8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                mn8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                mn8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                mn8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                mn8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                mn8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                mn8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                mn8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                mn8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                mn8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                mn8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                mn8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            }
            if (mn8Var != null) {
                mn8Var.y(0);
            }
            List<ln8> list = this.mAsyncCallBackMethodList.get(str);
            if (mn8Var != null && list != null) {
                Iterator<ln8> it = list.iterator();
                if (!dj.isEmpty(mn8Var.e())) {
                    while (it.hasNext()) {
                        ln8 next = it.next();
                        if (next.b().equals(mn8Var.e())) {
                            mn8 mn8Var2 = new mn8();
                            mn8Var2.v(next.a());
                            mn8Var2.x(mn8Var.f());
                            mn8Var2.t(mn8Var.b());
                            mn8Var2.o(mn8Var.a());
                            mn8Var2.z(mn8Var.l());
                            arrayList.add(mn8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ln8 next2 = it.next();
                        mn8 mn8Var3 = new mn8();
                        mn8Var3.v(next2.a());
                        mn8Var3.x(mn8Var.f());
                        mn8Var3.t(mn8Var.b());
                        mn8Var3.o(mn8Var.a());
                        mn8Var3.z(mn8Var.l());
                        arrayList.add(mn8Var3);
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
