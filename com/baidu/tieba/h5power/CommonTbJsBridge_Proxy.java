package com.baidu.tieba.h5power;

import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.vivo.push.PushClientConstants;
import d.b.c.e.p.k;
import d.b.i0.d3.l0.d.a;
import d.b.i0.d3.l0.d.b;
import d.b.i0.d3.l0.d.c;
import d.b.i0.d3.l0.d.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommonTbJsBridge_Proxy extends a {
    public CommonTbJsBridge mJsBridge;

    public CommonTbJsBridge_Proxy(CommonTbJsBridge commonTbJsBridge) {
        this.mJsBridge = commonTbJsBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        HashSet<String> hashSet = new HashSet<>();
        this.mNotificationNameList = hashSet;
        hashSet.add("saveImageSuccess");
        this.mNotificationNameList.add(CommonTbJsBridge.CHANGE_SKIN_TYPE);
        this.mNotificationNameList.add(CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION);
        this.mNotificationNameList.add(CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN);
        this.mNotificationNameList.add(CommonTbJsBridge.LOGIN_RESULT_TO_H5);
        this.mNotificationNameList.add(CommonTbJsBridge.RE_SHOW);
        this.mNotificationNameList.add(CommonTbJsBridge.CLICK_GO_BACK_TO_H5);
    }

    @Override // d.b.i0.d3.l0.d.a
    public c dispatch(e eVar, c cVar) {
        c cVar2 = cVar == null ? new c() : cVar;
        String b2 = eVar.b();
        JSONObject e2 = eVar.e();
        if (b2.equals("account/startLoginModule")) {
            cVar2.o(true);
            c startLoginModule = this.mJsBridge.startLoginModule(e2.optString("cssUrl"));
            if (startLoginModule != null) {
                cVar2.t(startLoginModule.e());
                cVar2.q(startLoginModule.b());
                cVar2.l(startLoginModule.a());
            }
            cVar2.u(0);
        } else if (b2.equals("router/finishThisPage")) {
            cVar2.o(true);
            c finishPage = this.mJsBridge.finishPage();
            if (finishPage != null) {
                cVar2.t(finishPage.e());
                cVar2.q(finishPage.b());
                cVar2.l(finishPage.a());
            }
            cVar2.u(0);
        } else if (b2.equals("toast/toastPopupView")) {
            cVar2.o(true);
            c showLowerHairHint = this.mJsBridge.showLowerHairHint(e2.optInt("showType"), e2.optInt("aheadType"), e2.optString("message"), e2.optString("btnText"), e2.optInt("toastDuration"), e2.optString("schema"), e2.optString("token"), e2.optDouble("opacity"), e2.optString("imgUrl"), e2.optString("url"), e2.optInt("missionId"), e2.optString("btnColor"), e2.optString("messageColor"), e2.optString("btnTextColor"), e2.optInt("status"), e2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
            if (showLowerHairHint != null) {
                cVar2.t(showLowerHairHint.e());
                cVar2.q(showLowerHairHint.b());
                cVar2.l(showLowerHairHint.a());
            }
            cVar2.u(0);
        } else if (b2.equals("router/goToBarDetail")) {
            cVar2.o(true);
            c handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(e2.optString(TbTitleActivityConfig.FORUM_ID));
            if (handleGoToBarDetail != null) {
                cVar2.t(handleGoToBarDetail.e());
                cVar2.q(handleGoToBarDetail.b());
                cVar2.l(handleGoToBarDetail.a());
            }
            cVar2.u(0);
        } else if (b2.equals("system/saveImage")) {
            cVar2.o(true);
            c handleSaveImage = this.mJsBridge.handleSaveImage(e2.optString("imgUrl"));
            this.mNotificationNameList.add("saveImageSuccess");
            if (handleSaveImage != null) {
                cVar2.t(handleSaveImage.e());
                cVar2.q(handleSaveImage.b());
                cVar2.l(handleSaveImage.a());
                if (!cVar2.g()) {
                    cVar2.k(false);
                    addObserver("saveImageSuccess", cVar2, false);
                }
            }
            cVar2.u(0);
        } else if (b2.equals("system/playSound")) {
            cVar2.o(true);
            c playSound = this.mJsBridge.playSound(e2.optString("soundUrl"));
            if (playSound != null) {
                cVar2.t(playSound.e());
                cVar2.q(playSound.b());
                cVar2.l(playSound.a());
            }
            cVar2.u(0);
        } else if (b2.equals("system/playVibrate")) {
            cVar2.o(true);
            c playVibrate = this.mJsBridge.playVibrate();
            if (playVibrate != null) {
                cVar2.t(playVibrate.e());
                cVar2.q(playVibrate.b());
                cVar2.l(playVibrate.a());
            }
            cVar2.u(0);
        } else if (b2.equals("account/loadThirdPartyLogin")) {
            cVar2.o(true);
            c jumpLoginActivity = this.mJsBridge.jumpLoginActivity(e2.optInt("socialType"), e2.optString("activityId"));
            if (jumpLoginActivity != null) {
                cVar2.t(jumpLoginActivity.e());
                cVar2.q(jumpLoginActivity.b());
                cVar2.l(jumpLoginActivity.a());
            }
            cVar2.u(0);
        } else if (b2.equals("system/startLoadTimeInterval")) {
            cVar2.o(true);
            c startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
            if (startLoadTimeInterval != null) {
                cVar2.t(startLoadTimeInterval.e());
                cVar2.q(startLoadTimeInterval.b());
                cVar2.l(startLoadTimeInterval.a());
            }
            cVar2.u(0);
        } else if (b2.equals("device/getZid")) {
            cVar2.o(true);
            c zid = this.mJsBridge.getZid();
            if (zid != null) {
                cVar2.t(zid.e());
                cVar2.q(zid.b());
                cVar2.l(zid.a());
            }
            cVar2.u(0);
        } else if (b2.equals("share/registerShareDataNew")) {
            cVar2.o(true);
            c shareInfo = this.mJsBridge.setShareInfo(e2.optString("title"), e2.optString("desc"), e2.optString("img"), e2.optString("url"), e2.optString("topic"), e2.optString("wbtitle"), e2.optString("wbcontent"), e2.optString("isShowMoreForum"), e2.optInt("shareimg"), e2.optString("extdata"));
            if (shareInfo != null) {
                cVar2.t(shareInfo.e());
                cVar2.q(shareInfo.b());
                cVar2.l(shareInfo.a());
            }
            cVar2.u(0);
        } else if (b2.equals("share/share")) {
            cVar2.o(true);
            c share = this.mJsBridge.share(e2.optInt("channel"), e2.optInt("shareImg"), e2.optString("img"), e2.optString("isShowMoreForum"), e2.optString("url"), e2.optString("title"), e2.optString("desc"), e2.optString("topic"), e2.optString("wbtitle"), e2.optString("wbcontent"), e2.optInt("weixinDisable"), e2.optString("extData"));
            if (share != null) {
                cVar2.t(share.e());
                cVar2.q(share.b());
                cVar2.l(share.a());
            }
            cVar2.u(0);
        } else if (b2.equals("clipper/getClipperInformation")) {
            cVar2.o(true);
            c clipperInformation = this.mJsBridge.getClipperInformation();
            if (clipperInformation != null) {
                cVar2.t(clipperInformation.e());
                cVar2.q(clipperInformation.b());
                cVar2.l(clipperInformation.a());
            }
            cVar2.u(0);
        } else if (b2.equals("clipper/setClipperInformation")) {
            cVar2.o(true);
            c clipperInformation2 = this.mJsBridge.setClipperInformation(e2.optString(DocumentOpenUtil.TXT));
            if (clipperInformation2 != null) {
                cVar2.t(clipperInformation2.e());
                cVar2.q(clipperInformation2.b());
                cVar2.l(clipperInformation2.a());
            }
            cVar2.u(0);
        } else if (b2.equals("router/goToEditPost")) {
            cVar2.o(true);
            c goToEditPost = this.mJsBridge.goToEditPost(e2.optString(IAdRequestParam.POS), e2.optString("tid"), e2.optString("floorId"), e2.optString("postId"), e2.optString("content"), e2.optString("fid"), e2.optString("fname"));
            if (goToEditPost != null) {
                cVar2.t(goToEditPost.e());
                cVar2.q(goToEditPost.b());
                cVar2.l(goToEditPost.a());
            }
            cVar2.u(0);
        } else if (b2.equals("system/checkAppInstall")) {
            cVar2.o(true);
            c checkAppInstall = this.mJsBridge.checkAppInstall(e2.optString(PushClientConstants.TAG_PKG_NAME));
            if (checkAppInstall != null) {
                cVar2.t(checkAppInstall.e());
                cVar2.q(checkAppInstall.b());
                cVar2.l(checkAppInstall.a());
            }
            cVar2.u(0);
        } else if (b2.equals("system/disableSlideBack")) {
            cVar2.o(true);
            c disableBack = this.mJsBridge.disableBack(e2.optInt(PackageTable.DISABLE));
            if (disableBack != null) {
                cVar2.t(disableBack.e());
                cVar2.q(disableBack.b());
                cVar2.l(disableBack.a());
            }
            cVar2.u(0);
        } else if (b2.equals("system/startApp")) {
            cVar2.o(true);
            c startApp = this.mJsBridge.startApp(e2.optString(PushClientConstants.TAG_PKG_NAME), e2.optString("schema"));
            if (startApp != null) {
                cVar2.t(startApp.e());
                cVar2.q(startApp.b());
                cVar2.l(startApp.a());
            }
            cVar2.u(0);
        } else if (b2.equals("system/hasNotificationPermission")) {
            cVar2.o(true);
            c hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
            if (hasNotificationPermission != null) {
                cVar2.t(hasNotificationPermission.e());
                cVar2.q(hasNotificationPermission.b());
                cVar2.l(hasNotificationPermission.a());
            }
            cVar2.u(0);
        } else if (b2.equals("system/goToNotificationSetting")) {
            cVar2.o(true);
            c goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
            if (goToNotificationSetting != null) {
                cVar2.t(goToNotificationSetting.e());
                cVar2.q(goToNotificationSetting.b());
                cVar2.l(goToNotificationSetting.a());
            }
            cVar2.u(0);
        } else if (b2.equals("account/startDownloadCss")) {
            cVar2.o(true);
            c startDownloadCss = this.mJsBridge.startDownloadCss(e2.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL));
            if (startDownloadCss != null) {
                cVar2.t(startDownloadCss.e());
                cVar2.q(startDownloadCss.b());
                cVar2.l(startDownloadCss.a());
            }
            cVar2.u(0);
        } else if (b2.equals("navigationBar/isDisableGoBack")) {
            cVar2.o(true);
            c disableGoBack = this.mJsBridge.setDisableGoBack();
            if (disableGoBack != null) {
                cVar2.t(disableGoBack.e());
                cVar2.q(disableGoBack.b());
                cVar2.l(disableGoBack.a());
            }
            cVar2.u(0);
        } else if (b2.equals("device/getSupplementInfo")) {
            cVar2.o(true);
            c supplementInfo = this.mJsBridge.getSupplementInfo();
            if (supplementInfo != null) {
                cVar2.t(supplementInfo.e());
                cVar2.q(supplementInfo.b());
                cVar2.l(supplementInfo.a());
            }
            cVar2.u(0);
        } else if (b2.equals("device/getDeviceInfo")) {
            cVar2.o(true);
            c deviceInfo = this.mJsBridge.getDeviceInfo();
            if (deviceInfo != null) {
                cVar2.t(deviceInfo.e());
                cVar2.q(deviceInfo.b());
                cVar2.l(deviceInfo.a());
            }
            cVar2.u(0);
        } else if (b2.equals("activity/completeTask")) {
            cVar2.o(true);
            c sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(e2.optString("activityId"), e2.optString("missionId"));
            if (sendCompleteTaskReqMsg != null) {
                cVar2.t(sendCompleteTaskReqMsg.e());
                cVar2.q(sendCompleteTaskReqMsg.b());
                cVar2.l(sendCompleteTaskReqMsg.a());
            }
            cVar2.u(0);
        } else if (b2.equals("toast/showTipToast")) {
            cVar2.o(true);
            c showTipToast = this.mJsBridge.showTipToast(e2.optString("content"), e2.optString("linkUrl"), e2.optString("key"), e2.optInt("maxTimes"), e2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
            if (showTipToast != null) {
                cVar2.t(showTipToast.e());
                cVar2.q(showTipToast.b());
                cVar2.l(showTipToast.a());
            }
            cVar2.u(0);
        } else if (b2.equals("router/jumpToHTMLPage")) {
            cVar2.o(true);
            c jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(e2.optString("url"), e2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE));
            if (jumpToHtmlPage != null) {
                cVar2.t(jumpToHtmlPage.e());
                cVar2.q(jumpToHtmlPage.b());
                cVar2.l(jumpToHtmlPage.a());
            }
            cVar2.u(0);
        } else if (b2.equals("router/goToHotTrend")) {
            cVar2.o(true);
            c jumpToHotTrendPage = this.mJsBridge.jumpToHotTrendPage();
            if (jumpToHotTrendPage != null) {
                cVar2.t(jumpToHotTrendPage.e());
                cVar2.q(jumpToHotTrendPage.b());
                cVar2.l(jumpToHotTrendPage.a());
            }
            cVar2.u(0);
        } else if (b2.equals("toast/showAlertView")) {
            cVar2.o(true);
            c showAlertView = this.mJsBridge.showAlertView(e2.optString("title"), e2.optString("sub_title"), e2.optInt("btn_corner"), e2.optInt("btn_borderWidth"), e2.optString("cancel_btn_text"), e2.optString("cancel_btn_color"), e2.optString("cancel_btn_borderColor"), e2.optString("confirm_btn_text"), e2.optString("confirm_btn_color"), e2.optString("confirm_btn_borderColor"), e2.optString("confirm_btn_url"));
            if (showAlertView != null) {
                cVar2.t(showAlertView.e());
                cVar2.q(showAlertView.b());
                cVar2.l(showAlertView.a());
            }
            cVar2.u(0);
        }
        return cVar2;
    }

    @Override // d.b.i0.d3.l0.d.a
    public List<c> processNotification(String str, HashMap hashMap) {
        c cVar = null;
        if (k.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str.equals("saveImageSuccess")) {
            cVar = this.mJsBridge.saveImageSuccess(hashMap);
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
        }
        if (cVar != null) {
            cVar.u(0);
        }
        List<b> list = this.mAsyncCallBackMethodList.get(str);
        if (cVar != null && list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                b next = it.next();
                c cVar2 = new c();
                cVar2.s(next.a());
                cVar2.t(cVar.e());
                cVar2.q(cVar.b());
                cVar2.l(cVar.a());
                arrayList.add(cVar2);
                if (!next.b()) {
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
