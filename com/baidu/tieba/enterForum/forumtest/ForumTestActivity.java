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
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes9.dex */
public class ForumTestActivity extends BaseActivity implements b {
    private NoNetworkView fbX;
    private i gEM;
    private k gEN;
    private List<g> gER;
    private ForumTestWebView gPa;
    private long gPb;
    private g gPc;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mStatusBarView;
    private String mUrl = "https://tieba.baidu.com/mo/q/recomforum?testId=";
    private k.b gPd = new k.b() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.4
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            ForumTestActivity.this.saveImage(ForumTestActivity.this.gPa.getHitTestResult().getExtra());
            ForumTestActivity.this.bLl();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setSwipeBackEnabled(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_forum_test_layout);
        this.fbX = (NoNetworkView) findViewById(R.id.activity_forum_test_net);
        this.mStatusBarView = findViewById(R.id.status_bar_view);
        this.gPa = (ForumTestWebView) findViewById(R.id.activity_forum_test_web);
        this.gPa.a(this);
        bOv();
        initData();
        this.gPa.loadUrl(this.mUrl);
        this.gPa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return ForumTestActivity.this.handleLongClick();
            }
        });
        bOu();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.gPb = intent.getLongExtra(ForumTestActivityConfig.TEST_ID, 0L);
            this.mUrl += this.gPb;
        }
    }

    private void bOu() {
        if (this.gEM == null) {
            this.gEN = new k(this);
        }
        if (this.gER == null) {
            this.gER = new ArrayList();
        }
        this.gEM = new i(getPageContext(), this.gEN);
    }

    private void bOv() {
        ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        this.mStatusBarView.setLayoutParams(layoutParams);
        if (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gPa.getLayoutParams();
            layoutParams2.addRule(3, R.id.status_bar_view);
            this.gPa.setLayoutParams(layoutParams2);
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
                    this.gPb = new JSONObject(str3).optLong("testId");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(this.gPb)));
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
        this.gPa.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gPa.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gPa.canGoBack()) {
            this.gPa.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gPa != null) {
            this.gPa.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.gPa.clearHistory();
            ((ViewGroup) this.gPa.getParent()).removeView(this.gPa);
            this.gPa.destroy();
            this.gPa = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        WebView.HitTestResult hitTestResult;
        if (this.gPa == null || (hitTestResult = this.gPa.getHitTestResult()) == null || hitTestResult.getType() != 5) {
            return false;
        }
        bOw();
        show();
        return true;
    }

    private void bOw() {
        this.gER.clear();
        this.gPc = new g(getString(R.string.save_this_image), this.gEN);
        this.gPc.a(this.gPd);
        this.gER.add(this.gPc);
        this.gEN.a(new k.a() { // from class: com.baidu.tieba.enterForum.forumtest.ForumTestActivity.3
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                ForumTestActivity.this.bLl();
            }
        });
        this.gEN.aD(this.gER);
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
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.tb_webview_download_image_success_tip);
                }

                @Override // com.baidu.tbadk.util.o.a
                public void onSuccess(String str2) {
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.save_success);
                }
            }).iw(true).execute(new String[0]);
        }
    }

    private void show() {
        if (this.gEM != null && !isFinishing()) {
            this.gEM.showDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLl() {
        if (this.gEM != null && this.gEM.isShowing()) {
            this.gEM.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.mStatusBarView, R.color.cp_bg_line_d);
    }
}
