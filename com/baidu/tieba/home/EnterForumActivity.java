package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.av;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
import java.util.Iterator;
/* loaded from: classes.dex */
public class EnterForumActivity extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    private k f1185a = null;
    private i b = null;
    private com.baidu.tieba.model.l c = null;
    private com.baidu.tieba.data.ae d = null;
    private boolean e = true;
    private Boolean f = false;
    private com.baidu.tieba.model.o g = new f(this);
    private View.OnKeyListener j = new g(this);
    private com.baidu.adp.widget.ListView.b k = new h(this);

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.f1185a.r() || dialogInterface == this.f1185a.s()) {
            switch (i) {
                case 0:
                    if (this.d != null) {
                        String b = this.d.b();
                        if (at.b(b)) {
                            FrsActivity.a(this, b, "tb_forumlist");
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    d();
                    return;
                default:
                    return;
            }
        }
    }

    private void d() {
        if (this.d != null) {
            if (this.d.e() == 1) {
                this.f1185a.q();
            } else if (this.b == null) {
                this.b = new i(this, this.d);
                this.b.execute(new com.baidu.tieba.data.ae[0]);
            }
        }
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e();
        m();
    }

    private void e() {
        this.f1185a = new k(this, this.j);
        this.f1185a.a(this.k);
        this.f1185a.e().setClickStatKey("ef_tb_search");
    }

    private void m() {
        this.e = true;
        this.f = false;
        this.c = new com.baidu.tieba.model.l();
        this.c.a(this.g);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f1185a.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f1185a.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1185a.i();
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
            av.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
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
                WriteActivity.a(this, com.baidu.tieba.data.g.h(), com.baidu.tieba.data.g.g(), antiData);
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        this.f1185a.j();
        c();
        super.onDestroy();
    }

    public void b() {
        this.f1185a.k();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.f1185a.m() || view.getId() == this.f1185a.n()) {
            com.baidu.tieba.data.ae aeVar = null;
            if (view.getTag() instanceof com.baidu.tieba.data.ae) {
                aeVar = (com.baidu.tieba.data.ae) view.getTag();
            }
            if (aeVar != null) {
                String b = aeVar.b();
                if (at.b(b)) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "ef_recent", "click", 1);
                    }
                    FrsActivity.a(this, b, "tb_forumlist");
                }
            }
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.f1185a.m() || view.getId() == this.f1185a.n()) {
            this.d = null;
            com.baidu.tieba.data.ae aeVar = view.getTag() instanceof com.baidu.tieba.data.ae ? (com.baidu.tieba.data.ae) view.getTag() : null;
            if (aeVar != null) {
                this.d = aeVar;
                String b = aeVar.b();
                int e = aeVar.e();
                if (at.b(b)) {
                    if (e == 1) {
                        this.f1185a.o();
                    } else {
                        this.f1185a.p();
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
        super.a(i);
        this.f1185a.c(i);
    }

    public void c() {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        this.c.cancelLoadData();
    }

    public void a(boolean z) {
        boolean z2;
        boolean z3;
        if (this.c != null) {
            boolean booleanValue = this.f.booleanValue();
            this.f = Boolean.valueOf((TiebaApplication.C() == null || TiebaApplication.G() == null) ? false : true);
            if (this.e) {
                this.e = false;
                z2 = true;
                z3 = false;
            } else if (booleanValue != this.f.booleanValue()) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (TiebaApplication.g().P()) {
                TiebaApplication.g().h(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TiebaApplication.g().j() > 0) {
                if (this.c != null && this.c.a() != null && this.c.a().a() != null) {
                    Iterator<com.baidu.tieba.data.ae> it = this.c.a().a().a().iterator();
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
                this.f1185a.f();
            }
            if (z2 || z4) {
                c();
                if (z4) {
                    this.f1185a.b();
                } else {
                    this.c.b(this.f.booleanValue());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        if (cVar == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
