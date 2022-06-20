package com.baidu.tieba.h5power;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.TbTitleActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.ji8;
import com.repackage.ki8;
import com.repackage.li8;
import com.repackage.ni8;
import com.repackage.oi;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class QuickWebViewBridge_Proxy extends ji8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public QuickWebViewBridge mJsBridge;

    public QuickWebViewBridge_Proxy(QuickWebViewBridge quickWebViewBridge) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {quickWebViewBridge};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridge = quickWebViewBridge;
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

    @Override // com.repackage.ji8
    public li8 dispatch(ni8 ni8Var, li8 li8Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ni8Var, li8Var)) == null) {
            li8 li8Var2 = li8Var == null ? new li8() : li8Var;
            String b = ni8Var.b();
            JSONObject e = ni8Var.e();
            if (b.equals("account/startLoginModule")) {
                li8Var2.r(true);
                li8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    li8Var2.x(startLoginModule.f());
                    li8Var2.t(startLoginModule.b());
                    li8Var2.o(startLoginModule.a());
                    li8Var2.w(startLoginModule.e());
                }
                li8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                li8Var2.r(true);
                li8 finishPage = this.mJsBridge.finishPage();
                if (finishPage != null) {
                    li8Var2.x(finishPage.f());
                    li8Var2.t(finishPage.b());
                    li8Var2.o(finishPage.a());
                    li8Var2.w(finishPage.e());
                }
                li8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                li8Var2.r(true);
                li8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    li8Var2.x(showLowerHairHint.f());
                    li8Var2.t(showLowerHairHint.b());
                    li8Var2.o(showLowerHairHint.a());
                    li8Var2.w(showLowerHairHint.e());
                }
                li8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                li8Var2.r(true);
                li8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    li8Var2.x(gamePush.f());
                    li8Var2.t(gamePush.b());
                    li8Var2.o(gamePush.a());
                    li8Var2.w(gamePush.e());
                }
                li8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                li8Var2.r(true);
                li8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    li8Var2.x(handleGamePushStatus.f());
                    li8Var2.t(handleGamePushStatus.b());
                    li8Var2.o(handleGamePushStatus.a());
                    li8Var2.w(handleGamePushStatus.e());
                }
                li8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                li8Var2.r(true);
                li8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    li8Var2.x(jumpForumRulesEditPage.f());
                    li8Var2.t(jumpForumRulesEditPage.b());
                    li8Var2.o(jumpForumRulesEditPage.a());
                    li8Var2.w(jumpForumRulesEditPage.e());
                }
                li8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                li8Var2.r(true);
                li8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    li8Var2.x(handleGoToBarDetail.f());
                    li8Var2.t(handleGoToBarDetail.b());
                    li8Var2.o(handleGoToBarDetail.a());
                    li8Var2.w(handleGoToBarDetail.e());
                }
                li8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                li8Var2.r(true);
                li8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    li8Var2.x(handleSaveImage.f());
                    li8Var2.t(handleSaveImage.b());
                    li8Var2.o(handleSaveImage.a());
                    li8Var2.w(handleSaveImage.e());
                    if (!li8Var2.h()) {
                        li8Var2.n(false);
                        addObserver("saveImageSuccess", li8Var2, false);
                    }
                }
                li8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                li8Var2.r(true);
                li8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    li8Var2.x(handleGetPhotoAlbum.f());
                    li8Var2.t(handleGetPhotoAlbum.b());
                    li8Var2.o(handleGetPhotoAlbum.a());
                    li8Var2.w(handleGetPhotoAlbum.e());
                    if (!li8Var2.h()) {
                        li8Var2.n(false);
                        addObserver("GetPhotoAlbum", li8Var2, false);
                    }
                }
                li8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                li8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                li8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    li8Var2.x(selectPhotoAlbum.f());
                    li8Var2.t(selectPhotoAlbum.b());
                    li8Var2.o(selectPhotoAlbum.a());
                    li8Var2.w(selectPhotoAlbum.e());
                    if (!li8Var2.h()) {
                        li8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, li8Var2, false);
                    }
                }
                li8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                li8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                li8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    li8Var2.x(selectPrivateMsg.f());
                    li8Var2.t(selectPrivateMsg.b());
                    li8Var2.o(selectPrivateMsg.a());
                    li8Var2.w(selectPrivateMsg.e());
                    if (!li8Var2.h()) {
                        li8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", li8Var2, false);
                    }
                }
                li8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                li8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                li8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    li8Var2.x(reportUserTheme.f());
                    li8Var2.t(reportUserTheme.b());
                    li8Var2.o(reportUserTheme.a());
                    li8Var2.w(reportUserTheme.e());
                    if (!li8Var2.h()) {
                        li8Var2.n(false);
                        addObserver("goToReportThreadPage", li8Var2, false);
                    }
                }
                li8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                li8Var2.r(true);
                li8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    li8Var2.x(playSound.f());
                    li8Var2.t(playSound.b());
                    li8Var2.o(playSound.a());
                    li8Var2.w(playSound.e());
                }
                li8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                li8Var2.r(true);
                li8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    li8Var2.x(playVibrate.f());
                    li8Var2.t(playVibrate.b());
                    li8Var2.o(playVibrate.a());
                    li8Var2.w(playVibrate.e());
                }
                li8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                li8Var2.r(true);
                li8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    li8Var2.x(jumpLoginActivity.f());
                    li8Var2.t(jumpLoginActivity.b());
                    li8Var2.o(jumpLoginActivity.a());
                    li8Var2.w(jumpLoginActivity.e());
                }
                li8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                li8Var2.r(true);
                li8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    li8Var2.x(startLoadTimeInterval.f());
                    li8Var2.t(startLoadTimeInterval.b());
                    li8Var2.o(startLoadTimeInterval.a());
                    li8Var2.w(startLoadTimeInterval.e());
                }
                li8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                li8Var2.r(true);
                li8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    li8Var2.x(zid.f());
                    li8Var2.t(zid.b());
                    li8Var2.o(zid.a());
                    li8Var2.w(zid.e());
                }
                li8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                li8Var2.r(true);
                li8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    li8Var2.x(hdid.f());
                    li8Var2.t(hdid.b());
                    li8Var2.o(hdid.a());
                    li8Var2.w(hdid.e());
                }
                li8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                li8Var2.r(true);
                li8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    li8Var2.x(shareInfo.f());
                    li8Var2.t(shareInfo.b());
                    li8Var2.o(shareInfo.a());
                    li8Var2.w(shareInfo.e());
                }
                li8Var2.y(0);
            } else if (b.equals("share/share")) {
                li8Var2.r(true);
                li8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"));
                if (share != null) {
                    li8Var2.x(share.f());
                    li8Var2.t(share.b());
                    li8Var2.o(share.a());
                    li8Var2.w(share.e());
                }
                li8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                li8Var2.r(true);
                li8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    li8Var2.x(clipperInformation.f());
                    li8Var2.t(clipperInformation.b());
                    li8Var2.o(clipperInformation.a());
                    li8Var2.w(clipperInformation.e());
                }
                li8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                li8Var2.r(true);
                li8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    li8Var2.x(clipperInformation2.f());
                    li8Var2.t(clipperInformation2.b());
                    li8Var2.o(clipperInformation2.a());
                    li8Var2.w(clipperInformation2.e());
                }
                li8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                li8Var2.r(true);
                li8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    li8Var2.x(goToEditPost.f());
                    li8Var2.t(goToEditPost.b());
                    li8Var2.o(goToEditPost.a());
                    li8Var2.w(goToEditPost.e());
                }
                li8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                li8Var2.r(true);
                li8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    li8Var2.x(updateSearchForumInfo.f());
                    li8Var2.t(updateSearchForumInfo.b());
                    li8Var2.o(updateSearchForumInfo.a());
                    li8Var2.w(updateSearchForumInfo.e());
                }
                li8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                li8Var2.r(true);
                li8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    li8Var2.x(personlizedSwitchChange.f());
                    li8Var2.t(personlizedSwitchChange.b());
                    li8Var2.o(personlizedSwitchChange.a());
                    li8Var2.w(personlizedSwitchChange.e());
                }
                li8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                li8Var2.r(true);
                li8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    li8Var2.x(goToVideoImmersivePage.f());
                    li8Var2.t(goToVideoImmersivePage.b());
                    li8Var2.o(goToVideoImmersivePage.a());
                    li8Var2.w(goToVideoImmersivePage.e());
                }
                li8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                li8Var2.r(true);
                li8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    li8Var2.x(jumpToVideo.f());
                    li8Var2.t(jumpToVideo.b());
                    li8Var2.o(jumpToVideo.a());
                    li8Var2.w(jumpToVideo.e());
                }
                li8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                li8Var2.r(true);
                li8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    li8Var2.x(closeNativeMask.f());
                    li8Var2.t(closeNativeMask.b());
                    li8Var2.o(closeNativeMask.a());
                    li8Var2.w(closeNativeMask.e());
                }
                li8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                li8Var2.r(true);
                li8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    li8Var2.x(checkAppInstall.f());
                    li8Var2.t(checkAppInstall.b());
                    li8Var2.o(checkAppInstall.a());
                    li8Var2.w(checkAppInstall.e());
                }
                li8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                li8Var2.r(true);
                li8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    li8Var2.x(disableBack.f());
                    li8Var2.t(disableBack.b());
                    li8Var2.o(disableBack.a());
                    li8Var2.w(disableBack.e());
                }
                li8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                li8Var2.r(true);
                li8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    li8Var2.x(startApp.f());
                    li8Var2.t(startApp.b());
                    li8Var2.o(startApp.a());
                    li8Var2.w(startApp.e());
                }
                li8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                li8Var2.r(true);
                li8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    li8Var2.x(hasNotificationPermission.f());
                    li8Var2.t(hasNotificationPermission.b());
                    li8Var2.o(hasNotificationPermission.a());
                    li8Var2.w(hasNotificationPermission.e());
                }
                li8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                li8Var2.r(true);
                li8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    li8Var2.x(goToNotificationSetting.f());
                    li8Var2.t(goToNotificationSetting.b());
                    li8Var2.o(goToNotificationSetting.a());
                    li8Var2.w(goToNotificationSetting.e());
                }
                li8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                li8Var2.r(true);
                li8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    li8Var2.x(startDownloadCss.f());
                    li8Var2.t(startDownloadCss.b());
                    li8Var2.o(startDownloadCss.a());
                    li8Var2.w(startDownloadCss.e());
                }
                li8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                li8Var2.r(true);
                li8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    li8Var2.x(disableGoBack.f());
                    li8Var2.t(disableGoBack.b());
                    li8Var2.o(disableGoBack.a());
                    li8Var2.w(disableGoBack.e());
                }
                li8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                li8Var2.r(true);
                li8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    li8Var2.x(supplementInfo.f());
                    li8Var2.t(supplementInfo.b());
                    li8Var2.o(supplementInfo.a());
                    li8Var2.w(supplementInfo.e());
                }
                li8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                li8Var2.r(true);
                li8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    li8Var2.x(deviceInfo.f());
                    li8Var2.t(deviceInfo.b());
                    li8Var2.o(deviceInfo.a());
                    li8Var2.w(deviceInfo.e());
                }
                li8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                li8Var2.r(true);
                li8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    li8Var2.x(sendCompleteTaskReqMsg.f());
                    li8Var2.t(sendCompleteTaskReqMsg.b());
                    li8Var2.o(sendCompleteTaskReqMsg.a());
                    li8Var2.w(sendCompleteTaskReqMsg.e());
                }
                li8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                li8Var2.r(true);
                li8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    li8Var2.x(showTipToast.f());
                    li8Var2.t(showTipToast.b());
                    li8Var2.o(showTipToast.a());
                    li8Var2.w(showTipToast.e());
                }
                li8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                li8Var2.r(true);
                li8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    li8Var2.x(getModalData.f());
                    li8Var2.t(getModalData.b());
                    li8Var2.o(getModalData.a());
                    li8Var2.w(getModalData.e());
                }
                li8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                li8Var2.r(true);
                li8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    li8Var2.x(jumpToHtmlPage.f());
                    li8Var2.t(jumpToHtmlPage.b());
                    li8Var2.o(jumpToHtmlPage.a());
                    li8Var2.w(jumpToHtmlPage.e());
                }
                li8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                li8Var2.r(true);
                li8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    li8Var2.x(offlineUserInfo.f());
                    li8Var2.t(offlineUserInfo.b());
                    li8Var2.o(offlineUserInfo.a());
                    li8Var2.w(offlineUserInfo.e());
                }
                li8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                li8Var2.r(true);
                li8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    li8Var2.x(deleteOfflineBundle.f());
                    li8Var2.t(deleteOfflineBundle.b());
                    li8Var2.o(deleteOfflineBundle.a());
                    li8Var2.w(deleteOfflineBundle.e());
                }
                li8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                li8Var2.r(true);
                li8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    li8Var2.x(updateOfflineBundle.f());
                    li8Var2.t(updateOfflineBundle.b());
                    li8Var2.o(updateOfflineBundle.a());
                    li8Var2.w(updateOfflineBundle.e());
                }
                li8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                li8Var2.r(true);
                li8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    li8Var2.x(switchOfflineInterface.f());
                    li8Var2.t(switchOfflineInterface.b());
                    li8Var2.o(switchOfflineInterface.a());
                    li8Var2.w(switchOfflineInterface.e());
                }
                li8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                li8Var2.r(true);
                li8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    li8Var2.x(switchOfflineBundleStatus.f());
                    li8Var2.t(switchOfflineBundleStatus.b());
                    li8Var2.o(switchOfflineBundleStatus.a());
                    li8Var2.w(switchOfflineBundleStatus.e());
                }
                li8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                li8Var2.r(true);
                li8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    li8Var2.x(finishTestAnswer.f());
                    li8Var2.t(finishTestAnswer.b());
                    li8Var2.o(finishTestAnswer.a());
                    li8Var2.w(finishTestAnswer.e());
                }
                li8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                li8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                li8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    li8Var2.x(switchUrlHost.f());
                    li8Var2.t(switchUrlHost.b());
                    li8Var2.o(switchUrlHost.a());
                    li8Var2.w(switchUrlHost.e());
                }
                li8Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                li8Var2.r(true);
                li8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    li8Var2.x(requestByNative.f());
                    li8Var2.t(requestByNative.b());
                    li8Var2.o(requestByNative.a());
                    li8Var2.w(requestByNative.e());
                    if (!li8Var2.h()) {
                        i = 0;
                        li8Var2.n(false);
                        addObserver("RequestByNativeToH5", li8Var2, false);
                        li8Var2.y(i);
                    }
                }
                i = 0;
                li8Var2.y(i);
            }
            return li8Var2;
        }
        return (li8) invokeLL.objValue;
    }

    @Override // com.repackage.ji8
    public List<li8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            li8 li8Var = null;
            if (oi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                li8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                li8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                li8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                li8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                li8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                li8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                li8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                li8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                li8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                li8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                li8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                li8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                li8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                li8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                li8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                li8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                li8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (li8Var != null) {
                li8Var.y(0);
            }
            List<ki8> list = this.mAsyncCallBackMethodList.get(str);
            if (li8Var != null && list != null) {
                Iterator<ki8> it = list.iterator();
                if (!oi.isEmpty(li8Var.e())) {
                    while (it.hasNext()) {
                        ki8 next = it.next();
                        if (next.b().equals(li8Var.e())) {
                            li8 li8Var2 = new li8();
                            li8Var2.v(next.a());
                            li8Var2.x(li8Var.f());
                            li8Var2.t(li8Var.b());
                            li8Var2.o(li8Var.a());
                            li8Var2.z(li8Var.l());
                            arrayList.add(li8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ki8 next2 = it.next();
                        li8 li8Var3 = new li8();
                        li8Var3.v(next2.a());
                        li8Var3.x(li8Var.f());
                        li8Var3.t(li8Var.b());
                        li8Var3.o(li8Var.a());
                        li8Var3.z(li8Var.l());
                        arrayList.add(li8Var3);
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
