package com.baidu.tieba.faceshop;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.by;
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class be {
    private com.baidu.tieba.f b;
    private LinearLayout c;
    private NavigationBar d;
    private TextView e;
    private BdListView f;
    private aw g;
    private NoNetworkView h;
    private ct i;
    private bh j;
    private com.baidu.tieba.util.i k;
    private Handler l;
    private h n;
    private boolean m = false;
    private Runnable o = new bf(this);
    AbsListView.OnScrollListener a = new bg(this);

    public be(com.baidu.tieba.f fVar) {
        this.b = fVar;
        fVar.setContentView(R.layout.face_shop_activity);
        this.c = (LinearLayout) fVar.findViewById(R.id.face_shop);
        this.d = (NavigationBar) fVar.findViewById(R.id.view_navigation_bar);
        this.d.a(fVar.getResources().getString(R.string.face_store));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, fVar.getResources().getString(R.string.manage));
        this.h = (NoNetworkView) fVar.findViewById(R.id.view_no_network);
        this.f = (BdListView) fVar.findViewById(R.id.face_shop_list);
        this.i = new ct(fVar);
        this.g = new aw(fVar);
        this.j = new bh(this, fVar);
        this.f.setAdapter((ListAdapter) this.g);
        this.f.setPullRefresh(this.i);
        this.f.setNextPage(this.j);
        this.f.setOnScrollListener(this.a);
        this.l = new Handler();
        this.k = this.g.b();
        this.e.setOnClickListener(fVar);
        this.n = new h(fVar, R.style.common_alert_dialog);
    }

    public void a(FaceShopData faceShopData) {
        b();
        if (faceShopData != null && faceShopData.packList != null) {
            this.m = true;
            if (faceShopData.packList.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<FacePackageData> it = faceShopData.packList.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(it.next().pid));
                }
                a(arrayList);
            }
            g();
        }
    }

    public void a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.d.j(arrayList));
        }
    }

    public aw a() {
        return this.g;
    }

    public void b() {
        this.j.f();
        this.f.a();
    }

    public void c() {
        this.j.e();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f.setOnItemClickListener(onItemClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.i.a(bVar);
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.f.setOnSrollToBottomListener(rVar);
    }

    public void a(by byVar) {
        this.h.a(byVar);
    }

    public void b(by byVar) {
        this.h.b(byVar);
    }

    public void d() {
        if (this.j != null) {
            this.j.c();
        }
    }

    public void e() {
        if (this.j != null) {
            this.j.d();
        }
    }

    public void f() {
        if (this.h != null && this.h.getVisibility() == 0 && UtilHelper.b()) {
            this.h.setVisible(false);
        }
        g();
    }

    public void g() {
        if (this.l != null) {
            this.l.removeCallbacks(this.o);
            this.l.postDelayed(this.o, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.m) {
            com.baidu.tieba.util.ap.a(this.f, this.g.b(), 0, -1);
        }
    }

    public void h() {
        if (this.k != null) {
            this.k.a();
            this.k.d();
        }
    }

    public void i() {
        if (this.n != null) {
            this.n.a();
            this.n.show();
        }
    }

    public void j() {
        if (this.n != null) {
            this.n.b();
        }
    }

    public void k() {
        if (this.n != null) {
            this.n.dismiss();
        }
    }

    public void l() {
        h();
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a((View) this.c);
        if (this.d != null) {
            this.d.c(i);
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

    public TextView m() {
        return this.e;
    }
}
