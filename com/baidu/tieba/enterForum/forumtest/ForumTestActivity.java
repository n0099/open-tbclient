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
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.forumtest.js.ForumTestWebView;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.h0.r.s.h;
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import d.b.h0.z0.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ForumTestActivity extends BaseActivity implements d.b.i0.i0.e.a.b {
    public j mMoreDialog;
    public List<h> mMoreDialogDataList;
    public l mMoreDialogView;
    public NoNetworkView mNoNetworkView;
    public PermissionJudgePolicy mPermissionJudgement;
    public h mSaveToDickItem;
    public View mStatusBarView;
    public long mTestId;
    public ForumTestWebView mWebView;
    public String mUrl = "https://tieba.baidu.com/mo/q/recomforum?testId=";
    public l.d mDialogSaveToDiskListener = new d();

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return ForumTestActivity.this.handleLongClick();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f15378e;

        public b(ShareItem shareItem) {
            this.f15378e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.p.a.a(this.f15378e.t);
            d.b.b.e.p.l.L(ForumTestActivity.this, view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements l.c {
        public c() {
        }

        @Override // d.b.h0.r.s.l.c
        public void onClick() {
            ForumTestActivity.this.hideMoreDialog();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements l.d {
        public d() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            ForumTestActivity forumTestActivity = ForumTestActivity.this;
            forumTestActivity.saveImage(forumTestActivity.mWebView.getHitTestResult().getExtra());
            ForumTestActivity.this.hideMoreDialog();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends q.a {
        public e() {
        }

        @Override // d.b.h0.z0.q.a
        public void onError(int i, String str) {
            d.b.b.e.p.l.K(TbadkCoreApplication.getInst(), R.string.tb_webview_download_image_success_tip);
        }

        @Override // d.b.h0.z0.q.a
        public void onSuccess(String str) {
            d.b.b.e.p.l.K(TbadkCoreApplication.getInst(), R.string.save_success);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        WebView.HitTestResult hitTestResult;
        ForumTestWebView forumTestWebView = this.mWebView;
        if (forumTestWebView == null || (hitTestResult = forumTestWebView.getHitTestResult()) == null || hitTestResult.getType() != 5) {
            return false;
        }
        setDialogItems();
        show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideMoreDialog() {
        j jVar = this.mMoreDialog;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.mMoreDialog.dismiss();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mTestId = intent.getLongExtra(ForumTestActivityConfig.TEST_ID, 0L);
        this.mUrl += this.mTestId;
    }

    private void initDiaglogView() {
        if (this.mMoreDialog == null) {
            this.mMoreDialogView = new l(this);
        }
        if (this.mMoreDialogDataList == null) {
            this.mMoreDialogDataList = new ArrayList();
        }
        this.mMoreDialog = new j(getPageContext(), this.mMoreDialogView);
    }

    private void initStatusBar() {
        ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
        layoutParams.height = UtilHelper.getStatusBarHeight();
        this.mStatusBarView.setLayoutParams(layoutParams);
        if (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mWebView.getLayoutParams();
            layoutParams2.addRule(3, R.id.status_bar_view);
            this.mWebView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage(String str) {
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return;
        }
        q qVar = new q(getActivity(), str, new e());
        qVar.h(true);
        qVar.execute(new String[0]);
    }

    private void setDialogItems() {
        this.mMoreDialogDataList.clear();
        h hVar = new h(getString(R.string.save_this_image), this.mMoreDialogView);
        this.mSaveToDickItem = hVar;
        hVar.m(this.mDialogSaveToDiskListener);
        this.mMoreDialogDataList.add(this.mSaveToDickItem);
        this.mMoreDialogView.m(new c());
        this.mMoreDialogView.k(this.mMoreDialogDataList);
    }

    private void show() {
        if (this.mMoreDialog == null || isFinishing()) {
            return;
        }
        this.mMoreDialog.l();
    }

    @Override // d.b.i0.i0.e.a.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if ("share".equals(str2)) {
                if (ShareSwitch.isOn()) {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("desc");
                        String optString3 = jSONObject.optString("img");
                        String optString4 = jSONObject.optString("url");
                        ShareItem shareItem = new ShareItem();
                        shareItem.r = optString;
                        shareItem.s = optString2;
                        shareItem.t = optString4;
                        shareItem.v = Uri.parse(optString3);
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this, shareItem, true, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.setCopyLinkListener(new b(shareItem));
                        sendMessage(new CustomMessage(2001276, shareDialogConfig));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                jsPromptResult.confirm("share");
                return false;
            } else if (CommonTbJsBridge.FINISH_THIS_PAGE.equals(str2)) {
                finish();
                jsPromptResult.confirm(CommonTbJsBridge.FINISH_THIS_PAGE);
                return true;
            } else if ("finishTestAnswer".equals(str2)) {
                try {
                    this.mTestId = new JSONObject(str3).optLong("testId");
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(this.mTestId)));
                finish();
                jsPromptResult.confirm("finishTestAnswer");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setBackgroundColor(this.mStatusBarView, R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setSwipeBackEnabled(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_forum_test_layout);
        this.mNoNetworkView = (NoNetworkView) findViewById(R.id.activity_forum_test_net);
        this.mStatusBarView = findViewById(R.id.status_bar_view);
        ForumTestWebView forumTestWebView = (ForumTestWebView) findViewById(R.id.activity_forum_test_web);
        this.mWebView = forumTestWebView;
        forumTestWebView.g(this);
        initStatusBar();
        initData();
        this.mWebView.loadUrl(this.mUrl);
        this.mWebView.setOnLongClickListener(new a());
        initDiaglogView();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ForumTestWebView forumTestWebView = this.mWebView;
        if (forumTestWebView != null) {
            forumTestWebView.loadDataWithBaseURL(null, "", SapiWebView.K, "utf-8", null);
            this.mWebView.clearHistory();
            ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
            this.mWebView.destroy();
            this.mWebView = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mWebView.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mWebView.onResume();
    }
}
