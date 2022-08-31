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
import com.baidu.tieba.qi;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.wl8;
import com.baidu.tieba.xl8;
import com.baidu.tieba.yl8;
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
public class SingleQuickWebViewBridge_Proxy extends wl8 {
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

    @Override // com.baidu.tieba.wl8
    public yl8 dispatch(am8 am8Var, yl8 yl8Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, am8Var, yl8Var)) == null) {
            yl8 yl8Var2 = yl8Var == null ? new yl8() : yl8Var;
            String b = am8Var.b();
            JSONObject e = am8Var.e();
            if (b.equals("account/startLoginModule")) {
                yl8Var2.r(true);
                yl8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    yl8Var2.x(startLoginModule.f());
                    yl8Var2.t(startLoginModule.b());
                    yl8Var2.o(startLoginModule.a());
                    yl8Var2.w(startLoginModule.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                yl8Var2.r(true);
                yl8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    yl8Var2.x(finishPage.f());
                    yl8Var2.t(finishPage.b());
                    yl8Var2.o(finishPage.a());
                    yl8Var2.w(finishPage.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                yl8Var2.r(true);
                yl8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    yl8Var2.x(showLowerHairHint.f());
                    yl8Var2.t(showLowerHairHint.b());
                    yl8Var2.o(showLowerHairHint.a());
                    yl8Var2.w(showLowerHairHint.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                yl8Var2.r(true);
                yl8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    yl8Var2.x(gamePush.f());
                    yl8Var2.t(gamePush.b());
                    yl8Var2.o(gamePush.a());
                    yl8Var2.w(gamePush.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                yl8Var2.r(true);
                yl8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    yl8Var2.x(handleGamePushStatus.f());
                    yl8Var2.t(handleGamePushStatus.b());
                    yl8Var2.o(handleGamePushStatus.a());
                    yl8Var2.w(handleGamePushStatus.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                yl8Var2.r(true);
                yl8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    yl8Var2.x(jumpForumRulesEditPage.f());
                    yl8Var2.t(jumpForumRulesEditPage.b());
                    yl8Var2.o(jumpForumRulesEditPage.a());
                    yl8Var2.w(jumpForumRulesEditPage.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                yl8Var2.r(true);
                yl8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    yl8Var2.x(handleGoToBarDetail.f());
                    yl8Var2.t(handleGoToBarDetail.b());
                    yl8Var2.o(handleGoToBarDetail.a());
                    yl8Var2.w(handleGoToBarDetail.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                yl8Var2.r(true);
                yl8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    yl8Var2.x(handleSaveImage.f());
                    yl8Var2.t(handleSaveImage.b());
                    yl8Var2.o(handleSaveImage.a());
                    yl8Var2.w(handleSaveImage.e());
                    if (!yl8Var2.h()) {
                        yl8Var2.n(false);
                        addObserver("saveImageSuccess", yl8Var2, false);
                    }
                }
                yl8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                yl8Var2.r(true);
                yl8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    yl8Var2.x(handleGetPhotoAlbum.f());
                    yl8Var2.t(handleGetPhotoAlbum.b());
                    yl8Var2.o(handleGetPhotoAlbum.a());
                    yl8Var2.w(handleGetPhotoAlbum.e());
                    if (!yl8Var2.h()) {
                        yl8Var2.n(false);
                        addObserver("GetPhotoAlbum", yl8Var2, false);
                    }
                }
                yl8Var2.y(0);
            } else if (b.equals("router/portal")) {
                yl8Var2.r(true);
                yl8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    yl8Var2.x(handlePortal.f());
                    yl8Var2.t(handlePortal.b());
                    yl8Var2.o(handlePortal.a());
                    yl8Var2.w(handlePortal.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                yl8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                yl8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    yl8Var2.x(selectPhotoAlbum.f());
                    yl8Var2.t(selectPhotoAlbum.b());
                    yl8Var2.o(selectPhotoAlbum.a());
                    yl8Var2.w(selectPhotoAlbum.e());
                    if (!yl8Var2.h()) {
                        yl8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, yl8Var2, false);
                    }
                }
                yl8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                yl8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                yl8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    yl8Var2.x(selectPrivateMsg.f());
                    yl8Var2.t(selectPrivateMsg.b());
                    yl8Var2.o(selectPrivateMsg.a());
                    yl8Var2.w(selectPrivateMsg.e());
                    if (!yl8Var2.h()) {
                        yl8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", yl8Var2, false);
                    }
                }
                yl8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                yl8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                yl8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    yl8Var2.x(reportUserTheme.f());
                    yl8Var2.t(reportUserTheme.b());
                    yl8Var2.o(reportUserTheme.a());
                    yl8Var2.w(reportUserTheme.e());
                    if (!yl8Var2.h()) {
                        yl8Var2.n(false);
                        addObserver("goToReportThreadPage", yl8Var2, false);
                    }
                }
                yl8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                yl8Var2.r(true);
                yl8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    yl8Var2.x(playSound.f());
                    yl8Var2.t(playSound.b());
                    yl8Var2.o(playSound.a());
                    yl8Var2.w(playSound.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                yl8Var2.r(true);
                yl8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    yl8Var2.x(playVibrate.f());
                    yl8Var2.t(playVibrate.b());
                    yl8Var2.o(playVibrate.a());
                    yl8Var2.w(playVibrate.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                yl8Var2.r(true);
                yl8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    yl8Var2.x(jumpLoginActivity.f());
                    yl8Var2.t(jumpLoginActivity.b());
                    yl8Var2.o(jumpLoginActivity.a());
                    yl8Var2.w(jumpLoginActivity.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                yl8Var2.r(true);
                yl8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    yl8Var2.x(startLoadTimeInterval.f());
                    yl8Var2.t(startLoadTimeInterval.b());
                    yl8Var2.o(startLoadTimeInterval.a());
                    yl8Var2.w(startLoadTimeInterval.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                yl8Var2.r(true);
                yl8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    yl8Var2.x(zid.f());
                    yl8Var2.t(zid.b());
                    yl8Var2.o(zid.a());
                    yl8Var2.w(zid.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                yl8Var2.r(true);
                yl8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    yl8Var2.x(hdid.f());
                    yl8Var2.t(hdid.b());
                    yl8Var2.o(hdid.a());
                    yl8Var2.w(hdid.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                yl8Var2.r(true);
                yl8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    yl8Var2.x(shareInfo.f());
                    yl8Var2.t(shareInfo.b());
                    yl8Var2.o(shareInfo.a());
                    yl8Var2.w(shareInfo.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("share/share")) {
                yl8Var2.r(true);
                yl8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"));
                if (share != null) {
                    yl8Var2.x(share.f());
                    yl8Var2.t(share.b());
                    yl8Var2.o(share.a());
                    yl8Var2.w(share.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                yl8Var2.r(true);
                yl8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    yl8Var2.x(clipperInformation.f());
                    yl8Var2.t(clipperInformation.b());
                    yl8Var2.o(clipperInformation.a());
                    yl8Var2.w(clipperInformation.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                yl8Var2.r(true);
                yl8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    yl8Var2.x(clipperInformation2.f());
                    yl8Var2.t(clipperInformation2.b());
                    yl8Var2.o(clipperInformation2.a());
                    yl8Var2.w(clipperInformation2.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                yl8Var2.r(true);
                yl8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    yl8Var2.x(goToEditPost.f());
                    yl8Var2.t(goToEditPost.b());
                    yl8Var2.o(goToEditPost.a());
                    yl8Var2.w(goToEditPost.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                yl8Var2.r(true);
                yl8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    yl8Var2.x(updateSearchForumInfo.f());
                    yl8Var2.t(updateSearchForumInfo.b());
                    yl8Var2.o(updateSearchForumInfo.a());
                    yl8Var2.w(updateSearchForumInfo.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                yl8Var2.r(true);
                yl8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    yl8Var2.x(personlizedSwitchChange.f());
                    yl8Var2.t(personlizedSwitchChange.b());
                    yl8Var2.o(personlizedSwitchChange.a());
                    yl8Var2.w(personlizedSwitchChange.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                yl8Var2.r(true);
                yl8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    yl8Var2.x(goToVideoImmersivePage.f());
                    yl8Var2.t(goToVideoImmersivePage.b());
                    yl8Var2.o(goToVideoImmersivePage.a());
                    yl8Var2.w(goToVideoImmersivePage.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                yl8Var2.r(true);
                yl8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    yl8Var2.x(jumpToVideo.f());
                    yl8Var2.t(jumpToVideo.b());
                    yl8Var2.o(jumpToVideo.a());
                    yl8Var2.w(jumpToVideo.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                yl8Var2.r(true);
                yl8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    yl8Var2.x(closeNativeMask.f());
                    yl8Var2.t(closeNativeMask.b());
                    yl8Var2.o(closeNativeMask.a());
                    yl8Var2.w(closeNativeMask.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                yl8Var2.r(true);
                yl8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    yl8Var2.x(checkAppInstall.f());
                    yl8Var2.t(checkAppInstall.b());
                    yl8Var2.o(checkAppInstall.a());
                    yl8Var2.w(checkAppInstall.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                yl8Var2.r(true);
                yl8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    yl8Var2.x(disableBack.f());
                    yl8Var2.t(disableBack.b());
                    yl8Var2.o(disableBack.a());
                    yl8Var2.w(disableBack.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                yl8Var2.r(true);
                yl8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    yl8Var2.x(startApp.f());
                    yl8Var2.t(startApp.b());
                    yl8Var2.o(startApp.a());
                    yl8Var2.w(startApp.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                yl8Var2.r(true);
                yl8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    yl8Var2.x(hasNotificationPermission.f());
                    yl8Var2.t(hasNotificationPermission.b());
                    yl8Var2.o(hasNotificationPermission.a());
                    yl8Var2.w(hasNotificationPermission.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                yl8Var2.r(true);
                yl8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    yl8Var2.x(goToNotificationSetting.f());
                    yl8Var2.t(goToNotificationSetting.b());
                    yl8Var2.o(goToNotificationSetting.a());
                    yl8Var2.w(goToNotificationSetting.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                yl8Var2.r(true);
                yl8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    yl8Var2.x(startDownloadCss.f());
                    yl8Var2.t(startDownloadCss.b());
                    yl8Var2.o(startDownloadCss.a());
                    yl8Var2.w(startDownloadCss.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                yl8Var2.r(true);
                yl8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    yl8Var2.x(disableGoBack.f());
                    yl8Var2.t(disableGoBack.b());
                    yl8Var2.o(disableGoBack.a());
                    yl8Var2.w(disableGoBack.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                yl8Var2.r(true);
                yl8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    yl8Var2.x(supplementInfo.f());
                    yl8Var2.t(supplementInfo.b());
                    yl8Var2.o(supplementInfo.a());
                    yl8Var2.w(supplementInfo.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                yl8Var2.r(true);
                yl8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    yl8Var2.x(deviceInfo.f());
                    yl8Var2.t(deviceInfo.b());
                    yl8Var2.o(deviceInfo.a());
                    yl8Var2.w(deviceInfo.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                yl8Var2.r(true);
                yl8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    yl8Var2.x(sendCompleteTaskReqMsg.f());
                    yl8Var2.t(sendCompleteTaskReqMsg.b());
                    yl8Var2.o(sendCompleteTaskReqMsg.a());
                    yl8Var2.w(sendCompleteTaskReqMsg.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                yl8Var2.r(true);
                yl8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    yl8Var2.x(showTipToast.f());
                    yl8Var2.t(showTipToast.b());
                    yl8Var2.o(showTipToast.a());
                    yl8Var2.w(showTipToast.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                yl8Var2.r(true);
                yl8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    yl8Var2.x(getModalData.f());
                    yl8Var2.t(getModalData.b());
                    yl8Var2.o(getModalData.a());
                    yl8Var2.w(getModalData.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                yl8Var2.r(true);
                yl8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    yl8Var2.x(jumpToHtmlPage.f());
                    yl8Var2.t(jumpToHtmlPage.b());
                    yl8Var2.o(jumpToHtmlPage.a());
                    yl8Var2.w(jumpToHtmlPage.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                yl8Var2.r(true);
                yl8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    yl8Var2.x(offlineUserInfo.f());
                    yl8Var2.t(offlineUserInfo.b());
                    yl8Var2.o(offlineUserInfo.a());
                    yl8Var2.w(offlineUserInfo.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                yl8Var2.r(true);
                yl8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    yl8Var2.x(deleteOfflineBundle.f());
                    yl8Var2.t(deleteOfflineBundle.b());
                    yl8Var2.o(deleteOfflineBundle.a());
                    yl8Var2.w(deleteOfflineBundle.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                yl8Var2.r(true);
                yl8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    yl8Var2.x(updateOfflineBundle.f());
                    yl8Var2.t(updateOfflineBundle.b());
                    yl8Var2.o(updateOfflineBundle.a());
                    yl8Var2.w(updateOfflineBundle.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                yl8Var2.r(true);
                yl8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    yl8Var2.x(switchOfflineInterface.f());
                    yl8Var2.t(switchOfflineInterface.b());
                    yl8Var2.o(switchOfflineInterface.a());
                    yl8Var2.w(switchOfflineInterface.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                yl8Var2.r(true);
                yl8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    yl8Var2.x(switchOfflineBundleStatus.f());
                    yl8Var2.t(switchOfflineBundleStatus.b());
                    yl8Var2.o(switchOfflineBundleStatus.a());
                    yl8Var2.w(switchOfflineBundleStatus.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                yl8Var2.r(true);
                yl8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    yl8Var2.x(finishTestAnswer.f());
                    yl8Var2.t(finishTestAnswer.b());
                    yl8Var2.o(finishTestAnswer.a());
                    yl8Var2.w(finishTestAnswer.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                yl8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                yl8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    yl8Var2.x(switchUrlHost.f());
                    yl8Var2.t(switchUrlHost.b());
                    yl8Var2.o(switchUrlHost.a());
                    yl8Var2.w(switchUrlHost.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                yl8Var2.r(true);
                yl8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    yl8Var2.x(appStorage.f());
                    yl8Var2.t(appStorage.b());
                    yl8Var2.o(appStorage.a());
                    yl8Var2.w(appStorage.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                yl8Var2.r(true);
                yl8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    yl8Var2.x(putAppStorage.f());
                    yl8Var2.t(putAppStorage.b());
                    yl8Var2.o(putAppStorage.a());
                    yl8Var2.w(putAppStorage.e());
                }
                yl8Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                yl8Var2.r(true);
                yl8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    yl8Var2.x(requestByNative.f());
                    yl8Var2.t(requestByNative.b());
                    yl8Var2.o(requestByNative.a());
                    yl8Var2.w(requestByNative.e());
                    if (!yl8Var2.h()) {
                        i = 0;
                        yl8Var2.n(false);
                        addObserver("RequestByNativeToH5", yl8Var2, false);
                        yl8Var2.y(i);
                    }
                }
                i = 0;
                yl8Var2.y(i);
            }
            return yl8Var2;
        }
        return (yl8) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.wl8
    public List<yl8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            yl8 yl8Var = null;
            if (qi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                yl8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                yl8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                yl8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                yl8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                yl8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                yl8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                yl8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                yl8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                yl8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                yl8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                yl8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                yl8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                yl8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                yl8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                yl8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                yl8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                yl8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (yl8Var != null) {
                yl8Var.y(0);
            }
            List<xl8> list = this.mAsyncCallBackMethodList.get(str);
            if (yl8Var != null && list != null) {
                Iterator<xl8> it = list.iterator();
                if (!qi.isEmpty(yl8Var.e())) {
                    while (it.hasNext()) {
                        xl8 next = it.next();
                        if (next.b().equals(yl8Var.e())) {
                            yl8 yl8Var2 = new yl8();
                            yl8Var2.v(next.a());
                            yl8Var2.x(yl8Var.f());
                            yl8Var2.t(yl8Var.b());
                            yl8Var2.o(yl8Var.a());
                            yl8Var2.z(yl8Var.l());
                            arrayList.add(yl8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        xl8 next2 = it.next();
                        yl8 yl8Var3 = new yl8();
                        yl8Var3.v(next2.a());
                        yl8Var3.x(yl8Var.f());
                        yl8Var3.t(yl8Var.b());
                        yl8Var3.o(yl8Var.a());
                        yl8Var3.z(yl8Var.l());
                        arrayList.add(yl8Var3);
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
