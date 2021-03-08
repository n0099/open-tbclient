package com.baidu.tieba.h5power;

import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
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
        String dOA = eVar.dOA();
        JSONObject dOy = eVar.dOy();
        if (dOA.equals("account/startLoginModule")) {
            cVar.yx(true);
            c startLoginModule = this.mJsBridge.startLoginModule(dOy.optString("cssUrl"));
            if (startLoginModule != null) {
                cVar.setStatus(startLoginModule.getStatus());
                cVar.setMessage(startLoginModule.getMessage());
                cVar.setData(startLoginModule.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("router/finishThisPage")) {
            cVar.yx(true);
            c finishPage = this.mJsBridge.finishPage();
            if (finishPage != null) {
                cVar.setStatus(finishPage.getStatus());
                cVar.setMessage(finishPage.getMessage());
                cVar.setData(finishPage.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("toast/toastPopupView")) {
            cVar.yx(true);
            c showLowerHairHint = this.mJsBridge.showLowerHairHint(dOy.optInt("showType"), dOy.optInt("aheadType"), dOy.optString("message"), dOy.optString("btnText"), dOy.optInt("toastDuration"), dOy.optString("schema"), dOy.optString("token"), dOy.optDouble("opacity"), dOy.optString("imgUrl"), dOy.optString("url"), dOy.optInt("missionId"), dOy.optString("btnColor"), dOy.optString("messageColor"), dOy.optString("btnTextColor"), dOy.optInt("status"), dOy.optInt("finishThisPage"));
            if (showLowerHairHint != null) {
                cVar.setStatus(showLowerHairHint.getStatus());
                cVar.setMessage(showLowerHairHint.getMessage());
                cVar.setData(showLowerHairHint.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("router/goToBarDetail")) {
            cVar.yx(true);
            c handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(dOy.optString(TbTitleActivityConfig.FORUM_ID));
            if (handleGoToBarDetail != null) {
                cVar.setStatus(handleGoToBarDetail.getStatus());
                cVar.setMessage(handleGoToBarDetail.getMessage());
                cVar.setData(handleGoToBarDetail.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("system/saveImage")) {
            cVar.yx(true);
            c handleSaveImage = this.mJsBridge.handleSaveImage(dOy.optString("imgUrl"));
            this.mNotificationNameList.add("saveImageSuccess");
            if (handleSaveImage != null) {
                cVar.setStatus(handleSaveImage.getStatus());
                cVar.setMessage(handleSaveImage.getMessage());
                cVar.setData(handleSaveImage.getData());
                if (!cVar.isError()) {
                    cVar.yz(false);
                    addObserver("saveImageSuccess", cVar, false);
                }
            }
            cVar.JR(0);
        } else if (dOA.equals("system/playSound")) {
            cVar.yx(true);
            c playSound = this.mJsBridge.playSound(dOy.optString("soundUrl"));
            if (playSound != null) {
                cVar.setStatus(playSound.getStatus());
                cVar.setMessage(playSound.getMessage());
                cVar.setData(playSound.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("system/playVibrate")) {
            cVar.yx(true);
            c playVibrate = this.mJsBridge.playVibrate();
            if (playVibrate != null) {
                cVar.setStatus(playVibrate.getStatus());
                cVar.setMessage(playVibrate.getMessage());
                cVar.setData(playVibrate.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("account/loadThirdPartyLogin")) {
            cVar.yx(true);
            c jumpLoginActivity = this.mJsBridge.jumpLoginActivity(dOy.optInt("socialType"), dOy.optString("activityId"));
            if (jumpLoginActivity != null) {
                cVar.setStatus(jumpLoginActivity.getStatus());
                cVar.setMessage(jumpLoginActivity.getMessage());
                cVar.setData(jumpLoginActivity.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("system/startLoadTimeInterval")) {
            cVar.yx(true);
            c startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
            if (startLoadTimeInterval != null) {
                cVar.setStatus(startLoadTimeInterval.getStatus());
                cVar.setMessage(startLoadTimeInterval.getMessage());
                cVar.setData(startLoadTimeInterval.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("device/getZid")) {
            cVar.yx(true);
            c zid = this.mJsBridge.getZid();
            if (zid != null) {
                cVar.setStatus(zid.getStatus());
                cVar.setMessage(zid.getMessage());
                cVar.setData(zid.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("share/registerShareDataNew")) {
            cVar.yx(true);
            c shareInfo = this.mJsBridge.setShareInfo(dOy.optString("title"), dOy.optString("desc"), dOy.optString("img"), dOy.optString("url"), dOy.optString(AlbumActivityConfig.FROM_TOPIC), dOy.optString("wbtitle"), dOy.optString("wbcontent"), dOy.optString("isShowMoreForum"), dOy.optInt("shareimg"), dOy.optString("extdata"));
            if (shareInfo != null) {
                cVar.setStatus(shareInfo.getStatus());
                cVar.setMessage(shareInfo.getMessage());
                cVar.setData(shareInfo.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("share/share")) {
            cVar.yx(true);
            c share = this.mJsBridge.share(dOy.optInt("channel"), dOy.optInt("shareImg"), dOy.optString("img"), dOy.optString("isShowMoreForum"), dOy.optString("url"), dOy.optString("title"), dOy.optString("desc"), dOy.optString(AlbumActivityConfig.FROM_TOPIC), dOy.optString("wbtitle"), dOy.optString("wbcontent"), dOy.optInt("weixinDisable"), dOy.optString(CashierData.EXT_DATA));
            if (share != null) {
                cVar.setStatus(share.getStatus());
                cVar.setMessage(share.getMessage());
                cVar.setData(share.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("clipper/getClipperInformation")) {
            cVar.yx(true);
            c clipperInformation = this.mJsBridge.getClipperInformation();
            if (clipperInformation != null) {
                cVar.setStatus(clipperInformation.getStatus());
                cVar.setMessage(clipperInformation.getMessage());
                cVar.setData(clipperInformation.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("clipper/setClipperInformation")) {
            cVar.yx(true);
            c clipperInformation2 = this.mJsBridge.setClipperInformation(dOy.optString(DocumentOpenUtil.TXT));
            if (clipperInformation2 != null) {
                cVar.setStatus(clipperInformation2.getStatus());
                cVar.setMessage(clipperInformation2.getMessage());
                cVar.setData(clipperInformation2.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("router/goToEditPost")) {
            cVar.yx(true);
            c goToEditPost = this.mJsBridge.goToEditPost(dOy.optString("pos"), dOy.optString("tid"), dOy.optString("floorId"), dOy.optString("postId"), dOy.optString("content"), dOy.optString("fid"), dOy.optString("fname"));
            if (goToEditPost != null) {
                cVar.setStatus(goToEditPost.getStatus());
                cVar.setMessage(goToEditPost.getMessage());
                cVar.setData(goToEditPost.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("system/checkAppInstall")) {
            cVar.yx(true);
            c checkAppInstall = this.mJsBridge.checkAppInstall(dOy.optString(PushClientConstants.TAG_PKG_NAME));
            if (checkAppInstall != null) {
                cVar.setStatus(checkAppInstall.getStatus());
                cVar.setMessage(checkAppInstall.getMessage());
                cVar.setData(checkAppInstall.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("system/disableSlideBack")) {
            cVar.yx(true);
            c disableBack = this.mJsBridge.disableBack(dOy.optInt("disable"));
            if (disableBack != null) {
                cVar.setStatus(disableBack.getStatus());
                cVar.setMessage(disableBack.getMessage());
                cVar.setData(disableBack.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("system/startApp")) {
            cVar.yx(true);
            c startApp = this.mJsBridge.startApp(dOy.optString(PushClientConstants.TAG_PKG_NAME), dOy.optString("schema"));
            if (startApp != null) {
                cVar.setStatus(startApp.getStatus());
                cVar.setMessage(startApp.getMessage());
                cVar.setData(startApp.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("system/hasNotificationPermission")) {
            cVar.yx(true);
            c hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
            if (hasNotificationPermission != null) {
                cVar.setStatus(hasNotificationPermission.getStatus());
                cVar.setMessage(hasNotificationPermission.getMessage());
                cVar.setData(hasNotificationPermission.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("system/goToNotificationSetting")) {
            cVar.yx(true);
            c goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
            if (goToNotificationSetting != null) {
                cVar.setStatus(goToNotificationSetting.getStatus());
                cVar.setMessage(goToNotificationSetting.getMessage());
                cVar.setData(goToNotificationSetting.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("account/startDownloadCss")) {
            cVar.yx(true);
            c startDownloadCss = this.mJsBridge.startDownloadCss(dOy.optString("downloadUrl"));
            if (startDownloadCss != null) {
                cVar.setStatus(startDownloadCss.getStatus());
                cVar.setMessage(startDownloadCss.getMessage());
                cVar.setData(startDownloadCss.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("navigationBar/isDisableGoBack")) {
            cVar.yx(true);
            c disableGoBack = this.mJsBridge.setDisableGoBack();
            if (disableGoBack != null) {
                cVar.setStatus(disableGoBack.getStatus());
                cVar.setMessage(disableGoBack.getMessage());
                cVar.setData(disableGoBack.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("device/getSupplementInfo")) {
            cVar.yx(true);
            c supplementInfo = this.mJsBridge.getSupplementInfo();
            if (supplementInfo != null) {
                cVar.setStatus(supplementInfo.getStatus());
                cVar.setMessage(supplementInfo.getMessage());
                cVar.setData(supplementInfo.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("device/getDeviceInfo")) {
            cVar.yx(true);
            c deviceInfo = this.mJsBridge.getDeviceInfo();
            if (deviceInfo != null) {
                cVar.setStatus(deviceInfo.getStatus());
                cVar.setMessage(deviceInfo.getMessage());
                cVar.setData(deviceInfo.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("activity/completeTask")) {
            cVar.yx(true);
            c sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(dOy.optString("activityId"), dOy.optString("missionId"));
            if (sendCompleteTaskReqMsg != null) {
                cVar.setStatus(sendCompleteTaskReqMsg.getStatus());
                cVar.setMessage(sendCompleteTaskReqMsg.getMessage());
                cVar.setData(sendCompleteTaskReqMsg.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("toast/showTipToast")) {
            cVar.yx(true);
            c showTipToast = this.mJsBridge.showTipToast(dOy.optString("content"), dOy.optString("linkUrl"), dOy.optString("key"), dOy.optInt("maxTimes"), dOy.optInt("finishThisPage"));
            if (showTipToast != null) {
                cVar.setStatus(showTipToast.getStatus());
                cVar.setMessage(showTipToast.getMessage());
                cVar.setData(showTipToast.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("router/jumpToHTMLPage")) {
            cVar.yx(true);
            c jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(dOy.optString("url"), dOy.optInt("finishThisPage"));
            if (jumpToHtmlPage != null) {
                cVar.setStatus(jumpToHtmlPage.getStatus());
                cVar.setMessage(jumpToHtmlPage.getMessage());
                cVar.setData(jumpToHtmlPage.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("router/goToHotTrend")) {
            cVar.yx(true);
            c jumpToHotTrendPage = this.mJsBridge.jumpToHotTrendPage();
            if (jumpToHotTrendPage != null) {
                cVar.setStatus(jumpToHotTrendPage.getStatus());
                cVar.setMessage(jumpToHotTrendPage.getMessage());
                cVar.setData(jumpToHotTrendPage.getData());
            }
            cVar.JR(0);
        } else if (dOA.equals("toast/showAlertView")) {
            cVar.yx(true);
            c showAlertView = this.mJsBridge.showAlertView(dOy.optString("title"), dOy.optString("sub_title"), dOy.optInt("btn_corner"), dOy.optInt("btn_borderWidth"), dOy.optString("cancel_btn_text"), dOy.optString("cancel_btn_color"), dOy.optString("cancel_btn_borderColor"), dOy.optString("confirm_btn_text"), dOy.optString("confirm_btn_color"), dOy.optString("confirm_btn_borderColor"), dOy.optString("confirm_btn_url"));
            if (showAlertView != null) {
                cVar.setStatus(showAlertView.getStatus());
                cVar.setMessage(showAlertView.getMessage());
                cVar.setData(showAlertView.getData());
            }
            cVar.JR(0);
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
            dealClickGoBackToH5.JR(0);
        }
        List<b> list = this.mAsyncCallBackMethodList.get(str);
        if (dealClickGoBackToH5 != null && list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                b next = it.next();
                c cVar = new c();
                cVar.TA(next.getName());
                cVar.setStatus(dealClickGoBackToH5.getStatus());
                cVar.setMessage(dealClickGoBackToH5.getMessage());
                cVar.setData(dealClickGoBackToH5.getData());
                arrayList.add(cVar);
                if (!next.dOr()) {
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
