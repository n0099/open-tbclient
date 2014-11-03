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
    private g ajb;
    private com.baidu.tieba.model.e ajc;
    private final int ajd = 0;
    private final int PAGE_LENGTH = 50;
    private com.baidu.tieba.model.h aje = new a(this);
    private com.baidu.tieba.model.i ajf = new b(this);
    private s ajg = new c(this);
    private s ajh = new d(this);
    public CustomMessageListener aji = new e(this, 2010040);

    static {
        TbadkApplication.m251getInst().RegisterIntent(BubbleChooseActivityConfig.class, BubbleChooseActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        nu();
        yj();
    }

    private void initData() {
        this.ajc = new com.baidu.tieba.model.e(this);
        this.ajc.a(this.aje);
        this.ajc.a(this.ajf);
        this.ajc.a(this.aji);
        sb();
    }

    private void nu() {
        this.ajb = new g(this);
        this.ajb.yo().setOnItemClickListener(this);
        this.ajb.showProgressBar();
    }

    private void sb() {
        this.ajc.Ti();
        this.ajc.Tj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yj() {
        this.ajc.h(0, 50, com.baidu.adp.lib.util.m.n(this), com.baidu.adp.lib.util.m.o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ajc != null) {
            this.ajc.unRegisterListener();
            this.ajc.b(this.aji);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ajb.yn()) {
            TbWebViewActivity.startActivity(this, getString(y.web_title_bubble_explain), String.valueOf(com.baidu.tieba.data.e.ajC) + "mo/q/tbeanrights?type=1&_client_version=" + TbConfig.getVersion(), true, false, true, true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ajb.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData dW;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView == this.ajb.yo() && view != null && (view instanceof com.baidu.tieba.view.b) && (dW = this.ajb.dW(i)) != null) {
            if (dW.getBcode() == 0 || dW.canUse()) {
                dU(dW.getBcode());
                this.ajb.showProgressBar();
            } else if (dW.isFree()) {
                h.a(this, dW, this.ajg);
            } else {
                h.b(this, dW, this.ajh);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dU(int i) {
        this.ajc.p(i, com.baidu.adp.lib.util.m.n(this), com.baidu.adp.lib.util.m.o(this));
        this.ajc.gy(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 23004) {
            yj();
        }
    }
}
