package com.baidu.tieba.faceshop;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class bg {
    private final BaseActivity b;
    private final LinearLayout c;
    private final NavigationBar d;
    private final NoNetworkView e;
    private final BdListView f;
    private final com.baidu.tbadk.core.view.q g;
    private final TextView h;
    private bc i;
    private final Handler j;
    private com.baidu.tbadk.editortool.ab k;
    private final Runnable l = new bh(this);
    AbsListView.OnScrollListener a = new bi(this);

    public bg(BaseActivity baseActivity) {
        this.b = baseActivity;
        baseActivity.setContentView(com.baidu.tieba.w.face_purchase_records_layout);
        this.c = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.purchase_record);
        this.d = (NavigationBar) this.c.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.d.a(baseActivity.getResources().getString(com.baidu.tieba.y.purchase_record));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (NoNetworkView) this.c.findViewById(com.baidu.tieba.v.view_no_network);
        this.h = (TextView) this.c.findViewById(com.baidu.tieba.v.empty);
        this.f = (BdListView) this.c.findViewById(com.baidu.tieba.v.purchase_record_list);
        this.g = new com.baidu.tbadk.core.view.q(baseActivity);
        this.f.setPullRefresh(this.g);
        this.f.setOnScrollListener(this.a);
        this.j = new Handler();
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.i == null) {
            this.i = new bc(this.b);
            this.f.setAdapter((ListAdapter) this.i);
        }
        this.k = this.i.a();
        this.i.a(facePurchaseRecordsData);
        if (facePurchaseRecordsData == null || facePurchaseRecordsData.packList == null || facePurchaseRecordsData.packList.size() == 0) {
            c();
        }
        d();
        b();
    }

    public bc a() {
        return this.i;
    }

    public void b() {
        this.f.c();
    }

    public void c() {
        if (this.f != null) {
            this.f.setEmptyView(this.h);
        }
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f.setOnItemClickListener(onItemClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.g.a(dVar);
    }

    public void d() {
        if (this.j != null) {
            this.j.removeCallbacks(this.l);
            this.j.postDelayed(this.l, 90L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.baidu.tbadk.core.util.ae.a(this.f, this.i.a(), 0, -1);
    }

    private void g() {
        if (this.k != null) {
            this.k.a();
            this.k.d();
        }
    }

    public void e() {
        g();
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.e.a(mVar);
    }

    public void b(com.baidu.tbadk.core.view.m mVar) {
        this.e.b(mVar);
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a((View) this.c);
        this.d.c(i);
        this.e.a(i);
        this.g.a(i);
    }
}
