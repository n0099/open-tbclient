package com.baidu.tieba.im.frsgroup;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.as;
import com.baidu.tieba.view.cs;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class MembersActivity extends com.baidu.tieba.f implements View.OnClickListener, AbsListView.OnScrollListener, com.baidu.adp.widget.ListView.r, com.baidu.tieba.im.messageCenter.g {
    private cs a;
    private ae b;
    private com.baidu.tieba.im.model.l c;
    private Handler d;
    private com.baidu.tieba.im.messageCenter.g e = new o(this);
    private com.baidu.tieba.im.messageCenter.g f = new q(this);
    private Runnable g = new r(this);

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, MembersActivity.class);
        intent.putExtra("group_id", j);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.im.messageCenter.d.a().a(-132, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-130, this);
        this.c = new com.baidu.tieba.im.model.l();
        if (bundle == null) {
            this.c.a(getIntent());
        } else {
            this.c.a(bundle);
        }
        this.d = new Handler();
        com.baidu.tieba.im.model.l lVar = this.c;
        com.baidu.tieba.im.messageCenter.d.a().a(103005, this.e);
        com.baidu.tieba.im.model.l lVar2 = this.c;
        com.baidu.tieba.im.messageCenter.d.a().a(103112, this.f);
        this.b = new ae(this);
        BdListView k = this.b.k();
        this.a = new cs(this);
        this.a.a(new s(this, k));
        k.setPullRefresh(this.a);
        k.setOnScrollListener(this);
        k.setOnSrollToBottomListener(this);
        k.setOnItemClickListener(new t(this));
        k.setOnItemLongClickListener(new u(this));
        this.b.a().setOnClickListener(this);
        this.b.d().setOnClickListener(this);
        this.b.e().setOnClickListener(this);
        this.b.b(false);
        this.b.h().a(new x(this));
        this.c.b(false);
        this.c.a((as) null);
        this.b.h().a(true);
        this.c.b(0);
        this.c.d(50);
        this.b.k().b();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.c.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        this.b.g().f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.d.a().a(this);
        com.baidu.tieba.im.model.l lVar = this.c;
        com.baidu.tieba.im.messageCenter.d.a().a(this.e);
        com.baidu.tieba.im.model.l lVar2 = this.c;
        com.baidu.tieba.im.messageCenter.d.a().a(this.f);
    }

    public final com.baidu.tieba.im.model.l a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(MembersActivity membersActivity, long j, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        membersActivity.b.a(true);
        membersActivity.c.a(list);
        com.baidu.tieba.im.model.l lVar = membersActivity.c;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append((Long) it.next()).append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        lVar.a(j, stringBuffer.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.c.b(true);
        this.c.a((as) null);
        this.b.h().a(false);
        this.c.b(0);
        this.c.d(50);
        this.b.k().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(MembersActivity membersActivity) {
        if (membersActivity.e()) {
            membersActivity.b.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
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
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        this.b.a(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.b.j()) {
            new AlertDialog.Builder(this).setTitle(R.string.members_order).setItems(R.array.members_order_by, new y(this)).create().show();
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
                z zVar = new z(this, arrayList);
                new AlertDialog.Builder(this).setTitle(R.string.del_post_tip).setMessage(R.string.members_dialog_remove_more_message).setPositiveButton(R.string.alert_yes_button, zVar).setNegativeButton(R.string.alert_no_button, new p(this)).create().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.adp.widget.ListView.r
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

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        GroupNewsPojo a;
        if (sVar != null && (sVar instanceof com.baidu.tieba.im.message.aa) && (a = ((com.baidu.tieba.im.message.aa) sVar).a()) != null) {
            String cmd = a.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                if (cmd.equals("apply_join_success")) {
                    d();
                } else if (cmd.equals("kick_out")) {
                    d();
                }
            }
        }
    }
}
