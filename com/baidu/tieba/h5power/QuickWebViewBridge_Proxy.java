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
import com.repackage.pi;
import com.repackage.rl8;
import com.repackage.sl8;
import com.repackage.tl8;
import com.repackage.vl8;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class QuickWebViewBridge_Proxy extends rl8 {
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

    @Override // com.repackage.rl8
    public tl8 dispatch(vl8 vl8Var, tl8 tl8Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vl8Var, tl8Var)) == null) {
            tl8 tl8Var2 = tl8Var == null ? new tl8() : tl8Var;
            String b = vl8Var.b();
            JSONObject e = vl8Var.e();
            if (b.equals("account/startLoginModule")) {
                tl8Var2.r(true);
                tl8 startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    tl8Var2.x(startLoginModule.f());
                    tl8Var2.t(startLoginModule.b());
                    tl8Var2.o(startLoginModule.a());
                    tl8Var2.w(startLoginModule.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("router/finishThisPage")) {
                tl8Var2.r(true);
                tl8 finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    tl8Var2.x(finishPage.f());
                    tl8Var2.t(finishPage.b());
                    tl8Var2.o(finishPage.a());
                    tl8Var2.w(finishPage.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("toast/toastPopupView")) {
                tl8Var2.r(true);
                tl8 showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    tl8Var2.x(showLowerHairHint.f());
                    tl8Var2.t(showLowerHairHint.b());
                    tl8Var2.o(showLowerHairHint.a());
                    tl8Var2.w(showLowerHairHint.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("subscription/gamePush")) {
                tl8Var2.r(true);
                tl8 gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    tl8Var2.x(gamePush.f());
                    tl8Var2.t(gamePush.b());
                    tl8Var2.o(gamePush.a());
                    tl8Var2.w(gamePush.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                tl8Var2.r(true);
                tl8 handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    tl8Var2.x(handleGamePushStatus.f());
                    tl8Var2.t(handleGamePushStatus.b());
                    tl8Var2.o(handleGamePushStatus.a());
                    tl8Var2.w(handleGamePushStatus.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                tl8Var2.r(true);
                tl8 jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    tl8Var2.x(jumpForumRulesEditPage.f());
                    tl8Var2.t(jumpForumRulesEditPage.b());
                    tl8Var2.o(jumpForumRulesEditPage.a());
                    tl8Var2.w(jumpForumRulesEditPage.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("router/goToBarDetail")) {
                tl8Var2.r(true);
                tl8 handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString(TbTitleActivityConfig.FORUM_ID), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    tl8Var2.x(handleGoToBarDetail.f());
                    tl8Var2.t(handleGoToBarDetail.b());
                    tl8Var2.o(handleGoToBarDetail.a());
                    tl8Var2.w(handleGoToBarDetail.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/saveImage")) {
                tl8Var2.r(true);
                tl8 handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    tl8Var2.x(handleSaveImage.f());
                    tl8Var2.t(handleSaveImage.b());
                    tl8Var2.o(handleSaveImage.a());
                    tl8Var2.w(handleSaveImage.e());
                    if (!tl8Var2.h()) {
                        tl8Var2.n(false);
                        addObserver("saveImageSuccess", tl8Var2, false);
                    }
                }
                tl8Var2.y(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                tl8Var2.r(true);
                tl8 handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    tl8Var2.x(handleGetPhotoAlbum.f());
                    tl8Var2.t(handleGetPhotoAlbum.b());
                    tl8Var2.o(handleGetPhotoAlbum.a());
                    tl8Var2.w(handleGetPhotoAlbum.e());
                    if (!tl8Var2.h()) {
                        tl8Var2.n(false);
                        addObserver("GetPhotoAlbum", tl8Var2, false);
                    }
                }
                tl8Var2.y(0);
            } else if (b.equals("router/portal")) {
                tl8Var2.r(true);
                tl8 handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString("pageParams"));
                if (handlePortal != null) {
                    tl8Var2.x(handlePortal.f());
                    tl8Var2.t(handlePortal.b());
                    tl8Var2.o(handlePortal.a());
                    tl8Var2.w(handlePortal.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                tl8Var2.r(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("imageArray"));
                tl8 selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList);
                this.mNotificationNameList.add(CommonTbJsBridge.SELECT_PHOTO_ALBUM);
                if (selectPhotoAlbum != null) {
                    tl8Var2.x(selectPhotoAlbum.f());
                    tl8Var2.t(selectPhotoAlbum.b());
                    tl8Var2.o(selectPhotoAlbum.a());
                    tl8Var2.w(selectPhotoAlbum.e());
                    if (!tl8Var2.h()) {
                        tl8Var2.n(false);
                        addObserver(CommonTbJsBridge.SELECT_PHOTO_ALBUM, tl8Var2, false);
                    }
                }
                tl8Var2.y(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                tl8Var2.r(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("msgArray"));
                tl8 selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList2);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    tl8Var2.x(selectPrivateMsg.f());
                    tl8Var2.t(selectPrivateMsg.b());
                    tl8Var2.o(selectPrivateMsg.a());
                    tl8Var2.w(selectPrivateMsg.e());
                    if (!tl8Var2.h()) {
                        tl8Var2.n(false);
                        addObserver("goToSelectPrivateMsgPage", tl8Var2, false);
                    }
                }
                tl8Var2.y(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                tl8Var2.r(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("threadArray"));
                tl8 reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList3);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    tl8Var2.x(reportUserTheme.f());
                    tl8Var2.t(reportUserTheme.b());
                    tl8Var2.o(reportUserTheme.a());
                    tl8Var2.w(reportUserTheme.e());
                    if (!tl8Var2.h()) {
                        tl8Var2.n(false);
                        addObserver("goToReportThreadPage", tl8Var2, false);
                    }
                }
                tl8Var2.y(0);
            } else if (b.equals("system/playSound")) {
                tl8Var2.r(true);
                tl8 playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    tl8Var2.x(playSound.f());
                    tl8Var2.t(playSound.b());
                    tl8Var2.o(playSound.a());
                    tl8Var2.w(playSound.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/playVibrate")) {
                tl8Var2.r(true);
                tl8 playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    tl8Var2.x(playVibrate.f());
                    tl8Var2.t(playVibrate.b());
                    tl8Var2.o(playVibrate.a());
                    tl8Var2.w(playVibrate.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                tl8Var2.r(true);
                tl8 jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    tl8Var2.x(jumpLoginActivity.f());
                    tl8Var2.t(jumpLoginActivity.b());
                    tl8Var2.o(jumpLoginActivity.a());
                    tl8Var2.w(jumpLoginActivity.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                tl8Var2.r(true);
                tl8 startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    tl8Var2.x(startLoadTimeInterval.f());
                    tl8Var2.t(startLoadTimeInterval.b());
                    tl8Var2.o(startLoadTimeInterval.a());
                    tl8Var2.w(startLoadTimeInterval.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("device/getZid")) {
                tl8Var2.r(true);
                tl8 zid = this.mJsBridge.getZid();
                if (zid != null) {
                    tl8Var2.x(zid.f());
                    tl8Var2.t(zid.b());
                    tl8Var2.o(zid.a());
                    tl8Var2.w(zid.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("device/getHdid")) {
                tl8Var2.r(true);
                tl8 hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    tl8Var2.x(hdid.f());
                    tl8Var2.t(hdid.b());
                    tl8Var2.o(hdid.a());
                    tl8Var2.w(hdid.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("share/registerShareDataNew")) {
                tl8Var2.r(true);
                tl8 shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    tl8Var2.x(shareInfo.f());
                    tl8Var2.t(shareInfo.b());
                    tl8Var2.o(shareInfo.a());
                    tl8Var2.w(shareInfo.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("share/share")) {
                tl8Var2.r(true);
                tl8 share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"));
                if (share != null) {
                    tl8Var2.x(share.f());
                    tl8Var2.t(share.b());
                    tl8Var2.o(share.a());
                    tl8Var2.w(share.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("clipper/getClipperInformation")) {
                tl8Var2.r(true);
                tl8 clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    tl8Var2.x(clipperInformation.f());
                    tl8Var2.t(clipperInformation.b());
                    tl8Var2.o(clipperInformation.a());
                    tl8Var2.w(clipperInformation.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                tl8Var2.r(true);
                tl8 clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    tl8Var2.x(clipperInformation2.f());
                    tl8Var2.t(clipperInformation2.b());
                    tl8Var2.o(clipperInformation2.a());
                    tl8Var2.w(clipperInformation2.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("router/goToEditPost")) {
                tl8Var2.r(true);
                tl8 goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    tl8Var2.x(goToEditPost.f());
                    tl8Var2.t(goToEditPost.b());
                    tl8Var2.o(goToEditPost.a());
                    tl8Var2.w(goToEditPost.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                tl8Var2.r(true);
                tl8 updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    tl8Var2.x(updateSearchForumInfo.f());
                    tl8Var2.t(updateSearchForumInfo.b());
                    tl8Var2.o(updateSearchForumInfo.a());
                    tl8Var2.w(updateSearchForumInfo.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                tl8Var2.r(true);
                tl8 personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    tl8Var2.x(personlizedSwitchChange.f());
                    tl8Var2.t(personlizedSwitchChange.b());
                    tl8Var2.o(personlizedSwitchChange.a());
                    tl8Var2.w(personlizedSwitchChange.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("router/videoImmersivePage")) {
                tl8Var2.r(true);
                tl8 goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("shareNum"), e.optString(TbTitleActivityConfig.FORUM_ID), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    tl8Var2.x(goToVideoImmersivePage.f());
                    tl8Var2.t(goToVideoImmersivePage.b());
                    tl8Var2.o(goToVideoImmersivePage.a());
                    tl8Var2.w(goToVideoImmersivePage.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("router/jumpToVideo")) {
                tl8Var2.r(true);
                tl8 jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    tl8Var2.x(jumpToVideo.f());
                    tl8Var2.t(jumpToVideo.b());
                    tl8Var2.o(jumpToVideo.a());
                    tl8Var2.w(jumpToVideo.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/closeNativeMask")) {
                tl8Var2.r(true);
                tl8 closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt(TiebaStatic.LogFields.RESULT));
                if (closeNativeMask != null) {
                    tl8Var2.x(closeNativeMask.f());
                    tl8Var2.t(closeNativeMask.b());
                    tl8Var2.o(closeNativeMask.a());
                    tl8Var2.w(closeNativeMask.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/checkAppInstall")) {
                tl8Var2.r(true);
                tl8 checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    tl8Var2.x(checkAppInstall.f());
                    tl8Var2.t(checkAppInstall.b());
                    tl8Var2.o(checkAppInstall.a());
                    tl8Var2.w(checkAppInstall.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/disableSlideBack")) {
                tl8Var2.r(true);
                tl8 disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    tl8Var2.x(disableBack.f());
                    tl8Var2.t(disableBack.b());
                    tl8Var2.o(disableBack.a());
                    tl8Var2.w(disableBack.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/startApp")) {
                tl8Var2.r(true);
                tl8 startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    tl8Var2.x(startApp.f());
                    tl8Var2.t(startApp.b());
                    tl8Var2.o(startApp.a());
                    tl8Var2.w(startApp.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                tl8Var2.r(true);
                tl8 hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    tl8Var2.x(hasNotificationPermission.f());
                    tl8Var2.t(hasNotificationPermission.b());
                    tl8Var2.o(hasNotificationPermission.a());
                    tl8Var2.w(hasNotificationPermission.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                tl8Var2.r(true);
                tl8 goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    tl8Var2.x(goToNotificationSetting.f());
                    tl8Var2.t(goToNotificationSetting.b());
                    tl8Var2.o(goToNotificationSetting.a());
                    tl8Var2.w(goToNotificationSetting.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("account/startDownloadCss")) {
                tl8Var2.r(true);
                tl8 startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    tl8Var2.x(startDownloadCss.f());
                    tl8Var2.t(startDownloadCss.b());
                    tl8Var2.o(startDownloadCss.a());
                    tl8Var2.w(startDownloadCss.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                tl8Var2.r(true);
                tl8 disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    tl8Var2.x(disableGoBack.f());
                    tl8Var2.t(disableGoBack.b());
                    tl8Var2.o(disableGoBack.a());
                    tl8Var2.w(disableGoBack.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("device/getSupplementInfo")) {
                tl8Var2.r(true);
                tl8 supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    tl8Var2.x(supplementInfo.f());
                    tl8Var2.t(supplementInfo.b());
                    tl8Var2.o(supplementInfo.a());
                    tl8Var2.w(supplementInfo.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("device/getDeviceInfo")) {
                tl8Var2.r(true);
                tl8 deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    tl8Var2.x(deviceInfo.f());
                    tl8Var2.t(deviceInfo.b());
                    tl8Var2.o(deviceInfo.a());
                    tl8Var2.w(deviceInfo.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("activity/completeTask")) {
                tl8Var2.r(true);
                tl8 sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    tl8Var2.x(sendCompleteTaskReqMsg.f());
                    tl8Var2.t(sendCompleteTaskReqMsg.b());
                    tl8Var2.o(sendCompleteTaskReqMsg.a());
                    tl8Var2.w(sendCompleteTaskReqMsg.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("toast/showTipToast")) {
                tl8Var2.r(true);
                tl8 showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString("linkUrl"), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    tl8Var2.x(showTipToast.f());
                    tl8Var2.t(showTipToast.b());
                    tl8Var2.o(showTipToast.a());
                    tl8Var2.w(showTipToast.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("toast/getModalData")) {
                tl8Var2.r(true);
                tl8 getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    tl8Var2.x(getModalData.f());
                    tl8Var2.t(getModalData.b());
                    tl8Var2.o(getModalData.a());
                    tl8Var2.w(getModalData.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                tl8Var2.r(true);
                tl8 jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    tl8Var2.x(jumpToHtmlPage.f());
                    tl8Var2.t(jumpToHtmlPage.b());
                    tl8Var2.o(jumpToHtmlPage.a());
                    tl8Var2.w(jumpToHtmlPage.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                tl8Var2.r(true);
                tl8 offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    tl8Var2.x(offlineUserInfo.f());
                    tl8Var2.t(offlineUserInfo.b());
                    tl8Var2.o(offlineUserInfo.a());
                    tl8Var2.w(offlineUserInfo.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                tl8Var2.r(true);
                tl8 deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    tl8Var2.x(deleteOfflineBundle.f());
                    tl8Var2.t(deleteOfflineBundle.b());
                    tl8Var2.o(deleteOfflineBundle.a());
                    tl8Var2.w(deleteOfflineBundle.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                tl8Var2.r(true);
                tl8 updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    tl8Var2.x(updateOfflineBundle.f());
                    tl8Var2.t(updateOfflineBundle.b());
                    tl8Var2.o(updateOfflineBundle.a());
                    tl8Var2.w(updateOfflineBundle.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                tl8Var2.r(true);
                tl8 switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    tl8Var2.x(switchOfflineInterface.f());
                    tl8Var2.t(switchOfflineInterface.b());
                    tl8Var2.o(switchOfflineInterface.a());
                    tl8Var2.w(switchOfflineInterface.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                tl8Var2.r(true);
                tl8 switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    tl8Var2.x(switchOfflineBundleStatus.f());
                    tl8Var2.t(switchOfflineBundleStatus.b());
                    tl8Var2.o(switchOfflineBundleStatus.a());
                    tl8Var2.w(switchOfflineBundleStatus.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                tl8Var2.r(true);
                tl8 finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    tl8Var2.x(finishTestAnswer.f());
                    tl8Var2.t(finishTestAnswer.b());
                    tl8Var2.o(finishTestAnswer.a());
                    tl8Var2.w(finishTestAnswer.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                tl8Var2.r(true);
                ArrayList<JSONObject> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("hostArr"));
                tl8 switchUrlHost = this.mJsBridge.switchUrlHost(arrayList4);
                if (switchUrlHost != null) {
                    tl8Var2.x(switchUrlHost.f());
                    tl8Var2.t(switchUrlHost.b());
                    tl8Var2.o(switchUrlHost.a());
                    tl8Var2.w(switchUrlHost.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/getAppStorage")) {
                tl8Var2.r(true);
                tl8 appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    tl8Var2.x(appStorage.f());
                    tl8Var2.t(appStorage.b());
                    tl8Var2.o(appStorage.a());
                    tl8Var2.w(appStorage.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("system/putAppStorage")) {
                tl8Var2.r(true);
                tl8 putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    tl8Var2.x(putAppStorage.f());
                    tl8Var2.t(putAppStorage.b());
                    tl8Var2.o(putAppStorage.a());
                    tl8Var2.w(putAppStorage.e());
                }
                tl8Var2.y(0);
            } else if (b.equals("hybrid/requestByNativeNew")) {
                tl8Var2.r(true);
                tl8 requestByNative = this.mJsBridge.requestByNative(e.optString("url"), e.optString("type"), e.optString("module"), e.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    tl8Var2.x(requestByNative.f());
                    tl8Var2.t(requestByNative.b());
                    tl8Var2.o(requestByNative.a());
                    tl8Var2.w(requestByNative.e());
                    if (!tl8Var2.h()) {
                        i = 0;
                        tl8Var2.n(false);
                        addObserver("RequestByNativeToH5", tl8Var2, false);
                        tl8Var2.y(i);
                    }
                }
                i = 0;
                tl8Var2.y(i);
            }
            return tl8Var2;
        }
        return (tl8) invokeLL.objValue;
    }

    @Override // com.repackage.rl8
    public List<tl8> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            tl8 tl8Var = null;
            if (pi.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                tl8Var = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                tl8Var = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.SELECT_PHOTO_ALBUM)) {
                tl8Var = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                tl8Var = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                tl8Var = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                tl8Var = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                tl8Var = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                tl8Var = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                tl8Var = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                tl8Var = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                tl8Var = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                tl8Var = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                tl8Var = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                tl8Var = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                tl8Var = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                tl8Var = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                tl8Var = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (tl8Var != null) {
                tl8Var.y(0);
            }
            List<sl8> list = this.mAsyncCallBackMethodList.get(str);
            if (tl8Var != null && list != null) {
                Iterator<sl8> it = list.iterator();
                if (!pi.isEmpty(tl8Var.e())) {
                    while (it.hasNext()) {
                        sl8 next = it.next();
                        if (next.b().equals(tl8Var.e())) {
                            tl8 tl8Var2 = new tl8();
                            tl8Var2.v(next.a());
                            tl8Var2.x(tl8Var.f());
                            tl8Var2.t(tl8Var.b());
                            tl8Var2.o(tl8Var.a());
                            tl8Var2.z(tl8Var.l());
                            arrayList.add(tl8Var2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        sl8 next2 = it.next();
                        tl8 tl8Var3 = new tl8();
                        tl8Var3.v(next2.a());
                        tl8Var3.x(tl8Var.f());
                        tl8Var3.t(tl8Var.b());
                        tl8Var3.o(tl8Var.a());
                        tl8Var3.z(tl8Var.l());
                        arrayList.add(tl8Var3);
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
