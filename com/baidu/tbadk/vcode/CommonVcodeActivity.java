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
    private View aAs = null;
    private View aAt = null;
    private TextView aAu = null;
    private com.baidu.tbadk.core.view.b aAv = null;
    private h aAw = null;
    private h aAx = null;
    private String aAy = null;
    private String aAz = null;
    private boolean aAA = true;
    private String aAB = null;
    private String aAC = null;
    private String aAD = null;
    private String mForumId = null;
    private String mThreadId = null;
    private String aAE = null;
    private String aAF = null;
    private boolean aAG = false;
    private Runnable aAH = new a(this);
    private final q aAI = new b(this);

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
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aAH);
        FH();
        if (this.aAx != null) {
            this.aAx.uS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        FH();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (FG()) {
            bundle.putString("from_page", this.aAB);
            bundle.putString(CommonVcodeActivityConfig.VCODE_PIC_URL, this.aAC);
            bundle.putString(CommonVcodeActivityConfig.VCODE_MD5, this.aAD);
            bundle.putString("forum_id", this.mForumId);
            bundle.putString("thread_id", this.mThreadId);
            bundle.putString(CommonVcodeActivityConfig.VCODE_MD5, this.aAD);
            bundle.putString(CommonVcodeActivityConfig.PIC_ID, this.aAE);
            bundle.putInt(CommonVcodeActivityConfig.WIDTH, this.mWidth);
            bundle.putInt(CommonVcodeActivityConfig.HEIGHT, this.mHeight);
            bundle.putString(CommonVcodeActivityConfig.CHECK_STR, this.aAF);
        }
        bundle.putBoolean("need_feed_back_button", this.aAA);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nq();
        initData(bundle);
        if (nt()) {
            FI();
        } else {
            finish();
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aAB = bundle.getString("from_page");
            if (FG()) {
                this.aAC = bundle.getString(CommonVcodeActivityConfig.VCODE_PIC_URL);
                this.aAD = bundle.getString(CommonVcodeActivityConfig.VCODE_MD5);
                this.mForumId = bundle.getString("forum_id");
                this.mThreadId = bundle.getString("thread_id");
                this.aAE = bundle.getString(CommonVcodeActivityConfig.PIC_ID);
                this.mWidth = bundle.getInt(CommonVcodeActivityConfig.WIDTH);
                this.mHeight = bundle.getInt(CommonVcodeActivityConfig.HEIGHT);
                this.aAF = bundle.getString(CommonVcodeActivityConfig.CHECK_STR);
            }
            this.aAA = bundle.getBoolean("need_feed_back_button");
            return;
        }
        Intent intent = getIntent();
        this.aAB = intent.getStringExtra("from_page");
        if (FG()) {
            this.aAC = intent.getStringExtra(CommonVcodeActivityConfig.VCODE_PIC_URL);
            this.aAD = intent.getStringExtra(CommonVcodeActivityConfig.VCODE_MD5);
            this.mForumId = intent.getStringExtra("forum_id");
            this.mThreadId = intent.getStringExtra("thread_id");
            this.aAE = intent.getStringExtra(CommonVcodeActivityConfig.PIC_ID);
            this.mWidth = intent.getIntExtra(CommonVcodeActivityConfig.WIDTH, 0);
            this.mHeight = intent.getIntExtra(CommonVcodeActivityConfig.HEIGHT, 0);
            this.aAF = intent.getStringExtra(CommonVcodeActivityConfig.CHECK_STR);
        }
        this.aAA = intent.getBooleanExtra("need_feed_back_button", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FG() {
        return !StringUtils.isNull(this.aAB) && this.aAB.equals(CommonVcodeActivityConfig.FROM_GRAFFITI_TAB);
    }

    @JavascriptInterface
    private boolean nt() {
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
                TbadkCoreApplication.m11getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m11getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    private void FH() {
        if (this.mWebView != null) {
            FL();
            this.mWebView.stopLoading();
        }
    }

    private void FI() {
        if (this.mWebView != null) {
            FK();
            String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
            if (this.aAA) {
                str = String.valueOf(str) + "?feedback=1";
            }
            this.mWebView.loadUrl(str);
        }
    }

    private void nq() {
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        setContentView(t.h.new_vcode_activity);
        this.aAs = findViewById(t.g.new_vcode_black_layout);
        this.aAs.setOnClickListener(new e(this));
        this.aAt = findViewById(t.g.post_thread_loading_view);
        this.aAu = (TextView) this.aAt.findViewById(t.g.custom_loading_text);
        this.aAu.setText(getResources().getString(t.j.sending));
        this.aAw = new h();
        this.aAx = new h();
        this.aAw.aaO = 1000L;
        this.aAx.aaO = 1000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2) {
        if (this.mWebView != null) {
            this.mWebView.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gr(String str) {
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
    public boolean gs(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.aAz = split[0];
        String str2 = split[1];
        if (FG()) {
            gt(str2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        if (FG()) {
            at(this.aAz, this.aAC);
        }
    }

    private void gt(String str) {
        if (!k.fH()) {
            showToast(t.j.neterror);
            finish();
            return;
        }
        com.baidu.tieba.graffiti.a aVar = new com.baidu.tieba.graffiti.a(this);
        aVar.a(this.aAI);
        aVar.a(this.mThreadId, this.mForumId, this.aAE, this.mWidth, this.mHeight, this.aAF, str, this.aAD);
        this.aAt.setVisibility(0);
    }

    private void FK() {
        if (this.aAv == null) {
            this.aAv = new com.baidu.tbadk.core.view.b(getPageContext());
            this.aAv.c(new f(this));
        }
        this.aAv.aD(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL() {
        if (this.aAv != null) {
            this.aAv.aD(false);
        }
    }
}
