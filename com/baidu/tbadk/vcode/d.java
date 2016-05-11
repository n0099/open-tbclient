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
    final /* synthetic */ CommonVcodeActivity aAJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonVcodeActivity commonVcodeActivity) {
        this.aAJ = commonVcodeActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean z;
        String gr;
        boolean gs;
        String gr2;
        String str2;
        boolean FG;
        String str3;
        String str4;
        String str5;
        Runnable runnable;
        if (!StringUtils.isNull(str)) {
            z = this.aAJ.aAG;
            if (!z) {
                this.aAJ.aAG = true;
                h dL = h.dL();
                runnable = this.aAJ.aAH;
                dL.postDelayed(runnable, 500L);
            }
            if (str.equals("objc:jumpToFeedback()")) {
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.aAJ.getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
                writeActivityConfig.setIsVcodeFeedBack();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                return true;
            } else if (str.contains("objc:jsChangeVcode")) {
                CommonVcodeActivity commonVcodeActivity = this.aAJ;
                gr2 = this.aAJ.gr(str);
                commonVcodeActivity.aAy = gr2;
                str2 = this.aAJ.aAy;
                if (str2 != null) {
                    FG = this.aAJ.FG();
                    if (FG) {
                        str3 = this.aAJ.aAC;
                        if (!StringUtils.isNull(str3)) {
                            CommonVcodeActivity commonVcodeActivity2 = this.aAJ;
                            str4 = this.aAJ.aAy;
                            str5 = this.aAJ.aAC;
                            commonVcodeActivity2.at(str4, str5);
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } else if (str.contains("objc:jsSubmit")) {
                CommonVcodeActivity commonVcodeActivity3 = this.aAJ;
                gr = this.aAJ.gr(str);
                gs = commonVcodeActivity3.gs(gr);
                return gs;
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
        this.aAJ.aAG = true;
        this.aAJ.FL();
        baseWebView = this.aAJ.mWebView;
        baseWebView.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }
}
