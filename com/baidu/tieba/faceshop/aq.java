package com.baidu.tieba.faceshop;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.bw;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class aq {
    private com.baidu.tieba.j b;
    private LinearLayout c;
    private NavigationBar d;
    private NoNetworkView e;
    private BdListView f;
    private bw g;
    private TextView h;
    private ak i;
    private Handler j;
    private com.baidu.tieba.util.i k;
    private Runnable l = new ar(this);
    AbsListView.OnScrollListener a = new as(this);

    public aq(com.baidu.tieba.j jVar) {
        this.b = jVar;
        jVar.setContentView(R.layout.face_purchase_records_layout);
        this.c = (LinearLayout) jVar.findViewById(R.id.purchase_record);
        this.d = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.d.a(jVar.getResources().getString(R.string.purchase_record));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (NoNetworkView) this.c.findViewById(R.id.view_no_network);
        this.h = (TextView) this.c.findViewById(R.id.empty);
        this.f = (BdListView) this.c.findViewById(R.id.purchase_record_list);
        this.g = new bw(jVar);
        this.f.setPullRefresh(this.g);
        this.f.setOnScrollListener(this.a);
        this.j = new Handler();
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.i == null) {
            this.i = new ak(this.b);
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

    public ak a() {
        return this.i;
    }

    public void b() {
        this.f.a();
    }

    public void c() {
        if (this.f != null) {
            this.f.setEmptyView(this.h);
        }
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f.setOnItemClickListener(onItemClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.g.a(bVar);
    }

    public void d() {
        if (this.j != null) {
            this.j.removeCallbacks(this.l);
            this.j.postDelayed(this.l, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.baidu.tieba.util.ak.a(this.f, this.i.a(), 0, -1);
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

    public void a(com.baidu.tieba.view.bf bfVar) {
        this.e.a(bfVar);
    }

    public void b(com.baidu.tieba.view.bf bfVar) {
        this.e.b(bfVar);
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.c);
        this.d.c(i);
        this.e.a(i);
        this.g.a(i);
    }
}
