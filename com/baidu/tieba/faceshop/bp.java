package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.QueryDownloadMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class bp {
    private final BaseActivity a;
    private final LinearLayout b;
    private final NavigationBar c;
    private final TextView d;
    private final BdListView e;
    private final bh f;
    private final NoNetworkView g;
    private final com.baidu.tbadk.core.view.u h;
    private final bq i;
    private final v j;

    public bp(BaseActivity baseActivity) {
        this.a = baseActivity;
        baseActivity.setContentView(com.baidu.tieba.v.face_shop_activity);
        this.b = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.u.face_shop);
        this.c = (NavigationBar) baseActivity.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.c.a(baseActivity.getResources().getString(com.baidu.tieba.x.face_store));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(com.baidu.tieba.x.manage));
        this.g = (NoNetworkView) baseActivity.findViewById(com.baidu.tieba.u.view_no_network);
        this.e = (BdListView) baseActivity.findViewById(com.baidu.tieba.u.face_shop_list);
        this.h = new com.baidu.tbadk.core.view.u(baseActivity);
        this.f = new bh(baseActivity);
        this.i = new bq(this, baseActivity);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setPullRefresh(this.h);
        this.e.setNextPage(this.i);
        this.d.setOnClickListener(baseActivity);
        this.j = new v(baseActivity, com.baidu.tieba.y.common_alert_dialog);
    }

    public void a(FaceShopData faceShopData) {
        b();
        if (faceShopData != null && faceShopData.packList != null && faceShopData.packList.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<FacePackageData> it = faceShopData.packList.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().pid));
            }
            a(arrayList);
        }
    }

    public void a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
        }
    }

    public bh a() {
        return this.f;
    }

    public void b() {
        this.i.f();
        this.e.d();
    }

    public void c() {
        this.e.e();
    }

    public void d() {
        this.i.e();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.e.setOnItemClickListener(onItemClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.h.a(dVar);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.e.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.tbadk.core.view.q qVar) {
        this.g.a(qVar);
    }

    public void b(com.baidu.tbadk.core.view.q qVar) {
        this.g.b(qVar);
    }

    public void e() {
        if (this.i != null) {
            this.i.c();
        }
    }

    public void f() {
        if (this.i != null) {
            this.i.d();
        }
    }

    public void g() {
        if (this.g != null && this.g.getVisibility() == 0 && UtilHelper.isNetOk()) {
            this.g.a(false);
        }
    }

    public void h() {
        if (this.j != null) {
            this.j.a();
            com.baidu.adp.lib.e.d.a(this.j, this.a);
        }
    }

    public void i() {
        if (this.j != null) {
            this.j.b();
        }
    }

    public void j() {
        if (this.j != null) {
            com.baidu.adp.lib.e.d.b(this.j, this.a);
        }
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.b);
        if (this.c != null) {
            this.c.c(i);
        }
        if (this.h != null) {
            this.h.a(i);
        }
        if (this.i != null) {
            this.i.a(i);
        }
        if (this.g != null) {
            this.g.a(i);
        }
    }

    public TextView k() {
        return this.d;
    }
}
