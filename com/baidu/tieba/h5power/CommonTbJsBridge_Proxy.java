package com.baidu.tieba.h5power;

import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.e.a.a;
import com.baidu.tieba.tbadkCore.e.a.b;
import com.baidu.tieba.tbadkCore.e.a.c;
import com.baidu.tieba.tbadkCore.e.a.e;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CommonTbJsBridge_Proxy extends a {
    private CommonTbJsBridge mJsBridge;

    public CommonTbJsBridge_Proxy(CommonTbJsBridge commonTbJsBridge) {
        this.mJsBridge = commonTbJsBridge;
        this.mAsyncCallBackMethodList = new LinkedHashMap();
        this.mNotificationNameList = new HashSet<>();
        this.mNotificationNameList.add("saveImageSuccess");
        this.mNotificationNameList.add("changeSkinType");
        this.mNotificationNameList.add("ShareSuccessNotification");
        this.mNotificationNameList.add("thirdPartyLoginResultToH5");
        this.mNotificationNameList.add("loginResultToH5");
        this.mNotificationNameList.add("reshow");
        this.mNotificationNameList.add("clickGoBackToH5");
    }

    @Override // com.baidu.tieba.tbadkCore.e.a.a
    public c dispatch(e eVar, c cVar) {
        if (cVar == null) {
            cVar = new c();
        }
        String dPS = eVar.dPS();
        JSONObject dPQ = eVar.dPQ();
        if (dPS.equals("account/startLoginModule")) {
            cVar.ye(true);
            c startLoginModule = this.mJsBridge.startLoginModule(dPQ.optString("cssUrl"));
            if (startLoginModule != null) {
                cVar.setStatus(startLoginModule.getStatus());
                cVar.setMessage(startLoginModule.getMessage());
                cVar.setData(startLoginModule.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("router/finishThisPage")) {
            cVar.ye(true);
            c finishPage = this.mJsBridge.finishPage();
            if (finishPage != null) {
                cVar.setStatus(finishPage.getStatus());
                cVar.setMessage(finishPage.getMessage());
                cVar.setData(finishPage.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("toast/toastPopupView")) {
            cVar.ye(true);
            c showLowerHairHint = this.mJsBridge.showLowerHairHint(dPQ.optInt("showType"), dPQ.optInt("aheadType"), dPQ.optString("message"), dPQ.optString("btnText"), dPQ.optInt("toastDuration"), dPQ.optString("schema"), dPQ.optString("token"), dPQ.optDouble("opacity"), dPQ.optString("imgUrl"), dPQ.optString("url"), dPQ.optInt("missionId"), dPQ.optString("btnColor"), dPQ.optString("messageColor"), dPQ.optString("btnTextColor"));
            if (showLowerHairHint != null) {
                cVar.setStatus(showLowerHairHint.getStatus());
                cVar.setMessage(showLowerHairHint.getMessage());
                cVar.setData(showLowerHairHint.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("router/goToBarDetail")) {
            cVar.ye(true);
            c handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(dPQ.optString(TbTitleActivityConfig.FORUM_ID));
            if (handleGoToBarDetail != null) {
                cVar.setStatus(handleGoToBarDetail.getStatus());
                cVar.setMessage(handleGoToBarDetail.getMessage());
                cVar.setData(handleGoToBarDetail.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("system/saveImage")) {
            cVar.ye(true);
            c handleSaveImage = this.mJsBridge.handleSaveImage(dPQ.optString("imgUrl"));
            this.mNotificationNameList.add("saveImageSuccess");
            if (handleSaveImage != null) {
                cVar.setStatus(handleSaveImage.getStatus());
                cVar.setMessage(handleSaveImage.getMessage());
                cVar.setData(handleSaveImage.getData());
                if (!cVar.isError()) {
                    cVar.yg(false);
                    addObserver("saveImageSuccess", cVar, false);
                }
            }
            cVar.Ld(0);
        } else if (dPS.equals("system/playSound")) {
            cVar.ye(true);
            c playSound = this.mJsBridge.playSound(dPQ.optString("soundUrl"));
            if (playSound != null) {
                cVar.setStatus(playSound.getStatus());
                cVar.setMessage(playSound.getMessage());
                cVar.setData(playSound.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("system/playVibrate")) {
            cVar.ye(true);
            c playVibrate = this.mJsBridge.playVibrate();
            if (playVibrate != null) {
                cVar.setStatus(playVibrate.getStatus());
                cVar.setMessage(playVibrate.getMessage());
                cVar.setData(playVibrate.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("account/loadThirdPartyLogin")) {
            cVar.ye(true);
            c jumpLoginActivity = this.mJsBridge.jumpLoginActivity(dPQ.optInt("socialType"), dPQ.optString("activityId"));
            if (jumpLoginActivity != null) {
                cVar.setStatus(jumpLoginActivity.getStatus());
                cVar.setMessage(jumpLoginActivity.getMessage());
                cVar.setData(jumpLoginActivity.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("device/getZid")) {
            cVar.ye(true);
            c zid = this.mJsBridge.getZid();
            if (zid != null) {
                cVar.setStatus(zid.getStatus());
                cVar.setMessage(zid.getMessage());
                cVar.setData(zid.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("share/registerShareDataNew")) {
            cVar.ye(true);
            c shareInfo = this.mJsBridge.setShareInfo(dPQ.optString("title"), dPQ.optString("desc"), dPQ.optString("img"), dPQ.optString("url"), dPQ.optString("topic"), dPQ.optString("wbtitle"), dPQ.optString("wbcontent"), dPQ.optString("isShowMoreForum"), dPQ.optInt("shareimg"), dPQ.optString("extdata"));
            if (shareInfo != null) {
                cVar.setStatus(shareInfo.getStatus());
                cVar.setMessage(shareInfo.getMessage());
                cVar.setData(shareInfo.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("share/share")) {
            cVar.ye(true);
            c share = this.mJsBridge.share(dPQ.optInt("channel"), dPQ.optInt("shareImg"), dPQ.optString("img"), dPQ.optString("isShowMoreForum"), dPQ.optString("url"), dPQ.optString("title"), dPQ.optString("desc"), dPQ.optString("topic"), dPQ.optString("wbtitle"), dPQ.optString("wbcontent"), dPQ.optInt("weixinDisable"), dPQ.optString(CashierData.EXT_DATA));
            if (share != null) {
                cVar.setStatus(share.getStatus());
                cVar.setMessage(share.getMessage());
                cVar.setData(share.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("clipper/getClipperInformation")) {
            cVar.ye(true);
            c clipperInformation = this.mJsBridge.getClipperInformation();
            if (clipperInformation != null) {
                cVar.setStatus(clipperInformation.getStatus());
                cVar.setMessage(clipperInformation.getMessage());
                cVar.setData(clipperInformation.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("clipper/setClipperInformation")) {
            cVar.ye(true);
            c clipperInformation2 = this.mJsBridge.setClipperInformation(dPQ.optString(DocumentOpenUtil.TXT));
            if (clipperInformation2 != null) {
                cVar.setStatus(clipperInformation2.getStatus());
                cVar.setMessage(clipperInformation2.getMessage());
                cVar.setData(clipperInformation2.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("system/checkAppInstall")) {
            cVar.ye(true);
            c checkAppInstall = this.mJsBridge.checkAppInstall(dPQ.optString(PushClientConstants.TAG_PKG_NAME));
            if (checkAppInstall != null) {
                cVar.setStatus(checkAppInstall.getStatus());
                cVar.setMessage(checkAppInstall.getMessage());
                cVar.setData(checkAppInstall.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("system/startApp")) {
            cVar.ye(true);
            c startApp = this.mJsBridge.startApp(dPQ.optString(PushClientConstants.TAG_PKG_NAME), dPQ.optString("schema"));
            if (startApp != null) {
                cVar.setStatus(startApp.getStatus());
                cVar.setMessage(startApp.getMessage());
                cVar.setData(startApp.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("system/hasNotificationPermission")) {
            cVar.ye(true);
            c hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
            if (hasNotificationPermission != null) {
                cVar.setStatus(hasNotificationPermission.getStatus());
                cVar.setMessage(hasNotificationPermission.getMessage());
                cVar.setData(hasNotificationPermission.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("system/goToNotificationSetting")) {
            cVar.ye(true);
            c goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
            if (goToNotificationSetting != null) {
                cVar.setStatus(goToNotificationSetting.getStatus());
                cVar.setMessage(goToNotificationSetting.getMessage());
                cVar.setData(goToNotificationSetting.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("account/startDownloadCss")) {
            cVar.ye(true);
            c startDownloadCss = this.mJsBridge.startDownloadCss(dPQ.optString("downloadUrl"));
            if (startDownloadCss != null) {
                cVar.setStatus(startDownloadCss.getStatus());
                cVar.setMessage(startDownloadCss.getMessage());
                cVar.setData(startDownloadCss.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("navigationBar/isDisableGoBack")) {
            cVar.ye(true);
            c disableGoBack = this.mJsBridge.setDisableGoBack();
            if (disableGoBack != null) {
                cVar.setStatus(disableGoBack.getStatus());
                cVar.setMessage(disableGoBack.getMessage());
                cVar.setData(disableGoBack.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("device/getSupplementInfo")) {
            cVar.ye(true);
            c supplementInfo = this.mJsBridge.getSupplementInfo();
            if (supplementInfo != null) {
                cVar.setStatus(supplementInfo.getStatus());
                cVar.setMessage(supplementInfo.getMessage());
                cVar.setData(supplementInfo.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("device/getDeviceInfo")) {
            cVar.ye(true);
            c deviceInfo = this.mJsBridge.getDeviceInfo();
            if (deviceInfo != null) {
                cVar.setStatus(deviceInfo.getStatus());
                cVar.setMessage(deviceInfo.getMessage());
                cVar.setData(deviceInfo.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("activity/completeTask")) {
            cVar.ye(true);
            c sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(dPQ.optString("activityId"), dPQ.optString("missionId"));
            if (sendCompleteTaskReqMsg != null) {
                cVar.setStatus(sendCompleteTaskReqMsg.getStatus());
                cVar.setMessage(sendCompleteTaskReqMsg.getMessage());
                cVar.setData(sendCompleteTaskReqMsg.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("toast/showTipToast")) {
            cVar.ye(true);
            c showTipToast = this.mJsBridge.showTipToast(dPQ.optString("content"), dPQ.optString("linkUrl"), dPQ.optString("key"), dPQ.optInt("maxTimes"));
            if (showTipToast != null) {
                cVar.setStatus(showTipToast.getStatus());
                cVar.setMessage(showTipToast.getMessage());
                cVar.setData(showTipToast.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("router/jumpToHTMLPage")) {
            cVar.ye(true);
            c jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(dPQ.optString("url"), dPQ.optInt("finishThisPage"));
            if (jumpToHtmlPage != null) {
                cVar.setStatus(jumpToHtmlPage.getStatus());
                cVar.setMessage(jumpToHtmlPage.getMessage());
                cVar.setData(jumpToHtmlPage.getData());
            }
            cVar.Ld(0);
        } else if (dPS.equals("router/goToHotTrend")) {
            cVar.ye(true);
            c jumpToHotTrendPage = this.mJsBridge.jumpToHotTrendPage();
            if (jumpToHotTrendPage != null) {
                cVar.setStatus(jumpToHotTrendPage.getStatus());
                cVar.setMessage(jumpToHotTrendPage.getMessage());
                cVar.setData(jumpToHotTrendPage.getData());
            }
            cVar.Ld(0);
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.e.a.a
    public List<c> processNotification(String str, HashMap hashMap) {
        c dealClickGoBackToH5;
        if (au.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str.equals("saveImageSuccess")) {
            dealClickGoBackToH5 = this.mJsBridge.saveImageSuccess(hashMap);
        } else if (str.equals("changeSkinType")) {
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
            dealClickGoBackToH5.Ld(0);
        }
        List<b> list = this.mAsyncCallBackMethodList.get(str);
        if (dealClickGoBackToH5 != null && list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                b next = it.next();
                c cVar = new c();
                cVar.TI(next.getName());
                cVar.setStatus(dealClickGoBackToH5.getStatus());
                cVar.setMessage(dealClickGoBackToH5.getMessage());
                cVar.setData(dealClickGoBackToH5.getData());
                arrayList.add(cVar);
                if (!next.dPJ()) {
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
