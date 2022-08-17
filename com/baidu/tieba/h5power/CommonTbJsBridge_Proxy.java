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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.pi;
import com.repackage.ql8;
import com.repackage.rl8;
import com.repackage.sl8;
import com.repackage.ul8;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommonTbJsBridge_Proxy extends ql8 {
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

    @Override // com.repackage.ql8
    public sl8 dispatch(ul8 ul8Var, sl8 sl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ul8Var, sl8Var)) == null) {
            sl8 sl8Var2 = sl8Var == null ? new sl8() : sl8Var;
            String b = ul8Var.b();
            JSONObject e = ul8Var.e();
            if (b.equals("account/startLoginModule")) {
                sl8Var2.r(true);
                sl8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    sl8Var2.x(startLoginModule.f());
                    sl8Var2.t(startLoginModule.b());
                    sl8Var2.o(startLoginModule.a());
                    sl8Var2.w(startLoginModule.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                sl8Var2.r(true);
                sl8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    sl8Var2.x(finishPage.f());
                    sl8Var2.t(finishPage.b());
                    sl8Var2.o(finishPage.a());
                    sl8Var2.w(finishPage.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                sl8Var2.r(true);
                sl8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    sl8Var2.x(showLowerHairHint.f());
                    sl8Var2.t(showLowerHairHint.b());
                    sl8Var2.o(showLowerHairHint.a());
                    sl8Var2.w(showLowerHairHint.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                sl8Var2.r(true);
                sl8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    sl8Var2.x(gamePush.f());
                    sl8Var2.t(gamePush.b());
                    sl8Var2.o(gamePush.a());
                    sl8Var2.w(gamePush.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                sl8Var2.r(true);
                sl8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    sl8Var2.x(handleGamePushStatus.f());
                    sl8Var2.t(handleGamePushStatus.b());
                    sl8Var2.o(handleGamePushStatus.a());
                    sl8Var2.w(handleGamePushStatus.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                sl8Var2.r(true);
                sl8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    sl8Var2.x(jumpForumRulesEditPage.f());
                    sl8Var2.t(jumpForumRulesEditPage.b());
                    sl8Var2.o(jumpForumRulesEditPage.a());
                    sl8Var2.w(jumpForumRulesEditPage.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                sl8Var2.r(true);
                sl8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    sl8Var2.x(handleGoToBarDetail.f());
                    sl8Var2.t(handleGoToBarDetail.b());
                    sl8Var2.o(handleGoToBarDetail.a());
                    sl8Var2.w(handleGoToBarDetail.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                sl8Var2.r(true);
                sl8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    sl8Var2.x(handleSaveImage.f());
                    sl8Var2.t(handleSaveImage.b());
                    sl8Var2.o(handleSaveImage.a());
                    sl8Var2.w(handleSaveImage.e());
                    if (!sl8Var2.h()) {
                        sl8Var2.n(false);
                        addObserver("saveImageSuccess", sl8Var2, false);
                    }
                }
                sl8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                sl8Var2.r(true);
                sl8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    sl8Var2.x(handleGetPhotoAlbum.f());
                    sl8Var2.t(handleGetPhotoAlbum.b());
                    sl8Var2.o(handleGetPhotoAlbum.a());
                    sl8Var2.w(handleGetPhotoAlbum.e());
                    if (!sl8Var2.h()) {
                        sl8Var2.n(false);
                        addObserver("GetPhotoAlbum", sl8Var2, false);
                    }
                }
                sl8Var2.y(0);
            } else if (b.equals("router/portal")) {
                sl8Var2.r(true);
                sl8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    sl8Var2.x(handlePortal.f());
                    sl8Var2.t(handlePortal.b());
                    sl8Var2.o(handlePortal.a());
                    sl8Var2.w(handlePortal.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                sl8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                sl8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    sl8Var2.x(selectPhotoAlbum.f());
                    sl8Var2.t(selectPhotoAlbum.b());
                    sl8Var2.o(selectPhotoAlbum.a());
                    sl8Var2.w(selectPhotoAlbum.e());
                    if (!sl8Var2.h()) {
                        sl8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, sl8Var2, false);
                    }
                }
                sl8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                sl8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                sl8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    sl8Var2.x(selectPrivateMsg.f());
                    sl8Var2.t(selectPrivateMsg.b());
                    sl8Var2.o(selectPrivateMsg.a());
                    sl8Var2.w(selectPrivateMsg.e());
                    if (!sl8Var2.h()) {
                        sl8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", sl8Var2, false);
                    }
                }
                sl8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                sl8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                sl8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    sl8Var2.x(reportUserTheme.f());
                    sl8Var2.t(reportUserTheme.b());
                    sl8Var2.o(reportUserTheme.a());
                    sl8Var2.w(reportUserTheme.e());
                    if (!sl8Var2.h()) {
                        sl8Var2.n(false);
                        addObserver("goToReportThreadPage", sl8Var2, false);
                    }
                }
                sl8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                sl8Var2.r(true);
                sl8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    sl8Var2.x(playSound.f());
                    sl8Var2.t(playSound.b());
                    sl8Var2.o(playSound.a());
                    sl8Var2.w(playSound.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                sl8Var2.r(true);
                sl8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    sl8Var2.x(playVibrate.f());
                    sl8Var2.t(playVibrate.b());
                    sl8Var2.o(playVibrate.a());
                    sl8Var2.w(playVibrate.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                sl8Var2.r(true);
                sl8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    sl8Var2.x(jumpLoginActivity.f());
                    sl8Var2.t(jumpLoginActivity.b());
                    sl8Var2.o(jumpLoginActivity.a());
                    sl8Var2.w(jumpLoginActivity.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                sl8Var2.r(true);
                sl8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    sl8Var2.x(startLoadTimeInterval.f());
                    sl8Var2.t(startLoadTimeInterval.b());
                    sl8Var2.o(startLoadTimeInterval.a());
                    sl8Var2.w(startLoadTimeInterval.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                sl8Var2.r(true);
                sl8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    sl8Var2.x(zid.f());
                    sl8Var2.t(zid.b());
                    sl8Var2.o(zid.a());
                    sl8Var2.w(zid.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                sl8Var2.r(true);
                sl8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    sl8Var2.x(hdid.f());
                    sl8Var2.t(hdid.b());
                    sl8Var2.o(hdid.a());
                    sl8Var2.w(hdid.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                sl8Var2.r(true);
                sl8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    sl8Var2.x(shareInfo.f());
                    sl8Var2.t(shareInfo.b());
                    sl8Var2.o(shareInfo.a());
                    sl8Var2.w(shareInfo.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("share/share")) {
                sl8Var2.r(true);
                sl8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"));
                if (share != null) {
                    sl8Var2.x(share.f());
                    sl8Var2.t(share.b());
                    sl8Var2.o(share.a());
                    sl8Var2.w(share.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                sl8Var2.r(true);
                sl8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    sl8Var2.x(clipperInformation.f());
                    sl8Var2.t(clipperInformation.b());
                    sl8Var2.o(clipperInformation.a());
                    sl8Var2.w(clipperInformation.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                sl8Var2.r(true);
                sl8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    sl8Var2.x(clipperInformation2.f());
                    sl8Var2.t(clipperInformation2.b());
                    sl8Var2.o(clipperInformation2.a());
                    sl8Var2.w(clipperInformation2.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                sl8Var2.r(true);
                sl8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    sl8Var2.x(goToEditPost.f());
                    sl8Var2.t(goToEditPost.b());
                    sl8Var2.o(goToEditPost.a());
                    sl8Var2.w(goToEditPost.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                sl8Var2.r(true);
                sl8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    sl8Var2.x(updateSearchForumInfo.f());
                    sl8Var2.t(updateSearchForumInfo.b());
                    sl8Var2.o(updateSearchForumInfo.a());
                    sl8Var2.w(updateSearchForumInfo.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                sl8Var2.r(true);
                sl8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    sl8Var2.x(personlizedSwitchChange.f());
                    sl8Var2.t(personlizedSwitchChange.b());
                    sl8Var2.o(personlizedSwitchChange.a());
                    sl8Var2.w(personlizedSwitchChange.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                sl8Var2.r(true);
                sl8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    sl8Var2.x(goToVideoImmersivePage.f());
                    sl8Var2.t(goToVideoImmersivePage.b());
                    sl8Var2.o(goToVideoImmersivePage.a());
                    sl8Var2.w(goToVideoImmersivePage.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                sl8Var2.r(true);
                sl8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    sl8Var2.x(jumpToVideo.f());
                    sl8Var2.t(jumpToVideo.b());
                    sl8Var2.o(jumpToVideo.a());
                    sl8Var2.w(jumpToVideo.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                sl8Var2.r(true);
                sl8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    sl8Var2.x(closeNativeMask.f());
                    sl8Var2.t(closeNativeMask.b());
                    sl8Var2.o(closeNativeMask.a());
                    sl8Var2.w(closeNativeMask.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                sl8Var2.r(true);
                sl8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    sl8Var2.x(checkAppInstall.f());
                    sl8Var2.t(checkAppInstall.b());
                    sl8Var2.o(checkAppInstall.a());
                    sl8Var2.w(checkAppInstall.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                sl8Var2.r(true);
                sl8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    sl8Var2.x(disableBack.f());
                    sl8Var2.t(disableBack.b());
                    sl8Var2.o(disableBack.a());
                    sl8Var2.w(disableBack.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                sl8Var2.r(true);
                sl8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    sl8Var2.x(startApp.f());
                    sl8Var2.t(startApp.b());
                    sl8Var2.o(startApp.a());
                    sl8Var2.w(startApp.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                sl8Var2.r(true);
                sl8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    sl8Var2.x(hasNotificationPermission.f());
                    sl8Var2.t(hasNotificationPermission.b());
                    sl8Var2.o(hasNotificationPermission.a());
                    sl8Var2.w(hasNotificationPermission.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                sl8Var2.r(true);
                sl8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    sl8Var2.x(goToNotificationSetting.f());
                    sl8Var2.t(goToNotificationSetting.b());
                    sl8Var2.o(goToNotificationSetting.a());
                    sl8Var2.w(goToNotificationSetting.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                sl8Var2.r(true);
                sl8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    sl8Var2.x(startDownloadCss.f());
                    sl8Var2.t(startDownloadCss.b());
                    sl8Var2.o(startDownloadCss.a());
                    sl8Var2.w(startDownloadCss.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                sl8Var2.r(true);
                sl8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    sl8Var2.x(disableGoBack.f());
                    sl8Var2.t(disableGoBack.b());
                    sl8Var2.o(disableGoBack.a());
                    sl8Var2.w(disableGoBack.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                sl8Var2.r(true);
                sl8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    sl8Var2.x(supplementInfo.f());
                    sl8Var2.t(supplementInfo.b());
                    sl8Var2.o(supplementInfo.a());
                    sl8Var2.w(supplementInfo.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                sl8Var2.r(true);
                sl8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    sl8Var2.x(deviceInfo.f());
                    sl8Var2.t(deviceInfo.b());
                    sl8Var2.o(deviceInfo.a());
                    sl8Var2.w(deviceInfo.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                sl8Var2.r(true);
                sl8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    sl8Var2.x(sendCompleteTaskReqMsg.f());
                    sl8Var2.t(sendCompleteTaskReqMsg.b());
                    sl8Var2.o(sendCompleteTaskReqMsg.a());
                    sl8Var2.w(sendCompleteTaskReqMsg.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                sl8Var2.r(true);
                sl8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    sl8Var2.x(showTipToast.f());
                    sl8Var2.t(showTipToast.b());
                    sl8Var2.o(showTipToast.a());
                    sl8Var2.w(showTipToast.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                sl8Var2.r(true);
                sl8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    sl8Var2.x(getModalData.f());
                    sl8Var2.t(getModalData.b());
                    sl8Var2.o(getModalData.a());
                    sl8Var2.w(getModalData.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                sl8Var2.r(true);
                sl8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    sl8Var2.x(jumpToHtmlPage.f());
                    sl8Var2.t(jumpToHtmlPage.b());
                    sl8Var2.o(jumpToHtmlPage.a());
                    sl8Var2.w(jumpToHtmlPage.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                sl8Var2.r(true);
                sl8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    sl8Var2.x(offlineUserInfo.f());
                    sl8Var2.t(offlineUserInfo.b());
                    sl8Var2.o(offlineUserInfo.a());
                    sl8Var2.w(offlineUserInfo.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                sl8Var2.r(true);
                sl8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    sl8Var2.x(deleteOfflineBundle.f());
                    sl8Var2.t(deleteOfflineBundle.b());
                    sl8Var2.o(deleteOfflineBundle.a());
                    sl8Var2.w(deleteOfflineBundle.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                sl8Var2.r(true);
                sl8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    sl8Var2.x(updateOfflineBundle.f());
                    sl8Var2.t(updateOfflineBundle.b());
                    sl8Var2.o(updateOfflineBundle.a());
                    sl8Var2.w(updateOfflineBundle.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                sl8Var2.r(true);
                sl8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    sl8Var2.x(switchOfflineInterface.f());
                    sl8Var2.t(switchOfflineInterface.b());
                    sl8Var2.o(switchOfflineInterface.a());
                    sl8Var2.w(switchOfflineInterface.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                sl8Var2.r(true);
                sl8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    sl8Var2.x(switchOfflineBundleStatus.f());
                    sl8Var2.t(switchOfflineBundleStatus.b());
                    sl8Var2.o(switchOfflineBundleStatus.a());
                    sl8Var2.w(switchOfflineBundleStatus.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                sl8Var2.r(true);
                sl8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    sl8Var2.x(finishTestAnswer.f());
                    sl8Var2.t(finishTestAnswer.b());
                    sl8Var2.o(finishTestAnswer.a());
                    sl8Var2.w(finishTestAnswer.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                sl8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                sl8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    sl8Var2.x(switchUrlHost.f());
                    sl8Var2.t(switchUrlHost.b());
                    sl8Var2.o(switchUrlHost.a());
                    sl8Var2.w(switchUrlHost.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                sl8Var2.r(true);
                sl8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    sl8Var2.x(appStorage.f());
                    sl8Var2.t(appStorage.b());
                    sl8Var2.o(appStorage.a());
                    sl8Var2.w(appStorage.e());
                }
                sl8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                sl8Var2.r(true);
                sl8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    sl8Var2.x(putAppStorage.f());
                    sl8Var2.t(putAppStorage.b());
                    sl8Var2.o(putAppStorage.a());
                    sl8Var2.w(putAppStorage.e());
                }
                sl8Var2.y(0);
            }
            return sl8Var2;
        }
        return (sl8) invokeLL.objValue;
    }

    @Override // com.repackage.ql8
    public List<sl8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            sl8 sl8Var = null;
            if (pi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                sl8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                sl8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                sl8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                sl8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                sl8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                sl8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                sl8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                sl8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                sl8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                sl8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                sl8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                sl8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                sl8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                sl8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                sl8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                sl8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            }
            if (sl8Var != null) {
                sl8Var.y(0);
            }
            List<rl8> list = this.mAsyncCallBackMethodList.get(str);
            if (sl8Var != null && list != null) {
                Iterator<rl8> it = list.iterator();
                if (!pi.isEmpty(sl8Var.e())) {
                    while (it.hasNext()) {
                        rl8 next = it.next();
                        if (next.b().equals(sl8Var.e())) {
                            sl8 sl8Var2 = new sl8();
                            sl8Var2.v(next.a());
                            sl8Var2.x(sl8Var.f());
                            sl8Var2.t(sl8Var.b());
                            sl8Var2.o(sl8Var.a());
                            sl8Var2.z(sl8Var.l());
                            arrayList.add(sl8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        rl8 next2 = it.next();
                        sl8 sl8Var3 = new sl8();
                        sl8Var3.v(next2.a());
                        sl8Var3.x(sl8Var.f());
                        sl8Var3.t(sl8Var.b());
                        sl8Var3.o(sl8Var.a());
                        sl8Var3.z(sl8Var.l());
                        arrayList.add(sl8Var3);
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
