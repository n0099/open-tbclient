package com.baidu.tieba.game;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
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
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.game.GameShareJsBridge;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GameWebViewActivity extends TbWebViewActivity {
    private WindowManager aIj;
    private com.baidu.tbadk.core.view.b aIk;
    private com.baidu.tbadk.coreExtra.share.d aIl;
    private ArrayList<String> aIm = new ArrayList<>();
    private GameInfoData aIn = com.baidu.tbadk.game.b.rU().getGameInfoData();
    SparseArray<com.baidu.tbadk.coreExtra.data.f> aIo = null;
    private View.OnClickListener mOnClickListener = new ah(this);
    private final HttpMessageListener aIp = new ai(this, CmdConfigHttp.H5_GAME_HTTP_CMD);

    static {
        TbadkApplication.m251getInst().RegisterIntent(GameWebViewActivityConfig.class, GameWebViewActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBottomTool.setVisibility(8);
        this.mNavigationBar.setVisibility(8);
        this.aIj = (WindowManager) getSystemService("window");
        this.aIk = new com.baidu.tbadk.core.view.b(this);
        this.aIk.setOnClickListener(this.mOnClickListener);
        this.aIm.add(getString(com.baidu.tieba.y.back));
        this.aIm.add(getString(com.baidu.tieba.y.share));
        this.aIm.add(getString(com.baidu.tieba.y.refresh));
        this.aIk.setData(this.aIm);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(GameShareJsBridge.getInstance(), "tb_game");
        setAutoChangeStyle(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aIj.addView(this.aIk, this.aIk.getWindowManagerParams());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aIj.removeView(this.aIk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aIk.onDestroy();
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

    public void Hw() {
        ShareFromGameCenterMsgData rW = com.baidu.tbadk.game.b.rU().rW();
        com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
        hVar.title = rW.getTitle();
        hVar.content = rW.getContent();
        hVar.Na = rW.getShareUrl();
        if (StringUtils.isNull(rW.getImageUrl())) {
            hVar.Nb = null;
        } else {
            hVar.Nb = Uri.parse(rW.getImageUrl());
        }
        this.aIl = new com.baidu.tbadk.coreExtra.share.d(this);
        this.aIl.a(hVar, true);
        this.aIl.b(getShareMtjStatInfo());
        this.aIl.ai(false);
        TextView t = this.aIl.t(com.baidu.tieba.y.share_tieba_qunzu, com.baidu.tieba.u.icon_unite_share_qunzu);
        this.aIl.a(t);
        t.setOnClickListener(new aj(this));
        TextView t2 = this.aIl.t(com.baidu.tieba.y.forum_friend, com.baidu.tieba.u.icon_unite_share_baf);
        this.aIl.a(t2);
        t2.setOnClickListener(new ak(this));
        this.aIl.show();
    }

    private SparseArray<com.baidu.tbadk.coreExtra.data.f> getShareMtjStatInfo() {
        if (this.aIo == null) {
            this.aIo = new SparseArray<>(7);
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.add("dev_id");
            arrayList.add(this.aIn.getGameId());
            arrayList.add("share_type");
            arrayList.add(5);
            com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
            fVar.cp("game_share_wxf");
            fVar.i(arrayList);
            this.aIo.put(2, fVar);
            com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
            fVar2.cp("game_share_wx");
            fVar2.i(arrayList);
            this.aIo.put(3, fVar2);
            com.baidu.tbadk.coreExtra.data.f fVar3 = new com.baidu.tbadk.coreExtra.data.f();
            fVar3.cp("game_share_qzone");
            fVar3.i(arrayList);
            this.aIo.put(4, fVar3);
            com.baidu.tbadk.coreExtra.data.f fVar4 = new com.baidu.tbadk.coreExtra.data.f();
            fVar4.cp("game_share_txw");
            fVar4.i(arrayList);
            this.aIo.put(5, fVar4);
            com.baidu.tbadk.coreExtra.data.f fVar5 = new com.baidu.tbadk.coreExtra.data.f();
            fVar5.cp("game_share_sina");
            fVar5.i(arrayList);
            this.aIo.put(6, fVar5);
            com.baidu.tbadk.coreExtra.data.f fVar6 = new com.baidu.tbadk.coreExtra.data.f();
            fVar6.cp("game_share_renren");
            fVar6.i(arrayList);
            this.aIo.put(7, fVar6);
        }
        return this.aIo;
    }
}
