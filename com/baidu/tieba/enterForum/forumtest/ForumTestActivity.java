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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.forumtest.js.ForumTestWebView;
import com.baidu.tieba.enterForum.forumtest.js.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ForumTestActivity extends BaseActivity implements b {
    private NoNetworkView ehd;
    private i fHQ;
    private k fHR;
    private List<g> fHV;
    private ForumTestWebView fRY;
    private long fRZ;
    private g fSa;
    private NavigationBar mNavigationBar;
    private a mPermissionJudgement;
    private String mUrl = "https://tieba.baidu.com/mo/q/recomforum?testId=";
    private k.b fSb = new k.b() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ForumTestActivity.this.saveImage(ForumTestActivity.this.fRY.getHitTestResult().getExtra());
            ForumTestActivity.this.btv();
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
        this.ehd = (NoNetworkView) findViewById(R.id.activity_forum_test_net);
        this.fRY = (ForumTestWebView) findViewById(R.id.activity_forum_test_web);
        this.fRY.a(this);
        initData();
        this.fRY.loadUrl(this.mUrl);
        this.fRY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return ForumTestActivity.this.handleLongClick();
            }
        });
        bww();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.fRZ = intent.getLongExtra(ForumTestActivityConfig.TEST_ID, 0L);
            this.mUrl += this.fRZ;
        }
    }

    private void bww() {
        if (this.fHQ == null) {
            this.fHR = new k(this);
        }
        if (this.fHV == null) {
            this.fHV = new ArrayList();
        }
        this.fHQ = new i(getPageContext(), this.fHR);
    }

    @Override // com.baidu.tieba.enterForum.forumtest.js.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if (TbConfig.TMP_SHARE_DIR_NAME.equals(str2)) {
                if (ShareSwitch.isOn()) {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString("img");
                        String optString4 = jSONObject.optString("url");
                        final ShareItem shareItem = new ShareItem();
                        shareItem.title = optString;
                        shareItem.content = optString2;
                        shareItem.linkUrl = optString4;
                        shareItem.imageUri = Uri.parse(optString3);
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this, shareItem, true, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                                l.showToast(ForumTestActivity.this, view.getResources().getString(R.string.copy_pb_url_success));
                            }
                        });
                        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
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
                    this.fRZ = new JSONObject(str3).optLong("testId");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(this.fRZ)));
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
        this.fRY.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.fRY.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.fRY.canGoBack()) {
            this.fRY.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fRY != null) {
            this.fRY.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.fRY.clearHistory();
            ((ViewGroup) this.fRY.getParent()).removeView(this.fRY);
            this.fRY.destroy();
            this.fRY = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        WebView.HitTestResult hitTestResult;
        if (this.fRY == null || (hitTestResult = this.fRY.getHitTestResult()) == null || hitTestResult.getType() != 5) {
            return false;
        }
        bwx();
        show();
        return true;
    }

    private void bwx() {
        this.fHV.clear();
        this.fSa = new g(getString(R.string.save_this_image), this.fHR);
        this.fSa.a(this.fSb);
        this.fHV.add(this.fSa);
        this.fHR.a(new k.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.3
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ForumTestActivity.this.btv();
            }
        });
        this.fHR.az(this.fHV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage(String str) {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            new o(getActivity(), str, new o.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.5
                @Override // com.baidu.tbadk.util.o.a
                public void onError(int i, String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.tb_webview_download_image_success_tip);
                }

                @Override // com.baidu.tbadk.util.o.a
                public void onSuccess(String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.save_success);
                }
            }).gT(true).execute(new String[0]);
        }
    }

    private void show() {
        if (this.fHQ != null && !isFinishing()) {
            this.fHQ.showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btv() {
        if (this.fHQ != null && this.fHQ.isShowing()) {
            this.fHQ.dismiss();
        }
    }
}
