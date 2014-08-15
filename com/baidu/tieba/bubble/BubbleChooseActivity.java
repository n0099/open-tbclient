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
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class BubbleChooseActivity extends BaseActivity {
    private g b;
    private com.baidu.tieba.model.e c;
    private final int d = 0;
    private final int e = 50;
    private com.baidu.tieba.model.h f = new a(this);
    private com.baidu.tieba.model.i g = new b(this);
    private s h = new c(this);
    private s i = new d(this);
    public CustomMessageListener a = new e(this, 2010040);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.f.class, BubbleChooseActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        b();
        d();
    }

    private void a() {
        this.c = new com.baidu.tieba.model.e();
        this.c.a(this.f);
        this.c.a(this.g);
        this.c.a(this.a);
        c();
    }

    private void b() {
        this.b = new g(this);
        this.b.c().setOnItemClickListener(this);
        this.b.d();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    private void c() {
        this.c.c();
        this.c.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.c.a(0, 50, com.baidu.adp.lib.util.j.b(this), com.baidu.adp.lib.util.j.c(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.e();
            this.c.b(this.a);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.b.b()) {
            TbWebViewActivity.startActivity(this, getString(x.web_title_bubble_explain), String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeanrights?type=1&_client_version=" + TbConfig.getVersion());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.b(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BubbleListData.BubbleData a;
        super.onItemClick(adapterView, view, i, j);
        if (adapterView == this.b.c() && view != null && (view instanceof com.baidu.tieba.view.b) && (a = this.b.a(i)) != null) {
            if (a.getBcode() == 0 || a.canUse()) {
                a(a.getBcode());
                this.b.d();
            } else if (a.isFree()) {
                h.a(this, a, this.h);
            } else {
                h.b(this, a, this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.c.a(i, com.baidu.adp.lib.util.j.b(this), com.baidu.adp.lib.util.j.c(this));
        this.c.a(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 23004) {
            d();
        }
    }
}
