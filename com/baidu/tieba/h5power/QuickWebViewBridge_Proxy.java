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
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.fj8;
import com.repackage.gj8;
import com.repackage.hj8;
import com.repackage.jj8;
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
public class QuickWebViewBridge_Proxy extends fj8 {
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

    @Override // com.repackage.fj8
    public hj8 dispatch(jj8 jj8Var, hj8 hj8Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jj8Var, hj8Var)) == null) {
            hj8 hj8Var2 = hj8Var == null ? new hj8() : hj8Var;
            String b = jj8Var.b();
            JSONObject e = jj8Var.e();
            if (b.equals("account/startLoginModule")) {
                hj8Var2.r(true);
                hj8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    hj8Var2.x(startLoginModule.f());
                    hj8Var2.t(startLoginModule.b());
                    hj8Var2.o(startLoginModule.a());
                    hj8Var2.w(startLoginModule.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                hj8Var2.r(true);
                hj8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    hj8Var2.x(finishPage.f());
                    hj8Var2.t(finishPage.b());
                    hj8Var2.o(finishPage.a());
                    hj8Var2.w(finishPage.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                hj8Var2.r(true);
                hj8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    hj8Var2.x(showLowerHairHint.f());
                    hj8Var2.t(showLowerHairHint.b());
                    hj8Var2.o(showLowerHairHint.a());
                    hj8Var2.w(showLowerHairHint.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                hj8Var2.r(true);
                hj8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    hj8Var2.x(gamePush.f());
                    hj8Var2.t(gamePush.b());
                    hj8Var2.o(gamePush.a());
                    hj8Var2.w(gamePush.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                hj8Var2.r(true);
                hj8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    hj8Var2.x(handleGamePushStatus.f());
                    hj8Var2.t(handleGamePushStatus.b());
                    hj8Var2.o(handleGamePushStatus.a());
                    hj8Var2.w(handleGamePushStatus.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                hj8Var2.r(true);
                hj8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    hj8Var2.x(jumpForumRulesEditPage.f());
                    hj8Var2.t(jumpForumRulesEditPage.b());
                    hj8Var2.o(jumpForumRulesEditPage.a());
                    hj8Var2.w(jumpForumRulesEditPage.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                hj8Var2.r(true);
                hj8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    hj8Var2.x(handleGoToBarDetail.f());
                    hj8Var2.t(handleGoToBarDetail.b());
                    hj8Var2.o(handleGoToBarDetail.a());
                    hj8Var2.w(handleGoToBarDetail.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                hj8Var2.r(true);
                hj8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    hj8Var2.x(handleSaveImage.f());
                    hj8Var2.t(handleSaveImage.b());
                    hj8Var2.o(handleSaveImage.a());
                    hj8Var2.w(handleSaveImage.e());
                    if (!hj8Var2.h()) {
                        hj8Var2.n(false);
                        addObserver("saveImageSuccess", hj8Var2, false);
                    }
                }
                hj8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                hj8Var2.r(true);
                hj8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    hj8Var2.x(handleGetPhotoAlbum.f());
                    hj8Var2.t(handleGetPhotoAlbum.b());
                    hj8Var2.o(handleGetPhotoAlbum.a());
                    hj8Var2.w(handleGetPhotoAlbum.e());
                    if (!hj8Var2.h()) {
                        hj8Var2.n(false);
                        addObserver("GetPhotoAlbum", hj8Var2, false);
                    }
                }
                hj8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                hj8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                hj8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    hj8Var2.x(selectPhotoAlbum.f());
                    hj8Var2.t(selectPhotoAlbum.b());
                    hj8Var2.o(selectPhotoAlbum.a());
                    hj8Var2.w(selectPhotoAlbum.e());
                    if (!hj8Var2.h()) {
                        hj8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, hj8Var2, false);
                    }
                }
                hj8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                hj8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                hj8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    hj8Var2.x(selectPrivateMsg.f());
                    hj8Var2.t(selectPrivateMsg.b());
                    hj8Var2.o(selectPrivateMsg.a());
                    hj8Var2.w(selectPrivateMsg.e());
                    if (!hj8Var2.h()) {
                        hj8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", hj8Var2, false);
                    }
                }
                hj8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                hj8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                hj8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    hj8Var2.x(reportUserTheme.f());
                    hj8Var2.t(reportUserTheme.b());
                    hj8Var2.o(reportUserTheme.a());
                    hj8Var2.w(reportUserTheme.e());
                    if (!hj8Var2.h()) {
                        hj8Var2.n(false);
                        addObserver("goToReportThreadPage", hj8Var2, false);
                    }
                }
                hj8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                hj8Var2.r(true);
                hj8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    hj8Var2.x(playSound.f());
                    hj8Var2.t(playSound.b());
                    hj8Var2.o(playSound.a());
                    hj8Var2.w(playSound.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                hj8Var2.r(true);
                hj8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    hj8Var2.x(playVibrate.f());
                    hj8Var2.t(playVibrate.b());
                    hj8Var2.o(playVibrate.a());
                    hj8Var2.w(playVibrate.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                hj8Var2.r(true);
                hj8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    hj8Var2.x(jumpLoginActivity.f());
                    hj8Var2.t(jumpLoginActivity.b());
                    hj8Var2.o(jumpLoginActivity.a());
                    hj8Var2.w(jumpLoginActivity.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                hj8Var2.r(true);
                hj8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    hj8Var2.x(startLoadTimeInterval.f());
                    hj8Var2.t(startLoadTimeInterval.b());
                    hj8Var2.o(startLoadTimeInterval.a());
                    hj8Var2.w(startLoadTimeInterval.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                hj8Var2.r(true);
                hj8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    hj8Var2.x(zid.f());
                    hj8Var2.t(zid.b());
                    hj8Var2.o(zid.a());
                    hj8Var2.w(zid.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                hj8Var2.r(true);
                hj8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    hj8Var2.x(hdid.f());
                    hj8Var2.t(hdid.b());
                    hj8Var2.o(hdid.a());
                    hj8Var2.w(hdid.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                hj8Var2.r(true);
                hj8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    hj8Var2.x(shareInfo.f());
                    hj8Var2.t(shareInfo.b());
                    hj8Var2.o(shareInfo.a());
                    hj8Var2.w(shareInfo.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("share/share")) {
                hj8Var2.r(true);
                hj8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"));
                if (share != null) {
                    hj8Var2.x(share.f());
                    hj8Var2.t(share.b());
                    hj8Var2.o(share.a());
                    hj8Var2.w(share.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                hj8Var2.r(true);
                hj8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    hj8Var2.x(clipperInformation.f());
                    hj8Var2.t(clipperInformation.b());
                    hj8Var2.o(clipperInformation.a());
                    hj8Var2.w(clipperInformation.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                hj8Var2.r(true);
                hj8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    hj8Var2.x(clipperInformation2.f());
                    hj8Var2.t(clipperInformation2.b());
                    hj8Var2.o(clipperInformation2.a());
                    hj8Var2.w(clipperInformation2.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                hj8Var2.r(true);
                hj8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    hj8Var2.x(goToEditPost.f());
                    hj8Var2.t(goToEditPost.b());
                    hj8Var2.o(goToEditPost.a());
                    hj8Var2.w(goToEditPost.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                hj8Var2.r(true);
                hj8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    hj8Var2.x(updateSearchForumInfo.f());
                    hj8Var2.t(updateSearchForumInfo.b());
                    hj8Var2.o(updateSearchForumInfo.a());
                    hj8Var2.w(updateSearchForumInfo.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                hj8Var2.r(true);
                hj8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    hj8Var2.x(personlizedSwitchChange.f());
                    hj8Var2.t(personlizedSwitchChange.b());
                    hj8Var2.o(personlizedSwitchChange.a());
                    hj8Var2.w(personlizedSwitchChange.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                hj8Var2.r(true);
                hj8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    hj8Var2.x(goToVideoImmersivePage.f());
                    hj8Var2.t(goToVideoImmersivePage.b());
                    hj8Var2.o(goToVideoImmersivePage.a());
                    hj8Var2.w(goToVideoImmersivePage.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                hj8Var2.r(true);
                hj8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    hj8Var2.x(jumpToVideo.f());
                    hj8Var2.t(jumpToVideo.b());
                    hj8Var2.o(jumpToVideo.a());
                    hj8Var2.w(jumpToVideo.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                hj8Var2.r(true);
                hj8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    hj8Var2.x(closeNativeMask.f());
                    hj8Var2.t(closeNativeMask.b());
                    hj8Var2.o(closeNativeMask.a());
                    hj8Var2.w(closeNativeMask.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                hj8Var2.r(true);
                hj8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    hj8Var2.x(checkAppInstall.f());
                    hj8Var2.t(checkAppInstall.b());
                    hj8Var2.o(checkAppInstall.a());
                    hj8Var2.w(checkAppInstall.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                hj8Var2.r(true);
                hj8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    hj8Var2.x(disableBack.f());
                    hj8Var2.t(disableBack.b());
                    hj8Var2.o(disableBack.a());
                    hj8Var2.w(disableBack.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                hj8Var2.r(true);
                hj8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    hj8Var2.x(startApp.f());
                    hj8Var2.t(startApp.b());
                    hj8Var2.o(startApp.a());
                    hj8Var2.w(startApp.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                hj8Var2.r(true);
                hj8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    hj8Var2.x(hasNotificationPermission.f());
                    hj8Var2.t(hasNotificationPermission.b());
                    hj8Var2.o(hasNotificationPermission.a());
                    hj8Var2.w(hasNotificationPermission.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                hj8Var2.r(true);
                hj8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    hj8Var2.x(goToNotificationSetting.f());
                    hj8Var2.t(goToNotificationSetting.b());
                    hj8Var2.o(goToNotificationSetting.a());
                    hj8Var2.w(goToNotificationSetting.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                hj8Var2.r(true);
                hj8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    hj8Var2.x(startDownloadCss.f());
                    hj8Var2.t(startDownloadCss.b());
                    hj8Var2.o(startDownloadCss.a());
                    hj8Var2.w(startDownloadCss.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                hj8Var2.r(true);
                hj8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    hj8Var2.x(disableGoBack.f());
                    hj8Var2.t(disableGoBack.b());
                    hj8Var2.o(disableGoBack.a());
                    hj8Var2.w(disableGoBack.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                hj8Var2.r(true);
                hj8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    hj8Var2.x(supplementInfo.f());
                    hj8Var2.t(supplementInfo.b());
                    hj8Var2.o(supplementInfo.a());
                    hj8Var2.w(supplementInfo.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                hj8Var2.r(true);
                hj8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    hj8Var2.x(deviceInfo.f());
                    hj8Var2.t(deviceInfo.b());
                    hj8Var2.o(deviceInfo.a());
                    hj8Var2.w(deviceInfo.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                hj8Var2.r(true);
                hj8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    hj8Var2.x(sendCompleteTaskReqMsg.f());
                    hj8Var2.t(sendCompleteTaskReqMsg.b());
                    hj8Var2.o(sendCompleteTaskReqMsg.a());
                    hj8Var2.w(sendCompleteTaskReqMsg.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                hj8Var2.r(true);
                hj8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    hj8Var2.x(showTipToast.f());
                    hj8Var2.t(showTipToast.b());
                    hj8Var2.o(showTipToast.a());
                    hj8Var2.w(showTipToast.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                hj8Var2.r(true);
                hj8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    hj8Var2.x(getModalData.f());
                    hj8Var2.t(getModalData.b());
                    hj8Var2.o(getModalData.a());
                    hj8Var2.w(getModalData.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                hj8Var2.r(true);
                hj8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    hj8Var2.x(jumpToHtmlPage.f());
                    hj8Var2.t(jumpToHtmlPage.b());
                    hj8Var2.o(jumpToHtmlPage.a());
                    hj8Var2.w(jumpToHtmlPage.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                hj8Var2.r(true);
                hj8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    hj8Var2.x(offlineUserInfo.f());
                    hj8Var2.t(offlineUserInfo.b());
                    hj8Var2.o(offlineUserInfo.a());
                    hj8Var2.w(offlineUserInfo.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                hj8Var2.r(true);
                hj8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    hj8Var2.x(deleteOfflineBundle.f());
                    hj8Var2.t(deleteOfflineBundle.b());
                    hj8Var2.o(deleteOfflineBundle.a());
                    hj8Var2.w(deleteOfflineBundle.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                hj8Var2.r(true);
                hj8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    hj8Var2.x(updateOfflineBundle.f());
                    hj8Var2.t(updateOfflineBundle.b());
                    hj8Var2.o(updateOfflineBundle.a());
                    hj8Var2.w(updateOfflineBundle.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                hj8Var2.r(true);
                hj8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    hj8Var2.x(switchOfflineInterface.f());
                    hj8Var2.t(switchOfflineInterface.b());
                    hj8Var2.o(switchOfflineInterface.a());
                    hj8Var2.w(switchOfflineInterface.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                hj8Var2.r(true);
                hj8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    hj8Var2.x(switchOfflineBundleStatus.f());
                    hj8Var2.t(switchOfflineBundleStatus.b());
                    hj8Var2.o(switchOfflineBundleStatus.a());
                    hj8Var2.w(switchOfflineBundleStatus.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                hj8Var2.r(true);
                hj8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    hj8Var2.x(finishTestAnswer.f());
                    hj8Var2.t(finishTestAnswer.b());
                    hj8Var2.o(finishTestAnswer.a());
                    hj8Var2.w(finishTestAnswer.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                hj8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                hj8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    hj8Var2.x(switchUrlHost.f());
                    hj8Var2.t(switchUrlHost.b());
                    hj8Var2.o(switchUrlHost.a());
                    hj8Var2.w(switchUrlHost.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                hj8Var2.r(true);
                hj8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    hj8Var2.x(appStorage.f());
                    hj8Var2.t(appStorage.b());
                    hj8Var2.o(appStorage.a());
                    hj8Var2.w(appStorage.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                hj8Var2.r(true);
                hj8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    hj8Var2.x(putAppStorage.f());
                    hj8Var2.t(putAppStorage.b());
                    hj8Var2.o(putAppStorage.a());
                    hj8Var2.w(putAppStorage.e());
                }
                hj8Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                hj8Var2.r(true);
                hj8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    hj8Var2.x(requestByNative.f());
                    hj8Var2.t(requestByNative.b());
                    hj8Var2.o(requestByNative.a());
                    hj8Var2.w(requestByNative.e());
                    if (!hj8Var2.h()) {
                        i = 0;
                        hj8Var2.n(false);
                        addObserver("RequestByNativeToH5", hj8Var2, false);
                        hj8Var2.y(i);
                    }
                }
                i = 0;
                hj8Var2.y(i);
            }
            return hj8Var2;
        }
        return (hj8) invokeLL.objValue;
    }

    @Override // com.repackage.fj8
    public List<hj8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            hj8 hj8Var = null;
            if (oi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                hj8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                hj8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                hj8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                hj8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                hj8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                hj8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                hj8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                hj8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                hj8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                hj8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                hj8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                hj8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                hj8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                hj8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                hj8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                hj8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                hj8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (hj8Var != null) {
                hj8Var.y(0);
            }
            List<gj8> list = this.mAsyncCallBackMethodList.get(str);
            if (hj8Var != null && list != null) {
                Iterator<gj8> it = list.iterator();
                if (!oi.isEmpty(hj8Var.e())) {
                    while (it.hasNext()) {
                        gj8 next = it.next();
                        if (next.b().equals(hj8Var.e())) {
                            hj8 hj8Var2 = new hj8();
                            hj8Var2.v(next.a());
                            hj8Var2.x(hj8Var.f());
                            hj8Var2.t(hj8Var.b());
                            hj8Var2.o(hj8Var.a());
                            hj8Var2.z(hj8Var.l());
                            arrayList.add(hj8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        gj8 next2 = it.next();
                        hj8 hj8Var3 = new hj8();
                        hj8Var3.v(next2.a());
                        hj8Var3.x(hj8Var.f());
                        hj8Var3.t(hj8Var.b());
                        hj8Var3.o(hj8Var.a());
                        hj8Var3.z(hj8Var.l());
                        arrayList.add(hj8Var3);
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
