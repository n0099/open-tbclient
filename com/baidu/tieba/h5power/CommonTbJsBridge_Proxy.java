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
        String dPQ = eVar.dPQ();
        JSONObject dPO = eVar.dPO();
        if (dPQ.equals("account/startLoginModule")) {
            cVar.yj(true);
            c startLoginModule = this.mJsBridge.startLoginModule(dPO.optString("cssUrl"));
            if (startLoginModule != null) {
                cVar.setStatus(startLoginModule.getStatus());
                cVar.setMessage(startLoginModule.getMessage());
                cVar.setData(startLoginModule.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("router/finishThisPage")) {
            cVar.yj(true);
            c finishPage = this.mJsBridge.finishPage();
            if (finishPage != null) {
                cVar.setStatus(finishPage.getStatus());
                cVar.setMessage(finishPage.getMessage());
                cVar.setData(finishPage.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("toast/toastPopupView")) {
            cVar.yj(true);
            c showLowerHairHint = this.mJsBridge.showLowerHairHint(dPO.optInt("showType"), dPO.optInt("aheadType"), dPO.optString("message"), dPO.optString("btnText"), dPO.optInt("toastDuration"), dPO.optString("schema"), dPO.optString("token"), dPO.optDouble("opacity"), dPO.optString("imgUrl"), dPO.optString("url"), dPO.optInt("missionId"), dPO.optString("btnColor"), dPO.optString("messageColor"), dPO.optString("btnTextColor"), dPO.optInt("status"), dPO.optInt("finishThisPage"));
            if (showLowerHairHint != null) {
                cVar.setStatus(showLowerHairHint.getStatus());
                cVar.setMessage(showLowerHairHint.getMessage());
                cVar.setData(showLowerHairHint.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("router/goToBarDetail")) {
            cVar.yj(true);
            c handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(dPO.optString(TbTitleActivityConfig.FORUM_ID));
            if (handleGoToBarDetail != null) {
                cVar.setStatus(handleGoToBarDetail.getStatus());
                cVar.setMessage(handleGoToBarDetail.getMessage());
                cVar.setData(handleGoToBarDetail.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("system/saveImage")) {
            cVar.yj(true);
            c handleSaveImage = this.mJsBridge.handleSaveImage(dPO.optString("imgUrl"));
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
        } else if (dPQ.equals("system/playSound")) {
            cVar.yj(true);
            c playSound = this.mJsBridge.playSound(dPO.optString("soundUrl"));
            if (playSound != null) {
                cVar.setStatus(playSound.getStatus());
                cVar.setMessage(playSound.getMessage());
                cVar.setData(playSound.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("system/playVibrate")) {
            cVar.yj(true);
            c playVibrate = this.mJsBridge.playVibrate();
            if (playVibrate != null) {
                cVar.setStatus(playVibrate.getStatus());
                cVar.setMessage(playVibrate.getMessage());
                cVar.setData(playVibrate.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("account/loadThirdPartyLogin")) {
            cVar.yj(true);
            c jumpLoginActivity = this.mJsBridge.jumpLoginActivity(dPO.optInt("socialType"), dPO.optString("activityId"));
            if (jumpLoginActivity != null) {
                cVar.setStatus(jumpLoginActivity.getStatus());
                cVar.setMessage(jumpLoginActivity.getMessage());
                cVar.setData(jumpLoginActivity.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("device/getZid")) {
            cVar.yj(true);
            c zid = this.mJsBridge.getZid();
            if (zid != null) {
                cVar.setStatus(zid.getStatus());
                cVar.setMessage(zid.getMessage());
                cVar.setData(zid.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("share/registerShareDataNew")) {
            cVar.yj(true);
            c shareInfo = this.mJsBridge.setShareInfo(dPO.optString("title"), dPO.optString("desc"), dPO.optString("img"), dPO.optString("url"), dPO.optString(AlbumActivityConfig.FROM_TOPIC), dPO.optString("wbtitle"), dPO.optString("wbcontent"), dPO.optString("isShowMoreForum"), dPO.optInt("shareimg"), dPO.optString("extdata"));
            if (shareInfo != null) {
                cVar.setStatus(shareInfo.getStatus());
                cVar.setMessage(shareInfo.getMessage());
                cVar.setData(shareInfo.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("share/share")) {
            cVar.yj(true);
            c share = this.mJsBridge.share(dPO.optInt("channel"), dPO.optInt("shareImg"), dPO.optString("img"), dPO.optString("isShowMoreForum"), dPO.optString("url"), dPO.optString("title"), dPO.optString("desc"), dPO.optString(AlbumActivityConfig.FROM_TOPIC), dPO.optString("wbtitle"), dPO.optString("wbcontent"), dPO.optInt("weixinDisable"), dPO.optString(CashierData.EXT_DATA));
            if (share != null) {
                cVar.setStatus(share.getStatus());
                cVar.setMessage(share.getMessage());
                cVar.setData(share.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("clipper/getClipperInformation")) {
            cVar.yj(true);
            c clipperInformation = this.mJsBridge.getClipperInformation();
            if (clipperInformation != null) {
                cVar.setStatus(clipperInformation.getStatus());
                cVar.setMessage(clipperInformation.getMessage());
                cVar.setData(clipperInformation.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("clipper/setClipperInformation")) {
            cVar.yj(true);
            c clipperInformation2 = this.mJsBridge.setClipperInformation(dPO.optString(DocumentOpenUtil.TXT));
            if (clipperInformation2 != null) {
                cVar.setStatus(clipperInformation2.getStatus());
                cVar.setMessage(clipperInformation2.getMessage());
                cVar.setData(clipperInformation2.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("router/goToEditPost")) {
            cVar.yj(true);
            c goToEditPost = this.mJsBridge.goToEditPost(dPO.optString("pos"), dPO.optString("tid"), dPO.optString("floorId"), dPO.optString("postId"), dPO.optString("content"), dPO.optString("fid"), dPO.optString("fname"));
            if (goToEditPost != null) {
                cVar.setStatus(goToEditPost.getStatus());
                cVar.setMessage(goToEditPost.getMessage());
                cVar.setData(goToEditPost.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("system/checkAppInstall")) {
            cVar.yj(true);
            c checkAppInstall = this.mJsBridge.checkAppInstall(dPO.optString(PushClientConstants.TAG_PKG_NAME));
            if (checkAppInstall != null) {
                cVar.setStatus(checkAppInstall.getStatus());
                cVar.setMessage(checkAppInstall.getMessage());
                cVar.setData(checkAppInstall.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("system/disableSlideBack")) {
            cVar.yj(true);
            c disableBack = this.mJsBridge.disableBack(dPO.optInt("disable"));
            if (disableBack != null) {
                cVar.setStatus(disableBack.getStatus());
                cVar.setMessage(disableBack.getMessage());
                cVar.setData(disableBack.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("system/startApp")) {
            cVar.yj(true);
            c startApp = this.mJsBridge.startApp(dPO.optString(PushClientConstants.TAG_PKG_NAME), dPO.optString("schema"));
            if (startApp != null) {
                cVar.setStatus(startApp.getStatus());
                cVar.setMessage(startApp.getMessage());
                cVar.setData(startApp.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("system/hasNotificationPermission")) {
            cVar.yj(true);
            c hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
            if (hasNotificationPermission != null) {
                cVar.setStatus(hasNotificationPermission.getStatus());
                cVar.setMessage(hasNotificationPermission.getMessage());
                cVar.setData(hasNotificationPermission.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("system/goToNotificationSetting")) {
            cVar.yj(true);
            c goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
            if (goToNotificationSetting != null) {
                cVar.setStatus(goToNotificationSetting.getStatus());
                cVar.setMessage(goToNotificationSetting.getMessage());
                cVar.setData(goToNotificationSetting.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("account/startDownloadCss")) {
            cVar.yj(true);
            c startDownloadCss = this.mJsBridge.startDownloadCss(dPO.optString("downloadUrl"));
            if (startDownloadCss != null) {
                cVar.setStatus(startDownloadCss.getStatus());
                cVar.setMessage(startDownloadCss.getMessage());
                cVar.setData(startDownloadCss.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("navigationBar/isDisableGoBack")) {
            cVar.yj(true);
            c disableGoBack = this.mJsBridge.setDisableGoBack();
            if (disableGoBack != null) {
                cVar.setStatus(disableGoBack.getStatus());
                cVar.setMessage(disableGoBack.getMessage());
                cVar.setData(disableGoBack.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("device/getSupplementInfo")) {
            cVar.yj(true);
            c supplementInfo = this.mJsBridge.getSupplementInfo();
            if (supplementInfo != null) {
                cVar.setStatus(supplementInfo.getStatus());
                cVar.setMessage(supplementInfo.getMessage());
                cVar.setData(supplementInfo.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("device/getDeviceInfo")) {
            cVar.yj(true);
            c deviceInfo = this.mJsBridge.getDeviceInfo();
            if (deviceInfo != null) {
                cVar.setStatus(deviceInfo.getStatus());
                cVar.setMessage(deviceInfo.getMessage());
                cVar.setData(deviceInfo.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("activity/completeTask")) {
            cVar.yj(true);
            c sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(dPO.optString("activityId"), dPO.optString("missionId"));
            if (sendCompleteTaskReqMsg != null) {
                cVar.setStatus(sendCompleteTaskReqMsg.getStatus());
                cVar.setMessage(sendCompleteTaskReqMsg.getMessage());
                cVar.setData(sendCompleteTaskReqMsg.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("toast/showTipToast")) {
            cVar.yj(true);
            c showTipToast = this.mJsBridge.showTipToast(dPO.optString("content"), dPO.optString("linkUrl"), dPO.optString("key"), dPO.optInt("maxTimes"), dPO.optInt("finishThisPage"));
            if (showTipToast != null) {
                cVar.setStatus(showTipToast.getStatus());
                cVar.setMessage(showTipToast.getMessage());
                cVar.setData(showTipToast.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("router/jumpToHTMLPage")) {
            cVar.yj(true);
            c jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(dPO.optString("url"), dPO.optInt("finishThisPage"));
            if (jumpToHtmlPage != null) {
                cVar.setStatus(jumpToHtmlPage.getStatus());
                cVar.setMessage(jumpToHtmlPage.getMessage());
                cVar.setData(jumpToHtmlPage.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("router/goToHotTrend")) {
            cVar.yj(true);
            c jumpToHotTrendPage = this.mJsBridge.jumpToHotTrendPage();
            if (jumpToHotTrendPage != null) {
                cVar.setStatus(jumpToHotTrendPage.getStatus());
                cVar.setMessage(jumpToHotTrendPage.getMessage());
                cVar.setData(jumpToHotTrendPage.getData());
            }
            cVar.KZ(0);
        } else if (dPQ.equals("toast/showAlertView")) {
            cVar.yj(true);
            c showAlertView = this.mJsBridge.showAlertView(dPO.optString("title"), dPO.optString("sub_title"), dPO.optInt("btn_corner"), dPO.optInt("btn_borderWidth"), dPO.optString("cancel_btn_text"), dPO.optString("cancel_btn_color"), dPO.optString("cancel_btn_borderColor"), dPO.optString("confirm_btn_text"), dPO.optString("confirm_btn_color"), dPO.optString("confirm_btn_borderColor"), dPO.optString("confirm_btn_url"));
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
                cVar.Tr(next.getName());
                cVar.setStatus(dealClickGoBackToH5.getStatus());
                cVar.setMessage(dealClickGoBackToH5.getMessage());
                cVar.setData(dealClickGoBackToH5.getData());
                arrayList.add(cVar);
                if (!next.dPH()) {
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
