package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class ba {
    private final BaseActivity a;
    private final LinearLayout b;
    private final NavigationBar c;
    private final NoNetworkView d;
    private final BdListView e;
    private final com.baidu.tbadk.core.view.u f;
    private final TextView g;
    private aw h;

    public ba(BaseActivity baseActivity) {
        this.a = baseActivity;
        baseActivity.setContentView(com.baidu.tieba.v.face_purchase_records_layout);
        this.b = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.purchase_record);
        this.c = (NavigationBar) this.b.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.c.a(baseActivity.getResources().getString(com.baidu.tieba.x.purchase_record));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (NoNetworkView) this.b.findViewById(com.baidu.tieba.u.view_no_network);
        this.g = (TextView) this.b.findViewById(com.baidu.tieba.u.empty);
        this.e = (BdListView) this.b.findViewById(com.baidu.tieba.u.purchase_record_list);
        this.f = new com.baidu.tbadk.core.view.u(baseActivity);
        this.e.setPullRefresh(this.f);
    }

    public void a(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.h == null) {
            this.h = new aw(this.a);
            this.e.setAdapter((ListAdapter) this.h);
        }
        this.h.a(facePurchaseRecordsData);
        if (facePurchaseRecordsData == null || facePurchaseRecordsData.packList == null || facePurchaseRecordsData.packList.size() == 0) {
            c();
        }
        b();
    }

    public aw a() {
        return this.h;
    }

    public void b() {
        this.e.d();
    }

    public void c() {
        if (this.e != null) {
            this.e.setEmptyView(this.g);
        }
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.e.setOnItemClickListener(onItemClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.f.a(dVar);
    }

    public void a(com.baidu.tbadk.core.view.q qVar) {
        this.d.a(qVar);
    }

    public void b(com.baidu.tbadk.core.view.q qVar) {
        this.d.b(qVar);
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.b);
        this.c.c(i);
        this.d.a(i);
        this.f.a(i);
    }
}
