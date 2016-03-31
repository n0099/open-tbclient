package com.baidu.tbadk.vcode;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.h.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends WebViewClient {
    final /* synthetic */ CommonVcodeActivity aEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonVcodeActivity commonVcodeActivity) {
        this.aEz = commonVcodeActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean z;
        String gq;
        boolean gr;
        String gq2;
        String str2;
        boolean HE;
        String str3;
        String str4;
        String str5;
        Runnable runnable;
        if (!StringUtils.isNull(str)) {
            z = this.aEz.aEw;
            if (!z) {
                this.aEz.aEw = true;
                h hx = h.hx();
                runnable = this.aEz.aEx;
                hx.postDelayed(runnable, 500L);
            }
            if (str.equals("objc:jumpToFeedback()")) {
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.aEz.getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
                writeActivityConfig.setIsVcodeFeedBack();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                return true;
            } else if (str.contains("objc:jsChangeVcode")) {
                CommonVcodeActivity commonVcodeActivity = this.aEz;
                gq2 = this.aEz.gq(str);
                commonVcodeActivity.aEo = gq2;
                str2 = this.aEz.aEo;
                if (str2 != null) {
                    HE = this.aEz.HE();
                    if (HE) {
                        str3 = this.aEz.aEs;
                        if (!StringUtils.isNull(str3)) {
                            CommonVcodeActivity commonVcodeActivity2 = this.aEz;
                            str4 = this.aEz.aEo;
                            str5 = this.aEz.aEs;
                            commonVcodeActivity2.as(str4, str5);
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } else if (str.contains("objc:jsSubmit")) {
                CommonVcodeActivity commonVcodeActivity3 = this.aEz;
                gq = this.aEz.gq(str);
                gr = commonVcodeActivity3.gr(gq);
                return gr;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        BaseWebView baseWebView;
        super.onPageFinished(webView, str);
        this.aEz.aEw = true;
        this.aEz.HJ();
        baseWebView = this.aEz.mWebView;
        baseWebView.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }
}
