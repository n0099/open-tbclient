package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.im.message.RequestMembersMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class MembersActivity extends BaseActivity implements View.OnClickListener, AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.x {
    private com.baidu.tbadk.core.view.v a;
    private af b;
    private com.baidu.tieba.im.model.u c;
    private final com.baidu.adp.framework.listener.d d = new p(this, 103005);
    private final com.baidu.adp.framework.listener.d e = new r(this, 103112);
    private final CustomMessageListener f = new s(this, 0);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, MembersActivity.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, j);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
        a(bundle);
        d();
        e();
    }

    private void c() {
        registerListener(2001132, this.f);
        registerListener(2001130, this.f);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.c.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.b.e().g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public com.baidu.tieba.im.model.u b() {
        return this.c;
    }

    private void d() {
        this.b = new af(this);
        BdListView i = this.b.i();
        this.a = new com.baidu.tbadk.core.view.v(this);
        this.a.a(new t(this, i));
        i.setPullRefresh(this.a);
        i.setOnScrollListener(this);
        i.setOnSrollToBottomListener(this);
        i.setOnItemClickListener(new u(this));
        i.setOnItemLongClickListener(new v(this));
        this.b.a().setOnClickListener(this);
        this.b.b().setOnClickListener(this);
        this.b.c().setOnClickListener(this);
        this.b.b(false);
        this.b.f().a(new y(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.b.a(true);
            this.c.a(list);
            this.c.a(j, a(list));
        }
    }

    private String a(List<Long> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Long l : list) {
            stringBuffer.append(l).append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    private void e() {
        this.c.b(false);
        this.c.a((RequestMembersMessage) null);
        this.b.f().a(true);
        this.c.b(0);
        this.c.d(50);
        this.b.i().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.c.b(true);
        this.c.a((RequestMembersMessage) null);
        this.b.f().a(false);
        this.c.b(0);
        this.c.d(50);
        this.b.i().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (h()) {
            this.b.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return 50 == this.c.e();
    }

    public void a(Bundle bundle) {
        this.c = new com.baidu.tieba.im.model.u(this);
        this.c.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.c.a(getIntent());
        } else {
            this.c.a(bundle);
        }
        registerListener(this.d);
        registerListener(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.c.a(isController);
            this.b.b(isController);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.b.e().f();
        this.b.e().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.b.a(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.h()) {
            j();
        } else if (view == this.b.a()) {
            l();
            this.b.d(false);
        } else if (view == this.b.b()) {
            k();
            this.b.d(true);
        } else if (view == this.b.c()) {
            m();
        }
    }

    private void j() {
        com.baidu.tieba.im.d.b.a((Activity) this, (DialogInterface.OnClickListener) new z(this));
    }

    private void k() {
        this.b.b(0);
        this.b.c(false);
        this.b.f().d(false);
        this.b.f().a();
        this.b.g();
    }

    private void l() {
        this.b.b(0);
        this.b.c(true);
        this.b.f().d(true);
        this.b.g();
    }

    private void m() {
        Set<Long> b = this.b.f().b();
        if (b.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(b);
            com.baidu.tieba.im.d.b.b((Activity) this, (DialogInterface.OnClickListener) new aa(this, arrayList), (DialogInterface.OnClickListener) new q(this));
        }
    }

    private void n() {
        if (this.b.f().c()) {
            this.c.a(this.c.f(), this.c.d(), this.c.e(), this.c.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        n();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.b.i();
    }
}
