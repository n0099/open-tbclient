package com.baidu.tieba.enterForum.forumtest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.a;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.s.az;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.forumtest.js.ForumTestWebView;
import com.baidu.tieba.enterForum.forumtest.js.b;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ForumTestActivity extends BaseActivity implements b {
    private NoNetworkView dbr;
    private ForumTestWebView eBM;
    private long eBN;
    private NavigationBar mNavigationBar;
    private String mUrl = "https://tieba.baidu.com/mo/q/recomforum?testId=";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setSwipeBackEnabled(false);
        super.onCreate(bundle);
        setContentView(d.h.activity_forum_test_layout);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.activity_forum_test_nav);
        this.mNavigationBar.setVisibility(8);
        this.dbr = (NoNetworkView) findViewById(d.g.activity_forum_test_net);
        this.eBM = (ForumTestWebView) findViewById(d.g.activity_forum_test_web);
        this.eBM.a(this);
        initData();
        this.eBM.loadUrl(this.mUrl);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.eBN = intent.getLongExtra(ForumTestActivityConfig.TEST_ID, 0L);
            this.mUrl += this.eBN;
        }
    }

    @Override // com.baidu.tieba.enterForum.forumtest.js.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if (TbConfig.TMP_SHARE_DIR_NAME.equals(str2)) {
                if (az.jK()) {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString(SocialConstants.PARAM_IMG_URL);
                        String optString4 = jSONObject.optString("url");
                        final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                        dVar.title = optString;
                        dVar.content = optString2;
                        dVar.linkUrl = optString4;
                        dVar.imageUri = Uri.parse(optString3);
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this, dVar, true, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                a.bh(dVar.linkUrl);
                                l.showToast(ForumTestActivity.this, view.getResources().getString(d.j.copy_pb_url_success));
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
                    this.eBN = new JSONObject(str3).optLong("testId");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(this.eBN)));
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
        this.eBM.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eBM.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.eBM.canGoBack()) {
            this.eBM.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eBM != null) {
            this.eBM.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.eBM.clearHistory();
            ((ViewGroup) this.eBM.getParent()).removeView(this.eBM);
            this.eBM.destroy();
            this.eBM = null;
        }
        super.onDestroy();
    }
}
