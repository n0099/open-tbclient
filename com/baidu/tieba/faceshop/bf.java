package com.baidu.tieba.faceshop;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public final class bf {
    private final com.baidu.tbadk.a b;
    private final LinearLayout c;
    private final NavigationBar d;
    private final NoNetworkView e;
    private final BdListView f;
    private final com.baidu.tbadk.core.view.q g;
    private final TextView h;
    private bb i;
    private final Handler j;
    private com.baidu.tbadk.editortool.ab k;
    private final Runnable l = new bg(this);
    AbsListView.OnScrollListener a = new bh(this);

    public bf(com.baidu.tbadk.a aVar) {
        this.b = aVar;
        aVar.setContentView(com.baidu.tieba.a.i.face_purchase_records_layout);
        this.c = (LinearLayout) aVar.findViewById(com.baidu.tieba.a.h.purchase_record);
        this.d = (NavigationBar) this.c.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.d.a(aVar.getResources().getString(com.baidu.tieba.a.k.purchase_record));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (NoNetworkView) this.c.findViewById(com.baidu.tieba.a.h.view_no_network);
        this.h = (TextView) this.c.findViewById(com.baidu.tieba.a.h.empty);
        this.f = (BdListView) this.c.findViewById(com.baidu.tieba.a.h.purchase_record_list);
        this.g = new com.baidu.tbadk.core.view.q(aVar);
        this.f.setPullRefresh(this.g);
        this.f.setOnScrollListener(this.a);
        this.j = new Handler();
    }

    public final void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.i == null) {
            this.i = new bb(this.b);
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
        this.f.b();
    }

    public final bb a() {
        return this.i;
    }

    public final void b() {
        this.f.b();
    }

    public final void c() {
        if (this.f != null) {
            this.f.setEmptyView(this.h);
        }
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f.setOnItemClickListener(onItemClickListener);
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.g.a(dVar);
    }

    public final void d() {
        if (this.k != null) {
            this.k.a();
            this.k.c();
        }
    }

    public final void a(com.baidu.tbadk.core.view.m mVar) {
        this.e.a(mVar);
    }

    public final void b(com.baidu.tbadk.core.view.m mVar) {
        this.e.b(mVar);
    }

    public final void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.c);
        this.d.b(i);
        this.e.a(i);
        this.g.a(i);
    }
}
