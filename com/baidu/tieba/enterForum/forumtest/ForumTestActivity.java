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
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.t.bf;
import com.baidu.tbadk.util.n;
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
    private NoNetworkView dlX;
    private g eRA;
    private ForumTestWebView eRy;
    private long eRz;
    private i eyp;
    private k eyq;
    private List<g> eyu;
    private NavigationBar mNavigationBar;
    private a mPermissionJudgement;
    private String mUrl = "https://tieba.baidu.com/mo/q/recomforum?testId=";
    private k.b eRB = new k.b() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ForumTestActivity.this.nD(ForumTestActivity.this.eRy.getHitTestResult().getExtra());
            ForumTestActivity.this.aXK();
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
        this.dlX = (NoNetworkView) findViewById(R.id.activity_forum_test_net);
        this.eRy = (ForumTestWebView) findViewById(R.id.activity_forum_test_web);
        this.eRy.a(this);
        initData();
        this.eRy.loadUrl(this.mUrl);
        this.eRy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return ForumTestActivity.this.handleLongClick();
            }
        });
        bdy();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.eRz = intent.getLongExtra(ForumTestActivityConfig.TEST_ID, 0L);
            this.mUrl += this.eRz;
        }
    }

    private void bdy() {
        if (this.eyp == null) {
            this.eyq = new k(this);
        }
        if (this.eyu == null) {
            this.eyu = new ArrayList();
        }
        this.eyp = new i(getPageContext(), this.eyq.afZ());
    }

    @Override // com.baidu.tieba.enterForum.forumtest.js.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if (TbConfig.TMP_SHARE_DIR_NAME.equals(str2)) {
                if (bf.iE()) {
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
                                com.baidu.adp.lib.util.a.aR(eVar.linkUrl);
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
                    this.eRz = new JSONObject(str3).optLong("testId");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(this.eRz)));
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
        this.eRy.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eRy.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eRy.canGoBack()) {
            this.eRy.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eRy != null) {
            this.eRy.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.eRy.clearHistory();
            ((ViewGroup) this.eRy.getParent()).removeView(this.eRy);
            this.eRy.destroy();
            this.eRy = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        WebView.HitTestResult hitTestResult;
        if (this.eRy == null || (hitTestResult = this.eRy.getHitTestResult()) == null || hitTestResult.getType() != 5) {
            return false;
        }
        bdz();
        show();
        return true;
    }

    private void bdz() {
        this.eyu.clear();
        this.eRA = new g(getString(R.string.save_this_image), this.eyq);
        this.eRA.a(this.eRB);
        this.eyu.add(this.eRA);
        this.eyq.a(new k.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.3
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ForumTestActivity.this.aXK();
            }
        });
        this.eyq.W(this.eyu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nD(String str) {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.aiM();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.aa(pageActivity)) {
            new n(getActivity(), str, new n.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.5
                @Override // com.baidu.tbadk.util.n.a
                public void onError(int i, String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.tb_webview_download_image_success_tip);
                }

                @Override // com.baidu.tbadk.util.n.a
                public void onSuccess(String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.save_success);
                }
            }).fG(true).execute(new String[0]);
        }
    }

    private void show() {
        if (this.eyp != null && !isFinishing()) {
            this.eyp.showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXK() {
        if (this.eyp != null && this.eyp.isShowing()) {
            this.eyp.dismiss();
        }
    }
}
