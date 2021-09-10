package com.baidu.tieba.h5power;

import c.a.e.e.p.k;
import c.a.r0.j3.m0.d.a;
import c.a.r0.j3.m0.d.b;
import c.a.r0.j3.m0.d.c;
import c.a.r0.j3.m0.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.quickWebView.QuickWebViewBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class QuickWebViewBridge_Proxy extends a {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.mNotificationNameList.add("getPageLeaveTime");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_SKIN_TYPE);
        this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
        this.mNotificationNameList.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.CLICK_GO_BACK_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.GO_BACK_FROM_NATIVE);
        this.mNotificationNameList.add("RequestByNativeToH5");
    }

    @Override // c.a.r0.j3.m0.d.a
    public c dispatch(e eVar, c cVar) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, cVar)) == null) {
            c cVar2 = cVar == null ? new c() : cVar;
            String b2 = eVar.b();
            JSONObject e2 = eVar.e();
            if (b2.equals("account/startLoginModule")) {
                cVar2.p(true);
                c startLoginModule = this.mJsBridge.startLoginModule(e2.optString("cssUrl"));
                if (startLoginModule != null) {
                    cVar2.v(startLoginModule.f());
                    cVar2.r(startLoginModule.b());
                    cVar2.m(startLoginModule.a());
                    cVar2.u(startLoginModule.e());
                }
                cVar2.w(0);
            } else if (b2.equals("router/finishThisPage")) {
                cVar2.p(true);
                c finishPage = this.mJsBridge.finishPage();
                if (finishPage != null) {
                    cVar2.v(finishPage.f());
                    cVar2.r(finishPage.b());
                    cVar2.m(finishPage.a());
                    cVar2.u(finishPage.e());
                }
                cVar2.w(0);
            } else if (b2.equals("toast/toastPopupView")) {
                cVar2.p(true);
                c showLowerHairHint = this.mJsBridge.showLowerHairHint(e2.optInt("showType"), e2.optInt("aheadType"), e2.optString("message"), e2.optString("btnText"), e2.optInt("toastDuration"), e2.optString("schema"), e2.optString("token"), e2.optDouble("opacity"), e2.optString("imgUrl"), e2.optString("url"), e2.optInt("missionId"), e2.optString("btnColor"), e2.optString("messageColor"), e2.optString("btnTextColor"), e2.optInt("status"), e2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showLowerHairHint != null) {
                    cVar2.v(showLowerHairHint.f());
                    cVar2.r(showLowerHairHint.b());
                    cVar2.m(showLowerHairHint.a());
                    cVar2.u(showLowerHairHint.e());
                }
                cVar2.w(0);
            } else if (b2.equals("subscription/gamePush")) {
                cVar2.p(true);
                c gamePush = this.mJsBridge.gamePush(e2.optString("gameId"), e2.optString("gameName"), e2.optString("gameTime"), e2.optString("gameType"));
                if (gamePush != null) {
                    cVar2.v(gamePush.f());
                    cVar2.r(gamePush.b());
                    cVar2.m(gamePush.a());
                    cVar2.u(gamePush.e());
                }
                cVar2.w(0);
            } else if (b2.equals("subscription/gamePushStatus")) {
                cVar2.p(true);
                c handleGamePushStatus = this.mJsBridge.handleGamePushStatus();
                if (handleGamePushStatus != null) {
                    cVar2.v(handleGamePushStatus.f());
                    cVar2.r(handleGamePushStatus.b());
                    cVar2.m(handleGamePushStatus.a());
                    cVar2.u(handleGamePushStatus.e());
                }
                cVar2.w(0);
            } else if (b2.equals("router/goToBarDetail")) {
                cVar2.p(true);
                c handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e2.optString(TbTitleActivityConfig.FORUM_ID));
                if (handleGoToBarDetail != null) {
                    cVar2.v(handleGoToBarDetail.f());
                    cVar2.r(handleGoToBarDetail.b());
                    cVar2.m(handleGoToBarDetail.a());
                    cVar2.u(handleGoToBarDetail.e());
                }
                cVar2.w(0);
            } else if (b2.equals("system/saveImage")) {
                cVar2.p(true);
                c handleSaveImage = this.mJsBridge.handleSaveImage(e2.optString("imgUrl"));
                this.mNotificationNameList.add("saveImageSuccess");
                if (handleSaveImage != null) {
                    cVar2.v(handleSaveImage.f());
                    cVar2.r(handleSaveImage.b());
                    cVar2.m(handleSaveImage.a());
                    cVar2.u(handleSaveImage.e());
                    if (!cVar2.h()) {
                        cVar2.l(false);
                        addObserver("saveImageSuccess", cVar2, false);
                    }
                }
                cVar2.w(0);
            } else if (b2.equals("system/playSound")) {
                cVar2.p(true);
                c playSound = this.mJsBridge.playSound(e2.optString("soundUrl"));
                if (playSound != null) {
                    cVar2.v(playSound.f());
                    cVar2.r(playSound.b());
                    cVar2.m(playSound.a());
                    cVar2.u(playSound.e());
                }
                cVar2.w(0);
            } else if (b2.equals("system/playVibrate")) {
                cVar2.p(true);
                c playVibrate = this.mJsBridge.playVibrate();
                if (playVibrate != null) {
                    cVar2.v(playVibrate.f());
                    cVar2.r(playVibrate.b());
                    cVar2.m(playVibrate.a());
                    cVar2.u(playVibrate.e());
                }
                cVar2.w(0);
            } else if (b2.equals("account/loadThirdPartyLogin")) {
                cVar2.p(true);
                c jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e2.optInt("socialType"), e2.optString("activityId"));
                if (jumpLoginActivity != null) {
                    cVar2.v(jumpLoginActivity.f());
                    cVar2.r(jumpLoginActivity.b());
                    cVar2.m(jumpLoginActivity.a());
                    cVar2.u(jumpLoginActivity.e());
                }
                cVar2.w(0);
            } else if (b2.equals("system/startLoadTimeInterval")) {
                cVar2.p(true);
                c startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
                if (startLoadTimeInterval != null) {
                    cVar2.v(startLoadTimeInterval.f());
                    cVar2.r(startLoadTimeInterval.b());
                    cVar2.m(startLoadTimeInterval.a());
                    cVar2.u(startLoadTimeInterval.e());
                }
                cVar2.w(0);
            } else if (b2.equals("device/getZid")) {
                cVar2.p(true);
                c zid = this.mJsBridge.getZid();
                if (zid != null) {
                    cVar2.v(zid.f());
                    cVar2.r(zid.b());
                    cVar2.m(zid.a());
                    cVar2.u(zid.e());
                }
                cVar2.w(0);
            } else if (b2.equals("device/getHdid")) {
                cVar2.p(true);
                c hdid = this.mJsBridge.getHdid();
                if (hdid != null) {
                    cVar2.v(hdid.f());
                    cVar2.r(hdid.b());
                    cVar2.m(hdid.a());
                    cVar2.u(hdid.e());
                }
                cVar2.w(0);
            } else if (b2.equals("share/registerShareDataNew")) {
                cVar2.p(true);
                c shareInfo = this.mJsBridge.setShareInfo(e2.optString("title"), e2.optString("desc"), e2.optString("img"), e2.optString("url"), e2.optString("topic"), e2.optString("wbtitle"), e2.optString("wbcontent"), e2.optString("isShowMoreForum"), e2.optInt("shareimg"), e2.optString("extdata"));
                if (shareInfo != null) {
                    cVar2.v(shareInfo.f());
                    cVar2.r(shareInfo.b());
                    cVar2.m(shareInfo.a());
                    cVar2.u(shareInfo.e());
                }
                cVar2.w(0);
            } else if (b2.equals("share/share")) {
                cVar2.p(true);
                c share = this.mJsBridge.share(e2.optInt("channel"), e2.optInt("shareImg"), e2.optString("img"), e2.optString("isShowMoreForum"), e2.optString("url"), e2.optString("title"), e2.optString("desc"), e2.optString("topic"), e2.optString("wbtitle"), e2.optString("wbcontent"), e2.optInt("weixinDisable"), e2.optString("extData"));
                if (share != null) {
                    cVar2.v(share.f());
                    cVar2.r(share.b());
                    cVar2.m(share.a());
                    cVar2.u(share.e());
                }
                cVar2.w(0);
            } else if (b2.equals("clipper/getClipperInformation")) {
                cVar2.p(true);
                c clipperInformation = this.mJsBridge.getClipperInformation();
                if (clipperInformation != null) {
                    cVar2.v(clipperInformation.f());
                    cVar2.r(clipperInformation.b());
                    cVar2.m(clipperInformation.a());
                    cVar2.u(clipperInformation.e());
                }
                cVar2.w(0);
            } else if (b2.equals("clipper/setClipperInformation")) {
                cVar2.p(true);
                c clipperInformation2 = this.mJsBridge.setClipperInformation(e2.optString(DocumentOpenUtil.TXT));
                if (clipperInformation2 != null) {
                    cVar2.v(clipperInformation2.f());
                    cVar2.r(clipperInformation2.b());
                    cVar2.m(clipperInformation2.a());
                    cVar2.u(clipperInformation2.e());
                }
                cVar2.w(0);
            } else if (b2.equals("router/goToEditPost")) {
                cVar2.p(true);
                c goToEditPost = this.mJsBridge.goToEditPost(e2.optString(IAdRequestParam.POS), e2.optString("tid"), e2.optString("floorId"), e2.optString("postId"), e2.optString("content"), e2.optString("fid"), e2.optString("fname"));
                if (goToEditPost != null) {
                    cVar2.v(goToEditPost.f());
                    cVar2.r(goToEditPost.b());
                    cVar2.m(goToEditPost.a());
                    cVar2.u(goToEditPost.e());
                }
                cVar2.w(0);
            } else if (b2.equals("system/closeNativeMask")) {
                cVar2.p(true);
                c closeNativeMask = this.mJsBridge.closeNativeMask(e2.optInt("result"));
                if (closeNativeMask != null) {
                    cVar2.v(closeNativeMask.f());
                    cVar2.r(closeNativeMask.b());
                    cVar2.m(closeNativeMask.a());
                    cVar2.u(closeNativeMask.e());
                }
                cVar2.w(0);
            } else if (b2.equals("system/checkAppInstall")) {
                cVar2.p(true);
                c checkAppInstall = this.mJsBridge.checkAppInstall(e2.optString(PushClientConstants.TAG_PKG_NAME));
                if (checkAppInstall != null) {
                    cVar2.v(checkAppInstall.f());
                    cVar2.r(checkAppInstall.b());
                    cVar2.m(checkAppInstall.a());
                    cVar2.u(checkAppInstall.e());
                }
                cVar2.w(0);
            } else if (b2.equals("system/disableSlideBack")) {
                cVar2.p(true);
                c disableBack = this.mJsBridge.disableBack(e2.optInt(PackageTable.DISABLE));
                if (disableBack != null) {
                    cVar2.v(disableBack.f());
                    cVar2.r(disableBack.b());
                    cVar2.m(disableBack.a());
                    cVar2.u(disableBack.e());
                }
                cVar2.w(0);
            } else if (b2.equals("system/startApp")) {
                cVar2.p(true);
                c startApp = this.mJsBridge.startApp(e2.optString(PushClientConstants.TAG_PKG_NAME), e2.optString("schema"));
                if (startApp != null) {
                    cVar2.v(startApp.f());
                    cVar2.r(startApp.b());
                    cVar2.m(startApp.a());
                    cVar2.u(startApp.e());
                }
                cVar2.w(0);
            } else if (b2.equals("system/hasNotificationPermission")) {
                cVar2.p(true);
                c hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
                if (hasNotificationPermission != null) {
                    cVar2.v(hasNotificationPermission.f());
                    cVar2.r(hasNotificationPermission.b());
                    cVar2.m(hasNotificationPermission.a());
                    cVar2.u(hasNotificationPermission.e());
                }
                cVar2.w(0);
            } else if (b2.equals("system/goToNotificationSetting")) {
                cVar2.p(true);
                c goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
                if (goToNotificationSetting != null) {
                    cVar2.v(goToNotificationSetting.f());
                    cVar2.r(goToNotificationSetting.b());
                    cVar2.m(goToNotificationSetting.a());
                    cVar2.u(goToNotificationSetting.e());
                }
                cVar2.w(0);
            } else if (b2.equals("account/startDownloadCss")) {
                cVar2.p(true);
                c startDownloadCss = this.mJsBridge.startDownloadCss(e2.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL));
                if (startDownloadCss != null) {
                    cVar2.v(startDownloadCss.f());
                    cVar2.r(startDownloadCss.b());
                    cVar2.m(startDownloadCss.a());
                    cVar2.u(startDownloadCss.e());
                }
                cVar2.w(0);
            } else if (b2.equals("navigationBar/isDisableGoBack")) {
                cVar2.p(true);
                c disableGoBack = this.mJsBridge.setDisableGoBack();
                if (disableGoBack != null) {
                    cVar2.v(disableGoBack.f());
                    cVar2.r(disableGoBack.b());
                    cVar2.m(disableGoBack.a());
                    cVar2.u(disableGoBack.e());
                }
                cVar2.w(0);
            } else if (b2.equals("device/getSupplementInfo")) {
                cVar2.p(true);
                c supplementInfo = this.mJsBridge.getSupplementInfo();
                if (supplementInfo != null) {
                    cVar2.v(supplementInfo.f());
                    cVar2.r(supplementInfo.b());
                    cVar2.m(supplementInfo.a());
                    cVar2.u(supplementInfo.e());
                }
                cVar2.w(0);
            } else if (b2.equals("device/getDeviceInfo")) {
                cVar2.p(true);
                c deviceInfo = this.mJsBridge.getDeviceInfo();
                if (deviceInfo != null) {
                    cVar2.v(deviceInfo.f());
                    cVar2.r(deviceInfo.b());
                    cVar2.m(deviceInfo.a());
                    cVar2.u(deviceInfo.e());
                }
                cVar2.w(0);
            } else if (b2.equals("activity/completeTask")) {
                cVar2.p(true);
                c sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e2.optString("activityId"), e2.optString("missionId"));
                if (sendCompleteTaskReqMsg != null) {
                    cVar2.v(sendCompleteTaskReqMsg.f());
                    cVar2.r(sendCompleteTaskReqMsg.b());
                    cVar2.m(sendCompleteTaskReqMsg.a());
                    cVar2.u(sendCompleteTaskReqMsg.e());
                }
                cVar2.w(0);
            } else if (b2.equals("toast/showTipToast")) {
                cVar2.p(true);
                c showTipToast = this.mJsBridge.showTipToast(e2.optString("content"), e2.optString("linkUrl"), e2.optString("key"), e2.optInt("maxTimes"), e2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (showTipToast != null) {
                    cVar2.v(showTipToast.f());
                    cVar2.r(showTipToast.b());
                    cVar2.m(showTipToast.a());
                    cVar2.u(showTipToast.e());
                }
                cVar2.w(0);
            } else if (b2.equals("toast/getModalData")) {
                cVar2.p(true);
                c getModalData = this.mJsBridge.getGetModalData();
                if (getModalData != null) {
                    cVar2.v(getModalData.f());
                    cVar2.r(getModalData.b());
                    cVar2.m(getModalData.a());
                    cVar2.u(getModalData.e());
                }
                cVar2.w(0);
            } else if (b2.equals("router/jumpToHTMLPage")) {
                cVar2.p(true);
                c jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e2.optString("url"), e2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
                if (jumpToHtmlPage != null) {
                    cVar2.v(jumpToHtmlPage.f());
                    cVar2.r(jumpToHtmlPage.b());
                    cVar2.m(jumpToHtmlPage.a());
                    cVar2.u(jumpToHtmlPage.e());
                }
                cVar2.w(0);
            } else if (b2.equals("hybridDebug/getOfflineUserInfo")) {
                cVar2.p(true);
                c offlineUserInfo = this.mJsBridge.getOfflineUserInfo();
                if (offlineUserInfo != null) {
                    cVar2.v(offlineUserInfo.f());
                    cVar2.r(offlineUserInfo.b());
                    cVar2.m(offlineUserInfo.a());
                    cVar2.u(offlineUserInfo.e());
                }
                cVar2.w(0);
            } else if (b2.equals("hybridDebug/deleteOfflineBundle")) {
                cVar2.p(true);
                c deleteOfflineBundle = this.mJsBridge.deleteOfflineBundle();
                if (deleteOfflineBundle != null) {
                    cVar2.v(deleteOfflineBundle.f());
                    cVar2.r(deleteOfflineBundle.b());
                    cVar2.m(deleteOfflineBundle.a());
                    cVar2.u(deleteOfflineBundle.e());
                }
                cVar2.w(0);
            } else if (b2.equals("hybridDebug/updateOfflineBundle")) {
                cVar2.p(true);
                c updateOfflineBundle = this.mJsBridge.updateOfflineBundle();
                if (updateOfflineBundle != null) {
                    cVar2.v(updateOfflineBundle.f());
                    cVar2.r(updateOfflineBundle.b());
                    cVar2.m(updateOfflineBundle.a());
                    cVar2.u(updateOfflineBundle.e());
                }
                cVar2.w(0);
            } else if (b2.equals("hybridDebug/switchOfflineInterface")) {
                cVar2.p(true);
                c switchOfflineInterface = this.mJsBridge.switchOfflineInterface(e2.optString("host"));
                if (switchOfflineInterface != null) {
                    cVar2.v(switchOfflineInterface.f());
                    cVar2.r(switchOfflineInterface.b());
                    cVar2.m(switchOfflineInterface.a());
                    cVar2.u(switchOfflineInterface.e());
                }
                cVar2.w(0);
            } else if (b2.equals("hybridDebug/switchOfflineBundleStatus")) {
                cVar2.p(true);
                c switchOfflineBundleStatus = this.mJsBridge.switchOfflineBundleStatus(e2.optInt("isOn"));
                if (switchOfflineBundleStatus != null) {
                    cVar2.v(switchOfflineBundleStatus.f());
                    cVar2.r(switchOfflineBundleStatus.b());
                    cVar2.m(switchOfflineBundleStatus.a());
                    cVar2.u(switchOfflineBundleStatus.e());
                }
                cVar2.w(0);
            } else if (b2.equals("activity/finishTestAnswer")) {
                cVar2.p(true);
                c finishTestAnswer = this.mJsBridge.finishTestAnswer(e2.optLong("testId"));
                if (finishTestAnswer != null) {
                    cVar2.v(finishTestAnswer.f());
                    cVar2.r(finishTestAnswer.b());
                    cVar2.m(finishTestAnswer.a());
                    cVar2.u(finishTestAnswer.e());
                }
                cVar2.w(0);
            } else if (b2.equals("hybridDebug/switchUrlHost")) {
                cVar2.p(true);
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                ListUtils.convertJSONArrayToList(arrayList, e2.optJSONArray("hostArr"));
                c switchUrlHost = this.mJsBridge.switchUrlHost(arrayList);
                if (switchUrlHost != null) {
                    cVar2.v(switchUrlHost.f());
                    cVar2.r(switchUrlHost.b());
                    cVar2.m(switchUrlHost.a());
                    cVar2.u(switchUrlHost.e());
                }
                cVar2.w(0);
            } else if (b2.equals("hybrid/requestByNativeNew")) {
                cVar2.p(true);
                c requestByNative = this.mJsBridge.requestByNative(e2.optString("url"), e2.optString("type"), e2.optString("module"), e2.optJSONObject("data"));
                this.mNotificationNameList.add("RequestByNativeToH5");
                if (requestByNative != null) {
                    cVar2.v(requestByNative.f());
                    cVar2.r(requestByNative.b());
                    cVar2.m(requestByNative.a());
                    cVar2.u(requestByNative.e());
                    if (!cVar2.h()) {
                        i2 = 0;
                        cVar2.l(false);
                        addObserver("RequestByNativeToH5", cVar2, false);
                        cVar2.w(i2);
                    }
                }
                i2 = 0;
                cVar2.w(i2);
            }
            return cVar2;
        }
        return (c) invokeLL.objValue;
    }

    @Override // c.a.r0.j3.m0.d.a
    public List<c> processNotification(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            c cVar = null;
            if (k.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals("saveImageSuccess")) {
                cVar = this.mJsBridge.saveImageSuccess(hashMap);
            } else if (str.equals("getPageLeaveTime")) {
                cVar = this.mJsBridge.springFestivalTimeToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.CHANGE_SKIN_TYPE)) {
                cVar = this.mJsBridge.changeSkinTypeInH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION)) {
                cVar = this.mJsBridge.shareSuccessNotification(hashMap);
            } else if (str.equals(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN)) {
                cVar = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.LOGIN_RESULT_TO_H5)) {
                cVar = this.mJsBridge.onUserLoginChanged(hashMap);
            } else if (str.equals(CommonTbJsBridge.RE_SHOW)) {
                cVar = this.mJsBridge.reShow(hashMap);
            } else if (str.equals(CommonTbJsBridge.CLICK_GO_BACK_TO_H5)) {
                cVar = this.mJsBridge.dealClickGoBackToH5(hashMap);
            } else if (str.equals(CommonTbJsBridge.GO_BACK_FROM_NATIVE)) {
                cVar = this.mJsBridge.dealGoBackFromNative(hashMap);
            } else if (str.equals("RequestByNativeToH5")) {
                cVar = this.mJsBridge.requestByNativeToH5(hashMap);
            }
            if (cVar != null) {
                cVar.w(0);
            }
            List<b> list = this.mAsyncCallBackMethodList.get(str);
            if (cVar != null && list != null) {
                Iterator<b> it = list.iterator();
                if (!k.isEmpty(cVar.e())) {
                    while (it.hasNext()) {
                        b next = it.next();
                        if (next.b().equals(cVar.e())) {
                            c cVar2 = new c();
                            cVar2.t(next.a());
                            cVar2.v(cVar.f());
                            cVar2.r(cVar.b());
                            cVar2.m(cVar.a());
                            arrayList.add(cVar2);
                            if (!next.c()) {
                                it.remove();
                            }
                        }
                    }
                } else {
                    while (it.hasNext()) {
                        b next2 = it.next();
                        c cVar3 = new c();
                        cVar3.t(next2.a());
                        cVar3.v(cVar.f());
                        cVar3.r(cVar.b());
                        cVar3.m(cVar.a());
                        arrayList.add(cVar3);
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
