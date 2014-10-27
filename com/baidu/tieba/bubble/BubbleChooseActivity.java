package com.baidu.tieba.bubble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class BubbleChooseActivity extends BaseActivity {
    private g aiS;
    private com.baidu.tieba.model.e aiT;
    private final int aiU = 0;
    private final int PAGE_LENGTH = 50;
    private com.baidu.tieba.model.h aiV = new a(this);
    private com.baidu.tieba.model.i aiW = new b(this);
    private s aiX = new c(this);
    private s aiY = new d(this);
    public CustomMessageListener aiZ = new e(this, 2010040);

    static {
        TbadkApplication.m251getInst().RegisterIntent(BubbleChooseActivityConfig.class, BubbleChooseActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        nu();
        yh();
    }

    private void initData() {
        this.aiT = new com.baidu.tieba.model.e(this);
        this.aiT.a(this.aiV);
        this.aiT.a(this.aiW);
        this.aiT.a(this.aiZ);
        rZ();
    }

    private void nu() {
        this.aiS = new g(this);
        this.aiS.ym().setOnItemClickListener(this);
        this.aiS.showProgressBar();
    }

    private void rZ() {
        this.aiT.Tf();
        this.aiT.Tg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        this.aiT.h(0, 50, com.baidu.adp.lib.util.m.n(this), com.baidu.adp.lib.util.m.o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aiT != null) {
            this.aiT.unRegisterListener();
            this.aiT.b(this.aiZ);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aiS.yl()) {
            TbWebViewActivity.startActivity(this, getString(y.web_title_bubble_explain), String.valueOf(com.baidu.tieba.data.e.ajt) + "mo/q/tbeanrights?type=1&_client_version=" + TbConfig.getVersion(), true, false, true, true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aiS.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData dW;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView == this.aiS.ym() && view != null && (view instanceof com.baidu.tieba.view.b) && (dW = this.aiS.dW(i)) != null) {
            if (dW.getBcode() == 0 || dW.canUse()) {
                dU(dW.getBcode());
                this.aiS.showProgressBar();
            } else if (dW.isFree()) {
                h.a(this, dW, this.aiX);
            } else {
                h.b(this, dW, this.aiY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dU(int i) {
        this.aiT.p(i, com.baidu.adp.lib.util.m.n(this), com.baidu.adp.lib.util.m.o(this));
        this.aiT.gy(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 23004) {
            yh();
        }
    }
}
