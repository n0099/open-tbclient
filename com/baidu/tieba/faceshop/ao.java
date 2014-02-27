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
import com.baidu.tieba.view.by;
import com.baidu.tieba.view.cs;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class ao {
    private com.baidu.tieba.f b;
    private LinearLayout c;
    private NavigationBar d;
    private NoNetworkView e;
    private BdListView f;
    private cs g;
    private TextView h;
    private ak i;
    private Handler j;
    private com.baidu.tieba.util.i k;
    private Runnable l = new ap(this);
    AbsListView.OnScrollListener a = new aq(this);

    public ao(com.baidu.tieba.f fVar) {
        this.b = fVar;
        fVar.setContentView(R.layout.face_purchase_records_layout);
        this.c = (LinearLayout) fVar.findViewById(R.id.purchase_record);
        this.d = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.d.a(fVar.getResources().getString(R.string.purchase_record));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (NoNetworkView) this.c.findViewById(R.id.view_no_network);
        this.h = (TextView) this.c.findViewById(R.id.empty);
        this.f = (BdListView) this.c.findViewById(R.id.purchase_record_list);
        this.g = new cs(fVar);
        this.f.setPullRefresh(this.g);
        this.f.setOnScrollListener(this.a);
        this.j = new Handler();
    }

    public final void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.i == null) {
            this.i = new ak(this.b);
            this.f.setAdapter((ListAdapter) this.i);
        }
        this.k = this.i.a();
        this.i.a(facePurchaseRecordsData);
        if (facePurchaseRecordsData == null || facePurchaseRecordsData.packList == null || facePurchaseRecordsData.packList.size() == 0) {
            c();
        }
        if (this.j != null) {
            this.j.removeCallbacks(this.l);
            this.j.postDelayed(this.l, 300L);
        }
        this.f.a();
    }

    public final ak a() {
        return this.i;
    }

    public final void b() {
        this.f.a();
    }

    public final void c() {
        if (this.f != null) {
            this.f.setEmptyView(this.h);
        }
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f.setOnItemClickListener(onItemClickListener);
    }

    public final void a(com.baidu.adp.widget.ListView.b bVar) {
        this.g.a(bVar);
    }

    public final void d() {
        if (this.k != null) {
            this.k.a();
            this.k.c();
        }
    }

    public final void a(by byVar) {
        this.e.a(byVar);
    }

    public final void b(by byVar) {
        this.e.b(byVar);
    }

    public final void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.c);
        this.d.b(i);
        this.e.a(i);
        this.g.a(i);
    }
}
