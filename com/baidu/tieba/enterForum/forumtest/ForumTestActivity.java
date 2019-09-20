package com.baidu.tieba.enterForum.forumtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.c.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.t.bf;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.forumtest.js.ForumTestWebView;
import com.baidu.tieba.enterForum.forumtest.js.b;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ForumTestActivity extends BaseActivity implements b {
    private NoNetworkView dpy;
    private i eFc;
    private k eFd;
    private List<g> eFh;
    private ForumTestWebView eYo;
    private long eYp;
    private g eYq;
    private NavigationBar mNavigationBar;
    private a mPermissionJudgement;
    private String mUrl = "https://tieba.baidu.com/mo/q/recomforum?testId=";
    private k.b eYr = new k.b() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ForumTestActivity.this.nR(ForumTestActivity.this.eYo.getHitTestResult().getExtra());
            ForumTestActivity.this.bao();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setSwipeBackEnabled(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_forum_test_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_forum_test_nav);
        this.mNavigationBar.setVisibility(8);
        this.dpy = (NoNetworkView) findViewById(R.id.activity_forum_test_net);
        this.eYo = (ForumTestWebView) findViewById(R.id.activity_forum_test_web);
        this.eYo.a(this);
        initData();
        this.eYo.loadUrl(this.mUrl);
        this.eYo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return ForumTestActivity.this.handleLongClick();
            }
        });
        bgg();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.eYp = intent.getLongExtra(ForumTestActivityConfig.TEST_ID, 0L);
            this.mUrl += this.eYp;
        }
    }

    private void bgg() {
        if (this.eFc == null) {
            this.eFd = new k(this);
        }
        if (this.eFh == null) {
            this.eFh = new ArrayList();
        }
        this.eFc = new i(getPageContext(), this.eFd);
    }

    @Override // com.baidu.tieba.enterForum.forumtest.js.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if (TbConfig.TMP_SHARE_DIR_NAME.equals(str2)) {
                if (bf.iN()) {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString(SocialConstants.PARAM_IMG_URL);
                        String optString4 = jSONObject.optString("url");
                        final e eVar = new e();
                        eVar.title = optString;
                        eVar.content = optString2;
                        eVar.linkUrl = optString4;
                        eVar.imageUri = Uri.parse(optString3);
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this, eVar, true, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.aS(eVar.linkUrl);
                                l.showToast(ForumTestActivity.this, view.getResources().getString(R.string.copy_pb_url_success));
                            }
                        });
                        sendMessage(new CustomMessage(2001276, shareDialogConfig));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                jsPromptResult.confirm(TbConfig.TMP_SHARE_DIR_NAME);
            } else if ("finishThisPage".equals(str2)) {
                finish();
                jsPromptResult.confirm("finishThisPage");
                return true;
            } else if ("finishTestAnswer".equals(str2)) {
                try {
                    this.eYp = new JSONObject(str3).optLong("testId");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(this.eYp)));
                finish();
                jsPromptResult.confirm("finishTestAnswer");
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eYo.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eYo.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eYo.canGoBack()) {
            this.eYo.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eYo != null) {
            this.eYo.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.eYo.clearHistory();
            ((ViewGroup) this.eYo.getParent()).removeView(this.eYo);
            this.eYo.destroy();
            this.eYo = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        WebView.HitTestResult hitTestResult;
        if (this.eYo == null || (hitTestResult = this.eYo.getHitTestResult()) == null || hitTestResult.getType() != 5) {
            return false;
        }
        bgh();
        show();
        return true;
    }

    private void bgh() {
        this.eFh.clear();
        this.eYq = new g(getString(R.string.save_this_image), this.eFd);
        this.eYq.a(this.eYr);
        this.eFh.add(this.eYq);
        this.eFd.a(new k.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.3
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ForumTestActivity.this.bao();
            }
        });
        this.eFd.W(this.eFh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nR(String str) {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.ake();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.ad(pageActivity)) {
            new m(getActivity(), str, new m.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.5
                @Override // com.baidu.tbadk.util.m.a
                public void onError(int i, String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.tb_webview_download_image_success_tip);
                }

                @Override // com.baidu.tbadk.util.m.a
                public void onSuccess(String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.save_success);
                }
            }).fN(true).execute(new String[0]);
        }
    }

    private void show() {
        if (this.eFc != null && !isFinishing()) {
            this.eFc.showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bao() {
        if (this.eFc != null && this.eFc.isShowing()) {
            this.eFc.dismiss();
        }
    }
}
