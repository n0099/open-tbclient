package com.baidu.tieba.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.message.http.GameHttpResponsedMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GameWebViewActivity extends TbWebViewActivity {
    private WindowManager a;
    private com.baidu.tbadk.core.view.b b;
    private ArrayList<String> c = new ArrayList<>();
    private View.OnClickListener d = new ah(this);
    private final HttpMessageListener e = new ai(this, CmdConfigHttp.H5_GAME_HTTP_CMD);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.x.class, GameWebViewActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBottomTool.setVisibility(8);
        this.mNavigationBar.setVisibility(8);
        this.a = (WindowManager) getSystemService("window");
        this.b = new com.baidu.tbadk.core.view.b(this);
        this.b.setOnClickListener(this.d);
        this.c.add(getString(com.baidu.tieba.x.back));
        this.c.add(getString(com.baidu.tieba.x.share));
        this.c.add(getString(com.baidu.tieba.x.refresh));
        this.b.setData(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.addView(this.b, this.b.getWindowManagerParams());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.removeView(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.b.a();
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.coreExtra.view.g
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (ba.c(str)) {
            return false;
        }
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        MessageManager.getInstance().removeMessage(getUniqueId());
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.H5_GAME_HTTP_CMD, str);
        httpMessageTask.setResponsedClass(GameHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(httpMessageTask);
        registerListener(this.e);
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.H5_GAME_HTTP_CMD));
        return super.shouldOverrideUrlLoading(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
