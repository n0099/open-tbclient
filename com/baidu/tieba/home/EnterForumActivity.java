package com.baidu.tieba.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EnterForumActivity extends com.baidu.tieba.e implements AbsListView.OnScrollListener, com.baidu.tbadk.a.d {
    t c = null;
    private com.baidu.tieba.c.j d = null;
    private com.baidu.tieba.c.ag e = null;
    private k f = null;
    private com.baidu.tieba.a.p g = null;
    private Boolean h = false;
    private j i = null;
    private Handler j = null;
    private Runnable k = null;
    private View.OnKeyListener l = new f(this);

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.c.r() || dialogInterface == this.c.s()) {
            switch (i) {
                case 0:
                    if (this.g != null) {
                        String b = this.g.b();
                        if (com.baidu.tieba.d.ad.b(b)) {
                            FrsActivity.a(this, b, "tb_forumlist");
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    n();
                    return;
                default:
                    return;
            }
        } else if (dialogInterface == this.c.t()) {
            if (i == -1) {
                if (this.f == null) {
                    this.f = new k(this, this.g);
                    this.f.setPriority(3);
                    this.f.execute(new com.baidu.tieba.a.p[0]);
                    return;
                }
                return;
            }
            this.c.q();
        }
    }

    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m();
        this.d = new com.baidu.tieba.c.j();
        this.d.a(new g(this));
        this.e = new com.baidu.tieba.c.ag();
        this.e.a(new h(this));
        b();
        this.c = new t(this, this.l);
    }

    public void b() {
        this.j = new Handler();
        this.k = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onStop() {
        this.c.e();
        super.onStop();
    }

    private void m() {
        this.i = new j(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.lottery");
        registerReceiver(this.i, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.j != null) {
            this.j.removeCallbacks(this.k);
            this.j.postDelayed(this.k, 300L);
        }
        this.c.f();
        a(false);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            if (!TiebaApplication.i()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        if (!TiebaApplication.i()) {
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
                MainTabActivity.a(this, "goto_person");
                break;
            case 2:
                AccountActivity.a(this);
                break;
            case 3:
                com.baidu.tieba.a.b bVar = new com.baidu.tieba.a.b();
                bVar.a(1);
                WriteActivity.a(this, com.baidu.tieba.a.i.g(), com.baidu.tieba.a.i.f(), bVar);
                break;
            case 4:
                AboutActivity.a(this);
                break;
            case 5:
                com.baidu.tieba.d.ag.a((Activity) this);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        if (this.j != null) {
            this.j.removeCallbacks(this.k);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.j != null) {
            this.j.removeCallbacks(this.k);
        }
        this.c.g();
        if (this.i != null) {
            unregisterReceiver(this.i);
        }
        d();
        super.onDestroy();
    }

    public void c() {
        this.c.h();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.c.i() || view.getId() == this.c.j()) {
            com.baidu.tieba.a.p pVar = null;
            if (view.getTag() instanceof com.baidu.tieba.a.p) {
                pVar = (com.baidu.tieba.a.p) view.getTag();
            }
            if (pVar != null) {
                String b = pVar.b();
                if (com.baidu.tieba.d.ad.b(b)) {
                    FrsActivity.a(this, b, "tb_forumlist");
                }
            }
        } else if (view.getId() == this.c.k()) {
            LoginActivity.a(this, "goto_home", getString(R.string.login_home_tab), 1100003);
        } else if (view.getId() == this.c.l()) {
            String B = TiebaApplication.B();
            if (B == null || B.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100002);
            } else if ((view.getTag() instanceof com.baidu.tieba.a.p) && !this.e.f()) {
                this.c.b();
                com.baidu.tieba.a.p pVar2 = (com.baidu.tieba.a.p) view.getTag();
                this.e.a(pVar2.b(), pVar2.a());
            }
        } else if (view == this.c.m()) {
            a(true);
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.c.i() || view.getId() == this.c.j()) {
            this.g = null;
            com.baidu.tieba.a.p pVar = view.getTag() instanceof com.baidu.tieba.a.p ? (com.baidu.tieba.a.p) view.getTag() : null;
            if (pVar != null) {
                this.g = pVar;
                String b = pVar.b();
                int c = pVar.c();
                if (com.baidu.tieba.d.ad.b(b)) {
                    if (c == 1) {
                        this.c.n();
                    } else {
                        this.c.o();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (adapterView == this.c.u() && this.c.b(i) != null) {
            if (this.c.b(i) instanceof com.baidu.tieba.a.p) {
                com.baidu.tieba.a.p pVar = (com.baidu.tieba.a.p) this.c.b(i);
                if (pVar != null) {
                    String b = pVar.b();
                    if (com.baidu.tieba.d.ad.b(b)) {
                        FrsActivity.a(this, b, "dimension_door");
                    }
                }
            } else if (this.c.b(i).equals(6)) {
                this.c.d();
                TiebaApplication.d().t();
            } else if (this.c.b(i).equals(0)) {
                SearchActivity.a(this, getString(R.string.home));
            }
        }
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.c.a(i);
    }

    public void d() {
        this.d.e();
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
        this.e.e();
    }

    public void a(boolean z) {
        boolean z2;
        boolean z3 = false;
        boolean booleanValue = this.h.booleanValue();
        this.h = Boolean.valueOf((TiebaApplication.B() == null || TiebaApplication.F() == null) ? false : true);
        if (this.d.d().c().size() <= 0 && this.d.d().d().size() <= 0) {
            z2 = true;
        } else if (booleanValue != this.h.booleanValue()) {
            z2 = false;
            z3 = true;
        } else {
            z2 = false;
        }
        if (TiebaApplication.d().O()) {
            z3 = true;
        }
        boolean z4 = z ? true : z3;
        if ((z2 || z4) && !this.d.f() && !this.e.f() && this.f == null) {
            d();
            if (z4) {
                this.c.a();
            }
            this.d.a(z2, z4, this.h.booleanValue());
        }
    }

    private void n() {
        if (this.g != null) {
            if (this.g.c() == 1) {
                this.c.p();
            } else if (this.f == null) {
                this.f = new k(this, this.g);
                this.f.execute(new com.baidu.tieba.a.p[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.c.a(this.d, this.h.booleanValue(), this.b);
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.c.a(str);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.j.removeCallbacks(this.k);
        this.j.postDelayed(this.k, 300L);
    }
}
