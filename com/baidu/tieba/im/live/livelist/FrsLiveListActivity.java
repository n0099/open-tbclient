package com.baidu.tieba.im.live.livelist;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class FrsLiveListActivity extends BaseActivity implements AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.x {
    private com.baidu.tbadk.core.view.q a;
    private w b;
    private com.baidu.tieba.im.model.j c;
    private final com.baidu.adp.framework.listener.b d = new j(this, 107001);
    private final com.baidu.adp.framework.listener.b e = new k(this, 107110);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.t.class, FrsLiveListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        b();
        c();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.c.a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    private void b() {
        this.b = new w(this);
        BdListView d = this.b.d();
        this.a = new com.baidu.tbadk.core.view.q(this);
        this.a.a(new l(this));
        d.setPullRefresh(this.a);
        d.setOnScrollListener(this);
        d.setOnSrollToBottomListener(this);
        this.b.c().c(this.c.b());
        this.b.c().a(new m(this));
    }

    private void c() {
        this.b.d().e();
        this.c.a(this.c.a(), this.c.c(), 20, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.c.a(0);
        this.c.b(0);
        this.b.d().e();
        this.c.a(this.c.a(), this.c.c(), 20, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.b.a();
    }

    public void a(Bundle bundle) {
        this.c = new com.baidu.tieba.im.model.j();
        if (bundle == null) {
            this.c.a(getIntent());
        } else {
            this.c.b(bundle);
        }
        this.c.registerListener(this.d);
        this.c.registerListener(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.b.a(i);
        this.a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.c.d() == 0;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void g() {
        if (this.b.c().b()) {
            this.c.a(this.c.a(), this.c.c(), 20, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        g();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
