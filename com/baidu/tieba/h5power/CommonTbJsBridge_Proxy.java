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
        String dOr = eVar.dOr();
        JSONObject dOp = eVar.dOp();
        if (dOr.equals("account/startLoginModule")) {
            cVar.yy(true);
            c startLoginModule = this.mJsBridge.startLoginModule(dOp.optString("cssUrl"));
            if (startLoginModule != null) {
                cVar.setStatus(startLoginModule.getStatus());
                cVar.setMessage(startLoginModule.getMessage());
                cVar.setData(startLoginModule.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("router/finishThisPage")) {
            cVar.yy(true);
            c finishPage = this.mJsBridge.finishPage();
            if (finishPage != null) {
                cVar.setStatus(finishPage.getStatus());
                cVar.setMessage(finishPage.getMessage());
                cVar.setData(finishPage.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("toast/toastPopupView")) {
            cVar.yy(true);
            c showLowerHairHint = this.mJsBridge.showLowerHairHint(dOp.optInt("showType"), dOp.optInt("aheadType"), dOp.optString("message"), dOp.optString("btnText"), dOp.optInt("toastDuration"), dOp.optString("schema"), dOp.optString("token"), dOp.optDouble("opacity"), dOp.optString("imgUrl"), dOp.optString("url"), dOp.optInt("missionId"), dOp.optString("btnColor"), dOp.optString("messageColor"), dOp.optString("btnTextColor"), dOp.optInt("status"), dOp.optInt("finishThisPage"));
            if (showLowerHairHint != null) {
                cVar.setStatus(showLowerHairHint.getStatus());
                cVar.setMessage(showLowerHairHint.getMessage());
                cVar.setData(showLowerHairHint.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("router/goToBarDetail")) {
            cVar.yy(true);
            c handleGoToBarDetail = this.mJsBridge.handleGoToBarDetail(dOp.optString(TbTitleActivityConfig.FORUM_ID));
            if (handleGoToBarDetail != null) {
                cVar.setStatus(handleGoToBarDetail.getStatus());
                cVar.setMessage(handleGoToBarDetail.getMessage());
                cVar.setData(handleGoToBarDetail.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("system/saveImage")) {
            cVar.yy(true);
            c handleSaveImage = this.mJsBridge.handleSaveImage(dOp.optString("imgUrl"));
            this.mNotificationNameList.add("saveImageSuccess");
            if (handleSaveImage != null) {
                cVar.setStatus(handleSaveImage.getStatus());
                cVar.setMessage(handleSaveImage.getMessage());
                cVar.setData(handleSaveImage.getData());
                if (!cVar.isError()) {
                    cVar.yA(false);
                    addObserver("saveImageSuccess", cVar, false);
                }
            }
            cVar.JM(0);
        } else if (dOr.equals("system/playSound")) {
            cVar.yy(true);
            c playSound = this.mJsBridge.playSound(dOp.optString("soundUrl"));
            if (playSound != null) {
                cVar.setStatus(playSound.getStatus());
                cVar.setMessage(playSound.getMessage());
                cVar.setData(playSound.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("system/playVibrate")) {
            cVar.yy(true);
            c playVibrate = this.mJsBridge.playVibrate();
            if (playVibrate != null) {
                cVar.setStatus(playVibrate.getStatus());
                cVar.setMessage(playVibrate.getMessage());
                cVar.setData(playVibrate.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("account/loadThirdPartyLogin")) {
            cVar.yy(true);
            c jumpLoginActivity = this.mJsBridge.jumpLoginActivity(dOp.optInt("socialType"), dOp.optString("activityId"));
            if (jumpLoginActivity != null) {
                cVar.setStatus(jumpLoginActivity.getStatus());
                cVar.setMessage(jumpLoginActivity.getMessage());
                cVar.setData(jumpLoginActivity.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("system/startLoadTimeInterval")) {
            cVar.yy(true);
            c startLoadTimeInterval = this.mJsBridge.getStartLoadTimeInterval();
            if (startLoadTimeInterval != null) {
                cVar.setStatus(startLoadTimeInterval.getStatus());
                cVar.setMessage(startLoadTimeInterval.getMessage());
                cVar.setData(startLoadTimeInterval.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("device/getZid")) {
            cVar.yy(true);
            c zid = this.mJsBridge.getZid();
            if (zid != null) {
                cVar.setStatus(zid.getStatus());
                cVar.setMessage(zid.getMessage());
                cVar.setData(zid.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("share/registerShareDataNew")) {
            cVar.yy(true);
            c shareInfo = this.mJsBridge.setShareInfo(dOp.optString("title"), dOp.optString("desc"), dOp.optString("img"), dOp.optString("url"), dOp.optString(AlbumActivityConfig.FROM_TOPIC), dOp.optString("wbtitle"), dOp.optString("wbcontent"), dOp.optString("isShowMoreForum"), dOp.optInt("shareimg"), dOp.optString("extdata"));
            if (shareInfo != null) {
                cVar.setStatus(shareInfo.getStatus());
                cVar.setMessage(shareInfo.getMessage());
                cVar.setData(shareInfo.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("share/share")) {
            cVar.yy(true);
            c share = this.mJsBridge.share(dOp.optInt("channel"), dOp.optInt("shareImg"), dOp.optString("img"), dOp.optString("isShowMoreForum"), dOp.optString("url"), dOp.optString("title"), dOp.optString("desc"), dOp.optString(AlbumActivityConfig.FROM_TOPIC), dOp.optString("wbtitle"), dOp.optString("wbcontent"), dOp.optInt("weixinDisable"), dOp.optString(CashierData.EXT_DATA));
            if (share != null) {
                cVar.setStatus(share.getStatus());
                cVar.setMessage(share.getMessage());
                cVar.setData(share.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("clipper/getClipperInformation")) {
            cVar.yy(true);
            c clipperInformation = this.mJsBridge.getClipperInformation();
            if (clipperInformation != null) {
                cVar.setStatus(clipperInformation.getStatus());
                cVar.setMessage(clipperInformation.getMessage());
                cVar.setData(clipperInformation.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("clipper/setClipperInformation")) {
            cVar.yy(true);
            c clipperInformation2 = this.mJsBridge.setClipperInformation(dOp.optString(DocumentOpenUtil.TXT));
            if (clipperInformation2 != null) {
                cVar.setStatus(clipperInformation2.getStatus());
                cVar.setMessage(clipperInformation2.getMessage());
                cVar.setData(clipperInformation2.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("router/goToEditPost")) {
            cVar.yy(true);
            c goToEditPost = this.mJsBridge.goToEditPost(dOp.optString("pos"), dOp.optString("tid"), dOp.optString("floorId"), dOp.optString("postId"), dOp.optString("content"), dOp.optString("fid"), dOp.optString("fname"));
            if (goToEditPost != null) {
                cVar.setStatus(goToEditPost.getStatus());
                cVar.setMessage(goToEditPost.getMessage());
                cVar.setData(goToEditPost.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("system/checkAppInstall")) {
            cVar.yy(true);
            c checkAppInstall = this.mJsBridge.checkAppInstall(dOp.optString(PushClientConstants.TAG_PKG_NAME));
            if (checkAppInstall != null) {
                cVar.setStatus(checkAppInstall.getStatus());
                cVar.setMessage(checkAppInstall.getMessage());
                cVar.setData(checkAppInstall.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("system/disableSlideBack")) {
            cVar.yy(true);
            c disableBack = this.mJsBridge.disableBack(dOp.optInt("disable"));
            if (disableBack != null) {
                cVar.setStatus(disableBack.getStatus());
                cVar.setMessage(disableBack.getMessage());
                cVar.setData(disableBack.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("system/startApp")) {
            cVar.yy(true);
            c startApp = this.mJsBridge.startApp(dOp.optString(PushClientConstants.TAG_PKG_NAME), dOp.optString("schema"));
            if (startApp != null) {
                cVar.setStatus(startApp.getStatus());
                cVar.setMessage(startApp.getMessage());
                cVar.setData(startApp.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("system/hasNotificationPermission")) {
            cVar.yy(true);
            c hasNotificationPermission = this.mJsBridge.hasNotificationPermission();
            if (hasNotificationPermission != null) {
                cVar.setStatus(hasNotificationPermission.getStatus());
                cVar.setMessage(hasNotificationPermission.getMessage());
                cVar.setData(hasNotificationPermission.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("system/goToNotificationSetting")) {
            cVar.yy(true);
            c goToNotificationSetting = this.mJsBridge.goToNotificationSetting();
            if (goToNotificationSetting != null) {
                cVar.setStatus(goToNotificationSetting.getStatus());
                cVar.setMessage(goToNotificationSetting.getMessage());
                cVar.setData(goToNotificationSetting.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("account/startDownloadCss")) {
            cVar.yy(true);
            c startDownloadCss = this.mJsBridge.startDownloadCss(dOp.optString("downloadUrl"));
            if (startDownloadCss != null) {
                cVar.setStatus(startDownloadCss.getStatus());
                cVar.setMessage(startDownloadCss.getMessage());
                cVar.setData(startDownloadCss.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("navigationBar/isDisableGoBack")) {
            cVar.yy(true);
            c disableGoBack = this.mJsBridge.setDisableGoBack();
            if (disableGoBack != null) {
                cVar.setStatus(disableGoBack.getStatus());
                cVar.setMessage(disableGoBack.getMessage());
                cVar.setData(disableGoBack.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("device/getSupplementInfo")) {
            cVar.yy(true);
            c supplementInfo = this.mJsBridge.getSupplementInfo();
            if (supplementInfo != null) {
                cVar.setStatus(supplementInfo.getStatus());
                cVar.setMessage(supplementInfo.getMessage());
                cVar.setData(supplementInfo.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("device/getDeviceInfo")) {
            cVar.yy(true);
            c deviceInfo = this.mJsBridge.getDeviceInfo();
            if (deviceInfo != null) {
                cVar.setStatus(deviceInfo.getStatus());
                cVar.setMessage(deviceInfo.getMessage());
                cVar.setData(deviceInfo.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("activity/completeTask")) {
            cVar.yy(true);
            c sendCompleteTaskReqMsg = this.mJsBridge.sendCompleteTaskReqMsg(dOp.optString("activityId"), dOp.optString("missionId"));
            if (sendCompleteTaskReqMsg != null) {
                cVar.setStatus(sendCompleteTaskReqMsg.getStatus());
                cVar.setMessage(sendCompleteTaskReqMsg.getMessage());
                cVar.setData(sendCompleteTaskReqMsg.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("toast/showTipToast")) {
            cVar.yy(true);
            c showTipToast = this.mJsBridge.showTipToast(dOp.optString("content"), dOp.optString("linkUrl"), dOp.optString("key"), dOp.optInt("maxTimes"), dOp.optInt("finishThisPage"));
            if (showTipToast != null) {
                cVar.setStatus(showTipToast.getStatus());
                cVar.setMessage(showTipToast.getMessage());
                cVar.setData(showTipToast.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("router/jumpToHTMLPage")) {
            cVar.yy(true);
            c jumpToHtmlPage = this.mJsBridge.jumpToHtmlPage(dOp.optString("url"), dOp.optInt("finishThisPage"));
            if (jumpToHtmlPage != null) {
                cVar.setStatus(jumpToHtmlPage.getStatus());
                cVar.setMessage(jumpToHtmlPage.getMessage());
                cVar.setData(jumpToHtmlPage.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("router/goToHotTrend")) {
            cVar.yy(true);
            c jumpToHotTrendPage = this.mJsBridge.jumpToHotTrendPage();
            if (jumpToHotTrendPage != null) {
                cVar.setStatus(jumpToHotTrendPage.getStatus());
                cVar.setMessage(jumpToHotTrendPage.getMessage());
                cVar.setData(jumpToHotTrendPage.getData());
            }
            cVar.JM(0);
        } else if (dOr.equals("toast/showAlertView")) {
            cVar.yy(true);
            c showAlertView = this.mJsBridge.showAlertView(dOp.optString("title"), dOp.optString("sub_title"), dOp.optInt("btn_corner"), dOp.optInt("btn_borderWidth"), dOp.optString("cancel_btn_text"), dOp.optString("cancel_btn_color"), dOp.optString("cancel_btn_borderColor"), dOp.optString("confirm_btn_text"), dOp.optString("confirm_btn_color"), dOp.optString("confirm_btn_borderColor"), dOp.optString("confirm_btn_url"));
            if (showAlertView != null) {
                cVar.setStatus(showAlertView.getStatus());
                cVar.setMessage(showAlertView.getMessage());
                cVar.setData(showAlertView.getData());
            }
            cVar.JM(0);
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
            dealClickGoBackToH5.JM(0);
        }
        List<b> list = this.mAsyncCallBackMethodList.get(str);
        if (dealClickGoBackToH5 != null && list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                b next = it.next();
                c cVar = new c();
                cVar.Tt(next.getName());
                cVar.setStatus(dealClickGoBackToH5.getStatus());
                cVar.setMessage(dealClickGoBackToH5.getMessage());
                cVar.setData(dealClickGoBackToH5.getData());
                arrayList.add(cVar);
                if (!next.dOi()) {
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
