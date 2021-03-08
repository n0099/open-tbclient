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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.p;
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
    private ForumTestWebView iJT;
    private long iJU;
    private g iJV;
    private List<g> izD;
    private i izy;
    private k izz;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mStatusBarView;
    private String mUrl = "https://tieba.baidu.com/mo/q/recomforum?testId=";
    private k.b iJW = new k.b() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ForumTestActivity.this.saveImage(ForumTestActivity.this.iJT.getHitTestResult().getExtra());
            ForumTestActivity.this.csC();
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
        this.iJT = (ForumTestWebView) findViewById(R.id.activity_forum_test_web);
        this.iJT.a(this);
        cvI();
        initData();
        this.iJT.loadUrl(this.mUrl);
        this.iJT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return ForumTestActivity.this.handleLongClick();
            }
        });
        cvH();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.iJU = intent.getLongExtra(ForumTestActivityConfig.TEST_ID, 0L);
            this.mUrl += this.iJU;
        }
    }

    private void cvH() {
        if (this.izy == null) {
            this.izz = new k(this);
        }
        if (this.izD == null) {
            this.izD = new ArrayList();
        }
        this.izy = new i(getPageContext(), this.izz);
    }

    private void cvI() {
        ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        this.mStatusBarView.setLayoutParams(layoutParams);
        if (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iJT.getLayoutParams();
            layoutParams2.addRule(3, R.id.status_bar_view);
            this.iJT.setLayoutParams(layoutParams2);
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
                    this.iJU = new JSONObject(str3).optLong("testId");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(this.iJU)));
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
        this.iJT.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.iJT.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.iJT.canGoBack()) {
            this.iJT.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iJT != null) {
            this.iJT.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.iJT.clearHistory();
            ((ViewGroup) this.iJT.getParent()).removeView(this.iJT);
            this.iJT.destroy();
            this.iJT = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        WebView.HitTestResult hitTestResult;
        if (this.iJT == null || (hitTestResult = this.iJT.getHitTestResult()) == null || hitTestResult.getType() != 5) {
            return false;
        }
        cvJ();
        show();
        return true;
    }

    private void cvJ() {
        this.izD.clear();
        this.iJV = new g(getString(R.string.save_this_image), this.izz);
        this.iJV.a(this.iJW);
        this.izD.add(this.iJV);
        this.izz.a(new k.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.3
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ForumTestActivity.this.csC();
            }
        });
        this.izz.bw(this.izD);
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
            new p(getActivity(), str, new p.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.5
                @Override // com.baidu.tbadk.util.p.a
                public void onError(int i, String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), R.string.tb_webview_download_image_success_tip);
                }

                @Override // com.baidu.tbadk.util.p.a
                public void onSuccess(String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), R.string.save_success);
                }
            }).ly(true).execute(new String[0]);
        }
    }

    private void show() {
        if (this.izy != null && !isFinishing()) {
            this.izy.QH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csC() {
        if (this.izy != null && this.izy.isShowing()) {
            this.izy.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0201);
    }
}
