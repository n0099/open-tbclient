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
import com.baidu.tieba.ao8;
import com.baidu.tieba.bo8;
import com.baidu.tieba.dj;
import com.baidu.tieba.do8;
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
import com.baidu.tieba.zn8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class QuickWebViewBridge_Proxy extends zn8 {
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

    @Override // com.baidu.tieba.zn8
    public bo8 dispatch(do8 do8Var, bo8 bo8Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, do8Var, bo8Var)) == null) {
            bo8 bo8Var2 = bo8Var == null ? new bo8() : bo8Var;
            String b = do8Var.b();
            JSONObject e = do8Var.e();
            if (b.equals("account/startLoginModule")) {
                bo8Var2.r(true);
                bo8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    bo8Var2.x(startLoginModule.f());
                    bo8Var2.t(startLoginModule.b());
                    bo8Var2.o(startLoginModule.a());
                    bo8Var2.w(startLoginModule.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                bo8Var2.r(true);
                bo8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    bo8Var2.x(finishPage.f());
                    bo8Var2.t(finishPage.b());
                    bo8Var2.o(finishPage.a());
                    bo8Var2.w(finishPage.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                bo8Var2.r(true);
                bo8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    bo8Var2.x(showLowerHairHint.f());
                    bo8Var2.t(showLowerHairHint.b());
                    bo8Var2.o(showLowerHairHint.a());
                    bo8Var2.w(showLowerHairHint.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                bo8Var2.r(true);
                bo8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    bo8Var2.x(gamePush.f());
                    bo8Var2.t(gamePush.b());
                    bo8Var2.o(gamePush.a());
                    bo8Var2.w(gamePush.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                bo8Var2.r(true);
                bo8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    bo8Var2.x(handleGamePushStatus.f());
                    bo8Var2.t(handleGamePushStatus.b());
                    bo8Var2.o(handleGamePushStatus.a());
                    bo8Var2.w(handleGamePushStatus.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                bo8Var2.r(true);
                bo8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    bo8Var2.x(jumpForumRulesEditPage.f());
                    bo8Var2.t(jumpForumRulesEditPage.b());
                    bo8Var2.o(jumpForumRulesEditPage.a());
                    bo8Var2.w(jumpForumRulesEditPage.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                bo8Var2.r(true);
                bo8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    bo8Var2.x(handleGoToBarDetail.f());
                    bo8Var2.t(handleGoToBarDetail.b());
                    bo8Var2.o(handleGoToBarDetail.a());
                    bo8Var2.w(handleGoToBarDetail.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                bo8Var2.r(true);
                bo8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    bo8Var2.x(handleSaveImage.f());
                    bo8Var2.t(handleSaveImage.b());
                    bo8Var2.o(handleSaveImage.a());
                    bo8Var2.w(handleSaveImage.e());
                    if (!bo8Var2.h()) {
                        bo8Var2.n(false);
                        addObserver("saveImageSuccess", bo8Var2, false);
                    }
                }
                bo8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                bo8Var2.r(true);
                bo8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    bo8Var2.x(handleGetPhotoAlbum.f());
                    bo8Var2.t(handleGetPhotoAlbum.b());
                    bo8Var2.o(handleGetPhotoAlbum.a());
                    bo8Var2.w(handleGetPhotoAlbum.e());
                    if (!bo8Var2.h()) {
                        bo8Var2.n(false);
                        addObserver("GetPhotoAlbum", bo8Var2, false);
                    }
                }
                bo8Var2.y(0);
            } else if (b.equals("payment/openMXDYab")) {
                bo8Var2.r(true);
                bo8 openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    bo8Var2.x(openMXDYab.f());
                    bo8Var2.t(openMXDYab.b());
                    bo8Var2.o(openMXDYab.a());
                    bo8Var2.w(openMXDYab.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("router/portal")) {
                bo8Var2.r(true);
                bo8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    bo8Var2.x(handlePortal.f());
                    bo8Var2.t(handlePortal.b());
                    bo8Var2.o(handlePortal.a());
                    bo8Var2.w(handlePortal.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                bo8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                bo8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    bo8Var2.x(selectPhotoAlbum.f());
                    bo8Var2.t(selectPhotoAlbum.b());
                    bo8Var2.o(selectPhotoAlbum.a());
                    bo8Var2.w(selectPhotoAlbum.e());
                    if (!bo8Var2.h()) {
                        bo8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, bo8Var2, false);
                    }
                }
                bo8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                bo8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                bo8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    bo8Var2.x(selectPrivateMsg.f());
                    bo8Var2.t(selectPrivateMsg.b());
                    bo8Var2.o(selectPrivateMsg.a());
                    bo8Var2.w(selectPrivateMsg.e());
                    if (!bo8Var2.h()) {
                        bo8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", bo8Var2, false);
                    }
                }
                bo8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                bo8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                bo8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    bo8Var2.x(reportUserTheme.f());
                    bo8Var2.t(reportUserTheme.b());
                    bo8Var2.o(reportUserTheme.a());
                    bo8Var2.w(reportUserTheme.e());
                    if (!bo8Var2.h()) {
                        bo8Var2.n(false);
                        addObserver("goToReportThreadPage", bo8Var2, false);
                    }
                }
                bo8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                bo8Var2.r(true);
                bo8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    bo8Var2.x(playSound.f());
                    bo8Var2.t(playSound.b());
                    bo8Var2.o(playSound.a());
                    bo8Var2.w(playSound.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                bo8Var2.r(true);
                bo8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    bo8Var2.x(playVibrate.f());
                    bo8Var2.t(playVibrate.b());
                    bo8Var2.o(playVibrate.a());
                    bo8Var2.w(playVibrate.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                bo8Var2.r(true);
                bo8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    bo8Var2.x(jumpLoginActivity.f());
                    bo8Var2.t(jumpLoginActivity.b());
                    bo8Var2.o(jumpLoginActivity.a());
                    bo8Var2.w(jumpLoginActivity.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                bo8Var2.r(true);
                bo8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    bo8Var2.x(startLoadTimeInterval.f());
                    bo8Var2.t(startLoadTimeInterval.b());
                    bo8Var2.o(startLoadTimeInterval.a());
                    bo8Var2.w(startLoadTimeInterval.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                bo8Var2.r(true);
                bo8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    bo8Var2.x(zid.f());
                    bo8Var2.t(zid.b());
                    bo8Var2.o(zid.a());
                    bo8Var2.w(zid.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                bo8Var2.r(true);
                bo8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    bo8Var2.x(hdid.f());
                    bo8Var2.t(hdid.b());
                    bo8Var2.o(hdid.a());
                    bo8Var2.w(hdid.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                bo8Var2.r(true);
                bo8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    bo8Var2.x(shareInfo.f());
                    bo8Var2.t(shareInfo.b());
                    bo8Var2.o(shareInfo.a());
                    bo8Var2.w(shareInfo.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("share/share")) {
                bo8Var2.r(true);
                bo8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"));
                if (share != null) {
                    bo8Var2.x(share.f());
                    bo8Var2.t(share.b());
                    bo8Var2.o(share.a());
                    bo8Var2.w(share.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                bo8Var2.r(true);
                bo8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    bo8Var2.x(clipperInformation.f());
                    bo8Var2.t(clipperInformation.b());
                    bo8Var2.o(clipperInformation.a());
                    bo8Var2.w(clipperInformation.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                bo8Var2.r(true);
                bo8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    bo8Var2.x(clipperInformation2.f());
                    bo8Var2.t(clipperInformation2.b());
                    bo8Var2.o(clipperInformation2.a());
                    bo8Var2.w(clipperInformation2.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                bo8Var2.r(true);
                bo8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    bo8Var2.x(goToEditPost.f());
                    bo8Var2.t(goToEditPost.b());
                    bo8Var2.o(goToEditPost.a());
                    bo8Var2.w(goToEditPost.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                bo8Var2.r(true);
                bo8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    bo8Var2.x(updateSearchForumInfo.f());
                    bo8Var2.t(updateSearchForumInfo.b());
                    bo8Var2.o(updateSearchForumInfo.a());
                    bo8Var2.w(updateSearchForumInfo.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                bo8Var2.r(true);
                bo8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    bo8Var2.x(personlizedSwitchChange.f());
                    bo8Var2.t(personlizedSwitchChange.b());
                    bo8Var2.o(personlizedSwitchChange.a());
                    bo8Var2.w(personlizedSwitchChange.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                bo8Var2.r(true);
                bo8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    bo8Var2.x(goToVideoImmersivePage.f());
                    bo8Var2.t(goToVideoImmersivePage.b());
                    bo8Var2.o(goToVideoImmersivePage.a());
                    bo8Var2.w(goToVideoImmersivePage.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                bo8Var2.r(true);
                bo8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    bo8Var2.x(jumpToVideo.f());
                    bo8Var2.t(jumpToVideo.b());
                    bo8Var2.o(jumpToVideo.a());
                    bo8Var2.w(jumpToVideo.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                bo8Var2.r(true);
                bo8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    bo8Var2.x(closeNativeMask.f());
                    bo8Var2.t(closeNativeMask.b());
                    bo8Var2.o(closeNativeMask.a());
                    bo8Var2.w(closeNativeMask.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                bo8Var2.r(true);
                bo8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    bo8Var2.x(checkAppInstall.f());
                    bo8Var2.t(checkAppInstall.b());
                    bo8Var2.o(checkAppInstall.a());
                    bo8Var2.w(checkAppInstall.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                bo8Var2.r(true);
                bo8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    bo8Var2.x(disableBack.f());
                    bo8Var2.t(disableBack.b());
                    bo8Var2.o(disableBack.a());
                    bo8Var2.w(disableBack.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                bo8Var2.r(true);
                bo8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    bo8Var2.x(startApp.f());
                    bo8Var2.t(startApp.b());
                    bo8Var2.o(startApp.a());
                    bo8Var2.w(startApp.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                bo8Var2.r(true);
                bo8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    bo8Var2.x(hasNotificationPermission.f());
                    bo8Var2.t(hasNotificationPermission.b());
                    bo8Var2.o(hasNotificationPermission.a());
                    bo8Var2.w(hasNotificationPermission.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                bo8Var2.r(true);
                bo8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    bo8Var2.x(goToNotificationSetting.f());
                    bo8Var2.t(goToNotificationSetting.b());
                    bo8Var2.o(goToNotificationSetting.a());
                    bo8Var2.w(goToNotificationSetting.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                bo8Var2.r(true);
                bo8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    bo8Var2.x(startDownloadCss.f());
                    bo8Var2.t(startDownloadCss.b());
                    bo8Var2.o(startDownloadCss.a());
                    bo8Var2.w(startDownloadCss.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                bo8Var2.r(true);
                bo8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    bo8Var2.x(disableGoBack.f());
                    bo8Var2.t(disableGoBack.b());
                    bo8Var2.o(disableGoBack.a());
                    bo8Var2.w(disableGoBack.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                bo8Var2.r(true);
                bo8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    bo8Var2.x(supplementInfo.f());
                    bo8Var2.t(supplementInfo.b());
                    bo8Var2.o(supplementInfo.a());
                    bo8Var2.w(supplementInfo.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                bo8Var2.r(true);
                bo8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    bo8Var2.x(deviceInfo.f());
                    bo8Var2.t(deviceInfo.b());
                    bo8Var2.o(deviceInfo.a());
                    bo8Var2.w(deviceInfo.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                bo8Var2.r(true);
                bo8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    bo8Var2.x(sendCompleteTaskReqMsg.f());
                    bo8Var2.t(sendCompleteTaskReqMsg.b());
                    bo8Var2.o(sendCompleteTaskReqMsg.a());
                    bo8Var2.w(sendCompleteTaskReqMsg.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                bo8Var2.r(true);
                bo8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    bo8Var2.x(showTipToast.f());
                    bo8Var2.t(showTipToast.b());
                    bo8Var2.o(showTipToast.a());
                    bo8Var2.w(showTipToast.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                bo8Var2.r(true);
                bo8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    bo8Var2.x(getModalData.f());
                    bo8Var2.t(getModalData.b());
                    bo8Var2.o(getModalData.a());
                    bo8Var2.w(getModalData.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                bo8Var2.r(true);
                bo8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    bo8Var2.x(jumpToHtmlPage.f());
                    bo8Var2.t(jumpToHtmlPage.b());
                    bo8Var2.o(jumpToHtmlPage.a());
                    bo8Var2.w(jumpToHtmlPage.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                bo8Var2.r(true);
                bo8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    bo8Var2.x(offlineUserInfo.f());
                    bo8Var2.t(offlineUserInfo.b());
                    bo8Var2.o(offlineUserInfo.a());
                    bo8Var2.w(offlineUserInfo.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                bo8Var2.r(true);
                bo8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    bo8Var2.x(deleteOfflineBundle.f());
                    bo8Var2.t(deleteOfflineBundle.b());
                    bo8Var2.o(deleteOfflineBundle.a());
                    bo8Var2.w(deleteOfflineBundle.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                bo8Var2.r(true);
                bo8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    bo8Var2.x(updateOfflineBundle.f());
                    bo8Var2.t(updateOfflineBundle.b());
                    bo8Var2.o(updateOfflineBundle.a());
                    bo8Var2.w(updateOfflineBundle.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                bo8Var2.r(true);
                bo8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    bo8Var2.x(switchOfflineInterface.f());
                    bo8Var2.t(switchOfflineInterface.b());
                    bo8Var2.o(switchOfflineInterface.a());
                    bo8Var2.w(switchOfflineInterface.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                bo8Var2.r(true);
                bo8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    bo8Var2.x(switchOfflineBundleStatus.f());
                    bo8Var2.t(switchOfflineBundleStatus.b());
                    bo8Var2.o(switchOfflineBundleStatus.a());
                    bo8Var2.w(switchOfflineBundleStatus.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                bo8Var2.r(true);
                bo8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    bo8Var2.x(finishTestAnswer.f());
                    bo8Var2.t(finishTestAnswer.b());
                    bo8Var2.o(finishTestAnswer.a());
                    bo8Var2.w(finishTestAnswer.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                bo8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                bo8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    bo8Var2.x(switchUrlHost.f());
                    bo8Var2.t(switchUrlHost.b());
                    bo8Var2.o(switchUrlHost.a());
                    bo8Var2.w(switchUrlHost.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                bo8Var2.r(true);
                bo8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    bo8Var2.x(appStorage.f());
                    bo8Var2.t(appStorage.b());
                    bo8Var2.o(appStorage.a());
                    bo8Var2.w(appStorage.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                bo8Var2.r(true);
                bo8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    bo8Var2.x(putAppStorage.f());
                    bo8Var2.t(putAppStorage.b());
                    bo8Var2.o(putAppStorage.a());
                    bo8Var2.w(putAppStorage.e());
                }
                bo8Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                bo8Var2.r(true);
                bo8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    bo8Var2.x(requestByNative.f());
                    bo8Var2.t(requestByNative.b());
                    bo8Var2.o(requestByNative.a());
                    bo8Var2.w(requestByNative.e());
                    if (!bo8Var2.h()) {
                        i = 0;
                        bo8Var2.n(false);
                        addObserver("RequestByNativeToH5", bo8Var2, false);
                        bo8Var2.y(i);
                    }
                }
                i = 0;
                bo8Var2.y(i);
            }
            return bo8Var2;
        }
        return (bo8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.zn8
    public List<bo8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            bo8 bo8Var = null;
            if (dj.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                bo8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                bo8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                bo8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                bo8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                bo8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                bo8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                bo8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                bo8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                bo8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                bo8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                bo8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                bo8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                bo8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                bo8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                bo8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                bo8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                bo8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (bo8Var != null) {
                bo8Var.y(0);
            }
            List<ao8> list = this.mAsyncCallBackMethodList.get(str);
            if (bo8Var != null && list != null) {
                Iterator<ao8> it = list.iterator();
                if (!dj.isEmpty(bo8Var.e())) {
                    while (it.hasNext()) {
                        ao8 next = it.next();
                        if (next.b().equals(bo8Var.e())) {
                            bo8 bo8Var2 = new bo8();
                            bo8Var2.v(next.a());
                            bo8Var2.x(bo8Var.f());
                            bo8Var2.t(bo8Var.b());
                            bo8Var2.o(bo8Var.a());
                            bo8Var2.z(bo8Var.l());
                            arrayList.add(bo8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        ao8 next2 = it.next();
                        bo8 bo8Var3 = new bo8();
                        bo8Var3.v(next2.a());
                        bo8Var3.x(bo8Var.f());
                        bo8Var3.t(bo8Var.b());
                        bo8Var3.o(bo8Var.a());
                        bo8Var3.z(bo8Var.l());
                        arrayList.add(bo8Var3);
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
