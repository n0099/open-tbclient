package com.baidu.tieba.im.live.livelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes.dex */
public class BlackMembersListActivity extends BaseActivity implements AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.x {
    private i a;
    private com.baidu.tieba.im.model.y b;
    private final com.baidu.adp.framework.listener.b c = new a(this, MessageTypes.CMD_LIVE_BLACK_MEMBERS_LIST);
    private final com.baidu.adp.framework.listener.b d = new b(this, MessageTypes.CMD_LIVE_GROUP_OWNER_GAG);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.d.class, BlackMembersListActivity.class);
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
        this.b.a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    private void b() {
        this.a = new i(this);
        BdListView d = this.a.d();
        d.setOnScrollListener(this);
        d.setOnSrollToBottomListener(this);
        d.setOnItemClickListener(new c(this));
        this.a.e().a(new d(this));
    }

    private void c() {
        showLoadingDialog(getString(com.baidu.tieba.y.group_tab_enterchatroom_loading), null);
        this.b.a(this.b.b(), this.b.c(), 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        closeLoadingDialog();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.b()) {
            a(this.a.b());
        } else if (view == this.a.a()) {
            e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                e();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    private void e() {
        Intent intent = new Intent();
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.TOTAL, this.b.a());
        setResult(-1, intent);
        finish();
    }

    private void a(TextView textView) {
        e e = this.a.e();
        if (!e.b()) {
            e.c(true);
            textView.setText(com.baidu.tieba.y.done);
            be.g(textView, TbadkApplication.m252getInst().getSkinType());
            e.notifyDataSetChanged();
            return;
        }
        e.c(false);
        textView.setText(com.baidu.tieba.y.edit);
        be.i(textView, TbadkApplication.m252getInst().getSkinType());
        e.notifyDataSetChanged();
    }

    public void a(Bundle bundle) {
        this.b = new com.baidu.tieba.im.model.y();
        if (bundle == null) {
            this.b.a(getIntent());
        } else {
            this.b.b(bundle);
        }
        this.b.registerListener(this.c);
        this.b.registerListener(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        return this.b.d() == 0;
    }

    private void g() {
        if (this.a.e().a()) {
            this.b.a(this.b.b(), this.b.c(), 20);
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void f_() {
        g();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.a.a(true);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
