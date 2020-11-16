package com.baidu.tieba.h5power;

import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.baidu.tieba.tbadkCore.e.a.a;
import com.baidu.tieba.tbadkCore.e.a.b;
import com.baidu.tieba.tbadkCore.e.a.d;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CommonTbJsBridge_Proxy extends a {
    private CommonTbJsBridge mJsBridge;

    public CommonTbJsBridge_Proxy(CommonTbJsBridge commonTbJsBridge) {
        this.mJsBridge = commonTbJsBridge;
        this.mAsyncCallBackNameList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
        this.mNotificationNameList.add("changeSkinType");
        this.mNotificationNameList.add("ShareSuccessNotification");
        this.mNotificationNameList.add("thirdPartyLoginResultToH5");
        this.mNotificationNameList.add("loginResultToH5");
        this.mNotificationNameList.add("reshow");
        this.mNotificationNameList.add("clickGoBackToH5");
    }

    @Override // com.baidu.tieba.tbadkCore.e.a.a
    public b dispatch(d dVar, b bVar) {
        if (bVar == null) {
            bVar = new b();
        }
        String dKA = dVar.dKA();
        JSONObject dKy = dVar.dKy();
        if (dKA.equals("account/startLoginModule")) {
            bVar.xz(true);
            b startLoginModule = this.mJsBridge.startLoginModule(dKy.optString("cssUrl"));
            if (startLoginModule != null) {
                bVar.setStatus(startLoginModule.getStatus());
                bVar.setMessage(startLoginModule.getMessage());
                bVar.setData(startLoginModule.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("router/finishThisPage")) {
            bVar.xz(true);
            b finishPage = this.mJsBridge.finishPage();
            if (finishPage != null) {
                bVar.setStatus(finishPage.getStatus());
                bVar.setMessage(finishPage.getMessage());
                bVar.setData(finishPage.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("toast/toastPopupView")) {
            bVar.xz(true);
            b showLowerHairHint = this.mJsBridge.showLowerHairHint(dKy.optInt("showType"), dKy.optInt("aheadType"), dKy.optString("message"), dKy.optString("btnText"), dKy.optInt("toastDuration"), dKy.optString("schema"), dKy.optString("token"), dKy.optDouble("opacity"), dKy.optString("imgUrl"), dKy.optString("url"), dKy.optInt("missionId"), dKy.optString("btnColor"), dKy.optString("messageColor"), dKy.optString("btnTextColor"));
            if (showLowerHairHint != null) {
                bVar.setStatus(showLowerHairHint.getStatus());
                bVar.setMessage(showLowerHairHint.getMessage());
                bVar.setData(showLowerHairHint.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("router/goToMyPost")) {
            bVar.xz(true);
            b handleGoToMyPost = this.mJsBridge.handleGoToMyPost(dKy.optString("uid"));
            if (handleGoToMyPost != null) {
                bVar.setStatus(handleGoToMyPost.getStatus());
                bVar.setMessage(handleGoToMyPost.getMessage());
                bVar.setData(handleGoToMyPost.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("router/goToMyLive")) {
            bVar.xz(true);
            b handleGoToMyLive = this.mJsBridge.handleGoToMyLive(dKy.optString("uid"));
            if (handleGoToMyLive != null) {
                bVar.setStatus(handleGoToMyLive.getStatus());
                bVar.setMessage(handleGoToMyLive.getMessage());
                bVar.setData(handleGoToMyLive.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("system/playSound")) {
            bVar.xz(true);
            b playSound = this.mJsBridge.playSound(dKy.optString("soundUrl"));
            if (playSound != null) {
                bVar.setStatus(playSound.getStatus());
                bVar.setMessage(playSound.getMessage());
                bVar.setData(playSound.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("system/playVibrate")) {
            bVar.xz(true);
            b playVibrate = this.mJsBridge.playVibrate();
            if (playVibrate != null) {
                bVar.setStatus(playVibrate.getStatus());
                bVar.setMessage(playVibrate.getMessage());
                bVar.setData(playVibrate.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("account/loadThirdPartyLogin")) {
            bVar.xz(true);
            b jumpLoginActivity = this.mJsBridge.jumpLoginActivity(dKy.optInt("socialType"), dKy.optString("activityId"));
            if (jumpLoginActivity != null) {
                bVar.setStatus(jumpLoginActivity.getStatus());
                bVar.setMessage(jumpLoginActivity.getMessage());
                bVar.setData(jumpLoginActivity.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("device/getZid")) {
            bVar.xz(true);
            b zid = this.mJsBridge.getZid();
            if (zid != null) {
                bVar.setStatus(zid.getStatus());
                bVar.setMessage(zid.getMessage());
                bVar.setData(zid.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("share/registerShareDataNew")) {
            bVar.xz(true);
            b shareInfo = this.mJsBridge.setShareInfo(dKy.optString("title"), dKy.optString("desc"), dKy.optString("img"), dKy.optString("url"), dKy.optString("topic"), dKy.optString("wbtitle"), dKy.optString("wbcontent"), dKy.optString("isShowMoreForum"), dKy.optInt("shareimg"), dKy.optString("extdata"));
            if (shareInfo != null) {
                bVar.setStatus(shareInfo.getStatus());
                bVar.setMessage(shareInfo.getMessage());
                bVar.setData(shareInfo.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("share/share")) {
            bVar.xz(true);
            b share = this.mJsBridge.share(dKy.optInt("channel"), dKy.optInt("shareImg"), dKy.optString("img"), dKy.optString("isShowMoreForum"), dKy.optString("url"), dKy.optString("title"), dKy.optString("desc"), dKy.optString("topic"), dKy.optString("wbtitle"), dKy.optString("wbcontent"), dKy.optInt("weixinDisable"), dKy.optString(CashierData.EXT_DATA));
            if (share != null) {
                bVar.setStatus(share.getStatus());
                bVar.setMessage(share.getMessage());
                bVar.setData(share.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("clipper/getClipperInformation")) {
            bVar.xz(true);
            b clipperInformation = this.mJsBridge.getClipperInformation();
            if (clipperInformation != null) {
                bVar.setStatus(clipperInformation.getStatus());
                bVar.setMessage(clipperInformation.getMessage());
                bVar.setData(clipperInformation.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("clipper/setClipperInformation")) {
            bVar.xz(true);
            b clipperInformation2 = this.mJsBridge.setClipperInformation(dKy.optString(DocumentOpenUtil.TXT));
            if (clipperInformation2 != null) {
                bVar.setStatus(clipperInformation2.getStatus());
                bVar.setMessage(clipperInformation2.getMessage());
                bVar.setData(clipperInformation2.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("system/checkAppInstall")) {
            bVar.xz(true);
            b checkAppInstall = this.mJsBridge.checkAppInstall(dKy.optString(PushClientConstants.TAG_PKG_NAME));
            if (checkAppInstall != null) {
                bVar.setStatus(checkAppInstall.getStatus());
                bVar.setMessage(checkAppInstall.getMessage());
                bVar.setData(checkAppInstall.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("system/startApp")) {
            bVar.xz(true);
            b startApp = this.mJsBridge.startApp(dKy.optString(PushClientConstants.TAG_PKG_NAME), dKy.optString("schema"));
            if (startApp != null) {
                bVar.setStatus(startApp.getStatus());
                bVar.setMessage(startApp.getMessage());
                bVar.setData(startApp.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("system/hasNotificationPermission")) {
            bVar.xz(true);
            b hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
            if (hasNotificationPermission != null) {
                bVar.setStatus(hasNotificationPermission.getStatus());
                bVar.setMessage(hasNotificationPermission.getMessage());
                bVar.setData(hasNotificationPermission.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("system/goToNotificationSetting")) {
            bVar.xz(true);
            b goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
            if (goToNotificationSetting != null) {
                bVar.setStatus(goToNotificationSetting.getStatus());
                bVar.setMessage(goToNotificationSetting.getMessage());
                bVar.setData(goToNotificationSetting.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("account/startDownloadCss")) {
            bVar.xz(true);
            b startDownloadCss = this.mJsBridge.startDownloadCss(dKy.optString("downloadUrl"));
            if (startDownloadCss != null) {
                bVar.setStatus(startDownloadCss.getStatus());
                bVar.setMessage(startDownloadCss.getMessage());
                bVar.setData(startDownloadCss.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("navigationBar/isDisableGoBack")) {
            bVar.xz(true);
            b disableGoBack = this.mJsBridge.setDisableGoBack();
            if (disableGoBack != null) {
                bVar.setStatus(disableGoBack.getStatus());
                bVar.setMessage(disableGoBack.getMessage());
                bVar.setData(disableGoBack.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("device/getSupplementInfo")) {
            bVar.xz(true);
            b supplementInfo = this.mJsBridge.getSupplementInfo();
            if (supplementInfo != null) {
                bVar.setStatus(supplementInfo.getStatus());
                bVar.setMessage(supplementInfo.getMessage());
                bVar.setData(supplementInfo.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("device/getDeviceInfo")) {
            bVar.xz(true);
            b deviceInfo = this.mJsBridge.getDeviceInfo();
            if (deviceInfo != null) {
                bVar.setStatus(deviceInfo.getStatus());
                bVar.setMessage(deviceInfo.getMessage());
                bVar.setData(deviceInfo.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("activity/completeTask")) {
            bVar.xz(true);
            b sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(dKy.optString("activityId"), dKy.optString("missionId"));
            if (sendCompleteTaskReqMsg != null) {
                bVar.setStatus(sendCompleteTaskReqMsg.getStatus());
                bVar.setMessage(sendCompleteTaskReqMsg.getMessage());
                bVar.setData(sendCompleteTaskReqMsg.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("toast/showTipToast")) {
            bVar.xz(true);
            b showTipToast = this.mJsBridge.showTipToast(dKy.optString("content"), dKy.optString("linkUrl"), dKy.optString("key"), dKy.optInt("maxTimes"));
            if (showTipToast != null) {
                bVar.setStatus(showTipToast.getStatus());
                bVar.setMessage(showTipToast.getMessage());
                bVar.setData(showTipToast.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("router/jumpToHTMLPage")) {
            bVar.xz(true);
            b jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(dKy.optString("url"), dKy.optInt("finishThisPage"));
            if (jumpToHtmlPage != null) {
                bVar.setStatus(jumpToHtmlPage.getStatus());
                bVar.setMessage(jumpToHtmlPage.getMessage());
                bVar.setData(jumpToHtmlPage.getData());
            }
            bVar.Kn(0);
        } else if (dKA.equals("router/goToHotTrend")) {
            bVar.xz(true);
            b jumpToHotTrendPage = this.mJsBridge.jumpToHotTrendPage();
            if (jumpToHotTrendPage != null) {
                bVar.setStatus(jumpToHotTrendPage.getStatus());
                bVar.setMessage(jumpToHotTrendPage.getMessage());
                bVar.setData(jumpToHotTrendPage.getData());
            }
            bVar.Kn(0);
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.e.a.a
    public List<b> processNotification(String str, HashMap hashMap) {
        b dealClickGoBackToH5;
        if (au.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str.equals("changeSkinType")) {
            dealClickGoBackToH5 = this.mJsBridge.changeSkinTypeInH5(hashMap);
        } else if (str.equals("ShareSuccessNotification")) {
            dealClickGoBackToH5 = this.mJsBridge.shareSuccessNotification(hashMap);
        } else if (str.equals("thirdPartyLoginResultToH5")) {
            dealClickGoBackToH5 = this.mJsBridge.thirdPartyLoginResultToH5(hashMap);
        } else if (str.equals("loginResultToH5")) {
            dealClickGoBackToH5 = this.mJsBridge.onUserLoginChanged(hashMap);
        } else if (str.equals("reshow")) {
            dealClickGoBackToH5 = this.mJsBridge.reShow(hashMap);
        } else {
            dealClickGoBackToH5 = str.equals("clickGoBackToH5") ? this.mJsBridge.dealClickGoBackToH5(hashMap) : null;
        }
        if (dealClickGoBackToH5 != null) {
            dealClickGoBackToH5.Kn(0);
        }
        List<String> list = this.mAsyncCallBackNameList.get(str);
        if (dealClickGoBackToH5 != null && list != null) {
            for (String str2 : list) {
                b bVar = new b();
                bVar.Su(str2);
                bVar.setStatus(dealClickGoBackToH5.getStatus());
                bVar.setMessage(dealClickGoBackToH5.getMessage());
                bVar.setData(dealClickGoBackToH5.getData());
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }
}
