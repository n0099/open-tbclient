package com.baidu.tbadk.vcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.graffiti.q;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class CommonVcodeActivity extends BaseActivity<CommonVcodeActivity> {
    private int mHeight;
    private int mWidth;
    private BaseWebView mWebView = null;
    private View aEi = null;
    private View aEj = null;
    private TextView aEk = null;
    private com.baidu.tbadk.core.view.b aEl = null;
    private h aEm = null;
    private h aEn = null;
    private String aEo = null;
    private String aEp = null;
    private boolean aEq = true;
    private String aEr = null;
    private String aEs = null;
    private String aEt = null;
    private String mForumId = null;
    private String mThreadId = null;
    private String aEu = null;
    private String aEv = null;
    private boolean aEw = false;
    private Runnable aEx = new a(this);
    private final q aEy = new b(this);

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.aEx);
        HF();
        if (this.aEn != null) {
            this.aEn.xj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        HF();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (HE()) {
            bundle.putString("from_page", this.aEr);
            bundle.putString(CommonVcodeActivityConfig.VCODE_PIC_URL, this.aEs);
            bundle.putString(CommonVcodeActivityConfig.VCODE_MD5, this.aEt);
            bundle.putString("forum_id", this.mForumId);
            bundle.putString("thread_id", this.mThreadId);
            bundle.putString(CommonVcodeActivityConfig.VCODE_MD5, this.aEt);
            bundle.putString(CommonVcodeActivityConfig.PIC_ID, this.aEu);
            bundle.putInt(CommonVcodeActivityConfig.WIDTH, this.mWidth);
            bundle.putInt(CommonVcodeActivityConfig.HEIGHT, this.mHeight);
            bundle.putString(CommonVcodeActivityConfig.CHECK_STR, this.aEv);
        }
        bundle.putBoolean("need_feed_back_button", this.aEq);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pU();
        initData(bundle);
        if (pX()) {
            HG();
        } else {
            finish();
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aEr = bundle.getString("from_page");
            if (HE()) {
                this.aEs = bundle.getString(CommonVcodeActivityConfig.VCODE_PIC_URL);
                this.aEt = bundle.getString(CommonVcodeActivityConfig.VCODE_MD5);
                this.mForumId = bundle.getString("forum_id");
                this.mThreadId = bundle.getString("thread_id");
                this.aEu = bundle.getString(CommonVcodeActivityConfig.PIC_ID);
                this.mWidth = bundle.getInt(CommonVcodeActivityConfig.WIDTH);
                this.mHeight = bundle.getInt(CommonVcodeActivityConfig.HEIGHT);
                this.aEv = bundle.getString(CommonVcodeActivityConfig.CHECK_STR);
            }
            this.aEq = bundle.getBoolean("need_feed_back_button");
            return;
        }
        Intent intent = getIntent();
        this.aEr = intent.getStringExtra("from_page");
        if (HE()) {
            this.aEs = intent.getStringExtra(CommonVcodeActivityConfig.VCODE_PIC_URL);
            this.aEt = intent.getStringExtra(CommonVcodeActivityConfig.VCODE_MD5);
            this.mForumId = intent.getStringExtra("forum_id");
            this.mThreadId = intent.getStringExtra("thread_id");
            this.aEu = intent.getStringExtra(CommonVcodeActivityConfig.PIC_ID);
            this.mWidth = intent.getIntExtra(CommonVcodeActivityConfig.WIDTH, 0);
            this.mHeight = intent.getIntExtra(CommonVcodeActivityConfig.HEIGHT, 0);
            this.aEv = intent.getStringExtra(CommonVcodeActivityConfig.CHECK_STR);
        }
        this.aEq = intent.getBooleanExtra("need_feed_back_button", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HE() {
        return !StringUtils.isNull(this.aEr) && this.aEr.equals(CommonVcodeActivityConfig.FROM_GRAFFITI_TAB);
    }

    @JavascriptInterface
    private boolean pX() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(t.g.new_vcode_webview);
                UtilHelper.setSupportHeight(getPageContext().getPageActivity(), this.mWebView, 1.2631578f);
                this.mWebView.setBackgroundColor(getResources().getColor(17170443));
                this.mWebView.setOnTouchListener(new c(this));
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.setWebViewClient(new d(this));
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TbadkCoreApplication.m411getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    private void HF() {
        if (this.mWebView != null) {
            HJ();
            this.mWebView.stopLoading();
        }
    }

    private void HG() {
        if (this.mWebView != null) {
            HI();
            String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
            if (this.aEq) {
                str = String.valueOf(str) + "?feedback=1";
            }
            this.mWebView.loadUrl(str);
        }
    }

    private void pU() {
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        setContentView(t.h.new_vcode_activity);
        this.aEi = findViewById(t.g.new_vcode_black_layout);
        this.aEi.setOnClickListener(new e(this));
        this.aEj = findViewById(t.g.post_thread_loading_view);
        this.aEk = (TextView) this.aEj.findViewById(t.g.custom_loading_text);
        this.aEk.setText(getResources().getString(t.j.sending));
        this.aEm = new h();
        this.aEn = new h();
        this.aEm.afp = 1000L;
        this.aEn.afp = 1000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(String str, String str2) {
        if (this.mWebView != null) {
            this.mWebView.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gq(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        int indexOf = str.indexOf("(");
        int indexOf2 = str.indexOf(")");
        if (indexOf == -1 || indexOf2 == -1 || indexOf + 1 >= indexOf2) {
            return null;
        }
        return str.substring(indexOf + 1, indexOf2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gr(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.aEp = split[0];
        String str2 = split[1];
        if (HE()) {
            gs(str2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HH() {
        if (HE()) {
            as(this.aEp, this.aEs);
        }
    }

    private void gs(String str) {
        if (!k.jw()) {
            showToast(t.j.neterror);
            finish();
            return;
        }
        com.baidu.tieba.graffiti.a aVar = new com.baidu.tieba.graffiti.a(this);
        aVar.a(this.aEy);
        aVar.a(this.mThreadId, this.mForumId, this.aEu, this.mWidth, this.mHeight, this.aEv, str, this.aEt);
        this.aEj.setVisibility(0);
    }

    private void HI() {
        if (this.aEl == null) {
            this.aEl = new com.baidu.tbadk.core.view.b(getPageContext());
            this.aEl.c(new f(this));
        }
        this.aEl.ay(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HJ() {
        if (this.aEl != null) {
            this.aEl.ay(false);
        }
    }
}
