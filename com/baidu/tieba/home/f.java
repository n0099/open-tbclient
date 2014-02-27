package com.baidu.tieba.home;

import android.app.Activity;
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
public final class f extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    private com.baidu.tieba.k h;
    private n b = null;
    private k c = null;
    private com.baidu.tieba.model.k d = null;
    private com.baidu.tieba.data.ad e = null;
    private boolean f = true;
    private Boolean g = false;
    private boolean i = false;
    private long j = -1;
    private com.baidu.tieba.model.n k = new g(this);
    private View.OnKeyListener l = new i(this);
    private com.baidu.adp.widget.ListView.b m = new j(this);

    @Override // com.baidu.tieba.j, android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface == this.b.q() || dialogInterface == this.b.r()) {
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
                    if (this.e != null) {
                        if (this.e.e() == 1) {
                            this.b.p();
                            return;
                        } else if (this.c == null) {
                            this.c = new k(this, this.e);
                            this.c.execute(new com.baidu.tieba.data.ad[0]);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.b != null) {
            this.b.a(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.h = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.enter_forum_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.j = System.currentTimeMillis();
        this.b = new n(this.h, this, this.l);
        this.b.a(this.m);
        this.b.f().setClickStatKey("ef_tb_search");
        Bundle arguments = getArguments();
        this.f = true;
        this.g = false;
        this.i = arguments.getBoolean("is_new_user", false);
        this.d = new com.baidu.tieba.model.k();
        this.d.a(this.k);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        n nVar = this.b;
        n.i();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onResume() {
        boolean z;
        boolean z2;
        boolean z3;
        super.onResume();
        if (d()) {
            this.b.h();
            if (this.d != null) {
                boolean booleanValue = this.g.booleanValue();
                this.g = Boolean.valueOf((TiebaApplication.v() == null || TiebaApplication.z() == null) ? false : true);
                if (this.f) {
                    this.f = false;
                    z = true;
                    z2 = false;
                } else if (booleanValue != this.g.booleanValue()) {
                    z = false;
                    z2 = true;
                } else {
                    z = false;
                    z2 = false;
                }
                if (TiebaApplication.g().F()) {
                    TiebaApplication.g().g(false);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (TiebaApplication.g().i() > 0) {
                    if (this.d != null && this.d.e() != null && this.d.e().e() != null) {
                        Iterator<com.baidu.tieba.data.ad> it = this.d.e().e().a().iterator();
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
                    TiebaApplication.g().h();
                    String v = TiebaApplication.v();
                    if (v != null && v.length() > 0) {
                        DatabaseService.c(v);
                    }
                    this.b.g();
                }
                if (z || z3) {
                    b();
                    if (z3) {
                        this.b.a();
                    } else {
                        this.d.b(this.g.booleanValue());
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            menu.findItem(2).setVisible(true);
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                com.baidu.tieba.mainentrance.d.a(this.h, 4);
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
                AboutActivity.a(this.h);
                break;
            case 5:
                UtilHelper.a((Activity) this.h);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onDestroy() {
        b();
        super.onDestroy();
    }

    public final void a() {
        this.b.j();
    }

    @Override // com.baidu.tieba.j, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == R.id.search_bg_layout) {
            com.baidu.tieba.k kVar = this.h;
            getString(R.string.home);
            SquareSearchActivity.a(kVar);
            return;
        }
        int id = view.getId();
        n nVar = this.b;
        if (id != n.l()) {
            int id2 = view.getId();
            n nVar2 = this.b;
            if (id2 != n.m()) {
                if (view.getId() == R.id.square_all_cat) {
                    cb.a(this.h, "enter_icon_category", "click", 1, new Object[0]);
                    BarFolderFirstDirActivity.a(this.h, "enter_icon_category");
                    return;
                }
                return;
            }
        }
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r1 == com.baidu.tieba.home.n.m()) goto L7;
     */
    @Override // com.baidu.tieba.j, android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onLongClick(View view) {
        int id = view.getId();
        n nVar = this.b;
        if (id != n.l()) {
            int id2 = view.getId();
            n nVar2 = this.b;
        }
        this.e = null;
        com.baidu.tieba.data.ad adVar = view.getTag() instanceof com.baidu.tieba.data.ad ? (com.baidu.tieba.data.ad) view.getTag() : null;
        if (adVar != null) {
            this.e = adVar;
            String b = adVar.b();
            int e = adVar.e();
            if (bs.b(b)) {
                if (e == 1) {
                    this.b.n();
                } else {
                    this.b.o();
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.j, android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tieba.j
    public final void c(int i) {
        super.c(i);
        this.b.a(i);
    }

    private void b() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
        this.d.cancelLoadData();
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar == null) {
        }
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.j, android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }
}
