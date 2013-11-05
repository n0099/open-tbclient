package com.baidu.tieba.home;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.message.GroupsByUidMessage;
import com.baidu.tieba.im.searchGroup.SearchGroupActivity;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.square.SquareSearchActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
import java.util.Iterator;
/* loaded from: classes.dex */
public class EnterForumActivity extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    public static int f1320a = 0;
    public static boolean b = false;
    private n c = null;
    private l d = null;
    private com.baidu.tieba.model.t e = null;
    private com.baidu.tieba.data.ae f = null;
    private boolean g = true;
    private Boolean j = false;
    private com.baidu.tieba.im.messageCenter.h k = new f(this);
    private com.baidu.tieba.im.pushNotify.m l = new g(this);
    private com.baidu.tieba.model.w m = new h(this);
    private View.OnKeyListener n = new j(this);
    private com.baidu.adp.widget.ListView.b o = new k(this);

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.c.u() || dialogInterface == this.c.v()) {
            switch (i) {
                case 0:
                    if (this.f != null) {
                        String b2 = this.f.b();
                        if (bc.b(b2)) {
                            FrsActivity.a(this, b2, "tb_forumlist");
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    e();
                    return;
                default:
                    return;
            }
        }
    }

    private void e() {
        if (this.f != null) {
            if (this.f.e() == 1) {
                this.c.t();
            } else if (this.d == null) {
                this.d = new l(this, this.f);
                this.d.execute(new com.baidu.tieba.data.ae[0]);
            }
        }
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
        n();
        if (bundle != null) {
            f1320a = bundle.getInt("curent_tab");
            this.c.a();
        } else {
            String stringExtra = getIntent().getStringExtra("curent_tab");
            if (stringExtra != null && TextUtils.isDigitsOnly(stringExtra)) {
                try {
                    f1320a = Integer.valueOf(stringExtra).intValue();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.c.a();
            }
        }
        com.baidu.tieba.im.messageCenter.f.a().a(103101, this.k);
        com.baidu.tieba.im.messageCenter.f.a().a(103112, this.k);
        com.baidu.tieba.im.messageCenter.f.a().a(103102, this.k);
        com.baidu.tieba.im.messageCenter.f.a().a(-109, this.k);
        com.baidu.tieba.im.pushNotify.n.a().a("apply_join_success", this.l);
        com.baidu.tieba.im.pushNotify.n.a().a("kick_out", this.l);
        com.baidu.tieba.im.pushNotify.n.a().a("group_intro_change", this.l);
        com.baidu.tieba.im.pushNotify.n.a().a("group_name_change", this.l);
        com.baidu.tieba.im.pushNotify.n.a().a("group_level_up", this.l);
        com.baidu.tieba.im.pushNotify.n.a().a("group_head_change", this.l);
    }

    public boolean b() {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) getSystemService("activity")).getRunningTasks(10)) {
            if (runningTaskInfo.topActivity.getClassName().equals(MainTabActivity.class.getName())) {
                return true;
            }
        }
        return false;
    }

    private void f() {
        this.c = new n(this, this.n);
        this.c.a(this.o);
        this.c.h().setClickStatKey("ef_tb_search");
    }

    private void n() {
        this.g = true;
        this.j = false;
        this.e = new com.baidu.tieba.model.t();
        this.e.a(this.m);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("curent_tab", f1320a);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.c.j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.c.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.l();
        a(false);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            if (!TiebaApplication.n()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            be.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        if (!TiebaApplication.n()) {
            menu.add(0, 2, 2, getString(R.string.account)).setIcon(R.drawable.menu_account);
        }
        menu.add(0, 3, 3, getString(R.string.feedback)).setIcon(R.drawable.menu_feedback);
        menu.add(0, 4, 4, getString(R.string.about)).setIcon(R.drawable.menu_about);
        menu.add(0, 5, 5, getString(R.string.quit)).setIcon(R.drawable.menu_quit);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                MainTabActivity.a(this, 4);
                break;
            case 2:
                AccountActivity.a(this);
                break;
            case 3:
                AntiData antiData = new AntiData();
                antiData.setIfpost(1);
                WriteActivity.a(this, com.baidu.tieba.data.h.h(), com.baidu.tieba.data.h.g(), antiData);
                break;
            case 4:
                AboutActivity.a((Context) this);
                break;
            case 5:
                UtilHelper.a((Activity) this);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.tieba.util.i.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        this.c.m();
        d();
        com.baidu.tieba.im.messageCenter.f.a().a(this.k);
        com.baidu.tieba.im.pushNotify.n.a().a(this.l);
        super.onDestroy();
    }

    public void c() {
        this.c.n();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.search_bg_layout) {
            if (f1320a == 0) {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, "ef_tb_search", "click", 1);
                }
                SquareSearchActivity.a(this, getString(R.string.home));
                return;
            }
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "cl_search_group", "click", 1);
            }
            SearchGroupActivity.a(this);
        } else if (view.getId() == this.c.p() || view.getId() == this.c.q()) {
            com.baidu.tieba.data.ae aeVar = view.getTag() instanceof com.baidu.tieba.data.ae ? (com.baidu.tieba.data.ae) view.getTag() : null;
            if (aeVar != null) {
                String b2 = aeVar.b();
                if (bc.b(b2)) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "ef_recent", "click", 1);
                    }
                    FrsActivity.a(this, b2, "tb_forumlist");
                }
            }
        } else if (view.getId() == R.id.click_head) {
            GroupInfoData groupInfoData = view.getTag() instanceof GroupInfoData ? (GroupInfoData) view.getTag() : null;
            if (groupInfoData != null) {
                GroupInfoActivity.a(this, groupInfoData.getGroupId(), 1);
            }
        } else if (view.getId() == R.id.enter_group) {
            f1320a = 1;
            if (this.c != null) {
                this.c.a();
            }
        } else if (view.getId() == R.id.enter_forum) {
            f1320a = 0;
            if (this.c != null) {
                this.c.a();
            }
        } else if (view.getId() == R.id.btn_create_group && this.c != null && this.c.d != null && this.c.d.b != null) {
            com.baidu.tieba.im.b.c cVar = this.c.d.b;
            if (!TiebaApplication.D()) {
                a("请先登录");
            } else if (!b) {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, "create_group_tab", "click", 1);
                }
                a((String) null, new i(this));
                com.baidu.tieba.im.messageCenter.f.a().a(new GroupsByUidMessage(cVar.f1380a, cVar.b));
                b = true;
            }
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.c.p() || view.getId() == this.c.q()) {
            this.f = null;
            com.baidu.tieba.data.ae aeVar = view.getTag() instanceof com.baidu.tieba.data.ae ? (com.baidu.tieba.data.ae) view.getTag() : null;
            if (aeVar != null) {
                this.f = aeVar;
                String b2 = aeVar.b();
                int e = aeVar.e();
                if (bc.b(b2)) {
                    if (e == 1) {
                        this.c.r();
                    } else {
                        this.c.s();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        this.c.b(i);
    }

    public void d() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        this.e.cancelLoadData();
    }

    public void a(boolean z) {
        boolean z2;
        boolean z3;
        if (this.e != null) {
            boolean booleanValue = this.j.booleanValue();
            this.j = Boolean.valueOf((TiebaApplication.C() == null || TiebaApplication.H() == null) ? false : true);
            if (this.g) {
                this.g = false;
                z2 = true;
                z3 = false;
            } else if (booleanValue != this.j.booleanValue()) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (TiebaApplication.g().Q()) {
                TiebaApplication.g().h(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TiebaApplication.g().j() > 0) {
                if (this.e != null && this.e.a() != null && this.e.a().a() != null) {
                    Iterator<com.baidu.tieba.data.ae> it = this.e.a().a().a().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.data.ae next = it.next();
                        if (TiebaApplication.g().b(next.b())) {
                            next.a(1);
                        }
                    }
                }
                TiebaApplication.g().i();
                String C = TiebaApplication.C();
                if (C != null && C.length() > 0) {
                    DatabaseService.g(C);
                }
                this.c.i();
            }
            if (z2 || z4) {
                d();
                if (z4) {
                    this.c.e();
                } else {
                    if (this.e.b(this.j.booleanValue())) {
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
