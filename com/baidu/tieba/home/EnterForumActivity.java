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
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.im.mygroup.MyGroupActivity;
import com.baidu.tieba.im.nearbygroups.NearbyGroupsActivity;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.square.SquareSearchActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
import com.slidingmenu.lib.R;
import java.util.Iterator;
/* loaded from: classes.dex */
public class EnterForumActivity extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.c {
    private BaseFragmentActivity g;

    /* renamed from: a  reason: collision with root package name */
    private k f1433a = null;
    private i b = null;
    private com.baidu.tieba.model.t c = null;
    private com.baidu.tieba.data.ad d = null;
    private boolean e = true;
    private Boolean f = false;
    private com.baidu.tieba.model.w h = new f(this);
    private View.OnKeyListener i = new g(this);
    private com.baidu.adp.widget.ListView.b Y = new h(this);

    @Override // com.baidu.tieba.BaseFragment, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.f1433a.s() || dialogInterface == this.f1433a.t()) {
            switch (i) {
                case 0:
                    if (this.d != null) {
                        String b = this.d.b();
                        if (com.baidu.tieba.util.bb.b(b)) {
                            FrsActivity.a(this.g, b, "tb_forumlist");
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    H();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (this.f1433a != null) {
            this.f1433a.a(i, i2, intent);
        }
    }

    private void H() {
        if (this.d != null) {
            if (this.d.e() == 1) {
                this.f1433a.r();
            } else if (this.b == null) {
                this.b = new i(this, this.d);
                this.b.execute(new com.baidu.tieba.data.ad[0]);
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.g = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        I();
        J();
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.enter_forum_view, (ViewGroup) null);
    }

    private void I() {
        this.f1433a = new k(this.g, this, this.i);
        this.f1433a.a(this.Y);
        this.f1433a.h().setClickStatKey("ef_tb_search");
    }

    private void J() {
        this.e = true;
        this.f = false;
        this.c = new com.baidu.tieba.model.t();
        this.c.a(this.h);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.f1433a.k();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (F()) {
            this.f1433a.j();
            a(false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            if (!TiebaApplication.o()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        super.a(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean a(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                MainTabActivity.a(this.g, 4);
                break;
            case 2:
                AccountActivity.a(this.g);
                break;
            case 3:
                AntiData antiData = new AntiData();
                antiData.setIfpost(1);
                WriteActivity.a(this.g, com.baidu.tieba.data.h.h(), com.baidu.tieba.data.h.g(), antiData);
                break;
            case 4:
                AboutActivity.a((Context) this.g);
                break;
            case 5:
                UtilHelper.a((Activity) this.g);
                break;
        }
        return super.a(menuItem);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        G();
        super.t();
    }

    public void a() {
        this.f1433a.l();
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.search_bg_layout) {
            SquareSearchActivity.a(this.g, a(R.string.home));
        } else if (view.getId() == this.f1433a.n() || view.getId() == this.f1433a.o()) {
            com.baidu.tieba.data.ad adVar = null;
            if (view.getTag() instanceof com.baidu.tieba.data.ad) {
                adVar = (com.baidu.tieba.data.ad) view.getTag();
            }
            if (adVar != null) {
                String b = adVar.b();
                if (com.baidu.tieba.util.bb.b(b)) {
                    if (TiebaApplication.h().t()) {
                        StatService.onEvent(this.g, "ef_recent", "click", 1);
                    }
                    FrsActivity.a(this.g, b, "tb_forumlist");
                }
            }
        } else if (view.getId() == R.id.mygroup_item) {
            MyGroupActivity.a(i());
        } else if (view.getId() == R.id.neargroup_item) {
            NearbyGroupsActivity.a(i());
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == this.f1433a.n() || view.getId() == this.f1433a.o()) {
            this.d = null;
            com.baidu.tieba.data.ad adVar = view.getTag() instanceof com.baidu.tieba.data.ad ? (com.baidu.tieba.data.ad) view.getTag() : null;
            if (adVar != null) {
                this.d = adVar;
                String b = adVar.b();
                int e = adVar.e();
                if (com.baidu.tieba.util.bb.b(b)) {
                    if (e == 1) {
                        this.f1433a.p();
                    } else {
                        this.f1433a.q();
                    }
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        this.f1433a.c(i);
    }

    public void G() {
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
            this.f = Boolean.valueOf((TiebaApplication.B() == null || TiebaApplication.G() == null) ? false : true);
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
            if (TiebaApplication.h().M()) {
                TiebaApplication.h().h(false);
                z3 = true;
            }
            boolean z4 = z ? true : z3;
            if (TiebaApplication.h().k() > 0) {
                if (this.c != null && this.c.a() != null && this.c.a().d() != null) {
                    Iterator<com.baidu.tieba.data.ad> it = this.c.a().d().a().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.data.ad next = it.next();
                        if (TiebaApplication.h().b(next.b())) {
                            next.a(1);
                            int d = TiebaApplication.h().d(next.b());
                            if (d > 0) {
                                next.b(d);
                            }
                        }
                    }
                }
                TiebaApplication.h().j();
                String B = TiebaApplication.B();
                if (B != null && B.length() > 0) {
                    DatabaseService.f(B);
                }
                this.f1433a.i();
            }
            if (z2 || z4) {
                G();
                if (z4) {
                    this.f1433a.e();
                } else {
                    this.c.b(this.f.booleanValue());
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar == null) {
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }
}
