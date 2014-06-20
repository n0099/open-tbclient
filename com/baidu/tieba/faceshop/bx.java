package com.baidu.tieba.faceshop;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
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
public class bx {
    private final BaseActivity b;
    private final LinearLayout c;
    private final NavigationBar d;
    private final TextView e;
    private final BdListView f;
    private final bp g;
    private final NoNetworkView h;
    private final com.baidu.tbadk.core.view.q i;
    private final ca j;
    private final com.baidu.tbadk.editortool.ab k;
    private final Handler l;
    private final y n;
    private boolean m = false;
    private final Runnable o = new by(this);
    AbsListView.OnScrollListener a = new bz(this);

    public bx(BaseActivity baseActivity) {
        this.b = baseActivity;
        baseActivity.setContentView(com.baidu.tieba.w.face_shop_activity);
        this.c = (LinearLayout) baseActivity.findViewById(com.baidu.tieba.v.face_shop);
        this.d = (NavigationBar) baseActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.d.a(baseActivity.getResources().getString(com.baidu.tieba.y.face_store));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(com.baidu.tieba.y.manage));
        this.h = (NoNetworkView) baseActivity.findViewById(com.baidu.tieba.v.view_no_network);
        this.f = (BdListView) baseActivity.findViewById(com.baidu.tieba.v.face_shop_list);
        this.i = new com.baidu.tbadk.core.view.q(baseActivity);
        this.g = new bp(baseActivity);
        this.j = new ca(this, baseActivity);
        this.f.setAdapter((ListAdapter) this.g);
        this.f.setPullRefresh(this.i);
        this.f.setNextPage(this.j);
        this.f.setOnScrollListener(this.a);
        this.l = new Handler();
        this.k = this.g.b();
        this.e.setOnClickListener(baseActivity);
        this.n = new y(baseActivity, com.baidu.tieba.z.common_alert_dialog);
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
            h();
        }
    }

    public void a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
        }
    }

    public bp a() {
        return this.g;
    }

    public void b() {
        this.j.f();
        this.f.c();
    }

    public void c() {
        this.f.d();
    }

    public void d() {
        this.j.e();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f.setOnItemClickListener(onItemClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.i.a(dVar);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.f.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.h.a(mVar);
    }

    public void b(com.baidu.tbadk.core.view.m mVar) {
        this.h.b(mVar);
    }

    public void e() {
        if (this.j != null) {
            this.j.c();
        }
    }

    public void f() {
        if (this.j != null) {
            this.j.d();
        }
    }

    public void g() {
        if (this.h != null && this.h.getVisibility() == 0 && UtilHelper.isNetOk()) {
            this.h.setVisible(false);
        }
        h();
    }

    public void h() {
        if (this.l != null) {
            this.l.removeCallbacks(this.o);
            this.l.postDelayed(this.o, 90L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.m) {
            com.baidu.tbadk.core.util.ag.a(this.f, this.g.b(), 0, -1);
        }
    }

    public void i() {
        if (this.k != null) {
            this.k.a();
            this.k.d();
        }
    }

    public void j() {
        if (this.n != null) {
            this.n.a();
            this.n.show();
        }
    }

    public void k() {
        if (this.n != null) {
            this.n.b();
        }
    }

    public void l() {
        if (this.n != null) {
            this.n.dismiss();
        }
    }

    public void m() {
        i();
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

    public TextView n() {
        return this.e;
    }
}
