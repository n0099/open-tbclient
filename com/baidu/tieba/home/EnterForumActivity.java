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
    private n f1105a = null;
    private j b = null;
    private com.baidu.tieba.model.j c = null;
    private Boolean d = false;
    private com.baidu.tieba.data.ai e = null;
    private Handler f = null;
    private Runnable g = null;
    private com.baidu.tieba.model.l j = new f(this);
    private View.OnKeyListener k = new g(this);
    private com.baidu.adp.widget.ListView.b l = new h(this);

    @Override // com.baidu.adp.a.a, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.f1105a.p() || dialogInterface == this.f1105a.q()) {
            switch (i) {
                case 0:
                    if (this.e != null) {
                        String b = this.e.b();
                        if (com.baidu.tieba.util.ai.b(b)) {
                            FrsActivity.a(this, b, "tb_forumlist");
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    k();
                    return;
                default:
                    return;
            }
        }
    }

    private void k() {
        if (this.e != null) {
            if (this.e.f() == 1) {
                this.f1105a.o();
            } else if (this.b == null) {
                this.b = new j(this, this.e);
                this.b.execute(new com.baidu.tieba.data.ai[0]);
            }
        }
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        l();
        m();
    }

    private void l() {
        this.f1105a = new n(this, this.k);
        this.f1105a.a(this.l);
    }

    private void m() {
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
        this.f1105a.e();
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
        this.f1105a.f();
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
            com.baidu.tieba.util.aj.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
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
                com.baidu.tieba.util.am.a((Activity) this);
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
        this.f1105a.g();
        d();
        super.onDestroy();
    }

    public void c() {
        this.f1105a.h();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.search_bg_layout) {
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this, "ef_tb_search", "click", 1);
            }
            SearchActivity.a(this, getString(R.string.home));
        } else if (view.getId() == this.f1105a.i() || view.getId() == this.f1105a.j()) {
            com.baidu.tieba.data.ai aiVar = null;
            if (view.getTag() instanceof com.baidu.tieba.data.ai) {
                aiVar = (com.baidu.tieba.data.ai) view.getTag();
            }
            if (aiVar != null) {
                String b = aiVar.b();
                if (com.baidu.tieba.util.ai.b(b)) {
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this, "ef_recent", "click", 1);
                    }
                    FrsActivity.a(this, b, "tb_forumlist");
                }
            }
        } else if (view.getId() == this.f1105a.l()) {
            LoginActivity.a(this, "goto_home", getString(R.string.login_home_tab), 11003);
        } else if (view.getId() == this.f1105a.k()) {
            this.f1105a.r();
            this.f.removeCallbacks(this.g);
            this.f.postDelayed(this.g, 0L);
        } else if (view == this.f1105a.c()) {
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this, "ef_category", "click", 1);
            }
            BarFolderFirstDirActivity.a(this);
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.f1105a.i() || view.getId() == this.f1105a.j()) {
            this.e = null;
            com.baidu.tieba.data.ai aiVar = view.getTag() instanceof com.baidu.tieba.data.ai ? (com.baidu.tieba.data.ai) view.getTag() : null;
            if (aiVar != null) {
                this.e = aiVar;
                String b = aiVar.b();
                int f = aiVar.f();
                if (com.baidu.tieba.util.ai.b(b)) {
                    if (f == 1) {
                        this.f1105a.m();
                    } else {
                        this.f1105a.n();
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
        this.f1105a.a(i);
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
        if (this.c != null) {
            boolean booleanValue = this.d.booleanValue();
            this.d = Boolean.valueOf((TiebaApplication.E() == null || TiebaApplication.I() == null) ? false : true);
            if (this.c.a() == null || this.c.a().g()) {
                z2 = true;
                z3 = false;
            } else {
                z3 = booleanValue != this.d.booleanValue();
                if (this.c.a().f()) {
                    z2 = false;
                } else {
                    z2 = false;
                    z3 = true;
                }
            }
            if (TiebaApplication.f().R()) {
                TiebaApplication.f().j(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TiebaApplication.f().i() > 0) {
                if (this.c != null && this.c.a() != null && this.c.a().a() != null) {
                    Iterator it = this.c.a().a().a().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.data.ai aiVar = (com.baidu.tieba.data.ai) it.next();
                        if (TiebaApplication.f().b(aiVar.b())) {
                            aiVar.a(1);
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
                this.f1105a.d();
            }
            if (z2 || z4) {
                d();
                if (z4) {
                    if (this.c.a(this.d.booleanValue()) && !z) {
                        this.f1105a.b();
                    }
                } else if (this.c.b(this.d.booleanValue())) {
                    this.f1105a.b();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.f1105a.a(str);
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
