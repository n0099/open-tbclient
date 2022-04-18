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
import com.repackage.ni;
import com.repackage.tl8;
import com.repackage.ul8;
import com.repackage.vl8;
import com.repackage.xl8;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class QuickWebViewBridge_Proxy extends tl8 {
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

    @Override // com.repackage.tl8
    public vl8 dispatch(xl8 xl8Var, vl8 vl8Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xl8Var, vl8Var)) == null) {
            vl8 vl8Var2 = vl8Var == null ? new vl8() : vl8Var;
            String b = xl8Var.b();
            JSONObject e = xl8Var.e();
            if (b.equals("account/startLoginModule")) {
                vl8Var2.r(true);
                vl8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    vl8Var2.x(startLoginModule.f());
                    vl8Var2.t(startLoginModule.b());
                    vl8Var2.o(startLoginModule.a());
                    vl8Var2.w(startLoginModule.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                vl8Var2.r(true);
                vl8 finishPage = this.mJsBridge.finishPage();
                if (finishPage != null) {
                    vl8Var2.x(finishPage.f());
                    vl8Var2.t(finishPage.b());
                    vl8Var2.o(finishPage.a());
                    vl8Var2.w(finishPage.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                vl8Var2.r(true);
                vl8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    vl8Var2.x(showLowerHairHint.f());
                    vl8Var2.t(showLowerHairHint.b());
                    vl8Var2.o(showLowerHairHint.a());
                    vl8Var2.w(showLowerHairHint.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                vl8Var2.r(true);
                vl8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    vl8Var2.x(gamePush.f());
                    vl8Var2.t(gamePush.b());
                    vl8Var2.o(gamePush.a());
                    vl8Var2.w(gamePush.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                vl8Var2.r(true);
                vl8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    vl8Var2.x(handleGamePushStatus.f());
                    vl8Var2.t(handleGamePushStatus.b());
                    vl8Var2.o(handleGamePushStatus.a());
                    vl8Var2.w(handleGamePushStatus.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                vl8Var2.r(true);
                vl8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID));
                if (handleGoToBarDetail != null) {
                    vl8Var2.x(handleGoToBarDetail.f());
                    vl8Var2.t(handleGoToBarDetail.b());
                    vl8Var2.o(handleGoToBarDetail.a());
                    vl8Var2.w(handleGoToBarDetail.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                vl8Var2.r(true);
                vl8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    vl8Var2.x(handleSaveImage.f());
                    vl8Var2.t(handleSaveImage.b());
                    vl8Var2.o(handleSaveImage.a());
                    vl8Var2.w(handleSaveImage.e());
                    if (!vl8Var2.h()) {
                        vl8Var2.n(false);
                        addObserver("saveImageSuccess", vl8Var2, false);
                    }
                }
                vl8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                vl8Var2.r(true);
                vl8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    vl8Var2.x(handleGetPhotoAlbum.f());
                    vl8Var2.t(handleGetPhotoAlbum.b());
                    vl8Var2.o(handleGetPhotoAlbum.a());
                    vl8Var2.w(handleGetPhotoAlbum.e());
                    if (!vl8Var2.h()) {
                        vl8Var2.n(false);
                        addObserver("GetPhotoAlbum", vl8Var2, false);
                    }
                }
                vl8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                vl8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                vl8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    vl8Var2.x(selectPhotoAlbum.f());
                    vl8Var2.t(selectPhotoAlbum.b());
                    vl8Var2.o(selectPhotoAlbum.a());
                    vl8Var2.w(selectPhotoAlbum.e());
                    if (!vl8Var2.h()) {
                        vl8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, vl8Var2, false);
                    }
                }
                vl8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                vl8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                vl8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    vl8Var2.x(selectPrivateMsg.f());
                    vl8Var2.t(selectPrivateMsg.b());
                    vl8Var2.o(selectPrivateMsg.a());
                    vl8Var2.w(selectPrivateMsg.e());
                    if (!vl8Var2.h()) {
                        vl8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", vl8Var2, false);
                    }
                }
                vl8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                vl8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                vl8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    vl8Var2.x(reportUserTheme.f());
                    vl8Var2.t(reportUserTheme.b());
                    vl8Var2.o(reportUserTheme.a());
                    vl8Var2.w(reportUserTheme.e());
                    if (!vl8Var2.h()) {
                        vl8Var2.n(false);
                        addObserver("goToReportThreadPage", vl8Var2, false);
                    }
                }
                vl8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                vl8Var2.r(true);
                vl8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    vl8Var2.x(playSound.f());
                    vl8Var2.t(playSound.b());
                    vl8Var2.o(playSound.a());
                    vl8Var2.w(playSound.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                vl8Var2.r(true);
                vl8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    vl8Var2.x(playVibrate.f());
                    vl8Var2.t(playVibrate.b());
                    vl8Var2.o(playVibrate.a());
                    vl8Var2.w(playVibrate.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                vl8Var2.r(true);
                vl8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    vl8Var2.x(jumpLoginActivity.f());
                    vl8Var2.t(jumpLoginActivity.b());
                    vl8Var2.o(jumpLoginActivity.a());
                    vl8Var2.w(jumpLoginActivity.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                vl8Var2.r(true);
                vl8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    vl8Var2.x(startLoadTimeInterval.f());
                    vl8Var2.t(startLoadTimeInterval.b());
                    vl8Var2.o(startLoadTimeInterval.a());
                    vl8Var2.w(startLoadTimeInterval.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                vl8Var2.r(true);
                vl8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    vl8Var2.x(zid.f());
                    vl8Var2.t(zid.b());
                    vl8Var2.o(zid.a());
                    vl8Var2.w(zid.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                vl8Var2.r(true);
                vl8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    vl8Var2.x(hdid.f());
                    vl8Var2.t(hdid.b());
                    vl8Var2.o(hdid.a());
                    vl8Var2.w(hdid.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                vl8Var2.r(true);
                vl8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    vl8Var2.x(shareInfo.f());
                    vl8Var2.t(shareInfo.b());
                    vl8Var2.o(shareInfo.a());
                    vl8Var2.w(shareInfo.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("share/share")) {
                vl8Var2.r(true);
                vl8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"));
                if (share != null) {
                    vl8Var2.x(share.f());
                    vl8Var2.t(share.b());
                    vl8Var2.o(share.a());
                    vl8Var2.w(share.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                vl8Var2.r(true);
                vl8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    vl8Var2.x(clipperInformation.f());
                    vl8Var2.t(clipperInformation.b());
                    vl8Var2.o(clipperInformation.a());
                    vl8Var2.w(clipperInformation.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                vl8Var2.r(true);
                vl8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    vl8Var2.x(clipperInformation2.f());
                    vl8Var2.t(clipperInformation2.b());
                    vl8Var2.o(clipperInformation2.a());
                    vl8Var2.w(clipperInformation2.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                vl8Var2.r(true);
                vl8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    vl8Var2.x(goToEditPost.f());
                    vl8Var2.t(goToEditPost.b());
                    vl8Var2.o(goToEditPost.a());
                    vl8Var2.w(goToEditPost.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                vl8Var2.r(true);
                vl8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    vl8Var2.x(updateSearchForumInfo.f());
                    vl8Var2.t(updateSearchForumInfo.b());
                    vl8Var2.o(updateSearchForumInfo.a());
                    vl8Var2.w(updateSearchForumInfo.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                vl8Var2.r(true);
                vl8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    vl8Var2.x(personlizedSwitchChange.f());
                    vl8Var2.t(personlizedSwitchChange.b());
                    vl8Var2.o(personlizedSwitchChange.a());
                    vl8Var2.w(personlizedSwitchChange.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                vl8Var2.r(true);
                vl8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    vl8Var2.x(goToVideoImmersivePage.f());
                    vl8Var2.t(goToVideoImmersivePage.b());
                    vl8Var2.o(goToVideoImmersivePage.a());
                    vl8Var2.w(goToVideoImmersivePage.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                vl8Var2.r(true);
                vl8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    vl8Var2.x(jumpToVideo.f());
                    vl8Var2.t(jumpToVideo.b());
                    vl8Var2.o(jumpToVideo.a());
                    vl8Var2.w(jumpToVideo.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                vl8Var2.r(true);
                vl8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    vl8Var2.x(closeNativeMask.f());
                    vl8Var2.t(closeNativeMask.b());
                    vl8Var2.o(closeNativeMask.a());
                    vl8Var2.w(closeNativeMask.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                vl8Var2.r(true);
                vl8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    vl8Var2.x(checkAppInstall.f());
                    vl8Var2.t(checkAppInstall.b());
                    vl8Var2.o(checkAppInstall.a());
                    vl8Var2.w(checkAppInstall.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                vl8Var2.r(true);
                vl8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    vl8Var2.x(disableBack.f());
                    vl8Var2.t(disableBack.b());
                    vl8Var2.o(disableBack.a());
                    vl8Var2.w(disableBack.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                vl8Var2.r(true);
                vl8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    vl8Var2.x(startApp.f());
                    vl8Var2.t(startApp.b());
                    vl8Var2.o(startApp.a());
                    vl8Var2.w(startApp.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                vl8Var2.r(true);
                vl8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    vl8Var2.x(hasNotificationPermission.f());
                    vl8Var2.t(hasNotificationPermission.b());
                    vl8Var2.o(hasNotificationPermission.a());
                    vl8Var2.w(hasNotificationPermission.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                vl8Var2.r(true);
                vl8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    vl8Var2.x(goToNotificationSetting.f());
                    vl8Var2.t(goToNotificationSetting.b());
                    vl8Var2.o(goToNotificationSetting.a());
                    vl8Var2.w(goToNotificationSetting.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                vl8Var2.r(true);
                vl8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    vl8Var2.x(startDownloadCss.f());
                    vl8Var2.t(startDownloadCss.b());
                    vl8Var2.o(startDownloadCss.a());
                    vl8Var2.w(startDownloadCss.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                vl8Var2.r(true);
                vl8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    vl8Var2.x(disableGoBack.f());
                    vl8Var2.t(disableGoBack.b());
                    vl8Var2.o(disableGoBack.a());
                    vl8Var2.w(disableGoBack.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                vl8Var2.r(true);
                vl8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    vl8Var2.x(supplementInfo.f());
                    vl8Var2.t(supplementInfo.b());
                    vl8Var2.o(supplementInfo.a());
                    vl8Var2.w(supplementInfo.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                vl8Var2.r(true);
                vl8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    vl8Var2.x(deviceInfo.f());
                    vl8Var2.t(deviceInfo.b());
                    vl8Var2.o(deviceInfo.a());
                    vl8Var2.w(deviceInfo.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                vl8Var2.r(true);
                vl8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    vl8Var2.x(sendCompleteTaskReqMsg.f());
                    vl8Var2.t(sendCompleteTaskReqMsg.b());
                    vl8Var2.o(sendCompleteTaskReqMsg.a());
                    vl8Var2.w(sendCompleteTaskReqMsg.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                vl8Var2.r(true);
                vl8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    vl8Var2.x(showTipToast.f());
                    vl8Var2.t(showTipToast.b());
                    vl8Var2.o(showTipToast.a());
                    vl8Var2.w(showTipToast.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                vl8Var2.r(true);
                vl8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    vl8Var2.x(getModalData.f());
                    vl8Var2.t(getModalData.b());
                    vl8Var2.o(getModalData.a());
                    vl8Var2.w(getModalData.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                vl8Var2.r(true);
                vl8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    vl8Var2.x(jumpToHtmlPage.f());
                    vl8Var2.t(jumpToHtmlPage.b());
                    vl8Var2.o(jumpToHtmlPage.a());
                    vl8Var2.w(jumpToHtmlPage.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                vl8Var2.r(true);
                vl8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    vl8Var2.x(offlineUserInfo.f());
                    vl8Var2.t(offlineUserInfo.b());
                    vl8Var2.o(offlineUserInfo.a());
                    vl8Var2.w(offlineUserInfo.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                vl8Var2.r(true);
                vl8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    vl8Var2.x(deleteOfflineBundle.f());
                    vl8Var2.t(deleteOfflineBundle.b());
                    vl8Var2.o(deleteOfflineBundle.a());
                    vl8Var2.w(deleteOfflineBundle.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                vl8Var2.r(true);
                vl8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    vl8Var2.x(updateOfflineBundle.f());
                    vl8Var2.t(updateOfflineBundle.b());
                    vl8Var2.o(updateOfflineBundle.a());
                    vl8Var2.w(updateOfflineBundle.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                vl8Var2.r(true);
                vl8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    vl8Var2.x(switchOfflineInterface.f());
                    vl8Var2.t(switchOfflineInterface.b());
                    vl8Var2.o(switchOfflineInterface.a());
                    vl8Var2.w(switchOfflineInterface.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                vl8Var2.r(true);
                vl8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    vl8Var2.x(switchOfflineBundleStatus.f());
                    vl8Var2.t(switchOfflineBundleStatus.b());
                    vl8Var2.o(switchOfflineBundleStatus.a());
                    vl8Var2.w(switchOfflineBundleStatus.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                vl8Var2.r(true);
                vl8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    vl8Var2.x(finishTestAnswer.f());
                    vl8Var2.t(finishTestAnswer.b());
                    vl8Var2.o(finishTestAnswer.a());
                    vl8Var2.w(finishTestAnswer.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                vl8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                vl8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    vl8Var2.x(switchUrlHost.f());
                    vl8Var2.t(switchUrlHost.b());
                    vl8Var2.o(switchUrlHost.a());
                    vl8Var2.w(switchUrlHost.e());
                }
                vl8Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                vl8Var2.r(true);
                vl8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    vl8Var2.x(requestByNative.f());
                    vl8Var2.t(requestByNative.b());
                    vl8Var2.o(requestByNative.a());
                    vl8Var2.w(requestByNative.e());
                    if (!vl8Var2.h()) {
                        i = 0;
                        vl8Var2.n(false);
                        addObserver("RequestByNativeToH5", vl8Var2, false);
                        vl8Var2.y(i);
                    }
                }
                i = 0;
                vl8Var2.y(i);
            }
            return vl8Var2;
        }
        return (vl8) invokeLL.objValue;
    }

    @Override // com.repackage.tl8
    public List<vl8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            vl8 vl8Var = null;
            if (ni.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                vl8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                vl8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                vl8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                vl8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                vl8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                vl8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                vl8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                vl8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                vl8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                vl8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                vl8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                vl8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                vl8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                vl8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                vl8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                vl8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (vl8Var != null) {
                vl8Var.y(0);
            }
            List<ul8> list = this.mAsyncCallBackMethodList.get(str);
            if (vl8Var != null && list != null) {
                Iterator<ul8> it = list.iterator();
                if (!ni.isEmpty(vl8Var.e())) {
                    while (it.hasNext()) {
                        ul8 next = it.next();
                        if (next.b().equals(vl8Var.e())) {
                            vl8 vl8Var2 = new vl8();
                            vl8Var2.v(next.a());
                            vl8Var2.x(vl8Var.f());
                            vl8Var2.t(vl8Var.b());
                            vl8Var2.o(vl8Var.a());
                            vl8Var2.z(vl8Var.l());
                            arrayList.add(vl8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ul8 next2 = it.next();
                        vl8 vl8Var3 = new vl8();
                        vl8Var3.v(next2.a());
                        vl8Var3.x(vl8Var.f());
                        vl8Var3.t(vl8Var.b());
                        vl8Var3.o(vl8Var.a());
                        vl8Var3.z(vl8Var.l());
                        arrayList.add(vl8Var3);
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
