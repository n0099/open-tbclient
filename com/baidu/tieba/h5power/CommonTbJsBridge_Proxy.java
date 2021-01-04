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
        String dPP = eVar.dPP();
        JSONObject dPN = eVar.dPN();
        if (dPP.equals("account/startLoginModule")) {
            cVar.yj(true);
            c startLoginModule = this.mJsBridge.startLoginModule(dPN.optString("cssUrl"));
            if (startLoginModule != null) {
                cVar.setStatus(startLoginModule.getStatus());
                cVar.setMessage(startLoginModule.getMessage());
                cVar.setData(startLoginModule.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("router/finishThisPage")) {
            cVar.yj(true);
            c finishPage = this.mJsBridge.finishPage();
            if (finishPage != null) {
                cVar.setStatus(finishPage.getStatus());
                cVar.setMessage(finishPage.getMessage());
                cVar.setData(finishPage.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("toast/toastPopupView")) {
            cVar.yj(true);
            c showLowerHairHint = this.mJsBridge.showLowerHairHint(dPN.optInt("showType"), dPN.optInt("aheadType"), dPN.optString("message"), dPN.optString("btnText"), dPN.optInt("toastDuration"), dPN.optString("schema"), dPN.optString("token"), dPN.optDouble("opacity"), dPN.optString("imgUrl"), dPN.optString("url"), dPN.optInt("missionId"), dPN.optString("btnColor"), dPN.optString("messageColor"), dPN.optString("btnTextColor"), dPN.optInt("status"), dPN.optInt("finishThisPage"));
            if (showLowerHairHint != null) {
                cVar.setStatus(showLowerHairHint.getStatus());
                cVar.setMessage(showLowerHairHint.getMessage());
                cVar.setData(showLowerHairHint.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("router/goToBarDetail")) {
            cVar.yj(true);
            c handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(dPN.optString(TbTitleActivityConfig.FORUM_ID));
            if (handleGoToBarDetail != null) {
                cVar.setStatus(handleGoToBarDetail.getStatus());
                cVar.setMessage(handleGoToBarDetail.getMessage());
                cVar.setData(handleGoToBarDetail.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("system/saveImage")) {
            cVar.yj(true);
            c handleSaveImage = this.mJsBridge.handleSaveImage(dPN.optString("imgUrl"));
            this.mNotificationNameList.add("saveImageSuccess");
            if (handleSaveImage != null) {
                cVar.setStatus(handleSaveImage.getStatus());
                cVar.setMessage(handleSaveImage.getMessage());
                cVar.setData(handleSaveImage.getData());
                if (!cVar.isError()) {
                    cVar.yl(false);
                    addObserver("saveImageSuccess", cVar, false);
                }
            }
            cVar.KZ(0);
        } else if (dPP.equals("system/playSound")) {
            cVar.yj(true);
            c playSound = this.mJsBridge.playSound(dPN.optString("soundUrl"));
            if (playSound != null) {
                cVar.setStatus(playSound.getStatus());
                cVar.setMessage(playSound.getMessage());
                cVar.setData(playSound.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("system/playVibrate")) {
            cVar.yj(true);
            c playVibrate = this.mJsBridge.playVibrate();
            if (playVibrate != null) {
                cVar.setStatus(playVibrate.getStatus());
                cVar.setMessage(playVibrate.getMessage());
                cVar.setData(playVibrate.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("account/loadThirdPartyLogin")) {
            cVar.yj(true);
            c jumpLoginActivity = this.mJsBridge.jumpLoginActivity(dPN.optInt("socialType"), dPN.optString("activityId"));
            if (jumpLoginActivity != null) {
                cVar.setStatus(jumpLoginActivity.getStatus());
                cVar.setMessage(jumpLoginActivity.getMessage());
                cVar.setData(jumpLoginActivity.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("device/getZid")) {
            cVar.yj(true);
            c zid = this.mJsBridge.getZid();
            if (zid != null) {
                cVar.setStatus(zid.getStatus());
                cVar.setMessage(zid.getMessage());
                cVar.setData(zid.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("share/registerShareDataNew")) {
            cVar.yj(true);
            c shareInfo = this.mJsBridge.setShareInfo(dPN.optString("title"), dPN.optString("desc"), dPN.optString("img"), dPN.optString("url"), dPN.optString(AlbumActivityConfig.FROM_TOPIC), dPN.optString("wbtitle"), dPN.optString("wbcontent"), dPN.optString("isShowMoreForum"), dPN.optInt("shareimg"), dPN.optString("extdata"));
            if (shareInfo != null) {
                cVar.setStatus(shareInfo.getStatus());
                cVar.setMessage(shareInfo.getMessage());
                cVar.setData(shareInfo.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("share/share")) {
            cVar.yj(true);
            c share = this.mJsBridge.share(dPN.optInt("channel"), dPN.optInt("shareImg"), dPN.optString("img"), dPN.optString("isShowMoreForum"), dPN.optString("url"), dPN.optString("title"), dPN.optString("desc"), dPN.optString(AlbumActivityConfig.FROM_TOPIC), dPN.optString("wbtitle"), dPN.optString("wbcontent"), dPN.optInt("weixinDisable"), dPN.optString(CashierData.EXT_DATA));
            if (share != null) {
                cVar.setStatus(share.getStatus());
                cVar.setMessage(share.getMessage());
                cVar.setData(share.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("clipper/getClipperInformation")) {
            cVar.yj(true);
            c clipperInformation = this.mJsBridge.getClipperInformation();
            if (clipperInformation != null) {
                cVar.setStatus(clipperInformation.getStatus());
                cVar.setMessage(clipperInformation.getMessage());
                cVar.setData(clipperInformation.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("clipper/setClipperInformation")) {
            cVar.yj(true);
            c clipperInformation2 = this.mJsBridge.setClipperInformation(dPN.optString(DocumentOpenUtil.TXT));
            if (clipperInformation2 != null) {
                cVar.setStatus(clipperInformation2.getStatus());
                cVar.setMessage(clipperInformation2.getMessage());
                cVar.setData(clipperInformation2.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("router/goToEditPost")) {
            cVar.yj(true);
            c goToEditPost = this.mJsBridge.goToEditPost(dPN.optString("pos"), dPN.optString("tid"), dPN.optString("floorId"), dPN.optString("postId"), dPN.optString("content"), dPN.optString("fid"), dPN.optString("fname"));
            if (goToEditPost != null) {
                cVar.setStatus(goToEditPost.getStatus());
                cVar.setMessage(goToEditPost.getMessage());
                cVar.setData(goToEditPost.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("system/checkAppInstall")) {
            cVar.yj(true);
            c checkAppInstall = this.mJsBridge.checkAppInstall(dPN.optString(PushClientConstants.TAG_PKG_NAME));
            if (checkAppInstall != null) {
                cVar.setStatus(checkAppInstall.getStatus());
                cVar.setMessage(checkAppInstall.getMessage());
                cVar.setData(checkAppInstall.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("system/disableSlideBack")) {
            cVar.yj(true);
            c disableBack = this.mJsBridge.disableBack(dPN.optInt("disable"));
            if (disableBack != null) {
                cVar.setStatus(disableBack.getStatus());
                cVar.setMessage(disableBack.getMessage());
                cVar.setData(disableBack.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("system/startApp")) {
            cVar.yj(true);
            c startApp = this.mJsBridge.startApp(dPN.optString(PushClientConstants.TAG_PKG_NAME), dPN.optString("schema"));
            if (startApp != null) {
                cVar.setStatus(startApp.getStatus());
                cVar.setMessage(startApp.getMessage());
                cVar.setData(startApp.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("system/hasNotificationPermission")) {
            cVar.yj(true);
            c hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
            if (hasNotificationPermission != null) {
                cVar.setStatus(hasNotificationPermission.getStatus());
                cVar.setMessage(hasNotificationPermission.getMessage());
                cVar.setData(hasNotificationPermission.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("system/goToNotificationSetting")) {
            cVar.yj(true);
            c goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
            if (goToNotificationSetting != null) {
                cVar.setStatus(goToNotificationSetting.getStatus());
                cVar.setMessage(goToNotificationSetting.getMessage());
                cVar.setData(goToNotificationSetting.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("account/startDownloadCss")) {
            cVar.yj(true);
            c startDownloadCss = this.mJsBridge.startDownloadCss(dPN.optString("downloadUrl"));
            if (startDownloadCss != null) {
                cVar.setStatus(startDownloadCss.getStatus());
                cVar.setMessage(startDownloadCss.getMessage());
                cVar.setData(startDownloadCss.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("navigationBar/isDisableGoBack")) {
            cVar.yj(true);
            c disableGoBack = this.mJsBridge.setDisableGoBack();
            if (disableGoBack != null) {
                cVar.setStatus(disableGoBack.getStatus());
                cVar.setMessage(disableGoBack.getMessage());
                cVar.setData(disableGoBack.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("device/getSupplementInfo")) {
            cVar.yj(true);
            c supplementInfo = this.mJsBridge.getSupplementInfo();
            if (supplementInfo != null) {
                cVar.setStatus(supplementInfo.getStatus());
                cVar.setMessage(supplementInfo.getMessage());
                cVar.setData(supplementInfo.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("device/getDeviceInfo")) {
            cVar.yj(true);
            c deviceInfo = this.mJsBridge.getDeviceInfo();
            if (deviceInfo != null) {
                cVar.setStatus(deviceInfo.getStatus());
                cVar.setMessage(deviceInfo.getMessage());
                cVar.setData(deviceInfo.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("activity/completeTask")) {
            cVar.yj(true);
            c sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(dPN.optString("activityId"), dPN.optString("missionId"));
            if (sendCompleteTaskReqMsg != null) {
                cVar.setStatus(sendCompleteTaskReqMsg.getStatus());
                cVar.setMessage(sendCompleteTaskReqMsg.getMessage());
                cVar.setData(sendCompleteTaskReqMsg.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("toast/showTipToast")) {
            cVar.yj(true);
            c showTipToast = this.mJsBridge.showTipToast(dPN.optString("content"), dPN.optString("linkUrl"), dPN.optString("key"), dPN.optInt("maxTimes"), dPN.optInt("finishThisPage"));
            if (showTipToast != null) {
                cVar.setStatus(showTipToast.getStatus());
                cVar.setMessage(showTipToast.getMessage());
                cVar.setData(showTipToast.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("router/jumpToHTMLPage")) {
            cVar.yj(true);
            c jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(dPN.optString("url"), dPN.optInt("finishThisPage"));
            if (jumpToHtmlPage != null) {
                cVar.setStatus(jumpToHtmlPage.getStatus());
                cVar.setMessage(jumpToHtmlPage.getMessage());
                cVar.setData(jumpToHtmlPage.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("router/goToHotTrend")) {
            cVar.yj(true);
            c jumpToHotTrendPage = this.mJsBridge.jumpToHotTrendPage();
            if (jumpToHotTrendPage != null) {
                cVar.setStatus(jumpToHotTrendPage.getStatus());
                cVar.setMessage(jumpToHotTrendPage.getMessage());
                cVar.setData(jumpToHotTrendPage.getData());
            }
            cVar.KZ(0);
        } else if (dPP.equals("toast/showAlertView")) {
            cVar.yj(true);
            c showAlertView = this.mJsBridge.showAlertView(dPN.optString("title"), dPN.optString("sub_title"), dPN.optInt("btn_corner"), dPN.optInt("btn_borderWidth"), dPN.optString("cancel_btn_text"), dPN.optString("cancel_btn_color"), dPN.optString("cancel_btn_borderColor"), dPN.optString("confirm_btn_text"), dPN.optString("confirm_btn_color"), dPN.optString("confirm_btn_borderColor"), dPN.optString("confirm_btn_url"));
            if (showAlertView != null) {
                cVar.setStatus(showAlertView.getStatus());
                cVar.setMessage(showAlertView.getMessage());
                cVar.setData(showAlertView.getData());
            }
            cVar.KZ(0);
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
            dealClickGoBackToH5.KZ(0);
        }
        List<b> list = this.mAsyncCallBackMethodList.get(str);
        if (dealClickGoBackToH5 != null && list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                b next = it.next();
                c cVar = new c();
                cVar.Ts(next.getName());
                cVar.setStatus(dealClickGoBackToH5.getStatus());
                cVar.setMessage(dealClickGoBackToH5.getMessage());
                cVar.setData(dealClickGoBackToH5.getData());
                arrayList.add(cVar);
                if (!next.dPG()) {
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
