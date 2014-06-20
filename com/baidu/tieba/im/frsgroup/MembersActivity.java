package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.im.message.RequestMembersMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class MembersActivity extends BaseActivity implements View.OnClickListener, AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.x {
    private com.baidu.tbadk.core.view.q a;
    private ah b;
    private com.baidu.tieba.im.model.ad c;
    private Handler d;
    private final com.baidu.adp.framework.listener.b e = new q(this, MessageTypes.CMD_REQUEST_MEMBERS_BY_ID);
    private final com.baidu.adp.framework.listener.b f = new t(this, MessageTypes.CMD_REMOVE_MEMBERS);
    private final Runnable g = new u(this);
    private final CustomMessageListener h = new v(this, 0);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, MembersActivity.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, j);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
        a(bundle);
        e();
        f();
    }

    private void d() {
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.h);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.h);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.c.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.b.e().g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public com.baidu.tieba.im.model.ad b() {
        return this.c;
    }

    private void e() {
        this.b = new ah(this);
        BdListView i = this.b.i();
        this.a = new com.baidu.tbadk.core.view.q(this);
        this.a.a(new w(this, i));
        i.setPullRefresh(this.a);
        i.setOnScrollListener(this);
        i.setOnSrollToBottomListener(this);
        i.setOnItemClickListener(new x(this));
        i.setOnItemLongClickListener(new y(this));
        this.b.a().setOnClickListener(this);
        this.b.b().setOnClickListener(this);
        this.b.c().setOnClickListener(this);
        this.b.b(false);
        this.b.f().a(new ab(this));
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
        this.c.a((RequestMembersMessage) null);
        this.b.f().a(true);
        this.c.b(0);
        this.c.d(50);
        this.b.i().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.c.b(true);
        this.c.a((RequestMembersMessage) null);
        this.b.f().a(false);
        this.c.b(0);
        this.c.d(50);
        this.b.i().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (i()) {
            this.b.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return 50 == this.c.e();
    }

    public void a(Bundle bundle) {
        this.c = new com.baidu.tieba.im.model.ad();
        this.c.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.c.a(getIntent());
        } else {
            this.c.a(bundle);
        }
        this.d = new Handler();
        this.c.registerListener(this.e);
        this.c.registerListener(this.f);
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
            k();
        } else if (view == this.b.a()) {
            m();
            this.b.d(false);
        } else if (view == this.b.b()) {
            l();
            this.b.d(true);
        } else if (view == this.b.c()) {
            n();
        }
    }

    private void k() {
        com.baidu.tieba.im.e.b.a((Activity) this, (DialogInterface.OnClickListener) new ac(this));
    }

    private void l() {
        this.b.b(0);
        this.b.c(false);
        this.b.f().d(false);
        this.b.f().a();
        this.b.g();
    }

    private void m() {
        this.b.c(true);
        this.b.f().d(true);
        this.b.g();
    }

    private void n() {
        Set<Long> b = this.b.f().b();
        if (b.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(b);
            com.baidu.tieba.im.e.b.b((Activity) this, (DialogInterface.OnClickListener) new r(this, arrayList), (DialogInterface.OnClickListener) new s(this));
        }
    }

    private void o() {
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
    public void f_() {
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
                this.d.postDelayed(this.g, 90L);
            }
        } else if (this.d != null) {
            this.d.removeCallbacks(this.g);
        }
    }
}
