package com.baidu.tieba.h5power;

import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.at;
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
        String dLY = eVar.dLY();
        JSONObject dLW = eVar.dLW();
        if (dLY.equals("account/startLoginModule")) {
            cVar.yf(true);
            c startLoginModule = this.mJsBridge.startLoginModule(dLW.optString("cssUrl"));
            if (startLoginModule != null) {
                cVar.setStatus(startLoginModule.getStatus());
                cVar.setMessage(startLoginModule.getMessage());
                cVar.setData(startLoginModule.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("router/finishThisPage")) {
            cVar.yf(true);
            c finishPage = this.mJsBridge.finishPage();
            if (finishPage != null) {
                cVar.setStatus(finishPage.getStatus());
                cVar.setMessage(finishPage.getMessage());
                cVar.setData(finishPage.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("toast/toastPopupView")) {
            cVar.yf(true);
            c showLowerHairHint = this.mJsBridge.showLowerHairHint(dLW.optInt("showType"), dLW.optInt("aheadType"), dLW.optString("message"), dLW.optString("btnText"), dLW.optInt("toastDuration"), dLW.optString("schema"), dLW.optString("token"), dLW.optDouble("opacity"), dLW.optString("imgUrl"), dLW.optString("url"), dLW.optInt("missionId"), dLW.optString("btnColor"), dLW.optString("messageColor"), dLW.optString("btnTextColor"), dLW.optInt("status"), dLW.optInt("finishThisPage"));
            if (showLowerHairHint != null) {
                cVar.setStatus(showLowerHairHint.getStatus());
                cVar.setMessage(showLowerHairHint.getMessage());
                cVar.setData(showLowerHairHint.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("router/goToBarDetail")) {
            cVar.yf(true);
            c handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(dLW.optString(TbTitleActivityConfig.FORUM_ID));
            if (handleGoToBarDetail != null) {
                cVar.setStatus(handleGoToBarDetail.getStatus());
                cVar.setMessage(handleGoToBarDetail.getMessage());
                cVar.setData(handleGoToBarDetail.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("system/saveImage")) {
            cVar.yf(true);
            c handleSaveImage = this.mJsBridge.handleSaveImage(dLW.optString("imgUrl"));
            this.mNotificationNameList.add("saveImageSuccess");
            if (handleSaveImage != null) {
                cVar.setStatus(handleSaveImage.getStatus());
                cVar.setMessage(handleSaveImage.getMessage());
                cVar.setData(handleSaveImage.getData());
                if (!cVar.isError()) {
                    cVar.yh(false);
                    addObserver("saveImageSuccess", cVar, false);
                }
            }
            cVar.Js(0);
        } else if (dLY.equals("system/playSound")) {
            cVar.yf(true);
            c playSound = this.mJsBridge.playSound(dLW.optString("soundUrl"));
            if (playSound != null) {
                cVar.setStatus(playSound.getStatus());
                cVar.setMessage(playSound.getMessage());
                cVar.setData(playSound.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("system/playVibrate")) {
            cVar.yf(true);
            c playVibrate = this.mJsBridge.playVibrate();
            if (playVibrate != null) {
                cVar.setStatus(playVibrate.getStatus());
                cVar.setMessage(playVibrate.getMessage());
                cVar.setData(playVibrate.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("account/loadThirdPartyLogin")) {
            cVar.yf(true);
            c jumpLoginActivity = this.mJsBridge.jumpLoginActivity(dLW.optInt("socialType"), dLW.optString("activityId"));
            if (jumpLoginActivity != null) {
                cVar.setStatus(jumpLoginActivity.getStatus());
                cVar.setMessage(jumpLoginActivity.getMessage());
                cVar.setData(jumpLoginActivity.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("device/getZid")) {
            cVar.yf(true);
            c zid = this.mJsBridge.getZid();
            if (zid != null) {
                cVar.setStatus(zid.getStatus());
                cVar.setMessage(zid.getMessage());
                cVar.setData(zid.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("share/registerShareDataNew")) {
            cVar.yf(true);
            c shareInfo = this.mJsBridge.setShareInfo(dLW.optString("title"), dLW.optString("desc"), dLW.optString("img"), dLW.optString("url"), dLW.optString(AlbumActivityConfig.FROM_TOPIC), dLW.optString("wbtitle"), dLW.optString("wbcontent"), dLW.optString("isShowMoreForum"), dLW.optInt("shareimg"), dLW.optString("extdata"));
            if (shareInfo != null) {
                cVar.setStatus(shareInfo.getStatus());
                cVar.setMessage(shareInfo.getMessage());
                cVar.setData(shareInfo.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("share/share")) {
            cVar.yf(true);
            c share = this.mJsBridge.share(dLW.optInt("channel"), dLW.optInt("shareImg"), dLW.optString("img"), dLW.optString("isShowMoreForum"), dLW.optString("url"), dLW.optString("title"), dLW.optString("desc"), dLW.optString(AlbumActivityConfig.FROM_TOPIC), dLW.optString("wbtitle"), dLW.optString("wbcontent"), dLW.optInt("weixinDisable"), dLW.optString(CashierData.EXT_DATA));
            if (share != null) {
                cVar.setStatus(share.getStatus());
                cVar.setMessage(share.getMessage());
                cVar.setData(share.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("clipper/getClipperInformation")) {
            cVar.yf(true);
            c clipperInformation = this.mJsBridge.getClipperInformation();
            if (clipperInformation != null) {
                cVar.setStatus(clipperInformation.getStatus());
                cVar.setMessage(clipperInformation.getMessage());
                cVar.setData(clipperInformation.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("clipper/setClipperInformation")) {
            cVar.yf(true);
            c clipperInformation2 = this.mJsBridge.setClipperInformation(dLW.optString(DocumentOpenUtil.TXT));
            if (clipperInformation2 != null) {
                cVar.setStatus(clipperInformation2.getStatus());
                cVar.setMessage(clipperInformation2.getMessage());
                cVar.setData(clipperInformation2.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("router/goToEditPost")) {
            cVar.yf(true);
            c goToEditPost = this.mJsBridge.goToEditPost(dLW.optString("pos"), dLW.optString("tid"), dLW.optString("floorId"), dLW.optString("postId"), dLW.optString("content"), dLW.optString("fid"), dLW.optString("fname"));
            if (goToEditPost != null) {
                cVar.setStatus(goToEditPost.getStatus());
                cVar.setMessage(goToEditPost.getMessage());
                cVar.setData(goToEditPost.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("system/checkAppInstall")) {
            cVar.yf(true);
            c checkAppInstall = this.mJsBridge.checkAppInstall(dLW.optString(PushClientConstants.TAG_PKG_NAME));
            if (checkAppInstall != null) {
                cVar.setStatus(checkAppInstall.getStatus());
                cVar.setMessage(checkAppInstall.getMessage());
                cVar.setData(checkAppInstall.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("system/disableSlideBack")) {
            cVar.yf(true);
            c disableBack = this.mJsBridge.disableBack(dLW.optInt("disable"));
            if (disableBack != null) {
                cVar.setStatus(disableBack.getStatus());
                cVar.setMessage(disableBack.getMessage());
                cVar.setData(disableBack.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("system/startApp")) {
            cVar.yf(true);
            c startApp = this.mJsBridge.startApp(dLW.optString(PushClientConstants.TAG_PKG_NAME), dLW.optString("schema"));
            if (startApp != null) {
                cVar.setStatus(startApp.getStatus());
                cVar.setMessage(startApp.getMessage());
                cVar.setData(startApp.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("system/hasNotificationPermission")) {
            cVar.yf(true);
            c hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
            if (hasNotificationPermission != null) {
                cVar.setStatus(hasNotificationPermission.getStatus());
                cVar.setMessage(hasNotificationPermission.getMessage());
                cVar.setData(hasNotificationPermission.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("system/goToNotificationSetting")) {
            cVar.yf(true);
            c goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
            if (goToNotificationSetting != null) {
                cVar.setStatus(goToNotificationSetting.getStatus());
                cVar.setMessage(goToNotificationSetting.getMessage());
                cVar.setData(goToNotificationSetting.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("account/startDownloadCss")) {
            cVar.yf(true);
            c startDownloadCss = this.mJsBridge.startDownloadCss(dLW.optString("downloadUrl"));
            if (startDownloadCss != null) {
                cVar.setStatus(startDownloadCss.getStatus());
                cVar.setMessage(startDownloadCss.getMessage());
                cVar.setData(startDownloadCss.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("navigationBar/isDisableGoBack")) {
            cVar.yf(true);
            c disableGoBack = this.mJsBridge.setDisableGoBack();
            if (disableGoBack != null) {
                cVar.setStatus(disableGoBack.getStatus());
                cVar.setMessage(disableGoBack.getMessage());
                cVar.setData(disableGoBack.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("device/getSupplementInfo")) {
            cVar.yf(true);
            c supplementInfo = this.mJsBridge.getSupplementInfo();
            if (supplementInfo != null) {
                cVar.setStatus(supplementInfo.getStatus());
                cVar.setMessage(supplementInfo.getMessage());
                cVar.setData(supplementInfo.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("device/getDeviceInfo")) {
            cVar.yf(true);
            c deviceInfo = this.mJsBridge.getDeviceInfo();
            if (deviceInfo != null) {
                cVar.setStatus(deviceInfo.getStatus());
                cVar.setMessage(deviceInfo.getMessage());
                cVar.setData(deviceInfo.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("activity/completeTask")) {
            cVar.yf(true);
            c sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(dLW.optString("activityId"), dLW.optString("missionId"));
            if (sendCompleteTaskReqMsg != null) {
                cVar.setStatus(sendCompleteTaskReqMsg.getStatus());
                cVar.setMessage(sendCompleteTaskReqMsg.getMessage());
                cVar.setData(sendCompleteTaskReqMsg.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("toast/showTipToast")) {
            cVar.yf(true);
            c showTipToast = this.mJsBridge.showTipToast(dLW.optString("content"), dLW.optString("linkUrl"), dLW.optString("key"), dLW.optInt("maxTimes"), dLW.optInt("finishThisPage"));
            if (showTipToast != null) {
                cVar.setStatus(showTipToast.getStatus());
                cVar.setMessage(showTipToast.getMessage());
                cVar.setData(showTipToast.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("router/jumpToHTMLPage")) {
            cVar.yf(true);
            c jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(dLW.optString("url"), dLW.optInt("finishThisPage"));
            if (jumpToHtmlPage != null) {
                cVar.setStatus(jumpToHtmlPage.getStatus());
                cVar.setMessage(jumpToHtmlPage.getMessage());
                cVar.setData(jumpToHtmlPage.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("router/goToHotTrend")) {
            cVar.yf(true);
            c jumpToHotTrendPage = this.mJsBridge.jumpToHotTrendPage();
            if (jumpToHotTrendPage != null) {
                cVar.setStatus(jumpToHotTrendPage.getStatus());
                cVar.setMessage(jumpToHotTrendPage.getMessage());
                cVar.setData(jumpToHotTrendPage.getData());
            }
            cVar.Js(0);
        } else if (dLY.equals("toast/showAlertView")) {
            cVar.yf(true);
            c showAlertView = this.mJsBridge.showAlertView(dLW.optString("title"), dLW.optString("sub_title"), dLW.optInt("btn_corner"), dLW.optInt("btn_borderWidth"), dLW.optString("cancel_btn_text"), dLW.optString("cancel_btn_color"), dLW.optString("cancel_btn_borderColor"), dLW.optString("confirm_btn_text"), dLW.optString("confirm_btn_color"), dLW.optString("confirm_btn_borderColor"), dLW.optString("confirm_btn_url"));
            if (showAlertView != null) {
                cVar.setStatus(showAlertView.getStatus());
                cVar.setMessage(showAlertView.getMessage());
                cVar.setData(showAlertView.getData());
            }
            cVar.Js(0);
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.e.a.a
    public List<c> processNotification(String str, HashMap hashMap) {
        c dealClickGoBackToH5;
        if (at.isEmpty(str) || !this.mNotificationNameList.contains(str)) {
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
            dealClickGoBackToH5.Js(0);
        }
        List<b> list = this.mAsyncCallBackMethodList.get(str);
        if (dealClickGoBackToH5 != null && list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                b next = it.next();
                c cVar = new c();
                cVar.Sk(next.getName());
                cVar.setStatus(dealClickGoBackToH5.getStatus());
                cVar.setMessage(dealClickGoBackToH5.getMessage());
                cVar.setData(dealClickGoBackToH5.getData());
                arrayList.add(cVar);
                if (!next.dLP()) {
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
