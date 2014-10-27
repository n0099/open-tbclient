package com.baidu.tieba.game;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.GameWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.game.GameShareJsBridge;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GameWebViewActivity extends TbWebViewActivity {
    private WindowManager aHZ;
    private com.baidu.tbadk.core.view.b aIa;
    private com.baidu.tbadk.coreExtra.share.d aIb;
    private ArrayList<String> aIc = new ArrayList<>();
    private View.OnClickListener mOnClickListener = new ah(this);
    private final HttpMessageListener aId = new ai(this, CmdConfigHttp.H5_GAME_HTTP_CMD);

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameWebViewActivityConfig.class, GameWebViewActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBottomTool.setVisibility(8);
        this.mNavigationBar.setVisibility(8);
        this.aHZ = (WindowManager) getSystemService("window");
        this.aIa = new com.baidu.tbadk.core.view.b(this);
        this.aIa.setOnClickListener(this.mOnClickListener);
        this.aIc.add(getString(com.baidu.tieba.y.back));
        this.aIc.add(getString(com.baidu.tieba.y.share));
        this.aIc.add(getString(com.baidu.tieba.y.refresh));
        this.aIa.setData(this.aIc);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(GameShareJsBridge.getInstance(), "tb_game");
        setAutoChangeStyle(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aHZ.addView(this.aIa, this.aIa.getWindowManagerParams());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aHZ.removeView(this.aIa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aIa.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.tbadk.browser.TbWebViewActivity
    protected WebViewClient genWebViewClient() {
        return new al(this);
    }

    public void Hv() {
        ShareFromGameCenterMsgData rU = com.baidu.tbadk.game.b.rS().rU();
        com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
        hVar.title = rU.getTitle();
        hVar.content = rU.getContent();
        hVar.MW = rU.getShareUrl();
        if (StringUtils.isNull(rU.getImageUrl())) {
            hVar.MX = null;
        } else {
            hVar.MX = Uri.parse(rU.getImageUrl());
        }
        this.aIb = new com.baidu.tbadk.coreExtra.share.d(this);
        this.aIb.a(hVar, true);
        this.aIb.ai(false);
        TextView t = this.aIb.t(com.baidu.tieba.y.share_tieba_qunzu, com.baidu.tieba.u.icon_unite_share_qunzu);
        this.aIb.a(t);
        t.setOnClickListener(new aj(this));
        TextView t2 = this.aIb.t(com.baidu.tieba.y.forum_friend, com.baidu.tieba.u.icon_unite_share_baf);
        this.aIb.a(t2);
        t2.setOnClickListener(new ak(this));
        this.aIb.show();
    }
}
