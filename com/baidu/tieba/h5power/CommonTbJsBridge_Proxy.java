package com.baidu.tieba.h5power;

import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ei;
import com.baidu.tieba.kia;
import com.baidu.tieba.lia;
import com.baidu.tieba.mia;
import com.baidu.tieba.oia;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.mcssdk.PushService;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CommonTbJsBridge_Proxy extends kia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonTbJsBridge mJsBridge;

    @Override // com.baidu.tieba.kia
    public mia dispatch(oia oiaVar, mia miaVar) {
        InterceptResult invokeLL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, oiaVar, miaVar)) == null) {
            mia miaVar2 = miaVar == null ? new mia() : miaVar;
            String b = oiaVar.b();
            JSONObject e = oiaVar.e();
            if (b.equals("account/startLoginModule")) {
                miaVar2.s(true);
                mia startLoginModule = this.mJsBridge.startLoginModule(e.optString("cssUrl"));
                if (startLoginModule != null) {
                    miaVar2.y(startLoginModule.f());
                    miaVar2.u(startLoginModule.b());
                    miaVar2.o(startLoginModule.a());
                    miaVar2.x(startLoginModule.e());
                }
                miaVar2.z(0);
            } else if (b.equals("account/authState")) {
                miaVar2.s(true);
                mia checkAuthState = this.mJsBridge.checkAuthState(e.optString("scene"));
                if (checkAuthState != null) {
                    miaVar2.y(checkAuthState.f());
                    miaVar2.u(checkAuthState.b());
                    miaVar2.o(checkAuthState.a());
                    miaVar2.x(checkAuthState.e());
                }
                miaVar2.z(0);
            } else if (b.equals("account/commonLogin")) {
                miaVar2.s(true);
                mia startAllLoginModule = this.mJsBridge.startAllLoginModule(e.optString("type"), e.optString("addObserverNotify"), e.optString("activityId"), e.optString("cssUrl"));
                this.mNotificationNameList.add("commonLogin");
                if (startAllLoginModule != null) {
                    miaVar2.y(startAllLoginModule.f());
                    miaVar2.u(startAllLoginModule.b());
                    miaVar2.o(startAllLoginModule.a());
                    miaVar2.x(startAllLoginModule.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver("commonLogin", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("account/realNameAuth")) {
                miaVar2.s(true);
                mia realNameAuth = this.mJsBridge.realNameAuth(e.optString("scene"), e.optBoolean("needCbKey"), e.optString("customRealNameUrl"), e.optInt(BindVerifyActivity.KEY_REAL_NAME_LEVEL));
                this.mNotificationNameList.add("realNameAuthResult");
                if (realNameAuth != null) {
                    miaVar2.y(realNameAuth.f());
                    miaVar2.u(realNameAuth.b());
                    miaVar2.o(realNameAuth.a());
                    miaVar2.x(realNameAuth.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver("realNameAuthResult", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("router/finishThisPage")) {
                miaVar2.s(true);
                mia finishPage = this.mJsBridge.finishPage(e.optString("nextPage"), e.optString("source"));
                if (finishPage != null) {
                    miaVar2.y(finishPage.f());
                    miaVar2.u(finishPage.b());
                    miaVar2.o(finishPage.a());
                    miaVar2.x(finishPage.e());
                }
                miaVar2.z(0);
            } else if (b.equals("toast/toastPopupView")) {
                miaVar2.s(true);
                mia showLowerHairHint = this.mJsBridge.showLowerHairHint(e.optInt("showType"), e.optInt("aheadType"), e.optString("message"), e.optString("btnText"), e.optInt("toastDuration"), e.optString("schema"), e.optString("token"), e.optDouble(NativeConstants.OPACITY), e.optString("imgUrl"), e.optString("url"), e.optInt("missionId"), e.optString("btnColor"), e.optString("messageColor"), e.optString("btnTextColor"), e.optInt("status"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    miaVar2.y(showLowerHairHint.f());
                    miaVar2.u(showLowerHairHint.b());
                    miaVar2.o(showLowerHairHint.a());
                    miaVar2.x(showLowerHairHint.e());
                }
                miaVar2.z(0);
            } else if (b.equals("subscription/gamePush")) {
                miaVar2.s(true);
                mia gamePush = this.mJsBridge.gamePush(e.optString("gameId"), e.optString("gameName"), e.optString("gameTime"), e.optString("gameType"));
                if (gamePush != null) {
                    miaVar2.y(gamePush.f());
                    miaVar2.u(gamePush.b());
                    miaVar2.o(gamePush.a());
                    miaVar2.x(gamePush.e());
                }
                miaVar2.z(0);
            } else if (b.equals("subscription/gamePushStatus")) {
                miaVar2.s(true);
                mia handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    miaVar2.y(handleGamePushStatus.f());
                    miaVar2.u(handleGamePushStatus.b());
                    miaVar2.o(handleGamePushStatus.a());
                    miaVar2.x(handleGamePushStatus.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/forumRulesEditPage")) {
                miaVar2.s(true);
                mia jumpForumRulesEditPage = this.mJsBridge.jumpForumRulesEditPage(e.optString("forum_id"), e.optString("forum_name"));
                if (jumpForumRulesEditPage != null) {
                    miaVar2.y(jumpForumRulesEditPage.f());
                    miaVar2.u(jumpForumRulesEditPage.b());
                    miaVar2.o(jumpForumRulesEditPage.a());
                    miaVar2.x(jumpForumRulesEditPage.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/goToBarDetail")) {
                miaVar2.s(true);
                mia handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e.optString("forumId"), e.optInt("selectHostTab"));
                if (handleGoToBarDetail != null) {
                    miaVar2.y(handleGoToBarDetail.f());
                    miaVar2.u(handleGoToBarDetail.b());
                    miaVar2.o(handleGoToBarDetail.a());
                    miaVar2.x(handleGoToBarDetail.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/saveImage")) {
                miaVar2.s(true);
                mia handleSaveImage = this.mJsBridge.handleSaveImage(e.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    miaVar2.y(handleSaveImage.f());
                    miaVar2.u(handleSaveImage.b());
                    miaVar2.o(handleSaveImage.a());
                    miaVar2.x(handleSaveImage.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver("saveImageSuccess", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("system/orderGameApk")) {
                miaVar2.s(true);
                mia orderGameApk = this.mJsBridge.orderGameApk(e.optString("id"), e.optString("name"));
                this.mNotificationNameList.add("orderGameApkResult");
                if (orderGameApk != null) {
                    miaVar2.y(orderGameApk.f());
                    miaVar2.u(orderGameApk.b());
                    miaVar2.o(orderGameApk.a());
                    miaVar2.x(orderGameApk.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver("orderGameApkResult", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("system/goToPhotoAlbum")) {
                miaVar2.s(true);
                mia handleGetPhotoAlbum = this.mJsBridge.handleGetPhotoAlbum();
                this.mNotificationNameList.add("GetPhotoAlbum");
                if (handleGetPhotoAlbum != null) {
                    miaVar2.y(handleGetPhotoAlbum.f());
                    miaVar2.u(handleGetPhotoAlbum.b());
                    miaVar2.o(handleGetPhotoAlbum.a());
                    miaVar2.x(handleGetPhotoAlbum.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver("GetPhotoAlbum", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("host/preheatWeb")) {
                miaVar2.s(true);
                ArrayList<String> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e.optJSONArray("urlList"));
                mia preheatWeb = this.mJsBridge.preheatWeb(arrayList);
                if (preheatWeb != null) {
                    miaVar2.y(preheatWeb.f());
                    miaVar2.u(preheatWeb.b());
                    miaVar2.o(preheatWeb.a());
                    miaVar2.x(preheatWeb.e());
                }
                miaVar2.z(0);
            } else if (b.equals("payment/openMXDYab")) {
                miaVar2.s(true);
                mia openMXDYab = this.mJsBridge.openMXDYab(e.optString(PushConstants.PARAMS));
                if (openMXDYab != null) {
                    miaVar2.y(openMXDYab.f());
                    miaVar2.u(openMXDYab.b());
                    miaVar2.o(openMXDYab.a());
                    miaVar2.x(openMXDYab.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/portal")) {
                miaVar2.s(true);
                mia handlePortal = this.mJsBridge.handlePortal(e.optString("page"), e.optString("refre"), e.optString(YunDialogManager.PAGE_PARAMS_KEY));
                if (handlePortal != null) {
                    miaVar2.y(handlePortal.f());
                    miaVar2.u(handlePortal.b());
                    miaVar2.o(handlePortal.a());
                    miaVar2.x(handlePortal.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/selectPhotoAlbum")) {
                miaVar2.s(true);
                int optInt = e.optInt("maxPhotoNum");
                ArrayList<JSONObject> arrayList2 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList2, e.optJSONArray("imageArray"));
                mia selectPhotoAlbum = this.mJsBridge.selectPhotoAlbum(optInt, arrayList2);
                this.mNotificationNameList.add("selectPhotoAlbum");
                if (selectPhotoAlbum != null) {
                    miaVar2.y(selectPhotoAlbum.f());
                    miaVar2.u(selectPhotoAlbum.b());
                    miaVar2.o(selectPhotoAlbum.a());
                    miaVar2.x(selectPhotoAlbum.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver("selectPhotoAlbum", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("subscription/notifyNativeRefresh")) {
                miaVar2.s(true);
                mia operateNotifyDataChanged = this.mJsBridge.operateNotifyDataChanged(e.optString("key"), e.optString("data"), e.optBoolean("isNotifyH5"));
                if (operateNotifyDataChanged != null) {
                    miaVar2.y(operateNotifyDataChanged.f());
                    miaVar2.u(operateNotifyDataChanged.b());
                    miaVar2.o(operateNotifyDataChanged.a());
                    miaVar2.x(operateNotifyDataChanged.e());
                }
                miaVar2.z(0);
            } else if (b.equals("subscription/getViewPosition")) {
                miaVar2.s(true);
                mia viewPosition = this.mJsBridge.getViewPosition(e.optString("viewId"), e.optString("data"));
                if (viewPosition != null) {
                    miaVar2.y(viewPosition.f());
                    miaVar2.u(viewPosition.b());
                    miaVar2.o(viewPosition.a());
                    miaVar2.x(viewPosition.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/goToSelectPrivateMsgPage")) {
                miaVar2.s(true);
                String optString = e.optString("portrait");
                ArrayList<JSONObject> arrayList3 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList3, e.optJSONArray("msgArray"));
                mia selectPrivateMsg = this.mJsBridge.selectPrivateMsg(optString, arrayList3);
                this.mNotificationNameList.add("goToSelectPrivateMsgPage");
                if (selectPrivateMsg != null) {
                    miaVar2.y(selectPrivateMsg.f());
                    miaVar2.u(selectPrivateMsg.b());
                    miaVar2.o(selectPrivateMsg.a());
                    miaVar2.x(selectPrivateMsg.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver("goToSelectPrivateMsgPage", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("router/goToReportThreadPage")) {
                miaVar2.s(true);
                String optString2 = e.optString("portrait");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList4, e.optJSONArray("threadArray"));
                mia reportUserTheme = this.mJsBridge.reportUserTheme(optString2, arrayList4);
                this.mNotificationNameList.add("goToReportThreadPage");
                if (reportUserTheme != null) {
                    miaVar2.y(reportUserTheme.f());
                    miaVar2.u(reportUserTheme.b());
                    miaVar2.o(reportUserTheme.a());
                    miaVar2.x(reportUserTheme.e());
                    if (!miaVar2.h()) {
                        miaVar2.n(false);
                        addObserver("goToReportThreadPage", miaVar2, false);
                    }
                }
                miaVar2.z(0);
            } else if (b.equals("system/playSound")) {
                miaVar2.s(true);
                mia playSound = this.mJsBridge.playSound(e.optString("soundUrl"));
                if (playSound != null) {
                    miaVar2.y(playSound.f());
                    miaVar2.u(playSound.b());
                    miaVar2.o(playSound.a());
                    miaVar2.x(playSound.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/playVibrate")) {
                miaVar2.s(true);
                mia playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    miaVar2.y(playVibrate.f());
                    miaVar2.u(playVibrate.b());
                    miaVar2.o(playVibrate.a());
                    miaVar2.x(playVibrate.e());
                }
                miaVar2.z(0);
            } else if (b.equals("log/LocalYaLog")) {
                miaVar2.s(true);
                mia localYaLog = this.mJsBridge.localYaLog(e.optString("tag"), e.optString("logInfo"));
                if (localYaLog != null) {
                    miaVar2.y(localYaLog.f());
                    miaVar2.u(localYaLog.b());
                    miaVar2.o(localYaLog.a());
                    miaVar2.x(localYaLog.e());
                }
                miaVar2.z(0);
            } else if (b.equals("account/loadThirdPartyLogin")) {
                miaVar2.s(true);
                mia jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e.optInt("socialType"), e.optString("activityId"));
                if (jumpLoginActivity != null) {
                    miaVar2.y(jumpLoginActivity.f());
                    miaVar2.u(jumpLoginActivity.b());
                    miaVar2.o(jumpLoginActivity.a());
                    miaVar2.x(jumpLoginActivity.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/startLoadTimeInterval")) {
                miaVar2.s(true);
                mia startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    miaVar2.y(startLoadTimeInterval.f());
                    miaVar2.u(startLoadTimeInterval.b());
                    miaVar2.o(startLoadTimeInterval.a());
                    miaVar2.x(startLoadTimeInterval.e());
                }
                miaVar2.z(0);
            } else if (b.equals("device/getZid")) {
                miaVar2.s(true);
                mia zid = this.mJsBridge.getZid();
                if (zid != null) {
                    miaVar2.y(zid.f());
                    miaVar2.u(zid.b());
                    miaVar2.o(zid.a());
                    miaVar2.x(zid.e());
                }
                miaVar2.z(0);
            } else if (b.equals("device/getHdid")) {
                miaVar2.s(true);
                mia hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    miaVar2.y(hdid.f());
                    miaVar2.u(hdid.b());
                    miaVar2.o(hdid.a());
                    miaVar2.x(hdid.e());
                }
                miaVar2.z(0);
            } else if (b.equals("share/registerShareDataNew")) {
                miaVar2.s(true);
                mia shareInfo = this.mJsBridge.setShareInfo(e.optString("title"), e.optString("desc"), e.optString("img"), e.optString("url"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optString("isShowMoreForum"), e.optInt("shareimg"), e.optString("extdata"));
                if (shareInfo != null) {
                    miaVar2.y(shareInfo.f());
                    miaVar2.u(shareInfo.b());
                    miaVar2.o(shareInfo.a());
                    miaVar2.x(shareInfo.e());
                }
                miaVar2.z(0);
            } else if (b.equals("share/share")) {
                miaVar2.s(true);
                mia share = this.mJsBridge.share(e.optInt("channel"), e.optInt("shareImg"), e.optString("img"), e.optString("isShowMoreForum"), e.optString("url"), e.optString("title"), e.optString("desc"), e.optString("topic"), e.optString("wbtitle"), e.optString("wbcontent"), e.optInt("weixinDisable"), e.optString("extData"), e.optInt("source"), e.optString("topicId"), e.optString("disableSafari"), e.optLong("roomId"), e.optInt("filterRooms"), e.optInt("roomMemberCount"), e.optLong("fid"), e.optString("forumName"), e.optString("onlyThirdShare"), e.optString("addObserverNotify"), e.optString("panelTitle"), e.optJSONObject("shareIMCard"));
                this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
                if (share != null) {
                    miaVar2.y(share.f());
                    miaVar2.u(share.b());
                    miaVar2.o(share.a());
                    miaVar2.x(share.e());
                    if (!miaVar2.h()) {
                        i11 = 0;
                        miaVar2.n(false);
                        addObserver(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, miaVar2, false);
                        miaVar2.z(i11);
                    }
                }
                i11 = 0;
                miaVar2.z(i11);
            } else if (b.equals("clipper/getClipperInformation")) {
                miaVar2.s(true);
                mia clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    miaVar2.y(clipperInformation.f());
                    miaVar2.u(clipperInformation.b());
                    miaVar2.o(clipperInformation.a());
                    miaVar2.x(clipperInformation.e());
                }
                miaVar2.z(0);
            } else if (b.equals("clipper/setClipperInformation")) {
                miaVar2.s(true);
                mia clipperInformation2 = this.mJsBridge.setClipperInformation(e.optString("txt"));
                if (clipperInformation2 != null) {
                    miaVar2.y(clipperInformation2.f());
                    miaVar2.u(clipperInformation2.b());
                    miaVar2.o(clipperInformation2.a());
                    miaVar2.x(clipperInformation2.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/goToEditPost")) {
                miaVar2.s(true);
                mia goToEditPost = this.mJsBridge.goToEditPost(e.optString("pos"), e.optString("tid"), e.optString("floorId"), e.optString("postId"), e.optString("content"), e.optString("fid"), e.optString("fname"));
                if (goToEditPost != null) {
                    miaVar2.y(goToEditPost.f());
                    miaVar2.u(goToEditPost.b());
                    miaVar2.o(goToEditPost.a());
                    miaVar2.x(goToEditPost.e());
                }
                miaVar2.z(0);
            } else if (b.equals("activity/updateSearchForumInfo")) {
                miaVar2.s(true);
                mia updateSearchForumInfo = this.mJsBridge.updateSearchForumInfo(e.optString("forumParams"));
                if (updateSearchForumInfo != null) {
                    miaVar2.y(updateSearchForumInfo.f());
                    miaVar2.u(updateSearchForumInfo.b());
                    miaVar2.o(updateSearchForumInfo.a());
                    miaVar2.x(updateSearchForumInfo.e());
                }
                miaVar2.z(0);
            } else if (b.equals("activity/personlizedSwitchChange")) {
                miaVar2.s(true);
                mia personlizedSwitchChange = this.mJsBridge.personlizedSwitchChange(e.optString("personlizedSwitchStatus"));
                if (personlizedSwitchChange != null) {
                    miaVar2.y(personlizedSwitchChange.f());
                    miaVar2.u(personlizedSwitchChange.b());
                    miaVar2.o(personlizedSwitchChange.a());
                    miaVar2.x(personlizedSwitchChange.e());
                }
                miaVar2.z(0);
            } else if (b.equals("activity/updateTailStyle")) {
                miaVar2.s(true);
                mia updateTailStyle = this.mJsBridge.updateTailStyle(e.optInt("type"), e.optString("tailId"));
                if (updateTailStyle != null) {
                    miaVar2.y(updateTailStyle.f());
                    miaVar2.u(updateTailStyle.b());
                    miaVar2.o(updateTailStyle.a());
                    miaVar2.x(updateTailStyle.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/videoImmersivePage")) {
                miaVar2.s(true);
                mia goToVideoImmersivePage = this.mJsBridge.goToVideoImmersivePage(e.optString("threadId"), e.optString("postId"), e.optString("title"), e.optString(TbEnum.SystemMessage.KEY_USER_NAME), e.optString("nickName"), e.optString("portrait"), e.optString("thumbnailUrl"), e.optString("videoUrl"), e.optString("videoWidth"), e.optString("videoHeight"), e.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION), e.optString("postNum"), e.optString("agreeNum"), e.optString("isAgreed"), e.optString("shareNum"), e.optString("forumId"), e.optString("forumName"), e.optString("showComment"));
                if (goToVideoImmersivePage != null) {
                    miaVar2.y(goToVideoImmersivePage.f());
                    miaVar2.u(goToVideoImmersivePage.b());
                    miaVar2.o(goToVideoImmersivePage.a());
                    miaVar2.x(goToVideoImmersivePage.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/jumpToVideo")) {
                miaVar2.s(true);
                mia jumpToVideo = this.mJsBridge.jumpToVideo(e.optString("videoTopic"), e.optString("videoTopicID"), e.optString("isVideo"));
                if (jumpToVideo != null) {
                    miaVar2.y(jumpToVideo.f());
                    miaVar2.u(jumpToVideo.b());
                    miaVar2.o(jumpToVideo.a());
                    miaVar2.x(jumpToVideo.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/closeNativeMask")) {
                miaVar2.s(true);
                mia closeNativeMask = this.mJsBridge.closeNativeMask(e.optInt("result"));
                if (closeNativeMask != null) {
                    miaVar2.y(closeNativeMask.f());
                    miaVar2.u(closeNativeMask.b());
                    miaVar2.o(closeNativeMask.a());
                    miaVar2.x(closeNativeMask.e());
                }
                miaVar2.z(0);
            } else if (b.equals("activity/oneKeyDeletion")) {
                miaVar2.s(true);
                mia oneKeyDeletion = this.mJsBridge.toOneKeyDeletion();
                if (oneKeyDeletion != null) {
                    miaVar2.y(oneKeyDeletion.f());
                    miaVar2.u(oneKeyDeletion.b());
                    miaVar2.o(oneKeyDeletion.a());
                    miaVar2.x(oneKeyDeletion.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/checkAppInstall")) {
                miaVar2.s(true);
                mia checkAppInstall = this.mJsBridge.checkAppInstall(e.optString("pkgName"));
                if (checkAppInstall != null) {
                    miaVar2.y(checkAppInstall.f());
                    miaVar2.u(checkAppInstall.b());
                    miaVar2.o(checkAppInstall.a());
                    miaVar2.x(checkAppInstall.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/disableSlideBack")) {
                miaVar2.s(true);
                mia disableBack = this.mJsBridge.disableBack(e.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    miaVar2.y(disableBack.f());
                    miaVar2.u(disableBack.b());
                    miaVar2.o(disableBack.a());
                    miaVar2.x(disableBack.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/startApp")) {
                miaVar2.s(true);
                mia startApp = this.mJsBridge.startApp(e.optString("pkgName"), e.optString("schema"));
                if (startApp != null) {
                    miaVar2.y(startApp.f());
                    miaVar2.u(startApp.b());
                    miaVar2.o(startApp.a());
                    miaVar2.x(startApp.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/hasNotificationPermission")) {
                miaVar2.s(true);
                mia hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    miaVar2.y(hasNotificationPermission.f());
                    miaVar2.u(hasNotificationPermission.b());
                    miaVar2.o(hasNotificationPermission.a());
                    miaVar2.x(hasNotificationPermission.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/goToNotificationSetting")) {
                miaVar2.s(true);
                mia goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    miaVar2.y(goToNotificationSetting.f());
                    miaVar2.u(goToNotificationSetting.b());
                    miaVar2.o(goToNotificationSetting.a());
                    miaVar2.x(goToNotificationSetting.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/downloadGameApk")) {
                miaVar2.s(true);
                mia startDownloadGameApk = this.mJsBridge.startDownloadGameApk(e.optString("gameUrl"), e.optString("gameId"), e.optString("apkName"), e.optString("apkIcon"), e.optString("forumName"), e.optString("apkVersion"), e.optString("developerName"), e.optString("privacyUrl"), e.optString("authorityUrl"), e.optString("packageSize"), e.optInt(PushService.APP_VERSION_CODE), e.optString("pkgName"), e.optInt("source"), e.optString("extInfo"));
                if (startDownloadGameApk != null) {
                    miaVar2.y(startDownloadGameApk.f());
                    miaVar2.u(startDownloadGameApk.b());
                    miaVar2.o(startDownloadGameApk.a());
                    miaVar2.x(startDownloadGameApk.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/checkInstallGameApk")) {
                miaVar2.s(true);
                mia checkInstallGameApk = this.mJsBridge.checkInstallGameApk(e.optString("pkgName"));
                if (checkInstallGameApk != null) {
                    miaVar2.y(checkInstallGameApk.f());
                    miaVar2.u(checkInstallGameApk.b());
                    miaVar2.o(checkInstallGameApk.a());
                    miaVar2.x(checkInstallGameApk.e());
                }
                miaVar2.z(0);
            } else if (b.equals("account/startDownloadCss")) {
                miaVar2.s(true);
                mia startDownloadCss = this.mJsBridge.startDownloadCss(e.optString(TTDownloadField.TT_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    miaVar2.y(startDownloadCss.f());
                    miaVar2.u(startDownloadCss.b());
                    miaVar2.o(startDownloadCss.a());
                    miaVar2.x(startDownloadCss.e());
                }
                miaVar2.z(0);
            } else if (b.equals("navigationBar/isDisableGoBack")) {
                miaVar2.s(true);
                mia disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    miaVar2.y(disableGoBack.f());
                    miaVar2.u(disableGoBack.b());
                    miaVar2.o(disableGoBack.a());
                    miaVar2.x(disableGoBack.e());
                }
                miaVar2.z(0);
            } else if (b.equals("device/getSupplementInfo")) {
                miaVar2.s(true);
                mia supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    miaVar2.y(supplementInfo.f());
                    miaVar2.u(supplementInfo.b());
                    miaVar2.o(supplementInfo.a());
                    miaVar2.x(supplementInfo.e());
                }
                miaVar2.z(0);
            } else if (b.equals("device/deviceMotion")) {
                miaVar2.s(true);
                mia deviceGyroscopeParams = this.mJsBridge.deviceGyroscopeParams(e.optString("interval"), e.optString("type"));
                this.mNotificationNameList.add("deviceMotion");
                if (deviceGyroscopeParams != null) {
                    miaVar2.y(deviceGyroscopeParams.f());
                    miaVar2.u(deviceGyroscopeParams.b());
                    miaVar2.o(deviceGyroscopeParams.a());
                    miaVar2.x(deviceGyroscopeParams.e());
                    if (!miaVar2.h()) {
                        i10 = 0;
                        miaVar2.n(false);
                        addObserver("deviceMotion", miaVar2, false);
                        miaVar2.z(i10);
                    }
                }
                i10 = 0;
                miaVar2.z(i10);
            } else if (b.equals("device/deviceRefreshRate")) {
                miaVar2.s(true);
                mia deviceRefreshRateParams = this.mJsBridge.deviceRefreshRateParams(e.optString("type"));
                this.mNotificationNameList.add("deviceRefreshRate");
                if (deviceRefreshRateParams != null) {
                    miaVar2.y(deviceRefreshRateParams.f());
                    miaVar2.u(deviceRefreshRateParams.b());
                    miaVar2.o(deviceRefreshRateParams.a());
                    miaVar2.x(deviceRefreshRateParams.e());
                    if (!miaVar2.h()) {
                        i9 = 0;
                        miaVar2.n(false);
                        addObserver("deviceRefreshRate", miaVar2, false);
                        miaVar2.z(i9);
                    }
                }
                i9 = 0;
                miaVar2.z(i9);
            } else if (b.equals("device/getDeviceInfo")) {
                miaVar2.s(true);
                mia deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    miaVar2.y(deviceInfo.f());
                    miaVar2.u(deviceInfo.b());
                    miaVar2.o(deviceInfo.a());
                    miaVar2.x(deviceInfo.e());
                }
                miaVar2.z(0);
            } else if (b.equals("activity/completeTask")) {
                miaVar2.s(true);
                mia sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e.optString("activityId"), e.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    miaVar2.y(sendCompleteTaskReqMsg.f());
                    miaVar2.u(sendCompleteTaskReqMsg.b());
                    miaVar2.o(sendCompleteTaskReqMsg.a());
                    miaVar2.x(sendCompleteTaskReqMsg.e());
                }
                miaVar2.z(0);
            } else if (b.equals("toast/showTipToast")) {
                miaVar2.s(true);
                mia showTipToast = this.mJsBridge.showTipToast(e.optString("content"), e.optString(GameAssistConstKt.KEY_LINKURL), e.optString("key"), e.optInt("maxTimes"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    miaVar2.y(showTipToast.f());
                    miaVar2.u(showTipToast.b());
                    miaVar2.o(showTipToast.a());
                    miaVar2.x(showTipToast.e());
                }
                miaVar2.z(0);
            } else if (b.equals("toast/getModalData")) {
                miaVar2.s(true);
                mia getModalData = this.mJsBridge.getGetModalData(e.optString("url"));
                if (getModalData != null) {
                    miaVar2.y(getModalData.f());
                    miaVar2.u(getModalData.b());
                    miaVar2.o(getModalData.a());
                    miaVar2.x(getModalData.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/openThirdPartyApp")) {
                miaVar2.s(true);
                mia openThirdPartApp = this.mJsBridge.openThirdPartApp(e.optInt("type"), e.optString("data"));
                if (openThirdPartApp != null) {
                    miaVar2.y(openThirdPartApp.f());
                    miaVar2.u(openThirdPartApp.b());
                    miaVar2.o(openThirdPartApp.a());
                    miaVar2.x(openThirdPartApp.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/jumpToHTMLPage")) {
                miaVar2.s(true);
                mia jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e.optString("url"), e.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    miaVar2.y(jumpToHtmlPage.f());
                    miaVar2.u(jumpToHtmlPage.b());
                    miaVar2.o(jumpToHtmlPage.a());
                    miaVar2.x(jumpToHtmlPage.e());
                }
                miaVar2.z(0);
            } else if (b.equals("hybridDebug/getOfflineUserInfo")) {
                miaVar2.s(true);
                mia offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    miaVar2.y(offlineUserInfo.f());
                    miaVar2.u(offlineUserInfo.b());
                    miaVar2.o(offlineUserInfo.a());
                    miaVar2.x(offlineUserInfo.e());
                }
                miaVar2.z(0);
            } else if (b.equals("hybridDebug/deleteOfflineBundle")) {
                miaVar2.s(true);
                mia deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    miaVar2.y(deleteOfflineBundle.f());
                    miaVar2.u(deleteOfflineBundle.b());
                    miaVar2.o(deleteOfflineBundle.a());
                    miaVar2.x(deleteOfflineBundle.e());
                }
                miaVar2.z(0);
            } else if (b.equals("hybridDebug/updateOfflineBundle")) {
                miaVar2.s(true);
                mia updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    miaVar2.y(updateOfflineBundle.f());
                    miaVar2.u(updateOfflineBundle.b());
                    miaVar2.o(updateOfflineBundle.a());
                    miaVar2.x(updateOfflineBundle.e());
                }
                miaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineInterface")) {
                miaVar2.s(true);
                mia switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e.optString("host"));
                if (switchOfflineInterface != null) {
                    miaVar2.y(switchOfflineInterface.f());
                    miaVar2.u(switchOfflineInterface.b());
                    miaVar2.o(switchOfflineInterface.a());
                    miaVar2.x(switchOfflineInterface.e());
                }
                miaVar2.z(0);
            } else if (b.equals("hybridDebug/switchOfflineBundleStatus")) {
                miaVar2.s(true);
                mia switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    miaVar2.y(switchOfflineBundleStatus.f());
                    miaVar2.u(switchOfflineBundleStatus.b());
                    miaVar2.o(switchOfflineBundleStatus.a());
                    miaVar2.x(switchOfflineBundleStatus.e());
                }
                miaVar2.z(0);
            } else if (b.equals("activity/finishTestAnswer")) {
                miaVar2.s(true);
                mia finishTestAnswer = this.mJsBridge.finishTestAnswer(e.optLong("testId"));
                if (finishTestAnswer != null) {
                    miaVar2.y(finishTestAnswer.f());
                    miaVar2.u(finishTestAnswer.b());
                    miaVar2.o(finishTestAnswer.a());
                    miaVar2.x(finishTestAnswer.e());
                }
                miaVar2.z(0);
            } else if (b.equals("hybridDebug/switchUrlHost")) {
                miaVar2.s(true);
                ArrayList<JSONObject> arrayList5 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList5, e.optJSONArray("hostArr"));
                mia switchUrlHost = this.mJsBridge.switchUrlHost(arrayList5);
                if (switchUrlHost != null) {
                    miaVar2.y(switchUrlHost.f());
                    miaVar2.u(switchUrlHost.b());
                    miaVar2.o(switchUrlHost.a());
                    miaVar2.x(switchUrlHost.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/getAppStorage")) {
                miaVar2.s(true);
                mia appStorage = this.mJsBridge.getAppStorage(e.optString("key"));
                if (appStorage != null) {
                    miaVar2.y(appStorage.f());
                    miaVar2.u(appStorage.b());
                    miaVar2.o(appStorage.a());
                    miaVar2.x(appStorage.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/putAppStorage")) {
                miaVar2.s(true);
                mia putAppStorage = this.mJsBridge.putAppStorage(e.optString("key"), e.optString("data"));
                if (putAppStorage != null) {
                    miaVar2.y(putAppStorage.f());
                    miaVar2.u(putAppStorage.b());
                    miaVar2.o(putAppStorage.a());
                    miaVar2.x(putAppStorage.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/getHistoryForumData")) {
                miaVar2.s(true);
                mia historyForumData = this.mJsBridge.getHistoryForumData();
                if (historyForumData != null) {
                    miaVar2.y(historyForumData.f());
                    miaVar2.u(historyForumData.b());
                    miaVar2.o(historyForumData.a());
                    miaVar2.x(historyForumData.e());
                }
                miaVar2.z(0);
            } else if (b.equals("activity/worldCupRaiseSuccess")) {
                miaVar2.s(true);
                mia worldCupRaiseSuccess = this.mJsBridge.worldCupRaiseSuccess(e.optString("portrait"), e.optString("flagUrl"));
                if (worldCupRaiseSuccess != null) {
                    miaVar2.y(worldCupRaiseSuccess.f());
                    miaVar2.u(worldCupRaiseSuccess.b());
                    miaVar2.o(worldCupRaiseSuccess.a());
                    miaVar2.x(worldCupRaiseSuccess.e());
                }
                miaVar2.z(0);
            } else if (b.equals("account/getAlipayUserId")) {
                miaVar2.s(true);
                mia alipayUserId = this.mJsBridge.getAlipayUserId();
                this.mNotificationNameList.add("aliAuthResult");
                if (alipayUserId != null) {
                    miaVar2.y(alipayUserId.f());
                    miaVar2.u(alipayUserId.b());
                    miaVar2.o(alipayUserId.a());
                    miaVar2.x(alipayUserId.e());
                    if (!miaVar2.h()) {
                        i8 = 0;
                        miaVar2.n(false);
                        addObserver("aliAuthResult", miaVar2, false);
                        miaVar2.z(i8);
                    }
                }
                i8 = 0;
                miaVar2.z(i8);
            } else if (b.equals("system/getFileDownloadStatus")) {
                miaVar2.s(true);
                mia fileDownloadStatus = this.mJsBridge.getFileDownloadStatus(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadStatus != null) {
                    miaVar2.y(fileDownloadStatus.f());
                    miaVar2.u(fileDownloadStatus.b());
                    miaVar2.o(fileDownloadStatus.a());
                    miaVar2.x(fileDownloadStatus.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/getFileDownloadProgress")) {
                miaVar2.s(true);
                mia fileDownloadProgress = this.mJsBridge.getFileDownloadProgress(e.optString("fileName"), e.optString("fileVersion"), e.optString("extInfo"));
                if (fileDownloadProgress != null) {
                    miaVar2.y(fileDownloadProgress.f());
                    miaVar2.u(fileDownloadProgress.b());
                    miaVar2.o(fileDownloadProgress.a());
                    miaVar2.x(fileDownloadProgress.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/fileDownloadPause")) {
                miaVar2.s(true);
                mia fileDownloadPause = this.mJsBridge.fileDownloadPause(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadPause != null) {
                    miaVar2.y(fileDownloadPause.f());
                    miaVar2.u(fileDownloadPause.b());
                    miaVar2.o(fileDownloadPause.a());
                    miaVar2.x(fileDownloadPause.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/fileDownloadDelete")) {
                miaVar2.s(true);
                mia fileDownloadDelete = this.mJsBridge.fileDownloadDelete(e.optString(CommonTbJsBridge.FILE_DOWNLOAD_URL), e.optString("fileName"), e.optString("fileVersion"), e.optInt("source"), e.optString("extInfo"));
                if (fileDownloadDelete != null) {
                    miaVar2.y(fileDownloadDelete.f());
                    miaVar2.u(fileDownloadDelete.b());
                    miaVar2.o(fileDownloadDelete.a());
                    miaVar2.x(fileDownloadDelete.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/installGameApk")) {
                miaVar2.s(true);
                mia installGameApk = this.mJsBridge.installGameApk(e.optString("apkName"), e.optString("pkgName"), e.optString("apkUrl"), e.optString("apkVersion"), e.optInt("source"), e.optString("extInfo"));
                if (installGameApk != null) {
                    miaVar2.y(installGameApk.f());
                    miaVar2.u(installGameApk.b());
                    miaVar2.o(installGameApk.a());
                    miaVar2.x(installGameApk.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/launchApk")) {
                miaVar2.s(true);
                mia launchApk = this.mJsBridge.launchApk(e.optString("pkgName"), e.optString("apkName"), e.optString("apkUrl"), e.optInt("source"), e.optString("extInfo"));
                if (launchApk != null) {
                    miaVar2.y(launchApk.f());
                    miaVar2.u(launchApk.b());
                    miaVar2.o(launchApk.a());
                    miaVar2.x(launchApk.e());
                }
                miaVar2.z(0);
            } else if (b.equals("system/wakeKeyboard")) {
                miaVar2.s(true);
                mia wakeKeyboard = this.mJsBridge.wakeKeyboard(e.optString("postType"), e.optBoolean("showInputContainer"), e.optBoolean("showReplyContainer"), e.optBoolean("showStarContainer"), e.optBoolean("showEmotion"), e.optBoolean("showDIYEmotion"), e.optBoolean("showAt"), e.optJSONObject("topViewData"), e.optBoolean("show"));
                if (wakeKeyboard != null) {
                    miaVar2.y(wakeKeyboard.f());
                    miaVar2.u(wakeKeyboard.b());
                    miaVar2.o(wakeKeyboard.a());
                    miaVar2.x(wakeKeyboard.e());
                }
                miaVar2.z(0);
            } else if (b.equals("router/replyPost")) {
                miaVar2.s(true);
                mia replyPost = this.mJsBridge.replyPost(e.optString("tid"));
                this.mNotificationNameList.add("replyPostResult");
                if (replyPost != null) {
                    miaVar2.y(replyPost.f());
                    miaVar2.u(replyPost.b());
                    miaVar2.o(replyPost.a());
                    miaVar2.x(replyPost.e());
                    if (!miaVar2.h()) {
                        i7 = 0;
                        miaVar2.n(false);
                        addObserver("replyPostResult", miaVar2, false);
                        miaVar2.z(i7);
                    }
                }
                i7 = 0;
                miaVar2.z(i7);
            } else if (b.equals("hybrid/nativeNetworkProxy")) {
                miaVar2.s(true);
                mia nativeNetworkProxy = this.mJsBridge.nativeNetworkProxy(e.optString("path"), e.optString("host"), e.optString("type"), e.optJSONObject("data"), e.optInt("needBduss"), e.optInt("needTbs"));
                this.mNotificationNameList.add("nativeNetworkProxyResult");
                if (nativeNetworkProxy != null) {
                    miaVar2.y(nativeNetworkProxy.f());
                    miaVar2.u(nativeNetworkProxy.b());
                    miaVar2.o(nativeNetworkProxy.a());
                    miaVar2.x(nativeNetworkProxy.e());
                    if (!miaVar2.h()) {
                        i6 = 0;
                        miaVar2.n(false);
                        addObserver("nativeNetworkProxyResult", miaVar2, false);
                        miaVar2.z(i6);
                    }
                }
                i6 = 0;
                miaVar2.z(i6);
            } else if (b.equals("host/sendMsg")) {
                miaVar2.s(true);
                mia sendMessage = this.mJsBridge.sendMessage(e.optString("msg"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("sendMsg");
                if (sendMessage != null) {
                    miaVar2.y(sendMessage.f());
                    miaVar2.u(sendMessage.b());
                    miaVar2.o(sendMessage.a());
                    miaVar2.x(sendMessage.e());
                    if (!miaVar2.h()) {
                        i5 = 0;
                        miaVar2.n(false);
                        addObserver("sendMsg", miaVar2, false);
                        miaVar2.z(i5);
                    }
                }
                i5 = 0;
                miaVar2.z(i5);
            } else if (b.equals("host/fetchHistoryMsgs")) {
                miaVar2.s(true);
                mia fetchHistoryMsgs = this.mJsBridge.fetchHistoryMsgs(e.optInt("count"), e.optLong("beginMsgId"), e.optLong("endMsgId"), e.optString("chatType"), e.optString("chatId"));
                this.mNotificationNameList.add("fetchHistoryMsgs");
                if (fetchHistoryMsgs != null) {
                    miaVar2.y(fetchHistoryMsgs.f());
                    miaVar2.u(fetchHistoryMsgs.b());
                    miaVar2.o(fetchHistoryMsgs.a());
                    miaVar2.x(fetchHistoryMsgs.e());
                    if (!miaVar2.h()) {
                        i4 = 0;
                        miaVar2.n(false);
                        addObserver("fetchHistoryMsgs", miaVar2, false);
                        miaVar2.z(i4);
                    }
                }
                i4 = 0;
                miaVar2.z(i4);
            } else if (b.equals("host/receiveNewMsgs")) {
                miaVar2.s(true);
                mia receiveNewMsgs = this.mJsBridge.receiveNewMsgs();
                this.mNotificationNameList.add("receiveNewMsgs");
                if (receiveNewMsgs != null) {
                    miaVar2.y(receiveNewMsgs.f());
                    miaVar2.u(receiveNewMsgs.b());
                    miaVar2.o(receiveNewMsgs.a());
                    miaVar2.x(receiveNewMsgs.e());
                    if (!miaVar2.h()) {
                        i3 = 0;
                        miaVar2.n(false);
                        addObserver("receiveNewMsgs", miaVar2, false);
                        miaVar2.z(i3);
                    }
                }
                i3 = 0;
                miaVar2.z(i3);
            } else if (b.equals("system/keyboardHeightChange")) {
                miaVar2.s(true);
                mia keyboardHeightChange = this.mJsBridge.keyboardHeightChange();
                this.mNotificationNameList.add("keyboardHeightChange");
                if (keyboardHeightChange != null) {
                    miaVar2.y(keyboardHeightChange.f());
                    miaVar2.u(keyboardHeightChange.b());
                    miaVar2.o(keyboardHeightChange.a());
                    miaVar2.x(keyboardHeightChange.e());
                    if (!miaVar2.h()) {
                        i2 = 0;
                        miaVar2.n(false);
                        addObserver("keyboardHeightChange", miaVar2, false);
                        miaVar2.z(i2);
                    }
                }
                i2 = 0;
                miaVar2.z(i2);
            } else if (b.equals("host/preloadPic")) {
                miaVar2.s(true);
                ArrayList<String> arrayList6 = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList6, e.optJSONArray("url"));
                mia perloadPicModule = this.mJsBridge.perloadPicModule(arrayList6);
                if (perloadPicModule != null) {
                    miaVar2.y(perloadPicModule.f());
                    miaVar2.u(perloadPicModule.b());
                    miaVar2.o(perloadPicModule.a());
                    miaVar2.x(perloadPicModule.e());
                }
                miaVar2.z(0);
            } else if (b.equals("toast/showDialog")) {
                miaVar2.s(true);
                mia showDialog = this.mJsBridge.showDialog(e.optInt("type"), e.optString("content"), e.optString("dialogId"));
                this.mNotificationNameList.add("showDialog");
                if (showDialog != null) {
                    miaVar2.y(showDialog.f());
                    miaVar2.u(showDialog.b());
                    miaVar2.o(showDialog.a());
                    miaVar2.x(showDialog.e());
                    if (!miaVar2.h()) {
                        i = 0;
                        miaVar2.n(false);
                        addObserver("showDialog", miaVar2, false);
                        miaVar2.z(i);
                    }
                }
                i = 0;
                miaVar2.z(i);
            }
            return miaVar2;
        }
        return (mia) invokeLL.objValue;
    }

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
        hashSet.add("commonLogin");
        this.mNotificationNameList.add("realNameAuthResult");
        this.mNotificationNameList.add("saveImageSuccess");
        this.mNotificationNameList.add("orderGameApkResult");
        this.mNotificationNameList.add("GetPhotoAlbum");
        this.mNotificationNameList.add("tbPayResult");
        this.mNotificationNameList.add("selectPhotoAlbum");
        this.mNotificationNameList.add("goToSelectPrivateMsgPage");
        this.mNotificationNameList.add("goToReportThreadPage");
        this.mNotificationNameList.add("getPageLeaveTime");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_SKIN_TYPE);
        this.mNotificationNameList.add(CommonTbJsBridge.OPEN_VIP_SUCCESS);
        this.mNotificationNameList.add(CommonTbJsBridge.REFRESH_TAIL);
        this.mNotificationNameList.add("writePostSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_POST_WALL);
        this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
        this.mNotificationNameList.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add(SearchJsBridge.METHOD_SET_SEARCH_HISTORY);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_HIDE);
        this.mNotificationNameList.add(CommonTbJsBridge.CLICK_GO_BACK_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.GO_BACK_FROM_NATIVE);
        this.mNotificationNameList.add("deviceMotion");
        this.mNotificationNameList.add("deviceRefreshRate");
        this.mNotificationNameList.add("aliAuthResult");
        this.mNotificationNameList.add(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT);
        this.mNotificationNameList.add(CommonTbJsBridge.INSTALL_APK_RESULT);
        this.mNotificationNameList.add("replyPostResult");
        this.mNotificationNameList.add("nativeNetworkProxyResult");
        this.mNotificationNameList.add("sendMsg");
        this.mNotificationNameList.add("handleAudioMsgByTTS");
        this.mNotificationNameList.add("fetchHistoryMsgs");
        this.mNotificationNameList.add("receiveNewMsgs");
        this.mNotificationNameList.add("keyboardHeightChange");
    }

    @Override // com.baidu.tieba.kia
    public List<mia> processNotification(WebView webView, String str, HashMap hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, hashMap)) == null) {
            mia miaVar = null;
            if (ei.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("commonLogin")) {
                miaVar = this.mJsBridge.newThirdPartyLoginResultToH5(hashMap);
            } else if (str.equals("realNameAuthResult")) {
                miaVar = this.mJsBridge.realNameAuthResult(hashMap);
            } else if (str.equals("saveImageSuccess")) {
                miaVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("orderGameApkResult")) {
                miaVar = this.mJsBridge.orderGameApkResult(hashMap);
            } else if (str.equals("GetPhotoAlbum")) {
                miaVar = this.mJsBridge.getPhotoAlbumResult(hashMap);
            } else if (str.equals("tbPayResult")) {
                miaVar = this.mJsBridge.tbPayResult(hashMap);
            } else if (str.equals("selectPhotoAlbum")) {
                miaVar = this.mJsBridge.getSelectPhotoAlbumResult(hashMap);
            } else if (str.equals("goToSelectPrivateMsgPage")) {
                miaVar = this.mJsBridge.getSelectPrivateImResult(hashMap);
            } else if (str.equals("goToReportThreadPage")) {
                miaVar = this.mJsBridge.getToReportThemePage(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                miaVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                miaVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.OPEN_VIP_SUCCESS)) {
                miaVar = this.mJsBridge.openVipSuccessInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.REFRESH_TAIL)) {
                miaVar = this.mJsBridge.refreshTailInH5(hashMap);
            } else if (str.equals("writePostSuccess")) {
                miaVar = this.mJsBridge.writePostSuccess(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_POST_WALL)) {
                miaVar = this.mJsBridge.postWriteWallData(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                miaVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                miaVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                miaVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(SearchJsBridge.METHOD_SET_SEARCH_HISTORY)) {
                miaVar = this.mJsBridge.setSearchHistory(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                miaVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_HIDE)) {
                miaVar = this.mJsBridge.reHide(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                miaVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                miaVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("deviceMotion")) {
                miaVar = this.mJsBridge.deviceMotion(hashMap);
            } else if (str.equals("deviceRefreshRate")) {
                miaVar = this.mJsBridge.deviceRefreshRate(hashMap);
            } else if (str.equals("aliAuthResult")) {
                miaVar = this.mJsBridge.notifyAliAuthResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT)) {
                miaVar = this.mJsBridge.notifyFileDownloadStatusResult(hashMap);
            } else if (str.equals(CommonTbJsBridge.INSTALL_APK_RESULT)) {
                miaVar = this.mJsBridge.notifyApkInstallResult(hashMap);
            } else if (str.equals("replyPostResult")) {
                miaVar = this.mJsBridge.replyPostResult(hashMap);
            } else if (str.equals("nativeNetworkProxyResult")) {
                miaVar = this.mJsBridge.nativeNetworkProxy(hashMap);
            } else if (str.equals("sendMsg")) {
                miaVar = this.mJsBridge.onSendMsgResult(hashMap);
            } else if (str.equals("handleAudioMsgByTTS")) {
                miaVar = this.mJsBridge.handleVoiceMsgResult(hashMap);
            } else if (str.equals("fetchHistoryMsgs")) {
                miaVar = this.mJsBridge.onFetchHistoryMsgsResult(hashMap);
            } else if (str.equals("receiveNewMsgs")) {
                miaVar = this.mJsBridge.onReceiveNewMsgsResult(hashMap);
            } else if (str.equals("keyboardHeightChange")) {
                miaVar = this.mJsBridge.onKeyboardHeightChange(hashMap);
            }
            if (miaVar != null) {
                miaVar.z(0);
            }
            List<lia> list = this.mAsyncCallBackMethodList.get(str);
            if (miaVar != null && list != null) {
                Iterator<lia> it = list.iterator();
                if (!ei.isEmpty(miaVar.e())) {
                    while (it.hasNext()) {
                        lia next = it.next();
                        if (next.b().equals(miaVar.e())) {
                            mia miaVar2 = new mia();
                            miaVar2.w(next.a());
                            miaVar2.y(miaVar.f());
                            miaVar2.u(miaVar.b());
                            miaVar2.o(miaVar.a());
                            miaVar2.A(miaVar.l());
                            arrayList.add(miaVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        lia next2 = it.next();
                        mia miaVar3 = new mia();
                        miaVar3.w(next2.a());
                        miaVar3.y(miaVar.f());
                        miaVar3.u(miaVar.b());
                        miaVar3.o(miaVar.a());
                        miaVar3.A(miaVar.l());
                        arrayList.add(miaVar3);
                        if (!next2.c()) {
                            it.remove();
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
