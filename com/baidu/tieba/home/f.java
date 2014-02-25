package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.mainentrance.SquareSearchActivity;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.square.BarFolderFirstDirActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    private com.baidu.tieba.k h;
    private n b = null;
    private k c = null;
    private com.baidu.tieba.model.k d = null;
    private com.baidu.tieba.data.ad e = null;
    private boolean f = true;
    private Boolean g = false;
    private boolean i = false;
    private com.baidu.tieba.model.n j = new g(this);
    private View.OnKeyListener k = new i(this);
    private com.baidu.adp.widget.ListView.b l = new j(this);

    @Override // com.baidu.tieba.j, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.b.u() || dialogInterface == this.b.v()) {
            switch (i) {
                case 0:
                    if (this.e != null) {
                        String b = this.e.b();
                        if (bs.b(b)) {
                            FrsActivity.a(this.h, b, "tb_forumlist");
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

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.b != null) {
            this.b.a(i, i2, intent);
        }
    }

    private void d() {
        if (this.e != null) {
            if (this.e.e() == 1) {
                this.b.t();
            } else if (this.c == null) {
                this.c = new k(this, this.e);
                this.c.execute(new com.baidu.tieba.data.ad[0]);
            }
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.h = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e();
        a(getArguments());
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.enter_forum_view, (ViewGroup) null);
    }

    private void e() {
        this.b = new n(this.h, this, this.k);
        this.b.a(this.l);
        this.b.j().setClickStatKey("ef_tb_search");
    }

    private void a(Bundle bundle) {
        this.f = true;
        this.g = false;
        this.i = bundle.getBoolean("is_new_user", false);
        this.d = new com.baidu.tieba.model.k();
        this.d.a(this.j);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.b.m();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (b()) {
            this.b.l();
            a(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            menu.findItem(2).setVisible(true);
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                com.baidu.tieba.mainentrance.f.a(this.h, 4);
                break;
            case 2:
                AccountActivity.a(this.h);
                break;
            case 3:
                AntiData antiData = new AntiData();
                antiData.setIfpost(1);
                WriteActivity.a(this.h, com.baidu.tieba.data.i.s(), com.baidu.tieba.data.i.r(), antiData);
                break;
            case 4:
                AboutActivity.a((Context) this.h);
                break;
            case 5:
                UtilHelper.a((Activity) this.h);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        c();
        super.onDestroy();
    }

    public void a() {
        this.b.n();
    }

    @Override // com.baidu.tieba.j, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.search_bg_layout) {
            SquareSearchActivity.a(this.h, getString(R.string.home));
        } else if (view.getId() == this.b.p() || view.getId() == this.b.q()) {
            com.baidu.tieba.data.ad adVar = null;
            if (view.getTag() instanceof com.baidu.tieba.data.ad) {
                adVar = (com.baidu.tieba.data.ad) view.getTag();
            }
            if (adVar != null) {
                String b = adVar.b();
                if (bs.b(b)) {
                    cb.a(this.h, "ef_recent", "click", 1, new Object[0]);
                    FrsActivity.a(this.h, b, "tb_forumlist");
                }
            }
        } else if (view.getId() == R.id.square_all_cat) {
            cb.a(this.h, "enter_icon_category", "click", 1, new Object[0]);
            BarFolderFirstDirActivity.a(this.h, "enter_icon_category");
        }
    }

    @Override // com.baidu.tieba.j, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.b.p() || view.getId() == this.b.q()) {
            this.e = null;
            com.baidu.tieba.data.ad adVar = view.getTag() instanceof com.baidu.tieba.data.ad ? (com.baidu.tieba.data.ad) view.getTag() : null;
            if (adVar != null) {
                this.e = adVar;
                String b = adVar.b();
                int e = adVar.e();
                if (bs.b(b)) {
                    if (e == 1) {
                        this.b.r();
                    } else {
                        this.b.s();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.j, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        this.b.a(i);
    }

    public void c() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
        this.d.cancelLoadData();
    }

    public void a(boolean z) {
        boolean z2;
        boolean z3;
        if (this.d != null) {
            boolean booleanValue = this.g.booleanValue();
            this.g = Boolean.valueOf((TiebaApplication.A() == null || TiebaApplication.F() == null) ? false : true);
            if (this.f) {
                this.f = false;
                z2 = true;
                z3 = false;
            } else if (booleanValue != this.g.booleanValue()) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (TiebaApplication.g().L()) {
                TiebaApplication.g().h(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TiebaApplication.g().k() > 0) {
                if (this.d != null && this.d.a() != null && this.d.a().e() != null) {
                    Iterator<com.baidu.tieba.data.ad> it = this.d.a().e().a().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.data.ad next = it.next();
                        if (TiebaApplication.g().a(next.b())) {
                            next.a(1);
                            int c = TiebaApplication.g().c(next.b());
                            if (c > 0) {
                                next.b(c);
                            }
                        }
                    }
                }
                TiebaApplication.g().j();
                String A = TiebaApplication.A();
                if (A != null && A.length() > 0) {
                    DatabaseService.d(A);
                }
                this.b.k();
            }
            if (z2 || z4) {
                c();
                if (z4) {
                    this.b.e();
                } else {
                    this.d.b(this.g.booleanValue());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar == null) {
        }
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.j, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }
}
