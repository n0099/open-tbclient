package com.baidu.tieba.im.frsgroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.RequestMembersMessage;
import com.baidu.tieba.view.bi;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class MembersActivity extends com.baidu.tieba.j implements View.OnClickListener, AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.r, com.baidu.tieba.im.pushNotify.m {

    /* renamed from: a  reason: collision with root package name */
    private aa f1641a;
    private com.baidu.tieba.im.model.h b;
    private Handler c;
    private com.baidu.tieba.im.messageCenter.h d = new r(this);
    private com.baidu.tieba.im.messageCenter.h e = new s(this);
    private Runnable f = new l(this);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, MembersActivity.class);
        intent.putExtra("group_id", j);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
        a(bundle);
        e();
        f();
    }

    private void d() {
        com.baidu.tieba.im.pushNotify.n.a().a("kick_out", this);
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_success", this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f1641a.h().h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.pushNotify.n.a().a(this);
        this.b.b(this.d);
        this.b.d(this.e);
    }

    public com.baidu.tieba.im.model.h b() {
        return this.b;
    }

    private void e() {
        this.f1641a = new aa(this);
        BdListView l = this.f1641a.l();
        bi biVar = new bi(this);
        biVar.a(new k(this, l));
        l.setPullRefresh(biVar);
        l.setOnScrollListener(this);
        l.setOnSrollToBottomListener(this);
        l.setOnItemClickListener(new m(this));
        l.setOnItemLongClickListener(new n(this));
        this.f1641a.a().setOnClickListener(this);
        this.f1641a.e().setOnClickListener(this);
        this.f1641a.f().setOnClickListener(this);
        this.f1641a.b(false);
        this.f1641a.i().a(new q(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, List<Long> list) {
        if (list != null && list.size() != 0) {
            this.f1641a.a(true);
            this.b.a(list);
            this.b.a(j, a(list));
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

    private void f() {
        this.b.b(false);
        this.b.a((RequestMembersMessage) null);
        this.f1641a.i().a(true);
        this.b.b(0);
        this.b.d(50);
        this.f1641a.l().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.b.b(true);
        this.b.a((RequestMembersMessage) null);
        this.f1641a.i().a(false);
        this.b.b(0);
        this.b.d(50);
        this.f1641a.l().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (i()) {
            this.f1641a.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        RequestMembersMessage a2 = this.b.a();
        return a2 != null ? 50 == a2.getRn() : 50 == this.b.f();
    }

    public void a(Bundle bundle) {
        this.b = new com.baidu.tieba.im.model.h();
        if (bundle == null) {
            this.b.a(getIntent());
        } else {
            this.b.a(bundle);
        }
        this.c = new Handler();
        this.b.a(this.d);
        this.b.c(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.b.a(isController);
            this.f1641a.b(isController);
        }
    }

    public void c() {
        if (this.c != null) {
            this.c.removeCallbacks(this.f);
            this.c.postDelayed(this.f, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f1641a.h().g();
        this.f1641a.h().e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        this.f1641a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f1641a.k()) {
            k();
        } else if (view == this.f1641a.a()) {
            m();
            this.f1641a.d(false);
        } else if (view == this.f1641a.e()) {
            l();
            this.f1641a.d(true);
        } else if (view == this.f1641a.f()) {
            n();
        }
    }

    private void k() {
        com.baidu.tieba.im.d.a.a(this, new t(this));
    }

    private void l() {
        this.f1641a.c(false);
        this.f1641a.i().d(false);
        this.f1641a.i().a();
        this.f1641a.j();
    }

    private void m() {
        this.f1641a.c(true);
        this.f1641a.i().d(true);
        this.f1641a.j();
    }

    private void n() {
        Set<Long> b = this.f1641a.i().b();
        if (b.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(b);
            com.baidu.tieba.im.d.a.b(this, new u(this, arrayList), new v(this));
        }
    }

    private void o() {
        if (this.f1641a.i().c()) {
            this.b.a(this.b.g(), this.b.e(), this.b.f(), this.b.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        o();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            if (this.c != null) {
                this.c.removeCallbacks(this.f);
                this.c.postDelayed(this.f, 300L);
            }
        } else if (this.c != null) {
            this.c.removeCallbacks(this.f);
        }
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public void a(GroupNewsPojo groupNewsPojo) {
        if (groupNewsPojo != null) {
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                if (cmd.equals("apply_join_success")) {
                    g();
                } else if (cmd.equals("kick_out")) {
                    g();
                }
            }
        }
    }
}
