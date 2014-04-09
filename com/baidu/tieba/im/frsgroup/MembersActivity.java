package com.baidu.tieba.im.frsgroup;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.im.message.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class MembersActivity extends com.baidu.tbadk.a implements View.OnClickListener, AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.t {
    private com.baidu.tbadk.core.view.q a;
    private ah b;
    private com.baidu.tieba.im.model.z c;
    private Handler d;
    private final com.baidu.adp.framework.c.g e = new q(this, 103005);
    private final com.baidu.adp.framework.c.g f = new t(this, 103112);
    private final Runnable g = new u(this);
    private final com.baidu.adp.framework.c.a h = new v(this, 0);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, MembersActivity.class);
        intent.putExtra("group_id", j);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.adp.framework.c.a().a(2001132, this.h);
        com.baidu.adp.framework.c.a().a(2001130, this.h);
        this.c = new com.baidu.tieba.im.model.z();
        this.c.setUniqueId(getUniqueId());
        if (bundle == null) {
            this.c.a(getIntent());
        } else {
            this.c.a(bundle);
        }
        this.d = new Handler();
        this.c.registerListener(this.e);
        this.c.registerListener(this.f);
        this.b = new ah(this);
        BdListView k = this.b.k();
        this.a = new com.baidu.tbadk.core.view.q(this);
        this.a.a(new w(this, k));
        k.setPullRefresh(this.a);
        k.setOnScrollListener(this);
        k.setOnSrollToBottomListener(this);
        k.setOnItemClickListener(new x(this));
        k.setOnItemLongClickListener(new y(this));
        this.b.a().setOnClickListener(this);
        this.b.d().setOnClickListener(this);
        this.b.e().setOnClickListener(this);
        this.b.b(false);
        this.b.h().a(new ab(this));
        this.c.b(false);
        this.c.a((ap) null);
        this.b.h().a(true);
        this.c.b(0);
        this.c.d(50);
        this.b.k().c();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.c.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        this.b.g().f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public final com.baidu.tieba.im.model.z a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(MembersActivity membersActivity, long j, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        membersActivity.b.a(true);
        membersActivity.c.a(list);
        com.baidu.tieba.im.model.z zVar = membersActivity.c;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append((Long) it.next()).append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        zVar.a(j, stringBuffer.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(MembersActivity membersActivity) {
        membersActivity.c.b(true);
        membersActivity.c.a((ap) null);
        membersActivity.b.h().a(false);
        membersActivity.c.b(0);
        membersActivity.c.d(50);
        membersActivity.b.k().c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(MembersActivity membersActivity) {
        if (membersActivity.d()) {
            membersActivity.b.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return 50 == this.c.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(MembersActivity membersActivity, UserData.Permission permission) {
        if (permission != null) {
            boolean isController = permission.isController();
            membersActivity.c.a(isController);
            membersActivity.b.b(isController);
        }
    }

    public final void c() {
        if (this.d != null) {
            this.d.removeCallbacks(this.g);
            this.d.postDelayed(this.g, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(MembersActivity membersActivity) {
        membersActivity.b.g().e();
        membersActivity.b.g().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        this.b.a(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.j()) {
            new AlertDialog.Builder(this).setTitle(com.baidu.tieba.im.j.members_order).setItems(com.baidu.tieba.im.d.members_order_by, new ac(this)).create().show();
        } else if (view == this.b.a()) {
            this.b.c(true);
            this.b.h().d(true);
            this.b.i();
            this.b.d(false);
        } else if (view == this.b.d()) {
            this.b.c(false);
            this.b.h().d(false);
            this.b.h().a();
            this.b.i();
            this.b.d(true);
        } else if (view == this.b.e()) {
            Set<Long> b = this.b.h().b();
            if (b.size() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(b);
                r rVar = new r(this, arrayList);
                new AlertDialog.Builder(this).setTitle(com.baidu.tieba.im.j.del_post_tip).setMessage(com.baidu.tieba.im.j.members_dialog_remove_more_message).setPositiveButton(com.baidu.tieba.im.j.alert_yes_button, rVar).setNegativeButton(com.baidu.tieba.im.j.alert_no_button, new s(this)).create().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        if (this.b.h().c()) {
            this.c.a(this.c.f(), this.c.d(), this.c.e(), this.c.a());
        }
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
}
