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
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.a;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
/* loaded from: classes2.dex */
public class ForumTestActivity extends BaseActivity implements b {
    private NoNetworkView gCe;
    private ForumTestWebView iGT;
    private long iGU;
    private g iGV;
    private i iwA;
    private k iwB;
    private List<g> iwF;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mStatusBarView;
    private String mUrl = "https://tieba.baidu.com/mo/q/recomforum?testId=";
    private k.b iGW = new k.b() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ForumTestActivity.this.saveImage(ForumTestActivity.this.iGT.getHitTestResult().getExtra());
            ForumTestActivity.this.cuV();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setSwipeBackEnabled(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_forum_test_layout);
        this.gCe = (NoNetworkView) findViewById(R.id.activity_forum_test_net);
        this.mStatusBarView = findViewById(R.id.status_bar_view);
        this.iGT = (ForumTestWebView) findViewById(R.id.activity_forum_test_web);
        this.iGT.a(this);
        cya();
        initData();
        this.iGT.loadUrl(this.mUrl);
        this.iGT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return ForumTestActivity.this.handleLongClick();
            }
        });
        cxZ();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.iGU = intent.getLongExtra(ForumTestActivityConfig.TEST_ID, 0L);
            this.mUrl += this.iGU;
        }
    }

    private void cxZ() {
        if (this.iwA == null) {
            this.iwB = new k(this);
        }
        if (this.iwF == null) {
            this.iwF = new ArrayList();
        }
        this.iwA = new i(getPageContext(), this.iwB);
    }

    private void cya() {
        ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        this.mStatusBarView.setLayoutParams(layoutParams);
        if (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iGT.getLayoutParams();
            layoutParams2.addRule(3, R.id.status_bar_view);
            this.iGT.setLayoutParams(layoutParams2);
        }
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
                                a.copyToClipboard(shareItem.linkUrl);
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
                    this.iGU = new JSONObject(str3).optLong("testId");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(this.iGU)));
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
        this.iGT.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.iGT.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.iGT.canGoBack()) {
            this.iGT.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iGT != null) {
            this.iGT.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.iGT.clearHistory();
            ((ViewGroup) this.iGT.getParent()).removeView(this.iGT);
            this.iGT.destroy();
            this.iGT = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        WebView.HitTestResult hitTestResult;
        if (this.iGT == null || (hitTestResult = this.iGT.getHitTestResult()) == null || hitTestResult.getType() != 5) {
            return false;
        }
        cyb();
        show();
        return true;
    }

    private void cyb() {
        this.iwF.clear();
        this.iGV = new g(getString(R.string.save_this_image), this.iwB);
        this.iGV.a(this.iGW);
        this.iwF.add(this.iGV);
        this.iwB.a(new k.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.3
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ForumTestActivity.this.cuV();
            }
        });
        this.iwB.bB(this.iwF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage(String str) {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            new o(getActivity(), str, new o.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.5
                @Override // com.baidu.tbadk.util.o.a
                public void onError(int i, String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), R.string.tb_webview_download_image_success_tip);
                }

                @Override // com.baidu.tbadk.util.o.a
                public void onSuccess(String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), R.string.save_success);
                }
            }).lz(true).execute(new String[0]);
        }
    }

    private void show() {
        if (this.iwA != null && !isFinishing()) {
            this.iwA.SY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuV() {
        if (this.iwA != null && this.iwA.isShowing()) {
            this.iwA.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0201);
    }
}
