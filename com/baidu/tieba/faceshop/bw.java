package com.baidu.tieba.faceshop;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.download.QueryDownloadMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class bw {
    private final com.baidu.tbadk.a b;
    private final LinearLayout c;
    private final NavigationBar d;
    private final TextView e;
    private final BdListView f;
    private final bo g;
    private final NoNetworkView h;
    private final com.baidu.tbadk.core.view.q i;
    private final bz j;
    private final com.baidu.tbadk.editortool.ab k;
    private final Handler l;
    private final x n;
    private boolean m = false;
    private final Runnable o = new bx(this);
    AbsListView.OnScrollListener a = new by(this);

    public bw(com.baidu.tbadk.a aVar) {
        this.b = aVar;
        aVar.setContentView(com.baidu.tieba.a.i.face_shop_activity);
        this.c = (LinearLayout) aVar.findViewById(com.baidu.tieba.a.h.face_shop);
        this.d = (NavigationBar) aVar.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.d.a(aVar.getResources().getString(com.baidu.tieba.a.k.face_store));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, aVar.getResources().getString(com.baidu.tieba.a.k.manage));
        this.h = (NoNetworkView) aVar.findViewById(com.baidu.tieba.a.h.view_no_network);
        this.f = (BdListView) aVar.findViewById(com.baidu.tieba.a.h.face_shop_list);
        this.i = new com.baidu.tbadk.core.view.q(aVar);
        this.g = new bo(aVar);
        this.j = new bz(this, aVar);
        this.f.setAdapter((ListAdapter) this.g);
        this.f.setPullRefresh(this.i);
        this.f.setNextPage(this.j);
        this.f.setOnScrollListener(this.a);
        this.l = new Handler();
        this.k = this.g.b();
        this.e.setOnClickListener(aVar);
        this.n = new x(aVar, com.baidu.tieba.a.l.common_alert_dialog);
    }

    public final void a(FaceShopData faceShopData) {
        b();
        if (faceShopData != null && faceShopData.packList != null) {
            this.m = true;
            if (faceShopData.packList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<FacePackageData> it = faceShopData.packList.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(it.next().pid));
                }
                a(arrayList);
            }
            m();
        }
    }

    public static void a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            com.baidu.adp.framework.c.a().b(new QueryDownloadMessage(arrayList));
        }
    }

    public final bo a() {
        return this.g;
    }

    public final void b() {
        this.j.f();
        this.f.b();
    }

    public final void c() {
        this.f.c();
    }

    public final void d() {
        this.j.e();
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f.setOnItemClickListener(onItemClickListener);
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.i.a(dVar);
    }

    public final void a(com.baidu.adp.widget.ListView.t tVar) {
        this.f.setOnSrollToBottomListener(tVar);
    }

    public final void a(com.baidu.tbadk.core.view.m mVar) {
        this.h.a(mVar);
    }

    public final void b(com.baidu.tbadk.core.view.m mVar) {
        this.h.b(mVar);
    }

    public final void e() {
        if (this.j != null) {
            this.j.c();
        }
    }

    public final void f() {
        if (this.j != null) {
            this.j.d();
        }
    }

    public final void g() {
        if (this.h != null && this.h.getVisibility() == 0 && UtilHelper.a()) {
            this.h.setVisible(false);
        }
        m();
    }

    private void m() {
        if (this.l != null) {
            this.l.removeCallbacks(this.o);
            this.l.postDelayed(this.o, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(bw bwVar) {
        if (bwVar.m) {
            com.baidu.tbadk.core.util.ac.a(bwVar.f, bwVar.g.b(), 0, -1);
        }
    }

    public final void h() {
        if (this.k != null) {
            this.k.a();
            this.k.c();
        }
    }

    public final void i() {
        if (this.n != null) {
            this.n.a();
            this.n.show();
        }
    }

    public final void j() {
        if (this.n != null) {
            this.n.b();
        }
    }

    public final void k() {
        if (this.n != null) {
            this.n.dismiss();
        }
    }

    public final void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.c);
        if (this.d != null) {
            this.d.b(i);
        }
        if (this.i != null) {
            this.i.a(i);
        }
        if (this.j != null) {
            this.j.a(i);
        }
        if (this.h != null) {
            this.h.a(i);
        }
    }

    public final TextView l() {
        return this.e;
    }
}
