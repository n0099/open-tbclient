package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.am;
import com.baidu.tieba.view.cm;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class MembersActivity extends com.baidu.tieba.j implements View.OnClickListener, AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.r, com.baidu.tieba.im.c.l {
    private cm a;
    private ac b;
    private com.baidu.tieba.im.model.n c;
    private Handler d;
    private com.baidu.tieba.im.messageCenter.g e = new t(this);
    private com.baidu.tieba.im.messageCenter.g f = new u(this);
    private Runnable g = new n(this);

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
        com.baidu.tieba.im.c.m.a().a("kick_out", this);
        com.baidu.tieba.im.c.m.a().a("apply_join_success", this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.c.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.b.h().g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.c.m.a().a(this);
        this.c.b(this.e);
        this.c.d(this.f);
    }

    public com.baidu.tieba.im.model.n b() {
        return this.c;
    }

    private void e() {
        this.b = new ac(this);
        BdListView l = this.b.l();
        this.a = new cm(this);
        this.a.a(new m(this, l));
        l.setPullRefresh(this.a);
        l.setOnScrollListener(this);
        l.setOnSrollToBottomListener(this);
        l.setOnItemClickListener(new o(this));
        l.setOnItemLongClickListener(new p(this));
        this.b.a().setOnClickListener(this);
        this.b.e().setOnClickListener(this);
        this.b.f().setOnClickListener(this);
        this.b.b(false);
        this.b.i().a(new s(this));
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

    private void f() {
        this.c.b(false);
        this.c.a((am) null);
        this.b.i().a(true);
        this.c.b(0);
        this.c.d(50);
        this.b.l().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.c.b(true);
        this.c.a((am) null);
        this.b.i().a(false);
        this.c.b(0);
        this.c.d(50);
        this.b.l().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (i()) {
            this.b.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return 50 == this.c.e();
    }

    public void a(Bundle bundle) {
        this.c = new com.baidu.tieba.im.model.n();
        if (bundle == null) {
            this.c.a(getIntent());
        } else {
            this.c.a(bundle);
        }
        this.d = new Handler();
        this.c.a(this.e);
        this.c.c(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            this.c.a(isController);
            this.b.b(isController);
        }
    }

    public void c() {
        if (this.d != null) {
            this.d.removeCallbacks(this.g);
            this.d.postDelayed(this.g, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.b.h().f();
        this.b.h().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        this.b.a(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.k()) {
            k();
        } else if (view == this.b.a()) {
            m();
            this.b.d(false);
        } else if (view == this.b.e()) {
            l();
            this.b.d(true);
        } else if (view == this.b.f()) {
            n();
        }
    }

    private void k() {
        com.baidu.tieba.im.d.b.a((Activity) this, (DialogInterface.OnClickListener) new v(this));
    }

    private void l() {
        this.b.c(false);
        this.b.i().d(false);
        this.b.i().a();
        this.b.j();
    }

    private void m() {
        this.b.c(true);
        this.b.i().d(true);
        this.b.j();
    }

    private void n() {
        Set<Long> b = this.b.i().b();
        if (b.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(b);
            com.baidu.tieba.im.d.b.b((Activity) this, (DialogInterface.OnClickListener) new w(this, arrayList), (DialogInterface.OnClickListener) new x(this));
        }
    }

    private void o() {
        if (this.b.i().c()) {
            this.c.a(this.c.f(), this.c.d(), this.c.e(), this.c.a());
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
            if (this.d != null) {
                this.d.removeCallbacks(this.g);
                this.d.postDelayed(this.g, 300L);
            }
        } else if (this.d != null) {
            this.d.removeCallbacks(this.g);
        }
    }

    @Override // com.baidu.tieba.im.c.l
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
