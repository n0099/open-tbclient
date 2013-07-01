package com.baidu.tieba.home;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.square.BarFolderFirstDirActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
import java.util.Iterator;
/* loaded from: classes.dex */
public class EnterForumActivity extends com.baidu.tieba.g implements AbsListView.OnScrollListener, com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    private n f883a = null;
    private j b = null;
    private com.baidu.tieba.model.j c = null;
    private Boolean d = false;
    private com.baidu.tieba.data.aa e = null;
    private Handler f = null;
    private Runnable g = null;
    private com.baidu.tieba.model.l j = new f(this);
    private View.OnKeyListener k = new g(this);
    private com.baidu.adp.widget.ListView.b l = new h(this);

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.f883a.o() || dialogInterface == this.f883a.p()) {
            switch (i) {
                case 0:
                    if (this.e != null) {
                        String b = this.e.b();
                        if (com.baidu.tieba.util.y.b(b)) {
                            FrsActivity.a(this, b, "tb_forumlist");
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    m();
                    return;
                default:
                    return;
            }
        }
    }

    private void m() {
        if (this.e != null) {
            if (this.e.f() == 1) {
                this.f883a.n();
            } else if (this.b == null) {
                this.b = new j(this, this.e);
                this.b.execute(new com.baidu.tieba.data.aa[0]);
            }
        }
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        n();
        o();
    }

    private void n() {
        this.f883a = new n(this, this.k);
        this.f883a.a(this.l);
    }

    private void o() {
        this.c = new com.baidu.tieba.model.j();
        this.c.a(this.j);
    }

    public void b() {
        this.f = new Handler();
        this.g = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        this.f883a.d();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f != null) {
            this.f.removeCallbacks(this.g);
            this.f.postDelayed(this.g, 300L);
        }
        this.f883a.e();
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
            com.baidu.tieba.util.z.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
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
                MainTabActivity.a(this, "goto_person");
                break;
            case 2:
                AccountActivity.a(this);
                break;
            case 3:
                AntiData antiData = new AntiData();
                antiData.setIfpost(1);
                WriteActivity.a(this, com.baidu.tieba.data.g.g(), com.baidu.tieba.data.g.f(), antiData);
                break;
            case 4:
                AboutActivity.a(this);
                break;
            case 5:
                com.baidu.tieba.util.ab.a((Activity) this);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        if (this.f != null) {
            this.f.removeCallbacks(this.g);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.f != null) {
            this.f.removeCallbacks(this.g);
        }
        this.f883a.f();
        d();
        super.onDestroy();
    }

    public void c() {
        this.f883a.g();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.search_bg_layout) {
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this, "ef_tb_search", "click", 1);
            }
            SearchActivity.a(this, getString(R.string.home));
        } else if (view.getId() == this.f883a.h() || view.getId() == this.f883a.i()) {
            com.baidu.tieba.data.aa aaVar = null;
            if (view.getTag() instanceof com.baidu.tieba.data.aa) {
                aaVar = (com.baidu.tieba.data.aa) view.getTag();
            }
            if (aaVar != null) {
                String b = aaVar.b();
                if (com.baidu.tieba.util.y.b(b)) {
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this, "ef_recent", "click", 1);
                    }
                    FrsActivity.a(this, b, "tb_forumlist");
                }
            }
        } else if (view.getId() == this.f883a.k()) {
            LoginActivity.a(this, "goto_home", getString(R.string.login_home_tab), 1100003);
        } else if (view.getId() == this.f883a.j()) {
            this.f883a.q();
            this.f.removeCallbacks(this.g);
            this.f.postDelayed(this.g, 0L);
        } else if (view == this.f883a.b()) {
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this, "ef_category", "click", 1);
            }
            BarFolderFirstDirActivity.a(this);
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.f883a.h() || view.getId() == this.f883a.i()) {
            this.e = null;
            com.baidu.tieba.data.aa aaVar = view.getTag() instanceof com.baidu.tieba.data.aa ? (com.baidu.tieba.data.aa) view.getTag() : null;
            if (aaVar != null) {
                this.e = aaVar;
                String b = aaVar.b();
                int f = aaVar.f();
                if (com.baidu.tieba.util.y.b(b)) {
                    if (f == 1) {
                        this.f883a.l();
                    } else {
                        this.f883a.m();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.f883a.a(i);
    }

    public void d() {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
        this.c.cancelLoadData();
    }

    public void a(boolean z) {
        boolean z2;
        boolean z3;
        boolean booleanValue = this.d.booleanValue();
        this.d = Boolean.valueOf((TiebaApplication.E() == null || TiebaApplication.H() == null) ? false : true);
        if (this.c.a() == null || this.c.a().g()) {
            z2 = true;
            z3 = false;
        } else if (booleanValue != this.d.booleanValue()) {
            z2 = false;
            z3 = true;
        } else {
            z2 = false;
            z3 = false;
        }
        if (TiebaApplication.f().Q()) {
            TiebaApplication.f().i(false);
            z3 = true;
        }
        boolean z4 = z ? true : z3;
        if (TiebaApplication.f().i() > 0) {
            if (this.c != null && this.c.a() != null && this.c.a().a() != null) {
                Iterator it = this.c.a().a().a().iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.data.aa aaVar = (com.baidu.tieba.data.aa) it.next();
                    if (TiebaApplication.f().b(aaVar.b())) {
                        aaVar.a(1);
                    }
                }
            }
            TiebaApplication.f().h();
            String E = TiebaApplication.E();
            if (E != null && E.length() > 0) {
                DatabaseService.g(E);
            } else {
                DatabaseService.c();
            }
            this.f883a.c();
        }
        if (z2 || z4) {
            d();
            if (z4) {
                if (this.c.a(this.d.booleanValue()) && !z) {
                    this.f883a.a();
                }
            } else if (this.c.b(this.d.booleanValue())) {
                this.f883a.a();
            }
        }
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.f883a.a(str);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f.removeCallbacks(this.g);
        this.f.postDelayed(this.g, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
