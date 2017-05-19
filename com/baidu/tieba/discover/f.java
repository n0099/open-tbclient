package com.baidu.tieba.discover;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.i.h;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f {
    private com.baidu.tbadk.i.f aSk;
    TbPageContext<BaseFragmentActivity> ajr;
    private h mRefreshView;
    private View mRootView;
    private String mUrl;
    private BaseWebView mWebView;
    private boolean yB;

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mRootView = layoutInflater.inflate(w.j.discover_fragment, (ViewGroup) null);
        this.mRootView.setDrawingCacheEnabled(false);
        return this.mRootView;
    }

    public void n(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.ajr = tbPageContext;
        this.mWebView = (BaseWebView) this.mRootView.findViewById(w.h.webview);
        View findViewById = this.mRootView.findViewById(w.h.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            findViewById.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.mWebView.setWebViewClient(new a(this, null));
    }

    public BaseWebView SX() {
        return this.mWebView;
    }

    public void loadUrl(String str) {
        this.mUrl = str;
        this.mWebView.loadUrl(str);
    }

    public void Vc() {
        if (this.yB) {
            this.mWebView.loadUrl("javascript:window.reload_page()");
        } else {
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    public void JP() {
        if (this.ajr != null && this.mRootView != null) {
            this.aSk = new com.baidu.tbadk.i.f(this.ajr.getPageActivity());
            this.aSk.c(this.mRootView, false);
            this.aSk.onChangeSkinType();
        }
    }

    public void JQ() {
        if (this.aSk != null) {
            this.aSk.H(this.mRootView);
            this.aSk = null;
        }
    }

    public void SY() {
        JR();
        this.mWebView.setVisibility(0);
    }

    public void Vd() {
        String string = TbadkCoreApplication.m9getInst().getString(w.l.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.ajr.getPageActivity(), new g(this));
            this.mRefreshView.onChangeSkinType();
        }
        this.mWebView.setVisibility(8);
        this.mRefreshView.fQ(string);
        this.mRefreshView.c(this.mRootView, false);
        this.mRefreshView.Ee();
        this.mRefreshView.eR(this.ajr.getResources().getDimensionPixelSize(w.f.ds280));
    }

    public void JR() {
        if (this.mRefreshView != null) {
            this.mRefreshView.H(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* loaded from: classes.dex */
    private class a extends WebViewClient {
        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            f.this.ih(str);
            if (str.contains("jump_webview_type=2")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (f.this.ii(str)) {
                return true;
            }
            bb.vB().c(f.this.ajr, new String[]{str});
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            f.this.JP();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            f.this.JQ();
            if (i.hk()) {
                f.this.SY();
                f.this.yB = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            f.this.Vd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(String str) {
        if (!StringUtils.isNull(str) && str.contains("squaresearch:")) {
            TiebaStatic.log(new as("c10378").s("obj_type", 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ii(String str) {
        return ij(str) || ik(str) || il(str) || im(str) || in(str) || io(str);
    }

    private boolean ij(String str) {
        if (str.contains("tieba://lego?")) {
            if (!(MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null)) {
                k.showToast(this.ajr.getPageActivity(), w.l.plugin_install_fail);
                return true;
            }
            bb.vB().c(this.ajr, new String[]{str});
            return true;
        }
        return false;
    }

    private boolean ik(String str) {
        if (str.contains("nohead:url") || str.contains("booktown")) {
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                k.showToast(this.ajr.getPageActivity(), w.l.plugin_install_fail);
            } else {
                bb.vB().c(this.ajr, new String[]{str});
            }
            return true;
        }
        return false;
    }

    private boolean il(String str) {
        if (str.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("http://tieba.baidu.com/mo/q/newhotmessage?") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage?topic_id=") || str.startsWith("https://tieba.baidu.com/mo/q/newhotmessage?")) {
            String ar = aa.ar(str, "topic_id=");
            String ar2 = aa.ar(str, "topic_name=");
            boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (StringUtils.isNull(ar) || StringUtils.isNull(ar2, true)) {
                return true;
            }
            if (appResponseToIntentClass) {
                this.ajr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.ajr.getPageActivity()).createNormalConfig(ar, ar2, null)));
                return true;
            }
            com.baidu.tbadk.browser.f.e(this.ajr.getPageActivity(), ar2, str);
            return true;
        } else if ((str.startsWith("http://tieba.baidu.com/mo/q/hotMessage/list") || str.startsWith("https://tieba.baidu.com/mo/q/hotMessage/list")) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class)) {
            new HotRanklistActivityConfig(this.ajr.getPageActivity()).createNormalConfig("discover", "all").start();
            return true;
        } else {
            return false;
        }
    }

    private boolean im(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("forumsquarelist")) {
            return false;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_SQUARE_FORUM_LIST) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new ForumListActivityConfig(this.ajr.getPageActivity(), aa.ar(str, "menuname="), aa.ar(str, "menutype="), aa.ar(str, "menuid="))));
            return true;
        }
        BdToast.a(this.ajr.getPageActivity(), this.ajr.getPageActivity().getString(w.l.discover_forum_square_tips), 0).tl();
        return true;
    }

    private boolean in(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("membercenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
            k.showToast(this.ajr.getPageActivity(), w.l.plugin_install_fail);
            return true;
        }
        bb.vB().c(this.ajr, new String[]{str});
        return true;
    }

    private boolean io(String str) {
        if (StringUtils.isNull(str) || !str.startsWith("dressupcenter:")) {
            return false;
        }
        if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
            k.showToast(this.ajr.getPageActivity(), w.l.plugin_install_fail);
            return true;
        }
        bb.vB().c(this.ajr, new String[]{str});
        return true;
    }
}
